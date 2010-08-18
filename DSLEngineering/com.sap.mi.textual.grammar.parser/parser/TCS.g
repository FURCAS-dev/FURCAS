grammar TCS;
options {superClass=ObservableInjectingParser;backtrack = true;}

@lexer::header {
package com.sap.mi.textual.grammar.parser;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.grammar.antlr3.ITokenFactory;
import com.sap.mi.textual.grammar.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

@lexer::members {  public com.sap.mi.textual.grammar.IModelInjector ei = null;
public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;
  /*************** Code generated in class com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
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
  /*************** End of Code generated in class com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
}

@header {
package com.sap.mi.textual.grammar.parser;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;
import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.PredicateSemantic;
import com.sap.mi.textual.grammar.impl.SemanticDisambRuleData;
import com.sap.mi.textual.moinlookup.util.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
   private static final String syntaxUUID = "E0DCF6CDFFDEFE33333D11DFC5D4DD40A9FE17A4";
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
  | 'partial' {ret = "partial";}
  | 'addToContext' {ret = "addToContext";}
  | 'omitted' {ret = "omitted";}
  | 'priority' {ret = "priority";}
  | 'source' {ret = "source";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'esc' {ret = "esc";}
  | 'keywords' {ret = "keywords";}
  | 'token' {ret = "token";}
  | 'syntax' {ret = "syntax";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'deep' {ret = "deep";}
  | 'start' {ret = "start";}
  | 'as' {ret = "as";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'symbols' {ret = "symbols";}
  | 'function' {ret = "function";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'serializer' {ret = "serializer";}
  | 'default' {ret = "default";}
  | 'createAs' {ret = "createAs";}
  | 'operators' {ret = "operators";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'operatored' {ret = "operatored";}
  | 'right' {ret = "right";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'when' {ret = "when";}
  | 'all' {ret = "all";}
  | 'rightNone' {ret = "rightNone";}
  | 'hex' {ret = "hex";}
  | 'abstract' {ret = "abstract";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'true' {ret = "true";}
  | 'for' {ret = "for";}
  | 'word' {ret = "word";}
  | 'invert' {ret = "invert";}
  | 'leftNone' {ret = "leftNone";}
  | 'query' {ret = "query";}
  | 'drop' {ret = "drop";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'value' {ret = "value";}
  | 'and' {ret = "and";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'foreach' {ret = "foreach";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'semDisambiguate' {ret = "semDisambiguate";}
  | 'left' {ret = "left";}
  | 'auto' {ret = "auto";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'lookIn' {ret = "lookIn";}
  | 'multi' {ret = "multi";}
  | 'one' {ret = "one";}
  | 'multiLine' {ret = "multiLine";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'k' {ret = "k";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'octal' {ret = "octal";}
  | 'end' {ret = "end";}
  | 'endNL' {ret = "endNL";}
  | 'startNL' {ret = "startNL";}
  | 'mode' {ret = "mode";}
  | 'prefix' {ret = "prefix";}
  | 'createIn' {ret = "createIn";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'separator' {ret = "separator";}
  | 'context' {ret = "context";}
  | 'isDefined' {ret = "isDefined";}
  | 'false' {ret = "false";}
  | 'importContext' {ret = "importContext";}
  | 'refersTo' {ret = "refersTo";}
  | 'never' {ret = "never";}
  | 'lexer' {ret = "lexer";}
  | 'postfix' {ret = "postfix";}
  | 'always' {ret = "always";}
  | 'template' {ret = "template";}
  | 'main' {ret = "main";}
  | 'nbNL' {ret = "nbNL";}
  | 'filter' {ret = "filter";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'part' {ret = "part";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'using' {ret = "using";})
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


model_classifier returns[Object ret2] @init{List<String> metaType=list("Model","Classifier");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFEC88523333D11DF972CDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEBC9E40333D11DFB259DD40A9FE17A4");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEC15930333D11DF8009DD40A9FE17A4");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEC15932333D11DFC931DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFEC88521333D11DFCE84DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

primary_model_namespace returns[Object ret2]
  :
  (ret=model_generalizableelement
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=model_namespace{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


dblcolon_priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=primary_model_namespace((DLCOLON)=>({_enterOpSeq("::", 2, false);}{_beforeSeqEl();}DLCOLON {opName = "::";}{_afterSeqEl();}((ret=model_modelelement[opName, ret, firstToken])){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

model_namespace returns[Object ret2]
  :
  ret=dblcolon_priority_0
  {
ret2=ret;
 }
  ;


model_generalizableelement returns[Object ret2] @init{List<String> metaType=list("Model","GeneralizableElement");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createReferenceProxy(metaType) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFED6B5F1333D11DF81F0DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

model_modelelement[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("Model","ModelElement");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ?  createReferenceProxy(metaType) : null;

}
  :
  ({_beforeSeqEl("E0DCF6CDFED926F2333D11DFAA72DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"container" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

textblockdefinition_textblockdefinition returns[Object ret2] @init{List<String> metaType=list("textblockdefinition","TextBlockDefinition");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
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
  ((ret=tcs_concretesyntax) EOF) 
  {
ret2=ret;
}
  ;


tcs_concretesyntax returns[Object ret2] @init{List<String> metaType=list("TCS","ConcreteSyntax");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFEE29CD0333D11DF9C5DDD40A9FE17A4");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CD2333D11DFB33FDD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CDD333D11DFCFBCDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEE29CD6333D11DFC882DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CD7333D11DF96E0DD40A9FE17A4");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CD8333D11DFC60FDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CDA333D11DFC45FDD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CDB333D11DF8A87DD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CDE333D11DFBB95DD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEEE83B0333D11DF8A0BDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFEE29CE0333D11DFBEBCDD40A9FE17A4");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77ED2333D11DF8A9ADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEE29CE4333D11DFA6F8DD40A9FE17A4");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE29CE5333D11DFB3EBDD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE50DD0333D11DFCBD2DD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFEE29CE7333D11DFA50BDD40A9FE17A4");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77ED0333D11DF989ADD40A9FE17A4");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77EDE333D11DFBAD4DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEE77ED6333D11DF9828DD40A9FE17A4");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77ED7333D11DFC4F3DD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77EDB333D11DFBD5FDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFEE77ED9333D11DFB361DD40A9FE17A4");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77EDC333D11DF8D4BDD40A9FE17A4");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77EE0333D11DF8B3BDD40A9FE17A4");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77EE2333D11DFB513DD40A9FE17A4");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEEC39C2333D11DF8EB9DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEE77EE6333D11DFA071DD40A9FE17A4");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE77EE7333D11DF8445DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEE9C8C2333D11DF9A59DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEEC39C0333D11DF9BF6DD40A9FE17A4");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEEE83B1333D11DF9FC7DD40A9FE17A4");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CDFEF5AFA1333D11DFC5C9DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEF0F4B5333D11DF9A50DD40A9FE17A4");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFEF0F4B7333D11DFB447DD40A9FE17A4");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEF365B1333D11DF970FDD40A9FE17A4");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFEF0F4B9333D11DFB73CDD40A9FE17A4");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


tcs_template returns[Object ret2]
  :
  (ret=tcs_contexttemplate
  | ret=tcs_primitivetemplate
  | ret=tcs_enumerationtemplate
  | ret=tcs_functiontemplate)
  {
ret2=ret;
 }
  ;


tcs_contexttemplate returns[Object ret2]
  :
  (ret=tcs_classtemplate
  | ret=tcs_operatortemplate)
  {
ret2=ret;
 }
  ;


tcs_primitivetemplate returns[Object ret2] @init{List<String> metaType=list("TCS","PrimitiveTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFEFCDB90333D11DFAE09DD40A9FE17A4");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEFCDB92333D11DFB97DDD40A9FE17A4");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEFCDB93333D11DFCA69DD40A9FE17A4");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFEFCDB94333D11DFA079DD40A9FE17A4");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019680333D11DFBB6EDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFEFF4C93333D11DF993BDD40A9FE17A4");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019681333D11DFB6A1DD40A9FE17A4");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019683333D11DFA5E2DD40A9FE17A4");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019689333D11DFCAAADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF019687333D11DF9AFADD40A9FE17A4");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF01968A333D11DFCC66DD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF01968B333D11DFB2D3DD40A9FE17A4");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF01968C333D11DF9804DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF01968F333D11DFA931DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF01969A333D11DF81D0DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF019693333D11DFC275DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019694333D11DFB837DD40A9FE17A4");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019695333D11DFCE0BDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF019698333D11DFB2B3DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF01969B333D11DFC8F8DD40A9FE17A4");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF040780333D11DF9051DD40A9FE17A4");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_enumerationtemplate returns[Object ret2] @init{List<String> metaType=list("TCS","EnumerationTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF065172333D11DF91A8DD40A9FE17A4");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF065173333D11DF8085DD40A9FE17A4");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF065179333D11DF8639DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF065177333D11DFB01FDD40A9FE17A4");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF08C280333D11DFB3F6DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF08C27C333D11DF81EDDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF08C271333D11DFB8C5DD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF08C279333D11DF845BDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF08C276333D11DF85AEDD40A9FE17A4");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF08C273333D11DFB84CDD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF08C27A333D11DF8418DD40A9FE17A4");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF08C27E333D11DF8EC2DD40A9FE17A4");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0B3372333D11DFC6F5DD40A9FE17A4");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_enumliteralmapping returns[Object ret2] @init{List<String> metaType=list("TCS","EnumLiteralMapping");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF0D7D61333D11DF8873DD40A9FE17A4");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0D7D62333D11DFAA1DDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0D7D64333D11DF842ADD40A9FE17A4");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_classtemplate returns[Object ret2] @init{List<String> metaType=list("TCS","ClassTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF0FEE60333D11DF9C89DD40A9FE17A4");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE61333D11DFAC08DD40A9FE17A4");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF19645B333D11DFA8FADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF0FEE65333D11DFC8F1DD40A9FE17A4");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF0FEE6E333D11DF8B05DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF0FEE6A333D11DF868ADD40A9FE17A4");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE6C333D11DFBEEADD40A9FE17A4");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE7A333D11DFACACDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF0FEE72333D11DFC1B8DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE73333D11DFCC12DD40A9FE17A4");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE74333D11DF8C32DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE77333D11DFA7DDDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE78333D11DFB1EEDD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF123851333D11DFACA1DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF0FEE7E333D11DFCDFADD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE7F333D11DF9FDDDD40A9FE17A4");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE80333D11DF8720DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE83333D11DFCB56DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF0FEE84333D11DFCD3ADD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF12385D333D11DFC4D2DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF123855333D11DF8C87DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF123856333D11DF92D4DD40A9FE17A4");}'semDisambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF123857333D11DFA1ADDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF12385A333D11DFBBC3DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "semDisambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF12385B333D11DFA65EDD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF123863333D11DF858ADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF123861333D11DF9BCEDD40A9FE17A4");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF14A954333D11DFCD87DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF14A952333D11DFB84CDD40A9FE17A4");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF14A960333D11DF912ADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF14A95D333D11DFAE48DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF14A95B333D11DF812DDD40A9FE17A4");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF14A95E333D11DF8D90DD40A9FE17A4");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF171A55333D11DFAA29DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF14A964333D11DFBE5ADD40A9FE17A4");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF171A53333D11DF949FDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF14A968333D11DFA6A5DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF171A50333D11DFC55ADD40A9FE17A4");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF171A51333D11DFA970DD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF171A62333D11DFA70CDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF171A59333D11DFC0BADD40A9FE17A4");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF171A60333D11DFBE32DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF171A5E333D11DF9D3FDD40A9FE17A4");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF196445333D11DFAFEADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF196443333D11DFA1E5DD40A9FE17A4");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF19644B333D11DFAFB9DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF196449333D11DFA4B7DD40A9FE17A4");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF196459333D11DFA8C1DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF19644F333D11DF946FDD40A9FE17A4");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF196457333D11DF9F50DD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF196450333D11DF928FDD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF196455333D11DF9C4BDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF196452333D11DFCAE7DD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF1BD54D333D11DFAFB0DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF1BD549333D11DFBDCADD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF1BD541333D11DFC419DD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF1BD546333D11DFBE7BDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF1BD543333D11DF8B26DD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF1BD547333D11DF80C2DD40A9FE17A4");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF1BD54B333D11DF907CDD40A9FE17A4");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF1BD550333D11DFA17CDD40A9FE17A4");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_operatortemplate returns[Object ret2] @init{List<String> metaType=list("TCS","OperatorTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF209030333D11DF999BDD40A9FE17A4");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209031333D11DFCD65DD40A9FE17A4");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209032333D11DF9A35DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209033333D11DFBB8EDD40A9FE17A4");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209034333D11DFA7B6DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209037333D11DF99CDDD40A9FE17A4");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209038333D11DF8D1DDD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF209039333D11DF837BDD40A9FE17A4");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF20903A333D11DF8856DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF20903C333D11DF8FE4DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230139333D11DF9DC7DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF230133333D11DFC1B5DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230134333D11DF8CDADD40A9FE17A4");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230135333D11DFB672DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230137333D11DFCE08DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230143333D11DF8CAEDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF23013D333D11DFABC5DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF23013E333D11DF8195DD40A9FE17A4");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF23013F333D11DF8B90DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230141333D11DFBA47DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF23014E333D11DF9633DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF230147333D11DF8387DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230148333D11DFB525DD40A9FE17A4");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230149333D11DF90ECDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF23014C333D11DF88DEDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230159333D11DF8EBBDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF230152333D11DFB17ADD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230153333D11DFCEBCDD40A9FE17A4");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230154333D11DFCC54DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF230157333D11DFCEC0DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B27333D11DFC425DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF254B20333D11DF862BDD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B21333D11DF9517DD40A9FE17A4");}'semDisambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B22333D11DFAD84DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B25333D11DFAB20DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "semDisambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B28333D11DF891EDD40A9FE17A4");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B3C333D11DF8DCCDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF254B2C333D11DFB939DD40A9FE17A4");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF254B3A333D11DFB3D8DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF254B31333D11DFA5E0DD40A9FE17A4");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF254B38333D11DF912FDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF254B36333D11DFB7D7DD40A9FE17A4");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF27BC2F333D11DF8824DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF27BC2B333D11DF9AB0DD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF27BC23333D11DF8138DD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF27BC28333D11DFB4ECDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF27BC25333D11DF83E7DD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF27BC29333D11DFBA2BDD40A9FE17A4");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF27BC2D333D11DFCBD4DD40A9FE17A4");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF27BC32333D11DF976EDD40A9FE17A4");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_functiontemplate returns[Object ret2] @init{List<String> metaType=list("TCS","FunctionTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF2A0610333D11DF8CC9DD40A9FE17A4");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2A0612333D11DFB3B2DD40A9FE17A4");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2A0613333D11DFA9AFDD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2A0614333D11DF808FDD40A9FE17A4");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2A0615333D11DF99F9DD40A9FE17A4");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2C7712333D11DFB9F4DD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF2A0616333D11DF8B42DD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2A061B333D11DF8D46DD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF2A0618333D11DFA3BADD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2C7710333D11DF996ADD40A9FE17A4");} SEMI {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_contexttags returns[Object ret2] @init{List<String> metaType=list("TCS","ContextTags");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF2C7716333D11DF9323DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2C771B333D11DFA509DD40A9FE17A4");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF2C7718333D11DF9AEADD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF2EE810333D11DF9DDCDD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_sequence__impl returns[Object ret2] @init{List<String> metaType=list("TCS","Sequence");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF2EE815333D11DFAFE8DD40A9FE17A4");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

tcs_sequence returns[Object ret2]
  :
  (ret=tcs_sequence__impl|(ret=tcs_sequenceinalternative)
  {
ret2=ret;
 }){ret2 = ret;}
  ;


tcs_sequenceelement returns[Object ret2]
  :
  (ret=tcs_literalref
  | ret=tcs_property
  | ret=tcs_customseparator
  | ret=tcs_block
  | ret=tcs_conditionalelement
  | ret=tcs_alternative
  | ret=tcs_functioncall
  | ret=tcs_injectoractionsblock)
  {
ret2=ret;
 }
  ;


tcs_literalref returns[Object ret2] @init{List<String> metaType=list("TCS","LiteralRef");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF385DF1333D11DFA1A3DD40A9FE17A4");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF3D18E0333D11DFB09BDD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_propertyreference returns[Object ret2] @init{List<String> metaType=list("TCS","PropertyReference");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF4444D7333D11DFCA63DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF4444D0333D11DF8160DD40A9FE17A4");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF4444D2333D11DF8084DD40A9FE17A4");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4444D5333D11DF931EDD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_property returns[Object ret2] @init{List<String> metaType=list("TCS","Property");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF46B5D1333D11DF9148DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF46B5DD333D11DFA363DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF46B5D5333D11DF9B20DD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF46B5DA333D11DFC749DD40A9FE17A4");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF46B5D7333D11DFAAF5DD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF46B5DB333D11DFCAFCDD40A9FE17A4");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF46B5E0333D11DFB7A4DD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_customseparator returns[Object ret2] @init{List<String> metaType=list("TCS","CustomSeparator");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF48FFC0333D11DF86E1DD40A9FE17A4");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF48FFC2333D11DFC6A9DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF48FFC3333D11DF8C13DD40A9FE17A4");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF48FFC6333D11DFCEB0DD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_block returns[Object ret2] @init{List<String> metaType=list("TCS","Block");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF4B70C0333D11DFADF5DD40A9FE17A4");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4B70C2333D11DFCD51DD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4B70C3333D11DFA24CDD40A9FE17A4");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4B70CF333D11DFB13DDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF4B70C7333D11DFB225DD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4B70CC333D11DFB2A8DD40A9FE17A4");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF4B70C9333D11DFAC28DD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4B70CD333D11DFAA3DDD40A9FE17A4");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4B70D2333D11DFCC3BDD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_conditionalelement returns[Object ret2] @init{List<String> metaType=list("TCS","ConditionalElement");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF4DBAB0333D11DFB6B7DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBAB2333D11DFB9F0DD40A9FE17A4");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBAB3333D11DFC101DD40A9FE17A4");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBAB5333D11DF8C1EDD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBABD333D11DFBA6EDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF4DBAB9333D11DFAA2DDD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBABB333D11DF95FDDD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBABE333D11DFABA0DD40A9FE17A4");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF4DBAC1333D11DFA586DD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_alternative returns[Object ret2] @init{List<String> metaType=list("TCS","Alternative");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF502BB0333D11DFB0BDDD40A9FE17A4");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF502BB5333D11DF8FABDD40A9FE17A4");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF502BB2333D11DF8413DD40A9FE17A4");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF502BB6333D11DF9237DD40A9FE17A4");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF502BBC333D11DFA65CDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF502BBA333D11DF8A58DD40A9FE17A4");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF502BBF333D11DF8E76DD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_sequenceinalternative returns[Object ret2] @init{List<String> metaType=list("TCS","SequenceInAlternative");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF529CBA333D11DFAD83DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF529CB3333D11DFC90ADD40A9FE17A4");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF529CB4333D11DFB425DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF529CB7333D11DF823EDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF529CB8333D11DF9F1CDD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF529CBC333D11DF9804DD40A9FE17A4");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_functioncall returns[Object ret2] @init{List<String> metaType=list("TCS","FunctionCall");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF54E6A0333D11DFAF99DD40A9FE17A4");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF54E6A3333D11DFC78ADD40A9FE17A4");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF54E6A6333D11DFC15BDD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_injectoractionsblock returns[Object ret2] @init{List<String> metaType=list("TCS","InjectorActionsBlock");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF54E6AA333D11DF96B1DD40A9FE17A4");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF54E6AF333D11DF9EE1DD40A9FE17A4");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF54E6AC333D11DF95B4DD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5757A0333D11DF89D9DD40A9FE17A4");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5757A3333D11DFC612DD40A9FE17A4");}{_enterInjectorAction();setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_injectoraction returns[Object ret2]
  :
  (ret=tcs_propertyinit)
  {
ret2=ret;
 }
  ;


tcs_propertyinit returns[Object ret2]
  :
  (ret=tcs_primitivepropertyinit
  | ret=tcs_lookuppropertyinit
  | ret=tcs_foreachpredicatepropertyinit)
  {
ret2=ret;
 }
  ;


tcs_primitivepropertyinit returns[Object ret2] @init{List<String> metaType=list("TCS","PrimitivePropertyInit");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF59A193333D11DFCB84DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF59A19B333D11DF9AD2DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF59A197333D11DFC001DD40A9FE17A4");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF59A199333D11DF8C41DD40A9FE17A4");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF59A19D333D11DF939DDD40A9FE17A4");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_lookuppropertyinit returns[Object ret2] @init{List<String> metaType=list("TCS","LookupPropertyInit");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF5C1291333D11DFCD1ADD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5C1299333D11DF8B1ADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF5C1295333D11DFB2BBDD40A9FE17A4");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF5C1297333D11DF8CFDDD40A9FE17A4");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5C129A333D11DF9016DD40A9FE17A4");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5C129B333D11DF9933DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5C129E333D11DFB4E2DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5C129F333D11DFC982DD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_foreachpredicatepropertyinit returns[Object ret2] @init{List<String> metaType=list("TCS","ForeachPredicatePropertyInit");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF5E8391333D11DFB30FDD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5E8399333D11DFC6B6DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF5E8395333D11DFC3AFDD40A9FE17A4");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF5E8397333D11DFAE2ADD40A9FE17A4");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5E839A333D11DF996DDD40A9FE17A4");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5E839B333D11DFB377DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5E839E333D11DFC1FDDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF60CD82333D11DFAA5BDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF5E83A2333D11DFAD3EDD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5E83A3333D11DFA4A5DD40A9FE17A4");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF5E83A4333D11DF97E9DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF60CD80333D11DFCB8CDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF60CD8D333D11DF870EDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF60CD86333D11DF9C09DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF60CD8B333D11DF8986DD40A9FE17A4");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF60CD88333D11DFB866DD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF60CD8E333D11DFCF7CDD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_predicatesemantic returns[Object ret2] @init{List<String> metaType=list("TCS","PredicateSemantic");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF633E8A333D11DF9A4BDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF633E83333D11DF980DDD40A9FE17A4");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E84333D11DFA7DCDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E87333D11DFA935DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E88333D11DFC85ADD40A9FE17A4");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E95333D11DFCDE1DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF633E8E333D11DFA334DD40A9FE17A4");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E8F333D11DFC9F1DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E92333D11DF9A26DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E93333D11DFB61BDD40A9FE17A4");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E96333D11DFAB75DD40A9FE17A4");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E97333D11DFADDDDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF633E9C333D11DF87BFDD40A9FE17A4");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_propertyarg returns[Object ret2]
  :
  (ret=tcs_referstoparg
  | ret=tcs_lookinparg
  | ret=tcs_createinparg
  | ret=tcs_asparg
  | ret=tcs_separatorparg
  | ret=tcs_disambiguateparg
  | ret=tcs_autocreateparg
  | ret=tcs_importcontextparg
  | ret=tcs_partialparg
  | ret=tcs_forcedlowerparg
  | ret=tcs_forcedupperparg
  | ret=tcs_createasparg
  | ret=tcs_queryparg
  | ret=tcs_filterparg
  | ret=tcs_modeparg)
  {
ret2=ret;
 }
  ;


tcs_referstoparg returns[Object ret2] @init{List<String> metaType=list("TCS","RefersToPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF658872333D11DF9BA6DD40A9FE17A4");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF658873333D11DF87FADD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF658876333D11DF8AC8DD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_lookinparg returns[Object ret2] @init{List<String> metaType=list("TCS","LookInPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF67F970333D11DF8944DD40A9FE17A4");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF67F971333D11DFC44EDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF6A6A7B333D11DFCE7EDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF6A6A71333D11DFC386DD40A9FE17A4");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF6A6A72333D11DF87F2DD40A9FE17A4");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF6A6A79333D11DF8651DD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF6A6A76333D11DFB9C9DD40A9FE17A4");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_createinparg returns[Object ret2] @init{List<String> metaType=list("TCS","CreateInPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF6CB462333D11DF925FDD40A9FE17A4");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF6CB463333D11DFCB1EDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF6CB469333D11DF9A45DD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF6CB466333D11DF9CE9DD40A9FE17A4");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_asparg returns[Object ret2] @init{List<String> metaType=list("TCS","AsPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF6F2562333D11DFC5B6DD40A9FE17A4");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF6F2563333D11DFA036DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF6F2568333D11DFADBEDD40A9FE17A4");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_separatorparg returns[Object ret2] @init{List<String> metaType=list("TCS","SeparatorPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF716F50333D11DFC134DD40A9FE17A4");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF716F51333D11DF94B3DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF716F53333D11DFA907DD40A9FE17A4");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_disambiguateparg returns[Object ret2] @init{List<String> metaType=list("TCS","DisambiguatePArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF716F57333D11DFA54DDD40A9FE17A4");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF716F58333D11DF9ADEDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF716F5B333D11DF8EE1DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreateparg returns[Object ret2] @init{List<String> metaType=list("TCS","AutoCreatePArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF73E050333D11DF8031DD40A9FE17A4");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF73E051333D11DF878DDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF73E053333D11DF8B08DD40A9FE17A4");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDFF765151333D11DFA9FFDD40A9FE17A4");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CDFF789B41333D11DF97AFDD40A9FE17A4");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CDFF789B44333D11DF9FDBDD40A9FE17A4");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
{
  ret2=ret;
}
  ;


tcs_importcontextparg returns[Object ret2] @init{List<String> metaType=list("TCS","ImportContextPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF7D5630333D11DF936CDD40A9FE17A4");}'importContext'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_partialparg returns[Object ret2] @init{List<String> metaType=list("TCS","PartialPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF7D5634333D11DFC5F9DD40A9FE17A4");}'partial'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_forcedlowerparg returns[Object ret2] @init{List<String> metaType=list("TCS","ForcedLowerPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF7FC730333D11DF9E6BDD40A9FE17A4");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF7FC731333D11DF8211DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF7FC733333D11DFC4FADD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_forcedupperparg returns[Object ret2] @init{List<String> metaType=list("TCS","ForcedUpperPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF823830333D11DFCEB7DD40A9FE17A4");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF823831333D11DFC542DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF823833333D11DF90C8DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_createasparg returns[Object ret2] @init{List<String> metaType=list("TCS","CreateAsPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF823837333D11DF9D5CDD40A9FE17A4");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF823838333D11DFA5BDDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF82383E333D11DFB437DD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF82383B333D11DFB336DD40A9FE17A4");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_queryparg returns[Object ret2] @init{List<String> metaType=list("TCS","QueryPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF848220333D11DFA8B1DD40A9FE17A4");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF848221333D11DF86B3DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF848224333D11DFA07BDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_filterparg returns[Object ret2] @init{List<String> metaType=list("TCS","FilterPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF848228333D11DF83A0DD40A9FE17A4");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF848229333D11DFAC97DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF84822C333D11DFCC18DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF86F32A333D11DFCA13DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF86F323333D11DFAF6EDD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF86F324333D11DFC692DD40A9FE17A4");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF86F325333D11DF920BDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF86F328333D11DFBA0DDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_modeparg returns[Object ret2] @init{List<String> metaType=list("TCS","ModePArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF893D10333D11DFB3A5DD40A9FE17A4");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF893D11333D11DFAC24DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF893D14333D11DF914EDD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_blockarg returns[Object ret2]
  :
  (ret=tcs_nbnlbarg
  | ret=tcs_indentincrbarg
  | ret=tcs_startnlbarg
  | ret=tcs_startnbnlbarg
  | ret=tcs_endnlbarg)
  {
ret2=ret;
 }
  ;


tcs_nbnlbarg returns[Object ret2] @init{List<String> metaType=list("TCS","NbNLBArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF8BAE10333D11DF9221DD40A9FE17A4");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF8BAE11333D11DFBB42DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF8BAE13333D11DF8333DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_indentincrbarg returns[Object ret2] @init{List<String> metaType=list("TCS","IndentIncrBArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF8BAE17333D11DFB000DD40A9FE17A4");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF8BAE18333D11DFC158DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF8BAE1A333D11DF9BF5DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_startnlbarg returns[Object ret2] @init{List<String> metaType=list("TCS","StartNLBArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF8E1F10333D11DF938BDD40A9FE17A4");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF8E1F11333D11DF9EBCDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF8E1F19333D11DF9DD7DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF8E1F15333D11DFB44CDD40A9FE17A4");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF8E1F17333D11DFB9A9DD40A9FE17A4");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_startnbnlbarg returns[Object ret2] @init{List<String> metaType=list("TCS","StartNbNLBArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF906900333D11DFC994DD40A9FE17A4");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF906901333D11DFBA29DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF906903333D11DFB9D2DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_endnlbarg returns[Object ret2] @init{List<String> metaType=list("TCS","EndNLBArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF906907333D11DFB1A5DD40A9FE17A4");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF906908333D11DF9024DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF906910333D11DF8452DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF90690C333D11DF9653DD40A9FE17A4");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF90690E333D11DF8F0DDD40A9FE17A4");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_symbol returns[Object ret2] @init{List<String> metaType=list("TCS","Symbol");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF92DA02333D11DF9371DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF92DA03333D11DF9FFBDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF92DA06333D11DF9328DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF92DA11333D11DF93F4DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF92DA0A333D11DFC6FEDD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF92DA0F333D11DF81E2DD40A9FE17A4");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFF92DA0C333D11DFA332DD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF92DA12333D11DF86F0DD40A9FE17A4");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDFF9523F2333D11DF87FFDD40A9FE17A4");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CDFF9523F5333D11DF817FDD40A9FE17A4");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CDFF9523F8333D11DF8DD9DD40A9FE17A4");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CDFF9523FB333D11DF81FCDD40A9FE17A4");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
{
  ret2=ret;
}
  ;


tcs_keyword returns[Object ret2] @init{List<String> metaType=list("TCS","Keyword");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF9794F1333D11DF8605DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9794F2333D11DFBFA5DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9794F5333D11DF926CDD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9794F6333D11DF9854DD40A9FE17A4");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_operatorlist returns[Object ret2] @init{List<String> metaType=list("TCS","OperatorList");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF9794FA333D11DFA27EDD40A9FE17A4");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF979501333D11DFAA57DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF9794FF333D11DF815ADD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A05F0333D11DFBD7BDD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A05F4333D11DFA2BDDD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF9A05F2333D11DFB762DD40A9FE17A4");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A05F5333D11DFC60DDD40A9FE17A4");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_priority returns[Object ret2] @init{List<String> metaType=list("TCS","Priority");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF9A05F9333D11DF8CCBDD40A9FE17A4");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A05FB333D11DFA046DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A0605333D11DF9AC5DD40A9FE17A4");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF9A0601333D11DF8EAADD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A0603333D11DFC3F2DD40A9FE17A4");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A0606333D11DFA785DD40A9FE17A4");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A060A333D11DFB191DD40A9FE17A4");}(({_beforeSeqEl("E0DCF6CDFF9A0608333D11DF8C7EDD40A9FE17A4");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9A060B333D11DFB594DD40A9FE17A4");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_operator returns[Object ret2] @init{List<String> metaType=list("TCS","Operator");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFF9C4FE5333D11DF929EDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF9C4FE3333D11DFA456DD40A9FE17A4");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9C4FE7333D11DFBB16DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFF9C4FE8333D11DF8278DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFA10AD1333D11DF8962DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF9EC0E9333D11DFBCB0DD40A9FE17A4");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFF9C4FEE333D11DFCAECDD40A9FE17A4");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDFF9EC0E7333D11DFA082DD40A9FE17A4");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFA10AD2333D11DFA9D9DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFA10AD4333D11DFB975DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFA10AD5333D11DFBD14DD40A9FE17A4");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDFFA37BD3333D11DFA6DDDD40A9FE17A4");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CDFFA37BD6333D11DF9F43DD40A9FE17A4");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
{
  ret2=ret;
}
  ;


tcs_expression returns[Object ret2]
  :
  (ret=tcs_andexp)
  {
ret2=ret;
 }
  ;


tcs_andexp returns[Object ret2] @init{List<String> metaType=list("TCS","AndExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFA5ECD6333D11DFA3EEDD40A9FE17A4");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFFA5ECD3333D11DF8E12DD40A9FE17A4");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_atomexp returns[Object ret2]
  :
  (ret=tcs_equalsexp
  | ret=tcs_booleanpropertyexp
  | ret=tcs_isdefinedexp
  | ret=tcs_oneexp
  | ret=tcs_instanceofexp)
  {
ret2=ret;
 }
  ;


tcs_equalsexp returns[Object ret2] @init{List<String> metaType=list("TCS","EqualsExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFA836C3333D11DF9469DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFA836C4333D11DF9140DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFA836C6333D11DFB983DD40A9FE17A4");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_booleanpropertyexp returns[Object ret2] @init{List<String> metaType=list("TCS","BooleanPropertyExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFAAA7C1333D11DFB535DD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_isdefinedexp returns[Object ret2] @init{List<String> metaType=list("TCS","IsDefinedExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFAAA7C5333D11DF84B3DD40A9FE17A4");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFAAA7C6333D11DFC1D7DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFAAA7C8333D11DFA3CDDD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFAAA7C9333D11DFC83ADD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_oneexp returns[Object ret2] @init{List<String> metaType=list("TCS","OneExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFACF1B0333D11DFC940DD40A9FE17A4");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFACF1B1333D11DFA7FBDD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFACF1B3333D11DFA46FDD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFACF1B4333D11DFB39DDD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_instanceofexp returns[Object ret2] @init{List<String> metaType=list("TCS","InstanceOfExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFACF1B9333D11DF8D6EDD40A9FE17A4");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFACF1BA333D11DF982EDD40A9FE17A4");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFACF1BF333D11DF8558DD40A9FE17A4");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFFACF1BC333D11DFB27DDD40A9FE17A4");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_value returns[Object ret2]
  :
  (ret=tcs_stringval
  | ret=tcs_integerval
  | ret=tcs_negativeintegerval
  | ret=tcs_enumliteralval)
  {
ret2=ret;
 }
  ;


tcs_stringval returns[Object ret2] @init{List<String> metaType=list("TCS","StringVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFAF62B6333D11DF90D0DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_integerval returns[Object ret2] @init{List<String> metaType=list("TCS","IntegerVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFB1D3B1333D11DF91F4DD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_negativeintegerval returns[Object ret2] @init{List<String> metaType=list("TCS","NegativeIntegerVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFB1D3B5333D11DFC710DD40A9FE17A4");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB1D3B7333D11DFCA8CDD40A9FE17A4");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_enumliteralval returns[Object ret2] @init{List<String> metaType=list("TCS","EnumLiteralVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFB41DA0333D11DFAD34DD40A9FE17A4");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB41DA3333D11DFAE8FDD40A9FE17A4");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_token returns[Object ret2] @init{List<String> metaType=list("TCS","Token");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFB41DAC333D11DFC8C2DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFB41DAA333D11DF8E6EDD40A9FE17A4");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB41DAD333D11DF8216DD40A9FE17A4");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB68EA0333D11DFB596DD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB68EA1333D11DFA236DD40A9FE17A4");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB68EA3333D11DFC36DDD40A9FE17A4");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFB68EA4333D11DFA22FDD40A9FE17A4");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_orpattern returns[Object ret2] @init{List<String> metaType=list("TCS","OrPattern");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFB68EAC333D11DF9743DD40A9FE17A4");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFFB68EA9333D11DF8B38DD40A9FE17A4");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_simplepattern returns[Object ret2]
  :
  (ret=tcs_rulepattern
  | ret=tcs_stringpattern
  | ret=tcs_classpattern)
  {
ret2=ret;
 }
  ;


tcs_rulepattern returns[Object ret2] @init{List<String> metaType=list("TCS","RulePattern");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFB8D893333D11DFCE35DD40A9FE17A4");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_rule returns[Object ret2]
  :
  (ret=tcs_wordrule
  | ret=tcs_endoflinerule
  | ret=tcs_multilinerule)
  {
ret2=ret;
 }
  ;


tcs_wordrule returns[Object ret2] @init{List<String> metaType=list("TCS","WordRule");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFBB4992333D11DF929CDD40A9FE17A4");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB4993333D11DF8803DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB4994333D11DFC342DD40A9FE17A4");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB4995333D11DFA2F1DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB4997333D11DF96E6DD40A9FE17A4");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB4998333D11DF9CC5DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB4999333D11DF9549DD40A9FE17A4");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB499A333D11DFA573DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB499C333D11DF9E7FDD40A9FE17A4");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB49A6333D11DFC128DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFBB49A0333D11DFA0FADD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB49A1333D11DF9E17DD40A9FE17A4");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB49A2333D11DFA795DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB49A4333D11DFCC41DD40A9FE17A4");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBB49A7333D11DFC21FDD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_endoflinerule returns[Object ret2] @init{List<String> metaType=list("TCS","EndOfLineRule");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFBDBA90333D11DF83BDDD40A9FE17A4");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBDBA91333D11DF8B24DD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBDBA92333D11DF8E77DD40A9FE17A4");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBDBA93333D11DF9A55DD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBDBA99333D11DFA0EBDD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFBDBA97333D11DFC2CEDD40A9FE17A4");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBDBA9B333D11DF9821DD40A9FE17A4");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFBDBA9C333D11DF8383DD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_multilinerule returns[Object ret2] @init{List<String> metaType=list("TCS","MultiLineRule");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC00480333D11DF8439DD40A9FE17A4");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC00481333D11DFB83EDD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC00482333D11DF87CCDD40A9FE17A4");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC00483333D11DF961BDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC00489333D11DF8892DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFC00487333D11DF945FDD40A9FE17A4");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0048B333D11DFCFAADD40A9FE17A4");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0048C333D11DFBBF2DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0048D333D11DFAFFBDD40A9FE17A4");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0048E333D11DF9C3FDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC00494333D11DFB683DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFC00492333D11DFAEAADD40A9FE17A4");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC00496333D11DF95DFDD40A9FE17A4");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC27584333D11DFA7EADD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFC0049A333D11DF9665DD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0049B333D11DF9B39DD40A9FE17A4");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0049C333D11DF84CBDD40A9FE17A4");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC0049E333D11DF8034DD40A9FE17A4");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC27582333D11DFC764DD40A9FE17A4");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDFFC004A2333D11DFCA4FDD40A9FE17A4");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC004A3333D11DFB15CDD40A9FE17A4");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC004A8333D11DFB900DD40A9FE17A4");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDFFC004A5333D11DF905BDD40A9FE17A4");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC27580333D11DF9852DD40A9FE17A4");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC27585333D11DFB222DD40A9FE17A4");} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_mapping returns[Object ret2]
  :
  (ret=tcs_simplemapping
  | ret=tcs_wildcardmapping
  | ret=tcs_octalmapping
  | ret=tcs_hexadecimalmapping)
  {
ret2=ret;
 }
  ;


tcs_simplemapping returns[Object ret2] @init{List<String> metaType=list("TCS","SimpleMapping");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC4BF71333D11DF9876DD40A9FE17A4");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC4BF72333D11DF9B3ADD40A9FE17A4");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC4BF74333D11DF9610DD40A9FE17A4");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_wildcardmapping returns[Object ret2] @init{List<String> metaType=list("TCS","WildcardMapping");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC73070333D11DFA2BADD40A9FE17A4");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC73071333D11DFB30ADD40A9FE17A4");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC73072333D11DF90E0DD40A9FE17A4");} POINT {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_octalmapping returns[Object ret2] @init{List<String> metaType=list("TCS","OctalMapping");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC73076333D11DFCDB3DD40A9FE17A4");}'octal'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_hexadecimalmapping returns[Object ret2] @init{List<String> metaType=list("TCS","HexadecimalMapping");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC7307A333D11DFBE18DD40A9FE17A4");}'hex'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_stringpattern returns[Object ret2] @init{List<String> metaType=list("TCS","StringPattern");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC9A172333D11DFCC01DD40A9FE17A4");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_classpattern returns[Object ret2] @init{List<String> metaType=list("TCS","ClassPattern");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDFFC9A176333D11DF8FE7DD40A9FE17A4");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC9A178333D11DF8E1EDD40A9FE17A4");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDFFC9A179333D11DFBB36DD40A9FE17A4");} RSQUARE {_afterSeqEl();})
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

        