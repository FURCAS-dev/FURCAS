grammar XPath;
options {superClass=ObservableInjectingParser;backtrack = true;}

@lexer::header {
package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

@lexer::members {  public com.sap.furcas.runtime.parser.IModelInjector ei = null;
public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;
  /*************** Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
  private void newline() {}

  public final Token emit() {
	// override emit() to generate own token class
	ANTLR3LocationToken ret = null;
        ITokenFactory<? extends ANTLR3LocationToken> tokenFactory = getTokenFactory();
        ret = tokenFactory.createToken(input, state.type, state.channel, state.tokenStartCharIndex, getCharIndex()-1);
    	   ret.setLine(state.tokenStartLine);
        String newtext = input.substring(state.tokenStartCharIndex,getCharIndex()-1);
        ret.setText(newtext); // sets the text as exactly what has been read
        ret.setCharPositionInLine(state.tokenStartCharPositionInLine);
        ret.setEndLine(getLine());
        ret.setEndColumn(getCharPositionInLine());
        emit(ret);
        return ret;
      }
      
      private ITokenFactory<? extends ANTLR3LocationToken> getTokenFactory() {
          if (tokenFactory == null) {
              tokenFactory = new DefaultANTLR3LocationTokenFactory();
          }
          return tokenFactory;
      }
   /**
     * Unescape string.
     * 
     * @param s the s
     * @param delimLength the delim length
     * 
     * @return the string
     * @deprecated
     */
    public String unescapeString(String s, int delimLength) {
        StringBuilder ret = new StringBuilder();
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
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

      public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
          if (ei != null) {
              ei.reportError(e);
          } else {
              super.displayRecognitionError(tokenNames, e);
          }
          
       }
  /*************** End of Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
}

@header {
package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
   private static final String syntaxUUID = "XPath";
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

}


identifier returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=NAME {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


stringSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=STRING {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


integerSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=INT {ret = Integer.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


floatSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FLOAT {ret = Double.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


main returns[Object ret2]
  :
  ((ret=xpath_expression) EOF) 
  {
ret2=ret;
}
  ;


primary_xpath_expression returns[Object ret2]
  :
  (ret=xpath_functioncallexp
  | ret=xpath_literalexp
  | ret=xpath_pathexpression
  | ret=xpath_variableexp
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=xpath_expression{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   (ret=primary_xpath_expression)
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   (ret=priority_0)
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_2 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_1(((PIPE)())=>({_enterOpSeq("|", 2, false);}{_beforeSeqEl();}PIPE {opName = "|";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_3 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ((((MINUS)())=>({_enterOpSeq("-", 1, false);}{_beforeSeqEl();}MINUS {opName = "-";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, null, firstToken]right=priority_2 {setProperty(ret, "left", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))
|
 ( ret=priority_2))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_4 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_3(((STAR)())=>({_enterOpSeq("*", 2, false);}{_beforeSeqEl();}STAR {opName = "*";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (('div')())=>({_enterOpSeq("div", 2, false);}{_beforeSeqEl();}'div'{opName = "div";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (('mod')())=>({_enterOpSeq("mod", 2, false);}{_beforeSeqEl();}'mod'{opName = "mod";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_5 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_4(((PLUS)())=>({_enterOpSeq("+", 2, false);}{_beforeSeqEl();}PLUS {opName = "+";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_4 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((MINUS)())=>({_enterOpSeq("-", 2, false);}{_beforeSeqEl();}MINUS {opName = "-";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_4 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_6 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_5(((LT)())=>({_enterOpSeq("<", 2, false);}{_beforeSeqEl();}LT {opName = "<";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_5 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((LE)())=>({_enterOpSeq("<=", 2, false);}{_beforeSeqEl();}LE {opName = "<=";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_5 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((GT)())=>({_enterOpSeq(">", 2, false);}{_beforeSeqEl();}GT {opName = ">";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_5 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((GE)())=>({_enterOpSeq(">=", 2, false);}{_beforeSeqEl();}GE {opName = ">=";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_5 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_7 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_6(((EQ)())=>({_enterOpSeq("=", 2, false);}{_beforeSeqEl();}EQ {opName = "=";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_6 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((EXCLEQ)())=>({_enterOpSeq("!=", 2, false);}{_beforeSeqEl();}EXCLEQ {opName = "!=";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_6 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_8 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_7((('and')())=>({_enterOpSeq("and", 2, false);}{_beforeSeqEl();}'and'{opName = "and";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_7 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_9 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_8((('or')())=>({_enterOpSeq("or", 2, false);}{_beforeSeqEl();}'or'{opName = "or";}{_afterSeqEl();}((ret=xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[opName, ret, firstToken]right=priority_8 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

xpath_expression returns[Object ret2]
  :
  ret=priority_9
  {
ret2=ret;
 }
  ;


xpath_variableexp returns[Object ret2] @init{List<String> metaType=list("XPath","VariableExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} DOLLAR {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_pathexpression returns[Object ret2] @init{List<String> metaType=list("XPath","PathExpression");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} SLASH {_afterSeqEl();}{_beforeSeqEl();}( temp=xpath_step {setProperty(ret, "steps", temp);} ({_enterSepSeq();}({_beforeSeqEl();} SLASH {_afterSeqEl();}){_exitSepSeq();} temp=xpath_step {setProperty(ret, "steps", temp);})* )? {_afterSeqEl();}){setProperty(ret, "isAbsolute", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}( temp=xpath_step {setProperty(ret, "steps", temp);} ({_enterSepSeq();}({_beforeSeqEl();} SLASH {_afterSeqEl();}){_exitSepSeq();} temp=xpath_step {setProperty(ret, "steps", temp);})* ){_afterSeqEl();}){setProperty(ret, "isAbsolute", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_step returns[Object ret2] @init{List<String> metaType=list("XPath","Step");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}({_enterAlt(0);} ({_beforeSeqEl();}( temp=xpath_axis {setProperty(ret, "axis", temp);}){_afterSeqEl();}{_beforeSeqEl();}( temp=xpath_nodetest {setProperty(ret, "nodeTest", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl();} POINT {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl();} POINTPOINT {_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl();}( temp=xpath_predicate {setProperty(ret, "predicates", temp);} ( temp=xpath_predicate {setProperty(ret, "predicates", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_predicate returns[Object ret2] @init{List<String> metaType=list("XPath","Predicate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=xpath_expression {setProperty(ret, "expression", temp);}){_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_operatorcallexp_XPath_OperatorCallExp_opUnion_opMinus1_opMul_opDiv_opMod_opPlus_opMinus_opLT_opLE_opGT_opGE_opEQ_opNE_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("XPath","OperatorCallExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  {
setProperty(ret,"name" , opName);
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

xpath_functioncallexp returns[Object ret2] @init{List<String> metaType=list("XPath","FunctionCallExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=xpath_expression {setProperty(ret, "arguments", temp);} ({_enterSepSeq();}({_beforeSeqEl();}','{_afterSeqEl();}){_exitSepSeq();} temp=xpath_expression {setProperty(ret, "arguments", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_literalexp returns[Object ret2]
  :
  (ret=xpath_integerexp
  | ret=xpath_stringexp)
  {
ret2=ret;
 }
  ;


xpath_integerexp returns[Object ret2] @init{List<String> metaType=list("XPath","IntegerExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_stringexp returns[Object ret2] @init{List<String> metaType=list("XPath","StringExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_nodetest returns[Object ret2]
  :
  (ret=xpath_nametest
  | ret=xpath_wildcardtest
  | ret=xpath_isnodetest
  | ret=xpath_istexttest)
  {
ret2=ret;
 }
  ;


xpath_nametest returns[Object ret2] @init{List<String> metaType=list("XPath","NameTest");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_wildcardtest returns[Object ret2] @init{List<String> metaType=list("XPath","WildCardTest");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} STAR {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_isnodetest returns[Object ret2] @init{List<String> metaType=list("XPath","IsNodeTest");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'node'{_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_istexttest returns[Object ret2] @init{List<String> metaType=list("XPath","IsTextTest");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'text'{_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_axis returns[Object ret2]
  :
  (ret=xpath_ancestoraxis
  | ret=xpath_ancestororselfaxis
  | ret=xpath_attributeaxis
  | ret=xpath_childaxis
  | ret=xpath_descendantaxis
  | ret=xpath_descendantorselfaxis
  | ret=xpath_followingaxis
  | ret=xpath_followingsiblingaxis
  | ret=xpath_namespaceaxis
  | ret=xpath_parentaxis
  | ret=xpath_precedingaxis
  | ret=xpath_precedingsiblingaxis
  | ret=xpath_selfaxis)
  {
ret2=ret;
 }
  ;


xpath_ancestoraxis returns[Object ret2] @init{List<String> metaType=list("XPath","AncestorAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'ancestor'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_ancestororselfaxis returns[Object ret2] @init{List<String> metaType=list("XPath","AncestorOrSelfAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'ancestor-or-self'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_attributeaxis returns[Object ret2] @init{List<String> metaType=list("XPath","AttributeAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}({_enterAlt(0);} ({_beforeSeqEl();}'attribute'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl();} AROBAS {_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_childaxis returns[Object ret2] @init{List<String> metaType=list("XPath","ChildAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}({_enterAlt(0);} ({_beforeSeqEl();}'child'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} (){_exitAlt();} ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_descendantaxis returns[Object ret2] @init{List<String> metaType=list("XPath","DescendantAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'descendant'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_descendantorselfaxis returns[Object ret2] @init{List<String> metaType=list("XPath","DescendantOrSelfAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'descendant-or-self'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_followingaxis returns[Object ret2] @init{List<String> metaType=list("XPath","FollowingAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'following'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_followingsiblingaxis returns[Object ret2] @init{List<String> metaType=list("XPath","FollowingSiblingAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'following-sibling'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_namespaceaxis returns[Object ret2] @init{List<String> metaType=list("XPath","NamespaceAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'namespace'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_parentaxis returns[Object ret2] @init{List<String> metaType=list("XPath","ParentAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'parent'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_precedingaxis returns[Object ret2] @init{List<String> metaType=list("XPath","PrecedingAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'preceding'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_precedingsiblingaxis returns[Object ret2] @init{List<String> metaType=list("XPath","PrecedingSiblingAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'preceding-sibling'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

xpath_selfaxis returns[Object ret2] @init{List<String> metaType=list("XPath","SelfAxis");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'self'{_afterSeqEl();}{_beforeSeqEl();} COLONS {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


DOLLAR
  :
  '$'
  ;


LSQUARE
  :
  '['
  ;


RSQUARE
  :
  ']'
  ;


LPAREN
  :
  '('
  ;


RPAREN
  :
  ')'
  ;


COLONS
  :
  '::'
  ;


POINT
  :
  '.'
  ;


POINTPOINT
  :
  '..'
  ;


AROBAS
  :
  '@'
  ;


SLASH
  :
  '/'
  ;


PIPE
  :
  '|'
  ;


MINUS
  :
  '-'
  ;


STAR
  :
  '*'
  ;


SLASHSLASH
  :
  '//'
  ;


PLUS
  :
  '+'
  ;


EQ
  :
  '='
  ;


GT
  :
  '>'
  ;


LT
  :
  '<'
  ;


GE
  :
  '>='
  ;


LE
  :
  '<='
  ;


EXCLEQ
  :
  '!='
  ;



NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

WS
	:	(	' '
		|	'\t'
		)
	;

fragment
DIGIT
	:	'0'..'9'
	;

fragment
ALPHA
	:	'a'..'z'
	|	'A'..'Z'
	|	'_'
	//For Unicode compatibility (from 0000 to 00ff)
	|	'\u00C0' .. '\u00D6'
	|	'\u00D8' .. '\u00F6'
	|	'\u00F8' .. '\u00FF'
	;

fragment
SNAME
	:	(ALPHA) (ALPHA | DIGIT)*
;

NAME
	:	(
			SNAME
		|	'"'!
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\"'|'\n')
			)*
			'"'!
			{setText(unescapeString(getText(), 1));}
		)
	;

INT
	:	(DIGIT)+
	;

	FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

fragment
ESC
	:	'\\'!
		(	'n' 
		|	'r' 
		|	't' 
		|	'b' 
		|	'f' 
		|	'"' 
		|	'\'' 
		|	'\\' 
		|	(
				('0'..'3')
				(
				:	('0'..'7')
					(
					:	'0'..'7'
					)?
				)?
			|	('4'..'7')
				(
				:	('0'..'7')
				)?
			)
				{
				}
		)
	;

STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
		{setText(unescapeString(getText(), 1));}
	;
	