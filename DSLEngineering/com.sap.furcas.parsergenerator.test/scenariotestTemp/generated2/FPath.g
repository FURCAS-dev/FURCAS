grammar FPath;
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
   private static final String syntaxUUID = "FPath";
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
  ((ret=fpath_expression) EOF) 
  {
ret2=ret;
}
  ;


primary_fpath_expression returns[Object ret2]
  :
  (ret=fpath_contextexp
  | ret=fpath_functioncallexp
  | ret=fpath_numberexp
  | ret=fpath_stringexp
  | ret=fpath_variableexp
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=fpath_expression{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=primary_fpath_expression(((SLASH)())=>({_enterOpSeq("/", 2, false);}{_beforeSeqEl();}SLASH {opName = "/";}{_afterSeqEl();}((ret=fpath_pathexp_FPath_PathExp_opSlash[opName, ret, firstToken])){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   (((('not')())=>({_enterOpSeq("not", 1, false);}{_beforeSeqEl();}'not'{opName = "not";}{_afterSeqEl();}((ret=fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken]right=priority_0 {setProperty(ret, "operand", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((MINUS)())=>({_enterOpSeq("-", 1, false);}{_beforeSeqEl();}MINUS {opName = "-";}{_afterSeqEl();}((ret=fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[opName, null, firstToken]right=priority_0 {setProperty(ret, "operand", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))
|
 ( ret=priority_0))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_2 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_1(((STAR)())=>({_enterOpSeq("*", 2, false);}{_beforeSeqEl();}STAR {opName = "*";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (('div')())=>({_enterOpSeq("div", 2, false);}{_beforeSeqEl();}'div'{opName = "div";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_1 {setProperty(ret, "right", right);
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
   ( ( ret=priority_2(((PLUS)())=>({_enterOpSeq("+", 2, false);}{_beforeSeqEl();}PLUS {opName = "+";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((MINUS)())=>({_enterOpSeq("-", 2, false);}{_beforeSeqEl();}MINUS {opName = "-";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

priority_4 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=priority_3(((LT)())=>({_enterOpSeq("<", 2, false);}{_beforeSeqEl();}LT {opName = "<";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((GT)())=>({_enterOpSeq(">", 2, false);}{_beforeSeqEl();}GT {opName = ">";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((LE)())=>({_enterOpSeq("<=", 2, false);}{_beforeSeqEl();}LE {opName = "<=";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((GE)())=>({_enterOpSeq(">=", 2, false);}{_beforeSeqEl();}GE {opName = ">=";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((EQEQ)())=>({_enterOpSeq("==", 2, false);}{_beforeSeqEl();}EQEQ {opName = "==";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((NE)())=>({_enterOpSeq("<>", 2, false);}{_beforeSeqEl();}NE {opName = "<>";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_3 {setProperty(ret, "right", right);
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
   ( ( ret=priority_4((('and')())=>({_enterOpSeq("and", 2, false);}{_beforeSeqEl();}'and'{opName = "and";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_4 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (('or')())=>({_enterOpSeq("or", 2, false);}{_beforeSeqEl();}'or'{opName = "or";}{_afterSeqEl();}((ret=fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[opName, ret, firstToken]right=priority_4 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

fpath_expression returns[Object ret2]
  :
  ret=priority_5
  {
ret2=ret;
 }
  ;


fpath_contextexp returns[Object ret2] @init{List<String> metaType=list("FPath","ContextExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} POINT {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

fpath_variableexp returns[Object ret2] @init{List<String> metaType=list("FPath","VariableExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'$'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

fpath_functioncallexp returns[Object ret2] @init{List<String> metaType=list("FPath","FunctionCallExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=fpath_expression {setProperty(ret, "arguments", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=fpath_expression {setProperty(ret, "arguments", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

fpath_numberexp returns[Object ret2] @init{List<String> metaType=list("FPath","NumberExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=floatSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

fpath_stringexp returns[Object ret2] @init{List<String> metaType=list("FPath","StringExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

fpath_pathexp_FPath_PathExp_opSlash[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("FPath","PathExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl();}( temp=fpath_step {setProperty(ret, "steps", temp);} ({_enterSepSeq();}({_beforeSeqEl();} SLASH {_afterSeqEl();}){_exitSepSeq();} temp=fpath_step {setProperty(ret, "steps", temp);})* ){_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"initialNodeSet" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

fpath_binaryoperatorexp_FPath_BinaryOperatorExp_opMul_opDiv_opPlus_opMinus2_opLt_opGt_opLe_opGe_opEq_opNe_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("FPath","BinaryOperatorExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  {
setProperty(ret,"operator" , opName);
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

fpath_unaryoperatorexp_FPath_UnaryOperatorExp_opNot_opMinus1[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("FPath","UnaryOperatorExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  {
setProperty(ret,"operator" , opName);
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

fpath_step returns[Object ret2] @init{List<String> metaType=list("FPath","Step");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=fpath_axis {setProperty(ret, "axis", temp);}){_afterSeqEl();}{_beforeSeqEl();} COLONCOLON {_afterSeqEl();}{_beforeSeqEl();}( temp=fpath_test {setProperty(ret, "test", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=fpath_expression {setProperty(ret, "predicates", temp);} ({_enterSepSeq();}({_beforeSeqEl();} RSQUARE {_afterSeqEl();}{_beforeSeqEl();} LSQUARE {_afterSeqEl();}){_exitSepSeq();} temp=fpath_expression {setProperty(ret, "predicates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

fpath_test returns[Object ret2]
  :
  (ret=fpath_wildcardtest
  | ret=fpath_nametest)
  {
ret2=ret;
 }
  ;


fpath_wildcardtest returns[Object ret2] @init{List<String> metaType=list("FPath","WildcardTest");
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

fpath_nametest returns[Object ret2] @init{List<String> metaType=list("FPath","NameTest");
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

fpath_axis returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl();}'component'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "component");}
 | ({_beforeSeqEl();}'internal-interface'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "internal-interface");}
 | ({_beforeSeqEl();}'interface'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "interface");}
 | ({_beforeSeqEl();}'attribute'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "attribute");}
 | ({_beforeSeqEl();}'binding'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "binding");}
 | ({_beforeSeqEl();}'child'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "child");}
 | ({_beforeSeqEl();}'parent'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "parent");}
 | ({_beforeSeqEl();}'descendant'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "descendant");}
 | ({_beforeSeqEl();}'ancestor'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "ancestor");}
 | ({_beforeSeqEl();}'sibling'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "sibling");}
 | ({_beforeSeqEl();}'descendant-or-self'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "descendant-or-self");}
 | ({_beforeSeqEl();}'ancestor-or-self'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "ancestor-or-self");}
 | ({_beforeSeqEl();}'sibling-or-self'{_afterSeqEl();}){ret = createEnumLiteral(list("FPath","Axis"), "sibling-or-self");})
{
  ret2=ret;
}
  ;


COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


LSQUARE
  :
  '['
  ;


RSQUARE
  :
  ']'
  ;


EXCL
  :
  '!'
  ;


COMA
  :
  ','
  ;


LPAREN
  :
  '('
  ;


RPAREN
  :
  ')'
  ;


LCURLY
  :
  '{'
  ;


RCURLY
  :
  '}'
  ;


SEMI
  :
  ';'
  ;


COLON
  :
  ':'
  ;


COLONCOLON
  :
  '::'
  ;


PIPE
  :
  '|'
  ;


SHARP
  :
  '#'
  ;


QMARK
  :
  '?'
  ;


POINT
  :
  '.'
  ;


RARROW
  :
  '->'
  ;


MINUS
  :
  '-'
  ;


STAR
  :
  '*'
  ;


SLASH
  :
  '/'
  ;


PLUS
  :
  '+'
  ;


EQ
  :
  '='
  ;


EQEQ
  :
  '=='
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


NE
  :
  '<>'
  ;


LARROW
  :
  '<-'
  ;



// testLiterals = false;

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

	FLOAT	:	DIGIT+ ('.' DIGIT*)?	;

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

	