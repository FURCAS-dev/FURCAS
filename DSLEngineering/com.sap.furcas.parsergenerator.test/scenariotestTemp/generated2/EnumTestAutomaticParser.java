// $ANTLR 3.1.1 ./scenariotestTemp/generated2/EnumTestAutomatic.g 2010-11-04 23:29:49

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
public class EnumTestAutomaticParser extends ObservableInjectingParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "COMA", "LPAREN", "RPAREN", "COMMENT", "LCURLY", "RCURLY", "PLUS", "NL", "WS", "DIGIT", "INT", "ALPHA", "SNAME", "ESC", "STRING", "'with'", "'speed'", "'mercury'", "'venus'", "'mars'", "'slow'", "'quick'", "'lightning'"
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
    public static final int LCURLY=9;
    public static final int INT=15;
    public static final int EOF=-1;
    public static final int COMA=5;
    public static final int ALPHA=16;
    public static final int LPAREN=6;
    public static final int RPAREN=7;
    public static final int NAME=4;
    public static final int WS=13;
    public static final int SNAME=17;
    public static final int RCURLY=10;
    public static final int PLUS=11;
    public static final int DIGIT=14;
    public static final int NL=12;
    public static final int COMMENT=8;
    public static final int STRING=19;

    // delegates
    // delegators


        public EnumTestAutomaticParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EnumTestAutomaticParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return EnumTestAutomaticParser.tokenNames; }
    public String getGrammarFileName() { return "./scenariotestTemp/generated2/EnumTestAutomatic.g"; }


       private static final String syntaxUUID = "EnumTestAutomatic";
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
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:207:1: identifier returns [Object ret2] : (ast= NAME ) ;
    public final Object identifier() throws RecognitionException {
        Object ret2 = null;

        Token ast=null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:208:3: ( (ast= NAME ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:209:3: (ast= NAME )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:209:3: (ast= NAME )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:209:4: ast= NAME
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


    // $ANTLR start "main"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:217:1: main returns [Object ret2] : ( (ret= enumtest_expressionlist ) EOF ) ;
    public final Object main() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:218:3: ( ( (ret= enumtest_expressionlist ) EOF ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:219:3: ( (ret= enumtest_expressionlist ) EOF )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:219:3: ( (ret= enumtest_expressionlist ) EOF )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:219:4: (ret= enumtest_expressionlist ) EOF
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:219:4: (ret= enumtest_expressionlist )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:219:5: ret= enumtest_expressionlist
            {
            pushFollow(FOLLOW_enumtest_expressionlist_in_main97);
            ret=enumtest_expressionlist();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;

            }

            match(input,EOF,FOLLOW_EOF_in_main100); if (state.failed) return ret2;

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


    // $ANTLR start "enumtest_expressionlist"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:226:1: enumtest_expressionlist returns [Object ret2] : ( (temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )* )? ) ;
    public final Object enumtest_expressionlist() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("enumtest","ExpressionList");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:231:3: ( ( (temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )* )? ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:3: ( (temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )* )? )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:3: ( (temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )* )? )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:4: (temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )* )?
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:21: (temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==NAME||LA2_0==LPAREN||(LA2_0>=22 && LA2_0<=24)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:23: temp= enumtest_expression ( ( COMA ) temp= enumtest_expression )*
                    {
                    pushFollow(FOLLOW_enumtest_expression_in_enumtest_expressionlist135);
                    temp=enumtest_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      setProperty(ret, "elements", temp);
                    }
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:86: ( ( COMA ) temp= enumtest_expression )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMA) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:87: ( COMA ) temp= enumtest_expression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _enterSepSeq();
                    	    }
                    	    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:104: ( COMA )
                    	    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:232:105: COMA
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	      _beforeSeqEl();
                    	    }
                    	    match(input,COMA,FOLLOW_COMA_in_enumtest_expressionlist144); if (state.failed) return ret2;
                    	    if ( state.backtracking==0 ) {
                    	      _afterSeqEl();
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	      _exitSepSeq();
                    	    }
                    	    pushFollow(FOLLOW_enumtest_expression_in_enumtest_expressionlist152);
                    	    temp=enumtest_expression();

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
    // $ANTLR end "enumtest_expressionlist"


    // $ANTLR start "primary_enumtest_expression"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:240:1: primary_enumtest_expression returns [Object ret2] : (ret= enumtest_planetexpression | ret= enumtest_stringexpression | ( LPAREN ret= enumtest_expression RPAREN ) ) ;
    public final Object primary_enumtest_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:241:3: ( (ret= enumtest_planetexpression | ret= enumtest_stringexpression | ( LPAREN ret= enumtest_expression RPAREN ) ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:242:3: (ret= enumtest_planetexpression | ret= enumtest_stringexpression | ( LPAREN ret= enumtest_expression RPAREN ) )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:242:3: (ret= enumtest_planetexpression | ret= enumtest_stringexpression | ( LPAREN ret= enumtest_expression RPAREN ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 22:
            case 23:
            case 24:
                {
                alt3=1;
                }
                break;
            case NAME:
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
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:242:4: ret= enumtest_planetexpression
                    {
                    pushFollow(FOLLOW_enumtest_planetexpression_in_primary_enumtest_expression197);
                    ret=enumtest_planetexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:243:5: ret= enumtest_stringexpression
                    {
                    pushFollow(FOLLOW_enumtest_stringexpression_in_primary_enumtest_expression205);
                    ret=enumtest_stringexpression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:244:5: ( LPAREN ret= enumtest_expression RPAREN )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:244:5: ( LPAREN ret= enumtest_expression RPAREN )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:244:6: LPAREN ret= enumtest_expression RPAREN
                    {
                    if ( state.backtracking==0 ) {
                      _enterOpdBrackSeq();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,LPAREN,FOLLOW_LPAREN_in_primary_enumtest_expression214); if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    pushFollow(FOLLOW_enumtest_expression_in_primary_enumtest_expression220);
                    ret=enumtest_expression();

                    checkFollows();
                    state._fsp--;
                    if (state.failed) return ret2;
                    if ( state.backtracking==0 ) {
                      _afterSeqEl();
                    }
                    if ( state.backtracking==0 ) {
                      _beforeSeqEl();
                    }
                    match(input,RPAREN,FOLLOW_RPAREN_in_primary_enumtest_expression224); if (state.failed) return ret2;
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
    // $ANTLR end "primary_enumtest_expression"


    // $ANTLR start "priority_0"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:251:1: priority_0 returns [Object ret2] : ( (ret= primary_enumtest_expression ) ) ;
    public final Object priority_0() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);
        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:252:3: ( ( (ret= primary_enumtest_expression ) ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:253:4: ( (ret= primary_enumtest_expression ) )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:253:4: ( (ret= primary_enumtest_expression ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:253:6: (ret= primary_enumtest_expression )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:253:6: (ret= primary_enumtest_expression )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:253:8: ret= primary_enumtest_expression
            {
            pushFollow(FOLLOW_primary_enumtest_expression_in_priority_0262);
            ret=primary_enumtest_expression();

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
    // $ANTLR end "priority_0"


    // $ANTLR start "enumtest_expression"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:261:1: enumtest_expression returns [Object ret2] : ret= priority_0 ;
    public final Object enumtest_expression() throws RecognitionException {
        Object ret2 = null;

        Object ret = null;


        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:262:3: (ret= priority_0 )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:263:3: ret= priority_0
            {
            pushFollow(FOLLOW_priority_0_in_enumtest_expression292);
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
    // $ANTLR end "enumtest_expression"


    // $ANTLR start "enumtest_stringexpression"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:270:1: enumtest_stringexpression returns [Object ret2] : ( (temp= identifier ) ) ;
    public final Object enumtest_stringexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("enumtest","StringExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:275:3: ( ( (temp= identifier ) ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:276:3: ( (temp= identifier ) )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:276:3: ( (temp= identifier ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:276:4: (temp= identifier )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:276:21: (temp= identifier )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:276:23: temp= identifier
            {
            pushFollow(FOLLOW_identifier_in_enumtest_stringexpression325);
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
    // $ANTLR end "enumtest_stringexpression"


    // $ANTLR start "enumtest_planetexpression"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:284:1: enumtest_planetexpression returns [Object ret2] : ( (temp= enumtest_planet ) 'with' 'speed' (temp= enumtest_speed ) ) ;
    public final Object enumtest_planetexpression() throws RecognitionException {
        Object ret2 = null;

        Object temp = null;


        List<String> metaType=list("enumtest","PlanetExpression");
        onEnterTemplateRule(metaType);
        IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
        org.antlr.runtime.Token firstToken=input.LT(1);

        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:289:3: ( ( (temp= enumtest_planet ) 'with' 'speed' (temp= enumtest_speed ) ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:3: ( (temp= enumtest_planet ) 'with' 'speed' (temp= enumtest_speed ) )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:3: ( (temp= enumtest_planet ) 'with' 'speed' (temp= enumtest_speed ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:4: (temp= enumtest_planet ) 'with' 'speed' (temp= enumtest_speed )
            {
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:21: (temp= enumtest_planet )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:23: temp= enumtest_planet
            {
            pushFollow(FOLLOW_enumtest_planet_in_enumtest_planetexpression372);
            temp=enumtest_planet();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "planet", temp);
            }

            }

            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,20,FOLLOW_20_in_enumtest_planetexpression378); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            match(input,21,FOLLOW_21_in_enumtest_planetexpression381); if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              _afterSeqEl();
            }
            if ( state.backtracking==0 ) {
              _beforeSeqEl();
            }
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:192: (temp= enumtest_speed )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:290:194: temp= enumtest_speed
            {
            pushFollow(FOLLOW_enumtest_speed_in_enumtest_planetexpression388);
            temp=enumtest_speed();

            checkFollows();
            state._fsp--;
            if (state.failed) return ret2;
            if ( state.backtracking==0 ) {
              setProperty(ret, "speed", temp);
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
    // $ANTLR end "enumtest_planetexpression"


    // $ANTLR start "enumtest_planet"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:298:1: enumtest_planet returns [Object ret2] : ( ( 'mercury' ) | ( 'venus' ) | ( 'mars' ) ) ;
    public final Object enumtest_planet() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:299:3: ( ( ( 'mercury' ) | ( 'venus' ) | ( 'mars' ) ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:300:3: ( ( 'mercury' ) | ( 'venus' ) | ( 'mars' ) )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:300:3: ( ( 'mercury' ) | ( 'venus' ) | ( 'mars' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt4=1;
                }
                break;
            case 23:
                {
                alt4=2;
                }
                break;
            case 24:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ret2;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:300:4: ( 'mercury' )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:300:4: ( 'mercury' )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:300:5: 'mercury'
                    {
                    match(input,22,FOLLOW_22_in_enumtest_planet431); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("enumtest","Planet"), "mercury");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:301:4: ( 'venus' )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:301:4: ( 'venus' )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:301:5: 'venus'
                    {
                    match(input,23,FOLLOW_23_in_enumtest_planet439); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("enumtest","Planet"), "venus");
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:302:4: ( 'mars' )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:302:4: ( 'mars' )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:302:5: 'mars'
                    {
                    match(input,24,FOLLOW_24_in_enumtest_planet447); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("enumtest","Planet"), "mars");
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
    // $ANTLR end "enumtest_planet"


    // $ANTLR start "enumtest_speed"
    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:309:1: enumtest_speed returns [Object ret2] : ( ( 'slow' ) | ( 'quick' ) | ( 'lightning' ) ) ;
    public final Object enumtest_speed() throws RecognitionException {
        Object ret2 = null;

        java.lang.Object ret=null;
        try {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:310:3: ( ( ( 'slow' ) | ( 'quick' ) | ( 'lightning' ) ) )
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:311:3: ( ( 'slow' ) | ( 'quick' ) | ( 'lightning' ) )
            {
            // ./scenariotestTemp/generated2/EnumTestAutomatic.g:311:3: ( ( 'slow' ) | ( 'quick' ) | ( 'lightning' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt5=1;
                }
                break;
            case 26:
                {
                alt5=2;
                }
                break;
            case 27:
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
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:311:4: ( 'slow' )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:311:4: ( 'slow' )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:311:5: 'slow'
                    {
                    match(input,25,FOLLOW_25_in_enumtest_speed477); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("enumtest","Speed"), "slow");
                    }

                    }
                    break;
                case 2 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:312:4: ( 'quick' )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:312:4: ( 'quick' )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:312:5: 'quick'
                    {
                    match(input,26,FOLLOW_26_in_enumtest_speed485); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("enumtest","Speed"), "quick");
                    }

                    }
                    break;
                case 3 :
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:313:4: ( 'lightning' )
                    {
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:313:4: ( 'lightning' )
                    // ./scenariotestTemp/generated2/EnumTestAutomatic.g:313:5: 'lightning'
                    {
                    match(input,27,FOLLOW_27_in_enumtest_speed493); if (state.failed) return ret2;

                    }

                    if ( state.backtracking==0 ) {
                      ret = createEnumLiteral(list("enumtest","Speed"), "lightning");
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
    // $ANTLR end "enumtest_speed"

    // Delegated rules


 

    public static final BitSet FOLLOW_NAME_in_identifier69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumtest_expressionlist_in_main97 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_main100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumtest_expression_in_enumtest_expressionlist135 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_COMA_in_enumtest_expressionlist144 = new BitSet(new long[]{0x0000000001C00050L});
    public static final BitSet FOLLOW_enumtest_expression_in_enumtest_expressionlist152 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_enumtest_planetexpression_in_primary_enumtest_expression197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumtest_stringexpression_in_primary_enumtest_expression205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primary_enumtest_expression214 = new BitSet(new long[]{0x0000000001C00050L});
    public static final BitSet FOLLOW_enumtest_expression_in_primary_enumtest_expression220 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RPAREN_in_primary_enumtest_expression224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_enumtest_expression_in_priority_0262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_priority_0_in_enumtest_expression292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_enumtest_stringexpression325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumtest_planet_in_enumtest_planetexpression372 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_enumtest_planetexpression378 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_enumtest_planetexpression381 = new BitSet(new long[]{0x000000000E000000L});
    public static final BitSet FOLLOW_enumtest_speed_in_enumtest_planetexpression388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_enumtest_planet431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_enumtest_planet439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_enumtest_planet447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_enumtest_speed477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_enumtest_speed485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_enumtest_speed493 = new BitSet(new long[]{0x0000000000000002L});

}