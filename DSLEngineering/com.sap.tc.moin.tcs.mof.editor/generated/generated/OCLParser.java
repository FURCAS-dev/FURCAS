// $ANTLR 3.1.1 C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g 2010-08-18 16:52:54

package generated;
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
public class OCLParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STRING", "QNAME", "MULTI_LINE_COMMENT", "INT", "FLOAT", "BOOL", "LPAREN", "RPAREN", "DCOLON", "LCURL", "RCURL", "DDOT", "COLON", "COMMENT", "LBRACKET", "RBRACKET", "STAR", "LCURL_LBRACK", "RBRACK_RCURL", "LBRACK_LCURL", "RCURL_RBRACK", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "RANGE_OR_INT", "'Collection'", "'='", "'|'", "'let'", "'in'", "'else'", "'self'", "'endif'", "'Sequence'", "'Bag'", "','", "'OrderedSet'", "'then'", "'iterate'", "';'", "'.'", "'if'", "'->'", "'Set'"
    };
    public static final int STAR=21;
    public static final int RBRACK_RCURL=23;
    public static final int FLOAT=9;
    public static final int EOF=-1;
    public static final int LPAREN=11;
    public static final int LBRACKET=19;
    public static final int RPAREN=12;
    public static final int NAME=4;
    public static final int DCOLON=13;
    public static final int LBRACK_LCURL=24;
    public static final int DIGIT=28;
    public static final int NL=26;
    public static final int RANGE_OR_INT=31;
    public static final int RBRACKET=20;
    public static final int COMMENT=18;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int RCURL_RBRACK=25;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int LCURL_LBRACK=22;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=16;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=10;
    public static final int INT=8;
    public static final int MULTI_LINE_COMMENT=7;
    public static final int ALPHA=29;
    public static final int COLON=17;
    public static final int T__32=32;
    public static final int LCURL=14;
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
    public static final int RCURL=15;
    public static final int STRING=5;

    // delegates
    // delegators


        public OCLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public OCLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OCLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g"; }


       private static final String syntaxUUID = "E0B918419531B1E0A93F11DFA111C3958D1505E2";
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:208:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:209:3: ( (ast= NAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:210:3: (ast= NAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:210:3: (ast= NAME )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:210:4: ast= NAME
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:218:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'Collection' | '=' | '|' | 'let' | 'in' | 'else' | 'self' | 'endif' | 'Sequence' | 'Bag' | ',' | 'OrderedSet' | 'then' | 'iterate' | ';' | '.' | 'if' | '->' | 'Set' ) ;
    public final Object identifierOrKeyword() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:219:3: ( (ast= NAME | 'Collection' | '=' | '|' | 'let' | 'in' | 'else' | 'self' | 'endif' | 'Sequence' | 'Bag' | ',' | 'OrderedSet' | 'then' | 'iterate' | ';' | '.' | 'if' | '->' | 'Set' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:220:3: (ast= NAME | 'Collection' | '=' | '|' | 'let' | 'in' | 'else' | 'self' | 'endif' | 'Sequence' | 'Bag' | ',' | 'OrderedSet' | 'then' | 'iterate' | ';' | '.' | 'if' | '->' | 'Set' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:220:3: (ast= NAME | 'Collection' | '=' | '|' | 'let' | 'in' | 'else' | 'self' | 'endif' | 'Sequence' | 'Bag' | ',' | 'OrderedSet' | 'then' | 'iterate' | ';' | '.' | 'if' | '->' | 'Set' )
            int alt1=20;
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
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:220:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword94); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:222:5: 'Collection'
                    {
                    match(input,32,FOLLOW_32_in_identifierOrKeyword102); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:223:5: '='
                    {
                    match(input,33,FOLLOW_33_in_identifierOrKeyword110); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "=";
                    }

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:224:5: '|'
                    {
                    match(input,34,FOLLOW_34_in_identifierOrKeyword118); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "|";
                    }

                    }
                    break;
                case 5 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:225:5: 'let'
                    {
                    match(input,35,FOLLOW_35_in_identifierOrKeyword126); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 6 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:226:5: 'in'
                    {
                    match(input,36,FOLLOW_36_in_identifierOrKeyword134); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 7 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:227:5: 'else'
                    {
                    match(input,37,FOLLOW_37_in_identifierOrKeyword142); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 8 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:228:5: 'self'
                    {
                    match(input,38,FOLLOW_38_in_identifierOrKeyword150); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "self";
                    }

                    }
                    break;
                case 9 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:229:5: 'endif'
                    {
                    match(input,39,FOLLOW_39_in_identifierOrKeyword158); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 10 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:230:5: 'Sequence'
                    {
                    match(input,40,FOLLOW_40_in_identifierOrKeyword166); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 11 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:231:5: 'Bag'
                    {
                    match(input,41,FOLLOW_41_in_identifierOrKeyword174); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 12 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:232:5: ','
                    {
                    match(input,42,FOLLOW_42_in_identifierOrKeyword182); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ",";
                    }

                    }
                    break;
                case 13 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:233:5: 'OrderedSet'
                    {
                    match(input,43,FOLLOW_43_in_identifierOrKeyword190); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 14 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:234:5: 'then'
                    {
                    match(input,44,FOLLOW_44_in_identifierOrKeyword198); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 15 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:235:5: 'iterate'
                    {
                    match(input,45,FOLLOW_45_in_identifierOrKeyword206); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 16 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:236:5: ';'
                    {
                    match(input,46,FOLLOW_46_in_identifierOrKeyword214); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ";";
                    }

                    }
                    break;
                case 17 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:237:5: '.'
                    {
                    match(input,47,FOLLOW_47_in_identifierOrKeyword222); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = ".";
                    }

                    }
                    break;
                case 18 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:238:5: 'if'
                    {
                    match(input,48,FOLLOW_48_in_identifierOrKeyword230); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 19 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:239:5: '->'
                    {
                    match(input,49,FOLLOW_49_in_identifierOrKeyword238); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "->";
                    }

                    }
                    break;
                case 20 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:240:5: 'Set'
                    {
                    match(input,50,FOLLOW_50_in_identifierOrKeyword246); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      ret = "Set";
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:247:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final Object stringSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:248:3: ( (ast= STRING ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:249:3: (ast= STRING )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:249:3: (ast= STRING )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:249:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol277); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:257:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final Object qualifiedNameSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:258:3: ( (ast= QNAME ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:259:3: (ast= QNAME )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:259:3: (ast= QNAME )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:259:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol308); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:267:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final Object annotationSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:268:3: ( (ast= MULTI_LINE_COMMENT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:269:3: (ast= MULTI_LINE_COMMENT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:269:3: (ast= MULTI_LINE_COMMENT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:269:4: ast= MULTI_LINE_COMMENT
            {
            ast=(Token)match(input,MULTI_LINE_COMMENT,FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol339); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:277:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object integerSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:278:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:279:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:279:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:279:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol370); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:287:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final Object longSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:288:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:289:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:289:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:289:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol401); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:297:1: integerAsString returns [Object ret2] : (ast= INT ) ;
    public final Object integerAsString() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:298:3: ( (ast= INT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:299:3: (ast= INT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:299:3: (ast= INT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:299:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsString432); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:307:1: floatAsString returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatAsString() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:308:3: ( (ast= FLOAT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:309:3: (ast= FLOAT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:309:3: (ast= FLOAT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:309:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsString463); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:317:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:318:3: ( (ast= BOOL ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:319:3: (ast= BOOL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:319:3: (ast= BOOL )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:319:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol494); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:327:1: booleanValueSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final Object booleanValueSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:328:3: ( (ast= BOOL ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:329:3: (ast= BOOL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:329:3: (ast= BOOL )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:329:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanValueSymbol525); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:337:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final Object floatSymbol() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:338:3: ( (ast= FLOAT ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:339:3: (ast= FLOAT )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:339:3: (ast= FLOAT )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:339:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol556); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:347:1: main returns [Object ret2] : ( (ret= ocl_expressions_oclexpression ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:348:3: ( ( (ret= ocl_expressions_oclexpression ) EOF ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:349:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:349:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:349:4: (ret= ocl_expressions_oclexpression ) EOF
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:349:4: (ret= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:349:5: ret= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_main584);
            ret=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main587); if (state.failed) return ret2;

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


    // $ANTLR start "primary_ocl_expressions_oclexpression"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:356:1: primary_ocl_expressions_oclexpression returns [Object ret2] : (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) ;
    public final Object primary_ocl_expressions_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:357:3: ( (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:358:3: (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:358:3: (ret= ocl_expressions_letexp | ret= ocl_expressions_ifexp | ret= ocl_expressions_literalexp | ret= ocl_expressions_variableexp | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt2=1;
                }
                break;
            case 48:
                {
                alt2=2;
                }
                break;
            case STRING:
            case QNAME:
            case INT:
            case FLOAT:
            case BOOL:
            case 32:
            case 40:
            case 41:
            case 43:
            case 50:
                {
                alt2=3;
                }
                break;
            case NAME:
            case 38:
                {
                alt2=4;
                }
                break;
            case LPAREN:
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:358:4: ret= ocl_expressions_letexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_letexp_in_primary_ocl_expressions_oclexpression615);
                    ret=ocl_expressions_letexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:359:5: ret= ocl_expressions_ifexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_ifexp_in_primary_ocl_expressions_oclexpression623);
                    ret=ocl_expressions_ifexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:360:5: ret= ocl_expressions_literalexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_literalexp_in_primary_ocl_expressions_oclexpression631);
                    ret=ocl_expressions_literalexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:361:5: ret= ocl_expressions_variableexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_variableexp_in_primary_ocl_expressions_oclexpression639);
                    ret=ocl_expressions_variableexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:362:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:362:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:362:6: LPAREN ret= ocl_expressions_oclexpression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression648); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression654);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression658); if (state.failed) return ret2;
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:369:1: oclexpressions_priority_0 returns [Object ret2] : ( (ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final Object oclexpressions_priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object temp = null;


        java.lang.String opName=null;
        org.antlr.runtime.Token firstToken=input.LT(1);
        Object semRef=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:372:3: ( ( (ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:4: ( (ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:4: ( (ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:6: (ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:6: (ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:8: ret= primary_ocl_expressions_oclexpression ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0696);
            ret=primary_ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:49: ( ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==47) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred1_OCL()) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==49) ) {
                    int LA4_3 = input.LA(2);

                    if ( (synpred4_OCL()) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:50: ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:101: ( '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:102: '.' ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(".", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,47,FOLLOW_47_in_oclexpressions_priority_0721); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = ".";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:182: ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) )
            	    int alt3=3;
            	    alt3 = dfa3.predict(input);
            	    switch (alt3) {
            	        case 1 :
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:183: ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) )
            	            {
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:205: ( ( (temp= identifierOrKeyword ) ) )
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:206: ( (temp= identifierOrKeyword ) )
            	            {
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:206: ( (temp= identifierOrKeyword ) )
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:207: (temp= identifierOrKeyword )
            	            {
            	            if ( state.backtracking==0 ) {
            	              _beforeSeqEl("E0B9184194EB3300A93F11DF976DC3958D1505E2");
            	            }
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:266: (temp= identifierOrKeyword )
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:268: temp= identifierOrKeyword
            	            {
            	            pushFollow(FOLLOW_identifierOrKeyword_in_oclexpressions_priority_0739);
            	            temp=identifierOrKeyword();

            	            checkFollows();
            	            state._fsp--;
            	            if (state.failed) return ret2;

            	            }

            	            if ( state.backtracking==0 ) {
            	              _afterSeqEl();
            	            }
            	            if ( state.backtracking==0 ) {
            	              semRef = temp;
            	            }
            	            if ( state.backtracking==0 ) {
            	              _beforeSeqEl("E0B9184194EF2AA0A93F11DF907CC3958D1505E2");
            	            }
            	            if ( state.backtracking==0 ) {
            	              _afterSeqEl();
            	            }

            	            }

            	            if ( state.backtracking==0 ) {
            	              List<SemanticDisambRuleData> semDisambRuleData = new ArrayList<SemanticDisambRuleData>();
            	              semDisambRuleData.add(new SemanticDisambRuleData("ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp","#source.type.lookupElementExtended(${referredAttribute}).oclIsTypeOf(Attribute)"));
            	              semDisambRuleData.add(new SemanticDisambRuleData("ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp","#source.type.lookupElementExtended(${referredAssociationEnd}).oclIsTypeOf(Reference)"));
            	              Object lefthand = ret;
            	              List<String> metaType=list("OCL","Expressions","OclExpression");
            	              ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
            	              setSemDisambiguate(ret,lefthand,opName,semRef,semDisambRuleData,false, (ANTLR3LocationToken)firstToken);

            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:383:1: 
            	            {
            	            }
            	            break;
            	        case 3 :
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:383:3: ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] )
            	            {
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:383:24: (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] )
            	            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:383:25: ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken]
            	            {
            	            pushFollow(FOLLOW_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp_in_oclexpressions_priority_0764);
            	            ret=ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp(opName, ret, firstToken);

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
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:3: ( ( '->' ) () )=> ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:15: ( '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:16: '->' ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("->", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,49,FOLLOW_49_in_oclexpressions_priority_0784); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "->";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:99: ( (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:100: (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] )
            	    {
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:100: (ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken] )
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:101: ret= ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp_in_oclexpressions_priority_0791);
            	    ret=ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp(opName, ret, firstToken);

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
    // $ANTLR end "oclexpressions_priority_0"


    // $ANTLR start "oclexpressions_priority_1"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:392:1: oclexpressions_priority_1 returns [Object ret2] : ( (ret= oclexpressions_priority_0 ) ) ;
    public final Object oclexpressions_priority_1() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null;
        org.antlr.runtime.Token firstToken=input.LT(1);
        Object semRef=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:395:3: ( ( (ret= oclexpressions_priority_0 ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:396:4: ( (ret= oclexpressions_priority_0 ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:396:4: ( (ret= oclexpressions_priority_0 ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:396:6: (ret= oclexpressions_priority_0 )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:396:6: (ret= oclexpressions_priority_0 )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:396:8: ret= oclexpressions_priority_0
            {
            pushFollow(FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1837);
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
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return ret2;
    }
    // $ANTLR end "oclexpressions_priority_1"


    // $ANTLR start "ocl_expressions_oclexpression"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:404:1: ocl_expressions_oclexpression returns [Object ret2] : ret= oclexpressions_priority_1 ;
    public final Object ocl_expressions_oclexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:405:3: (ret= oclexpressions_priority_1 )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:406:3: ret= oclexpressions_priority_1
            {
            pushFollow(FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression867);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:413:1: ocl_expressions_literalexp returns [Object ret2] : (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp ) ;
    public final Object ocl_expressions_literalexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:414:3: ( (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:415:3: (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:415:3: (ret= ocl_expressions_primitiveliteralexp | ret= ocl_expressions_enumliteralexp | ret= ocl_expressions_collectionliteralexp )
            int alt5=3;
            switch ( input.LA(1) ) {
            case STRING:
            case INT:
            case FLOAT:
            case BOOL:
                {
                alt5=1;
                }
                break;
            case QNAME:
                {
                alt5=2;
                }
                break;
            case 32:
            case 40:
            case 41:
            case 43:
            case 50:
                {
                alt5=3;
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:415:4: ret= ocl_expressions_primitiveliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_primitiveliteralexp_in_ocl_expressions_literalexp893);
                    ret=ocl_expressions_primitiveliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:416:5: ret= ocl_expressions_enumliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_enumliteralexp_in_ocl_expressions_literalexp901);
                    ret=ocl_expressions_enumliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:417:5: ret= ocl_expressions_collectionliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralexp_in_ocl_expressions_literalexp909);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:424:1: ocl_expressions_primitiveliteralexp returns [Object ret2] : (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp ) ;
    public final Object ocl_expressions_primitiveliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:425:3: ( (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:426:3: (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:426:3: (ret= ocl_expressions_numericliteralexp | ret= ocl_expressions_stringliteralexp | ret= ocl_expressions_booleanliteralexp )
            int alt6=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt6=1;
                }
                break;
            case STRING:
                {
                alt6=2;
                }
                break;
            case BOOL:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:426:4: ret= ocl_expressions_numericliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_numericliteralexp_in_ocl_expressions_primitiveliteralexp936);
                    ret=ocl_expressions_numericliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:427:5: ret= ocl_expressions_stringliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_stringliteralexp_in_ocl_expressions_primitiveliteralexp944);
                    ret=ocl_expressions_stringliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:428:5: ret= ocl_expressions_booleanliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_booleanliteralexp_in_ocl_expressions_primitiveliteralexp952);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:435:1: ocl_expressions_numericliteralexp returns [Object ret2] : (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp ) ;
    public final Object ocl_expressions_numericliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:436:3: ( (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:437:3: (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:437:3: (ret= ocl_expressions_integerliteralexp | ret= ocl_expressions_realliteralexp )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==FLOAT) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:437:4: ret= ocl_expressions_integerliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_integerliteralexp_in_ocl_expressions_numericliteralexp979);
                    ret=ocl_expressions_integerliteralexp();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:438:5: ret= ocl_expressions_realliteralexp
                    {
                    pushFollow(FOLLOW_ocl_expressions_realliteralexp_in_ocl_expressions_numericliteralexp987);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:445:1: ocl_expressions_integerliteralexp returns [Object ret2] : ( (temp= integerAsString ) ) ;
    public final Object ocl_expressions_integerliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","IntegerLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:451:3: ( ( (temp= integerAsString ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:452:3: ( (temp= integerAsString ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:452:3: ( (temp= integerAsString ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:452:4: (temp= integerAsString )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193CFFF00A93F11DF8FDAC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:452:63: (temp= integerAsString )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:452:65: temp= integerAsString
            {
            pushFollow(FOLLOW_integerAsString_in_ocl_expressions_integerliteralexp1021);
            temp=integerAsString();

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
              _beforeSeqEl("E0B9184193D38170A93F11DFA332C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "integerSymbol", null, null, "OCL:self.name.toInteger()", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='Integer' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:461:1: ocl_expressions_stringliteralexp returns [Object ret2] : ( (temp= stringSymbol ) ) ;
    public final Object ocl_expressions_stringliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","StringLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:467:3: ( ( (temp= stringSymbol ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:468:3: ( (temp= stringSymbol ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:468:3: ( (temp= stringSymbol ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:468:4: (temp= stringSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193D83C60A93F11DFA5AFC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:468:63: (temp= stringSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:468:65: temp= stringSymbol
            {
            pushFollow(FOLLOW_stringSymbol_in_ocl_expressions_stringliteralexp1071);
            temp=stringSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "stringSymbol", temp);
              setParent(temp,ret,"stringSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193DBE5E0A93F11DF993EC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.stringSymbol", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='String' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:477:1: ocl_expressions_realliteralexp returns [Object ret2] : ( (temp= floatAsString ) ) ;
    public final Object ocl_expressions_realliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","RealLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:483:3: ( ( (temp= floatAsString ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:484:3: ( (temp= floatAsString ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:484:3: ( (temp= floatAsString ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:484:4: (temp= floatAsString )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193E052B0A93F11DF8D52C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:484:63: (temp= floatAsString )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:484:65: temp= floatAsString
            {
            pushFollow(FOLLOW_floatAsString_in_ocl_expressions_realliteralexp1121);
            temp=floatAsString();

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
              _beforeSeqEl("E0B9184193E38700A93F11DFC9D1C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "realSymbol", null, null, "OCL:self.name.toDouble()", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='Double' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:493:1: ocl_expressions_booleanliteralexp returns [Object ret2] : ( (temp= booleanValueSymbol ) ) ;
    public final Object ocl_expressions_booleanliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","BooleanLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:499:3: ( ( (temp= booleanValueSymbol ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:500:3: ( (temp= booleanValueSymbol ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:500:3: ( (temp= booleanValueSymbol ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:500:4: (temp= booleanValueSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193E7A5B0A93F11DF9C5BC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:500:63: (temp= booleanValueSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:500:65: temp= booleanValueSymbol
            {
            pushFollow(FOLLOW_booleanValueSymbol_in_ocl_expressions_booleanliteralexp1171);
            temp=booleanValueSymbol();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "booleanSymbol", temp);
              setParent(temp,ret,"booleanSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193EAB2F0A93F11DFB3F0C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:if self.booleanSymbol then 'true' else 'false' endif", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:Classifier.allInstances()->select(c| if c.container->isEmpty() then false else c.qualifiedName->asSequence()->at(1)='PrimitiveTypes' and qualifiedName->asSequence()->at(2)='Boolean' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:509:1: ocl_expressions_enumliteralexp returns [Object ret2] : ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) ;
    public final Object ocl_expressions_enumliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","EnumLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:515:3: ( ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:4: (temp= qualifiedNameSymbol ) DCOLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193F00A20A93F11DFC19CC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:63: (temp= qualifiedNameSymbol )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:65: temp= qualifiedNameSymbol
            {
            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_expressions_enumliteralexp1221);
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
              _beforeSeqEl("E0B9184193F190C0A93F11DFC083C3958D1505E2");
            }
            match(input,DCOLON,FOLLOW_DCOLON_in_ocl_expressions_enumliteralexp1228); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184193F22D00A93F11DFB030C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:995: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:516:997: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_expressions_enumliteralexp1236);
            temp=identifier();

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

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:525:1: ocl_expressions_collectionliteralexp returns [Object ret2] : ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) ;
    public final Object ocl_expressions_collectionliteralexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","CollectionLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"collectionliteral"}) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:531:3: ( ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:3: ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:3: ( ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:4: ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841940FEE30A93F11DFC587C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:63: ( ( 'Sequence' (temp= model_classifier_sequence ) ) | ( 'Set' (temp= model_classifier_set ) ) | ( 'Collection' (temp= model_classifier_collection ) ) | ( 'Bag' (temp= model_classifier_bag ) ) | ( 'OrderedSet' (temp= model_classifier_orderedset ) ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt8=1;
                }
                break;
            case 50:
                {
                alt8=2;
                }
                break;
            case 32:
                {
                alt8=3;
                }
                break;
            case 41:
                {
                alt8=4;
                }
                break;
            case 43:
                {
                alt8=5;
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:64: ( 'Sequence' (temp= model_classifier_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:80: ( 'Sequence' (temp= model_classifier_sequence ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:81: 'Sequence' (temp= model_classifier_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184193F699D0A93F11DFA793C3958D1505E2");
                    }
                    match(input,40,FOLLOW_40_in_ocl_expressions_collectionliteralexp1284); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184193F7AB40A93F11DFA5CAC3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:225: (temp= model_classifier_sequence )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:532:227: temp= model_classifier_sequence
                    {
                    pushFollow(FOLLOW_model_classifier_sequence_in_ocl_expressions_collectionliteralexp1291);
                    temp=model_classifier_sequence();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "type", temp);
                      setParent(temp,ret,"type");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184193F9CE20A93F11DFC979C3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.SEQUENCE);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:534:4: ( 'Set' (temp= model_classifier_set ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:534:20: ( 'Set' (temp= model_classifier_set ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:534:21: 'Set' (temp= model_classifier_set )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184193FBA2E0A93F11DFAB69C3958D1505E2");
                    }
                    match(input,50,FOLLOW_50_in_ocl_expressions_collectionliteralexp1310); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184193FCB450A93F11DFBB04C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:534:160: (temp= model_classifier_set )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:534:162: temp= model_classifier_set
                    {
                    pushFollow(FOLLOW_model_classifier_set_in_ocl_expressions_collectionliteralexp1317);
                    temp=model_classifier_set();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "type", temp);
                      setParent(temp,ret,"type");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184193FED730A93F11DFBB9BC3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.SET);_exitInjectorAction();
                    }
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:536:4: ( 'Collection' (temp= model_classifier_collection ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:536:20: ( 'Collection' (temp= model_classifier_collection ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:536:21: 'Collection' (temp= model_classifier_collection )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841940084E0A93F11DF87D4C3958D1505E2");
                    }
                    match(input,32,FOLLOW_32_in_ocl_expressions_collectionliteralexp1336); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419401BD60A93F11DFCF2FC3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:536:167: (temp= model_classifier_collection )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:536:169: temp= model_classifier_collection
                    {
                    pushFollow(FOLLOW_model_classifier_collection_in_ocl_expressions_collectionliteralexp1343);
                    temp=model_classifier_collection();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "type", temp);
                      setParent(temp,ret,"type");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419403E040A93F11DF8186C3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.COLLECTION);_exitInjectorAction();
                    }
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:538:4: ( 'Bag' (temp= model_classifier_bag ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:538:20: ( 'Bag' (temp= model_classifier_bag ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:538:21: 'Bag' (temp= model_classifier_bag )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194058DF0A93F11DF97BDC3958D1505E2");
                    }
                    match(input,41,FOLLOW_41_in_ocl_expressions_collectionliteralexp1362); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419406C670A93F11DFADACC3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:538:160: (temp= model_classifier_bag )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:538:162: temp= model_classifier_bag
                    {
                    pushFollow(FOLLOW_model_classifier_bag_in_ocl_expressions_collectionliteralexp1369);
                    temp=model_classifier_bag();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "type", temp);
                      setParent(temp,ret,"type");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419408C240A93F11DFBF37C3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.BAG);_exitInjectorAction();
                    }
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:540:4: ( 'OrderedSet' (temp= model_classifier_orderedset ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:540:20: ( 'OrderedSet' (temp= model_classifier_orderedset ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:540:21: 'OrderedSet' (temp= model_classifier_orderedset )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841940A9700A93F11DFAF9DC3958D1505E2");
                    }
                    match(input,43,FOLLOW_43_in_ocl_expressions_collectionliteralexp1388); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841940BCF80A93F11DFC2F3C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:540:167: (temp= model_classifier_orderedset )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:540:169: temp= model_classifier_orderedset
                    {
                    pushFollow(FOLLOW_model_classifier_orderedset_in_ocl_expressions_collectionliteralexp1395);
                    temp=model_classifier_orderedset();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "type", temp);
                      setParent(temp,ret,"type");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B91841940DCB50A93F11DF8E06C3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.omg.ocl.expressions.CollectionKindEnum.ORDERED_SET);_exitInjectorAction();
                    }
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
              _beforeSeqEl("E0B918419411C2F0A93F11DFCD1FC3958D1505E2");
            }
            match(input,LCURL,FOLLOW_LCURL_in_ocl_expressions_collectionliteralexp1410); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194140CE0A93F11DFCAB6C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:541:422: (temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=NAME && LA10_0<=QNAME)||(LA10_0>=INT && LA10_0<=LPAREN)||LA10_0==32||LA10_0==35||LA10_0==38||(LA10_0>=40 && LA10_0<=41)||LA10_0==43||LA10_0==48||LA10_0==50) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:541:424: temp= ocl_expressions_collectionliteralpart ( ( ',' ) temp= ocl_expressions_collectionliteralpart )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp1418);
                    temp=ocl_expressions_collectionliteralpart();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "parts", temp);
                      setParent(temp,ret,"parts");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:542:31: ( ( ',' ) temp= ocl_expressions_collectionliteralpart )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==42) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:542:32: ( ',' ) temp= ocl_expressions_collectionliteralpart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:542:49: ( ',' )
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:542:50: ','
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("E0B9184194125F30A93F11DFA070C3958D1505E2");
                    	    }
                    	    match(input,42,FOLLOW_42_in_ocl_expressions_collectionliteralexp1426); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp1433);
                    	    temp=ocl_expressions_collectionliteralpart();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "parts", temp);
                    	      setParent(temp,ret,"parts");
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
              _beforeSeqEl("E0B918419414F740A93F11DFC33CC3958D1505E2");
            }
            match(input,RCURL,FOLLOW_RCURL_in_ocl_expressions_collectionliteralexp1445); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194167DE0A93F11DFC727C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.type.name.subString(1, -4+type.name.size()).concat('{...}')", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:551:1: model_classifier_sequence returns [Object ret2] : (ret= model_datatype_sequence ) ;
    public final Object model_classifier_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:552:3: ( (ret= model_datatype_sequence ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:553:3: (ret= model_datatype_sequence )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:553:3: (ret= model_datatype_sequence )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:553:4: ret= model_datatype_sequence
            {
            pushFollow(FOLLOW_model_datatype_sequence_in_model_classifier_sequence1486);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:560:1: model_datatype_sequence returns [Object ret2] : (ret= ocl_types_collectiontype_sequence ) ;
    public final Object model_datatype_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:561:3: ( (ret= ocl_types_collectiontype_sequence ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:562:3: (ret= ocl_types_collectiontype_sequence )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:562:3: (ret= ocl_types_collectiontype_sequence )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:562:4: ret= ocl_types_collectiontype_sequence
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_sequence_in_model_datatype_sequence1513);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:569:1: ocl_types_collectiontype_sequence returns [Object ret2] : (ret= ocl_types_sequencetype_sequence ) ;
    public final Object ocl_types_collectiontype_sequence() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:570:3: ( (ret= ocl_types_sequencetype_sequence ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:571:3: (ret= ocl_types_sequencetype_sequence )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:571:3: (ret= ocl_types_sequencetype_sequence )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:571:4: ret= ocl_types_sequencetype_sequence
            {
            pushFollow(FOLLOW_ocl_types_sequencetype_sequence_in_ocl_types_collectiontype_sequence1540);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:578:1: ocl_types_sequencetype_sequence returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_sequencetype_sequence() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Types","SequenceType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"sequence");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:584:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:585:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:585:3: ( collectiontypeelementtype[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:585:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194241270A93F11DFBA08C3958D1505E2");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_sequencetype_sequence1570);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194259910A93F11DFC9D9C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "SequenceType");_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:593:1: model_classifier_set returns [Object ret2] : (ret= model_datatype_set ) ;
    public final Object model_classifier_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:594:3: ( (ret= model_datatype_set ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:595:3: (ret= model_datatype_set )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:595:3: (ret= model_datatype_set )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:595:4: ret= model_datatype_set
            {
            pushFollow(FOLLOW_model_datatype_set_in_model_classifier_set1611);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:602:1: model_datatype_set returns [Object ret2] : (ret= ocl_types_collectiontype_set ) ;
    public final Object model_datatype_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:603:3: ( (ret= ocl_types_collectiontype_set ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:604:3: (ret= ocl_types_collectiontype_set )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:604:3: (ret= ocl_types_collectiontype_set )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:604:4: ret= ocl_types_collectiontype_set
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_set_in_model_datatype_set1638);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:611:1: ocl_types_collectiontype_set returns [Object ret2] : (ret= ocl_types_settype_set ) ;
    public final Object ocl_types_collectiontype_set() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:612:3: ( (ret= ocl_types_settype_set ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:613:3: (ret= ocl_types_settype_set )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:613:3: (ret= ocl_types_settype_set )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:613:4: ret= ocl_types_settype_set
            {
            pushFollow(FOLLOW_ocl_types_settype_set_in_ocl_types_collectiontype_set1665);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:620:1: ocl_types_settype_set returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_settype_set() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Types","SetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"set");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:626:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:627:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:627:3: ( collectiontypeelementtype[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:627:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194317FF0A93F11DF8BE5C3958D1505E2");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_settype_set1695);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194332DA0A93F11DF936AC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "SetType");_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:635:1: model_classifier_collection returns [Object ret2] : (ret= model_datatype_collection ) ;
    public final Object model_classifier_collection() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:636:3: ( (ret= model_datatype_collection ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:637:3: (ret= model_datatype_collection )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:637:3: (ret= model_datatype_collection )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:637:4: ret= model_datatype_collection
            {
            pushFollow(FOLLOW_model_datatype_collection_in_model_classifier_collection1736);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:644:1: model_datatype_collection returns [Object ret2] : (ret= ocl_types_collectiontype_collection ) ;
    public final Object model_datatype_collection() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:645:3: ( (ret= ocl_types_collectiontype_collection ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:646:3: (ret= ocl_types_collectiontype_collection )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:646:3: (ret= ocl_types_collectiontype_collection )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:646:4: ret= ocl_types_collectiontype_collection
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_collection_in_model_datatype_collection1763);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:653:1: ocl_types_collectiontype_collection returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_collectiontype_collection() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Types","CollectionType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"collection");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:659:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:660:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:660:3: ( collectiontypeelementtype[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:660:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841943C0740A93F11DF8183C3958D1505E2");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_collectiontype_collection1793);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841943D8DE0A93F11DF8153C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "CollectionType");_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:668:1: model_classifier_bag returns [Object ret2] : (ret= model_datatype_bag ) ;
    public final Object model_classifier_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:669:3: ( (ret= model_datatype_bag ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:670:3: (ret= model_datatype_bag )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:670:3: (ret= model_datatype_bag )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:670:4: ret= model_datatype_bag
            {
            pushFollow(FOLLOW_model_datatype_bag_in_model_classifier_bag1834);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:677:1: model_datatype_bag returns [Object ret2] : (ret= ocl_types_collectiontype_bag ) ;
    public final Object model_datatype_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:678:3: ( (ret= ocl_types_collectiontype_bag ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:679:3: (ret= ocl_types_collectiontype_bag )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:679:3: (ret= ocl_types_collectiontype_bag )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:679:4: ret= ocl_types_collectiontype_bag
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_bag_in_model_datatype_bag1861);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:686:1: ocl_types_collectiontype_bag returns [Object ret2] : (ret= ocl_types_bagtype_bag ) ;
    public final Object ocl_types_collectiontype_bag() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:687:3: ( (ret= ocl_types_bagtype_bag ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:688:3: (ret= ocl_types_bagtype_bag )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:688:3: (ret= ocl_types_bagtype_bag )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:688:4: ret= ocl_types_bagtype_bag
            {
            pushFollow(FOLLOW_ocl_types_bagtype_bag_in_ocl_types_collectiontype_bag1888);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:695:1: ocl_types_bagtype_bag returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_bagtype_bag() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Types","BagType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"bag");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:701:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:702:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:702:3: ( collectiontypeelementtype[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:702:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841944974C0A93F11DFBB5EC3958D1505E2");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_bagtype_bag1918);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841944AFB60A93F11DF87D3C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "BagType");_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:710:1: model_classifier_orderedset returns [Object ret2] : (ret= model_datatype_orderedset ) ;
    public final Object model_classifier_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:711:3: ( (ret= model_datatype_orderedset ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:712:3: (ret= model_datatype_orderedset )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:712:3: (ret= model_datatype_orderedset )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:712:4: ret= model_datatype_orderedset
            {
            pushFollow(FOLLOW_model_datatype_orderedset_in_model_classifier_orderedset1959);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:719:1: model_datatype_orderedset returns [Object ret2] : (ret= ocl_types_collectiontype_orderedset ) ;
    public final Object model_datatype_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:720:3: ( (ret= ocl_types_collectiontype_orderedset ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:721:3: (ret= ocl_types_collectiontype_orderedset )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:721:3: (ret= ocl_types_collectiontype_orderedset )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:721:4: ret= ocl_types_collectiontype_orderedset
            {
            pushFollow(FOLLOW_ocl_types_collectiontype_orderedset_in_model_datatype_orderedset1986);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:728:1: ocl_types_collectiontype_orderedset returns [Object ret2] : (ret= ocl_types_orderedsettype_orderedset ) ;
    public final Object ocl_types_collectiontype_orderedset() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:729:3: ( (ret= ocl_types_orderedsettype_orderedset ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:730:3: (ret= ocl_types_orderedsettype_orderedset )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:730:3: (ret= ocl_types_orderedsettype_orderedset )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:730:4: ret= ocl_types_orderedsettype_orderedset
            {
            pushFollow(FOLLOW_ocl_types_orderedsettype_orderedset_in_ocl_types_collectiontype_orderedset2013);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:737:1: ocl_types_orderedsettype_orderedset returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final Object ocl_types_orderedsettype_orderedset() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Types","OrderedSetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"orderedset");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:743:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:744:3: ( collectiontypeelementtype[ret] )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:744:3: ( collectiontypeelementtype[ret] )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:744:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194566D10A93F11DF9B1EC3958D1505E2");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_types_orderedsettype_orderedset2043);
            collectiontypeelementtype(ret);

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419457CCA0A93F11DFC436C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "OrderedSetType");_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:752:1: collectiontypeelementtype[Object ret] : () ;
    public final void collectiontypeelementtype(Object ret) throws RecognitionException {
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:753:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:754:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:754:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:754:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841945DE720A93F11DFB6B1C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "elementType", null, null, "OCL:#context(collectionliteral).oclAsType(CollectionLiteralExp).parts.type->iterate("+"  								t; acc:Moin::Model::Classifier=null |"+"  									if acc->isEmpty() or acc=t then"+"  										t "+"  									else "+"  										if t.allSupertypes()->includes(acc) then"+"  											acc "+"  										else "+"  											if acc.allSupertypes()->includes(t) then"+"  												t "+"  											else "+"  												null "+"  											endif"+"  										endif"+"  									endif)", true);_exitInjectorAction();
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:761:1: ocl_expressions_collectionliteralpart returns [Object ret2] : ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) ) ;
    public final Object ocl_expressions_collectionliteralpart() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:762:3: ( ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) )
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:4: ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:38: (ret= ocl_expressions_collectionitem )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:39: ret= ocl_expressions_collectionitem
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart2113);
                    ret=ocl_expressions_collectionitem();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }


                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:764:5: ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:764:40: (ret= ocl_expressions_collectionrange )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:764:41: ret= ocl_expressions_collectionrange
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart2127);
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:771:1: ocl_expressions_collectionitem returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_expressions_collectionitem() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","CollectionItem");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:777:3: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:778:3: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:778:3: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:778:4: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419462C920A93F11DF80BCC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:778:63: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:778:65: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionitem2162);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "item", temp);
              setParent(temp,ret,"item");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194649DE0A93F11DFBC0FC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.item.type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:787:1: ocl_expressions_collectionrange returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_expressions_collectionrange() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","CollectionRange");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:793:3: ( ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:794:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:794:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:794:4: (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194689580A93F11DFADA1C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:794:63: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:794:65: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange2212);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "first", temp);
              setParent(temp,ret,"first");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841946931C0A93F11DF869FC3958D1505E2");
            }
            match(input,DDOT,FOLLOW_DDOT_in_ocl_expressions_collectionrange2219); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419469CE00A93F11DFA302C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:795:187: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:795:189: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange2227);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "last", temp);
              setParent(temp,ret,"last");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841946BA2C0A93F11DF9F66C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:if self.first.type=self.last.type then"+"  	  						self.first.type "+"  	  					  else "+"  	  					  	if self.first.type.allSupertypes()->includes(self.last.type) then"+"  	  					  		self.last.type "+"  	  					  	else "+"  	  					  		if self.last.type.allSupertypes()->includes(self.first.type) then "+"  	  					  			self.first.type "+"  	  					  		else "+"  	  					  			null "+"  	  					  		endif "+"  	  					  	endif "+"  	  					  endif", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:804:1: ocl_expressions_collectionkind returns [Object ret2] : ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) ) ;
    public final Object ocl_expressions_collectionkind() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:805:3: ( ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:806:3: ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:806:3: ( ( 'Collection' ) | ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'OrderedSet' ) )
            int alt12=5;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt12=1;
                }
                break;
            case 50:
                {
                alt12=2;
                }
                break;
            case 41:
                {
                alt12=3;
                }
                break;
            case 40:
                {
                alt12=4;
                }
                break;
            case 43:
                {
                alt12=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:806:4: ( 'Collection' )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:806:4: ( 'Collection' )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:806:5: 'Collection'
                    {
                    match(input,32,FOLLOW_32_in_ocl_expressions_collectionkind2273); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Collection");
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:807:4: ( 'Set' )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:807:4: ( 'Set' )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:807:5: 'Set'
                    {
                    match(input,50,FOLLOW_50_in_ocl_expressions_collectionkind2281); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Set");
                    }

                    }
                    break;
                case 3 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:808:4: ( 'Bag' )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:808:4: ( 'Bag' )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:808:5: 'Bag'
                    {
                    match(input,41,FOLLOW_41_in_ocl_expressions_collectionkind2289); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Bag");
                    }

                    }
                    break;
                case 4 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:809:4: ( 'Sequence' )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:809:4: ( 'Sequence' )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:809:5: 'Sequence'
                    {
                    match(input,40,FOLLOW_40_in_ocl_expressions_collectionkind2297); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("OCL","Expressions","CollectionKind"), "Sequence");
                    }

                    }
                    break;
                case 5 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:810:4: ( 'OrderedSet' )
                    {
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:810:4: ( 'OrderedSet' )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:810:5: 'OrderedSet'
                    {
                    match(input,43,FOLLOW_43_in_ocl_expressions_collectionkind2305); if (state.failed) return ret2;

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:817:1: ocl_expressions_ifexp returns [Object ret2] : ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' ) ;
    public final Object ocl_expressions_ifexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","IfExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:823:3: ( ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:824:3: ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:824:3: ( 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:824:4: 'if' (temp= ocl_expressions_oclexpression ) 'then' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'else' ( ( (temp= ocl_expressions_oclexpression ) ) ) 'endif'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419471BD40A93F11DFB728C3958D1505E2");
            }
            match(input,48,FOLLOW_48_in_ocl_expressions_ifexp2335); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194725980A93F11DF9462C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:824:142: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:824:144: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp2342);
            temp=ocl_expressions_oclexpression();

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
              _beforeSeqEl("E0B918419472F5C0A93F11DF8FF6C3958D1505E2");
            }
            match(input,44,FOLLOW_44_in_ocl_expressions_ifexp2348); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841947518A0A93F11DFCC5BC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:825:191: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:825:192: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:825:192: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:825:193: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194739200A93F11DF82ABC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:825:252: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:825:254: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp2358);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "thenExpression", temp);
              setParent(temp,ret,"thenExpression");
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
              _beforeSeqEl("E0B9184194760300A93F11DF89F9C3958D1505E2");
            }
            match(input,37,FOLLOW_37_in_ocl_expressions_ifexp2367); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841947825E0A93F11DFCF5DC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:826:214: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:826:215: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:826:215: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:826:216: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194769F40A93F11DF838AC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:826:275: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:826:277: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp2377);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "elseExpression", temp);
              setParent(temp,ret,"elseExpression");
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
              _beforeSeqEl("E0B9184194791040A93F11DFCE09C3958D1505E2");
            }
            match(input,39,FOLLOW_39_in_ocl_expressions_ifexp2386); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841947C92B0A93F11DFCF67C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'if '.concat(self.condition.name)", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:if self.thenExpression.type=self.elseExpression.type then"+"  	                          self.thenExpression.type"+"  	                      else"+"  	                          if self.thenExpression.type.allSupertypes()->includes(self.elseExpression.type) then"+"  	                              self.elseExpression.type"+"  	                          else"+"  	                              if self.elseExpression.type.allSupertypes()->includes(self.thenExpression.type) then"+"  	                                  self.thenExpression.type"+"  	                              else"+"  	                                  null"+"  	                              endif"+"  	                          endif"+"  	                      endif", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:835:1: ocl_expressions_letexp returns [Object ret2] : ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) ;
    public final Object ocl_expressions_letexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","LetExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:841:3: ( ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:842:3: ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:842:3: ( 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:842:4: 'let' (temp= ocl_expressions_variabledeclaration_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419482FB50A93F11DFA5F7C3958D1505E2");
            }
            match(input,35,FOLLOW_35_in_ocl_expressions_letexp2429); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841948433D0A93F11DF9B4EC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:842:143: (temp= ocl_expressions_variabledeclaration_let )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:842:145: temp= ocl_expressions_variabledeclaration_let
            {
            pushFollow(FOLLOW_ocl_expressions_variabledeclaration_let_in_ocl_expressions_letexp2436);
            temp=ocl_expressions_variabledeclaration_let();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "variable", temp);
              setParent(temp,ret,"variable");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194854540A93F11DF9D72C3958D1505E2");
            }
            match(input,36,FOLLOW_36_in_ocl_expressions_letexp2442); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194871A00A93F11DF9C2FC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:843:188: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:843:189: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:843:189: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:843:190: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419485E180A93F11DF8552C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:843:249: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:843:251: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_letexp2452);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "in", temp);
              setParent(temp,ret,"in");
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
              _beforeSeqEl("E0B91841948A4E50A93F11DFA2ACC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.\"in\".type", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'let '.concat(self.variable.name)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:852:1: ocl_expressions_variabledeclaration_let returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) ) ;
    public final Object ocl_expressions_variabledeclaration_let() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        onEnterTemplateRule(metaType,"let");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:858:3: ( ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:859:3: ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:859:3: ( (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:859:4: (temp= identifier ) ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841948FCC90A93F11DF8034C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:859:63: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:859:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let2505);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "varName", temp);
              setParent(temp,ret,"varName");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841949C28A0A93F11DF9AA4C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:860:108: ( () | ( COLON (temp= qualifiedNameSymbol ) ) | ( COLON (temp= identifier ) ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==33) ) {
                alt13=1;
            }
            else if ( (LA13_0==COLON) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==QNAME) ) {
                    alt13=2;
                }
                else if ( (LA13_2==NAME) ) {
                    alt13=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ret2;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:860:109: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:860:125: ()
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:860:126: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419491A150A93F11DFA995C3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.initExpression.type", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:861:4: ( COLON (temp= qualifiedNameSymbol ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:861:20: ( COLON (temp= qualifiedNameSymbol ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:861:21: COLON (temp= qualifiedNameSymbol )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419492D9D0A93F11DF87D7C3958D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let2530); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B918419494FCB0A93F11DFC4AFC3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:861:162: (temp= qualifiedNameSymbol )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:861:164: temp= qualifiedNameSymbol
                    {
                    pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration_let2538);
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:20: ( COLON (temp= identifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194976DB0A93F11DF9C78C3958D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let2555); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194999090A93F11DFAC71C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:162: (temp= identifier )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:164: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let2563);
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
              _beforeSeqEl("E0B91841949D8830A93F11DFA049C3958D1505E2");
            }
            match(input,33,FOLLOW_33_in_ocl_expressions_variabledeclaration_let2574); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841949EE7C0A93F11DF88CCC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:459: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:862:461: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration_let2581);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "initExpression", temp);
              setParent(temp,ret,"initExpression");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194A131B0A93F11DF9CE8C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.varName", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:871:1: ocl_expressions_variabledeclaration returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) ) ;
    public final Object ocl_expressions_variabledeclaration() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:877:3: ( ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:878:3: ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:878:3: ( (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:878:4: (temp= identifier ) ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194A6AFF0A93F11DFC95EC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:878:63: (temp= identifier )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:878:65: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration2631);
            temp=identifier();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "varName", temp);
              setParent(temp,ret,"varName");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194A85DA0A93F11DF9636C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.varName", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194B57D00A93F11DFAD93C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:879:291: ( () | ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NAME||(LA15_0>=33 && LA15_0<=34)||LA15_0==46) ) {
                alt15=1;
            }
            else if ( (LA15_0==COLON) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:879:292: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:879:308: ()
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:879:309: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194AA3260A93F11DFCF96C3958D1505E2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:#context(propertyCallExp).oclAsType(PropertyCallExp).source.type", true);_exitInjectorAction();
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:4: ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:20: ( COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:21: COLON ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194AB6AE0A93F11DFB19BC3958D1505E2");
                    }
                    match(input,COLON,FOLLOW_COLON_in_ocl_expressions_variabledeclaration2659); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194B38130A93F11DFB102C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:162: ( ( (temp= qualifiedNameSymbol ) ) | ( (temp= identifier ) ) )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==QNAME) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==NAME) ) {
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
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:163: ( (temp= qualifiedNameSymbol ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:179: ( (temp= qualifiedNameSymbol ) )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:180: (temp= qualifiedNameSymbol )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B9184194AD8DC0A93F11DFC3ABC3958D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:239: (temp= qualifiedNameSymbol )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:880:241: temp= qualifiedNameSymbol
                            {
                            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration2672);
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
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:4: ( (temp= identifier ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:20: ( (temp= identifier ) )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:21: (temp= identifier )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("E0B9184194B15E50A93F11DFA248C3958D1505E2");
                            }
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:80: (temp= identifier )
                            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:82: temp= identifier
                            {
                            pushFollow(FOLLOW_identifier_in_ocl_expressions_variabledeclaration2692);
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
              _beforeSeqEl("E0B9184194B9E9D0A93F11DF97FAC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:332: ( ( '=' (temp= ocl_expressions_oclexpression ) ) | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==33) ) {
                alt16=1;
            }
            else if ( (LA16_0==NAME||LA16_0==34||LA16_0==46) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:333: ( '=' (temp= ocl_expressions_oclexpression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:349: ( '=' (temp= ocl_expressions_oclexpression ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:350: '=' (temp= ocl_expressions_oclexpression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194B7EE00A93F11DF87D3C3958D1505E2");
                    }
                    match(input,33,FOLLOW_33_in_ocl_expressions_variabledeclaration2714); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194B88A40A93F11DF9F46C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:487: (temp= ocl_expressions_oclexpression )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:881:489: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration2721);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "initExpression", temp);
                      setParent(temp,ret,"initExpression");
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:882:74: 
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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:891:1: ocl_expressions_variableexp returns [Object ret2] : ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) ) ;
    public final Object ocl_expressions_variableexp() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","VariableExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:897:3: ( ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:3: ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:3: ( ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:4: ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194C35FB0A93F11DFCCF6C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:63: ( ( (temp= ocl_expressions_variabledeclaration_self ) ) | ( (temp= identifier ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            else if ( (LA17_0==NAME) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:64: ( (temp= ocl_expressions_variabledeclaration_self ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:80: ( (temp= ocl_expressions_variabledeclaration_self ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:81: (temp= ocl_expressions_variabledeclaration_self )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194BF6810A93F11DFC19BC3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:140: (temp= ocl_expressions_variabledeclaration_self )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:898:142: temp= ocl_expressions_variabledeclaration_self
                    {
                    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_self_in_ocl_expressions_variableexp2786);
                    temp=ocl_expressions_variabledeclaration_self();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "referredVariable", temp);
                      setParent(temp,ret,"referredVariable");
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:900:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:900:20: ( (temp= identifier ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:900:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194C1D910A93F11DF8D1FC3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:900:80: (temp= identifier )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:900:82: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_expressions_variableexp2806);
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
              _beforeSeqEl("E0B9184194C6E220A93F11DFC197C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.referredVariable.type", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredVariable.name", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:908:1: ocl_expressions_variabledeclaration_self returns [Object ret2] : ( 'self' ) ;
    public final Object ocl_expressions_variabledeclaration_self() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"self");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:914:3: ( ( 'self' ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:915:3: ( 'self' )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:915:3: ( 'self' )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:915:4: 'self'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194CA8BA0A93F11DF9E25C3958D1505E2");
            }
            match(input,38,FOLLOW_38_in_ocl_expressions_variabledeclaration_self2857); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194CE8340A93F11DFC053C3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "self");_exitInjectorAction();_enterInjectorAction();setProperty(ret, "varName", "self");_exitInjectorAction();_enterInjectorAction();setRef(ret, "type", list("Model","Classifier"), null, null, "#context(class)", null, null, false, null, true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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


    // $ANTLR start "ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:923:1: ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN ) ;
    public final Object ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","IterateExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:928:3: ( ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:929:3: ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:929:3: ( 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:929:4: 'iterate' LPAREN (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* ) ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) ) '|' (temp= ocl_expressions_oclexpression ) RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194D40180A93F11DF85CDC3958D1505E2");
            }
            match(input,45,FOLLOW_45_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2901); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194D44FA0A93F11DFBDD1C3958D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2905); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194D4EBE0A93F11DFC759C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:929:230: (temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )* )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:929:232: temp= ocl_expressions_variabledeclaration (temp= ocl_expressions_variabledeclaration )*
            {
            pushFollow(FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2913);
            temp=ocl_expressions_variabledeclaration();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "iterators", temp);
              setParent(temp,ret,"iterators");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:930:35: (temp= ocl_expressions_variabledeclaration )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==NAME) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:930:37: temp= ocl_expressions_variabledeclaration
            	    {
            	    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2921);
            	    temp=ocl_expressions_variabledeclaration();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "iterators", temp);
            	      setParent(temp,ret,"iterators");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194DA4310A93F11DFC38FC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:931:113: ( ( ';' (temp= ocl_expressions_variabledeclaration ) ) | ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==46) ) {
                alt19=1;
            }
            else if ( (LA19_0==34) ) {
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:931:114: ( ';' (temp= ocl_expressions_variabledeclaration ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:931:130: ( ';' (temp= ocl_expressions_variabledeclaration ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:931:131: ';' (temp= ocl_expressions_variabledeclaration )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194D58820A93F11DFA0F8C3958D1505E2");
                    }
                    match(input,46,FOLLOW_46_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2935); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194D64B70A93F11DF8775C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:931:268: (temp= ocl_expressions_variabledeclaration )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:931:270: temp= ocl_expressions_variabledeclaration
                    {
                    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2942);
                    temp=ocl_expressions_variabledeclaration();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "result", temp);
                      setParent(temp,ret,"result");
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
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:933:4: ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:933:20: ( (temp= ocl_expressions_variabledeclaration_implicitAccumulator ) )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:933:21: (temp= ocl_expressions_variabledeclaration_implicitAccumulator )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("E0B9184194D8BC70A93F11DF94B8C3958D1505E2");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:933:80: (temp= ocl_expressions_variabledeclaration_implicitAccumulator )
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:933:82: temp= ocl_expressions_variabledeclaration_implicitAccumulator
                    {
                    pushFollow(FOLLOW_ocl_expressions_variabledeclaration_implicitAccumulator_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2962);
                    temp=ocl_expressions_variabledeclaration_implicitAccumulator();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "result", temp);
                      setParent(temp,ret,"result");
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
              _beforeSeqEl("E0B9184194DB2D70A93F11DFB50CC3958D1505E2");
            }
            match(input,34,FOLLOW_34_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2973); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194DBC9B0A93F11DF9B18C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:934:217: (temp= ocl_expressions_oclexpression )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:934:219: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2980);
            temp=ocl_expressions_oclexpression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "body", temp);
              setParent(temp,ret,"body");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194DC8D00A93F11DFA756C3958D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2987); if (state.failed) return ret2;
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
    // $ANTLR end "ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp"


    // $ANTLR start "ocl_expressions_variabledeclaration_implicitAccumulator"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:946:1: ocl_expressions_variabledeclaration_implicitAccumulator returns [Object ret2] : () ;
    public final Object ocl_expressions_variabledeclaration_implicitAccumulator() throws RecognitionException {
        Object ret2 = null;

        IModelElementProxy ret;
        List<String> metaType=list("OCL","Expressions","VariableDeclaration");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"implicitAccumulator");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:952:3: ( () )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:953:3: ()
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:953:3: ()
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:953:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194E4CA60A93F11DFC07DC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "acc");_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:#context(propertyCallExp).oclAsType(IterateExp).\"body\".type", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

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


    // $ANTLR start "ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:961:1: ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword ) ) ;
    public final Object ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","AttributeCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:966:3: ( ( (temp= identifierOrKeyword ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:967:3: ( (temp= identifierOrKeyword ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:967:3: ( (temp= identifierOrKeyword ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:967:4: (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194EB3300A93F11DF976DC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:967:63: (temp= identifierOrKeyword )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:967:65: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp3065);
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
              _beforeSeqEl("E0B9184194EF2AA0A93F11DF907CC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredAttribute.name", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.referredAttribute.type", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp"


    // $ANTLR start "ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:978:1: ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword ) ) ;
    public final Object ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","AssociationEndCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:983:3: ( ( (temp= identifierOrKeyword ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:984:3: ( (temp= identifierOrKeyword ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:984:3: ( (temp= identifierOrKeyword ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:984:4: (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194F6F2D0A93F11DF9B9AC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:984:63: (temp= identifierOrKeyword )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:984:65: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp3108);
            temp=identifierOrKeyword();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredAssociationEnd", null, temp, "OCL:self.source.type.allSupertypes()->append(self.source.type)."+"  												contents->select(a | a.oclIsKindOf(Reference))->select(a|a.name=?).oclAsType(Reference).referencedEnd");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B9184194FAEA70A93F11DFA50EC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredAssociationEnd.name", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.referredAssociationEnd.type", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp"


    // $ANTLR start "ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp"
    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:995:1: ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) ) ;
    public final Object ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("OCL","Expressions","OperationCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1000:3: ( ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:3: ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) )
            {
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:3: ( ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:4: ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841950B1710A93F11DFAA22C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:63: ( ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN ) )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:64: ( identifier LPAREN )=> ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN )
            {
            if ( state.backtracking==0 ) {
              _enterAlt(0);
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:103: ( (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:104: (temp= identifierOrKeyword ) LPAREN (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419502B2A0A93F11DFB21CC3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:163: (temp= identifierOrKeyword )
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:165: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3164);
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
              _beforeSeqEl("E0B9184195043940A93F11DF8D71C3958D1505E2");
            }
            match(input,LPAREN,FOLLOW_LPAREN_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3171); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B918419504D580A93F11DFA9B8C3958D1505E2");
            }
            // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:549: (temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=NAME && LA21_0<=QNAME)||(LA21_0>=INT && LA21_0<=LPAREN)||LA21_0==32||LA21_0==35||LA21_0==38||(LA21_0>=40 && LA21_0<=41)||LA21_0==43||LA21_0==48||LA21_0==50) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1001:551: temp= ocl_expressions_oclexpression (temp= ocl_expressions_oclexpression )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3179);
                    temp=ocl_expressions_oclexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "arguments", temp);
                      setParent(temp,ret,"arguments");
                    }
                    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1002:35: (temp= ocl_expressions_oclexpression )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( ((LA20_0>=NAME && LA20_0<=QNAME)||(LA20_0>=INT && LA20_0<=LPAREN)||LA20_0==32||LA20_0==35||LA20_0==38||(LA20_0>=40 && LA20_0<=41)||LA20_0==43||LA20_0==48||LA20_0==50) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:1002:37: temp= ocl_expressions_oclexpression
                    	    {
                    	    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3187);
                    	    temp=ocl_expressions_oclexpression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "arguments", temp);
                    	      setParent(temp,ret,"arguments");
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841950571C0A93F11DFB9E7C3958D1505E2");
            }
            match(input,RPAREN,FOLLOW_RPAREN_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3199); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("E0B91841950830E0A93F11DF970FC3958D1505E2");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredOperation.name.concat('(...)')", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.referredOperation.contents->select(p |"+"  	       			p.oclIsKindOf(Moin::Model::Parameter))->select(p |"+"  	       					p.oclAsType(Moin::Model::Parameter).direction = DirectionKind::return_dir)."+"  	       					oclAsType(Moin::Model::Parameter).type", true);_exitInjectorAction();
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
    // $ANTLR end "ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp"

    // $ANTLR start synpred1_OCL
    public final void synpred1_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:50: ( ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) ) )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:51: ( '.' ) ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) )
        {
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:51: ( '.' )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:52: '.'
        {
        match(input,47,FOLLOW_47_in_synpred1_OCL700); if (state.failed) return ;

        }

        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:56: ( ( identifier ~ LPAREN ) | ( identifier LPAREN ) )
        int alt22=2;
        int LA22_0 = input.LA(1);

        if ( (LA22_0==NAME) ) {
            int LA22_1 = input.LA(2);

            if ( (LA22_1==LPAREN) ) {
                alt22=2;
            }
            else if ( ((LA22_1>=NAME && LA22_1<=BOOL)||(LA22_1>=RPAREN && LA22_1<=50)) ) {
                alt22=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 1, input);

                throw nvae;
            }
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 22, 0, input);

            throw nvae;
        }
        switch (alt22) {
            case 1 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:57: ( identifier ~ LPAREN )
                {
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:57: ( identifier ~ LPAREN )
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:58: identifier ~ LPAREN
                {
                pushFollow(FOLLOW_identifier_in_synpred1_OCL704);
                identifier();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                if ( (input.LA(1)>=NAME && input.LA(1)<=BOOL)||(input.LA(1)>=RPAREN && input.LA(1)<=50) ) {
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
                break;
            case 2 :
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:78: ( identifier LPAREN )
                {
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:78: ( identifier LPAREN )
                // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:79: identifier LPAREN
                {
                pushFollow(FOLLOW_identifier_in_synpred1_OCL711);
                identifier();

                checkFollows();
                state._fsp--;
                if (state.failed) return ;
                match(input,LPAREN,FOLLOW_LPAREN_in_synpred1_OCL713); if (state.failed) return ;

                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred1_OCL

    // $ANTLR start synpred2_OCL
    public final void synpred2_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:183: ( identifier ~ LPAREN )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:373:184: identifier ~ LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred2_OCL726);
        identifier();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        if ( (input.LA(1)>=NAME && input.LA(1)<=BOOL)||(input.LA(1)>=RPAREN && input.LA(1)<=50) ) {
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
    // $ANTLR end synpred2_OCL

    // $ANTLR start synpred3_OCL
    public final void synpred3_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:383:3: ( identifier LPAREN )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:383:4: identifier LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred3_OCL756);
        identifier();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred3_OCL758); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_OCL

    // $ANTLR start synpred4_OCL
    public final void synpred4_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:3: ( ( '->' ) () )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:4: ( '->' ) ()
        {
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:4: ( '->' )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:5: '->'
        {
        match(input,49,FOLLOW_49_in_synpred4_OCL775); if (state.failed) return ;

        }

        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:10: ()
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:384:11: 
        {
        }


        }
    }
    // $ANTLR end synpred4_OCL

    // $ANTLR start synpred5_OCL
    public final void synpred5_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:4: ( ocl_expressions_collectionitem )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:763:5: ocl_expressions_collectionitem
        {
        pushFollow(FOLLOW_ocl_expressions_collectionitem_in_synpred5_OCL2107);
        ocl_expressions_collectionitem();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_OCL

    // $ANTLR start synpred6_OCL
    public final void synpred6_OCL_fragment() throws RecognitionException {   
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:764:5: ( ocl_expressions_collectionrange )
        // C:\\_fzi\\projects\\CTS\\git\\DSLEngineering\\com.sap.tc.moin.tcs.mof.editor\\generated\\generated\\OCL.g:764:6: ocl_expressions_collectionrange
        {
        pushFollow(FOLLOW_ocl_expressions_collectionrange_in_synpred6_OCL2121);
        ocl_expressions_collectionrange();

        checkFollows();
        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_OCL

    // Delegated rules

    public final boolean synpred2_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_OCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_OCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_OCL_fragment(); // can never throw exception
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
    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA3_eotS =
        "\41\uffff";
    static final String DFA3_eofS =
        "\1\25\40\uffff";
    static final String DFA3_minS =
        "\1\4\24\0\14\uffff";
    static final String DFA3_maxS =
        "\1\62\24\0\14\uffff";
    static final String DFA3_acceptS =
        "\25\uffff\1\2\11\uffff\1\1\1\3";
    static final String DFA3_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\14\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1\2\25\1\uffff\5\25\2\uffff\2\25\17\uffff\1\2\1\3\1\4\1"+
            "\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21"+
            "\1\22\1\23\1\24",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            "",
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
            return "373:182: ( ( identifier ~ LPAREN )=> ( ( (temp= identifierOrKeyword ) ) ) | | ( identifier LPAREN )=> (ret= ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp[opName, ret, firstToken] ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_1 = input.LA(1);

                         
                        int index3_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA3_2 = input.LA(1);

                         
                        int index3_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA3_3 = input.LA(1);

                         
                        int index3_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA3_4 = input.LA(1);

                         
                        int index3_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA3_5 = input.LA(1);

                         
                        int index3_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA3_6 = input.LA(1);

                         
                        int index3_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA3_7 = input.LA(1);

                         
                        int index3_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA3_8 = input.LA(1);

                         
                        int index3_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA3_9 = input.LA(1);

                         
                        int index3_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA3_10 = input.LA(1);

                         
                        int index3_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA3_11 = input.LA(1);

                         
                        int index3_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA3_12 = input.LA(1);

                         
                        int index3_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA3_13 = input.LA(1);

                         
                        int index3_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA3_14 = input.LA(1);

                         
                        int index3_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA3_15 = input.LA(1);

                         
                        int index3_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA3_16 = input.LA(1);

                         
                        int index3_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA3_17 = input.LA(1);

                         
                        int index3_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA3_18 = input.LA(1);

                         
                        int index3_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA3_19 = input.LA(1);

                         
                        int index3_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA3_20 = input.LA(1);

                         
                        int index3_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_OCL()) ) {s = 31;}

                        else if ( (true) ) {s = 21;}

                        else if ( (synpred3_OCL()) ) {s = 32;}

                         
                        input.seek(index3_20);
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
    static final String DFA11_eotS =
        "\22\uffff";
    static final String DFA11_eofS =
        "\22\uffff";
    static final String DFA11_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA11_maxS =
        "\1\62\17\0\2\uffff";
    static final String DFA11_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA11_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\2\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\16\1\5\1\7\1\uffff\1\3\1\4\1\6\1\17\24\uffff\1\12\2\uffff"+
            "\1\1\2\uffff\1\15\1\uffff\1\10\1\13\1\uffff\1\14\4\uffff\1\2"+
            "\1\uffff\1\11",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "763:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_expressions_collectionitem ) | ( ocl_expressions_collectionrange )=> (ret= ocl_expressions_collectionrange ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA11_8 = input.LA(1);

                         
                        int index11_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA11_9 = input.LA(1);

                         
                        int index11_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA11_10 = input.LA(1);

                         
                        int index11_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA11_11 = input.LA(1);

                         
                        int index11_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA11_12 = input.LA(1);

                         
                        int index11_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA11_13 = input.LA(1);

                         
                        int index11_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA11_14 = input.LA(1);

                         
                        int index11_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA11_15 = input.LA(1);

                         
                        int index11_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_OCL()) ) {s = 16;}

                        else if ( (synpred6_OCL()) ) {s = 17;}

                         
                        input.seek(index11_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
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
    public static final BitSet FOLLOW_STRING_in_stringSymbol277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsString432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsString463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanValueSymbol525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_main584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_letexp_in_primary_ocl_expressions_oclexpression615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_ifexp_in_primary_ocl_expressions_oclexpression623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_literalexp_in_primary_ocl_expressions_oclexpression631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variableexp_in_primary_ocl_expressions_oclexpression639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression648 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression654 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0696 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_47_in_oclexpressions_priority_0721 = new BitSet(new long[]{0x0007FFFF00000012L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_oclexpressions_priority_0739 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp_in_oclexpressions_priority_0764 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_49_in_oclexpressions_priority_0784 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp_in_oclexpressions_priority_0791 = new BitSet(new long[]{0x0002800000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_primitiveliteralexp_in_ocl_expressions_literalexp893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_enumliteralexp_in_ocl_expressions_literalexp901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralexp_in_ocl_expressions_literalexp909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_numericliteralexp_in_ocl_expressions_primitiveliteralexp936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_stringliteralexp_in_ocl_expressions_primitiveliteralexp944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_booleanliteralexp_in_ocl_expressions_primitiveliteralexp952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_integerliteralexp_in_ocl_expressions_numericliteralexp979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_realliteralexp_in_ocl_expressions_numericliteralexp987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerAsString_in_ocl_expressions_integerliteralexp1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringSymbol_in_ocl_expressions_stringliteralexp1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_floatAsString_in_ocl_expressions_realliteralexp1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValueSymbol_in_ocl_expressions_booleanliteralexp1171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_expressions_enumliteralexp1221 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_DCOLON_in_ocl_expressions_enumliteralexp1228 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_enumliteralexp1236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ocl_expressions_collectionliteralexp1284 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_sequence_in_ocl_expressions_collectionliteralexp1291 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_50_in_ocl_expressions_collectionliteralexp1310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_set_in_ocl_expressions_collectionliteralexp1317 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_32_in_ocl_expressions_collectionliteralexp1336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_collection_in_ocl_expressions_collectionliteralexp1343 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_41_in_ocl_expressions_collectionliteralexp1362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_bag_in_ocl_expressions_collectionliteralexp1369 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_43_in_ocl_expressions_collectionliteralexp1388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_model_classifier_orderedset_in_ocl_expressions_collectionliteralexp1395 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_LCURL_in_ocl_expressions_collectionliteralexp1410 = new BitSet(new long[]{0x00050B4900008F70L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp1418 = new BitSet(new long[]{0x0000040000008000L});
    public static final BitSet FOLLOW_42_in_ocl_expressions_collectionliteralexp1426 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_expressions_collectionliteralexp1433 = new BitSet(new long[]{0x0000040000008000L});
    public static final BitSet FOLLOW_RCURL_in_ocl_expressions_collectionliteralexp1445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_sequence_in_model_classifier_sequence1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_sequence_in_model_datatype_sequence1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_sequencetype_sequence_in_ocl_types_collectiontype_sequence1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_sequencetype_sequence1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_set_in_model_classifier_set1611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_set_in_model_datatype_set1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_settype_set_in_ocl_types_collectiontype_set1665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_settype_set1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_collection_in_model_classifier_collection1736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_collection_in_model_datatype_collection1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_collectiontype_collection1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_bag_in_model_classifier_bag1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_bag_in_model_datatype_bag1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_bagtype_bag_in_ocl_types_collectiontype_bag1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_bagtype_bag1918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_model_datatype_orderedset_in_model_classifier_orderedset1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_collectiontype_orderedset_in_model_datatype_orderedset1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_types_orderedsettype_orderedset_in_ocl_types_collectiontype_orderedset2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_types_orderedsettype_orderedset2043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart2113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionitem2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange2212 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DDOT_in_ocl_expressions_collectionrange2219 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_collectionrange2227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ocl_expressions_collectionkind2273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ocl_expressions_collectionkind2281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ocl_expressions_collectionkind2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ocl_expressions_collectionkind2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ocl_expressions_collectionkind2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ocl_expressions_ifexp2335 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp2342 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ocl_expressions_ifexp2348 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp2358 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ocl_expressions_ifexp2367 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_ifexp2377 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ocl_expressions_ifexp2386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ocl_expressions_letexp2429 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_let_in_ocl_expressions_letexp2436 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ocl_expressions_letexp2442 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_letexp2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let2505 = new BitSet(new long[]{0x0000000200020000L});
    public static final BitSet FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let2530 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration_let2538 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_COLON_in_ocl_expressions_variabledeclaration_let2555 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration_let2563 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ocl_expressions_variabledeclaration_let2574 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration_let2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration2631 = new BitSet(new long[]{0x0000000200020002L});
    public static final BitSet FOLLOW_COLON_in_ocl_expressions_variabledeclaration2659 = new BitSet(new long[]{0x0000004000000050L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_expressions_variabledeclaration2672 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variabledeclaration2692 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_ocl_expressions_variabledeclaration2714 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_variabledeclaration2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_self_in_ocl_expressions_variableexp2786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_expressions_variableexp2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ocl_expressions_variabledeclaration_self2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2901 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2905 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2913 = new BitSet(new long[]{0x0000404400000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2921 = new BitSet(new long[]{0x0000404400000010L});
    public static final BitSet FOLLOW_46_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2935 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2942 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ocl_expressions_variabledeclaration_implicitAccumulator_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2962 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2973 = new BitSet(new long[]{0x00050B4900000F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2980 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_expressions_iterateexp_OCL_Expressions_IterateExp_arrowOp2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_expressions_attributecallexp_OCL_Expressions_AttributeCallExp_dotOp3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_expressions_associationendcallexp_OCL_Expressions_AssociationEndCallExp_dotOp3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3164 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3171 = new BitSet(new long[]{0x00050B4900001F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3179 = new BitSet(new long[]{0x00050B4900001F70L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3187 = new BitSet(new long[]{0x00050B4900001F70L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_expressions_operationcallexp_OCL_Expressions_OperationCallExp_dotOp3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_synpred1_OCL700 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_identifier_in_synpred1_OCL704 = new BitSet(new long[]{0x0007FFFFFFFFF7F0L});
    public static final BitSet FOLLOW_set_in_synpred1_OCL706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred1_OCL711 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_synpred1_OCL713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred2_OCL726 = new BitSet(new long[]{0x0007FFFFFFFFF7F0L});
    public static final BitSet FOLLOW_set_in_synpred2_OCL728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_synpred3_OCL756 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_LPAREN_in_synpred3_OCL758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_synpred4_OCL775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_synpred5_OCL2107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_synpred6_OCL2121 = new BitSet(new long[]{0x0000000000000002L});

}