// $ANTLR 3.1.1 ./scenariotestTemp/generated2/PrimTempBug.g 2010-11-04 23:30:58

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
public class PrimTempBugParser extends ObservableInjectingParser {
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


        public PrimTempBugParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PrimTempBugParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PrimTempBugParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/PrimTempBug.g"; }


       private static final String syntaxUUID = "PrimTempBug";
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




    // $ANTLR start "wrongidentifier"
    // ./scenariotestTemp/generated2/PrimTempBug.g:207:1: wrongidentifier returns [Object ret2] : (ast= NAME ) ;
    public final Object wrongidentifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/PrimTempBug.g:209:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_wrongidentifier69); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = null;

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
    // $ANTLR end "wrongidentifier"


    // $ANTLR start "identifier"
    // ./scenariotestTemp/generated2/PrimTempBug.g:217:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:218:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:219:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:219:3: (ast= NAME )
            // ./scenariotestTemp/generated2/PrimTempBug.g:219:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_identifier100); if (state.failed) return ret2;
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


    // $ANTLR start "badidentifier"
    // ./scenariotestTemp/generated2/PrimTempBug.g:227:1: badidentifier returns [Object ret2] : (ast= NAME ) ;
    public final Object badidentifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:228:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:229:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:229:3: (ast= NAME )
            // ./scenariotestTemp/generated2/PrimTempBug.g:229:4: ast= NAME
            {
            ast=(Token)match(input,NAME,FOLLOW_NAME_in_badidentifier131); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = null;

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
    // $ANTLR end "badidentifier"


    // $ANTLR start "eintegerobject"
    // ./scenariotestTemp/generated2/PrimTempBug.g:237:1: eintegerobject returns [Object ret2] : (ast= INT ) ;
    public final Object eintegerobject() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:238:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:239:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:239:3: (ast= INT )
            // ./scenariotestTemp/generated2/PrimTempBug.g:239:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_eintegerobject162); if (state.failed) return ret2;
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


    // $ANTLR start "badeintegerobject"
    // ./scenariotestTemp/generated2/PrimTempBug.g:247:1: badeintegerobject returns [Object ret2] : (ast= INT ) ;
    public final Object badeintegerobject() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:248:3: ( (ast= INT ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:249:3: (ast= INT )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:249:3: (ast= INT )
            // ./scenariotestTemp/generated2/PrimTempBug.g:249:4: ast= INT
            {
            ast=(Token)match(input,INT,FOLLOW_INT_in_badeintegerobject193); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              ret = null;

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
    // $ANTLR end "badeintegerobject"


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/PrimTempBug.g:257:1: main returns [Object ret2] : ( (ret= expression_expressionlist ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:258:3: ( ( (ret= expression_expressionlist ) EOF ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:259:3: ( (ret= expression_expressionlist ) EOF )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:259:3: ( (ret= expression_expressionlist ) EOF )
            // ./scenariotestTemp/generated2/PrimTempBug.g:259:4: (ret= expression_expressionlist ) EOF
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:259:4: (ret= expression_expressionlist )
            // ./scenariotestTemp/generated2/PrimTempBug.g:259:5: ret= expression_expressionlist
            {
            pushFollow(FOLLOW_expression_expressionlist_in_main221);
            ret=expression_expressionlist();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main224); if (state.failed) return ret2;

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
    // ./scenariotestTemp/generated2/PrimTempBug.g:266:1: expression_expressionlist returns [Object ret2] : ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) ;
    public final Object expression_expressionlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","ExpressionList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:271:3: ( ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:272:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:272:3: ( (temp= expression_expression ( ( COMA ) temp= expression_expression )* )? )
            // ./scenariotestTemp/generated2/PrimTempBug.g:272:4: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/PrimTempBug.g:272:21: (temp= expression_expression ( ( COMA ) temp= expression_expression )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=NAME && LA2_0<=INT)||LA2_0==LPAREN) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:272:23: temp= expression_expression ( ( COMA ) temp= expression_expression )*
                    {
                    pushFollow(FOLLOW_expression_expression_in_expression_expressionlist259);
                    temp=expression_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/PrimTempBug.g:272:88: ( ( COMA ) temp= expression_expression )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/PrimTempBug.g:272:89: ( COMA ) temp= expression_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/PrimTempBug.g:272:106: ( COMA )
                    	    // ./scenariotestTemp/generated2/PrimTempBug.g:272:107: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_expression_expressionlist268); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_expression_expression_in_expression_expressionlist276);
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
    // ./scenariotestTemp/generated2/PrimTempBug.g:280:1: primary_expression_expression returns [Object ret2] : (ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) ) ;
    public final Object primary_expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:281:3: ( (ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:282:3: (ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:282:3: (ret= expression_stringexpression | ret= expression_valueexpression | ( LPAREN ret= expression_expression RPAREN ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case NAME:
                {
                alt3=1;
                }
                break;
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
                    // ./scenariotestTemp/generated2/PrimTempBug.g:282:4: ret= expression_stringexpression
                    {
                    pushFollow(FOLLOW_expression_stringexpression_in_primary_expression_expression321);
                    ret=expression_stringexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:283:5: ret= expression_valueexpression
                    {
                    pushFollow(FOLLOW_expression_valueexpression_in_primary_expression_expression329);
                    ret=expression_valueexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/PrimTempBug.g:284:5: ( LPAREN ret= expression_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/PrimTempBug.g:284:5: ( LPAREN ret= expression_expression RPAREN )
                    // ./scenariotestTemp/generated2/PrimTempBug.g:284:6: LPAREN ret= expression_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_expression_expression338); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_expression_expression_in_primary_expression_expression344);
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
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_expression_expression348); if (state.failed) return ret2;
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
    // ./scenariotestTemp/generated2/PrimTempBug.g:291:1: priority_0 returns [Object ret2] : ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;

        Object right = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:292:3: ( ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:293:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:293:4: ( (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:293:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:293:6: (ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )* )
            // ./scenariotestTemp/generated2/PrimTempBug.g:293:8: ret= primary_expression_expression ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            {
            pushFollow(FOLLOW_primary_expression_expression_in_priority_0386);
            ret=primary_expression_expression();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            // ./scenariotestTemp/generated2/PrimTempBug.g:293:41: ( ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==PLUS) && (synpred5_PrimTempBug())) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:42: ( ( PLUS ) () )=> ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    {
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:54: ( PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) ) )
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:55: PLUS ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	      _enterOpSeq("+", 2, false);
            	    }
            	    if ( state.backtracking==0 ) {
            	      _beforeSeqEl();
            	    }
            	    match(input,PLUS,FOLLOW_PLUS_in_priority_0399); if (state.failed) return ret2;
            	    if ( state.backtracking==0 ) {
            	      opName = "+";
            	    }
            	    if ( state.backtracking==0 ) {
            	      _afterSeqEl();
            	    }
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:137: ( (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression ) )
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:138: (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    {
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:138: (ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression )
            	    // ./scenariotestTemp/generated2/PrimTempBug.g:293:139: ret= expression_binaryexpression_expression_BinaryExpression_opPlus[opName, ret, firstToken] right= primary_expression_expression
            	    {
            	    pushFollow(FOLLOW_expression_binaryexpression_expression_BinaryExpression_opPlus_in_priority_0407);
            	    ret=expression_binaryexpression_expression_BinaryExpression_opPlus(opName, ret, firstToken);

            	    checkFollows();
            	    state._fsp--;
            	    if (state.failed) return ret2;
            	    pushFollow(FOLLOW_primary_expression_expression_in_priority_0411);
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
    // ./scenariotestTemp/generated2/PrimTempBug.g:303:1: expression_expression returns [Object ret2] : ret= priority_0 ;
    public final Object expression_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:304:3: (ret= priority_0 )
            // ./scenariotestTemp/generated2/PrimTempBug.g:305:3: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_expression_expression449);
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
    // ./scenariotestTemp/generated2/PrimTempBug.g:312:1: expression_binaryexpression_expression_BinaryExpression_opPlus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns [Object ret2] : ;
    public final Object expression_binaryexpression_expression_BinaryExpression_opPlus(java.lang.String opName, Object left, org.antlr.runtime.Token firstToken) throws RecognitionException {
        Object ret2 = null;

        List<String> metaType=list("expression","BinaryExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;


        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:317:3: ()
            // ./scenariotestTemp/generated2/PrimTempBug.g:318:3: 
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
    // ./scenariotestTemp/generated2/PrimTempBug.g:328:1: expression_valueexpression returns [Object ret2] : ( (temp= eintegerobject ) ) ;
    public final Object expression_valueexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","ValueExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:333:3: ( ( (temp= eintegerobject ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:334:3: ( (temp= eintegerobject ) )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:334:3: ( (temp= eintegerobject ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:334:4: (temp= eintegerobject )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/PrimTempBug.g:334:21: (temp= eintegerobject )
            // ./scenariotestTemp/generated2/PrimTempBug.g:334:23: temp= eintegerobject
            {
            pushFollow(FOLLOW_eintegerobject_in_expression_valueexpression510);
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
    // $ANTLR end "expression_valueexpression"


    // $ANTLR start "expression_stringexpression"
    // ./scenariotestTemp/generated2/PrimTempBug.g:342:1: expression_stringexpression returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object expression_stringexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("expression","StringExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/PrimTempBug.g:347:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:348:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/PrimTempBug.g:348:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/PrimTempBug.g:348:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/PrimTempBug.g:348:21: (temp= identifier )
            // ./scenariotestTemp/generated2/PrimTempBug.g:348:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_expression_stringexpression557);
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

    // $ANTLR start synpred5_PrimTempBug
    public final void synpred5_PrimTempBug_fragment() throws RecognitionException {   
        // ./scenariotestTemp/generated2/PrimTempBug.g:293:42: ( ( PLUS ) () )
        // ./scenariotestTemp/generated2/PrimTempBug.g:293:43: ( PLUS ) ()
        {
        // ./scenariotestTemp/generated2/PrimTempBug.g:293:43: ( PLUS )
        // ./scenariotestTemp/generated2/PrimTempBug.g:293:44: PLUS
        {
        match(input,PLUS,FOLLOW_PLUS_in_synpred5_PrimTempBug390); if (state.failed) return ;

        }

        // ./scenariotestTemp/generated2/PrimTempBug.g:293:49: ()
        // ./scenariotestTemp/generated2/PrimTempBug.g:293:50: 
        {
        }


        }
    }
    // $ANTLR end synpred5_PrimTempBug

    // Delegated rules

    public final boolean synpred5_PrimTempBug() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_PrimTempBug_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_NAME_in_wrongidentifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_identifier100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_badidentifier131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eintegerobject162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_badeintegerobject193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_expressionlist_in_main221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_expression_in_expression_expressionlist259 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_COMA_in_expression_expressionlist268 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expression_expression_in_expression_expressionlist276 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_expression_stringexpression_in_primary_expression_expression321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_valueexpression_in_primary_expression_expression329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_expression_expression338 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expression_expression_in_primary_expression_expression344 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RPAREN_in_primary_expression_expression348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0386 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_PLUS_in_priority_0399 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_expression_binaryexpression_expression_BinaryExpression_opPlus_in_priority_0407 = new BitSet(new long[]{0x00000000000000B0L});
    public static final BitSet FOLLOW_primary_expression_expression_in_priority_0411 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_priority_0_in_expression_expression449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eintegerobject_in_expression_valueexpression510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_expression_stringexpression557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_synpred5_PrimTempBug390 = new BitSet(new long[]{0x0000000000000002L});

}