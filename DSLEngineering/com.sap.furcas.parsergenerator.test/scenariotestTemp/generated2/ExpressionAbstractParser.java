// $ANTLR 3.1.1 ./scenariotestTemp/generated2/ExpressionAbstract.g 2010-11-04 23:30:55

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
public class ExpressionAbstractParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "INT", "COMA", "LPAREN", "RPAREN", "PLUS", "COMMENT", "LCURLY", "RCURLY", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "STRING", "'trueS'", "'falseS'"
    };
    public static final int ESC=18;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LCURLY=11;
    public static final int INT=5;
    public static final int EOF=-1;
    public static final int COMA=6;
    public static final int LPAREN=7;
    public static final int ALPHA=16;
    public static final int RPAREN=8;
    public static final int NAME=4;
    public static final int WS=14;
    public static final int SNAME=17;
    public static final int RCURLY=12;
    public static final int PLUS=9;
    public static final int NL=13;
    public static final int DIGIT=15;
    public static final int COMMENT=10;
    public static final int STRING=19;

    // delegates
    // delegators


        public ExpressionAbstractParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ExpressionAbstractParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ExpressionAbstractParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/ExpressionAbstract.g"; }


       private static final String syntaxUUID = "ExpressionAbstract";
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
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:217:1: eintegerobject returns [Object ret2] : (ast= INT ) ;
    public final Object eintegerobject() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:218:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:219:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:219:3: (ast= INT )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:219:4: ast= INT
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


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:227:1: main returns [Object ret2] : ( (ret= expression_expressionlist ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:228:3: ( ( (ret= expression_expressionlist ) EOF ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:229:3: ( (ret= expression_expressionlist ) EOF )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:229:3: ( (ret= expression_expressionlist ) EOF )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:229:4: (ret= expression_expressionlist ) EOF
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:229:4: (ret= expression_expressionlist )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:229:5: ret= expression_expressionlist
            {
            pushFollow(FOLLOW_expression_expressionlist_in_main128);
            ret=expression_expressionlist();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main131); if (state.failed) return ret2;

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
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:236:1: expression_expressionlist returns [Object ret2] : ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) ;
    public final Object expression_expressionlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","ExpressionList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:241:3: ( ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:4: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:21: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=NAME && LA2_0<=INT)||LA2_0==LPAREN||(LA2_0>=20 && LA2_0<=21)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:23: temp= expression_expression ( ( COMA ) temp= expression_expression )*
                    {
                    pushFollow(FOLLOW_expression_expression_in_expression_expressionlist166);
                    temp=expression_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:88: ( ( COMA ) temp= expression_expression )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:89: ( COMA ) temp= expression_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:106: ( COMA )
                    	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:242:107: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_expression_expressionlist175); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_expression_expression_in_expression_expressionlist183);
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
    // $ANTLR end "expression_expressionlist"


    // $ANTLR start "primary_expression_expression"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:250:1: primary_expression_expression returns [Object ret2] : (ret= expression_subexpression | ret= expression_subexpression2 | ( LPAREN ret= expression_expression RPAREN ) ) ;
    public final Object primary_expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:251:3: ( (ret= expression_subexpression | ret= expression_subexpression2 | ( LPAREN ret= expression_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:252:3: (ret= expression_subexpression | ret= expression_subexpression2 | ( LPAREN ret= expression_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:252:3: (ret= expression_subexpression | ret= expression_subexpression2 | ( LPAREN ret= expression_expression RPAREN ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 20:
            case 21:
                {
                alt3=1;
                }
                break;
            case NAME:
            case INT:
                {
                alt3=2;
                }
                break;
            case LPAREN:
                {
                alt3=3;
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
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:252:4: ret= expression_subexpression
                    {
                    pushFollow(FOLLOW_expression_subexpression_in_primary_expression_expression228);
                    ret=expression_subexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:253:5: ret= expression_subexpression2
                    {
                    pushFollow(FOLLOW_expression_subexpression2_in_primary_expression_expression236);
                    ret=expression_subexpression2();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:254:5: ( LPAREN ret= expression_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:254:5: ( LPAREN ret= expression_expression RPAREN )
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:254:6: LPAREN ret= expression_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_expression_expression245); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_expression_expression_in_primary_expression_expression251);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_expression_expression255); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:261:1: priority_0 returns [Object ret2] : ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:262:3: ( ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:8: ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            {
            pushFollow(FOLLOW_primary_expression_expression_in_priority_0293);
            ret=primary_expression_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:41: ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PLUS) && (synpred5_ExpressionAbstract())) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:42: ( ( PLUS ) () )=> ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:54: ( PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:55: PLUS ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_0306); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:137: ( (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:138: (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    {
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:138: (ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:139: ret= expression_includingexpression_expression_IncludingExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression
            	    {
            	    pushFollow(FOLLOW_expression_includingexpression_expression_IncludingExpression_opPlus_in_priority_0314);
            	    ret=expression_includingexpression_expression_IncludingExpression_opPlus(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_primary_expression_expression_in_priority_0318);
            	    right=primary_expression_expression();

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      setProperty(ret, "argument", right);
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
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:273:1: expression_expression returns [Object ret2] : ret= priority_0 ;
    public final Object expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:274:3: (ret= priority_0 )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:275:3: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_expression_expression356);
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


    // $ANTLR start "expression_subexpression"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:282:1: expression_subexpression returns [Object ret2] : (ret= expression_booleanexpression ) ;
    public final Object expression_subexpression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:283:3: ( (ret= expression_booleanexpression ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:284:3: (ret= expression_booleanexpression )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:284:3: (ret= expression_booleanexpression )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:284:4: ret= expression_booleanexpression
            {
            pushFollow(FOLLOW_expression_booleanexpression_in_expression_subexpression382);
            ret=expression_booleanexpression();

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
    // $ANTLR end "expression_subexpression"


    // $ANTLR start "expression_subexpression2"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:291:1: expression_subexpression2 returns [Object ret2] : (ret= expression_stringexpression | ret= expression_negativeintexpression ) ;
    public final Object expression_subexpression2() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:292:3: ( (ret= expression_stringexpression | ret= expression_negativeintexpression ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:293:3: (ret= expression_stringexpression | ret= expression_negativeintexpression )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:293:3: (ret= expression_stringexpression | ret= expression_negativeintexpression )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==NAME) ) {
                alt5=1;
            }
            else if ( (LA5_0==INT) ) {
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
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:293:4: ret= expression_stringexpression
                    {
                    pushFollow(FOLLOW_expression_stringexpression_in_expression_subexpression2409);
                    ret=expression_stringexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:294:5: ret= expression_negativeintexpression
                    {
                    pushFollow(FOLLOW_expression_negativeintexpression_in_expression_subexpression2417);
                    ret=expression_negativeintexpression();

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
    // $ANTLR end "expression_subexpression2"


    // $ANTLR start "expression_includingexpression_expression_IncludingExpression_opPlus"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:301:1: expression_includingexpression_expression_IncludingExpression_opPlus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object expression_includingexpression_expression_IncludingExpression_opPlus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","IncludingExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:306:3: ()
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:307:3: 
            {
            if ( state.backtracking==0 ) {

              // discarding operator name instead of storing it here
              setProperty(ret,"source" , left);
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
    // $ANTLR end "expression_includingexpression_expression_IncludingExpression_opPlus"


    // $ANTLR start "expression_stringexpression"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:317:1: expression_stringexpression returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object expression_stringexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","StringExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:322:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:323:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:323:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:323:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:323:21: (temp= identifier )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:323:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_expression_stringexpression479);
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
    // $ANTLR end "expression_stringexpression"


    // $ANTLR start "expression_booleanexpression"
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:331:1: expression_booleanexpression returns [Object ret2] : ( ( ( 'trueS' ) | ( 'falseS' ) ) ) ;
    public final Object expression_booleanexpression() throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","BooleanExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:336:3: ( ( ( ( 'trueS' ) | ( 'falseS' ) ) ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:3: ( ( ( 'trueS' ) | ( 'falseS' ) ) )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:3: ( ( ( 'trueS' ) | ( 'falseS' ) ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:4: ( ( 'trueS' ) | ( 'falseS' ) )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:22: ( ( 'trueS' ) | ( 'falseS' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
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
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:23: ( 'trueS' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(0);
                    }
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:39: ( 'trueS' )
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:40: 'trueS'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,20,FOLLOW_20_in_expression_booleanexpression528); if (state.failed) return ret2;
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
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:150: ( 'falseS' )
                    {
                    if ( state.backtracking==0 ) {
                      _enterAlt(1);
                    }
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:166: ( 'falseS' )
                    // ./scenariotestTemp/generated2/ExpressionAbstract.g:337:167: 'falseS'
                    {
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,21,FOLLOW_21_in_expression_booleanexpression541); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/ExpressionAbstract.g:346:1: expression_negativeintexpression returns [Object ret2] : ( (temp= eintegerobject ) ) ;
    public final Object expression_negativeintexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","NegativeIntExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:351:3: ( ( (temp= eintegerobject ) ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:352:3: ( (temp= eintegerobject ) )
            {
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:352:3: ( (temp= eintegerobject ) )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:352:4: (temp= eintegerobject )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:352:21: (temp= eintegerobject )
            // ./scenariotestTemp/generated2/ExpressionAbstract.g:352:23: temp= eintegerobject
            {
            pushFollow(FOLLOW_eintegerobject_in_expression_negativeintexpression592);
            temp=eintegerobject();

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
    // $ANTLR end "expression_negativeintexpression"

    // $ANTLR start synpred5_ExpressionAbstract
    public final void synpred5_ExpressionAbstract_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:42: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:43: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:43: ( PLUS )
        // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:44: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred5_ExpressionAbstract297); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:49: ()
        // ./scenariotestTemp/generated2/ExpressionAbstract.g:263:50: 
        {
        }


        }
    }
    // $ANTLR end synpred5_ExpressionAbstract

    // Delegated rules

    public final boolean synpred5_ExpressionAbstract() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ExpressionAbstract_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_expression_expressionlist_in_main128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_expression_in_expression_expressionlist166 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMA_in_expression_expressionlist175 = new BitSet(new long[]{0x00000000003000B0L});
    public static final BitSet FOLLOW_expression_expression_in_expression_expressionlist183 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_expression_subexpression_in_primary_expression_expression228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_subexpression2_in_primary_expression_expression236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expression_expression245 = new BitSet(new long[]{0x00000000003000B0L});
    public static final BitSet FOLLOW_expression_expression_in_primary_expression_expression251 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expression_expression255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0293 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_PLUS_in_priority_0306 = new BitSet(new long[]{0x00000000003000B0L});
    public static final BitSet FOLLOW_expression_includingexpression_expression_IncludingExpression_opPlus_in_priority_0314 = new BitSet(new long[]{0x00000000003000B0L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0318 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_priority_0_in_expression_expression356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_booleanexpression_in_expression_subexpression382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_stringexpression_in_expression_subexpression2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_negativeintexpression_in_expression_subexpression2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_expression_stringexpression479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_expression_booleanexpression528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_expression_booleanexpression541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eintegerobject_in_expression_negativeintexpression592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred5_ExpressionAbstract297 = new BitSet(new long[]{0x0000000000000002L});

}