// $ANTLR 3.1.1 parser/TCS.g 2010-03-19 10:59:47

package com.sap.mi.textual.grammar.parser;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.PredicateSemantic;
import com.sap.mi.textual.grammar.impl.SemanticDisambRuleData;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "DLCOLON", "LPAREN", "RPAREN", "EQ", "LCURLY", "RCURLY", "SEMI", "RARROW", "COLON", "COMA", "SHARP", "LT", "GT", "LSQUARE", "RSQUARE", "QMARK", "DLSQUARE", "PIPE", "DRSQUARE", "STAR", "DOLLAR", "DLCURLY", "DRCURLY", "LARROW", "POINT", "MINUS", "COMMENT", "MULTI_LINE_COMMENT", "EXCL", "AROBAS", "SLASH", "PLUS", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'partial'", "'addToContext'", "'omitted'", "'priority'", "'source'", "'disambiguate'", "'esc'", "'keywords'", "'token'", "'syntax'", "'endOfLine'", "'deep'", "'start'", "'as'", "'enumerationTemplate'", "'nonPrimary'", "'symbols'", "'function'", "'indentIncr'", "'serializer'", "'default'", "'createAs'", "'operators'", "'primitiveTemplate'", "'forcedLower'", "'operatored'", "'right'", "'instanceOf'", "'when'", "'all'", "'rightNone'", "'hex'", "'abstract'", "'orKeyword'", "'true'", "'for'", "'word'", "'invert'", "'leftNone'", "'query'", "'drop'", "'operatorTemplate'", "'value'", "'and'", "'autoCreate'", "'foreach'", "'forcedUpper'", "'semDisambiguate'", "'left'", "'auto'", "'startNbNL'", "'lookIn'", "'multi'", "'one'", "'multiLine'", "'leftSpace'", "'k'", "'rightSpace'", "'storeRightTo'", "'octal'", "'end'", "'endNL'", "'startNL'", "'mode'", "'prefix'", "'createIn'", "'ifmissing'", "'separator'", "'context'", "'isDefined'", "'false'", "'importContext'", "'refersTo'", "'never'", "'lexer'", "'postfix'", "'always'", "'template'", "'main'", "'nbNL'", "'filter'", "'storeOpTo'", "'part'", "'referenceOnly'", "'disambiguateV3'", "'using'"
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


       private static final String syntaxUUID = "E0DCF6CDFFDEFE33333D11DFC5D4DD40A9FE17A4";
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
    // parser/TCS.g:208:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:209:3: ( (ast= NAME ) )
            // parser/TCS.g:210:3: (ast= NAME )
            {
            // parser/TCS.g:210:3: (ast= NAME )
            // parser/TCS.g:210:4: ast= NAME
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
    // parser/TCS.g:218:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'partial' | 'addToContext' | 'omitted' | 'priority' | 'source' | 'disambiguate' | 'esc' | 'keywords' | 'token' | 'syntax' | 'endOfLine' | 'deep' | 'start' | 'as' | 'enumerationTemplate' | 'nonPrimary' | 'symbols' | 'function' | 'indentIncr' | 'serializer' | 'default' | 'createAs' | 'operators' | 'primitiveTemplate' | 'forcedLower' | 'operatored' | 'right' | 'instanceOf' | 'when' | 'all' | 'rightNone' | 'hex' | 'abstract' | 'orKeyword' | 'true' | 'for' | 'word' | 'invert' | 'leftNone' | 'query' | 'drop' | 'operatorTemplate' | 'value' | 'and' | 'autoCreate' | 'foreach' | 'forcedUpper' | 'semDisambiguate' | 'left' | 'auto' | 'startNbNL' | 'lookIn' | 'multi' | 'one' | 'multiLine' | 'leftSpace' | 'k' | 'rightSpace' | 'storeRightTo' | 'octal' | 'end' | 'endNL' | 'startNL' | 'mode' | 'prefix' | 'createIn' | 'ifmissing' | 'separator' | 'context' | 'isDefined' | 'false' | 'importContext' | 'refersTo' | 'never' | 'lexer' | 'postfix' | 'always' | 'template' | 'main' | 'nbNL' | 'filter' | 'storeOpTo' | 'part' | 'referenceOnly' | 'disambiguateV3' | 'using' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:219:3: ( (ast= NAME | 'partial' | 'addToContext' | 'omitted' | 'priority' | 'source' | 'disambiguate' | 'esc' | 'keywords' | 'token' | 'syntax' | 'endOfLine' | 'deep' | 'start' | 'as' | 'enumerationTemplate' | 'nonPrimary' | 'symbols' | 'function' | 'indentIncr' | 'serializer' | 'default' | 'createAs' | 'operators' | 'primitiveTemplate' | 'forcedLower' | 'operatored' | 'right' | 'instanceOf' | 'when' | 'all' | 'rightNone' | 'hex' | 'abstract' | 'orKeyword' | 'true' | 'for' | 'word' | 'invert' | 'leftNone' | 'query' | 'drop' | 'operatorTemplate' | 'value' | 'and' | 'autoCreate' | 'foreach' | 'forcedUpper' | 'semDisambiguate' | 'left' | 'auto' | 'startNbNL' | 'lookIn' | 'multi' | 'one' | 'multiLine' | 'leftSpace' | 'k' | 'rightSpace' | 'storeRightTo' | 'octal' | 'end' | 'endNL' | 'startNL' | 'mode' | 'prefix' | 'createIn' | 'ifmissing' | 'separator' | 'context' | 'isDefined' | 'false' | 'importContext' | 'refersTo' | 'never' | 'lexer' | 'postfix' | 'always' | 'template' | 'main' | 'nbNL' | 'filter' | 'storeOpTo' | 'part' | 'referenceOnly' | 'disambiguateV3' | 'using' ) )
            // parser/TCS.g:220:3: (ast= NAME | 'partial' | 'addToContext' | 'omitted' | 'priority' | 'source' | 'disambiguate' | 'esc' | 'keywords' | 'token' | 'syntax' | 'endOfLine' | 'deep' | 'start' | 'as' | 'enumerationTemplate' | 'nonPrimary' | 'symbols' | 'function' | 'indentIncr' | 'serializer' | 'default' | 'createAs' | 'operators' | 'primitiveTemplate' | 'forcedLower' | 'operatored' | 'right' | 'instanceOf' | 'when' | 'all' | 'rightNone' | 'hex' | 'abstract' | 'orKeyword' | 'true' | 'for' | 'word' | 'invert' | 'leftNone' | 'query' | 'drop' | 'operatorTemplate' | 'value' | 'and' | 'autoCreate' | 'foreach' | 'forcedUpper' | 'semDisambiguate' | 'left' | 'auto' | 'startNbNL' | 'lookIn' | 'multi' | 'one' | 'multiLine' | 'leftSpace' | 'k' | 'rightSpace' | 'storeRightTo' | 'octal' | 'end' | 'endNL' | 'startNL' | 'mode' | 'prefix' | 'createIn' | 'ifmissing' | 'separator' | 'context' | 'isDefined' | 'false' | 'importContext' | 'refersTo' | 'never' | 'lexer' | 'postfix' | 'always' | 'template' | 'main' | 'nbNL' | 'filter' | 'storeOpTo' | 'part' | 'referenceOnly' | 'disambiguateV3' | 'using' )
            {
            // parser/TCS.g:220:3: (ast= NAME | 'partial' | 'addToContext' | 'omitted' | 'priority' | 'source' | 'disambiguate' | 'esc' | 'keywords' | 'token' | 'syntax' | 'endOfLine' | 'deep' | 'start' | 'as' | 'enumerationTemplate' | 'nonPrimary' | 'symbols' | 'function' | 'indentIncr' | 'serializer' | 'default' | 'createAs' | 'operators' | 'primitiveTemplate' | 'forcedLower' | 'operatored' | 'right' | 'instanceOf' | 'when' | 'all' | 'rightNone' | 'hex' | 'abstract' | 'orKeyword' | 'true' | 'for' | 'word' | 'invert' | 'leftNone' | 'query' | 'drop' | 'operatorTemplate' | 'value' | 'and' | 'autoCreate' | 'foreach' | 'forcedUpper' | 'semDisambiguate' | 'left' | 'auto' | 'startNbNL' | 'lookIn' | 'multi' | 'one' | 'multiLine' | 'leftSpace' | 'k' | 'rightSpace' | 'storeRightTo' | 'octal' | 'end' | 'endNL' | 'startNL' | 'mode' | 'prefix' | 'createIn' | 'ifmissing' | 'separator' | 'context' | 'isDefined' | 'false' | 'importContext' | 'refersTo' | 'never' | 'lexer' | 'postfix' | 'always' | 'template' | 'main' | 'nbNL' | 'filter' | 'storeOpTo' | 'part' | 'referenceOnly' | 'disambiguateV3' | 'using' )
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
                    // parser/TCS.g:220:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:222:5: 'partial'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "partial";
                    }

                    }
                    break;
                case 3 :
                    // parser/TCS.g:223:5: 'addToContext'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
                    }

                    }
                    break;
                case 4 :
                    // parser/TCS.g:224:5: 'omitted'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "omitted";
                    }

                    }
                    break;
                case 5 :
                    // parser/TCS.g:225:5: 'priority'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 6 :
                    // parser/TCS.g:226:5: 'source'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 7 :
                    // parser/TCS.g:227:5: 'disambiguate'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 8 :
                    // parser/TCS.g:228:5: 'esc'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 9 :
                    // parser/TCS.g:229:5: 'keywords'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
                    }

                    }
                    break;
                case 10 :
                    // parser/TCS.g:230:5: 'token'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 11 :
                    // parser/TCS.g:231:5: 'syntax'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 12 :
                    // parser/TCS.g:232:5: 'endOfLine'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 13 :
                    // parser/TCS.g:233:5: 'deep'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 14 :
                    // parser/TCS.g:234:5: 'start'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 15 :
                    // parser/TCS.g:235:5: 'as'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 16 :
                    // parser/TCS.g:236:5: 'enumerationTemplate'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 17 :
                    // parser/TCS.g:237:5: 'nonPrimary'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 18 :
                    // parser/TCS.g:238:5: 'symbols'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 19 :
                    // parser/TCS.g:239:5: 'function'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 20 :
                    // parser/TCS.g:240:5: 'indentIncr'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 21 :
                    // parser/TCS.g:241:5: 'serializer'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
                    }

                    }
                    break;
                case 22 :
                    // parser/TCS.g:242:5: 'default'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 23 :
                    // parser/TCS.g:243:5: 'createAs'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 24 :
                    // parser/TCS.g:244:5: 'operators'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 25 :
                    // parser/TCS.g:245:5: 'primitiveTemplate'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 26 :
                    // parser/TCS.g:246:5: 'forcedLower'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 27 :
                    // parser/TCS.g:247:5: 'operatored'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
                    }

                    }
                    break;
                case 28 :
                    // parser/TCS.g:248:5: 'right'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 29 :
                    // parser/TCS.g:249:5: 'instanceOf'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "instanceOf";
                    }

                    }
                    break;
                case 30 :
                    // parser/TCS.g:250:5: 'when'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "when";
                    }

                    }
                    break;
                case 31 :
                    // parser/TCS.g:251:5: 'all'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword340); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 32 :
                    // parser/TCS.g:252:5: 'rightNone'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword348); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 33 :
                    // parser/TCS.g:253:5: 'hex'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword356); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 34 :
                    // parser/TCS.g:254:5: 'abstract'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword364); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 35 :
                    // parser/TCS.g:255:5: 'orKeyword'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword372); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 36 :
                    // parser/TCS.g:256:5: 'true'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 37 :
                    // parser/TCS.g:257:5: 'for'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 38 :
                    // parser/TCS.g:258:5: 'word'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 39 :
                    // parser/TCS.g:259:5: 'invert'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword404); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "invert";
                    }

                    }
                    break;
                case 40 :
                    // parser/TCS.g:260:5: 'leftNone'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 41 :
                    // parser/TCS.g:261:5: 'query'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword420); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "query";
                    }

                    }
                    break;
                case 42 :
                    // parser/TCS.g:262:5: 'drop'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword428); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 43 :
                    // parser/TCS.g:263:5: 'operatorTemplate'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword436); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 44 :
                    // parser/TCS.g:264:5: 'value'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 45 :
                    // parser/TCS.g:265:5: 'and'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 46 :
                    // parser/TCS.g:266:5: 'autoCreate'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 47 :
                    // parser/TCS.g:267:5: 'foreach'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 48 :
                    // parser/TCS.g:268:5: 'forcedUpper'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword476); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedUpper";
                    }

                    }
                    break;
                case 49 :
                    // parser/TCS.g:269:5: 'semDisambiguate'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "semDisambiguate";
                    }

                    }
                    break;
                case 50 :
                    // parser/TCS.g:270:5: 'left'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 51 :
                    // parser/TCS.g:271:5: 'auto'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword500); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 52 :
                    // parser/TCS.g:272:5: 'startNbNL'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword508); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 53 :
                    // parser/TCS.g:273:5: 'lookIn'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword516); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 54 :
                    // parser/TCS.g:274:5: 'multi'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword524); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 55 :
                    // parser/TCS.g:275:5: 'one'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 56 :
                    // parser/TCS.g:276:5: 'multiLine'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword540); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 57 :
                    // parser/TCS.g:277:5: 'leftSpace'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
                    }

                    }
                    break;
                case 58 :
                    // parser/TCS.g:278:5: 'k'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 59 :
                    // parser/TCS.g:279:5: 'rightSpace'
                    {
                    match(input,106,FOLLOW_106_in_identifierOrKeyword564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 60 :
                    // parser/TCS.g:280:5: 'storeRightTo'
                    {
                    match(input,107,FOLLOW_107_in_identifierOrKeyword572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 61 :
                    // parser/TCS.g:281:5: 'octal'
                    {
                    match(input,108,FOLLOW_108_in_identifierOrKeyword580); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 62 :
                    // parser/TCS.g:282:5: 'end'
                    {
                    match(input,109,FOLLOW_109_in_identifierOrKeyword588); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 63 :
                    // parser/TCS.g:283:5: 'endNL'
                    {
                    match(input,110,FOLLOW_110_in_identifierOrKeyword596); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 64 :
                    // parser/TCS.g:284:5: 'startNL'
                    {
                    match(input,111,FOLLOW_111_in_identifierOrKeyword604); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 65 :
                    // parser/TCS.g:285:5: 'mode'
                    {
                    match(input,112,FOLLOW_112_in_identifierOrKeyword612); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 66 :
                    // parser/TCS.g:286:5: 'prefix'
                    {
                    match(input,113,FOLLOW_113_in_identifierOrKeyword620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 67 :
                    // parser/TCS.g:287:5: 'createIn'
                    {
                    match(input,114,FOLLOW_114_in_identifierOrKeyword628); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 68 :
                    // parser/TCS.g:288:5: 'ifmissing'
                    {
                    match(input,115,FOLLOW_115_in_identifierOrKeyword636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 69 :
                    // parser/TCS.g:289:5: 'separator'
                    {
                    match(input,116,FOLLOW_116_in_identifierOrKeyword644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 70 :
                    // parser/TCS.g:290:5: 'context'
                    {
                    match(input,117,FOLLOW_117_in_identifierOrKeyword652); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 71 :
                    // parser/TCS.g:291:5: 'isDefined'
                    {
                    match(input,118,FOLLOW_118_in_identifierOrKeyword660); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 72 :
                    // parser/TCS.g:292:5: 'false'
                    {
                    match(input,119,FOLLOW_119_in_identifierOrKeyword668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 73 :
                    // parser/TCS.g:293:5: 'importContext'
                    {
                    match(input,120,FOLLOW_120_in_identifierOrKeyword676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 74 :
                    // parser/TCS.g:294:5: 'refersTo'
                    {
                    match(input,121,FOLLOW_121_in_identifierOrKeyword684); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 75 :
                    // parser/TCS.g:295:5: 'never'
                    {
                    match(input,122,FOLLOW_122_in_identifierOrKeyword692); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 76 :
                    // parser/TCS.g:296:5: 'lexer'
                    {
                    match(input,123,FOLLOW_123_in_identifierOrKeyword700); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 77 :
                    // parser/TCS.g:297:5: 'postfix'
                    {
                    match(input,124,FOLLOW_124_in_identifierOrKeyword708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 78 :
                    // parser/TCS.g:298:5: 'always'
                    {
                    match(input,125,FOLLOW_125_in_identifierOrKeyword716); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 79 :
                    // parser/TCS.g:299:5: 'template'
                    {
                    match(input,126,FOLLOW_126_in_identifierOrKeyword724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 80 :
                    // parser/TCS.g:300:5: 'main'
                    {
                    match(input,127,FOLLOW_127_in_identifierOrKeyword732); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 81 :
                    // parser/TCS.g:301:5: 'nbNL'
                    {
                    match(input,128,FOLLOW_128_in_identifierOrKeyword740); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 82 :
                    // parser/TCS.g:302:5: 'filter'
                    {
                    match(input,129,FOLLOW_129_in_identifierOrKeyword748); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "filter";
                    }

                    }
                    break;
                case 83 :
                    // parser/TCS.g:303:5: 'storeOpTo'
                    {
                    match(input,130,FOLLOW_130_in_identifierOrKeyword756); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 84 :
                    // parser/TCS.g:304:5: 'part'
                    {
                    match(input,131,FOLLOW_131_in_identifierOrKeyword764); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 85 :
                    // parser/TCS.g:305:5: 'referenceOnly'
                    {
                    match(input,132,FOLLOW_132_in_identifierOrKeyword772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceOnly";
                    }

                    }
                    break;
                case 86 :
                    // parser/TCS.g:306:5: 'disambiguateV3'
                    {
                    match(input,133,FOLLOW_133_in_identifierOrKeyword780); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 87 :
                    // parser/TCS.g:307:5: 'using'
                    {
                    match(input,134,FOLLOW_134_in_identifierOrKeyword788); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
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
    // parser/TCS.g:314:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:315:3: ( (ast= STRING ) )
            // parser/TCS.g:316:3: (ast= STRING )
            {
            // parser/TCS.g:316:3: (ast= STRING )
            // parser/TCS.g:316:4: ast= STRING
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
    // parser/TCS.g:324:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:325:3: ( (ast= INT ) )
            // parser/TCS.g:326:3: (ast= INT )
            {
            // parser/TCS.g:326:3: (ast= INT )
            // parser/TCS.g:326:4: ast= INT
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
    // parser/TCS.g:334:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {

        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:335:3: ( (ast= FLOAT ) )
            // parser/TCS.g:336:3: (ast= FLOAT )
            {
            // parser/TCS.g:336:3: (ast= FLOAT )
            // parser/TCS.g:336:4: ast= FLOAT
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
    // parser/TCS.g:344:1: model_classifier returns [Object ret2] : ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object model_classifier() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","Classifier");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:349:3: ( ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) ) )
            // parser/TCS.g:350:3: ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) )
            {
            // parser/TCS.g:350:3: ( ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) ) )
            // parser/TCS.g:350:4: ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEC88523333D11DF972CDD40A9FE17A4");
            }
            // parser/TCS.g:350:64: ( ( (temp= model_namespace ) DLCOLON (temp= identifier ) ) | ( (temp= identifier ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==DLCOLON) ) {
                    alt2=1;
                }
                else if ( (LA2_1==EOF||(LA2_1>=LPAREN && LA2_1<=RPAREN)||LA2_1==SEMI||LA2_1==COLON||LA2_1==SHARP||LA2_1==50||LA2_1==60||LA2_1==64||LA2_1==69||LA2_1==74||LA2_1==81||LA2_1==98||LA2_1==101||LA2_1==113||LA2_1==117||LA2_1==127||LA2_1==132||LA2_1==134) ) {
                    alt2=2;
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
                    // parser/TCS.g:350:65: ( (temp= model_namespace ) DLCOLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:350:81: ( (temp= model_namespace ) DLCOLON (temp= identifier ) )
                    // parser/TCS.g:350:82: (temp= model_namespace ) DLCOLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEBC9E40333D11DFB259DD40A9FE17A4");
                    }
                    // parser/TCS.g:350:141: (temp= model_namespace )
                    // parser/TCS.g:350:143: temp= model_namespace
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
                      _beforeSeqEl("E0DCF6CDFEC15930333D11DF8009DD40A9FE17A4");
                    }
                    match(input,DLCOLON,FOLLOW_DLCOLON_in_model_classifier928); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEC15932333D11DFC931DD40A9FE17A4");
                    }
                    // parser/TCS.g:350:362: (temp= identifier )
                    // parser/TCS.g:350:364: temp= identifier
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
                    // parser/TCS.g:350:448: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:350:464: ( (temp= identifier ) )
                    // parser/TCS.g:350:465: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEC88521333D11DFCE84DD40A9FE17A4");
                    }
                    // parser/TCS.g:350:524: (temp= identifier )
                    // parser/TCS.g:350:526: temp= identifier
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
    // parser/TCS.g:359:1: primary_model_namespace returns [Object ret2] : (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) ) ;
    public final Object primary_model_namespace() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:360:3: ( (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) ) )
            // parser/TCS.g:361:3: (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) )
            {
            // parser/TCS.g:361:3: (ret= model_generalizableelement | ( LPAREN ret= model_namespace RPAREN ) )
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
                    // parser/TCS.g:361:4: ret= model_generalizableelement
                    {
                    pushFollow(FOLLOW_model_generalizableelement_in_primary_model_namespace1001);
                    ret=model_generalizableelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:362:5: ( LPAREN ret= model_namespace RPAREN )
                    {
                    // parser/TCS.g:362:5: ( LPAREN ret= model_namespace RPAREN )
                    // parser/TCS.g:362:6: LPAREN ret= model_namespace RPAREN
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
    // parser/TCS.g:369:1: dblcolon_priority_0 returns [Object ret2] : ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object dblcolon_priority_0() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // parser/TCS.g:370:3: ( ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) ) )
            // parser/TCS.g:371:4: ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) )
            {
            // parser/TCS.g:371:4: ( (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* ) )
            // parser/TCS.g:371:6: (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* )
            {
            // parser/TCS.g:371:6: (ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )* )
            // parser/TCS.g:371:8: ret= primary_model_namespace ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_model_namespace_in_dblcolon_priority_01058);
            ret=primary_model_namespace();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // parser/TCS.g:371:35: ( ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DLCOLON) ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1==NAME) ) {
                        int LA4_3 = input.LA(3);

                        if ( (LA4_3==RPAREN) ) {
                            int LA4_4 = input.LA(4);

                            if ( (LA4_4==DLCOLON) && (synpred89_TCS())) {
                                alt4=1;
                            }
                            else if ( (LA4_4==RPAREN) && (synpred89_TCS())) {
                                alt4=1;
                            }


                        }
                        else if ( (LA4_3==DLCOLON) && (synpred89_TCS())) {
                            alt4=1;
                        }


                    }


                }


                switch (alt4) {
            	case 1 :
            	    // parser/TCS.g:371:36: ( DLCOLON )=> ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) )
            	    {
            	    // parser/TCS.g:371:47: ( DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) ) )
            	    // parser/TCS.g:371:48: DLCOLON ( (ret= model_modelelement[opName, ret, firstToken] ) )
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
            	    // parser/TCS.g:371:135: ( (ret= model_modelelement[opName, ret, firstToken] ) )
            	    // parser/TCS.g:371:136: (ret= model_modelelement[opName, ret, firstToken] )
            	    {
            	    // parser/TCS.g:371:136: (ret= model_modelelement[opName, ret, firstToken] )
            	    // parser/TCS.g:371:137: ret= model_modelelement[opName, ret, firstToken]
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
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "dblcolon_priority_0"


    // $ANTLR start "model_namespace"
    // parser/TCS.g:379:1: model_namespace returns [Object ret2] : ret= dblcolon_priority_0 ;
    public final Object model_namespace() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:380:3: (ret= dblcolon_priority_0 )
            // parser/TCS.g:381:3: ret= dblcolon_priority_0
            {
            pushFollow(FOLLOW_dblcolon_priority_0_in_model_namespace1112);
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
    // parser/TCS.g:388:1: model_generalizableelement returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object model_generalizableelement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","GeneralizableElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:393:3: ( ( (temp= identifier ) ) )
            // parser/TCS.g:394:3: ( (temp= identifier ) )
            {
            // parser/TCS.g:394:3: ( (temp= identifier ) )
            // parser/TCS.g:394:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFED6B5F1333D11DF81F0DD40A9FE17A4");
            }
            // parser/TCS.g:394:63: (temp= identifier )
            // parser/TCS.g:394:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_generalizableelement1145);
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
    // parser/TCS.g:402:1: model_modelelement[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object model_modelelement(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Model","ModelElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ?  createReferenceProxy(metaType) : null;


        try {
            // parser/TCS.g:407:3: ( ( (temp= identifier ) ) )
            // parser/TCS.g:408:3: ( (temp= identifier ) )
            {
            // parser/TCS.g:408:3: ( (temp= identifier ) )
            // parser/TCS.g:408:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFED926F2333D11DFAA72DD40A9FE17A4");
            }
            // parser/TCS.g:408:63: (temp= identifier )
            // parser/TCS.g:408:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_model_modelelement1193);
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
    // parser/TCS.g:418:1: textblockdefinition_textblockdefinition returns [Object ret2] : () ;
    public final Object textblockdefinition_textblockdefinition() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("textblockdefinition","TextBlockDefinition");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:423:3: ( () )
            // parser/TCS.g:424:3: ()
            {
            // parser/TCS.g:424:3: ()
            // parser/TCS.g:424:4: 
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
    // parser/TCS.g:432:1: main returns [Object ret2] : ( (ret= tcs_concretesyntax ) EOF ) ;
    public final Object main() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:433:3: ( ( (ret= tcs_concretesyntax ) EOF ) )
            // parser/TCS.g:434:3: ( (ret= tcs_concretesyntax ) EOF )
            {
            // parser/TCS.g:434:3: ( (ret= tcs_concretesyntax ) EOF )
            // parser/TCS.g:434:4: (ret= tcs_concretesyntax ) EOF
            {
            // parser/TCS.g:434:4: (ret= tcs_concretesyntax )
            // parser/TCS.g:434:5: ret= tcs_concretesyntax
            {
            pushFollow(FOLLOW_tcs_concretesyntax_in_main1263);
            ret=tcs_concretesyntax();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main1266); if (state.failed) return ret2;

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
    // parser/TCS.g:441:1: tcs_concretesyntax returns [Object ret2] : ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) ;
    public final Object tcs_concretesyntax() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConcreteSyntax");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:446:3: ( ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) )
            // parser/TCS.g:447:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            {
            // parser/TCS.g:447:3: ( 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            // parser/TCS.g:447:4: 'syntax' (temp= identifier )? ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEE29CD0333D11DF9C5DDD40A9FE17A4");
            }
            match(input,58,FOLLOW_58_in_tcs_concretesyntax1297); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEE29CD2333D11DFB33FDD40A9FE17A4");
            }
            // parser/TCS.g:447:146: (temp= identifier )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // parser/TCS.g:447:148: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_concretesyntax1304);
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
              _beforeSeqEl("E0DCF6CDFEE29CDD333D11DFCFBCDD40A9FE17A4");
            }
            // parser/TCS.g:447:276: ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | )
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
                    // parser/TCS.g:447:277: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:447:293: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    // parser/TCS.g:447:294: LPAREN 'k' EQ (temp= integerSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CD6333D11DFC882DD40A9FE17A4");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_concretesyntax1319); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CD7333D11DF96E0DD40A9FE17A4");
                    }
                    match(input,105,FOLLOW_105_in_tcs_concretesyntax1323); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CD8333D11DFC60FDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1327); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CDA333D11DFC45FDD40A9FE17A4");
                    }
                    // parser/TCS.g:447:593: (temp= integerSymbol )
                    // parser/TCS.g:447:595: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_tcs_concretesyntax1335);
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
                      _beforeSeqEl("E0DCF6CDFEE29CDB333D11DF8A87DD40A9FE17A4");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_concretesyntax1342); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:447:762: 
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
              _beforeSeqEl("E0DCF6CDFEE29CDE333D11DFBB95DD40A9FE17A4");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1360); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEEE83B0333D11DF8A0BDD40A9FE17A4");
            }
            // parser/TCS.g:448:159: ( ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) )
            // parser/TCS.g:448:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            {
            // parser/TCS.g:448:160: ( (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            // parser/TCS.g:448:161: (temp= tcs_template (temp= tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | ) (temp= tcs_operatorlist (temp= tcs_operatorlist )* )? (temp= tcs_token (temp= tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEE29CE0333D11DFBEBCDD40A9FE17A4");
            }
            // parser/TCS.g:448:220: (temp= tcs_template (temp= tcs_template )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==63||LA8_0==66||LA8_0==72||LA8_0==90||LA8_0==126) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // parser/TCS.g:448:222: temp= tcs_template (temp= tcs_template )*
                    {
                    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1371);
                    temp=tcs_template();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templates", temp);
                    }
                    // parser/TCS.g:448:279: (temp= tcs_template )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==63||LA7_0==66||LA7_0==72||LA7_0==90||LA7_0==126) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // parser/TCS.g:448:281: temp= tcs_template
                    	    {
                    	    pushFollow(FOLLOW_tcs_template_in_tcs_concretesyntax1379);
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
              _beforeSeqEl("E0DCF6CDFEE77ED2333D11DF8A9ADD40A9FE17A4");
            }
            // parser/TCS.g:448:419: ( ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY ) | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==56) ) {
                alt11=1;
            }
            else if ( (LA11_0==RCURLY||LA11_0==51||LA11_0==57||LA11_0==65||LA11_0==71||LA11_0==123) ) {
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
                    // parser/TCS.g:448:420: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:448:436: ( 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY )
                    // parser/TCS.g:448:437: 'keywords' LCURLY ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CE4333D11DFA6F8DD40A9FE17A4");
                    }
                    match(input,56,FOLLOW_56_in_tcs_concretesyntax1396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CE5333D11DFB3EBDD40A9FE17A4");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1400); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE50DD0333D11DFCBD2DD40A9FE17A4");
                    }
                    // parser/TCS.g:448:664: ( ( (temp= tcs_keyword (temp= tcs_keyword )* )? ) )
                    // parser/TCS.g:448:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    {
                    // parser/TCS.g:448:665: ( (temp= tcs_keyword (temp= tcs_keyword )* )? )
                    // parser/TCS.g:448:666: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE29CE7333D11DFA50BDD40A9FE17A4");
                    }
                    // parser/TCS.g:448:725: (temp= tcs_keyword (temp= tcs_keyword )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==NAME||LA10_0==EQ) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // parser/TCS.g:448:727: temp= tcs_keyword (temp= tcs_keyword )*
                            {
                            pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1411);
                            temp=tcs_keyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "keywords", temp);
                            }
                            // parser/TCS.g:448:782: (temp= tcs_keyword )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==NAME||LA9_0==EQ) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // parser/TCS.g:448:784: temp= tcs_keyword
                            	    {
                            	    pushFollow(FOLLOW_tcs_keyword_in_tcs_concretesyntax1419);
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
                      _beforeSeqEl("E0DCF6CDFEE77ED0333D11DF989ADD40A9FE17A4");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1434); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:448:979: 
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
              _beforeSeqEl("E0DCF6CDFEE77EDE333D11DFBAD4DD40A9FE17A4");
            }
            // parser/TCS.g:449:77: ( ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY ) | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==65) ) {
                alt14=1;
            }
            else if ( (LA14_0==RCURLY||LA14_0==51||LA14_0==57||LA14_0==71||LA14_0==123) ) {
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
                    // parser/TCS.g:449:78: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:449:94: ( 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY )
                    // parser/TCS.g:449:95: 'symbols' LCURLY ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE77ED6333D11DF9828DD40A9FE17A4");
                    }
                    match(input,65,FOLLOW_65_in_tcs_concretesyntax1457); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE77ED7333D11DFC4F3DD40A9FE17A4");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_concretesyntax1461); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE77EDB333D11DFBD5FDD40A9FE17A4");
                    }
                    // parser/TCS.g:449:321: ( ( (temp= tcs_symbol (temp= tcs_symbol )* )? ) )
                    // parser/TCS.g:449:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    {
                    // parser/TCS.g:449:322: ( (temp= tcs_symbol (temp= tcs_symbol )* )? )
                    // parser/TCS.g:449:323: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE77ED9333D11DFB361DD40A9FE17A4");
                    }
                    // parser/TCS.g:449:382: (temp= tcs_symbol (temp= tcs_symbol )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==NAME||LA13_0==EQ) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // parser/TCS.g:449:384: temp= tcs_symbol (temp= tcs_symbol )*
                            {
                            pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1472);
                            temp=tcs_symbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "symbols", temp);
                            }
                            // parser/TCS.g:449:437: (temp= tcs_symbol )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==NAME||LA12_0==EQ) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // parser/TCS.g:449:439: temp= tcs_symbol
                            	    {
                            	    pushFollow(FOLLOW_tcs_symbol_in_tcs_concretesyntax1480);
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
                      _beforeSeqEl("E0DCF6CDFEE77EDC333D11DF8D4BDD40A9FE17A4");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1495); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:449:632: 
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
              _beforeSeqEl("E0DCF6CDFEE77EE0333D11DF8B3BDD40A9FE17A4");
            }
            // parser/TCS.g:450:76: (temp= tcs_operatorlist (temp= tcs_operatorlist )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==71) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // parser/TCS.g:450:78: temp= tcs_operatorlist (temp= tcs_operatorlist )*
                    {
                    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1516);
                    temp=tcs_operatorlist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operatorLists", temp);
                    }
                    // parser/TCS.g:450:143: (temp= tcs_operatorlist )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==71) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // parser/TCS.g:450:145: temp= tcs_operatorlist
                    	    {
                    	    pushFollow(FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1524);
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
              _beforeSeqEl("E0DCF6CDFEE77EE2333D11DFB513DD40A9FE17A4");
            }
            // parser/TCS.g:450:290: (temp= tcs_token (temp= tcs_token )* )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==51||LA18_0==57) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // parser/TCS.g:450:292: temp= tcs_token (temp= tcs_token )*
                    {
                    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1539);
                    temp=tcs_token();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tokens", temp);
                    }
                    // parser/TCS.g:450:343: (temp= tcs_token )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==51||LA17_0==57) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // parser/TCS.g:450:345: temp= tcs_token
                    	    {
                    	    pushFollow(FOLLOW_tcs_token_in_tcs_concretesyntax1547);
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
              _beforeSeqEl("E0DCF6CDFEEC39C2333D11DF8EB9DD40A9FE17A4");
            }
            // parser/TCS.g:450:477: ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==123) ) {
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
                    // parser/TCS.g:450:478: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:450:494: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    // parser/TCS.g:450:495: 'lexer' EQ (temp= stringSymbol ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE77EE6333D11DFA071DD40A9FE17A4");
                    }
                    match(input,123,FOLLOW_123_in_tcs_concretesyntax1564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE77EE7333D11DF8445DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_concretesyntax1568); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEE9C8C2333D11DF9A59DD40A9FE17A4");
                    }
                    // parser/TCS.g:450:715: (temp= stringSymbol )
                    // parser/TCS.g:450:717: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_concretesyntax1576);
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
                      _beforeSeqEl("E0DCF6CDFEEC39C0333D11DF9BF6DD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_concretesyntax1583); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:450:885: 
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
              _beforeSeqEl("E0DCF6CDFEEE83B1333D11DF9FC7DD40A9FE17A4");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_concretesyntax1604); if (state.failed) return ret2;
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
    // parser/TCS.g:459:1: reference[Object ret] : ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) ) ;
    public final void reference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // parser/TCS.g:460:3: ( ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) ) )
            // parser/TCS.g:461:3: ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) )
            {
            // parser/TCS.g:461:3: ( ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ) )
            // parser/TCS.g:461:4: ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEF5AFA1333D11DFC5C9DD40A9FE17A4");
            }
            // parser/TCS.g:461:64: ( ( (temp= model_classifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
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
                    // parser/TCS.g:461:65: ( (temp= model_classifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:461:81: ( (temp= model_classifier ) )
                    // parser/TCS.g:461:82: (temp= model_classifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEF0F4B5333D11DF9A50DD40A9FE17A4");
                    }
                    // parser/TCS.g:461:141: (temp= model_classifier )
                    // parser/TCS.g:461:143: temp= model_classifier
                    {
                    pushFollow(FOLLOW_model_classifier_in_reference1649);
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
                    // parser/TCS.g:461:242: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:461:258: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
                    // parser/TCS.g:461:259: RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEF0F4B7333D11DFB447DD40A9FE17A4");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_reference1665); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEF365B1333D11DF970FDD40A9FE17A4");
                    }
                    // parser/TCS.g:461:401: (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==NAME) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // parser/TCS.g:461:403: temp= identifier ( ( DLCOLON ) temp= identifier )*
                            {
                            pushFollow(FOLLOW_identifier_in_reference1673);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "names", temp);
                            }
                            // parser/TCS.g:461:454: ( ( DLCOLON ) temp= identifier )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==DLCOLON) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // parser/TCS.g:461:455: ( DLCOLON ) temp= identifier
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:461:472: ( DLCOLON )
                            	    // parser/TCS.g:461:473: DLCOLON
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDFEF0F4B9333D11DFB73CDD40A9FE17A4");
                            	    }
                            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_reference1682); if (state.failed) return ;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifier_in_reference1690);
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
    // parser/TCS.g:469:1: tcs_template returns [Object ret2] : (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate ) ;
    public final Object tcs_template() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:470:3: ( (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate ) )
            // parser/TCS.g:471:3: (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate )
            {
            // parser/TCS.g:471:3: (ret= tcs_contexttemplate | ret= tcs_primitivetemplate | ret= tcs_enumerationtemplate | ret= tcs_functiontemplate )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 90:
            case 126:
                {
                alt23=1;
                }
                break;
            case 72:
                {
                alt23=2;
                }
                break;
            case 63:
                {
                alt23=3;
                }
                break;
            case 66:
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
                    // parser/TCS.g:471:4: ret= tcs_contexttemplate
                    {
                    pushFollow(FOLLOW_tcs_contexttemplate_in_tcs_template1731);
                    ret=tcs_contexttemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:472:5: ret= tcs_primitivetemplate
                    {
                    pushFollow(FOLLOW_tcs_primitivetemplate_in_tcs_template1739);
                    ret=tcs_primitivetemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:473:5: ret= tcs_enumerationtemplate
                    {
                    pushFollow(FOLLOW_tcs_enumerationtemplate_in_tcs_template1747);
                    ret=tcs_enumerationtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:474:5: ret= tcs_functiontemplate
                    {
                    pushFollow(FOLLOW_tcs_functiontemplate_in_tcs_template1755);
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
    // parser/TCS.g:481:1: tcs_contexttemplate returns [Object ret2] : (ret= tcs_classtemplate | ret= tcs_operatortemplate ) ;
    public final Object tcs_contexttemplate() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:482:3: ( (ret= tcs_classtemplate | ret= tcs_operatortemplate ) )
            // parser/TCS.g:483:3: (ret= tcs_classtemplate | ret= tcs_operatortemplate )
            {
            // parser/TCS.g:483:3: (ret= tcs_classtemplate | ret= tcs_operatortemplate )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==126) ) {
                alt24=1;
            }
            else if ( (LA24_0==90) ) {
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
                    // parser/TCS.g:483:4: ret= tcs_classtemplate
                    {
                    pushFollow(FOLLOW_tcs_classtemplate_in_tcs_contexttemplate1782);
                    ret=tcs_classtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:484:5: ret= tcs_operatortemplate
                    {
                    pushFollow(FOLLOW_tcs_operatortemplate_in_tcs_contexttemplate1790);
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
    // parser/TCS.g:491:1: tcs_primitivetemplate returns [Object ret2] : ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_primitivetemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitiveTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:496:3: ( ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:497:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:497:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:497:4: 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) COLON 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) SEMI (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEFCDB90333D11DFAE09DD40A9FE17A4");
            }
            match(input,72,FOLLOW_72_in_tcs_primitivetemplate1820); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEFCDB92333D11DFB97DDD40A9FE17A4");
            }
            // parser/TCS.g:497:157: (temp= identifier )
            // parser/TCS.g:497:159: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1827);
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
              _beforeSeqEl("E0DCF6CDFEFCDB93333D11DFCA69DD40A9FE17A4");
            }
            match(input,84,FOLLOW_84_in_tcs_primitivetemplate1833); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFEFCDB94333D11DFA079DD40A9FE17A4");
            }
            pushFollow(FOLLOW_reference_in_tcs_primitivetemplate1836);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF019680333D11DFBB6EDD40A9FE17A4");
            }
            // parser/TCS.g:497:462: ( ( 'default' ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==69) ) {
                alt25=1;
            }
            else if ( (LA25_0==134) ) {
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
                    // parser/TCS.g:497:463: ( 'default' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:497:479: ( 'default' )
                    // parser/TCS.g:497:480: 'default'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFEFF4C93333D11DF993BDD40A9FE17A4");
                    }
                    match(input,69,FOLLOW_69_in_tcs_primitivetemplate1846); if (state.failed) return ret2;
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
                    // parser/TCS.g:497:638: 
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
              _beforeSeqEl("E0DCF6CDFF019681333D11DFB6A1DD40A9FE17A4");
            }
            match(input,134,FOLLOW_134_in_tcs_primitivetemplate1864); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF019683333D11DFA5E2DD40A9FE17A4");
            }
            // parser/TCS.g:498:158: (temp= identifier )
            // parser/TCS.g:498:160: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivetemplate1871);
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
              _beforeSeqEl("E0DCF6CDFF019689333D11DFCAAADD40A9FE17A4");
            }
            // parser/TCS.g:498:291: ( ( 'orKeyword' ) | )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==82) ) {
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
                    // parser/TCS.g:498:292: ( 'orKeyword' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:498:308: ( 'orKeyword' )
                    // parser/TCS.g:498:309: 'orKeyword'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF019687333D11DF9AFADD40A9FE17A4");
                    }
                    match(input,82,FOLLOW_82_in_tcs_primitivetemplate1883); if (state.failed) return ret2;
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
                    // parser/TCS.g:498:469: 
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
              _beforeSeqEl("E0DCF6CDFF01968A333D11DFCC66DD40A9FE17A4");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_primitivetemplate1902); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF01968B333D11DFB2D3DD40A9FE17A4");
            }
            match(input,91,FOLLOW_91_in_tcs_primitivetemplate1906); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF01968C333D11DF9804DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1910); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF01968F333D11DFA931DD40A9FE17A4");
            }
            // parser/TCS.g:499:319: (temp= stringSymbol )
            // parser/TCS.g:499:321: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1918);
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
              _beforeSeqEl("E0DCF6CDFF01969A333D11DF81D0DD40A9FE17A4");
            }
            // parser/TCS.g:499:450: ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
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
                    // parser/TCS.g:499:451: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:499:467: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:499:468: COMA 'serializer' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF019693333D11DFC275DD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_primitivetemplate1931); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF019694333D11DFB837DD40A9FE17A4");
                    }
                    match(input,68,FOLLOW_68_in_tcs_primitivetemplate1935); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF019695333D11DFCE0BDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivetemplate1939); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF019698333D11DFB2B3DD40A9FE17A4");
                    }
                    // parser/TCS.g:499:774: (temp= stringSymbol )
                    // parser/TCS.g:499:776: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_primitivetemplate1947);
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
                    // parser/TCS.g:499:868: 
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
              _beforeSeqEl("E0DCF6CDFF01969B333D11DFC8F8DD40A9FE17A4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_primitivetemplate1967); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF040780333D11DF9051DD40A9FE17A4");
            }
            // parser/TCS.g:500:157: (temp= textblockdefinition_textblockdefinition )?
            int alt28=2;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // parser/TCS.g:500:159: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1975);
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
    // parser/TCS.g:508:1: tcs_enumerationtemplate returns [Object ret2] : ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_enumerationtemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumerationTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:513:3: ( ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:514:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:514:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:514:4: 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF065172333D11DF91A8DD40A9FE17A4");
            }
            match(input,63,FOLLOW_63_in_tcs_enumerationtemplate2020); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF065173333D11DF8085DD40A9FE17A4");
            }
            pushFollow(FOLLOW_reference_in_tcs_enumerationtemplate2023);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF065179333D11DF8639DD40A9FE17A4");
            }
            // parser/TCS.g:514:249: ( ( 'auto' ) | )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==98) ) {
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
                    // parser/TCS.g:514:250: ( 'auto' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:514:266: ( 'auto' )
                    // parser/TCS.g:514:267: 'auto'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF065177333D11DFB01FDD40A9FE17A4");
                    }
                    match(input,98,FOLLOW_98_in_tcs_enumerationtemplate2033); if (state.failed) return ret2;
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
                    // parser/TCS.g:514:422: 
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
              _beforeSeqEl("E0DCF6CDFF08C280333D11DFB3F6DD40A9FE17A4");
            }
            // parser/TCS.g:515:77: ( ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
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
                    // parser/TCS.g:515:78: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:515:94: ( ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    // parser/TCS.g:515:95: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF08C27C333D11DF81EDDD40A9FE17A4");
                    }
                    // parser/TCS.g:515:154: ( ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    // parser/TCS.g:515:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    {
                    // parser/TCS.g:515:155: ( COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI )
                    // parser/TCS.g:515:156: COLON ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF08C271333D11DFB8C5DD40A9FE17A4");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_enumerationtemplate2061); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF08C279333D11DF845BDD40A9FE17A4");
                    }
                    // parser/TCS.g:515:297: ( ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? ) )
                    // parser/TCS.g:515:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    {
                    // parser/TCS.g:515:298: ( (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )? )
                    // parser/TCS.g:515:299: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF08C276333D11DF85AEDD40A9FE17A4");
                    }
                    // parser/TCS.g:515:358: (temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==SHARP) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // parser/TCS.g:515:360: temp= tcs_enumliteralmapping ( ( COMA ) temp= tcs_enumliteralmapping )*
                            {
                            pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2072);
                            temp=tcs_enumliteralmapping();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mappings", temp);
                            }
                            // parser/TCS.g:515:426: ( ( COMA ) temp= tcs_enumliteralmapping )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==COMA) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // parser/TCS.g:515:427: ( COMA ) temp= tcs_enumliteralmapping
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:515:444: ( COMA )
                            	    // parser/TCS.g:515:445: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDFF08C273333D11DFB84CDD40A9FE17A4");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_enumerationtemplate2081); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2089);
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
                      _beforeSeqEl("E0DCF6CDFF08C27A333D11DF8418DD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate2104); if (state.failed) return ret2;
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
                    // parser/TCS.g:515:766: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:515:782: ( SEMI )
                    // parser/TCS.g:515:783: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF08C27E333D11DF8EC2DD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_enumerationtemplate2121); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDFF0B3372333D11DFC6F5DD40A9FE17A4");
            }
            // parser/TCS.g:516:76: (temp= textblockdefinition_textblockdefinition )?
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // parser/TCS.g:516:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate2135);
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
    // parser/TCS.g:524:1: tcs_enumliteralmapping returns [Object ret2] : ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) ;
    public final Object tcs_enumliteralmapping() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:529:3: ( ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) ) )
            // parser/TCS.g:530:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            {
            // parser/TCS.g:530:3: ( (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref ) )
            // parser/TCS.g:530:4: (temp= tcs_enumliteralval ) EQ (temp= tcs_literalref )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF0D7D61333D11DF8873DD40A9FE17A4");
            }
            // parser/TCS.g:530:63: (temp= tcs_enumliteralval )
            // parser/TCS.g:530:65: temp= tcs_enumliteralval
            {
            pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping2184);
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
              _beforeSeqEl("E0DCF6CDFF0D7D62333D11DFAA1DDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_enumliteralmapping2191); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF0D7D64333D11DF842ADD40A9FE17A4");
            }
            // parser/TCS.g:530:280: (temp= tcs_literalref )
            // parser/TCS.g:530:282: temp= tcs_literalref
            {
            pushFollow(FOLLOW_tcs_literalref_in_tcs_enumliteralmapping2199);
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
    // parser/TCS.g:538:1: tcs_classtemplate returns [Object ret2] : ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_classtemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:543:3: ( ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:544:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:544:3: ( 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:544:4: 'template' reference[ret] ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF0FEE60333D11DF9C89DD40A9FE17A4");
            }
            match(input,126,FOLLOW_126_in_tcs_classtemplate2242); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF0FEE61333D11DFAC08DD40A9FE17A4");
            }
            pushFollow(FOLLOW_reference_in_tcs_classtemplate2245);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF19645B333D11DFA8FADD40A9FE17A4");
            }
            // parser/TCS.g:544:238: ( ( 'referenceOnly' ) | ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==132) ) {
                alt49=1;
            }
            else if ( (LA49_0==LPAREN||LA49_0==SEMI||LA49_0==COLON||LA49_0==SHARP||LA49_0==50||LA49_0==60||LA49_0==64||LA49_0==74||LA49_0==81||LA49_0==101||LA49_0==113||LA49_0==117||LA49_0==127) ) {
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
                    // parser/TCS.g:544:239: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:544:255: ( 'referenceOnly' )
                    // parser/TCS.g:544:256: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF0FEE65333D11DFC8F1DD40A9FE17A4");
                    }
                    match(input,132,FOLLOW_132_in_tcs_classtemplate2255); if (state.failed) return ret2;
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
                    // parser/TCS.g:544:426: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:544:442: ( ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | ) )
                    // parser/TCS.g:544:443: ( ( SHARP (temp= identifier ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF0FEE6E333D11DF8B05DD40A9FE17A4");
                    }
                    // parser/TCS.g:544:503: ( ( SHARP (temp= identifier ) ) | )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==SHARP) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==LPAREN||LA34_0==SEMI||LA34_0==COLON||LA34_0==50||LA34_0==60||LA34_0==64||LA34_0==74||LA34_0==81||LA34_0==101||LA34_0==113||LA34_0==117||LA34_0==127) ) {
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
                            // parser/TCS.g:544:504: ( SHARP (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:544:520: ( SHARP (temp= identifier ) )
                            // parser/TCS.g:544:521: SHARP (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE6A333D11DF868ADD40A9FE17A4");
                            }
                            match(input,SHARP,FOLLOW_SHARP_in_tcs_classtemplate2275); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE6C333D11DFBEEADD40A9FE17A4");
                            }
                            // parser/TCS.g:544:662: (temp= identifier )
                            // parser/TCS.g:544:664: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_classtemplate2283);
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
                            // parser/TCS.g:544:748: 
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
                      _beforeSeqEl("E0DCF6CDFF0FEE7A333D11DFACACDD40A9FE17A4");
                    }
                    // parser/TCS.g:545:77: ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==LPAREN) ) {
                        int LA35_1 = input.LA(2);

                        if ( (LA35_1==54) ) {
                            alt35=1;
                        }
                        else if ( (LA35_1==96||LA35_1==133) ) {
                            alt35=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 35, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA35_0==SEMI||LA35_0==COLON||LA35_0==50||LA35_0==60||LA35_0==64||LA35_0==74||LA35_0==81||LA35_0==101||LA35_0==113||LA35_0==117||LA35_0==127) ) {
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
                            // parser/TCS.g:545:78: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:545:94: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:545:95: LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE72333D11DFC1B8DD40A9FE17A4");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2309); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE73333D11DFCC12DD40A9FE17A4");
                            }
                            match(input,54,FOLLOW_54_in_tcs_classtemplate2313); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE74333D11DF8C32DD40A9FE17A4");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2317); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE77333D11DFA7DDDD40A9FE17A4");
                            }
                            // parser/TCS.g:545:405: (temp= stringSymbol )
                            // parser/TCS.g:545:407: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2325);
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
                              _beforeSeqEl("E0DCF6CDFF0FEE78333D11DFB1EEDD40A9FE17A4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2332); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // parser/TCS.g:545:584: 
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
                      _beforeSeqEl("E0DCF6CDFF123851333D11DFACA1DD40A9FE17A4");
                    }
                    // parser/TCS.g:546:77: ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==LPAREN) ) {
                        int LA36_1 = input.LA(2);

                        if ( (LA36_1==96) ) {
                            alt36=2;
                        }
                        else if ( (LA36_1==133) ) {
                            alt36=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 36, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA36_0==SEMI||LA36_0==COLON||LA36_0==50||LA36_0==60||LA36_0==64||LA36_0==74||LA36_0==81||LA36_0==101||LA36_0==113||LA36_0==117||LA36_0==127) ) {
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
                            // parser/TCS.g:546:78: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:546:94: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:546:95: LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE7E333D11DFCDFADD40A9FE17A4");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2356); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE7F333D11DF9FDDDD40A9FE17A4");
                            }
                            match(input,133,FOLLOW_133_in_tcs_classtemplate2360); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE80333D11DF8720DD40A9FE17A4");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2364); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF0FEE83333D11DFCB56DD40A9FE17A4");
                            }
                            // parser/TCS.g:546:407: (temp= stringSymbol )
                            // parser/TCS.g:546:409: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2372);
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
                              _beforeSeqEl("E0DCF6CDFF0FEE84333D11DFCD3ADD40A9FE17A4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2379); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // parser/TCS.g:546:588: 
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
                      _beforeSeqEl("E0DCF6CDFF12385D333D11DFC4D2DD40A9FE17A4");
                    }
                    // parser/TCS.g:547:77: ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==LPAREN) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==SEMI||LA37_0==COLON||LA37_0==50||LA37_0==60||LA37_0==64||LA37_0==74||LA37_0==81||LA37_0==101||LA37_0==113||LA37_0==117||LA37_0==127) ) {
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
                            // parser/TCS.g:547:78: ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:547:94: ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // parser/TCS.g:547:95: LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF123855333D11DF8C87DD40A9FE17A4");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2403); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF123856333D11DF92D4DD40A9FE17A4");
                            }
                            match(input,96,FOLLOW_96_in_tcs_classtemplate2407); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF123857333D11DFA1ADDD40A9FE17A4");
                            }
                            match(input,EQ,FOLLOW_EQ_in_tcs_classtemplate2411); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF12385A333D11DFBBC3DD40A9FE17A4");
                            }
                            // parser/TCS.g:547:408: (temp= stringSymbol )
                            // parser/TCS.g:547:410: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_classtemplate2419);
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
                              _beforeSeqEl("E0DCF6CDFF12385B333D11DFA65EDD40A9FE17A4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2426); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // parser/TCS.g:547:590: 
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
                      _beforeSeqEl("E0DCF6CDFF123863333D11DF858ADD40A9FE17A4");
                    }
                    // parser/TCS.g:548:77: ( ( 'multi' ) | )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==101) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==SEMI||LA38_0==COLON||LA38_0==50||LA38_0==60||LA38_0==64||LA38_0==74||LA38_0==81||LA38_0==113||LA38_0==117||LA38_0==127) ) {
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
                            // parser/TCS.g:548:78: ( 'multi' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:548:94: ( 'multi' )
                            // parser/TCS.g:548:95: 'multi'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF123861333D11DF9BCEDD40A9FE17A4");
                            }
                            match(input,101,FOLLOW_101_in_tcs_classtemplate2449); if (state.failed) return ret2;
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
                            // parser/TCS.g:548:249: 
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
                      _beforeSeqEl("E0DCF6CDFF14A954333D11DFCD87DD40A9FE17A4");
                    }
                    // parser/TCS.g:549:77: ( ( 'main' ) | )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==127) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==SEMI||LA39_0==COLON||LA39_0==50||LA39_0==60||LA39_0==64||LA39_0==74||LA39_0==81||LA39_0==113||LA39_0==117) ) {
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
                            // parser/TCS.g:549:78: ( 'main' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:549:94: ( 'main' )
                            // parser/TCS.g:549:95: 'main'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF14A952333D11DFB84CDD40A9FE17A4");
                            }
                            match(input,127,FOLLOW_127_in_tcs_classtemplate2473); if (state.failed) return ret2;
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
                            // parser/TCS.g:549:247: 
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
                      _beforeSeqEl("E0DCF6CDFF14A960333D11DF912ADD40A9FE17A4");
                    }
                    // parser/TCS.g:550:77: ( ( ( ( 'deep' ) | ) 'abstract' ) | )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==60||LA41_0==81) ) {
                        alt41=1;
                    }
                    else if ( (LA41_0==SEMI||LA41_0==COLON||LA41_0==50||LA41_0==64||LA41_0==74||LA41_0==113||LA41_0==117) ) {
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
                            // parser/TCS.g:550:78: ( ( ( 'deep' ) | ) 'abstract' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:550:94: ( ( ( 'deep' ) | ) 'abstract' )
                            // parser/TCS.g:550:95: ( ( 'deep' ) | ) 'abstract'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF14A95D333D11DFAE48DD40A9FE17A4");
                            }
                            // parser/TCS.g:550:155: ( ( 'deep' ) | )
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==60) ) {
                                alt40=1;
                            }
                            else if ( (LA40_0==81) ) {
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
                                    // parser/TCS.g:550:156: ( 'deep' )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:550:172: ( 'deep' )
                                    // parser/TCS.g:550:173: 'deep'
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDFF14A95B333D11DF812DDD40A9FE17A4");
                                    }
                                    match(input,60,FOLLOW_60_in_tcs_classtemplate2503); if (state.failed) return ret2;
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
                                    // parser/TCS.g:550:325: 
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
                              _beforeSeqEl("E0DCF6CDFF14A95E333D11DF8D90DD40A9FE17A4");
                            }
                            match(input,81,FOLLOW_81_in_tcs_classtemplate2521); if (state.failed) return ret2;
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
                            // parser/TCS.g:551:177: 
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
                      _beforeSeqEl("E0DCF6CDFF171A55333D11DFAA29DD40A9FE17A4");
                    }
                    // parser/TCS.g:552:77: ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==74) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==SEMI||LA43_0==COLON||LA43_0==50||LA43_0==64||LA43_0==113||LA43_0==117) ) {
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
                            // parser/TCS.g:552:78: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:552:94: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            // parser/TCS.g:552:95: 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF14A964333D11DFBE5ADD40A9FE17A4");
                            }
                            match(input,74,FOLLOW_74_in_tcs_classtemplate2545); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF171A53333D11DF949FDD40A9FE17A4");
                            }
                            // parser/TCS.g:552:242: ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            int alt42=2;
                            int LA42_0 = input.LA(1);

                            if ( (LA42_0==LPAREN) ) {
                                alt42=1;
                            }
                            else if ( (LA42_0==SEMI||LA42_0==COLON||LA42_0==50||LA42_0==64||LA42_0==113||LA42_0==117) ) {
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
                                    // parser/TCS.g:552:243: ( LPAREN (temp= identifier ) RPAREN )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:552:259: ( LPAREN (temp= identifier ) RPAREN )
                                    // parser/TCS.g:552:260: LPAREN (temp= identifier ) RPAREN
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDFF14A968333D11DFA6A5DD40A9FE17A4");
                                    }
                                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_classtemplate2555); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDFF171A50333D11DFC55ADD40A9FE17A4");
                                    }
                                    // parser/TCS.g:552:402: (temp= identifier )
                                    // parser/TCS.g:552:404: temp= identifier
                                    {
                                    pushFollow(FOLLOW_identifier_in_tcs_classtemplate2563);
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
                                      _beforeSeqEl("E0DCF6CDFF171A51333D11DFA970DD40A9FE17A4");
                                    }
                                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_classtemplate2570); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }

                                    }

                                    if ( state.backtracking==0 ) {
                                      _exitAlt();
                                    }

                                    }
                                    break;
                                case 2 :
                                    // parser/TCS.g:552:644: 
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
                            // parser/TCS.g:553:94: 
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
                      _beforeSeqEl("E0DCF6CDFF171A62333D11DFA70CDD40A9FE17A4");
                    }
                    // parser/TCS.g:554:77: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==117) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==SEMI||LA45_0==COLON||LA45_0==50||LA45_0==64||LA45_0==113) ) {
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
                            // parser/TCS.g:554:78: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:554:94: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:554:95: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF171A59333D11DFC0BADD40A9FE17A4");
                            }
                            match(input,117,FOLLOW_117_in_tcs_classtemplate2608); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF171A60333D11DFBE32DD40A9FE17A4");
                            }
                            // parser/TCS.g:554:239: ( ( (temp= tcs_contexttags ) ) | )
                            int alt44=2;
                            int LA44_0 = input.LA(1);

                            if ( (LA44_0==LPAREN) ) {
                                alt44=1;
                            }
                            else if ( (LA44_0==SEMI||LA44_0==COLON||LA44_0==50||LA44_0==64||LA44_0==113) ) {
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
                                    // parser/TCS.g:554:240: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:554:256: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:554:257: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDFF171A5E333D11DF9D3FDD40A9FE17A4");
                                    }
                                    // parser/TCS.g:554:316: (temp= tcs_contexttags )
                                    // parser/TCS.g:554:318: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_classtemplate2621);
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
                                    // parser/TCS.g:554:414: 
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
                            // parser/TCS.g:555:91: 
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
                      _beforeSeqEl("E0DCF6CDFF196445333D11DFAFEADD40A9FE17A4");
                    }
                    // parser/TCS.g:556:77: ( ( 'addToContext' ) | )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==50) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==SEMI||LA46_0==COLON||LA46_0==64||LA46_0==113) ) {
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
                            // parser/TCS.g:556:78: ( 'addToContext' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:556:94: ( 'addToContext' )
                            // parser/TCS.g:556:95: 'addToContext'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF196443333D11DFA1E5DD40A9FE17A4");
                            }
                            match(input,50,FOLLOW_50_in_tcs_classtemplate2661); if (state.failed) return ret2;
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
                            // parser/TCS.g:556:263: 
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
                      _beforeSeqEl("E0DCF6CDFF19644B333D11DFAFB9DD40A9FE17A4");
                    }
                    // parser/TCS.g:557:77: ( ( 'nonPrimary' ) | )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==64) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==SEMI||LA47_0==COLON||LA47_0==113) ) {
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
                            // parser/TCS.g:557:78: ( 'nonPrimary' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:557:94: ( 'nonPrimary' )
                            // parser/TCS.g:557:95: 'nonPrimary'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF196449333D11DFA4B7DD40A9FE17A4");
                            }
                            match(input,64,FOLLOW_64_in_tcs_classtemplate2685); if (state.failed) return ret2;
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
                            // parser/TCS.g:557:259: 
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
                      _beforeSeqEl("E0DCF6CDFF196459333D11DFA8C1DD40A9FE17A4");
                    }
                    // parser/TCS.g:558:77: ( ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) ) | )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==113) ) {
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
                            // parser/TCS.g:558:78: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:558:94: ( 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) ) )
                            // parser/TCS.g:558:95: 'prefix' ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF19644F333D11DF946FDD40A9FE17A4");
                            }
                            match(input,113,FOLLOW_113_in_tcs_classtemplate2709); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF196457333D11DF9F50DD40A9FE17A4");
                            }
                            // parser/TCS.g:558:237: ( ( COLON ( ( (temp= tcs_sequence ) ) ) ) )
                            // parser/TCS.g:558:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            {
                            // parser/TCS.g:558:238: ( COLON ( ( (temp= tcs_sequence ) ) ) )
                            // parser/TCS.g:558:239: COLON ( ( (temp= tcs_sequence ) ) )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF196450333D11DF928FDD40A9FE17A4");
                            }
                            match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2716); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF196455333D11DF9C4BDD40A9FE17A4");
                            }
                            // parser/TCS.g:558:380: ( ( (temp= tcs_sequence ) ) )
                            // parser/TCS.g:558:381: ( (temp= tcs_sequence ) )
                            {
                            // parser/TCS.g:558:381: ( (temp= tcs_sequence ) )
                            // parser/TCS.g:558:382: (temp= tcs_sequence )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF196452333D11DFCAE7DD40A9FE17A4");
                            }
                            // parser/TCS.g:558:441: (temp= tcs_sequence )
                            // parser/TCS.g:558:443: temp= tcs_sequence
                            {
                            pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2727);
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
                            // parser/TCS.g:558:575: 
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
              _beforeSeqEl("E0DCF6CDFF1BD54D333D11DFAFB0DD40A9FE17A4");
            }
            // parser/TCS.g:560:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
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
                    // parser/TCS.g:560:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:560:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:560:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF1BD549333D11DFBDCADD40A9FE17A4");
                    }
                    // parser/TCS.g:560:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:560:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:560:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:560:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF1BD541333D11DFC419DD40A9FE17A4");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_classtemplate2769); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF1BD546333D11DFBE7BDD40A9FE17A4");
                    }
                    // parser/TCS.g:560:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:560:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:560:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:560:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF1BD543333D11DF8B26DD40A9FE17A4");
                    }
                    // parser/TCS.g:560:358: (temp= tcs_sequence )
                    // parser/TCS.g:560:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_classtemplate2780);
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
                      _beforeSeqEl("E0DCF6CDFF1BD547333D11DF80C2DD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2790); if (state.failed) return ret2;
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
                    // parser/TCS.g:560:575: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:560:591: ( SEMI )
                    // parser/TCS.g:560:592: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF1BD54B333D11DF907CDD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_classtemplate2807); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDFF1BD550333D11DFA17CDD40A9FE17A4");
            }
            // parser/TCS.g:561:76: (temp= textblockdefinition_textblockdefinition )?
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // parser/TCS.g:561:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2821);
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
    // parser/TCS.g:569:1: tcs_operatortemplate returns [Object ret2] : ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) ;
    public final Object tcs_operatortemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:574:3: ( ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? ) )
            // parser/TCS.g:575:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            {
            // parser/TCS.g:575:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )? )
            // parser/TCS.g:575:4: 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= tcs_propertyreference ) ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) (temp= textblockdefinition_textblockdefinition )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209030333D11DF999BDD40A9FE17A4");
            }
            match(input,90,FOLLOW_90_in_tcs_operatortemplate2866); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209031333D11DFCD65DD40A9FE17A4");
            }
            pushFollow(FOLLOW_reference_in_tcs_operatortemplate2869);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209032333D11DF9A35DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_operatortemplate2874); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209033333D11DFBB8EDD40A9FE17A4");
            }
            match(input,71,FOLLOW_71_in_tcs_operatortemplate2878); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209034333D11DFA7B6DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2882); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209037333D11DF99CDDD40A9FE17A4");
            }
            // parser/TCS.g:575:493: (temp= identifier (temp= identifier )* )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==NAME) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // parser/TCS.g:575:495: temp= identifier (temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2890);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);
                    }
                    // parser/TCS.g:575:611: (temp= identifier )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==NAME) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // parser/TCS.g:575:613: temp= identifier
                    	    {
                    	    pushFollow(FOLLOW_identifier_in_tcs_operatortemplate2898);
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
              _beforeSeqEl("E0DCF6CDFF209038333D11DF8D1DDD40A9FE17A4");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2910); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF209039333D11DF837BDD40A9FE17A4");
            }
            match(input,53,FOLLOW_53_in_tcs_operatortemplate2914); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF20903A333D11DF8856DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2918); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF20903C333D11DF8FE4DD40A9FE17A4");
            }
            // parser/TCS.g:575:1052: (temp= tcs_propertyreference )
            // parser/TCS.g:575:1054: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2926);
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
              _beforeSeqEl("E0DCF6CDFF230139333D11DF9DC7DD40A9FE17A4");
            }
            // parser/TCS.g:575:1202: ( ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==COMA) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==130) ) {
                    alt54=1;
                }
                else if ( (LA54_1==54||LA54_1==96||LA54_1==107||LA54_1==133) ) {
                    alt54=2;
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
                    // parser/TCS.g:575:1203: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:575:1219: ( COMA 'storeOpTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:575:1220: COMA 'storeOpTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230133333D11DFC1B5DD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2939); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230134333D11DF8CDADD40A9FE17A4");
                    }
                    match(input,130,FOLLOW_130_in_tcs_operatortemplate2943); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230135333D11DFB672DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2947); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230137333D11DFCE08DD40A9FE17A4");
                    }
                    // parser/TCS.g:575:1525: (temp= tcs_propertyreference )
                    // parser/TCS.g:575:1527: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2955);
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
                    // parser/TCS.g:575:1633: 
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
              _beforeSeqEl("E0DCF6CDFF230143333D11DF8CAEDD40A9FE17A4");
            }
            // parser/TCS.g:576:77: ( ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) ) | )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==COMA) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==54||LA55_1==96||LA55_1==133) ) {
                    alt55=2;
                }
                else if ( (LA55_1==107) ) {
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
                    // parser/TCS.g:576:78: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:576:94: ( COMA 'storeRightTo' EQ (temp= tcs_propertyreference ) )
                    // parser/TCS.g:576:95: COMA 'storeRightTo' EQ (temp= tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF23013D333D11DFABC5DD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate2981); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF23013E333D11DF8195DD40A9FE17A4");
                    }
                    match(input,107,FOLLOW_107_in_tcs_operatortemplate2985); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF23013F333D11DF8B90DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate2989); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230141333D11DFBA47DD40A9FE17A4");
                    }
                    // parser/TCS.g:576:403: (temp= tcs_propertyreference )
                    // parser/TCS.g:576:405: temp= tcs_propertyreference
                    {
                    pushFollow(FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2997);
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
                    // parser/TCS.g:576:512: 
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
              _beforeSeqEl("E0DCF6CDFF23014E333D11DF9633DD40A9FE17A4");
            }
            // parser/TCS.g:577:77: ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==COMA) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==96||LA56_1==133) ) {
                    alt56=2;
                }
                else if ( (LA56_1==54) ) {
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
                    // parser/TCS.g:577:78: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:577:94: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:577:95: COMA 'disambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230147333D11DF8387DD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate3023); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230148333D11DFB525DD40A9FE17A4");
                    }
                    match(input,54,FOLLOW_54_in_tcs_operatortemplate3027); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230149333D11DF90ECDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate3031); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF23014C333D11DF88DEDD40A9FE17A4");
                    }
                    // parser/TCS.g:577:403: (temp= stringSymbol )
                    // parser/TCS.g:577:405: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate3039);
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
                    // parser/TCS.g:577:499: 
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
              _beforeSeqEl("E0DCF6CDFF230159333D11DF8EBBDD40A9FE17A4");
            }
            // parser/TCS.g:578:77: ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==COMA) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==96) ) {
                    alt57=2;
                }
                else if ( (LA57_1==133) ) {
                    alt57=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 1, input);

                    throw nvae;
                }
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
                    // parser/TCS.g:578:78: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:578:94: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:578:95: COMA 'disambiguateV3' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230152333D11DFB17ADD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate3065); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230153333D11DFCEBCDD40A9FE17A4");
                    }
                    match(input,133,FOLLOW_133_in_tcs_operatortemplate3069); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230154333D11DFCC54DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate3073); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF230157333D11DFCEC0DD40A9FE17A4");
                    }
                    // parser/TCS.g:578:405: (temp= stringSymbol )
                    // parser/TCS.g:578:407: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate3081);
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
                    // parser/TCS.g:578:503: 
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
              _beforeSeqEl("E0DCF6CDFF254B27333D11DFC425DD40A9FE17A4");
            }
            // parser/TCS.g:579:77: ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==COMA) ) {
                alt58=1;
            }
            else if ( (LA58_0==RPAREN) ) {
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
                    // parser/TCS.g:579:78: ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:579:94: ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:579:95: COMA 'semDisambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF254B20333D11DF862BDD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_operatortemplate3107); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF254B21333D11DF9517DD40A9FE17A4");
                    }
                    match(input,96,FOLLOW_96_in_tcs_operatortemplate3111); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF254B22333D11DFAD84DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_operatortemplate3115); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF254B25333D11DFAB20DD40A9FE17A4");
                    }
                    // parser/TCS.g:579:406: (temp= stringSymbol )
                    // parser/TCS.g:579:408: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_operatortemplate3123);
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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:579:505: 
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
              _beforeSeqEl("E0DCF6CDFF254B28333D11DF891EDD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_operatortemplate3143); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF254B3C333D11DF8DCCDD40A9FE17A4");
            }
            // parser/TCS.g:580:160: ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==132) ) {
                alt61=1;
            }
            else if ( (LA61_0==SEMI||LA61_0==COLON||LA61_0==117) ) {
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
                    // parser/TCS.g:580:161: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:580:177: ( 'referenceOnly' )
                    // parser/TCS.g:580:178: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF254B2C333D11DFB939DD40A9FE17A4");
                    }
                    match(input,132,FOLLOW_132_in_tcs_operatortemplate3153); if (state.failed) return ret2;
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
                    // parser/TCS.g:580:348: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:580:364: ( ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | ) )
                    // parser/TCS.g:580:365: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF254B3A333D11DFB3D8DD40A9FE17A4");
                    }
                    // parser/TCS.g:580:425: ( ( 'context' ( ( (temp= tcs_contexttags ) ) | ) ) | )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==117) ) {
                        alt60=1;
                    }
                    else if ( (LA60_0==SEMI||LA60_0==COLON) ) {
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
                            // parser/TCS.g:580:426: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:580:442: ( 'context' ( ( (temp= tcs_contexttags ) ) | ) )
                            // parser/TCS.g:580:443: 'context' ( ( (temp= tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF254B31333D11DFA5E0DD40A9FE17A4");
                            }
                            match(input,117,FOLLOW_117_in_tcs_operatortemplate3172); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF254B38333D11DF912FDD40A9FE17A4");
                            }
                            // parser/TCS.g:580:587: ( ( (temp= tcs_contexttags ) ) | )
                            int alt59=2;
                            int LA59_0 = input.LA(1);

                            if ( (LA59_0==LPAREN) ) {
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
                                    // parser/TCS.g:580:588: ( (temp= tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // parser/TCS.g:580:604: ( (temp= tcs_contexttags ) )
                                    // parser/TCS.g:580:605: (temp= tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("E0DCF6CDFF254B36333D11DFB7D7DD40A9FE17A4");
                                    }
                                    // parser/TCS.g:580:664: (temp= tcs_contexttags )
                                    // parser/TCS.g:580:666: temp= tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_tcs_contexttags_in_tcs_operatortemplate3185);
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
                                    // parser/TCS.g:580:762: 
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
                            // parser/TCS.g:581:91: 
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
              _beforeSeqEl("E0DCF6CDFF27BC2F333D11DF8824DD40A9FE17A4");
            }
            // parser/TCS.g:583:77: ( ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==COLON) ) {
                alt62=1;
            }
            else if ( (LA62_0==SEMI) ) {
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
                    // parser/TCS.g:583:78: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:583:94: ( ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
                    // parser/TCS.g:583:95: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF27BC2B333D11DF9AB0DD40A9FE17A4");
                    }
                    // parser/TCS.g:583:154: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
                    // parser/TCS.g:583:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    {
                    // parser/TCS.g:583:155: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
                    // parser/TCS.g:583:156: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF27BC23333D11DF8138DD40A9FE17A4");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_operatortemplate3236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF27BC28333D11DFB4ECDD40A9FE17A4");
                    }
                    // parser/TCS.g:583:297: ( ( (temp= tcs_sequence ) ) )
                    // parser/TCS.g:583:298: ( (temp= tcs_sequence ) )
                    {
                    // parser/TCS.g:583:298: ( (temp= tcs_sequence ) )
                    // parser/TCS.g:583:299: (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF27BC25333D11DF83E7DD40A9FE17A4");
                    }
                    // parser/TCS.g:583:358: (temp= tcs_sequence )
                    // parser/TCS.g:583:360: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_operatortemplate3247);
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
                      _beforeSeqEl("E0DCF6CDFF27BC29333D11DFBA2BDD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate3257); if (state.failed) return ret2;
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
                    // parser/TCS.g:583:569: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:583:585: ( SEMI )
                    // parser/TCS.g:583:586: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF27BC2D333D11DFCBD4DD40A9FE17A4");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_tcs_operatortemplate3274); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDFF27BC32333D11DF976EDD40A9FE17A4");
            }
            // parser/TCS.g:584:76: (temp= textblockdefinition_textblockdefinition )?
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // parser/TCS.g:584:78: temp= textblockdefinition_textblockdefinition
                    {
                    pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate3288);
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
    // parser/TCS.g:592:1: tcs_functiontemplate returns [Object ret2] : ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) ;
    public final Object tcs_functiontemplate() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionTemplate");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:597:3: ( ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) ) )
            // parser/TCS.g:598:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            {
            // parser/TCS.g:598:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) ) )
            // parser/TCS.g:598:4: 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A0610333D11DF8CC9DD40A9FE17A4");
            }
            match(input,66,FOLLOW_66_in_tcs_functiontemplate3333); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A0612333D11DFB3B2DD40A9FE17A4");
            }
            // parser/TCS.g:598:148: (temp= identifier )
            // parser/TCS.g:598:150: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functiontemplate3340);
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
              _beforeSeqEl("E0DCF6CDFF2A0613333D11DFA9AFDD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_functiontemplate3347); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A0614333D11DF808FDD40A9FE17A4");
            }
            pushFollow(FOLLOW_reference_in_tcs_functiontemplate3351);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A0615333D11DF99F9DD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_functiontemplate3356); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2C7712333D11DFB9F4DD40A9FE17A4");
            }
            // parser/TCS.g:598:538: ( ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI ) )
            // parser/TCS.g:598:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            {
            // parser/TCS.g:598:539: ( COLON ( ( (temp= tcs_sequence ) ) ) SEMI )
            // parser/TCS.g:598:540: COLON ( ( (temp= tcs_sequence ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A0616333D11DF8B42DD40A9FE17A4");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_functiontemplate3364); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A061B333D11DF8D46DD40A9FE17A4");
            }
            // parser/TCS.g:598:681: ( ( (temp= tcs_sequence ) ) )
            // parser/TCS.g:598:682: ( (temp= tcs_sequence ) )
            {
            // parser/TCS.g:598:682: ( (temp= tcs_sequence ) )
            // parser/TCS.g:598:683: (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2A0618333D11DFA3BADD40A9FE17A4");
            }
            // parser/TCS.g:598:742: (temp= tcs_sequence )
            // parser/TCS.g:598:744: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_functiontemplate3375);
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
              _beforeSeqEl("E0DCF6CDFF2C7710333D11DF996ADD40A9FE17A4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_functiontemplate3385); if (state.failed) return ret2;
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
    // parser/TCS.g:606:1: tcs_contexttags returns [Object ret2] : ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) ;
    public final Object tcs_contexttags() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ContextTags");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:611:3: ( ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) )
            // parser/TCS.g:612:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            {
            // parser/TCS.g:612:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            // parser/TCS.g:612:4: LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2C7716333D11DF9323DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_contexttags3430); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2C771B333D11DFA509DD40A9FE17A4");
            }
            // parser/TCS.g:612:146: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==NAME) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // parser/TCS.g:612:148: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_contexttags3438);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tags", temp);
                    }
                    // parser/TCS.g:612:198: ( ( COMA ) temp= identifier )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==COMA) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // parser/TCS.g:612:199: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:612:216: ( COMA )
                    	    // parser/TCS.g:612:217: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDFF2C7718333D11DF9AEADD40A9FE17A4");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_contexttags3447); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_tcs_contexttags3455);
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
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2EE810333D11DF9DDCDD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_contexttags3467); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:620:1: tcs_sequence__impl returns [Object ret2] : ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequence__impl() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Sequence");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:625:3: ( ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:626:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:626:3: ( (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:626:4: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF2EE815333D11DFAFE8DD40A9FE17A4");
            }
            // parser/TCS.g:626:63: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( ((LA67_0>=NAME && LA67_0<=STRING)||LA67_0==LPAREN||LA67_0==RARROW||LA67_0==LT||LA67_0==LSQUARE||LA67_0==DLSQUARE||(LA67_0>=DOLLAR && LA67_0<=DLCURLY)||(LA67_0>=49 && LA67_0<=134)) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // parser/TCS.g:626:65: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3512);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:626:128: (temp= tcs_sequenceelement )*
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( ((LA66_0>=NAME && LA66_0<=STRING)||LA66_0==LPAREN||LA66_0==RARROW||LA66_0==LT||LA66_0==LSQUARE||LA66_0==DLSQUARE||(LA66_0>=DOLLAR && LA66_0<=DLCURLY)||(LA66_0>=49 && LA66_0<=134)) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // parser/TCS.g:626:130: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3520);
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

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
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
    // $ANTLR end "tcs_sequence__impl"


    // $ANTLR start "tcs_sequence"
    // parser/TCS.g:634:1: tcs_sequence returns [Object ret2] : (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) ;
    public final Object tcs_sequence() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:635:3: ( (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) ) )
            // parser/TCS.g:636:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            {
            // parser/TCS.g:636:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )
            int alt68=2;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // parser/TCS.g:636:4: ret= tcs_sequence__impl
                    {
                    pushFollow(FOLLOW_tcs_sequence__impl_in_tcs_sequence3561);
                    ret=tcs_sequence__impl();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:636:27: (ret= tcs_sequenceinalternative )
                    {
                    // parser/TCS.g:636:27: (ret= tcs_sequenceinalternative )
                    // parser/TCS.g:636:28: ret= tcs_sequenceinalternative
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3566);
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
    // parser/TCS.g:643:1: tcs_sequenceelement returns [Object ret2] : (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) ;
    public final Object tcs_sequenceelement() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:644:3: ( (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock ) )
            // parser/TCS.g:645:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            {
            // parser/TCS.g:645:3: (ret= tcs_literalref | ret= tcs_property | ret= tcs_customseparator | ret= tcs_block | ret= tcs_conditionalelement | ret= tcs_alternative | ret= tcs_functioncall | ret= tcs_injectoractionsblock )
            int alt69=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt69=1;
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
                alt69=2;
                }
                break;
            case LT:
                {
                alt69=3;
                }
                break;
            case LSQUARE:
                {
                alt69=4;
                }
                break;
            case LPAREN:
                {
                alt69=5;
                }
                break;
            case DLSQUARE:
                {
                alt69=6;
                }
                break;
            case DOLLAR:
                {
                alt69=7;
                }
                break;
            case DLCURLY:
                {
                alt69=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // parser/TCS.g:645:4: ret= tcs_literalref
                    {
                    pushFollow(FOLLOW_tcs_literalref_in_tcs_sequenceelement3595);
                    ret=tcs_literalref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:646:5: ret= tcs_property
                    {
                    pushFollow(FOLLOW_tcs_property_in_tcs_sequenceelement3603);
                    ret=tcs_property();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:647:5: ret= tcs_customseparator
                    {
                    pushFollow(FOLLOW_tcs_customseparator_in_tcs_sequenceelement3611);
                    ret=tcs_customseparator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:648:5: ret= tcs_block
                    {
                    pushFollow(FOLLOW_tcs_block_in_tcs_sequenceelement3619);
                    ret=tcs_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:649:5: ret= tcs_conditionalelement
                    {
                    pushFollow(FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3627);
                    ret=tcs_conditionalelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:650:5: ret= tcs_alternative
                    {
                    pushFollow(FOLLOW_tcs_alternative_in_tcs_sequenceelement3635);
                    ret=tcs_alternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:651:5: ret= tcs_functioncall
                    {
                    pushFollow(FOLLOW_tcs_functioncall_in_tcs_sequenceelement3643);
                    ret=tcs_functioncall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:652:5: ret= tcs_injectoractionsblock
                    {
                    pushFollow(FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3651);
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
    // parser/TCS.g:659:1: tcs_literalref returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_literalref() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LiteralRef");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:664:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:665:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:665:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:665:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF385DF1333D11DFA1A3DD40A9FE17A4");
            }
            // parser/TCS.g:665:63: (temp= stringSymbol )
            // parser/TCS.g:665:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_literalref3685);
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
              _beforeSeqEl("E0DCF6CDFF3D18E0333D11DFB09BDD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:673:1: tcs_propertyreference returns [Object ret2] : ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) ;
    public final Object tcs_propertyreference() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PropertyReference");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:678:3: ( ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) ) )
            // parser/TCS.g:679:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            {
            // parser/TCS.g:679:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) ) )
            // parser/TCS.g:679:4: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4444D7333D11DFCA63DD40A9FE17A4");
            }
            // parser/TCS.g:679:64: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword )? ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==NAME||(LA71_0>=49 && LA71_0<=134)) ) {
                alt71=1;
            }
            else if ( (LA71_0==RARROW) ) {
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
                    // parser/TCS.g:679:65: ( (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:679:81: ( (temp= identifierOrKeyword ) )
                    // parser/TCS.g:679:82: (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4444D0333D11DF8160DD40A9FE17A4");
                    }
                    // parser/TCS.g:679:141: (temp= identifierOrKeyword )
                    // parser/TCS.g:679:143: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3741);
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
                    // parser/TCS.g:679:3487: ( RARROW (temp= identifierOrKeyword )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:679:3503: ( RARROW (temp= identifierOrKeyword )? )
                    // parser/TCS.g:679:3504: RARROW (temp= identifierOrKeyword )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4444D2333D11DF8084DD40A9FE17A4");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_tcs_propertyreference3757); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4444D5333D11DF931EDD40A9FE17A4");
                    }
                    // parser/TCS.g:679:3646: (temp= identifierOrKeyword )?
                    int alt70=2;
                    alt70 = dfa70.predict(input);
                    switch (alt70) {
                        case 1 :
                            // parser/TCS.g:679:3648: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_propertyreference3765);
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
    // parser/TCS.g:688:1: tcs_property returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_property() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Property");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:693:3: ( ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:694:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:694:3: ( (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | ) )
            // parser/TCS.g:694:4: (temp= tcs_propertyreference ) ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF46B5D1333D11DF9148DD40A9FE17A4");
            }
            // parser/TCS.g:694:63: (temp= tcs_propertyreference )
            // parser/TCS.g:694:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_property3820);
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
              _beforeSeqEl("E0DCF6CDFF46B5DD333D11DFA363DD40A9FE17A4");
            }
            // parser/TCS.g:694:215: ( ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY ) | )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==LCURLY) ) {
                alt74=1;
            }
            else if ( (LA74_0==EOF||(LA74_0>=NAME && LA74_0<=STRING)||(LA74_0>=LPAREN && LA74_0<=RPAREN)||(LA74_0>=RCURLY && LA74_0<=COMA)||LA74_0==LT||(LA74_0>=LSQUARE && LA74_0<=RSQUARE)||(LA74_0>=DLSQUARE && LA74_0<=DRSQUARE)||(LA74_0>=DOLLAR && LA74_0<=DLCURLY)||(LA74_0>=49 && LA74_0<=134)) ) {
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
                    // parser/TCS.g:694:216: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:694:232: ( LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY )
                    // parser/TCS.g:694:233: LCURLY (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF46B5D5333D11DF9B20DD40A9FE17A4");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_property3833); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF46B5DA333D11DFC749DD40A9FE17A4");
                    }
                    // parser/TCS.g:694:375: (temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )* )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==49||LA73_0==54||LA73_0==62||LA73_0==70||LA73_0==73||LA73_0==88||LA73_0==93||LA73_0==95||LA73_0==100||LA73_0==112||LA73_0==114||LA73_0==116||(LA73_0>=120 && LA73_0<=121)||LA73_0==129) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // parser/TCS.g:694:377: temp= tcs_propertyarg ( ( COMA ) temp= tcs_propertyarg )*
                            {
                            pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3841);
                            temp=tcs_propertyarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyArgs", temp);
                            }
                            // parser/TCS.g:694:440: ( ( COMA ) temp= tcs_propertyarg )*
                            loop72:
                            do {
                                int alt72=2;
                                int LA72_0 = input.LA(1);

                                if ( (LA72_0==COMA) ) {
                                    alt72=1;
                                }


                                switch (alt72) {
                            	case 1 :
                            	    // parser/TCS.g:694:441: ( COMA ) temp= tcs_propertyarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:694:458: ( COMA )
                            	    // parser/TCS.g:694:459: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDFF46B5D7333D11DFAAF5DD40A9FE17A4");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_property3850); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_propertyarg_in_tcs_property3858);
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
                      _beforeSeqEl("E0DCF6CDFF46B5DB333D11DFCAFCDD40A9FE17A4");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_property3870); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:694:743: 
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
              _beforeSeqEl("E0DCF6CDFF46B5E0333D11DFB7A4DD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:703:1: tcs_customseparator returns [Object ret2] : ( LT (temp= identifier ) GT ) ;
    public final Object tcs_customseparator() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CustomSeparator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:708:3: ( ( LT (temp= identifier ) GT ) )
            // parser/TCS.g:709:3: ( LT (temp= identifier ) GT )
            {
            // parser/TCS.g:709:3: ( LT (temp= identifier ) GT )
            // parser/TCS.g:709:4: LT (temp= identifier ) GT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF48FFC0333D11DF86E1DD40A9FE17A4");
            }
            match(input,LT,FOLLOW_LT_in_tcs_customseparator3928); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF48FFC2333D11DFC6A9DD40A9FE17A4");
            }
            // parser/TCS.g:709:142: (temp= identifier )
            // parser/TCS.g:709:144: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_customseparator3936);
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
              _beforeSeqEl("E0DCF6CDFF48FFC3333D11DF8C13DD40A9FE17A4");
            }
            match(input,GT,FOLLOW_GT_in_tcs_customseparator3943); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF48FFC6333D11DFCEB0DD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:717:1: tcs_block returns [Object ret2] : ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) ;
    public final Object tcs_block() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Block");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:722:3: ( ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) ) )
            // parser/TCS.g:723:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            {
            // parser/TCS.g:723:3: ( LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | ) )
            // parser/TCS.g:723:4: LSQUARE (temp= tcs_sequence ) RSQUARE ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4B70C0333D11DFADF5DD40A9FE17A4");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_block3988); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4B70C2333D11DFCD51DD40A9FE17A4");
            }
            // parser/TCS.g:723:147: (temp= tcs_sequence )
            // parser/TCS.g:723:149: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_block3996);
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
              _beforeSeqEl("E0DCF6CDFF4B70C3333D11DFA24CDD40A9FE17A4");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_block4003); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4B70CF333D11DFB13DDD40A9FE17A4");
            }
            // parser/TCS.g:723:370: ( ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY ) | )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==LCURLY) ) {
                alt77=1;
            }
            else if ( (LA77_0==EOF||(LA77_0>=NAME && LA77_0<=STRING)||(LA77_0>=LPAREN && LA77_0<=RPAREN)||(LA77_0>=RCURLY && LA77_0<=COMA)||LA77_0==LT||(LA77_0>=LSQUARE && LA77_0<=RSQUARE)||(LA77_0>=DLSQUARE && LA77_0<=DRSQUARE)||(LA77_0>=DOLLAR && LA77_0<=DLCURLY)||(LA77_0>=49 && LA77_0<=134)) ) {
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
                    // parser/TCS.g:723:371: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:723:387: ( LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY )
                    // parser/TCS.g:723:388: LCURLY (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4B70C7333D11DFB225DD40A9FE17A4");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_tcs_block4014); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4B70CC333D11DFB2A8DD40A9FE17A4");
                    }
                    // parser/TCS.g:723:530: (temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )* )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==67||LA76_0==99||(LA76_0>=110 && LA76_0<=111)||LA76_0==128) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // parser/TCS.g:723:532: temp= tcs_blockarg ( ( COMA ) temp= tcs_blockarg )*
                            {
                            pushFollow(FOLLOW_tcs_blockarg_in_tcs_block4022);
                            temp=tcs_blockarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "blockArgs", temp);
                            }
                            // parser/TCS.g:723:589: ( ( COMA ) temp= tcs_blockarg )*
                            loop75:
                            do {
                                int alt75=2;
                                int LA75_0 = input.LA(1);

                                if ( (LA75_0==COMA) ) {
                                    alt75=1;
                                }


                                switch (alt75) {
                            	case 1 :
                            	    // parser/TCS.g:723:590: ( COMA ) temp= tcs_blockarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:723:607: ( COMA )
                            	    // parser/TCS.g:723:608: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDFF4B70C9333D11DFAC28DD40A9FE17A4");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_block4031); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_blockarg_in_tcs_block4039);
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
                            	    break loop75;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4B70CD333D11DFAA3DDD40A9FE17A4");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_tcs_block4051); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:723:886: 
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
              _beforeSeqEl("E0DCF6CDFF4B70D2333D11DFCC3BDD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:732:1: tcs_conditionalelement returns [Object ret2] : ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) ;
    public final Object tcs_conditionalelement() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ConditionalElement");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:737:3: ( ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN ) )
            // parser/TCS.g:738:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            {
            // parser/TCS.g:738:3: ( LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN )
            // parser/TCS.g:738:4: LPAREN (temp= tcs_expression )? QMARK (temp= tcs_sequence ) ( ( COLON (temp= tcs_sequence ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4DBAB0333D11DFB6B7DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_conditionalelement4109); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4DBAB2333D11DFB9F0DD40A9FE17A4");
            }
            // parser/TCS.g:738:146: (temp= tcs_expression )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==NAME||LA78_0==RARROW||(LA78_0>=49 && LA78_0<=134)) ) {
                alt78=1;
            }
            else if ( (LA78_0==QMARK) ) {
                int LA78_2 = input.LA(2);

                if ( (synpred171_TCS()) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // parser/TCS.g:738:148: temp= tcs_expression
                    {
                    pushFollow(FOLLOW_tcs_expression_in_tcs_conditionalelement4117);
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
              _beforeSeqEl("E0DCF6CDFF4DBAB3333D11DFC101DD40A9FE17A4");
            }
            match(input,QMARK,FOLLOW_QMARK_in_tcs_conditionalelement4126); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4DBAB5333D11DF8C1EDD40A9FE17A4");
            }
            // parser/TCS.g:738:366: (temp= tcs_sequence )
            // parser/TCS.g:738:368: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement4134);
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
              _beforeSeqEl("E0DCF6CDFF4DBABD333D11DFBA6EDD40A9FE17A4");
            }
            // parser/TCS.g:738:504: ( ( COLON (temp= tcs_sequence ) ) | )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==COLON) ) {
                alt79=1;
            }
            else if ( (LA79_0==RPAREN) ) {
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
                    // parser/TCS.g:738:505: ( COLON (temp= tcs_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:738:521: ( COLON (temp= tcs_sequence ) )
                    // parser/TCS.g:738:522: COLON (temp= tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4DBAB9333D11DFAA2DDD40A9FE17A4");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_conditionalelement4147); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF4DBABB333D11DF95FDDD40A9FE17A4");
                    }
                    // parser/TCS.g:738:663: (temp= tcs_sequence )
                    // parser/TCS.g:738:665: temp= tcs_sequence
                    {
                    pushFollow(FOLLOW_tcs_sequence_in_tcs_conditionalelement4155);
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
                    // parser/TCS.g:738:759: 
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
              _beforeSeqEl("E0DCF6CDFF4DBABE333D11DFABA0DD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_conditionalelement4175); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF4DBAC1333D11DFA586DD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:747:1: tcs_alternative returns [Object ret2] : ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) ;
    public final Object tcs_alternative() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Alternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:752:3: ( ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) ) )
            // parser/TCS.g:753:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            {
            // parser/TCS.g:753:3: ( DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | ) )
            // parser/TCS.g:753:4: DLSQUARE (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )? DRSQUARE ( ( STAR ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF502BB0333D11DFB0BDDD40A9FE17A4");
            }
            match(input,DLSQUARE,FOLLOW_DLSQUARE_in_tcs_alternative4220); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF502BB5333D11DF8FABDD40A9FE17A4");
            }
            // parser/TCS.g:753:148: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( ((LA81_0>=NAME && LA81_0<=STRING)||LA81_0==LPAREN||LA81_0==RARROW||LA81_0==LT||LA81_0==LSQUARE||(LA81_0>=DLSQUARE && LA81_0<=PIPE)||(LA81_0>=DOLLAR && LA81_0<=DLCURLY)||(LA81_0>=49 && LA81_0<=134)) ) {
                alt81=1;
            }
            else if ( (LA81_0==DRSQUARE) ) {
                int LA81_2 = input.LA(2);

                if ( (synpred174_TCS()) ) {
                    alt81=1;
                }
            }
            switch (alt81) {
                case 1 :
                    // parser/TCS.g:753:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4228);
                    temp=tcs_sequenceinalternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "sequences", temp);
                    }
                    // parser/TCS.g:753:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==PIPE) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // parser/TCS.g:753:221: ( PIPE ) temp= tcs_sequenceinalternative
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:753:238: ( PIPE )
                    	    // parser/TCS.g:753:239: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDFF502BB2333D11DF8413DD40A9FE17A4");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_alternative4237); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4245);
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
                    	    break loop80;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF502BB6333D11DF9237DD40A9FE17A4");
            }
            match(input,DRSQUARE,FOLLOW_DRSQUARE_in_tcs_alternative4257); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF502BBC333D11DFA65CDD40A9FE17A4");
            }
            // parser/TCS.g:753:574: ( ( STAR ) | )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==STAR) ) {
                alt82=1;
            }
            else if ( (LA82_0==EOF||(LA82_0>=NAME && LA82_0<=STRING)||(LA82_0>=LPAREN && LA82_0<=RPAREN)||(LA82_0>=RCURLY && LA82_0<=COMA)||LA82_0==LT||(LA82_0>=LSQUARE && LA82_0<=RSQUARE)||(LA82_0>=DLSQUARE && LA82_0<=DRSQUARE)||(LA82_0>=DOLLAR && LA82_0<=DLCURLY)||(LA82_0>=49 && LA82_0<=134)) ) {
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
                    // parser/TCS.g:753:575: ( STAR )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:753:591: ( STAR )
                    // parser/TCS.g:753:592: STAR
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF502BBA333D11DF8A58DD40A9FE17A4");
                    }
                    match(input,STAR,FOLLOW_STAR_in_tcs_alternative4268); if (state.failed) return ret2;
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
                    // parser/TCS.g:753:745: 
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
              _beforeSeqEl("E0DCF6CDFF502BBF333D11DF8E76DD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:762:1: tcs_sequenceinalternative returns [Object ret2] : ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) ;
    public final Object tcs_sequenceinalternative() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SequenceInAlternative");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:767:3: ( ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? ) )
            // parser/TCS.g:768:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            {
            // parser/TCS.g:768:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )? )
            // parser/TCS.g:768:4: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF529CBA333D11DFAD83DD40A9FE17A4");
            }
            // parser/TCS.g:768:64: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==54) ) {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==LPAREN) ) {
                    int LA83_3 = input.LA(3);

                    if ( (LA83_3==NAME||LA83_3==RARROW||LA83_3==QMARK||(LA83_3>=49 && LA83_3<=134)) ) {
                        alt83=2;
                    }
                    else if ( (LA83_3==STRING) ) {
                        alt83=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 83, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA83_1==EOF||(LA83_1>=NAME && LA83_1<=STRING)||LA83_1==RPAREN||(LA83_1>=LCURLY && LA83_1<=COMA)||LA83_1==LT||(LA83_1>=LSQUARE && LA83_1<=RSQUARE)||(LA83_1>=DLSQUARE && LA83_1<=DRSQUARE)||(LA83_1>=DOLLAR && LA83_1<=DLCURLY)||(LA83_1>=49 && LA83_1<=134)) ) {
                    alt83=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA83_0==EOF||(LA83_0>=NAME && LA83_0<=STRING)||(LA83_0>=LPAREN && LA83_0<=RPAREN)||(LA83_0>=RCURLY && LA83_0<=COMA)||LA83_0==LT||(LA83_0>=LSQUARE && LA83_0<=RSQUARE)||(LA83_0>=DLSQUARE && LA83_0<=DRSQUARE)||(LA83_0>=DOLLAR && LA83_0<=DLCURLY)||(LA83_0>=49 && LA83_0<=53)||(LA83_0>=55 && LA83_0<=134)) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // parser/TCS.g:768:65: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:768:81: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    // parser/TCS.g:768:82: 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF529CB3333D11DFC90ADD40A9FE17A4");
                    }
                    match(input,54,FOLLOW_54_in_tcs_sequenceinalternative4333); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF529CB4333D11DFB425DD40A9FE17A4");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_tcs_sequenceinalternative4337); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF529CB7333D11DF823EDD40A9FE17A4");
                    }
                    // parser/TCS.g:768:313: (temp= stringSymbol )
                    // parser/TCS.g:768:315: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_sequenceinalternative4345);
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
                      _beforeSeqEl("E0DCF6CDFF529CB8333D11DF9F1CDD40A9FE17A4");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_tcs_sequenceinalternative4352); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:768:492: 
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
              _beforeSeqEl("E0DCF6CDFF529CBC333D11DF9804DD40A9FE17A4");
            }
            // parser/TCS.g:769:76: (temp= tcs_sequenceelement (temp= tcs_sequenceelement )* )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( ((LA85_0>=NAME && LA85_0<=STRING)||LA85_0==LPAREN||LA85_0==RARROW||LA85_0==LT||LA85_0==LSQUARE||LA85_0==DLSQUARE||(LA85_0>=DOLLAR && LA85_0<=DLCURLY)||(LA85_0>=49 && LA85_0<=134)) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // parser/TCS.g:769:78: temp= tcs_sequenceelement (temp= tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4373);
                    temp=tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // parser/TCS.g:769:141: (temp= tcs_sequenceelement )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( ((LA84_0>=NAME && LA84_0<=STRING)||LA84_0==LPAREN||LA84_0==RARROW||LA84_0==LT||LA84_0==LSQUARE||LA84_0==DLSQUARE||(LA84_0>=DOLLAR && LA84_0<=DLCURLY)||(LA84_0>=49 && LA84_0<=134)) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // parser/TCS.g:769:143: temp= tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4381);
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
                    	    break loop84;
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
    // parser/TCS.g:777:1: tcs_functioncall returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object tcs_functioncall() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FunctionCall");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:782:3: ( ( DOLLAR (temp= identifier ) ) )
            // parser/TCS.g:783:3: ( DOLLAR (temp= identifier ) )
            {
            // parser/TCS.g:783:3: ( DOLLAR (temp= identifier ) )
            // parser/TCS.g:783:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF54E6A0333D11DFAF99DD40A9FE17A4");
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_tcs_functioncall4430); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF54E6A3333D11DFC78ADD40A9FE17A4");
            }
            // parser/TCS.g:783:146: (temp= identifier )
            // parser/TCS.g:783:148: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_functioncall4438);
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
              _beforeSeqEl("E0DCF6CDFF54E6A6333D11DFC15BDD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:791:1: tcs_injectoractionsblock returns [Object ret2] : ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) ;
    public final Object tcs_injectoractionsblock() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InjectorActionsBlock");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:796:3: ( ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY ) )
            // parser/TCS.g:797:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            {
            // parser/TCS.g:797:3: ( DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY )
            // parser/TCS.g:797:4: DLCURLY (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )? DRCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF54E6AA333D11DF96B1DD40A9FE17A4");
            }
            match(input,DLCURLY,FOLLOW_DLCURLY_in_tcs_injectoractionsblock4485); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF54E6AF333D11DF9EE1DD40A9FE17A4");
            }
            // parser/TCS.g:797:147: (temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )* )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==NAME||LA87_0==RARROW||(LA87_0>=49 && LA87_0<=134)) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // parser/TCS.g:797:149: temp= tcs_injectoraction ( ( COMA ) temp= tcs_injectoraction )*
                    {
                    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4493);
                    temp=tcs_injectoraction();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "injectorActions", temp);
                    }
                    // parser/TCS.g:797:218: ( ( COMA ) temp= tcs_injectoraction )*
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==COMA) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // parser/TCS.g:797:219: ( COMA ) temp= tcs_injectoraction
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:797:236: ( COMA )
                    	    // parser/TCS.g:797:237: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDFF54E6AC333D11DF95B4DD40A9FE17A4");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_tcs_injectoractionsblock4502); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4510);
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
                    	    break loop86;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5757A0333D11DF89D9DD40A9FE17A4");
            }
            match(input,DRCURLY,FOLLOW_DRCURLY_in_tcs_injectoractionsblock4522); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5757A3333D11DFC612DD40A9FE17A4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:805:1: tcs_injectoraction returns [Object ret2] : (ret= tcs_propertyinit ) ;
    public final Object tcs_injectoraction() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:806:3: ( (ret= tcs_propertyinit ) )
            // parser/TCS.g:807:3: (ret= tcs_propertyinit )
            {
            // parser/TCS.g:807:3: (ret= tcs_propertyinit )
            // parser/TCS.g:807:4: ret= tcs_propertyinit
            {
            pushFollow(FOLLOW_tcs_propertyinit_in_tcs_injectoraction4563);
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
    // parser/TCS.g:814:1: tcs_propertyinit returns [Object ret2] : (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) ;
    public final Object tcs_propertyinit() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:815:3: ( (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit ) )
            // parser/TCS.g:816:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            {
            // parser/TCS.g:816:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )
            int alt88=3;
            alt88 = dfa88.predict(input);
            switch (alt88) {
                case 1 :
                    // parser/TCS.g:816:4: ret= tcs_primitivepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4590);
                    ret=tcs_primitivepropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:817:5: ret= tcs_lookuppropertyinit
                    {
                    pushFollow(FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4598);
                    ret=tcs_lookuppropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:818:5: ret= tcs_foreachpredicatepropertyinit
                    {
                    pushFollow(FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4606);
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
    // parser/TCS.g:825:1: tcs_primitivepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) ;
    public final Object tcs_primitivepropertyinit() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PrimitivePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:830:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) ) )
            // parser/TCS.g:831:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            {
            // parser/TCS.g:831:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier ) )
            // parser/TCS.g:831:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF59A193333D11DFCB84DD40A9FE17A4");
            }
            // parser/TCS.g:831:63: (temp= tcs_propertyreference )
            // parser/TCS.g:831:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4640);
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
              _beforeSeqEl("E0DCF6CDFF59A19B333D11DF9AD2DD40A9FE17A4");
            }
            // parser/TCS.g:831:215: ( ( LARROW ) | ( EQ ) )
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
                    // parser/TCS.g:831:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:831:232: ( LARROW )
                    // parser/TCS.g:831:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF59A197333D11DFC001DD40A9FE17A4");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_primitivepropertyinit4653); if (state.failed) return ret2;
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
                    // parser/TCS.g:831:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:831:406: ( EQ )
                    // parser/TCS.g:831:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF59A199333D11DF8C41DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_primitivepropertyinit4668); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDFF59A19D333D11DF939DDD40A9FE17A4");
            }
            // parser/TCS.g:832:76: (temp= identifier )
            // parser/TCS.g:832:78: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_primitivepropertyinit4683);
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
    // parser/TCS.g:840:1: tcs_lookuppropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) ;
    public final Object tcs_lookuppropertyinit() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookupPropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:845:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN ) )
            // parser/TCS.g:846:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            {
            // parser/TCS.g:846:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN )
            // parser/TCS.g:846:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5C1291333D11DFCD1ADD40A9FE17A4");
            }
            // parser/TCS.g:846:63: (temp= tcs_propertyreference )
            // parser/TCS.g:846:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4730);
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
              _beforeSeqEl("E0DCF6CDFF5C1299333D11DF8B1ADD40A9FE17A4");
            }
            // parser/TCS.g:846:215: ( ( LARROW ) | ( EQ ) )
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
                    // parser/TCS.g:846:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:846:232: ( LARROW )
                    // parser/TCS.g:846:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5C1295333D11DFB2BBDD40A9FE17A4");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_lookuppropertyinit4743); if (state.failed) return ret2;
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
                    // parser/TCS.g:846:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:846:406: ( EQ )
                    // parser/TCS.g:846:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5C1297333D11DF8CFDDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_lookuppropertyinit4758); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDFF5C129A333D11DF9016DD40A9FE17A4");
            }
            match(input,100,FOLLOW_100_in_tcs_lookuppropertyinit4769); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5C129B333D11DF9933DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_lookuppropertyinit4773); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5C129E333D11DFB4E2DD40A9FE17A4");
            }
            // parser/TCS.g:847:242: (temp= stringSymbol )
            // parser/TCS.g:847:244: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4781);
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
              _beforeSeqEl("E0DCF6CDFF5C129F333D11DFC982DD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_lookuppropertyinit4788); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:855:1: tcs_foreachpredicatepropertyinit returns [Object ret2] : ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) ;
    public final Object tcs_foreachpredicatepropertyinit() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForeachPredicatePropertyInit");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:860:3: ( ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN ) )
            // parser/TCS.g:861:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            {
            // parser/TCS.g:861:3: ( (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN )
            // parser/TCS.g:861:4: (temp= tcs_propertyreference ) ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol ) ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | ) ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5E8391333D11DFB30FDD40A9FE17A4");
            }
            // parser/TCS.g:861:63: (temp= tcs_propertyreference )
            // parser/TCS.g:861:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4833);
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
              _beforeSeqEl("E0DCF6CDFF5E8399333D11DFC6B6DD40A9FE17A4");
            }
            // parser/TCS.g:861:215: ( ( LARROW ) | ( EQ ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==LARROW) ) {
                alt91=1;
            }
            else if ( (LA91_0==EQ) ) {
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
                    // parser/TCS.g:861:216: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:861:232: ( LARROW )
                    // parser/TCS.g:861:233: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5E8395333D11DFC3AFDD40A9FE17A4");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4846); if (state.failed) return ret2;
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
                    // parser/TCS.g:861:390: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:861:406: ( EQ )
                    // parser/TCS.g:861:407: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5E8397333D11DFAE2ADD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4861); if (state.failed) return ret2;
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
              _beforeSeqEl("E0DCF6CDFF5E839A333D11DF996DDD40A9FE17A4");
            }
            match(input,94,FOLLOW_94_in_tcs_foreachpredicatepropertyinit4872); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5E839B333D11DFB377DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4876); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF5E839E333D11DFC1FDDD40A9FE17A4");
            }
            // parser/TCS.g:862:243: (temp= stringSymbol )
            // parser/TCS.g:862:245: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4884);
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
              _beforeSeqEl("E0DCF6CDFF60CD82333D11DFAA5BDD40A9FE17A4");
            }
            // parser/TCS.g:862:374: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) | )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==COMA) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==RPAREN||LA92_1==62||LA92_1==77) ) {
                    alt92=2;
                }
                else if ( (LA92_1==112) ) {
                    int LA92_3 = input.LA(3);

                    if ( (LA92_3==EQ) ) {
                        int LA92_4 = input.LA(4);

                        if ( (LA92_4==STRING) ) {
                            int LA92_5 = input.LA(5);

                            if ( (LA92_5==COMA) ) {
                                int LA92_6 = input.LA(6);

                                if ( (synpred186_TCS()) ) {
                                    alt92=1;
                                }
                                else if ( (true) ) {
                                    alt92=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ret2;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 92, 6, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA92_5==RPAREN) ) {
                                alt92=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 92, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 92, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 92, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 1, input);

                    throw nvae;
                }
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
                    // parser/TCS.g:862:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:862:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:862:392: COMA 'mode' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5E83A2333D11DFAD3EDD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4897); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5E83A3333D11DFA4A5DD40A9FE17A4");
                    }
                    match(input,112,FOLLOW_112_in_tcs_foreachpredicatepropertyinit4901); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF5E83A4333D11DF97E9DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4905); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF60CD80333D11DFCB8CDD40A9FE17A4");
                    }
                    // parser/TCS.g:862:692: (temp= stringSymbol )
                    // parser/TCS.g:862:694: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4913);
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
                    // parser/TCS.g:862:780: 
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
              _beforeSeqEl("E0DCF6CDFF60CD8D333D11DF870EDD40A9FE17A4");
            }
            // parser/TCS.g:863:77: ( ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? ) | )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==COMA) ) {
                alt95=1;
            }
            else if ( (LA95_0==RPAREN) ) {
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
                    // parser/TCS.g:863:78: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:863:94: ( COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )? )
                    // parser/TCS.g:863:95: COMA (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF60CD86333D11DF9C09DD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4939); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF60CD8B333D11DF8986DD40A9FE17A4");
                    }
                    // parser/TCS.g:863:235: (temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )* )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==62||LA94_0==77||LA94_0==112) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // parser/TCS.g:863:237: temp= tcs_predicatesemantic ( ( COMA ) temp= tcs_predicatesemantic )*
                            {
                            pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4947);
                            temp=tcs_predicatesemantic();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "predicatesemantic", temp);
                            }
                            // parser/TCS.g:863:311: ( ( COMA ) temp= tcs_predicatesemantic )*
                            loop93:
                            do {
                                int alt93=2;
                                int LA93_0 = input.LA(1);

                                if ( (LA93_0==COMA) ) {
                                    alt93=1;
                                }


                                switch (alt93) {
                            	case 1 :
                            	    // parser/TCS.g:863:312: ( COMA ) temp= tcs_predicatesemantic
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:863:329: ( COMA )
                            	    // parser/TCS.g:863:330: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDFF60CD88333D11DFB866DD40A9FE17A4");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4956); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4964);
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
                            	    break loop93;
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
                    // parser/TCS.g:863:542: 
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
              _beforeSeqEl("E0DCF6CDFF60CD8E333D11DFCF7CDD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4989); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:872:1: tcs_predicatesemantic returns [Object ret2] : ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) ;
    public final Object tcs_predicatesemantic() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","PredicateSemantic");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:877:3: ( ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) )
            // parser/TCS.g:878:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            {
            // parser/TCS.g:878:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            // parser/TCS.g:878:4: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF633E8A333D11DF9A4BDD40A9FE17A4");
            }
            // parser/TCS.g:878:64: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==77) ) {
                alt96=1;
            }
            else if ( (LA96_0==62||LA96_0==112) ) {
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
                    // parser/TCS.g:878:65: ( 'when' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:878:81: ( 'when' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:878:82: 'when' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF633E83333D11DF980DDD40A9FE17A4");
                    }
                    match(input,77,FOLLOW_77_in_tcs_predicatesemantic5036); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF633E84333D11DFA7DCDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic5040); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF633E87333D11DFA935DD40A9FE17A4");
                    }
                    // parser/TCS.g:878:301: (temp= stringSymbol )
                    // parser/TCS.g:878:303: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic5048);
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
                      _beforeSeqEl("E0DCF6CDFF633E88333D11DFC85ADD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic5055); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:878:470: 
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
              _beforeSeqEl("E0DCF6CDFF633E95333D11DFCDE1DD40A9FE17A4");
            }
            // parser/TCS.g:879:77: ( ( 'mode' EQ (temp= stringSymbol ) COMA ) | )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==112) ) {
                alt97=1;
            }
            else if ( (LA97_0==62) ) {
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
                    // parser/TCS.g:879:78: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:879:94: ( 'mode' EQ (temp= stringSymbol ) COMA )
                    // parser/TCS.g:879:95: 'mode' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF633E8E333D11DFA334DD40A9FE17A4");
                    }
                    match(input,112,FOLLOW_112_in_tcs_predicatesemantic5078); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF633E8F333D11DFC9F1DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic5082); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF633E92333D11DF9A26DD40A9FE17A4");
                    }
                    // parser/TCS.g:879:314: (temp= stringSymbol )
                    // parser/TCS.g:879:316: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_predicatesemantic5090);
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
                      _beforeSeqEl("E0DCF6CDFF633E93333D11DFB61BDD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_predicatesemantic5097); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // parser/TCS.g:879:483: 
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
              _beforeSeqEl("E0DCF6CDFF633E96333D11DFAB75DD40A9FE17A4");
            }
            match(input,62,FOLLOW_62_in_tcs_predicatesemantic5114); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF633E97333D11DFADDDDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_predicatesemantic5118); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF633E9C333D11DF87BFDD40A9FE17A4");
            }
            // parser/TCS.g:880:234: (temp= identifierOrKeyword )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==NAME||(LA98_0>=49 && LA98_0<=134)) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // parser/TCS.g:880:236: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic5126);
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
    // parser/TCS.g:888:1: tcs_propertyarg returns [Object ret2] : (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) ;
    public final Object tcs_propertyarg() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:889:3: ( (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg ) )
            // parser/TCS.g:890:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            {
            // parser/TCS.g:890:3: (ret= tcs_referstoparg | ret= tcs_lookinparg | ret= tcs_createinparg | ret= tcs_asparg | ret= tcs_separatorparg | ret= tcs_disambiguateparg | ret= tcs_autocreateparg | ret= tcs_importcontextparg | ret= tcs_partialparg | ret= tcs_forcedlowerparg | ret= tcs_forcedupperparg | ret= tcs_createasparg | ret= tcs_queryparg | ret= tcs_filterparg | ret= tcs_modeparg )
            int alt99=15;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt99=1;
                }
                break;
            case 100:
                {
                alt99=2;
                }
                break;
            case 114:
                {
                alt99=3;
                }
                break;
            case 62:
                {
                alt99=4;
                }
                break;
            case 116:
                {
                alt99=5;
                }
                break;
            case 54:
                {
                alt99=6;
                }
                break;
            case 93:
                {
                alt99=7;
                }
                break;
            case 120:
                {
                alt99=8;
                }
                break;
            case 49:
                {
                alt99=9;
                }
                break;
            case 73:
                {
                alt99=10;
                }
                break;
            case 95:
                {
                alt99=11;
                }
                break;
            case 70:
                {
                alt99=12;
                }
                break;
            case 88:
                {
                alt99=13;
                }
                break;
            case 129:
                {
                alt99=14;
                }
                break;
            case 112:
                {
                alt99=15;
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
                    // parser/TCS.g:890:4: ret= tcs_referstoparg
                    {
                    pushFollow(FOLLOW_tcs_referstoparg_in_tcs_propertyarg5168);
                    ret=tcs_referstoparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:891:5: ret= tcs_lookinparg
                    {
                    pushFollow(FOLLOW_tcs_lookinparg_in_tcs_propertyarg5176);
                    ret=tcs_lookinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:892:5: ret= tcs_createinparg
                    {
                    pushFollow(FOLLOW_tcs_createinparg_in_tcs_propertyarg5184);
                    ret=tcs_createinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:893:5: ret= tcs_asparg
                    {
                    pushFollow(FOLLOW_tcs_asparg_in_tcs_propertyarg5192);
                    ret=tcs_asparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:894:5: ret= tcs_separatorparg
                    {
                    pushFollow(FOLLOW_tcs_separatorparg_in_tcs_propertyarg5200);
                    ret=tcs_separatorparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // parser/TCS.g:895:5: ret= tcs_disambiguateparg
                    {
                    pushFollow(FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg5208);
                    ret=tcs_disambiguateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // parser/TCS.g:896:5: ret= tcs_autocreateparg
                    {
                    pushFollow(FOLLOW_tcs_autocreateparg_in_tcs_propertyarg5216);
                    ret=tcs_autocreateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // parser/TCS.g:897:5: ret= tcs_importcontextparg
                    {
                    pushFollow(FOLLOW_tcs_importcontextparg_in_tcs_propertyarg5224);
                    ret=tcs_importcontextparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // parser/TCS.g:898:5: ret= tcs_partialparg
                    {
                    pushFollow(FOLLOW_tcs_partialparg_in_tcs_propertyarg5232);
                    ret=tcs_partialparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // parser/TCS.g:899:5: ret= tcs_forcedlowerparg
                    {
                    pushFollow(FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg5240);
                    ret=tcs_forcedlowerparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // parser/TCS.g:900:5: ret= tcs_forcedupperparg
                    {
                    pushFollow(FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg5248);
                    ret=tcs_forcedupperparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 12 :
                    // parser/TCS.g:901:5: ret= tcs_createasparg
                    {
                    pushFollow(FOLLOW_tcs_createasparg_in_tcs_propertyarg5256);
                    ret=tcs_createasparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 13 :
                    // parser/TCS.g:902:5: ret= tcs_queryparg
                    {
                    pushFollow(FOLLOW_tcs_queryparg_in_tcs_propertyarg5264);
                    ret=tcs_queryparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 14 :
                    // parser/TCS.g:903:5: ret= tcs_filterparg
                    {
                    pushFollow(FOLLOW_tcs_filterparg_in_tcs_propertyarg5272);
                    ret=tcs_filterparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 15 :
                    // parser/TCS.g:904:5: ret= tcs_modeparg
                    {
                    pushFollow(FOLLOW_tcs_modeparg_in_tcs_propertyarg5280);
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
    // parser/TCS.g:911:1: tcs_referstoparg returns [Object ret2] : ( 'refersTo' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_referstoparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RefersToPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:916:3: ( ( 'refersTo' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:917:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:917:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:917:4: 'refersTo' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF658872333D11DF9BA6DD40A9FE17A4");
            }
            match(input,121,FOLLOW_121_in_tcs_referstoparg5310); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF658873333D11DF87FADD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_referstoparg5314); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF658876333D11DF8AC8DD40A9FE17A4");
            }
            // parser/TCS.g:917:227: (temp= identifierOrKeyword )
            // parser/TCS.g:917:229: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_referstoparg5322);
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
    // parser/TCS.g:925:1: tcs_lookinparg returns [Object ret2] : ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) ;
    public final Object tcs_lookinparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","LookInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:930:3: ( ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) ) )
            // parser/TCS.g:931:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            {
            // parser/TCS.g:931:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ) )
            // parser/TCS.g:931:4: 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF67F970333D11DF8944DD40A9FE17A4");
            }
            match(input,100,FOLLOW_100_in_tcs_lookinparg5365); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF67F971333D11DFC44EDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_lookinparg5369); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6A6A7B333D11DFCE7EDD40A9FE17A4");
            }
            // parser/TCS.g:931:226: ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==SHARP) ) {
                alt101=1;
            }
            else if ( (LA101_0==NAME||(LA101_0>=49 && LA101_0<=134)) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // parser/TCS.g:931:227: ( SHARP 'all' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:931:243: ( SHARP 'all' )
                    // parser/TCS.g:931:244: SHARP 'all'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF6A6A71333D11DFC386DD40A9FE17A4");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_tcs_lookinparg5380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF6A6A72333D11DF87F2DD40A9FE17A4");
                    }
                    match(input,78,FOLLOW_78_in_tcs_lookinparg5384); if (state.failed) return ret2;
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
                    // parser/TCS.g:931:479: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:931:495: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
                    // parser/TCS.g:931:496: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF6A6A79333D11DF8651DD40A9FE17A4");
                    }
                    // parser/TCS.g:931:555: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
                    // parser/TCS.g:931:557: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5401);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", temp);
                    }
                    // parser/TCS.g:931:624: ( ( POINT ) temp= identifierOrKeyword )*
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==POINT) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // parser/TCS.g:931:625: ( POINT ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:931:642: ( POINT )
                    	    // parser/TCS.g:931:643: POINT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDFF6A6A76333D11DFB9C9DD40A9FE17A4");
                    	    }
                    	    match(input,POINT,FOLLOW_POINT_in_tcs_lookinparg5410); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_lookinparg5418);
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
                    	    break loop100;
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
    // parser/TCS.g:940:1: tcs_createinparg returns [Object ret2] : ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createinparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateInPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:945:3: ( ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:946:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:946:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:946:4: 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6CB462333D11DF925FDD40A9FE17A4");
            }
            match(input,114,FOLLOW_114_in_tcs_createinparg5471); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6CB463333D11DFCB1EDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createinparg5475); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6CB469333D11DF9A45DD40A9FE17A4");
            }
            // parser/TCS.g:946:227: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )
            // parser/TCS.g:946:229: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5483);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
            }
            // parser/TCS.g:946:296: ( ( POINT ) temp= identifierOrKeyword )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==POINT) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // parser/TCS.g:946:297: ( POINT ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:946:314: ( POINT )
            	    // parser/TCS.g:946:315: POINT
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CDFF6CB466333D11DF9CE9DD40A9FE17A4");
            	    }
            	    match(input,POINT,FOLLOW_POINT_in_tcs_createinparg5492); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createinparg5500);
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
            	    break loop102;
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
    // parser/TCS.g:954:1: tcs_asparg returns [Object ret2] : ( 'as' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_asparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:959:3: ( ( 'as' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:960:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:960:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:960:4: 'as' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6F2562333D11DFC5B6DD40A9FE17A4");
            }
            match(input,62,FOLLOW_62_in_tcs_asparg5546); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6F2563333D11DFA036DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_asparg5550); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF6F2568333D11DFADBEDD40A9FE17A4");
            }
            // parser/TCS.g:960:221: (temp= identifierOrKeyword )
            // parser/TCS.g:960:223: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_asparg5558);
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
    // parser/TCS.g:968:1: tcs_separatorparg returns [Object ret2] : ( 'separator' EQ (temp= tcs_sequence ) ) ;
    public final Object tcs_separatorparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SeparatorPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:973:3: ( ( 'separator' EQ (temp= tcs_sequence ) ) )
            // parser/TCS.g:974:3: ( 'separator' EQ (temp= tcs_sequence ) )
            {
            // parser/TCS.g:974:3: ( 'separator' EQ (temp= tcs_sequence ) )
            // parser/TCS.g:974:4: 'separator' EQ (temp= tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF716F50333D11DFC134DD40A9FE17A4");
            }
            match(input,116,FOLLOW_116_in_tcs_separatorparg5601); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF716F51333D11DF94B3DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_separatorparg5605); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF716F53333D11DFA907DD40A9FE17A4");
            }
            // parser/TCS.g:974:228: (temp= tcs_sequence )
            // parser/TCS.g:974:230: temp= tcs_sequence
            {
            pushFollow(FOLLOW_tcs_sequence_in_tcs_separatorparg5613);
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
    // parser/TCS.g:982:1: tcs_disambiguateparg returns [Object ret2] : ( 'disambiguate' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_disambiguateparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","DisambiguatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:987:3: ( ( 'disambiguate' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:988:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:988:3: ( 'disambiguate' EQ (temp= stringSymbol ) )
            // parser/TCS.g:988:4: 'disambiguate' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF716F57333D11DFA54DDD40A9FE17A4");
            }
            match(input,54,FOLLOW_54_in_tcs_disambiguateparg5656); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF716F58333D11DF9ADEDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_disambiguateparg5660); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF716F5B333D11DF8EE1DD40A9FE17A4");
            }
            // parser/TCS.g:988:231: (temp= stringSymbol )
            // parser/TCS.g:988:233: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_disambiguateparg5668);
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
    // parser/TCS.g:996:1: tcs_autocreateparg returns [Object ret2] : ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) ;
    public final Object tcs_autocreateparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AutoCreatePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1001:3: ( ( 'autoCreate' EQ (temp= tcs_autocreatekind ) ) )
            // parser/TCS.g:1002:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            {
            // parser/TCS.g:1002:3: ( 'autoCreate' EQ (temp= tcs_autocreatekind ) )
            // parser/TCS.g:1002:4: 'autoCreate' EQ (temp= tcs_autocreatekind )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF73E050333D11DF8031DD40A9FE17A4");
            }
            match(input,93,FOLLOW_93_in_tcs_autocreateparg5711); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF73E051333D11DF878DDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_autocreateparg5715); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF73E053333D11DF8B08DD40A9FE17A4");
            }
            // parser/TCS.g:1002:229: (temp= tcs_autocreatekind )
            // parser/TCS.g:1002:231: temp= tcs_autocreatekind
            {
            pushFollow(FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5723);
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
    // parser/TCS.g:1010:1: tcs_autocreatekind returns [Object ret2] : ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) ;
    public final Object tcs_autocreatekind() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1011:3: ( ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) )
            // parser/TCS.g:1012:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            {
            // parser/TCS.g:1012:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            int alt103=3;
            switch ( input.LA(1) ) {
            case 125:
                {
                alt103=1;
                }
                break;
            case 115:
                {
                alt103=2;
                }
                break;
            case 122:
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
                    // parser/TCS.g:1012:4: ( 'always' )
                    {
                    // parser/TCS.g:1012:4: ( 'always' )
                    // parser/TCS.g:1012:5: 'always'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF765151333D11DFA9FFDD40A9FE17A4");
                    }
                    match(input,125,FOLLOW_125_in_tcs_autocreatekind5767); if (state.failed) return ret2;
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
                    // parser/TCS.g:1013:4: ( 'ifmissing' )
                    {
                    // parser/TCS.g:1013:4: ( 'ifmissing' )
                    // parser/TCS.g:1013:5: 'ifmissing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF789B41333D11DF97AFDD40A9FE17A4");
                    }
                    match(input,115,FOLLOW_115_in_tcs_autocreatekind5777); if (state.failed) return ret2;
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
                    // parser/TCS.g:1014:4: ( 'never' )
                    {
                    // parser/TCS.g:1014:4: ( 'never' )
                    // parser/TCS.g:1014:5: 'never'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF789B44333D11DF9FDBDD40A9FE17A4");
                    }
                    match(input,122,FOLLOW_122_in_tcs_autocreatekind5787); if (state.failed) return ret2;
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
    // parser/TCS.g:1021:1: tcs_importcontextparg returns [Object ret2] : ( 'importContext' ) ;
    public final Object tcs_importcontextparg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","ImportContextPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1026:3: ( ( 'importContext' ) )
            // parser/TCS.g:1027:3: ( 'importContext' )
            {
            // parser/TCS.g:1027:3: ( 'importContext' )
            // parser/TCS.g:1027:4: 'importContext'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF7D5630333D11DF936CDD40A9FE17A4");
            }
            match(input,120,FOLLOW_120_in_tcs_importcontextparg5818); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1035:1: tcs_partialparg returns [Object ret2] : ( 'partial' ) ;
    public final Object tcs_partialparg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","PartialPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1040:3: ( ( 'partial' ) )
            // parser/TCS.g:1041:3: ( 'partial' )
            {
            // parser/TCS.g:1041:3: ( 'partial' )
            // parser/TCS.g:1041:4: 'partial'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF7D5634333D11DFC5F9DD40A9FE17A4");
            }
            match(input,49,FOLLOW_49_in_tcs_partialparg5858); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1049:1: tcs_forcedlowerparg returns [Object ret2] : ( 'forcedLower' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedlowerparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedLowerPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1054:3: ( ( 'forcedLower' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1055:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1055:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1055:4: 'forcedLower' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF7FC730333D11DF9E6BDD40A9FE17A4");
            }
            match(input,73,FOLLOW_73_in_tcs_forcedlowerparg5898); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF7FC731333D11DF8211DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedlowerparg5902); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF7FC733333D11DFC4FADD40A9FE17A4");
            }
            // parser/TCS.g:1055:230: (temp= integerSymbol )
            // parser/TCS.g:1055:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedlowerparg5910);
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
    // parser/TCS.g:1063:1: tcs_forcedupperparg returns [Object ret2] : ( 'forcedUpper' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_forcedupperparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ForcedUpperPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1068:3: ( ( 'forcedUpper' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1069:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1069:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1069:4: 'forcedUpper' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF823830333D11DFCEB7DD40A9FE17A4");
            }
            match(input,95,FOLLOW_95_in_tcs_forcedupperparg5953); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF823831333D11DFC542DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_forcedupperparg5957); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF823833333D11DF90C8DD40A9FE17A4");
            }
            // parser/TCS.g:1069:230: (temp= integerSymbol )
            // parser/TCS.g:1069:232: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_forcedupperparg5965);
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
    // parser/TCS.g:1077:1: tcs_createasparg returns [Object ret2] : ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) ;
    public final Object tcs_createasparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","CreateAsPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1082:3: ( ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) ) )
            // parser/TCS.g:1083:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            {
            // parser/TCS.g:1083:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* ) )
            // parser/TCS.g:1083:4: 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF823837333D11DF9D5CDD40A9FE17A4");
            }
            match(input,70,FOLLOW_70_in_tcs_createasparg6008); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF823838333D11DFA5BDDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_createasparg6012); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF82383E333D11DFB437DD40A9FE17A4");
            }
            // parser/TCS.g:1083:227: (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )
            // parser/TCS.g:1083:229: temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )*
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg6020);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
            }
            // parser/TCS.g:1083:288: ( ( DLCOLON ) temp= identifierOrKeyword )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==DLCOLON) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // parser/TCS.g:1083:289: ( DLCOLON ) temp= identifierOrKeyword
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1083:306: ( DLCOLON )
            	    // parser/TCS.g:1083:307: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CDFF82383B333D11DFB336DD40A9FE17A4");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_createasparg6029); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifierOrKeyword_in_tcs_createasparg6037);
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
    // parser/TCS.g:1091:1: tcs_queryparg returns [Object ret2] : ( 'query' EQ (temp= stringSymbol ) ) ;
    public final Object tcs_queryparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","QueryPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1096:3: ( ( 'query' EQ (temp= stringSymbol ) ) )
            // parser/TCS.g:1097:3: ( 'query' EQ (temp= stringSymbol ) )
            {
            // parser/TCS.g:1097:3: ( 'query' EQ (temp= stringSymbol ) )
            // parser/TCS.g:1097:4: 'query' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF848220333D11DFA8B1DD40A9FE17A4");
            }
            match(input,88,FOLLOW_88_in_tcs_queryparg6083); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF848221333D11DF86B3DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_queryparg6087); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF848224333D11DFA07BDD40A9FE17A4");
            }
            // parser/TCS.g:1097:224: (temp= stringSymbol )
            // parser/TCS.g:1097:226: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_queryparg6095);
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
    // parser/TCS.g:1105:1: tcs_filterparg returns [Object ret2] : ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) ;
    public final Object tcs_filterparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","FilterPArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1110:3: ( ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) ) )
            // parser/TCS.g:1111:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            {
            // parser/TCS.g:1111:3: ( 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | ) )
            // parser/TCS.g:1111:4: 'filter' EQ (temp= stringSymbol ) ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF848228333D11DF83A0DD40A9FE17A4");
            }
            match(input,129,FOLLOW_129_in_tcs_filterparg6138); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF848229333D11DFAC97DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_filterparg6142); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF84822C333D11DFCC18DD40A9FE17A4");
            }
            // parser/TCS.g:1111:225: (temp= stringSymbol )
            // parser/TCS.g:1111:227: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg6150);
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
              _beforeSeqEl("E0DCF6CDFF86F32A333D11DFCA13DD40A9FE17A4");
            }
            // parser/TCS.g:1111:357: ( ( COMA 'invert' EQ (temp= stringSymbol ) ) | )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==COMA) ) {
                int LA105_1 = input.LA(2);

                if ( (LA105_1==49||LA105_1==54||LA105_1==62||LA105_1==70||LA105_1==73||LA105_1==88||LA105_1==93||LA105_1==95||LA105_1==100||LA105_1==112||LA105_1==114||LA105_1==116||(LA105_1>=120 && LA105_1<=121)||LA105_1==129) ) {
                    alt105=2;
                }
                else if ( (LA105_1==86) ) {
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
                    // parser/TCS.g:1111:358: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1111:374: ( COMA 'invert' EQ (temp= stringSymbol ) )
                    // parser/TCS.g:1111:375: COMA 'invert' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF86F323333D11DFAF6EDD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_filterparg6163); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF86F324333D11DFC692DD40A9FE17A4");
                    }
                    match(input,86,FOLLOW_86_in_tcs_filterparg6167); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF86F325333D11DF920BDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_filterparg6171); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF86F328333D11DFBA0DDD40A9FE17A4");
                    }
                    // parser/TCS.g:1111:677: (temp= stringSymbol )
                    // parser/TCS.g:1111:679: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_filterparg6179);
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
                    // parser/TCS.g:1111:767: 
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
    // parser/TCS.g:1120:1: tcs_modeparg returns [Object ret2] : ( 'mode' EQ (temp= identifierOrKeyword ) ) ;
    public final Object tcs_modeparg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ModePArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1125:3: ( ( 'mode' EQ (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1126:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1126:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            // parser/TCS.g:1126:4: 'mode' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF893D10333D11DFB3A5DD40A9FE17A4");
            }
            match(input,112,FOLLOW_112_in_tcs_modeparg6235); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF893D11333D11DFAC24DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_modeparg6239); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF893D14333D11DF914EDD40A9FE17A4");
            }
            // parser/TCS.g:1126:223: (temp= identifierOrKeyword )
            // parser/TCS.g:1126:225: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_modeparg6247);
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
    // parser/TCS.g:1134:1: tcs_blockarg returns [Object ret2] : (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) ;
    public final Object tcs_blockarg() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1135:3: ( (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg ) )
            // parser/TCS.g:1136:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            {
            // parser/TCS.g:1136:3: (ret= tcs_nbnlbarg | ret= tcs_indentincrbarg | ret= tcs_startnlbarg | ret= tcs_startnbnlbarg | ret= tcs_endnlbarg )
            int alt106=5;
            switch ( input.LA(1) ) {
            case 128:
                {
                alt106=1;
                }
                break;
            case 67:
                {
                alt106=2;
                }
                break;
            case 111:
                {
                alt106=3;
                }
                break;
            case 99:
                {
                alt106=4;
                }
                break;
            case 110:
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
                    // parser/TCS.g:1136:4: ret= tcs_nbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6287);
                    ret=tcs_nbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1137:5: ret= tcs_indentincrbarg
                    {
                    pushFollow(FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6295);
                    ret=tcs_indentincrbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1138:5: ret= tcs_startnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnlbarg_in_tcs_blockarg6303);
                    ret=tcs_startnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1139:5: ret= tcs_startnbnlbarg
                    {
                    pushFollow(FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6311);
                    ret=tcs_startnbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1140:5: ret= tcs_endnlbarg
                    {
                    pushFollow(FOLLOW_tcs_endnlbarg_in_tcs_blockarg6319);
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
    // parser/TCS.g:1147:1: tcs_nbnlbarg returns [Object ret2] : ( 'nbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_nbnlbarg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1152:3: ( ( 'nbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1153:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1153:3: ( 'nbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1153:4: 'nbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8BAE10333D11DF9221DD40A9FE17A4");
            }
            match(input,128,FOLLOW_128_in_tcs_nbnlbarg6349); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8BAE11333D11DFBB42DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_nbnlbarg6353); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8BAE13333D11DF8333DD40A9FE17A4");
            }
            // parser/TCS.g:1153:223: (temp= integerSymbol )
            // parser/TCS.g:1153:225: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_nbnlbarg6361);
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
    // parser/TCS.g:1161:1: tcs_indentincrbarg returns [Object ret2] : ( 'indentIncr' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_indentincrbarg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IndentIncrBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1166:3: ( ( 'indentIncr' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1167:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1167:3: ( 'indentIncr' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1167:4: 'indentIncr' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8BAE17333D11DFB000DD40A9FE17A4");
            }
            match(input,67,FOLLOW_67_in_tcs_indentincrbarg6404); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8BAE18333D11DFC158DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_indentincrbarg6408); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8BAE1A333D11DF9BF5DD40A9FE17A4");
            }
            // parser/TCS.g:1167:229: (temp= integerSymbol )
            // parser/TCS.g:1167:231: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_indentincrbarg6416);
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
    // parser/TCS.g:1175:1: tcs_startnlbarg returns [Object ret2] : ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_startnlbarg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","StartNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1180:3: ( ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1181:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1181:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1181:4: 'startNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8E1F10333D11DF938BDD40A9FE17A4");
            }
            match(input,111,FOLLOW_111_in_tcs_startnlbarg6459); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8E1F11333D11DF9EBCDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnlbarg6463); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF8E1F19333D11DF9DD7DD40A9FE17A4");
            }
            // parser/TCS.g:1181:227: ( ( 'true' ) | ( 'false' ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==83) ) {
                alt107=1;
            }
            else if ( (LA107_0==119) ) {
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
                    // parser/TCS.g:1181:228: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1181:244: ( 'true' )
                    // parser/TCS.g:1181:245: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF8E1F15333D11DFB44CDD40A9FE17A4");
                    }
                    match(input,83,FOLLOW_83_in_tcs_startnlbarg6473); if (state.failed) return ret2;
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
                    // parser/TCS.g:1181:396: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1181:412: ( 'false' )
                    // parser/TCS.g:1181:413: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF8E1F17333D11DFB9A9DD40A9FE17A4");
                    }
                    match(input,119,FOLLOW_119_in_tcs_startnlbarg6486); if (state.failed) return ret2;
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
    // parser/TCS.g:1190:1: tcs_startnbnlbarg returns [Object ret2] : ( 'startNbNL' EQ (temp= integerSymbol ) ) ;
    public final Object tcs_startnbnlbarg() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StartNbNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1195:3: ( ( 'startNbNL' EQ (temp= integerSymbol ) ) )
            // parser/TCS.g:1196:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            {
            // parser/TCS.g:1196:3: ( 'startNbNL' EQ (temp= integerSymbol ) )
            // parser/TCS.g:1196:4: 'startNbNL' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF906900333D11DFC994DD40A9FE17A4");
            }
            match(input,99,FOLLOW_99_in_tcs_startnbnlbarg6533); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF906901333D11DFBA29DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_startnbnlbarg6537); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF906903333D11DFB9D2DD40A9FE17A4");
            }
            // parser/TCS.g:1196:228: (temp= integerSymbol )
            // parser/TCS.g:1196:230: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_startnbnlbarg6545);
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
    // parser/TCS.g:1204:1: tcs_endnlbarg returns [Object ret2] : ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object tcs_endnlbarg() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","EndNLBArg");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1209:3: ( ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // parser/TCS.g:1210:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // parser/TCS.g:1210:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // parser/TCS.g:1210:4: 'endNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF906907333D11DFB1A5DD40A9FE17A4");
            }
            match(input,110,FOLLOW_110_in_tcs_endnlbarg6588); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF906908333D11DF9024DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endnlbarg6592); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF906910333D11DF8452DD40A9FE17A4");
            }
            // parser/TCS.g:1210:225: ( ( 'true' ) | ( 'false' ) )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==83) ) {
                alt108=1;
            }
            else if ( (LA108_0==119) ) {
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
                    // parser/TCS.g:1210:226: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1210:242: ( 'true' )
                    // parser/TCS.g:1210:243: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF90690C333D11DF9653DD40A9FE17A4");
                    }
                    match(input,83,FOLLOW_83_in_tcs_endnlbarg6602); if (state.failed) return ret2;
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
                    // parser/TCS.g:1210:394: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1210:410: ( 'false' )
                    // parser/TCS.g:1210:411: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF90690E333D11DF8F0DDD40A9FE17A4");
                    }
                    match(input,119,FOLLOW_119_in_tcs_endnlbarg6615); if (state.failed) return ret2;
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
    // parser/TCS.g:1219:1: tcs_symbol returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) ;
    public final Object tcs_symbol() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Symbol");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1224:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI ) )
            // parser/TCS.g:1225:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            {
            // parser/TCS.g:1225:3: ( (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI )
            // parser/TCS.g:1225:4: (temp= identifier )? EQ (temp= stringSymbol ) ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF92DA02333D11DF9371DD40A9FE17A4");
            }
            // parser/TCS.g:1225:63: (temp= identifier )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==NAME) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // parser/TCS.g:1225:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_symbol6666);
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
              _beforeSeqEl("E0DCF6CDFF92DA03333D11DF9FFBDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_symbol6675); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF92DA06333D11DF9328DD40A9FE17A4");
            }
            // parser/TCS.g:1225:271: (temp= stringSymbol )
            // parser/TCS.g:1225:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_symbol6683);
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
              _beforeSeqEl("E0DCF6CDFF92DA11333D11DF93F4DD40A9FE17A4");
            }
            // parser/TCS.g:1225:402: ( ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? ) | )
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
                    // parser/TCS.g:1225:403: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1225:419: ( COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )? )
                    // parser/TCS.g:1225:420: COLON (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF92DA0A333D11DFC6FEDD40A9FE17A4");
                    }
                    match(input,COLON,FOLLOW_COLON_in_tcs_symbol6696); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF92DA0F333D11DF81E2DD40A9FE17A4");
                    }
                    // parser/TCS.g:1225:561: (temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )* )?
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==79||LA111_0==87||LA111_0==104||LA111_0==106) ) {
                        alt111=1;
                    }
                    switch (alt111) {
                        case 1 :
                            // parser/TCS.g:1225:563: temp= tcs_spacekind ( ( COMA ) temp= tcs_spacekind )*
                            {
                            pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6704);
                            temp=tcs_spacekind();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "spaces", temp);
                            }
                            // parser/TCS.g:1225:618: ( ( COMA ) temp= tcs_spacekind )*
                            loop110:
                            do {
                                int alt110=2;
                                int LA110_0 = input.LA(1);

                                if ( (LA110_0==COMA) ) {
                                    alt110=1;
                                }


                                switch (alt110) {
                            	case 1 :
                            	    // parser/TCS.g:1225:619: ( COMA ) temp= tcs_spacekind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // parser/TCS.g:1225:636: ( COMA )
                            	    // parser/TCS.g:1225:637: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("E0DCF6CDFF92DA0C333D11DFA332DD40A9FE17A4");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_tcs_symbol6713); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_tcs_spacekind_in_tcs_symbol6721);
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
                    // parser/TCS.g:1225:830: 
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
              _beforeSeqEl("E0DCF6CDFF92DA12333D11DF86F0DD40A9FE17A4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_symbol6746); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1234:1: tcs_spacekind returns [Object ret2] : ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) ;
    public final Object tcs_spacekind() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1235:3: ( ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) )
            // parser/TCS.g:1236:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            {
            // parser/TCS.g:1236:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            int alt113=4;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt113=1;
                }
                break;
            case 87:
                {
                alt113=2;
                }
                break;
            case 106:
                {
                alt113=3;
                }
                break;
            case 79:
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
                    // parser/TCS.g:1236:4: ( 'leftSpace' )
                    {
                    // parser/TCS.g:1236:4: ( 'leftSpace' )
                    // parser/TCS.g:1236:5: 'leftSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9523F2333D11DF87FFDD40A9FE17A4");
                    }
                    match(input,104,FOLLOW_104_in_tcs_spacekind6788); if (state.failed) return ret2;
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
                    // parser/TCS.g:1237:4: ( 'leftNone' )
                    {
                    // parser/TCS.g:1237:4: ( 'leftNone' )
                    // parser/TCS.g:1237:5: 'leftNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9523F5333D11DF817FDD40A9FE17A4");
                    }
                    match(input,87,FOLLOW_87_in_tcs_spacekind6798); if (state.failed) return ret2;
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
                    // parser/TCS.g:1238:4: ( 'rightSpace' )
                    {
                    // parser/TCS.g:1238:4: ( 'rightSpace' )
                    // parser/TCS.g:1238:5: 'rightSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9523F8333D11DF8DD9DD40A9FE17A4");
                    }
                    match(input,106,FOLLOW_106_in_tcs_spacekind6808); if (state.failed) return ret2;
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
                    // parser/TCS.g:1239:4: ( 'rightNone' )
                    {
                    // parser/TCS.g:1239:4: ( 'rightNone' )
                    // parser/TCS.g:1239:5: 'rightNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9523FB333D11DF81FCDD40A9FE17A4");
                    }
                    match(input,79,FOLLOW_79_in_tcs_spacekind6818); if (state.failed) return ret2;
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
    // parser/TCS.g:1246:1: tcs_keyword returns [Object ret2] : ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) ;
    public final Object tcs_keyword() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Keyword");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1251:3: ( ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI ) )
            // parser/TCS.g:1252:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            {
            // parser/TCS.g:1252:3: ( (temp= identifier )? EQ (temp= stringSymbol ) SEMI )
            // parser/TCS.g:1252:4: (temp= identifier )? EQ (temp= stringSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9794F1333D11DF8605DD40A9FE17A4");
            }
            // parser/TCS.g:1252:63: (temp= identifier )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==NAME) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // parser/TCS.g:1252:65: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_keyword6853);
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
              _beforeSeqEl("E0DCF6CDFF9794F2333D11DFBFA5DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_keyword6862); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9794F5333D11DF926CDD40A9FE17A4");
            }
            // parser/TCS.g:1252:271: (temp= stringSymbol )
            // parser/TCS.g:1252:273: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_keyword6870);
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
              _beforeSeqEl("E0DCF6CDFF9794F6333D11DF9854DD40A9FE17A4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_keyword6877); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1260:1: tcs_operatorlist returns [Object ret2] : ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) ;
    public final Object tcs_operatorlist() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OperatorList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1265:3: ( ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY ) )
            // parser/TCS.g:1266:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1266:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY )
            // parser/TCS.g:1266:4: 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9794FA333D11DFA27EDD40A9FE17A4");
            }
            match(input,71,FOLLOW_71_in_tcs_operatorlist6918); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF979501333D11DFAA57DD40A9FE17A4");
            }
            // parser/TCS.g:1266:150: ( ( (temp= identifier ) ) | )
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
                    // parser/TCS.g:1266:151: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1266:167: ( (temp= identifier ) )
                    // parser/TCS.g:1266:168: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9794FF333D11DF815ADD40A9FE17A4");
                    }
                    // parser/TCS.g:1266:227: (temp= identifier )
                    // parser/TCS.g:1266:229: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operatorlist6931);
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
                    // parser/TCS.g:1266:313: 
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
              _beforeSeqEl("E0DCF6CDFF9A05F0333D11DFBD7BDD40A9FE17A4");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_operatorlist6951); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9A05F4333D11DFA2BDDD40A9FE17A4");
            }
            // parser/TCS.g:1267:159: ( ( (temp= tcs_priority (temp= tcs_priority )* )? ) )
            // parser/TCS.g:1267:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            {
            // parser/TCS.g:1267:160: ( (temp= tcs_priority (temp= tcs_priority )* )? )
            // parser/TCS.g:1267:161: (temp= tcs_priority (temp= tcs_priority )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9A05F2333D11DFB762DD40A9FE17A4");
            }
            // parser/TCS.g:1267:220: (temp= tcs_priority (temp= tcs_priority )* )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==52) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // parser/TCS.g:1267:222: temp= tcs_priority (temp= tcs_priority )*
                    {
                    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6962);
                    temp=tcs_priority();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "priorities", temp);
                    }
                    // parser/TCS.g:1267:280: (temp= tcs_priority )*
                    loop116:
                    do {
                        int alt116=2;
                        int LA116_0 = input.LA(1);

                        if ( (LA116_0==52) ) {
                            alt116=1;
                        }


                        switch (alt116) {
                    	case 1 :
                    	    // parser/TCS.g:1267:282: temp= tcs_priority
                    	    {
                    	    pushFollow(FOLLOW_tcs_priority_in_tcs_operatorlist6970);
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
              _beforeSeqEl("E0DCF6CDFF9A05F5333D11DFC60DDD40A9FE17A4");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_operatorlist6985); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1275:1: tcs_priority returns [Object ret2] : ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) ;
    public final Object tcs_priority() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Priority");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1280:3: ( ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY ) )
            // parser/TCS.g:1281:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            {
            // parser/TCS.g:1281:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY )
            // parser/TCS.g:1281:4: 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= tcs_associativity ) ) ) LCURLY ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9A05F9333D11DF8CCBDD40A9FE17A4");
            }
            match(input,52,FOLLOW_52_in_tcs_priority7026); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9A05FB333D11DFA046DD40A9FE17A4");
            }
            // parser/TCS.g:1281:148: (temp= integerSymbol )
            // parser/TCS.g:1281:150: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_priority7033);
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
              _beforeSeqEl("E0DCF6CDFF9A0605333D11DF9AC5DD40A9FE17A4");
            }
            // parser/TCS.g:1281:280: ( () | ( COMA (temp= tcs_associativity ) ) )
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
                    // parser/TCS.g:1281:281: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1281:297: ()
                    // parser/TCS.g:1281:298: 
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
                    // parser/TCS.g:1281:407: ( COMA (temp= tcs_associativity ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // parser/TCS.g:1281:423: ( COMA (temp= tcs_associativity ) )
                    // parser/TCS.g:1281:424: COMA (temp= tcs_associativity )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9A0601333D11DF8EAADD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_priority7056); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9A0603333D11DFC3F2DD40A9FE17A4");
                    }
                    // parser/TCS.g:1281:564: (temp= tcs_associativity )
                    // parser/TCS.g:1281:566: temp= tcs_associativity
                    {
                    pushFollow(FOLLOW_tcs_associativity_in_tcs_priority7064);
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
              _beforeSeqEl("E0DCF6CDFF9A0606333D11DFA785DD40A9FE17A4");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_tcs_priority7078); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9A060A333D11DFB191DD40A9FE17A4");
            }
            // parser/TCS.g:1282:159: ( ( (temp= tcs_operator (temp= tcs_operator )* )? ) )
            // parser/TCS.g:1282:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            {
            // parser/TCS.g:1282:160: ( (temp= tcs_operator (temp= tcs_operator )* )? )
            // parser/TCS.g:1282:161: (temp= tcs_operator (temp= tcs_operator )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9A0608333D11DF8C7EDD40A9FE17A4");
            }
            // parser/TCS.g:1282:220: (temp= tcs_operator (temp= tcs_operator )* )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==NAME||LA120_0==EQ||LA120_0==124) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // parser/TCS.g:1282:222: temp= tcs_operator (temp= tcs_operator )*
                    {
                    pushFollow(FOLLOW_tcs_operator_in_tcs_priority7089);
                    temp=tcs_operator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operators", temp);
                    }
                    // parser/TCS.g:1282:279: (temp= tcs_operator )*
                    loop119:
                    do {
                        int alt119=2;
                        int LA119_0 = input.LA(1);

                        if ( (LA119_0==NAME||LA119_0==EQ||LA119_0==124) ) {
                            alt119=1;
                        }


                        switch (alt119) {
                    	case 1 :
                    	    // parser/TCS.g:1282:281: temp= tcs_operator
                    	    {
                    	    pushFollow(FOLLOW_tcs_operator_in_tcs_priority7097);
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
              _beforeSeqEl("E0DCF6CDFF9A060B333D11DFB594DD40A9FE17A4");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_tcs_priority7112); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1290:1: tcs_operator returns [Object ret2] : ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) ;
    public final Object tcs_operator() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Operator");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1295:3: ( ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) )
            // parser/TCS.g:1296:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            {
            // parser/TCS.g:1296:3: ( ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            // parser/TCS.g:1296:4: ( ( 'postfix' ) | ) (temp= identifier )? EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFF9C4FE5333D11DF929EDD40A9FE17A4");
            }
            // parser/TCS.g:1296:64: ( ( 'postfix' ) | )
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==124) ) {
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
                    // parser/TCS.g:1296:65: ( 'postfix' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1296:81: ( 'postfix' )
                    // parser/TCS.g:1296:82: 'postfix'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9C4FE3333D11DFA456DD40A9FE17A4");
                    }
                    match(input,124,FOLLOW_124_in_tcs_operator7159); if (state.failed) return ret2;
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
                    // parser/TCS.g:1296:240: 
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
              _beforeSeqEl("E0DCF6CDFF9C4FE7333D11DFBB16DD40A9FE17A4");
            }
            // parser/TCS.g:1297:76: (temp= identifier )?
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==NAME) ) {
                alt122=1;
            }
            switch (alt122) {
                case 1 :
                    // parser/TCS.g:1297:78: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_operator7181);
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
              _beforeSeqEl("E0DCF6CDFF9C4FE8333D11DF8278DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_operator7190); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFA10AD1333D11DF8962DD40A9FE17A4");
            }
            // parser/TCS.g:1297:285: ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | )
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
                    // parser/TCS.g:1297:286: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1297:302: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    // parser/TCS.g:1297:303: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFF9EC0E9333D11DFBCB0DD40A9FE17A4");
                    }
                    // parser/TCS.g:1297:362: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
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
                            // parser/TCS.g:1297:363: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1297:379: ( (temp= identifier ) )
                            // parser/TCS.g:1297:380: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF9C4FEE333D11DFCAECDD40A9FE17A4");
                            }
                            // parser/TCS.g:1297:439: (temp= identifier )
                            // parser/TCS.g:1297:441: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_tcs_operator7209);
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
                            // parser/TCS.g:1298:4: ( (temp= stringSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // parser/TCS.g:1298:20: ( (temp= stringSymbol ) )
                            // parser/TCS.g:1298:21: (temp= stringSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFF9EC0E7333D11DFA082DD40A9FE17A4");
                            }
                            // parser/TCS.g:1298:80: (temp= stringSymbol )
                            // parser/TCS.g:1298:82: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_tcs_operator7229);
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
                    // parser/TCS.g:1298:287: 
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
              _beforeSeqEl("E0DCF6CDFFA10AD2333D11DFA9D9DD40A9FE17A4");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_operator7254); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFA10AD4333D11DFB975DD40A9FE17A4");
            }
            // parser/TCS.g:1299:157: (temp= integerSymbol )
            // parser/TCS.g:1299:159: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_operator7262);
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
              _beforeSeqEl("E0DCF6CDFFA10AD5333D11DFBD14DD40A9FE17A4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_operator7269); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1307:1: tcs_associativity returns [Object ret2] : ( ( 'left' ) | ( 'right' ) ) ;
    public final Object tcs_associativity() throws RecognitionException {

        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // parser/TCS.g:1308:3: ( ( ( 'left' ) | ( 'right' ) ) )
            // parser/TCS.g:1309:3: ( ( 'left' ) | ( 'right' ) )
            {
            // parser/TCS.g:1309:3: ( ( 'left' ) | ( 'right' ) )
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==97) ) {
                alt125=1;
            }
            else if ( (LA125_0==75) ) {
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
                    // parser/TCS.g:1309:4: ( 'left' )
                    {
                    // parser/TCS.g:1309:4: ( 'left' )
                    // parser/TCS.g:1309:5: 'left'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFA37BD3333D11DFA6DDDD40A9FE17A4");
                    }
                    match(input,97,FOLLOW_97_in_tcs_associativity7311); if (state.failed) return ret2;
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
                    // parser/TCS.g:1310:4: ( 'right' )
                    {
                    // parser/TCS.g:1310:4: ( 'right' )
                    // parser/TCS.g:1310:5: 'right'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFA37BD6333D11DF9F43DD40A9FE17A4");
                    }
                    match(input,75,FOLLOW_75_in_tcs_associativity7321); if (state.failed) return ret2;
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
    // parser/TCS.g:1317:1: tcs_expression returns [Object ret2] : (ret= tcs_andexp ) ;
    public final Object tcs_expression() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1318:3: ( (ret= tcs_andexp ) )
            // parser/TCS.g:1319:3: (ret= tcs_andexp )
            {
            // parser/TCS.g:1319:3: (ret= tcs_andexp )
            // parser/TCS.g:1319:4: ret= tcs_andexp
            {
            pushFollow(FOLLOW_tcs_andexp_in_tcs_expression7349);
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
    // parser/TCS.g:1326:1: tcs_andexp returns [Object ret2] : ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) ;
    public final Object tcs_andexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","AndExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1331:3: ( ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? ) )
            // parser/TCS.g:1332:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            {
            // parser/TCS.g:1332:3: ( (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )? )
            // parser/TCS.g:1332:4: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFA5ECD6333D11DFA3EEDD40A9FE17A4");
            }
            // parser/TCS.g:1332:63: (temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )* )?
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==NAME||LA127_0==RARROW||(LA127_0>=49 && LA127_0<=134)) ) {
                alt127=1;
            }
            switch (alt127) {
                case 1 :
                    // parser/TCS.g:1332:65: temp= tcs_atomexp ( ( 'and' ) temp= tcs_atomexp )*
                    {
                    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7383);
                    temp=tcs_atomexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "expressions", temp);
                    }
                    // parser/TCS.g:1332:123: ( ( 'and' ) temp= tcs_atomexp )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==92) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // parser/TCS.g:1332:124: ( 'and' ) temp= tcs_atomexp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1332:141: ( 'and' )
                    	    // parser/TCS.g:1332:142: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDFFA5ECD3333D11DF8E12DD40A9FE17A4");
                    	    }
                    	    match(input,92,FOLLOW_92_in_tcs_andexp7391); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_atomexp_in_tcs_andexp7398);
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
    // parser/TCS.g:1340:1: tcs_atomexp returns [Object ret2] : (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) ;
    public final Object tcs_atomexp() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1341:3: ( (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp ) )
            // parser/TCS.g:1342:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            {
            // parser/TCS.g:1342:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )
            int alt128=5;
            alt128 = dfa128.predict(input);
            switch (alt128) {
                case 1 :
                    // parser/TCS.g:1342:4: ret= tcs_equalsexp
                    {
                    pushFollow(FOLLOW_tcs_equalsexp_in_tcs_atomexp7443);
                    ret=tcs_equalsexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1343:5: ret= tcs_booleanpropertyexp
                    {
                    pushFollow(FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7451);
                    ret=tcs_booleanpropertyexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1344:5: ret= tcs_isdefinedexp
                    {
                    pushFollow(FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7459);
                    ret=tcs_isdefinedexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1345:5: ret= tcs_oneexp
                    {
                    pushFollow(FOLLOW_tcs_oneexp_in_tcs_atomexp7467);
                    ret=tcs_oneexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // parser/TCS.g:1346:5: ret= tcs_instanceofexp
                    {
                    pushFollow(FOLLOW_tcs_instanceofexp_in_tcs_atomexp7475);
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
    // parser/TCS.g:1353:1: tcs_equalsexp returns [Object ret2] : ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) ;
    public final Object tcs_equalsexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EqualsExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1358:3: ( ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) ) )
            // parser/TCS.g:1359:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            {
            // parser/TCS.g:1359:3: ( (temp= tcs_propertyreference ) EQ (temp= tcs_value ) )
            // parser/TCS.g:1359:4: (temp= tcs_propertyreference ) EQ (temp= tcs_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFA836C3333D11DF9469DD40A9FE17A4");
            }
            // parser/TCS.g:1359:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1359:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_equalsexp7509);
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
              _beforeSeqEl("E0DCF6CDFFA836C4333D11DF9140DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_equalsexp7516); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFA836C6333D11DFB983DD40A9FE17A4");
            }
            // parser/TCS.g:1359:293: (temp= tcs_value )
            // parser/TCS.g:1359:295: temp= tcs_value
            {
            pushFollow(FOLLOW_tcs_value_in_tcs_equalsexp7524);
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
    // parser/TCS.g:1367:1: tcs_booleanpropertyexp returns [Object ret2] : ( (temp= tcs_propertyreference ) ) ;
    public final Object tcs_booleanpropertyexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","BooleanPropertyExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1372:3: ( ( (temp= tcs_propertyreference ) ) )
            // parser/TCS.g:1373:3: ( (temp= tcs_propertyreference ) )
            {
            // parser/TCS.g:1373:3: ( (temp= tcs_propertyreference ) )
            // parser/TCS.g:1373:4: (temp= tcs_propertyreference )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFAAA7C1333D11DFB535DD40A9FE17A4");
            }
            // parser/TCS.g:1373:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1373:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7571);
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
    // parser/TCS.g:1381:1: tcs_isdefinedexp returns [Object ret2] : ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_isdefinedexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IsDefinedExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1386:3: ( ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1387:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1387:3: ( 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1387:4: 'isDefined' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFAAA7C5333D11DF84B3DD40A9FE17A4");
            }
            match(input,118,FOLLOW_118_in_tcs_isdefinedexp7614); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFAAA7C6333D11DFC1D7DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_isdefinedexp7618); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFAAA7C8333D11DFA3CDDD40A9FE17A4");
            }
            // parser/TCS.g:1387:232: (temp= tcs_propertyreference )
            // parser/TCS.g:1387:234: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7626);
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
              _beforeSeqEl("E0DCF6CDFFAAA7C9333D11DFC83ADD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_isdefinedexp7633); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1395:1: tcs_oneexp returns [Object ret2] : ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) ;
    public final Object tcs_oneexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OneExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1400:3: ( ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN ) )
            // parser/TCS.g:1401:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            {
            // parser/TCS.g:1401:3: ( 'one' LPAREN (temp= tcs_propertyreference ) RPAREN )
            // parser/TCS.g:1401:4: 'one' LPAREN (temp= tcs_propertyreference ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFACF1B0333D11DFC940DD40A9FE17A4");
            }
            match(input,102,FOLLOW_102_in_tcs_oneexp7674); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFACF1B1333D11DFA7FBDD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_oneexp7678); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFACF1B3333D11DFA46FDD40A9FE17A4");
            }
            // parser/TCS.g:1401:226: (temp= tcs_propertyreference )
            // parser/TCS.g:1401:228: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_oneexp7686);
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
              _beforeSeqEl("E0DCF6CDFFACF1B4333D11DFB39DDD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_oneexp7693); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1409:1: tcs_instanceofexp returns [Object ret2] : ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ;
    public final Object tcs_instanceofexp() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","InstanceOfExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1414:3: ( ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) )
            // parser/TCS.g:1415:3: ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            {
            // parser/TCS.g:1415:3: ( (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
            // parser/TCS.g:1415:4: (temp= tcs_propertyreference ) 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFACF1B9333D11DF8D6EDD40A9FE17A4");
            }
            // parser/TCS.g:1415:63: (temp= tcs_propertyreference )
            // parser/TCS.g:1415:65: temp= tcs_propertyreference
            {
            pushFollow(FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7738);
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
              _beforeSeqEl("E0DCF6CDFFACF1BA333D11DF982EDD40A9FE17A4");
            }
            match(input,76,FOLLOW_76_in_tcs_instanceofexp7744); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFACF1BF333D11DF8558DD40A9FE17A4");
            }
            // parser/TCS.g:1415:301: (temp= identifier ( ( DLCOLON ) temp= identifier )* )
            // parser/TCS.g:1415:303: temp= identifier ( ( DLCOLON ) temp= identifier )*
            {
            pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7751);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "supertype", temp);
            }
            // parser/TCS.g:1415:358: ( ( DLCOLON ) temp= identifier )*
            loop129:
            do {
                int alt129=2;
                int LA129_0 = input.LA(1);

                if ( (LA129_0==DLCOLON) ) {
                    alt129=1;
                }


                switch (alt129) {
            	case 1 :
            	    // parser/TCS.g:1415:359: ( DLCOLON ) temp= identifier
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // parser/TCS.g:1415:376: ( DLCOLON )
            	    // parser/TCS.g:1415:377: DLCOLON
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("E0DCF6CDFFACF1BC333D11DFB27DDD40A9FE17A4");
            	    }
            	    match(input,DLCOLON,FOLLOW_DLCOLON_in_tcs_instanceofexp7760); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_identifier_in_tcs_instanceofexp7768);
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
            	    break loop129;
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
    // parser/TCS.g:1423:1: tcs_value returns [Object ret2] : (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) ;
    public final Object tcs_value() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1424:3: ( (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval ) )
            // parser/TCS.g:1425:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            {
            // parser/TCS.g:1425:3: (ret= tcs_stringval | ret= tcs_integerval | ret= tcs_negativeintegerval | ret= tcs_enumliteralval )
            int alt130=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt130=1;
                }
                break;
            case INT:
                {
                alt130=2;
                }
                break;
            case MINUS:
                {
                alt130=3;
                }
                break;
            case SHARP:
                {
                alt130=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // parser/TCS.g:1425:4: ret= tcs_stringval
                    {
                    pushFollow(FOLLOW_tcs_stringval_in_tcs_value7811);
                    ret=tcs_stringval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1426:5: ret= tcs_integerval
                    {
                    pushFollow(FOLLOW_tcs_integerval_in_tcs_value7819);
                    ret=tcs_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1427:5: ret= tcs_negativeintegerval
                    {
                    pushFollow(FOLLOW_tcs_negativeintegerval_in_tcs_value7827);
                    ret=tcs_negativeintegerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1428:5: ret= tcs_enumliteralval
                    {
                    pushFollow(FOLLOW_tcs_enumliteralval_in_tcs_value7835);
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
    // parser/TCS.g:1435:1: tcs_stringval returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object tcs_stringval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1440:3: ( ( (temp= stringSymbol ) ) )
            // parser/TCS.g:1441:3: ( (temp= stringSymbol ) )
            {
            // parser/TCS.g:1441:3: ( (temp= stringSymbol ) )
            // parser/TCS.g:1441:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFAF62B6333D11DF90D0DD40A9FE17A4");
            }
            // parser/TCS.g:1441:63: (temp= stringSymbol )
            // parser/TCS.g:1441:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_tcs_stringval7869);
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
    // parser/TCS.g:1449:1: tcs_integerval returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final Object tcs_integerval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","IntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1454:3: ( ( (temp= integerSymbol ) ) )
            // parser/TCS.g:1455:3: ( (temp= integerSymbol ) )
            {
            // parser/TCS.g:1455:3: ( (temp= integerSymbol ) )
            // parser/TCS.g:1455:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB1D3B1333D11DF91F4DD40A9FE17A4");
            }
            // parser/TCS.g:1455:63: (temp= integerSymbol )
            // parser/TCS.g:1455:65: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_integerval7916);
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
    // parser/TCS.g:1463:1: tcs_negativeintegerval returns [Object ret2] : ( MINUS (temp= integerSymbol ) ) ;
    public final Object tcs_negativeintegerval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","NegativeIntegerVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1468:3: ( ( MINUS (temp= integerSymbol ) ) )
            // parser/TCS.g:1469:3: ( MINUS (temp= integerSymbol ) )
            {
            // parser/TCS.g:1469:3: ( MINUS (temp= integerSymbol ) )
            // parser/TCS.g:1469:4: MINUS (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB1D3B5333D11DFC710DD40A9FE17A4");
            }
            match(input,MINUS,FOLLOW_MINUS_in_tcs_negativeintegerval7960); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB1D3B7333D11DFCA8CDD40A9FE17A4");
            }
            // parser/TCS.g:1469:145: (temp= integerSymbol )
            // parser/TCS.g:1469:147: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_tcs_negativeintegerval7968);
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
    // parser/TCS.g:1477:1: tcs_enumliteralval returns [Object ret2] : ( SHARP (temp= identifierOrKeyword ) ) ;
    public final Object tcs_enumliteralval() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EnumLiteralVal");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1482:3: ( ( SHARP (temp= identifierOrKeyword ) ) )
            // parser/TCS.g:1483:3: ( SHARP (temp= identifierOrKeyword ) )
            {
            // parser/TCS.g:1483:3: ( SHARP (temp= identifierOrKeyword ) )
            // parser/TCS.g:1483:4: SHARP (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB41DA0333D11DFAD34DD40A9FE17A4");
            }
            match(input,SHARP,FOLLOW_SHARP_in_tcs_enumliteralval8012); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB41DA3333D11DFAE8FDD40A9FE17A4");
            }
            // parser/TCS.g:1483:145: (temp= identifierOrKeyword )
            // parser/TCS.g:1483:147: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_tcs_enumliteralval8020);
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
    // parser/TCS.g:1491:1: tcs_token returns [Object ret2] : ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) ;
    public final Object tcs_token() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","Token");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1496:3: ( ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI ) )
            // parser/TCS.g:1497:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            {
            // parser/TCS.g:1497:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI )
            // parser/TCS.g:1497:4: ( ( 'omitted' ) | ) 'token' (temp= identifier )? COLON (temp= tcs_orpattern ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB41DAC333D11DFC8C2DD40A9FE17A4");
            }
            // parser/TCS.g:1497:64: ( ( 'omitted' ) | )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==51) ) {
                alt131=1;
            }
            else if ( (LA131_0==57) ) {
                alt131=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // parser/TCS.g:1497:65: ( 'omitted' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1497:81: ( 'omitted' )
                    // parser/TCS.g:1497:82: 'omitted'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFB41DAA333D11DF8E6EDD40A9FE17A4");
                    }
                    match(input,51,FOLLOW_51_in_tcs_token8069); if (state.failed) return ret2;
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
                    // parser/TCS.g:1497:240: 
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
              _beforeSeqEl("E0DCF6CDFFB41DAD333D11DF8216DD40A9FE17A4");
            }
            match(input,57,FOLLOW_57_in_tcs_token8087); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB68EA0333D11DFB596DD40A9FE17A4");
            }
            // parser/TCS.g:1498:158: (temp= identifier )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==NAME) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // parser/TCS.g:1498:160: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_token8094);
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
              _beforeSeqEl("E0DCF6CDFFB68EA1333D11DFA236DD40A9FE17A4");
            }
            match(input,COLON,FOLLOW_COLON_in_tcs_token8103); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB68EA3333D11DFC36DDD40A9FE17A4");
            }
            // parser/TCS.g:1498:369: (temp= tcs_orpattern )
            // parser/TCS.g:1498:371: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_token8111);
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
              _beforeSeqEl("E0DCF6CDFFB68EA4333D11DFA22FDD40A9FE17A4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_tcs_token8118); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1506:1: tcs_orpattern returns [Object ret2] : ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) ;
    public final Object tcs_orpattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","OrPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1511:3: ( ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? ) )
            // parser/TCS.g:1512:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            {
            // parser/TCS.g:1512:3: ( (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )? )
            // parser/TCS.g:1512:4: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB68EAC333D11DF9743DD40A9FE17A4");
            }
            // parser/TCS.g:1512:63: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )?
            int alt134=2;
            switch ( input.LA(1) ) {
                case STRING:
                case LSQUARE:
                case PIPE:
                case 59:
                case 85:
                case 103:
                    {
                    alt134=1;
                    }
                    break;
                case SEMI:
                    {
                    int LA134_2 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt134=1;
                    }
                    }
                    break;
                case COMA:
                    {
                    int LA134_3 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt134=1;
                    }
                    }
                    break;
                case RPAREN:
                    {
                    int LA134_4 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt134=1;
                    }
                    }
                    break;
                case EOF:
                    {
                    int LA134_5 = input.LA(2);

                    if ( (synpred252_TCS()) ) {
                        alt134=1;
                    }
                    }
                    break;
            }

            switch (alt134) {
                case 1 :
                    // parser/TCS.g:1512:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
                    {
                    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern8163);
                    temp=tcs_simplepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "simplePatterns", temp);
                    }
                    // parser/TCS.g:1512:132: ( ( PIPE ) temp= tcs_simplepattern )*
                    loop133:
                    do {
                        int alt133=2;
                        int LA133_0 = input.LA(1);

                        if ( (LA133_0==PIPE) ) {
                            alt133=1;
                        }


                        switch (alt133) {
                    	case 1 :
                    	    // parser/TCS.g:1512:133: ( PIPE ) temp= tcs_simplepattern
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // parser/TCS.g:1512:150: ( PIPE )
                    	    // parser/TCS.g:1512:151: PIPE
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0DCF6CDFFB68EA9333D11DF8B38DD40A9FE17A4");
                    	    }
                    	    match(input,PIPE,FOLLOW_PIPE_in_tcs_orpattern8172); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_tcs_simplepattern_in_tcs_orpattern8180);
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
                    	    break loop133;
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
    // parser/TCS.g:1520:1: tcs_simplepattern returns [Object ret2] : (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) ;
    public final Object tcs_simplepattern() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1521:3: ( (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern ) )
            // parser/TCS.g:1522:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            {
            // parser/TCS.g:1522:3: (ret= tcs_rulepattern | ret= tcs_stringpattern | ret= tcs_classpattern )
            int alt135=3;
            switch ( input.LA(1) ) {
            case 59:
            case 85:
            case 103:
                {
                alt135=1;
                }
                break;
            case EOF:
            case STRING:
            case RPAREN:
            case SEMI:
            case COMA:
            case PIPE:
                {
                alt135=2;
                }
                break;
            case LSQUARE:
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
                    // parser/TCS.g:1522:4: ret= tcs_rulepattern
                    {
                    pushFollow(FOLLOW_tcs_rulepattern_in_tcs_simplepattern8225);
                    ret=tcs_rulepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1523:5: ret= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_simplepattern8233);
                    ret=tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1524:5: ret= tcs_classpattern
                    {
                    pushFollow(FOLLOW_tcs_classpattern_in_tcs_simplepattern8241);
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
    // parser/TCS.g:1531:1: tcs_rulepattern returns [Object ret2] : ( (temp= tcs_rule ) ) ;
    public final Object tcs_rulepattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","RulePattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1536:3: ( ( (temp= tcs_rule ) ) )
            // parser/TCS.g:1537:3: ( (temp= tcs_rule ) )
            {
            // parser/TCS.g:1537:3: ( (temp= tcs_rule ) )
            // parser/TCS.g:1537:4: (temp= tcs_rule )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFB8D893333D11DFCE35DD40A9FE17A4");
            }
            // parser/TCS.g:1537:63: (temp= tcs_rule )
            // parser/TCS.g:1537:65: temp= tcs_rule
            {
            pushFollow(FOLLOW_tcs_rule_in_tcs_rulepattern8275);
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
    // parser/TCS.g:1545:1: tcs_rule returns [Object ret2] : (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) ;
    public final Object tcs_rule() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1546:3: ( (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule ) )
            // parser/TCS.g:1547:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            {
            // parser/TCS.g:1547:3: (ret= tcs_wordrule | ret= tcs_endoflinerule | ret= tcs_multilinerule )
            int alt136=3;
            switch ( input.LA(1) ) {
            case 85:
                {
                alt136=1;
                }
                break;
            case 59:
                {
                alt136=2;
                }
                break;
            case 103:
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
                    // parser/TCS.g:1547:4: ret= tcs_wordrule
                    {
                    pushFollow(FOLLOW_tcs_wordrule_in_tcs_rule8315);
                    ret=tcs_wordrule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1548:5: ret= tcs_endoflinerule
                    {
                    pushFollow(FOLLOW_tcs_endoflinerule_in_tcs_rule8323);
                    ret=tcs_endoflinerule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1549:5: ret= tcs_multilinerule
                    {
                    pushFollow(FOLLOW_tcs_multilinerule_in_tcs_rule8331);
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
    // parser/TCS.g:1556:1: tcs_wordrule returns [Object ret2] : ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) ;
    public final Object tcs_wordrule() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","WordRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1561:3: ( ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN ) )
            // parser/TCS.g:1562:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            {
            // parser/TCS.g:1562:3: ( 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN )
            // parser/TCS.g:1562:4: 'word' LPAREN 'start' EQ (temp= tcs_orpattern ) COMA 'part' EQ (temp= tcs_orpattern ) ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB4992333D11DF929CDD40A9FE17A4");
            }
            match(input,85,FOLLOW_85_in_tcs_wordrule8361); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB4993333D11DF8803DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_wordrule8365); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB4994333D11DFC342DD40A9FE17A4");
            }
            match(input,61,FOLLOW_61_in_tcs_wordrule8369); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB4995333D11DFA2F1DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8373); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB4997333D11DF96E6DD40A9FE17A4");
            }
            // parser/TCS.g:1562:388: (temp= tcs_orpattern )
            // parser/TCS.g:1562:390: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8381);
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
              _beforeSeqEl("E0DCF6CDFFBB4998333D11DF9CC5DD40A9FE17A4");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8388); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB4999333D11DF9549DD40A9FE17A4");
            }
            match(input,131,FOLLOW_131_in_tcs_wordrule8392); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB499A333D11DFA573DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8396); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBB499C333D11DF9E7FDD40A9FE17A4");
            }
            // parser/TCS.g:1562:760: (temp= tcs_orpattern )
            // parser/TCS.g:1562:762: temp= tcs_orpattern
            {
            pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8404);
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
              _beforeSeqEl("E0DCF6CDFFBB49A6333D11DFC128DD40A9FE17A4");
            }
            // parser/TCS.g:1562:891: ( ( COMA 'end' EQ (temp= tcs_orpattern ) ) | )
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==COMA) ) {
                alt137=1;
            }
            else if ( (LA137_0==RPAREN) ) {
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
                    // parser/TCS.g:1562:892: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1562:908: ( COMA 'end' EQ (temp= tcs_orpattern ) )
                    // parser/TCS.g:1562:909: COMA 'end' EQ (temp= tcs_orpattern )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFBB49A0333D11DFA0FADD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_wordrule8417); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFBB49A1333D11DF9E17DD40A9FE17A4");
                    }
                    match(input,109,FOLLOW_109_in_tcs_wordrule8421); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFBB49A2333D11DFA795DD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_wordrule8425); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFBB49A4333D11DFCC41DD40A9FE17A4");
                    }
                    // parser/TCS.g:1562:1208: (temp= tcs_orpattern )
                    // parser/TCS.g:1562:1210: temp= tcs_orpattern
                    {
                    pushFollow(FOLLOW_tcs_orpattern_in_tcs_wordrule8433);
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
                    // parser/TCS.g:1562:1296: 
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
              _beforeSeqEl("E0DCF6CDFFBB49A7333D11DFC21FDD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_wordrule8453); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1571:1: tcs_endoflinerule returns [Object ret2] : ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) ;
    public final Object tcs_endoflinerule() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","EndOfLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1576:3: ( ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN ) )
            // parser/TCS.g:1577:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            {
            // parser/TCS.g:1577:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN )
            // parser/TCS.g:1577:4: 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBDBA90333D11DF83BDDD40A9FE17A4");
            }
            match(input,59,FOLLOW_59_in_tcs_endoflinerule8494); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBDBA91333D11DF8B24DD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_endoflinerule8498); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBDBA92333D11DF8E77DD40A9FE17A4");
            }
            match(input,61,FOLLOW_61_in_tcs_endoflinerule8502); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBDBA93333D11DF9A55DD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_endoflinerule8506); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFBDBA99333D11DFA0EBDD40A9FE17A4");
            }
            // parser/TCS.g:1577:394: ( ( 'drop' ) | )
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==89) ) {
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
                    // parser/TCS.g:1577:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1577:411: ( 'drop' )
                    // parser/TCS.g:1577:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFBDBA97333D11DFC2CEDD40A9FE17A4");
                    }
                    match(input,89,FOLLOW_89_in_tcs_endoflinerule8516); if (state.failed) return ret2;
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
                    // parser/TCS.g:1577:567: 
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
              _beforeSeqEl("E0DCF6CDFFBDBA9B333D11DF9821DD40A9FE17A4");
            }
            // parser/TCS.g:1578:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1578:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8538);
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
              _beforeSeqEl("E0DCF6CDFFBDBA9C333D11DF8383DD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_endoflinerule8545); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1586:1: tcs_multilinerule returns [Object ret2] : ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) ;
    public final Object tcs_multilinerule() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","MultiLineRule");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1591:3: ( ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) )
            // parser/TCS.g:1592:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            {
            // parser/TCS.g:1592:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            // parser/TCS.g:1592:4: 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC00480333D11DF8439DD40A9FE17A4");
            }
            match(input,103,FOLLOW_103_in_tcs_multilinerule8586); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC00481333D11DFB83EDD40A9FE17A4");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8590); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC00482333D11DF87CCDD40A9FE17A4");
            }
            match(input,61,FOLLOW_61_in_tcs_multilinerule8594); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC00483333D11DF961BDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8598); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC00489333D11DF8892DD40A9FE17A4");
            }
            // parser/TCS.g:1592:394: ( ( 'drop' ) | )
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==89) ) {
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
                    // parser/TCS.g:1592:395: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1592:411: ( 'drop' )
                    // parser/TCS.g:1592:412: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFC00487333D11DF945FDD40A9FE17A4");
                    }
                    match(input,89,FOLLOW_89_in_tcs_multilinerule8608); if (state.failed) return ret2;
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
                    // parser/TCS.g:1592:567: 
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
              _beforeSeqEl("E0DCF6CDFFC0048B333D11DFCFAADD40A9FE17A4");
            }
            // parser/TCS.g:1593:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1593:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8630);
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
              _beforeSeqEl("E0DCF6CDFFC0048C333D11DFBBF2DD40A9FE17A4");
            }
            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8637); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC0048D333D11DFAFFBDD40A9FE17A4");
            }
            match(input,109,FOLLOW_109_in_tcs_multilinerule8641); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC0048E333D11DF9C3FDD40A9FE17A4");
            }
            match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8645); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC00494333D11DFB683DD40A9FE17A4");
            }
            // parser/TCS.g:1593:452: ( ( 'drop' ) | )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==89) ) {
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
                    // parser/TCS.g:1593:453: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1593:469: ( 'drop' )
                    // parser/TCS.g:1593:470: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFC00492333D11DFAEAADD40A9FE17A4");
                    }
                    match(input,89,FOLLOW_89_in_tcs_multilinerule8655); if (state.failed) return ret2;
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
                    // parser/TCS.g:1593:623: 
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
              _beforeSeqEl("E0DCF6CDFFC00496333D11DF95DFDD40A9FE17A4");
            }
            // parser/TCS.g:1594:76: (temp= tcs_stringpattern )
            // parser/TCS.g:1594:78: temp= tcs_stringpattern
            {
            pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8677);
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
              _beforeSeqEl("E0DCF6CDFFC27584333D11DFA7EADD40A9FE17A4");
            }
            // parser/TCS.g:1594:210: ( ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) ) | )
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
                    // parser/TCS.g:1594:211: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // parser/TCS.g:1594:227: ( COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | ) )
                    // parser/TCS.g:1594:228: COMA 'esc' EQ (temp= tcs_stringpattern ) ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFC0049A333D11DF9665DD40A9FE17A4");
                    }
                    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8690); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFC0049B333D11DF9B39DD40A9FE17A4");
                    }
                    match(input,55,FOLLOW_55_in_tcs_multilinerule8694); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFC0049C333D11DF84CBDD40A9FE17A4");
                    }
                    match(input,EQ,FOLLOW_EQ_in_tcs_multilinerule8698); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0DCF6CDFFC0049E333D11DF8034DD40A9FE17A4");
                    }
                    // parser/TCS.g:1594:527: (temp= tcs_stringpattern )
                    // parser/TCS.g:1594:529: temp= tcs_stringpattern
                    {
                    pushFollow(FOLLOW_tcs_stringpattern_in_tcs_multilinerule8706);
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
                      _beforeSeqEl("E0DCF6CDFFC27582333D11DFC764DD40A9FE17A4");
                    }
                    // parser/TCS.g:1594:661: ( ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN ) | )
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
                            // parser/TCS.g:1594:662: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // parser/TCS.g:1594:678: ( COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN )
                            // parser/TCS.g:1594:679: COMA LPAREN (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )? RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFFC004A2333D11DFCA4FDD40A9FE17A4");
                            }
                            match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8719); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFFC004A3333D11DFB15CDD40A9FE17A4");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_tcs_multilinerule8724); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFFC004A8333D11DFB900DD40A9FE17A4");
                            }
                            // parser/TCS.g:1594:902: (temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )* )?
                            int alt142=2;
                            int LA142_0 = input.LA(1);

                            if ( (LA142_0==NAME||LA142_0==POINT||LA142_0==80||LA142_0==108) ) {
                                alt142=1;
                            }
                            switch (alt142) {
                                case 1 :
                                    // parser/TCS.g:1594:904: temp= tcs_mapping ( ( COMA ) temp= tcs_mapping )*
                                    {
                                    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8732);
                                    temp=tcs_mapping();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "escMappings", temp);
                                    }
                                    // parser/TCS.g:1594:962: ( ( COMA ) temp= tcs_mapping )*
                                    loop141:
                                    do {
                                        int alt141=2;
                                        int LA141_0 = input.LA(1);

                                        if ( (LA141_0==COMA) ) {
                                            alt141=1;
                                        }


                                        switch (alt141) {
                                    	case 1 :
                                    	    // parser/TCS.g:1594:963: ( COMA ) temp= tcs_mapping
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _enterSepSeq();
                                    	    }
                                    	    // parser/TCS.g:1594:980: ( COMA )
                                    	    // parser/TCS.g:1594:981: COMA
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _beforeSeqEl("E0DCF6CDFFC004A5333D11DF905BDD40A9FE17A4");
                                    	    }
                                    	    match(input,COMA,FOLLOW_COMA_in_tcs_multilinerule8741); if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      _afterSeqEl();
                                    	    }

                                    	    }

                                    	    if ( state.backtracking==0 ) {
                                    	      _exitSepSeq();
                                    	    }
                                    	    pushFollow(FOLLOW_tcs_mapping_in_tcs_multilinerule8749);
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
                                    	    break loop141;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0DCF6CDFFC27580333D11DF9852DD40A9FE17A4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8761); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // parser/TCS.g:1594:1260: 
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
                    // parser/TCS.g:1595:35: 
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
              _beforeSeqEl("E0DCF6CDFFC27585333D11DFB222DD40A9FE17A4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_tcs_multilinerule8792); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1604:1: tcs_mapping returns [Object ret2] : (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) ;
    public final Object tcs_mapping() throws RecognitionException {

        Object ret2 = null;

        Object ret = null;


        try {
            // parser/TCS.g:1605:3: ( (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping ) )
            // parser/TCS.g:1606:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            {
            // parser/TCS.g:1606:3: (ret= tcs_simplemapping | ret= tcs_wildcardmapping | ret= tcs_octalmapping | ret= tcs_hexadecimalmapping )
            int alt145=4;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt145=1;
                }
                break;
            case POINT:
                {
                alt145=2;
                }
                break;
            case 108:
                {
                alt145=3;
                }
                break;
            case 80:
                {
                alt145=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 145, 0, input);

                throw nvae;
            }

            switch (alt145) {
                case 1 :
                    // parser/TCS.g:1606:4: ret= tcs_simplemapping
                    {
                    pushFollow(FOLLOW_tcs_simplemapping_in_tcs_mapping8830);
                    ret=tcs_simplemapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // parser/TCS.g:1607:5: ret= tcs_wildcardmapping
                    {
                    pushFollow(FOLLOW_tcs_wildcardmapping_in_tcs_mapping8838);
                    ret=tcs_wildcardmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // parser/TCS.g:1608:5: ret= tcs_octalmapping
                    {
                    pushFollow(FOLLOW_tcs_octalmapping_in_tcs_mapping8846);
                    ret=tcs_octalmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // parser/TCS.g:1609:5: ret= tcs_hexadecimalmapping
                    {
                    pushFollow(FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8854);
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
    // parser/TCS.g:1616:1: tcs_simplemapping returns [Object ret2] : ( (temp= identifier ) RARROW (temp= identifier ) ) ;
    public final Object tcs_simplemapping() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","SimpleMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1621:3: ( ( (temp= identifier ) RARROW (temp= identifier ) ) )
            // parser/TCS.g:1622:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            {
            // parser/TCS.g:1622:3: ( (temp= identifier ) RARROW (temp= identifier ) )
            // parser/TCS.g:1622:4: (temp= identifier ) RARROW (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC4BF71333D11DF9876DD40A9FE17A4");
            }
            // parser/TCS.g:1622:63: (temp= identifier )
            // parser/TCS.g:1622:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8888);
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
              _beforeSeqEl("E0DCF6CDFFC4BF72333D11DF9B3ADD40A9FE17A4");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_simplemapping8895); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC4BF74333D11DF9610DD40A9FE17A4");
            }
            // parser/TCS.g:1622:272: (temp= identifier )
            // parser/TCS.g:1622:274: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_tcs_simplemapping8903);
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
    // parser/TCS.g:1630:1: tcs_wildcardmapping returns [Object ret2] : ( POINT RARROW POINT ) ;
    public final Object tcs_wildcardmapping() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","WildcardMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1635:3: ( ( POINT RARROW POINT ) )
            // parser/TCS.g:1636:3: ( POINT RARROW POINT )
            {
            // parser/TCS.g:1636:3: ( POINT RARROW POINT )
            // parser/TCS.g:1636:4: POINT RARROW POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC73070333D11DFA2BADD40A9FE17A4");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8947); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC73071333D11DFB30ADD40A9FE17A4");
            }
            match(input,RARROW,FOLLOW_RARROW_in_tcs_wildcardmapping8952); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC73072333D11DF90E0DD40A9FE17A4");
            }
            match(input,POINT,FOLLOW_POINT_in_tcs_wildcardmapping8957); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1644:1: tcs_octalmapping returns [Object ret2] : ( 'octal' ) ;
    public final Object tcs_octalmapping() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","OctalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1649:3: ( ( 'octal' ) )
            // parser/TCS.g:1650:3: ( 'octal' )
            {
            // parser/TCS.g:1650:3: ( 'octal' )
            // parser/TCS.g:1650:4: 'octal'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC73076333D11DFCDB3DD40A9FE17A4");
            }
            match(input,108,FOLLOW_108_in_tcs_octalmapping8998); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1658:1: tcs_hexadecimalmapping returns [Object ret2] : ( 'hex' ) ;
    public final Object tcs_hexadecimalmapping() throws RecognitionException {

        Object ret2 = null;

        List<String> metaType=list("TCS","HexadecimalMapping");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1663:3: ( ( 'hex' ) )
            // parser/TCS.g:1664:3: ( 'hex' )
            {
            // parser/TCS.g:1664:3: ( 'hex' )
            // parser/TCS.g:1664:4: 'hex'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC7307A333D11DFBE18DD40A9FE17A4");
            }
            match(input,80,FOLLOW_80_in_tcs_hexadecimalmapping9038); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // parser/TCS.g:1672:1: tcs_stringpattern returns [Object ret2] : ( (temp= stringSymbol )? ) ;
    public final Object tcs_stringpattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","StringPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1677:3: ( ( (temp= stringSymbol )? ) )
            // parser/TCS.g:1678:3: ( (temp= stringSymbol )? )
            {
            // parser/TCS.g:1678:3: ( (temp= stringSymbol )? )
            // parser/TCS.g:1678:4: (temp= stringSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC9A172333D11DFCC01DD40A9FE17A4");
            }
            // parser/TCS.g:1678:63: (temp= stringSymbol )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==STRING) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // parser/TCS.g:1678:65: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_tcs_stringpattern9082);
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
    // parser/TCS.g:1686:1: tcs_classpattern returns [Object ret2] : ( LSQUARE (temp= identifier )? RSQUARE ) ;
    public final Object tcs_classpattern() throws RecognitionException {

        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("TCS","ClassPattern");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // parser/TCS.g:1691:3: ( ( LSQUARE (temp= identifier )? RSQUARE ) )
            // parser/TCS.g:1692:3: ( LSQUARE (temp= identifier )? RSQUARE )
            {
            // parser/TCS.g:1692:3: ( LSQUARE (temp= identifier )? RSQUARE )
            // parser/TCS.g:1692:4: LSQUARE (temp= identifier )? RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC9A176333D11DF8FE7DD40A9FE17A4");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_tcs_classpattern9128); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0DCF6CDFFC9A178333D11DF8E1EDD40A9FE17A4");
            }
            // parser/TCS.g:1692:147: (temp= identifier )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==NAME) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // parser/TCS.g:1692:149: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_tcs_classpattern9136);
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
              _beforeSeqEl("E0DCF6CDFFC9A179333D11DFBB36DD40A9FE17A4");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_tcs_classpattern9145); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
        // parser/TCS.g:371:36: ( DLCOLON )
        // parser/TCS.g:371:37: DLCOLON
        {
        match(input,DLCOLON,FOLLOW_DLCOLON_in_synpred89_TCS1061); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_TCS

    // $ANTLR start synpred115_TCS
    public final void synpred115_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:500:159: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:500:159: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred115_TCS1975);
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


        // parser/TCS.g:516:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:516:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred120_TCS2135);
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


        // parser/TCS.g:561:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:561:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred138_TCS2821);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred138_TCS

    // $ANTLR start synpred150_TCS
    public final void synpred150_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:584:78: (temp= textblockdefinition_textblockdefinition )
        // parser/TCS.g:584:78: temp= textblockdefinition_textblockdefinition
        {
        pushFollow(FOLLOW_textblockdefinition_textblockdefinition_in_synpred150_TCS3288);
        temp=textblockdefinition_textblockdefinition();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred150_TCS

    // $ANTLR start synpred155_TCS
    public final void synpred155_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // parser/TCS.g:636:4: (ret= tcs_sequence__impl )
        // parser/TCS.g:636:4: ret= tcs_sequence__impl
        {
        pushFollow(FOLLOW_tcs_sequence__impl_in_synpred155_TCS3561);
        ret=tcs_sequence__impl();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred155_TCS

    // $ANTLR start synpred164_TCS
    public final void synpred164_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:679:3648: (temp= identifierOrKeyword )
        // parser/TCS.g:679:3648: temp= identifierOrKeyword
        {
        pushFollow(FOLLOW_identifierOrKeyword_in_synpred164_TCS3765);
        temp=identifierOrKeyword();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred164_TCS

    // $ANTLR start synpred171_TCS
    public final void synpred171_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:738:148: (temp= tcs_expression )
        // parser/TCS.g:738:148: temp= tcs_expression
        {
        pushFollow(FOLLOW_tcs_expression_in_synpred171_TCS4117);
        temp=tcs_expression();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred171_TCS

    // $ANTLR start synpred174_TCS
    public final void synpred174_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:753:150: (temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )* )
        // parser/TCS.g:753:150: temp= tcs_sequenceinalternative ( ( PIPE ) temp= tcs_sequenceinalternative )*
        {
        pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred174_TCS4228);
        temp=tcs_sequenceinalternative();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:753:220: ( ( PIPE ) temp= tcs_sequenceinalternative )*
        loop174:
        do {
            int alt174=2;
            int LA174_0 = input.LA(1);

            if ( (LA174_0==PIPE) ) {
                alt174=1;
            }


            switch (alt174) {
        	case 1 :
        	    // parser/TCS.g:753:221: ( PIPE ) temp= tcs_sequenceinalternative
        	    {
        	    // parser/TCS.g:753:238: ( PIPE )
        	    // parser/TCS.g:753:239: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CDFF502BB2333D11DF8413DD40A9FE17A4");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred174_TCS4237); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_sequenceinalternative_in_synpred174_TCS4245);
        	    temp=tcs_sequenceinalternative();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop174;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred174_TCS

    // $ANTLR start synpred186_TCS
    public final void synpred186_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:862:375: ( ( COMA 'mode' EQ (temp= stringSymbol ) ) )
        // parser/TCS.g:862:375: ( COMA 'mode' EQ (temp= stringSymbol ) )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // parser/TCS.g:862:391: ( COMA 'mode' EQ (temp= stringSymbol ) )
        // parser/TCS.g:862:392: COMA 'mode' EQ (temp= stringSymbol )
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("E0DCF6CDFF5E83A2333D11DFAD3EDD40A9FE17A4");
        }
        match(input,COMA,FOLLOW_COMA_in_synpred186_TCS4897); if (state.failed) return ;
        match(input,112,FOLLOW_112_in_synpred186_TCS4901); if (state.failed) return ;
        match(input,EQ,FOLLOW_EQ_in_synpred186_TCS4905); if (state.failed) return ;
        // parser/TCS.g:862:692: (temp= stringSymbol )
        // parser/TCS.g:862:694: temp= stringSymbol
        {
        pushFollow(FOLLOW_stringSymbol_in_synpred186_TCS4913);
        temp=stringSymbol();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred186_TCS

    // $ANTLR start synpred252_TCS
    public final void synpred252_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // parser/TCS.g:1512:65: (temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )* )
        // parser/TCS.g:1512:65: temp= tcs_simplepattern ( ( PIPE ) temp= tcs_simplepattern )*
        {
        pushFollow(FOLLOW_tcs_simplepattern_in_synpred252_TCS8163);
        temp=tcs_simplepattern();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // parser/TCS.g:1512:132: ( ( PIPE ) temp= tcs_simplepattern )*
        loop187:
        do {
            int alt187=2;
            int LA187_0 = input.LA(1);

            if ( (LA187_0==PIPE) ) {
                alt187=1;
            }


            switch (alt187) {
        	case 1 :
        	    // parser/TCS.g:1512:133: ( PIPE ) temp= tcs_simplepattern
        	    {
        	    // parser/TCS.g:1512:150: ( PIPE )
        	    // parser/TCS.g:1512:151: PIPE
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("E0DCF6CDFFB68EA9333D11DF8B38DD40A9FE17A4");
        	    }
        	    match(input,PIPE,FOLLOW_PIPE_in_synpred252_TCS8172); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_tcs_simplepattern_in_synpred252_TCS8180);
        	    temp=tcs_simplepattern();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop187;
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
    public final boolean synpred164_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred164_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred155_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred155_TCS_fragment(); // can never throw exception
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
    public final boolean synpred186_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred186_TCS_fragment(); // can never throw exception
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
    public final boolean synpred150_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred150_TCS_fragment(); // can never throw exception
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
    public final boolean synpred174_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred174_TCS_fragment(); // can never throw exception
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
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA88 dfa88 = new DFA88(this);
    protected DFA128 dfa128 = new DFA128(this);
    static final String DFA28_eotS =
        "\20\uffff";
    static final String DFA28_eofS =
        "\1\15\17\uffff";
    static final String DFA28_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA28_maxS =
        "\1\176\15\0\2\uffff";
    static final String DFA28_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA28_specialS =
        "\1\uffff\1\13\1\12\1\6\1\0\1\7\1\4\1\10\1\2\1\14\1\11\1\5\1\3\1"+
        "\1\2\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\14\45\uffff\1\11\4\uffff\1\6\1\12\5\uffff\1\4\1\uffff\1"+
            "\7\1\5\4\uffff\1\10\1\3\21\uffff\1\2\40\uffff\1\13\2\uffff\1"+
            "\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "500:157: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA28_4 = input.LA(1);

                         
                        int index28_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_4);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA28_13 = input.LA(1);

                         
                        int index28_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_13);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA28_8 = input.LA(1);

                         
                        int index28_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_8);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA28_12 = input.LA(1);

                         
                        int index28_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_12);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA28_6 = input.LA(1);

                         
                        int index28_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_6);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA28_11 = input.LA(1);

                         
                        int index28_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_11);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA28_3 = input.LA(1);

                         
                        int index28_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_3);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA28_5 = input.LA(1);

                         
                        int index28_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_5);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA28_7 = input.LA(1);

                         
                        int index28_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_7);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA28_10 = input.LA(1);

                         
                        int index28_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_10);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA28_2 = input.LA(1);

                         
                        int index28_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_2);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA28_1 = input.LA(1);

                         
                        int index28_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_1);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA28_9 = input.LA(1);

                         
                        int index28_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred115_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index28_9);
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
        "\1\176\15\0\2\uffff";
    static final String DFA33_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\1\uffff\1\13\1\12\1\6\1\0\1\7\1\4\1\10\1\1\1\14\1\11\1\5\1\2\1"+
        "\3\2\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\14\45\uffff\1\11\4\uffff\1\6\1\12\5\uffff\1\4\1\uffff\1"+
            "\7\1\5\4\uffff\1\10\1\3\21\uffff\1\2\40\uffff\1\13\2\uffff\1"+
            "\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "516:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA33_4 = input.LA(1);

                         
                        int index33_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_4);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA33_12 = input.LA(1);

                         
                        int index33_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_12);
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
                        int LA33_6 = input.LA(1);

                         
                        int index33_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_6);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA33_11 = input.LA(1);

                         
                        int index33_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_11);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA33_3 = input.LA(1);

                         
                        int index33_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_3);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA33_5 = input.LA(1);

                         
                        int index33_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_5);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA33_7 = input.LA(1);

                         
                        int index33_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_7);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA33_10 = input.LA(1);

                         
                        int index33_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_10);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA33_2 = input.LA(1);

                         
                        int index33_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_2);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA33_1 = input.LA(1);

                         
                        int index33_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_1);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA33_9 = input.LA(1);

                         
                        int index33_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred120_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index33_9);
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
        "\1\176\15\0\2\uffff";
    static final String DFA51_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA51_specialS =
        "\1\uffff\1\13\1\12\1\6\1\0\1\7\1\3\1\10\1\1\1\14\1\11\1\4\1\2\1"+
        "\5\2\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\14\45\uffff\1\11\4\uffff\1\6\1\12\5\uffff\1\4\1\uffff\1"+
            "\7\1\5\4\uffff\1\10\1\3\21\uffff\1\2\40\uffff\1\13\2\uffff\1"+
            "\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            return "561:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA51_4 = input.LA(1);

                         
                        int index51_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_4);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA51_8 = input.LA(1);

                         
                        int index51_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_8);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA51_12 = input.LA(1);

                         
                        int index51_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_12);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA51_6 = input.LA(1);

                         
                        int index51_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_6);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA51_11 = input.LA(1);

                         
                        int index51_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_11);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA51_13 = input.LA(1);

                         
                        int index51_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_13);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA51_3 = input.LA(1);

                         
                        int index51_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_3);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA51_5 = input.LA(1);

                         
                        int index51_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_5);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA51_7 = input.LA(1);

                         
                        int index51_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_7);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA51_10 = input.LA(1);

                         
                        int index51_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_10);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA51_2 = input.LA(1);

                         
                        int index51_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_2);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA51_1 = input.LA(1);

                         
                        int index51_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_1);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA51_9 = input.LA(1);

                         
                        int index51_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred138_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index51_9);
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
    static final String DFA63_eotS =
        "\20\uffff";
    static final String DFA63_eofS =
        "\1\15\17\uffff";
    static final String DFA63_minS =
        "\1\15\15\0\2\uffff";
    static final String DFA63_maxS =
        "\1\176\15\0\2\uffff";
    static final String DFA63_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA63_specialS =
        "\1\uffff\1\13\1\12\1\5\1\0\1\6\1\3\1\7\1\1\1\14\1\10\1\4\1\2\1"+
        "\11\2\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\14\45\uffff\1\11\4\uffff\1\6\1\12\5\uffff\1\4\1\uffff\1"+
            "\7\1\5\4\uffff\1\10\1\3\21\uffff\1\2\40\uffff\1\13\2\uffff\1"+
            "\1",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "584:76: (temp= textblockdefinition_textblockdefinition )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA63_4 = input.LA(1);

                         
                        int index63_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_4);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA63_8 = input.LA(1);

                         
                        int index63_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_8);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA63_12 = input.LA(1);

                         
                        int index63_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_12);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA63_6 = input.LA(1);

                         
                        int index63_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_6);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA63_11 = input.LA(1);

                         
                        int index63_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_11);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA63_5 = input.LA(1);

                         
                        int index63_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_5);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA63_7 = input.LA(1);

                         
                        int index63_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_7);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA63_10 = input.LA(1);

                         
                        int index63_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_10);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA63_13 = input.LA(1);

                         
                        int index63_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_13);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA63_2 = input.LA(1);

                         
                        int index63_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_2);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA63_1 = input.LA(1);

                         
                        int index63_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_1);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA63_9 = input.LA(1);

                         
                        int index63_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred150_TCS()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index63_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA68_eotS =
        "\151\uffff";
    static final String DFA68_eofS =
        "\1\146\150\uffff";
    static final String DFA68_minS =
        "\1\4\146\0\2\uffff";
    static final String DFA68_maxS =
        "\1\u0086\146\0\2\uffff";
    static final String DFA68_acceptS =
        "\147\uffff\1\1\1\2";
    static final String DFA68_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
        "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45"+
        "\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62"+
        "\1\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
        "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111\1\112"+
        "\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125"+
        "\1\126\1\127\1\130\1\131\1\132\1\133\1\134\1\135\1\136\1\137\1\140"+
        "\1\141\1\142\1\143\1\144\1\145\2\uffff}>";
    static final String[] DFA68_transitionS = {
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

    static final short[] DFA68_eot = DFA.unpackEncodedString(DFA68_eotS);
    static final short[] DFA68_eof = DFA.unpackEncodedString(DFA68_eofS);
    static final char[] DFA68_min = DFA.unpackEncodedStringToUnsignedChars(DFA68_minS);
    static final char[] DFA68_max = DFA.unpackEncodedStringToUnsignedChars(DFA68_maxS);
    static final short[] DFA68_accept = DFA.unpackEncodedString(DFA68_acceptS);
    static final short[] DFA68_special = DFA.unpackEncodedString(DFA68_specialS);
    static final short[][] DFA68_transition;

    static {
        int numStates = DFA68_transitionS.length;
        DFA68_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA68_transition[i] = DFA.unpackEncodedString(DFA68_transitionS[i]);
        }
    }

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = DFA68_eot;
            this.eof = DFA68_eof;
            this.min = DFA68_min;
            this.max = DFA68_max;
            this.accept = DFA68_accept;
            this.special = DFA68_special;
            this.transition = DFA68_transition;
        }
        public String getDescription() {
            return "636:3: (ret= tcs_sequence__impl | (ret= tcs_sequenceinalternative ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA68_1 = input.LA(1);

                         
                        int index68_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_1);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA68_2 = input.LA(1);

                         
                        int index68_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_2);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA68_3 = input.LA(1);

                         
                        int index68_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_3);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA68_4 = input.LA(1);

                         
                        int index68_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_4);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA68_5 = input.LA(1);

                         
                        int index68_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_5);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA68_6 = input.LA(1);

                         
                        int index68_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_6);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA68_7 = input.LA(1);

                         
                        int index68_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_7);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA68_8 = input.LA(1);

                         
                        int index68_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_8);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA68_9 = input.LA(1);

                         
                        int index68_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_9);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA68_10 = input.LA(1);

                         
                        int index68_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_10);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA68_11 = input.LA(1);

                         
                        int index68_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_11);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA68_12 = input.LA(1);

                         
                        int index68_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_12);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA68_13 = input.LA(1);

                         
                        int index68_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_13);
                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA68_14 = input.LA(1);

                         
                        int index68_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_14);
                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA68_15 = input.LA(1);

                         
                        int index68_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_15);
                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA68_16 = input.LA(1);

                         
                        int index68_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_16);
                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA68_17 = input.LA(1);

                         
                        int index68_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_17);
                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA68_18 = input.LA(1);

                         
                        int index68_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_18);
                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA68_19 = input.LA(1);

                         
                        int index68_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_19);
                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA68_20 = input.LA(1);

                         
                        int index68_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_20);
                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA68_21 = input.LA(1);

                         
                        int index68_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_21);
                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA68_22 = input.LA(1);

                         
                        int index68_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_22);
                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA68_23 = input.LA(1);

                         
                        int index68_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_23);
                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA68_24 = input.LA(1);

                         
                        int index68_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_24);
                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA68_25 = input.LA(1);

                         
                        int index68_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_25);
                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA68_26 = input.LA(1);

                         
                        int index68_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_26);
                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA68_27 = input.LA(1);

                         
                        int index68_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_27);
                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA68_28 = input.LA(1);

                         
                        int index68_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_28);
                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA68_29 = input.LA(1);

                         
                        int index68_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_29);
                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA68_30 = input.LA(1);

                         
                        int index68_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_30);
                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA68_31 = input.LA(1);

                         
                        int index68_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_31);
                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA68_32 = input.LA(1);

                         
                        int index68_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_32);
                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA68_33 = input.LA(1);

                         
                        int index68_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_33);
                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA68_34 = input.LA(1);

                         
                        int index68_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_34);
                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA68_35 = input.LA(1);

                         
                        int index68_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_35);
                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA68_36 = input.LA(1);

                         
                        int index68_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_36);
                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA68_37 = input.LA(1);

                         
                        int index68_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_37);
                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA68_38 = input.LA(1);

                         
                        int index68_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_38);
                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA68_39 = input.LA(1);

                         
                        int index68_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_39);
                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA68_40 = input.LA(1);

                         
                        int index68_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_40);
                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA68_41 = input.LA(1);

                         
                        int index68_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_41);
                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA68_42 = input.LA(1);

                         
                        int index68_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_42);
                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA68_43 = input.LA(1);

                         
                        int index68_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_43);
                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA68_44 = input.LA(1);

                         
                        int index68_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_44);
                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA68_45 = input.LA(1);

                         
                        int index68_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_45);
                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA68_46 = input.LA(1);

                         
                        int index68_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_46);
                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA68_47 = input.LA(1);

                         
                        int index68_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_47);
                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA68_48 = input.LA(1);

                         
                        int index68_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_48);
                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA68_49 = input.LA(1);

                         
                        int index68_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_49);
                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA68_50 = input.LA(1);

                         
                        int index68_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_50);
                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA68_51 = input.LA(1);

                         
                        int index68_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_51);
                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA68_52 = input.LA(1);

                         
                        int index68_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_52);
                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA68_53 = input.LA(1);

                         
                        int index68_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_53);
                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA68_54 = input.LA(1);

                         
                        int index68_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_54);
                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA68_55 = input.LA(1);

                         
                        int index68_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_55);
                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA68_56 = input.LA(1);

                         
                        int index68_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_56);
                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA68_57 = input.LA(1);

                         
                        int index68_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_57);
                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA68_58 = input.LA(1);

                         
                        int index68_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_58);
                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA68_59 = input.LA(1);

                         
                        int index68_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_59);
                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA68_60 = input.LA(1);

                         
                        int index68_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_60);
                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA68_61 = input.LA(1);

                         
                        int index68_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_61);
                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA68_62 = input.LA(1);

                         
                        int index68_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_62);
                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA68_63 = input.LA(1);

                         
                        int index68_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_63);
                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA68_64 = input.LA(1);

                         
                        int index68_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_64);
                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA68_65 = input.LA(1);

                         
                        int index68_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_65);
                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA68_66 = input.LA(1);

                         
                        int index68_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_66);
                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA68_67 = input.LA(1);

                         
                        int index68_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_67);
                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA68_68 = input.LA(1);

                         
                        int index68_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_68);
                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA68_69 = input.LA(1);

                         
                        int index68_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_69);
                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA68_70 = input.LA(1);

                         
                        int index68_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_70);
                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA68_71 = input.LA(1);

                         
                        int index68_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_71);
                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA68_72 = input.LA(1);

                         
                        int index68_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_72);
                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA68_73 = input.LA(1);

                         
                        int index68_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_73);
                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA68_74 = input.LA(1);

                         
                        int index68_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_74);
                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA68_75 = input.LA(1);

                         
                        int index68_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_75);
                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA68_76 = input.LA(1);

                         
                        int index68_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_76);
                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA68_77 = input.LA(1);

                         
                        int index68_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_77);
                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA68_78 = input.LA(1);

                         
                        int index68_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_78);
                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA68_79 = input.LA(1);

                         
                        int index68_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_79);
                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA68_80 = input.LA(1);

                         
                        int index68_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_80);
                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA68_81 = input.LA(1);

                         
                        int index68_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_81);
                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA68_82 = input.LA(1);

                         
                        int index68_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_82);
                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA68_83 = input.LA(1);

                         
                        int index68_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_83);
                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA68_84 = input.LA(1);

                         
                        int index68_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_84);
                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA68_85 = input.LA(1);

                         
                        int index68_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_85);
                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA68_86 = input.LA(1);

                         
                        int index68_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_86);
                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA68_87 = input.LA(1);

                         
                        int index68_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_87);
                        if ( s>=0 ) return s;
                        break;

                    case 87 : 
                        int LA68_88 = input.LA(1);

                         
                        int index68_88 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_88);
                        if ( s>=0 ) return s;
                        break;

                    case 88 : 
                        int LA68_89 = input.LA(1);

                         
                        int index68_89 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_89);
                        if ( s>=0 ) return s;
                        break;

                    case 89 : 
                        int LA68_90 = input.LA(1);

                         
                        int index68_90 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_90);
                        if ( s>=0 ) return s;
                        break;

                    case 90 : 
                        int LA68_91 = input.LA(1);

                         
                        int index68_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_91);
                        if ( s>=0 ) return s;
                        break;

                    case 91 : 
                        int LA68_92 = input.LA(1);

                         
                        int index68_92 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_92);
                        if ( s>=0 ) return s;
                        break;

                    case 92 : 
                        int LA68_93 = input.LA(1);

                         
                        int index68_93 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_93);
                        if ( s>=0 ) return s;
                        break;

                    case 93 : 
                        int LA68_94 = input.LA(1);

                         
                        int index68_94 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_94);
                        if ( s>=0 ) return s;
                        break;

                    case 94 : 
                        int LA68_95 = input.LA(1);

                         
                        int index68_95 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_95);
                        if ( s>=0 ) return s;
                        break;

                    case 95 : 
                        int LA68_96 = input.LA(1);

                         
                        int index68_96 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_96);
                        if ( s>=0 ) return s;
                        break;

                    case 96 : 
                        int LA68_97 = input.LA(1);

                         
                        int index68_97 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_97);
                        if ( s>=0 ) return s;
                        break;

                    case 97 : 
                        int LA68_98 = input.LA(1);

                         
                        int index68_98 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_98);
                        if ( s>=0 ) return s;
                        break;

                    case 98 : 
                        int LA68_99 = input.LA(1);

                         
                        int index68_99 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_99);
                        if ( s>=0 ) return s;
                        break;

                    case 99 : 
                        int LA68_100 = input.LA(1);

                         
                        int index68_100 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_100);
                        if ( s>=0 ) return s;
                        break;

                    case 100 : 
                        int LA68_101 = input.LA(1);

                         
                        int index68_101 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_101);
                        if ( s>=0 ) return s;
                        break;

                    case 101 : 
                        int LA68_102 = input.LA(1);

                         
                        int index68_102 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred155_TCS()) ) {s = 103;}

                        else if ( (true) ) {s = 104;}

                         
                        input.seek(index68_102);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA70_eotS =
        "\132\uffff";
    static final String DFA70_eofS =
        "\1\130\131\uffff";
    static final String DFA70_minS =
        "\1\4\127\0\2\uffff";
    static final String DFA70_maxS =
        "\1\u0086\127\0\2\uffff";
    static final String DFA70_acceptS =
        "\130\uffff\1\2\1\1";
    static final String DFA70_specialS =
        "\1\uffff\1\54\1\52\1\103\1\34\1\104\1\53\1\5\1\63\1\3\1\62\1\32"+
        "\1\105\1\33\1\106\1\2\1\60\1\1\1\57\1\107\1\35\1\110\1\36\1\24\1"+
        "\67\1\0\1\65\1\23\1\111\1\101\1\112\1\25\1\75\1\6\1\72\1\26\1\40"+
        "\1\125\1\42\1\21\1\73\1\30\1\102\1\17\1\71\1\4\1\126\1\10\1\66\1"+
        "\27\1\100\1\14\1\70\1\120\1\46\1\13\1\56\1\12\1\76\1\7\1\55\1\11"+
        "\1\123\1\16\1\61\1\15\1\77\1\20\1\64\1\22\1\74\1\113\1\37\1\114"+
        "\1\41\1\116\1\44\1\115\1\43\1\122\1\50\1\124\1\51\1\121\1\47\1\117"+
        "\1\45\1\31\2\uffff}>";
    static final String[] DFA70_transitionS = {
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

    static final short[] DFA70_eot = DFA.unpackEncodedString(DFA70_eotS);
    static final short[] DFA70_eof = DFA.unpackEncodedString(DFA70_eofS);
    static final char[] DFA70_min = DFA.unpackEncodedStringToUnsignedChars(DFA70_minS);
    static final char[] DFA70_max = DFA.unpackEncodedStringToUnsignedChars(DFA70_maxS);
    static final short[] DFA70_accept = DFA.unpackEncodedString(DFA70_acceptS);
    static final short[] DFA70_special = DFA.unpackEncodedString(DFA70_specialS);
    static final short[][] DFA70_transition;

    static {
        int numStates = DFA70_transitionS.length;
        DFA70_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA70_transition[i] = DFA.unpackEncodedString(DFA70_transitionS[i]);
        }
    }

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = DFA70_eot;
            this.eof = DFA70_eof;
            this.min = DFA70_min;
            this.max = DFA70_max;
            this.accept = DFA70_accept;
            this.special = DFA70_special;
            this.transition = DFA70_transition;
        }
        public String getDescription() {
            return "679:3646: (temp= identifierOrKeyword )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {

                    case 0 : 
                        int LA70_25 = input.LA(1);

                         
                        int index70_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_25);
                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA70_17 = input.LA(1);

                         
                        int index70_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_17);
                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA70_15 = input.LA(1);

                         
                        int index70_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_15);
                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA70_9 = input.LA(1);

                         
                        int index70_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_9);
                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA70_45 = input.LA(1);

                         
                        int index70_45 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_45);
                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA70_7 = input.LA(1);

                         
                        int index70_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_7);
                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA70_33 = input.LA(1);

                         
                        int index70_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_33);
                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA70_59 = input.LA(1);

                         
                        int index70_59 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_59);
                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA70_47 = input.LA(1);

                         
                        int index70_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_47);
                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA70_61 = input.LA(1);

                         
                        int index70_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_61);
                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA70_57 = input.LA(1);

                         
                        int index70_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_57);
                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA70_55 = input.LA(1);

                         
                        int index70_55 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_55);
                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA70_51 = input.LA(1);

                         
                        int index70_51 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_51);
                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA70_65 = input.LA(1);

                         
                        int index70_65 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_65);
                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA70_63 = input.LA(1);

                         
                        int index70_63 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_63);
                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA70_43 = input.LA(1);

                         
                        int index70_43 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_43);
                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA70_67 = input.LA(1);

                         
                        int index70_67 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_67);
                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA70_39 = input.LA(1);

                         
                        int index70_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_39);
                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA70_69 = input.LA(1);

                         
                        int index70_69 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_69);
                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA70_27 = input.LA(1);

                         
                        int index70_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_27);
                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA70_23 = input.LA(1);

                         
                        int index70_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_23);
                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA70_31 = input.LA(1);

                         
                        int index70_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_31);
                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA70_35 = input.LA(1);

                         
                        int index70_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_35);
                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA70_49 = input.LA(1);

                         
                        int index70_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_49);
                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA70_41 = input.LA(1);

                         
                        int index70_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_41);
                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA70_87 = input.LA(1);

                         
                        int index70_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_87);
                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA70_11 = input.LA(1);

                         
                        int index70_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_11);
                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA70_13 = input.LA(1);

                         
                        int index70_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_13);
                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA70_4 = input.LA(1);

                         
                        int index70_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_4);
                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA70_20 = input.LA(1);

                         
                        int index70_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_20);
                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA70_22 = input.LA(1);

                         
                        int index70_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_22);
                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA70_72 = input.LA(1);

                         
                        int index70_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_72);
                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA70_36 = input.LA(1);

                         
                        int index70_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_36);
                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA70_74 = input.LA(1);

                         
                        int index70_74 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_74);
                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA70_38 = input.LA(1);

                         
                        int index70_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_38);
                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA70_78 = input.LA(1);

                         
                        int index70_78 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_78);
                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA70_76 = input.LA(1);

                         
                        int index70_76 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_76);
                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA70_86 = input.LA(1);

                         
                        int index70_86 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_86);
                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA70_54 = input.LA(1);

                         
                        int index70_54 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_54);
                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA70_84 = input.LA(1);

                         
                        int index70_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_84);
                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA70_80 = input.LA(1);

                         
                        int index70_80 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_80);
                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA70_82 = input.LA(1);

                         
                        int index70_82 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_82);
                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA70_2 = input.LA(1);

                         
                        int index70_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_2);
                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA70_6 = input.LA(1);

                         
                        int index70_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_6);
                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA70_1 = input.LA(1);

                         
                        int index70_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_1);
                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA70_60 = input.LA(1);

                         
                        int index70_60 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_60);
                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA70_56 = input.LA(1);

                         
                        int index70_56 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_56);
                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA70_18 = input.LA(1);

                         
                        int index70_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_18);
                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA70_16 = input.LA(1);

                         
                        int index70_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_16);
                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA70_64 = input.LA(1);

                         
                        int index70_64 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_64);
                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA70_10 = input.LA(1);

                         
                        int index70_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_10);
                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA70_8 = input.LA(1);

                         
                        int index70_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_8);
                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA70_68 = input.LA(1);

                         
                        int index70_68 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_68);
                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA70_26 = input.LA(1);

                         
                        int index70_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_26);
                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA70_48 = input.LA(1);

                         
                        int index70_48 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_48);
                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA70_24 = input.LA(1);

                         
                        int index70_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_24);
                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA70_52 = input.LA(1);

                         
                        int index70_52 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_52);
                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA70_44 = input.LA(1);

                         
                        int index70_44 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_44);
                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA70_34 = input.LA(1);

                         
                        int index70_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_34);
                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA70_40 = input.LA(1);

                         
                        int index70_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_40);
                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA70_70 = input.LA(1);

                         
                        int index70_70 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_70);
                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA70_32 = input.LA(1);

                         
                        int index70_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_32);
                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA70_58 = input.LA(1);

                         
                        int index70_58 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_58);
                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA70_66 = input.LA(1);

                         
                        int index70_66 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_66);
                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA70_50 = input.LA(1);

                         
                        int index70_50 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_50);
                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA70_29 = input.LA(1);

                         
                        int index70_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_29);
                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA70_42 = input.LA(1);

                         
                        int index70_42 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_42);
                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA70_3 = input.LA(1);

                         
                        int index70_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_3);
                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA70_5 = input.LA(1);

                         
                        int index70_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_5);
                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA70_12 = input.LA(1);

                         
                        int index70_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_12);
                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA70_14 = input.LA(1);

                         
                        int index70_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_14);
                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA70_19 = input.LA(1);

                         
                        int index70_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_19);
                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA70_21 = input.LA(1);

                         
                        int index70_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_21);
                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA70_28 = input.LA(1);

                         
                        int index70_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_28);
                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA70_30 = input.LA(1);

                         
                        int index70_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_30);
                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA70_71 = input.LA(1);

                         
                        int index70_71 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_71);
                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA70_73 = input.LA(1);

                         
                        int index70_73 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_73);
                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA70_77 = input.LA(1);

                         
                        int index70_77 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_77);
                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA70_75 = input.LA(1);

                         
                        int index70_75 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_75);
                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA70_85 = input.LA(1);

                         
                        int index70_85 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_85);
                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA70_53 = input.LA(1);

                         
                        int index70_53 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_53);
                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA70_83 = input.LA(1);

                         
                        int index70_83 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_83);
                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA70_79 = input.LA(1);

                         
                        int index70_79 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_79);
                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA70_62 = input.LA(1);

                         
                        int index70_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_62);
                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA70_81 = input.LA(1);

                         
                        int index70_81 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_81);
                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA70_37 = input.LA(1);

                         
                        int index70_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_37);
                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA70_46 = input.LA(1);

                         
                        int index70_46 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred164_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index70_46);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 70, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA88_eotS =
        "\u00b5\uffff";
    static final String DFA88_eofS =
        "\u00b5\uffff";
    static final String DFA88_minS =
        "\1\4\127\13\3\4\127\13\3\uffff";
    static final String DFA88_maxS =
        "\1\u0086\127\37\1\u0086\2\144\127\37\3\uffff";
    static final String DFA88_acceptS =
        "\u00b2\uffff\1\2\1\1\1\3";
    static final String DFA88_specialS =
        "\u00b5\uffff}>";
    static final String[] DFA88_transitionS = {
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
            "\1\u00b3\131\uffff\1\u00b4\5\uffff\1\u00b2",
            "\1\u00b3\131\uffff\1\u00b4\5\uffff\1\u00b2",
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

    static final short[] DFA88_eot = DFA.unpackEncodedString(DFA88_eotS);
    static final short[] DFA88_eof = DFA.unpackEncodedString(DFA88_eofS);
    static final char[] DFA88_min = DFA.unpackEncodedStringToUnsignedChars(DFA88_minS);
    static final char[] DFA88_max = DFA.unpackEncodedStringToUnsignedChars(DFA88_maxS);
    static final short[] DFA88_accept = DFA.unpackEncodedString(DFA88_acceptS);
    static final short[] DFA88_special = DFA.unpackEncodedString(DFA88_specialS);
    static final short[][] DFA88_transition;

    static {
        int numStates = DFA88_transitionS.length;
        DFA88_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA88_transition[i] = DFA.unpackEncodedString(DFA88_transitionS[i]);
        }
    }

    class DFA88 extends DFA {

        public DFA88(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 88;
            this.eot = DFA88_eot;
            this.eof = DFA88_eof;
            this.min = DFA88_min;
            this.max = DFA88_max;
            this.accept = DFA88_accept;
            this.special = DFA88_special;
            this.transition = DFA88_transition;
        }
        public String getDescription() {
            return "816:3: (ret= tcs_primitivepropertyinit | ret= tcs_lookuppropertyinit | ret= tcs_foreachpredicatepropertyinit )";
        }
    }
    static final String DFA128_eotS =
        "\u00b6\uffff";
    static final String DFA128_eofS =
        "\1\uffff\130\131\5\uffff\130\131";
    static final String DFA128_minS =
        "\1\4\66\13\1\11\17\13\1\11\20\13\1\4\5\uffff\34\13\1\4\17\13\1"+
        "\4\52\13\1\4";
    static final String DFA128_maxS =
        "\1\u0086\127\134\1\u0086\5\uffff\54\134\1\u0086\53\134";
    static final String DFA128_acceptS =
        "\131\uffff\1\2\1\1\1\5\1\4\1\3\130\uffff";
    static final String DFA128_specialS =
        "\u00b6\uffff}>";
    static final String[] DFA128_transitionS = {
            "\1\1\12\uffff\1\130\41\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1"+
            "\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1"+
            "\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1"+
            "\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1\67\1\70\1"+
            "\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
            "\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1"+
            "\116\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\134\1\uffff\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff"+
            "\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\135\1\uffff\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff"+
            "\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\136\6\uffff\1\132\13\uffff\1\131\31\uffff\1\137\1\140\1"+
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
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\133\6\uffff\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff"+
            "\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\131\6\uffff\1\132\3\uffff\1\131\7\uffff\1\131\31\uffff"+
            "\33\131\1\u00b5\72\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\132\13\uffff\1\131\64\uffff\1\133\17\uffff\1\131",
            "\1\133\6\uffff\1\131\13\uffff\1\131\64\uffff\1\131\17\uffff"+
            "\1\131"
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
            return "1342:3: (ret= tcs_equalsexp | ret= tcs_booleanpropertyexp | ret= tcs_isdefinedexp | ret= tcs_oneexp | ret= tcs_instanceofexp )";
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
    public static final BitSet FOLLOW_dblcolon_priority_0_in_model_namespace1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_generalizableelement1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_model_modelelement1193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_concretesyntax_in_main1263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_tcs_concretesyntax1297 = new BitSet(new long[]{0x0000000000001210L});
    public static final BitSet FOLLOW_identifier_in_tcs_concretesyntax1304 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_concretesyntax1319 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
    public static final BitSet FOLLOW_105_in_tcs_concretesyntax1323 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1327 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_concretesyntax1335 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_concretesyntax1342 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1360 = new BitSet(new long[]{0x8308000000002000L,0x4800000004000186L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1371 = new BitSet(new long[]{0x8308000000002000L,0x4800000004000186L});
    public static final BitSet FOLLOW_tcs_template_in_tcs_concretesyntax1379 = new BitSet(new long[]{0x8308000000002000L,0x4800000004000186L});
    public static final BitSet FOLLOW_56_in_tcs_concretesyntax1396 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1400 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1411 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_keyword_in_tcs_concretesyntax1419 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1434 = new BitSet(new long[]{0x0208000000002000L,0x0800000000000082L});
    public static final BitSet FOLLOW_65_in_tcs_concretesyntax1457 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_concretesyntax1461 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1472 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_tcs_symbol_in_tcs_concretesyntax1480 = new BitSet(new long[]{0x0000000000002810L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1495 = new BitSet(new long[]{0x0208000000002000L,0x0800000000000080L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1516 = new BitSet(new long[]{0x0208000000002000L,0x0800000000000080L});
    public static final BitSet FOLLOW_tcs_operatorlist_in_tcs_concretesyntax1524 = new BitSet(new long[]{0x0208000000002000L,0x0800000000000080L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1539 = new BitSet(new long[]{0x0208000000002000L,0x0800000000000000L});
    public static final BitSet FOLLOW_tcs_token_in_tcs_concretesyntax1547 = new BitSet(new long[]{0x0208000000002000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_tcs_concretesyntax1564 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_concretesyntax1568 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_concretesyntax1576 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_concretesyntax1583 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_concretesyntax1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_classifier_in_reference1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_reference1665 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_reference1673 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_reference1682 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference1690 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_tcs_contexttemplate_in_tcs_template1731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivetemplate_in_tcs_template1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumerationtemplate_in_tcs_template1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functiontemplate_in_tcs_template1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classtemplate_in_tcs_contexttemplate1782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_operatortemplate_in_tcs_contexttemplate1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_tcs_primitivetemplate1820 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1827 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_tcs_primitivetemplate1833 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_primitivetemplate1836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L,0x0000000000000040L});
    public static final BitSet FOLLOW_69_in_tcs_primitivetemplate1846 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_tcs_primitivetemplate1864 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivetemplate1871 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_82_in_tcs_primitivetemplate1883 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_primitivetemplate1902 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_tcs_primitivetemplate1906 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1910 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1918 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_primitivetemplate1931 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_tcs_primitivetemplate1935 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivetemplate1939 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_primitivetemplate1947 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_primitivetemplate1967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_primitivetemplate1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_tcs_enumerationtemplate2020 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_enumerationtemplate2023 = new BitSet(new long[]{0x0000000000014000L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_tcs_enumerationtemplate2033 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_enumerationtemplate2061 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2072 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_enumerationtemplate2081 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_tcs_enumliteralmapping_in_tcs_enumerationtemplate2089 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate2104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_enumerationtemplate2121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_enumerationtemplate2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_enumliteralmapping2184 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_enumliteralmapping2191 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_enumliteralmapping2199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_tcs_classtemplate2242 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_classtemplate2245 = new BitSet(new long[]{0x1004000000054200L,0x8022002000020401L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_tcs_classtemplate2255 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_SHARP_in_tcs_classtemplate2275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2283 = new BitSet(new long[]{0x1004000000014200L,0x8022002000020401L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2309 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_tcs_classtemplate2313 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2317 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2325 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2332 = new BitSet(new long[]{0x1004000000014200L,0x8022002000020401L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_tcs_classtemplate2360 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2372 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2379 = new BitSet(new long[]{0x1004000000014200L,0x8022002000020401L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2403 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_tcs_classtemplate2407 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_classtemplate2411 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_classtemplate2419 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2426 = new BitSet(new long[]{0x1004000000014000L,0x8022002000020401L});
    public static final BitSet FOLLOW_101_in_tcs_classtemplate2449 = new BitSet(new long[]{0x1004000000014000L,0x8022000000020401L});
    public static final BitSet FOLLOW_127_in_tcs_classtemplate2473 = new BitSet(new long[]{0x1004000000014000L,0x0022000000020401L});
    public static final BitSet FOLLOW_60_in_tcs_classtemplate2503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_tcs_classtemplate2521 = new BitSet(new long[]{0x0004000000014000L,0x0022000000000401L});
    public static final BitSet FOLLOW_74_in_tcs_classtemplate2545 = new BitSet(new long[]{0x0004000000014200L,0x0022000000000001L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_classtemplate2555 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classtemplate2563 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_classtemplate2570 = new BitSet(new long[]{0x0004000000014000L,0x0022000000000001L});
    public static final BitSet FOLLOW_117_in_tcs_classtemplate2608 = new BitSet(new long[]{0x0004000000014200L,0x0002000000000001L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_classtemplate2621 = new BitSet(new long[]{0x0004000000014000L,0x0002000000000001L});
    public static final BitSet FOLLOW_50_in_tcs_classtemplate2661 = new BitSet(new long[]{0x0000000000014000L,0x0002000000000001L});
    public static final BitSet FOLLOW_64_in_tcs_classtemplate2685 = new BitSet(new long[]{0x0000000000014000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_tcs_classtemplate2709 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2716 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2727 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_classtemplate2769 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_classtemplate2780 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_classtemplate2807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_classtemplate2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_tcs_operatortemplate2866 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_operatortemplate2869 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_operatortemplate2874 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_tcs_operatortemplate2878 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2882 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2890 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatortemplate2898 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2910 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_tcs_operatortemplate2914 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2918 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2926 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2939 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_tcs_operatortemplate2943 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2947 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2955 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate2981 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_107_in_tcs_operatortemplate2985 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate2989 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_operatortemplate2997 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate3023 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_tcs_operatortemplate3027 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate3031 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate3039 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate3065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_tcs_operatortemplate3069 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate3073 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate3081 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_operatortemplate3107 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_tcs_operatortemplate3111 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operatortemplate3115 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operatortemplate3123 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_operatortemplate3143 = new BitSet(new long[]{0x0000000000014000L,0x0020000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_tcs_operatortemplate3153 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_117_in_tcs_operatortemplate3172 = new BitSet(new long[]{0x0000000000014200L});
    public static final BitSet FOLLOW_tcs_contexttags_in_tcs_operatortemplate3185 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_operatortemplate3236 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_operatortemplate3247 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate3257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operatortemplate3274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_tcs_operatortemplate3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_tcs_functiontemplate3333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functiontemplate3340 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_functiontemplate3347 = new BitSet(new long[]{0x0000000000008210L});
    public static final BitSet FOLLOW_reference_in_tcs_functiontemplate3351 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_functiontemplate3356 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_functiontemplate3364 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_functiontemplate3375 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_functiontemplate3385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_contexttags3430 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3438 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_contexttags3447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_contexttags3455 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_contexttags3467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3512 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequence__impl3520 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_tcs_sequence3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_sequence3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_literalref_in_tcs_sequenceelement3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_property_in_tcs_sequenceelement3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_customseparator_in_tcs_sequenceelement3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_block_in_tcs_sequenceelement3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_conditionalelement_in_tcs_sequenceelement3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_alternative_in_tcs_sequenceelement3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_functioncall_in_tcs_sequenceelement3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_injectoractionsblock_in_tcs_sequenceelement3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_literalref3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_tcs_propertyreference3757 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_propertyreference3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_property3820 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_property3833 = new BitSet(new long[]{0x4042000000002000L,0x03150010A1000240L,0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3841 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_property3850 = new BitSet(new long[]{0x4042000000000000L,0x03150010A1000240L,0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyarg_in_tcs_property3858 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_property3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_tcs_customseparator3928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_customseparator3936 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_GT_in_tcs_customseparator3943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_block3988 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_block3996 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_block4003 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_block4014 = new BitSet(new long[]{0x0000000000002000L,0x0000C00800000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block4022 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_COMA_in_tcs_block4031 = new BitSet(new long[]{0x0000000000000000L,0x0000C00800000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_tcs_blockarg_in_tcs_block4039 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_block4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_conditionalelement4109 = new BitSet(new long[]{0xFFFE000000808010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_expression_in_tcs_conditionalelement4117 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_QMARK_in_tcs_conditionalelement4126 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement4134 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_COLON_in_tcs_conditionalelement4147 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_conditionalelement4155 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_conditionalelement4175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLSQUARE_in_tcs_alternative4220 = new BitSet(new long[]{0xFFFE000037288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4228 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_PIPE_in_tcs_alternative4237 = new BitSet(new long[]{0xFFFE000037288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_tcs_alternative4245 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_DRSQUARE_in_tcs_alternative4257 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_STAR_in_tcs_alternative4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_tcs_sequenceinalternative4333 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_sequenceinalternative4337 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_sequenceinalternative4345 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_sequenceinalternative4352 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4373 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceelement_in_tcs_sequenceinalternative4381 = new BitSet(new long[]{0xFFFE000031288232L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_DOLLAR_in_tcs_functioncall4430 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_functioncall4438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCURLY_in_tcs_injectoractionsblock4485 = new BitSet(new long[]{0xFFFE000040008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4493 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_injectoractionsblock4502 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_injectoraction_in_tcs_injectoractionsblock4510 = new BitSet(new long[]{0x0000000040020000L});
    public static final BitSet FOLLOW_DRCURLY_in_tcs_injectoractionsblock4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyinit_in_tcs_injectoraction4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_primitivepropertyinit_in_tcs_propertyinit4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookuppropertyinit_in_tcs_propertyinit4598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_foreachpredicatepropertyinit_in_tcs_propertyinit4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_primitivepropertyinit4640 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_primitivepropertyinit4653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EQ_in_tcs_primitivepropertyinit4668 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_primitivepropertyinit4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_lookuppropertyinit4730 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_lookuppropertyinit4743 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookuppropertyinit4758 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_tcs_lookuppropertyinit4769 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_lookuppropertyinit4773 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_lookuppropertyinit4781 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_lookuppropertyinit4788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_foreachpredicatepropertyinit4833 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_tcs_foreachpredicatepropertyinit4846 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4861 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_tcs_foreachpredicatepropertyinit4872 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_foreachpredicatepropertyinit4876 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4884 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4897 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_tcs_foreachpredicatepropertyinit4901 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_foreachpredicatepropertyinit4905 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_foreachpredicatepropertyinit4913 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4939 = new BitSet(new long[]{0x4000000000000400L,0x0001000000002000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4947 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_foreachpredicatepropertyinit4956 = new BitSet(new long[]{0x4000000000000000L,0x0001000000002000L});
    public static final BitSet FOLLOW_tcs_predicatesemantic_in_tcs_foreachpredicatepropertyinit4964 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_foreachpredicatepropertyinit4989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_tcs_predicatesemantic5036 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic5040 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic5048 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic5055 = new BitSet(new long[]{0x4000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_tcs_predicatesemantic5078 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic5082 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_predicatesemantic5090 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_predicatesemantic5097 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_tcs_predicatesemantic5114 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_predicatesemantic5118 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_predicatesemantic5126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_referstoparg_in_tcs_propertyarg5168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_lookinparg_in_tcs_propertyarg5176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createinparg_in_tcs_propertyarg5184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_asparg_in_tcs_propertyarg5192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_separatorparg_in_tcs_propertyarg5200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_disambiguateparg_in_tcs_propertyarg5208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_autocreateparg_in_tcs_propertyarg5216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_importcontextparg_in_tcs_propertyarg5224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_partialparg_in_tcs_propertyarg5232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedlowerparg_in_tcs_propertyarg5240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_forcedupperparg_in_tcs_propertyarg5248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_createasparg_in_tcs_propertyarg5256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_queryparg_in_tcs_propertyarg5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_filterparg_in_tcs_propertyarg5272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_modeparg_in_tcs_propertyarg5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_tcs_referstoparg5310 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_referstoparg5314 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_referstoparg5322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_tcs_lookinparg5365 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_lookinparg5369 = new BitSet(new long[]{0xFFFE000000040010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_SHARP_in_tcs_lookinparg5380 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_tcs_lookinparg5384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5401 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_lookinparg5410 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_lookinparg5418 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_114_in_tcs_createinparg5471 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_createinparg5475 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5483 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_createinparg5492 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createinparg5500 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_62_in_tcs_asparg5546 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_asparg5550 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_asparg5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_tcs_separatorparg5601 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_separatorparg5605 = new BitSet(new long[]{0xFFFE000031288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequence_in_tcs_separatorparg5613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_tcs_disambiguateparg5656 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_disambiguateparg5660 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_disambiguateparg5668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_tcs_autocreateparg5711 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_autocreateparg5715 = new BitSet(new long[]{0x0000000000000000L,0x2408000000000000L});
    public static final BitSet FOLLOW_tcs_autocreatekind_in_tcs_autocreateparg5723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_tcs_autocreatekind5767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_tcs_autocreatekind5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_tcs_autocreatekind5787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_tcs_importcontextparg5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_tcs_partialparg5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_tcs_forcedlowerparg5898 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedlowerparg5902 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedlowerparg5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_tcs_forcedupperparg5953 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_forcedupperparg5957 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_forcedupperparg5965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_tcs_createasparg6008 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_createasparg6012 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg6020 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_createasparg6029 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_createasparg6037 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_88_in_tcs_queryparg6083 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_queryparg6087 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_queryparg6095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_tcs_filterparg6138 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg6142 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg6150 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COMA_in_tcs_filterparg6163 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_tcs_filterparg6167 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_filterparg6171 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_filterparg6179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_tcs_modeparg6235 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_modeparg6239 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_modeparg6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_nbnlbarg_in_tcs_blockarg6287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_indentincrbarg_in_tcs_blockarg6295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnlbarg_in_tcs_blockarg6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_startnbnlbarg_in_tcs_blockarg6311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endnlbarg_in_tcs_blockarg6319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_tcs_nbnlbarg6349 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_nbnlbarg6353 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_nbnlbarg6361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_tcs_indentincrbarg6404 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_indentincrbarg6408 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_indentincrbarg6416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_tcs_startnlbarg6459 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnlbarg6463 = new BitSet(new long[]{0x0000000000000000L,0x0080000000080000L});
    public static final BitSet FOLLOW_83_in_tcs_startnlbarg6473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_tcs_startnlbarg6486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_tcs_startnbnlbarg6533 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_startnbnlbarg6537 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_startnbnlbarg6545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_tcs_endnlbarg6588 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_endnlbarg6592 = new BitSet(new long[]{0x0000000000000000L,0x0080000000080000L});
    public static final BitSet FOLLOW_83_in_tcs_endnlbarg6602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_tcs_endnlbarg6615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_symbol6666 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_symbol6675 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_symbol6683 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_COLON_in_tcs_symbol6696 = new BitSet(new long[]{0x0000000000004000L,0x0000050000808000L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6704 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_COMA_in_tcs_symbol6713 = new BitSet(new long[]{0x0000000000000000L,0x0000050000808000L});
    public static final BitSet FOLLOW_tcs_spacekind_in_tcs_symbol6721 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_symbol6746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_tcs_spacekind6788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_tcs_spacekind6798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_tcs_spacekind6808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_tcs_spacekind6818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_keyword6853 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_keyword6862 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_keyword6870 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_keyword6877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_tcs_operatorlist6918 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_tcs_operatorlist6931 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_operatorlist6951 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6962 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_tcs_priority_in_tcs_operatorlist6970 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_operatorlist6985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_tcs_priority7026 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_priority7033 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COMA_in_tcs_priority7056 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000800L});
    public static final BitSet FOLLOW_tcs_associativity_in_tcs_priority7064 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LCURLY_in_tcs_priority7078 = new BitSet(new long[]{0x0000000000002810L,0x1000000000000000L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority7089 = new BitSet(new long[]{0x0000000000002810L,0x1000000000000000L});
    public static final BitSet FOLLOW_tcs_operator_in_tcs_priority7097 = new BitSet(new long[]{0x0000000000002810L,0x1000000000000000L});
    public static final BitSet FOLLOW_RCURLY_in_tcs_priority7112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_tcs_operator7159 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator7181 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_operator7190 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_identifier_in_tcs_operator7209 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_operator7229 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_operator7254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_operator7262 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_operator7269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_tcs_associativity7311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_tcs_associativity7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_andexp_in_tcs_expression7349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7383 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_tcs_andexp7391 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_atomexp_in_tcs_andexp7398 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_tcs_equalsexp_in_tcs_atomexp7443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_booleanpropertyexp_in_tcs_atomexp7451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_isdefinedexp_in_tcs_atomexp7459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_oneexp_in_tcs_atomexp7467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_instanceofexp_in_tcs_atomexp7475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_equalsexp7509 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_equalsexp7516 = new BitSet(new long[]{0x0000000200040060L});
    public static final BitSet FOLLOW_tcs_value_in_tcs_equalsexp7524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_booleanpropertyexp7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_tcs_isdefinedexp7614 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_isdefinedexp7618 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_isdefinedexp7626 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_isdefinedexp7633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_tcs_oneexp7674 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_oneexp7678 = new BitSet(new long[]{0xFFFE000000008010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_oneexp7686 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_oneexp7693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_propertyreference_in_tcs_instanceofexp7738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_tcs_instanceofexp7744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7751 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_tcs_instanceofexp7760 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_instanceofexp7768 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_tcs_stringval_in_tcs_value7811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_integerval_in_tcs_value7819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_negativeintegerval_in_tcs_value7827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_enumliteralval_in_tcs_value7835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringval7869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_integerval7916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_tcs_negativeintegerval7960 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_tcs_negativeintegerval7968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_tcs_enumliteralval8012 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_tcs_enumliteralval8020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_tcs_token8069 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_tcs_token8087 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_identifier_in_tcs_token8094 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COLON_in_tcs_token8103 = new BitSet(new long[]{0x0800000000204020L,0x0000008000200000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_token8111 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_SEMI_in_tcs_token8118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern8163 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_tcs_orpattern8172 = new BitSet(new long[]{0x0800000000200020L,0x0000008000200000L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_tcs_orpattern8180 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_tcs_rulepattern_in_tcs_simplepattern8225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_simplepattern8233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_classpattern_in_tcs_simplepattern8241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_rule_in_tcs_rulepattern8275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wordrule_in_tcs_rule8315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_endoflinerule_in_tcs_rule8323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_multilinerule_in_tcs_rule8331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_tcs_wordrule8361 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_wordrule8365 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_tcs_wordrule8369 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8373 = new BitSet(new long[]{0x0800000000220020L,0x0000008000200000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8381 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_tcs_wordrule8392 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8396 = new BitSet(new long[]{0x0800000000220420L,0x0000008000200000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8404 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_wordrule8417 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_tcs_wordrule8421 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_wordrule8425 = new BitSet(new long[]{0x0800000000200420L,0x0000008000200000L});
    public static final BitSet FOLLOW_tcs_orpattern_in_tcs_wordrule8433 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_wordrule8453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_tcs_endoflinerule8494 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_endoflinerule8498 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_tcs_endoflinerule8502 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_endoflinerule8506 = new BitSet(new long[]{0x0000000000000420L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_tcs_endoflinerule8516 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_endoflinerule8538 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_endoflinerule8545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_tcs_multilinerule8586 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8590 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_tcs_multilinerule8594 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8598 = new BitSet(new long[]{0x0000000000020020L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_tcs_multilinerule8608 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8630 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8637 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_109_in_tcs_multilinerule8641 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8645 = new BitSet(new long[]{0x0000000000020420L,0x0000000002000000L});
    public static final BitSet FOLLOW_89_in_tcs_multilinerule8655 = new BitSet(new long[]{0x0000000000020420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8677 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8690 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_tcs_multilinerule8694 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_tcs_multilinerule8698 = new BitSet(new long[]{0x0000000000020420L});
    public static final BitSet FOLLOW_tcs_stringpattern_in_tcs_multilinerule8706 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8719 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LPAREN_in_tcs_multilinerule8724 = new BitSet(new long[]{0x0000000100000410L,0x0000100000010000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8732 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_COMA_in_tcs_multilinerule8741 = new BitSet(new long[]{0x0000000100000010L,0x0000100000010000L});
    public static final BitSet FOLLOW_tcs_mapping_in_tcs_multilinerule8749 = new BitSet(new long[]{0x0000000000020400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8761 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RPAREN_in_tcs_multilinerule8792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplemapping_in_tcs_mapping8830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_wildcardmapping_in_tcs_mapping8838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_octalmapping_in_tcs_mapping8846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_hexadecimalmapping_in_tcs_mapping8854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8888 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_simplemapping8895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_tcs_simplemapping8903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8947 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RARROW_in_tcs_wildcardmapping8952 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_POINT_in_tcs_wildcardmapping8957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_tcs_octalmapping8998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_tcs_hexadecimalmapping9038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_tcs_stringpattern9082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_tcs_classpattern9128 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_identifier_in_tcs_classpattern9136 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_tcs_classpattern9145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCOLON_in_synpred89_TCS1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred115_TCS1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred120_TCS2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred138_TCS2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_textblockdefinition_textblockdefinition_in_synpred150_TCS3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequence__impl_in_synpred155_TCS3561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_synpred164_TCS3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_expression_in_synpred171_TCS4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred174_TCS4228 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred174_TCS4237 = new BitSet(new long[]{0xFFFE000033288230L,0xFFFFFFFFFFFFFFFFL,0x000000000000007FL});
    public static final BitSet FOLLOW_tcs_sequenceinalternative_in_synpred174_TCS4245 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COMA_in_synpred186_TCS4897 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_synpred186_TCS4901 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_synpred186_TCS4905 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_synpred186_TCS4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred252_TCS8163 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_synpred252_TCS8172 = new BitSet(new long[]{0x0800000000200020L,0x0000008000200000L});
    public static final BitSet FOLLOW_tcs_simplepattern_in_synpred252_TCS8180 = new BitSet(new long[]{0x0000000002000002L});

}