grammar TCS;
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
       } else if (s.length() >= 4 && s.charAt(0) == '\\' && s.charAt(s.length()-delimLength) == '\"' && s.charAt(1) == '\"' && s.charAt(s.length()-delimLength-1) == '\\') {
             //also handle strings that are surrounded with an escaped string symbol \"value\"
             delimLength += 1;
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
   private static final String syntaxUUID = "__vpmUEV4EeCySMKQLNKlTA";
   public String getSyntaxUUID() {
        return syntaxUUID;
   }
    public String unescapeString(String s) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       int delimLength = 1; // for delimLength > 0, the following code needs to change
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
       }
       if(s.contains("\\\"")) {
                s = s.replaceAll("\\\\\"", "\"");
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
  | 'default' {ret = "default";}
  | 'source' {ret = "source";}
  | 'lookupScope' {ret = "lookupScope";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'always' {ret = "always";}
  | 'symbols' {ret = "symbols";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'abstract' {ret = "abstract";}
  | 'all' {ret = "all";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'right' {ret = "right";}
  | 'function' {ret = "function";}
  | 'value' {ret = "value";}
  | 'octal' {ret = "octal";}
  | 'using' {ret = "using";}
  | 'operatored' {ret = "operatored";}
  | 'endNL' {ret = "endNL";}
  | 'referenceBy' {ret = "referenceBy";}
  | 'never' {ret = "never";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'auto' {ret = "auto";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'lookIn' {ret = "lookIn";}
  | 'prefix' {ret = "prefix";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'drop' {ret = "drop";}
  | 'postfix' {ret = "postfix";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'rightNone' {ret = "rightNone";}
  | 'template' {ret = "template";}
  | 'end' {ret = "end";}
  | 'separator' {ret = "separator";}
  | 'deep' {ret = "deep";}
  | 'partial' {ret = "partial";}
  | 'part' {ret = "part";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'as' {ret = "as";}
  | 'hex' {ret = "hex";}
  | 'omitted' {ret = "omitted";}
  | 'esc' {ret = "esc";}
  | 'createAs' {ret = "createAs";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'startNL' {ret = "startNL";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'main' {ret = "main";}
  | 'and' {ret = "and";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'nbNL' {ret = "nbNL";}
  | 'serializer' {ret = "serializer";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'priority' {ret = "priority";}
  | 'token' {ret = "token";}
  | 'refersTo' {ret = "refersTo";}
  | 'leftNone' {ret = "leftNone";}
  | 'keywords' {ret = "keywords";}
  | 'lexer' {ret = "lexer";}
  | 'word' {ret = "word";}
  | 'left' {ret = "left";}
  | 'true' {ret = "true";}
  | 'false' {ret = "false";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'foreach' {ret = "foreach";}
  | 'importContext' {ret = "importContext";}
  | 'mode' {ret = "mode";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'one' {ret = "one";}
  | 'context' {ret = "context";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'multi' {ret = "multi";}
  | 'operators' {ret = "operators";}
  | 'addToContext' {ret = "addToContext";}
  | 'createIn' {ret = "createIn";}
  | 'k' {ret = "k";}
  | 'when' {ret = "when";}
  | 'isDefined' {ret = "isDefined";}
  | 'start' {ret = "start";}
  | 'for' {ret = "for";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'syntax' {ret = "syntax";}
  | 'semDisambiguate' {ret = "semDisambiguate";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'multiLine' {ret = "multiLine";})
{
ret2=ret;
}
  ;


escapedIdentifierOrKeyword returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=NAME {ret = unescapeString( ast.getText());
}
  | 'default' {ret = "default";}
  | 'source' {ret = "source";}
  | 'lookupScope' {ret = "lookupScope";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'always' {ret = "always";}
  | 'symbols' {ret = "symbols";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'abstract' {ret = "abstract";}
  | 'all' {ret = "all";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'right' {ret = "right";}
  | 'function' {ret = "function";}
  | 'value' {ret = "value";}
  | 'octal' {ret = "octal";}
  | 'using' {ret = "using";}
  | 'operatored' {ret = "operatored";}
  | 'endNL' {ret = "endNL";}
  | 'referenceBy' {ret = "referenceBy";}
  | 'never' {ret = "never";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'auto' {ret = "auto";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'lookIn' {ret = "lookIn";}
  | 'prefix' {ret = "prefix";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'drop' {ret = "drop";}
  | 'postfix' {ret = "postfix";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'rightNone' {ret = "rightNone";}
  | 'template' {ret = "template";}
  | 'end' {ret = "end";}
  | 'separator' {ret = "separator";}
  | 'deep' {ret = "deep";}
  | 'partial' {ret = "partial";}
  | 'part' {ret = "part";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'as' {ret = "as";}
  | 'hex' {ret = "hex";}
  | 'omitted' {ret = "omitted";}
  | 'esc' {ret = "esc";}
  | 'createAs' {ret = "createAs";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'startNL' {ret = "startNL";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'main' {ret = "main";}
  | 'and' {ret = "and";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'nbNL' {ret = "nbNL";}
  | 'serializer' {ret = "serializer";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'priority' {ret = "priority";}
  | 'token' {ret = "token";}
  | 'refersTo' {ret = "refersTo";}
  | 'leftNone' {ret = "leftNone";}
  | 'keywords' {ret = "keywords";}
  | 'lexer' {ret = "lexer";}
  | 'word' {ret = "word";}
  | 'left' {ret = "left";}
  | 'true' {ret = "true";}
  | 'false' {ret = "false";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'foreach' {ret = "foreach";}
  | 'importContext' {ret = "importContext";}
  | 'mode' {ret = "mode";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'one' {ret = "one";}
  | 'context' {ret = "context";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'multi' {ret = "multi";}
  | 'operators' {ret = "operators";}
  | 'addToContext' {ret = "addToContext";}
  | 'createIn' {ret = "createIn";}
  | 'k' {ret = "k";}
  | 'when' {ret = "when";}
  | 'isDefined' {ret = "isDefined";}
  | 'start' {ret = "start";}
  | 'for' {ret = "for";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'syntax' {ret = "syntax";}
  | 'semDisambiguate' {ret = "semDisambiguate";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'multiLine' {ret = "multiLine";})
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


plainStringSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
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


ecore_eclassifier returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ecore","EClassifier");
ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.7/@templateSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.7/@templateSequence/@elements.0/@thenSequence/@elements.0");}( temp=ecore_epackage {setProperty(ret, "ePackage", temp);
setParent(temp,ret,"ePackage");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.7/@templateSequence/@elements.0/@thenSequence/@elements.1");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.7/@templateSequence/@elements.0/@thenSequence/@elements.2");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");})? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.7/@templateSequence/@elements.0/@elseSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");})? {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

ecore_epackage returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("ecore","EPackage");
ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.8/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_textblockdefinition_textblockdefinition returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","textblockdefinition","TextBlockDefinition");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ()
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

main returns[Object ret2]
  :
  ((ret=furcas_tcs_concretesyntax) EOF) 
  {
ret2=ret;
}
  ;


furcas_tcs_concretesyntax returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ConcreteSyntax");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.0");}'syntax'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.2/@thenSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.2/@thenSequence/@elements.1");}'k'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.2/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.2/@thenSequence/@elements.3");}( temp=integerSymbol {setProperty(ret, "k", temp);
setParent(temp,ret,"k");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.2/@thenSequence/@elements.4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.0");}( temp=furcas_tcs_template {setProperty(ret, "templates", temp);
setParent(temp,ret,"templates");} ( temp=furcas_tcs_template {setProperty(ret, "templates", temp);
setParent(temp,ret,"templates");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.0");}'keywords'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.2");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.2/@blockSequence/@elements.0");}( temp=furcas_tcs_keyword {setProperty(ret, "keywords", temp);
setParent(temp,ret,"keywords");} ( temp=furcas_tcs_keyword {setProperty(ret, "keywords", temp);
setParent(temp,ret,"keywords");})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.1/@thenSequence/@elements.3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.0");}'symbols'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.2");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.2/@blockSequence/@elements.0");}( temp=furcas_tcs_symbol {setProperty(ret, "symbols", temp);
setParent(temp,ret,"symbols");} ( temp=furcas_tcs_symbol {setProperty(ret, "symbols", temp);
setParent(temp,ret,"symbols");})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.2/@thenSequence/@elements.3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.3");}( temp=furcas_tcs_operatorlist {setProperty(ret, "operatorLists", temp);
setParent(temp,ret,"operatorLists");} ( temp=furcas_tcs_operatorlist {setProperty(ret, "operatorLists", temp);
setParent(temp,ret,"operatorLists");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.4");}( temp=furcas_tcs_token {setProperty(ret, "tokens", temp);
setParent(temp,ret,"tokens");} ( temp=furcas_tcs_token {setProperty(ret, "tokens", temp);
setParent(temp,ret,"tokens");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.5");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.0");}'lexer'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "lexer", temp);
setParent(temp,ret,"lexer");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.4/@blockSequence/@elements.5/@thenSequence/@elements.3");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.5");} RCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.10/@templateSequence/@elements.6");}{_enterInjectorAction();setOclRef(ret, "keywords", null, null, "OCL:LiteralRef.allInstances()->select("+
"                                lr | self.templates->includes(lr.parentTemplate)).referredLiteral->asSet()"+
"                                ->union(self.operatorLists.priorities.operators.literal->asSet())"+
"                                ->select(k | k.oclIsTypeOf(Keyword))", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.11/@functionSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.11/@functionSequence/@elements.0/@thenSequence/@elements.0");}( temp=ecore_eclassifier {setProperty(ret, "metaReference", temp);
setParent(temp,ret,"metaReference");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.11/@functionSequence/@elements.0/@elseSequence/@elements.0");} RARROW {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.11/@functionSequence/@elements.0/@elseSequence/@elements.1");}( temp=identifier {setProperty(ret, "names", temp);
setParent(temp,ret,"names");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.11/@functionSequence/@elements.0/@elseSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);
setParent(temp,ret,"names");})* ){_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


furcas_tcs_template returns[Object ret2]
  :
  (ret=furcas_tcs_contexttemplate
  | ret=furcas_tcs_primitivetemplate
  | ret=furcas_tcs_enumerationtemplate
  | ret=furcas_tcs_functiontemplate)
  {
ret2=ret;
 }
  ;


furcas_tcs_contexttemplate returns[Object ret2]
  :
  (ret=furcas_tcs_classtemplate
  | ret=furcas_tcs_operatortemplate)
  {
ret2=ret;
 }
  ;


furcas_tcs_primitivetemplate returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PrimitiveTemplate");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.0");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "templateName", temp);
setParent(temp,ret,"templateName");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.2");}'for'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.4");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.4/@thenSequence/@elements.0");}'default'{_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "default", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.5");}'using'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.6");}( temp=identifier {setProperty(ret, "tokenName", temp);
setParent(temp,ret,"tokenName");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.7");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.7/@thenSequence/@elements.0");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.8");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.9");}'value'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.10");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.11");}( temp=stringSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.12");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.12/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.12/@thenSequence/@elements.1");}'serializer'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.12/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.12/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "serializer", temp);
setParent(temp,ret,"serializer");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.13");} SEMI {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.14/@templateSequence/@elements.14");}( temp=furcas_textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);
setParent(temp,ret,"textBlockDefinition");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_enumerationtemplate returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","EnumerationTemplate");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.0");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.2/@thenSequence/@elements.0");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@thenSequence/@elements.0");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_enumliteralmapping {setProperty(ret, "mappings", temp);
setParent(temp,ret,"mappings");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_enumliteralmapping {setProperty(ret, "mappings", temp);
setParent(temp,ret,"mappings");})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.3/@elseSequence/@elements.0");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.15/@templateSequence/@elements.4");}( temp=furcas_textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);
setParent(temp,ret,"textBlockDefinition");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_enumliteralmapping returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","EnumLiteralMapping");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.16/@templateSequence/@elements.0");}( temp=furcas_tcs_enumliteralval {setProperty(ret, "literal", temp);
setParent(temp,ret,"literal");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.16/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.16/@templateSequence/@elements.2");}( temp=furcas_tcs_sequenceelement {setProperty(ret, "element", temp);
setParent(temp,ret,"element");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_classtemplate returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ClassTemplate");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.0");}'template'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@thenSequence/@elements.0");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.0/@thenSequence/@elements.0");} SHARP {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.0/@thenSequence/@elements.1");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);
setParent(temp,ret,"mode");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.1");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);
setParent(temp,ret,"disambiguate");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.1/@thenSequence/@elements.4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.1");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);
setParent(temp,ret,"disambiguateV3");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.2/@thenSequence/@elements.4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.1");}'semDisambiguate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "semDisambiguate", temp);
setParent(temp,ret,"semDisambiguate");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.3/@thenSequence/@elements.4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.4");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.4/@thenSequence/@elements.0");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.5");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.5/@thenSequence/@elements.0");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.6");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.6/@thenSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.6/@thenSequence/@elements.0/@thenSequence/@elements.0");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.6/@thenSequence/@elements.1");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.7");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.0");}'operatored'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1/@thenSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1/@thenSequence/@elements.1");}( temp=identifier {setRef(ret, "operatorList", list("FURCAS","TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.7/@thenSequence/@elements.1/@thenSequence/@elements.2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.8");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.8/@thenSequence/@elements.0");}'context'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.8/@thenSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.8/@thenSequence/@elements.1/@thenSequence/@elements.0");}( temp=furcas_tcs_contexttags {setProperty(ret, "contextTags", temp);
setParent(temp,ret,"contextTags");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.9");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.9/@thenSequence/@elements.0");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.10");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.2/@elseSequence/@elements.10/@thenSequence/@elements.0");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3/@thenSequence/@elements.0");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_sequence {setProperty(ret, "templateSequence", temp);
setParent(temp,ret,"templateSequence");}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3/@thenSequence/@elements.0/@blockSequence/@elements.2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.3/@elseSequence/@elements.0");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.17/@templateSequence/@elements.4");}( temp=furcas_textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);
setParent(temp,ret,"textBlockDefinition");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_operatortemplate returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","OperatorTemplate");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.0");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.3");}'operators'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.4");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.5");}( temp=identifier {setRef(ret, "operators", list("FURCAS","TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("FURCAS","TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.6");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.7");}'source'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.8");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.9");}( temp=furcas_tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);
setParent(temp,ret,"storeLeftSideTo");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.10");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.10/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.10/@thenSequence/@elements.1");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.10/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.10/@thenSequence/@elements.3");}( temp=furcas_tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);
setParent(temp,ret,"storeOperatorTo");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.11");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.11/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.11/@thenSequence/@elements.1");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.11/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.11/@thenSequence/@elements.3");}( temp=furcas_tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);
setParent(temp,ret,"storeRightSideTo");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.12");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.12/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.12/@thenSequence/@elements.1");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.12/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.12/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);
setParent(temp,ret,"disambiguate");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.13");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.13/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.13/@thenSequence/@elements.1");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.13/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.13/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);
setParent(temp,ret,"disambiguateV3");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.14");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.14/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.14/@thenSequence/@elements.1");}'semDisambiguate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.14/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.14/@thenSequence/@elements.3");}( temp=stringSymbol {setProperty(ret, "semDisambiguate", temp);
setParent(temp,ret,"semDisambiguate");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.15");} RPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.16");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.16/@thenSequence/@elements.0");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.16/@elseSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.16/@elseSequence/@elements.0/@thenSequence/@elements.0");}'context'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.16/@elseSequence/@elements.0/@thenSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.16/@elseSequence/@elements.0/@thenSequence/@elements.1/@thenSequence/@elements.0");}( temp=furcas_tcs_contexttags {setProperty(ret, "contextTags", temp);
setParent(temp,ret,"contextTags");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17/@thenSequence/@elements.0");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_sequence {setProperty(ret, "templateSequence", temp);
setParent(temp,ret,"templateSequence");}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17/@thenSequence/@elements.0/@blockSequence/@elements.2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.17/@elseSequence/@elements.0");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.18/@templateSequence/@elements.18");}( temp=furcas_textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);
setParent(temp,ret,"textBlockDefinition");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_functiontemplate returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","FunctionTemplate");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.0");}'function'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "functionName", temp);
setParent(temp,ret,"functionName");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.4");} RPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.5");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.5/@blockSequence/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.5/@blockSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.5/@blockSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_sequence {setProperty(ret, "functionSequence", temp);
setParent(temp,ret,"functionSequence");}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.19/@templateSequence/@elements.5/@blockSequence/@elements.2");} SEMI {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_contexttags returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ContextTags");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.20/@templateSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.20/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "tags", temp);
setParent(temp,ret,"tags");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.20/@templateSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);
setParent(temp,ret,"tags");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.20/@templateSequence/@elements.2");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_sequence__impl returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Sequence");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.21/@templateSequence/@elements.0");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.21/@templateSequence/@elements.0/@blockSequence/@elements.0");}( temp=furcas_tcs_sequenceelement {setProperty(ret, "elements", temp);
setParent(temp,ret,"elements");} ( temp=furcas_tcs_sequenceelement {setProperty(ret, "elements", temp);
setParent(temp,ret,"elements");})* )? {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_sequence returns[Object ret2]
  :
  (ret=furcas_tcs_sequence__impl|(ret=furcas_tcs_sequenceinalternative)
  {
ret2=ret;
 }){ret2 = ret;}
  ;


furcas_tcs_sequenceelement returns[Object ret2]
  :
  (ret=furcas_tcs_literalref
  | ret=furcas_tcs_property
  | ret=furcas_tcs_customseparator
  | ret=furcas_tcs_block
  | ret=furcas_tcs_conditionalelement
  | ret=furcas_tcs_alternative
  | ret=furcas_tcs_functioncall
  | ret=furcas_tcs_injectoractionsblock)
  {
ret2=ret;
 }
  ;


furcas_tcs_literalref returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","LiteralRef");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.23/@templateSequence/@elements.0");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("FURCAS","TCS","Literal"), "value", temp, "#all", "ifmissing", list("FURCAS","TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.23/@templateSequence/@elements.1");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_propertyreference returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PropertyReference");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.24/@templateSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.24/@templateSequence/@elements.0/@thenSequence/@elements.0");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", null, temp, "OCL:#context.oclAsType(FURCAS::TCS::Template).metaReference.oclAsType(ecore::EClass).eAllStructuralFeatures->select(name = ?)");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.24/@templateSequence/@elements.0/@elseSequence/@elements.0");} RARROW {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.24/@templateSequence/@elements.0/@elseSequence/@elements.1");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_property returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Property");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.1/@thenSequence/@elements.0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.1/@thenSequence/@elements.1");}( temp=furcas_tcs_propertyarg {setProperty(ret, "propertyArgs", temp);
setParent(temp,ret,"propertyArgs");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.1/@thenSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_propertyarg {setProperty(ret, "propertyArgs", temp);
setParent(temp,ret,"propertyArgs");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.1/@thenSequence/@elements.2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.25/@templateSequence/@elements.2");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_customseparator returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","CustomSeparator");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.26/@templateSequence/@elements.0");} LT {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.26/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.26/@templateSequence/@elements.2");} GT {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.26/@templateSequence/@elements.3");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_block returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Block");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.0");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.1");}( temp=furcas_tcs_sequence {setProperty(ret, "blockSequence", temp);
setParent(temp,ret,"blockSequence");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.2");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.3/@thenSequence/@elements.0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.3/@thenSequence/@elements.1");}( temp=furcas_tcs_blockarg {setProperty(ret, "blockArgs", temp);
setParent(temp,ret,"blockArgs");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.3/@thenSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_blockarg {setProperty(ret, "blockArgs", temp);
setParent(temp,ret,"blockArgs");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.3/@thenSequence/@elements.2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.27/@templateSequence/@elements.4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_conditionalelement returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ConditionalElement");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.1");}( temp=furcas_tcs_expression {setProperty(ret, "condition", temp);
setParent(temp,ret,"condition");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.2");} QMARK {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.3");}( temp=furcas_tcs_sequence {setProperty(ret, "thenSequence", temp);
setParent(temp,ret,"thenSequence");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.4");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.4/@thenSequence/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.4/@thenSequence/@elements.1");}( temp=furcas_tcs_sequence {setProperty(ret, "elseSequence", temp);
setParent(temp,ret,"elseSequence");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.5");} RPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.28/@templateSequence/@elements.6");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_alternative returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Alternative");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.0");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_sequenceinalternative {setProperty(ret, "sequences", temp);
setParent(temp,ret,"sequences");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_sequenceinalternative {setProperty(ret, "sequences", temp);
setParent(temp,ret,"sequences");})+){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.2");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.3/@thenSequence/@elements.0");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.29/@templateSequence/@elements.4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_sequenceinalternative returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","SequenceInAlternative");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.0/@thenSequence/@elements.0");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.0/@thenSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.0/@thenSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);
setParent(temp,ret,"disambiguate");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.0/@thenSequence/@elements.3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.30/@templateSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_sequenceelement {setProperty(ret, "elements", temp);
setParent(temp,ret,"elements");} ( temp=furcas_tcs_sequenceelement {setProperty(ret, "elements", temp);
setParent(temp,ret,"elements");})* )? {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_functioncall returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","FunctionCall");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.31/@templateSequence/@elements.0");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.31/@templateSequence/@elements.1");}( temp=identifier {setRef(ret, "calledFunction", list("FURCAS","TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.31/@templateSequence/@elements.2");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_injectoractionsblock returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","InjectorActionsBlock");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.32/@templateSequence/@elements.0");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.32/@templateSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.32/@templateSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_injectoraction {setProperty(ret, "injectorActions", temp);
setParent(temp,ret,"injectorActions");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.32/@templateSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_injectoraction {setProperty(ret, "injectorActions", temp);
setParent(temp,ret,"injectorActions");})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.32/@templateSequence/@elements.2");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.32/@templateSequence/@elements.3");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_injectoraction returns[Object ret2]
  :
  (ret=furcas_tcs_propertyinit)
  {
ret2=ret;
 }
  ;


furcas_tcs_propertyinit returns[Object ret2]
  :
  (ret=furcas_tcs_primitivepropertyinit
  | ret=furcas_tcs_lookuppropertyinit
  | ret=furcas_tcs_foreachpredicatepropertyinit)
  {
ret2=ret;
 }
  ;


furcas_tcs_primitivepropertyinit returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PrimitivePropertyInit");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.35/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.35/@templateSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.35/@templateSequence/@elements.1/@thenSequence/@elements.0");} LARROW {_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.35/@templateSequence/@elements.1/@elseSequence/@elements.0");} EQ {_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.35/@templateSequence/@elements.2");}( temp=escapedIdentifierOrKeyword {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_lookuppropertyinit returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","LookupPropertyInit");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.1/@thenSequence/@elements.0");} LARROW {_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.1/@elseSequence/@elements.0");} EQ {_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.2");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.4");}( temp=stringSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.36/@templateSequence/@elements.5");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_foreachpredicatepropertyinit returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ForeachPredicatePropertyInit");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.1/@thenSequence/@elements.0");} LARROW {_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.1/@elseSequence/@elements.0");} EQ {_afterSeqEl();}){setProperty(ret, "default", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.2");}'foreach'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.4");}( temp=stringSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.5");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.5/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.5/@thenSequence/@elements.1");}'mode'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.5/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.5/@thenSequence/@elements.3");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);
setParent(temp,ret,"mode");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.6");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.6/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.6/@thenSequence/@elements.1");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.6/@thenSequence/@elements.1/@blockSequence/@elements.0");}( temp=furcas_tcs_predicatesemantic {setProperty(ret, "predicateSemantic", temp);
setParent(temp,ret,"predicateSemantic");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.6/@thenSequence/@elements.1/@blockSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_predicatesemantic {setProperty(ret, "predicateSemantic", temp);
setParent(temp,ret,"predicateSemantic");})* )? {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.37/@templateSequence/@elements.7");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_predicatesemantic returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PredicateSemantic");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.0/@thenSequence/@elements.0");}'when'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.0/@thenSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.0/@thenSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "when", temp);
setParent(temp,ret,"when");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.0/@thenSequence/@elements.3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.1/@thenSequence/@elements.0");}'mode'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.1/@thenSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.1/@thenSequence/@elements.2");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);
setParent(temp,ret,"mode");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.1/@thenSequence/@elements.3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.2");}'as'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.3");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.38/@templateSequence/@elements.4");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlock.parentTemplate.concreteSyntax.templates->select(t| "+
"                                            if(t.oclIsTypeOf(FURCAS::TCS::ClassTemplate)) then "+
"                                                t.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.oclAsType(ecore::EClass).eAllSuperTypes"+
"                                                       ->prepend(t.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.oclAsType(ecore::EClass))"+
"                                                       ->includes(self.foreachParent.propertyReference.strucfeature.eType.oclAsType(ecore::EClass))"+
"                                                and (if(not self.mode.oclIsUndefined()) then"+
"                                                         t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.mode"+
"                                                     else"+
"                                                         t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.foreachParent.mode"+
"                                                     endif)                                                                       "+
"                                            else"+
"                                                t.oclIsTypeOf(FURCAS::TCS::PrimitiveTemplate)"+
"                                            endif)->select(candidate | if candidate.oclIsTypeOf(FURCAS::TCS::ClassTemplate) then"+
"                                                candidate.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.name"+
"                                            else "+
"                                                candidate.oclAsType(FURCAS::TCS::PrimitiveTemplate).templateName"+
"                                            endif = ?)");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_propertyarg returns[Object ret2]
  :
  (ret=furcas_tcs_referstoparg
  | ret=furcas_tcs_lookinparg
  | ret=furcas_tcs_createinparg
  | ret=furcas_tcs_asparg
  | ret=furcas_tcs_separatorparg
  | ret=furcas_tcs_disambiguateparg
  | ret=furcas_tcs_autocreateparg
  | ret=furcas_tcs_importcontextparg
  | ret=furcas_tcs_partialparg
  | ret=furcas_tcs_forcedlowerparg
  | ret=furcas_tcs_forcedupperparg
  | ret=furcas_tcs_createasparg
  | ret=furcas_tcs_lookupscopeparg
  | ret=furcas_tcs_referencebyparg
  | ret=furcas_tcs_prefixparg
  | ret=furcas_tcs_postfixparg
  | ret=furcas_tcs_modeparg)
  {
ret2=ret;
 }
  ;


furcas_tcs_referstoparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","RefersToPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.40/@templateSequence/@elements.0");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.40/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.40/@templateSequence/@elements.2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);
setParent(temp,ret,"propertyName");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_lookinparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","LookInPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.0");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.2/@thenSequence/@elements.0");} SHARP {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.2/@thenSequence/@elements.1");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.2/@elseSequence/@elements.0");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);
setParent(temp,ret,"propertyName");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.41/@templateSequence/@elements.2/@elseSequence/@elements.0/@propertyArgs.1/@separatorSequence/@elements.0");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);
setParent(temp,ret,"propertyName");})* )? {_afterSeqEl();}){}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_createinparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","CreateInPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.42/@templateSequence/@elements.0");}'createIn'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.42/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.42/@templateSequence/@elements.2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);
setParent(temp,ret,"propertyName");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.42/@templateSequence/@elements.2/@propertyArgs.1/@separatorSequence/@elements.0");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);
setParent(temp,ret,"propertyName");})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_asparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","AsPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.43/@templateSequence/@elements.0");}'as'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.43/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.43/@templateSequence/@elements.2");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t| "+
"                                            if(t.oclIsTypeOf(FURCAS::TCS::ClassTemplate) and ("+
"                                               self.property.propertyReference.strucfeature.eType.oclIsKindOf(ecore::EClass))) then"+
"                                                   self.property.propertyReference.strucfeature.eType.oclAsType(ecore::EClass).eAllSuperTypes"+
"                                                       ->prepend(self.property.propertyReference.strucfeature.eType.oclAsType(ecore::EClass))"+
"                                                       ->includes(t.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.oclAsType(ecore::EClass))                                                       "+
"                                                   and (if (not self.property.propertyArgs->select(arg | arg.oclIsTypeOf(FURCAS::TCS::ModePArg))->isEmpty()) then "+
"                                                            t.oclAsType(FURCAS::TCS::ClassTemplate).mode = self.property.propertyArgs->select("+
"                                                                arg | arg.oclIsTypeOf(FURCAS::TCS::ModePArg)).oclAsType(FURCAS::TCS::ModePArg)"+
"                                                                    ->asSequence()->at(1).mode"+
"                                                        else"+
"                                                            t.oclAsType(FURCAS::TCS::ClassTemplate).mode.oclIsUndefined()"+
"                                                        endif)                                                                       "+
"                                            else"+
"                                                t.oclIsKindOf(FURCAS::TCS::PrimitiveTemplate)"+
"                                            endif)->select(candidate | if candidate.oclIsTypeOf(FURCAS::TCS::ClassTemplate) then"+
"                                                candidate.oclAsType(FURCAS::TCS::ClassTemplate).metaReference.name"+
"                                            else "+
"                                                candidate.oclAsType(FURCAS::TCS::PrimitiveTemplate).templateName"+
"                                            endif = ?)");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_separatorparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","SeparatorPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.44/@templateSequence/@elements.0");}'separator'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.44/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.44/@templateSequence/@elements.2");}( temp=furcas_tcs_sequence {setProperty(ret, "separatorSequence", temp);
setParent(temp,ret,"separatorSequence");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_disambiguateparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","DisambiguatePArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.45/@templateSequence/@elements.0");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.45/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.45/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);
setParent(temp,ret,"disambiguation");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_autocreateparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","AutoCreatePArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.46/@templateSequence/@elements.0");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.46/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.46/@templateSequence/@elements.2");}( temp=furcas_tcs_autocreatekind {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.47/@mappings.0/@element");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.47/@mappings.1/@element");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.47/@mappings.2/@element");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","AutoCreateKind"), "never");})
{
  ret2=ret;
}
  ;


furcas_tcs_importcontextparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ImportContextPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.48/@templateSequence/@elements.0");}'importContext'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_partialparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PartialPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.49/@templateSequence/@elements.0");}'partial'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_forcedlowerparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ForcedLowerPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.50/@templateSequence/@elements.0");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.50/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.50/@templateSequence/@elements.2");}( temp=integerSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_forcedupperparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ForcedUpperPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.51/@templateSequence/@elements.0");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.51/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.51/@templateSequence/@elements.2");}( temp=integerSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_createasparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","CreateAsPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.52/@templateSequence/@elements.0");}'createAs'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.52/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.52/@templateSequence/@elements.2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);
setParent(temp,ret,"name");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.52/@templateSequence/@elements.2/@propertyArgs.1/@separatorSequence/@elements.0");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);
setParent(temp,ret,"name");})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_lookupscopeparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","LookupScopePArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.53/@templateSequence/@elements.0");}'lookupScope'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.53/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.53/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "query", temp);
setParent(temp,ret,"query");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_referencebyparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ReferenceByPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.54/@templateSequence/@elements.0");}'referenceBy'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.54/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.54/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "referenceBy", temp);
setParent(temp,ret,"referenceBy");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_prefixparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PrefixPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.55/@templateSequence/@elements.0");}'prefix'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.55/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.55/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "prefix", temp);
setParent(temp,ret,"prefix");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_postfixparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","PostfixPArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.56/@templateSequence/@elements.0");}'postfix'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.56/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.56/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "postfix", temp);
setParent(temp,ret,"postfix");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_modeparg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ModePArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.57/@templateSequence/@elements.0");}'mode'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.57/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.57/@templateSequence/@elements.2");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);
setParent(temp,ret,"mode");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_blockarg returns[Object ret2]
  :
  (ret=furcas_tcs_nbnlbarg
  | ret=furcas_tcs_indentincrbarg
  | ret=furcas_tcs_startnlbarg
  | ret=furcas_tcs_startnbnlbarg
  | ret=furcas_tcs_endnlbarg)
  {
ret2=ret;
 }
  ;


furcas_tcs_nbnlbarg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","NbNLBArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.59/@templateSequence/@elements.0");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.59/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.59/@templateSequence/@elements.2");}( temp=integerSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_indentincrbarg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","IndentIncrBArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.60/@templateSequence/@elements.0");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.60/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.60/@templateSequence/@elements.2");}( temp=integerSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_startnlbarg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","StartNLBArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.61/@templateSequence/@elements.0");}'startNL'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.61/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.61/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.61/@templateSequence/@elements.2/@thenSequence/@elements.0");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.61/@templateSequence/@elements.2/@elseSequence/@elements.0");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_startnbnlbarg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","StartNbNLBArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.62/@templateSequence/@elements.0");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.62/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.62/@templateSequence/@elements.2");}( temp=integerSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_endnlbarg returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","EndNLBArg");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.63/@templateSequence/@elements.0");}'endNL'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.63/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.63/@templateSequence/@elements.2");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.63/@templateSequence/@elements.2/@thenSequence/@elements.0");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.63/@templateSequence/@elements.2/@elseSequence/@elements.0");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_symbol returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Symbol");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.3/@thenSequence/@elements.0");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.3/@thenSequence/@elements.1");}( temp=furcas_tcs_spacekind {setProperty(ret, "spaces", temp);
setParent(temp,ret,"spaces");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.3/@thenSequence/@elements.1/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_spacekind {setProperty(ret, "spaces", temp);
setParent(temp,ret,"spaces");})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.64/@templateSequence/@elements.4");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.65/@mappings.0/@element");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.65/@mappings.1/@element");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.65/@mappings.2/@element");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.65/@mappings.3/@element");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","SpaceKind"), "rightNone");})
{
  ret2=ret;
}
  ;


furcas_tcs_keyword returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Keyword");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.66/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.66/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.66/@templateSequence/@elements.2");}( temp=stringSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.66/@templateSequence/@elements.3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_operatorlist returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","OperatorList");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.0");}'operators'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.1");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.1/@thenSequence/@elements.0");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.3");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.3/@blockSequence/@elements.0");}( temp=furcas_tcs_priority {setProperty(ret, "priorities", temp);
setParent(temp,ret,"priorities");} ( temp=furcas_tcs_priority {setProperty(ret, "priorities", temp);
setParent(temp,ret,"priorities");})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.67/@templateSequence/@elements.4");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_priority returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Priority");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.0");}'priority'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.1");}( temp=integerSymbol {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.2");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("FURCAS","TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.2/@elseSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.2/@elseSequence/@elements.1");}( temp=furcas_tcs_associativity {setProperty(ret, "associativity", temp);
setParent(temp,ret,"associativity");}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("FURCAS","TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.4");}(({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.4/@blockSequence/@elements.0");}( temp=furcas_tcs_operator {setProperty(ret, "operators", temp);
setParent(temp,ret,"operators");} ( temp=furcas_tcs_operator {setProperty(ret, "operators", temp);
setParent(temp,ret,"operators");})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.68/@templateSequence/@elements.5");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_operator returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Operator");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.0/@thenSequence/@elements.0");}'postfix'{_afterSeqEl();}){setProperty(ret, "postfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "postfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.3");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.3/@thenSequence/@elements.0");}({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.3/@thenSequence/@elements.0/@sequences.0/@elements.0");}( temp=identifier {setRef(ret, "literal", list("FURCAS","TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.3/@thenSequence/@elements.0/@sequences.1/@elements.0");}( temp=stringSymbol {setRef(ret, "literal", list("FURCAS","TCS","Literal"), "value", temp, "#all", "ifmissing", list("FURCAS","TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.4");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.5");}( temp=integerSymbol {setProperty(ret, "arity", temp);
setParent(temp,ret,"arity");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.69/@templateSequence/@elements.6");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.70/@mappings.0/@element");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","Associativity"), "left");}
 | ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.70/@mappings.1/@element");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("FURCAS","TCS","Associativity"), "right");})
{
  ret2=ret;
}
  ;


furcas_tcs_expression returns[Object ret2]
  :
  (ret=furcas_tcs_andexp)
  {
ret2=ret;
 }
  ;


furcas_tcs_andexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","AndExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.72/@templateSequence/@elements.0");}( temp=furcas_tcs_atomexp {setProperty(ret, "expressions", temp);
setParent(temp,ret,"expressions");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.72/@templateSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_atomexp {setProperty(ret, "expressions", temp);
setParent(temp,ret,"expressions");})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_atomexp returns[Object ret2]
  :
  (ret=furcas_tcs_equalsexp
  | ret=furcas_tcs_booleanpropertyexp
  | ret=furcas_tcs_isdefinedexp
  | ret=furcas_tcs_oneexp
  | ret=furcas_tcs_instanceofexp)
  {
ret2=ret;
 }
  ;


furcas_tcs_equalsexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","EqualsExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.74/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.74/@templateSequence/@elements.1");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.74/@templateSequence/@elements.2");}( temp=furcas_tcs_value {setProperty(ret, "value", temp);
setParent(temp,ret,"value");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_booleanpropertyexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","BooleanPropertyExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.75/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_isdefinedexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","IsDefinedExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.76/@templateSequence/@elements.0");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.76/@templateSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.76/@templateSequence/@elements.2");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.76/@templateSequence/@elements.3");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_oneexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","OneExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.77/@templateSequence/@elements.0");}'one'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.77/@templateSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.77/@templateSequence/@elements.2");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.77/@templateSequence/@elements.3");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_instanceofexp returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","InstanceOfExp");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.78/@templateSequence/@elements.0");}( temp=furcas_tcs_propertyreference {setProperty(ret, "propertyReference", temp);
setParent(temp,ret,"propertyReference");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.78/@templateSequence/@elements.1");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.78/@templateSequence/@elements.2");}( temp=identifier {setProperty(ret, "supertype", temp);
setParent(temp,ret,"supertype");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.78/@templateSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);
setParent(temp,ret,"supertype");})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_value returns[Object ret2]
  :
  (ret=furcas_tcs_stringval
  | ret=furcas_tcs_integerval
  | ret=furcas_tcs_negativeintegerval
  | ret=furcas_tcs_enumliteralval)
  {
ret2=ret;
 }
  ;


furcas_tcs_stringval returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","StringVal");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.80/@templateSequence/@elements.0");}( temp=stringSymbol {setProperty(ret, "symbol", temp);
setParent(temp,ret,"symbol");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_integerval returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","IntegerVal");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.81/@templateSequence/@elements.0");}( temp=integerSymbol {setProperty(ret, "symbol", temp);
setParent(temp,ret,"symbol");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_negativeintegerval returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","NegativeIntegerVal");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.82/@templateSequence/@elements.0");} MINUS {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.82/@templateSequence/@elements.1");}( temp=integerSymbol {setProperty(ret, "symbol", temp);
setParent(temp,ret,"symbol");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_enumliteralval returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","EnumLiteralVal");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.83/@templateSequence/@elements.0");} SHARP {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.83/@templateSequence/@elements.1");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_token returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","Token");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.0");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.0/@thenSequence/@elements.0");}'omitted'{_afterSeqEl();}){setProperty(ret, "omitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "omitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.1");}'token'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.2");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.3");} COLON {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.4");}( temp=furcas_tcs_orpattern {setProperty(ret, "pattern", temp);
setParent(temp,ret,"pattern");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.84/@templateSequence/@elements.5");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_orpattern returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","OrPattern");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.85/@templateSequence/@elements.0");}( temp=furcas_tcs_simplepattern {setProperty(ret, "simplePatterns", temp);
setParent(temp,ret,"simplePatterns");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.85/@templateSequence/@elements.0/@propertyArgs.0/@separatorSequence/@elements.0");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_simplepattern {setProperty(ret, "simplePatterns", temp);
setParent(temp,ret,"simplePatterns");})* ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_simplepattern returns[Object ret2]
  :
  (ret=furcas_tcs_rulepattern
  | ret=furcas_tcs_stringpattern
  | ret=furcas_tcs_classpattern)
  {
ret2=ret;
 }
  ;


furcas_tcs_rulepattern returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","RulePattern");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.87/@templateSequence/@elements.0");}( temp=furcas_tcs_rule {setProperty(ret, "rule", temp);
setParent(temp,ret,"rule");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_rule returns[Object ret2]
  :
  (ret=furcas_tcs_wordrule
  | ret=furcas_tcs_endoflinerule
  | ret=furcas_tcs_multilinerule)
  {
ret2=ret;
 }
  ;


furcas_tcs_wordrule returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","WordRule");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.0");}'word'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.2");}'start'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.3");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.4");}( temp=furcas_tcs_orpattern {setProperty(ret, "start", temp);
setParent(temp,ret,"start");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.5");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.6");}'part'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.7");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.8");}( temp=furcas_tcs_orpattern {setProperty(ret, "part", temp);
setParent(temp,ret,"part");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.9");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.9/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.9/@thenSequence/@elements.1");}'end'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.9/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.9/@thenSequence/@elements.3");}( temp=furcas_tcs_orpattern {setProperty(ret, "end", temp);
setParent(temp,ret,"end");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.89/@templateSequence/@elements.10");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_endoflinerule returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","EndOfLineRule");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.0");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.2");}'start'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.3");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.4");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.4/@thenSequence/@elements.0");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.5");}( temp=furcas_tcs_stringpattern {setProperty(ret, "start", temp);
setParent(temp,ret,"start");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.90/@templateSequence/@elements.6");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_multilinerule returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","MultiLineRule");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.0");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.2");}'start'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.3");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.4");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.4/@thenSequence/@elements.0");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.5");}( temp=furcas_tcs_stringpattern {setProperty(ret, "start", temp);
setParent(temp,ret,"start");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.6");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.7");}'end'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.8");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.9");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.9/@thenSequence/@elements.0");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.10");}( temp=furcas_tcs_stringpattern {setProperty(ret, "end", temp);
setParent(temp,ret,"end");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.1");}'esc'{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.2");} EQ {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.3");}( temp=furcas_tcs_stringpattern {setProperty(ret, "esc", temp);
setParent(temp,ret,"esc");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.4");} ({_enterAlt(0);} ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.0");} COMA {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.2");}( temp=furcas_tcs_mapping {setProperty(ret, "escMappings", temp);
setParent(temp,ret,"escMappings");} ({_enterSepSeq();}({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.2/@propertyArgs.0/@separatorSequence/@elements.0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=furcas_tcs_mapping {setProperty(ret, "escMappings", temp);
setParent(temp,ret,"escMappings");})* )? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.11/@thenSequence/@elements.4/@thenSequence/@elements.3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.91/@templateSequence/@elements.12");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_mapping returns[Object ret2]
  :
  (ret=furcas_tcs_simplemapping
  | ret=furcas_tcs_wildcardmapping
  | ret=furcas_tcs_octalmapping
  | ret=furcas_tcs_hexadecimalmapping)
  {
ret2=ret;
 }
  ;


furcas_tcs_simplemapping returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","SimpleMapping");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.93/@templateSequence/@elements.0");}( temp=identifier {setProperty(ret, "key", temp);
setParent(temp,ret,"key");})? {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.93/@templateSequence/@elements.1");} RARROW {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.93/@templateSequence/@elements.2");}( temp=identifier {setProperty(ret, "value", temp);
setParent(temp,ret,"value");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_wildcardmapping returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","WildcardMapping");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.94/@templateSequence/@elements.0");} POINT {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.94/@templateSequence/@elements.1");} RARROW {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.94/@templateSequence/@elements.2");} POINT {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_octalmapping returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","OctalMapping");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.95/@templateSequence/@elements.0");}'octal'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_hexadecimalmapping returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","HexadecimalMapping");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.96/@templateSequence/@elements.0");}'hex'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_stringpattern returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","StringPattern");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.97/@templateSequence/@elements.0");}( temp=stringSymbol {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

furcas_tcs_classpattern returns[Object ret2] @init{IModelElementProxy ret;
List<String> metaType=list("FURCAS","TCS","ClassPattern");
ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
onEnterTemplateRule(metaType);
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.98/@templateSequence/@elements.0");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.98/@templateSequence/@elements.1");}( temp=identifier {setProperty(ret, "name", temp);
setParent(temp,ret,"name");}){_afterSeqEl();}{_beforeSeqEl("platform:/plugin/com.sap.furcas.tcs.editor/mappings/TCS.tcs#//@templates.98/@templateSequence/@elements.2");} RSQUARE {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('--' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


MULTI_LINE_COMMENT
  :
     ((('/**' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


LSQUARE
  :
  '['
  ;


RSQUARE
  :
  ']'
  ;


DLSQUARE
  :
  '[['
  ;


DRSQUARE
  :
  ']]'
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


DLCURLY
  :
  '{{'
  ;


DRCURLY
  :
  '}}'
  ;


SEMI
  :
  ';'
  ;


COLON
  :
  ':'
  ;


DLCOLON
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


DOLLAR
  :
  '$'
  ;


AROBAS
  :
  '@'
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
        :       
//      (~ORKEYWORD)=> 
        (ALPHA) (ALPHA | DIGIT)* 
;

//QNAME_OR_NAME :
//         ( ORKEYWORD COLON ) => ORKEYWORD { _type = ORKEYWORD; }
//         |    ( SNAME DLCOLON SNAME ) => QNAME { _type = QNAME; }
//         |    (~ORKEYWORD COLON | SNAME COLON ~(COLON) ) => NAME { _type = NAME; }
//         |    ( ~ORKEYWORD | SNAME ~COLON ) => NAME { _type = NAME; }
//         |    ( '\'' SNAME) => NAME { _type = NAME; }
//;

//fragment 
//ORKEYWORD :
//      'orKeyword'
//;

//fragment
NAME
        :       (   
                        SNAME
                |       '\''!  // exclamation marks means to exclude the char from the token (in theory)
                        (       ESC
                        |       '\n' {newline();}
                        |       ~('\\'|'\''|'\n') // means any other character
                        )*
                        '\''!
                )
        ;

//fragment
//QNAME
//        : SNAME DLCOLON SNAME (DLCOLON SNAME )*
//        ;

INT
        :       (DIGIT)+
        ;

        FLOAT   :       DIGIT+ '.' DIGIT*       ;

fragment
ESC
        :       '\\'!
                (       'n' 
                |       'r' 
                |       't' 
                |       'b' 
                |       'f' 
                |       '"' 
                |       '\'' 
                |       '\\' 
                |       (
                                ('0'..'3')
                                (
                                :       ('0'..'7')
                                        (
                                        :       '0'..'7'
                                        )?
                                )?
                        |       ('4'..'7')
                                (
                                :       ('0'..'7')
                                )?
                        )
                                {
                                }
                )
        ;

STRING
        :       '"'!
                (       ESC
                |       '\n' {newline();}
                |       ~('\\'|'\"'|'\n')  // means any other character
                )*
                '"'!
        ;

        