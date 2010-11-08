// $ANTLR 3.1.1 ./scenariotestTemp/generated2/Problem.g 2010-11-04 23:27:19

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
public class ProblemParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "SEMI", "COMMENT", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "NAME", "INT", "FLOAT", "'at'", "'error'", "'warning'", "'critic'"
    };
    public static final int ESC=12;
    public static final int INT=14;
    public static final int FLOAT=15;
    public static final int EOF=-1;
    public static final int SEMI=5;
    public static final int ALPHA=10;
    public static final int T__19=19;
    public static final int NAME=13;
    public static final int T__16=16;
    public static final int WS=8;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int SNAME=11;
    public static final int NL=7;
    public static final int DIGIT=9;
    public static final int COMMENT=6;
    public static final int STRING=4;

    // delegates
    // delegators


        public ProblemParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ProblemParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ProblemParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/Problem.g"; }


       private static final String syntaxUUID = "Problem";
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




    // $ANTLR start "string"
    // ./scenariotestTemp/generated2/Problem.g:207:1: string returns [Object ret2] : (ast= STRING ) ;
    public final Object string() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Problem.g:208:3: ( (ast= STRING ) )
            // ./scenariotestTemp/generated2/Problem.g:209:3: (ast= STRING )
            {
            // ./scenariotestTemp/generated2/Problem.g:209:3: (ast= STRING )
            // ./scenariotestTemp/generated2/Problem.g:209:4: ast= STRING
            {
            ast=(Token)match(input,STRING,FOLLOW_STRING_in_string69); if (state.failed) return ret2;
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
    // $ANTLR end "string"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/Problem.g:217:1: main returns [Object ret2] : ( (ret= problem_problem )+ EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/Problem.g:218:3: ( ( (ret= problem_problem )+ EOF ) )
            // ./scenariotestTemp/generated2/Problem.g:219:3: ( (ret= problem_problem )+ EOF )
            {
            // ./scenariotestTemp/generated2/Problem.g:219:3: ( (ret= problem_problem )+ EOF )
            // ./scenariotestTemp/generated2/Problem.g:219:4: (ret= problem_problem )+ EOF
            {
            // ./scenariotestTemp/generated2/Problem.g:219:4: (ret= problem_problem )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=17 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/Problem.g:219:5: ret= problem_problem
            	    {
            	    pushFollow(FOLLOW_problem_problem_in_main97);
            	    ret=problem_problem();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ret2;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_main101); if (state.failed) return ret2;

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


    // $ANTLR start "problem_problem"
    // ./scenariotestTemp/generated2/Problem.g:226:1: problem_problem returns [Object ret2] : ( (temp= problem_severity ) (temp= string ) 'at' (temp= string ) SEMI ) ;
    public final Object problem_problem() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("Problem","Problem");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/Problem.g:231:3: ( ( (temp= problem_severity ) (temp= string ) 'at' (temp= string ) SEMI ) )
            // ./scenariotestTemp/generated2/Problem.g:232:3: ( (temp= problem_severity ) (temp= string ) 'at' (temp= string ) SEMI )
            {
            // ./scenariotestTemp/generated2/Problem.g:232:3: ( (temp= problem_severity ) (temp= string ) 'at' (temp= string ) SEMI )
            // ./scenariotestTemp/generated2/Problem.g:232:4: (temp= problem_severity ) (temp= string ) 'at' (temp= string ) SEMI
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Problem.g:232:21: (temp= problem_severity )
            // ./scenariotestTemp/generated2/Problem.g:232:23: temp= problem_severity
            {
            pushFollow(FOLLOW_problem_severity_in_problem_problem136);
            temp=problem_severity();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "severity", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Problem.g:232:116: (temp= string )
            // ./scenariotestTemp/generated2/Problem.g:232:118: temp= string
            {
            pushFollow(FOLLOW_string_in_problem_problem146);
            temp=string();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "description", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,16,FOLLOW_16_in_problem_problem152); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/Problem.g:232:241: (temp= string )
            // ./scenariotestTemp/generated2/Problem.g:232:243: temp= string
            {
            pushFollow(FOLLOW_string_in_problem_problem159);
            temp=string();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "location", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,SEMI,FOLLOW_SEMI_in_problem_problem166); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }

            }

            if ( state.backtracking==0 ) {

              ret2 = commitCreation(ret, firstToken, false);

               
            }

            }

        }
        catch (Exception e) {
            handleExceptionInTemplateRule(e, firstToken, ret);
        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "problem_problem"


    // $ANTLR start "problem_severity"
    // ./scenariotestTemp/generated2/Problem.g:240:1: problem_severity returns [Object ret2] : ( ( 'error' ) | ( 'warning' ) | ( 'critic' ) ) ;
    public final Object problem_severity() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/Problem.g:241:3: ( ( ( 'error' ) | ( 'warning' ) | ( 'critic' ) ) )
            // ./scenariotestTemp/generated2/Problem.g:242:3: ( ( 'error' ) | ( 'warning' ) | ( 'critic' ) )
            {
            // ./scenariotestTemp/generated2/Problem.g:242:3: ( ( 'error' ) | ( 'warning' ) | ( 'critic' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 19:
                {
                alt2=3;
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
                    // ./scenariotestTemp/generated2/Problem.g:242:4: ( 'error' )
                    {
                    // ./scenariotestTemp/generated2/Problem.g:242:4: ( 'error' )
                    // ./scenariotestTemp/generated2/Problem.g:242:5: 'error'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,17,FOLLOW_17_in_problem_severity208); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("Problem","Severity"), "error");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/Problem.g:243:4: ( 'warning' )
                    {
                    // ./scenariotestTemp/generated2/Problem.g:243:4: ( 'warning' )
                    // ./scenariotestTemp/generated2/Problem.g:243:5: 'warning'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,18,FOLLOW_18_in_problem_severity218); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("Problem","Severity"), "warning");
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/Problem.g:244:4: ( 'critic' )
                    {
                    // ./scenariotestTemp/generated2/Problem.g:244:4: ( 'critic' )
                    // ./scenariotestTemp/generated2/Problem.g:244:5: 'critic'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,19,FOLLOW_19_in_problem_severity228); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("Problem","Severity"), "critic");
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
    // $ANTLR end "problem_severity"

    // Delegated rules


 

    public static final BitSet FOLLOW_STRING_in_string69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_problem_problem_in_main97 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_EOF_in_main101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_problem_severity_in_problem_problem136 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_string_in_problem_problem146 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_problem_problem152 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_string_in_problem_problem159 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_SEMI_in_problem_problem166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_problem_severity208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_problem_severity218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_problem_severity228 = new BitSet(new long[]{0x0000000000000002L});

}