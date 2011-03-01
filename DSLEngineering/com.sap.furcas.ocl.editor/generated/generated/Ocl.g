grammar Ocl;
options {superClass=ObservableInjectingParser;backtrack = true;}

@lexer::header {
package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
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
     * Removing starting/ending delimiters.
     * @deprecated
     */
    public String unescapeString(String s, int delimLength) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
        }
        return s;
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
package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.runtime.parser.impl.SemanticDisambRuleData;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
   private static final String syntaxUUID = "_jXPggENuEeCVWekCgdT-_A";
   public String getSyntaxUUID() {
        return syntaxUUID;
   }
    public String unescapeString(String s) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       int delimLength = 1; // for delimLength > 0, the following code needs to change
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
        }
        return s;
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
  | 'if' {ret = "if";}
  | 'endif' {ret = "endif";}
  | 'then' {ret = "then";}
  | 'forAll' {ret = "forAll";}
  | 'self' {ret = "self";}
  | 'else' {ret = "else";}
  | 'Sequence' {ret = "Sequence";}
  | 'collect' {ret = "collect";}
  | 'Set' {ret = "Set";}
  | 'select' {ret = "select";}
  | 'Collection' {ret = "Collection";}
  | 'in' {ret = "in";}
  | 'Bag' {ret = "Bag";}
  | 'iterate' {ret = "iterate";}
  | 'OrderedSet' {ret = "OrderedSet";}
  | 'let' {ret = "let";})
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


qualifiedNameSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=QNAME {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


annotationSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=MULTI_LINE_COMMENT {ret = unescapeString( ast.getText());
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


longSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=INT {ret = Integer.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


integerAsString returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=INT {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


floatAsString returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FLOAT {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


booleanSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=BOOL {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


booleanValueSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=BOOL {ret = Boolean.valueOf( ast.getText());
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


realSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FLOAT {ret = Double.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


doubleSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FLOAT {ret = Double.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


ocl_ecore_oclexpression returns[Object ret2]
  :
  (ret=ocl_ecore_literalexp
  | ret=ocl_ecore_ifexp
  | ret=ocl_ecore_letexp
  | ret=ocl_ecore_variableexp)
  {
ret2=ret;
 }
  ;


main returns[Object ret2]
  :
  ((ret=ocl_expressions_oclexpression) EOF) 
  {
ret2=ret;
}
  ;


primary_ocl_expressions_oclexpression returns[Object ret2]
  :
  (ret=ocl_ecore_oclexpression
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=ocl_expressions_oclexpression{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


oclexpressions_priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;}
  :
   ( ( ret=primary_ocl_expressions_oclexpression((DOT((identifier ~LPAREN)|(identifier LPAREN)))=>({_enterOpSeq(".", 2, false);}{_beforeSeqEl();}DOT {opName = ".";}{_afterSeqEl();}((identifier ~LPAREN)=>(ret=ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[opName, ret, firstToken])
| (identifier LPAREN)=>(ret=ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[opName, ret, firstToken])){_exitOpSeq();})
| (ARROW)=>({_enterOpSeq("->", 2, false);}{_beforeSeqEl();}ARROW {opName = "->";}{_afterSeqEl();}((ret=ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[opName, ret, firstToken])){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

oclexpressions_priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1); Object semRef=null;}
  :
   ( ( ret=oclexpressions_priority_0((EQUALS)=>({_enterOpSeq("=", 2, false);}{_beforeSeqEl();}EQUALS {opName = "=";}{_afterSeqEl();}((ret=ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[opName, ret, firstToken])){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

ocl_expressions_oclexpression returns[Object ret2]
  :
  ret=oclexpressions_priority_1
  {
ret2=ret;
 }
  ;


ocl_ecore_literalexp returns[Object ret2]
  :
  (ret=ocl_ecore_primitiveliteralexp
  | ret=ocl_ecore_enumliteralexp
  | ret=ocl_ecore_collectionliteralexp)
  {
ret2=ret;
 }
  ;


ocl_ecore_primitiveliteralexp returns[Object ret2]
  :
  (ret=ocl_ecore_numericliteralexp
  | ret=ocl_ecore_stringliteralexp
  | ret=ocl_ecore_booleanliteralexp)
  {
ret2=ret;
 }
  ;


ocl_ecore_numericliteralexp returns[Object ret2]
  :
  (ret=ocl_ecore_integerliteralexp
  | ret=ocl_ecore_realliteralexp)
  {
ret2=ret;
 }
  ;


ocl_ecore_integerliteralexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","IntegerLiteralExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.19/@templateSequence/@elements.0");}( temp=integerSymbol {setProperty(ret, "integerSymbol", temp);
setParent(temp,ret,"integerSymbol");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.19/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EIntegerObject' endif)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_stringliteralexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","StringLiteralExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.0");} APOSTROPHE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "stringSymbol", temp);
setParent(temp,ret,"stringSymbol");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.2");} APOSTROPHE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.20/@templateSequence/@elements.3");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EString' endif)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_realliteralexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","RealLiteralExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.21/@templateSequence/@elements.0");}( temp=realSymbol {setProperty(ret, "realSymbol", temp);
setParent(temp,ret,"realSymbol");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.21/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EDoubleObject' endif)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_booleanliteralexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","BooleanLiteralExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.22/@templateSequence/@elements.0");}( temp=booleanValueSymbol {setProperty(ret, "booleanSymbol", temp);
setParent(temp,ret,"booleanSymbol");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.22/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c| if c.ePackage->isEmpty() then false else c.ePackage.name='ecore' and c.name='EBooleanObject' endif)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_enumliteralexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","EnumLiteralExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.0");}( temp=qualifiedNameSymbol {setOclRef(ret, "eType", null, temp, "ecore::EEnum.allInstances() ->select(name = ?)");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.1");} DCOLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.23/@templateSequence/@elements.2");}( temp=identifier {setOclRef(ret, "referredEnumLiteral", null, temp, "self.eType.oclAsType(ecore::EEnum).eLiterals->select(literal = ?)");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_expressions_collectionliteralpart returns[Object ret2]
  :
  (ret=ocl_expressions_collectionitem
  | (ocl_expressions_oclexpression COMMA)=>(ret=ocl_expressions_collectionrange))
  {
ret2=ret;
 }
  ;


ocl_ecore_collectionliteralexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","CollectionLiteralExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"collectionliteral"}) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.0");}'Sequence'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.1");}( temp=ecore_eclassifier_sequence {setProperty(ret, "eType", temp);
setParent(temp,ret,"eType");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.0/@elements.2");}{_enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.SEQUENCE);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.0");}'Set'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.1");}( temp=ecore_eclassifier_set {setProperty(ret, "eType", temp);
setParent(temp,ret,"eType");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.1/@elements.2");}{_enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.SET);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.0");}'Collection'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.1");}( temp=ecore_eclassifier_collection {setProperty(ret, "eType", temp);
setParent(temp,ret,"eType");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.2/@elements.2");}{_enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.COLLECTION);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(3);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.0");}'Bag'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.1");}( temp=ecore_eclassifier_bag {setProperty(ret, "eType", temp);
setParent(temp,ret,"eType");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.3/@elements.2");}{_enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.BAG);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(4);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.0");}'OrderedSet'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.1");}( temp=ecore_eclassifier_orderedset {setProperty(ret, "eType", temp);
setParent(temp,ret,"eType");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.0/@sequences.4/@elements.2");}{_enterInjectorAction();setProperty(ret, "kind", org.eclipse.ocl.expressions.CollectionKind.ORDERED_SET);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.1");} LCURL {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.2");}( temp=ocl_expressions_collectionliteralpart {setProperty(ret, "part", temp);
setParent(temp,ret,"part");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");} COMMA {_afterSeqEl();}){_exitSepSeq();} temp=ocl_expressions_collectionliteralpart {setProperty(ret, "part", temp);
setParent(temp,ret,"part");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.3");} RCURL {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.25/@templateSequence/@elements.4");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.eType.name.substring(1, -4+self.eType.name.size()).concat('{...}')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ecore_eclassifier_sequence returns[Object ret2]
  :
  (ret=ecore_edatatype_sequence)
  {
ret2=ret;
 }
  ;


ecore_edatatype_sequence returns[Object ret2]
  :
  (ret=ocl_ecore_collectiontype_sequence)
  {
ret2=ret;
 }
  ;


ocl_ecore_collectiontype_sequence returns[Object ret2]
  :
  (ret=ocl_ecore_sequencetype_sequence)
  {
ret2=ret;
 }
  ;


ocl_ecore_sequencetype_sequence returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","SequenceType");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"sequence");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.29/@templateSequence/@elements.0");}collectiontypeelementtype[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.29/@templateSequence/@elements.1");}{_enterInjectorAction();setProperty(ret, "name", "SequenceType");_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ecore_eclassifier_set returns[Object ret2]
  :
  (ret=ecore_edatatype_set)
  {
ret2=ret;
 }
  ;


ecore_edatatype_set returns[Object ret2]
  :
  (ret=ocl_ecore_collectiontype_set)
  {
ret2=ret;
 }
  ;


ocl_ecore_collectiontype_set returns[Object ret2]
  :
  (ret=ocl_ecore_settype_set)
  {
ret2=ret;
 }
  ;


ocl_ecore_settype_set returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","SetType");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"set");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.33/@templateSequence/@elements.0");}collectiontypeelementtype[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.33/@templateSequence/@elements.1");}{_enterInjectorAction();setProperty(ret, "name", "SetType");_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ecore_eclassifier_collection returns[Object ret2]
  :
  (ret=ecore_edatatype_collection)
  {
ret2=ret;
 }
  ;


ecore_edatatype_collection returns[Object ret2]
  :
  (ret=ocl_ecore_collectiontype_collection)
  {
ret2=ret;
 }
  ;


ocl_ecore_collectiontype_collection returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","CollectionType");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"collection");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.36/@templateSequence/@elements.0");}collectiontypeelementtype[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.36/@templateSequence/@elements.1");}{_enterInjectorAction();setProperty(ret, "name", "CollectionType");_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ecore_eclassifier_bag returns[Object ret2]
  :
  (ret=ecore_edatatype_bag)
  {
ret2=ret;
 }
  ;


ecore_edatatype_bag returns[Object ret2]
  :
  (ret=ocl_ecore_collectiontype_bag)
  {
ret2=ret;
 }
  ;


ocl_ecore_collectiontype_bag returns[Object ret2]
  :
  (ret=ocl_ecore_bagtype_bag)
  {
ret2=ret;
 }
  ;


ocl_ecore_bagtype_bag returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","BagType");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"bag");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.40/@templateSequence/@elements.0");}collectiontypeelementtype[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.40/@templateSequence/@elements.1");}{_enterInjectorAction();setProperty(ret, "name", "BagType");_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ecore_eclassifier_orderedset returns[Object ret2]
  :
  (ret=ecore_edatatype_orderedset)
  {
ret2=ret;
 }
  ;


ecore_edatatype_orderedset returns[Object ret2]
  :
  (ret=ocl_ecore_collectiontype_orderedset)
  {
ret2=ret;
 }
  ;


ocl_ecore_collectiontype_orderedset returns[Object ret2]
  :
  (ret=ocl_ecore_orderedsettype_orderedset)
  {
ret2=ret;
 }
  ;


ocl_ecore_orderedsettype_orderedset returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","OrderedSetType");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"orderedset");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.44/@templateSequence/@elements.0");}collectiontypeelementtype[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.44/@templateSequence/@elements.1");}{_enterInjectorAction();setProperty(ret, "name", "OrderedSetType");_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

collectiontypeelementtype[Object ret]
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.45/@functionSequence/@elements.0");}{_enterInjectorAction();setOclRef(ret, "elementType", null, null, "OCL:#context(collectionliteral).oclAsType(ocl::ecore::CollectionLiteralExp).part.oclAsType(ocl::ecore::CollectionLiteralPart).eType.oclAsType(ecore::EClass)->iterate("+
"                                                                t; acc:ecore::EClass=null |"+
"                                                                        if acc->isEmpty() or acc=t then"+
"                                                                                t "+
"                                                                        else "+
"                                                                                if t.eAllSuperTypes->includes(acc) then"+
"                                                                                        acc "+
"                                                                                else "+
"                                                                                        if acc.eAllSuperTypes->includes(t) then"+
"                                                                                                t "+
"                                                                                        else "+
"                                                                                                null "+
"                                                                                        endif"+
"                                                                                endif"+
"                                                                        endif)", true);_exitInjectorAction();}{_afterSeqEl();})
{
  }

  ;


ocl_expressions_collectionitem returns[Object ret2]
  :
  ((ocl_expressions_collectionitem)=>(ret=ocl_ecore_collectionitem))
  {
ret2=ret;
 }
  ;


ocl_ecore_collectionitem returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","CollectionItem");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.47/@templateSequence/@elements.0");}( temp=ocl_expressions_oclexpression {setProperty(ret, "item", temp);
setParent(temp,ret,"item");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.47/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.item.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_expressions_collectionrange returns[Object ret2]
  :
  ((ocl_expressions_oclexpression COMMA)=>(ret=ocl_ecore_collectionrange))
  {
ret2=ret;
 }
  ;


ocl_ecore_collectionrange returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","CollectionRange");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.0");}( temp=ocl_expressions_oclexpression {setProperty(ret, "first", temp);
setParent(temp,ret,"first");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.1");} DDOT {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.2");}( temp=ocl_expressions_oclexpression {setProperty(ret, "last", temp);
setParent(temp,ret,"last");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.49/@templateSequence/@elements.3");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:"+
"                                let f : ocl::ecore::OCLExpression = self.first.oclAsType(ocl::ecore::OCLExpression) in"+
"                                let l : ocl::ecore::OCLExpression = self.last.oclAsType(ocl::ecore::OCLExpression) in"+
"                                if f.eType = l.eType then"+
"                                                        f.eType "+
"                                                  else "+
"                                                        if f.eType.oclAsType(ecore::EClass).eAllSuperTypes->includes(l.eType.oclAsType(ecore::EClass)) then"+
"                                                                l.eType "+
"                                                        else "+
"                                                                if l.eType.oclAsType(ecore::EClass).eAllSuperTypes->includes(f.eType.oclAsType(ecore::EClass)) then "+
"                                                                        f.eType "+
"                                                                else "+
"                                                                        null "+
"                                                                endif "+
"                                                        endif "+
"                                                  endif", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_ifexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","IfExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.0");}'if'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.1");}( temp=ocl_expressions_oclexpression {setProperty(ret, "condition", temp);
setParent(temp,ret,"condition");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.2");}'then'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.3");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.3/@blockSequence/@elements.0");}( temp=ocl_expressions_oclexpression {setProperty(ret, "thenExpression", temp);
setParent(temp,ret,"thenExpression");})? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.4");}'else'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.5");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.5/@blockSequence/@elements.0");}( temp=ocl_expressions_oclexpression {setProperty(ret, "elseExpression", temp);
setParent(temp,ret,"elseExpression");})? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.6");}'endif'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.50/@templateSequence/@elements.7");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:"+
"                              let te : ocl::ecore::OCLExpression = self.thenExpression.oclAsType(ocl::ecore::OCLExpression) in"+
"                              let ee : ocl::ecore::OCLExpression = self.elseExpression.oclAsType(ocl::ecore::OCLExpression) in"+
"                              if te.eType = ee.eType then"+
"                                  te.eType"+
"                              else"+
"                                  if te.oclAsType(ecore::EClass).eAllSuperTypes->includes(ee.eType.oclAsType(ecore::EClass)) then"+
"                                      ee.eType"+
"                                  else"+
"                                      if ee.eType.oclAsType(ecore::EClass).eAllSuperTypes->includes(te.eType.oclAsType(ecore::EClass)) then"+
"                                          te.eType"+
"                                      else"+
"                                          null"+
"                                      endif"+
"                                  endif"+
"                              endif", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_letexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","LetExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.0");}'let'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.1");}( temp=ocl_expressions_variable_let {setProperty(ret, "variable", temp);
setParent(temp,ret,"variable");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.2");}'in'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.3");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.3/@blockSequence/@elements.0");}( temp=ocl_expressions_oclexpression {setProperty(ret, "in", temp);
setParent(temp,ret,"in");}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.51/@templateSequence/@elements.4");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.\\\"in\\\".oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'let '.concat(self.variable.oclAsType(ocl::ecore::Variable).name)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_expressions_variable_let returns[Object ret2]
  :
  (ret=ocl_ecore_variable_let)
  {
ret2=ret;
 }
  ;


ocl_ecore_variable_let returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","Variable");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"let");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.0/@elements.0");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.initExpression.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.1/@sequences.1/@elements.1");}( temp=identifier {setOclRef(ret, "eType", null, temp, "ecore::EClassifier.allInstances()->select(name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.2");} EQUALS {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.53/@templateSequence/@elements.3");}( temp=ocl_expressions_oclexpression {setProperty(ret, "initExpression", temp);
setParent(temp,ret,"initExpression");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_expressions_variable returns[Object ret2]
  :
  (ret=ocl_ecore_variable)
  {
ret2=ret;
 }
  ;


ocl_ecore_variable returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","Variable");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.0/@elements.0");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(ocl::ecore::CallExp).source.oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.1/@sequences.1/@elements.1");}( temp=identifier {setOclRef(ret, "eType", null, temp, "ecore::EClassifier.allInstances()->select(name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.0");} EQUALS {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.55/@templateSequence/@elements.2/@thenSequence/@elements.1");}( temp=ocl_expressions_oclexpression {setProperty(ret, "initExpression", temp);
setParent(temp,ret,"initExpression");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_variableexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","VariableExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0/@sequences.0/@elements.0");}( temp=ocl_expressions_variable_self {setProperty(ret, "referredVariable", temp);
setParent(temp,ret,"referredVariable");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.0/@sequences.1/@elements.0");}( temp=identifier {setOclRef(ret, "referredVariable", null, temp, "ocl::ecore::Variable.allInstances()->select(getName() = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.56/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.referredVariable.oclAsType(ocl::ecore::Variable).eType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredVariable.oclAsType(ocl::ecore::Variable).name", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_expressions_variable_self returns[Object ret2]
  :
  (ret=ocl_ecore_variable_self)
  {
ret2=ret;
 }
  ;


ocl_ecore_variable_self returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","Variable");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"self");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.58/@templateSequence/@elements.0");}'self'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.58/@templateSequence/@elements.1");}{_enterInjectorAction();setProperty(ret, "name", "self");_exitInjectorAction();_enterInjectorAction();setRef(ret, "eType", list("ecore","EClassifier"), null, null, "#context(class)", null, null, false, null, true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_iterateexp_ocl_ecore_IterateExp_arrowOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("ocl","ecore","IterateExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;

}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.0");}'iterate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.2");}( temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");} ( temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.0");} SEMI {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.0/@elements.1");}( temp=ocl_expressions_variable {setProperty(ret, "result", temp);
setParent(temp,ret,"result");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.0/@elements.3/@sequences.1/@elements.0");}( temp=ocl_expressions_variable_implicitAccumulator {setProperty(ret, "result", temp);
setParent(temp,ret,"result");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.0");}'forAll'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.2");}( temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.1/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");} COMMA {_afterSeqEl();}){_exitSepSeq();} temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");})* )? {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.0");}'collect'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.2");}( temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.2/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");} COMMA {_afterSeqEl();}){_exitSepSeq();} temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");})* )? {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(3);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.0");}'select'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.2");}( temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.0/@sequences.3/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");} COMMA {_afterSeqEl();}){_exitSepSeq();} temp=ocl_expressions_variable {setProperty(ret, "iterator", temp);
setParent(temp,ret,"iterator");})* )? {_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.1");} BAR {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.2");}( temp=ocl_expressions_oclexpression {setProperty(ret, "body", temp);
setParent(temp,ret,"body");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.59/@templateSequence/@elements.3");} RPAREN {_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"source" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);
leaveContext();

}
  ;
 finally {onExitTemplateRule(metaType);}

ocl_expressions_variable_implicitAccumulator returns[Object ret2]
  :
  (ret=ocl_ecore_variable_implicitAccumulator)
  {
ret2=ret;
 }
  ;


ocl_ecore_variable_implicitAccumulator returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ocl","ecore","Variable");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType,"implicitAccumulator");
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.61/@templateSequence/@elements.0");}{_enterInjectorAction();setProperty(ret, "name", "acc");_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:#context(propertyCallExp).oclAsType(ocl::ecore::IterateExp).\\\"body\\\".oclAsType(ocl::ecore::OCLExpression).eType", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ocl_ecore_propertycallexp_ocl_ecore_PropertyCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("ocl","ecore","PropertyCallExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;

}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.62/@templateSequence/@elements.0");}( temp=identifierOrKeyword {setOclRef(ret, "referredProperty", null, temp, "self.source.oclAsType(ocl::ecore::OCLExpression).eType.oclAsType(ecore::EClass).eAllStructuralFeatures->select(name = ?)");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.62/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredProperty.oclAsType(ecore::EStructuralFeature).name", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:self.referredProperty.oclAsType(ecore::EStructuralFeature).eType", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"source" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);
leaveContext();

}
  ;
 finally {onExitTemplateRule(metaType);}

ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_dotOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("ocl","ecore","OperationCallExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;

}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.0");}( temp=identifierOrKeyword {setOclRef(ret, "referredOperation", null, temp, "OCL:self.source.oclAsType(ocl::ecore::OCLExpression).eType.oclAsType(ecore::EClass).eAllOperations->select(name = ?)");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.2");}( temp=ocl_expressions_oclexpression {setProperty(ret, "argument", temp);
setParent(temp,ret,"argument");} ( temp=ocl_expressions_oclexpression {setProperty(ret, "argument", temp);
setParent(temp,ret,"argument");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.63/@templateSequence/@elements.4");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.referredOperation.oclAsType(ecore::EOperation).name.concat('(...)')", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:let params : OrderedSet(ecore::EParameter) = self.referredOperation.oclAsType(ecore::EOperation).eParameters in"+
"             				if params->isEmpty() then"+
"             					null --todo: use OclVoid from StdLib"+
"             				else"+
"             					params->at(1).eType"+
"             				endif ", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"source" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);
leaveContext();

}
  ;
 finally {onExitTemplateRule(metaType);}

ocl_ecore_operationcallexp_ocl_ecore_OperationCallExp_equalsOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("ocl","ecore","OperationCallExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"propertyCallExp"}) : null;

}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.64/@templateSequence/@elements.0");}( temp=identifierOrKeyword {setOclRef(ret, "referredOperation", null, temp, "OCL:ecore::EClass.allInstances()->select(c | c.ePackage.name = 'oclstdlib' and "+
"          				let type : ecore::EClassifier = source.oclAsType(ocl::ecore::OCLExpression).eType in"+
"          				if type.name = 'EBoolean' then"+
"          					c.name = 'Boolean_Class'"+
"          				else"+
"          					c.name = 'OclVoid_Class'"+
"          				endif"+
"          			).eOperations->select(op | op.oclAsType(ecore::EOperation).name = '=')->select(name = ?)");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.64/@templateSequence/@elements.1");}( temp=ocl_expressions_oclexpression {setProperty(ret, "argument", temp);
setParent(temp,ret,"argument");} ( temp=ocl_expressions_oclexpression {setProperty(ret, "argument", temp);
setParent(temp,ret,"argument");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.ocl.editor/mappings/Ocl.tcs#//@templates.64/@templateSequence/@elements.2");}{_enterInjectorAction();setRef(ret, "name", list("ecore","EString"), null, null, "equals", null, null, false, null, true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "eType", null, null, "OCL:ecore::EClassifier.allInstances()->select(c | c.ePackage.name ='ecore' and c.name = 'EBoolean')", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"source" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);
leaveContext();

}
  ;
 finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('//' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


MULTI_LINE_COMMENT
  :
     ((('/**' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


DDOT
  :
  '..'
  ;


LBRACKET
  :
  '['
  ;


RBRACKET
  :
  ']'
  ;


LCURL
  :
  '{'
  ;


RCURL
  :
  '}'
  ;


STAR
  :
  '*'
  ;


LPAREN
  :
  '('
  ;


RPAREN
  :
  ')'
  ;


COLON
  :
  ':'
  ;


DCOLON
  :
  '::'
  ;


COMMA
  :
  ','
  ;


SEMI
  :
  ';'
  ;


DOT
  :
  '.'
  ;


EQUALS
  :
  '='
  ;


GT
  :
  '>'
  ;


GTRQULAS
  :
  '>='
  ;


LT
  :
  '<'
  ;


LTEQUALS
  :
  '<='
  ;


ARROW
  :
  '->'
  ;


BAR
  :
  '|'
  ;


APOSTROPHE
  :
  '\''
  ;



// testLiterals = false;


NL
        :       (       '\r' '\n'
                |       '\n' '\r'     //Improbable
                |       '\r'
                |       '\n'
                )
        {newline();$channel=HIDDEN;}
        ;

WS
        :       (       ' '
                |       '\t'
                ){$channel=HIDDEN;}
        ;

fragment
DIGIT
        :       '0'..'9'
        ;

fragment
ALPHA
        :       'a'..'z'
        |       'A'..'Z'
        |       '_'
        //For Unicode compatibility (from 0000 to 00ff)
        |       '\u00C0' .. '\u00D6'
        |       '\u00D8' .. '\u00F6'
        |       '\u00F8' .. '\u00FF'
        ;

fragment
SNAME
        :       (ALPHA) (ALPHA | DIGIT)*
;

BOOL    :       'true' | 'false'        ;

NAME
        :       (
                        (SNAME (~DCOLON|EOF))=>SNAME
                |       '\''!
                        (       
                        '\n' {newline();}
                        |       ~('\\'|'\''|'\n')
                        )*
                        '\''!
                )
        ;

QNAME
        : SNAME DCOLON SNAME (DCOLON SNAME )*
        ;

protected
INT
 : (DIGIT)+
 ;

fragment
FLOAT
        :       DIGIT+ '.' DIGIT*
        ;
  
RANGE_OR_INT
    :   ( INT '..' ) => INT  { _type = INT; }
    |   ( INT '.' NAME ) => INT { _type = INT; }
    |   ( INT '.' ~('.' |       'a'..'z'
                                                |       'A'..'Z'
                                                |       '_'
                                                //For Unicode compatibility (from 0000 to 00ff)
                                                |       '\u00C0' .. '\u00D6'
                                                |       '\u00D8' .. '\u00F6'
                                                |       '\u00F8' .. '\u00FF') )  => FLOAT { _type = FLOAT; }
    |   INT                  { _type = INT; }
    ;


STRING
        :       '"'!
                (       
                //ESC   |               
                        '\n' {newline();}
                |       ~('\\'|'"'|'\n')
                )*
                '"'!
        ;

        