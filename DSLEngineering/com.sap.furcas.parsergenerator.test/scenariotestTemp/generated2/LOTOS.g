grammar LOTOS;
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
   private static final String syntaxUUID = "LOTOS";
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


identifierOrKeyword returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=NAME {ret = unescapeString( ast.getText());
}
  | 'is' {ret = "is";}
  | 'false' {ret = "false";}
  | 'true' {ret = "true";}
  | 'choice' {ret = "choice";}
  | 'sorts' {ret = "sorts";}
  | 'library' {ret = "library";}
  | 'endtype' {ret = "endtype";}
  | 'process' {ret = "process";}
  | 'hide' {ret = "hide";}
  | 'where' {ret = "where";}
  | 'of' {ret = "of";}
  | 'endproc' {ret = "endproc";}
  | 'in' {ret = "in";}
  | 'ofsort' {ret = "ofsort";}
  | 'forall' {ret = "forall";}
  | 'or' {ret = "or";}
  | 'let' {ret = "let";}
  | 'and' {ret = "and";}
  | 'endlib' {ret = "endlib";}
  | 'opns' {ret = "opns";}
  | 'neq' {ret = "neq";}
  | 'exit' {ret = "exit";}
  | 'endspec' {ret = "endspec";}
  | 'eqns' {ret = "eqns";}
  | 'behaviour' {ret = "behaviour";}
  | 'specification' {ret = "specification";}
  | 'type' {ret = "type";}
  | 'eq' {ret = "eq";}
  | 'noexit' {ret = "noexit";})
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
  ((ret=lotos_specification) EOF) 
  {
ret2=ret;
}
  ;


lotos_specification returns[Object ret2] @init{List<String> metaType=list("LOTOS","Specification");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'specification'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "gates", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "gates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'exit'{_afterSeqEl();}){setProperty(ret, "isExit", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}'noexit'{_afterSeqEl();}){setProperty(ret, "isExit", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_type {setProperty(ret, "types", temp);} ( temp=lotos_type {setProperty(ret, "types", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();}'behaviour'{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}( temp=lotos_definition {setProperty(ret, "definition", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();}'endspec'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_definition returns[Object ret2] @init{List<String> metaType=list("LOTOS","Definition");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_behaviour {setProperty(ret, "behaviour", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'where'{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_typeorprocessdeclaration {setProperty(ret, "declarations", temp);} ( temp=lotos_typeorprocessdeclaration {setProperty(ret, "declarations", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_typeorprocessdeclaration returns[Object ret2]
  :
  (ret=lotos_process
  | ret=lotos_type)
  {
ret2=ret;
 }
  ;


lotos_process returns[Object ret2] @init{List<String> metaType=list("LOTOS","Process");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'process'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "gates", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "gates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_variabledeclarations {setProperty(ret, "variables", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=lotos_variabledeclarations {setProperty(ret, "variables", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'exit'{_afterSeqEl();}){setProperty(ret, "isExit", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}'noexit'{_afterSeqEl();}){setProperty(ret, "isExit", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} COLONEQ {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_definition {setProperty(ret, "definition", temp);}){_afterSeqEl();}{_beforeSeqEl();}'endproc'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

primary_lotos_behaviour returns[Object ret2]
  :
  (ret=lotos_processcall
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=lotos_behaviour{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


behaviour_priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ((({_enterOpSeq(";", 1, false);}((ret=lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[opName, null, firstToken]{_beforeSeqEl();}SEMI {opName = ";";}{_afterSeqEl();}right=behaviour_priority_0 {setProperty(ret, "behaviour", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))
|
 ( ret=primary_lotos_behaviour))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

behaviour_priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ((((RARROW)())=>({_enterOpSeq("->", 1, false);}{_beforeSeqEl();}RARROW {opName = "->";}{_afterSeqEl();}((ret=lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[opName, null, firstToken]right=behaviour_priority_0 {setProperty(ret, "behaviour", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))
|
 ( ret=behaviour_priority_0))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

behaviour_priority_2 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=behaviour_priority_1(((LSQUARERSQUARE)())=>({_enterOpSeq("[]", 2, false);}{_beforeSeqEl();}LSQUARERSQUARE {opName = "[]";}{_afterSeqEl();}((ret=lotos_alternative_LOTOS_Alternative_alternativeOp[opName, ret, firstToken]right=behaviour_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

behaviour_priority_3 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=behaviour_priority_2(((PIPE3)())=>({_enterOpSeq("|||", 2, false);}{_beforeSeqEl();}PIPE3 {opName = "|||";}{_afterSeqEl();}((ret=lotos_simpleparallel_LOTOS_SimpleParallel_parOp[opName, ret, firstToken]right=behaviour_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((PIPELSQUARE)())=>({_enterOpSeq("|[", 2, false);}{_beforeSeqEl();}PIPELSQUARE {opName = "|[";}{_afterSeqEl();}((ret=lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[opName, ret, firstToken]right=behaviour_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

lotos_behaviour returns[Object ret2]
  :
  (ret=behaviour_priority_3
  | ret=lotos_choice
  | ret=lotos_hide
  | ret=lotos_let)
  {
ret2=ret;
 }
  ;


lotos_let returns[Object ret2] @init{List<String> metaType=list("LOTOS","Let");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'let'{_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_variabledeclarations {setProperty(ret, "variables", temp);}){_afterSeqEl();}{_beforeSeqEl();} EQ {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl();}'in'{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_behaviour {setProperty(ret, "behaviour", temp);}){_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_choice returns[Object ret2] @init{List<String> metaType=list("LOTOS","Choice");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'choice'{_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_variabledeclarations {setProperty(ret, "variables", temp);}){_afterSeqEl();}{_beforeSeqEl();} LSQUARERSQUARE {_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_behaviour {setProperty(ret, "behaviour", temp);}){_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_hide returns[Object ret2] @init{List<String> metaType=list("LOTOS","Hide");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'hide'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "gates", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "gates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}'in'{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_behaviour {setProperty(ret, "behaviour", temp);}){_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_processcall returns[Object ret2] @init{List<String> metaType=list("LOTOS","ProcessCall");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "gates", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "gates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "arguments", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=lotos_value {setProperty(ret, "arguments", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_simpleparallel_LOTOS_SimpleParallel_parOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","SimpleParallel");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  {
// discarding operator name instead of storing it here
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_gatedparallel_LOTOS_GatedParallel_gatedParOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","GatedParallel");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "gates", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "gates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RSQUAREPIPE {_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_guardedbehaviour_LOTOS_GuardedBehaviour_guardedOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","GuardedBehaviour");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_guardexpression {setProperty(ret, "guard", temp);}){_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"behaviour" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_actionbehaviour_LOTOS_ActionBehaviour_semiOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","ActionBehaviour");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;

}
  :
  ({_beforeSeqEl();}( temp=lotos_action {setProperty(ret, "action", temp);}){_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"behaviour" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);
leaveContext();

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_alternative_LOTOS_Alternative_alternativeOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","Alternative");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  {
// discarding operator name instead of storing it here
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_action returns[Object ret2]
  :
  (ret=lotos_gateaction)
  {
ret2=ret;
 }
  ;


lotos_gateaction returns[Object ret2] @init{List<String> metaType=list("LOTOS","GateAction");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "gate", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}( temp=lotos_communication {setProperty(ret, "communications", temp);} ( temp=lotos_communication {setProperty(ret, "communications", temp);})* ){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_guardexpression {setProperty(ret, "guard", temp);}){_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_communication returns[Object ret2]
  :
  (ret=lotos_incomm
  | ret=lotos_outcomm)
  {
ret2=ret;
 }
  ;


lotos_incomm returns[Object ret2] @init{List<String> metaType=list("LOTOS","InComm");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} QMARK {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_variabledeclarations {setProperty(ret, "declarations", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_outcomm returns[Object ret2] @init{List<String> metaType=list("LOTOS","OutComm");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} EXCL {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_guardexpression returns[Object ret2]
  :
  (ret=lotos_equalitytestguardexp
  | ret=lotos_booleanguardexp)
  {
ret2=ret;
 }
  ;


lotos_equalitytestguardexp returns[Object ret2] @init{List<String> metaType=list("LOTOS","EqualityTestGuardExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "left", temp);}){_afterSeqEl();}{_beforeSeqEl();} EQ {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "right", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_booleanguardexp returns[Object ret2] @init{List<String> metaType=list("LOTOS","BooleanGuardExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

primary_lotos_value returns[Object ret2]
  :
  (ret=lotos_booleanval
  | ret=lotos_integerval
  | ret=lotos_operationcall
  | ret=lotos_variable
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=lotos_value{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


value_priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=primary_lotos_value((('of')())=>({_enterOpSeq("of", 2, false);}{_beforeSeqEl();}'of'{opName = "of";}{_afterSeqEl();}((ret=lotos_castval_LOTOS_CastVal_opOf[opName, ret, firstToken])){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

value_priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=value_priority_0(((PLUS)())=>({_enterOpSeq("+", 2, false);}{_beforeSeqEl();}PLUS {opName = "+";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_0 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

value_priority_2 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=value_priority_1((('eq')())=>({_enterOpSeq("eq", 2, false);}{_beforeSeqEl();}'eq'{opName = "eq";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((GE)())=>({_enterOpSeq(">=", 2, false);}{_beforeSeqEl();}GE {opName = ">=";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((GT)())=>({_enterOpSeq(">", 2, false);}{_beforeSeqEl();}GT {opName = ">";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((LE)())=>({_enterOpSeq("<=", 2, false);}{_beforeSeqEl();}LE {opName = "<=";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ((LT)())=>({_enterOpSeq("<", 2, false);}{_beforeSeqEl();}LT {opName = "<";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (('neq')())=>({_enterOpSeq("neq", 2, false);}{_beforeSeqEl();}'neq'{opName = "neq";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

value_priority_3 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=value_priority_2((('and')())=>({_enterOpSeq("and", 2, false);}{_beforeSeqEl();}'and'{opName = "and";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (('or')())=>({_enterOpSeq("or", 2, false);}{_beforeSeqEl();}'or'{opName = "or";}{_afterSeqEl();}((ret=lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[opName, ret, firstToken]right=value_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

lotos_value returns[Object ret2]
  :
  ret=value_priority_3
  {
ret2=ret;
 }
  ;


lotos_variable returns[Object ret2] @init{List<String> metaType=list("LOTOS","Variable");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setRef(ret, "declaration", list("LOTOS","Declaration"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_operationcall returns[Object ret2] @init{List<String> metaType=list("LOTOS","OperationCall");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "operationName", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "arguments", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=lotos_value {setProperty(ret, "arguments", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_integerval returns[Object ret2] @init{List<String> metaType=list("LOTOS","IntegerVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_booleanval returns[Object ret2] @init{List<String> metaType=list("LOTOS","BooleanVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_castval_LOTOS_CastVal_opOf[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","CastVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "toType", temp);}){_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"value" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_operatorcall_LOTOS_OperatorCall_opPlus_opEq_opGe_opGt_opLe_opLt_opNe_opAnd_opOr[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("LOTOS","OperatorCall");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  {
setProperty(ret,"operatorName" , opName);
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

lotos_variabledeclaration returns[Object ret2] @init{List<String> metaType=list("LOTOS","VariableDeclaration");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_variabledeclarations returns[Object ret2] @init{List<String> metaType=list("LOTOS","VariableDeclarations");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=lotos_variabledeclaration {setProperty(ret, "declarations", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=lotos_variabledeclaration {setProperty(ret, "declarations", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "type", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_type returns[Object ret2]
  :
  (ret=lotos_librarylist
  | ret=lotos_typedefinition)
  {
ret2=ret;
 }
  ;


lotos_librarylist returns[Object ret2] @init{List<String> metaType=list("LOTOS","LibraryList");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'library'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}'endlib'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_typedefinition returns[Object ret2] @init{List<String> metaType=list("LOTOS","TypeDefinition");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'type'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}'is'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "types", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "types", temp);})* ){_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}'sorts'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "sorts", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "sorts", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}'opns'{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_operations {setProperty(ret, "operations", temp);} ( temp=lotos_operations {setProperty(ret, "operations", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();}'eqns'{_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_equations {setProperty(ret, "equations", temp);} ( temp=lotos_equations {setProperty(ret, "equations", temp);})* )? {_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();}'endtype'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_operations returns[Object ret2] @init{List<String> metaType=list("LOTOS","Operations");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=lotos_operationdeclaration {setProperty(ret, "declarations", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=lotos_operationdeclaration {setProperty(ret, "declarations", temp);})* ){_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "parameterTypes", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "parameterTypes", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RARROW {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "returnType", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_operationdeclaration returns[Object ret2] @init{List<String> metaType=list("LOTOS","OperationDeclaration");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_equations returns[Object ret2] @init{List<String> metaType=list("LOTOS","Equations");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'forall'{_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_variabledeclarations {setProperty(ret, "declarations", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=lotos_variabledeclarations {setProperty(ret, "declarations", temp);})* ){_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_ofsort {setProperty(ret, "ofSorts", temp);} ( temp=lotos_ofsort {setProperty(ret, "ofSorts", temp);})* )? {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_ofsort returns[Object ret2] @init{List<String> metaType=list("LOTOS","OfSort");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'ofsort'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=lotos_equation {setProperty(ret, "equations", temp);} ( temp=lotos_equation {setProperty(ret, "equations", temp);})* )? {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_equation returns[Object ret2]
  :
  (ret=lotos_simpleequation
  | ret=lotos_guardedequation)
  {
ret2=ret;
 }
  ;


lotos_simpleequation returns[Object ret2] @init{List<String> metaType=list("LOTOS","SimpleEquation");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "left", temp);}){_afterSeqEl();}{_beforeSeqEl();} EQ {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_value {setProperty(ret, "right", temp);}){_afterSeqEl();}{_beforeSeqEl();} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

lotos_guardedequation returns[Object ret2] @init{List<String> metaType=list("LOTOS","GuardedEquation");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=lotos_guardexpression {setProperty(ret, "guard", temp);}){_afterSeqEl();}{_beforeSeqEl();} IMPLIES {_afterSeqEl();}{_beforeSeqEl();}( temp=lotos_simpleequation {setProperty(ret, "equation", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('(*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*)')))
  ;


LSQUARERSQUARE
  :
  '[]'
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


COLONCOLON
  :
  '::'
  ;


PIPE3
  :
  '|||'
  ;


PIPELSQUARE
  :
  '|['
  ;


RSQUAREPIPE
  :
  ']|'
  ;


COLONEQ
  :
  ':='
  ;


IMPLIES
  :
  '=>'
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

INT
	:	(DIGIT)+

	;

	FLOAT	:	DIGIT+ '.' DIGIT*	;

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

	