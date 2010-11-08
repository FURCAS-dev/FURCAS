// $ANTLR 3.1.1 ./scenariotestTemp/generated2/MultiPackage.g 2010-11-04 23:30:57

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
public class MultiPackageParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "INT", "COMA", "LPAREN", "RPAREN", "PLUS", "COMMENT", "LCURLY", "RCURLY", "NL", "WS", "DIGIT", "ALPHA", "SNAME", "ESC", "STRING"
    };
    public static final int ESC=18;
    public static final int LCURLY=11;
    public static final int INT=5;
    public static final int COMA=6;
    public static final int EOF=-1;
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


        public MultiPackageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public MultiPackageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return MultiPackageParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/MultiPackage.g"; }


       private static final String syntaxUUID = "MultiPackage";
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
    // ./scenariotestTemp/generated2/MultiPackage.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/MultiPackage.g:209:4: ast= NAME
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
    // ./scenariotestTemp/generated2/MultiPackage.g:217:1: eintegerobject returns [Object ret2] : (ast= INT ) ;
    public final Object eintegerobject() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:218:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:219:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:219:3: (ast= INT )
            // ./scenariotestTemp/generated2/MultiPackage.g:219:4: ast= INT
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
    // ./scenariotestTemp/generated2/MultiPackage.g:227:1: main returns [Object ret2] : ( (ret= expression_rightpackage_expressionlist ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:228:3: ( ( (ret= expression_rightpackage_expressionlist ) EOF ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:229:3: ( (ret= expression_rightpackage_expressionlist ) EOF )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:229:3: ( (ret= expression_rightpackage_expressionlist ) EOF )
            // ./scenariotestTemp/generated2/MultiPackage.g:229:4: (ret= expression_rightpackage_expressionlist ) EOF
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:229:4: (ret= expression_rightpackage_expressionlist )
            // ./scenariotestTemp/generated2/MultiPackage.g:229:5: ret= expression_rightpackage_expressionlist
            {
            pushFollow(FOLLOW_expression_rightpackage_expressionlist_in_main128);
            ret=expression_rightpackage_expressionlist();

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


    // $ANTLR start "expression_rightpackage_expressionlist"
    // ./scenariotestTemp/generated2/MultiPackage.g:236:1: expression_rightpackage_expressionlist returns [Object ret2] : ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) ;
    public final Object expression_rightpackage_expressionlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","rightPackage","ExpressionList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:241:3: ( ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:242:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:242:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            // ./scenariotestTemp/generated2/MultiPackage.g:242:4: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/MultiPackage.g:242:21: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==INT||LA2_0==LPAREN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/MultiPackage.g:242:23: temp= expression_expression ( ( COMA ) temp= expression_expression )*
                    {
                    pushFollow(FOLLOW_expression_expression_in_expression_rightpackage_expressionlist166);
                    temp=expression_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/MultiPackage.g:242:88: ( ( COMA ) temp= expression_expression )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/MultiPackage.g:242:89: ( COMA ) temp= expression_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/MultiPackage.g:242:106: ( COMA )
                    	    // ./scenariotestTemp/generated2/MultiPackage.g:242:107: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_expression_rightpackage_expressionlist175); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_expression_expression_in_expression_rightpackage_expressionlist183);
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
    // $ANTLR end "expression_rightpackage_expressionlist"


    // $ANTLR start "primary_expression_expression"
    // ./scenariotestTemp/generated2/MultiPackage.g:250:1: primary_expression_expression returns [Object ret2] : (ret= expression_rightpackage_valueexpression | ( LPAREN ret= expression_expression RPAREN ) ) ;
    public final Object primary_expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:251:3: ( (ret= expression_rightpackage_valueexpression | ( LPAREN ret= expression_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:252:3: (ret= expression_rightpackage_valueexpression | ( LPAREN ret= expression_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:252:3: (ret= expression_rightpackage_valueexpression | ( LPAREN ret= expression_expression RPAREN ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INT) ) {
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
                    // ./scenariotestTemp/generated2/MultiPackage.g:252:4: ret= expression_rightpackage_valueexpression
                    {
                    pushFollow(FOLLOW_expression_rightpackage_valueexpression_in_primary_expression_expression228);
                    ret=expression_rightpackage_valueexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/MultiPackage.g:253:5: ( LPAREN ret= expression_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/MultiPackage.g:253:5: ( LPAREN ret= expression_expression RPAREN )
                    // ./scenariotestTemp/generated2/MultiPackage.g:253:6: LPAREN ret= expression_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_expression_expression237); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_expression_expression_in_primary_expression_expression243);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_expression_expression247); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/MultiPackage.g:260:1: priority_0 returns [Object ret2] : ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:261:3: ( ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:262:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:262:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:262:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:262:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            // ./scenariotestTemp/generated2/MultiPackage.g:262:8: ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            {
            pushFollow(FOLLOW_primary_expression_expression_in_priority_0285);
            ret=primary_expression_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/MultiPackage.g:262:41: ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PLUS) && (synpred4_MultiPackage())) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:42: ( ( PLUS ) () )=> ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:54: ( PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:55: PLUS ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_0298); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:137: ( (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:138: (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    {
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:138: (ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    // ./scenariotestTemp/generated2/MultiPackage.g:262:139: ret= expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression
            	    {
            	    pushFollow(FOLLOW_expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus_in_priority_0306);
            	    ret=expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_primary_expression_expression_in_priority_0310);
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
    // ./scenariotestTemp/generated2/MultiPackage.g:272:1: expression_expression returns [Object ret2] : ret= priority_0 ;
    public final Object expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:273:3: (ret= priority_0 )
            // ./scenariotestTemp/generated2/MultiPackage.g:274:3: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_expression_expression348);
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


    // $ANTLR start "expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus"
    // ./scenariotestTemp/generated2/MultiPackage.g:281:1: expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","rightPackage","BinaryExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:286:3: ()
            // ./scenariotestTemp/generated2/MultiPackage.g:287:3: 
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
    // $ANTLR end "expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus"


    // $ANTLR start "expression_rightpackage_valueexpression"
    // ./scenariotestTemp/generated2/MultiPackage.g:297:1: expression_rightpackage_valueexpression returns [Object ret2] : ( (temp= eintegerobject ) ) ;
    public final Object expression_rightpackage_valueexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","rightPackage","ValueExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/MultiPackage.g:302:3: ( ( (temp= eintegerobject ) ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:303:3: ( (temp= eintegerobject ) )
            {
            // ./scenariotestTemp/generated2/MultiPackage.g:303:3: ( (temp= eintegerobject ) )
            // ./scenariotestTemp/generated2/MultiPackage.g:303:4: (temp= eintegerobject )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/MultiPackage.g:303:21: (temp= eintegerobject )
            // ./scenariotestTemp/generated2/MultiPackage.g:303:23: temp= eintegerobject
            {
            pushFollow(FOLLOW_eintegerobject_in_expression_rightpackage_valueexpression409);
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
    // $ANTLR end "expression_rightpackage_valueexpression"

    // $ANTLR start synpred4_MultiPackage
    public final void synpred4_MultiPackage_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/MultiPackage.g:262:42: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/MultiPackage.g:262:43: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/MultiPackage.g:262:43: ( PLUS )
        // ./scenariotestTemp/generated2/MultiPackage.g:262:44: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred4_MultiPackage289); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/MultiPackage.g:262:49: ()
        // ./scenariotestTemp/generated2/MultiPackage.g:262:50: 
        {
        }


        }
    }
    // $ANTLR end synpred4_MultiPackage

    // Delegated rules

    public final boolean synpred4_MultiPackage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_MultiPackage_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_expression_rightpackage_expressionlist_in_main128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_expression_in_expression_rightpackage_expressionlist166 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMA_in_expression_rightpackage_expressionlist175 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_expression_expression_in_expression_rightpackage_expressionlist183 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_expression_rightpackage_valueexpression_in_primary_expression_expression228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expression_expression237 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_expression_expression_in_primary_expression_expression243 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expression_expression247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0285 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_PLUS_in_priority_0298 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_expression_rightpackage_binaryexpression_expression_rightPackage_BinaryExpression_opPlus_in_priority_0306 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0310 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_priority_0_in_expression_expression348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eintegerobject_in_expression_rightpackage_valueexpression409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred4_MultiPackage289 = new BitSet(new long[]{0x0000000000000002L});

}