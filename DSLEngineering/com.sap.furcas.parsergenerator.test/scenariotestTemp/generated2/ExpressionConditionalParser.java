// $ANTLR 3.1.1 ./scenariotestTemp/generated2/ExpressionConditional.g 2010-11-04 23:29:47

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
public class ExpressionConditionalParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "INT", "COMA", "LPAREN", "RPAREN", "PLUS", "COMMENT", "LCURLY", "RCURLY", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "STRING", "'fourty-two'", "'noInt'", "'Hello'", "'Bye'", "'trueS'", "'falseS'", "'-twelve'", "'nothing'"
    };
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ESC=18;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LCURLY=11;
    public static final int INT=5;
    public static final int EOF=-1;
    public static final int COMA=6;
    public static final int ALPHA=16;
    public static final int LPAREN=7;
    public static final int RPAREN=8;
    public static final int NAME=4;
    public static final int WS=14;
    public static final int SNAME=17;
    public static final int RCURLY=12;
    public static final int PLUS=9;
    public static final int DIGIT=15;
    public static final int NL=13;
    public static final int COMMENT=10;
    public static final int STRING=19;

    // delegates
    // delegators


        public ExpressionConditionalParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExpressionConditionalParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExpressionConditionalParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/ExpressionConditional.g"; }


       private static final String syntaxUUID = "ExpressionConditional";
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
    // ./scenariotestTemp/generated2/ExpressionConditional.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:209:4: ast= NAME
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


    // $ANTLR start "eintegerobject"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:217:1: eintegerobject returns [Object ret2] : (ast= INT ) ;
    public final Object eintegerobject() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:218:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:219:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:219:3: (ast= INT )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:219:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_eintegerobject100); if (state.failed) return ret2;
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
    // $ANTLR end "eintegerobject"


    // $ANTLR start "bool"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:227:1: bool returns [Object ret2] : (ast= NAME ) ;
    public final Object bool() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:228:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:229:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:229:3: (ast= NAME )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:229:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_bool131); if (state.failed) return ret2;
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
    // $ANTLR end "bool"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:237:1: main returns [Object ret2] : ( (ret= expression_expressionlist ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:238:3: ( ( (ret= expression_expressionlist ) EOF ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:239:3: ( (ret= expression_expressionlist ) EOF )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:239:3: ( (ret= expression_expressionlist ) EOF )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:239:4: (ret= expression_expressionlist ) EOF
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:239:4: (ret= expression_expressionlist )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:239:5: ret= expression_expressionlist
            {
            pushFollow(FOLLOW_expression_expressionlist_in_main159);
            ret=expression_expressionlist();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main162); if (state.failed) return ret2;

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


    // $ANTLR start "expression_expressionlist"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:246:1: expression_expressionlist returns [Object ret2] : ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) ;
    public final Object expression_expressionlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","ExpressionList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:251:3: ( ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:252:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:252:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:252:4: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionConditional.g:252:21: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==LPAREN||(LA2_0>=20 && LA2_0<=27)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:252:23: temp= expression_expression ( ( COMA ) temp= expression_expression )*
                    {
                    pushFollow(FOLLOW_expression_expression_in_expression_expressionlist197);
                    temp=expression_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:252:88: ( ( COMA ) temp= expression_expression )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/ExpressionConditional.g:252:89: ( COMA ) temp= expression_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/ExpressionConditional.g:252:106: ( COMA )
                    	    // ./scenariotestTemp/generated2/ExpressionConditional.g:252:107: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_expression_expressionlist206); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_expression_expression_in_expression_expressionlist214);
                    	    temp=expression_expression();

                    	    checkFollows();
                    	    state._fsp--;
                    	    if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      setProperty(ret, "elements", temp);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
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
    // $ANTLR end "expression_expressionlist"


    // $ANTLR start "primary_expression_expression"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:260:1: primary_expression_expression returns [Object ret2] : (ret= expression_booleanexpression | ret= expression_negativeintexpression | ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) ) ;
    public final Object primary_expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:261:3: ( (ret= expression_booleanexpression | ret= expression_negativeintexpression | ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:262:3: (ret= expression_booleanexpression | ret= expression_negativeintexpression | ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:262:3: (ret= expression_booleanexpression | ret= expression_negativeintexpression | ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 24:
            case 25:
                {
                alt3=1;
                }
                break;
            case 26:
            case 27:
                {
                alt3=2;
                }
                break;
            case 22:
            case 23:
                {
                alt3=3;
                }
                break;
            case 20:
            case 21:
                {
                alt3=4;
                }
                break;
            case LPAREN:
                {
                alt3=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:262:4: ret= expression_booleanexpression
                    {
                    pushFollow(FOLLOW_expression_booleanexpression_in_primary_expression_expression259);
                    ret=expression_booleanexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:263:5: ret= expression_negativeintexpression
                    {
                    pushFollow(FOLLOW_expression_negativeintexpression_in_primary_expression_expression267);
                    ret=expression_negativeintexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:264:5: ret= expression_stringexpression
                    {
                    pushFollow(FOLLOW_expression_stringexpression_in_primary_expression_expression275);
                    ret=expression_stringexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 4 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:265:5: ret= expression_valueexpression
                    {
                    pushFollow(FOLLOW_expression_valueexpression_in_primary_expression_expression283);
                    ret=expression_valueexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 5 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:266:5: ( LPAREN ret= expression_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:266:5: ( LPAREN ret= expression_expression RPAREN )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:266:6: LPAREN ret= expression_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_expression_expression292); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_expression_expression_in_primary_expression_expression298);
                    ret=expression_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_expression_expression302); if (state.failed) return ret2;
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
    // $ANTLR end "primary_expression_expression"


    // $ANTLR start "priority_0"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:273:1: priority_0 returns [Object ret2] : ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:274:3: ( ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:275:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:275:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:275:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:275:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:275:8: ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            {
            pushFollow(FOLLOW_primary_expression_expression_in_priority_0340);
            ret=primary_expression_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/ExpressionConditional.g:275:41: ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PLUS) && (synpred7_ExpressionConditional())) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:42: ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:54: ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:55: PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_0353); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:137: ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:138: (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    {
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:138: (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    // ./scenariotestTemp/generated2/ExpressionConditional.g:275:139: ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression
            	    {
            	    pushFollow(FOLLOW_expression_binaryexpression_expression_BinaryExpression_opPlus_in_priority_0361);
            	    ret=expression_binaryexpression_expression_BinaryExpression_opPlus(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_primary_expression_expression_in_priority_0365);
            	    right=primary_expression_expression();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "right", right);
            	      this.setLocationAndComment(ret, firstToken);

            	    }

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
    // $ANTLR end "priority_0"


    // $ANTLR start "expression_expression"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:285:1: expression_expression returns [Object ret2] : ret= priority_0 ;
    public final Object expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:286:3: (ret= priority_0 )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:287:3: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_expression_expression403);
            ret=priority_0();

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
    // $ANTLR end "expression_expression"


    // $ANTLR start "expression_binaryexpression_expression_BinaryExpression_opPlus"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:294:1: expression_binaryexpression_expression_BinaryExpression_opPlus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object expression_binaryexpression_expression_BinaryExpression_opPlus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","BinaryExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:299:3: ()
            // ./scenariotestTemp/generated2/ExpressionConditional.g:300:3: 
            {
            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"left" , left);
              ret2 = createOrResolve(ret, firstToken);
              onRuleElementCreationCommited(ret2);


            }

            }

        }
        finally {
            onExitTemplateRule(metaType);
        }
        return ret2;
    }
    // $ANTLR end "expression_binaryexpression_expression_BinaryExpression_opPlus"


    // $ANTLR start "expression_valueexpression"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:310:1: expression_valueexpression returns [Object ret2] : ( ( ( 'fourty-two' ) | ( 'noInt' ) ) ) ;
    public final Object expression_valueexpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","ValueExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:315:3: ( ( ( ( 'fourty-two' ) | ( 'noInt' ) ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:316:3: ( ( ( 'fourty-two' ) | ( 'noInt' ) ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:316:3: ( ( ( 'fourty-two' ) | ( 'noInt' ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:316:4: ( ( 'fourty-two' ) | ( 'noInt' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionConditional.g:316:22: ( ( 'fourty-two' ) | ( 'noInt' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            else if ( (LA5_0==21) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:316:23: ( 'fourty-two' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:316:39: ( 'fourty-two' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:316:40: 'fourty-two'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,20,FOLLOW_20_in_expression_valueexpression466); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", new Integer(42));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:316:148: ( 'noInt' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:316:164: ( 'noInt' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:316:165: 'noInt'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,21,FOLLOW_21_in_expression_valueexpression479); if (state.failed) return ret2;
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
    // $ANTLR end "expression_valueexpression"


    // $ANTLR start "expression_stringexpression"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:325:1: expression_stringexpression returns [Object ret2] : ( ( ( 'Hello' ) | ( 'Bye' ) ) ) ;
    public final Object expression_stringexpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","StringExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:330:3: ( ( ( ( 'Hello' ) | ( 'Bye' ) ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:331:3: ( ( ( 'Hello' ) | ( 'Bye' ) ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:331:3: ( ( ( 'Hello' ) | ( 'Bye' ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:331:4: ( ( 'Hello' ) | ( 'Bye' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionConditional.g:331:22: ( ( 'Hello' ) | ( 'Bye' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            else if ( (LA6_0==23) ) {
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
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:331:23: ( 'Hello' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:331:39: ( 'Hello' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:331:40: 'Hello'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,22,FOLLOW_22_in_expression_stringexpression532); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", new String("World"));
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:331:147: ( 'Bye' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:331:163: ( 'Bye' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:331:164: 'Bye'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,23,FOLLOW_23_in_expression_stringexpression545); if (state.failed) return ret2;
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
    // $ANTLR end "expression_stringexpression"


    // $ANTLR start "expression_booleanexpression"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:340:1: expression_booleanexpression returns [Object ret2] : ( ( ( 'trueS' ) | ( 'falseS' ) ) ) ;
    public final Object expression_booleanexpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","BooleanExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:345:3: ( ( ( ( 'trueS' ) | ( 'falseS' ) ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:346:3: ( ( ( 'trueS' ) | ( 'falseS' ) ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:346:3: ( ( ( 'trueS' ) | ( 'falseS' ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:346:4: ( ( 'trueS' ) | ( 'falseS' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionConditional.g:346:22: ( ( 'trueS' ) | ( 'falseS' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            else if ( (LA7_0==25) ) {
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
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:346:23: ( 'trueS' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:346:39: ( 'trueS' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:346:40: 'trueS'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,24,FOLLOW_24_in_expression_booleanexpression598); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:346:150: ( 'falseS' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:346:166: ( 'falseS' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:346:167: 'falseS'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,25,FOLLOW_25_in_expression_booleanexpression611); if (state.failed) return ret2;
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
    // $ANTLR end "expression_booleanexpression"


    // $ANTLR start "expression_negativeintexpression"
    // ./scenariotestTemp/generated2/ExpressionConditional.g:355:1: expression_negativeintexpression returns [Object ret2] : ( ( ( '-twelve' ) | ( 'nothing' ) ) ) ;
    public final Object expression_negativeintexpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","NegativeIntExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:360:3: ( ( ( ( '-twelve' ) | ( 'nothing' ) ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:361:3: ( ( ( '-twelve' ) | ( 'nothing' ) ) )
            {
            // ./scenariotestTemp/generated2/ExpressionConditional.g:361:3: ( ( ( '-twelve' ) | ( 'nothing' ) ) )
            // ./scenariotestTemp/generated2/ExpressionConditional.g:361:4: ( ( '-twelve' ) | ( 'nothing' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionConditional.g:361:22: ( ( '-twelve' ) | ( 'nothing' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            else if ( (LA8_0==27) ) {
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
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:361:23: ( '-twelve' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:361:39: ( '-twelve' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:361:40: '-twelve'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,26,FOLLOW_26_in_expression_negativeintexpression664); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "value", new Integer(12));setProperty(ret, "isNegative", java.lang.Boolean.TRUE);
                    }
                    if ( state.backtracking==0 ) {
                      _exitAlt();
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:361:200: ( 'nothing' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:361:216: ( 'nothing' )
                    // ./scenariotestTemp/generated2/ExpressionConditional.g:361:217: 'nothing'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,27,FOLLOW_27_in_expression_negativeintexpression677); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }

                    }

                    if ( state.backtracking==0 ) {
                      setProperty(ret, "isNegative", java.lang.Boolean.FALSE);
                    }
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
    // $ANTLR end "expression_negativeintexpression"

    // $ANTLR start synpred7_ExpressionConditional
    public final void synpred7_ExpressionConditional_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/ExpressionConditional.g:275:42: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/ExpressionConditional.g:275:43: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/ExpressionConditional.g:275:43: ( PLUS )
        // ./scenariotestTemp/generated2/ExpressionConditional.g:275:44: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred7_ExpressionConditional344); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/ExpressionConditional.g:275:49: ()
        // ./scenariotestTemp/generated2/ExpressionConditional.g:275:50: 
        {
        }


        }
    }
    // $ANTLR end synpred7_ExpressionConditional

    // Delegated rules

    public final boolean synpred7_ExpressionConditional() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ExpressionConditional_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eintegerobject100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_bool131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_expressionlist_in_main159 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_expression_in_expression_expressionlist197 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMA_in_expression_expressionlist206 = new BitSet(new long[]{0x000000000FF00080L});
    public static final BitSet FOLLOW_expression_expression_in_expression_expressionlist214 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_expression_booleanexpression_in_primary_expression_expression259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_negativeintexpression_in_primary_expression_expression267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_stringexpression_in_primary_expression_expression275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_valueexpression_in_primary_expression_expression283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expression_expression292 = new BitSet(new long[]{0x000000000FF00080L});
    public static final BitSet FOLLOW_expression_expression_in_primary_expression_expression298 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expression_expression302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0340 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_PLUS_in_priority_0353 = new BitSet(new long[]{0x000000000FF00080L});
    public static final BitSet FOLLOW_expression_binaryexpression_expression_BinaryExpression_opPlus_in_priority_0361 = new BitSet(new long[]{0x000000000FF00080L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0365 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_priority_0_in_expression_expression403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_expression_valueexpression466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_expression_valueexpression479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_expression_stringexpression532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_expression_stringexpression545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_expression_booleanexpression598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_expression_booleanexpression611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_expression_negativeintexpression664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_expression_negativeintexpression677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred7_ExpressionConditional344 = new BitSet(new long[]{0x0000000000000002L});

}