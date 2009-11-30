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
   private static final String syntaxUUID = "E0DCF6CDBDFE0460DD8A11DECF0EE5ED8D1506C3";
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
  | 'never' {ret = "never";}
  | 'source' {ret = "source";}
  | 'using' {ret = "using";}
  | 'operatored' {ret = "operatored";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'k' {ret = "k";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'end' {ret = "end";}
  | 'lookIn' {ret = "lookIn";}
  | 'true' {ret = "true";}
  | 'createIn' {ret = "createIn";}
  | 'symbols' {ret = "symbols";}
  | 'token' {ret = "token";}
  | 'filter' {ret = "filter";}
  | 'template' {ret = "template";}
  | 'octal' {ret = "octal";}
  | 'importContext' {ret = "importContext";}
  | 'separator' {ret = "separator";}
  | 'lexer' {ret = "lexer";}
  | 'start' {ret = "start";}
  | 'value' {ret = "value";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'one' {ret = "one";}
  | 'left' {ret = "left";}
  | 'hex' {ret = "hex";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'syntax' {ret = "syntax";}
  | 'invert' {ret = "invert";}
  | 'foreach' {ret = "foreach";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'keywords' {ret = "keywords";}
  | 'leftNone' {ret = "leftNone";}
  | 'serializer' {ret = "serializer";}
  | 'prefix' {ret = "prefix";}
  | 'context' {ret = "context";}
  | 'omitted' {ret = "omitted";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'false' {ret = "false";}
  | 'right' {ret = "right";}
  | 'createAs' {ret = "createAs";}
  | 'partial' {ret = "partial";}
  | 'multi' {ret = "multi";}
  | 'operators' {ret = "operators";}
  | 'as' {ret = "as";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'query' {ret = "query";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'when' {ret = "when";}
  | 'word' {ret = "word";}
  | 'always' {ret = "always";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'auto' {ret = "auto";}
  | 'isDefined' {ret = "isDefined";}
  | 'all' {ret = "all";}
  | 'endNL' {ret = "endNL";}
  | 'esc' {ret = "esc";}
  | 'deep' {ret = "deep";}
  | 'drop' {ret = "drop";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'mode' {ret = "mode";}
  | 'startNL' {ret = "startNL";}
  | 'main' {ret = "main";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'nbNL' {ret = "nbNL";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'refersTo' {ret = "refersTo";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'multiLine' {ret = "multiLine";}
  | 'for' {ret = "for";}
  | 'function' {ret = "function";}
  | 'rightNone' {ret = "rightNone";}
  | 'default' {ret = "default";}
  | 'priority' {ret = "priority";}
  | 'addToContext' {ret = "addToContext";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'part' {ret = "part";}
  | 'postfix' {ret = "postfix";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'abstract' {ret = "abstract";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'and' {ret = "and";})
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
  ({_beforeSeqEl("E0DCF6CDBC5CD780DD8A11DEC9B1E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBC4BE791DD8A11DE96B5E5ED8D1506C3");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC520210DD8A11DEB2C7E5ED8D1506C3");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC520212DD8A11DE92ECE5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBC5B50E1DD8A11DE971CE5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDBC6DA061DD8A11DEBCFDE5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBC70ADA2DD8A11DE926DE5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CDBC7CE2A0DD8A11DEA35DE5ED8D1506C3");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7CE2A2DD8A11DE99B6E5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E6947DD8A11DEC544E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBC7E6940DD8A11DEBAE8E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E6941DD8A11DE9CE1E5ED8D1506C3");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E6942DD8A11DE95D5E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E6944DD8A11DEB4BBE5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E6945DD8A11DE87B3E5ED8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E6948DD8A11DEA92DE5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8DAB81DD8A11DECD4CE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBC7E694ADD8A11DEC2EBE5ED8D1506C3");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC82FD22DD8A11DECC85E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBC7E694EDD8A11DEAECAE5ED8D1506C3");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7E694FDD8A11DEBD94E5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC7FEFE0DD8A11DEB0FAE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBC7E6951DD8A11DEB715E5ED8D1506C3");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC82FD20DD8A11DE877DE5ED8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8483CBDD8A11DEA0CAE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBC8483C3DD8A11DEB96FE5ED8D1506C3");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8483C4DD8A11DEC8CFE5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8483C8DD8A11DEAE10E5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBC8483C6DD8A11DEA80FE5ED8D1506C3");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8483C9DD8A11DEA2FEE5ED8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC860A61DD8A11DE9797E5ED8D1506C3");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC860A63DD8A11DE985CE5ED8D1506C3");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8A9E42DD8A11DE9DAFE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBC860A67DD8A11DEB8D9E5ED8D1506C3");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC860A68DD8A11DE8D88E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8917A0DD8A11DEAB15E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8A9E40DD8A11DE8BAFE5ED8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC8F3220DD8A11DE8DC4E5ED8D1506C3");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CDBC9859E0DD8A11DEBCA4E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBC93C604DD8A11DE91F1E5ED8D1506C3");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBC954CA1DD8A11DE9BA2E5ED8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBC96D340DD8A11DE9AD4E5ED8D1506C3");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBC954CA3DD8A11DECC8DE5ED8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


tcs_template returns[Object ret2]
  :
  (ret=tcs_primitivetemplate
  | ret=tcs_enumerationtemplate
  | ret=tcs_contexttemplate
  | ret=tcs_functiontemplate)
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
  ({_beforeSeqEl("E0DCF6CDBC9FFB00DD8A11DE83B6E5ED8D1506C3");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA181A1DD8A11DEA50AE5ED8D1506C3");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA181A2DD8A11DE98FCE5ED8D1506C3");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA181A3DD8A11DEB1CBE5ED8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA48EE4DD8A11DEBA08E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCA48EE2DD8A11DEACADE5ED8D1506C3");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA48EE5DD8A11DEBF7DE5ED8D1506C3");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA48EE7DD8A11DE9076E5ED8D1506C3");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA61585DD8A11DEC294E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCA61583DD8A11DEA12EE5ED8D1506C3");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA61586DD8A11DECB81E5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA61587DD8A11DECDE5E5ED8D1506C3");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA61588DD8A11DEC253E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA6158BDD8A11DE8771E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA79C24DD8A11DEB8AAE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCA6158FDD8A11DEA774E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA61590DD8A11DEBD63E5ED8D1506C3");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA61591DD8A11DEC02DE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA79C22DD8A11DEC4D5E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA79C25DD8A11DEA7E8E5ED8D1506C3");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCA922C0DD8A11DEA68FE5ED8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCADB6A0DD8A11DEA3C9E5ED8D1506C3");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCADB6A1DD8A11DEC8DFE5ED8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCADB6A7DD8A11DEB6D0E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCADB6A5DD8A11DEC9A1E5ED8D1506C3");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCB27197DD8A11DEA5D7E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCB27193DD8A11DE93DDE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCAF6453DD8A11DEA127E5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCB27190DD8A11DEA596E5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCAF6458DD8A11DEBE85E5ED8D1506C3");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBCAF6455DD8A11DE8592E5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCB27191DD8A11DE89AAE5ED8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBCB27195DD8A11DECEEEE5ED8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCB3F830DD8A11DEAD28E5ED8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCB57ED1DD8A11DEC8B2E5ED8D1506C3");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCB57ED2DD8A11DE945AE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCB57ED4DD8A11DEC279E5ED8D1506C3");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_contexttemplate returns[Object ret2]
  :
  (ret=tcs_classtemplate
  | ret=tcs_operatortemplate)
  {
ret2=ret;
 }
  ;


tcs_classtemplate returns[Object ret2] @init{List<String> metaType=list("TCS","ClassTemplate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0DCF6CDBCC02D30DD8A11DE82DAE5ED8D1506C3");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC02D31DD8A11DEABA5E5ED8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD0F610DD8A11DE8F08E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC1B3D1DD8A11DEA1F3E5ED8D1506C3");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBCC1B3DADD8A11DE93F0E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC1B3D6DD8A11DEBF50E5ED8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC1B3D8DD8A11DE86A8E5ED8D1506C3");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC4C110DD8A11DEBEE5E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC33A73DD8A11DE8489E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC33A74DD8A11DEC593E5ED8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC33A75DD8A11DEB4A7E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC33A78DD8A11DE9A13E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC33A79DD8A11DECD24E5ED8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC647B9DD8A11DECA19E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC647B1DD8A11DE91EBE5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC647B2DD8A11DEA7EDE5ED8D1506C3");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC647B3DD8A11DEC27CE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC647B6DD8A11DEA795E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC647B7DD8A11DE90D0E5ED8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC647BFDD8A11DEAD99E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC647BDDD8A11DEB0D3E5ED8D1506C3");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC7CE55DD8A11DEA01DE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC7CE53DD8A11DEC15BE5ED8D1506C3");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC7CE61DD8A11DE8B78E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC7CE5EDD8A11DEA71BE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC7CE5CDD8A11DE98B0E5ED8D1506C3");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCC7CE5FDD8A11DE9593E5ED8D1506C3");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCC6234DD8A11DECEF9E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC7CE65DD8A11DEB41FE5ED8D1506C3");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCC6232DD8A11DEC99FE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCC954F3DD8A11DEC9BAE5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCADB91DD8A11DEAEEDE5ED8D1506C3");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCC6230DD8A11DEA48AE5ED8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCDE8D1DD8A11DEC5B3E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCCC6238DD8A11DEA0D4E5ED8D1506C3");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCC623FDD8A11DEB0AEE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCCC623DDD8A11DEC4CEE5ED8D1506C3");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCDE8D7DD8A11DEBE5EE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCCDE8D5DD8A11DEBEE4E5ED8D1506C3");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCDE8DDDD8A11DEACF7E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCCDE8DBDD8A11DEB651E5ED8D1506C3");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCF6F7ADD8A11DE850DE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCCF6F70DD8A11DEA9FEE5ED8D1506C3");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCF6F78DD8A11DEA936E5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCCF6F71DD8A11DEA43AE5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCCF6F76DD8A11DEB79BE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCCF6F73DD8A11DEB615E5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD27CB6DD8A11DEC991E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCD27CB2DD8A11DE8407E5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCD0F614DD8A11DEA30EE5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD0F619DD8A11DE9EEAE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCD0F616DD8A11DEB286E5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD27CB0DD8A11DE9488E5ED8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBCD27CB4DD8A11DE839DE5ED8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD27CB9DD8A11DEB13EE5ED8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCD71090DD8A11DEC95FE5ED8D1506C3");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD89730DD8A11DECADDE5ED8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD89731DD8A11DEB607E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD89732DD8A11DE90C8E5ED8D1506C3");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCD89733DD8A11DECFF8E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DD0DD8A11DE8749E5ED8D1506C3");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DD1DD8A11DEB590E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DD2DD8A11DE9D19E5ED8D1506C3");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DD3DD8A11DE98A9E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DD5DD8A11DE8FA9E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DDFDD8A11DE8669E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDA1DD9DD8A11DEB063E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DDADD8A11DE8526E5ED8D1506C3");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DDBDD8A11DE8174E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DDDDD8A11DE8546E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA470DD8A11DEB7D8E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDA1DE3DD8A11DEB779E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DE4DD8A11DE97D5E5ED8D1506C3");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DE5DD8A11DEB50EE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDA1DE7DD8A11DE8658E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA47BDD8A11DEC511E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDBA474DD8A11DE9CF1E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA475DD8A11DEB839E5ED8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA476DD8A11DE9E81E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA479DD8A11DEBCD9E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDD2B11DD8A11DEC21AE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDBA47FDD8A11DEC6D7E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA480DD8A11DE9532E5ED8D1506C3");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA481DD8A11DEAF6CE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDBA484DD8A11DE908BE5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDD2B12DD8A11DE9AC5E5ED8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDEB1B4DD8A11DE83A0E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDD2B16DD8A11DEC99FE5ED8D1506C3");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBCDEB1B2DD8A11DE9092E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDD2B1BDD8A11DE9AB5E5ED8D1506C3");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCDEB1B0DD8A11DEA48DE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCDD2B20DD8A11DECBBDE5ED8D1506C3");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE0385FDD8A11DE840CE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBCE0385BDD8A11DEA39BE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCE03853DD8A11DE88D9E5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE03858DD8A11DEACE4E5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCE03855DD8A11DEC512E5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE03859DD8A11DEAEADE5ED8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBCE0385DDD8A11DE95B8E5ED8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE03862DD8A11DE85FDE5ED8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCE652D0DD8A11DEC52BE5ED8D1506C3");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652D2DD8A11DEBCF4E5ED8D1506C3");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652D3DD8A11DEA469E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652D4DD8A11DEC019E5ED8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652D5DD8A11DE9FADE5ED8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652DEDD8A11DE94DAE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCE652D6DD8A11DE8598E5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652DBDD8A11DE8D6FE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBCE652D8DD8A11DEAB04E5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE652DCDD8A11DEBF98E5ED8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCE96010DD8A11DEB8A6E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE96015DD8A11DEAF3DE5ED8D1506C3");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBCE96012DD8A11DEAA7AE5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCE96016DD8A11DE8D28E5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCEAE6B1DD8A11DE8192E5ED8D1506C3");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBCF71BB0DD8A11DEA42BE5ED8D1506C3");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBCFBAF90DD8A11DE93B0E5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD065DF0DD8A11DECB76E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD0350B1DD8A11DEC884E5ED8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"		  				let result = c.lookupElementExtended(?) in"+"		  				if not (result.oclIsInvalid()) then"+"		  					if(result.oclIsTypeOf(Model::Attribute) or"+"		  							result.oclIsTypeOf(Model::Reference)"+"		  							or result.oclIsTypeOf(Model::StructureField)) then"+"		  						Bag{result}	"+"		  					else 		"+"		  						c.allSupertypes()->prepend(c)->collect("+"		  							st | st.oclAsType(Model::Classifier).typedElements->select("+"		  								te | "+"		  									if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  										te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  									else		"+"		  										false "+"		  									endif"+"		  								)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"		  						)"+"		  					endif "+"		  				else	"+"		  					c.allSupertypes()->prepend(c)->collect("+"		  						st | st.oclAsType(Model::Classifier).typedElements->select("+"		  							te | "+"		  								if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  									te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  								else"+"		  									false "+"		  								endif"+"		  							)"+"		  						)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"		  					) "+"		  				endif"+"		  					");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD04D751DD8A11DE85BFE5ED8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD04D754DD8A11DE8505E5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDBD07E491DD8A11DEBB1CE5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD099242DD8A11DEB614E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD07E495DD8A11DEB017E5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD07E49ADD8A11DE8A4DE5ED8D1506C3");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD07E497DD8A11DEA1CDE5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD099240DD8A11DEB16AE5ED8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD099245DD8A11DE9B0EE5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD0B18E0DD8A11DEC998E5ED8D1506C3");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0B18E2DD8A11DE8911E5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0B18E3DD8A11DECFB5E5ED8D1506C3");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0B18E6DD8A11DE8C04E5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD0E2620DD8A11DEB9C8E5ED8D1506C3");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0E2622DD8A11DEC8FBE5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0E2623DD8A11DEA531E5ED8D1506C3");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0E262FDD8A11DEA11AE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD0E2627DD8A11DE93D4E5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0E262CDD8A11DEB5FCE5ED8D1506C3");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD0E2629DD8A11DE908EE5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0E262DDD8A11DEC70CE5ED8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD0E2632DD8A11DEA39FE5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD113360DD8A11DEC177E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD113362DD8A11DE9843E5ED8D1506C3");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD113363DD8A11DE8098E5ED8D1506C3");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD113365DD8A11DE80AFE5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD11336DDD8A11DE8D3CE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD113369DD8A11DEC599E5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD11336BDD8A11DEBF2BE5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD11336EDD8A11DE93D6E5ED8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD113371DD8A11DE9CFEE5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD12BA00DD8A11DE9DF4E5ED8D1506C3");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1440A1DD8A11DEC9A1E5ED8D1506C3");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD12BA02DD8A11DEB397E5ED8D1506C3");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1440A2DD8A11DE9F34E5ED8D1506C3");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1440A8DD8A11DEBA9EE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD1440A6DD8A11DEBDF4E5ED8D1506C3");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1440ABDD8A11DE987DE5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD174DEADD8A11DEA95EE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD174DE3DD8A11DEBC9EE5ED8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD174DE4DD8A11DEC931E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD174DE7DD8A11DE8F29E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD174DE8DD8A11DEC08BE5ED8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD174DECDD8A11DEBD22E5ED8D1506C3");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD18D480DD8A11DE8F4CE5ED8D1506C3");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1A5B20DD8A11DEAA29E5ED8D1506C3");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1A5B23DD8A11DEC0EFE5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD1BE1C0DD8A11DEC779E5ED8D1506C3");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1D6861DD8A11DE8BBBE5ED8D1506C3");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD1BE1C2DD8A11DEC9B5E5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1D6862DD8A11DEC9B1E5ED8D1506C3");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD1D6865DD8A11DEABD6E5ED8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD21FC41DD8A11DEB869E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD2382E7DD8A11DEBAA4E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD2382E3DD8A11DEBFD3E5ED8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD2382E5DD8A11DEBDADE5ED8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD2382E9DD8A11DEB4D4E5ED8D1506C3");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD250981DD8A11DEB646E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD269020DD8A11DE851AE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD250985DD8A11DEAED0E5ED8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD250987DD8A11DE9F7BE5ED8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD269021DD8A11DE84C1E5ED8D1506C3");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD269022DD8A11DE89D9E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD269025DD8A11DECE74E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD269026DD8A11DEB2F9E5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD2816C1DD8A11DE881CE5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D64DD8A11DEACEFE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD299D60DD8A11DEA323E5ED8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD299D62DD8A11DEAABEE5ED8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D65DD8A11DE8B54E5ED8D1506C3");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D66DD8A11DEA1FEE5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D69DD8A11DEB423E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D74DD8A11DE9BBEE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD299D6DDD8A11DEAEDAE5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D6EDD8A11DE852FE5ED8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D6FDD8A11DECFC7E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD299D72DD8A11DEC0A4E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD2B2408DD8A11DE836AE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD2B2401DD8A11DEA7FEE5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD2B2406DD8A11DEB93BE5ED8D1506C3");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD2B2403DD8A11DEBD84E5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD2FB7E0DD8A11DECED7E5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD313E8ADD8A11DE866FE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD313E83DD8A11DEA686E5ED8D1506C3");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD313E84DD8A11DE9D8BE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD313E87DD8A11DEB086E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD313E88DD8A11DE93C7E5ED8D1506C3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD32C527DD8A11DECA9DE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD32C520DD8A11DECC3BE5ED8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD32C521DD8A11DEA65CE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD32C524DD8A11DEAF87E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD32C525DD8A11DEAF4AE5ED8D1506C3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD32C528DD8A11DEC36CE5ED8D1506C3");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD32C529DD8A11DE919DE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD344BC0DD8A11DE9ACEE5ED8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"										and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"											->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"											->includes(self.foreachParent.propertyReference.strucfeature.type)"+"										and ("+"											if(not self.mode.oclIsUndefined()) then"+"												t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"											endif"+"										)									"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"										else"+"											false"+"										endif"+"									endif)"+"								");})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD375902DD8A11DECE75E5ED8D1506C3");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD375903DD8A11DECC5BE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD375906DD8A11DE9312E5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD3A6640DD8A11DE9C78E5ED8D1506C3");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD3A6641DD8A11DEA55CE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD3EFA25DD8A11DE9DFFE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD3D7381DD8A11DE9B27E5ED8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD3D7382DD8A11DE96DFE5ED8D1506C3");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD3EFA23DD8A11DE9352E5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD3EFA20DD8A11DEA7ACE5ED8D1506C3");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDBD4080C0DD8A11DEC321E5ED8D1506C3");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD4080C1DD8A11DE8DD2E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD4080C7DD8A11DEBEACE5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD4080C4DD8A11DE8ED8E5ED8D1506C3");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD438E00DD8A11DEA513E5ED8D1506C3");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD438E01DD8A11DEB1F4E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD438E06DD8A11DE87EAE5ED8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"										and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"											->prepend(self.property.propertyReference.strucfeature.type)"+"											->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"										and ("+"											if (not self.property.propertyArgs->select("+"													arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"												) "+"											then"+"												t.oclAsType(TCS::ClassTemplate).mode = "+"													self.property.propertyArgs->select("+"														arg | arg.oclIsTypeOf(TCS::ModePArg))"+"															.oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"													.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"											endif"+"										)"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"										else"+"											false"+"										endif"+"									endif)"+"								");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD469B40DD8A11DE8EC0E5ED8D1506C3");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD469B41DD8A11DEAEEFE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD469B43DD8A11DE8DA1E5ED8D1506C3");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD4821E0DD8A11DE8F19E5ED8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD4821E1DD8A11DEBD0DE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD4821E4DD8A11DE94ABE5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD4B2F20DD8A11DE9C64E5ED8D1506C3");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD4B2F21DD8A11DEB65FE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD4B2F23DD8A11DE8B0EE5ED8D1506C3");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDBD4FC300DD8A11DEAE67E5ED8D1506C3");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CDBD52D041DD8A11DEC8FCE5ED8D1506C3");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CDBD52D044DD8A11DE91A0E5ED8D1506C3");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CDBD576420DD8A11DEB42FE5ED8D1506C3");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD58EAC2DD8A11DEAD64E5ED8D1506C3");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD5BF800DD8A11DE893EE5ED8D1506C3");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD5BF801DD8A11DE9C3BE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD5BF803DD8A11DEB93DE5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD5D7EA0DD8A11DE8D81E5ED8D1506C3");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD5D7EA1DD8A11DE8D93E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD5D7EA3DD8A11DE81B2E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD608BE0DD8A11DEB876E5ED8D1506C3");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD608BE1DD8A11DEC69DE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD608BE7DD8A11DEB3B3E5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD608BE4DD8A11DE96A1E5ED8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD621280DD8A11DE9ADAE5ED8D1506C3");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD621281DD8A11DE94C0E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD63C030DD8A11DECBEBE5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD6546D0DD8A11DE8916E5ED8D1506C3");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6546D1DD8A11DE88BFE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6546D4DD8A11DE9298E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6546DFDD8A11DE9D17E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD6546D8DD8A11DEC4E0E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6546D9DD8A11DECE7BE5ED8D1506C3");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6546DADD8A11DE9DBBE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6546DDDD8A11DEA786E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDBD685410DD8A11DECC1DE5ED8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD685411DD8A11DE99FCE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD685414DD8A11DEB6F5E5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD6CE7F0DD8A11DE9018E5ED8D1506C3");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6CE7F1DD8A11DE96FEE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6CE7F3DD8A11DEC379E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD6E6E90DD8A11DE883CE5ED8D1506C3");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6E6E91DD8A11DEC946E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6E6E93DD8A11DEB5C2E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD6FF530DD8A11DEA45AE5ED8D1506C3");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD6FF531DD8A11DEB7AFE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD717BD4DD8A11DEAC28E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD717BD0DD8A11DEC8C7E5ED8D1506C3");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD717BD2DD8A11DE87F5E5ED8D1506C3");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDBD730270DD8A11DE9A88E5ED8D1506C3");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD730271DD8A11DEB69DE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD730273DD8A11DE85D2E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD760FB0DD8A11DEC179E5ED8D1506C3");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD760FB1DD8A11DEBA96E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD760FB9DD8A11DEAC27E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD760FB5DD8A11DE9361E5ED8D1506C3");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD760FB7DD8A11DE8395E5ED8D1506C3");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDBD779651DD8A11DEC83EE5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD779652DD8A11DECE4FE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD779655DD8A11DE861EE5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD779660DD8A11DEC3ACE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD779659DD8A11DE9698E5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD77965EDD8A11DEB3DEE5ED8D1506C3");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBD77965BDD8A11DEBD82E5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD791CF0DD8A11DE821DE5ED8D1506C3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDBD7C2A31DD8A11DEB92BE5ED8D1506C3");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CDBD7C2A34DD8A11DE8323E5ED8D1506C3");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CDBD7C2A37DD8A11DEC0FDE5ED8D1506C3");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CDBD7C2A3ADD8A11DE838AE5ED8D1506C3");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CDBD7F3771DD8A11DE8B83E5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD7F3772DD8A11DEA5B5E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD7F3775DD8A11DEBCBDE5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD7F3776DD8A11DEA7A4E5ED8D1506C3");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD8244B0DD8A11DEA747E5ED8D1506C3");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8244B7DD8A11DEAD1AE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD8244B5DD8A11DE904AE5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8244B8DD8A11DEB028E5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8244BCDD8A11DEA0C3E5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBD8244BADD8A11DECB6DE5ED8D1506C3");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8244BDDD8A11DE947CE5ED8D1506C3");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD83CB52DD8A11DE9C5AE5ED8D1506C3");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD83CB54DD8A11DE9D58E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8551F7DD8A11DE94CEE5ED8D1506C3");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBD8551F3DD8A11DE9085E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8551F5DD8A11DEA4FDE5ED8D1506C3");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8551F8DD8A11DEAFE6E5ED8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8551FCDD8A11DEB57FE5ED8D1506C3");}(({_beforeSeqEl("E0DCF6CDBD8551FADD8A11DE8C8CE5ED8D1506C3");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD8551FDDD8A11DE9936E5ED8D1506C3");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBD86D895DD8A11DEA96AE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD86D893DD8A11DEA2F1E5ED8D1506C3");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD86D897DD8A11DEB4D8E5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBD885F30DD8A11DE9426E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDA55D11DD8A11DEAAA9E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDA3D676DD8A11DE8BAFE5ED8D1506C3");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBD885F36DD8A11DEBDE0E5ED8D1506C3");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDBDA3D674DD8A11DEC7B4E5ED8D1506C3");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDA55D12DD8A11DEC46DE5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDA55D14DD8A11DEB9D3E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDA55D15DD8A11DEBF2CE5ED8D1506C3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDBDA86A51DD8A11DEC0A1E5ED8D1506C3");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CDBDA86A54DD8A11DE9900E5ED8D1506C3");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CDBDAB7794DD8A11DEBFCFE5ED8D1506C3");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBDAB7791DD8A11DE82E6E5ED8D1506C3");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDB00B71DD8A11DEC3D5E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB00B72DD8A11DEC42DE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB00B74DD8A11DEA8C3E5ED8D1506C3");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDB19213DD8A11DEA77FE5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDB49F50DD8A11DEB17AE5ED8D1506C3");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB49F51DD8A11DEB6E3E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB49F53DD8A11DE8212E5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB49F54DD8A11DE9B0FE5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDB625F0DD8A11DEC470E5ED8D1506C3");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB625F1DD8A11DE99E1E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB625F3DD8A11DE8E8BE5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB625F4DD8A11DE8158E5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDB93331DD8A11DECF4CE5ED8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB93332DD8A11DEA89EE5ED8D1506C3");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDB93337DD8A11DECDD7E5ED8D1506C3");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBDB93334DD8A11DEA22CE5ED8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDBDEE22DD8A11DEB8B3E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDBF74C1DD8A11DEAC1CE5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDC0FB60DD8A11DE91AFE5ED8D1506C3");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC0FB62DD8A11DECC53E5ED8D1506C3");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDC28200DD8A11DE865AE5ED8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC408A0DD8A11DE99D3E5ED8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDC58F45DD8A11DEB112E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDC58F43DD8A11DE9F8EE5ED8D1506C3");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC58F46DD8A11DEAB6AE5ED8D1506C3");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC58F48DD8A11DEA468E5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC58F49DD8A11DEB77DE5ED8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC58F4BDD8A11DE8B13E5ED8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDC58F4CDD8A11DECEE2E5ED8D1506C3");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDC89C84DD8A11DE94B7E5ED8D1506C3");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBDC89C81DD8A11DEB33AE5ED8D1506C3");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDCBA9C1DD8A11DEB4FFE5ED8D1506C3");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDCEB700DD8A11DEA722E5ED8D1506C3");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB701DD8A11DECE43E5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB702DD8A11DE80FCE5ED8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB703DD8A11DEA88CE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB705DD8A11DEBE34E5ED8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB706DD8A11DE89E4E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB707DD8A11DEAA88E5ED8D1506C3");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB708DD8A11DE8A62E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDCEB70ADD8A11DE9287E5ED8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD03DA8DD8A11DEA9A2E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDD03DA2DD8A11DE830CE5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD03DA3DD8A11DECCF9E5ED8D1506C3");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD03DA4DD8A11DEA449E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD03DA6DD8A11DE99E6E5ED8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD03DA9DD8A11DEA25BE5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDD34AE0DD8A11DEC622E5ED8D1506C3");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD34AE1DD8A11DEBB2DE5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD34AE2DD8A11DEC322E5ED8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD34AE3DD8A11DEBC6AE5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD34AE9DD8A11DE8354E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDD34AE7DD8A11DEA0EBE5ED8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD34AEBDD8A11DE9923E5ED8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD34AECDD8A11DE9505E5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDD4D180DD8A11DEC35EE5ED8D1506C3");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD4D181DD8A11DEB10AE5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD4D182DD8A11DEAAF8E5ED8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD4D183DD8A11DEB812E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65822DD8A11DEB72DE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDD65820DD8A11DEB761E5ED8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65824DD8A11DE88A2E5ED8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65825DD8A11DEC275E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65826DD8A11DEB815E5ED8D1506C3");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65827DD8A11DEA901E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD6582DDD8A11DE9DDCE5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDD6582BDD8A11DEAC3EE5ED8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD6582FDD8A11DEA19EE5ED8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD7DEC9DD8A11DEB813E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDD65833DD8A11DE8BD5E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65834DD8A11DEB7E0E5ED8D1506C3");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65835DD8A11DE8F85E5ED8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD65837DD8A11DE8B00E5ED8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD7DEC7DD8A11DECF61E5ED8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDBDD6583BDD8A11DE9FE5E5ED8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD6583CDD8A11DE8A3EE5ED8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD7DEC4DD8A11DE8E3DE5ED8D1506C3");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDBDD7DEC1DD8A11DEA9CAE5ED8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD7DEC5DD8A11DEB50DE5ED8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDD7DECADD8A11DEB924E5ED8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDDAEC03DD8A11DEA91BE5ED8D1506C3");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDDAEC04DD8A11DEC82CE5ED8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDDAEC06DD8A11DE9DB8E5ED8D1506C3");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDDDF940DD8A11DE911EE5ED8D1506C3");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDDDF941DD8A11DEA1FCE5ED8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDDDF942DD8A11DE8495E5ED8D1506C3");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDDF7FE0DD8A11DE9610E5ED8D1506C3");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDE28D20DD8A11DEB769E5ED8D1506C3");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDE413C2DD8A11DE95B5E5ED8D1506C3");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDBDE59A60DD8A11DECB50E5ED8D1506C3");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDE59A62DD8A11DE9E93E5ED8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDBDE59A63DD8A11DEC2ACE5ED8D1506C3");} RSQUARE {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('--' (~('\r'| '\n'))*))){$channel=HIDDEN;}
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
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();$channel=HIDDEN;}
	;

WS
	:	(	' '
		|	'\t'
		){$channel=HIDDEN;}
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
		|	'\''!  // exclamation marks means to exclude the char from the token (in theory)
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\''|'\n') // means any other character
			)*
			'\''!
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
	:	'"'!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\"'|'\n')  // means any other character
		)*
		'"'!
	;

	