// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g 2011-02-07 13:18:30

package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.runtime.parser.impl.SemanticDisambRuleData;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
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

import org.antlr.runtime.tree.*;

public class OCLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SNAME", "NAME", "STRING", "QNAME", "MULTI_LINE_COMMENT", "INT", "FLOAT", "BOOL", "LPAREN", "RPAREN", "DCOLON", "LCURL", "COMMA", "RCURL", "DDOT", "COLON", "COMMENT", "LBRACK_LCURL", "LBRACKET", "RCURL_RBRACK", "STAR", "LCURL_LBRACK", "RBRACKET", "RBRACK_RCURL", "NL", "WS", "DIGIT", "ALPHA", "RANGE_OR_INT", "'then'", "'Bag'", "';'", "'self'", "'.'", "'collect'", "'='", "'iterate'", "'|'", "'in'", "'OrderedSet'", "'Sequence'", "'else'", "'\\''", "'let'", "'endif'", "'Set'", "'forAll'", "'if'", "'Collection'", "'->'"
    };
    public static final int STAR=24;
    public static final int RBRACK_RCURL=27;
    public static final int FLOAT=10;
    public static final int EOF=-1;
    public static final int LPAREN=12;
    public static final int LBRACKET=22;
    public static final int RPAREN=13;
    public static final int NAME=5;
    public static final int DCOLON=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int COMMA=16;
    public static final int LBRACK_LCURL=21;
    public static final int DIGIT=30;
    public static final int NL=28;
    public static final int RANGE_OR_INT=32;
    public static final int RBRACKET=26;
    public static final int COMMENT=20;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int RCURL_RBRACK=23;
    public static final int T__43=43;
    public static final int LCURL_LBRACK=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int DDOT=18;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int BOOL=11;
    public static final int INT=9;
    public static final int MULTI_LINE_COMMENT=8;
    public static final int ALPHA=31;
    public static final int COLON=19;
    public static final int LCURL=15;
    public static final int WS=29;
    public static final int T__33=33;
    public static final int QNAME=7;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int SNAME=4;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RCURL=17;
    public static final int STRING=6;

    // delegates
    // delegators


        public OCLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public OCLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OCLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g"; }


       private static final String syntaxUUID = "OCL";
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



    public static class identifier_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifier"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:208:1: identifier returns [Object ret2] : ( SNAME ) ;
    public final OCLParser.identifier_return identifier() throws RecognitionException {
        OCLParser.identifier_return retval = new OCLParser.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SNAME1=null;

        Object SNAME1_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:209:3: ( ( SNAME ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:210:3: ( SNAME )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:210:3: ( SNAME )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:210:4: SNAME
            {
            SNAME1=(Token)match(input,SNAME,FOLLOW_SNAME_in_identifier61); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SNAME1_tree = (Object)adaptor.create(SNAME1);
            adaptor.addChild(root_0, SNAME1_tree);
            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    public static class identifierOrKeyword_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifierOrKeyword"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:217:1: identifierOrKeyword returns [Object ret2] : (ast= NAME | 'then' | 'Bag' | ';' | 'self' | '.' | 'collect' | '=' | 'iterate' | '|' | 'in' | 'OrderedSet' | 'Sequence' | 'else' | '\\'' | 'let' | 'endif' | 'Set' | 'forAll' | 'if' | 'Collection' | '->' ) ;
    public final OCLParser.identifierOrKeyword_return identifierOrKeyword() throws RecognitionException {
        OCLParser.identifierOrKeyword_return retval = new OCLParser.identifierOrKeyword_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;
        Token string_literal2=null;
        Token string_literal3=null;
        Token char_literal4=null;
        Token string_literal5=null;
        Token char_literal6=null;
        Token string_literal7=null;
        Token char_literal8=null;
        Token string_literal9=null;
        Token char_literal10=null;
        Token string_literal11=null;
        Token string_literal12=null;
        Token string_literal13=null;
        Token string_literal14=null;
        Token char_literal15=null;
        Token string_literal16=null;
        Token string_literal17=null;
        Token string_literal18=null;
        Token string_literal19=null;
        Token string_literal20=null;
        Token string_literal21=null;
        Token string_literal22=null;

        Object ast_tree=null;
        Object string_literal2_tree=null;
        Object string_literal3_tree=null;
        Object char_literal4_tree=null;
        Object string_literal5_tree=null;
        Object char_literal6_tree=null;
        Object string_literal7_tree=null;
        Object char_literal8_tree=null;
        Object string_literal9_tree=null;
        Object char_literal10_tree=null;
        Object string_literal11_tree=null;
        Object string_literal12_tree=null;
        Object string_literal13_tree=null;
        Object string_literal14_tree=null;
        Object char_literal15_tree=null;
        Object string_literal16_tree=null;
        Object string_literal17_tree=null;
        Object string_literal18_tree=null;
        Object string_literal19_tree=null;
        Object string_literal20_tree=null;
        Object string_literal21_tree=null;
        Object string_literal22_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:218:3: ( (ast= NAME | 'then' | 'Bag' | ';' | 'self' | '.' | 'collect' | '=' | 'iterate' | '|' | 'in' | 'OrderedSet' | 'Sequence' | 'else' | '\\'' | 'let' | 'endif' | 'Set' | 'forAll' | 'if' | 'Collection' | '->' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:219:3: (ast= NAME | 'then' | 'Bag' | ';' | 'self' | '.' | 'collect' | '=' | 'iterate' | '|' | 'in' | 'OrderedSet' | 'Sequence' | 'else' | '\\'' | 'let' | 'endif' | 'Set' | 'forAll' | 'if' | 'Collection' | '->' )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:219:3: (ast= NAME | 'then' | 'Bag' | ';' | 'self' | '.' | 'collect' | '=' | 'iterate' | '|' | 'in' | 'OrderedSet' | 'Sequence' | 'else' | '\\'' | 'let' | 'endif' | 'Set' | 'forAll' | 'if' | 'Collection' | '->' )
            int alt1=22;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt1=1;
                }
                break;
            case 33:
                {
                alt1=2;
                }
                break;
            case 34:
                {
                alt1=3;
                }
                break;
            case 35:
                {
                alt1=4;
                }
                break;
            case 36:
                {
                alt1=5;
                }
                break;
            case 37:
                {
                alt1=6;
                }
                break;
            case 38:
                {
                alt1=7;
                }
                break;
            case 39:
                {
                alt1=8;
                }
                break;
            case 40:
                {
                alt1=9;
                }
                break;
            case 41:
                {
                alt1=10;
                }
                break;
            case 42:
                {
                alt1=11;
                }
                break;
            case 43:
                {
                alt1=12;
                }
                break;
            case 44:
                {
                alt1=13;
                }
                break;
            case 45:
                {
                alt1=14;
                }
                break;
            case 46:
                {
                alt1=15;
                }
                break;
            case 47:
                {
                alt1=16;
                }
                break;
            case 48:
                {
                alt1=17;
                }
                break;
            case 49:
                {
                alt1=18;
                }
                break;
            case 50:
                {
                alt1=19;
                }
                break;
            case 51:
                {
                alt1=20;
                }
                break;
            case 52:
                {
                alt1=21;
                }
                break;
            case 53:
                {
                alt1=22;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:219:4: ast= NAME
                    {
                    ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifierOrKeyword91); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ast_tree = (Object)adaptor.create(ast);
                    adaptor.addChild(root_0, ast_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = unescapeString( ast.getText());

                    }

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:221:5: 'then'
                    {
                    string_literal2=(Token)match(input,33,FOLLOW_33_in_identifierOrKeyword99); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal2_tree = (Object)adaptor.create(string_literal2);
                    adaptor.addChild(root_0, string_literal2_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "then";
                    }

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:222:5: 'Bag'
                    {
                    string_literal3=(Token)match(input,34,FOLLOW_34_in_identifierOrKeyword107); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal3_tree = (Object)adaptor.create(string_literal3);
                    adaptor.addChild(root_0, string_literal3_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "Bag";
                    }

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:223:5: ';'
                    {
                    char_literal4=(Token)match(input,35,FOLLOW_35_in_identifierOrKeyword115); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal4_tree = (Object)adaptor.create(char_literal4);
                    adaptor.addChild(root_0, char_literal4_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = ";";
                    }

                    }
                    break;
                case 5 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:224:5: 'self'
                    {
                    string_literal5=(Token)match(input,36,FOLLOW_36_in_identifierOrKeyword123); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal5_tree = (Object)adaptor.create(string_literal5);
                    adaptor.addChild(root_0, string_literal5_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "self";
                    }

                    }
                    break;
                case 6 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:225:5: '.'
                    {
                    char_literal6=(Token)match(input,37,FOLLOW_37_in_identifierOrKeyword131); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal6_tree = (Object)adaptor.create(char_literal6);
                    adaptor.addChild(root_0, char_literal6_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = ".";
                    }

                    }
                    break;
                case 7 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:226:5: 'collect'
                    {
                    string_literal7=(Token)match(input,38,FOLLOW_38_in_identifierOrKeyword139); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal7_tree = (Object)adaptor.create(string_literal7);
                    adaptor.addChild(root_0, string_literal7_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "collect";
                    }

                    }
                    break;
                case 8 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:227:5: '='
                    {
                    char_literal8=(Token)match(input,39,FOLLOW_39_in_identifierOrKeyword147); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (Object)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "=";
                    }

                    }
                    break;
                case 9 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:228:5: 'iterate'
                    {
                    string_literal9=(Token)match(input,40,FOLLOW_40_in_identifierOrKeyword155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal9_tree = (Object)adaptor.create(string_literal9);
                    adaptor.addChild(root_0, string_literal9_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "iterate";
                    }

                    }
                    break;
                case 10 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:229:5: '|'
                    {
                    char_literal10=(Token)match(input,41,FOLLOW_41_in_identifierOrKeyword163); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal10_tree = (Object)adaptor.create(char_literal10);
                    adaptor.addChild(root_0, char_literal10_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "|";
                    }

                    }
                    break;
                case 11 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:230:5: 'in'
                    {
                    string_literal11=(Token)match(input,42,FOLLOW_42_in_identifierOrKeyword171); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal11_tree = (Object)adaptor.create(string_literal11);
                    adaptor.addChild(root_0, string_literal11_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "in";
                    }

                    }
                    break;
                case 12 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:231:5: 'OrderedSet'
                    {
                    string_literal12=(Token)match(input,43,FOLLOW_43_in_identifierOrKeyword179); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal12_tree = (Object)adaptor.create(string_literal12);
                    adaptor.addChild(root_0, string_literal12_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "OrderedSet";
                    }

                    }
                    break;
                case 13 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:232:5: 'Sequence'
                    {
                    string_literal13=(Token)match(input,44,FOLLOW_44_in_identifierOrKeyword187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal13_tree = (Object)adaptor.create(string_literal13);
                    adaptor.addChild(root_0, string_literal13_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "Sequence";
                    }

                    }
                    break;
                case 14 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:233:5: 'else'
                    {
                    string_literal14=(Token)match(input,45,FOLLOW_45_in_identifierOrKeyword195); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal14_tree = (Object)adaptor.create(string_literal14);
                    adaptor.addChild(root_0, string_literal14_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "else";
                    }

                    }
                    break;
                case 15 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:234:5: '\\''
                    {
                    char_literal15=(Token)match(input,46,FOLLOW_46_in_identifierOrKeyword203); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal15_tree = (Object)adaptor.create(char_literal15);
                    adaptor.addChild(root_0, char_literal15_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "\'";
                    }

                    }
                    break;
                case 16 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:235:5: 'let'
                    {
                    string_literal16=(Token)match(input,47,FOLLOW_47_in_identifierOrKeyword211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal16_tree = (Object)adaptor.create(string_literal16);
                    adaptor.addChild(root_0, string_literal16_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "let";
                    }

                    }
                    break;
                case 17 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:236:5: 'endif'
                    {
                    string_literal17=(Token)match(input,48,FOLLOW_48_in_identifierOrKeyword219); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal17_tree = (Object)adaptor.create(string_literal17);
                    adaptor.addChild(root_0, string_literal17_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "endif";
                    }

                    }
                    break;
                case 18 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:237:5: 'Set'
                    {
                    string_literal18=(Token)match(input,49,FOLLOW_49_in_identifierOrKeyword227); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal18_tree = (Object)adaptor.create(string_literal18);
                    adaptor.addChild(root_0, string_literal18_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "Set";
                    }

                    }
                    break;
                case 19 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:238:5: 'forAll'
                    {
                    string_literal19=(Token)match(input,50,FOLLOW_50_in_identifierOrKeyword235); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal19_tree = (Object)adaptor.create(string_literal19);
                    adaptor.addChild(root_0, string_literal19_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "forAll";
                    }

                    }
                    break;
                case 20 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:239:5: 'if'
                    {
                    string_literal20=(Token)match(input,51,FOLLOW_51_in_identifierOrKeyword243); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal20_tree = (Object)adaptor.create(string_literal20);
                    adaptor.addChild(root_0, string_literal20_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "if";
                    }

                    }
                    break;
                case 21 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:240:5: 'Collection'
                    {
                    string_literal21=(Token)match(input,52,FOLLOW_52_in_identifierOrKeyword251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal21_tree = (Object)adaptor.create(string_literal21);
                    adaptor.addChild(root_0, string_literal21_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "Collection";
                    }

                    }
                    break;
                case 22 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:241:5: '->'
                    {
                    string_literal22=(Token)match(input,53,FOLLOW_53_in_identifierOrKeyword259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal22_tree = (Object)adaptor.create(string_literal22);
                    adaptor.addChild(root_0, string_literal22_tree);
                    }
                    if ( state.backtracking==0 ) {
                      ret = "->";
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifierOrKeyword"

    public static class stringSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:248:1: stringSymbol returns [Object ret2] : (ast= STRING ) ;
    public final OCLParser.stringSymbol_return stringSymbol() throws RecognitionException {
        OCLParser.stringSymbol_return retval = new OCLParser.stringSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:249:3: ( (ast= STRING ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:250:3: (ast= STRING )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:250:3: (ast= STRING )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:250:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_stringSymbol290); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stringSymbol"

    public static class qualifiedNameSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "qualifiedNameSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:258:1: qualifiedNameSymbol returns [Object ret2] : (ast= QNAME ) ;
    public final OCLParser.qualifiedNameSymbol_return qualifiedNameSymbol() throws RecognitionException {
        OCLParser.qualifiedNameSymbol_return retval = new OCLParser.qualifiedNameSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:259:3: ( (ast= QNAME ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:260:3: (ast= QNAME )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:260:3: (ast= QNAME )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:260:4: ast= QNAME
            {
            ast=(Token)match(input,QNAME,FOLLOW_QNAME_in_qualifiedNameSymbol321); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qualifiedNameSymbol"

    public static class annotationSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "annotationSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:268:1: annotationSymbol returns [Object ret2] : (ast= MULTI_LINE_COMMENT ) ;
    public final OCLParser.annotationSymbol_return annotationSymbol() throws RecognitionException {
        OCLParser.annotationSymbol_return retval = new OCLParser.annotationSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:269:3: ( (ast= MULTI_LINE_COMMENT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:270:3: (ast= MULTI_LINE_COMMENT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:270:3: (ast= MULTI_LINE_COMMENT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:270:4: ast= MULTI_LINE_COMMENT
            {
            ast=(Token)match(input,MULTI_LINE_COMMENT,FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "annotationSymbol"

    public static class integerSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integerSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:278:1: integerSymbol returns [Object ret2] : (ast= INT ) ;
    public final OCLParser.integerSymbol_return integerSymbol() throws RecognitionException {
        OCLParser.integerSymbol_return retval = new OCLParser.integerSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:279:3: ( (ast= INT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:280:3: (ast= INT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:280:3: (ast= INT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:280:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerSymbol383); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = Integer.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integerSymbol"

    public static class longSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "longSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:288:1: longSymbol returns [Object ret2] : (ast= INT ) ;
    public final OCLParser.longSymbol_return longSymbol() throws RecognitionException {
        OCLParser.longSymbol_return retval = new OCLParser.longSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:289:3: ( (ast= INT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:290:3: (ast= INT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:290:3: (ast= INT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:290:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_longSymbol414); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = Integer.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "longSymbol"

    public static class integerAsString_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integerAsString"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:298:1: integerAsString returns [Object ret2] : (ast= INT ) ;
    public final OCLParser.integerAsString_return integerAsString() throws RecognitionException {
        OCLParser.integerAsString_return retval = new OCLParser.integerAsString_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:299:3: ( (ast= INT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:300:3: (ast= INT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:300:3: (ast= INT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:300:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_integerAsString445); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integerAsString"

    public static class floatAsString_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "floatAsString"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:308:1: floatAsString returns [Object ret2] : (ast= FLOAT ) ;
    public final OCLParser.floatAsString_return floatAsString() throws RecognitionException {
        OCLParser.floatAsString_return retval = new OCLParser.floatAsString_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:309:3: ( (ast= FLOAT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:310:3: (ast= FLOAT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:310:3: (ast= FLOAT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:310:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatAsString476); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = unescapeString( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "floatAsString"

    public static class booleanSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:318:1: booleanSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final OCLParser.booleanSymbol_return booleanSymbol() throws RecognitionException {
        OCLParser.booleanSymbol_return retval = new OCLParser.booleanSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:319:3: ( (ast= BOOL ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:320:3: (ast= BOOL )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:320:3: (ast= BOOL )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:320:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanSymbol507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret =  ast.getText();

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanSymbol"

    public static class booleanValueSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanValueSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:328:1: booleanValueSymbol returns [Object ret2] : (ast= BOOL ) ;
    public final OCLParser.booleanValueSymbol_return booleanValueSymbol() throws RecognitionException {
        OCLParser.booleanValueSymbol_return retval = new OCLParser.booleanValueSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:329:3: ( (ast= BOOL ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:330:3: (ast= BOOL )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:330:3: (ast= BOOL )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:330:4: ast= BOOL
            {
            ast=(Token)match(input,BOOL,FOLLOW_BOOL_in_booleanValueSymbol538); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = Boolean.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanValueSymbol"

    public static class floatSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "floatSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:338:1: floatSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final OCLParser.floatSymbol_return floatSymbol() throws RecognitionException {
        OCLParser.floatSymbol_return retval = new OCLParser.floatSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:339:3: ( (ast= FLOAT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:340:3: (ast= FLOAT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:340:3: (ast= FLOAT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:340:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_floatSymbol569); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = Double.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "floatSymbol"

    public static class realSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "realSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:348:1: realSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final OCLParser.realSymbol_return realSymbol() throws RecognitionException {
        OCLParser.realSymbol_return retval = new OCLParser.realSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:349:3: ( (ast= FLOAT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:350:3: (ast= FLOAT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:350:3: (ast= FLOAT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:350:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_realSymbol600); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = Double.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "realSymbol"

    public static class doubleSymbol_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "doubleSymbol"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:358:1: doubleSymbol returns [Object ret2] : (ast= FLOAT ) ;
    public final OCLParser.doubleSymbol_return doubleSymbol() throws RecognitionException {
        OCLParser.doubleSymbol_return retval = new OCLParser.doubleSymbol_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ast=null;

        Object ast_tree=null;

        java.lang.Object ret=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:359:3: ( (ast= FLOAT ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:360:3: (ast= FLOAT )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:360:3: (ast= FLOAT )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:360:4: ast= FLOAT
            {
            ast=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_doubleSymbol631); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ast_tree = (Object)adaptor.create(ast);
            adaptor.addChild(root_0, ast_tree);
            }
            if ( state.backtracking==0 ) {
              ret = Double.valueOf( ast.getText());

            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "doubleSymbol"

    public static class ocl_ecore2_oclexpression_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_oclexpression"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:368:1: ocl_ecore2_oclexpression returns [Object ret2] : (ret= ocl_ecore2_literalexp | ret= ocl_ecore2_ifexp | ret= ocl_ecore2_letexp | ret= ocl_ecore2_variableexp ) ;
    public final OCLParser.ocl_ecore2_oclexpression_return ocl_ecore2_oclexpression() throws RecognitionException {
        OCLParser.ocl_ecore2_oclexpression_return retval = new OCLParser.ocl_ecore2_oclexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_variableexp_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:369:3: ( (ret= ocl_ecore2_literalexp | ret= ocl_ecore2_ifexp | ret= ocl_ecore2_letexp | ret= ocl_ecore2_variableexp ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:370:3: (ret= ocl_ecore2_literalexp | ret= ocl_ecore2_ifexp | ret= ocl_ecore2_letexp | ret= ocl_ecore2_variableexp )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:370:3: (ret= ocl_ecore2_literalexp | ret= ocl_ecore2_ifexp | ret= ocl_ecore2_letexp | ret= ocl_ecore2_variableexp )
            int alt2=4;
            switch ( input.LA(1) ) {
            case QNAME:
            case INT:
            case FLOAT:
            case BOOL:
            case 34:
            case 43:
            case 44:
            case 46:
            case 49:
            case 52:
                {
                alt2=1;
                }
                break;
            case 51:
                {
                alt2=2;
                }
                break;
            case 47:
                {
                alt2=3;
                }
                break;
            case SNAME:
            case 36:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:370:4: ret= ocl_ecore2_literalexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_literalexp_in_ocl_ecore2_oclexpression658);
                    ret=ocl_ecore2_literalexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:371:5: ret= ocl_ecore2_ifexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_ifexp_in_ocl_ecore2_oclexpression666);
                    ret=ocl_ecore2_ifexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:372:5: ret= ocl_ecore2_letexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_letexp_in_ocl_ecore2_oclexpression674);
                    ret=ocl_ecore2_letexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 4 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:373:5: ret= ocl_ecore2_variableexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_variableexp_in_ocl_ecore2_oclexpression682);
                    ret=ocl_ecore2_variableexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_oclexpression"

    public static class main_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "main"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:380:1: main returns [Object ret2] : ( (ret= ocl_expressions_oclexpression ) EOF ) ;
    public final OCLParser.main_return main() throws RecognitionException {
        OCLParser.main_return retval = new OCLParser.main_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF23=null;
        OCLParser.ocl_expressions_oclexpression_return ret = null;


        Object EOF23_tree=null;

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:381:3: ( ( (ret= ocl_expressions_oclexpression ) EOF ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:382:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:382:3: ( (ret= ocl_expressions_oclexpression ) EOF )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:382:4: (ret= ocl_expressions_oclexpression ) EOF
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:382:4: (ret= ocl_expressions_oclexpression )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:382:5: ret= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_main710);
            ret=ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            EOF23=(Token)match(input,EOF,FOLLOW_EOF_in_main713); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF23_tree = (Object)adaptor.create(EOF23);
            adaptor.addChild(root_0, EOF23_tree);
            }

            }

            if ( state.backtracking==0 ) {

              ret2=ret;

            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "main"

    public static class primary_ocl_expressions_oclexpression_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primary_ocl_expressions_oclexpression"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:389:1: primary_ocl_expressions_oclexpression returns [Object ret2] : (ret= ocl_ecore2_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) ;
    public final OCLParser.primary_ocl_expressions_oclexpression_return primary_ocl_expressions_oclexpression() throws RecognitionException {
        OCLParser.primary_ocl_expressions_oclexpression_return retval = new OCLParser.primary_ocl_expressions_oclexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN24=null;
        Token RPAREN25=null;
        OCLParser.ocl_expressions_oclexpression_return ret = null;


        Object LPAREN24_tree=null;
        Object RPAREN25_tree=null;

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:390:3: ( (ret= ocl_ecore2_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:391:3: (ret= ocl_ecore2_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:391:3: (ret= ocl_ecore2_oclexpression | ( LPAREN ret= ocl_expressions_oclexpression RPAREN ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==SNAME||LA3_0==QNAME||(LA3_0>=INT && LA3_0<=BOOL)||LA3_0==34||LA3_0==36||(LA3_0>=43 && LA3_0<=44)||(LA3_0>=46 && LA3_0<=47)||LA3_0==49||(LA3_0>=51 && LA3_0<=52)) ) {
                alt3=1;
            }
            else if ( (LA3_0==LPAREN) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:391:4: ret= ocl_ecore2_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_ecore2_oclexpression_in_primary_ocl_expressions_oclexpression741);
                    ret=ocl_ecore2_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:392:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    {
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:392:5: ( LPAREN ret= ocl_expressions_oclexpression RPAREN )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:392:6: LPAREN ret= ocl_expressions_oclexpression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    LPAREN24=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression750); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN24_tree = (Object)adaptor.create(LPAREN24);
                    adaptor.addChild(root_0, LPAREN24_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression756);
                    ret=ocl_expressions_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    RPAREN25=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression760); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN25_tree = (Object)adaptor.create(RPAREN25);
                    adaptor.addChild(root_0, RPAREN25_tree);
                    }
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "primary_ocl_expressions_oclexpression"

    public static class oclexpressions_priority_0_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oclexpressions_priority_0"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:399:1: oclexpressions_priority_0 returns [Object ret2] : ( (ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) ;
    public final OCLParser.oclexpressions_priority_0_return oclexpressions_priority_0() throws RecognitionException {
        OCLParser.oclexpressions_priority_0_return retval = new OCLParser.oclexpressions_priority_0_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal26=null;
        Token string_literal27=null;
        OCLParser.ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_return ret = null;


        Object char_literal26_tree=null;
        Object string_literal27_tree=null;

        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:400:3: ( ( (ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:4: ( (ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:4: ( (ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:6: (ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:6: (ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )* )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:8: ret= primary_ocl_expressions_oclexpression ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            {
            pushFollow(FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0798);
            ret=primary_ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:49: ( ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) ) | ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==37) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred1_OCL()) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==53) ) {
                    int LA4_3 = input.LA(2);

                    if ( (synpred3_OCL()) ) {
                        alt4=2;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:50: ( '.' ( ( identifier ~ LPAREN ) ) )=> ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:79: ( '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) ) )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:80: '.' ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq(".", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    char_literal26=(Token)match(input,37,FOLLOW_37_in_oclexpressions_priority_0815); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal26_tree = (Object)adaptor.create(char_literal26);
            	    adaptor.addChild(root_0, char_literal26_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	      opName = ".";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:160: ( ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] ) )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:161: ( identifier ~ LPAREN )=> (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] )
            	    {
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:183: (ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken] )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:184: ret= ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp_in_oclexpressions_priority_0829);
            	    ret=ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp(opName, ret, firstToken);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            	    }


            	    }

            	    if ( state.backtracking==0 ) {
            	      _exitOpSeq();
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:3: ( '->' )=> ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    {
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:11: ( '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) ) )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:12: '->' ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("->", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    string_literal27=(Token)match(input,53,FOLLOW_53_in_oclexpressions_priority_0845); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal27_tree = (Object)adaptor.create(string_literal27);
            	    adaptor.addChild(root_0, string_literal27_tree);
            	    }
            	    if ( state.backtracking==0 ) {
            	      opName = "->";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:95: ( (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] ) )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:96: (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] )
            	    {
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:96: (ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken] )
            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:97: ret= ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[opName, ret, firstToken]
            	    {
            	    pushFollow(FOLLOW_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_in_oclexpressions_priority_0852);
            	    ret=ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp(opName, ret, firstToken);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oclexpressions_priority_0"

    public static class oclexpressions_priority_1_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "oclexpressions_priority_1"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:410:1: oclexpressions_priority_1 returns [Object ret2] : ( (ret= oclexpressions_priority_0 ) ) ;
    public final OCLParser.oclexpressions_priority_1_return oclexpressions_priority_1() throws RecognitionException {
        OCLParser.oclexpressions_priority_1_return retval = new OCLParser.oclexpressions_priority_1_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.oclexpressions_priority_0_return ret = null;



        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;
        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:411:3: ( ( (ret= oclexpressions_priority_0 ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:412:4: ( (ret= oclexpressions_priority_0 ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:412:4: ( (ret= oclexpressions_priority_0 ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:412:6: (ret= oclexpressions_priority_0 )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:412:6: (ret= oclexpressions_priority_0 )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:412:8: ret= oclexpressions_priority_0
            {
            pushFollow(FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1898);
            ret=oclexpressions_priority_0();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }


            }

            if ( state.backtracking==0 ) {

              this.setLocationAndComment(ret, firstToken);
              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "oclexpressions_priority_1"

    public static class ocl_expressions_oclexpression_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_oclexpression"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:420:1: ocl_expressions_oclexpression returns [Object ret2] : ret= oclexpressions_priority_1 ;
    public final OCLParser.ocl_expressions_oclexpression_return ocl_expressions_oclexpression() throws RecognitionException {
        OCLParser.ocl_expressions_oclexpression_return retval = new OCLParser.ocl_expressions_oclexpression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.oclexpressions_priority_1_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:421:3: (ret= oclexpressions_priority_1 )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:422:3: ret= oclexpressions_priority_1
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression928);
            ret=oclexpressions_priority_1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());
            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_oclexpression"

    public static class ocl_ecore2_literalexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_literalexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:429:1: ocl_ecore2_literalexp returns [Object ret2] : (ret= ocl_ecore2_primitiveliteralexp | ret= ocl_ecore2_enumliteralexp | ret= ocl_ecore2_collectionliteralexp ) ;
    public final OCLParser.ocl_ecore2_literalexp_return ocl_ecore2_literalexp() throws RecognitionException {
        OCLParser.ocl_ecore2_literalexp_return retval = new OCLParser.ocl_ecore2_literalexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectionliteralexp_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:430:3: ( (ret= ocl_ecore2_primitiveliteralexp | ret= ocl_ecore2_enumliteralexp | ret= ocl_ecore2_collectionliteralexp ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:431:3: (ret= ocl_ecore2_primitiveliteralexp | ret= ocl_ecore2_enumliteralexp | ret= ocl_ecore2_collectionliteralexp )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:431:3: (ret= ocl_ecore2_primitiveliteralexp | ret= ocl_ecore2_enumliteralexp | ret= ocl_ecore2_collectionliteralexp )
            int alt5=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
            case BOOL:
            case 46:
                {
                alt5=1;
                }
                break;
            case QNAME:
                {
                alt5=2;
                }
                break;
            case 34:
            case 43:
            case 44:
            case 49:
            case 52:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:431:4: ret= ocl_ecore2_primitiveliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_primitiveliteralexp_in_ocl_ecore2_literalexp954);
                    ret=ocl_ecore2_primitiveliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:432:5: ret= ocl_ecore2_enumliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_enumliteralexp_in_ocl_ecore2_literalexp962);
                    ret=ocl_ecore2_enumliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:433:5: ret= ocl_ecore2_collectionliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_collectionliteralexp_in_ocl_ecore2_literalexp970);
                    ret=ocl_ecore2_collectionliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_literalexp"

    public static class ocl_ecore2_primitiveliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_primitiveliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:440:1: ocl_ecore2_primitiveliteralexp returns [Object ret2] : (ret= ocl_ecore2_numericliteralexp | ret= ocl_ecore2_stringliteralexp | ret= ocl_ecore2_booleanliteralexp ) ;
    public final OCLParser.ocl_ecore2_primitiveliteralexp_return ocl_ecore2_primitiveliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_primitiveliteralexp_return retval = new OCLParser.ocl_ecore2_primitiveliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_booleanliteralexp_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:441:3: ( (ret= ocl_ecore2_numericliteralexp | ret= ocl_ecore2_stringliteralexp | ret= ocl_ecore2_booleanliteralexp ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:442:3: (ret= ocl_ecore2_numericliteralexp | ret= ocl_ecore2_stringliteralexp | ret= ocl_ecore2_booleanliteralexp )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:442:3: (ret= ocl_ecore2_numericliteralexp | ret= ocl_ecore2_stringliteralexp | ret= ocl_ecore2_booleanliteralexp )
            int alt6=3;
            switch ( input.LA(1) ) {
            case INT:
            case FLOAT:
                {
                alt6=1;
                }
                break;
            case 46:
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
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:442:4: ret= ocl_ecore2_numericliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_numericliteralexp_in_ocl_ecore2_primitiveliteralexp997);
                    ret=ocl_ecore2_numericliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:443:5: ret= ocl_ecore2_stringliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_stringliteralexp_in_ocl_ecore2_primitiveliteralexp1005);
                    ret=ocl_ecore2_stringliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:444:5: ret= ocl_ecore2_booleanliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_booleanliteralexp_in_ocl_ecore2_primitiveliteralexp1013);
                    ret=ocl_ecore2_booleanliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_primitiveliteralexp"

    public static class ocl_ecore2_numericliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_numericliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:451:1: ocl_ecore2_numericliteralexp returns [Object ret2] : (ret= ocl_ecore2_integerliteralexp | ret= ocl_ecore2_realliteralexp ) ;
    public final OCLParser.ocl_ecore2_numericliteralexp_return ocl_ecore2_numericliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_numericliteralexp_return retval = new OCLParser.ocl_ecore2_numericliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_realliteralexp_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:452:3: ( (ret= ocl_ecore2_integerliteralexp | ret= ocl_ecore2_realliteralexp ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:453:3: (ret= ocl_ecore2_integerliteralexp | ret= ocl_ecore2_realliteralexp )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:453:3: (ret= ocl_ecore2_integerliteralexp | ret= ocl_ecore2_realliteralexp )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==FLOAT) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:453:4: ret= ocl_ecore2_integerliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_integerliteralexp_in_ocl_ecore2_numericliteralexp1040);
                    ret=ocl_ecore2_integerliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:454:5: ret= ocl_ecore2_realliteralexp
                    {
                    pushFollow(FOLLOW_ocl_ecore2_realliteralexp_in_ocl_ecore2_numericliteralexp1048);
                    ret=ocl_ecore2_realliteralexp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_numericliteralexp"

    public static class ocl_ecore2_integerliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_integerliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:461:1: ocl_ecore2_integerliteralexp returns [Object ret2] : ( (temp= integerSymbol ) ) ;
    public final OCLParser.ocl_ecore2_integerliteralexp_return ocl_ecore2_integerliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_integerliteralexp_return retval = new OCLParser.ocl_ecore2_integerliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.integerSymbol_return temp = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","IntegerLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:467:3: ( ( (temp= integerSymbol ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:468:3: ( (temp= integerSymbol ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:468:3: ( (temp= integerSymbol ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:468:4: (temp= integerSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.19/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:468:140: (temp= integerSymbol )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:468:142: temp= integerSymbol
            {
            pushFollow(FOLLOW_integerSymbol_in_ocl_ecore2_integerliteralexp1082);
            temp=integerSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "integerSymbol", temp);
              setParent(temp,ret,"integerSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.19/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name->asSequence()->at(1)='ecore2' and c.ePackage.name->asSequence()->at(2)='EIntegerObject' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_integerliteralexp"

    public static class ocl_ecore2_stringliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_stringliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:477:1: ocl_ecore2_stringliteralexp returns [Object ret2] : ( '\\'' (temp= identifier ) '\\'' ) ;
    public final OCLParser.ocl_ecore2_stringliteralexp_return ocl_ecore2_stringliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_stringliteralexp_return retval = new OCLParser.ocl_ecore2_stringliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal28=null;
        Token char_literal29=null;
        OCLParser.identifier_return temp = null;


        Object char_literal28_tree=null;
        Object char_literal29_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","StringLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:483:3: ( ( '\\'' (temp= identifier ) '\\'' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:484:3: ( '\\'' (temp= identifier ) '\\'' )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:484:3: ( '\\'' (temp= identifier ) '\\'' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:484:4: '\\'' (temp= identifier ) '\\''
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.20/@templateSequence/@elements.0");
            }
            char_literal28=(Token)match(input,46,FOLLOW_46_in_ocl_ecore2_stringliteralexp1128); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal28_tree = (Object)adaptor.create(char_literal28);
            adaptor.addChild(root_0, char_literal28_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.20/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:484:296: (temp= identifier )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:484:298: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore2_stringliteralexp1135);
            temp=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "stringSymbol", temp);
              setParent(temp,ret,"stringSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.20/@templateSequence/@elements.2");
            }
            char_literal29=(Token)match(input,46,FOLLOW_46_in_ocl_ecore2_stringliteralexp1141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal29_tree = (Object)adaptor.create(char_literal29);
            adaptor.addChild(root_0, char_literal29_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.20/@templateSequence/@elements.3");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.name->asSequence()->at(1)='ecore2' and name->asSequence()->at(2)='EString' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_stringliteralexp"

    public static class ocl_ecore2_realliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_realliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:493:1: ocl_ecore2_realliteralexp returns [Object ret2] : ( (temp= realSymbol ) ) ;
    public final OCLParser.ocl_ecore2_realliteralexp_return ocl_ecore2_realliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_realliteralexp_return retval = new OCLParser.ocl_ecore2_realliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.realSymbol_return temp = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","RealLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:499:3: ( ( (temp= realSymbol ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:500:3: ( (temp= realSymbol ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:500:3: ( (temp= realSymbol ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:500:4: (temp= realSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.21/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:500:140: (temp= realSymbol )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:500:142: temp= realSymbol
            {
            pushFollow(FOLLOW_realSymbol_in_ocl_ecore2_realliteralexp1188);
            temp=realSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "realSymbol", temp);
              setParent(temp,ret,"realSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.21/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.name->asSequence()->at(1)='ecore2' and name->asSequence()->at(2)='EDoubleObject' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_realliteralexp"

    public static class ocl_ecore2_booleanliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_booleanliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:509:1: ocl_ecore2_booleanliteralexp returns [Object ret2] : ( (temp= booleanValueSymbol ) ) ;
    public final OCLParser.ocl_ecore2_booleanliteralexp_return ocl_ecore2_booleanliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_booleanliteralexp_return retval = new OCLParser.ocl_ecore2_booleanliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.booleanValueSymbol_return temp = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","BooleanLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:515:3: ( ( (temp= booleanValueSymbol ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:516:3: ( (temp= booleanValueSymbol ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:516:3: ( (temp= booleanValueSymbol ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:516:4: (temp= booleanValueSymbol )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.22/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:516:140: (temp= booleanValueSymbol )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:516:142: temp= booleanValueSymbol
            {
            pushFollow(FOLLOW_booleanValueSymbol_in_ocl_ecore2_booleanliteralexp1238);
            temp=booleanValueSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "booleanSymbol", temp);
              setParent(temp,ret,"booleanSymbol");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.22/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.name->asSequence()->at(1)='ecore2' and qualifiedName->asSequence()->at(2)='EBooleanObject' endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_booleanliteralexp"

    public static class ocl_ecore2_enumliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_enumliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:525:1: ocl_ecore2_enumliteralexp returns [Object ret2] : ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) ;
    public final OCLParser.ocl_ecore2_enumliteralexp_return ocl_ecore2_enumliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_enumliteralexp_return retval = new OCLParser.ocl_ecore2_enumliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DCOLON30=null;
        OCLParser.identifier_return temp = null;


        Object DCOLON30_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","EnumLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:531:3: ( ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:3: ( (temp= qualifiedNameSymbol ) DCOLON (temp= identifier ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:4: (temp= qualifiedNameSymbol ) DCOLON (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.23/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:140: (temp= qualifiedNameSymbol )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:142: temp= qualifiedNameSymbol
            {
            pushFollow(FOLLOW_qualifiedNameSymbol_in_ocl_ecore2_enumliteralexp1288);
            temp=qualifiedNameSymbol();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setOclRef(ret, "eType", null, temp, "OCL:EEnum.allInstances() ->select(c | c.name=?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.23/@templateSequence/@elements.1");
            }
            DCOLON30=(Token)match(input,DCOLON,FOLLOW_DCOLON_in_ocl_ecore2_enumliteralexp1295); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DCOLON30_tree = (Object)adaptor.create(DCOLON30);
            adaptor.addChild(root_0, DCOLON30_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.23/@templateSequence/@elements.2");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:569: (temp= identifier )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:532:571: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore2_enumliteralexp1303);
            temp=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredEnumLiteral", null, temp, "OCL:self.eType.oclAsType(EEnum).eLiterals->select(l | l.literal = ?)");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_enumliteralexp"

    public static class ocl_expressions_collectionliteralpart_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_collectionliteralpart"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:540:1: ocl_expressions_collectionliteralpart returns [Object ret2] : (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) ) ;
    public final OCLParser.ocl_expressions_collectionliteralpart_return ocl_expressions_collectionliteralpart() throws RecognitionException {
        OCLParser.ocl_expressions_collectionliteralpart_return retval = new OCLParser.ocl_expressions_collectionliteralpart_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_expressions_collectionrange_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:541:3: ( (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:542:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:542:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:542:4: ret= ocl_expressions_collectionitem
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart1343);
                    ret=ocl_expressions_collectionitem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:543:5: ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange )
                    {
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:543:44: (ret= ocl_expressions_collectionrange )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:543:45: ret= ocl_expressions_collectionrange
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart1358);
                    ret=ocl_expressions_collectionrange();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_collectionliteralpart"

    public static class ocl_ecore2_collectionliteralexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectionliteralexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:550:1: ocl_ecore2_collectionliteralexp returns [Object ret2] : ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) ;
    public final OCLParser.ocl_ecore2_collectionliteralexp_return ocl_ecore2_collectionliteralexp() throws RecognitionException {
        OCLParser.ocl_ecore2_collectionliteralexp_return retval = new OCLParser.ocl_ecore2_collectionliteralexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal31=null;
        Token string_literal32=null;
        Token string_literal33=null;
        Token string_literal34=null;
        Token string_literal35=null;
        Token LCURL36=null;
        Token COMMA37=null;
        Token RCURL38=null;
        OCLParser.ocl_expressions_collectionliteralpart_return temp = null;


        Object string_literal31_tree=null;
        Object string_literal32_tree=null;
        Object string_literal33_tree=null;
        Object string_literal34_tree=null;
        Object string_literal35_tree=null;
        Object LCURL36_tree=null;
        Object COMMA37_tree=null;
        Object RCURL38_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","CollectionLiteralExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"collectionliteral"}) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:556:3: ( ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:3: ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:3: ( ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:4: ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) ) LCURL (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )? RCURL
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:140: ( ( 'Sequence' (temp= ecore_eclassifier_sequence ) ) | ( 'Set' (temp= ecore_eclassifier_set ) ) | ( 'Collection' (temp= ecore_eclassifier_collection ) ) | ( 'Bag' (temp= ecore_eclassifier_bag ) ) | ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) ) )
            int alt9=5;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt9=1;
                }
                break;
            case 49:
                {
                alt9=2;
                }
                break;
            case 52:
                {
                alt9=3;
                }
                break;
            case 34:
                {
                alt9=4;
                }
                break;
            case 43:
                {
                alt9=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:141: ( 'Sequence' (temp= ecore_eclassifier_sequence ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:157: ( 'Sequence' (temp= ecore_eclassifier_sequence ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:158: 'Sequence' (temp= ecore_eclassifier_sequence )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    string_literal31=(Token)match(input,44,FOLLOW_44_in_ocl_ecore2_collectionliteralexp1394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal31_tree = (Object)adaptor.create(string_literal31);
                    adaptor.addChild(root_0, string_literal31_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:506: (temp= ecore_eclassifier_sequence )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:557:508: temp= ecore_eclassifier_sequence
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_sequence_in_ocl_ecore2_collectionliteralexp1401);
                    temp=ecore_eclassifier_sequence();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.SEQUENCE);_exitInjectorAction();
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:559:4: ( 'Set' (temp= ecore_eclassifier_set ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:559:20: ( 'Set' (temp= ecore_eclassifier_set ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:559:21: 'Set' (temp= ecore_eclassifier_set )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    string_literal32=(Token)match(input,49,FOLLOW_49_in_ocl_ecore2_collectionliteralexp1420); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal32_tree = (Object)adaptor.create(string_literal32);
                    adaptor.addChild(root_0, string_literal32_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:559:364: (temp= ecore_eclassifier_set )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:559:366: temp= ecore_eclassifier_set
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_set_in_ocl_ecore2_collectionliteralexp1427);
                    temp=ecore_eclassifier_set();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.SET);_exitInjectorAction();
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:561:4: ( 'Collection' (temp= ecore_eclassifier_collection ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:561:20: ( 'Collection' (temp= ecore_eclassifier_collection ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:561:21: 'Collection' (temp= ecore_eclassifier_collection )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.0");
                    }
                    string_literal33=(Token)match(input,52,FOLLOW_52_in_ocl_ecore2_collectionliteralexp1446); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal33_tree = (Object)adaptor.create(string_literal33);
                    adaptor.addChild(root_0, string_literal33_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:561:371: (temp= ecore_eclassifier_collection )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:561:373: temp= ecore_eclassifier_collection
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_collection_in_ocl_ecore2_collectionliteralexp1453);
                    temp=ecore_eclassifier_collection();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.COLLECTION);_exitInjectorAction();
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:563:4: ( 'Bag' (temp= ecore_eclassifier_bag ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(3);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:563:20: ( 'Bag' (temp= ecore_eclassifier_bag ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:563:21: 'Bag' (temp= ecore_eclassifier_bag )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.0");
                    }
                    string_literal34=(Token)match(input,34,FOLLOW_34_in_ocl_ecore2_collectionliteralexp1472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal34_tree = (Object)adaptor.create(string_literal34);
                    adaptor.addChild(root_0, string_literal34_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:563:364: (temp= ecore_eclassifier_bag )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:563:366: temp= ecore_eclassifier_bag
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_bag_in_ocl_ecore2_collectionliteralexp1479);
                    temp=ecore_eclassifier_bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.BAG);_exitInjectorAction();
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:565:4: ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(4);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:565:20: ( 'OrderedSet' (temp= ecore_eclassifier_orderedset ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:565:21: 'OrderedSet' (temp= ecore_eclassifier_orderedset )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.0");
                    }
                    string_literal35=(Token)match(input,43,FOLLOW_43_in_ocl_ecore2_collectionliteralexp1498); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal35_tree = (Object)adaptor.create(string_literal35);
                    adaptor.addChild(root_0, string_literal35_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:565:371: (temp= ecore_eclassifier_orderedset )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:565:373: temp= ecore_eclassifier_orderedset
                    {
                    pushFollow(FOLLOW_ecore_eclassifier_orderedset_in_ocl_ecore2_collectionliteralexp1505);
                    temp=ecore_eclassifier_orderedset();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "eType", temp);
                      setParent(temp,ret,"eType");
                    }

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.2");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.ORDERED_SET);_exitInjectorAction();
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.1");
            }
            LCURL36=(Token)match(input,LCURL,FOLLOW_LCURL_in_ocl_ecore2_collectionliteralexp1520); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LCURL36_tree = (Object)adaptor.create(LCURL36);
            adaptor.addChild(root_0, LCURL36_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.2");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:566:679: (temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==SNAME||LA11_0==QNAME||(LA11_0>=INT && LA11_0<=LPAREN)||LA11_0==34||LA11_0==36||(LA11_0>=43 && LA11_0<=44)||(LA11_0>=46 && LA11_0<=47)||LA11_0==49||(LA11_0>=51 && LA11_0<=52)) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:566:681: temp= ocl_expressions_collectionliteralpart ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )*
                    {
                    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore2_collectionliteralexp1528);
                    temp=ocl_expressions_collectionliteralpart();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "part", temp);
                      setParent(temp,ret,"part");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:567:30: ( ( COMMA ) temp= ocl_expressions_collectionliteralpart )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:567:31: ( COMMA ) temp= ocl_expressions_collectionliteralpart
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:567:48: ( COMMA )
                    	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:567:49: COMMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                    	    }
                    	    COMMA37=(Token)match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore2_collectionliteralexp1537); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA37_tree = (Object)adaptor.create(COMMA37);
                    	    adaptor.addChild(root_0, COMMA37_tree);
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore2_collectionliteralexp1545);
                    	    temp=ocl_expressions_collectionliteralpart();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "part", temp);
                    	      setParent(temp,ret,"part");
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.3");
            }
            RCURL38=(Token)match(input,RCURL,FOLLOW_RCURL_in_ocl_ecore2_collectionliteralexp1557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RCURL38_tree = (Object)adaptor.create(RCURL38);
            adaptor.addChild(root_0, RCURL38_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.25/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.eType.name.subString(1, -4+type.name.size()).concat('{...}')", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, true);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectionliteralexp"

    public static class ecore_eclassifier_sequence_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_eclassifier_sequence"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:576:1: ecore_eclassifier_sequence returns [Object ret2] : (ret= ecore_edatatype_sequence ) ;
    public final OCLParser.ecore_eclassifier_sequence_return ecore_eclassifier_sequence() throws RecognitionException {
        OCLParser.ecore_eclassifier_sequence_return retval = new OCLParser.ecore_eclassifier_sequence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ecore_edatatype_sequence_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:577:3: ( (ret= ecore_edatatype_sequence ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:578:3: (ret= ecore_edatatype_sequence )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:578:3: (ret= ecore_edatatype_sequence )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:578:4: ret= ecore_edatatype_sequence
            {
            pushFollow(FOLLOW_ecore_edatatype_sequence_in_ecore_eclassifier_sequence1598);
            ret=ecore_edatatype_sequence();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_eclassifier_sequence"

    public static class ecore_edatatype_sequence_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_edatatype_sequence"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:585:1: ecore_edatatype_sequence returns [Object ret2] : (ret= ocl_ecore2_collectiontype_sequence ) ;
    public final OCLParser.ecore_edatatype_sequence_return ecore_edatatype_sequence() throws RecognitionException {
        OCLParser.ecore_edatatype_sequence_return retval = new OCLParser.ecore_edatatype_sequence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectiontype_sequence_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:586:3: ( (ret= ocl_ecore2_collectiontype_sequence ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:587:3: (ret= ocl_ecore2_collectiontype_sequence )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:587:3: (ret= ocl_ecore2_collectiontype_sequence )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:587:4: ret= ocl_ecore2_collectiontype_sequence
            {
            pushFollow(FOLLOW_ocl_ecore2_collectiontype_sequence_in_ecore_edatatype_sequence1625);
            ret=ocl_ecore2_collectiontype_sequence();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_edatatype_sequence"

    public static class ocl_ecore2_collectiontype_sequence_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectiontype_sequence"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:594:1: ocl_ecore2_collectiontype_sequence returns [Object ret2] : (ret= ocl_ecore2_sequencetype_sequence ) ;
    public final OCLParser.ocl_ecore2_collectiontype_sequence_return ocl_ecore2_collectiontype_sequence() throws RecognitionException {
        OCLParser.ocl_ecore2_collectiontype_sequence_return retval = new OCLParser.ocl_ecore2_collectiontype_sequence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_sequencetype_sequence_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:595:3: ( (ret= ocl_ecore2_sequencetype_sequence ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:596:3: (ret= ocl_ecore2_sequencetype_sequence )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:596:3: (ret= ocl_ecore2_sequencetype_sequence )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:596:4: ret= ocl_ecore2_sequencetype_sequence
            {
            pushFollow(FOLLOW_ocl_ecore2_sequencetype_sequence_in_ocl_ecore2_collectiontype_sequence1652);
            ret=ocl_ecore2_sequencetype_sequence();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectiontype_sequence"

    public static class ocl_ecore2_sequencetype_sequence_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_sequencetype_sequence"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:603:1: ocl_ecore2_sequencetype_sequence returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final OCLParser.ocl_ecore2_sequencetype_sequence_return ocl_ecore2_sequencetype_sequence() throws RecognitionException {
        OCLParser.ocl_ecore2_sequencetype_sequence_return retval = new OCLParser.ocl_ecore2_sequencetype_sequence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.collectiontypeelementtype_return collectiontypeelementtype39 = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","SequenceType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"sequence");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:609:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:610:3: ( collectiontypeelementtype[ret] )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:610:3: ( collectiontypeelementtype[ret] )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:610:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.29/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore2_sequencetype_sequence1682);
            collectiontypeelementtype39=collectiontypeelementtype(ret);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, collectiontypeelementtype39.getTree());
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.29/@templateSequence/@elements.1");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_sequencetype_sequence"

    public static class ecore_eclassifier_set_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_eclassifier_set"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:618:1: ecore_eclassifier_set returns [Object ret2] : (ret= ecore_edatatype_set ) ;
    public final OCLParser.ecore_eclassifier_set_return ecore_eclassifier_set() throws RecognitionException {
        OCLParser.ecore_eclassifier_set_return retval = new OCLParser.ecore_eclassifier_set_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ecore_edatatype_set_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:619:3: ( (ret= ecore_edatatype_set ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:620:3: (ret= ecore_edatatype_set )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:620:3: (ret= ecore_edatatype_set )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:620:4: ret= ecore_edatatype_set
            {
            pushFollow(FOLLOW_ecore_edatatype_set_in_ecore_eclassifier_set1723);
            ret=ecore_edatatype_set();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_eclassifier_set"

    public static class ecore_edatatype_set_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_edatatype_set"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:627:1: ecore_edatatype_set returns [Object ret2] : (ret= ocl_ecore2_collectiontype_set ) ;
    public final OCLParser.ecore_edatatype_set_return ecore_edatatype_set() throws RecognitionException {
        OCLParser.ecore_edatatype_set_return retval = new OCLParser.ecore_edatatype_set_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectiontype_set_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:628:3: ( (ret= ocl_ecore2_collectiontype_set ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:629:3: (ret= ocl_ecore2_collectiontype_set )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:629:3: (ret= ocl_ecore2_collectiontype_set )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:629:4: ret= ocl_ecore2_collectiontype_set
            {
            pushFollow(FOLLOW_ocl_ecore2_collectiontype_set_in_ecore_edatatype_set1750);
            ret=ocl_ecore2_collectiontype_set();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_edatatype_set"

    public static class ocl_ecore2_collectiontype_set_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectiontype_set"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:636:1: ocl_ecore2_collectiontype_set returns [Object ret2] : (ret= ocl_ecore2_settype_set ) ;
    public final OCLParser.ocl_ecore2_collectiontype_set_return ocl_ecore2_collectiontype_set() throws RecognitionException {
        OCLParser.ocl_ecore2_collectiontype_set_return retval = new OCLParser.ocl_ecore2_collectiontype_set_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_settype_set_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:637:3: ( (ret= ocl_ecore2_settype_set ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:638:3: (ret= ocl_ecore2_settype_set )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:638:3: (ret= ocl_ecore2_settype_set )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:638:4: ret= ocl_ecore2_settype_set
            {
            pushFollow(FOLLOW_ocl_ecore2_settype_set_in_ocl_ecore2_collectiontype_set1777);
            ret=ocl_ecore2_settype_set();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectiontype_set"

    public static class ocl_ecore2_settype_set_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_settype_set"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:645:1: ocl_ecore2_settype_set returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final OCLParser.ocl_ecore2_settype_set_return ocl_ecore2_settype_set() throws RecognitionException {
        OCLParser.ocl_ecore2_settype_set_return retval = new OCLParser.ocl_ecore2_settype_set_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.collectiontypeelementtype_return collectiontypeelementtype40 = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","SetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"set");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:651:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:652:3: ( collectiontypeelementtype[ret] )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:652:3: ( collectiontypeelementtype[ret] )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:652:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.33/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore2_settype_set1807);
            collectiontypeelementtype40=collectiontypeelementtype(ret);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, collectiontypeelementtype40.getTree());
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.33/@templateSequence/@elements.1");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_settype_set"

    public static class ecore_eclassifier_collection_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_eclassifier_collection"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:660:1: ecore_eclassifier_collection returns [Object ret2] : (ret= ecore_edatatype_collection ) ;
    public final OCLParser.ecore_eclassifier_collection_return ecore_eclassifier_collection() throws RecognitionException {
        OCLParser.ecore_eclassifier_collection_return retval = new OCLParser.ecore_eclassifier_collection_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ecore_edatatype_collection_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:661:3: ( (ret= ecore_edatatype_collection ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:662:3: (ret= ecore_edatatype_collection )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:662:3: (ret= ecore_edatatype_collection )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:662:4: ret= ecore_edatatype_collection
            {
            pushFollow(FOLLOW_ecore_edatatype_collection_in_ecore_eclassifier_collection1848);
            ret=ecore_edatatype_collection();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_eclassifier_collection"

    public static class ecore_edatatype_collection_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_edatatype_collection"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:669:1: ecore_edatatype_collection returns [Object ret2] : (ret= ocl_ecore2_collectiontype_collection ) ;
    public final OCLParser.ecore_edatatype_collection_return ecore_edatatype_collection() throws RecognitionException {
        OCLParser.ecore_edatatype_collection_return retval = new OCLParser.ecore_edatatype_collection_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectiontype_collection_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:670:3: ( (ret= ocl_ecore2_collectiontype_collection ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:671:3: (ret= ocl_ecore2_collectiontype_collection )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:671:3: (ret= ocl_ecore2_collectiontype_collection )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:671:4: ret= ocl_ecore2_collectiontype_collection
            {
            pushFollow(FOLLOW_ocl_ecore2_collectiontype_collection_in_ecore_edatatype_collection1875);
            ret=ocl_ecore2_collectiontype_collection();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_edatatype_collection"

    public static class ocl_ecore2_collectiontype_collection_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectiontype_collection"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:678:1: ocl_ecore2_collectiontype_collection returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final OCLParser.ocl_ecore2_collectiontype_collection_return ocl_ecore2_collectiontype_collection() throws RecognitionException {
        OCLParser.ocl_ecore2_collectiontype_collection_return retval = new OCLParser.ocl_ecore2_collectiontype_collection_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.collectiontypeelementtype_return collectiontypeelementtype41 = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","CollectionType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"collection");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:684:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:685:3: ( collectiontypeelementtype[ret] )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:685:3: ( collectiontypeelementtype[ret] )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:685:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.36/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore2_collectiontype_collection1905);
            collectiontypeelementtype41=collectiontypeelementtype(ret);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, collectiontypeelementtype41.getTree());
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.36/@templateSequence/@elements.1");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectiontype_collection"

    public static class ecore_eclassifier_bag_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_eclassifier_bag"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:693:1: ecore_eclassifier_bag returns [Object ret2] : (ret= ecore_edatatype_bag ) ;
    public final OCLParser.ecore_eclassifier_bag_return ecore_eclassifier_bag() throws RecognitionException {
        OCLParser.ecore_eclassifier_bag_return retval = new OCLParser.ecore_eclassifier_bag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ecore_edatatype_bag_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:694:3: ( (ret= ecore_edatatype_bag ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:695:3: (ret= ecore_edatatype_bag )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:695:3: (ret= ecore_edatatype_bag )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:695:4: ret= ecore_edatatype_bag
            {
            pushFollow(FOLLOW_ecore_edatatype_bag_in_ecore_eclassifier_bag1946);
            ret=ecore_edatatype_bag();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_eclassifier_bag"

    public static class ecore_edatatype_bag_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_edatatype_bag"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:702:1: ecore_edatatype_bag returns [Object ret2] : (ret= ocl_ecore2_collectiontype_bag ) ;
    public final OCLParser.ecore_edatatype_bag_return ecore_edatatype_bag() throws RecognitionException {
        OCLParser.ecore_edatatype_bag_return retval = new OCLParser.ecore_edatatype_bag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectiontype_bag_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:703:3: ( (ret= ocl_ecore2_collectiontype_bag ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:704:3: (ret= ocl_ecore2_collectiontype_bag )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:704:3: (ret= ocl_ecore2_collectiontype_bag )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:704:4: ret= ocl_ecore2_collectiontype_bag
            {
            pushFollow(FOLLOW_ocl_ecore2_collectiontype_bag_in_ecore_edatatype_bag1973);
            ret=ocl_ecore2_collectiontype_bag();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_edatatype_bag"

    public static class ocl_ecore2_collectiontype_bag_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectiontype_bag"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:711:1: ocl_ecore2_collectiontype_bag returns [Object ret2] : (ret= ocl_ecore2_bagtype_bag ) ;
    public final OCLParser.ocl_ecore2_collectiontype_bag_return ocl_ecore2_collectiontype_bag() throws RecognitionException {
        OCLParser.ocl_ecore2_collectiontype_bag_return retval = new OCLParser.ocl_ecore2_collectiontype_bag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_bagtype_bag_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:712:3: ( (ret= ocl_ecore2_bagtype_bag ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:713:3: (ret= ocl_ecore2_bagtype_bag )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:713:3: (ret= ocl_ecore2_bagtype_bag )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:713:4: ret= ocl_ecore2_bagtype_bag
            {
            pushFollow(FOLLOW_ocl_ecore2_bagtype_bag_in_ocl_ecore2_collectiontype_bag2000);
            ret=ocl_ecore2_bagtype_bag();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectiontype_bag"

    public static class ocl_ecore2_bagtype_bag_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_bagtype_bag"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:720:1: ocl_ecore2_bagtype_bag returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final OCLParser.ocl_ecore2_bagtype_bag_return ocl_ecore2_bagtype_bag() throws RecognitionException {
        OCLParser.ocl_ecore2_bagtype_bag_return retval = new OCLParser.ocl_ecore2_bagtype_bag_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.collectiontypeelementtype_return collectiontypeelementtype42 = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","BagType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"bag");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:726:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:727:3: ( collectiontypeelementtype[ret] )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:727:3: ( collectiontypeelementtype[ret] )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:727:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.40/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore2_bagtype_bag2030);
            collectiontypeelementtype42=collectiontypeelementtype(ret);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, collectiontypeelementtype42.getTree());
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.40/@templateSequence/@elements.1");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_bagtype_bag"

    public static class ecore_eclassifier_orderedset_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_eclassifier_orderedset"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:735:1: ecore_eclassifier_orderedset returns [Object ret2] : (ret= ecore_edatatype_orderedset ) ;
    public final OCLParser.ecore_eclassifier_orderedset_return ecore_eclassifier_orderedset() throws RecognitionException {
        OCLParser.ecore_eclassifier_orderedset_return retval = new OCLParser.ecore_eclassifier_orderedset_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ecore_edatatype_orderedset_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:736:3: ( (ret= ecore_edatatype_orderedset ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:737:3: (ret= ecore_edatatype_orderedset )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:737:3: (ret= ecore_edatatype_orderedset )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:737:4: ret= ecore_edatatype_orderedset
            {
            pushFollow(FOLLOW_ecore_edatatype_orderedset_in_ecore_eclassifier_orderedset2071);
            ret=ecore_edatatype_orderedset();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_eclassifier_orderedset"

    public static class ecore_edatatype_orderedset_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ecore_edatatype_orderedset"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:744:1: ecore_edatatype_orderedset returns [Object ret2] : (ret= ocl_ecore2_collectiontype_orderedset ) ;
    public final OCLParser.ecore_edatatype_orderedset_return ecore_edatatype_orderedset() throws RecognitionException {
        OCLParser.ecore_edatatype_orderedset_return retval = new OCLParser.ecore_edatatype_orderedset_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectiontype_orderedset_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:745:3: ( (ret= ocl_ecore2_collectiontype_orderedset ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:746:3: (ret= ocl_ecore2_collectiontype_orderedset )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:746:3: (ret= ocl_ecore2_collectiontype_orderedset )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:746:4: ret= ocl_ecore2_collectiontype_orderedset
            {
            pushFollow(FOLLOW_ocl_ecore2_collectiontype_orderedset_in_ecore_edatatype_orderedset2098);
            ret=ocl_ecore2_collectiontype_orderedset();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ecore_edatatype_orderedset"

    public static class ocl_ecore2_collectiontype_orderedset_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectiontype_orderedset"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:753:1: ocl_ecore2_collectiontype_orderedset returns [Object ret2] : (ret= ocl_ecore2_orderedsettype_orderedset ) ;
    public final OCLParser.ocl_ecore2_collectiontype_orderedset_return ocl_ecore2_collectiontype_orderedset() throws RecognitionException {
        OCLParser.ocl_ecore2_collectiontype_orderedset_return retval = new OCLParser.ocl_ecore2_collectiontype_orderedset_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_orderedsettype_orderedset_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:754:3: ( (ret= ocl_ecore2_orderedsettype_orderedset ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:755:3: (ret= ocl_ecore2_orderedsettype_orderedset )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:755:3: (ret= ocl_ecore2_orderedsettype_orderedset )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:755:4: ret= ocl_ecore2_orderedsettype_orderedset
            {
            pushFollow(FOLLOW_ocl_ecore2_orderedsettype_orderedset_in_ocl_ecore2_collectiontype_orderedset2125);
            ret=ocl_ecore2_orderedsettype_orderedset();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectiontype_orderedset"

    public static class ocl_ecore2_orderedsettype_orderedset_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_orderedsettype_orderedset"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:762:1: ocl_ecore2_orderedsettype_orderedset returns [Object ret2] : ( collectiontypeelementtype[ret] ) ;
    public final OCLParser.ocl_ecore2_orderedsettype_orderedset_return ocl_ecore2_orderedsettype_orderedset() throws RecognitionException {
        OCLParser.ocl_ecore2_orderedsettype_orderedset_return retval = new OCLParser.ocl_ecore2_orderedsettype_orderedset_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.collectiontypeelementtype_return collectiontypeelementtype43 = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","OrderedSetType");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"orderedset");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:768:3: ( ( collectiontypeelementtype[ret] ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:769:3: ( collectiontypeelementtype[ret] )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:769:3: ( collectiontypeelementtype[ret] )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:769:4: collectiontypeelementtype[ret]
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.44/@templateSequence/@elements.0");
            }
            pushFollow(FOLLOW_collectiontypeelementtype_in_ocl_ecore2_orderedsettype_orderedset2155);
            collectiontypeelementtype43=collectiontypeelementtype(ret);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, collectiontypeelementtype43.getTree());
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.44/@templateSequence/@elements.1");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_orderedsettype_orderedset"

    public static class collectiontypeelementtype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "collectiontypeelementtype"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:777:1: collectiontypeelementtype[Object ret] : () ;
    public final OCLParser.collectiontypeelementtype_return collectiontypeelementtype(Object ret) throws RecognitionException {
        OCLParser.collectiontypeelementtype_return retval = new OCLParser.collectiontypeelementtype_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:778:3: ( () )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:779:3: ()
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:779:3: ()
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:779:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.45/@functionSequence/@elements.0");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "elementType", null, null, "OCL:#context(collectionliteral).oclAsType(CollectionLiteralExp).part.eType->iterate("+"  								t; acc:EClass=null |"+"  									if acc->isEmpty() or acc=t then"+"  										t "+"  									else "+"  										if t.eAllSupertypes->includes(acc) then"+"  											acc "+"  										else "+"  											if acc.eAllSupertypes->includes(t) then"+"  												t "+"  											else "+"  												null "+"  											endif"+"  										endif"+"  									endif)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

                
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "collectiontypeelementtype"

    public static class ocl_expressions_collectionitem_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_collectionitem"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:786:1: ocl_expressions_collectionitem returns [Object ret2] : ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore2_collectionitem ) ) ;
    public final OCLParser.ocl_expressions_collectionitem_return ocl_expressions_collectionitem() throws RecognitionException {
        OCLParser.ocl_expressions_collectionitem_return retval = new OCLParser.ocl_expressions_collectionitem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectionitem_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:787:3: ( ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore2_collectionitem ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:788:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore2_collectionitem ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:788:3: ( ( ocl_expressions_collectionitem )=> (ret= ocl_ecore2_collectionitem ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:788:4: ( ocl_expressions_collectionitem )=> (ret= ocl_ecore2_collectionitem )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:788:38: (ret= ocl_ecore2_collectionitem )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:788:39: ret= ocl_ecore2_collectionitem
            {
            pushFollow(FOLLOW_ocl_ecore2_collectionitem_in_ocl_expressions_collectionitem2225);
            ret=ocl_ecore2_collectionitem();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }


            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_collectionitem"

    public static class ocl_ecore2_collectionitem_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectionitem"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:795:1: ocl_ecore2_collectionitem returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) ) ;
    public final OCLParser.ocl_ecore2_collectionitem_return ocl_ecore2_collectionitem() throws RecognitionException {
        OCLParser.ocl_ecore2_collectionitem_return retval = new OCLParser.ocl_ecore2_collectionitem_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_expressions_oclexpression_return temp = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","CollectionItem");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:801:3: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:802:3: ( (temp= ocl_expressions_oclexpression ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:802:3: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:802:4: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.47/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:802:140: (temp= ocl_expressions_oclexpression )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:802:142: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_collectionitem2260);
            temp=ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "item", temp);
              setParent(temp,ret,"item");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.47/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.item.eType", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectionitem"

    public static class ocl_expressions_collectionrange_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_collectionrange"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:811:1: ocl_expressions_collectionrange returns [Object ret2] : ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore2_collectionrange ) ) ;
    public final OCLParser.ocl_expressions_collectionrange_return ocl_expressions_collectionrange() throws RecognitionException {
        OCLParser.ocl_expressions_collectionrange_return retval = new OCLParser.ocl_expressions_collectionrange_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_collectionrange_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:812:3: ( ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore2_collectionrange ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:813:3: ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore2_collectionrange ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:813:3: ( ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore2_collectionrange ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:813:4: ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_ecore2_collectionrange )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:813:43: (ret= ocl_ecore2_collectionrange )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:813:44: ret= ocl_ecore2_collectionrange
            {
            pushFollow(FOLLOW_ocl_ecore2_collectionrange_in_ocl_expressions_collectionrange2310);
            ret=ocl_ecore2_collectionrange();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }


            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_collectionrange"

    public static class ocl_ecore2_collectionrange_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_collectionrange"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:820:1: ocl_ecore2_collectionrange returns [Object ret2] : ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) ;
    public final OCLParser.ocl_ecore2_collectionrange_return ocl_ecore2_collectionrange() throws RecognitionException {
        OCLParser.ocl_ecore2_collectionrange_return retval = new OCLParser.ocl_ecore2_collectionrange_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DDOT44=null;
        OCLParser.ocl_expressions_oclexpression_return temp = null;


        Object DDOT44_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","CollectionRange");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:826:3: ( ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:827:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:827:3: ( (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:827:4: (temp= ocl_expressions_oclexpression ) DDOT (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.49/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:827:140: (temp= ocl_expressions_oclexpression )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:827:142: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_collectionrange2345);
            temp=ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "first", temp);
              setParent(temp,ret,"first");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.49/@templateSequence/@elements.1");
            }
            DDOT44=(Token)match(input,DDOT,FOLLOW_DDOT_in_ocl_ecore2_collectionrange2352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DDOT44_tree = (Object)adaptor.create(DDOT44);
            adaptor.addChild(root_0, DDOT44_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.49/@templateSequence/@elements.2");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:828:341: (temp= ocl_expressions_oclexpression )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:828:343: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_collectionrange2360);
            temp=ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "last", temp);
              setParent(temp,ret,"last");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.49/@templateSequence/@elements.3");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:if self.first.eType=self.last.eType then"+"  	  						self.first.eType "+"  	  					  else "+"  	  					  	if self.first.eType.eAllSupertypes->includes(self.last.eType) then"+"  	  					  		self.last.eType "+"  	  					  	else "+"  	  					  		if self.last.eType.eAllSupertypes->includes(self.first.eType) then "+"  	  					  			self.first.eType "+"  	  					  		else "+"  	  					  			null "+"  	  					  		endif "+"  	  					  	endif "+"  	  					  endif", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_collectionrange"

    public static class ocl_ecore2_ifexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_ifexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:837:1: ocl_ecore2_ifexp returns [Object ret2] : ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' ) ;
    public final OCLParser.ocl_ecore2_ifexp_return ocl_ecore2_ifexp() throws RecognitionException {
        OCLParser.ocl_ecore2_ifexp_return retval = new OCLParser.ocl_ecore2_ifexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal45=null;
        Token string_literal46=null;
        Token string_literal47=null;
        Token string_literal48=null;
        OCLParser.ocl_expressions_oclexpression_return temp = null;


        Object string_literal45_tree=null;
        Object string_literal46_tree=null;
        Object string_literal47_tree=null;
        Object string_literal48_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","IfExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:843:3: ( ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:844:3: ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:844:3: ( 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:844:4: 'if' (temp= ocl_expressions_oclexpression )? 'then' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'else' ( ( (temp= ocl_expressions_oclexpression )? ) ) 'endif'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.0");
            }
            string_literal45=(Token)match(input,51,FOLLOW_51_in_ocl_ecore2_ifexp2406); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal45_tree = (Object)adaptor.create(string_literal45);
            adaptor.addChild(root_0, string_literal45_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:844:296: (temp= ocl_expressions_oclexpression )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==SNAME||LA12_0==QNAME||(LA12_0>=INT && LA12_0<=LPAREN)||LA12_0==34||LA12_0==36||(LA12_0>=43 && LA12_0<=44)||(LA12_0>=46 && LA12_0<=47)||LA12_0==49||(LA12_0>=51 && LA12_0<=52)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:844:298: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_ifexp2413);
                    temp=ocl_expressions_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "condition", temp);
                      setParent(temp,ret,"condition");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.2");
            }
            string_literal46=(Token)match(input,33,FOLLOW_33_in_ocl_ecore2_ifexp2421); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal46_tree = (Object)adaptor.create(string_literal46);
            adaptor.addChild(root_0, string_literal46_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.3");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:845:347: ( ( (temp= ocl_expressions_oclexpression )? ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:845:348: ( (temp= ocl_expressions_oclexpression )? )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:845:348: ( (temp= ocl_expressions_oclexpression )? )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:845:349: (temp= ocl_expressions_oclexpression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:845:512: (temp= ocl_expressions_oclexpression )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==SNAME||LA13_0==QNAME||(LA13_0>=INT && LA13_0<=LPAREN)||LA13_0==34||LA13_0==36||(LA13_0>=43 && LA13_0<=44)||(LA13_0>=46 && LA13_0<=47)||LA13_0==49||(LA13_0>=51 && LA13_0<=52)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:845:514: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_ifexp2431);
                    temp=ocl_expressions_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "thenExpression", temp);
                      setParent(temp,ret,"thenExpression");
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.4");
            }
            string_literal47=(Token)match(input,45,FOLLOW_45_in_ocl_ecore2_ifexp2442); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal47_tree = (Object)adaptor.create(string_literal47);
            adaptor.addChild(root_0, string_literal47_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.5");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:846:370: ( ( (temp= ocl_expressions_oclexpression )? ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:846:371: ( (temp= ocl_expressions_oclexpression )? )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:846:371: ( (temp= ocl_expressions_oclexpression )? )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:846:372: (temp= ocl_expressions_oclexpression )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.5/@blockSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:846:535: (temp= ocl_expressions_oclexpression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==SNAME||LA14_0==QNAME||(LA14_0>=INT && LA14_0<=LPAREN)||LA14_0==34||LA14_0==36||(LA14_0>=43 && LA14_0<=44)||(LA14_0>=46 && LA14_0<=47)||LA14_0==49||(LA14_0>=51 && LA14_0<=52)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:846:537: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_ifexp2452);
                    temp=ocl_expressions_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elseExpression", temp);
                      setParent(temp,ret,"elseExpression");
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.6");
            }
            string_literal48=(Token)match(input,48,FOLLOW_48_in_ocl_ecore2_ifexp2463); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal48_tree = (Object)adaptor.create(string_literal48);
            adaptor.addChild(root_0, string_literal48_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.50/@templateSequence/@elements.7");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'if '.concat(self.condition.name)", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:if self.thenExpression.type=self.elseExpression.eType then"+"  	                          self.thenExpression.eType"+"  	                      else"+"  	                          if self.thenExpression.eType.eAllSupertypes->includes(self.elseExpression.eType) then"+"  	                              self.elseExpression.eType"+"  	                          else"+"  	                              if self.elseExpression.eType.eAllSupertypes->includes(self.thenExpression.eType) then"+"  	                                  self.thenExpression.eType"+"  	                              else"+"  	                                  null"+"  	                              endif"+"  	                          endif"+"  	                      endif", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_ifexp"

    public static class ocl_ecore2_letexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_letexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:855:1: ocl_ecore2_letexp returns [Object ret2] : ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) ;
    public final OCLParser.ocl_ecore2_letexp_return ocl_ecore2_letexp() throws RecognitionException {
        OCLParser.ocl_ecore2_letexp_return retval = new OCLParser.ocl_ecore2_letexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal49=null;
        Token string_literal50=null;
        OCLParser.ocl_expressions_oclexpression_return temp = null;


        Object string_literal49_tree=null;
        Object string_literal50_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","LetExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:861:3: ( ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:862:3: ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:862:3: ( 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:862:4: 'let' (temp= ocl_expressions_variable_let ) 'in' ( ( (temp= ocl_expressions_oclexpression ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.51/@templateSequence/@elements.0");
            }
            string_literal49=(Token)match(input,47,FOLLOW_47_in_ocl_ecore2_letexp2506); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal49_tree = (Object)adaptor.create(string_literal49);
            adaptor.addChild(root_0, string_literal49_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.51/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:862:297: (temp= ocl_expressions_variable_let )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:862:299: temp= ocl_expressions_variable_let
            {
            pushFollow(FOLLOW_ocl_expressions_variable_let_in_ocl_ecore2_letexp2513);
            temp=ocl_expressions_variable_let();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "variable", temp);
              setParent(temp,ret,"variable");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.51/@templateSequence/@elements.2");
            }
            string_literal50=(Token)match(input,42,FOLLOW_42_in_ocl_ecore2_letexp2519); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal50_tree = (Object)adaptor.create(string_literal50);
            adaptor.addChild(root_0, string_literal50_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.51/@templateSequence/@elements.3");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:863:342: ( ( (temp= ocl_expressions_oclexpression ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:863:343: ( (temp= ocl_expressions_oclexpression ) )
            {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:863:343: ( (temp= ocl_expressions_oclexpression ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:863:344: (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.51/@templateSequence/@elements.3/@blockSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:863:507: (temp= ocl_expressions_oclexpression )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:863:509: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_letexp2529);
            temp=ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.51/@templateSequence/@elements.4");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.\"in\".eType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'let '.concat(self.variable.name)", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_letexp"

    public static class ocl_expressions_variable_let_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_variable_let"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:872:1: ocl_expressions_variable_let returns [Object ret2] : (ret= ocl_ecore2_variable_let ) ;
    public final OCLParser.ocl_expressions_variable_let_return ocl_expressions_variable_let() throws RecognitionException {
        OCLParser.ocl_expressions_variable_let_return retval = new OCLParser.ocl_expressions_variable_let_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_variable_let_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:873:3: ( (ret= ocl_ecore2_variable_let ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:874:3: (ret= ocl_ecore2_variable_let )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:874:3: (ret= ocl_ecore2_variable_let )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:874:4: ret= ocl_ecore2_variable_let
            {
            pushFollow(FOLLOW_ocl_ecore2_variable_let_in_ocl_expressions_variable_let2575);
            ret=ocl_ecore2_variable_let();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_variable_let"

    public static class ocl_ecore2_variable_let_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_variable_let"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:881:1: ocl_ecore2_variable_let returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) ) ;
    public final OCLParser.ocl_ecore2_variable_let_return ocl_ecore2_variable_let() throws RecognitionException {
        OCLParser.ocl_ecore2_variable_let_return retval = new OCLParser.ocl_ecore2_variable_let_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON51=null;
        Token char_literal52=null;
        OCLParser.ocl_expressions_oclexpression_return temp = null;


        Object COLON51_tree=null;
        Object char_literal52_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"let");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:887:3: ( ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:888:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:888:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:888:4: (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) '=' (temp= ocl_expressions_oclexpression )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:888:140: (temp= identifier )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:888:142: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore2_variable_let2609);
            temp=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:889:182: ( () | ( COLON (temp= identifier ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==39) ) {
                alt15=1;
            }
            else if ( (LA15_0==COLON) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:889:183: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:889:199: ()
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:889:200: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.1/@sequences.0/@elements.0");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.initExpression.eType", true);_exitInjectorAction();
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:20: ( COLON (temp= identifier ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.0");
                    }
                    COLON51=(Token)match(input,COLON,FOLLOW_COLON_in_ocl_ecore2_variable_let2634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON51_tree = (Object)adaptor.create(COLON51);
                    adaptor.addChild(root_0, COLON51_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:366: (temp= identifier )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:368: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore2_variable_let2642);
                    temp=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "eType", null, temp, "OCL:EClassifier.allInstances()->select(name=?)");
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.2");
            }
            char_literal52=(Token)match(input,39,FOLLOW_39_in_ocl_ecore2_variable_let2653); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal52_tree = (Object)adaptor.create(char_literal52);
            adaptor.addChild(root_0, char_literal52_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.3");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:812: (temp= ocl_expressions_oclexpression )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:890:814: temp= ocl_expressions_oclexpression
            {
            pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_variable_let2660);
            temp=ocl_expressions_oclexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "initExpression", temp);
              setParent(temp,ret,"initExpression");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.53/@templateSequence/@elements.4");
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_variable_let"

    public static class ocl_expressions_variable_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_variable"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:899:1: ocl_expressions_variable returns [Object ret2] : (ret= ocl_ecore2_variable ) ;
    public final OCLParser.ocl_expressions_variable_return ocl_expressions_variable() throws RecognitionException {
        OCLParser.ocl_expressions_variable_return retval = new OCLParser.ocl_expressions_variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_variable_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:900:3: ( (ret= ocl_ecore2_variable ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:901:3: (ret= ocl_ecore2_variable )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:901:3: (ret= ocl_ecore2_variable )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:901:4: ret= ocl_ecore2_variable
            {
            pushFollow(FOLLOW_ocl_ecore2_variable_in_ocl_expressions_variable2703);
            ret=ocl_ecore2_variable();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_variable"

    public static class ocl_ecore2_variable_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_variable"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:908:1: ocl_ecore2_variable returns [Object ret2] : ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) ) ;
    public final OCLParser.ocl_ecore2_variable_return ocl_ecore2_variable() throws RecognitionException {
        OCLParser.ocl_ecore2_variable_return retval = new OCLParser.ocl_ecore2_variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COLON53=null;
        Token char_literal54=null;
        OCLParser.ocl_expressions_oclexpression_return temp = null;


        Object COLON53_tree=null;
        Object char_literal54_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:914:3: ( ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:915:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:915:3: ( (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:915:4: (temp= identifier ) ( () | ( COLON (temp= identifier ) ) ) ( ( '=' (temp= ocl_expressions_oclexpression ) ) | )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:915:140: (temp= identifier )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:915:142: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_ocl_ecore2_variable2737);
            temp=identifier();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setProperty(ret, "name", temp);
              setParent(temp,ret,"name");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.1");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:916:182: ( () | ( COLON (temp= identifier ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SNAME||LA16_0==COMMA||LA16_0==35||LA16_0==39||LA16_0==41) ) {
                alt16=1;
            }
            else if ( (LA16_0==COLON) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:916:183: ()
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:916:199: ()
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:916:200: 
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.1/@sequences.0/@elements.0");
                    }
                    if ( state.backtracking==0 ) {
                      _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(PropertyCallExp).source.eType", true);_exitInjectorAction();
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:4: ( COLON (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:20: ( COLON (temp= identifier ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:21: COLON (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.0");
                    }
                    COLON53=(Token)match(input,COLON,FOLLOW_COLON_in_ocl_ecore2_variable2762); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON53_tree = (Object)adaptor.create(COLON53);
                    adaptor.addChild(root_0, COLON53_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:366: (temp= identifier )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:368: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore2_variable2770);
                    temp=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "eType", null, temp, "OCL:EClassifier.allInstances()->select(name=?)");
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.2");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:658: ( ( '=' (temp= ocl_expressions_oclexpression ) ) | )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            else if ( (LA17_0==SNAME||LA17_0==COMMA||LA17_0==35||LA17_0==41) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:659: ( '=' (temp= ocl_expressions_oclexpression ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:675: ( '=' (temp= ocl_expressions_oclexpression ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:676: '=' (temp= ocl_expressions_oclexpression )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.0");
                    }
                    char_literal54=(Token)match(input,39,FOLLOW_39_in_ocl_ecore2_variable2787); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal54_tree = (Object)adaptor.create(char_literal54);
                    adaptor.addChild(root_0, char_literal54_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.1");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:1019: (temp= ocl_expressions_oclexpression )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:917:1021: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_variable2794);
                    temp=ocl_expressions_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:918:74: 
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_variable"

    public static class ocl_ecore2_variableexp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_variableexp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:927:1: ocl_ecore2_variableexp returns [Object ret2] : ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) ) ;
    public final OCLParser.ocl_ecore2_variableexp_return ocl_ecore2_variableexp() throws RecognitionException {
        OCLParser.ocl_ecore2_variableexp_return retval = new OCLParser.ocl_ecore2_variableexp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.identifier_return temp = null;



        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","VariableExp");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType);
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:933:3: ( ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:3: ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:3: ( ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:4: ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.56/@templateSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:140: ( ( (temp= ocl_expressions_variable_self ) ) | ( (temp= identifier ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            else if ( (LA18_0==SNAME) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:141: ( (temp= ocl_expressions_variable_self ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:157: ( (temp= ocl_expressions_variable_self ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:158: (temp= ocl_expressions_variable_self )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.56/@templateSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:319: (temp= ocl_expressions_variable_self )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:934:321: temp= ocl_expressions_variable_self
                    {
                    pushFollow(FOLLOW_ocl_expressions_variable_self_in_ocl_ecore2_variableexp2859);
                    temp=ocl_expressions_variable_self();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
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
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:936:4: ( (temp= identifier ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:936:20: ( (temp= identifier ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:936:21: (temp= identifier )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.56/@templateSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:936:182: (temp= identifier )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:936:184: temp= identifier
                    {
                    pushFollow(FOLLOW_identifier_in_ocl_ecore2_variableexp2879);
                    temp=identifier();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setOclRef(ret, "referredVariable", null, temp, "OCL:ecore::Variable.allInstances()->select(v | v.name =?)");
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
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.56/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.referredVariable.eType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredVariable.name", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_variableexp"

    public static class ocl_expressions_variable_self_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_variable_self"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:944:1: ocl_expressions_variable_self returns [Object ret2] : (ret= ocl_ecore2_variable_self ) ;
    public final OCLParser.ocl_expressions_variable_self_return ocl_expressions_variable_self() throws RecognitionException {
        OCLParser.ocl_expressions_variable_self_return retval = new OCLParser.ocl_expressions_variable_self_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_variable_self_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:945:3: ( (ret= ocl_ecore2_variable_self ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:946:3: (ret= ocl_ecore2_variable_self )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:946:3: (ret= ocl_ecore2_variable_self )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:946:4: ret= ocl_ecore2_variable_self
            {
            pushFollow(FOLLOW_ocl_ecore2_variable_self_in_ocl_expressions_variable_self2927);
            ret=ocl_ecore2_variable_self();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_variable_self"

    public static class ocl_ecore2_variable_self_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_variable_self"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:953:1: ocl_ecore2_variable_self returns [Object ret2] : ( 'self' ) ;
    public final OCLParser.ocl_ecore2_variable_self_return ocl_ecore2_variable_self() throws RecognitionException {
        OCLParser.ocl_ecore2_variable_self_return retval = new OCLParser.ocl_ecore2_variable_self_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal55=null;

        Object string_literal55_tree=null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"self");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:959:3: ( ( 'self' ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:960:3: ( 'self' )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:960:3: ( 'self' )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:960:4: 'self'
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.58/@templateSequence/@elements.0");
            }
            string_literal55=(Token)match(input,36,FOLLOW_36_in_ocl_ecore2_variable_self2957); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal55_tree = (Object)adaptor.create(string_literal55);
            adaptor.addChild(root_0, string_literal55_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.58/@templateSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "self");_exitInjectorAction();_enterInjectorAction();setRef(ret, "eType", list("ecore","EClassifier"), null, null, "#context(class)", null, null, false, null, true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_variable_self"

    public static class ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:968:1: ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) '|' (temp= ocl_expressions_oclexpression )? RPAREN ) ;
    public final OCLParser.ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_return ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        OCLParser.ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_return retval = new OCLParser.ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal56=null;
        Token LPAREN57=null;
        Token char_literal58=null;
        Token string_literal59=null;
        Token LPAREN60=null;
        Token COMMA61=null;
        Token string_literal62=null;
        Token LPAREN63=null;
        Token COMMA64=null;
        Token char_literal65=null;
        Token RPAREN66=null;
        OCLParser.ocl_expressions_oclexpression_return temp = null;


        Object string_literal56_tree=null;
        Object LPAREN57_tree=null;
        Object char_literal58_tree=null;
        Object string_literal59_tree=null;
        Object LPAREN60_tree=null;
        Object COMMA61_tree=null;
        Object string_literal62_tree=null;
        Object LPAREN63_tree=null;
        Object COMMA64_tree=null;
        Object char_literal65_tree=null;
        Object RPAREN66_tree=null;

        List<String> metaType=list("ocl","ecore2","IterateExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:973:3: ( ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) '|' (temp= ocl_expressions_oclexpression )? RPAREN ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:3: ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) '|' (temp= ocl_expressions_oclexpression )? RPAREN )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:3: ( ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) '|' (temp= ocl_expressions_oclexpression )? RPAREN )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:4: ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) ) '|' (temp= ocl_expressions_oclexpression )? RPAREN
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:134: ( ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) ) | ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) | ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? ) )
            int alt26=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt26=1;
                }
                break;
            case 50:
                {
                alt26=2;
                }
                break;
            case 38:
                {
                alt26=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:135: ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:151: ( 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) ) )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:152: 'iterate' LPAREN (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )? ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) )
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.0");
                    }
                    string_literal56=(Token)match(input,40,FOLLOW_40_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal56_tree = (Object)adaptor.create(string_literal56);
                    adaptor.addChild(root_0, string_literal56_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.1");
                    }
                    LPAREN57=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3010); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN57_tree = (Object)adaptor.create(LPAREN57);
                    adaptor.addChild(root_0, LPAREN57_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.2");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:666: (temp= ocl_expressions_variable (temp= ocl_expressions_variable )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==SNAME) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:974:668: temp= ocl_expressions_variable (temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3018);
                            temp=ocl_expressions_variable();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:975:34: (temp= ocl_expressions_variable )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==SNAME) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:975:36: temp= ocl_expressions_variable
                            	    {
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3026);
                            	    temp=ocl_expressions_variable();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.3");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:976:210: ( ( ';' (temp= ocl_expressions_variable ) ) | ( (temp= ocl_expressions_variable_implicitAccumulator ) ) )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==35) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==41) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:976:211: ( ';' (temp= ocl_expressions_variable ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(0);
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:976:227: ( ';' (temp= ocl_expressions_variable ) )
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:976:228: ';' (temp= ocl_expressions_variable )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.0");
                            }
                            char_literal58=(Token)match(input,35,FOLLOW_35_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3042); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            char_literal58_tree = (Object)adaptor.create(char_literal58);
                            adaptor.addChild(root_0, char_literal58_tree);
                            }
                            if ( state.backtracking==0 ) {
                              _afterSeqEl();
                            }
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.1");
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:976:607: (temp= ocl_expressions_variable )
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:976:609: temp= ocl_expressions_variable
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3049);
                            temp=ocl_expressions_variable();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
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
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:978:4: ( (temp= ocl_expressions_variable_implicitAccumulator ) )
                            {
                            if ( state.backtracking==0 ) {
                              _enterAlt(1);
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:978:20: ( (temp= ocl_expressions_variable_implicitAccumulator ) )
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:978:21: (temp= ocl_expressions_variable_implicitAccumulator )
                            {
                            if ( state.backtracking==0 ) {
                              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.0/@elements.3/@sequences.1/@elements.0");
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:978:201: (temp= ocl_expressions_variable_implicitAccumulator )
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:978:203: temp= ocl_expressions_variable_implicitAccumulator
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_implicitAccumulator_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3069);
                            temp=ocl_expressions_variable_implicitAccumulator();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
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

                    }

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:980:4: ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:980:20: ( 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:980:21: 'forAll' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.1/@elements.0");
                    }
                    string_literal59=(Token)match(input,50,FOLLOW_50_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3090); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal59_tree = (Object)adaptor.create(string_literal59);
                    adaptor.addChild(root_0, string_literal59_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.1/@elements.1");
                    }
                    LPAREN60=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN60_tree = (Object)adaptor.create(LPAREN60);
                    adaptor.addChild(root_0, LPAREN60_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.1/@elements.2");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:980:534: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==SNAME) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:980:536: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3102);
                            temp=ocl_expressions_variable();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:981:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==COMMA) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:981:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:981:52: ( COMMA )
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:981:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.1/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    COMMA61=(Token)match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3111); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    COMMA61_tree = (Object)adaptor.create(COMMA61);
                            	    adaptor.addChild(root_0, COMMA61_tree);
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3119);
                            	    temp=ocl_expressions_variable();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
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

                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 3 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:983:4: ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(2);
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:983:20: ( 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )? )
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:983:21: 'collect' LPAREN (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.2/@elements.0");
                    }
                    string_literal62=(Token)match(input,38,FOLLOW_38_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal62_tree = (Object)adaptor.create(string_literal62);
                    adaptor.addChild(root_0, string_literal62_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.2/@elements.1");
                    }
                    LPAREN63=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3144); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN63_tree = (Object)adaptor.create(LPAREN63);
                    adaptor.addChild(root_0, LPAREN63_tree);
                    }
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.2/@elements.2");
                    }
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:983:535: (temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==SNAME) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:983:537: temp= ocl_expressions_variable ( ( COMMA ) temp= ocl_expressions_variable )*
                            {
                            pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3152);
                            temp=ocl_expressions_variable();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                            if ( state.backtracking==0 ) {
                              setProperty(ret, "iterator", temp);
                              setParent(temp,ret,"iterator");
                            }
                            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:984:34: ( ( COMMA ) temp= ocl_expressions_variable )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==COMMA) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:984:35: ( COMMA ) temp= ocl_expressions_variable
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _enterSepSeq();
                            	    }
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:984:52: ( COMMA )
                            	    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:984:53: COMMA
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	      _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.0/@sequences.2/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");
                            	    }
                            	    COMMA64=(Token)match(input,COMMA,FOLLOW_COMMA_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3161); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) {
                            	    COMMA64_tree = (Object)adaptor.create(COMMA64);
                            	    adaptor.addChild(root_0, COMMA64_tree);
                            	    }
                            	    if ( state.backtracking==0 ) {
                            	      _afterSeqEl();
                            	    }

                            	    }

                            	    if ( state.backtracking==0 ) {
                            	      _exitSepSeq();
                            	    }
                            	    pushFollow(FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3169);
                            	    temp=ocl_expressions_variable();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                            	    if ( state.backtracking==0 ) {
                            	      setProperty(ret, "iterator", temp);
                            	      setParent(temp,ret,"iterator");
                            	    }

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
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
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.1");
            }
            char_literal65=(Token)match(input,41,FOLLOW_41_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3185); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal65_tree = (Object)adaptor.create(char_literal65);
            adaptor.addChild(root_0, char_literal65_tree);
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.2");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:985:366: (temp= ocl_expressions_oclexpression )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==SNAME||LA27_0==QNAME||(LA27_0>=INT && LA27_0<=LPAREN)||LA27_0==34||LA27_0==36||(LA27_0>=43 && LA27_0<=44)||(LA27_0>=46 && LA27_0<=47)||LA27_0==49||(LA27_0>=51 && LA27_0<=52)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:985:368: temp= ocl_expressions_oclexpression
                    {
                    pushFollow(FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3192);
                    temp=ocl_expressions_oclexpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "body", temp);
                      setParent(temp,ret,"body");
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.59/@otSequence/@elements.3");
            }
            RPAREN66=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3201); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN66_tree = (Object)adaptor.create(RPAREN66);
            adaptor.addChild(root_0, RPAREN66_tree);
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp"

    public static class ocl_expressions_variable_implicitAccumulator_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_expressions_variable_implicitAccumulator"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:997:1: ocl_expressions_variable_implicitAccumulator returns [Object ret2] : (ret= ocl_ecore2_variable_implicitAccumulator ) ;
    public final OCLParser.ocl_expressions_variable_implicitAccumulator_return ocl_expressions_variable_implicitAccumulator() throws RecognitionException {
        OCLParser.ocl_expressions_variable_implicitAccumulator_return retval = new OCLParser.ocl_expressions_variable_implicitAccumulator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.ocl_ecore2_variable_implicitAccumulator_return ret = null;



        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:998:3: ( (ret= ocl_ecore2_variable_implicitAccumulator ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:999:3: (ret= ocl_ecore2_variable_implicitAccumulator )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:999:3: (ret= ocl_ecore2_variable_implicitAccumulator )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:999:4: ret= ocl_ecore2_variable_implicitAccumulator
            {
            pushFollow(FOLLOW_ocl_ecore2_variable_implicitAccumulator_in_ocl_expressions_variable_implicitAccumulator3231);
            ret=ocl_ecore2_variable_implicitAccumulator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, ret.getTree());

            }

            if ( state.backtracking==0 ) {

              ret2=ret;
               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ocl_expressions_variable_implicitAccumulator"

    public static class ocl_ecore2_variable_implicitAccumulator_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_variable_implicitAccumulator"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1006:1: ocl_ecore2_variable_implicitAccumulator returns [Object ret2] : () ;
    public final OCLParser.ocl_ecore2_variable_implicitAccumulator_return ocl_ecore2_variable_implicitAccumulator() throws RecognitionException {
        OCLParser.ocl_ecore2_variable_implicitAccumulator_return retval = new OCLParser.ocl_ecore2_variable_implicitAccumulator_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        IModelElementProxy ret;
        List<String> metaType=list("ocl","ecore2","Variable");
        ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        onEnterTemplateRule(metaType,"implicitAccumulator");
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1012:3: ( () )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1013:3: ()
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1013:3: ()
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1013:4: 
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.61/@templateSequence/@elements.0");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setProperty(ret, "name", "acc");_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(IterateExp).\"body\".eType", true);_exitInjectorAction();
            }
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_variable_implicitAccumulator"

    public static class ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp_return extends ParserRuleReturnScope {
        public Object ret2;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp"
    // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1021:1: ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ( (temp= identifierOrKeyword ) ) ;
    public final OCLParser.ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp_return ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        OCLParser.ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp_return retval = new OCLParser.ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OCLParser.identifierOrKeyword_return temp = null;



        List<String> metaType=list("ocl","ecore2","PropertyCallExp");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;


        try {
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1026:3: ( ( (temp= identifierOrKeyword ) ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1027:3: ( (temp= identifierOrKeyword ) )
            {
            root_0 = (Object)adaptor.nil();

            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1027:3: ( (temp= identifierOrKeyword ) )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1027:4: (temp= identifierOrKeyword )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.62/@otSequence/@elements.0");
            }
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1027:134: (temp= identifierOrKeyword )
            // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:1027:136: temp= identifierOrKeyword
            {
            pushFollow(FOLLOW_identifierOrKeyword_in_ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp3306);
            temp=identifierOrKeyword();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, temp.getTree());
            if ( state.backtracking==0 ) {
              setOclRef(ret, "referredProperty", null, temp, "OCL:self.source.eType.allSupertypes()->append(self.source.eType)."+"  												contents->select(a | a.oclIsKindOf(EProperty))->select(a|a.name=?)");
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl("http://www.furcas.org/transientParsingResource_-0ZbwTKwEeCV8ZWoJ3o1Qw#/74/@templates.62/@otSequence/@elements.1");
            }
            if ( state.backtracking==0 ) {
              _enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredProperty.name", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.referredProperty.eType", true);_exitInjectorAction();
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

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            onExitTemplateRule(metaType);
        }
        return retval;
    }
    // $ANTLR end "ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp"

    // $ANTLR start synpred1_OCL
    public final void synpred1_OCL_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:50: ( '.' ( ( identifier ~ LPAREN ) ) )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:51: '.' ( ( identifier ~ LPAREN ) )
        {
        match(input,37,FOLLOW_37_in_synpred1_OCL801); if (state.failed) return ;
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:54: ( ( identifier ~ LPAREN ) )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:55: ( identifier ~ LPAREN )
        {
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:55: ( identifier ~ LPAREN )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:401:56: identifier ~ LPAREN
        {
        pushFollow(FOLLOW_identifier_in_synpred1_OCL804);
        identifier();

        state._fsp--;
        if (state.failed) return ;
        if ( (input.LA(1)>=SNAME && input.LA(1)<=BOOL)||(input.LA(1)>=RPAREN && input.LA(1)<=53) ) {
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


        }
    }
    // $ANTLR end synpred1_OCL

    // $ANTLR start synpred3_OCL
    public final void synpred3_OCL_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:3: ( '->' )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:402:4: '->'
        {
        match(input,53,FOLLOW_53_in_synpred3_OCL839); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_OCL

    // $ANTLR start synpred4_OCL
    public final void synpred4_OCL_fragment() throws RecognitionException {   
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:543:5: ( ocl_expressions_oclexpression COMMA )
        // C:\\FURCAS_EMF\\FURCASEMF\\DSLEngineering\\com.sap.furcas.parsergenerator.test\\generationTemp\\generated\\OCL.g:543:6: ocl_expressions_oclexpression COMMA
        {
        pushFollow(FOLLOW_ocl_expressions_oclexpression_in_synpred4_OCL1350);
        ocl_expressions_oclexpression();

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred4_OCL1352); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_OCL

    // Delegated rules

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


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\22\uffff";
    static final String DFA8_eofS =
        "\22\uffff";
    static final String DFA8_minS =
        "\1\4\17\0\2\uffff";
    static final String DFA8_maxS =
        "\1\64\17\0\2\uffff";
    static final String DFA8_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA8_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\2\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\16\2\uffff\1\5\1\uffff\1\1\1\2\1\4\1\17\25\uffff\1\11\1"+
            "\uffff\1\15\6\uffff\1\12\1\6\1\uffff\1\3\1\14\1\uffff\1\7\1"+
            "\uffff\1\13\1\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "542:3: (ret= ocl_expressions_collectionitem | ( ocl_expressions_oclexpression COMMA )=> (ret= ocl_expressions_collectionrange ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_3 = input.LA(1);

                         
                        int index8_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_4 = input.LA(1);

                         
                        int index8_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA8_8 = input.LA(1);

                         
                        int index8_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA8_10 = input.LA(1);

                         
                        int index8_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA8_13 = input.LA(1);

                         
                        int index8_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA8_14 = input.LA(1);

                         
                        int index8_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (true) ) {s = 16;}

                        else if ( (synpred4_OCL()) ) {s = 17;}

                         
                        input.seek(index8_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_SNAME_in_identifier61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifierOrKeyword91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_identifierOrKeyword99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_identifierOrKeyword107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_identifierOrKeyword115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_identifierOrKeyword123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_identifierOrKeyword131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_identifierOrKeyword139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_identifierOrKeyword147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_identifierOrKeyword155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_identifierOrKeyword163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_identifierOrKeyword171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_identifierOrKeyword179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_identifierOrKeyword187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_identifierOrKeyword195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_identifierOrKeyword203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_identifierOrKeyword211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_identifierOrKeyword219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_identifierOrKeyword227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_identifierOrKeyword235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_identifierOrKeyword243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_identifierOrKeyword251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_identifierOrKeyword259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringSymbol290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QNAME_in_qualifiedNameSymbol321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MULTI_LINE_COMMENT_in_annotationSymbol352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerSymbol383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_longSymbol414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_integerAsString445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatAsString476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanSymbol507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_booleanValueSymbol538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_floatSymbol569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_realSymbol600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_doubleSymbol631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_literalexp_in_ocl_ecore2_oclexpression658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_ifexp_in_ocl_ecore2_oclexpression666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_letexp_in_ocl_ecore2_oclexpression674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_variableexp_in_ocl_ecore2_oclexpression682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_main710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_oclexpression_in_primary_ocl_expressions_oclexpression741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_ocl_expressions_oclexpression750 = new BitSet(new long[]{0x001AD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_primary_ocl_expressions_oclexpression756 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_primary_ocl_expressions_oclexpression760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_ocl_expressions_oclexpression_in_oclexpressions_priority_0798 = new BitSet(new long[]{0x0020002000000002L});
    public static final BitSet FOLLOW_37_in_oclexpressions_priority_0815 = new BitSet(new long[]{0x003FFFFE00000020L});
    public static final BitSet FOLLOW_ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp_in_oclexpressions_priority_0829 = new BitSet(new long[]{0x0020002000000002L});
    public static final BitSet FOLLOW_53_in_oclexpressions_priority_0845 = new BitSet(new long[]{0x0004014000000000L});
    public static final BitSet FOLLOW_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp_in_oclexpressions_priority_0852 = new BitSet(new long[]{0x0020002000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_0_in_oclexpressions_priority_1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oclexpressions_priority_1_in_ocl_expressions_oclexpression928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_primitiveliteralexp_in_ocl_ecore2_literalexp954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_enumliteralexp_in_ocl_ecore2_literalexp962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectionliteralexp_in_ocl_ecore2_literalexp970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_numericliteralexp_in_ocl_ecore2_primitiveliteralexp997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_stringliteralexp_in_ocl_ecore2_primitiveliteralexp1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_booleanliteralexp_in_ocl_ecore2_primitiveliteralexp1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_integerliteralexp_in_ocl_ecore2_numericliteralexp1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_realliteralexp_in_ocl_ecore2_numericliteralexp1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_integerSymbol_in_ocl_ecore2_integerliteralexp1082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ocl_ecore2_stringliteralexp1128 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_stringliteralexp1135 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ocl_ecore2_stringliteralexp1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realSymbol_in_ocl_ecore2_realliteralexp1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_booleanValueSymbol_in_ocl_ecore2_booleanliteralexp1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedNameSymbol_in_ocl_ecore2_enumliteralexp1288 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DCOLON_in_ocl_ecore2_enumliteralexp1295 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_enumliteralexp1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionitem_in_ocl_expressions_collectionliteralpart1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_collectionrange_in_ocl_expressions_collectionliteralpart1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ocl_ecore2_collectionliteralexp1394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_sequence_in_ocl_ecore2_collectionliteralexp1401 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_49_in_ocl_ecore2_collectionliteralexp1420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_set_in_ocl_ecore2_collectionliteralexp1427 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_52_in_ocl_ecore2_collectionliteralexp1446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_collection_in_ocl_ecore2_collectionliteralexp1453 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_34_in_ocl_ecore2_collectionliteralexp1472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_bag_in_ocl_ecore2_collectionliteralexp1479 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_43_in_ocl_ecore2_collectionliteralexp1498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_ecore_eclassifier_orderedset_in_ocl_ecore2_collectionliteralexp1505 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_LCURL_in_ocl_ecore2_collectionliteralexp1520 = new BitSet(new long[]{0x001AD81400021E90L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore2_collectionliteralexp1528 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore2_collectionliteralexp1537 = new BitSet(new long[]{0x001AD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_collectionliteralpart_in_ocl_ecore2_collectionliteralexp1545 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_RCURL_in_ocl_ecore2_collectionliteralexp1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_sequence_in_ecore_eclassifier_sequence1598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectiontype_sequence_in_ecore_edatatype_sequence1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_sequencetype_sequence_in_ocl_ecore2_collectiontype_sequence1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore2_sequencetype_sequence1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_set_in_ecore_eclassifier_set1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectiontype_set_in_ecore_edatatype_set1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_settype_set_in_ocl_ecore2_collectiontype_set1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore2_settype_set1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_collection_in_ecore_eclassifier_collection1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectiontype_collection_in_ecore_edatatype_collection1875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore2_collectiontype_collection1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_bag_in_ecore_eclassifier_bag1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectiontype_bag_in_ecore_edatatype_bag1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_bagtype_bag_in_ocl_ecore2_collectiontype_bag2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore2_bagtype_bag2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ecore_edatatype_orderedset_in_ecore_eclassifier_orderedset2071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectiontype_orderedset_in_ecore_edatatype_orderedset2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_orderedsettype_orderedset_in_ocl_ecore2_collectiontype_orderedset2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collectiontypeelementtype_in_ocl_ecore2_orderedsettype_orderedset2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectionitem_in_ocl_expressions_collectionitem2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_collectionitem2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_collectionrange_in_ocl_expressions_collectionrange2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_collectionrange2345 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DDOT_in_ocl_ecore2_collectionrange2352 = new BitSet(new long[]{0x001AD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_collectionrange2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ocl_ecore2_ifexp2406 = new BitSet(new long[]{0x001AD81600001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_ifexp2413 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ocl_ecore2_ifexp2421 = new BitSet(new long[]{0x001AF81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_ifexp2431 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ocl_ecore2_ifexp2442 = new BitSet(new long[]{0x001BD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_ifexp2452 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ocl_ecore2_ifexp2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ocl_ecore2_letexp2506 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_let_in_ocl_ecore2_letexp2513 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ocl_ecore2_letexp2519 = new BitSet(new long[]{0x001AD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_letexp2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_variable_let_in_ocl_expressions_variable_let2575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_variable_let2609 = new BitSet(new long[]{0x0000008000080000L});
    public static final BitSet FOLLOW_COLON_in_ocl_ecore2_variable_let2634 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_variable_let2642 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ocl_ecore2_variable_let2653 = new BitSet(new long[]{0x001AD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_variable_let2660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_variable_in_ocl_expressions_variable2703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_variable2737 = new BitSet(new long[]{0x0000008000080002L});
    public static final BitSet FOLLOW_COLON_in_ocl_ecore2_variable2762 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_variable2770 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ocl_ecore2_variable2787 = new BitSet(new long[]{0x001AD81400001E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_variable2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_variable_self_in_ocl_ecore2_variableexp2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_ocl_ecore2_variableexp2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_variable_self_in_ocl_expressions_variable_self2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ocl_ecore2_variable_self2957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3006 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3010 = new BitSet(new long[]{0x001AD81C00000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3018 = new BitSet(new long[]{0x001AD81C00000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3026 = new BitSet(new long[]{0x001AD81C00000E90L});
    public static final BitSet FOLLOW_35_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3042 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3049 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ocl_expressions_variable_implicitAccumulator_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3069 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_50_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3090 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3094 = new BitSet(new long[]{0x001ADA1400000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3102 = new BitSet(new long[]{0x0000020000010000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3111 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3119 = new BitSet(new long[]{0x0000020000010000L});
    public static final BitSet FOLLOW_38_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3140 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_LPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3144 = new BitSet(new long[]{0x001ADA1400000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3152 = new BitSet(new long[]{0x0000020000010000L});
    public static final BitSet FOLLOW_COMMA_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3161 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_ocl_expressions_variable_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3169 = new BitSet(new long[]{0x0000020000010000L});
    public static final BitSet FOLLOW_41_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3185 = new BitSet(new long[]{0x001AD81400003E90L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3192 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_ocl_ecore2_iterateexp_ocl_ecore2_IterateExp_arrowOp3201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_ecore2_variable_implicitAccumulator_in_ocl_expressions_variable_implicitAccumulator3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierOrKeyword_in_ocl_ecore2_propertycallexp_ocl_ecore2_PropertyCallExp_dotOp3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_synpred1_OCL801 = new BitSet(new long[]{0x001AD81400000E90L});
    public static final BitSet FOLLOW_identifier_in_synpred1_OCL804 = new BitSet(new long[]{0x003FFFFFFFFFEFF0L});
    public static final BitSet FOLLOW_set_in_synpred1_OCL806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_synpred3_OCL839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ocl_expressions_oclexpression_in_synpred4_OCL1350 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_synpred4_OCL1352 = new BitSet(new long[]{0x0000000000000002L});

}