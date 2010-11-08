// $ANTLR 3.1.1 ./scenariotestTemp/generated2/LexerMember.g 2010-11-04 23:30:47

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

public class LexerMemberParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "BOOL", "OBJECT", "BINARY", "INT", "LBRACKET", "RBRACKET", "FLOAT", "DATE", "STRING", "'test'"
    };
    public static final int T__20=20;
    public static final int BOOL=11;
    public static final int INT=14;
    public static final int FLOAT=17;
    public static final int EOF=-1;
    public static final int ALPHA=9;
    public static final int LBRACKET=15;
    public static final int NAME=4;
    public static final int WS=7;
    public static final int SNAME=10;
    public static final int OBJECT=12;
    public static final int NL=6;
    public static final int DIGIT=8;
    public static final int BINARY=13;
    public static final int RBRACKET=16;
    public static final int COMMENT=5;
    public static final int DATE=18;
    public static final int STRING=19;

    // delegates
    // delegators


        public LexerMemberParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public LexerMemberParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return LexerMemberParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/LexerMember.g"; }


       private static final String syntaxUUID = "LexerMember";
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
    // ./scenariotestTemp/generated2/LexerMember.g:210:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/LexerMember.g:211:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/LexerMember.g:212:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:212:3: (ast= NAME )
            // ./scenariotestTemp/generated2/LexerMember.g:212:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier69); 
            ret = unescapeString( ast.getText());


            }


            ret2=ret;


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


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/LexerMember.g:220:1: main returns [Object ret2] : ( (ret= bibtext_bibtextfile ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/LexerMember.g:221:3: ( ( (ret= bibtext_bibtextfile ) EOF ) )
            // ./scenariotestTemp/generated2/LexerMember.g:222:3: ( (ret= bibtext_bibtextfile ) EOF )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:222:3: ( (ret= bibtext_bibtextfile ) EOF )
            // ./scenariotestTemp/generated2/LexerMember.g:222:4: (ret= bibtext_bibtextfile ) EOF
            {
            // ./scenariotestTemp/generated2/LexerMember.g:222:4: (ret= bibtext_bibtextfile )
            // ./scenariotestTemp/generated2/LexerMember.g:222:5: ret= bibtext_bibtextfile
            {
            pushFollow(FOLLOW_bibtext_bibtextfile_in_main97);
            ret=bibtext_bibtextfile();

            checkFollows();
            state._fsp--;


            }

            match(input,EOF,FOLLOW_EOF_in_main100); 

            }


            ret2=ret;


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


    // $ANTLR start "bibtext_bibtextfile"
    // ./scenariotestTemp/generated2/LexerMember.g:229:1: bibtext_bibtextfile returns [Object ret2] : ( 'test' ) ;
    public final Object bibtext_bibtextfile() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("BibText","BibTextFile");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/LexerMember.g:234:3: ( ( 'test' ) )
            // ./scenariotestTemp/generated2/LexerMember.g:235:3: ( 'test' )
            {
            // ./scenariotestTemp/generated2/LexerMember.g:235:3: ( 'test' )
            // ./scenariotestTemp/generated2/LexerMember.g:235:4: 'test'
            {
            _beforeSeqEl();
            match(input,20,FOLLOW_20_in_bibtext_bibtextfile131); 
            _afterSeqEl();

            }


            ret2 = commitCreation(ret, firstToken, true);

             

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "bibtext_bibtextfile"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bibtext_bibtextfile_in_main97 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_bibtext_bibtextfile131 = new BitSet(new long[]{0x0000000000000002L});

}