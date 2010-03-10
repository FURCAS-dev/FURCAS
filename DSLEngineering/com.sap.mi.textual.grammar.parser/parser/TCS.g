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
   private static final String syntaxUUID = "E0DCF6CD76DF71431AFC11DFBDD1E3828D1504C0";
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
  | 'and' {ret = "and";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'all' {ret = "all";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'foreach' {ret = "foreach";}
  | 'leftNone' {ret = "leftNone";}
  | 'multi' {ret = "multi";}
  | 'function' {ret = "function";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'importContext' {ret = "importContext";}
  | 'partial' {ret = "partial";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'keywords' {ret = "keywords";}
  | 'part' {ret = "part";}
  | 'isDefined' {ret = "isDefined";}
  | 'octal' {ret = "octal";}
  | 'serializer' {ret = "serializer";}
  | 'end' {ret = "end";}
  | 'addToContext' {ret = "addToContext";}
  | 'default' {ret = "default";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'startNL' {ret = "startNL";}
  | 'template' {ret = "template";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'k' {ret = "k";}
  | 'one' {ret = "one";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'context' {ret = "context";}
  | 'true' {ret = "true";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'drop' {ret = "drop";}
  | 'endNL' {ret = "endNL";}
  | 'createAs' {ret = "createAs";}
  | 'refersTo' {ret = "refersTo";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'left' {ret = "left";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'start' {ret = "start";}
  | 'right' {ret = "right";}
  | 'nbNL' {ret = "nbNL";}
  | 'symbols' {ret = "symbols";}
  | 'hex' {ret = "hex";}
  | 'using' {ret = "using";}
  | 'always' {ret = "always";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'PartitionHandling' {ret = "PartitionHandling";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'main' {ret = "main";}
  | 'multiLine' {ret = "multiLine";}
  | 'word' {ret = "word";}
  | 'esc' {ret = "esc";}
  | 'rightNone' {ret = "rightNone";}
  | 'source' {ret = "source";}
  | 'filter' {ret = "filter";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'name' {ret = "name";}
  | 'deep' {ret = "deep";}
  | 'token' {ret = "token";}
  | 'invert' {ret = "invert";}
  | 'createIn' {ret = "createIn";}
  | 'never' {ret = "never";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'semDisambiguate' {ret = "semDisambiguate";}
  | 'content' {ret = "content";}
  | 'false' {ret = "false";}
  | 'as' {ret = "as";}
  | 'mode' {ret = "mode";}
  | 'for' {ret = "for";}
  | 'textblocks' {ret = "textblocks";}
  | 'lexer' {ret = "lexer";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'abstract' {ret = "abstract";}
  | 'value' {ret = "value";}
  | 'operators' {ret = "operators";}
  | 'operatored' {ret = "operatored";}
  | 'auto' {ret = "auto";}
  | 'separator' {ret = "separator";}
  | 'query' {ret = "query";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'prefix' {ret = "prefix";}
  | 'container' {ret = "container";}
  | 'syntax' {ret = "syntax";}
  | 'lookIn' {ret = "lookIn";}
  | 'model' {ret = "model";}
  | 'postfix' {ret = "postfix";}
  | 'priority' {ret = "priority";}
  | 'when' {ret = "when";}
  | 'omitted' {ret = "omitted";})
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
  ({_beforeSeqEl("E0DCF6CD75FD4EA31AFC11DFA9FBE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD75F3D8C21AFC11DF909EE3828D1504C0");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD75F893B01AFC11DFA904E3828D1504C0");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD75F893B21AFC11DF9ABAE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD75FD4EA11AFC11DF866CE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD7606C4831AFC11DF89C0E3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD760935821AFC11DFA0FCE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CD760DF0701AFC11DFBEFEE3828D1504C0");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD760DF0721AFC11DFA3ECE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061761AFC11DFC700E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD760DF0761AFC11DFA3EDE3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061701AFC11DF9B72E3828D1504C0");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061711AFC11DF9BE9E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061731AFC11DFCD06E3828D1504C0");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061741AFC11DFBF09E3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7610617D1AFC11DFB3F8E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7610617B1AFC11DFAA09E3828D1504C0");}( temp=tcs_partitionhandling {setProperty(ret, "partitionHandling", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7610617E1AFC11DF95D3E3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76178D621AFC11DFB78AE3828D1504C0");}(({_beforeSeqEl("E0DCF6CD761061801AFC11DF8194E3828D1504C0");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB621AFC11DFA859E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD761061841AFC11DF9EC4E3828D1504C0");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061851AFC11DFB7C4E3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761061891AFC11DFA087E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD761061871AFC11DFAB4BE3828D1504C0");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB601AFC11DF8864E3828D1504C0");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB6E1AFC11DFBE16E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7612AB661AFC11DFA8D5E3828D1504C0");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB671AFC11DFB19CE3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB6B1AFC11DF9726E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD7612AB691AFC11DFA873E3828D1504C0");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB6C1AFC11DF8BD5E3828D1504C0");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7612AB701AFC11DFB2E5E3828D1504C0");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76151C611AFC11DF812BE3828D1504C0");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76151C6C1AFC11DFC93DE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76151C651AFC11DF9747E3828D1504C0");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76151C661AFC11DFA4BBE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76151C691AFC11DF9DF1E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76151C6A1AFC11DFB12BE3828D1504C0");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76178D631AFC11DFAAA4E3828D1504C0");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CD761C48531AFC11DFBB93E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7619D7541AFC11DF9D68E3828D1504C0");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD7619D7561AFC11DFC22BE3828D1504C0");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD761C48511AFC11DFAFBCE3828D1504C0");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD7619D7581AFC11DFC816E3828D1504C0");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD762374401AFC11DF85A0E3828D1504C0");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762374421AFC11DFCFCAE3828D1504C0");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762374431AFC11DFC198E3828D1504C0");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762374441AFC11DFA641E3828D1504C0");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE331AFC11DF9BF5E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7625BE311AFC11DFB7B5E3828D1504C0");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE341AFC11DFC583E3828D1504C0");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE361AFC11DFB8F7E3828D1504C0");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE3C1AFC11DFC585E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7625BE3A1AFC11DFAB68E3828D1504C0");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE3D1AFC11DF8068E3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE3E1AFC11DFCB96E3828D1504C0");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE3F1AFC11DFBEE1E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE421AFC11DFAA35E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE4D1AFC11DF923AE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7625BE461AFC11DF86C8E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE471AFC11DF805BE3828D1504C0");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE481AFC11DFBBF0E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE4B1AFC11DFA467E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7625BE4E1AFC11DFBC3AE3828D1504C0");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76282F301AFC11DFC274E3828D1504C0");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD762A79201AFC11DFBAA9E3828D1504C0");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762A79211AFC11DFCA66E3828D1504C0");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762A79271AFC11DF9BDAE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD762A79251AFC11DF949BE3828D1504C0");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762CEA201AFC11DFAF48E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD762A79361AFC11DFC154E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD762A792B1AFC11DF8ABBE3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762A79331AFC11DFB4C6E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD762A79301AFC11DF96EFE3828D1504C0");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD762A792D1AFC11DF9EAFE3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762A79341AFC11DFAB6FE3828D1504C0");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD762A79381AFC11DFBDAEE3828D1504C0");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762CEA231AFC11DFB4D5E3828D1504C0");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD762CEA281AFC11DFA9A6E3828D1504C0");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762CEA291AFC11DFB18EE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762CEA2B1AFC11DF937EE3828D1504C0");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD762F5B201AFC11DF9AADE3828D1504C0");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD762F5B211AFC11DFB7F7E3828D1504C0");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1071AFC11DF9448E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD762F5B251AFC11DFC5CEE3828D1504C0");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD7631A5171AFC11DF9037E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7631A5131AFC11DFCCA0E3828D1504C0");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5151AFC11DF892AE3828D1504C0");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5231AFC11DF89BEE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7631A51B1AFC11DF9EE9E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A51C1AFC11DFB3F0E3828D1504C0");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A51D1AFC11DF95C4E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5201AFC11DF8CE3E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5211AFC11DF85A8E3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A52F1AFC11DF8E51E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7631A5271AFC11DFA74EE3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5281AFC11DFB1F0E3828D1504C0");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5291AFC11DFA7E8E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A52C1AFC11DF9E4EE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A52D1AFC11DFA9D4E3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A53B1AFC11DFA53FE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7631A5331AFC11DFBC88E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5341AFC11DF9C73E3828D1504C0");}'semDisambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5351AFC11DF9B6DE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5381AFC11DFC8D2E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "semDisambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7631A5391AFC11DFC129E3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763416151AFC11DF8E0DE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763416131AFC11DFCF4DE3828D1504C0");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7634161B1AFC11DF9115E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763416191AFC11DF9569E3828D1504C0");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763416271AFC11DFAF7DE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763416241AFC11DFCE4CE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763416221AFC11DFCD8CE3828D1504C0");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763416251AFC11DF8B88E3828D1504C0");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660051AFC11DF950CE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7634162B1AFC11DFCC4BE3828D1504C0");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660031AFC11DFB8FCE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7634162F1AFC11DFBB70E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660001AFC11DFB4CFE3828D1504C0");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660011AFC11DF982EE3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660121AFC11DFB06CE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763660091AFC11DFCA93E3828D1504C0");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660101AFC11DF9256E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7636600E1AFC11DFB62FE3828D1504C0");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763660181AFC11DF8EE4E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763660161AFC11DF896EE3828D1504C0");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7636601E1AFC11DFAA58E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7636601C1AFC11DFBE3CE3828D1504C0");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1051AFC11DFBBC4E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763660221AFC11DF8862E3828D1504C0");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1031AFC11DFB59FE3828D1504C0");}(({_beforeSeqEl("E0DCF6CD763660231AFC11DF8139E3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1011AFC11DFB408E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD763660251AFC11DFC01CE3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D10E1AFC11DF9CE9E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7638D10C1AFC11DF94E2E3828D1504C0");}( temp=tcs_partitionhandling {setProperty(ret, "partitionHandling", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D11E1AFC11DFC076E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7638D11A1AFC11DFAD31E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD7638D1121AFC11DFCC0FE3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1171AFC11DFBB89E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD7638D1141AFC11DFC67DE3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1181AFC11DF9C49E3828D1504C0");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD7638D11C1AFC11DFC234E3828D1504C0");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7638D1211AFC11DF8E42E3828D1504C0");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_partitionhandling returns[Object ret2] @init{List<String> metaType=list("TCS","PartitionHandling");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CD763D8BF01AFC11DF8CCAE3828D1504C0");}'PartitionHandling'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8BF11AFC11DF8628E3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763FFCF01AFC11DFB68FE3828D1504C0");}(({_beforeSeqEl("E0DCF6CD763D8BFB1AFC11DF8F3AE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763D8BF51AFC11DFB1F9E3828D1504C0");}'name'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8BF61AFC11DFCD92E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8BF81AFC11DF907CE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8BF91AFC11DF8906E3828D1504C0");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C021AFC11DF942DE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763D8BFF1AFC11DF9283E3828D1504C0");}'auto'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C001AFC11DFC726E3828D1504C0");} COMA {_afterSeqEl();}){setProperty(ret, "isAutomaticPartition", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAutomaticPartition", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C0C1AFC11DF919EE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763D8C061AFC11DF9345E3828D1504C0");}'container'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C071AFC11DFAC3EE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C091AFC11DF8416E3828D1504C0");}( temp=identifier {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C0A1AFC11DFA4FFE3828D1504C0");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C161AFC11DFB363E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD763D8C101AFC11DFA683E3828D1504C0");}'content'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C111AFC11DFA697E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C131AFC11DFBCF5E3828D1504C0");}( temp=tcs_partitioncontentenum {setProperty(ret, "content", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763D8C141AFC11DF8D61E3828D1504C0");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD763FFCF11AFC11DFB612E3828D1504C0");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_partitioncontentenum returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD764246E11AFC11DF8412E3828D1504C0");}'all'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","PartitionContentEnum"), "all");}
 | ({_beforeSeqEl("E0DCF6CD7644B7E11AFC11DF86C9E3828D1504C0");}'model'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","PartitionContentEnum"), "model");}
 | ({_beforeSeqEl("E0DCF6CD7644B7E41AFC11DF9E8AE3828D1504C0");}'textblocks'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","PartitionContentEnum"), "textblocks");})
{
  ret2=ret;
}
  ;


tcs_operatortemplate returns[Object ret2] @init{List<String> metaType=list("TCS","OperatorTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CD764728E01AFC11DFB339E3828D1504C0");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764728E11AFC11DFCD6AE3828D1504C0");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764728E21AFC11DFA141E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764728E31AFC11DF99B3E3828D1504C0");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764728E41AFC11DF9612E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972D01AFC11DF91BAE3828D1504C0");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972D11AFC11DFC21FE3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972D21AFC11DFA515E3828D1504C0");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972D31AFC11DF89B7E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972D51AFC11DF8048E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972DF1AFC11DFB4A4E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764972D91AFC11DFA665E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972DA1AFC11DF9AABE3828D1504C0");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972DB1AFC11DFA85DE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972DD1AFC11DF8CEBE3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972E91AFC11DFA4E2E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764972E31AFC11DFB234E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972E41AFC11DFABC6E3828D1504C0");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972E51AFC11DFC966E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972E71AFC11DFCDCAE3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972F41AFC11DFBAD6E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764972ED1AFC11DF972AE3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972EE1AFC11DFAE3DE3828D1504C0");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972EF1AFC11DFACB9E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972F21AFC11DFB94DE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972FF1AFC11DF9CF2E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764972F81AFC11DFBAF1E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972F91AFC11DF9FDAE3828D1504C0");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972FA1AFC11DFA611E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764972FD1AFC11DF8C53E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764973001AFC11DF8315E3828D1504C0");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764BE3E01AFC11DF9C35E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764BE3D01AFC11DFC14CE3828D1504C0");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD764BE3DE1AFC11DFA95BE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764BE3D51AFC11DFCFC4E3828D1504C0");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764BE3DC1AFC11DFA6E3E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764BE3DA1AFC11DF8ADDE3828D1504C0");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764BE3F01AFC11DF92E4E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD764BE3EC1AFC11DF869FE3828D1504C0");}(({_beforeSeqEl("E0DCF6CD764BE3E41AFC11DFCB59E3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764BE3E91AFC11DF8FA1E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD764BE3E61AFC11DF8D00E3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764BE3EA1AFC11DFBA36E3828D1504C0");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD764BE3EE1AFC11DFC53AE3828D1504C0");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD764BE3F31AFC11DF8B5BE3828D1504C0");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD765EF6A01AFC11DF9FA7E3828D1504C0");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6A21AFC11DF99A1E3828D1504C0");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6A31AFC11DF92BDE3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6A41AFC11DF9B8EE3828D1504C0");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6A51AFC11DF8A5FE3828D1504C0");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6AE1AFC11DFCAEFE3828D1504C0");}(({_beforeSeqEl("E0DCF6CD765EF6A61AFC11DF9678E3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6AB1AFC11DFC89AE3828D1504C0");}(({_beforeSeqEl("E0DCF6CD765EF6A81AFC11DF8259E3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD765EF6AC1AFC11DF8E82E3828D1504C0");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD766140901AFC11DFC406E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD766140951AFC11DF87FAE3828D1504C0");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD766140921AFC11DF96B0E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD766140961AFC11DF825DE3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7661409B1AFC11DFBCD4E3828D1504C0");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76686C811AFC11DF9AF2E3828D1504C0");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD766ADD801AFC11DF9159E3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD766F98791AFC11DFB86AE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD766F98721AFC11DFA2C1E3828D1504C0");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD766F98741AFC11DF97D4E3828D1504C0");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD766F98771AFC11DF9960E3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD7671E2611AFC11DFC32EE3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7671E26D1AFC11DFC80FE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7671E2651AFC11DFC3F1E3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7671E26A1AFC11DF9400E3828D1504C0");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD7671E2671AFC11DFB337E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7671E26B1AFC11DFCFE5E3828D1504C0");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7671E2701AFC11DFB340E3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD767453601AFC11DFC284E3828D1504C0");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767453621AFC11DFB39BE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767453631AFC11DF8C57E3828D1504C0");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767453661AFC11DF9F82E3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7674536A1AFC11DFBA3AE3828D1504C0");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7674536C1AFC11DF8CB8E3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7674536D1AFC11DF8371E3828D1504C0");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767453791AFC11DFB9D8E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD767453711AFC11DFA23EE3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767453761AFC11DF8BAFE3828D1504C0");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD767453731AFC11DF9329E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767453771AFC11DFC1C7E3828D1504C0");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7674537C1AFC11DFB09EE3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7676C4621AFC11DFC138E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C4641AFC11DFB75BE3828D1504C0");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C4651AFC11DFCB65E3828D1504C0");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C4671AFC11DFA2B2E3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C46F1AFC11DFCD5DE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7676C46B1AFC11DFACC6E3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C46D1AFC11DFB788E3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C4701AFC11DFAAD8E3828D1504C0");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7676C4731AFC11DFBA43E3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76790E501AFC11DF96A3E3828D1504C0");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E551AFC11DFCA22E3828D1504C0");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD76790E521AFC11DFC6F5E3828D1504C0");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E561AFC11DFC76FE3828D1504C0");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E5C1AFC11DF8CA4E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76790E5A1AFC11DF83A2E3828D1504C0");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E5F1AFC11DF8F3DE3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76790E6D1AFC11DF94BDE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76790E661AFC11DF8D75E3828D1504C0");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E671AFC11DFBF92E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E6A1AFC11DF8605E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76790E6B1AFC11DFA2F1E3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767B7F511AFC11DF94B8E3828D1504C0");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD767B7F551AFC11DFA4B0E3828D1504C0");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767B7F581AFC11DFAB0AE3828D1504C0");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767B7F5B1AFC11DFBB22E3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD767B7F5F1AFC11DF8E19E3828D1504C0");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767B7F641AFC11DFB241E3828D1504C0");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD767B7F611AFC11DF8CC7E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767B7F651AFC11DFC427E3828D1504C0");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD767B7F681AFC11DFBED7E3828D1504C0");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76803A431AFC11DF94B1E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76803A4B1AFC11DFAA17E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76803A471AFC11DF87E3E3828D1504C0");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD76803A491AFC11DFB8B2E3828D1504C0");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76803A4D1AFC11DFAC80E3828D1504C0");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76803A521AFC11DF9351E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB451AFC11DFA6F3E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7682AB411AFC11DFB684E3828D1504C0");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD7682AB431AFC11DF8B07E3828D1504C0");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB461AFC11DF93D8E3828D1504C0");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB471AFC11DFA235E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB4A1AFC11DFC835E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB4B1AFC11DFB744E3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7682AB501AFC11DFCEA1E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB581AFC11DF99A0E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7682AB541AFC11DF8244E3828D1504C0");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD7682AB561AFC11DF8389E3828D1504C0");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB591AFC11DFCDB4E3828D1504C0");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB5A1AFC11DF883CE3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB5D1AFC11DFCAECE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB681AFC11DF9B30E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7682AB611AFC11DFA19EE3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB621AFC11DF8CB5E3828D1504C0");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB631AFC11DF8D4BE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7682AB661AFC11DFCC19E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5351AFC11DFA9A9E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7682AB6C1AFC11DFA1F3E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5331AFC11DF8DC4E3828D1504C0");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD7684F5301AFC11DF89D4E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5361AFC11DFB04FE3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7684F5441AFC11DFAEDEE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7684F53D1AFC11DFAFDBE3828D1504C0");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F53E1AFC11DFB914E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5411AFC11DF812EE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5421AFC11DF941BE3828D1504C0");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F54F1AFC11DFA069E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD7684F5481AFC11DFA964E3828D1504C0");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5491AFC11DF8570E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F54C1AFC11DF8F0FE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F54D1AFC11DF8D82E3828D1504C0");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7684F5501AFC11DF969DE3828D1504C0");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768766301AFC11DFC406E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768766351AFC11DF8879E3828D1504C0");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();})
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
  | ret=tcs_modeparg
  | ret=tcs_partitionhandlingparg)
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
  ({_beforeSeqEl("E0DCF6CD7687663B1AFC11DF93F8E3828D1504C0");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7687663C1AFC11DFC856E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7687663F1AFC11DF91EAE3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7689B0201AFC11DFA0CAE3828D1504C0");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7689B0211AFC11DF80DFE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768C212C1AFC11DFC951E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD768C21221AFC11DFC621E3828D1504C0");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768C21231AFC11DF83F6E3828D1504C0");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD768C212A1AFC11DF97BBE3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD768C21271AFC11DFB150E3828D1504C0");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD768E92201AFC11DF8959E3828D1504C0");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768E92211AFC11DF9F72E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768E92271AFC11DFC04EE3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD768E92241AFC11DFC126E3828D1504C0");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD768E922B1AFC11DF9E98E3828D1504C0");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768E922C1AFC11DF931EE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD768E92311AFC11DFCA1EE3828D1504C0");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7690DC101AFC11DF86FCE3828D1504C0");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7690DC111AFC11DF9FB9E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7690DC131AFC11DF874BE3828D1504C0");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7690DC171AFC11DFC179E3828D1504C0");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7690DC181AFC11DF9C8CE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7690DC1B1AFC11DFA2F7E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD7690DC1F1AFC11DF8F52E3828D1504C0");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7690DC201AFC11DFA25DE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7690DC221AFC11DFBBB5E3828D1504C0");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD76934D111AFC11DF99CCE3828D1504C0");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CD76934D141AFC11DF87A3E3828D1504C0");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CD76934D171AFC11DF9052E3828D1504C0");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CD76934D1B1AFC11DF9A5FE3828D1504C0");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76934D1F1AFC11DFCD82E3828D1504C0");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769597021AFC11DFC2C8E3828D1504C0");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769597031AFC11DFB309E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769597051AFC11DF81DFE3828D1504C0");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769808001AFC11DFB1BEE3828D1504C0");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769808011AFC11DFA7D5E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769808031AFC11DFBD50E3828D1504C0");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769808071AFC11DF8629E3828D1504C0");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769808081AFC11DFBCEEE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD7698080E1AFC11DFA0A0E3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD7698080B1AFC11DF81EAE3828D1504C0");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769A79001AFC11DF93B8E3828D1504C0");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79011AFC11DFBD83E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79041AFC11DFC041E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769A79081AFC11DFC2FAE3828D1504C0");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79091AFC11DFC8AFE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A790C1AFC11DF88BCE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79171AFC11DF9637E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD769A79101AFC11DF8A2DE3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79111AFC11DFC387E3828D1504C0");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79121AFC11DFA004E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A79151AFC11DF8FD0E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD769A791B1AFC11DFC449E3828D1504C0");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A791C1AFC11DFAC65E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769A791F1AFC11DF95DBE3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_partitionhandlingparg returns[Object ret2] @init{List<String> metaType=list("TCS","PartitionHandlingPArg");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CD769CC2F41AFC11DFA374E3828D1504C0");}( temp=tcs_partitionhandling {setProperty(ret, "partitionHandling", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769CC2FA1AFC11DF8162E3828D1504C0");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769CC2FB1AFC11DFA8A8E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769CC2FD1AFC11DFC82AE3828D1504C0");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769F33F31AFC11DFA9ACE3828D1504C0");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769F33F41AFC11DFA7B0E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769F33F61AFC11DFAABDE3828D1504C0");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD769F33FA1AFC11DF99B2E3828D1504C0");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769F33FB1AFC11DFBB81E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD769F34031AFC11DFBC9FE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD769F33FF1AFC11DFBDFAE3828D1504C0");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD769F34011AFC11DF86B4E3828D1504C0");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD76A17DE01AFC11DF9A26E3828D1504C0");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A17DE11AFC11DF88CCE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A17DE31AFC11DF9760E3828D1504C0");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76A3EEE01AFC11DFC340E3828D1504C0");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEE11AFC11DFB3D4E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEE91AFC11DFB4B2E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76A3EEE51AFC11DF8CE1E3828D1504C0");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD76A3EEE71AFC11DFC385E3828D1504C0");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD76A3EEEE1AFC11DF9352E3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEEF1AFC11DF8311E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEF21AFC11DFBB99E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEFD1AFC11DF8EA7E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76A3EEF61AFC11DFBB61E3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEFB1AFC11DFC4CCE3828D1504C0");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD76A3EEF81AFC11DFC4E4E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A3EEFE1AFC11DF85E1E3828D1504C0");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD76A65FE31AFC11DFB61BE3828D1504C0");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CD76A65FE61AFC11DFCCAAE3828D1504C0");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CD76A65FE91AFC11DFC44DE3828D1504C0");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CD76A65FEC1AFC11DFBF80E3828D1504C0");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CD76A65FF11AFC11DF987EE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A65FF21AFC11DFB241E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A65FF51AFC11DF94DBE3828D1504C0");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A65FF61AFC11DF8202E3828D1504C0");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76A8A9D01AFC11DF88F1E3828D1504C0");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9D71AFC11DFBB19E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76A8A9D51AFC11DFBEE5E3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9D81AFC11DF8DF9E3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9DC1AFC11DFCDA9E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD76A8A9DA1AFC11DF9344E3828D1504C0");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9DD1AFC11DF89F7E3828D1504C0");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76A8A9E11AFC11DF8E51E3828D1504C0");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9E31AFC11DF9A02E3828D1504C0");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9ED1AFC11DF82C6E3828D1504C0");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD76A8A9E91AFC11DFB9D1E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9EB1AFC11DFA42AE3828D1504C0");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9EE1AFC11DF95F7E3828D1504C0");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76A8A9F21AFC11DFAD22E3828D1504C0");}(({_beforeSeqEl("E0DCF6CD76A8A9F01AFC11DFCD7AE3828D1504C0");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AB1AD01AFC11DF8111E3828D1504C0");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76AB1AD91AFC11DFBA02E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76AB1AD71AFC11DFBD85E3828D1504C0");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AB1ADB1AFC11DFC2BEE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AB1ADC1AFC11DFA859E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AD8BDA1AFC11DFB914E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76AD8BD81AFC11DF9A2DE3828D1504C0");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76AB1AE21AFC11DFA0C0E3828D1504C0");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD76AD8BD61AFC11DF8191E3828D1504C0");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AD8BDB1AFC11DF9653E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AD8BDD1AFC11DF942FE3828D1504C0");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76AD8BDE1AFC11DF95CBE3828D1504C0");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD76B246C21AFC11DFCE7FE3828D1504C0");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CD76B246C51AFC11DFA07CE3828D1504C0");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CD76B490B61AFC11DFA3BFE3828D1504C0");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD76B490B31AFC11DFB6FDE3828D1504C0");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76B701B11AFC11DFAA88E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B701B21AFC11DFA66CE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B701B41AFC11DFA1EDE3828D1504C0");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76B701B91AFC11DFB973E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76B701BD1AFC11DF8890E3828D1504C0");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B701BE1AFC11DF9129E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B701C01AFC11DFA2A9E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B701C11AFC11DFB190E3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76B972B01AFC11DFB494E3828D1504C0");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B972B11AFC11DFBCE6E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B972B31AFC11DF99F8E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B972B41AFC11DF9012E3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76B972B91AFC11DF8D94E3828D1504C0");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B972BA1AFC11DF9B9DE3828D1504C0");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76B972BF1AFC11DFAF55E3828D1504C0");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD76B972BC1AFC11DF829CE3828D1504C0");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76BBBCA41AFC11DFB3A8E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76BE2DA11AFC11DFCBFBE3828D1504C0");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76BE2DA51AFC11DFB1E7E3828D1504C0");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76BE2DA71AFC11DFAABCE3828D1504C0");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76BE2DAB1AFC11DFA075E3828D1504C0");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76BE2DAE1AFC11DFC972E3828D1504C0");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76C077951AFC11DF8DDEE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C077931AFC11DF8C11E3828D1504C0");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C077961AFC11DFCDCFE3828D1504C0");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C077981AFC11DFC8ADE3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C077991AFC11DF9DBFE3828D1504C0");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C0779B1AFC11DFA2E7E3828D1504C0");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C0779C1AFC11DFA47DE3828D1504C0");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76C077A41AFC11DF828AE3828D1504C0");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD76C077A11AFC11DFBECBE3828D1504C0");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76C2E8931AFC11DF962EE3828D1504C0");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76C2E8991AFC11DFBD44E3828D1504C0");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E89A1AFC11DFB108E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E89B1AFC11DFC50FE3828D1504C0");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E89C1AFC11DFA067E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E89E1AFC11DFB99FE3828D1504C0");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E89F1AFC11DF8522E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E8A01AFC11DFCB27E3828D1504C0");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E8A11AFC11DFA70AE3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C2E8A31AFC11DFB535E3828D1504C0");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559971AFC11DFB877E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C559911AFC11DF9AEEE3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559921AFC11DF903BE3828D1504C0");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559931AFC11DFCCD5E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559951AFC11DFA0EFE3828D1504C0");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559981AFC11DFCEC0E3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76C5599C1AFC11DF9F4DE3828D1504C0");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C5599D1AFC11DFC8EEE3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C5599E1AFC11DFA3E0E3828D1504C0");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C5599F1AFC11DFB311E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559A51AFC11DF8528E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C559A31AFC11DFB30DE3828D1504C0");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559A71AFC11DF9CA4E3828D1504C0");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C559A81AFC11DF95E0E3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76C7A3801AFC11DFB6EDE3828D1504C0");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3811AFC11DFB923E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3821AFC11DF9210E3828D1504C0");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3831AFC11DFC541E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3891AFC11DFB9A4E3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C7A3871AFC11DFB3F5E3828D1504C0");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A38B1AFC11DF8051E3828D1504C0");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A38C1AFC11DFB7A6E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A38D1AFC11DFCCDEE3828D1504C0");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A38E1AFC11DFCEE2E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3941AFC11DFCFFCE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C7A3921AFC11DF9011E3828D1504C0");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3961AFC11DFBC50E3828D1504C0");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA14851AFC11DF84BCE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C7A39A1AFC11DFBC68E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A39B1AFC11DFC7A8E3828D1504C0");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A39C1AFC11DF8DB0E3828D1504C0");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A39E1AFC11DFB236E3828D1504C0");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA14831AFC11DFA3BDE3828D1504C0");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD76C7A3A21AFC11DF8017E3828D1504C0");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76C7A3A31AFC11DF8400E3828D1504C0");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA14801AFC11DFB932E3828D1504C0");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD76C7A3A51AFC11DF90D0E3828D1504C0");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA14811AFC11DFCC0BE3828D1504C0");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA14861AFC11DFC68FE3828D1504C0");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76CA148D1AFC11DFA182E3828D1504C0");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA148E1AFC11DF9B5BE3828D1504C0");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CA14901AFC11DF8F7EE3828D1504C0");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76CC5E721AFC11DFC5B2E3828D1504C0");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CC5E731AFC11DF85D0E3828D1504C0");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CC5E741AFC11DF97A3E3828D1504C0");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76CC5E781AFC11DFCAE3E3828D1504C0");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76CECF701AFC11DFA751E3828D1504C0");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76CECF761AFC11DF8096E3828D1504C0");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD76CECF7A1AFC11DF90BEE3828D1504C0");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CECF7C1AFC11DF91E9E3828D1504C0");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD76CECF7D1AFC11DF8E2EE3828D1504C0");} RSQUARE {_afterSeqEl();})
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

        