// $ANTLR 3.1.1 ./generationTemp/generated/TCS.g 2011-05-19 01:09:34

package com.sap.furcas.parser.tcs.stable;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.runtime.parser.impl.SemanticDisambRuleData;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistryFacade;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class TCSParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "INT", "FLOAT", "DLCOLON", "SHARP", "LPAREN", "EQ", "RPAREN", "LCURLY", "RCURLY", "SEMI", "RARROW", "COLON", "COMA", "LT", "GT", "LSQUARE", "RSQUARE", "QMARK", "DLSQUARE", "PIPE", "DRSQUARE", "STAR", "DOLLAR", "DLCURLY", "DRCURLY", "LARROW", "POINT", "MINUS", "COMMENT", "MULTI_LINE_COMMENT", "EXCL", "AROBAS", "SLASH", "PLUS", "GE", "LE", "NE", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "'deep'", "'context'", "'postfix'", "'source'", "'addToContext'", "'value'", "'leftSpace'", "'serializer'", "'rightSpace'", "'function'", "'disambiguateV3'", "'startNbNL'", "'referenceOnly'", "'left'", "'forcedLower'", "'and'", "'part'", "'word'", "'importContext'", "'disambiguate'", "'enumerationTemplate'", "'refersTo'", "'default'", "'operatorTemplate'", "'ifmissing'", "'k'", "'always'", "'createIn'", "'one'", "'keywords'", "'omitted'", "'drop'", "'storeOpTo'", "'when'", "'lookIn'", "'abstract'", "'indentIncr'", "'storeRightTo'", "'symbols'", "'lexer'", "'partial'", "'token'", "'multiLine'", "'prefix'", "'mode'", "'template'", "'nonPrimary'", "'semDisambiguate'", "'leftNone'", "'priority'", "'multi'", "'start'", "'foreach'", "'for'", "'hex'", "'end'", "'autoCreate'", "'operators'", "'endNL'", "'isDefined'", "'false'", "'syntax'", "'lookupScope'", "'endOfLine'", "'main'", "'esc'", "'using'", "'never'", "'referenceBy'", "'primitiveTemplate'", "'instanceOf'", "'right'", "'forcedUpper'", "'separator'", "'octal'", "'orKeyword'", "'rightNone'", "'true'", "'as'", "'all'", "'createAs'", "'auto'", "'startNL'", "'nbNL'", "'operatored'"
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
    public static final int RPAREN=12;
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
    public static final int SHARP=9;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LCURLY=13;
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
    public static final int LPAREN=10;
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
    public static final int RARROW=16;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int MINUS=33;
    public static final int RSQUARE=22;
    public static final int COMA=18;
    public static final int SEMI=15;
    public static final int MULTI_LINE_COMMENT=35;
    public static final int COLON=17;
    public static final int RCURLY=14;
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
    public String getGrammarFileName() { return "./generationTemp/generated/TCS.g"; }


       private static final String syntaxUUID = "_3pDRgIGjEeCb7d5HBRdM8w";
       public String getSyntaxUUID() {
            return syntaxUUID;
       }
        public String unescapeString(String s) {
            // get rid of the starting and ending delimiters (e.g., '\'', '"')
           int delimLength = 1; // for delimLength > 0, the following code needs to change
           if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                    s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
           }
           if(s.contains("\\\"")) {
                    s = s.replaceAll("\\\\\"", "\"");
           }
           return s;
        }




    // $ANTLR start "identifier"
    // ./generationTemp/generated/TCS.g:103:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:104:3: ( (ast= NAME ) )
            // ./generationTemp/generated/TCS.g:105:3: (ast= NAME )
            {
            // ./generationTemp/generated/TCS.g:105:3: (ast= NAME )
            // ./generationTemp/generated/TCS.g:105:4: ast= NAME
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
    // ./generationTemp/generated/TCS.g:113:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:114:3: ( (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' ) )
            // ./generationTemp/generated/TCS.g:115:3: (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' )
            {
            // ./generationTemp/generated/TCS.g:115:3: (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' )
            int alt1=86;
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
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:115:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword100); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:117:5: 'deep'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword108); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:118:5: 'context'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword116); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:119:5: 'postfix'
                    {
                    match(input,51,FOLLOW_51_in_identifierOrKeyword124); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 5 :
                    // ./generationTemp/generated/TCS.g:120:5: 'source'
                    {
                    match(input,52,FOLLOW_52_in_identifierOrKeyword132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 6 :
                    // ./generationTemp/generated/TCS.g:121:5: 'addToContext'
                    {
                    match(input,53,FOLLOW_53_in_identifierOrKeyword140); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
                    }

                    }
                    break;
                case 7 :
                    // ./generationTemp/generated/TCS.g:122:5: 'value'
                    {
                    match(input,54,FOLLOW_54_in_identifierOrKeyword148); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 8 :
                    // ./generationTemp/generated/TCS.g:123:5: 'leftSpace'
                    {
                    match(input,55,FOLLOW_55_in_identifierOrKeyword156); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
                    }

                    }
                    break;
                case 9 :
                    // ./generationTemp/generated/TCS.g:124:5: 'serializer'
                    {
                    match(input,56,FOLLOW_56_in_identifierOrKeyword164); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
                    }

                    }
                    break;
                case 10 :
                    // ./generationTemp/generated/TCS.g:125:5: 'rightSpace'
                    {
                    match(input,57,FOLLOW_57_in_identifierOrKeyword172); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 11 :
                    // ./generationTemp/generated/TCS.g:126:5: 'function'
                    {
                    match(input,58,FOLLOW_58_in_identifierOrKeyword180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 12 :
                    // ./generationTemp/generated/TCS.g:127:5: 'disambiguateV3'
                    {
                    match(input,59,FOLLOW_59_in_identifierOrKeyword188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 13 :
                    // ./generationTemp/generated/TCS.g:128:5: 'startNbNL'
                    {
                    match(input,60,FOLLOW_60_in_identifierOrKeyword196); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 14 :
                    // ./generationTemp/generated/TCS.g:129:5: 'referenceOnly'
                    {
                    match(input,61,FOLLOW_61_in_identifierOrKeyword204); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceOnly";
                    }

                    }
                    break;
                case 15 :
                    // ./generationTemp/generated/TCS.g:130:5: 'left'
                    {
                    match(input,62,FOLLOW_62_in_identifierOrKeyword212); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 16 :
                    // ./generationTemp/generated/TCS.g:131:5: 'forcedLower'
                    {
                    match(input,63,FOLLOW_63_in_identifierOrKeyword220); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 17 :
                    // ./generationTemp/generated/TCS.g:132:5: 'and'
                    {
                    match(input,64,FOLLOW_64_in_identifierOrKeyword228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 18 :
                    // ./generationTemp/generated/TCS.g:133:5: 'part'
                    {
                    match(input,65,FOLLOW_65_in_identifierOrKeyword236); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 19 :
                    // ./generationTemp/generated/TCS.g:134:5: 'word'
                    {
                    match(input,66,FOLLOW_66_in_identifierOrKeyword244); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 20 :
                    // ./generationTemp/generated/TCS.g:135:5: 'importContext'
                    {
                    match(input,67,FOLLOW_67_in_identifierOrKeyword252); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 21 :
                    // ./generationTemp/generated/TCS.g:136:5: 'disambiguate'
                    {
                    match(input,68,FOLLOW_68_in_identifierOrKeyword260); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 22 :
                    // ./generationTemp/generated/TCS.g:137:5: 'enumerationTemplate'
                    {
                    match(input,69,FOLLOW_69_in_identifierOrKeyword268); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 23 :
                    // ./generationTemp/generated/TCS.g:138:5: 'refersTo'
                    {
                    match(input,70,FOLLOW_70_in_identifierOrKeyword276); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 24 :
                    // ./generationTemp/generated/TCS.g:139:5: 'default'
                    {
                    match(input,71,FOLLOW_71_in_identifierOrKeyword284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 25 :
                    // ./generationTemp/generated/TCS.g:140:5: 'operatorTemplate'
                    {
                    match(input,72,FOLLOW_72_in_identifierOrKeyword292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 26 :
                    // ./generationTemp/generated/TCS.g:141:5: 'ifmissing'
                    {
                    match(input,73,FOLLOW_73_in_identifierOrKeyword300); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 27 :
                    // ./generationTemp/generated/TCS.g:142:5: 'k'
                    {
                    match(input,74,FOLLOW_74_in_identifierOrKeyword308); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 28 :
                    // ./generationTemp/generated/TCS.g:143:5: 'always'
                    {
                    match(input,75,FOLLOW_75_in_identifierOrKeyword316); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 29 :
                    // ./generationTemp/generated/TCS.g:144:5: 'createIn'
                    {
                    match(input,76,FOLLOW_76_in_identifierOrKeyword324); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 30 :
                    // ./generationTemp/generated/TCS.g:145:5: 'one'
                    {
                    match(input,77,FOLLOW_77_in_identifierOrKeyword332); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 31 :
                    // ./generationTemp/generated/TCS.g:146:5: 'keywords'
                    {
                    match(input,78,FOLLOW_78_in_identifierOrKeyword340); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
                    }

                    }
                    break;
                case 32 :
                    // ./generationTemp/generated/TCS.g:147:5: 'omitted'
                    {
                    match(input,79,FOLLOW_79_in_identifierOrKeyword348); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "omitted";
                    }

                    }
                    break;
                case 33 :
                    // ./generationTemp/generated/TCS.g:148:5: 'drop'
                    {
                    match(input,80,FOLLOW_80_in_identifierOrKeyword356); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 34 :
                    // ./generationTemp/generated/TCS.g:149:5: 'storeOpTo'
                    {
                    match(input,81,FOLLOW_81_in_identifierOrKeyword364); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 35 :
                    // ./generationTemp/generated/TCS.g:150:5: 'when'
                    {
                    match(input,82,FOLLOW_82_in_identifierOrKeyword372); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "when";
                    }

                    }
                    break;
                case 36 :
                    // ./generationTemp/generated/TCS.g:151:5: 'lookIn'
                    {
                    match(input,83,FOLLOW_83_in_identifierOrKeyword380); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 37 :
                    // ./generationTemp/generated/TCS.g:152:5: 'abstract'
                    {
                    match(input,84,FOLLOW_84_in_identifierOrKeyword388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 38 :
                    // ./generationTemp/generated/TCS.g:153:5: 'indentIncr'
                    {
                    match(input,85,FOLLOW_85_in_identifierOrKeyword396); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 39 :
                    // ./generationTemp/generated/TCS.g:154:5: 'storeRightTo'
                    {
                    match(input,86,FOLLOW_86_in_identifierOrKeyword404); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 40 :
                    // ./generationTemp/generated/TCS.g:155:5: 'symbols'
                    {
                    match(input,87,FOLLOW_87_in_identifierOrKeyword412); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 41 :
                    // ./generationTemp/generated/TCS.g:156:5: 'lexer'
                    {
                    match(input,88,FOLLOW_88_in_identifierOrKeyword420); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 42 :
                    // ./generationTemp/generated/TCS.g:157:5: 'partial'
                    {
                    match(input,89,FOLLOW_89_in_identifierOrKeyword428); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "partial";
                    }

                    }
                    break;
                case 43 :
                    // ./generationTemp/generated/TCS.g:158:5: 'token'
                    {
                    match(input,90,FOLLOW_90_in_identifierOrKeyword436); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 44 :
                    // ./generationTemp/generated/TCS.g:159:5: 'multiLine'
                    {
                    match(input,91,FOLLOW_91_in_identifierOrKeyword444); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 45 :
                    // ./generationTemp/generated/TCS.g:160:5: 'prefix'
                    {
                    match(input,92,FOLLOW_92_in_identifierOrKeyword452); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 46 :
                    // ./generationTemp/generated/TCS.g:161:5: 'mode'
                    {
                    match(input,93,FOLLOW_93_in_identifierOrKeyword460); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 47 :
                    // ./generationTemp/generated/TCS.g:162:5: 'template'
                    {
                    match(input,94,FOLLOW_94_in_identifierOrKeyword468); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 48 :
                    // ./generationTemp/generated/TCS.g:163:5: 'nonPrimary'
                    {
                    match(input,95,FOLLOW_95_in_identifierOrKeyword476); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 49 :
                    // ./generationTemp/generated/TCS.g:164:5: 'semDisambiguate'
                    {
                    match(input,96,FOLLOW_96_in_identifierOrKeyword484); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "semDisambiguate";
                    }

                    }
                    break;
                case 50 :
                    // ./generationTemp/generated/TCS.g:165:5: 'leftNone'
                    {
                    match(input,97,FOLLOW_97_in_identifierOrKeyword492); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 51 :
                    // ./generationTemp/generated/TCS.g:166:5: 'priority'
                    {
                    match(input,98,FOLLOW_98_in_identifierOrKeyword500); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 52 :
                    // ./generationTemp/generated/TCS.g:167:5: 'multi'
                    {
                    match(input,99,FOLLOW_99_in_identifierOrKeyword508); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 53 :
                    // ./generationTemp/generated/TCS.g:168:5: 'start'
                    {
                    match(input,100,FOLLOW_100_in_identifierOrKeyword516); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 54 :
                    // ./generationTemp/generated/TCS.g:169:5: 'foreach'
                    {
                    match(input,101,FOLLOW_101_in_identifierOrKeyword524); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 55 :
                    // ./generationTemp/generated/TCS.g:170:5: 'for'
                    {
                    match(input,102,FOLLOW_102_in_identifierOrKeyword532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 56 :
                    // ./generationTemp/generated/TCS.g:171:5: 'hex'
                    {
                    match(input,103,FOLLOW_103_in_identifierOrKeyword540); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 57 :
                    // ./generationTemp/generated/TCS.g:172:5: 'end'
                    {
                    match(input,104,FOLLOW_104_in_identifierOrKeyword548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 58 :
                    // ./generationTemp/generated/TCS.g:173:5: 'autoCreate'
                    {
                    match(input,105,FOLLOW_105_in_identifierOrKeyword556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 59 :
                    // ./generationTemp/generated/TCS.g:174:5: 'operators'
                    {
                    match(input,106,FOLLOW_106_in_identifierOrKeyword564); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 60 :
                    // ./generationTemp/generated/TCS.g:175:5: 'endNL'
                    {
                    match(input,107,FOLLOW_107_in_identifierOrKeyword572); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 61 :
                    // ./generationTemp/generated/TCS.g:176:5: 'isDefined'
                    {
                    match(input,108,FOLLOW_108_in_identifierOrKeyword580); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 62 :
                    // ./generationTemp/generated/TCS.g:177:5: 'false'
                    {
                    match(input,109,FOLLOW_109_in_identifierOrKeyword588); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 63 :
                    // ./generationTemp/generated/TCS.g:178:5: 'syntax'
                    {
                    match(input,110,FOLLOW_110_in_identifierOrKeyword596); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 64 :
                    // ./generationTemp/generated/TCS.g:179:5: 'lookupScope'
                    {
                    match(input,111,FOLLOW_111_in_identifierOrKeyword604); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookupScope";
                    }

                    }
                    break;
                case 65 :
                    // ./generationTemp/generated/TCS.g:180:5: 'endOfLine'
                    {
                    match(input,112,FOLLOW_112_in_identifierOrKeyword612); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 66 :
                    // ./generationTemp/generated/TCS.g:181:5: 'main'
                    {
                    match(input,113,FOLLOW_113_in_identifierOrKeyword620); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 67 :
                    // ./generationTemp/generated/TCS.g:182:5: 'esc'
                    {
                    match(input,114,FOLLOW_114_in_identifierOrKeyword628); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 68 :
                    // ./generationTemp/generated/TCS.g:183:5: 'using'
                    {
                    match(input,115,FOLLOW_115_in_identifierOrKeyword636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 69 :
                    // ./generationTemp/generated/TCS.g:184:5: 'never'
                    {
                    match(input,116,FOLLOW_116_in_identifierOrKeyword644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 70 :
                    // ./generationTemp/generated/TCS.g:185:5: 'referenceBy'
                    {
                    match(input,117,FOLLOW_117_in_identifierOrKeyword652); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceBy";
                    }

                    }
                    break;
                case 71 :
                    // ./generationTemp/generated/TCS.g:186:5: 'primitiveTemplate'
                    {
                    match(input,118,FOLLOW_118_in_identifierOrKeyword660); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 72 :
                    // ./generationTemp/generated/TCS.g:187:5: 'instanceOf'
                    {
                    match(input,119,FOLLOW_119_in_identifierOrKeyword668); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "instanceOf";
                    }

                    }
                    break;
                case 73 :
                    // ./generationTemp/generated/TCS.g:188:5: 'right'
                    {
                    match(input,120,FOLLOW_120_in_identifierOrKeyword676); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 74 :
                    // ./generationTemp/generated/TCS.g:189:5: 'forcedUpper'
                    {
                    match(input,121,FOLLOW_121_in_identifierOrKeyword684); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedUpper";
                    }

                    }
                    break;
                case 75 :
                    // ./generationTemp/generated/TCS.g:190:5: 'separator'
                    {
                    match(input,122,FOLLOW_122_in_identifierOrKeyword692); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 76 :
                    // ./generationTemp/generated/TCS.g:191:5: 'octal'
                    {
                    match(input,123,FOLLOW_123_in_identifierOrKeyword700); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 77 :
                    // ./generationTemp/generated/TCS.g:192:5: 'orKeyword'
                    {
                    match(input,124,FOLLOW_124_in_identifierOrKeyword708); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 78 :
                    // ./generationTemp/generated/TCS.g:193:5: 'rightNone'
                    {
                    match(input,125,FOLLOW_125_in_identifierOrKeyword716); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 79 :
                    // ./generationTemp/generated/TCS.g:194:5: 'true'
                    {
                    match(input,126,FOLLOW_126_in_identifierOrKeyword724); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 80 :
                    // ./generationTemp/generated/TCS.g:195:5: 'as'
                    {
                    match(input,127,FOLLOW_127_in_identifierOrKeyword732); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 81 :
                    // ./generationTemp/generated/TCS.g:196:5: 'all'
                    {
                    match(input,128,FOLLOW_128_in_identifierOrKeyword740); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 82 :
                    // ./generationTemp/generated/TCS.g:197:5: 'createAs'
                    {
                    match(input,129,FOLLOW_129_in_identifierOrKeyword748); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 83 :
                    // ./generationTemp/generated/TCS.g:198:5: 'auto'
                    {
                    match(input,130,FOLLOW_130_in_identifierOrKeyword756); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 84 :
                    // ./generationTemp/generated/TCS.g:199:5: 'startNL'
                    {
                    match(input,131,FOLLOW_131_in_identifierOrKeyword764); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 85 :
                    // ./generationTemp/generated/TCS.g:200:5: 'nbNL'
                    {
                    match(input,132,FOLLOW_132_in_identifierOrKeyword772); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 86 :
                    // ./generationTemp/generated/TCS.g:201:5: 'operatored'
                    {
                    match(input,133,FOLLOW_133_in_identifierOrKeyword780); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
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


    // $ANTLR start "escapedIdentifierOrKeyword"
    // ./generationTemp/generated/TCS.g:208:1: escapedIdentifierOrKeyword returns [Object ret2] : (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' ) ;
    public final Object escapedIdentifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:209:3: ( (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' ) )
            // ./generationTemp/generated/TCS.g:210:3: (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' )
            {
            // ./generationTemp/generated/TCS.g:210:3: (ast= NAME | 'deep' | 'context' | 'postfix' | 'source' | 'addToContext' | 'value' | 'leftSpace' | 'serializer' | 'rightSpace' | 'function' | 'disambiguateV3' | 'startNbNL' | 'referenceOnly' | 'left' | 'forcedLower' | 'and' | 'part' | 'word' | 'importContext' | 'disambiguate' | 'enumerationTemplate' | 'refersTo' | 'default' | 'operatorTemplate' | 'ifmissing' | 'k' | 'always' | 'createIn' | 'one' | 'keywords' | 'omitted' | 'drop' | 'storeOpTo' | 'when' | 'lookIn' | 'abstract' | 'indentIncr' | 'storeRightTo' | 'symbols' | 'lexer' | 'partial' | 'token' | 'multiLine' | 'prefix' | 'mode' | 'template' | 'nonPrimary' | 'semDisambiguate' | 'leftNone' | 'priority' | 'multi' | 'start' | 'foreach' | 'for' | 'hex' | 'end' | 'autoCreate' | 'operators' | 'endNL' | 'isDefined' | 'false' | 'syntax' | 'lookupScope' | 'endOfLine' | 'main' | 'esc' | 'using' | 'never' | 'referenceBy' | 'primitiveTemplate' | 'instanceOf' | 'right' | 'forcedUpper' | 'separator' | 'octal' | 'orKeyword' | 'rightNone' | 'true' | 'as' | 'all' | 'createAs' | 'auto' | 'startNL' | 'nbNL' | 'operatored' )
            int alt2=86;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt2=1;
                }
                break;
            case 49:
                {
                alt2=2;
                }
                break;
            case 50:
                {
                alt2=3;
                }
                break;
            case 51:
                {
                alt2=4;
                }
                break;
            case 52:
                {
                alt2=5;
                }
                break;
            case 53:
                {
                alt2=6;
                }
                break;
            case 54:
                {
                alt2=7;
                }
                break;
            case 55:
                {
                alt2=8;
                }
                break;
            case 56:
                {
                alt2=9;
                }
                break;
            case 57:
                {
                alt2=10;
                }
                break;
            case 58:
                {
                alt2=11;
                }
                break;
            case 59:
                {
                alt2=12;
                }
                break;
            case 60:
                {
                alt2=13;
                }
                break;
            case 61:
                {
                alt2=14;
                }
                break;
            case 62:
                {
                alt2=15;
                }
                break;
            case 63:
                {
                alt2=16;
                }
                break;
            case 64:
                {
                alt2=17;
                }
                break;
            case 65:
                {
                alt2=18;
                }
                break;
            case 66:
                {
                alt2=19;
                }
                break;
            case 67:
                {
                alt2=20;
                }
                break;
            case 68:
                {
                alt2=21;
                }
                break;
            case 69:
                {
                alt2=22;
                }
                break;
            case 70:
                {
                alt2=23;
                }
                break;
            case 71:
                {
                alt2=24;
                }
                break;
            case 72:
                {
                alt2=25;
                }
                break;
            case 73:
                {
                alt2=26;
                }
                break;
            case 74:
                {
                alt2=27;
                }
                break;
            case 75:
                {
                alt2=28;
                }
                break;
            case 76:
                {
                alt2=29;
                }
                break;
            case 77:
                {
                alt2=30;
                }
                break;
            case 78:
                {
                alt2=31;
                }
                break;
            case 79:
                {
                alt2=32;
                }
                break;
            case 80:
                {
                alt2=33;
                }
                break;
            case 81:
                {
                alt2=34;
                }
                break;
            case 82:
                {
                alt2=35;
                }
                break;
            case 83:
                {
                alt2=36;
                }
                break;
            case 84:
                {
                alt2=37;
                }
                break;
            case 85:
                {
                alt2=38;
                }
                break;
            case 86:
                {
                alt2=39;
                }
                break;
            case 87:
                {
                alt2=40;
                }
                break;
            case 88:
                {
                alt2=41;
                }
                break;
            case 89:
                {
                alt2=42;
                }
                break;
            case 90:
                {
                alt2=43;
                }
                break;
            case 91:
                {
                alt2=44;
                }
                break;
            case 92:
                {
                alt2=45;
                }
                break;
            case 93:
                {
                alt2=46;
                }
                break;
            case 94:
                {
                alt2=47;
                }
                break;
            case 95:
                {
                alt2=48;
                }
                break;
            case 96:
                {
                alt2=49;
                }
                break;
            case 97:
                {
                alt2=50;
                }
                break;
            case 98:
                {
                alt2=51;
                }
                break;
            case 99:
                {
                alt2=52;
                }
                break;
            case 100:
                {
                alt2=53;
                }
                break;
            case 101:
                {
                alt2=54;
                }
                break;
            case 102:
                {
                alt2=55;
                }
                break;
            case 103:
                {
                alt2=56;
                }
                break;
            case 104:
                {
                alt2=57;
                }
                break;
            case 105:
                {
                alt2=58;
                }
                break;
            case 106:
                {
                alt2=59;
                }
                break;
            case 107:
                {
                alt2=60;
                }
                break;
            case 108:
                {
                alt2=61;
                }
                break;
            case 109:
                {
                alt2=62;
                }
                break;
            case 110:
                {
                alt2=63;
                }
                break;
            case 111:
                {
                alt2=64;
                }
                break;
            case 112:
                {
                alt2=65;
                }
                break;
            case 113:
                {
                alt2=66;
                }
                break;
            case 114:
                {
                alt2=67;
                }
                break;
            case 115:
                {
                alt2=68;
                }
                break;
            case 116:
                {
                alt2=69;
                }
                break;
            case 117:
                {
                alt2=70;
                }
                break;
            case 118:
                {
                alt2=71;
                }
                break;
            case 119:
                {
                alt2=72;
                }
                break;
            case 120:
                {
                alt2=73;
                }
                break;
            case 121:
                {
                alt2=74;
                }
                break;
            case 122:
                {
                alt2=75;
                }
                break;
            case 123:
                {
                alt2=76;
                }
                break;
            case 124:
                {
                alt2=77;
                }
                break;
            case 125:
                {
                alt2=78;
                }
                break;
            case 126:
                {
                alt2=79;
                }
                break;
            case 127:
                {
                alt2=80;
                }
                break;
            case 128:
                {
                alt2=81;
                }
                break;
            case 129:
                {
                alt2=82;
                }
                break;
            case 130:
                {
                alt2=83;
                }
                break;
            case 131:
                {
                alt2=84;
                }
                break;
            case 132:
                {
                alt2=85;
                }
                break;
            case 133:
                {
                alt2=86;
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
                    // ./generationTemp/generated/TCS.g:210:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_escapedIdentifierOrKeyword811); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:212:5: 'deep'
                    {
                    match(input,49,FOLLOW_49_in_escapedIdentifierOrKeyword819); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "deep";
                    }

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:213:5: 'context'
                    {
                    match(input,50,FOLLOW_50_in_escapedIdentifierOrKeyword827); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "context";
                    }

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:214:5: 'postfix'
                    {
                    match(input,51,FOLLOW_51_in_escapedIdentifierOrKeyword835); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "postfix";
                    }

                    }
                    break;
                case 5 :
                    // ./generationTemp/generated/TCS.g:215:5: 'source'
                    {
                    match(input,52,FOLLOW_52_in_escapedIdentifierOrKeyword843); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "source";
                    }

                    }
                    break;
                case 6 :
                    // ./generationTemp/generated/TCS.g:216:5: 'addToContext'
                    {
                    match(input,53,FOLLOW_53_in_escapedIdentifierOrKeyword851); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "addToContext";
                    }

                    }
                    break;
                case 7 :
                    // ./generationTemp/generated/TCS.g:217:5: 'value'
                    {
                    match(input,54,FOLLOW_54_in_escapedIdentifierOrKeyword859); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "value";
                    }

                    }
                    break;
                case 8 :
                    // ./generationTemp/generated/TCS.g:218:5: 'leftSpace'
                    {
                    match(input,55,FOLLOW_55_in_escapedIdentifierOrKeyword867); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftSpace";
                    }

                    }
                    break;
                case 9 :
                    // ./generationTemp/generated/TCS.g:219:5: 'serializer'
                    {
                    match(input,56,FOLLOW_56_in_escapedIdentifierOrKeyword875); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "serializer";
                    }

                    }
                    break;
                case 10 :
                    // ./generationTemp/generated/TCS.g:220:5: 'rightSpace'
                    {
                    match(input,57,FOLLOW_57_in_escapedIdentifierOrKeyword883); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightSpace";
                    }

                    }
                    break;
                case 11 :
                    // ./generationTemp/generated/TCS.g:221:5: 'function'
                    {
                    match(input,58,FOLLOW_58_in_escapedIdentifierOrKeyword891); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "function";
                    }

                    }
                    break;
                case 12 :
                    // ./generationTemp/generated/TCS.g:222:5: 'disambiguateV3'
                    {
                    match(input,59,FOLLOW_59_in_escapedIdentifierOrKeyword899); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguateV3";
                    }

                    }
                    break;
                case 13 :
                    // ./generationTemp/generated/TCS.g:223:5: 'startNbNL'
                    {
                    match(input,60,FOLLOW_60_in_escapedIdentifierOrKeyword907); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNbNL";
                    }

                    }
                    break;
                case 14 :
                    // ./generationTemp/generated/TCS.g:224:5: 'referenceOnly'
                    {
                    match(input,61,FOLLOW_61_in_escapedIdentifierOrKeyword915); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceOnly";
                    }

                    }
                    break;
                case 15 :
                    // ./generationTemp/generated/TCS.g:225:5: 'left'
                    {
                    match(input,62,FOLLOW_62_in_escapedIdentifierOrKeyword923); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "left";
                    }

                    }
                    break;
                case 16 :
                    // ./generationTemp/generated/TCS.g:226:5: 'forcedLower'
                    {
                    match(input,63,FOLLOW_63_in_escapedIdentifierOrKeyword931); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedLower";
                    }

                    }
                    break;
                case 17 :
                    // ./generationTemp/generated/TCS.g:227:5: 'and'
                    {
                    match(input,64,FOLLOW_64_in_escapedIdentifierOrKeyword939); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "and";
                    }

                    }
                    break;
                case 18 :
                    // ./generationTemp/generated/TCS.g:228:5: 'part'
                    {
                    match(input,65,FOLLOW_65_in_escapedIdentifierOrKeyword947); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "part";
                    }

                    }
                    break;
                case 19 :
                    // ./generationTemp/generated/TCS.g:229:5: 'word'
                    {
                    match(input,66,FOLLOW_66_in_escapedIdentifierOrKeyword955); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "word";
                    }

                    }
                    break;
                case 20 :
                    // ./generationTemp/generated/TCS.g:230:5: 'importContext'
                    {
                    match(input,67,FOLLOW_67_in_escapedIdentifierOrKeyword963); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "importContext";
                    }

                    }
                    break;
                case 21 :
                    // ./generationTemp/generated/TCS.g:231:5: 'disambiguate'
                    {
                    match(input,68,FOLLOW_68_in_escapedIdentifierOrKeyword971); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "disambiguate";
                    }

                    }
                    break;
                case 22 :
                    // ./generationTemp/generated/TCS.g:232:5: 'enumerationTemplate'
                    {
                    match(input,69,FOLLOW_69_in_escapedIdentifierOrKeyword979); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "enumerationTemplate";
                    }

                    }
                    break;
                case 23 :
                    // ./generationTemp/generated/TCS.g:233:5: 'refersTo'
                    {
                    match(input,70,FOLLOW_70_in_escapedIdentifierOrKeyword987); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "refersTo";
                    }

                    }
                    break;
                case 24 :
                    // ./generationTemp/generated/TCS.g:234:5: 'default'
                    {
                    match(input,71,FOLLOW_71_in_escapedIdentifierOrKeyword995); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "default";
                    }

                    }
                    break;
                case 25 :
                    // ./generationTemp/generated/TCS.g:235:5: 'operatorTemplate'
                    {
                    match(input,72,FOLLOW_72_in_escapedIdentifierOrKeyword1003); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatorTemplate";
                    }

                    }
                    break;
                case 26 :
                    // ./generationTemp/generated/TCS.g:236:5: 'ifmissing'
                    {
                    match(input,73,FOLLOW_73_in_escapedIdentifierOrKeyword1011); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "ifmissing";
                    }

                    }
                    break;
                case 27 :
                    // ./generationTemp/generated/TCS.g:237:5: 'k'
                    {
                    match(input,74,FOLLOW_74_in_escapedIdentifierOrKeyword1019); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "k";
                    }

                    }
                    break;
                case 28 :
                    // ./generationTemp/generated/TCS.g:238:5: 'always'
                    {
                    match(input,75,FOLLOW_75_in_escapedIdentifierOrKeyword1027); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "always";
                    }

                    }
                    break;
                case 29 :
                    // ./generationTemp/generated/TCS.g:239:5: 'createIn'
                    {
                    match(input,76,FOLLOW_76_in_escapedIdentifierOrKeyword1035); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createIn";
                    }

                    }
                    break;
                case 30 :
                    // ./generationTemp/generated/TCS.g:240:5: 'one'
                    {
                    match(input,77,FOLLOW_77_in_escapedIdentifierOrKeyword1043); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "one";
                    }

                    }
                    break;
                case 31 :
                    // ./generationTemp/generated/TCS.g:241:5: 'keywords'
                    {
                    match(input,78,FOLLOW_78_in_escapedIdentifierOrKeyword1051); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "keywords";
                    }

                    }
                    break;
                case 32 :
                    // ./generationTemp/generated/TCS.g:242:5: 'omitted'
                    {
                    match(input,79,FOLLOW_79_in_escapedIdentifierOrKeyword1059); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "omitted";
                    }

                    }
                    break;
                case 33 :
                    // ./generationTemp/generated/TCS.g:243:5: 'drop'
                    {
                    match(input,80,FOLLOW_80_in_escapedIdentifierOrKeyword1067); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "drop";
                    }

                    }
                    break;
                case 34 :
                    // ./generationTemp/generated/TCS.g:244:5: 'storeOpTo'
                    {
                    match(input,81,FOLLOW_81_in_escapedIdentifierOrKeyword1075); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeOpTo";
                    }

                    }
                    break;
                case 35 :
                    // ./generationTemp/generated/TCS.g:245:5: 'when'
                    {
                    match(input,82,FOLLOW_82_in_escapedIdentifierOrKeyword1083); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "when";
                    }

                    }
                    break;
                case 36 :
                    // ./generationTemp/generated/TCS.g:246:5: 'lookIn'
                    {
                    match(input,83,FOLLOW_83_in_escapedIdentifierOrKeyword1091); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookIn";
                    }

                    }
                    break;
                case 37 :
                    // ./generationTemp/generated/TCS.g:247:5: 'abstract'
                    {
                    match(input,84,FOLLOW_84_in_escapedIdentifierOrKeyword1099); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "abstract";
                    }

                    }
                    break;
                case 38 :
                    // ./generationTemp/generated/TCS.g:248:5: 'indentIncr'
                    {
                    match(input,85,FOLLOW_85_in_escapedIdentifierOrKeyword1107); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "indentIncr";
                    }

                    }
                    break;
                case 39 :
                    // ./generationTemp/generated/TCS.g:249:5: 'storeRightTo'
                    {
                    match(input,86,FOLLOW_86_in_escapedIdentifierOrKeyword1115); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "storeRightTo";
                    }

                    }
                    break;
                case 40 :
                    // ./generationTemp/generated/TCS.g:250:5: 'symbols'
                    {
                    match(input,87,FOLLOW_87_in_escapedIdentifierOrKeyword1123); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "symbols";
                    }

                    }
                    break;
                case 41 :
                    // ./generationTemp/generated/TCS.g:251:5: 'lexer'
                    {
                    match(input,88,FOLLOW_88_in_escapedIdentifierOrKeyword1131); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lexer";
                    }

                    }
                    break;
                case 42 :
                    // ./generationTemp/generated/TCS.g:252:5: 'partial'
                    {
                    match(input,89,FOLLOW_89_in_escapedIdentifierOrKeyword1139); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "partial";
                    }

                    }
                    break;
                case 43 :
                    // ./generationTemp/generated/TCS.g:253:5: 'token'
                    {
                    match(input,90,FOLLOW_90_in_escapedIdentifierOrKeyword1147); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "token";
                    }

                    }
                    break;
                case 44 :
                    // ./generationTemp/generated/TCS.g:254:5: 'multiLine'
                    {
                    match(input,91,FOLLOW_91_in_escapedIdentifierOrKeyword1155); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multiLine";
                    }

                    }
                    break;
                case 45 :
                    // ./generationTemp/generated/TCS.g:255:5: 'prefix'
                    {
                    match(input,92,FOLLOW_92_in_escapedIdentifierOrKeyword1163); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "prefix";
                    }

                    }
                    break;
                case 46 :
                    // ./generationTemp/generated/TCS.g:256:5: 'mode'
                    {
                    match(input,93,FOLLOW_93_in_escapedIdentifierOrKeyword1171); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "mode";
                    }

                    }
                    break;
                case 47 :
                    // ./generationTemp/generated/TCS.g:257:5: 'template'
                    {
                    match(input,94,FOLLOW_94_in_escapedIdentifierOrKeyword1179); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "template";
                    }

                    }
                    break;
                case 48 :
                    // ./generationTemp/generated/TCS.g:258:5: 'nonPrimary'
                    {
                    match(input,95,FOLLOW_95_in_escapedIdentifierOrKeyword1187); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nonPrimary";
                    }

                    }
                    break;
                case 49 :
                    // ./generationTemp/generated/TCS.g:259:5: 'semDisambiguate'
                    {
                    match(input,96,FOLLOW_96_in_escapedIdentifierOrKeyword1195); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "semDisambiguate";
                    }

                    }
                    break;
                case 50 :
                    // ./generationTemp/generated/TCS.g:260:5: 'leftNone'
                    {
                    match(input,97,FOLLOW_97_in_escapedIdentifierOrKeyword1203); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "leftNone";
                    }

                    }
                    break;
                case 51 :
                    // ./generationTemp/generated/TCS.g:261:5: 'priority'
                    {
                    match(input,98,FOLLOW_98_in_escapedIdentifierOrKeyword1211); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "priority";
                    }

                    }
                    break;
                case 52 :
                    // ./generationTemp/generated/TCS.g:262:5: 'multi'
                    {
                    match(input,99,FOLLOW_99_in_escapedIdentifierOrKeyword1219); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "multi";
                    }

                    }
                    break;
                case 53 :
                    // ./generationTemp/generated/TCS.g:263:5: 'start'
                    {
                    match(input,100,FOLLOW_100_in_escapedIdentifierOrKeyword1227); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "start";
                    }

                    }
                    break;
                case 54 :
                    // ./generationTemp/generated/TCS.g:264:5: 'foreach'
                    {
                    match(input,101,FOLLOW_101_in_escapedIdentifierOrKeyword1235); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "foreach";
                    }

                    }
                    break;
                case 55 :
                    // ./generationTemp/generated/TCS.g:265:5: 'for'
                    {
                    match(input,102,FOLLOW_102_in_escapedIdentifierOrKeyword1243); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "for";
                    }

                    }
                    break;
                case 56 :
                    // ./generationTemp/generated/TCS.g:266:5: 'hex'
                    {
                    match(input,103,FOLLOW_103_in_escapedIdentifierOrKeyword1251); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "hex";
                    }

                    }
                    break;
                case 57 :
                    // ./generationTemp/generated/TCS.g:267:5: 'end'
                    {
                    match(input,104,FOLLOW_104_in_escapedIdentifierOrKeyword1259); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "end";
                    }

                    }
                    break;
                case 58 :
                    // ./generationTemp/generated/TCS.g:268:5: 'autoCreate'
                    {
                    match(input,105,FOLLOW_105_in_escapedIdentifierOrKeyword1267); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "autoCreate";
                    }

                    }
                    break;
                case 59 :
                    // ./generationTemp/generated/TCS.g:269:5: 'operators'
                    {
                    match(input,106,FOLLOW_106_in_escapedIdentifierOrKeyword1275); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operators";
                    }

                    }
                    break;
                case 60 :
                    // ./generationTemp/generated/TCS.g:270:5: 'endNL'
                    {
                    match(input,107,FOLLOW_107_in_escapedIdentifierOrKeyword1283); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endNL";
                    }

                    }
                    break;
                case 61 :
                    // ./generationTemp/generated/TCS.g:271:5: 'isDefined'
                    {
                    match(input,108,FOLLOW_108_in_escapedIdentifierOrKeyword1291); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "isDefined";
                    }

                    }
                    break;
                case 62 :
                    // ./generationTemp/generated/TCS.g:272:5: 'false'
                    {
                    match(input,109,FOLLOW_109_in_escapedIdentifierOrKeyword1299); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "false";
                    }

                    }
                    break;
                case 63 :
                    // ./generationTemp/generated/TCS.g:273:5: 'syntax'
                    {
                    match(input,110,FOLLOW_110_in_escapedIdentifierOrKeyword1307); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "syntax";
                    }

                    }
                    break;
                case 64 :
                    // ./generationTemp/generated/TCS.g:274:5: 'lookupScope'
                    {
                    match(input,111,FOLLOW_111_in_escapedIdentifierOrKeyword1315); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "lookupScope";
                    }

                    }
                    break;
                case 65 :
                    // ./generationTemp/generated/TCS.g:275:5: 'endOfLine'
                    {
                    match(input,112,FOLLOW_112_in_escapedIdentifierOrKeyword1323); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endOfLine";
                    }

                    }
                    break;
                case 66 :
                    // ./generationTemp/generated/TCS.g:276:5: 'main'
                    {
                    match(input,113,FOLLOW_113_in_escapedIdentifierOrKeyword1331); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "main";
                    }

                    }
                    break;
                case 67 :
                    // ./generationTemp/generated/TCS.g:277:5: 'esc'
                    {
                    match(input,114,FOLLOW_114_in_escapedIdentifierOrKeyword1339); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "esc";
                    }

                    }
                    break;
                case 68 :
                    // ./generationTemp/generated/TCS.g:278:5: 'using'
                    {
                    match(input,115,FOLLOW_115_in_escapedIdentifierOrKeyword1347); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "using";
                    }

                    }
                    break;
                case 69 :
                    // ./generationTemp/generated/TCS.g:279:5: 'never'
                    {
                    match(input,116,FOLLOW_116_in_escapedIdentifierOrKeyword1355); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "never";
                    }

                    }
                    break;
                case 70 :
                    // ./generationTemp/generated/TCS.g:280:5: 'referenceBy'
                    {
                    match(input,117,FOLLOW_117_in_escapedIdentifierOrKeyword1363); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "referenceBy";
                    }

                    }
                    break;
                case 71 :
                    // ./generationTemp/generated/TCS.g:281:5: 'primitiveTemplate'
                    {
                    match(input,118,FOLLOW_118_in_escapedIdentifierOrKeyword1371); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "primitiveTemplate";
                    }

                    }
                    break;
                case 72 :
                    // ./generationTemp/generated/TCS.g:282:5: 'instanceOf'
                    {
                    match(input,119,FOLLOW_119_in_escapedIdentifierOrKeyword1379); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "instanceOf";
                    }

                    }
                    break;
                case 73 :
                    // ./generationTemp/generated/TCS.g:283:5: 'right'
                    {
                    match(input,120,FOLLOW_120_in_escapedIdentifierOrKeyword1387); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "right";
                    }

                    }
                    break;
                case 74 :
                    // ./generationTemp/generated/TCS.g:284:5: 'forcedUpper'
                    {
                    match(input,121,FOLLOW_121_in_escapedIdentifierOrKeyword1395); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "forcedUpper";
                    }

                    }
                    break;
                case 75 :
                    // ./generationTemp/generated/TCS.g:285:5: 'separator'
                    {
                    match(input,122,FOLLOW_122_in_escapedIdentifierOrKeyword1403); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "separator";
                    }

                    }
                    break;
                case 76 :
                    // ./generationTemp/generated/TCS.g:286:5: 'octal'
                    {
                    match(input,123,FOLLOW_123_in_escapedIdentifierOrKeyword1411); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "octal";
                    }

                    }
                    break;
                case 77 :
                    // ./generationTemp/generated/TCS.g:287:5: 'orKeyword'
                    {
                    match(input,124,FOLLOW_124_in_escapedIdentifierOrKeyword1419); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "orKeyword";
                    }

                    }
                    break;
                case 78 :
                    // ./generationTemp/generated/TCS.g:288:5: 'rightNone'
                    {
                    match(input,125,FOLLOW_125_in_escapedIdentifierOrKeyword1427); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "rightNone";
                    }

                    }
                    break;
                case 79 :
                    // ./generationTemp/generated/TCS.g:289:5: 'true'
                    {
                    match(input,126,FOLLOW_126_in_escapedIdentifierOrKeyword1435); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "true";
                    }

                    }
                    break;
                case 80 :
                    // ./generationTemp/generated/TCS.g:290:5: 'as'
                    {
                    match(input,127,FOLLOW_127_in_escapedIdentifierOrKeyword1443); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "as";
                    }

                    }
                    break;
                case 81 :
                    // ./generationTemp/generated/TCS.g:291:5: 'all'
                    {
                    match(input,128,FOLLOW_128_in_escapedIdentifierOrKeyword1451); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "all";
                    }

                    }
                    break;
                case 82 :
                    // ./generationTemp/generated/TCS.g:292:5: 'createAs'
                    {
                    match(input,129,FOLLOW_129_in_escapedIdentifierOrKeyword1459); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "createAs";
                    }

                    }
                    break;
                case 83 :
                    // ./generationTemp/generated/TCS.g:293:5: 'auto'
                    {
                    match(input,130,FOLLOW_130_in_escapedIdentifierOrKeyword1467); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "auto";
                    }

                    }
                    break;
                case 84 :
                    // ./generationTemp/generated/TCS.g:294:5: 'startNL'
                    {
                    match(input,131,FOLLOW_131_in_escapedIdentifierOrKeyword1475); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "startNL";
                    }

                    }
                    break;
                case 85 :
                    // ./generationTemp/generated/TCS.g:295:5: 'nbNL'
                    {
                    match(input,132,FOLLOW_132_in_escapedIdentifierOrKeyword1483); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "nbNL";
                    }

                    }
                    break;
                case 86 :
                    // ./generationTemp/generated/TCS.g:296:5: 'operatored'
                    {
                    match(input,133,FOLLOW_133_in_escapedIdentifierOrKeyword1491); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "operatored";
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
    // $ANTLR end "escapedIdentifierOrKeyword"


    // $ANTLR start "stringSymbol"
    // ./generationTemp/generated/TCS.g:303:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:304:3: ( (ast= STRING ) )
            // ./generationTemp/generated/TCS.g:305:3: (ast= STRING )
            {
            // ./generationTemp/generated/TCS.g:305:3: (ast= STRING )
            // ./generationTemp/generated/TCS.g:305:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol1522); if (state.failed) return ret2;
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


    // $ANTLR start "plainStringSymbol"
    // ./generationTemp/generated/TCS.g:313:1: plainStringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object plainStringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:314:3: ( (ast= STRING ) )
            // ./generationTemp/generated/TCS.g:315:3: (ast= STRING )
            {
            // ./generationTemp/generated/TCS.g:315:3: (ast= STRING )
            // ./generationTemp/generated/TCS.g:315:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_plainStringSymbol1553); if (state.failed) return ret2;
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
    // $ANTLR end "plainStringSymbol"


    // $ANTLR start "uriSymbol"
    // ./generationTemp/generated/TCS.g:323:1: uriSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object uriSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:324:3: ( (ast= STRING ) )
            // ./generationTemp/generated/TCS.g:325:3: (ast= STRING )
            {
            // ./generationTemp/generated/TCS.g:325:3: (ast= STRING )
            // ./generationTemp/generated/TCS.g:325:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_uriSymbol1584); if (state.failed) return ret2;
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
    // $ANTLR end "uriSymbol"


    // $ANTLR start "integerSymbol"
    // ./generationTemp/generated/TCS.g:333:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:334:3: ( (ast= INT ) )
            // ./generationTemp/generated/TCS.g:335:3: (ast= INT )
            {
            // ./generationTemp/generated/TCS.g:335:3: (ast= INT )
            // ./generationTemp/generated/TCS.g:335:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol1615); if (state.failed) return ret2;
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
    // ./generationTemp/generated/TCS.g:343:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:344:3: ( (ast= FLOAT ) )
            // ./generationTemp/generated/TCS.g:345:3: (ast= FLOAT )
            {
            // ./generationTemp/generated/TCS.g:345:3: (ast= FLOAT )
            // ./generationTemp/generated/TCS.g:345:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol1646); if (state.failed) return ret2;
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


    // $ANTLR start "ecore_eclassifier"
    // ./generationTemp/generated/TCS.g:353:1: ecore_eclassifier returns [Object ret2] : ( ( ( (temp= ecore_epackage ) ) | ) (temp= identifier )? ) ;
    public final Object ecore_eclassifier() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ecore","EClassifier");
        ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:359:3: ( ( ( ( (temp= ecore_epackage ) ) | ) (temp= identifier )? ) )
            // ./generationTemp/generated/TCS.g:360:3: ( ( ( (temp= ecore_epackage ) ) | ) (temp= identifier )? )
            {
            // ./generationTemp/generated/TCS.g:360:3: ( ( ( (temp= ecore_epackage ) ) | ) (temp= identifier )? )
            // ./generationTemp/generated/TCS.g:360:4: ( ( (temp= ecore_epackage ) ) | ) (temp= identifier )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.8/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:360:127: ( ( (temp= ecore_epackage ) ) | )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:360:128: ( (temp= ecore_epackage ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:360:144: ( (temp= ecore_epackage ) )
                    // ./generationTemp/generated/TCS.g:360:145: (temp= ecore_epackage )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.8/@templateSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:360:293: (temp= ecore_epackage )
                    // ./generationTemp/generated/TCS.g:360:295: temp= ecore_epackage
                    {
                    pushFollow(FOLLOW_ecore_epackage_in_ecore_eclassifier1686);
                    temp=ecore_epackage();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "ePackage", temp);
                      setParent(temp,ret,"ePackage");
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
                    // ./generationTemp/generated/TCS.g:361:68: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.8/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:362:139: (temp= identifier )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==NAME) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:362:141: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ecore_eclassifier1709);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                      setParent(temp,ret,"name");
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
    // $ANTLR end "ecore_eclassifier"


    // $ANTLR start "ecore_epackage"
    // ./generationTemp/generated/TCS.g:371:1: ecore_epackage returns [Object ret2] : ( ( ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) ) ;
    public final Object ecore_epackage() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ecore","EPackage");
        ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:377:3: ( ( ( ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) ) )
            // ./generationTemp/generated/TCS.g:378:3: ( ( ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) )
            {
            // ./generationTemp/generated/TCS.g:378:3: ( ( ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) )
            // ./generationTemp/generated/TCS.g:378:4: ( ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:378:126: ( ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) )
            int alt8=2;
            switch ( input.LA(1) ) {
            case NAME:
            case DLCOLON:
                {
                alt8=1;
                }
                break;
            case STRING:
                {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==SHARP) ) {
                    switch ( input.LA(3) ) {
                    case NAME:
                        {
                        int LA8_4 = input.LA(4);

                        if ( (LA8_4==DLCOLON) ) {
                            alt8=1;
                        }
                        else if ( (LA8_4==EOF||(LA8_4>=SHARP && LA8_4<=LPAREN)||LA8_4==RPAREN||LA8_4==SEMI||LA8_4==COLON||(LA8_4>=49 && LA8_4<=50)||LA8_4==53||LA8_4==61||LA8_4==71||LA8_4==84||LA8_4==95||LA8_4==99||LA8_4==113||LA8_4==115||LA8_4==130||LA8_4==133) ) {
                            alt8=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DLCOLON:
                        {
                        alt8=1;
                        }
                        break;
                    case EOF:
                    case SHARP:
                    case LPAREN:
                    case RPAREN:
                    case SEMI:
                    case COLON:
                    case 49:
                    case 50:
                    case 53:
                    case 61:
                    case 71:
                    case 84:
                    case 95:
                    case 99:
                    case 113:
                    case 115:
                    case 130:
                    case 133:
                        {
                        alt8=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 3, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;
                }
                }
                break;
            case SHARP:
                {
                switch ( input.LA(2) ) {
                case NAME:
                    {
                    int LA8_4 = input.LA(3);

                    if ( (LA8_4==DLCOLON) ) {
                        alt8=1;
                    }
                    else if ( (LA8_4==EOF||(LA8_4>=SHARP && LA8_4<=LPAREN)||LA8_4==RPAREN||LA8_4==SEMI||LA8_4==COLON||(LA8_4>=49 && LA8_4<=50)||LA8_4==53||LA8_4==61||LA8_4==71||LA8_4==84||LA8_4==95||LA8_4==99||LA8_4==113||LA8_4==115||LA8_4==130||LA8_4==133) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case DLCOLON:
                    {
                    alt8=1;
                    }
                    break;
                case EOF:
                case SHARP:
                case LPAREN:
                case RPAREN:
                case SEMI:
                case COLON:
                case 49:
                case 50:
                case 53:
                case 61:
                case 71:
                case 84:
                case 95:
                case 99:
                case 113:
                case 115:
                case 130:
                case 133:
                    {
                    alt8=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:378:127: ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:378:143: ( ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON )
                    // ./generationTemp/generated/TCS.g:378:144: ( ( (temp= ecore_epackage_superPackage ) ) | ) (temp= identifier )? DLCOLON
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:378:292: ( ( (temp= ecore_epackage_superPackage ) ) | )
                    int alt5=2;
                    switch ( input.LA(1) ) {
                    case NAME:
                        {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1==DLCOLON) ) {
                            switch ( input.LA(3) ) {
                            case NAME:
                                {
                                int LA5_4 = input.LA(4);

                                if ( (LA5_4==DLCOLON) ) {
                                    alt5=1;
                                }
                                else if ( (LA5_4==EOF||(LA5_4>=SHARP && LA5_4<=LPAREN)||LA5_4==RPAREN||LA5_4==SEMI||LA5_4==COLON||(LA5_4>=49 && LA5_4<=50)||LA5_4==53||LA5_4==61||LA5_4==71||LA5_4==84||LA5_4==95||LA5_4==99||LA5_4==113||LA5_4==115||LA5_4==130||LA5_4==133) ) {
                                    alt5=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return ret2;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 4, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case DLCOLON:
                                {
                                alt5=1;
                                }
                                break;
                            case EOF:
                            case SHARP:
                            case LPAREN:
                            case RPAREN:
                            case SEMI:
                            case COLON:
                            case 49:
                            case 50:
                            case 53:
                            case 61:
                            case 71:
                            case 84:
                            case 95:
                            case 99:
                            case 113:
                            case 115:
                            case 130:
                            case 133:
                                {
                                alt5=2;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 2, input);

                                throw nvae;
                            }

                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DLCOLON:
                        {
                        switch ( input.LA(2) ) {
                        case NAME:
                            {
                            int LA5_4 = input.LA(3);

                            if ( (LA5_4==DLCOLON) ) {
                                alt5=1;
                            }
                            else if ( (LA5_4==EOF||(LA5_4>=SHARP && LA5_4<=LPAREN)||LA5_4==RPAREN||LA5_4==SEMI||LA5_4==COLON||(LA5_4>=49 && LA5_4<=50)||LA5_4==53||LA5_4==61||LA5_4==71||LA5_4==84||LA5_4==95||LA5_4==99||LA5_4==113||LA5_4==115||LA5_4==130||LA5_4==133) ) {
                                alt5=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DLCOLON:
                            {
                            alt5=1;
                            }
                            break;
                        case EOF:
                        case SHARP:
                        case LPAREN:
                        case RPAREN:
                        case SEMI:
                        case COLON:
                        case 49:
                        case 50:
                        case 53:
                        case 61:
                        case 71:
                        case 84:
                        case 95:
                        case 99:
                        case 113:
                        case 115:
                        case 130:
                        case 133:
                            {
                            alt5=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 2, input);

                            throw nvae;
                        }

                        }
                        break;
                    case STRING:
                    case SHARP:
                        {
                        alt5=1;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }

                    switch (alt5) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:378:293: ( (temp= ecore_epackage_superPackage ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:378:309: ( (temp= ecore_epackage_superPackage ) )
                            // ./generationTemp/generated/TCS.g:378:310: (temp= ecore_epackage_superPackage )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0/@sequences.0/@elements.0/@thenSequence/@elements.0");
                            }
                            // ./generationTemp/generated/TCS.g:378:483: (temp= ecore_epackage_superPackage )
                            // ./generationTemp/generated/TCS.g:378:485: temp= ecore_epackage_superPackage
                            {
                            pushFollow(FOLLOW_ecore_epackage_superPackage_in_ecore_epackage1769);
                            temp=ecore_epackage_superPackage();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "eSuperPackage", temp);
                              setParent(temp,ret,"eSuperPackage");
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
                            // ./generationTemp/generated/TCS.g:379:73: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:380:164: (temp= identifier )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==NAME) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:380:166: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_ecore_epackage1792);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "name", temp);
                              setParent(temp,ret,"name");
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0/@sequences.0/@elements.2");
                    }
                    match(input,DLCOLON,FOLLOW_DLCOLON_in_ecore_epackage1801); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:382:4: ( (temp= uriSymbol )? SHARP )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:382:20: ( (temp= uriSymbol )? SHARP )
                    // ./generationTemp/generated/TCS.g:382:21: (temp= uriSymbol )? SHARP
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:382:168: (temp= uriSymbol )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==STRING) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:382:170: temp= uriSymbol
                            {
                            pushFollow(FOLLOW_uriSymbol_in_ecore_epackage1819);
                            temp=uriSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "nsURI", temp);
                              setParent(temp,ret,"nsURI");
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.9/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_ecore_epackage1828); if (state.failed) return ret2;
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
    // $ANTLR end "ecore_epackage"


    // $ANTLR start "ecore_epackage_superPackage"
    // ./generationTemp/generated/TCS.g:391:1: ecore_epackage_superPackage returns [Object ret2] : ( ( ( (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) ) ;
    public final Object ecore_epackage_superPackage() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("ecore","EPackage");
        ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
        onEnterTemplateRule(metaType,"superPackage");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:397:3: ( ( ( ( (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) ) )
            // ./generationTemp/generated/TCS.g:398:3: ( ( ( (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) )
            {
            // ./generationTemp/generated/TCS.g:398:3: ( ( ( (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) ) )
            // ./generationTemp/generated/TCS.g:398:4: ( ( (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.10/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:398:127: ( ( (temp= identifier )? DLCOLON ) | ( (temp= uriSymbol )? SHARP ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==NAME||LA11_0==DLCOLON) ) {
                alt11=1;
            }
            else if ( (LA11_0==STRING||LA11_0==SHARP) ) {
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
                    // ./generationTemp/generated/TCS.g:398:128: ( (temp= identifier )? DLCOLON )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:398:144: ( (temp= identifier )? DLCOLON )
                    // ./generationTemp/generated/TCS.g:398:145: (temp= identifier )? DLCOLON
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.10/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:398:293: (temp= identifier )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==NAME) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:398:295: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_ecore_epackage_superPackage1883);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "name", temp);
                              setParent(temp,ret,"name");
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.10/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    match(input,DLCOLON,FOLLOW_DLCOLON_in_ecore_epackage_superPackage1892); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:400:4: ( (temp= uriSymbol )? SHARP )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:400:20: ( (temp= uriSymbol )? SHARP )
                    // ./generationTemp/generated/TCS.g:400:21: (temp= uriSymbol )? SHARP
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.10/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:400:169: (temp= uriSymbol )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==STRING) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:400:171: temp= uriSymbol
                            {
                            pushFollow(FOLLOW_uriSymbol_in_ecore_epackage_superPackage1910);
                            temp=uriSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "nsURI", temp);
                              setParent(temp,ret,"nsURI");
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.10/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_ecore_epackage_superPackage1919); if (state.failed) return ret2;
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
    // $ANTLR end "ecore_epackage_superPackage"


    // $ANTLR start "main"
    // ./generationTemp/generated/TCS.g:409:1: main returns [Object ret2] : ( (ret= furcas_tcs_concretesyntax ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:410:3: ( ( (ret= furcas_tcs_concretesyntax ) EOF ) )
            // ./generationTemp/generated/TCS.g:411:3: ( (ret= furcas_tcs_concretesyntax ) EOF )
            {
            // ./generationTemp/generated/TCS.g:411:3: ( (ret= furcas_tcs_concretesyntax ) EOF )
            // ./generationTemp/generated/TCS.g:411:4: (ret= furcas_tcs_concretesyntax ) EOF
            {
            // ./generationTemp/generated/TCS.g:411:4: (ret= furcas_tcs_concretesyntax )
            // ./generationTemp/generated/TCS.g:411:5: ret= furcas_tcs_concretesyntax
            {
            pushFollow(FOLLOW_furcas_tcs_concretesyntax_in_main1963);
            ret=furcas_tcs_concretesyntax();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main1966); if (state.failed) return ret2;

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


    // $ANTLR start "furcas_tcs_concretesyntax"
    // ./generationTemp/generated/TCS.g:418:1: furcas_tcs_concretesyntax returns [Object ret2] : ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) ;
    public final Object furcas_tcs_concretesyntax() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ConcreteSyntax");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:424:3: ( ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY ) )
            // ./generationTemp/generated/TCS.g:425:3: ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            {
            // ./generationTemp/generated/TCS.g:425:3: ( 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY )
            // ./generationTemp/generated/TCS.g:425:4: 'syntax' (temp= identifier ) ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | ) LCURLY ( ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.0");
            }
            match(input,110,FOLLOW_110_in_furcas_tcs_concretesyntax1997); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:425:274: (temp= identifier )
            // ./generationTemp/generated/TCS.g:425:276: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_concretesyntax2004);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:426:170: ( ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN ) | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LPAREN) ) {
                alt12=1;
            }
            else if ( (LA12_0==LCURLY) ) {
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
                    // ./generationTemp/generated/TCS.g:426:171: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:426:187: ( LPAREN 'k' EQ (temp= integerSymbol ) RPAREN )
                    // ./generationTemp/generated/TCS.g:426:188: LPAREN 'k' EQ (temp= integerSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_concretesyntax2017); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    match(input,74,FOLLOW_74_in_furcas_tcs_concretesyntax2021); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.2/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_concretesyntax2025); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.2/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:426:847: (temp= integerSymbol )
                    // ./generationTemp/generated/TCS.g:426:849: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_concretesyntax2033);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "k", temp);
                      setParent(temp,ret,"k");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.2/@thenSequence/@elements.4");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_concretesyntax2040); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:427:234: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.3");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_concretesyntax2058); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:428:287: ( ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) ) )
            // ./generationTemp/generated/TCS.g:428:288: ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            {
            // ./generationTemp/generated/TCS.g:428:288: ( (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | ) )
            // ./generationTemp/generated/TCS.g:428:289: (temp= furcas_tcs_template (temp= furcas_tcs_template )* )? ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | ) ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | ) (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )? (temp= furcas_tcs_token (temp= furcas_tcs_token )* )? ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:428:439: (temp= furcas_tcs_template (temp= furcas_tcs_template )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==58||LA14_0==69||LA14_0==72||LA14_0==94||LA14_0==118) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:428:441: temp= furcas_tcs_template (temp= furcas_tcs_template )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_template_in_furcas_tcs_concretesyntax2069);
                    temp=furcas_tcs_template();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templates", temp);
                      setParent(temp,ret,"templates");
                    }
                    // ./generationTemp/generated/TCS.g:429:35: (temp= furcas_tcs_template )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==58||LA13_0==69||LA13_0==72||LA13_0==94||LA13_0==118) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:429:37: temp= furcas_tcs_template
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_template_in_furcas_tcs_concretesyntax2077);
                    	    temp=furcas_tcs_template();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "templates", temp);
                    	      setParent(temp,ret,"templates");
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:430:207: ( ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==78) ) {
                alt17=1;
            }
            else if ( (LA17_0==RCURLY||LA17_0==79||(LA17_0>=87 && LA17_0<=88)||LA17_0==90||LA17_0==106) ) {
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
                    // ./generationTemp/generated/TCS.g:430:208: ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:430:224: ( 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY )
                    // ./generationTemp/generated/TCS.g:430:225: 'keywords' LCURLY ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    match(input,78,FOLLOW_78_in_furcas_tcs_concretesyntax2094); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.1");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_concretesyntax2098); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:430:803: ( ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? ) )
                    // ./generationTemp/generated/TCS.g:430:804: ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? )
                    {
                    // ./generationTemp/generated/TCS.g:430:804: ( (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )? )
                    // ./generationTemp/generated/TCS.g:430:805: (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.2/@blockSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:430:1008: (temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==NAME) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:430:1010: temp= furcas_tcs_keyword (temp= furcas_tcs_keyword )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_keyword_in_furcas_tcs_concretesyntax2109);
                            temp=furcas_tcs_keyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "keywords", temp);
                              setParent(temp,ret,"keywords");
                            }
                            // ./generationTemp/generated/TCS.g:431:34: (temp= furcas_tcs_keyword )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==NAME) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:431:36: temp= furcas_tcs_keyword
                            	    {
                            	    pushFollow(FOLLOW_furcas_tcs_keyword_in_furcas_tcs_concretesyntax2117);
                            	    temp=furcas_tcs_keyword();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "keywords", temp);
                            	      setParent(temp,ret,"keywords");
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

                    }


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.3");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_concretesyntax2132); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:432:291: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:433:168: ( ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY ) | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==87) ) {
                alt20=1;
            }
            else if ( (LA20_0==RCURLY||LA20_0==79||LA20_0==88||LA20_0==90||LA20_0==106) ) {
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
                    // ./generationTemp/generated/TCS.g:433:169: ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:433:185: ( 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY )
                    // ./generationTemp/generated/TCS.g:433:186: 'symbols' LCURLY ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) ) RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,87,FOLLOW_87_in_furcas_tcs_concretesyntax2155); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_concretesyntax2159); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:433:763: ( ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? ) )
                    // ./generationTemp/generated/TCS.g:433:764: ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? )
                    {
                    // ./generationTemp/generated/TCS.g:433:764: ( (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )? )
                    // ./generationTemp/generated/TCS.g:433:765: (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.2/@blockSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:433:968: (temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==NAME) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:433:970: temp= furcas_tcs_symbol (temp= furcas_tcs_symbol )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_symbol_in_furcas_tcs_concretesyntax2170);
                            temp=furcas_tcs_symbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "symbols", temp);
                              setParent(temp,ret,"symbols");
                            }
                            // ./generationTemp/generated/TCS.g:434:33: (temp= furcas_tcs_symbol )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==NAME) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:434:35: temp= furcas_tcs_symbol
                            	    {
                            	    pushFollow(FOLLOW_furcas_tcs_symbol_in_furcas_tcs_concretesyntax2178);
                            	    temp=furcas_tcs_symbol();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "symbols", temp);
                            	      setParent(temp,ret,"symbols");
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


                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.3");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_concretesyntax2193); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:435:290: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:436:167: (temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==106) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:436:169: temp= furcas_tcs_operatorlist (temp= furcas_tcs_operatorlist )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_operatorlist_in_furcas_tcs_concretesyntax2214);
                    temp=furcas_tcs_operatorlist();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operatorLists", temp);
                      setParent(temp,ret,"operatorLists");
                    }
                    // ./generationTemp/generated/TCS.g:437:39: (temp= furcas_tcs_operatorlist )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==106) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:437:41: temp= furcas_tcs_operatorlist
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_operatorlist_in_furcas_tcs_concretesyntax2222);
                    	    temp=furcas_tcs_operatorlist();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "operatorLists", temp);
                    	      setParent(temp,ret,"operatorLists");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:438:210: (temp= furcas_tcs_token (temp= furcas_tcs_token )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==79||LA24_0==90) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:438:212: temp= furcas_tcs_token (temp= furcas_tcs_token )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_token_in_furcas_tcs_concretesyntax2237);
                    temp=furcas_tcs_token();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tokens", temp);
                      setParent(temp,ret,"tokens");
                    }
                    // ./generationTemp/generated/TCS.g:439:32: (temp= furcas_tcs_token )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==79||LA23_0==90) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:439:34: temp= furcas_tcs_token
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_token_in_furcas_tcs_concretesyntax2245);
                    	    temp=furcas_tcs_token();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "tokens", temp);
                    	      setParent(temp,ret,"tokens");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:440:204: ( ( 'lexer' EQ (temp= stringSymbol ) SEMI ) | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==88) ) {
                alt25=1;
            }
            else if ( (LA25_0==RCURLY) ) {
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
                    // ./generationTemp/generated/TCS.g:440:205: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:440:221: ( 'lexer' EQ (temp= stringSymbol ) SEMI )
                    // ./generationTemp/generated/TCS.g:440:222: 'lexer' EQ (temp= stringSymbol ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.0");
                    }
                    match(input,88,FOLLOW_88_in_furcas_tcs_concretesyntax2262); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_concretesyntax2266); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:440:793: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:440:795: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_concretesyntax2274);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "lexer", temp);
                      setParent(temp,ret,"lexer");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.3");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_concretesyntax2281); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:441:263: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.5");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_concretesyntax2302); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.6");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "keywords", null, null, "OCL:LiteralRef.allInstances()->select("+
              "                                lr | self.templates->includes(lr.parentTemplate)).referredLiteral->asSet()"+
              "                                ->union(self.operatorLists.priorities.operators.literal->asSet())"+
              "                                ->select(k | k.oclIsTypeOf(Keyword))", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.11/@templateSequence/@elements.6/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
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
    // $ANTLR end "furcas_tcs_concretesyntax"


    // $ANTLR start "reference"
    // ./generationTemp/generated/TCS.g:453:1: reference[Object ret] : ( ( ( (temp= ecore_eclassifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ) ) ;
    public final void reference(Object ret) throws RecognitionException {
        Object temp = null;


        try {
            // ./generationTemp/generated/TCS.g:454:3: ( ( ( ( (temp= ecore_eclassifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ) ) )
            // ./generationTemp/generated/TCS.g:455:3: ( ( ( (temp= ecore_eclassifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ) )
            {
            // ./generationTemp/generated/TCS.g:455:3: ( ( ( (temp= ecore_eclassifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) ) )
            // ./generationTemp/generated/TCS.g:455:4: ( ( (temp= ecore_eclassifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.12/@functionSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:455:128: ( ( (temp= ecore_eclassifier ) ) | ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==EOF||(LA27_0>=NAME && LA27_0<=STRING)||(LA27_0>=DLCOLON && LA27_0<=LPAREN)||LA27_0==RPAREN||LA27_0==SEMI||LA27_0==COLON||(LA27_0>=49 && LA27_0<=50)||LA27_0==53||LA27_0==61||LA27_0==71||LA27_0==84||LA27_0==95||LA27_0==99||LA27_0==113||LA27_0==115||LA27_0==130||LA27_0==133) ) {
                alt27=1;
            }
            else if ( (LA27_0==RARROW) ) {
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
                    // ./generationTemp/generated/TCS.g:455:129: ( (temp= ecore_eclassifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:455:145: ( (temp= ecore_eclassifier ) )
                    // ./generationTemp/generated/TCS.g:455:146: (temp= ecore_eclassifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.12/@functionSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:455:295: (temp= ecore_eclassifier )
                    // ./generationTemp/generated/TCS.g:455:297: temp= ecore_eclassifier
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_in_reference2350);
                    temp=ecore_eclassifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "metaReference", temp);
                      setParent(temp,ret,"metaReference");
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
                    // ./generationTemp/generated/TCS.g:456:73: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:456:89: ( RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* ) )
                    // ./generationTemp/generated/TCS.g:456:90: RARROW (temp= identifier ( ( DLCOLON ) temp= identifier )* )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.12/@functionSequence/@elements.0/@elseSequence/@elements.0");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_reference2366); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.12/@functionSequence/@elements.0/@elseSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:456:412: (temp= identifier ( ( DLCOLON ) temp= identifier )* )
                    // ./generationTemp/generated/TCS.g:456:414: temp= identifier ( ( DLCOLON ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_reference2374);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "names", temp);
                      setParent(temp,ret,"names");
                    }
                    // ./generationTemp/generated/TCS.g:457:31: ( ( DLCOLON ) temp= identifier )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==DLCOLON) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:457:32: ( DLCOLON ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:457:49: ( DLCOLON )
                    	    // ./generationTemp/generated/TCS.g:457:50: DLCOLON
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.12/@functionSequence/@elements.0/@elseSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,DLCOLON,FOLLOW_DLCOLON_in_reference2383); if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_reference2391);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "names", temp);
                    	      setParent(temp,ret,"names");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
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


    // $ANTLR start "furcas_tcs_template"
    // ./generationTemp/generated/TCS.g:466:1: furcas_tcs_template returns [Object ret2] : (ret= furcas_tcs_contexttemplate | ret= furcas_tcs_primitivetemplate | ret= furcas_tcs_enumerationtemplate | ret= furcas_tcs_functiontemplate ) ;
    public final Object furcas_tcs_template() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:467:3: ( (ret= furcas_tcs_contexttemplate | ret= furcas_tcs_primitivetemplate | ret= furcas_tcs_enumerationtemplate | ret= furcas_tcs_functiontemplate ) )
            // ./generationTemp/generated/TCS.g:468:3: (ret= furcas_tcs_contexttemplate | ret= furcas_tcs_primitivetemplate | ret= furcas_tcs_enumerationtemplate | ret= furcas_tcs_functiontemplate )
            {
            // ./generationTemp/generated/TCS.g:468:3: (ret= furcas_tcs_contexttemplate | ret= furcas_tcs_primitivetemplate | ret= furcas_tcs_enumerationtemplate | ret= furcas_tcs_functiontemplate )
            int alt28=4;
            switch ( input.LA(1) ) {
            case 72:
            case 94:
                {
                alt28=1;
                }
                break;
            case 118:
                {
                alt28=2;
                }
                break;
            case 69:
                {
                alt28=3;
                }
                break;
            case 58:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:468:4: ret= furcas_tcs_contexttemplate
                    {
                    pushFollow(FOLLOW_furcas_tcs_contexttemplate_in_furcas_tcs_template2430);
                    ret=furcas_tcs_contexttemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:469:5: ret= furcas_tcs_primitivetemplate
                    {
                    pushFollow(FOLLOW_furcas_tcs_primitivetemplate_in_furcas_tcs_template2438);
                    ret=furcas_tcs_primitivetemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:470:5: ret= furcas_tcs_enumerationtemplate
                    {
                    pushFollow(FOLLOW_furcas_tcs_enumerationtemplate_in_furcas_tcs_template2446);
                    ret=furcas_tcs_enumerationtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:471:5: ret= furcas_tcs_functiontemplate
                    {
                    pushFollow(FOLLOW_furcas_tcs_functiontemplate_in_furcas_tcs_template2454);
                    ret=furcas_tcs_functiontemplate();

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
    // $ANTLR end "furcas_tcs_template"


    // $ANTLR start "furcas_tcs_contexttemplate"
    // ./generationTemp/generated/TCS.g:478:1: furcas_tcs_contexttemplate returns [Object ret2] : (ret= furcas_tcs_classtemplate | ret= furcas_tcs_operatortemplate ) ;
    public final Object furcas_tcs_contexttemplate() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:479:3: ( (ret= furcas_tcs_classtemplate | ret= furcas_tcs_operatortemplate ) )
            // ./generationTemp/generated/TCS.g:480:3: (ret= furcas_tcs_classtemplate | ret= furcas_tcs_operatortemplate )
            {
            // ./generationTemp/generated/TCS.g:480:3: (ret= furcas_tcs_classtemplate | ret= furcas_tcs_operatortemplate )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==94) ) {
                alt29=1;
            }
            else if ( (LA29_0==72) ) {
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
                    // ./generationTemp/generated/TCS.g:480:4: ret= furcas_tcs_classtemplate
                    {
                    pushFollow(FOLLOW_furcas_tcs_classtemplate_in_furcas_tcs_contexttemplate2481);
                    ret=furcas_tcs_classtemplate();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:481:5: ret= furcas_tcs_operatortemplate
                    {
                    pushFollow(FOLLOW_furcas_tcs_operatortemplate_in_furcas_tcs_contexttemplate2489);
                    ret=furcas_tcs_operatortemplate();

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
    // $ANTLR end "furcas_tcs_contexttemplate"


    // $ANTLR start "furcas_tcs_primitivetemplate"
    // ./generationTemp/generated/TCS.g:488:1: furcas_tcs_primitivetemplate returns [Object ret2] : ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) ( ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI ) ) ) ;
    public final Object furcas_tcs_primitivetemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PrimitiveTemplate");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:494:3: ( ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) ( ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI ) ) ) )
            // ./generationTemp/generated/TCS.g:495:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) ( ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI ) ) )
            {
            // ./generationTemp/generated/TCS.g:495:3: ( 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) ( ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI ) ) )
            // ./generationTemp/generated/TCS.g:495:4: 'primitiveTemplate' (temp= identifier ) 'for' reference[ret] ( ( 'default' ) | ) 'using' (temp= identifier ) ( ( 'orKeyword' ) | ) ( ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.0");
            }
            match(input,118,FOLLOW_118_in_furcas_tcs_primitivetemplate2519); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:495:285: (temp= identifier )
            // ./generationTemp/generated/TCS.g:495:287: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_primitivetemplate2526);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "templateName", temp);
              setParent(temp,ret,"templateName");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.2");
            }
            match(input,102,FOLLOW_102_in_furcas_tcs_primitivetemplate2532); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.3");
            }
            pushFollow(FOLLOW_reference_in_furcas_tcs_primitivetemplate2535);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:496:475: ( ( 'default' ) | )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==71) ) {
                alt30=1;
            }
            else if ( (LA30_0==115) ) {
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
                    // ./generationTemp/generated/TCS.g:496:476: ( 'default' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:496:492: ( 'default' )
                    // ./generationTemp/generated/TCS.g:496:493: 'default'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.4/@thenSequence/@elements.0");
                    }
                    match(input,71,FOLLOW_71_in_furcas_tcs_primitivetemplate2545); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:496:739: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.5");
            }
            match(input,115,FOLLOW_115_in_furcas_tcs_primitivetemplate2563); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.6");
            }
            // ./generationTemp/generated/TCS.g:497:286: (temp= identifier )
            // ./generationTemp/generated/TCS.g:497:288: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_primitivetemplate2570);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "tokenName", temp);
              setParent(temp,ret,"tokenName");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.7");
            }
            // ./generationTemp/generated/TCS.g:498:175: ( ( 'orKeyword' ) | )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==124) ) {
                alt31=1;
            }
            else if ( (LA31_0==COLON) ) {
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
                    // ./generationTemp/generated/TCS.g:498:176: ( 'orKeyword' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:498:192: ( 'orKeyword' )
                    // ./generationTemp/generated/TCS.g:498:193: 'orKeyword'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.7/@thenSequence/@elements.0");
                    }
                    match(input,124,FOLLOW_124_in_furcas_tcs_primitivetemplate2582); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:498:443: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8");
            }
            // ./generationTemp/generated/TCS.g:499:140: ( ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI ) )
            // ./generationTemp/generated/TCS.g:499:141: ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI )
            {
            // ./generationTemp/generated/TCS.g:499:141: ( COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI )
            // ./generationTemp/generated/TCS.g:499:142: COLON ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.0");
            }
            match(input,COLON,FOLLOW_COLON_in_furcas_tcs_primitivetemplate2604); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:499:465: ( ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) ) )
            // ./generationTemp/generated/TCS.g:499:466: ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) )
            {
            // ./generationTemp/generated/TCS.g:499:466: ( 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | ) )
            // ./generationTemp/generated/TCS.g:499:467: 'value' EQ (temp= stringSymbol ) ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.0");
            }
            match(input,54,FOLLOW_54_in_furcas_tcs_primitivetemplate2611); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_primitivetemplate2615); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:499:1041: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:499:1043: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_primitivetemplate2623);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:500:225: ( ( COMA 'serializer' EQ (temp= stringSymbol ) ) | )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==COMA) ) {
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
                    // ./generationTemp/generated/TCS.g:500:226: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:500:242: ( COMA 'serializer' EQ (temp= stringSymbol ) )
                    // ./generationTemp/generated/TCS.g:500:243: COMA 'serializer' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_primitivetemplate2636); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.3/@thenSequence/@elements.1");
                    }
                    match(input,56,FOLLOW_56_in_furcas_tcs_primitivetemplate2640); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.3/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_primitivetemplate2644); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.1/@blockSequence/@elements.3/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:500:1125: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:500:1127: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_primitivetemplate2652);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "serializer", temp);
                      setParent(temp,ret,"serializer");
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
                    // ./generationTemp/generated/TCS.g:501:70: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.15/@templateSequence/@elements.8/@blockSequence/@elements.2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_primitivetemplate2675); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_primitivetemplate"


    // $ANTLR start "furcas_tcs_enumerationtemplate"
    // ./generationTemp/generated/TCS.g:510:1: furcas_tcs_enumerationtemplate returns [Object ret2] : ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) ) ;
    public final Object furcas_tcs_enumerationtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","EnumerationTemplate");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:516:3: ( ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) ) )
            // ./generationTemp/generated/TCS.g:517:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) )
            {
            // ./generationTemp/generated/TCS.g:517:3: ( 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) ) )
            // ./generationTemp/generated/TCS.g:517:4: 'enumerationTemplate' reference[ret] ( ( 'auto' ) | ) ( ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.0");
            }
            match(input,69,FOLLOW_69_in_furcas_tcs_enumerationtemplate2719); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.1");
            }
            pushFollow(FOLLOW_reference_in_furcas_tcs_enumerationtemplate2722);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:517:441: ( ( 'auto' ) | )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==130) ) {
                alt33=1;
            }
            else if ( (LA33_0==SEMI||LA33_0==COLON) ) {
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
                    // ./generationTemp/generated/TCS.g:517:442: ( 'auto' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:517:458: ( 'auto' )
                    // ./generationTemp/generated/TCS.g:517:459: 'auto'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,130,FOLLOW_130_in_furcas_tcs_enumerationtemplate2732); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:517:704: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:518:141: ( ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) ) | ( SEMI ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==COLON) ) {
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
                    // ./generationTemp/generated/TCS.g:518:142: ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:518:158: ( ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) ) )
                    // ./generationTemp/generated/TCS.g:518:159: ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:518:308: ( ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI ) )
                    // ./generationTemp/generated/TCS.g:518:309: ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI )
                    {
                    // ./generationTemp/generated/TCS.g:518:309: ( COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI )
                    // ./generationTemp/generated/TCS.g:518:310: COLON ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_furcas_tcs_enumerationtemplate2760); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:518:685: ( ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? ) )
                    // ./generationTemp/generated/TCS.g:518:686: ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? )
                    {
                    // ./generationTemp/generated/TCS.g:518:686: ( (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )? )
                    // ./generationTemp/generated/TCS.g:518:687: (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:518:890: (temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==SHARP) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:518:892: temp= furcas_tcs_enumliteralmapping ( ( COMA ) temp= furcas_tcs_enumliteralmapping )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_enumliteralmapping_in_furcas_tcs_enumerationtemplate2771);
                            temp=furcas_tcs_enumliteralmapping();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mappings", temp);
                              setParent(temp,ret,"mappings");
                            }
                            // ./generationTemp/generated/TCS.g:519:34: ( ( COMA ) temp= furcas_tcs_enumliteralmapping )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==COMA) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:519:35: ( COMA ) temp= furcas_tcs_enumliteralmapping
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./generationTemp/generated/TCS.g:519:52: ( COMA )
                            	    // ./generationTemp/generated/TCS.g:519:53: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_enumerationtemplate2780); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_furcas_tcs_enumliteralmapping_in_furcas_tcs_enumerationtemplate2788);
                            	    temp=furcas_tcs_enumliteralmapping();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "mappings", temp);
                            	      setParent(temp,ret,"mappings");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop34;
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_enumerationtemplate2803); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:520:307: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:520:323: ( SEMI )
                    // ./generationTemp/generated/TCS.g:520:324: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.16/@templateSequence/@elements.3/@elseSequence/@elements.0");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_enumerationtemplate2820); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_enumerationtemplate"


    // $ANTLR start "furcas_tcs_enumliteralmapping"
    // ./generationTemp/generated/TCS.g:529:1: furcas_tcs_enumliteralmapping returns [Object ret2] : ( (temp= furcas_tcs_enumliteralval ) EQ (temp= furcas_tcs_sequenceelement )? ) ;
    public final Object furcas_tcs_enumliteralmapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","EnumLiteralMapping");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:535:3: ( ( (temp= furcas_tcs_enumliteralval ) EQ (temp= furcas_tcs_sequenceelement )? ) )
            // ./generationTemp/generated/TCS.g:536:3: ( (temp= furcas_tcs_enumliteralval ) EQ (temp= furcas_tcs_sequenceelement )? )
            {
            // ./generationTemp/generated/TCS.g:536:3: ( (temp= furcas_tcs_enumliteralval ) EQ (temp= furcas_tcs_sequenceelement )? )
            // ./generationTemp/generated/TCS.g:536:4: (temp= furcas_tcs_enumliteralval ) EQ (temp= furcas_tcs_sequenceelement )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.17/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:536:127: (temp= furcas_tcs_enumliteralval )
            // ./generationTemp/generated/TCS.g:536:129: temp= furcas_tcs_enumliteralval
            {
            pushFollow(FOLLOW_furcas_tcs_enumliteralval_in_furcas_tcs_enumliteralmapping2871);
            temp=furcas_tcs_enumliteralval();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "literal", temp);
              setParent(temp,ret,"literal");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.17/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_enumliteralmapping2878); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.17/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:537:315: (temp= furcas_tcs_sequenceelement )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=NAME && LA37_0<=STRING)||LA37_0==LPAREN||LA37_0==RARROW||LA37_0==LT||LA37_0==LSQUARE||LA37_0==DLSQUARE||(LA37_0>=DOLLAR && LA37_0<=DLCURLY)||(LA37_0>=49 && LA37_0<=133)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:537:317: temp= furcas_tcs_sequenceelement
                    {
                    pushFollow(FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_enumliteralmapping2886);
                    temp=furcas_tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "element", temp);
                      setParent(temp,ret,"element");
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
    // $ANTLR end "furcas_tcs_enumliteralmapping"


    // $ANTLR start "furcas_tcs_classtemplate"
    // ./generationTemp/generated/TCS.g:546:1: furcas_tcs_classtemplate returns [Object ret2] : ( 'template' reference[ret] ( ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) ) | ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) ;
    public final Object furcas_tcs_classtemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ClassTemplate");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:552:3: ( ( 'template' reference[ret] ( ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) ) | ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) )
            // ./generationTemp/generated/TCS.g:553:3: ( 'template' reference[ret] ( ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) ) | ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            {
            // ./generationTemp/generated/TCS.g:553:3: ( 'template' reference[ret] ( ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) ) | ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            // ./generationTemp/generated/TCS.g:553:4: 'template' reference[ret] ( ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) ) | ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.0");
            }
            match(input,94,FOLLOW_94_in_furcas_tcs_classtemplate2931); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.1");
            }
            pushFollow(FOLLOW_reference_in_furcas_tcs_classtemplate2934);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:553:430: ( ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) ) | ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==61) ) {
                alt53=1;
            }
            else if ( ((LA53_0>=SHARP && LA53_0<=LPAREN)||LA53_0==SEMI||LA53_0==COLON||(LA53_0>=49 && LA53_0<=50)||LA53_0==53||LA53_0==84||LA53_0==95||LA53_0==99||LA53_0==113||LA53_0==133) ) {
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
                    // ./generationTemp/generated/TCS.g:553:431: ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:553:447: ( 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | ) )
                    // ./generationTemp/generated/TCS.g:553:448: 'referenceOnly' ( ( SHARP (temp= identifierOrKeyword ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,61,FOLLOW_61_in_furcas_tcs_classtemplate2944); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:553:778: ( ( SHARP (temp= identifierOrKeyword ) ) | )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==SHARP) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==SEMI||LA38_0==COLON) ) {
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
                            // ./generationTemp/generated/TCS.g:553:779: ( SHARP (temp= identifierOrKeyword ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:553:795: ( SHARP (temp= identifierOrKeyword ) )
                            // ./generationTemp/generated/TCS.g:553:796: SHARP (temp= identifierOrKeyword )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@thenSequence/@elements.1/@thenSequence/@elements.0");
                            }
                            match(input,SHARP,FOLLOW_SHARP_in_furcas_tcs_classtemplate2954); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@thenSequence/@elements.1/@thenSequence/@elements.1");
                            }
                            // ./generationTemp/generated/TCS.g:553:1169: (temp= identifierOrKeyword )
                            // ./generationTemp/generated/TCS.g:553:1171: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_classtemplate2962);
                            temp=identifierOrKeyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mode", temp);
                              setParent(temp,ret,"mode");
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
                            // ./generationTemp/generated/TCS.g:554:64: 
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
                      setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:555:97: ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:555:113: ( ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | ) )
                    // ./generationTemp/generated/TCS.g:555:114: ( ( SHARP (temp= identifierOrKeyword ) ) | ) ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | ) ( ( 'multi' ) | ) ( ( 'main' ) | ) ( ( ( ( 'deep' ) | ) 'abstract' ) | ) ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | ) ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ( ( 'addToContext' ) | ) ( ( 'nonPrimary' ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:555:264: ( ( SHARP (temp= identifierOrKeyword ) ) | )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==SHARP) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==LPAREN||LA39_0==SEMI||LA39_0==COLON||(LA39_0>=49 && LA39_0<=50)||LA39_0==53||LA39_0==84||LA39_0==95||LA39_0==99||LA39_0==113||LA39_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:555:265: ( SHARP (temp= identifierOrKeyword ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:555:281: ( SHARP (temp= identifierOrKeyword ) )
                            // ./generationTemp/generated/TCS.g:555:282: SHARP (temp= identifierOrKeyword )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.0/@thenSequence/@elements.0");
                            }
                            match(input,SHARP,FOLLOW_SHARP_in_furcas_tcs_classtemplate2998); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.0/@thenSequence/@elements.1");
                            }
                            // ./generationTemp/generated/TCS.g:555:655: (temp= identifierOrKeyword )
                            // ./generationTemp/generated/TCS.g:555:657: temp= identifierOrKeyword
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_classtemplate3006);
                            temp=identifierOrKeyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "mode", temp);
                              setParent(temp,ret,"mode");
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
                            // ./generationTemp/generated/TCS.g:556:64: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:557:167: ( ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==LPAREN) ) {
                        int LA40_1 = input.LA(2);

                        if ( (LA40_1==59||LA40_1==96) ) {
                            alt40=2;
                        }
                        else if ( (LA40_1==68) ) {
                            alt40=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 40, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA40_0==SEMI||LA40_0==COLON||(LA40_0>=49 && LA40_0<=50)||LA40_0==53||LA40_0==84||LA40_0==95||LA40_0==99||LA40_0==113||LA40_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:557:168: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:557:184: ( LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // ./generationTemp/generated/TCS.g:557:185: LPAREN 'disambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.0");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_classtemplate3032); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.1");
                            }
                            match(input,68,FOLLOW_68_in_furcas_tcs_classtemplate3036); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.2");
                            }
                            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_classtemplate3040); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.3");
                            }
                            // ./generationTemp/generated/TCS.g:557:959: (temp= stringSymbol )
                            // ./generationTemp/generated/TCS.g:557:961: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_classtemplate3048);
                            temp=stringSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "disambiguate", temp);
                              setParent(temp,ret,"disambiguate");
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_classtemplate3055); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // ./generationTemp/generated/TCS.g:558:271: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:559:167: ( ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==LPAREN) ) {
                        int LA41_1 = input.LA(2);

                        if ( (LA41_1==96) ) {
                            alt41=2;
                        }
                        else if ( (LA41_1==59) ) {
                            alt41=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ret2;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 41, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA41_0==SEMI||LA41_0==COLON||(LA41_0>=49 && LA41_0<=50)||LA41_0==53||LA41_0==84||LA41_0==95||LA41_0==99||LA41_0==113||LA41_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:559:168: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:559:184: ( LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN )
                            // ./generationTemp/generated/TCS.g:559:185: LPAREN 'disambiguateV3' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.0");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_classtemplate3079); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.1");
                            }
                            match(input,59,FOLLOW_59_in_furcas_tcs_classtemplate3083); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.2");
                            }
                            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_classtemplate3087); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.3");
                            }
                            // ./generationTemp/generated/TCS.g:559:961: (temp= stringSymbol )
                            // ./generationTemp/generated/TCS.g:559:963: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_classtemplate3095);
                            temp=stringSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "disambiguateV3", temp);
                              setParent(temp,ret,"disambiguateV3");
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_classtemplate3102); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // ./generationTemp/generated/TCS.g:560:273: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:561:167: ( ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN ) | )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==LPAREN) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==SEMI||LA42_0==COLON||(LA42_0>=49 && LA42_0<=50)||LA42_0==53||LA42_0==84||LA42_0==95||LA42_0==99||LA42_0==113||LA42_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:561:168: ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:561:184: ( LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN )
                            // ./generationTemp/generated/TCS.g:561:185: LPAREN 'semDisambiguate' EQ (temp= stringSymbol ) RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.0");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_classtemplate3126); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.1");
                            }
                            match(input,96,FOLLOW_96_in_furcas_tcs_classtemplate3130); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.2");
                            }
                            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_classtemplate3134); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.3");
                            }
                            // ./generationTemp/generated/TCS.g:561:962: (temp= stringSymbol )
                            // ./generationTemp/generated/TCS.g:561:964: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_classtemplate3142);
                            temp=stringSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "semDisambiguate", temp);
                              setParent(temp,ret,"semDisambiguate");
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.4");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_classtemplate3149); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // ./generationTemp/generated/TCS.g:562:274: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.4");
                    }
                    // ./generationTemp/generated/TCS.g:563:167: ( ( 'multi' ) | )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==99) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==SEMI||LA43_0==COLON||(LA43_0>=49 && LA43_0<=50)||LA43_0==53||LA43_0==84||LA43_0==95||LA43_0==113||LA43_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:563:168: ( 'multi' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:563:184: ( 'multi' )
                            // ./generationTemp/generated/TCS.g:563:185: 'multi'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.4/@thenSequence/@elements.0");
                            }
                            match(input,99,FOLLOW_99_in_furcas_tcs_classtemplate3172); if (state.failed) return ret2;
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
                            // ./generationTemp/generated/TCS.g:563:455: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.5");
                    }
                    // ./generationTemp/generated/TCS.g:564:167: ( ( 'main' ) | )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==113) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==SEMI||LA44_0==COLON||(LA44_0>=49 && LA44_0<=50)||LA44_0==53||LA44_0==84||LA44_0==95||LA44_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:564:168: ( 'main' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:564:184: ( 'main' )
                            // ./generationTemp/generated/TCS.g:564:185: 'main'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.5/@thenSequence/@elements.0");
                            }
                            match(input,113,FOLLOW_113_in_furcas_tcs_classtemplate3196); if (state.failed) return ret2;
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
                            // ./generationTemp/generated/TCS.g:564:453: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.6");
                    }
                    // ./generationTemp/generated/TCS.g:565:167: ( ( ( ( 'deep' ) | ) 'abstract' ) | )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==49||LA46_0==84) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==SEMI||LA46_0==COLON||LA46_0==50||LA46_0==53||LA46_0==95||LA46_0==133) ) {
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
                            // ./generationTemp/generated/TCS.g:565:168: ( ( ( 'deep' ) | ) 'abstract' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:565:184: ( ( ( 'deep' ) | ) 'abstract' )
                            // ./generationTemp/generated/TCS.g:565:185: ( ( 'deep' ) | ) 'abstract'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.6/@thenSequence/@elements.0");
                            }
                            // ./generationTemp/generated/TCS.g:565:361: ( ( 'deep' ) | )
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( (LA45_0==49) ) {
                                alt45=1;
                            }
                            else if ( (LA45_0==84) ) {
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
                                    // ./generationTemp/generated/TCS.g:565:362: ( 'deep' )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // ./generationTemp/generated/TCS.g:565:378: ( 'deep' )
                                    // ./generationTemp/generated/TCS.g:565:379: 'deep'
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.6/@thenSequence/@elements.0/@thenSequence/@elements.0");
                                    }
                                    match(input,49,FOLLOW_49_in_furcas_tcs_classtemplate3226); if (state.failed) return ret2;
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
                                    // ./generationTemp/generated/TCS.g:565:673: 
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
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.6/@thenSequence/@elements.1");
                            }
                            match(input,84,FOLLOW_84_in_furcas_tcs_classtemplate3244); if (state.failed) return ret2;
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
                            // ./generationTemp/generated/TCS.g:566:293: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.7");
                    }
                    // ./generationTemp/generated/TCS.g:567:167: ( ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) ) | )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==133) ) {
                        alt48=1;
                    }
                    else if ( (LA48_0==SEMI||LA48_0==COLON||LA48_0==50||LA48_0==53||LA48_0==95) ) {
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
                            // ./generationTemp/generated/TCS.g:567:168: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:567:184: ( 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | ) )
                            // ./generationTemp/generated/TCS.g:567:185: 'operatored' ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.0");
                            }
                            match(input,133,FOLLOW_133_in_furcas_tcs_classtemplate3268); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1");
                            }
                            // ./generationTemp/generated/TCS.g:567:564: ( ( LPAREN (temp= identifier ) RPAREN ) | )
                            int alt47=2;
                            int LA47_0 = input.LA(1);

                            if ( (LA47_0==LPAREN) ) {
                                alt47=1;
                            }
                            else if ( (LA47_0==SEMI||LA47_0==COLON||LA47_0==50||LA47_0==53||LA47_0==95) ) {
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
                                    // ./generationTemp/generated/TCS.g:567:565: ( LPAREN (temp= identifier ) RPAREN )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // ./generationTemp/generated/TCS.g:567:581: ( LPAREN (temp= identifier ) RPAREN )
                                    // ./generationTemp/generated/TCS.g:567:582: LPAREN (temp= identifier ) RPAREN
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1/@thenSequence/@elements.0");
                                    }
                                    match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_classtemplate3278); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1/@thenSequence/@elements.1");
                                    }
                                    // ./generationTemp/generated/TCS.g:567:1008: (temp= identifier )
                                    // ./generationTemp/generated/TCS.g:567:1010: temp= identifier
                                    {
                                    pushFollow(FOLLOW_identifier_in_furcas_tcs_classtemplate3286);
                                    temp=identifier();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setRef(ret, "operatorList", list("FURCAS","TCS","OperatorList"), "name", temp, null, "never", null, false, null);
                                    }

                                    }

                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1/@thenSequence/@elements.2");
                                    }
                                    match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_classtemplate3293); if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      _afterSeqEl();
                                    }

                                    }

                                    if ( state.backtracking==0 ) {
                                      _exitAlt();
                                    }

                                    }
                                    break;
                                case 2 :
                                    // ./generationTemp/generated/TCS.g:567:1401: 
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
                            // ./generationTemp/generated/TCS.g:568:94: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.8");
                    }
                    // ./generationTemp/generated/TCS.g:569:167: ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==50) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==SEMI||LA50_0==COLON||LA50_0==53||LA50_0==95) ) {
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
                            // ./generationTemp/generated/TCS.g:569:168: ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:569:184: ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) )
                            // ./generationTemp/generated/TCS.g:569:185: 'context' ( ( (temp= furcas_tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.8/@thenSequence/@elements.0");
                            }
                            match(input,50,FOLLOW_50_in_furcas_tcs_classtemplate3331); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.8/@thenSequence/@elements.1");
                            }
                            // ./generationTemp/generated/TCS.g:569:561: ( ( (temp= furcas_tcs_contexttags ) ) | )
                            int alt49=2;
                            int LA49_0 = input.LA(1);

                            if ( (LA49_0==LPAREN) ) {
                                alt49=1;
                            }
                            else if ( (LA49_0==SEMI||LA49_0==COLON||LA49_0==53||LA49_0==95) ) {
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
                                    // ./generationTemp/generated/TCS.g:569:562: ( (temp= furcas_tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // ./generationTemp/generated/TCS.g:569:578: ( (temp= furcas_tcs_contexttags ) )
                                    // ./generationTemp/generated/TCS.g:569:579: (temp= furcas_tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.8/@thenSequence/@elements.1/@thenSequence/@elements.0");
                                    }
                                    // ./generationTemp/generated/TCS.g:569:780: (temp= furcas_tcs_contexttags )
                                    // ./generationTemp/generated/TCS.g:569:782: temp= furcas_tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_furcas_tcs_contexttags_in_furcas_tcs_classtemplate3344);
                                    temp=furcas_tcs_contexttags();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "contextTags", temp);
                                      setParent(temp,ret,"contextTags");
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
                                    // ./generationTemp/generated/TCS.g:570:71: 
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
                            // ./generationTemp/generated/TCS.g:571:91: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.9");
                    }
                    // ./generationTemp/generated/TCS.g:572:167: ( ( 'addToContext' ) | )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==53) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==SEMI||LA51_0==COLON||LA51_0==95) ) {
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
                            // ./generationTemp/generated/TCS.g:572:168: ( 'addToContext' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:572:184: ( 'addToContext' )
                            // ./generationTemp/generated/TCS.g:572:185: 'addToContext'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.9/@thenSequence/@elements.0");
                            }
                            match(input,53,FOLLOW_53_in_furcas_tcs_classtemplate3384); if (state.failed) return ret2;
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
                            // ./generationTemp/generated/TCS.g:572:469: 
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.10");
                    }
                    // ./generationTemp/generated/TCS.g:573:168: ( ( 'nonPrimary' ) | )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==95) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==SEMI||LA52_0==COLON) ) {
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
                            // ./generationTemp/generated/TCS.g:573:169: ( 'nonPrimary' )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:573:185: ( 'nonPrimary' )
                            // ./generationTemp/generated/TCS.g:573:186: 'nonPrimary'
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.2/@elseSequence/@elements.10/@thenSequence/@elements.0");
                            }
                            match(input,95,FOLLOW_95_in_furcas_tcs_classtemplate3408); if (state.failed) return ret2;
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
                            // ./generationTemp/generated/TCS.g:573:467: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:575:141: ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==COLON) ) {
                alt54=1;
            }
            else if ( (LA54_0==SEMI) ) {
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
                    // ./generationTemp/generated/TCS.g:575:142: ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:575:158: ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) )
                    // ./generationTemp/generated/TCS.g:575:159: ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:575:308: ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) )
                    // ./generationTemp/generated/TCS.g:575:309: ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI )
                    {
                    // ./generationTemp/generated/TCS.g:575:309: ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI )
                    // ./generationTemp/generated/TCS.g:575:310: COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_furcas_tcs_classtemplate3443); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:575:685: ( ( (temp= furcas_tcs_sequence ) ) )
                    // ./generationTemp/generated/TCS.g:575:686: ( (temp= furcas_tcs_sequence ) )
                    {
                    // ./generationTemp/generated/TCS.g:575:686: ( (temp= furcas_tcs_sequence ) )
                    // ./generationTemp/generated/TCS.g:575:687: (temp= furcas_tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:575:890: (temp= furcas_tcs_sequence )
                    // ./generationTemp/generated/TCS.g:575:892: temp= furcas_tcs_sequence
                    {
                    pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_classtemplate3454);
                    temp=furcas_tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templateSequence", temp);
                      setParent(temp,ret,"templateSequence");
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_classtemplate3464); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:576:310: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:576:326: ( SEMI )
                    // ./generationTemp/generated/TCS.g:576:327: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.18/@templateSequence/@elements.3/@elseSequence/@elements.0");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_classtemplate3481); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_classtemplate"


    // $ANTLR start "furcas_tcs_operatortemplate"
    // ./generationTemp/generated/TCS.g:585:1: furcas_tcs_operatortemplate returns [Object ret2] : ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= furcas_tcs_propertyreference )? ( ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) ;
    public final Object furcas_tcs_operatortemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","OperatorTemplate");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:591:3: ( ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= furcas_tcs_propertyreference )? ( ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) ) )
            // ./generationTemp/generated/TCS.g:592:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= furcas_tcs_propertyreference )? ( ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            {
            // ./generationTemp/generated/TCS.g:592:3: ( 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= furcas_tcs_propertyreference )? ( ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) ) )
            // ./generationTemp/generated/TCS.g:592:4: 'operatorTemplate' reference[ret] LPAREN 'operators' EQ (temp= identifier (temp= identifier )* )? COMA 'source' EQ (temp= furcas_tcs_propertyreference )? ( ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) ) | ) ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | ) ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | ) RPAREN ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ) ) ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.0");
            }
            match(input,72,FOLLOW_72_in_furcas_tcs_operatortemplate3528); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.1");
            }
            pushFollow(FOLLOW_reference_in_furcas_tcs_operatortemplate3531);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_operatortemplate3536); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.3");
            }
            match(input,106,FOLLOW_106_in_furcas_tcs_operatortemplate3540); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.4");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3544); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:592:877: (temp= identifier (temp= identifier )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==NAME) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:592:879: temp= identifier (temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_tcs_operatortemplate3552);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setRef(ret, "operators", list("FURCAS","TCS","Operator"), "name", temp, null, "never", null, false, null);
                    }
                    // ./generationTemp/generated/TCS.g:592:1004: (temp= identifier )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==NAME) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:592:1006: temp= identifier
                    	    {
                    	    pushFollow(FOLLOW_identifier_in_furcas_tcs_operatortemplate3560);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setRef(ret, "operators", list("FURCAS","TCS","Operator"), "name", temp, null, "never", null, false, null);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.6");
            }
            match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operatortemplate3572); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.7");
            }
            match(input,52,FOLLOW_52_in_furcas_tcs_operatortemplate3576); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.8");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3580); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.9");
            }
            // ./generationTemp/generated/TCS.g:592:1710: (temp= furcas_tcs_propertyreference )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==NAME||LA57_0==RARROW||(LA57_0>=49 && LA57_0<=133)) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:592:1712: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_operatortemplate3588);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeLeftSideTo", temp);
                      setParent(temp,ret,"storeLeftSideTo");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.10");
            }
            // ./generationTemp/generated/TCS.g:593:184: ( ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) ) | )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==COMA) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==59||LA58_1==68||LA58_1==86||LA58_1==96) ) {
                    alt58=2;
                }
                else if ( (LA58_1==81) ) {
                    alt58=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;
                }
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
                    // ./generationTemp/generated/TCS.g:593:185: ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:593:201: ( COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference ) )
                    // ./generationTemp/generated/TCS.g:593:202: COMA 'storeOpTo' EQ (temp= furcas_tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.10/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operatortemplate3603); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.10/@thenSequence/@elements.1");
                    }
                    match(input,81,FOLLOW_81_in_furcas_tcs_operatortemplate3607); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.10/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3611); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.10/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:593:871: (temp= furcas_tcs_propertyreference )
                    // ./generationTemp/generated/TCS.g:593:873: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_operatortemplate3619);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeOperatorTo", temp);
                      setParent(temp,ret,"storeOperatorTo");
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
                    // ./generationTemp/generated/TCS.g:594:75: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.11");
            }
            // ./generationTemp/generated/TCS.g:595:142: ( ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) ) | )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==COMA) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==86) ) {
                    alt59=1;
                }
                else if ( (LA59_1==59||LA59_1==68||LA59_1==96) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA59_0==RPAREN) ) {
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
                    // ./generationTemp/generated/TCS.g:595:143: ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:595:159: ( COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference ) )
                    // ./generationTemp/generated/TCS.g:595:160: COMA 'storeRightTo' EQ (temp= furcas_tcs_propertyreference )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.11/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operatortemplate3645); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.11/@thenSequence/@elements.1");
                    }
                    match(input,86,FOLLOW_86_in_furcas_tcs_operatortemplate3649); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.11/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3653); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.11/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:595:832: (temp= furcas_tcs_propertyreference )
                    // ./generationTemp/generated/TCS.g:595:834: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_operatortemplate3661);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "storeRightSideTo", temp);
                      setParent(temp,ret,"storeRightSideTo");
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
                    // ./generationTemp/generated/TCS.g:596:76: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.12");
            }
            // ./generationTemp/generated/TCS.g:597:142: ( ( COMA 'disambiguate' EQ (temp= stringSymbol ) ) | )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==COMA) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==68) ) {
                    alt60=1;
                }
                else if ( (LA60_1==59||LA60_1==96) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA60_0==RPAREN) ) {
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
                    // ./generationTemp/generated/TCS.g:597:143: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:597:159: ( COMA 'disambiguate' EQ (temp= stringSymbol ) )
                    // ./generationTemp/generated/TCS.g:597:160: COMA 'disambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.12/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operatortemplate3687); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.12/@thenSequence/@elements.1");
                    }
                    match(input,68,FOLLOW_68_in_furcas_tcs_operatortemplate3691); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.12/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3695); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.12/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:597:832: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:597:834: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_operatortemplate3703);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguate", temp);
                      setParent(temp,ret,"disambiguate");
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
                    // ./generationTemp/generated/TCS.g:598:72: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.13");
            }
            // ./generationTemp/generated/TCS.g:599:142: ( ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) ) | )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==COMA) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==59) ) {
                    alt61=1;
                }
                else if ( (LA61_1==96) ) {
                    alt61=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA61_0==RPAREN) ) {
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
                    // ./generationTemp/generated/TCS.g:599:143: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:599:159: ( COMA 'disambiguateV3' EQ (temp= stringSymbol ) )
                    // ./generationTemp/generated/TCS.g:599:160: COMA 'disambiguateV3' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.13/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operatortemplate3729); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.13/@thenSequence/@elements.1");
                    }
                    match(input,59,FOLLOW_59_in_furcas_tcs_operatortemplate3733); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.13/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3737); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.13/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:599:834: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:599:836: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_operatortemplate3745);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguateV3", temp);
                      setParent(temp,ret,"disambiguateV3");
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
                    // ./generationTemp/generated/TCS.g:600:74: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.14");
            }
            // ./generationTemp/generated/TCS.g:601:142: ( ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) ) | )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==COMA) ) {
                alt62=1;
            }
            else if ( (LA62_0==RPAREN) ) {
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
                    // ./generationTemp/generated/TCS.g:601:143: ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:601:159: ( COMA 'semDisambiguate' EQ (temp= stringSymbol ) )
                    // ./generationTemp/generated/TCS.g:601:160: COMA 'semDisambiguate' EQ (temp= stringSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.14/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operatortemplate3771); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.14/@thenSequence/@elements.1");
                    }
                    match(input,96,FOLLOW_96_in_furcas_tcs_operatortemplate3775); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.14/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operatortemplate3779); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.14/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:601:835: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:601:837: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_operatortemplate3787);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "semDisambiguate", temp);
                      setParent(temp,ret,"semDisambiguate");
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
                    // ./generationTemp/generated/TCS.g:602:75: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.15");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_operatortemplate3807); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.16");
            }
            // ./generationTemp/generated/TCS.g:603:290: ( ( 'referenceOnly' ) | ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==61) ) {
                alt65=1;
            }
            else if ( (LA65_0==SEMI||LA65_0==COLON||LA65_0==50) ) {
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
                    // ./generationTemp/generated/TCS.g:603:291: ( 'referenceOnly' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:603:307: ( 'referenceOnly' )
                    // ./generationTemp/generated/TCS.g:603:308: 'referenceOnly'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.16/@thenSequence/@elements.0");
                    }
                    match(input,61,FOLLOW_61_in_furcas_tcs_operatortemplate3817); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:603:569: ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:603:585: ( ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | ) )
                    // ./generationTemp/generated/TCS.g:603:586: ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.16/@elseSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:603:737: ( ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) ) | )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==50) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==SEMI||LA64_0==COLON) ) {
                        alt64=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 0, input);

                        throw nvae;
                    }
                    switch (alt64) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:603:738: ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:603:754: ( 'context' ( ( (temp= furcas_tcs_contexttags ) ) | ) )
                            // ./generationTemp/generated/TCS.g:603:755: 'context' ( ( (temp= furcas_tcs_contexttags ) ) | )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.16/@elseSequence/@elements.0/@thenSequence/@elements.0");
                            }
                            match(input,50,FOLLOW_50_in_furcas_tcs_operatortemplate3836); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.16/@elseSequence/@elements.0/@thenSequence/@elements.1");
                            }
                            // ./generationTemp/generated/TCS.g:603:1133: ( ( (temp= furcas_tcs_contexttags ) ) | )
                            int alt63=2;
                            int LA63_0 = input.LA(1);

                            if ( (LA63_0==LPAREN) ) {
                                alt63=1;
                            }
                            else if ( (LA63_0==SEMI||LA63_0==COLON) ) {
                                alt63=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ret2;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 63, 0, input);

                                throw nvae;
                            }
                            switch (alt63) {
                                case 1 :
                                    // ./generationTemp/generated/TCS.g:603:1134: ( (temp= furcas_tcs_contexttags ) )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _enterAlt(0);
                                    }
                                    // ./generationTemp/generated/TCS.g:603:1150: ( (temp= furcas_tcs_contexttags ) )
                                    // ./generationTemp/generated/TCS.g:603:1151: (temp= furcas_tcs_contexttags )
                                    {
                                    if ( state.backtracking==0 ) {
                                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.16/@elseSequence/@elements.0/@thenSequence/@elements.1/@thenSequence/@elements.0");
                                    }
                                    // ./generationTemp/generated/TCS.g:603:1353: (temp= furcas_tcs_contexttags )
                                    // ./generationTemp/generated/TCS.g:603:1355: temp= furcas_tcs_contexttags
                                    {
                                    pushFollow(FOLLOW_furcas_tcs_contexttags_in_furcas_tcs_operatortemplate3849);
                                    temp=furcas_tcs_contexttags();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "contextTags", temp);
                                      setParent(temp,ret,"contextTags");
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
                                    // ./generationTemp/generated/TCS.g:604:71: 
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
                            // ./generationTemp/generated/TCS.g:605:91: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17");
            }
            // ./generationTemp/generated/TCS.g:607:142: ( ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) | ( SEMI ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==COLON) ) {
                alt66=1;
            }
            else if ( (LA66_0==SEMI) ) {
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
                    // ./generationTemp/generated/TCS.g:607:143: ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:607:159: ( ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) )
                    // ./generationTemp/generated/TCS.g:607:160: ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:607:310: ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) )
                    // ./generationTemp/generated/TCS.g:607:311: ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI )
                    {
                    // ./generationTemp/generated/TCS.g:607:311: ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI )
                    // ./generationTemp/generated/TCS.g:607:312: COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_furcas_tcs_operatortemplate3900); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:607:689: ( ( (temp= furcas_tcs_sequence ) ) )
                    // ./generationTemp/generated/TCS.g:607:690: ( (temp= furcas_tcs_sequence ) )
                    {
                    // ./generationTemp/generated/TCS.g:607:690: ( (temp= furcas_tcs_sequence ) )
                    // ./generationTemp/generated/TCS.g:607:691: (temp= furcas_tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:607:895: (temp= furcas_tcs_sequence )
                    // ./generationTemp/generated/TCS.g:607:897: temp= furcas_tcs_sequence
                    {
                    pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_operatortemplate3911);
                    temp=furcas_tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "templateSequence", temp);
                      setParent(temp,ret,"templateSequence");
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
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.2");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_operatortemplate3921); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:608:311: ( SEMI )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:608:327: ( SEMI )
                    // ./generationTemp/generated/TCS.g:608:328: SEMI
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.19/@templateSequence/@elements.17/@elseSequence/@elements.0");
                    }
                    match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_operatortemplate3938); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_operatortemplate"


    // $ANTLR start "furcas_tcs_functiontemplate"
    // ./generationTemp/generated/TCS.g:617:1: furcas_tcs_functiontemplate returns [Object ret2] : ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) ;
    public final Object furcas_tcs_functiontemplate() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","FunctionTemplate");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:623:3: ( ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) ) )
            // ./generationTemp/generated/TCS.g:624:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) )
            {
            // ./generationTemp/generated/TCS.g:624:3: ( 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) ) )
            // ./generationTemp/generated/TCS.g:624:4: 'function' (temp= identifier ) LPAREN reference[ret] RPAREN ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.0");
            }
            match(input,58,FOLLOW_58_in_furcas_tcs_functiontemplate3985); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:624:276: (temp= identifier )
            // ./generationTemp/generated/TCS.g:624:278: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_functiontemplate3992);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "functionName", temp);
              setParent(temp,ret,"functionName");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_functiontemplate3999); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.3");
            }
            pushFollow(FOLLOW_reference_in_furcas_tcs_functiontemplate4003);
            reference(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.4");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_functiontemplate4008); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:625:624: ( ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI ) )
            // ./generationTemp/generated/TCS.g:625:625: ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI )
            {
            // ./generationTemp/generated/TCS.g:625:625: ( COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI )
            // ./generationTemp/generated/TCS.g:625:626: COLON ( ( (temp= furcas_tcs_sequence ) ) ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.5/@blockSequence/@elements.0");
            }
            match(input,COLON,FOLLOW_COLON_in_furcas_tcs_functiontemplate4016); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.5/@blockSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:625:949: ( ( (temp= furcas_tcs_sequence ) ) )
            // ./generationTemp/generated/TCS.g:625:950: ( (temp= furcas_tcs_sequence ) )
            {
            // ./generationTemp/generated/TCS.g:625:950: ( (temp= furcas_tcs_sequence ) )
            // ./generationTemp/generated/TCS.g:625:951: (temp= furcas_tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.5/@blockSequence/@elements.1/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:625:1128: (temp= furcas_tcs_sequence )
            // ./generationTemp/generated/TCS.g:625:1130: temp= furcas_tcs_sequence
            {
            pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_functiontemplate4027);
            temp=furcas_tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "functionSequence", temp);
              setParent(temp,ret,"functionSequence");
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.20/@templateSequence/@elements.5/@blockSequence/@elements.2");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_functiontemplate4037); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_functiontemplate"


    // $ANTLR start "furcas_tcs_contexttags"
    // ./generationTemp/generated/TCS.g:634:1: furcas_tcs_contexttags returns [Object ret2] : ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) ;
    public final Object furcas_tcs_contexttags() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ContextTags");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:640:3: ( ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN ) )
            // ./generationTemp/generated/TCS.g:641:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            {
            // ./generationTemp/generated/TCS.g:641:3: ( LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN )
            // ./generationTemp/generated/TCS.g:641:4: LPAREN (temp= identifier ( ( COMA ) temp= identifier )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.21/@templateSequence/@elements.0");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_contexttags4082); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.21/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:641:274: (temp= identifier ( ( COMA ) temp= identifier )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==NAME) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:641:276: temp= identifier ( ( COMA ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_tcs_contexttags4090);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "tags", temp);
                      setParent(temp,ret,"tags");
                    }
                    // ./generationTemp/generated/TCS.g:642:30: ( ( COMA ) temp= identifier )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==COMA) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:642:31: ( COMA ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:642:48: ( COMA )
                    	    // ./generationTemp/generated/TCS.g:642:49: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.21/@templateSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_contexttags4099); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_furcas_tcs_contexttags4107);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "tags", temp);
                    	      setParent(temp,ret,"tags");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.21/@templateSequence/@elements.2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_contexttags4119); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_contexttags"


    // $ANTLR start "furcas_tcs_sequence"
    // ./generationTemp/generated/TCS.g:651:1: furcas_tcs_sequence returns [Object ret2] : ( ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) ) ;
    public final Object furcas_tcs_sequence() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Sequence");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:657:3: ( ( ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) ) )
            // ./generationTemp/generated/TCS.g:658:3: ( ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) )
            {
            // ./generationTemp/generated/TCS.g:658:3: ( ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) )
            // ./generationTemp/generated/TCS.g:658:4: ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.22/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:658:127: ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) )
            // ./generationTemp/generated/TCS.g:658:128: ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? )
            {
            // ./generationTemp/generated/TCS.g:658:128: ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? )
            // ./generationTemp/generated/TCS.g:658:129: (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.22/@templateSequence/@elements.0/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:658:279: (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( ((LA70_0>=NAME && LA70_0<=STRING)||LA70_0==LPAREN||LA70_0==RARROW||LA70_0==LT||LA70_0==LSQUARE||LA70_0==DLSQUARE||(LA70_0>=DOLLAR && LA70_0<=DLCURLY)||(LA70_0>=49 && LA70_0<=133)) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:658:281: temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequence4167);
                    temp=furcas_tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                      setParent(temp,ret,"elements");
                    }
                    // ./generationTemp/generated/TCS.g:659:34: (temp= furcas_tcs_sequenceelement )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( ((LA69_0>=NAME && LA69_0<=STRING)||LA69_0==LPAREN||LA69_0==RARROW||LA69_0==LT||LA69_0==LSQUARE||LA69_0==DLSQUARE||(LA69_0>=DOLLAR && LA69_0<=DLCURLY)||(LA69_0>=49 && LA69_0<=133)) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:659:36: temp= furcas_tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequence4175);
                    	    temp=furcas_tcs_sequenceelement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "elements", temp);
                    	      setParent(temp,ret,"elements");
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
    // $ANTLR end "furcas_tcs_sequence"


    // $ANTLR start "furcas_tcs_sequenceelement"
    // ./generationTemp/generated/TCS.g:668:1: furcas_tcs_sequenceelement returns [Object ret2] : (ret= furcas_tcs_literalref | ret= furcas_tcs_property | ret= furcas_tcs_customseparator | ret= furcas_tcs_block | ret= furcas_tcs_conditionalelement | ret= furcas_tcs_alternative | ret= furcas_tcs_functioncall | ret= furcas_tcs_injectoractionsblock ) ;
    public final Object furcas_tcs_sequenceelement() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:669:3: ( (ret= furcas_tcs_literalref | ret= furcas_tcs_property | ret= furcas_tcs_customseparator | ret= furcas_tcs_block | ret= furcas_tcs_conditionalelement | ret= furcas_tcs_alternative | ret= furcas_tcs_functioncall | ret= furcas_tcs_injectoractionsblock ) )
            // ./generationTemp/generated/TCS.g:670:3: (ret= furcas_tcs_literalref | ret= furcas_tcs_property | ret= furcas_tcs_customseparator | ret= furcas_tcs_block | ret= furcas_tcs_conditionalelement | ret= furcas_tcs_alternative | ret= furcas_tcs_functioncall | ret= furcas_tcs_injectoractionsblock )
            {
            // ./generationTemp/generated/TCS.g:670:3: (ret= furcas_tcs_literalref | ret= furcas_tcs_property | ret= furcas_tcs_customseparator | ret= furcas_tcs_block | ret= furcas_tcs_conditionalelement | ret= furcas_tcs_alternative | ret= furcas_tcs_functioncall | ret= furcas_tcs_injectoractionsblock )
            int alt71=8;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt71=1;
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
                {
                alt71=2;
                }
                break;
            case LT:
                {
                alt71=3;
                }
                break;
            case LSQUARE:
                {
                alt71=4;
                }
                break;
            case LPAREN:
                {
                alt71=5;
                }
                break;
            case DLSQUARE:
                {
                alt71=6;
                }
                break;
            case DOLLAR:
                {
                alt71=7;
                }
                break;
            case DLCURLY:
                {
                alt71=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:670:4: ret= furcas_tcs_literalref
                    {
                    pushFollow(FOLLOW_furcas_tcs_literalref_in_furcas_tcs_sequenceelement4223);
                    ret=furcas_tcs_literalref();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:671:5: ret= furcas_tcs_property
                    {
                    pushFollow(FOLLOW_furcas_tcs_property_in_furcas_tcs_sequenceelement4231);
                    ret=furcas_tcs_property();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:672:5: ret= furcas_tcs_customseparator
                    {
                    pushFollow(FOLLOW_furcas_tcs_customseparator_in_furcas_tcs_sequenceelement4239);
                    ret=furcas_tcs_customseparator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:673:5: ret= furcas_tcs_block
                    {
                    pushFollow(FOLLOW_furcas_tcs_block_in_furcas_tcs_sequenceelement4247);
                    ret=furcas_tcs_block();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./generationTemp/generated/TCS.g:674:5: ret= furcas_tcs_conditionalelement
                    {
                    pushFollow(FOLLOW_furcas_tcs_conditionalelement_in_furcas_tcs_sequenceelement4255);
                    ret=furcas_tcs_conditionalelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // ./generationTemp/generated/TCS.g:675:5: ret= furcas_tcs_alternative
                    {
                    pushFollow(FOLLOW_furcas_tcs_alternative_in_furcas_tcs_sequenceelement4263);
                    ret=furcas_tcs_alternative();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // ./generationTemp/generated/TCS.g:676:5: ret= furcas_tcs_functioncall
                    {
                    pushFollow(FOLLOW_furcas_tcs_functioncall_in_furcas_tcs_sequenceelement4271);
                    ret=furcas_tcs_functioncall();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // ./generationTemp/generated/TCS.g:677:5: ret= furcas_tcs_injectoractionsblock
                    {
                    pushFollow(FOLLOW_furcas_tcs_injectoractionsblock_in_furcas_tcs_sequenceelement4279);
                    ret=furcas_tcs_injectoractionsblock();

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
    // $ANTLR end "furcas_tcs_sequenceelement"


    // $ANTLR start "furcas_tcs_literalref"
    // ./generationTemp/generated/TCS.g:684:1: furcas_tcs_literalref returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object furcas_tcs_literalref() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","LiteralRef");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:690:3: ( ( (temp= stringSymbol ) ) )
            // ./generationTemp/generated/TCS.g:691:3: ( (temp= stringSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:691:3: ( (temp= stringSymbol ) )
            // ./generationTemp/generated/TCS.g:691:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.24/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:691:127: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:691:129: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_literalref4313);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "referredLiteral", list("FURCAS","TCS","Literal"), "value", temp, "#all", "ifmissing", list("FURCAS","TCS","Keyword"), false, null);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.24/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.24/@templateSequence/@elements.1/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_literalref"


    // $ANTLR start "furcas_tcs_propertyreference"
    // ./generationTemp/generated/TCS.g:699:1: furcas_tcs_propertyreference returns [Object ret2] : ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword ) ) ) ) ;
    public final Object furcas_tcs_propertyreference() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PropertyReference");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:705:3: ( ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword ) ) ) ) )
            // ./generationTemp/generated/TCS.g:706:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword ) ) ) )
            {
            // ./generationTemp/generated/TCS.g:706:3: ( ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword ) ) ) )
            // ./generationTemp/generated/TCS.g:706:4: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.25/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:706:128: ( ( (temp= identifierOrKeyword ) ) | ( RARROW (temp= identifierOrKeyword ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==NAME||(LA72_0>=49 && LA72_0<=133)) ) {
                alt72=1;
            }
            else if ( (LA72_0==RARROW) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:706:129: ( (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:706:145: ( (temp= identifierOrKeyword ) )
                    // ./generationTemp/generated/TCS.g:706:146: (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.25/@templateSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:706:295: (temp= identifierOrKeyword )
                    // ./generationTemp/generated/TCS.g:706:297: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_propertyreference4369);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "strucfeature", null, temp, "OCL:#context.oclAsType(FURCAS::TCS::Template).metaReference.oclAsType(ecore::EClass).eAllStructuralFeatures->select(name = ?)", "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.25/@templateSequence/@elements.0/@thenSequence/@elements.0", SyntaxRegistryFacade.getModelUpdaterRegistry());
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
                    // ./generationTemp/generated/TCS.g:706:713: ( RARROW (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:706:729: ( RARROW (temp= identifierOrKeyword ) )
                    // ./generationTemp/generated/TCS.g:706:730: RARROW (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.25/@templateSequence/@elements.0/@elseSequence/@elements.0");
                    }
                    match(input,RARROW,FOLLOW_RARROW_in_furcas_tcs_propertyreference4385); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.25/@templateSequence/@elements.0/@elseSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:706:1052: (temp= identifierOrKeyword )
                    // ./generationTemp/generated/TCS.g:706:1054: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_propertyreference4393);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                      setParent(temp,ret,"name");
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
    // $ANTLR end "furcas_tcs_propertyreference"


    // $ANTLR start "furcas_tcs_property"
    // ./generationTemp/generated/TCS.g:716:1: furcas_tcs_property returns [Object ret2] : ( (temp= furcas_tcs_propertyreference ) ( ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY ) | ) ) ;
    public final Object furcas_tcs_property() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Property");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:722:3: ( ( (temp= furcas_tcs_propertyreference ) ( ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY ) | ) ) )
            // ./generationTemp/generated/TCS.g:723:3: ( (temp= furcas_tcs_propertyreference ) ( ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY ) | ) )
            {
            // ./generationTemp/generated/TCS.g:723:3: ( (temp= furcas_tcs_propertyreference ) ( ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY ) | ) )
            // ./generationTemp/generated/TCS.g:723:4: (temp= furcas_tcs_propertyreference ) ( ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:723:127: (temp= furcas_tcs_propertyreference )
            // ./generationTemp/generated/TCS.g:723:129: temp= furcas_tcs_propertyreference
            {
            pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_property4446);
            temp=furcas_tcs_propertyreference();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyReference", temp);
              setParent(temp,ret,"propertyReference");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:724:183: ( ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY ) | )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==LCURLY) ) {
                alt75=1;
            }
            else if ( (LA75_0==EOF||(LA75_0>=NAME && LA75_0<=STRING)||LA75_0==LPAREN||LA75_0==RPAREN||(LA75_0>=RCURLY && LA75_0<=LT)||(LA75_0>=LSQUARE && LA75_0<=RSQUARE)||(LA75_0>=DLSQUARE && LA75_0<=DRSQUARE)||(LA75_0>=DOLLAR && LA75_0<=DLCURLY)||(LA75_0>=49 && LA75_0<=133)) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:724:184: ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:724:200: ( LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY )
                    // ./generationTemp/generated/TCS.g:724:201: LCURLY (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_property4459); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.1/@thenSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:724:523: (temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )* )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==51||LA74_0==63||(LA74_0>=67 && LA74_0<=68)||LA74_0==70||LA74_0==76||LA74_0==83||LA74_0==89||(LA74_0>=92 && LA74_0<=93)||LA74_0==105||LA74_0==111||LA74_0==117||(LA74_0>=121 && LA74_0<=122)||LA74_0==127||LA74_0==129) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:724:525: temp= furcas_tcs_propertyarg ( ( COMA ) temp= furcas_tcs_propertyarg )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_propertyarg_in_furcas_tcs_property4467);
                            temp=furcas_tcs_propertyarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyArgs", temp);
                              setParent(temp,ret,"propertyArgs");
                            }
                            // ./generationTemp/generated/TCS.g:725:38: ( ( COMA ) temp= furcas_tcs_propertyarg )*
                            loop73:
                            do {
                                int alt73=2;
                                int LA73_0 = input.LA(1);

                                if ( (LA73_0==COMA) ) {
                                    alt73=1;
                                }


                                switch (alt73) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:725:39: ( COMA ) temp= furcas_tcs_propertyarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./generationTemp/generated/TCS.g:725:56: ( COMA )
                            	    // ./generationTemp/generated/TCS.g:725:57: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.1/@thenSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_property4476); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_furcas_tcs_propertyarg_in_furcas_tcs_property4484);
                            	    temp=furcas_tcs_propertyarg();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "propertyArgs", temp);
                            	      setParent(temp,ret,"propertyArgs");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop73;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.1/@thenSequence/@elements.2");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_property4496); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:726:250: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.26/@templateSequence/@elements.2/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_property"


    // $ANTLR start "furcas_tcs_customseparator"
    // ./generationTemp/generated/TCS.g:735:1: furcas_tcs_customseparator returns [Object ret2] : ( LT (temp= identifier ) GT ) ;
    public final Object furcas_tcs_customseparator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","CustomSeparator");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:741:3: ( ( LT (temp= identifier ) GT ) )
            // ./generationTemp/generated/TCS.g:742:3: ( LT (temp= identifier ) GT )
            {
            // ./generationTemp/generated/TCS.g:742:3: ( LT (temp= identifier ) GT )
            // ./generationTemp/generated/TCS.g:742:4: LT (temp= identifier ) GT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.27/@templateSequence/@elements.0");
            }
            match(input,LT,FOLLOW_LT_in_furcas_tcs_customseparator4554); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.27/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:742:270: (temp= identifier )
            // ./generationTemp/generated/TCS.g:742:272: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_customseparator4562);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.27/@templateSequence/@elements.2");
            }
            match(input,GT,FOLLOW_GT_in_furcas_tcs_customseparator4569); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.27/@templateSequence/@elements.3");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.27/@templateSequence/@elements.3/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_customseparator"


    // $ANTLR start "furcas_tcs_block"
    // ./generationTemp/generated/TCS.g:751:1: furcas_tcs_block returns [Object ret2] : ( LSQUARE (temp= furcas_tcs_sequence ) RSQUARE ( ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY ) | ) ) ;
    public final Object furcas_tcs_block() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Block");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:757:3: ( ( LSQUARE (temp= furcas_tcs_sequence ) RSQUARE ( ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY ) | ) ) )
            // ./generationTemp/generated/TCS.g:758:3: ( LSQUARE (temp= furcas_tcs_sequence ) RSQUARE ( ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY ) | ) )
            {
            // ./generationTemp/generated/TCS.g:758:3: ( LSQUARE (temp= furcas_tcs_sequence ) RSQUARE ( ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY ) | ) )
            // ./generationTemp/generated/TCS.g:758:4: LSQUARE (temp= furcas_tcs_sequence ) RSQUARE ( ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.0");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_furcas_tcs_block4614); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:758:275: (temp= furcas_tcs_sequence )
            // ./generationTemp/generated/TCS.g:758:277: temp= furcas_tcs_sequence
            {
            pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_block4622);
            temp=furcas_tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "blockSequence", temp);
              setParent(temp,ret,"blockSequence");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.2");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_furcas_tcs_block4629); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:759:327: ( ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY ) | )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==LCURLY) ) {
                alt78=1;
            }
            else if ( (LA78_0==EOF||(LA78_0>=NAME && LA78_0<=STRING)||LA78_0==LPAREN||LA78_0==RPAREN||(LA78_0>=RCURLY && LA78_0<=LT)||(LA78_0>=LSQUARE && LA78_0<=RSQUARE)||(LA78_0>=DLSQUARE && LA78_0<=DRSQUARE)||(LA78_0>=DOLLAR && LA78_0<=DLCURLY)||(LA78_0>=49 && LA78_0<=133)) ) {
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
                    // ./generationTemp/generated/TCS.g:759:328: ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:759:344: ( LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY )
                    // ./generationTemp/generated/TCS.g:759:345: LCURLY (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )? RCURLY
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_block4640); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.3/@thenSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:759:667: (temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )* )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==60||LA77_0==85||LA77_0==107||(LA77_0>=131 && LA77_0<=132)) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:759:669: temp= furcas_tcs_blockarg ( ( COMA ) temp= furcas_tcs_blockarg )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_blockarg_in_furcas_tcs_block4648);
                            temp=furcas_tcs_blockarg();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "blockArgs", temp);
                              setParent(temp,ret,"blockArgs");
                            }
                            // ./generationTemp/generated/TCS.g:760:35: ( ( COMA ) temp= furcas_tcs_blockarg )*
                            loop76:
                            do {
                                int alt76=2;
                                int LA76_0 = input.LA(1);

                                if ( (LA76_0==COMA) ) {
                                    alt76=1;
                                }


                                switch (alt76) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:760:36: ( COMA ) temp= furcas_tcs_blockarg
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./generationTemp/generated/TCS.g:760:53: ( COMA )
                            	    // ./generationTemp/generated/TCS.g:760:54: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.3/@thenSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_block4657); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_furcas_tcs_blockarg_in_furcas_tcs_block4665);
                            	    temp=furcas_tcs_blockarg();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "blockArgs", temp);
                            	      setParent(temp,ret,"blockArgs");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop76;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.3/@thenSequence/@elements.2");
                    }
                    match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_block4677); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:761:247: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.28/@templateSequence/@elements.4/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_block"


    // $ANTLR start "furcas_tcs_conditionalelement"
    // ./generationTemp/generated/TCS.g:770:1: furcas_tcs_conditionalelement returns [Object ret2] : ( LPAREN (temp= furcas_tcs_expression ) QMARK (temp= furcas_tcs_sequence ) ( ( COLON (temp= furcas_tcs_sequence ) ) | ) RPAREN ) ;
    public final Object furcas_tcs_conditionalelement() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ConditionalElement");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:776:3: ( ( LPAREN (temp= furcas_tcs_expression ) QMARK (temp= furcas_tcs_sequence ) ( ( COLON (temp= furcas_tcs_sequence ) ) | ) RPAREN ) )
            // ./generationTemp/generated/TCS.g:777:3: ( LPAREN (temp= furcas_tcs_expression ) QMARK (temp= furcas_tcs_sequence ) ( ( COLON (temp= furcas_tcs_sequence ) ) | ) RPAREN )
            {
            // ./generationTemp/generated/TCS.g:777:3: ( LPAREN (temp= furcas_tcs_expression ) QMARK (temp= furcas_tcs_sequence ) ( ( COLON (temp= furcas_tcs_sequence ) ) | ) RPAREN )
            // ./generationTemp/generated/TCS.g:777:4: LPAREN (temp= furcas_tcs_expression ) QMARK (temp= furcas_tcs_sequence ) ( ( COLON (temp= furcas_tcs_sequence ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.0");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_conditionalelement4735); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:777:274: (temp= furcas_tcs_expression )
            // ./generationTemp/generated/TCS.g:777:276: temp= furcas_tcs_expression
            {
            pushFollow(FOLLOW_furcas_tcs_expression_in_furcas_tcs_conditionalelement4743);
            temp=furcas_tcs_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "condition", temp);
              setParent(temp,ret,"condition");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.2");
            }
            match(input,QMARK,FOLLOW_QMARK_in_furcas_tcs_conditionalelement4750); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:778:320: (temp= furcas_tcs_sequence )
            // ./generationTemp/generated/TCS.g:778:322: temp= furcas_tcs_sequence
            {
            pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_conditionalelement4758);
            temp=furcas_tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "thenSequence", temp);
              setParent(temp,ret,"thenSequence");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:779:178: ( ( COLON (temp= furcas_tcs_sequence ) ) | )
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
                    // ./generationTemp/generated/TCS.g:779:179: ( COLON (temp= furcas_tcs_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:779:195: ( COLON (temp= furcas_tcs_sequence ) )
                    // ./generationTemp/generated/TCS.g:779:196: COLON (temp= furcas_tcs_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.4/@thenSequence/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_furcas_tcs_conditionalelement4771); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.4/@thenSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:779:517: (temp= furcas_tcs_sequence )
                    // ./generationTemp/generated/TCS.g:779:519: temp= furcas_tcs_sequence
                    {
                    pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_conditionalelement4779);
                    temp=furcas_tcs_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elseSequence", temp);
                      setParent(temp,ret,"elseSequence");
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
                    // ./generationTemp/generated/TCS.g:780:72: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.5");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_conditionalelement4799); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.6");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.29/@templateSequence/@elements.6/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_conditionalelement"


    // $ANTLR start "furcas_tcs_alternative"
    // ./generationTemp/generated/TCS.g:789:1: furcas_tcs_alternative returns [Object ret2] : ( DLSQUARE ( ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) ) ) DRSQUARE ( ( STAR ) | ) ) ;
    public final Object furcas_tcs_alternative() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Alternative");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:795:3: ( ( DLSQUARE ( ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) ) ) DRSQUARE ( ( STAR ) | ) ) )
            // ./generationTemp/generated/TCS.g:796:3: ( DLSQUARE ( ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) ) ) DRSQUARE ( ( STAR ) | ) )
            {
            // ./generationTemp/generated/TCS.g:796:3: ( DLSQUARE ( ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) ) ) DRSQUARE ( ( STAR ) | ) )
            // ./generationTemp/generated/TCS.g:796:4: DLSQUARE ( ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) ) ) DRSQUARE ( ( STAR ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.0");
            }
            match(input,DLSQUARE,FOLLOW_DLSQUARE_in_furcas_tcs_alternative4844); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:796:276: ( ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) ) )
            // ./generationTemp/generated/TCS.g:796:277: ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) )
            {
            // ./generationTemp/generated/TCS.g:796:277: ( (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ ) )
            // ./generationTemp/generated/TCS.g:796:278: (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.1/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:796:428: (temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+ )
            // ./generationTemp/generated/TCS.g:796:430: temp= furcas_tcs_sequenceinalternative_nestedSequence ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+
            {
            pushFollow(FOLLOW_furcas_tcs_sequenceinalternative_nestedSequence_in_furcas_tcs_alternative4855);
            temp=furcas_tcs_sequenceinalternative_nestedSequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "sequences", temp);
              setParent(temp,ret,"sequences");
            }
            // ./generationTemp/generated/TCS.g:797:35: ( ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence )+
            int cnt80=0;
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==PIPE) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // ./generationTemp/generated/TCS.g:797:36: ( PIPE ) temp= furcas_tcs_sequenceinalternative_nestedSequence
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./generationTemp/generated/TCS.g:797:53: ( PIPE )
            	    // ./generationTemp/generated/TCS.g:797:54: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.1/@separatorSequence/@elements.0");
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_furcas_tcs_alternative4864); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_furcas_tcs_sequenceinalternative_nestedSequence_in_furcas_tcs_alternative4872);
            	    temp=furcas_tcs_sequenceinalternative_nestedSequence();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "sequences", temp);
            	      setParent(temp,ret,"sequences");
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt80 >= 1 ) break loop80;
            	    if (state.backtracking>0) {state.failed=true; return ret2;}
                        EarlyExitException eee =
                            new EarlyExitException(80, input);
                        throw eee;
                }
                cnt80++;
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.2");
            }
            match(input,DRSQUARE,FOLLOW_DRSQUARE_in_furcas_tcs_alternative4884); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:798:344: ( ( STAR ) | )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==STAR) ) {
                alt81=1;
            }
            else if ( (LA81_0==EOF||(LA81_0>=NAME && LA81_0<=STRING)||LA81_0==LPAREN||LA81_0==RPAREN||(LA81_0>=RCURLY && LA81_0<=LT)||(LA81_0>=LSQUARE && LA81_0<=RSQUARE)||(LA81_0>=DLSQUARE && LA81_0<=DRSQUARE)||(LA81_0>=DOLLAR && LA81_0<=DLCURLY)||(LA81_0>=49 && LA81_0<=133)) ) {
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
                    // ./generationTemp/generated/TCS.g:798:345: ( STAR )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:798:361: ( STAR )
                    // ./generationTemp/generated/TCS.g:798:362: STAR
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    match(input,STAR,FOLLOW_STAR_in_furcas_tcs_alternative4895); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:798:605: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.30/@templateSequence/@elements.4/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_alternative"


    // $ANTLR start "furcas_tcs_sequenceinalternative_nestedSequence"
    // ./generationTemp/generated/TCS.g:807:1: furcas_tcs_sequenceinalternative_nestedSequence returns [Object ret2] : ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) ) ;
    public final Object furcas_tcs_sequenceinalternative_nestedSequence() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","SequenceInAlternative");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"nestedSequence");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:813:3: ( ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) ) )
            // ./generationTemp/generated/TCS.g:814:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) )
            {
            // ./generationTemp/generated/TCS.g:814:3: ( ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) ) )
            // ./generationTemp/generated/TCS.g:814:4: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | ) ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:814:128: ( ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN ) | )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==68) ) {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==EOF||(LA82_1>=NAME && LA82_1<=STRING)||LA82_1==LCURLY||LA82_1==RARROW||LA82_1==LT||LA82_1==LSQUARE||(LA82_1>=DLSQUARE && LA82_1<=DRSQUARE)||(LA82_1>=DOLLAR && LA82_1<=DLCURLY)||(LA82_1>=49 && LA82_1<=133)) ) {
                    alt82=2;
                }
                else if ( (LA82_1==LPAREN) ) {
                    int LA82_3 = input.LA(3);

                    if ( (LA82_3==NAME||LA82_3==EQ||LA82_3==RARROW||LA82_3==QMARK||(LA82_3>=49 && LA82_3<=133)) ) {
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
            else if ( (LA82_0==EOF||(LA82_0>=NAME && LA82_0<=STRING)||LA82_0==LPAREN||LA82_0==RARROW||LA82_0==LT||LA82_0==LSQUARE||(LA82_0>=DLSQUARE && LA82_0<=DRSQUARE)||(LA82_0>=DOLLAR && LA82_0<=DLCURLY)||(LA82_0>=49 && LA82_0<=67)||(LA82_0>=69 && LA82_0<=133)) ) {
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
                    // ./generationTemp/generated/TCS.g:814:129: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:814:145: ( 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN )
                    // ./generationTemp/generated/TCS.g:814:146: 'disambiguate' LPAREN (temp= stringSymbol ) RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    match(input,68,FOLLOW_68_in_furcas_tcs_sequenceinalternative_nestedSequence4960); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.0/@thenSequence/@elements.1");
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_sequenceinalternative_nestedSequence4964); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.0/@thenSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:814:647: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:814:649: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_sequenceinalternative_nestedSequence4972);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguate", temp);
                      setParent(temp,ret,"disambiguate");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.0/@thenSequence/@elements.3");
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_sequenceinalternative_nestedSequence4979); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:815:245: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:816:140: ( ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? ) )
            // ./generationTemp/generated/TCS.g:816:141: ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? )
            {
            // ./generationTemp/generated/TCS.g:816:141: ( (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )? )
            // ./generationTemp/generated/TCS.g:816:142: (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.31/@templateSequence/@elements.1/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:816:292: (temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( ((LA84_0>=NAME && LA84_0<=STRING)||LA84_0==LPAREN||LA84_0==RARROW||LA84_0==LT||LA84_0==LSQUARE||LA84_0==DLSQUARE||(LA84_0>=DOLLAR && LA84_0<=DLCURLY)||(LA84_0>=49 && LA84_0<=133)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:816:294: temp= furcas_tcs_sequenceelement (temp= furcas_tcs_sequenceelement )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequenceinalternative_nestedSequence5003);
                    temp=furcas_tcs_sequenceelement();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                      setParent(temp,ret,"elements");
                    }
                    // ./generationTemp/generated/TCS.g:817:34: (temp= furcas_tcs_sequenceelement )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( ((LA83_0>=NAME && LA83_0<=STRING)||LA83_0==LPAREN||LA83_0==RARROW||LA83_0==LT||LA83_0==LSQUARE||LA83_0==DLSQUARE||(LA83_0>=DOLLAR && LA83_0<=DLCURLY)||(LA83_0>=49 && LA83_0<=133)) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:817:36: temp= furcas_tcs_sequenceelement
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequenceinalternative_nestedSequence5011);
                    	    temp=furcas_tcs_sequenceelement();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "elements", temp);
                    	      setParent(temp,ret,"elements");
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


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_sequenceinalternative_nestedSequence"


    // $ANTLR start "furcas_tcs_functioncall"
    // ./generationTemp/generated/TCS.g:826:1: furcas_tcs_functioncall returns [Object ret2] : ( DOLLAR (temp= identifier ) ) ;
    public final Object furcas_tcs_functioncall() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","FunctionCall");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:832:3: ( ( DOLLAR (temp= identifier ) ) )
            // ./generationTemp/generated/TCS.g:833:3: ( DOLLAR (temp= identifier ) )
            {
            // ./generationTemp/generated/TCS.g:833:3: ( DOLLAR (temp= identifier ) )
            // ./generationTemp/generated/TCS.g:833:4: DOLLAR (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.32/@templateSequence/@elements.0");
            }
            match(input,DOLLAR,FOLLOW_DOLLAR_in_furcas_tcs_functioncall5063); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.32/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:833:274: (temp= identifier )
            // ./generationTemp/generated/TCS.g:833:276: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_functioncall5071);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setRef(ret, "calledFunction", list("FURCAS","TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.32/@templateSequence/@elements.2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.32/@templateSequence/@elements.2/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_functioncall"


    // $ANTLR start "furcas_tcs_injectoractionsblock"
    // ./generationTemp/generated/TCS.g:841:1: furcas_tcs_injectoractionsblock returns [Object ret2] : ( DLCURLY ( ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? ) ) DRCURLY ) ;
    public final Object furcas_tcs_injectoractionsblock() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","InjectorActionsBlock");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:847:3: ( ( DLCURLY ( ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? ) ) DRCURLY ) )
            // ./generationTemp/generated/TCS.g:848:3: ( DLCURLY ( ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? ) ) DRCURLY )
            {
            // ./generationTemp/generated/TCS.g:848:3: ( DLCURLY ( ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? ) ) DRCURLY )
            // ./generationTemp/generated/TCS.g:848:4: DLCURLY ( ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? ) ) DRCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.0");
            }
            match(input,DLCURLY,FOLLOW_DLCURLY_in_furcas_tcs_injectoractionsblock5118); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:848:275: ( ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? ) )
            // ./generationTemp/generated/TCS.g:848:276: ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? )
            {
            // ./generationTemp/generated/TCS.g:848:276: ( (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )? )
            // ./generationTemp/generated/TCS.g:848:277: (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.1/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:848:427: (temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )* )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==NAME||LA86_0==EQ||LA86_0==RARROW||LA86_0==LARROW||(LA86_0>=49 && LA86_0<=133)) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:848:429: temp= furcas_tcs_injectoraction ( ( COMA ) temp= furcas_tcs_injectoraction )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_injectoraction_in_furcas_tcs_injectoractionsblock5129);
                    temp=furcas_tcs_injectoraction();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "injectorActions", temp);
                      setParent(temp,ret,"injectorActions");
                    }
                    // ./generationTemp/generated/TCS.g:849:41: ( ( COMA ) temp= furcas_tcs_injectoraction )*
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( (LA85_0==COMA) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:849:42: ( COMA ) temp= furcas_tcs_injectoraction
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:849:59: ( COMA )
                    	    // ./generationTemp/generated/TCS.g:849:60: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_injectoractionsblock5138); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_furcas_tcs_injectoraction_in_furcas_tcs_injectoractionsblock5146);
                    	    temp=furcas_tcs_injectoraction();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "injectorActions", temp);
                    	      setParent(temp,ret,"injectorActions");
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

            }


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.2");
            }
            match(input,DRCURLY,FOLLOW_DRCURLY_in_furcas_tcs_injectoractionsblock5161); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.3");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true, "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.33/@templateSequence/@elements.3/@injectorActions.0", SyntaxRegistryFacade.getModelUpdaterRegistry());_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_injectoractionsblock"


    // $ANTLR start "furcas_tcs_injectoraction"
    // ./generationTemp/generated/TCS.g:858:1: furcas_tcs_injectoraction returns [Object ret2] : (ret= furcas_tcs_propertyinit ) ;
    public final Object furcas_tcs_injectoraction() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:859:3: ( (ret= furcas_tcs_propertyinit ) )
            // ./generationTemp/generated/TCS.g:860:3: (ret= furcas_tcs_propertyinit )
            {
            // ./generationTemp/generated/TCS.g:860:3: (ret= furcas_tcs_propertyinit )
            // ./generationTemp/generated/TCS.g:860:4: ret= furcas_tcs_propertyinit
            {
            pushFollow(FOLLOW_furcas_tcs_propertyinit_in_furcas_tcs_injectoraction5202);
            ret=furcas_tcs_propertyinit();

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
    // $ANTLR end "furcas_tcs_injectoraction"


    // $ANTLR start "furcas_tcs_propertyinit"
    // ./generationTemp/generated/TCS.g:867:1: furcas_tcs_propertyinit returns [Object ret2] : (ret= furcas_tcs_primitivepropertyinit | ret= furcas_tcs_lookuppropertyinit | ret= furcas_tcs_foreachpredicatepropertyinit ) ;
    public final Object furcas_tcs_propertyinit() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:868:3: ( (ret= furcas_tcs_primitivepropertyinit | ret= furcas_tcs_lookuppropertyinit | ret= furcas_tcs_foreachpredicatepropertyinit ) )
            // ./generationTemp/generated/TCS.g:869:3: (ret= furcas_tcs_primitivepropertyinit | ret= furcas_tcs_lookuppropertyinit | ret= furcas_tcs_foreachpredicatepropertyinit )
            {
            // ./generationTemp/generated/TCS.g:869:3: (ret= furcas_tcs_primitivepropertyinit | ret= furcas_tcs_lookuppropertyinit | ret= furcas_tcs_foreachpredicatepropertyinit )
            int alt87=3;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:869:4: ret= furcas_tcs_primitivepropertyinit
                    {
                    pushFollow(FOLLOW_furcas_tcs_primitivepropertyinit_in_furcas_tcs_propertyinit5229);
                    ret=furcas_tcs_primitivepropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:870:5: ret= furcas_tcs_lookuppropertyinit
                    {
                    pushFollow(FOLLOW_furcas_tcs_lookuppropertyinit_in_furcas_tcs_propertyinit5237);
                    ret=furcas_tcs_lookuppropertyinit();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:871:5: ret= furcas_tcs_foreachpredicatepropertyinit
                    {
                    pushFollow(FOLLOW_furcas_tcs_foreachpredicatepropertyinit_in_furcas_tcs_propertyinit5245);
                    ret=furcas_tcs_foreachpredicatepropertyinit();

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
    // $ANTLR end "furcas_tcs_propertyinit"


    // $ANTLR start "furcas_tcs_primitivepropertyinit"
    // ./generationTemp/generated/TCS.g:878:1: furcas_tcs_primitivepropertyinit returns [Object ret2] : ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) (temp= escapedIdentifierOrKeyword )? ) ;
    public final Object furcas_tcs_primitivepropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PrimitivePropertyInit");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:884:3: ( ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) (temp= escapedIdentifierOrKeyword )? ) )
            // ./generationTemp/generated/TCS.g:885:3: ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) (temp= escapedIdentifierOrKeyword )? )
            {
            // ./generationTemp/generated/TCS.g:885:3: ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) (temp= escapedIdentifierOrKeyword )? )
            // ./generationTemp/generated/TCS.g:885:4: (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) (temp= escapedIdentifierOrKeyword )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.36/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:885:127: (temp= furcas_tcs_propertyreference )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==NAME||LA88_0==RARROW||(LA88_0>=49 && LA88_0<=133)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:885:129: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_primitivepropertyinit5279);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.36/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:886:185: ( ( LARROW ) | ( EQ ) )
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
                    // ./generationTemp/generated/TCS.g:886:186: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:886:202: ( LARROW )
                    // ./generationTemp/generated/TCS.g:886:203: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.36/@templateSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_furcas_tcs_primitivepropertyinit5294); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:886:448: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:886:464: ( EQ )
                    // ./generationTemp/generated/TCS.g:886:465: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.36/@templateSequence/@elements.1/@elseSequence/@elements.0");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_primitivepropertyinit5309); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.36/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:887:140: (temp= escapedIdentifierOrKeyword )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==NAME||(LA90_0>=49 && LA90_0<=133)) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:887:142: temp= escapedIdentifierOrKeyword
                    {
                    pushFollow(FOLLOW_escapedIdentifierOrKeyword_in_furcas_tcs_primitivepropertyinit5324);
                    temp=escapedIdentifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_primitivepropertyinit"


    // $ANTLR start "furcas_tcs_lookuppropertyinit"
    // ./generationTemp/generated/TCS.g:896:1: furcas_tcs_lookuppropertyinit returns [Object ret2] : ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol )? RPAREN ) ;
    public final Object furcas_tcs_lookuppropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","LookupPropertyInit");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:902:3: ( ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol )? RPAREN ) )
            // ./generationTemp/generated/TCS.g:903:3: ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol )? RPAREN )
            {
            // ./generationTemp/generated/TCS.g:903:3: ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol )? RPAREN )
            // ./generationTemp/generated/TCS.g:903:4: (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'lookIn' LPAREN (temp= stringSymbol )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:903:127: (temp= furcas_tcs_propertyreference )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==NAME||LA91_0==RARROW||(LA91_0>=49 && LA91_0<=133)) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:903:129: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_lookuppropertyinit5373);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:904:185: ( ( LARROW ) | ( EQ ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==LARROW) ) {
                alt92=1;
            }
            else if ( (LA92_0==EQ) ) {
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
                    // ./generationTemp/generated/TCS.g:904:186: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:904:202: ( LARROW )
                    // ./generationTemp/generated/TCS.g:904:203: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_furcas_tcs_lookuppropertyinit5388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:904:448: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:904:464: ( EQ )
                    // ./generationTemp/generated/TCS.g:904:465: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.1/@elseSequence/@elements.0");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_lookuppropertyinit5403); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.2");
            }
            match(input,83,FOLLOW_83_in_furcas_tcs_lookuppropertyinit5414); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_lookuppropertyinit5418); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:905:434: (temp= stringSymbol )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==STRING) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:905:436: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_lookuppropertyinit5426);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.37/@templateSequence/@elements.5");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_lookuppropertyinit5435); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_lookuppropertyinit"


    // $ANTLR start "furcas_tcs_foreachpredicatepropertyinit"
    // ./generationTemp/generated/TCS.g:914:1: furcas_tcs_foreachpredicatepropertyinit returns [Object ret2] : ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol )? ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | ) ( ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) ) | ) RPAREN ) ;
    public final Object furcas_tcs_foreachpredicatepropertyinit() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ForeachPredicatePropertyInit");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:920:3: ( ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol )? ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | ) ( ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) ) | ) RPAREN ) )
            // ./generationTemp/generated/TCS.g:921:3: ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol )? ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | ) ( ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) ) | ) RPAREN )
            {
            // ./generationTemp/generated/TCS.g:921:3: ( (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol )? ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | ) ( ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) ) | ) RPAREN )
            // ./generationTemp/generated/TCS.g:921:4: (temp= furcas_tcs_propertyreference )? ( ( LARROW ) | ( EQ ) ) 'foreach' LPAREN (temp= stringSymbol )? ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | ) ( ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:921:127: (temp= furcas_tcs_propertyreference )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==NAME||LA94_0==RARROW||(LA94_0>=49 && LA94_0<=133)) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:921:129: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_foreachpredicatepropertyinit5480);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:922:185: ( ( LARROW ) | ( EQ ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==LARROW) ) {
                alt95=1;
            }
            else if ( (LA95_0==EQ) ) {
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
                    // ./generationTemp/generated/TCS.g:922:186: ( LARROW )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:922:202: ( LARROW )
                    // ./generationTemp/generated/TCS.g:922:203: LARROW
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    match(input,LARROW,FOLLOW_LARROW_in_furcas_tcs_foreachpredicatepropertyinit5495); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:922:448: ( EQ )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:922:464: ( EQ )
                    // ./generationTemp/generated/TCS.g:922:465: EQ
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.1/@elseSequence/@elements.0");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_foreachpredicatepropertyinit5510); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "default", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.2");
            }
            match(input,101,FOLLOW_101_in_furcas_tcs_foreachpredicatepropertyinit5521); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.3");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_foreachpredicatepropertyinit5525); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:923:435: (temp= stringSymbol )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==STRING) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:923:437: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_foreachpredicatepropertyinit5533);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:924:173: ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | )
            int alt97=2;
            alt97 = dfa97.predict(input);
            switch (alt97) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:924:174: ( COMA 'mode' EQ (temp= identifierOrKeyword ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:924:190: ( COMA 'mode' EQ (temp= identifierOrKeyword ) )
                    // ./generationTemp/generated/TCS.g:924:191: COMA 'mode' EQ (temp= identifierOrKeyword )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.5/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_foreachpredicatepropertyinit5548); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.5/@thenSequence/@elements.1");
                    }
                    match(input,93,FOLLOW_93_in_furcas_tcs_foreachpredicatepropertyinit5552); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.5/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_foreachpredicatepropertyinit5556); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.5/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:924:851: (temp= identifierOrKeyword )
                    // ./generationTemp/generated/TCS.g:924:853: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_foreachpredicatepropertyinit5564);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mode", temp);
                      setParent(temp,ret,"mode");
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
                    // ./generationTemp/generated/TCS.g:925:64: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.6");
            }
            // ./generationTemp/generated/TCS.g:926:141: ( ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) ) | )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==COMA) ) {
                alt100=1;
            }
            else if ( (LA100_0==RPAREN) ) {
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
                    // ./generationTemp/generated/TCS.g:926:142: ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:926:158: ( COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) ) )
                    // ./generationTemp/generated/TCS.g:926:159: COMA ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.6/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_foreachpredicatepropertyinit5590); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.6/@thenSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:926:479: ( ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? ) )
                    // ./generationTemp/generated/TCS.g:926:480: ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? )
                    {
                    // ./generationTemp/generated/TCS.g:926:480: ( (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )? )
                    // ./generationTemp/generated/TCS.g:926:481: (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.6/@thenSequence/@elements.1/@blockSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:926:657: (temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )* )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==82||LA99_0==93||LA99_0==127) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:926:659: temp= furcas_tcs_predicatesemantic ( ( COMA ) temp= furcas_tcs_predicatesemantic )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_predicatesemantic_in_furcas_tcs_foreachpredicatepropertyinit5601);
                            temp=furcas_tcs_predicatesemantic();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "predicateSemantic", temp);
                              setParent(temp,ret,"predicateSemantic");
                            }
                            // ./generationTemp/generated/TCS.g:927:43: ( ( COMA ) temp= furcas_tcs_predicatesemantic )*
                            loop98:
                            do {
                                int alt98=2;
                                int LA98_0 = input.LA(1);

                                if ( (LA98_0==COMA) ) {
                                    alt98=1;
                                }


                                switch (alt98) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:927:44: ( COMA ) temp= furcas_tcs_predicatesemantic
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./generationTemp/generated/TCS.g:927:61: ( COMA )
                            	    // ./generationTemp/generated/TCS.g:927:62: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.6/@thenSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_foreachpredicatepropertyinit5610); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_furcas_tcs_predicatesemantic_in_furcas_tcs_foreachpredicatepropertyinit5618);
                            	    temp=furcas_tcs_predicatesemantic();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "predicateSemantic", temp);
                            	      setParent(temp,ret,"predicateSemantic");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop98;
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
                    // ./generationTemp/generated/TCS.g:928:100: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.7");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_foreachpredicatepropertyinit5646); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_foreachpredicatepropertyinit"


    // $ANTLR start "furcas_tcs_predicatesemantic"
    // ./generationTemp/generated/TCS.g:937:1: furcas_tcs_predicatesemantic returns [Object ret2] : ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= identifierOrKeyword ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) ;
    public final Object furcas_tcs_predicatesemantic() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PredicateSemantic");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:943:3: ( ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= identifierOrKeyword ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? ) )
            // ./generationTemp/generated/TCS.g:944:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= identifierOrKeyword ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            {
            // ./generationTemp/generated/TCS.g:944:3: ( ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= identifierOrKeyword ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )? )
            // ./generationTemp/generated/TCS.g:944:4: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | ) ( ( 'mode' EQ (temp= identifierOrKeyword ) COMA ) | ) 'as' EQ (temp= identifierOrKeyword )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:944:128: ( ( 'when' EQ (temp= stringSymbol ) COMA ) | )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==82) ) {
                alt101=1;
            }
            else if ( (LA101_0==93||LA101_0==127) ) {
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
                    // ./generationTemp/generated/TCS.g:944:129: ( 'when' EQ (temp= stringSymbol ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:944:145: ( 'when' EQ (temp= stringSymbol ) COMA )
                    // ./generationTemp/generated/TCS.g:944:146: 'when' EQ (temp= stringSymbol ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    match(input,82,FOLLOW_82_in_furcas_tcs_predicatesemantic5693); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.0/@thenSequence/@elements.1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_predicatesemantic5697); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.0/@thenSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:944:635: (temp= stringSymbol )
                    // ./generationTemp/generated/TCS.g:944:637: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_predicatesemantic5705);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "when", temp);
                      setParent(temp,ret,"when");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.0/@thenSequence/@elements.3");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_predicatesemantic5712); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:945:235: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:946:141: ( ( 'mode' EQ (temp= identifierOrKeyword ) COMA ) | )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==93) ) {
                alt102=1;
            }
            else if ( (LA102_0==127) ) {
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
                    // ./generationTemp/generated/TCS.g:946:142: ( 'mode' EQ (temp= identifierOrKeyword ) COMA )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:946:158: ( 'mode' EQ (temp= identifierOrKeyword ) COMA )
                    // ./generationTemp/generated/TCS.g:946:159: 'mode' EQ (temp= identifierOrKeyword ) COMA
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    match(input,93,FOLLOW_93_in_furcas_tcs_predicatesemantic5735); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.1/@thenSequence/@elements.1");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_predicatesemantic5739); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.1/@thenSequence/@elements.2");
                    }
                    // ./generationTemp/generated/TCS.g:946:648: (temp= identifierOrKeyword )
                    // ./generationTemp/generated/TCS.g:946:650: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_predicatesemantic5747);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "mode", temp);
                      setParent(temp,ret,"mode");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.1/@thenSequence/@elements.3");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_predicatesemantic5754); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:947:235: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.2");
            }
            match(input,127,FOLLOW_127_in_furcas_tcs_predicatesemantic5771); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.3");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_predicatesemantic5775); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:948:426: (temp= identifierOrKeyword )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==NAME||(LA103_0>=49 && LA103_0<=133)) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:948:428: temp= identifierOrKeyword
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_predicatesemantic5783);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlock.parentTemplate.concreteSyntax.templates->select(t| "+
                      "                                            if(t.oclIsTypeOf(FURCAS::TCS::ClassTemplate)) then "+
                      "                                                t.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.oclAsType(ecore::EClass).eAllSuperTypes"+
                      "                                                       ->prepend(t.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.oclAsType(ecore::EClass))"+
                      "                                                       ->includes(self.foreachParent.propertyReference.strucfeature.eType.oclAsType(ecore::EClass))"+
                      "                                                and (if(not self.mode.oclIsUndefined()) then"+
                      "                                                         t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.mode"+
                      "                                                     else"+
                      "                                                         t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.foreachParent.mode"+
                      "                                                     endif)                                                                       "+
                      "                                            else"+
                      "                                                t.oclIsTypeOf(FURCAS::TCS::PrimitiveTemplate)"+
                      "                                            endif)->select(candidate | if candidate.oclIsTypeOf(FURCAS::TCS::ClassTemplate) then"+
                      "                                                candidate.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.name"+
                      "                                            else "+
                      "                                                candidate.oclAsType(FURCAS::TCS::PrimitiveTemplate).templateName"+
                      "                                            endif = ?)", "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.39/@templateSequence/@elements.4", SyntaxRegistryFacade.getModelUpdaterRegistry());
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
    // $ANTLR end "furcas_tcs_predicatesemantic"


    // $ANTLR start "furcas_tcs_propertyarg"
    // ./generationTemp/generated/TCS.g:972:1: furcas_tcs_propertyarg returns [Object ret2] : (ret= furcas_tcs_referstoparg | ret= furcas_tcs_lookinparg | ret= furcas_tcs_createinparg | ret= furcas_tcs_asparg | ret= furcas_tcs_separatorparg | ret= furcas_tcs_disambiguateparg | ret= furcas_tcs_autocreateparg | ret= furcas_tcs_importcontextparg | ret= furcas_tcs_partialparg | ret= furcas_tcs_forcedlowerparg | ret= furcas_tcs_forcedupperparg | ret= furcas_tcs_createasparg | ret= furcas_tcs_lookupscopeparg | ret= furcas_tcs_referencebyparg | ret= furcas_tcs_prefixparg | ret= furcas_tcs_postfixparg | ret= furcas_tcs_modeparg ) ;
    public final Object furcas_tcs_propertyarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:973:3: ( (ret= furcas_tcs_referstoparg | ret= furcas_tcs_lookinparg | ret= furcas_tcs_createinparg | ret= furcas_tcs_asparg | ret= furcas_tcs_separatorparg | ret= furcas_tcs_disambiguateparg | ret= furcas_tcs_autocreateparg | ret= furcas_tcs_importcontextparg | ret= furcas_tcs_partialparg | ret= furcas_tcs_forcedlowerparg | ret= furcas_tcs_forcedupperparg | ret= furcas_tcs_createasparg | ret= furcas_tcs_lookupscopeparg | ret= furcas_tcs_referencebyparg | ret= furcas_tcs_prefixparg | ret= furcas_tcs_postfixparg | ret= furcas_tcs_modeparg ) )
            // ./generationTemp/generated/TCS.g:974:3: (ret= furcas_tcs_referstoparg | ret= furcas_tcs_lookinparg | ret= furcas_tcs_createinparg | ret= furcas_tcs_asparg | ret= furcas_tcs_separatorparg | ret= furcas_tcs_disambiguateparg | ret= furcas_tcs_autocreateparg | ret= furcas_tcs_importcontextparg | ret= furcas_tcs_partialparg | ret= furcas_tcs_forcedlowerparg | ret= furcas_tcs_forcedupperparg | ret= furcas_tcs_createasparg | ret= furcas_tcs_lookupscopeparg | ret= furcas_tcs_referencebyparg | ret= furcas_tcs_prefixparg | ret= furcas_tcs_postfixparg | ret= furcas_tcs_modeparg )
            {
            // ./generationTemp/generated/TCS.g:974:3: (ret= furcas_tcs_referstoparg | ret= furcas_tcs_lookinparg | ret= furcas_tcs_createinparg | ret= furcas_tcs_asparg | ret= furcas_tcs_separatorparg | ret= furcas_tcs_disambiguateparg | ret= furcas_tcs_autocreateparg | ret= furcas_tcs_importcontextparg | ret= furcas_tcs_partialparg | ret= furcas_tcs_forcedlowerparg | ret= furcas_tcs_forcedupperparg | ret= furcas_tcs_createasparg | ret= furcas_tcs_lookupscopeparg | ret= furcas_tcs_referencebyparg | ret= furcas_tcs_prefixparg | ret= furcas_tcs_postfixparg | ret= furcas_tcs_modeparg )
            int alt104=17;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt104=1;
                }
                break;
            case 83:
                {
                alt104=2;
                }
                break;
            case 76:
                {
                alt104=3;
                }
                break;
            case 127:
                {
                alt104=4;
                }
                break;
            case 122:
                {
                alt104=5;
                }
                break;
            case 68:
                {
                alt104=6;
                }
                break;
            case 105:
                {
                alt104=7;
                }
                break;
            case 67:
                {
                alt104=8;
                }
                break;
            case 89:
                {
                alt104=9;
                }
                break;
            case 63:
                {
                alt104=10;
                }
                break;
            case 121:
                {
                alt104=11;
                }
                break;
            case 129:
                {
                alt104=12;
                }
                break;
            case 111:
                {
                alt104=13;
                }
                break;
            case 117:
                {
                alt104=14;
                }
                break;
            case 92:
                {
                alt104=15;
                }
                break;
            case 51:
                {
                alt104=16;
                }
                break;
            case 93:
                {
                alt104=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:974:4: ret= furcas_tcs_referstoparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_referstoparg_in_furcas_tcs_propertyarg5825);
                    ret=furcas_tcs_referstoparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:975:5: ret= furcas_tcs_lookinparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_lookinparg_in_furcas_tcs_propertyarg5833);
                    ret=furcas_tcs_lookinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:976:5: ret= furcas_tcs_createinparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_createinparg_in_furcas_tcs_propertyarg5841);
                    ret=furcas_tcs_createinparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:977:5: ret= furcas_tcs_asparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_asparg_in_furcas_tcs_propertyarg5849);
                    ret=furcas_tcs_asparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./generationTemp/generated/TCS.g:978:5: ret= furcas_tcs_separatorparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_separatorparg_in_furcas_tcs_propertyarg5857);
                    ret=furcas_tcs_separatorparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 6 :
                    // ./generationTemp/generated/TCS.g:979:5: ret= furcas_tcs_disambiguateparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_disambiguateparg_in_furcas_tcs_propertyarg5865);
                    ret=furcas_tcs_disambiguateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 7 :
                    // ./generationTemp/generated/TCS.g:980:5: ret= furcas_tcs_autocreateparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_autocreateparg_in_furcas_tcs_propertyarg5873);
                    ret=furcas_tcs_autocreateparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 8 :
                    // ./generationTemp/generated/TCS.g:981:5: ret= furcas_tcs_importcontextparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_importcontextparg_in_furcas_tcs_propertyarg5881);
                    ret=furcas_tcs_importcontextparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 9 :
                    // ./generationTemp/generated/TCS.g:982:5: ret= furcas_tcs_partialparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_partialparg_in_furcas_tcs_propertyarg5889);
                    ret=furcas_tcs_partialparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 10 :
                    // ./generationTemp/generated/TCS.g:983:5: ret= furcas_tcs_forcedlowerparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_forcedlowerparg_in_furcas_tcs_propertyarg5897);
                    ret=furcas_tcs_forcedlowerparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 11 :
                    // ./generationTemp/generated/TCS.g:984:5: ret= furcas_tcs_forcedupperparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_forcedupperparg_in_furcas_tcs_propertyarg5905);
                    ret=furcas_tcs_forcedupperparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 12 :
                    // ./generationTemp/generated/TCS.g:985:5: ret= furcas_tcs_createasparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_createasparg_in_furcas_tcs_propertyarg5913);
                    ret=furcas_tcs_createasparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 13 :
                    // ./generationTemp/generated/TCS.g:986:5: ret= furcas_tcs_lookupscopeparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_lookupscopeparg_in_furcas_tcs_propertyarg5921);
                    ret=furcas_tcs_lookupscopeparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 14 :
                    // ./generationTemp/generated/TCS.g:987:5: ret= furcas_tcs_referencebyparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_referencebyparg_in_furcas_tcs_propertyarg5929);
                    ret=furcas_tcs_referencebyparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 15 :
                    // ./generationTemp/generated/TCS.g:988:5: ret= furcas_tcs_prefixparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_prefixparg_in_furcas_tcs_propertyarg5937);
                    ret=furcas_tcs_prefixparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 16 :
                    // ./generationTemp/generated/TCS.g:989:5: ret= furcas_tcs_postfixparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_postfixparg_in_furcas_tcs_propertyarg5945);
                    ret=furcas_tcs_postfixparg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 17 :
                    // ./generationTemp/generated/TCS.g:990:5: ret= furcas_tcs_modeparg
                    {
                    pushFollow(FOLLOW_furcas_tcs_modeparg_in_furcas_tcs_propertyarg5953);
                    ret=furcas_tcs_modeparg();

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
    // $ANTLR end "furcas_tcs_propertyarg"


    // $ANTLR start "furcas_tcs_referstoparg"
    // ./generationTemp/generated/TCS.g:997:1: furcas_tcs_referstoparg returns [Object ret2] : ( 'refersTo' EQ (temp= identifierOrKeyword ) ) ;
    public final Object furcas_tcs_referstoparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","RefersToPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1003:3: ( ( 'refersTo' EQ (temp= identifierOrKeyword ) ) )
            // ./generationTemp/generated/TCS.g:1004:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            {
            // ./generationTemp/generated/TCS.g:1004:3: ( 'refersTo' EQ (temp= identifierOrKeyword ) )
            // ./generationTemp/generated/TCS.g:1004:4: 'refersTo' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.41/@templateSequence/@elements.0");
            }
            match(input,70,FOLLOW_70_in_furcas_tcs_referstoparg5983); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.41/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_referstoparg5987); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.41/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1004:419: (temp= identifierOrKeyword )
            // ./generationTemp/generated/TCS.g:1004:421: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_referstoparg5995);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "propertyName", temp);
              setParent(temp,ret,"propertyName");
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
    // $ANTLR end "furcas_tcs_referstoparg"


    // $ANTLR start "furcas_tcs_lookinparg"
    // ./generationTemp/generated/TCS.g:1013:1: furcas_tcs_lookinparg returns [Object ret2] : ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) ) ) ;
    public final Object furcas_tcs_lookinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","LookInPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1019:3: ( ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) ) ) )
            // ./generationTemp/generated/TCS.g:1020:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) ) )
            {
            // ./generationTemp/generated/TCS.g:1020:3: ( 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) ) )
            // ./generationTemp/generated/TCS.g:1020:4: 'lookIn' EQ ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.0");
            }
            match(input,83,FOLLOW_83_in_furcas_tcs_lookinparg6038); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_lookinparg6042); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1020:418: ( ( SHARP 'all' ) | ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==SHARP) ) {
                alt107=1;
            }
            else if ( (LA107_0==EOF||LA107_0==NAME||LA107_0==RCURLY||LA107_0==COMA||(LA107_0>=49 && LA107_0<=133)) ) {
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
                    // ./generationTemp/generated/TCS.g:1020:419: ( SHARP 'all' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1020:435: ( SHARP 'all' )
                    // ./generationTemp/generated/TCS.g:1020:436: SHARP 'all'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,SHARP,FOLLOW_SHARP_in_furcas_tcs_lookinparg6053); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    match(input,128,FOLLOW_128_in_furcas_tcs_lookinparg6057); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:1020:851: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:1020:867: ( (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? )
                    // ./generationTemp/generated/TCS.g:1020:868: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.2/@elseSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:1020:1017: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )?
                    int alt106=2;
                    int LA106_0 = input.LA(1);

                    if ( (LA106_0==NAME||(LA106_0>=49 && LA106_0<=133)) ) {
                        alt106=1;
                    }
                    switch (alt106) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:1020:1019: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                            {
                            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_lookinparg6074);
                            temp=identifierOrKeyword();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "propertyName", temp);
                              setParent(temp,ret,"propertyName");
                            }
                            // ./generationTemp/generated/TCS.g:1021:38: ( ( POINT ) temp= identifierOrKeyword )*
                            loop105:
                            do {
                                int alt105=2;
                                int LA105_0 = input.LA(1);

                                if ( (LA105_0==POINT) ) {
                                    alt105=1;
                                }


                                switch (alt105) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:1021:39: ( POINT ) temp= identifierOrKeyword
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./generationTemp/generated/TCS.g:1021:56: ( POINT )
                            	    // ./generationTemp/generated/TCS.g:1021:57: POINT
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.42/@templateSequence/@elements.2/@elseSequence/@elements.0/@propertyArgs.1/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,POINT,FOLLOW_POINT_in_furcas_tcs_lookinparg6083); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_lookinparg6091);
                            	    temp=identifierOrKeyword();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "propertyName", temp);
                            	      setParent(temp,ret,"propertyName");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop105;
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
                    }
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
    // $ANTLR end "furcas_tcs_lookinparg"


    // $ANTLR start "furcas_tcs_createinparg"
    // ./generationTemp/generated/TCS.g:1031:1: furcas_tcs_createinparg returns [Object ret2] : ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) ;
    public final Object furcas_tcs_createinparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","CreateInPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1037:3: ( ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? ) )
            // ./generationTemp/generated/TCS.g:1038:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? )
            {
            // ./generationTemp/generated/TCS.g:1038:3: ( 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )? )
            // ./generationTemp/generated/TCS.g:1038:4: 'createIn' EQ (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.43/@templateSequence/@elements.0");
            }
            match(input,76,FOLLOW_76_in_furcas_tcs_createinparg6146); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.43/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_createinparg6150); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.43/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1038:419: (temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )* )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==NAME||(LA109_0>=49 && LA109_0<=133)) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1038:421: temp= identifierOrKeyword ( ( POINT ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_createinparg6158);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyName", temp);
                      setParent(temp,ret,"propertyName");
                    }
                    // ./generationTemp/generated/TCS.g:1039:38: ( ( POINT ) temp= identifierOrKeyword )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==POINT) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:1039:39: ( POINT ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:1039:56: ( POINT )
                    	    // ./generationTemp/generated/TCS.g:1039:57: POINT
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.43/@templateSequence/@elements.2/@propertyArgs.1/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,POINT,FOLLOW_POINT_in_furcas_tcs_createinparg6167); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_createinparg6175);
                    	    temp=identifierOrKeyword();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "propertyName", temp);
                    	      setParent(temp,ret,"propertyName");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop108;
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
    // $ANTLR end "furcas_tcs_createinparg"


    // $ANTLR start "furcas_tcs_asparg"
    // ./generationTemp/generated/TCS.g:1048:1: furcas_tcs_asparg returns [Object ret2] : ( 'as' EQ (temp= identifierOrKeyword ) ) ;
    public final Object furcas_tcs_asparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","AsPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1054:3: ( ( 'as' EQ (temp= identifierOrKeyword ) ) )
            // ./generationTemp/generated/TCS.g:1055:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            {
            // ./generationTemp/generated/TCS.g:1055:3: ( 'as' EQ (temp= identifierOrKeyword ) )
            // ./generationTemp/generated/TCS.g:1055:4: 'as' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.44/@templateSequence/@elements.0");
            }
            match(input,127,FOLLOW_127_in_furcas_tcs_asparg6223); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.44/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_asparg6227); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.44/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1055:413: (temp= identifierOrKeyword )
            // ./generationTemp/generated/TCS.g:1055:415: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_asparg6235);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t| "+
              "                                            if(t.oclIsTypeOf(FURCAS::TCS::ClassTemplate) and ("+
              "                                               self.property.propertyReference.strucfeature.eType.oclIsKindOf(ecore::EClass))) then"+
              "                                                   self.property.propertyReference.strucfeature.eType.oclAsType(ecore::EClass).eAllSuperTypes"+
              "                                                       ->prepend(self.property.propertyReference.strucfeature.eType.oclAsType(ecore::EClass))"+
              "                                                       ->includes(t.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.oclAsType(ecore::EClass))                                                       "+
              "                                                   and (if (not self.property.propertyArgs->select(arg | arg.oclIsTypeOf(FURCAS::TCS::ModePArg))->isEmpty()) then "+
              "                                                            t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.property.propertyArgs->select("+
              "                                                                arg | arg.oclIsTypeOf(FURCAS::TCS::ModePArg)).oclAsType(FURCAS::TCS::ModePArg)"+
              "                                                                    ->asSequence()->at(1).mode"+
              "                                                        else"+
              "                                                            t.oclAsType(FURCAS::TCS::ClassTemplate).mode.oclIsUndefined()"+
              "                                                        endif)                                                                       "+
              "                                            else"+
              "                                                t.oclIsKindOf(FURCAS::TCS::PrimitiveTemplate)"+
              "                                            endif)->select(candidate | if candidate.oclIsTypeOf(FURCAS::TCS::ClassTemplate) then"+
              "                                                candidate.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.name"+
              "                                            else "+
              "                                                candidate.oclAsType(FURCAS::TCS::PrimitiveTemplate).templateName"+
              "                                            endif = ?)", "platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.44/@templateSequence/@elements.2", SyntaxRegistryFacade.getModelUpdaterRegistry());
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
    // $ANTLR end "furcas_tcs_asparg"


    // $ANTLR start "furcas_tcs_separatorparg"
    // ./generationTemp/generated/TCS.g:1082:1: furcas_tcs_separatorparg returns [Object ret2] : ( 'separator' EQ (temp= furcas_tcs_sequence ) ) ;
    public final Object furcas_tcs_separatorparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","SeparatorPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1088:3: ( ( 'separator' EQ (temp= furcas_tcs_sequence ) ) )
            // ./generationTemp/generated/TCS.g:1089:3: ( 'separator' EQ (temp= furcas_tcs_sequence ) )
            {
            // ./generationTemp/generated/TCS.g:1089:3: ( 'separator' EQ (temp= furcas_tcs_sequence ) )
            // ./generationTemp/generated/TCS.g:1089:4: 'separator' EQ (temp= furcas_tcs_sequence )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.45/@templateSequence/@elements.0");
            }
            match(input,122,FOLLOW_122_in_furcas_tcs_separatorparg6278); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.45/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_separatorparg6282); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.45/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1089:420: (temp= furcas_tcs_sequence )
            // ./generationTemp/generated/TCS.g:1089:422: temp= furcas_tcs_sequence
            {
            pushFollow(FOLLOW_furcas_tcs_sequence_in_furcas_tcs_separatorparg6290);
            temp=furcas_tcs_sequence();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "separatorSequence", temp);
              setParent(temp,ret,"separatorSequence");
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
    // $ANTLR end "furcas_tcs_separatorparg"


    // $ANTLR start "furcas_tcs_disambiguateparg"
    // ./generationTemp/generated/TCS.g:1098:1: furcas_tcs_disambiguateparg returns [Object ret2] : ( 'disambiguate' EQ (temp= stringSymbol )? ) ;
    public final Object furcas_tcs_disambiguateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","DisambiguatePArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1104:3: ( ( 'disambiguate' EQ (temp= stringSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1105:3: ( 'disambiguate' EQ (temp= stringSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1105:3: ( 'disambiguate' EQ (temp= stringSymbol )? )
            // ./generationTemp/generated/TCS.g:1105:4: 'disambiguate' EQ (temp= stringSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.46/@templateSequence/@elements.0");
            }
            match(input,68,FOLLOW_68_in_furcas_tcs_disambiguateparg6333); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.46/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_disambiguateparg6337); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.46/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1105:423: (temp= stringSymbol )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==STRING) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1105:425: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_disambiguateparg6345);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "disambiguation", temp);
                      setParent(temp,ret,"disambiguation");
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
    // $ANTLR end "furcas_tcs_disambiguateparg"


    // $ANTLR start "furcas_tcs_autocreateparg"
    // ./generationTemp/generated/TCS.g:1114:1: furcas_tcs_autocreateparg returns [Object ret2] : ( 'autoCreate' EQ (temp= furcas_tcs_autocreatekind ) ) ;
    public final Object furcas_tcs_autocreateparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","AutoCreatePArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1120:3: ( ( 'autoCreate' EQ (temp= furcas_tcs_autocreatekind ) ) )
            // ./generationTemp/generated/TCS.g:1121:3: ( 'autoCreate' EQ (temp= furcas_tcs_autocreatekind ) )
            {
            // ./generationTemp/generated/TCS.g:1121:3: ( 'autoCreate' EQ (temp= furcas_tcs_autocreatekind ) )
            // ./generationTemp/generated/TCS.g:1121:4: 'autoCreate' EQ (temp= furcas_tcs_autocreatekind )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.47/@templateSequence/@elements.0");
            }
            match(input,105,FOLLOW_105_in_furcas_tcs_autocreateparg6390); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.47/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_autocreateparg6394); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.47/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1121:421: (temp= furcas_tcs_autocreatekind )
            // ./generationTemp/generated/TCS.g:1121:423: temp= furcas_tcs_autocreatekind
            {
            pushFollow(FOLLOW_furcas_tcs_autocreatekind_in_furcas_tcs_autocreateparg6402);
            temp=furcas_tcs_autocreatekind();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_autocreateparg"


    // $ANTLR start "furcas_tcs_autocreatekind"
    // ./generationTemp/generated/TCS.g:1130:1: furcas_tcs_autocreatekind returns [Object ret2] : ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) ;
    public final Object furcas_tcs_autocreatekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:1131:3: ( ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) ) )
            // ./generationTemp/generated/TCS.g:1132:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            {
            // ./generationTemp/generated/TCS.g:1132:3: ( ( 'always' ) | ( 'ifmissing' ) | ( 'never' ) )
            int alt111=3;
            switch ( input.LA(1) ) {
            case 75:
                {
                alt111=1;
                }
                break;
            case 73:
                {
                alt111=2;
                }
                break;
            case 116:
                {
                alt111=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }

            switch (alt111) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1132:4: ( 'always' )
                    {
                    // ./generationTemp/generated/TCS.g:1132:4: ( 'always' )
                    // ./generationTemp/generated/TCS.g:1132:5: 'always'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.48/@mappings.0/@element");
                    }
                    match(input,75,FOLLOW_75_in_furcas_tcs_autocreatekind6446); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","AutoCreateKind"), "always");
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1133:4: ( 'ifmissing' )
                    {
                    // ./generationTemp/generated/TCS.g:1133:4: ( 'ifmissing' )
                    // ./generationTemp/generated/TCS.g:1133:5: 'ifmissing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.48/@mappings.1/@element");
                    }
                    match(input,73,FOLLOW_73_in_furcas_tcs_autocreatekind6456); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","AutoCreateKind"), "ifmissing");
                    }

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1134:4: ( 'never' )
                    {
                    // ./generationTemp/generated/TCS.g:1134:4: ( 'never' )
                    // ./generationTemp/generated/TCS.g:1134:5: 'never'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.48/@mappings.2/@element");
                    }
                    match(input,116,FOLLOW_116_in_furcas_tcs_autocreatekind6466); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","AutoCreateKind"), "never");
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
    // $ANTLR end "furcas_tcs_autocreatekind"


    // $ANTLR start "furcas_tcs_importcontextparg"
    // ./generationTemp/generated/TCS.g:1141:1: furcas_tcs_importcontextparg returns [Object ret2] : ( 'importContext' ) ;
    public final Object furcas_tcs_importcontextparg() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ImportContextPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1147:3: ( ( 'importContext' ) )
            // ./generationTemp/generated/TCS.g:1148:3: ( 'importContext' )
            {
            // ./generationTemp/generated/TCS.g:1148:3: ( 'importContext' )
            // ./generationTemp/generated/TCS.g:1148:4: 'importContext'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.49/@templateSequence/@elements.0");
            }
            match(input,67,FOLLOW_67_in_furcas_tcs_importcontextparg6497); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_importcontextparg"


    // $ANTLR start "furcas_tcs_partialparg"
    // ./generationTemp/generated/TCS.g:1156:1: furcas_tcs_partialparg returns [Object ret2] : ( 'partial' ) ;
    public final Object furcas_tcs_partialparg() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PartialPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1162:3: ( ( 'partial' ) )
            // ./generationTemp/generated/TCS.g:1163:3: ( 'partial' )
            {
            // ./generationTemp/generated/TCS.g:1163:3: ( 'partial' )
            // ./generationTemp/generated/TCS.g:1163:4: 'partial'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.50/@templateSequence/@elements.0");
            }
            match(input,89,FOLLOW_89_in_furcas_tcs_partialparg6537); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_partialparg"


    // $ANTLR start "furcas_tcs_forcedlowerparg"
    // ./generationTemp/generated/TCS.g:1171:1: furcas_tcs_forcedlowerparg returns [Object ret2] : ( 'forcedLower' EQ (temp= integerSymbol ) ) ;
    public final Object furcas_tcs_forcedlowerparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ForcedLowerPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1177:3: ( ( 'forcedLower' EQ (temp= integerSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1178:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1178:3: ( 'forcedLower' EQ (temp= integerSymbol ) )
            // ./generationTemp/generated/TCS.g:1178:4: 'forcedLower' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.51/@templateSequence/@elements.0");
            }
            match(input,63,FOLLOW_63_in_furcas_tcs_forcedlowerparg6577); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.51/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_forcedlowerparg6581); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.51/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1178:422: (temp= integerSymbol )
            // ./generationTemp/generated/TCS.g:1178:424: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_forcedlowerparg6589);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_forcedlowerparg"


    // $ANTLR start "furcas_tcs_forcedupperparg"
    // ./generationTemp/generated/TCS.g:1187:1: furcas_tcs_forcedupperparg returns [Object ret2] : ( 'forcedUpper' EQ (temp= integerSymbol ) ) ;
    public final Object furcas_tcs_forcedupperparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ForcedUpperPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1193:3: ( ( 'forcedUpper' EQ (temp= integerSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1194:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1194:3: ( 'forcedUpper' EQ (temp= integerSymbol ) )
            // ./generationTemp/generated/TCS.g:1194:4: 'forcedUpper' EQ (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.52/@templateSequence/@elements.0");
            }
            match(input,121,FOLLOW_121_in_furcas_tcs_forcedupperparg6632); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.52/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_forcedupperparg6636); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.52/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1194:422: (temp= integerSymbol )
            // ./generationTemp/generated/TCS.g:1194:424: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_forcedupperparg6644);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_forcedupperparg"


    // $ANTLR start "furcas_tcs_createasparg"
    // ./generationTemp/generated/TCS.g:1203:1: furcas_tcs_createasparg returns [Object ret2] : ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )? ) ;
    public final Object furcas_tcs_createasparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","CreateAsPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1209:3: ( ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )? ) )
            // ./generationTemp/generated/TCS.g:1210:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )? )
            {
            // ./generationTemp/generated/TCS.g:1210:3: ( 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )? )
            // ./generationTemp/generated/TCS.g:1210:4: 'createAs' EQ (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.53/@templateSequence/@elements.0");
            }
            match(input,129,FOLLOW_129_in_furcas_tcs_createasparg6687); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.53/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_createasparg6691); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.53/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1210:419: (temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )* )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==NAME||(LA113_0>=49 && LA113_0<=133)) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1210:421: temp= identifierOrKeyword ( ( DLCOLON ) temp= identifierOrKeyword )*
                    {
                    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_createasparg6699);
                    temp=identifierOrKeyword();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                      setParent(temp,ret,"name");
                    }
                    // ./generationTemp/generated/TCS.g:1211:30: ( ( DLCOLON ) temp= identifierOrKeyword )*
                    loop112:
                    do {
                        int alt112=2;
                        int LA112_0 = input.LA(1);

                        if ( (LA112_0==DLCOLON) ) {
                            alt112=1;
                        }


                        switch (alt112) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:1211:31: ( DLCOLON ) temp= identifierOrKeyword
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:1211:48: ( DLCOLON )
                    	    // ./generationTemp/generated/TCS.g:1211:49: DLCOLON
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.53/@templateSequence/@elements.2/@propertyArgs.1/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,DLCOLON,FOLLOW_DLCOLON_in_furcas_tcs_createasparg6708); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_createasparg6716);
                    	    temp=identifierOrKeyword();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "name", temp);
                    	      setParent(temp,ret,"name");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop112;
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
    // $ANTLR end "furcas_tcs_createasparg"


    // $ANTLR start "furcas_tcs_lookupscopeparg"
    // ./generationTemp/generated/TCS.g:1220:1: furcas_tcs_lookupscopeparg returns [Object ret2] : ( 'lookupScope' EQ (temp= stringSymbol ) ) ;
    public final Object furcas_tcs_lookupscopeparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","LookupScopePArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1226:3: ( ( 'lookupScope' EQ (temp= stringSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1227:3: ( 'lookupScope' EQ (temp= stringSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1227:3: ( 'lookupScope' EQ (temp= stringSymbol ) )
            // ./generationTemp/generated/TCS.g:1227:4: 'lookupScope' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.54/@templateSequence/@elements.0");
            }
            match(input,111,FOLLOW_111_in_furcas_tcs_lookupscopeparg6764); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.54/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_lookupscopeparg6768); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.54/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1227:422: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1227:424: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_lookupscopeparg6776);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "query", temp);
              setParent(temp,ret,"query");
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
    // $ANTLR end "furcas_tcs_lookupscopeparg"


    // $ANTLR start "furcas_tcs_referencebyparg"
    // ./generationTemp/generated/TCS.g:1236:1: furcas_tcs_referencebyparg returns [Object ret2] : ( 'referenceBy' EQ (temp= stringSymbol ) ) ;
    public final Object furcas_tcs_referencebyparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ReferenceByPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1242:3: ( ( 'referenceBy' EQ (temp= stringSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1243:3: ( 'referenceBy' EQ (temp= stringSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1243:3: ( 'referenceBy' EQ (temp= stringSymbol ) )
            // ./generationTemp/generated/TCS.g:1243:4: 'referenceBy' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.55/@templateSequence/@elements.0");
            }
            match(input,117,FOLLOW_117_in_furcas_tcs_referencebyparg6819); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.55/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_referencebyparg6823); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.55/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1243:422: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1243:424: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_referencebyparg6831);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "referenceBy", temp);
              setParent(temp,ret,"referenceBy");
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
    // $ANTLR end "furcas_tcs_referencebyparg"


    // $ANTLR start "furcas_tcs_prefixparg"
    // ./generationTemp/generated/TCS.g:1252:1: furcas_tcs_prefixparg returns [Object ret2] : ( 'prefix' EQ (temp= stringSymbol ) ) ;
    public final Object furcas_tcs_prefixparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PrefixPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1258:3: ( ( 'prefix' EQ (temp= stringSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1259:3: ( 'prefix' EQ (temp= stringSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1259:3: ( 'prefix' EQ (temp= stringSymbol ) )
            // ./generationTemp/generated/TCS.g:1259:4: 'prefix' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.56/@templateSequence/@elements.0");
            }
            match(input,92,FOLLOW_92_in_furcas_tcs_prefixparg6874); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.56/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_prefixparg6878); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.56/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1259:417: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1259:419: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_prefixparg6886);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "prefix", temp);
              setParent(temp,ret,"prefix");
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
    // $ANTLR end "furcas_tcs_prefixparg"


    // $ANTLR start "furcas_tcs_postfixparg"
    // ./generationTemp/generated/TCS.g:1268:1: furcas_tcs_postfixparg returns [Object ret2] : ( 'postfix' EQ (temp= stringSymbol ) ) ;
    public final Object furcas_tcs_postfixparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","PostfixPArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1274:3: ( ( 'postfix' EQ (temp= stringSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1275:3: ( 'postfix' EQ (temp= stringSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1275:3: ( 'postfix' EQ (temp= stringSymbol ) )
            // ./generationTemp/generated/TCS.g:1275:4: 'postfix' EQ (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.57/@templateSequence/@elements.0");
            }
            match(input,51,FOLLOW_51_in_furcas_tcs_postfixparg6929); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.57/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_postfixparg6933); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.57/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1275:418: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1275:420: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_postfixparg6941);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "postfix", temp);
              setParent(temp,ret,"postfix");
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
    // $ANTLR end "furcas_tcs_postfixparg"


    // $ANTLR start "furcas_tcs_modeparg"
    // ./generationTemp/generated/TCS.g:1284:1: furcas_tcs_modeparg returns [Object ret2] : ( 'mode' EQ (temp= identifierOrKeyword ) ) ;
    public final Object furcas_tcs_modeparg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ModePArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1290:3: ( ( 'mode' EQ (temp= identifierOrKeyword ) ) )
            // ./generationTemp/generated/TCS.g:1291:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            {
            // ./generationTemp/generated/TCS.g:1291:3: ( 'mode' EQ (temp= identifierOrKeyword ) )
            // ./generationTemp/generated/TCS.g:1291:4: 'mode' EQ (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.58/@templateSequence/@elements.0");
            }
            match(input,93,FOLLOW_93_in_furcas_tcs_modeparg6984); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.58/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_modeparg6988); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.58/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1291:415: (temp= identifierOrKeyword )
            // ./generationTemp/generated/TCS.g:1291:417: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_modeparg6996);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "mode", temp);
              setParent(temp,ret,"mode");
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
    // $ANTLR end "furcas_tcs_modeparg"


    // $ANTLR start "furcas_tcs_blockarg"
    // ./generationTemp/generated/TCS.g:1300:1: furcas_tcs_blockarg returns [Object ret2] : (ret= furcas_tcs_nbnlbarg | ret= furcas_tcs_indentincrbarg | ret= furcas_tcs_startnlbarg | ret= furcas_tcs_startnbnlbarg | ret= furcas_tcs_endnlbarg ) ;
    public final Object furcas_tcs_blockarg() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1301:3: ( (ret= furcas_tcs_nbnlbarg | ret= furcas_tcs_indentincrbarg | ret= furcas_tcs_startnlbarg | ret= furcas_tcs_startnbnlbarg | ret= furcas_tcs_endnlbarg ) )
            // ./generationTemp/generated/TCS.g:1302:3: (ret= furcas_tcs_nbnlbarg | ret= furcas_tcs_indentincrbarg | ret= furcas_tcs_startnlbarg | ret= furcas_tcs_startnbnlbarg | ret= furcas_tcs_endnlbarg )
            {
            // ./generationTemp/generated/TCS.g:1302:3: (ret= furcas_tcs_nbnlbarg | ret= furcas_tcs_indentincrbarg | ret= furcas_tcs_startnlbarg | ret= furcas_tcs_startnbnlbarg | ret= furcas_tcs_endnlbarg )
            int alt114=5;
            switch ( input.LA(1) ) {
            case 132:
                {
                alt114=1;
                }
                break;
            case 85:
                {
                alt114=2;
                }
                break;
            case 131:
                {
                alt114=3;
                }
                break;
            case 60:
                {
                alt114=4;
                }
                break;
            case 107:
                {
                alt114=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1302:4: ret= furcas_tcs_nbnlbarg
                    {
                    pushFollow(FOLLOW_furcas_tcs_nbnlbarg_in_furcas_tcs_blockarg7036);
                    ret=furcas_tcs_nbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1303:5: ret= furcas_tcs_indentincrbarg
                    {
                    pushFollow(FOLLOW_furcas_tcs_indentincrbarg_in_furcas_tcs_blockarg7044);
                    ret=furcas_tcs_indentincrbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1304:5: ret= furcas_tcs_startnlbarg
                    {
                    pushFollow(FOLLOW_furcas_tcs_startnlbarg_in_furcas_tcs_blockarg7052);
                    ret=furcas_tcs_startnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:1305:5: ret= furcas_tcs_startnbnlbarg
                    {
                    pushFollow(FOLLOW_furcas_tcs_startnbnlbarg_in_furcas_tcs_blockarg7060);
                    ret=furcas_tcs_startnbnlbarg();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./generationTemp/generated/TCS.g:1306:5: ret= furcas_tcs_endnlbarg
                    {
                    pushFollow(FOLLOW_furcas_tcs_endnlbarg_in_furcas_tcs_blockarg7068);
                    ret=furcas_tcs_endnlbarg();

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
    // $ANTLR end "furcas_tcs_blockarg"


    // $ANTLR start "furcas_tcs_nbnlbarg"
    // ./generationTemp/generated/TCS.g:1313:1: furcas_tcs_nbnlbarg returns [Object ret2] : ( 'nbNL' EQ (temp= integerSymbol )? ) ;
    public final Object furcas_tcs_nbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","NbNLBArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1319:3: ( ( 'nbNL' EQ (temp= integerSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1320:3: ( 'nbNL' EQ (temp= integerSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1320:3: ( 'nbNL' EQ (temp= integerSymbol )? )
            // ./generationTemp/generated/TCS.g:1320:4: 'nbNL' EQ (temp= integerSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.60/@templateSequence/@elements.0");
            }
            match(input,132,FOLLOW_132_in_furcas_tcs_nbnlbarg7098); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.60/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_nbnlbarg7102); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.60/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1320:415: (temp= integerSymbol )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==INT) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1320:417: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_nbnlbarg7110);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_nbnlbarg"


    // $ANTLR start "furcas_tcs_indentincrbarg"
    // ./generationTemp/generated/TCS.g:1329:1: furcas_tcs_indentincrbarg returns [Object ret2] : ( 'indentIncr' EQ (temp= integerSymbol )? ) ;
    public final Object furcas_tcs_indentincrbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","IndentIncrBArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1335:3: ( ( 'indentIncr' EQ (temp= integerSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1336:3: ( 'indentIncr' EQ (temp= integerSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1336:3: ( 'indentIncr' EQ (temp= integerSymbol )? )
            // ./generationTemp/generated/TCS.g:1336:4: 'indentIncr' EQ (temp= integerSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.61/@templateSequence/@elements.0");
            }
            match(input,85,FOLLOW_85_in_furcas_tcs_indentincrbarg7155); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.61/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_indentincrbarg7159); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.61/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1336:421: (temp= integerSymbol )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==INT) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1336:423: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_indentincrbarg7167);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_indentincrbarg"


    // $ANTLR start "furcas_tcs_startnlbarg"
    // ./generationTemp/generated/TCS.g:1345:1: furcas_tcs_startnlbarg returns [Object ret2] : ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object furcas_tcs_startnlbarg() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","StartNLBArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1351:3: ( ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // ./generationTemp/generated/TCS.g:1352:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // ./generationTemp/generated/TCS.g:1352:3: ( 'startNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // ./generationTemp/generated/TCS.g:1352:4: 'startNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.62/@templateSequence/@elements.0");
            }
            match(input,131,FOLLOW_131_in_furcas_tcs_startnlbarg7212); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.62/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_startnlbarg7216); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.62/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1352:419: ( ( 'true' ) | ( 'false' ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==126) ) {
                alt117=1;
            }
            else if ( (LA117_0==109) ) {
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
                    // ./generationTemp/generated/TCS.g:1352:420: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1352:436: ( 'true' )
                    // ./generationTemp/generated/TCS.g:1352:437: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.62/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,126,FOLLOW_126_in_furcas_tcs_startnlbarg7226); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:1352:678: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:1352:694: ( 'false' )
                    // ./generationTemp/generated/TCS.g:1352:695: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.62/@templateSequence/@elements.2/@elseSequence/@elements.0");
                    }
                    match(input,109,FOLLOW_109_in_furcas_tcs_startnlbarg7239); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_startnlbarg"


    // $ANTLR start "furcas_tcs_startnbnlbarg"
    // ./generationTemp/generated/TCS.g:1361:1: furcas_tcs_startnbnlbarg returns [Object ret2] : ( 'startNbNL' EQ (temp= integerSymbol )? ) ;
    public final Object furcas_tcs_startnbnlbarg() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","StartNbNLBArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1367:3: ( ( 'startNbNL' EQ (temp= integerSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1368:3: ( 'startNbNL' EQ (temp= integerSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1368:3: ( 'startNbNL' EQ (temp= integerSymbol )? )
            // ./generationTemp/generated/TCS.g:1368:4: 'startNbNL' EQ (temp= integerSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.63/@templateSequence/@elements.0");
            }
            match(input,60,FOLLOW_60_in_furcas_tcs_startnbnlbarg7286); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.63/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_startnbnlbarg7290); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.63/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1368:420: (temp= integerSymbol )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==INT) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1368:422: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_startnbnlbarg7298);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_startnbnlbarg"


    // $ANTLR start "furcas_tcs_endnlbarg"
    // ./generationTemp/generated/TCS.g:1377:1: furcas_tcs_endnlbarg returns [Object ret2] : ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) ;
    public final Object furcas_tcs_endnlbarg() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","EndNLBArg");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1383:3: ( ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) ) )
            // ./generationTemp/generated/TCS.g:1384:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            {
            // ./generationTemp/generated/TCS.g:1384:3: ( 'endNL' EQ ( ( 'true' ) | ( 'false' ) ) )
            // ./generationTemp/generated/TCS.g:1384:4: 'endNL' EQ ( ( 'true' ) | ( 'false' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.64/@templateSequence/@elements.0");
            }
            match(input,107,FOLLOW_107_in_furcas_tcs_endnlbarg7343); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.64/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_endnlbarg7347); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.64/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1384:417: ( ( 'true' ) | ( 'false' ) )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==126) ) {
                alt119=1;
            }
            else if ( (LA119_0==109) ) {
                alt119=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }
            switch (alt119) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1384:418: ( 'true' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1384:434: ( 'true' )
                    // ./generationTemp/generated/TCS.g:1384:435: 'true'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.64/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    match(input,126,FOLLOW_126_in_furcas_tcs_endnlbarg7357); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:1384:676: ( 'false' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:1384:692: ( 'false' )
                    // ./generationTemp/generated/TCS.g:1384:693: 'false'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.64/@templateSequence/@elements.2/@elseSequence/@elements.0");
                    }
                    match(input,109,FOLLOW_109_in_furcas_tcs_endnlbarg7370); if (state.failed) return ret2;
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
    // $ANTLR end "furcas_tcs_endnlbarg"


    // $ANTLR start "furcas_tcs_symbol"
    // ./generationTemp/generated/TCS.g:1393:1: furcas_tcs_symbol returns [Object ret2] : ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? ) | ) SEMI ) ;
    public final Object furcas_tcs_symbol() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Symbol");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1399:3: ( ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? ) | ) SEMI ) )
            // ./generationTemp/generated/TCS.g:1400:3: ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? ) | ) SEMI )
            {
            // ./generationTemp/generated/TCS.g:1400:3: ( (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? ) | ) SEMI )
            // ./generationTemp/generated/TCS.g:1400:4: (temp= identifier ) EQ (temp= stringSymbol ) ( ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? ) | ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1400:127: (temp= identifier )
            // ./generationTemp/generated/TCS.g:1400:129: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_symbol7421);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_symbol7428); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1401:312: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1401:314: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_symbol7436);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:1402:171: ( ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? ) | )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==COLON) ) {
                alt122=1;
            }
            else if ( (LA122_0==SEMI) ) {
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
                    // ./generationTemp/generated/TCS.g:1402:172: ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1402:188: ( COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )? )
                    // ./generationTemp/generated/TCS.g:1402:189: COLON (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    match(input,COLON,FOLLOW_COLON_in_furcas_tcs_symbol7449); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.3/@thenSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:1402:510: (temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )* )?
                    int alt121=2;
                    int LA121_0 = input.LA(1);

                    if ( (LA121_0==55||LA121_0==57||LA121_0==97||LA121_0==125) ) {
                        alt121=1;
                    }
                    switch (alt121) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:1402:512: temp= furcas_tcs_spacekind ( ( COMA ) temp= furcas_tcs_spacekind )*
                            {
                            pushFollow(FOLLOW_furcas_tcs_spacekind_in_furcas_tcs_symbol7457);
                            temp=furcas_tcs_spacekind();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "spaces", temp);
                              setParent(temp,ret,"spaces");
                            }
                            // ./generationTemp/generated/TCS.g:1403:32: ( ( COMA ) temp= furcas_tcs_spacekind )*
                            loop120:
                            do {
                                int alt120=2;
                                int LA120_0 = input.LA(1);

                                if ( (LA120_0==COMA) ) {
                                    alt120=1;
                                }


                                switch (alt120) {
                            	case 1 :
                            	    // ./generationTemp/generated/TCS.g:1403:33: ( COMA ) temp= furcas_tcs_spacekind
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // ./generationTemp/generated/TCS.g:1403:50: ( COMA )
                            	    // ./generationTemp/generated/TCS.g:1403:51: COMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.3/@thenSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_symbol7466); if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_furcas_tcs_spacekind_in_furcas_tcs_symbol7474);
                            	    temp=furcas_tcs_spacekind();

                            	    checkFollows();
                            	    state._fsp--;
                            	    if (state.failed) return ret2;
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "spaces", temp);
                            	      setParent(temp,ret,"spaces");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop120;
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
                    // ./generationTemp/generated/TCS.g:1404:71: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.65/@templateSequence/@elements.4");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_symbol7499); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_symbol"


    // $ANTLR start "furcas_tcs_spacekind"
    // ./generationTemp/generated/TCS.g:1413:1: furcas_tcs_spacekind returns [Object ret2] : ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) ;
    public final Object furcas_tcs_spacekind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:1414:3: ( ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) ) )
            // ./generationTemp/generated/TCS.g:1415:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            {
            // ./generationTemp/generated/TCS.g:1415:3: ( ( 'leftSpace' ) | ( 'leftNone' ) | ( 'rightSpace' ) | ( 'rightNone' ) )
            int alt123=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt123=1;
                }
                break;
            case 97:
                {
                alt123=2;
                }
                break;
            case 57:
                {
                alt123=3;
                }
                break;
            case 125:
                {
                alt123=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }

            switch (alt123) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1415:4: ( 'leftSpace' )
                    {
                    // ./generationTemp/generated/TCS.g:1415:4: ( 'leftSpace' )
                    // ./generationTemp/generated/TCS.g:1415:5: 'leftSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.66/@mappings.0/@element");
                    }
                    match(input,55,FOLLOW_55_in_furcas_tcs_spacekind7541); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "leftSpace");
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1416:4: ( 'leftNone' )
                    {
                    // ./generationTemp/generated/TCS.g:1416:4: ( 'leftNone' )
                    // ./generationTemp/generated/TCS.g:1416:5: 'leftNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.66/@mappings.1/@element");
                    }
                    match(input,97,FOLLOW_97_in_furcas_tcs_spacekind7551); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "leftNone");
                    }

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1417:4: ( 'rightSpace' )
                    {
                    // ./generationTemp/generated/TCS.g:1417:4: ( 'rightSpace' )
                    // ./generationTemp/generated/TCS.g:1417:5: 'rightSpace'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.66/@mappings.2/@element");
                    }
                    match(input,57,FOLLOW_57_in_furcas_tcs_spacekind7561); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "rightSpace");
                    }

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:1418:4: ( 'rightNone' )
                    {
                    // ./generationTemp/generated/TCS.g:1418:4: ( 'rightNone' )
                    // ./generationTemp/generated/TCS.g:1418:5: 'rightNone'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.66/@mappings.3/@element");
                    }
                    match(input,125,FOLLOW_125_in_furcas_tcs_spacekind7571); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "rightNone");
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
    // $ANTLR end "furcas_tcs_spacekind"


    // $ANTLR start "furcas_tcs_keyword"
    // ./generationTemp/generated/TCS.g:1425:1: furcas_tcs_keyword returns [Object ret2] : ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI ) ;
    public final Object furcas_tcs_keyword() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Keyword");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1431:3: ( ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI ) )
            // ./generationTemp/generated/TCS.g:1432:3: ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI )
            {
            // ./generationTemp/generated/TCS.g:1432:3: ( (temp= identifier ) EQ (temp= stringSymbol ) SEMI )
            // ./generationTemp/generated/TCS.g:1432:4: (temp= identifier ) EQ (temp= stringSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.67/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1432:127: (temp= identifier )
            // ./generationTemp/generated/TCS.g:1432:129: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_keyword7606);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.67/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_keyword7613); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.67/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1433:312: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1433:314: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_keyword7621);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.67/@templateSequence/@elements.3");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_keyword7628); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_keyword"


    // $ANTLR start "furcas_tcs_operatorlist"
    // ./generationTemp/generated/TCS.g:1442:1: furcas_tcs_operatorlist returns [Object ret2] : ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? ) ) RCURLY ) ;
    public final Object furcas_tcs_operatorlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","OperatorList");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1448:3: ( ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? ) ) RCURLY ) )
            // ./generationTemp/generated/TCS.g:1449:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? ) ) RCURLY )
            {
            // ./generationTemp/generated/TCS.g:1449:3: ( 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? ) ) RCURLY )
            // ./generationTemp/generated/TCS.g:1449:4: 'operators' ( ( (temp= identifier ) ) | ) LCURLY ( ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.0");
            }
            match(input,106,FOLLOW_106_in_furcas_tcs_operatorlist7669); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:1449:278: ( ( (temp= identifier ) ) | )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==NAME) ) {
                alt124=1;
            }
            else if ( (LA124_0==LCURLY) ) {
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
                    // ./generationTemp/generated/TCS.g:1449:279: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1449:295: ( (temp= identifier ) )
                    // ./generationTemp/generated/TCS.g:1449:296: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.1/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:1449:445: (temp= identifier )
                    // ./generationTemp/generated/TCS.g:1449:447: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_tcs_operatorlist7682);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "name", temp);
                      setParent(temp,ret,"name");
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
                    // ./generationTemp/generated/TCS.g:1450:64: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.2");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_operatorlist7702); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:1451:287: ( ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? ) )
            // ./generationTemp/generated/TCS.g:1451:288: ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? )
            {
            // ./generationTemp/generated/TCS.g:1451:288: ( (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )? )
            // ./generationTemp/generated/TCS.g:1451:289: (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1451:439: (temp= furcas_tcs_priority (temp= furcas_tcs_priority )* )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==98) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1451:441: temp= furcas_tcs_priority (temp= furcas_tcs_priority )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_priority_in_furcas_tcs_operatorlist7713);
                    temp=furcas_tcs_priority();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "priorities", temp);
                      setParent(temp,ret,"priorities");
                    }
                    // ./generationTemp/generated/TCS.g:1452:36: (temp= furcas_tcs_priority )*
                    loop125:
                    do {
                        int alt125=2;
                        int LA125_0 = input.LA(1);

                        if ( (LA125_0==98) ) {
                            alt125=1;
                        }


                        switch (alt125) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:1452:38: temp= furcas_tcs_priority
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_priority_in_furcas_tcs_operatorlist7721);
                    	    temp=furcas_tcs_priority();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "priorities", temp);
                    	      setParent(temp,ret,"priorities");
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


            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.68/@templateSequence/@elements.4");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_operatorlist7736); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_operatorlist"


    // $ANTLR start "furcas_tcs_priority"
    // ./generationTemp/generated/TCS.g:1461:1: furcas_tcs_priority returns [Object ret2] : ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= furcas_tcs_associativity ) ) ) LCURLY ( ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? ) ) RCURLY ) ;
    public final Object furcas_tcs_priority() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Priority");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1467:3: ( ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= furcas_tcs_associativity ) ) ) LCURLY ( ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? ) ) RCURLY ) )
            // ./generationTemp/generated/TCS.g:1468:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= furcas_tcs_associativity ) ) ) LCURLY ( ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? ) ) RCURLY )
            {
            // ./generationTemp/generated/TCS.g:1468:3: ( 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= furcas_tcs_associativity ) ) ) LCURLY ( ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? ) ) RCURLY )
            // ./generationTemp/generated/TCS.g:1468:4: 'priority' (temp= integerSymbol ) ( () | ( COMA (temp= furcas_tcs_associativity ) ) ) LCURLY ( ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? ) ) RCURLY
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.0");
            }
            match(input,98,FOLLOW_98_in_furcas_tcs_priority7777); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:1468:276: (temp= integerSymbol )
            // ./generationTemp/generated/TCS.g:1468:278: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_priority7784);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1469:171: ( () | ( COMA (temp= furcas_tcs_associativity ) ) )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==LCURLY) ) {
                alt127=1;
            }
            else if ( (LA127_0==COMA) ) {
                alt127=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1469:172: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1469:188: ()
                    // ./generationTemp/generated/TCS.g:1469:189: 
                    {
                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "associativity", createEnumLiteral(list("FURCAS","TCS","Associativity"),"left"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1469:307: ( COMA (temp= furcas_tcs_associativity ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./generationTemp/generated/TCS.g:1469:323: ( COMA (temp= furcas_tcs_associativity ) )
                    // ./generationTemp/generated/TCS.g:1469:324: COMA (temp= furcas_tcs_associativity )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.2/@elseSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_priority7807); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.2/@elseSequence/@elements.1");
                    }
                    // ./generationTemp/generated/TCS.g:1469:644: (temp= furcas_tcs_associativity )
                    // ./generationTemp/generated/TCS.g:1469:646: temp= furcas_tcs_associativity
                    {
                    pushFollow(FOLLOW_furcas_tcs_associativity_in_furcas_tcs_priority7815);
                    temp=furcas_tcs_associativity();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "associativity", temp);
                      setParent(temp,ret,"associativity");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "associativity", createEnumLiteral(list("FURCAS","TCS","Associativity"),"right"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.3");
            }
            match(input,LCURLY,FOLLOW_LCURLY_in_furcas_tcs_priority7829); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:1471:287: ( ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? ) )
            // ./generationTemp/generated/TCS.g:1471:288: ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? )
            {
            // ./generationTemp/generated/TCS.g:1471:288: ( (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )? )
            // ./generationTemp/generated/TCS.g:1471:289: (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.4/@blockSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1471:439: (temp= furcas_tcs_operator (temp= furcas_tcs_operator )* )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==NAME||LA129_0==51) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1471:441: temp= furcas_tcs_operator (temp= furcas_tcs_operator )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_operator_in_furcas_tcs_priority7840);
                    temp=furcas_tcs_operator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "operators", temp);
                      setParent(temp,ret,"operators");
                    }
                    // ./generationTemp/generated/TCS.g:1472:35: (temp= furcas_tcs_operator )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==NAME||LA128_0==51) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:1472:37: temp= furcas_tcs_operator
                    	    {
                    	    pushFollow(FOLLOW_furcas_tcs_operator_in_furcas_tcs_priority7848);
                    	    temp=furcas_tcs_operator();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "operators", temp);
                    	      setParent(temp,ret,"operators");
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop128;
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.69/@templateSequence/@elements.5");
            }
            match(input,RCURLY,FOLLOW_RCURLY_in_furcas_tcs_priority7863); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_priority"


    // $ANTLR start "furcas_tcs_operator"
    // ./generationTemp/generated/TCS.g:1481:1: furcas_tcs_operator returns [Object ret2] : ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) ;
    public final Object furcas_tcs_operator() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Operator");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1487:3: ( ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI ) )
            // ./generationTemp/generated/TCS.g:1488:3: ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            {
            // ./generationTemp/generated/TCS.g:1488:3: ( ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI )
            // ./generationTemp/generated/TCS.g:1488:4: ( ( 'postfix' ) | ) (temp= identifier ) EQ ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | ) COMA (temp= integerSymbol ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1488:128: ( ( 'postfix' ) | )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==51) ) {
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
                    // ./generationTemp/generated/TCS.g:1488:129: ( 'postfix' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1488:145: ( 'postfix' )
                    // ./generationTemp/generated/TCS.g:1488:146: 'postfix'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    match(input,51,FOLLOW_51_in_furcas_tcs_operator7910); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "postfix", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1488:392: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "postfix", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:1489:140: (temp= identifier )
            // ./generationTemp/generated/TCS.g:1489:142: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_operator7932);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.2");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_operator7939); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.3");
            }
            // ./generationTemp/generated/TCS.g:1490:313: ( ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) ) | )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( ((LA132_0>=NAME && LA132_0<=STRING)) ) {
                alt132=1;
            }
            else if ( (LA132_0==COMA) ) {
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
                    // ./generationTemp/generated/TCS.g:1490:314: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1490:330: ( ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) ) )
                    // ./generationTemp/generated/TCS.g:1490:331: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.3/@thenSequence/@elements.0");
                    }
                    // ./generationTemp/generated/TCS.g:1490:480: ( ( (temp= identifier ) ) | ( (temp= stringSymbol ) ) )
                    int alt131=2;
                    int LA131_0 = input.LA(1);

                    if ( (LA131_0==NAME) ) {
                        alt131=1;
                    }
                    else if ( (LA131_0==STRING) ) {
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
                            // ./generationTemp/generated/TCS.g:1490:481: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:1490:497: ( (temp= identifier ) )
                            // ./generationTemp/generated/TCS.g:1490:498: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.3/@thenSequence/@elements.0/@sequences.0/@elements.0");
                            }
                            // ./generationTemp/generated/TCS.g:1490:672: (temp= identifier )
                            // ./generationTemp/generated/TCS.g:1490:674: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_furcas_tcs_operator7958);
                            temp=identifier();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setRef(ret, "literal", list("FURCAS","TCS","Literal"), "name", temp, null, "never", null, false, null);
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
                            // ./generationTemp/generated/TCS.g:1491:4: ( (temp= stringSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // ./generationTemp/generated/TCS.g:1491:20: ( (temp= stringSymbol ) )
                            // ./generationTemp/generated/TCS.g:1491:21: (temp= stringSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.3/@thenSequence/@elements.0/@sequences.1/@elements.0");
                            }
                            // ./generationTemp/generated/TCS.g:1491:195: (temp= stringSymbol )
                            // ./generationTemp/generated/TCS.g:1491:197: temp= stringSymbol
                            {
                            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_operator7978);
                            temp=stringSymbol();

                            checkFollows();
                            state._fsp--;
                            if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              setRef(ret, "literal", list("FURCAS","TCS","Literal"), "value", temp, "#all", "ifmissing", list("FURCAS","TCS","Keyword"), false, null);
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
                    // ./generationTemp/generated/TCS.g:1491:420: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.4");
            }
            match(input,COMA,FOLLOW_COMA_in_furcas_tcs_operator8003); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:1492:285: (temp= integerSymbol )
            // ./generationTemp/generated/TCS.g:1492:287: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_operator8011);
            temp=integerSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "arity", temp);
              setParent(temp,ret,"arity");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.70/@templateSequence/@elements.6");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_operator8018); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_operator"


    // $ANTLR start "furcas_tcs_associativity"
    // ./generationTemp/generated/TCS.g:1501:1: furcas_tcs_associativity returns [Object ret2] : ( ( 'left' ) | ( 'right' ) ) ;
    public final Object furcas_tcs_associativity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./generationTemp/generated/TCS.g:1502:3: ( ( ( 'left' ) | ( 'right' ) ) )
            // ./generationTemp/generated/TCS.g:1503:3: ( ( 'left' ) | ( 'right' ) )
            {
            // ./generationTemp/generated/TCS.g:1503:3: ( ( 'left' ) | ( 'right' ) )
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==62) ) {
                alt133=1;
            }
            else if ( (LA133_0==120) ) {
                alt133=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }
            switch (alt133) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1503:4: ( 'left' )
                    {
                    // ./generationTemp/generated/TCS.g:1503:4: ( 'left' )
                    // ./generationTemp/generated/TCS.g:1503:5: 'left'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.71/@mappings.0/@element");
                    }
                    match(input,62,FOLLOW_62_in_furcas_tcs_associativity8060); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","Associativity"), "left");
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1504:4: ( 'right' )
                    {
                    // ./generationTemp/generated/TCS.g:1504:4: ( 'right' )
                    // ./generationTemp/generated/TCS.g:1504:5: 'right'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.71/@mappings.1/@element");
                    }
                    match(input,120,FOLLOW_120_in_furcas_tcs_associativity8070); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("FURCAS","TCS","Associativity"), "right");
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
    // $ANTLR end "furcas_tcs_associativity"


    // $ANTLR start "furcas_tcs_expression"
    // ./generationTemp/generated/TCS.g:1511:1: furcas_tcs_expression returns [Object ret2] : (ret= furcas_tcs_andexp ) ;
    public final Object furcas_tcs_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1512:3: ( (ret= furcas_tcs_andexp ) )
            // ./generationTemp/generated/TCS.g:1513:3: (ret= furcas_tcs_andexp )
            {
            // ./generationTemp/generated/TCS.g:1513:3: (ret= furcas_tcs_andexp )
            // ./generationTemp/generated/TCS.g:1513:4: ret= furcas_tcs_andexp
            {
            pushFollow(FOLLOW_furcas_tcs_andexp_in_furcas_tcs_expression8098);
            ret=furcas_tcs_andexp();

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
    // $ANTLR end "furcas_tcs_expression"


    // $ANTLR start "furcas_tcs_andexp"
    // ./generationTemp/generated/TCS.g:1520:1: furcas_tcs_andexp returns [Object ret2] : ( (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )? ) ;
    public final Object furcas_tcs_andexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","AndExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1526:3: ( ( (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )? ) )
            // ./generationTemp/generated/TCS.g:1527:3: ( (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )? )
            {
            // ./generationTemp/generated/TCS.g:1527:3: ( (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )? )
            // ./generationTemp/generated/TCS.g:1527:4: (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.73/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1527:127: (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )?
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==NAME||LA135_0==EQ||LA135_0==RARROW||(LA135_0>=49 && LA135_0<=133)) ) {
                alt135=1;
            }
            else if ( (LA135_0==QMARK) ) {
                int LA135_2 = input.LA(2);

                if ( (synpred333_TCS()) ) {
                    alt135=1;
                }
            }
            switch (alt135) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1527:129: temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )*
                    {
                    pushFollow(FOLLOW_furcas_tcs_atomexp_in_furcas_tcs_andexp8132);
                    temp=furcas_tcs_atomexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "expressions", temp);
                      setParent(temp,ret,"expressions");
                    }
                    // ./generationTemp/generated/TCS.g:1528:37: ( ( 'and' ) temp= furcas_tcs_atomexp )*
                    loop134:
                    do {
                        int alt134=2;
                        int LA134_0 = input.LA(1);

                        if ( (LA134_0==64) ) {
                            alt134=1;
                        }


                        switch (alt134) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:1528:38: ( 'and' ) temp= furcas_tcs_atomexp
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:1528:55: ( 'and' )
                    	    // ./generationTemp/generated/TCS.g:1528:56: 'and'
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.73/@templateSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,64,FOLLOW_64_in_furcas_tcs_andexp8140); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_furcas_tcs_atomexp_in_furcas_tcs_andexp8147);
                    	    temp=furcas_tcs_atomexp();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "expressions", temp);
                    	      setParent(temp,ret,"expressions");
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
    // $ANTLR end "furcas_tcs_andexp"


    // $ANTLR start "furcas_tcs_atomexp"
    // ./generationTemp/generated/TCS.g:1537:1: furcas_tcs_atomexp returns [Object ret2] : (ret= furcas_tcs_equalsexp | ret= furcas_tcs_booleanpropertyexp | ret= furcas_tcs_isdefinedexp | ret= furcas_tcs_oneexp | ret= furcas_tcs_instanceofexp ) ;
    public final Object furcas_tcs_atomexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1538:3: ( (ret= furcas_tcs_equalsexp | ret= furcas_tcs_booleanpropertyexp | ret= furcas_tcs_isdefinedexp | ret= furcas_tcs_oneexp | ret= furcas_tcs_instanceofexp ) )
            // ./generationTemp/generated/TCS.g:1539:3: (ret= furcas_tcs_equalsexp | ret= furcas_tcs_booleanpropertyexp | ret= furcas_tcs_isdefinedexp | ret= furcas_tcs_oneexp | ret= furcas_tcs_instanceofexp )
            {
            // ./generationTemp/generated/TCS.g:1539:3: (ret= furcas_tcs_equalsexp | ret= furcas_tcs_booleanpropertyexp | ret= furcas_tcs_isdefinedexp | ret= furcas_tcs_oneexp | ret= furcas_tcs_instanceofexp )
            int alt136=5;
            alt136 = dfa136.predict(input);
            switch (alt136) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1539:4: ret= furcas_tcs_equalsexp
                    {
                    pushFollow(FOLLOW_furcas_tcs_equalsexp_in_furcas_tcs_atomexp8192);
                    ret=furcas_tcs_equalsexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1540:5: ret= furcas_tcs_booleanpropertyexp
                    {
                    pushFollow(FOLLOW_furcas_tcs_booleanpropertyexp_in_furcas_tcs_atomexp8200);
                    ret=furcas_tcs_booleanpropertyexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1541:5: ret= furcas_tcs_isdefinedexp
                    {
                    pushFollow(FOLLOW_furcas_tcs_isdefinedexp_in_furcas_tcs_atomexp8208);
                    ret=furcas_tcs_isdefinedexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:1542:5: ret= furcas_tcs_oneexp
                    {
                    pushFollow(FOLLOW_furcas_tcs_oneexp_in_furcas_tcs_atomexp8216);
                    ret=furcas_tcs_oneexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./generationTemp/generated/TCS.g:1543:5: ret= furcas_tcs_instanceofexp
                    {
                    pushFollow(FOLLOW_furcas_tcs_instanceofexp_in_furcas_tcs_atomexp8224);
                    ret=furcas_tcs_instanceofexp();

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
    // $ANTLR end "furcas_tcs_atomexp"


    // $ANTLR start "furcas_tcs_equalsexp"
    // ./generationTemp/generated/TCS.g:1550:1: furcas_tcs_equalsexp returns [Object ret2] : ( (temp= furcas_tcs_propertyreference )? EQ (temp= furcas_tcs_value ) ) ;
    public final Object furcas_tcs_equalsexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","EqualsExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1556:3: ( ( (temp= furcas_tcs_propertyreference )? EQ (temp= furcas_tcs_value ) ) )
            // ./generationTemp/generated/TCS.g:1557:3: ( (temp= furcas_tcs_propertyreference )? EQ (temp= furcas_tcs_value ) )
            {
            // ./generationTemp/generated/TCS.g:1557:3: ( (temp= furcas_tcs_propertyreference )? EQ (temp= furcas_tcs_value ) )
            // ./generationTemp/generated/TCS.g:1557:4: (temp= furcas_tcs_propertyreference )? EQ (temp= furcas_tcs_value )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.75/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1557:127: (temp= furcas_tcs_propertyreference )?
            int alt137=2;
            int LA137_0 = input.LA(1);

            if ( (LA137_0==NAME||LA137_0==RARROW||(LA137_0>=49 && LA137_0<=133)) ) {
                alt137=1;
            }
            switch (alt137) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1557:129: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_equalsexp8258);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.75/@templateSequence/@elements.1");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_equalsexp8267); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.75/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1558:327: (temp= furcas_tcs_value )
            // ./generationTemp/generated/TCS.g:1558:329: temp= furcas_tcs_value
            {
            pushFollow(FOLLOW_furcas_tcs_value_in_furcas_tcs_equalsexp8275);
            temp=furcas_tcs_value();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "value", temp);
              setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_equalsexp"


    // $ANTLR start "furcas_tcs_booleanpropertyexp"
    // ./generationTemp/generated/TCS.g:1567:1: furcas_tcs_booleanpropertyexp returns [Object ret2] : ( (temp= furcas_tcs_propertyreference )? ) ;
    public final Object furcas_tcs_booleanpropertyexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","BooleanPropertyExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1573:3: ( ( (temp= furcas_tcs_propertyreference )? ) )
            // ./generationTemp/generated/TCS.g:1574:3: ( (temp= furcas_tcs_propertyreference )? )
            {
            // ./generationTemp/generated/TCS.g:1574:3: ( (temp= furcas_tcs_propertyreference )? )
            // ./generationTemp/generated/TCS.g:1574:4: (temp= furcas_tcs_propertyreference )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.76/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1574:127: (temp= furcas_tcs_propertyreference )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==NAME||LA138_0==RARROW||(LA138_0>=49 && LA138_0<=63)||(LA138_0>=65 && LA138_0<=133)) ) {
                alt138=1;
            }
            else if ( (LA138_0==64) ) {
                int LA138_2 = input.LA(2);

                if ( (synpred339_TCS()) ) {
                    alt138=1;
                }
            }
            switch (alt138) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1574:129: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_booleanpropertyexp8322);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
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
    // $ANTLR end "furcas_tcs_booleanpropertyexp"


    // $ANTLR start "furcas_tcs_isdefinedexp"
    // ./generationTemp/generated/TCS.g:1583:1: furcas_tcs_isdefinedexp returns [Object ret2] : ( 'isDefined' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN ) ;
    public final Object furcas_tcs_isdefinedexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","IsDefinedExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1589:3: ( ( 'isDefined' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN ) )
            // ./generationTemp/generated/TCS.g:1590:3: ( 'isDefined' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN )
            {
            // ./generationTemp/generated/TCS.g:1590:3: ( 'isDefined' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN )
            // ./generationTemp/generated/TCS.g:1590:4: 'isDefined' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.77/@templateSequence/@elements.0");
            }
            match(input,108,FOLLOW_108_in_furcas_tcs_isdefinedexp8367); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.77/@templateSequence/@elements.1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_isdefinedexp8371); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.77/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1590:424: (temp= furcas_tcs_propertyreference )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==NAME||LA139_0==RARROW||(LA139_0>=49 && LA139_0<=133)) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1590:426: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_isdefinedexp8379);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.77/@templateSequence/@elements.3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_isdefinedexp8388); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_isdefinedexp"


    // $ANTLR start "furcas_tcs_oneexp"
    // ./generationTemp/generated/TCS.g:1599:1: furcas_tcs_oneexp returns [Object ret2] : ( 'one' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN ) ;
    public final Object furcas_tcs_oneexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","OneExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1605:3: ( ( 'one' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN ) )
            // ./generationTemp/generated/TCS.g:1606:3: ( 'one' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN )
            {
            // ./generationTemp/generated/TCS.g:1606:3: ( 'one' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN )
            // ./generationTemp/generated/TCS.g:1606:4: 'one' LPAREN (temp= furcas_tcs_propertyreference )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.78/@templateSequence/@elements.0");
            }
            match(input,77,FOLLOW_77_in_furcas_tcs_oneexp8429); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.78/@templateSequence/@elements.1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_oneexp8433); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.78/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1606:418: (temp= furcas_tcs_propertyreference )?
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==NAME||LA140_0==RARROW||(LA140_0>=49 && LA140_0<=133)) ) {
                alt140=1;
            }
            switch (alt140) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1606:420: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_oneexp8441);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.78/@templateSequence/@elements.3");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_oneexp8450); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_oneexp"


    // $ANTLR start "furcas_tcs_instanceofexp"
    // ./generationTemp/generated/TCS.g:1615:1: furcas_tcs_instanceofexp returns [Object ret2] : ( (temp= furcas_tcs_propertyreference )? 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) ;
    public final Object furcas_tcs_instanceofexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","InstanceOfExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1621:3: ( ( (temp= furcas_tcs_propertyreference )? 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )? ) )
            // ./generationTemp/generated/TCS.g:1622:3: ( (temp= furcas_tcs_propertyreference )? 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
            {
            // ./generationTemp/generated/TCS.g:1622:3: ( (temp= furcas_tcs_propertyreference )? 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )? )
            // ./generationTemp/generated/TCS.g:1622:4: (temp= furcas_tcs_propertyreference )? 'instanceOf' (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.79/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1622:127: (temp= furcas_tcs_propertyreference )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==NAME||LA141_0==RARROW||(LA141_0>=49 && LA141_0<=118)||(LA141_0>=120 && LA141_0<=133)) ) {
                alt141=1;
            }
            else if ( (LA141_0==119) ) {
                int LA141_2 = input.LA(2);

                if ( (LA141_2==119) ) {
                    alt141=1;
                }
            }
            switch (alt141) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1622:129: temp= furcas_tcs_propertyreference
                    {
                    pushFollow(FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_instanceofexp8495);
                    temp=furcas_tcs_propertyreference();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "propertyReference", temp);
                      setParent(temp,ret,"propertyReference");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.79/@templateSequence/@elements.1");
            }
            match(input,119,FOLLOW_119_in_furcas_tcs_instanceofexp8503); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.79/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1623:335: (temp= identifier ( ( DLCOLON ) temp= identifier )* )?
            int alt143=2;
            int LA143_0 = input.LA(1);

            if ( (LA143_0==NAME) ) {
                alt143=1;
            }
            switch (alt143) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1623:337: temp= identifier ( ( DLCOLON ) temp= identifier )*
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_tcs_instanceofexp8510);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "supertype", temp);
                      setParent(temp,ret,"supertype");
                    }
                    // ./generationTemp/generated/TCS.g:1624:35: ( ( DLCOLON ) temp= identifier )*
                    loop142:
                    do {
                        int alt142=2;
                        int LA142_0 = input.LA(1);

                        if ( (LA142_0==DLCOLON) ) {
                            alt142=1;
                        }


                        switch (alt142) {
                    	case 1 :
                    	    // ./generationTemp/generated/TCS.g:1624:36: ( DLCOLON ) temp= identifier
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./generationTemp/generated/TCS.g:1624:53: ( DLCOLON )
                    	    // ./generationTemp/generated/TCS.g:1624:54: DLCOLON
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.79/@templateSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    match(input,DLCOLON,FOLLOW_DLCOLON_in_furcas_tcs_instanceofexp8519); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_identifier_in_furcas_tcs_instanceofexp8527);
                    	    temp=identifier();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "supertype", temp);
                    	      setParent(temp,ret,"supertype");
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

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_instanceofexp"


    // $ANTLR start "furcas_tcs_value"
    // ./generationTemp/generated/TCS.g:1633:1: furcas_tcs_value returns [Object ret2] : (ret= furcas_tcs_stringval | ret= furcas_tcs_integerval | ret= furcas_tcs_negativeintegerval | ret= furcas_tcs_enumliteralval ) ;
    public final Object furcas_tcs_value() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1634:3: ( (ret= furcas_tcs_stringval | ret= furcas_tcs_integerval | ret= furcas_tcs_negativeintegerval | ret= furcas_tcs_enumliteralval ) )
            // ./generationTemp/generated/TCS.g:1635:3: (ret= furcas_tcs_stringval | ret= furcas_tcs_integerval | ret= furcas_tcs_negativeintegerval | ret= furcas_tcs_enumliteralval )
            {
            // ./generationTemp/generated/TCS.g:1635:3: (ret= furcas_tcs_stringval | ret= furcas_tcs_integerval | ret= furcas_tcs_negativeintegerval | ret= furcas_tcs_enumliteralval )
            int alt144=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt144=1;
                }
                break;
            case 64:
                {
                int LA144_2 = input.LA(2);

                if ( (synpred345_TCS()) ) {
                    alt144=1;
                }
                else if ( (synpred346_TCS()) ) {
                    alt144=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 144, 2, input);

                    throw nvae;
                }
                }
                break;
            case QMARK:
                {
                int LA144_3 = input.LA(2);

                if ( (synpred345_TCS()) ) {
                    alt144=1;
                }
                else if ( (synpred346_TCS()) ) {
                    alt144=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 144, 3, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
                {
                int LA144_4 = input.LA(2);

                if ( (synpred345_TCS()) ) {
                    alt144=1;
                }
                else if ( (synpred346_TCS()) ) {
                    alt144=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 144, 4, input);

                    throw nvae;
                }
                }
                break;
            case INT:
                {
                alt144=2;
                }
                break;
            case MINUS:
                {
                alt144=3;
                }
                break;
            case SHARP:
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
                    // ./generationTemp/generated/TCS.g:1635:4: ret= furcas_tcs_stringval
                    {
                    pushFollow(FOLLOW_furcas_tcs_stringval_in_furcas_tcs_value8572);
                    ret=furcas_tcs_stringval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1636:5: ret= furcas_tcs_integerval
                    {
                    pushFollow(FOLLOW_furcas_tcs_integerval_in_furcas_tcs_value8580);
                    ret=furcas_tcs_integerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1637:5: ret= furcas_tcs_negativeintegerval
                    {
                    pushFollow(FOLLOW_furcas_tcs_negativeintegerval_in_furcas_tcs_value8588);
                    ret=furcas_tcs_negativeintegerval();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:1638:5: ret= furcas_tcs_enumliteralval
                    {
                    pushFollow(FOLLOW_furcas_tcs_enumliteralval_in_furcas_tcs_value8596);
                    ret=furcas_tcs_enumliteralval();

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
    // $ANTLR end "furcas_tcs_value"


    // $ANTLR start "furcas_tcs_stringval"
    // ./generationTemp/generated/TCS.g:1645:1: furcas_tcs_stringval returns [Object ret2] : ( (temp= stringSymbol )? ) ;
    public final Object furcas_tcs_stringval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","StringVal");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1651:3: ( ( (temp= stringSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1652:3: ( (temp= stringSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1652:3: ( (temp= stringSymbol )? )
            // ./generationTemp/generated/TCS.g:1652:4: (temp= stringSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.81/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1652:127: (temp= stringSymbol )?
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==STRING) ) {
                alt145=1;
            }
            switch (alt145) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1652:129: temp= stringSymbol
                    {
                    pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_stringval8630);
                    temp=stringSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "symbol", temp);
                      setParent(temp,ret,"symbol");
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
    // $ANTLR end "furcas_tcs_stringval"


    // $ANTLR start "furcas_tcs_integerval"
    // ./generationTemp/generated/TCS.g:1661:1: furcas_tcs_integerval returns [Object ret2] : ( (temp= integerSymbol )? ) ;
    public final Object furcas_tcs_integerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","IntegerVal");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1667:3: ( ( (temp= integerSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1668:3: ( (temp= integerSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1668:3: ( (temp= integerSymbol )? )
            // ./generationTemp/generated/TCS.g:1668:4: (temp= integerSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.82/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1668:127: (temp= integerSymbol )?
            int alt146=2;
            int LA146_0 = input.LA(1);

            if ( (LA146_0==INT) ) {
                alt146=1;
            }
            switch (alt146) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1668:129: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_integerval8679);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "symbol", temp);
                      setParent(temp,ret,"symbol");
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
    // $ANTLR end "furcas_tcs_integerval"


    // $ANTLR start "furcas_tcs_negativeintegerval"
    // ./generationTemp/generated/TCS.g:1677:1: furcas_tcs_negativeintegerval returns [Object ret2] : ( MINUS (temp= integerSymbol )? ) ;
    public final Object furcas_tcs_negativeintegerval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","NegativeIntegerVal");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1683:3: ( ( MINUS (temp= integerSymbol )? ) )
            // ./generationTemp/generated/TCS.g:1684:3: ( MINUS (temp= integerSymbol )? )
            {
            // ./generationTemp/generated/TCS.g:1684:3: ( MINUS (temp= integerSymbol )? )
            // ./generationTemp/generated/TCS.g:1684:4: MINUS (temp= integerSymbol )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.83/@templateSequence/@elements.0");
            }
            match(input,MINUS,FOLLOW_MINUS_in_furcas_tcs_negativeintegerval8725); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.83/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:1684:273: (temp= integerSymbol )?
            int alt147=2;
            int LA147_0 = input.LA(1);

            if ( (LA147_0==INT) ) {
                alt147=1;
            }
            switch (alt147) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1684:275: temp= integerSymbol
                    {
                    pushFollow(FOLLOW_integerSymbol_in_furcas_tcs_negativeintegerval8733);
                    temp=integerSymbol();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "symbol", temp);
                      setParent(temp,ret,"symbol");
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
    // $ANTLR end "furcas_tcs_negativeintegerval"


    // $ANTLR start "furcas_tcs_enumliteralval"
    // ./generationTemp/generated/TCS.g:1693:1: furcas_tcs_enumliteralval returns [Object ret2] : ( SHARP (temp= identifierOrKeyword ) ) ;
    public final Object furcas_tcs_enumliteralval() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","EnumLiteralVal");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1699:3: ( ( SHARP (temp= identifierOrKeyword ) ) )
            // ./generationTemp/generated/TCS.g:1700:3: ( SHARP (temp= identifierOrKeyword ) )
            {
            // ./generationTemp/generated/TCS.g:1700:3: ( SHARP (temp= identifierOrKeyword ) )
            // ./generationTemp/generated/TCS.g:1700:4: SHARP (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.84/@templateSequence/@elements.0");
            }
            match(input,SHARP,FOLLOW_SHARP_in_furcas_tcs_enumliteralval8779); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.84/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:1700:273: (temp= identifierOrKeyword )
            // ./generationTemp/generated/TCS.g:1700:275: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_furcas_tcs_enumliteralval8787);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
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
    // $ANTLR end "furcas_tcs_enumliteralval"


    // $ANTLR start "furcas_tcs_token"
    // ./generationTemp/generated/TCS.g:1709:1: furcas_tcs_token returns [Object ret2] : ( ( ( 'omitted' ) | ) 'token' (temp= identifier ) COLON (temp= furcas_tcs_orpattern ) SEMI ) ;
    public final Object furcas_tcs_token() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","Token");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1715:3: ( ( ( ( 'omitted' ) | ) 'token' (temp= identifier ) COLON (temp= furcas_tcs_orpattern ) SEMI ) )
            // ./generationTemp/generated/TCS.g:1716:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier ) COLON (temp= furcas_tcs_orpattern ) SEMI )
            {
            // ./generationTemp/generated/TCS.g:1716:3: ( ( ( 'omitted' ) | ) 'token' (temp= identifier ) COLON (temp= furcas_tcs_orpattern ) SEMI )
            // ./generationTemp/generated/TCS.g:1716:4: ( ( 'omitted' ) | ) 'token' (temp= identifier ) COLON (temp= furcas_tcs_orpattern ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1716:128: ( ( 'omitted' ) | )
            int alt148=2;
            int LA148_0 = input.LA(1);

            if ( (LA148_0==79) ) {
                alt148=1;
            }
            else if ( (LA148_0==90) ) {
                alt148=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }
            switch (alt148) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1716:129: ( 'omitted' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1716:145: ( 'omitted' )
                    // ./generationTemp/generated/TCS.g:1716:146: 'omitted'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.0/@thenSequence/@elements.0");
                    }
                    match(input,79,FOLLOW_79_in_furcas_tcs_token8836); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "omitted", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1716:392: 
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "omitted", java.lang.Boolean.FALSE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.1");
            }
            match(input,90,FOLLOW_90_in_furcas_tcs_token8854); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1717:286: (temp= identifier )
            // ./generationTemp/generated/TCS.g:1717:288: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_token8861);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.3");
            }
            match(input,COLON,FOLLOW_COLON_in_furcas_tcs_token8868); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:1718:315: (temp= furcas_tcs_orpattern )
            // ./generationTemp/generated/TCS.g:1718:317: temp= furcas_tcs_orpattern
            {
            pushFollow(FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_token8876);
            temp=furcas_tcs_orpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "pattern", temp);
              setParent(temp,ret,"pattern");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.85/@templateSequence/@elements.5");
            }
            match(input,SEMI,FOLLOW_SEMI_in_furcas_tcs_token8883); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_token"


    // $ANTLR start "furcas_tcs_orpattern"
    // ./generationTemp/generated/TCS.g:1727:1: furcas_tcs_orpattern returns [Object ret2] : ( (temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )* ) ) ;
    public final Object furcas_tcs_orpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","OrPattern");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1733:3: ( ( (temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )* ) ) )
            // ./generationTemp/generated/TCS.g:1734:3: ( (temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )* ) )
            {
            // ./generationTemp/generated/TCS.g:1734:3: ( (temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )* ) )
            // ./generationTemp/generated/TCS.g:1734:4: (temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )* )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.86/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1734:127: (temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )* )
            // ./generationTemp/generated/TCS.g:1734:129: temp= furcas_tcs_simplepattern ( ( PIPE ) temp= furcas_tcs_simplepattern )*
            {
            pushFollow(FOLLOW_furcas_tcs_simplepattern_in_furcas_tcs_orpattern8928);
            temp=furcas_tcs_simplepattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "simplePatterns", temp);
              setParent(temp,ret,"simplePatterns");
            }
            // ./generationTemp/generated/TCS.g:1735:40: ( ( PIPE ) temp= furcas_tcs_simplepattern )*
            loop149:
            do {
                int alt149=2;
                int LA149_0 = input.LA(1);

                if ( (LA149_0==PIPE) ) {
                    alt149=1;
                }


                switch (alt149) {
            	case 1 :
            	    // ./generationTemp/generated/TCS.g:1735:41: ( PIPE ) temp= furcas_tcs_simplepattern
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterSepSeq();
            	    }
            	    // ./generationTemp/generated/TCS.g:1735:58: ( PIPE )
            	    // ./generationTemp/generated/TCS.g:1735:59: PIPE
            	    {
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.86/@templateSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
            	    }
            	    match(input,PIPE,FOLLOW_PIPE_in_furcas_tcs_orpattern8937); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitSepSeq();
            	    }
            	    pushFollow(FOLLOW_furcas_tcs_simplepattern_in_furcas_tcs_orpattern8945);
            	    temp=furcas_tcs_simplepattern();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "simplePatterns", temp);
            	      setParent(temp,ret,"simplePatterns");
            	    }

            	    }
            	    break;

            	default :
            	    break loop149;
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
    // $ANTLR end "furcas_tcs_orpattern"


    // $ANTLR start "furcas_tcs_simplepattern"
    // ./generationTemp/generated/TCS.g:1744:1: furcas_tcs_simplepattern returns [Object ret2] : (ret= furcas_tcs_rulepattern | ret= furcas_tcs_stringpattern | ret= furcas_tcs_classpattern ) ;
    public final Object furcas_tcs_simplepattern() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1745:3: ( (ret= furcas_tcs_rulepattern | ret= furcas_tcs_stringpattern | ret= furcas_tcs_classpattern ) )
            // ./generationTemp/generated/TCS.g:1746:3: (ret= furcas_tcs_rulepattern | ret= furcas_tcs_stringpattern | ret= furcas_tcs_classpattern )
            {
            // ./generationTemp/generated/TCS.g:1746:3: (ret= furcas_tcs_rulepattern | ret= furcas_tcs_stringpattern | ret= furcas_tcs_classpattern )
            int alt150=3;
            switch ( input.LA(1) ) {
            case 66:
            case 91:
            case 112:
                {
                alt150=1;
                }
                break;
            case STRING:
                {
                alt150=2;
                }
                break;
            case LSQUARE:
                {
                alt150=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 150, 0, input);

                throw nvae;
            }

            switch (alt150) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1746:4: ret= furcas_tcs_rulepattern
                    {
                    pushFollow(FOLLOW_furcas_tcs_rulepattern_in_furcas_tcs_simplepattern8988);
                    ret=furcas_tcs_rulepattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1747:5: ret= furcas_tcs_stringpattern
                    {
                    pushFollow(FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_simplepattern8996);
                    ret=furcas_tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1748:5: ret= furcas_tcs_classpattern
                    {
                    pushFollow(FOLLOW_furcas_tcs_classpattern_in_furcas_tcs_simplepattern9004);
                    ret=furcas_tcs_classpattern();

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
    // $ANTLR end "furcas_tcs_simplepattern"


    // $ANTLR start "furcas_tcs_rulepattern"
    // ./generationTemp/generated/TCS.g:1755:1: furcas_tcs_rulepattern returns [Object ret2] : ( (temp= furcas_tcs_rule ) ) ;
    public final Object furcas_tcs_rulepattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","RulePattern");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1761:3: ( ( (temp= furcas_tcs_rule ) ) )
            // ./generationTemp/generated/TCS.g:1762:3: ( (temp= furcas_tcs_rule ) )
            {
            // ./generationTemp/generated/TCS.g:1762:3: ( (temp= furcas_tcs_rule ) )
            // ./generationTemp/generated/TCS.g:1762:4: (temp= furcas_tcs_rule )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.88/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1762:127: (temp= furcas_tcs_rule )
            // ./generationTemp/generated/TCS.g:1762:129: temp= furcas_tcs_rule
            {
            pushFollow(FOLLOW_furcas_tcs_rule_in_furcas_tcs_rulepattern9038);
            temp=furcas_tcs_rule();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "rule", temp);
              setParent(temp,ret,"rule");
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
    // $ANTLR end "furcas_tcs_rulepattern"


    // $ANTLR start "furcas_tcs_rule"
    // ./generationTemp/generated/TCS.g:1771:1: furcas_tcs_rule returns [Object ret2] : (ret= furcas_tcs_wordrule | ret= furcas_tcs_endoflinerule | ret= furcas_tcs_multilinerule ) ;
    public final Object furcas_tcs_rule() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1772:3: ( (ret= furcas_tcs_wordrule | ret= furcas_tcs_endoflinerule | ret= furcas_tcs_multilinerule ) )
            // ./generationTemp/generated/TCS.g:1773:3: (ret= furcas_tcs_wordrule | ret= furcas_tcs_endoflinerule | ret= furcas_tcs_multilinerule )
            {
            // ./generationTemp/generated/TCS.g:1773:3: (ret= furcas_tcs_wordrule | ret= furcas_tcs_endoflinerule | ret= furcas_tcs_multilinerule )
            int alt151=3;
            switch ( input.LA(1) ) {
            case 66:
                {
                alt151=1;
                }
                break;
            case 112:
                {
                alt151=2;
                }
                break;
            case 91:
                {
                alt151=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 151, 0, input);

                throw nvae;
            }

            switch (alt151) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1773:4: ret= furcas_tcs_wordrule
                    {
                    pushFollow(FOLLOW_furcas_tcs_wordrule_in_furcas_tcs_rule9078);
                    ret=furcas_tcs_wordrule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1774:5: ret= furcas_tcs_endoflinerule
                    {
                    pushFollow(FOLLOW_furcas_tcs_endoflinerule_in_furcas_tcs_rule9086);
                    ret=furcas_tcs_endoflinerule();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1775:5: ret= furcas_tcs_multilinerule
                    {
                    pushFollow(FOLLOW_furcas_tcs_multilinerule_in_furcas_tcs_rule9094);
                    ret=furcas_tcs_multilinerule();

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
    // $ANTLR end "furcas_tcs_rule"


    // $ANTLR start "furcas_tcs_wordrule"
    // ./generationTemp/generated/TCS.g:1782:1: furcas_tcs_wordrule returns [Object ret2] : ( 'word' LPAREN 'start' EQ (temp= furcas_tcs_orpattern ) COMA 'part' EQ (temp= furcas_tcs_orpattern ) ( ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) ) | ) RPAREN ) ;
    public final Object furcas_tcs_wordrule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","WordRule");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1788:3: ( ( 'word' LPAREN 'start' EQ (temp= furcas_tcs_orpattern ) COMA 'part' EQ (temp= furcas_tcs_orpattern ) ( ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) ) | ) RPAREN ) )
            // ./generationTemp/generated/TCS.g:1789:3: ( 'word' LPAREN 'start' EQ (temp= furcas_tcs_orpattern ) COMA 'part' EQ (temp= furcas_tcs_orpattern ) ( ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) ) | ) RPAREN )
            {
            // ./generationTemp/generated/TCS.g:1789:3: ( 'word' LPAREN 'start' EQ (temp= furcas_tcs_orpattern ) COMA 'part' EQ (temp= furcas_tcs_orpattern ) ( ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) ) | ) RPAREN )
            // ./generationTemp/generated/TCS.g:1789:4: 'word' LPAREN 'start' EQ (temp= furcas_tcs_orpattern ) COMA 'part' EQ (temp= furcas_tcs_orpattern ) ( ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.0");
            }
            match(input,66,FOLLOW_66_in_furcas_tcs_wordrule9124); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_wordrule9128); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.2");
            }
            match(input,100,FOLLOW_100_in_furcas_tcs_wordrule9132); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.3");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_wordrule9136); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:1789:708: (temp= furcas_tcs_orpattern )
            // ./generationTemp/generated/TCS.g:1789:710: temp= furcas_tcs_orpattern
            {
            pushFollow(FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_wordrule9144);
            temp=furcas_tcs_orpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "start", temp);
              setParent(temp,ret,"start");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.5");
            }
            match(input,COMA,FOLLOW_COMA_in_furcas_tcs_wordrule9151); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.6");
            }
            match(input,65,FOLLOW_65_in_furcas_tcs_wordrule9155); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.7");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_wordrule9159); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.8");
            }
            // ./generationTemp/generated/TCS.g:1790:603: (temp= furcas_tcs_orpattern )
            // ./generationTemp/generated/TCS.g:1790:605: temp= furcas_tcs_orpattern
            {
            pushFollow(FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_wordrule9167);
            temp=furcas_tcs_orpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "part", temp);
              setParent(temp,ret,"part");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.9");
            }
            // ./generationTemp/generated/TCS.g:1791:170: ( ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) ) | )
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==COMA) ) {
                alt152=1;
            }
            else if ( (LA152_0==RPAREN) ) {
                alt152=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }
            switch (alt152) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1791:171: ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1791:187: ( COMA 'end' EQ (temp= furcas_tcs_orpattern ) )
                    // ./generationTemp/generated/TCS.g:1791:188: COMA 'end' EQ (temp= furcas_tcs_orpattern )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.9/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_wordrule9180); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.9/@thenSequence/@elements.1");
                    }
                    match(input,104,FOLLOW_104_in_furcas_tcs_wordrule9184); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.9/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_wordrule9188); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.9/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:1791:847: (temp= furcas_tcs_orpattern )
                    // ./generationTemp/generated/TCS.g:1791:849: temp= furcas_tcs_orpattern
                    {
                    pushFollow(FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_wordrule9196);
                    temp=furcas_tcs_orpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "end", temp);
                      setParent(temp,ret,"end");
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
                    // ./generationTemp/generated/TCS.g:1792:63: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.90/@templateSequence/@elements.10");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_wordrule9216); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_wordrule"


    // $ANTLR start "furcas_tcs_endoflinerule"
    // ./generationTemp/generated/TCS.g:1801:1: furcas_tcs_endoflinerule returns [Object ret2] : ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) RPAREN ) ;
    public final Object furcas_tcs_endoflinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","EndOfLineRule");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1807:3: ( ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) RPAREN ) )
            // ./generationTemp/generated/TCS.g:1808:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) RPAREN )
            {
            // ./generationTemp/generated/TCS.g:1808:3: ( 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) RPAREN )
            // ./generationTemp/generated/TCS.g:1808:4: 'endOfLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.0");
            }
            match(input,112,FOLLOW_112_in_furcas_tcs_endoflinerule9257); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_endoflinerule9261); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.2");
            }
            match(input,100,FOLLOW_100_in_furcas_tcs_endoflinerule9265); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.3");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_endoflinerule9269); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:1808:714: ( ( 'drop' ) | )
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==80) ) {
                alt153=1;
            }
            else if ( (LA153_0==STRING) ) {
                alt153=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 153, 0, input);

                throw nvae;
            }
            switch (alt153) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1808:715: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1808:731: ( 'drop' )
                    // ./generationTemp/generated/TCS.g:1808:732: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.4/@thenSequence/@elements.0");
                    }
                    match(input,80,FOLLOW_80_in_furcas_tcs_endoflinerule9279); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:1808:977: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:1809:140: (temp= furcas_tcs_stringpattern )
            // ./generationTemp/generated/TCS.g:1809:142: temp= furcas_tcs_stringpattern
            {
            pushFollow(FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_endoflinerule9301);
            temp=furcas_tcs_stringpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "start", temp);
              setParent(temp,ret,"start");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.91/@templateSequence/@elements.6");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_endoflinerule9308); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_endoflinerule"


    // $ANTLR start "furcas_tcs_multilinerule"
    // ./generationTemp/generated/TCS.g:1818:1: furcas_tcs_multilinerule returns [Object ret2] : ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) ;
    public final Object furcas_tcs_multilinerule() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","MultiLineRule");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1824:3: ( ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN ) )
            // ./generationTemp/generated/TCS.g:1825:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            {
            // ./generationTemp/generated/TCS.g:1825:3: ( 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN )
            // ./generationTemp/generated/TCS.g:1825:4: 'multiLine' LPAREN 'start' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) COMA 'end' EQ ( ( 'drop' ) | ) (temp= furcas_tcs_stringpattern ) ( ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) ) | ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.0");
            }
            match(input,91,FOLLOW_91_in_furcas_tcs_multilinerule9349); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.1");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_multilinerule9353); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.2");
            }
            match(input,100,FOLLOW_100_in_furcas_tcs_multilinerule9357); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.3");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_multilinerule9361); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.4");
            }
            // ./generationTemp/generated/TCS.g:1825:714: ( ( 'drop' ) | )
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==80) ) {
                alt154=1;
            }
            else if ( (LA154_0==STRING) ) {
                alt154=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 154, 0, input);

                throw nvae;
            }
            switch (alt154) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1825:715: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1825:731: ( 'drop' )
                    // ./generationTemp/generated/TCS.g:1825:732: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.4/@thenSequence/@elements.0");
                    }
                    match(input,80,FOLLOW_80_in_furcas_tcs_multilinerule9371); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:1825:977: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.5");
            }
            // ./generationTemp/generated/TCS.g:1826:140: (temp= furcas_tcs_stringpattern )
            // ./generationTemp/generated/TCS.g:1826:142: temp= furcas_tcs_stringpattern
            {
            pushFollow(FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_multilinerule9393);
            temp=furcas_tcs_stringpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "start", temp);
              setParent(temp,ret,"start");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.6");
            }
            match(input,COMA,FOLLOW_COMA_in_furcas_tcs_multilinerule9400); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.7");
            }
            match(input,104,FOLLOW_104_in_furcas_tcs_multilinerule9404); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.8");
            }
            match(input,EQ,FOLLOW_EQ_in_furcas_tcs_multilinerule9408); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.9");
            }
            // ./generationTemp/generated/TCS.g:1827:603: ( ( 'drop' ) | )
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==80) ) {
                alt155=1;
            }
            else if ( (LA155_0==STRING) ) {
                alt155=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 155, 0, input);

                throw nvae;
            }
            switch (alt155) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1827:604: ( 'drop' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1827:620: ( 'drop' )
                    // ./generationTemp/generated/TCS.g:1827:621: 'drop'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.9/@thenSequence/@elements.0");
                    }
                    match(input,80,FOLLOW_80_in_furcas_tcs_multilinerule9418); if (state.failed) return ret2;
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
                    // ./generationTemp/generated/TCS.g:1827:864: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.10");
            }
            // ./generationTemp/generated/TCS.g:1828:141: (temp= furcas_tcs_stringpattern )
            // ./generationTemp/generated/TCS.g:1828:143: temp= furcas_tcs_stringpattern
            {
            pushFollow(FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_multilinerule9440);
            temp=furcas_tcs_stringpattern();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "end", temp);
              setParent(temp,ret,"end");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11");
            }
            // ./generationTemp/generated/TCS.g:1829:170: ( ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) ) | )
            int alt159=2;
            int LA159_0 = input.LA(1);

            if ( (LA159_0==COMA) ) {
                alt159=1;
            }
            else if ( (LA159_0==RPAREN) ) {
                alt159=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 159, 0, input);

                throw nvae;
            }
            switch (alt159) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1829:171: ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./generationTemp/generated/TCS.g:1829:187: ( COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | ) )
                    // ./generationTemp/generated/TCS.g:1829:188: COMA 'esc' EQ (temp= furcas_tcs_stringpattern ) ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.0");
                    }
                    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_multilinerule9453); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.1");
                    }
                    match(input,114,FOLLOW_114_in_furcas_tcs_multilinerule9457); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.2");
                    }
                    match(input,EQ,FOLLOW_EQ_in_furcas_tcs_multilinerule9461); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.3");
                    }
                    // ./generationTemp/generated/TCS.g:1829:851: (temp= furcas_tcs_stringpattern )
                    // ./generationTemp/generated/TCS.g:1829:853: temp= furcas_tcs_stringpattern
                    {
                    pushFollow(FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_multilinerule9469);
                    temp=furcas_tcs_stringpattern();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "esc", temp);
                      setParent(temp,ret,"esc");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.4");
                    }
                    // ./generationTemp/generated/TCS.g:1830:196: ( ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN ) | )
                    int alt158=2;
                    int LA158_0 = input.LA(1);

                    if ( (LA158_0==COMA) ) {
                        alt158=1;
                    }
                    else if ( (LA158_0==RPAREN) ) {
                        alt158=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ret2;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 158, 0, input);

                        throw nvae;
                    }
                    switch (alt158) {
                        case 1 :
                            // ./generationTemp/generated/TCS.g:1830:197: ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // ./generationTemp/generated/TCS.g:1830:213: ( COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN )
                            // ./generationTemp/generated/TCS.g:1830:214: COMA LPAREN (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )? RPAREN
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.0");
                            }
                            match(input,COMA,FOLLOW_COMA_in_furcas_tcs_multilinerule9482); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.1");
                            }
                            match(input,LPAREN,FOLLOW_LPAREN_in_furcas_tcs_multilinerule9487); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.2");
                            }
                            // ./generationTemp/generated/TCS.g:1830:788: (temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )* )?
                            int alt157=2;
                            int LA157_0 = input.LA(1);

                            if ( (LA157_0==NAME||LA157_0==RARROW||LA157_0==POINT||LA157_0==103||LA157_0==123) ) {
                                alt157=1;
                            }
                            switch (alt157) {
                                case 1 :
                                    // ./generationTemp/generated/TCS.g:1830:790: temp= furcas_tcs_mapping ( ( COMA ) temp= furcas_tcs_mapping )*
                                    {
                                    pushFollow(FOLLOW_furcas_tcs_mapping_in_furcas_tcs_multilinerule9495);
                                    temp=furcas_tcs_mapping();

                                    checkFollows();
                                    state._fsp--;
                                    if (state.failed) return ret2;
                                    if ( state.backtracking==0 ) {
                                      setProperty(ret, "escMappings", temp);
                                      setParent(temp,ret,"escMappings");
                                    }
                                    // ./generationTemp/generated/TCS.g:1831:37: ( ( COMA ) temp= furcas_tcs_mapping )*
                                    loop156:
                                    do {
                                        int alt156=2;
                                        int LA156_0 = input.LA(1);

                                        if ( (LA156_0==COMA) ) {
                                            alt156=1;
                                        }


                                        switch (alt156) {
                                    	case 1 :
                                    	    // ./generationTemp/generated/TCS.g:1831:38: ( COMA ) temp= furcas_tcs_mapping
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _enterSepSeq();
                                    	    }
                                    	    // ./generationTemp/generated/TCS.g:1831:55: ( COMA )
                                    	    // ./generationTemp/generated/TCS.g:1831:56: COMA
                                    	    {
                                    	    if ( state.backtracking==0 ) {
                                    	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                                    	    }
                                    	    match(input,COMA,FOLLOW_COMA_in_furcas_tcs_multilinerule9504); if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      _afterSeqEl();
                                    	    }

                                    	    }

                                    	    if ( state.backtracking==0 ) {
                                    	      _exitSepSeq();
                                    	    }
                                    	    pushFollow(FOLLOW_furcas_tcs_mapping_in_furcas_tcs_multilinerule9512);
                                    	    temp=furcas_tcs_mapping();

                                    	    checkFollows();
                                    	    state._fsp--;
                                    	    if (state.failed) return ret2;
                                    	    if ( state.backtracking==0 ) {
                                    	      setProperty(ret, "escMappings", temp);
                                    	      setParent(temp,ret,"escMappings");
                                    	    }

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop156;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.3");
                            }
                            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_multilinerule9524); if (state.failed) return ret2;
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }

                            }

                            if ( state.backtracking==0 ) {
                              _exitAlt();
                            }

                            }
                            break;
                        case 2 :
                            // ./generationTemp/generated/TCS.g:1832:276: 
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
                    // ./generationTemp/generated/TCS.g:1833:35: 
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
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.92/@templateSequence/@elements.12");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_furcas_tcs_multilinerule9555); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_multilinerule"


    // $ANTLR start "furcas_tcs_mapping"
    // ./generationTemp/generated/TCS.g:1842:1: furcas_tcs_mapping returns [Object ret2] : (ret= furcas_tcs_simplemapping | ret= furcas_tcs_wildcardmapping | ret= furcas_tcs_octalmapping | ret= furcas_tcs_hexadecimalmapping ) ;
    public final Object furcas_tcs_mapping() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./generationTemp/generated/TCS.g:1843:3: ( (ret= furcas_tcs_simplemapping | ret= furcas_tcs_wildcardmapping | ret= furcas_tcs_octalmapping | ret= furcas_tcs_hexadecimalmapping ) )
            // ./generationTemp/generated/TCS.g:1844:3: (ret= furcas_tcs_simplemapping | ret= furcas_tcs_wildcardmapping | ret= furcas_tcs_octalmapping | ret= furcas_tcs_hexadecimalmapping )
            {
            // ./generationTemp/generated/TCS.g:1844:3: (ret= furcas_tcs_simplemapping | ret= furcas_tcs_wildcardmapping | ret= furcas_tcs_octalmapping | ret= furcas_tcs_hexadecimalmapping )
            int alt160=4;
            switch ( input.LA(1) ) {
            case NAME:
            case RARROW:
                {
                alt160=1;
                }
                break;
            case POINT:
                {
                alt160=2;
                }
                break;
            case 123:
                {
                alt160=3;
                }
                break;
            case 103:
                {
                alt160=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 160, 0, input);

                throw nvae;
            }

            switch (alt160) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1844:4: ret= furcas_tcs_simplemapping
                    {
                    pushFollow(FOLLOW_furcas_tcs_simplemapping_in_furcas_tcs_mapping9593);
                    ret=furcas_tcs_simplemapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./generationTemp/generated/TCS.g:1845:5: ret= furcas_tcs_wildcardmapping
                    {
                    pushFollow(FOLLOW_furcas_tcs_wildcardmapping_in_furcas_tcs_mapping9601);
                    ret=furcas_tcs_wildcardmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./generationTemp/generated/TCS.g:1846:5: ret= furcas_tcs_octalmapping
                    {
                    pushFollow(FOLLOW_furcas_tcs_octalmapping_in_furcas_tcs_mapping9609);
                    ret=furcas_tcs_octalmapping();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./generationTemp/generated/TCS.g:1847:5: ret= furcas_tcs_hexadecimalmapping
                    {
                    pushFollow(FOLLOW_furcas_tcs_hexadecimalmapping_in_furcas_tcs_mapping9617);
                    ret=furcas_tcs_hexadecimalmapping();

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
    // $ANTLR end "furcas_tcs_mapping"


    // $ANTLR start "furcas_tcs_simplemapping"
    // ./generationTemp/generated/TCS.g:1854:1: furcas_tcs_simplemapping returns [Object ret2] : ( (temp= identifier )? RARROW (temp= identifier )? ) ;
    public final Object furcas_tcs_simplemapping() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","SimpleMapping");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1860:3: ( ( (temp= identifier )? RARROW (temp= identifier )? ) )
            // ./generationTemp/generated/TCS.g:1861:3: ( (temp= identifier )? RARROW (temp= identifier )? )
            {
            // ./generationTemp/generated/TCS.g:1861:3: ( (temp= identifier )? RARROW (temp= identifier )? )
            // ./generationTemp/generated/TCS.g:1861:4: (temp= identifier )? RARROW (temp= identifier )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.94/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1861:127: (temp= identifier )?
            int alt161=2;
            int LA161_0 = input.LA(1);

            if ( (LA161_0==NAME) ) {
                alt161=1;
            }
            switch (alt161) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1861:129: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_tcs_simplemapping9651);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "key", temp);
                      setParent(temp,ret,"key");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.94/@templateSequence/@elements.1");
            }
            match(input,RARROW,FOLLOW_RARROW_in_furcas_tcs_simplemapping9660); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.94/@templateSequence/@elements.2");
            }
            // ./generationTemp/generated/TCS.g:1862:317: (temp= identifier )?
            int alt162=2;
            int LA162_0 = input.LA(1);

            if ( (LA162_0==NAME) ) {
                alt162=1;
            }
            switch (alt162) {
                case 1 :
                    // ./generationTemp/generated/TCS.g:1862:319: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_furcas_tcs_simplemapping9668);
                    temp=identifier();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", temp);
                      setParent(temp,ret,"value");
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
    // $ANTLR end "furcas_tcs_simplemapping"


    // $ANTLR start "furcas_tcs_wildcardmapping"
    // ./generationTemp/generated/TCS.g:1871:1: furcas_tcs_wildcardmapping returns [Object ret2] : ( POINT RARROW POINT ) ;
    public final Object furcas_tcs_wildcardmapping() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","WildcardMapping");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1877:3: ( ( POINT RARROW POINT ) )
            // ./generationTemp/generated/TCS.g:1878:3: ( POINT RARROW POINT )
            {
            // ./generationTemp/generated/TCS.g:1878:3: ( POINT RARROW POINT )
            // ./generationTemp/generated/TCS.g:1878:4: POINT RARROW POINT
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.95/@templateSequence/@elements.0");
            }
            match(input,POINT,FOLLOW_POINT_in_furcas_tcs_wildcardmapping9714); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.95/@templateSequence/@elements.1");
            }
            match(input,RARROW,FOLLOW_RARROW_in_furcas_tcs_wildcardmapping9719); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.95/@templateSequence/@elements.2");
            }
            match(input,POINT,FOLLOW_POINT_in_furcas_tcs_wildcardmapping9724); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_wildcardmapping"


    // $ANTLR start "furcas_tcs_octalmapping"
    // ./generationTemp/generated/TCS.g:1886:1: furcas_tcs_octalmapping returns [Object ret2] : ( 'octal' ) ;
    public final Object furcas_tcs_octalmapping() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","OctalMapping");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1892:3: ( ( 'octal' ) )
            // ./generationTemp/generated/TCS.g:1893:3: ( 'octal' )
            {
            // ./generationTemp/generated/TCS.g:1893:3: ( 'octal' )
            // ./generationTemp/generated/TCS.g:1893:4: 'octal'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.96/@templateSequence/@elements.0");
            }
            match(input,123,FOLLOW_123_in_furcas_tcs_octalmapping9765); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_octalmapping"


    // $ANTLR start "furcas_tcs_hexadecimalmapping"
    // ./generationTemp/generated/TCS.g:1901:1: furcas_tcs_hexadecimalmapping returns [Object ret2] : ( 'hex' ) ;
    public final Object furcas_tcs_hexadecimalmapping() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","HexadecimalMapping");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1907:3: ( ( 'hex' ) )
            // ./generationTemp/generated/TCS.g:1908:3: ( 'hex' )
            {
            // ./generationTemp/generated/TCS.g:1908:3: ( 'hex' )
            // ./generationTemp/generated/TCS.g:1908:4: 'hex'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.97/@templateSequence/@elements.0");
            }
            match(input,103,FOLLOW_103_in_furcas_tcs_hexadecimalmapping9805); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_hexadecimalmapping"


    // $ANTLR start "furcas_tcs_stringpattern"
    // ./generationTemp/generated/TCS.g:1916:1: furcas_tcs_stringpattern returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object furcas_tcs_stringpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","StringPattern");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1922:3: ( ( (temp= stringSymbol ) ) )
            // ./generationTemp/generated/TCS.g:1923:3: ( (temp= stringSymbol ) )
            {
            // ./generationTemp/generated/TCS.g:1923:3: ( (temp= stringSymbol ) )
            // ./generationTemp/generated/TCS.g:1923:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.98/@templateSequence/@elements.0");
            }
            // ./generationTemp/generated/TCS.g:1923:127: (temp= stringSymbol )
            // ./generationTemp/generated/TCS.g:1923:129: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_furcas_tcs_stringpattern9849);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
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
    // $ANTLR end "furcas_tcs_stringpattern"


    // $ANTLR start "furcas_tcs_classpattern"
    // ./generationTemp/generated/TCS.g:1932:1: furcas_tcs_classpattern returns [Object ret2] : ( LSQUARE (temp= identifier ) RSQUARE ) ;
    public final Object furcas_tcs_classpattern() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("FURCAS","TCS","ClassPattern");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./generationTemp/generated/TCS.g:1938:3: ( ( LSQUARE (temp= identifier ) RSQUARE ) )
            // ./generationTemp/generated/TCS.g:1939:3: ( LSQUARE (temp= identifier ) RSQUARE )
            {
            // ./generationTemp/generated/TCS.g:1939:3: ( LSQUARE (temp= identifier ) RSQUARE )
            // ./generationTemp/generated/TCS.g:1939:4: LSQUARE (temp= identifier ) RSQUARE
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.99/@templateSequence/@elements.0");
            }
            match(input,LSQUARE,FOLLOW_LSQUARE_in_furcas_tcs_classpattern9893); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.99/@templateSequence/@elements.1");
            }
            // ./generationTemp/generated/TCS.g:1939:275: (temp= identifier )
            // ./generationTemp/generated/TCS.g:1939:277: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_furcas_tcs_classpattern9901);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.99/@templateSequence/@elements.2");
            }
            match(input,RSQUARE,FOLLOW_RSQUARE_in_furcas_tcs_classpattern9908); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "furcas_tcs_classpattern"

    // $ANTLR start synpred171_TCS
    public final void synpred171_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // ./generationTemp/generated/TCS.g:360:128: ( ( (temp= ecore_epackage ) ) )
        // ./generationTemp/generated/TCS.g:360:128: ( (temp= ecore_epackage ) )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // ./generationTemp/generated/TCS.g:360:144: ( (temp= ecore_epackage ) )
        // ./generationTemp/generated/TCS.g:360:145: (temp= ecore_epackage )
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.8/@templateSequence/@elements.0/@thenSequence/@elements.0");
        }
        // ./generationTemp/generated/TCS.g:360:293: (temp= ecore_epackage )
        // ./generationTemp/generated/TCS.g:360:295: temp= ecore_epackage
        {
        pushFollow(FOLLOW_ecore_epackage_in_synpred171_TCS1686);
        temp=ecore_epackage();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred171_TCS

    // $ANTLR start synpred274_TCS
    public final void synpred274_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // ./generationTemp/generated/TCS.g:924:174: ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) )
        // ./generationTemp/generated/TCS.g:924:174: ( COMA 'mode' EQ (temp= identifierOrKeyword ) )
        {
        if ( state.backtracking==0 ) {
          _enterAlt(0);
        }
        // ./generationTemp/generated/TCS.g:924:190: ( COMA 'mode' EQ (temp= identifierOrKeyword ) )
        // ./generationTemp/generated/TCS.g:924:191: COMA 'mode' EQ (temp= identifierOrKeyword )
        {
        if ( state.backtracking==0 ) {
          _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.38/@templateSequence/@elements.5/@thenSequence/@elements.0");
        }
        match(input,COMA,FOLLOW_COMA_in_synpred274_TCS5548); if (state.failed) return ;
        match(input,93,FOLLOW_93_in_synpred274_TCS5552); if (state.failed) return ;
        match(input,EQ,FOLLOW_EQ_in_synpred274_TCS5556); if (state.failed) return ;
        // ./generationTemp/generated/TCS.g:924:851: (temp= identifierOrKeyword )
        // ./generationTemp/generated/TCS.g:924:853: temp= identifierOrKeyword
        {
        pushFollow(FOLLOW_identifierOrKeyword_in_synpred274_TCS5564);
        temp=identifierOrKeyword();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred274_TCS

    // $ANTLR start synpred333_TCS
    public final void synpred333_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // ./generationTemp/generated/TCS.g:1527:129: (temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )* )
        // ./generationTemp/generated/TCS.g:1527:129: temp= furcas_tcs_atomexp ( ( 'and' ) temp= furcas_tcs_atomexp )*
        {
        pushFollow(FOLLOW_furcas_tcs_atomexp_in_synpred333_TCS8132);
        temp=furcas_tcs_atomexp();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        // ./generationTemp/generated/TCS.g:1528:37: ( ( 'and' ) temp= furcas_tcs_atomexp )*
        loop206:
        do {
            int alt206=2;
            int LA206_0 = input.LA(1);

            if ( (LA206_0==64) ) {
                alt206=1;
            }


            switch (alt206) {
        	case 1 :
        	    // ./generationTemp/generated/TCS.g:1528:38: ( 'and' ) temp= furcas_tcs_atomexp
        	    {
        	    // ./generationTemp/generated/TCS.g:1528:55: ( 'and' )
        	    // ./generationTemp/generated/TCS.g:1528:56: 'and'
        	    {
        	    if ( state.backtracking==0 ) {
        	      _beforeSeqEl("platform:/plugin/com.sap.furcas.parser.tcs/mapping/TCS.tcs#//@templates.73/@templateSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");
        	    }
        	    match(input,64,FOLLOW_64_in_synpred333_TCS8140); if (state.failed) return ;

        	    }

        	    pushFollow(FOLLOW_furcas_tcs_atomexp_in_synpred333_TCS8147);
        	    temp=furcas_tcs_atomexp();

        	    checkFollows();
        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop206;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred333_TCS

    // $ANTLR start synpred334_TCS
    public final void synpred334_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // ./generationTemp/generated/TCS.g:1539:4: (ret= furcas_tcs_equalsexp )
        // ./generationTemp/generated/TCS.g:1539:4: ret= furcas_tcs_equalsexp
        {
        pushFollow(FOLLOW_furcas_tcs_equalsexp_in_synpred334_TCS8192);
        ret=furcas_tcs_equalsexp();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred334_TCS

    // $ANTLR start synpred335_TCS
    public final void synpred335_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // ./generationTemp/generated/TCS.g:1540:5: (ret= furcas_tcs_booleanpropertyexp )
        // ./generationTemp/generated/TCS.g:1540:5: ret= furcas_tcs_booleanpropertyexp
        {
        pushFollow(FOLLOW_furcas_tcs_booleanpropertyexp_in_synpred335_TCS8200);
        ret=furcas_tcs_booleanpropertyexp();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred335_TCS

    // $ANTLR start synpred339_TCS
    public final void synpred339_TCS_fragment() throws RecognitionException {   
        Object temp = null;


        // ./generationTemp/generated/TCS.g:1574:129: (temp= furcas_tcs_propertyreference )
        // ./generationTemp/generated/TCS.g:1574:129: temp= furcas_tcs_propertyreference
        {
        pushFollow(FOLLOW_furcas_tcs_propertyreference_in_synpred339_TCS8322);
        temp=furcas_tcs_propertyreference();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred339_TCS

    // $ANTLR start synpred345_TCS
    public final void synpred345_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // ./generationTemp/generated/TCS.g:1635:4: (ret= furcas_tcs_stringval )
        // ./generationTemp/generated/TCS.g:1635:4: ret= furcas_tcs_stringval
        {
        pushFollow(FOLLOW_furcas_tcs_stringval_in_synpred345_TCS8572);
        ret=furcas_tcs_stringval();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred345_TCS

    // $ANTLR start synpred346_TCS
    public final void synpred346_TCS_fragment() throws RecognitionException {   
        Object ret = null;


        // ./generationTemp/generated/TCS.g:1636:5: (ret= furcas_tcs_integerval )
        // ./generationTemp/generated/TCS.g:1636:5: ret= furcas_tcs_integerval
        {
        pushFollow(FOLLOW_furcas_tcs_integerval_in_synpred346_TCS8580);
        ret=furcas_tcs_integerval();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred346_TCS

    // Delegated rules

    public final boolean synpred335_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred335_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred339_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred339_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred346_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred346_TCS_fragment(); // can never throw exception
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
    public final boolean synpred333_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred333_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred274_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred274_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred334_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred334_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred345_TCS() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred345_TCS_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA97 dfa97 = new DFA97(this);
    protected DFA136 dfa136 = new DFA136(this);
    static final String DFA3_eotS =
        "\25\uffff";
    static final String DFA3_eofS =
        "\2\4\1\uffff\1\2\21\uffff";
    static final String DFA3_minS =
        "\1\4\1\10\1\uffff\1\4\1\uffff\5\0\1\12\4\0\1\4\1\12\1\0\1\4\2\0";
    static final String DFA3_maxS =
        "\2\u0085\1\uffff\1\u0085\1\uffff\5\0\1\u0085\4\0\2\u0085\1\0\1\u0085"+
        "\2\0";
    static final String DFA3_acceptS =
        "\2\uffff\1\1\1\uffff\1\2\20\uffff";
    static final String DFA3_specialS =
        "\5\uffff\1\5\1\10\1\6\1\13\1\2\1\uffff\1\12\1\7\1\11\1\4\2\uffff"+
        "\1\3\1\uffff\1\0\1\1}>";
    static final String[] DFA3_transitionS = {
            "\1\1\1\2\2\uffff\1\2\1\3\1\4\1\uffff\1\4\2\uffff\1\4\1\uffff"+
            "\1\4\37\uffff\2\4\2\uffff\1\4\7\uffff\1\4\11\uffff\1\4\14\uffff"+
            "\1\4\12\uffff\1\4\3\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff"+
            "\1\4\2\uffff\1\4",
            "\1\2\2\4\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\37\uffff\2\4\2"+
            "\uffff\1\4\7\uffff\1\4\11\uffff\1\4\14\uffff\1\4\12\uffff\1"+
            "\4\3\uffff\1\4\15\uffff\1\4\1\uffff\1\4\16\uffff\1\4\2\uffff"+
            "\1\4",
            "",
            "\1\5\3\uffff\3\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\37\uffff"+
            "\1\6\1\7\2\4\1\10\7\4\1\11\11\4\1\12\14\4\1\13\12\4\1\14\3\4"+
            "\1\15\15\4\1\16\1\4\1\17\16\4\1\20\2\4\1\21",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\4\4\uffff\1\4\1\uffff\1\4\37\uffff\2\4\2\uffff\1\4\36\uffff"+
            "\1\4\12\uffff\1\4\3\uffff\1\4\15\uffff\1\4\1\uffff\1\2\21\uffff"+
            "\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\2\5\uffff\1\4\4\uffff\1\4\1\uffff\1\4\37\uffff\2\4\2\uffff"+
            "\1\4\36\uffff\1\4\12\uffff\1\4\3\uffff\1\4\15\uffff\1\4\23\uffff"+
            "\1\4",
            "\1\4\4\uffff\1\23\1\uffff\1\22\37\uffff\2\4\2\uffff\1\4\36"+
            "\uffff\1\4\12\uffff\1\4\3\uffff\1\4\15\uffff\1\4\23\uffff\1"+
            "\4",
            "\1\uffff",
            "\2\4\3\uffff\1\2\1\4\4\uffff\1\24\1\4\2\uffff\1\4\1\uffff\1"+
            "\4\2\uffff\1\4\3\uffff\2\4\23\uffff\125\4",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "360:127: ( ( (temp= ecore_epackage ) ) | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_19 = input.LA(1);

                         
                        int index3_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_19);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_20 = input.LA(1);

                         
                        int index3_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_20);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_9 = input.LA(1);

                         
                        int index3_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_9);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_17 = input.LA(1);

                         
                        int index3_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_17);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_14 = input.LA(1);

                         
                        int index3_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_7 = input.LA(1);

                         
                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA3_12 = input.LA(1);

                         
                        int index3_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_12);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA3_6 = input.LA(1);

                         
                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA3_13 = input.LA(1);

                         
                        int index3_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_13);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA3_11 = input.LA(1);

                         
                        int index3_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred171_TCS()) ) {s = 2;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\u00b5\uffff";
    static final String DFA87_eofS =
        "\130\uffff\2\u00b0\127\uffff\2\u00b0\2\uffff";
    static final String DFA87_minS =
        "\1\4\126\13\3\4\126\13\1\uffff\2\12\2\uffff";
    static final String DFA87_maxS =
        "\1\u0085\126\37\3\u0085\126\37\1\uffff\2\36\2\uffff";
    static final String DFA87_acceptS =
        "\u00b0\uffff\1\1\2\uffff\1\2\1\3";
    static final String DFA87_specialS =
        "\u00b5\uffff}>";
    static final String[] DFA87_transitionS = {
            "\1\1\6\uffff\1\131\4\uffff\1\127\16\uffff\1\130\21\uffff\1\2"+
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
            "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
            "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
            "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
            "\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
            "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111"+
            "\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123"+
            "\1\124\1\125\1\126",
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
            "\1\132\54\uffff\1\133\1\134\1\135\1\136\1\137\1\140\1\141\1"+
            "\142\1\143\1\144\1\145\1\146\1\147\1\150\1\151\1\152\1\153\1"+
            "\154\1\155\1\156\1\157\1\160\1\161\1\162\1\163\1\164\1\165\1"+
            "\166\1\167\1\170\1\171\1\172\1\173\1\174\1\175\1\176\1\177\1"+
            "\u0080\1\u0081\1\u0082\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087"+
            "\1\u0088\1\u0089\1\u008a\1\u008b\1\u008c\1\u008d\1\u008e\1\u008f"+
            "\1\u0090\1\u0091\1\u0092\1\u0093\1\u0094\1\u0095\1\u0096\1\u0097"+
            "\1\u0098\1\u0099\1\u009a\1\u009b\1\u009c\1\u009d\1\u009e\1\u009f"+
            "\1\u00a0\1\u00a1\1\u00a2\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7"+
            "\1\u00a8\1\u00a9\1\u00aa\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af",
            "\1\u00b0\15\uffff\1\u00b0\13\uffff\1\u00b0\22\uffff\42\u00b0"+
            "\1\u00b1\21\u00b0\1\u00b2\40\u00b0",
            "\1\u00b0\15\uffff\1\u00b0\13\uffff\1\u00b0\22\uffff\42\u00b0"+
            "\1\u00b1\21\u00b0\1\u00b2\40\u00b0",
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
            "\1\u00b3\7\uffff\1\u00b0\13\uffff\1\u00b0",
            "\1\u00b4\7\uffff\1\u00b0\13\uffff\1\u00b0",
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
            return "869:3: (ret= furcas_tcs_primitivepropertyinit | ret= furcas_tcs_lookuppropertyinit | ret= furcas_tcs_foreachpredicatepropertyinit )";
        }
    }
    static final String DFA97_eotS =
        "\135\uffff";
    static final String DFA97_eofS =
        "\135\uffff";
    static final String DFA97_minS =
        "\2\14\1\uffff\1\13\1\4\126\14\1\0\1\uffff";
    static final String DFA97_maxS =
        "\1\22\1\177\1\uffff\1\13\1\u0085\126\22\1\0\1\uffff";
    static final String DFA97_acceptS =
        "\2\uffff\1\2\131\uffff\1\1";
    static final String DFA97_specialS =
        "\133\uffff\1\0\1\uffff}>";
    static final String[] DFA97_transitionS = {
            "\1\2\5\uffff\1\1",
            "\1\2\105\uffff\1\2\12\uffff\1\3\41\uffff\1\2",
            "",
            "\1\4",
            "\1\5\54\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1"+
            "\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1"+
            "\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1"+
            "\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1"+
            "\63\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1"+
            "\77\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1"+
            "\111\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1"+
            "\123\1\124\1\125\1\126\1\127\1\130\1\131\1\132",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\134\5\uffff\1\133",
            "\1\uffff",
            ""
    };

    static final short[] DFA97_eot = DFA.unpackEncodedString(DFA97_eotS);
    static final short[] DFA97_eof = DFA.unpackEncodedString(DFA97_eofS);
    static final char[] DFA97_min = DFA.unpackEncodedStringToUnsignedChars(DFA97_minS);
    static final char[] DFA97_max = DFA.unpackEncodedStringToUnsignedChars(DFA97_maxS);
    static final short[] DFA97_accept = DFA.unpackEncodedString(DFA97_acceptS);
    static final short[] DFA97_special = DFA.unpackEncodedString(DFA97_specialS);
    static final short[][] DFA97_transition;

    static {
        int numStates = DFA97_transitionS.length;
        DFA97_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA97_transition[i] = DFA.unpackEncodedString(DFA97_transitionS[i]);
        }
    }

    class DFA97 extends DFA {

        public DFA97(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 97;
            this.eot = DFA97_eot;
            this.eof = DFA97_eof;
            this.min = DFA97_min;
            this.max = DFA97_max;
            this.accept = DFA97_accept;
            this.special = DFA97_special;
            this.transition = DFA97_transition;
        }
        public String getDescription() {
            return "924:173: ( ( COMA 'mode' EQ (temp= identifierOrKeyword ) ) | )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA97_91 = input.LA(1);

                         
                        int index97_91 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred274_TCS()) ) {s = 92;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index97_91);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 97, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA136_eotS =
        "\u00b3\uffff";
    static final String DFA136_eofS =
        "\21\131\1\uffff\66\131\1\uffff\16\131\6\uffff\126\131";
    static final String DFA136_minS =
        "\1\4\20\13\1\0\14\13\1\12\36\13\1\12\31\13\1\4\5\uffff\126\13";
    static final String DFA136_maxS =
        "\1\u0085\20\167\1\0\66\167\1\13\16\167\1\u0085\5\uffff\126\167";
    static final String DFA136_acceptS =
        "\130\uffff\1\1\1\2\1\5\1\4\1\3\126\uffff";
    static final String DFA136_specialS =
        "\21\uffff\1\1\66\uffff\1\0\152\uffff}>";
    static final String[] DFA136_transitionS = {
            "\1\1\6\uffff\1\130\4\uffff\1\127\6\uffff\1\131\31\uffff\1\2"+
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
            "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
            "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
            "\1\50\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
            "\1\64\1\65\1\66\1\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77"+
            "\1\100\1\101\1\102\1\103\1\104\1\105\1\106\1\107\1\110\1\111"+
            "\1\112\1\113\1\114\1\115\1\116\1\117\1\120\1\121\1\122\1\123"+
            "\1\124\1\125\1\126",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\uffff",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\133\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\134\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\135\54\uffff\1\136\1\137\1\140\1\141\1\142\1\143\1\144\1"+
            "\145\1\146\1\147\1\150\1\151\1\152\1\153\1\154\1\155\1\156\1"+
            "\157\1\160\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\170\1"+
            "\171\1\172\1\173\1\174\1\175\1\176\1\177\1\u0080\1\u0081\1\u0082"+
            "\1\u0083\1\u0084\1\u0085\1\u0086\1\u0087\1\u0088\1\u0089\1\u008a"+
            "\1\u008b\1\u008c\1\u008d\1\u008e\1\u008f\1\u0090\1\u0091\1\u0092"+
            "\1\u0093\1\u0094\1\u0095\1\u0096\1\u0097\1\u0098\1\u0099\1\u009a"+
            "\1\u009b\1\u009c\1\u009d\1\u009e\1\u009f\1\u00a0\1\u00a1\1\u00a2"+
            "\1\u00a3\1\u00a4\1\u00a5\1\u00a6\1\u00a7\1\u00a8\1\u00a9\1\u00aa"+
            "\1\u00ab\1\u00ac\1\u00ad\1\u00ae\1\u00af\1\u00b0\1\u00b1\1\u00b2",
            "",
            "",
            "",
            "",
            "",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132",
            "\1\130\13\uffff\1\131\50\uffff\1\131\66\uffff\1\132"
    };

    static final short[] DFA136_eot = DFA.unpackEncodedString(DFA136_eotS);
    static final short[] DFA136_eof = DFA.unpackEncodedString(DFA136_eofS);
    static final char[] DFA136_min = DFA.unpackEncodedStringToUnsignedChars(DFA136_minS);
    static final char[] DFA136_max = DFA.unpackEncodedStringToUnsignedChars(DFA136_maxS);
    static final short[] DFA136_accept = DFA.unpackEncodedString(DFA136_acceptS);
    static final short[] DFA136_special = DFA.unpackEncodedString(DFA136_specialS);
    static final short[][] DFA136_transition;

    static {
        int numStates = DFA136_transitionS.length;
        DFA136_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA136_transition[i] = DFA.unpackEncodedString(DFA136_transitionS[i]);
        }
    }

    class DFA136 extends DFA {

        public DFA136(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 136;
            this.eot = DFA136_eot;
            this.eof = DFA136_eof;
            this.min = DFA136_min;
            this.max = DFA136_max;
            this.accept = DFA136_accept;
            this.special = DFA136_special;
            this.transition = DFA136_transition;
        }
        public String getDescription() {
            return "1539:3: (ret= furcas_tcs_equalsexp | ret= furcas_tcs_booleanpropertyexp | ret= furcas_tcs_isdefinedexp | ret= furcas_tcs_oneexp | ret= furcas_tcs_instanceofexp )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA136_72 = input.LA(1);

                         
                        int index136_72 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA136_72==EQ) ) {s = 88;}

                        else if ( (synpred335_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index136_72);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA136_17 = input.LA(1);

                         
                        int index136_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred334_TCS()) ) {s = 88;}

                        else if ( (synpred335_TCS()) ) {s = 89;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index136_17);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 136, _s, input);
            error(nvae);
            throw nvae;
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
    public static final BitSet FOLLOW_NAME_in_escapedIdentifierOrKeyword811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_escapedIdentifierOrKeyword819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_escapedIdentifierOrKeyword827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_escapedIdentifierOrKeyword835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_escapedIdentifierOrKeyword843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_escapedIdentifierOrKeyword851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_escapedIdentifierOrKeyword859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_escapedIdentifierOrKeyword867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_escapedIdentifierOrKeyword875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_escapedIdentifierOrKeyword883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_escapedIdentifierOrKeyword891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_escapedIdentifierOrKeyword899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_escapedIdentifierOrKeyword907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_escapedIdentifierOrKeyword915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_escapedIdentifierOrKeyword923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_escapedIdentifierOrKeyword931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_escapedIdentifierOrKeyword939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_escapedIdentifierOrKeyword947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_escapedIdentifierOrKeyword955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_escapedIdentifierOrKeyword963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_escapedIdentifierOrKeyword971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_escapedIdentifierOrKeyword979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_escapedIdentifierOrKeyword987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_escapedIdentifierOrKeyword995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_escapedIdentifierOrKeyword1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_escapedIdentifierOrKeyword1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_escapedIdentifierOrKeyword1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_escapedIdentifierOrKeyword1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_escapedIdentifierOrKeyword1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_escapedIdentifierOrKeyword1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_escapedIdentifierOrKeyword1051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_escapedIdentifierOrKeyword1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_escapedIdentifierOrKeyword1067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_escapedIdentifierOrKeyword1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_escapedIdentifierOrKeyword1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_escapedIdentifierOrKeyword1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_escapedIdentifierOrKeyword1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_escapedIdentifierOrKeyword1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_escapedIdentifierOrKeyword1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_escapedIdentifierOrKeyword1123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_escapedIdentifierOrKeyword1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_escapedIdentifierOrKeyword1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_escapedIdentifierOrKeyword1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_escapedIdentifierOrKeyword1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_escapedIdentifierOrKeyword1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_escapedIdentifierOrKeyword1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_escapedIdentifierOrKeyword1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_escapedIdentifierOrKeyword1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_escapedIdentifierOrKeyword1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_escapedIdentifierOrKeyword1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_escapedIdentifierOrKeyword1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_escapedIdentifierOrKeyword1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_escapedIdentifierOrKeyword1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_escapedIdentifierOrKeyword1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_escapedIdentifierOrKeyword1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_escapedIdentifierOrKeyword1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_escapedIdentifierOrKeyword1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_escapedIdentifierOrKeyword1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_escapedIdentifierOrKeyword1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_escapedIdentifierOrKeyword1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_escapedIdentifierOrKeyword1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_escapedIdentifierOrKeyword1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_escapedIdentifierOrKeyword1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_111_in_escapedIdentifierOrKeyword1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_escapedIdentifierOrKeyword1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_113_in_escapedIdentifierOrKeyword1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_escapedIdentifierOrKeyword1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_115_in_escapedIdentifierOrKeyword1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_escapedIdentifierOrKeyword1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_escapedIdentifierOrKeyword1363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_escapedIdentifierOrKeyword1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_119_in_escapedIdentifierOrKeyword1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_escapedIdentifierOrKeyword1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_escapedIdentifierOrKeyword1395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_escapedIdentifierOrKeyword1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_escapedIdentifierOrKeyword1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_124_in_escapedIdentifierOrKeyword1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_escapedIdentifierOrKeyword1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_escapedIdentifierOrKeyword1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_127_in_escapedIdentifierOrKeyword1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_128_in_escapedIdentifierOrKeyword1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_escapedIdentifierOrKeyword1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_escapedIdentifierOrKeyword1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_escapedIdentifierOrKeyword1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_escapedIdentifierOrKeyword1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_escapedIdentifierOrKeyword1491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_plainStringSymbol1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_uriSymbol1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol1615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_epackage_in_ecore_eclassifier1686 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_ecore_eclassifier1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_epackage_superPackage_in_ecore_epackage1769 = new BitSet(new long[]{0x0000000000000110L});
    public static final BitSet FOLLOW_identifier_in_ecore_epackage1792 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DLCOLON_in_ecore_epackage1801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uriSymbol_in_ecore_epackage1819 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SHARP_in_ecore_epackage1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ecore_epackage_superPackage1883 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_DLCOLON_in_ecore_epackage_superPackage1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_uriSymbol_in_ecore_epackage_superPackage1910 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SHARP_in_ecore_epackage_superPackage1919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_concretesyntax_in_main1963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_furcas_tcs_concretesyntax1997 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_concretesyntax2004 = new BitSet(new long[]{0x0000000000002400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_concretesyntax2017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_furcas_tcs_concretesyntax2021 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_concretesyntax2025 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_concretesyntax2033 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_concretesyntax2040 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_concretesyntax2058 = new BitSet(new long[]{0x0400000000004000L,0x004004004580C120L});
    public static final BitSet FOLLOW_furcas_tcs_template_in_furcas_tcs_concretesyntax2069 = new BitSet(new long[]{0x0400000000004000L,0x004004004580C120L});
    public static final BitSet FOLLOW_furcas_tcs_template_in_furcas_tcs_concretesyntax2077 = new BitSet(new long[]{0x0400000000004000L,0x004004004580C120L});
    public static final BitSet FOLLOW_78_in_furcas_tcs_concretesyntax2094 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_concretesyntax2098 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_furcas_tcs_keyword_in_furcas_tcs_concretesyntax2109 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_furcas_tcs_keyword_in_furcas_tcs_concretesyntax2117 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_concretesyntax2132 = new BitSet(new long[]{0x0000000000004000L,0x0000040005808000L});
    public static final BitSet FOLLOW_87_in_furcas_tcs_concretesyntax2155 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_concretesyntax2159 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_furcas_tcs_symbol_in_furcas_tcs_concretesyntax2170 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_furcas_tcs_symbol_in_furcas_tcs_concretesyntax2178 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_concretesyntax2193 = new BitSet(new long[]{0x0000000000004000L,0x0000040005008000L});
    public static final BitSet FOLLOW_furcas_tcs_operatorlist_in_furcas_tcs_concretesyntax2214 = new BitSet(new long[]{0x0000000000004000L,0x0000040005008000L});
    public static final BitSet FOLLOW_furcas_tcs_operatorlist_in_furcas_tcs_concretesyntax2222 = new BitSet(new long[]{0x0000000000004000L,0x0000040005008000L});
    public static final BitSet FOLLOW_furcas_tcs_token_in_furcas_tcs_concretesyntax2237 = new BitSet(new long[]{0x0000000000004000L,0x0000000005008000L});
    public static final BitSet FOLLOW_furcas_tcs_token_in_furcas_tcs_concretesyntax2245 = new BitSet(new long[]{0x0000000000004000L,0x0000000005008000L});
    public static final BitSet FOLLOW_88_in_furcas_tcs_concretesyntax2262 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_concretesyntax2266 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_concretesyntax2274 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_concretesyntax2281 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_concretesyntax2302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_eclassifier_in_reference2350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_reference2366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference2374 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_reference2383 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_reference2391 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_furcas_tcs_contexttemplate_in_furcas_tcs_template2430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_primitivetemplate_in_furcas_tcs_template2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_enumerationtemplate_in_furcas_tcs_template2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_functiontemplate_in_furcas_tcs_template2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_classtemplate_in_furcas_tcs_contexttemplate2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_operatortemplate_in_furcas_tcs_contexttemplate2489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_118_in_furcas_tcs_primitivetemplate2519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_primitivetemplate2526 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_102_in_furcas_tcs_primitivetemplate2532 = new BitSet(new long[]{0x0000000000010330L});
    public static final BitSet FOLLOW_reference_in_furcas_tcs_primitivetemplate2535 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000080L});
    public static final BitSet FOLLOW_71_in_furcas_tcs_primitivetemplate2545 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_furcas_tcs_primitivetemplate2563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_primitivetemplate2570 = new BitSet(new long[]{0x0000000000020000L,0x1000000000000000L});
    public static final BitSet FOLLOW_124_in_furcas_tcs_primitivetemplate2582 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_primitivetemplate2604 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_furcas_tcs_primitivetemplate2611 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_primitivetemplate2615 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_primitivetemplate2623 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_primitivetemplate2636 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_furcas_tcs_primitivetemplate2640 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_primitivetemplate2644 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_primitivetemplate2652 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_primitivetemplate2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_furcas_tcs_enumerationtemplate2719 = new BitSet(new long[]{0x0000000000010330L});
    public static final BitSet FOLLOW_reference_in_furcas_tcs_enumerationtemplate2722 = new BitSet(new long[]{0x0000000000028000L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_130_in_furcas_tcs_enumerationtemplate2732 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_enumerationtemplate2760 = new BitSet(new long[]{0x0000000000008200L});
    public static final BitSet FOLLOW_furcas_tcs_enumliteralmapping_in_furcas_tcs_enumerationtemplate2771 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_enumerationtemplate2780 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_furcas_tcs_enumliteralmapping_in_furcas_tcs_enumerationtemplate2788 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_enumerationtemplate2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_enumerationtemplate2820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_enumliteralval_in_furcas_tcs_enumliteralmapping2871 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_enumliteralmapping2878 = new BitSet(new long[]{0xFFFE000031290432L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_enumliteralmapping2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_furcas_tcs_classtemplate2931 = new BitSet(new long[]{0x0000000000010330L});
    public static final BitSet FOLLOW_reference_in_furcas_tcs_classtemplate2934 = new BitSet(new long[]{0x2026000000028600L,0x0002000880100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_61_in_furcas_tcs_classtemplate2944 = new BitSet(new long[]{0x0000000000028200L});
    public static final BitSet FOLLOW_SHARP_in_furcas_tcs_classtemplate2954 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_classtemplate2962 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_SHARP_in_furcas_tcs_classtemplate2998 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_classtemplate3006 = new BitSet(new long[]{0x0026000000028400L,0x0002000880100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_classtemplate3032 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_furcas_tcs_classtemplate3036 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_classtemplate3040 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_classtemplate3048 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_classtemplate3055 = new BitSet(new long[]{0x0026000000028400L,0x0002000880100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_classtemplate3079 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_furcas_tcs_classtemplate3083 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_classtemplate3087 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_classtemplate3095 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_classtemplate3102 = new BitSet(new long[]{0x0026000000028400L,0x0002000880100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_classtemplate3126 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_furcas_tcs_classtemplate3130 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_classtemplate3134 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_classtemplate3142 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_classtemplate3149 = new BitSet(new long[]{0x0026000000028000L,0x0002000880100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_99_in_furcas_tcs_classtemplate3172 = new BitSet(new long[]{0x0026000000028000L,0x0002000080100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_113_in_furcas_tcs_classtemplate3196 = new BitSet(new long[]{0x0026000000028000L,0x0000000080100000L,0x0000000000000020L});
    public static final BitSet FOLLOW_49_in_furcas_tcs_classtemplate3226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_84_in_furcas_tcs_classtemplate3244 = new BitSet(new long[]{0x0024000000028000L,0x0000000080000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_furcas_tcs_classtemplate3268 = new BitSet(new long[]{0x0024000000028400L,0x0000000080000000L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_classtemplate3278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_classtemplate3286 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_classtemplate3293 = new BitSet(new long[]{0x0024000000028000L,0x0000000080000000L});
    public static final BitSet FOLLOW_50_in_furcas_tcs_classtemplate3331 = new BitSet(new long[]{0x0020000000028400L,0x0000000080000000L});
    public static final BitSet FOLLOW_furcas_tcs_contexttags_in_furcas_tcs_classtemplate3344 = new BitSet(new long[]{0x0020000000028000L,0x0000000080000000L});
    public static final BitSet FOLLOW_53_in_furcas_tcs_classtemplate3384 = new BitSet(new long[]{0x0000000000028000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_furcas_tcs_classtemplate3408 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_classtemplate3443 = new BitSet(new long[]{0xFFFE000031298430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_classtemplate3454 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_classtemplate3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_classtemplate3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_furcas_tcs_operatortemplate3528 = new BitSet(new long[]{0x0000000000010330L});
    public static final BitSet FOLLOW_reference_in_furcas_tcs_operatortemplate3531 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_operatortemplate3536 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_106_in_furcas_tcs_operatortemplate3540 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3544 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_operatortemplate3552 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_operatortemplate3560 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operatortemplate3572 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_furcas_tcs_operatortemplate3576 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3580 = new BitSet(new long[]{0xFFFE000000051010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_operatortemplate3588 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operatortemplate3603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_81_in_furcas_tcs_operatortemplate3607 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3611 = new BitSet(new long[]{0xFFFE000000010010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_operatortemplate3619 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operatortemplate3645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_furcas_tcs_operatortemplate3649 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3653 = new BitSet(new long[]{0xFFFE000000010010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_operatortemplate3661 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operatortemplate3687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_furcas_tcs_operatortemplate3691 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3695 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_operatortemplate3703 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operatortemplate3729 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_furcas_tcs_operatortemplate3733 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3737 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_operatortemplate3745 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operatortemplate3771 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_furcas_tcs_operatortemplate3775 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operatortemplate3779 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_operatortemplate3787 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_operatortemplate3807 = new BitSet(new long[]{0x2004000000028000L});
    public static final BitSet FOLLOW_61_in_furcas_tcs_operatortemplate3817 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_50_in_furcas_tcs_operatortemplate3836 = new BitSet(new long[]{0x0000000000028400L});
    public static final BitSet FOLLOW_furcas_tcs_contexttags_in_furcas_tcs_operatortemplate3849 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_operatortemplate3900 = new BitSet(new long[]{0xFFFE000031298430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_operatortemplate3911 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_operatortemplate3921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_operatortemplate3938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_furcas_tcs_functiontemplate3985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_functiontemplate3992 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_functiontemplate3999 = new BitSet(new long[]{0x0000000000010330L});
    public static final BitSet FOLLOW_reference_in_furcas_tcs_functiontemplate4003 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_functiontemplate4008 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_functiontemplate4016 = new BitSet(new long[]{0xFFFE000031298430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_functiontemplate4027 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_functiontemplate4037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_contexttags4082 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_contexttags4090 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_contexttags4099 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_contexttags4107 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_contexttags4119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequence4167 = new BitSet(new long[]{0xFFFE000031290432L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequence4175 = new BitSet(new long[]{0xFFFE000031290432L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_literalref_in_furcas_tcs_sequenceelement4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_property_in_furcas_tcs_sequenceelement4231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_customseparator_in_furcas_tcs_sequenceelement4239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_block_in_furcas_tcs_sequenceelement4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_conditionalelement_in_furcas_tcs_sequenceelement4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_alternative_in_furcas_tcs_sequenceelement4263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_functioncall_in_furcas_tcs_sequenceelement4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_injectoractionsblock_in_furcas_tcs_sequenceelement4279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_literalref4313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_propertyreference4369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_furcas_tcs_propertyreference4385 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_propertyreference4393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_property4446 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_property4459 = new BitSet(new long[]{0x8008000000004000L,0x8620820032081058L,0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyarg_in_furcas_tcs_property4467 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_property4476 = new BitSet(new long[]{0x8008000000000000L,0x8620820032081058L,0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyarg_in_furcas_tcs_property4484 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_property4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_furcas_tcs_customseparator4554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_customseparator4562 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_GT_in_furcas_tcs_customseparator4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_furcas_tcs_block4614 = new BitSet(new long[]{0xFFFE000031690430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_block4622 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_furcas_tcs_block4629 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_block4640 = new BitSet(new long[]{0x1000000000004000L,0x0000080000200000L,0x0000000000000018L});
    public static final BitSet FOLLOW_furcas_tcs_blockarg_in_furcas_tcs_block4648 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_block4657 = new BitSet(new long[]{0x1000000000000000L,0x0000080000200000L,0x0000000000000018L});
    public static final BitSet FOLLOW_furcas_tcs_blockarg_in_furcas_tcs_block4665 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_block4677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_conditionalelement4735 = new BitSet(new long[]{0xFFFE000000010810L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_expression_in_furcas_tcs_conditionalelement4743 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_QMARK_in_furcas_tcs_conditionalelement4750 = new BitSet(new long[]{0xFFFE0000312B1430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_conditionalelement4758 = new BitSet(new long[]{0x0000000000021000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_conditionalelement4771 = new BitSet(new long[]{0xFFFE000031291430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_conditionalelement4779 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_conditionalelement4799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLSQUARE_in_furcas_tcs_alternative4844 = new BitSet(new long[]{0xFFFE000033290430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequenceinalternative_nestedSequence_in_furcas_tcs_alternative4855 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_PIPE_in_furcas_tcs_alternative4864 = new BitSet(new long[]{0xFFFE000037290430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequenceinalternative_nestedSequence_in_furcas_tcs_alternative4872 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_DRSQUARE_in_furcas_tcs_alternative4884 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_STAR_in_furcas_tcs_alternative4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_furcas_tcs_sequenceinalternative_nestedSequence4960 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_sequenceinalternative_nestedSequence4964 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_sequenceinalternative_nestedSequence4972 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_sequenceinalternative_nestedSequence4979 = new BitSet(new long[]{0xFFFE000031290432L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequenceinalternative_nestedSequence5003 = new BitSet(new long[]{0xFFFE000031290432L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequenceelement_in_furcas_tcs_sequenceinalternative_nestedSequence5011 = new BitSet(new long[]{0xFFFE000031290432L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_DOLLAR_in_furcas_tcs_functioncall5063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_functioncall5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DLCURLY_in_furcas_tcs_injectoractionsblock5118 = new BitSet(new long[]{0xFFFE0000C0010810L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_injectoraction_in_furcas_tcs_injectoractionsblock5129 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_injectoractionsblock5138 = new BitSet(new long[]{0xFFFE000080010810L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_injectoraction_in_furcas_tcs_injectoractionsblock5146 = new BitSet(new long[]{0x0000000040040000L});
    public static final BitSet FOLLOW_DRCURLY_in_furcas_tcs_injectoractionsblock5161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyinit_in_furcas_tcs_injectoraction5202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_primitivepropertyinit_in_furcas_tcs_propertyinit5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_lookuppropertyinit_in_furcas_tcs_propertyinit5237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_foreachpredicatepropertyinit_in_furcas_tcs_propertyinit5245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_primitivepropertyinit5279 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_furcas_tcs_primitivepropertyinit5294 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_primitivepropertyinit5309 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_escapedIdentifierOrKeyword_in_furcas_tcs_primitivepropertyinit5324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_lookuppropertyinit5373 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_furcas_tcs_lookuppropertyinit5388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_lookuppropertyinit5403 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_83_in_furcas_tcs_lookuppropertyinit5414 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_lookuppropertyinit5418 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_lookuppropertyinit5426 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_lookuppropertyinit5435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_foreachpredicatepropertyinit5480 = new BitSet(new long[]{0x0000000080000800L});
    public static final BitSet FOLLOW_LARROW_in_furcas_tcs_foreachpredicatepropertyinit5495 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_foreachpredicatepropertyinit5510 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_101_in_furcas_tcs_foreachpredicatepropertyinit5521 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_foreachpredicatepropertyinit5525 = new BitSet(new long[]{0x0000000000041020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_foreachpredicatepropertyinit5533 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_foreachpredicatepropertyinit5548 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_furcas_tcs_foreachpredicatepropertyinit5552 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_foreachpredicatepropertyinit5556 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_foreachpredicatepropertyinit5564 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_foreachpredicatepropertyinit5590 = new BitSet(new long[]{0x0000000000001000L,0x8000000020040000L});
    public static final BitSet FOLLOW_furcas_tcs_predicatesemantic_in_furcas_tcs_foreachpredicatepropertyinit5601 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_foreachpredicatepropertyinit5610 = new BitSet(new long[]{0x0000000000000000L,0x8000000020040000L});
    public static final BitSet FOLLOW_furcas_tcs_predicatesemantic_in_furcas_tcs_foreachpredicatepropertyinit5618 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_foreachpredicatepropertyinit5646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_furcas_tcs_predicatesemantic5693 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_predicatesemantic5697 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_predicatesemantic5705 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_predicatesemantic5712 = new BitSet(new long[]{0x0000000000000000L,0x8000000020000000L});
    public static final BitSet FOLLOW_93_in_furcas_tcs_predicatesemantic5735 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_predicatesemantic5739 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_predicatesemantic5747 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_predicatesemantic5754 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
    public static final BitSet FOLLOW_127_in_furcas_tcs_predicatesemantic5771 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_predicatesemantic5775 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_predicatesemantic5783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_referstoparg_in_furcas_tcs_propertyarg5825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_lookinparg_in_furcas_tcs_propertyarg5833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_createinparg_in_furcas_tcs_propertyarg5841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_asparg_in_furcas_tcs_propertyarg5849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_separatorparg_in_furcas_tcs_propertyarg5857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_disambiguateparg_in_furcas_tcs_propertyarg5865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_autocreateparg_in_furcas_tcs_propertyarg5873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_importcontextparg_in_furcas_tcs_propertyarg5881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_partialparg_in_furcas_tcs_propertyarg5889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_forcedlowerparg_in_furcas_tcs_propertyarg5897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_forcedupperparg_in_furcas_tcs_propertyarg5905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_createasparg_in_furcas_tcs_propertyarg5913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_lookupscopeparg_in_furcas_tcs_propertyarg5921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_referencebyparg_in_furcas_tcs_propertyarg5929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_prefixparg_in_furcas_tcs_propertyarg5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_postfixparg_in_furcas_tcs_propertyarg5945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_modeparg_in_furcas_tcs_propertyarg5953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_furcas_tcs_referstoparg5983 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_referstoparg5987 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_referstoparg5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_furcas_tcs_lookinparg6038 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_lookinparg6042 = new BitSet(new long[]{0xFFFE000000000212L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_SHARP_in_furcas_tcs_lookinparg6053 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_furcas_tcs_lookinparg6057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_lookinparg6074 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_furcas_tcs_lookinparg6083 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_lookinparg6091 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_76_in_furcas_tcs_createinparg6146 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_createinparg6150 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_createinparg6158 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_POINT_in_furcas_tcs_createinparg6167 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_createinparg6175 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_127_in_furcas_tcs_asparg6223 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_asparg6227 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_asparg6235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_122_in_furcas_tcs_separatorparg6278 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_separatorparg6282 = new BitSet(new long[]{0xFFFE000031290430L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_sequence_in_furcas_tcs_separatorparg6290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_furcas_tcs_disambiguateparg6333 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_disambiguateparg6337 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_disambiguateparg6345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_105_in_furcas_tcs_autocreateparg6390 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_autocreateparg6394 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000A00L});
    public static final BitSet FOLLOW_furcas_tcs_autocreatekind_in_furcas_tcs_autocreateparg6402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_furcas_tcs_autocreatekind6446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_furcas_tcs_autocreatekind6456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_116_in_furcas_tcs_autocreatekind6466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_furcas_tcs_importcontextparg6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_furcas_tcs_partialparg6537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_furcas_tcs_forcedlowerparg6577 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_forcedlowerparg6581 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_forcedlowerparg6589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_121_in_furcas_tcs_forcedupperparg6632 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_forcedupperparg6636 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_forcedupperparg6644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_furcas_tcs_createasparg6687 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_createasparg6691 = new BitSet(new long[]{0xFFFE000000000012L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_createasparg6699 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_furcas_tcs_createasparg6708 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_createasparg6716 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_111_in_furcas_tcs_lookupscopeparg6764 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_lookupscopeparg6768 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_lookupscopeparg6776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_117_in_furcas_tcs_referencebyparg6819 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_referencebyparg6823 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_referencebyparg6831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_furcas_tcs_prefixparg6874 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_prefixparg6878 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_prefixparg6886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_furcas_tcs_postfixparg6929 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_postfixparg6933 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_postfixparg6941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_furcas_tcs_modeparg6984 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_modeparg6988 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_modeparg6996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_nbnlbarg_in_furcas_tcs_blockarg7036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_indentincrbarg_in_furcas_tcs_blockarg7044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_startnlbarg_in_furcas_tcs_blockarg7052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_startnbnlbarg_in_furcas_tcs_blockarg7060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_endnlbarg_in_furcas_tcs_blockarg7068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_132_in_furcas_tcs_nbnlbarg7098 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_nbnlbarg7102 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_nbnlbarg7110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_furcas_tcs_indentincrbarg7155 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_indentincrbarg7159 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_indentincrbarg7167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_131_in_furcas_tcs_startnlbarg7212 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_startnlbarg7216 = new BitSet(new long[]{0x0000000000000000L,0x4000200000000000L});
    public static final BitSet FOLLOW_126_in_furcas_tcs_startnlbarg7226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_furcas_tcs_startnlbarg7239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_furcas_tcs_startnbnlbarg7286 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_startnbnlbarg7290 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_startnbnlbarg7298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_furcas_tcs_endnlbarg7343 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_endnlbarg7347 = new BitSet(new long[]{0x0000000000000000L,0x4000200000000000L});
    public static final BitSet FOLLOW_126_in_furcas_tcs_endnlbarg7357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_furcas_tcs_endnlbarg7370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_symbol7421 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_symbol7428 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_symbol7436 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_symbol7449 = new BitSet(new long[]{0x0280000000008000L,0x2000000200000000L});
    public static final BitSet FOLLOW_furcas_tcs_spacekind_in_furcas_tcs_symbol7457 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_symbol7466 = new BitSet(new long[]{0x0280000000000000L,0x2000000200000000L});
    public static final BitSet FOLLOW_furcas_tcs_spacekind_in_furcas_tcs_symbol7474 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_symbol7499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_furcas_tcs_spacekind7541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_furcas_tcs_spacekind7551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_furcas_tcs_spacekind7561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_125_in_furcas_tcs_spacekind7571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_keyword7606 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_keyword7613 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_keyword7621 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_keyword7628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_furcas_tcs_operatorlist7669 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_operatorlist7682 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_operatorlist7702 = new BitSet(new long[]{0x0000000000004000L,0x0000000400000000L});
    public static final BitSet FOLLOW_furcas_tcs_priority_in_furcas_tcs_operatorlist7713 = new BitSet(new long[]{0x0000000000004000L,0x0000000400000000L});
    public static final BitSet FOLLOW_furcas_tcs_priority_in_furcas_tcs_operatorlist7721 = new BitSet(new long[]{0x0000000000004000L,0x0000000400000000L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_operatorlist7736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_furcas_tcs_priority7777 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_priority7784 = new BitSet(new long[]{0x0000000000042000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_priority7807 = new BitSet(new long[]{0x4000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_furcas_tcs_associativity_in_furcas_tcs_priority7815 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_LCURLY_in_furcas_tcs_priority7829 = new BitSet(new long[]{0x0008000000004010L});
    public static final BitSet FOLLOW_furcas_tcs_operator_in_furcas_tcs_priority7840 = new BitSet(new long[]{0x0008000000004010L});
    public static final BitSet FOLLOW_furcas_tcs_operator_in_furcas_tcs_priority7848 = new BitSet(new long[]{0x0008000000004010L});
    public static final BitSet FOLLOW_RCURLY_in_furcas_tcs_priority7863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_furcas_tcs_operator7910 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_operator7932 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_operator7939 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_operator7958 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_operator7978 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_operator8003 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_operator8011 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_operator8018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_furcas_tcs_associativity8060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_120_in_furcas_tcs_associativity8070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_andexp_in_furcas_tcs_expression8098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_atomexp_in_furcas_tcs_andexp8132 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_furcas_tcs_andexp8140 = new BitSet(new long[]{0xFFFE000000010810L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_atomexp_in_furcas_tcs_andexp8147 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_furcas_tcs_equalsexp_in_furcas_tcs_atomexp8192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_booleanpropertyexp_in_furcas_tcs_atomexp8200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_isdefinedexp_in_furcas_tcs_atomexp8208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_oneexp_in_furcas_tcs_atomexp8216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_instanceofexp_in_furcas_tcs_atomexp8224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_equalsexp8258 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_equalsexp8267 = new BitSet(new long[]{0x0000000200000260L});
    public static final BitSet FOLLOW_furcas_tcs_value_in_furcas_tcs_equalsexp8275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_booleanpropertyexp8322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_furcas_tcs_isdefinedexp8367 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_isdefinedexp8371 = new BitSet(new long[]{0xFFFE000000011010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_isdefinedexp8379 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_isdefinedexp8388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_furcas_tcs_oneexp8429 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_oneexp8433 = new BitSet(new long[]{0xFFFE000000011010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_oneexp8441 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_oneexp8450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_furcas_tcs_instanceofexp8495 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
    public static final BitSet FOLLOW_119_in_furcas_tcs_instanceofexp8503 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_instanceofexp8510 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_DLCOLON_in_furcas_tcs_instanceofexp8519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_instanceofexp8527 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_furcas_tcs_stringval_in_furcas_tcs_value8572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_integerval_in_furcas_tcs_value8580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_negativeintegerval_in_furcas_tcs_value8588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_enumliteralval_in_furcas_tcs_value8596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_stringval8630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_integerval8679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_furcas_tcs_negativeintegerval8725 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_integerSymbol_in_furcas_tcs_negativeintegerval8733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHARP_in_furcas_tcs_enumliteralval8779 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_furcas_tcs_enumliteralval8787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_furcas_tcs_token8836 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_90_in_furcas_tcs_token8854 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_token8861 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_furcas_tcs_token8868 = new BitSet(new long[]{0x0000000000200020L,0x0001000008000004L});
    public static final BitSet FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_token8876 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SEMI_in_furcas_tcs_token8883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_simplepattern_in_furcas_tcs_orpattern8928 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_PIPE_in_furcas_tcs_orpattern8937 = new BitSet(new long[]{0x0000000000200020L,0x0001000008000004L});
    public static final BitSet FOLLOW_furcas_tcs_simplepattern_in_furcas_tcs_orpattern8945 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_furcas_tcs_rulepattern_in_furcas_tcs_simplepattern8988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_simplepattern8996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_classpattern_in_furcas_tcs_simplepattern9004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_rule_in_furcas_tcs_rulepattern9038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_wordrule_in_furcas_tcs_rule9078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_endoflinerule_in_furcas_tcs_rule9086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_multilinerule_in_furcas_tcs_rule9094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_furcas_tcs_wordrule9124 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_wordrule9128 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_furcas_tcs_wordrule9132 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_wordrule9136 = new BitSet(new long[]{0x0000000000200020L,0x0001000008000004L});
    public static final BitSet FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_wordrule9144 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_wordrule9151 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_furcas_tcs_wordrule9155 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_wordrule9159 = new BitSet(new long[]{0x0000000000200020L,0x0001000008000004L});
    public static final BitSet FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_wordrule9167 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_wordrule9180 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_furcas_tcs_wordrule9184 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_wordrule9188 = new BitSet(new long[]{0x0000000000200020L,0x0001000008000004L});
    public static final BitSet FOLLOW_furcas_tcs_orpattern_in_furcas_tcs_wordrule9196 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_wordrule9216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_112_in_furcas_tcs_endoflinerule9257 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_endoflinerule9261 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_furcas_tcs_endoflinerule9265 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_endoflinerule9269 = new BitSet(new long[]{0x0000000000000020L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_furcas_tcs_endoflinerule9279 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_endoflinerule9301 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_endoflinerule9308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_furcas_tcs_multilinerule9349 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_multilinerule9353 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_100_in_furcas_tcs_multilinerule9357 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_multilinerule9361 = new BitSet(new long[]{0x0000000000000020L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_furcas_tcs_multilinerule9371 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_multilinerule9393 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_multilinerule9400 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_104_in_furcas_tcs_multilinerule9404 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_multilinerule9408 = new BitSet(new long[]{0x0000000000000020L,0x0000000000010000L});
    public static final BitSet FOLLOW_80_in_furcas_tcs_multilinerule9418 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_multilinerule9440 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_multilinerule9453 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_114_in_furcas_tcs_multilinerule9457 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_furcas_tcs_multilinerule9461 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_furcas_tcs_stringpattern_in_furcas_tcs_multilinerule9469 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_multilinerule9482 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_LPAREN_in_furcas_tcs_multilinerule9487 = new BitSet(new long[]{0x0000000100011010L,0x0800008000000000L});
    public static final BitSet FOLLOW_furcas_tcs_mapping_in_furcas_tcs_multilinerule9495 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_COMA_in_furcas_tcs_multilinerule9504 = new BitSet(new long[]{0x0000000100010010L,0x0800008000000000L});
    public static final BitSet FOLLOW_furcas_tcs_mapping_in_furcas_tcs_multilinerule9512 = new BitSet(new long[]{0x0000000000041000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_multilinerule9524 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_furcas_tcs_multilinerule9555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_simplemapping_in_furcas_tcs_mapping9593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_wildcardmapping_in_furcas_tcs_mapping9601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_octalmapping_in_furcas_tcs_mapping9609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_hexadecimalmapping_in_furcas_tcs_mapping9617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_simplemapping9651 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RARROW_in_furcas_tcs_simplemapping9660 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_simplemapping9668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINT_in_furcas_tcs_wildcardmapping9714 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RARROW_in_furcas_tcs_wildcardmapping9719 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_POINT_in_furcas_tcs_wildcardmapping9724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_furcas_tcs_octalmapping9765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_furcas_tcs_hexadecimalmapping9805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_furcas_tcs_stringpattern9849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LSQUARE_in_furcas_tcs_classpattern9893 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_identifier_in_furcas_tcs_classpattern9901 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_RSQUARE_in_furcas_tcs_classpattern9908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_epackage_in_synpred171_TCS1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_synpred274_TCS5548 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_93_in_synpred274_TCS5552 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_EQ_in_synpred274_TCS5556 = new BitSet(new long[]{0xFFFE000000000010L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_identifierOrKeyword_in_synpred274_TCS5564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_atomexp_in_synpred333_TCS8132 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_synpred333_TCS8140 = new BitSet(new long[]{0xFFFE000000010810L,0xFFFFFFFFFFFFFFFFL,0x000000000000003FL});
    public static final BitSet FOLLOW_furcas_tcs_atomexp_in_synpred333_TCS8147 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_furcas_tcs_equalsexp_in_synpred334_TCS8192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_booleanpropertyexp_in_synpred335_TCS8200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_propertyreference_in_synpred339_TCS8322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_stringval_in_synpred345_TCS8572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_furcas_tcs_integerval_in_synpred346_TCS8580 = new BitSet(new long[]{0x0000000000000002L});

}