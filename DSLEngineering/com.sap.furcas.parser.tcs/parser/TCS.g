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
import com.sap.mi.textual.moinlookup.util.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
   private static final String syntaxUUID = "E0DCF6CD35B822E00F2911DF80C7EEEE93CCC8E1";
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
  | 'part' {ret = "part";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'refersTo' {ret = "refersTo";}
  | 'omitted' {ret = "omitted";}
  | 'importContext' {ret = "importContext";}
  | 'template' {ret = "template";}
  | 'drop' {ret = "drop";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'lexer' {ret = "lexer";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'when' {ret = "when";}
  | 'query' {ret = "query";}
  | 'foreach' {ret = "foreach";}
  | 'partial' {ret = "partial";}
  | 'leftNone' {ret = "leftNone";}
  | 'start' {ret = "start";}
  | 'isDefined' {ret = "isDefined";}
  | 'lookIn' {ret = "lookIn";}
  | 'esc' {ret = "esc";}
  | 'invert' {ret = "invert";}
  | 'default' {ret = "default";}
  | 'separator' {ret = "separator";}
  | 'multiLine' {ret = "multiLine";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'filter' {ret = "filter";}
  | 'deep' {ret = "deep";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'all' {ret = "all";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'function' {ret = "function";}
  | 'rightNone' {ret = "rightNone";}
  | 'keywords' {ret = "keywords";}
  | 'priority' {ret = "priority";}
  | 'false' {ret = "false";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'octal' {ret = "octal";}
  | 'mode' {ret = "mode";}
  | 'true' {ret = "true";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'abstract' {ret = "abstract";}
  | 'context' {ret = "context";}
  | 'symbols' {ret = "symbols";}
  | 'auto' {ret = "auto";}
  | 'word' {ret = "word";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'always' {ret = "always";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'multi' {ret = "multi";}
  | 'main' {ret = "main";}
  | 'addToContext' {ret = "addToContext";}
  | 'semDisambiguate' {ret = "semDisambiguate";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'prefix' {ret = "prefix";}
  | 'for' {ret = "for";}
  | 'one' {ret = "one";}
  | 'left' {ret = "left";}
  | 'postfix' {ret = "postfix";}
  | 'syntax' {ret = "syntax";}
  | 'operatored' {ret = "operatored";}
  | 'hex' {ret = "hex";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'endNL' {ret = "endNL";}
  | 'and' {ret = "and";}
  | 'end' {ret = "end";}
  | 'right' {ret = "right";}
  | 'token' {ret = "token";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'createIn' {ret = "createIn";}
  | 'k' {ret = "k";}
  | 'value' {ret = "value";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'source' {ret = "source";}
  | 'as' {ret = "as";}
  | 'never' {ret = "never";}
  | 'using' {ret = "using";}
  | 'startNL' {ret = "startNL";}
  | 'nbNL' {ret = "nbNL";}
  | 'operators' {ret = "operators";}
  | 'createAs' {ret = "createAs";}
  | 'serializer' {ret = "serializer";})
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
  ({_beforeSeqEl("E0DCF6CD32F532500F2911DFAA12EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD32D17DB00F2911DFB3BBEEEE93CCC8E1");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD32DAF3900F2911DFAE80EEEE93CCC8E1");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD32DD64910F2911DFBA4EEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD32F2C1510F2911DFB83BEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD332012E10F2911DFCC1FEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3324CDD20F2911DF9809EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CD3343C7800F2911DF8D9CEEEE93CCC8E1");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD334611710F2911DFAAEBEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3346117C0F2911DF96C6EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD334611750F2911DF8EE2EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD334611760F2911DFB96FEEEE93CCC8E1");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD334611770F2911DFC2CCEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD334611790F2911DF88C2EEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3346117A0F2911DF8EA5EEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3346117D0F2911DFB195EEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD337363000F2911DFC06DEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD3346117F0F2911DF82CEEEEE93CCC8E1");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335924420F2911DF81E4EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD334882710F2911DFB34AEEEE93CCC8E1");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD334882720F2911DF9C57EEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD334D3D600F2911DFB9FCEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD334882740F2911DFB449EEEE93CCC8E1");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335924400F2911DF9678EEEE93CCC8E1");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335B954B0F2911DF85E9EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD335B95430F2911DFCFB6EEEE93CCC8E1");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335B95440F2911DF96EDEEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335B95480F2911DF8D33EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD335B95460F2911DFB8DCEEEE93CCC8E1");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335B95490F2911DFBD3EEEEE93CCC8E1");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335B954D0F2911DFA6B1EEEE93CCC8E1");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335B954F0F2911DFAB08EEEE93CCC8E1");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3369C6120F2911DF88C7EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD335DDF330F2911DF9A47EEEE93CCC8E1");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD335DDF340F2911DFA233EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33629A200F2911DFBA61EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3369C6100F2911DF96FAEEEE93CCC8E1");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3375ACF00F2911DFCEDFEEEE93CCC8E1");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CD33864EC20F2911DFA4FBEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33781DF40F2911DF802CEEEE93CCC8E1");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD33781DF60F2911DF94EEEEEE93CCC8E1");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33864EC00F2911DFB152EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD33781DF80F2911DFC93EEEEE93CCC8E1");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD339717A00F2911DFC96FEEEE93CCC8E1");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD339717A20F2911DFC2FDEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD339717A30F2911DF9015EEEE93CCC8E1");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD339717A40F2911DFCD53EEEE93CCC8E1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A08D830F2911DFCE64EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33A08D810F2911DF9976EEEE93CCC8E1");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE800F2911DFAA2AEEEE93CCC8E1");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE820F2911DF83AAEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE880F2911DFC59BEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33A2FE860F2911DFAE62EEEE93CCC8E1");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE890F2911DFC7A7EEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE8A0F2911DFB5F7EEEE93CCC8E1");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE8B0F2911DF8834EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE8E0F2911DF991EEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE990F2911DF9055EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33A2FE920F2911DFB14DEEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE930F2911DFAC08EEEE93CCC8E1");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE940F2911DF8103EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE970F2911DF91EDEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33A2FE9A0F2911DFC6EFEEEE93CCC8E1");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33AA03600F2911DFA173EEEE93CCC8E1");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD33BD16300F2911DF8DE4EEEE93CCC8E1");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33BD16310F2911DFCF3AEEEE93CCC8E1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33BD16370F2911DFA4E9EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33BD16350F2911DFAFE9EEEE93CCC8E1");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33CB6E170F2911DFB73FEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33CB6E130F2911DF9E12EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33BD163B0F2911DFA2D0EEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33CB6E100F2911DFAE52EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33BF87300F2911DF9449EEEE93CCC8E1");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD33BD163D0F2911DFAE3DEEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33CB6E110F2911DFCFF8EEEE93CCC8E1");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD33CB6E150F2911DFC287EEEE93CCC8E1");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33CB6E1A0F2911DFBFA5EEEE93CCC8E1");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD33CDB8010F2911DFA7BCEEEE93CCC8E1");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33CDB8020F2911DFB808EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33CDB8040F2911DF800CEEEE93CCC8E1");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD33D029000F2911DF9930EEEE93CCC8E1");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D029010F2911DFBEB9EEEE93CCC8E1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E33BD10F2911DFC8D1EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D029050F2911DFC1B6EEEE93CCC8E1");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD33D29A070F2911DFA3C1EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D29A030F2911DF9D64EEEE93CCC8E1");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D29A050F2911DFAE31EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D29A130F2911DF94D1EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D29A0B0F2911DF8021EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D29A0C0F2911DFA6B5EEEE93CCC8E1");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D29A0D0F2911DFC081EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D29A100F2911DFC15FEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D29A110F2911DF851FEEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3F80F2911DFAE26EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D4E3F00F2911DFCBD3EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3F10F2911DF929EEEEE93CCC8E1");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3F20F2911DFBB18EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3F50F2911DF8468EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3F60F2911DFAD35EEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E4040F2911DFB5D7EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D4E3FC0F2911DFAADBEEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3FD0F2911DFA712EEEE93CCC8E1");}'semDisambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E3FE0F2911DF88BDEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E4010F2911DFBE80EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "semDisambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E4020F2911DF8CC3EEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D4E40A0F2911DFB2AFEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D4E4080F2911DF8F9EEEEE93CCC8E1");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D754F50F2911DF8BA8EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D754F30F2911DFC6E8EEEE93CCC8E1");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D755010F2911DFBF0EEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D754FE0F2911DFC92DEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D754FC0F2911DF8375EEEE93CCC8E1");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33D754FF0F2911DFA4AEEEEE93CCC8E1");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33DE80E50F2911DFAAEFEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D755050F2911DFCF19EEEE93CCC8E1");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33DE80E30F2911DFCA31EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33D755090F2911DF89E9EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33DE80E00F2911DFAE51EEEE93CCC8E1");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33DE80E10F2911DFA42CEEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CAD30F2911DFB7A7EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33DE80E90F2911DF8288EEEE93CCC8E1");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CAD10F2911DFAEA5EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33DE80EE0F2911DFB0C5EEEE93CCC8E1");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CAD90F2911DFB1F8EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33E0CAD70F2911DF944AEEEE93CCC8E1");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CADF0F2911DFABB6EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33E0CADD0F2911DFBE70EEEE93CCC8E1");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CAED0F2911DF860FEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33E0CAE30F2911DF8CB4EEEE93CCC8E1");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CAEB0F2911DFA13EEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33E0CAE40F2911DF8335EEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E0CAE90F2911DFA2FEEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33E0CAE60F2911DFB992EEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E585C40F2911DFC23CEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33E585C00F2911DF9937EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33E33BD50F2911DF9570EEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E33BDA0F2911DFCA94EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33E33BD70F2911DFCCC0EEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E33BDB0F2911DFCF1EEEEE93CCC8E1");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD33E585C20F2911DFA3A7EEEE93CCC8E1");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33E585C70F2911DFC4A3EEEE93CCC8E1");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD33F64EA00F2911DF99F5EEEE93CCC8E1");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA10F2911DF8810EEEE93CCC8E1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA20F2911DF8CF5EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA30F2911DFCABBEEEE93CCC8E1");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA40F2911DFB8FAEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA70F2911DF95A2EEEE93CCC8E1");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA80F2911DF891FEEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EA90F2911DFCA38EEEE93CCC8E1");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EAA0F2911DFCAF0EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EAC0F2911DF8250EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EB60F2911DF8A6DEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33F64EB00F2911DFB023EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EB10F2911DFAC36EEEE93CCC8E1");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EB20F2911DF806AEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EB40F2911DFC610EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898930F2911DFA217EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33F64EBA0F2911DF8324EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EBB0F2911DFADE6EEEE93CCC8E1");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F64EBC0F2911DF95EEEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898910F2911DFC6DFEEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F8989E0F2911DF80CAEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33F898970F2911DFB0D3EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898980F2911DFA757EEEE93CCC8E1");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898990F2911DFAAA5EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F8989C0F2911DF9540EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898A90F2911DF88D9EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33F898A20F2911DF8431EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898A30F2911DFB2FEEEEE93CCC8E1");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898A40F2911DFA9C8EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898A70F2911DF8376EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33F898AA0F2911DFAC12EEEE93CCC8E1");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FB099E0F2911DFB671EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33F898AE0F2911DF9C46EEEE93CCC8E1");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD33FB099C0F2911DFAC2EEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33FB09930F2911DF86CFEEEE93CCC8E1");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FB099A0F2911DF8B0AEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33FB09980F2911DF9F8BEEEE93CCC8E1");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FB09AE0F2911DFA969EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD33FB09AA0F2911DF8E0BEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33FB09A20F2911DFC2FAEEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FB09A70F2911DFCAFAEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33FB09A40F2911DF9406EEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FB09A80F2911DFAF9CEEEE93CCC8E1");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD33FB09AC0F2911DFA72DEEEE93CCC8E1");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FB09B10F2911DF86BDEEEE93CCC8E1");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD33FD53820F2911DF80D7EEEE93CCC8E1");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FD53840F2911DFA92BEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FD53850F2911DF9BB1EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FD53860F2911DF9A6FEEEE93CCC8E1");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FD53870F2911DF8B88EEEE93CCC8E1");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FFC4840F2911DF98F5EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33FD53880F2911DFCCFAEEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FFC4810F2911DFC303EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD33FD538A0F2911DF9811EEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD33FFC4820F2911DFC8DEEEEE93CCC8E1");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD33FFC4880F2911DF9D7EEEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD340235810F2911DFCFDFEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD33FFC48A0F2911DF829EEEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD340235820F2911DFBD31EEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD340235870F2911DF9D91EEEE93CCC8E1");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

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
  ({_beforeSeqEl("E0DCF6CD343B46E00F2911DFA498EEEE93CCC8E1");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3450CAB00F2911DFB413EEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD346627760F2911DFA774EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD3463B6720F2911DFA2EEEEEE93CCC8E1");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD346627710F2911DFC74BEEEE93CCC8E1");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346627740F2911DFC661EEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD3466277B0F2911DFA78AEEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3468987B0F2911DF8DF1EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD346898730F2911DFCF8CEEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346898780F2911DFAE2DEEEE93CCC8E1");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD346898750F2911DF9A6EEEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346898790F2911DFA37CEEEE93CCC8E1");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3468987E0F2911DF9D75EEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD346898820F2911DFB874EEEE93CCC8E1");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346898840F2911DFA7C9EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346898850F2911DF9CEFEEEE93CCC8E1");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346AE2620F2911DFB79EEEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD346AE2660F2911DF872CEEEE93CCC8E1");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346AE2680F2911DFB3CEEEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346AE2690F2911DFA61AEEEE93CCC8E1");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D53620F2911DFBCD8EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD346AE26D0F2911DF87EBEEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346AE2720F2911DF98C3EEEE93CCC8E1");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD346AE26F0F2911DFA3B9EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D53600F2911DFBFA4EEEE93CCC8E1");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D53650F2911DFCB76EEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD346D53690F2911DF9CECEEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D536B0F2911DFAFCEEEEE93CCC8E1");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D536C0F2911DFC815EEEE93CCC8E1");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D536E0F2911DFB7F4EEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D53760F2911DF8C38EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD346D53720F2911DFAA81EEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346D53740F2911DFBF69EEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346F9D500F2911DF80B3EEEE93CCC8E1");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346F9D530F2911DFAB0FEEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD346F9D570F2911DFCC71EEEE93CCC8E1");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346F9D5C0F2911DF908FEEEE93CCC8E1");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD346F9D590F2911DF9371EEEE93CCC8E1");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346F9D5D0F2911DF8E68EEEE93CCC8E1");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346F9D630F2911DFB18DEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD346F9D610F2911DF8554EEEE93CCC8E1");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD346F9D660F2911DF85F4EEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34720E5C0F2911DF8CCDEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34720E550F2911DFC514EEEE93CCC8E1");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34720E560F2911DF9781EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34720E590F2911DF9078EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34720E5A0F2911DFB7B6EEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34747F510F2911DFC68DEEEE93CCC8E1");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34747F550F2911DF94DAEEEE93CCC8E1");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34747F580F2911DF95D9EEEE93CCC8E1");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34747F5B0F2911DFB91FEEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3476C9400F2911DFB8D0EEEE93CCC8E1");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3476C9450F2911DFAB24EEEE93CCC8E1");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD3476C9420F2911DFACF8EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3476C9460F2911DFBA4CEEEE93CCC8E1");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3476C9490F2911DFA0C6EEEE93CCC8E1");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34793A440F2911DFAFD4EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347B84350F2911DF94DCEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD347B84310F2911DF8A32EEEE93CCC8E1");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD347B84330F2911DFB652EEEE93CCC8E1");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347B84370F2911DFA745EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD347B843C0F2911DFAEB5EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347B84440F2911DFB029EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD347B84400F2911DFC208EEEE93CCC8E1");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD347B84420F2911DF89ABEEEE93CCC8E1");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5300F2911DF990DEEEE93CCC8E1");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5310F2911DFBF18EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5340F2911DFA11AEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5350F2911DFC7A8EEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD347DF53A0F2911DFB723EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5420F2911DFB21DEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD347DF53E0F2911DF928EEEEE93CCC8E1");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD347DF5400F2911DFC5A9EEEE93CCC8E1");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5430F2911DFAD3CEEEE93CCC8E1");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5440F2911DFB988EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD347DF5470F2911DFC102EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3480663A0F2911DFA82BEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD348066330F2911DF89DDEEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348066340F2911DFB2B7EEEE93CCC8E1");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348066350F2911DF90B8EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348066380F2911DF9C7EEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348066450F2911DF9C18EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD3480663E0F2911DFC6D0EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348066430F2911DFC250EEEE93CCC8E1");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD348066400F2911DF9EA6EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348066460F2911DF9994EEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3482B02A0F2911DF9A9CEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD3482B0230F2911DFC41CEEEE93CCC8E1");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0240F2911DFB709EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0270F2911DFA196EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0280F2911DFAD01EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0350F2911DF9110EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD3482B02E0F2911DFAC76EEEE93CCC8E1");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B02F0F2911DFB702EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0320F2911DF9206EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0330F2911DFAD59EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0360F2911DF903CEEEE93CCC8E1");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B0370F2911DFA20FEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3482B03C0F2911DF829CEEEE93CCC8E1");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD348521220F2911DFB298EEEE93CCC8E1");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348521230F2911DFC52FEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD348521260F2911DF8C71EEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34876B100F2911DFC9EEEEEE93CCC8E1");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34876B110F2911DFC7DAEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A1A9DB0F2911DFB735EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34A1A9D10F2911DFA88AEEEE93CCC8E1");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A1A9D20F2911DF87EAEEEE93CCC8E1");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD34A1A9D90F2911DFBABEEEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD34A1A9D60F2911DF87D7EEEE93CCC8E1");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD34A41AD20F2911DFB1D1EEEE93CCC8E1");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A41AD30F2911DF861FEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A41AD90F2911DFADDBEEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD34A41AD60F2911DFCFB3EEEE93CCC8E1");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34A664C20F2911DF9972EEEE93CCC8E1");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A664C30F2911DF932BEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A664C80F2911DF89ADEEEE93CCC8E1");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34A8D5C00F2911DFA9A9EEEE93CCC8E1");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A8D5C10F2911DF9C21EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A8D5C30F2911DF9D3AEEEE93CCC8E1");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34A8D5C70F2911DFCBB4EEEE93CCC8E1");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A8D5C80F2911DF9A9AEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34A8D5CB0F2911DFA6C1EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34AB1FB00F2911DF8415EEEE93CCC8E1");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34AB1FB10F2911DF9B70EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34AB1FB30F2911DF996BEEEE93CCC8E1");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD34B24BA00F2911DFA1D5EEEE93CCC8E1");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CD34C55E710F2911DF9917EEEE93CCC8E1");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CD34C7CF710F2911DFCD80EEEE93CCC8E1");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CD34D600400F2911DFA67FEEEE93CCC8E1");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34D600440F2911DFB96AEEEE93CCC8E1");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34D871400F2911DFA81BEEEE93CCC8E1");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34D871410F2911DF8534EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34D871430F2911DFB0FFEEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34D871470F2911DFC85DEEEE93CCC8E1");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34D871480F2911DF8B9AEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34D8714A0F2911DFB123EEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34DABB300F2911DF957EEEEE93CCC8E1");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DABB310F2911DFC0A3EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DABB370F2911DF8999EEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD34DABB340F2911DFB00BEEEE93CCC8E1");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34DABB3B0F2911DF9709EEEE93CCC8E1");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DABB3C0F2911DF9B78EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DABB3F0F2911DFB2ACEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34DD2C300F2911DF87E8EEEE93CCC8E1");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DD2C310F2911DFC2A1EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DD2C340F2911DFC2CCEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DD2C3F0F2911DFA982EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34DD2C380F2911DFB875EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DD2C390F2911DF90AFEEEE93CCC8E1");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DD2C3A0F2911DFA053EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DD2C3D0F2911DF9CE9EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD34DF9D300F2911DF9302EEEE93CCC8E1");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DF9D310F2911DFB364EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34DF9D340F2911DFA611EEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34E1E7220F2911DFA3F2EEEE93CCC8E1");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E1E7230F2911DF90DCEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E1E7250F2911DFC943EEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34E458200F2911DF888BEEEE93CCC8E1");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E458210F2911DFA25DEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E458230F2911DF9BC1EEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34E458270F2911DFA80EEEEE93CCC8E1");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E458280F2911DFB110EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E458300F2911DFCB22EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34E4582C0F2911DF9E7AEEEE93CCC8E1");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD34E4582E0F2911DF8781EEEE93CCC8E1");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD34E6A2100F2911DFCB97EEEE93CCC8E1");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E6A2110F2911DF8A43EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E6A2130F2911DF8EBCEEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34E6A2170F2911DFC6EDEEEE93CCC8E1");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E6A2180F2911DFC006EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E913120F2911DF9B0AEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34E6A21C0F2911DFAEF9EEEE93CCC8E1");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD34E913100F2911DFCCB4EEEE93CCC8E1");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD34E913170F2911DFB4FEEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E913180F2911DF8896EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E9131B0F2911DFBC8EEEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34EB84100F2911DF9546EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34E9131F0F2911DFAFACEEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34E913240F2911DFB127EEEE93CCC8E1");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD34E913210F2911DF81B7EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34EB84110F2911DF91CEEEEE93CCC8E1");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD34EB84160F2911DF8D15EEEE93CCC8E1");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CD34EB84190F2911DFC308EEEE93CCC8E1");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CD34EB841C0F2911DF88EFEEEE93CCC8E1");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CD34EB841F0F2911DF8F4AEEEE93CCC8E1");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CD34EDCE010F2911DFC4E8EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34EDCE020F2911DFBF20EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34EDCE050F2911DFBDB2EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34EDCE060F2911DF89FAEEEE93CCC8E1");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34EDCE0A0F2911DF85D8EEEE93CCC8E1");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F010F2911DF9C83EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34EDCE0F0F2911DFBEFDEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F020F2911DF88B9EEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F060F2911DFB326EEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD34F03F040F2911DFA0E6EEEE93CCC8E1");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F070F2911DF9A4BEEEE93CCC8E1");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34F03F0B0F2911DF8A08EEEE93CCC8E1");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F0D0F2911DFC695EEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F170F2911DFB426EEEE93CCC8E1");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD34F03F130F2911DFA47FEEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F150F2911DF880DEEEE93CCC8E1");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F03F180F2911DFB6B7EEEE93CCC8E1");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F288F00F2911DFCBCAEEEE93CCC8E1");}(({_beforeSeqEl("E0DCF6CD34F03F1A0F2911DFA263EEEE93CCC8E1");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F288F10F2911DFCF8FEEEE93CCC8E1");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD34F288FA0F2911DF806DEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34F288F80F2911DFB3CBEEEE93CCC8E1");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F288FC0F2911DFB433EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD34F288FD0F2911DFBD3CEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD350CC7B10F2911DFCB79EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD35059BC00F2911DF9520EEEE93CCC8E1");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD34F289030F2911DF9389EEEE93CCC8E1");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD350351D60F2911DFC9B2EEEE93CCC8E1");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD350CC7B20F2911DFA825EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD350CC7B40F2911DFB80BEEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD350F38B00F2911DF98D1EEEE93CCC8E1");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD350F38B50F2911DFBD16EEEE93CCC8E1");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CD350F38B80F2911DFB842EEEE93CCC8E1");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CD351182A60F2911DFA00EEEEE93CCC8E1");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD351182A30F2911DF89C9EEEE93CCC8E1");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3513F3A10F2911DFC2FDEEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3513F3A20F2911DFBF66EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3513F3A40F2911DFBD04EEEE93CCC8E1");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3513F3A90F2911DFAC69EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD35163D900F2911DFCE9FEEEE93CCC8E1");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD35163D910F2911DF8060EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD35163D930F2911DFC12FEEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD35163D940F2911DF9BE2EEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD35163D980F2911DFB674EEEE93CCC8E1");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD35163D990F2911DF8038EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD35163D9B0F2911DF8570EEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD35163D9C0F2911DFB1AAEEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3518AE910F2911DFA7BAEEEE93CCC8E1");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3518AE920F2911DFBDC6EEEE93CCC8E1");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3518AE970F2911DFB95EEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD3518AE940F2911DFAC67EEEE93CCC8E1");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD351B1F920F2911DF8228EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD351B1F970F2911DF902EEEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD351D69800F2911DF85ECEEEE93CCC8E1");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351D69820F2911DFC4E2EEEE93CCC8E1");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD351D69860F2911DFCCB5EEEE93CCC8E1");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351D69890F2911DFCD06EEEE93CCC8E1");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD351FDA850F2911DF8B3BEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD351FDA830F2911DFABE7EEEE93CCC8E1");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351FDA860F2911DF8321EEEE93CCC8E1");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351FDA880F2911DFB6F2EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351FDA890F2911DFBEEEEEEE93CCC8E1");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351FDA8B0F2911DF8097EEEE93CCC8E1");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD351FDA8C0F2911DFBE50EEEE93CCC8E1");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD351FDA940F2911DFA267EEEE93CCC8E1");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD351FDA910F2911DF8AC5EEEE93CCC8E1");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352224750F2911DFA24DEEEE93CCC8E1");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352495720F2911DF9C95EEEE93CCC8E1");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495730F2911DFB4F6EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495740F2911DF8E1CEEEE93CCC8E1");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495750F2911DF87CBEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495770F2911DFAB90EEEE93CCC8E1");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495780F2911DF94F0EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495790F2911DFAF14EEEE93CCC8E1");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3524957A0F2911DFC85BEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3524957C0F2911DFC65BEEEE93CCC8E1");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495860F2911DF8546EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD352495800F2911DFB057EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495810F2911DF8803EEEE93CCC8E1");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495820F2911DFA67EEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495840F2911DFB181EEEE93CCC8E1");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352495870F2911DFC7A3EEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352706700F2911DFC5F2EEEE93CCC8E1");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352706710F2911DFA650EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352706720F2911DFB6D8EEEE93CCC8E1");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352706730F2911DFA3DFEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352706790F2911DFC485EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD352706770F2911DFA51AEEEE93CCC8E1");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3527067B0F2911DF8B59EEEE93CCC8E1");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3527067C0F2911DFC625EEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352950600F2911DFBBA3EEEE93CCC8E1");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950610F2911DFC8FEEEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950620F2911DF960EEEEE93CCC8E1");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950630F2911DFCE3CEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950690F2911DFB8E6EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD352950670F2911DFB446EEEE93CCC8E1");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529506B0F2911DFA315EEEE93CCC8E1");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529506C0F2911DFB192EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529506D0F2911DF8798EEEE93CCC8E1");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529506E0F2911DFC28BEEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950740F2911DF904EEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD352950720F2911DFA6DCEEEE93CCC8E1");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950760F2911DFBC0EEEEE93CCC8E1");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529508D0F2911DFB371EEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD3529507A0F2911DFBBE2EEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529507B0F2911DF98F4EEEE93CCC8E1");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529507C0F2911DF8AE2EEEE93CCC8E1");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529507E0F2911DF9E0BEEEE93CCC8E1");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529508B0F2911DFC23BEEEE93CCC8E1");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD352950820F2911DF984AEEEE93CCC8E1");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950830F2911DFCF60EEEE93CCC8E1");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950880F2911DF8326EEEE93CCC8E1");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD352950850F2911DFA023EEEE93CCC8E1");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352950890F2911DFA70DEEEE93CCC8E1");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3529508E0F2911DFBCEEEEEE93CCC8E1");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352BC1630F2911DF9923EEEE93CCC8E1");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352BC1640F2911DF8979EEEE93CCC8E1");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352BC1660F2911DFA6DAEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352E0B500F2911DFB435EEEE93CCC8E1");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352E0B510F2911DF8C0EEEEE93CCC8E1");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD352E0B520F2911DF8790EEEE93CCC8E1");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD352E0B560F2911DFB7D6EEEE93CCC8E1");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD35307C500F2911DFC4F1EEEE93CCC8E1");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD35307C560F2911DFC4E0EEEE93CCC8E1");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD3532ED500F2911DF8913EEEE93CCC8E1");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3532ED520F2911DF820BEEEE93CCC8E1");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD3532ED530F2911DF93C5EEEE93CCC8E1");} RSQUARE {_afterSeqEl();})
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

        