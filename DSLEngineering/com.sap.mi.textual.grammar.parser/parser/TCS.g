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
   private static final String syntaxUUID = "E0DCF6CD900DD3D0E89511DEC1C7ECDF8D1506C3";
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
  | 'for' {ret = "for";}
  | 'createAs' {ret = "createAs";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'prefix' {ret = "prefix";}
  | 'esc' {ret = "esc";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'priority' {ret = "priority";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'refersTo' {ret = "refersTo";}
  | 'symbols' {ret = "symbols";}
  | 'and' {ret = "and";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'function' {ret = "function";}
  | 'keywords' {ret = "keywords";}
  | 'end' {ret = "end";}
  | 'hex' {ret = "hex";}
  | 'isDefined' {ret = "isDefined";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'omitted' {ret = "omitted";}
  | 'postfix' {ret = "postfix";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'partial' {ret = "partial";}
  | 'importContext' {ret = "importContext";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'multiLine' {ret = "multiLine";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'startNL' {ret = "startNL";}
  | 'nbNL' {ret = "nbNL";}
  | 'all' {ret = "all";}
  | 'main' {ret = "main";}
  | 'part' {ret = "part";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'mode' {ret = "mode";}
  | 'default' {ret = "default";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'deep' {ret = "deep";}
  | 'abstract' {ret = "abstract";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'right' {ret = "right";}
  | 'endNL' {ret = "endNL";}
  | 'context' {ret = "context";}
  | 'filter' {ret = "filter";}
  | 'value' {ret = "value";}
  | 'one' {ret = "one";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'auto' {ret = "auto";}
  | 'query' {ret = "query";}
  | 'multi' {ret = "multi";}
  | 'token' {ret = "token";}
  | 'start' {ret = "start";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'operatored' {ret = "operatored";}
  | 'operators' {ret = "operators";}
  | 'using' {ret = "using";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'always' {ret = "always";}
  | 'never' {ret = "never";}
  | 'createIn' {ret = "createIn";}
  | 'addToContext' {ret = "addToContext";}
  | 'lookIn' {ret = "lookIn";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'template' {ret = "template";}
  | 'octal' {ret = "octal";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'syntax' {ret = "syntax";}
  | 'serializer' {ret = "serializer";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'lexer' {ret = "lexer";}
  | 'foreach' {ret = "foreach";}
  | 'k' {ret = "k";}
  | 'left' {ret = "left";}
  | 'invert' {ret = "invert";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'as' {ret = "as";}
  | 'word' {ret = "word";}
  | 'source' {ret = "source";}
  | 'rightNone' {ret = "rightNone";}
  | 'leftNone' {ret = "leftNone";}
  | 'separator' {ret = "separator";}
  | 'drop' {ret = "drop";}
  | 'true' {ret = "true";}
  | 'when' {ret = "when";}
  | 'false' {ret = "false";}
  | 'indentIncr' {ret = "indentIncr";})
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
  ({_beforeSeqEl("E0DCF6CD8F0DC8F0E89511DEB317ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8EFD0010E89511DECD52ECDF8D1506C3");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F031A90E89511DE93FBECDF8D1506C3");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F031A92E89511DE974EECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F0C4251E89511DEB9BCECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8F19FDF1E89511DE883EECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F19FDF7E89511DE9238ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CD8F219F10E89511DEBC05ECDF8D1506C3");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F219F12E89511DE9291ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2325B7E89511DE90FCECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F2325B0E89511DE8633ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2325B1E89511DE852CECDF8D1506C3");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2325B2E89511DEAB7CECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2325B4E89511DE9EA6ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2325B5E89511DEA8E2ECDF8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F24AC50E89511DE9044ECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F36D4C0E89511DE8DEFECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F24AC52E89511DE93F6ECDF8D1506C3");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2AC6D0E89511DEBD49ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F2632F0E89511DE83FDECDF8D1506C3");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2632F1E89511DECD66ECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F27B990E89511DEBC59ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F2632F3E89511DE9115ECDF8D1506C3");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F294030E89511DEA1C9ECDF8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2DD412E89511DEBA12ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F2AC6D4E89511DEC83AECDF8D1506C3");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2AC6D5E89511DE8349ECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2AC6D9E89511DEBEBFECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F2AC6D7E89511DEAB4CECDF8D1506C3");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2DD410E89511DE927FECDF8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2F5AB1E89511DEA4E0ECDF8D1506C3");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F2F5AB3E89511DE9B06ECDF8D1506C3");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F33EE92E89511DE95BDECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F30E151E89511DEB944ECDF8D1506C3");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F30E152E89511DE969BECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F3267F0E89511DE890BECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F33EE90E89511DEA06DECDF8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F39E200E89511DEC7AFECDF8D1506C3");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CD8F3FFC80E89511DEAF02ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F3B68A2E89511DECEC8ECDF8D1506C3");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F3B68A4E89511DE92A8ECDF8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F3E75E0E89511DEAEA5ECDF8D1506C3");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8F3B68A6E89511DEB6BDECDF8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8F449063E89511DE8045ECDF8D1506C3");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F449065E89511DE9729ECDF8D1506C3");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F449066E89511DEB3AEECDF8D1506C3");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F461700E89511DEC57DECDF8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F479DA4E89511DE8BE9ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F479DA2E89511DEA3E3ECDF8D1506C3");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F492440E89511DEC219ECDF8D1506C3");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F492442E89511DEC158ECDF8D1506C3");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F492448E89511DE8D78ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F492446E89511DECE7BECDF8D1506C3");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F492449E89511DEA034ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F49244AE89511DEB027ECDF8D1506C3");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F49244BE89511DEC6C2ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F49244EE89511DE880EECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4AAAE7E89511DE913EECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F4AAAE0E89511DECCF5ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4AAAE1E89511DE84D2ECDF8D1506C3");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4AAAE2E89511DEBBCFECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4AAAE5E89511DE9E10ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4AAAE8E89511DE864DECDF8D1506C3");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4DB820E89511DE98A7ECDF8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F4F3EC2E89511DE9F98ECDF8D1506C3");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F4F3EC3E89511DE81AAECDF8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F50C562E89511DEBDC2ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F50C560E89511DE8E74ECDF8D1506C3");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F555946E89511DEA112ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F555942E89511DEA60DECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F50C566E89511DEA0B2ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F53D2A0E89511DECA49ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F50C56BE89511DEB8B7ECDF8D1506C3");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8F50C568E89511DE9155ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F555940E89511DEB692ECDF8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F555944E89511DE98DFECDF8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F555949E89511DE9DD9ECDF8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F56DFE3E89511DE9511ECDF8D1506C3");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F586680E89511DE9679ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F586682E89511DEA66DECDF8D1506C3");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F586686E89511DE87EFECDF8D1506C3");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F586687E89511DE9BF2ECDF8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6AB600E89511DE954DECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F59ED20E89511DEA22FECDF8D1506C3");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F59ED29E89511DECEBBECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F59ED25E89511DE9916ECDF8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F59ED27E89511DEB818ECDF8D1506C3");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5B73C3E89511DE8E4CECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F59ED2DE89511DEBE0EECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F59ED2EE89511DECA14ECDF8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F59ED2FE89511DEA599ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5B73C0E89511DE9BA5ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5B73C1E89511DE92CFECDF8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5E8100E89511DEB208ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F5B73C7E89511DEA78BECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5B73C8E89511DEABBEECDF8D1506C3");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5B73C9E89511DEC5BCECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5B73CCE89511DEC369ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5CFA60E89511DE8AC9ECDF8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5E8106E89511DE91A0ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F5E8104E89511DEBD2AECDF8D1506C3");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F5E810CE89511DE8FE5ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F5E810AE89511DEC378ECDF8D1506C3");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6007ABE89511DEB0DCECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F6007A8E89511DEB9DFECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F6007A6E89511DE8A23ECDF8D1506C3");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6007A9E89511DE8875ECDF8D1506C3");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F649B84E89511DE911DECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F618E41E89511DE9F64ECDF8D1506C3");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F649B82E89511DEC9C5ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F618E45E89511DEB766ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6314E1E89511DE94F2ECDF8D1506C3");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F649B80E89511DE98CEECDF8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F662223E89511DECAEEECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F649B88E89511DECD43ECDF8D1506C3");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F662221E89511DEBB4EECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F649B8DE89511DEB2F9ECDF8D1506C3");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F662229E89511DE8735ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F662227E89511DEB58BECDF8D1506C3");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F67A8C2E89511DECC86ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F67A8C0E89511DEC20FECDF8D1506C3");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F692F6AE89511DEC4A6ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F692F60E89511DEAED3ECDF8D1506C3");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F692F68E89511DEC176ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F692F61E89511DE8592ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F692F66E89511DECE50ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F692F63E89511DEBF30ECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC340E89511DE8F76ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F6C3CA5E89511DEA692ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F6AB604E89511DEAD88ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6C3CA2E89511DEA4DAECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F6AB606E89511DEA0FCECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6C3CA3E89511DE809FECDF8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F6C3CA7E89511DEAAB8ECDF8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC343E89511DE987CECDF8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F6DC347E89511DECE0BECDF8D1506C3");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC348E89511DE91E1ECDF8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC349E89511DE8D1EECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC34AE89511DE9838ECDF8D1506C3");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC34BE89511DEBB20ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6DC34EE89511DE891EECDF8D1506C3");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6F49E0E89511DEADF7ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6F49E1E89511DE851BECDF8D1506C3");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6F49E2E89511DEBB56ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6F49E4E89511DEC7E6ECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F70D082E89511DEA082ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F6F49E8E89511DECDD4ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6F49E9E89511DEAFA7ECDF8D1506C3");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F6F49EAE89511DE989CECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F70D080E89511DE97CCECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725720E89511DEA2DBECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F70D086E89511DEADE4ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F70D087E89511DEA572ECDF8D1506C3");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F70D088E89511DE9912ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F70D08AE89511DE84A2ECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F72572BE89511DEB606ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F725724E89511DEBADBECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725725E89511DEA531ECDF8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725726E89511DECB74ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725729E89511DEC588ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F73DDC1E89511DEA44FECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F72572FE89511DE8A27ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725730E89511DEC983ECDF8D1506C3");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725731E89511DE9535ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F725734E89511DE93F9ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F73DDC2E89511DEA905ECDF8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F75646EE89511DEA2C1ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F73DDC6E89511DE8851ECDF8D1506C3");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F75646CE89511DE86C6ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F756463E89511DEADAFECDF8D1506C3");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F75646AE89511DE8CB5ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F756468E89511DECE1FECDF8D1506C3");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F76EB0DE89511DECC8CECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F76EB09E89511DE9DB1ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F76EB01E89511DE89CEECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F76EB06E89511DECE5CECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F76EB03E89511DE8C02ECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F76EB07E89511DEB212ECDF8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F76EB0BE89511DE8275ECDF8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F7871A0E89511DE95FAECDF8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F79F842E89511DEB9ACECDF8D1506C3");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F844E89511DE8A00ECDF8D1506C3");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F845E89511DEBBB5ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F846E89511DEB22EECDF8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F847E89511DE9E66ECDF8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F850E89511DE9F1EECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F79F848E89511DE9713ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F84DE89511DE8E67ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8F79F84AE89511DEB15FECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F79F84EE89511DEB99EECDF8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F7B7EE3E89511DEB272ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F7B7EE8E89511DEB0BAECDF8D1506C3");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8F7B7EE5E89511DEA62FECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F7D0580E89511DEAFA9ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F7D0585E89511DE9E0CECDF8D1506C3");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F862D40E89511DEC124ECDF8D1506C3");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F893A80E89511DEB21FECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F90DBA6E89511DEA352ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F8F5502E89511DEA251ECDF8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8F90DBA1E89511DECDDCECDF8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F90DBA4E89511DE8AD6ECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8F90DBABE89511DE96F8ECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F93E8E0E89511DEAC05ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F90DBAFE89511DEA8F6ECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F926242E89511DEBA2FECDF8D1506C3");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8F90DBB1E89511DEBA42ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F926243E89511DEACBBECDF8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F956F82E89511DECE31ECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F96F622E89511DE9CA4ECDF8D1506C3");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F96F624E89511DEA577ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F96F625E89511DEBA12ECDF8D1506C3");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F96F628E89511DEA5EEECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F96F62CE89511DEAAB5ECDF8D1506C3");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F96F62EE89511DEB3DDECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F96F62FE89511DE937AECDF8D1506C3");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F987CC2E89511DE8437ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F96F633E89511DEC82EECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F96F638E89511DEC92CECDF8D1506C3");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8F96F635E89511DEA310ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F987CC0E89511DEAC65ECDF8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F987CC5E89511DEAE84ECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F987CC9E89511DE9592ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F987CCBE89511DEB719ECDF8D1506C3");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F987CCCE89511DEA71BECDF8D1506C3");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F987CCEE89511DEC5D0ECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9A0367E89511DE8D9BECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F9A0363E89511DECAFAECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9A0365E89511DEC2E5ECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9A0368E89511DEB0F8ECDF8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9A036BE89511DE83C7ECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F9B8A00E89511DECAF5ECDF8D1506C3");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9B8A05E89511DE8888ECDF8D1506C3");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8F9B8A02E89511DE8A2DECDF8D1506C3");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9B8A06E89511DEB3A2ECDF8D1506C3");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9B8A0CE89511DE8FC3ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F9B8A0AE89511DEA1DBECDF8D1506C3");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9B8A0FE89511DE919BECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F9E9740E89511DECC02ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8F9D10A5E89511DE90DFECDF8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9D10A6E89511DE9D43ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9D10A9E89511DE8426ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9D10AAE89511DE89DBECDF8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9E9742E89511DEB007ECDF8D1506C3");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8F9E9746E89511DE9426ECDF8D1506C3");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9E9749E89511DEBEFBECDF8D1506C3");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8F9E974CE89511DE9B95ECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FA01DE0E89511DECDD5ECDF8D1506C3");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA01DE5E89511DE9729ECDF8D1506C3");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FA01DE2E89511DE91DCECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA01DE6E89511DE9093ECDF8D1506C3");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA01DE9E89511DECB77ECDF8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FA1A481E89511DE803DECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA1A489E89511DE81B6ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FA1A485E89511DE8EA9ECDF8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FA1A487E89511DEC285ECDF8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA1A48BE89511DEA977ECDF8D1506C3");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FA1A490E89511DE889EECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA32B27E89511DEB627ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FA32B23E89511DE91CEECDF8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FA32B25E89511DE99D6ECDF8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA32B28E89511DE9423ECDF8D1506C3");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA32B29E89511DE9396ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA32B2CE89511DE832DECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA4B1C0E89511DEBA25ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FA4B1C5E89511DEBDA8ECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA4B1CDE89511DEBEF8ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FA4B1C9E89511DEBD40ECDF8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FA4B1CBE89511DEAD66ECDF8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA4B1CEE89511DE9530ECDF8D1506C3");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA63860E89511DEC10DECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA63863E89511DEB886ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA6386EE89511DE9FBDECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FA63867E89511DE9DF2ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA63868E89511DE9AA1ECDF8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA63869E89511DEBD72ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA6386CE89511DE957EECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA7BF0AE89511DE9AA9ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FA7BF03E89511DEB36BECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA7BF08E89511DEC812ECDF8D1506C3");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FA7BF05E89511DEA064ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA7BF0BE89511DEC80EECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FAACC40E89511DEBFDFECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FA7BF12E89511DEC2A8ECDF8D1506C3");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA7BF13E89511DEB0EAECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA7BF16E89511DEA2BCECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FA945A0E89511DE901AECDF8D1506C3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FAC52EAE89511DEA1BBECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FAC52E3E89511DE8D1EECDF8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FAC52E4E89511DEC4B3ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FAC52E7E89511DE9990ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FAC52E8E89511DEA8D6ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FADD980E89511DE9674ECDF8D1506C3");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FADD981E89511DEA471ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FADD986E89511DEA3C7ECDF8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FB0E6C1E89511DEC71DECDF8D1506C3");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB0E6C2E89511DE8608ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB0E6C5E89511DE9D93ECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FB0E6C9E89511DE9AF9ECDF8D1506C3");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB0E6CAE89511DEB109ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB57AABE89511DEA271ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FB57AA1E89511DE8ABBECDF8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB57AA2E89511DE9D25ECDF8D1506C3");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FB57AA9E89511DEAE1AECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FB57AA6E89511DEBFFCECDF8D1506C3");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8FB70140E89511DE8C38ECDF8D1506C3");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB70141E89511DEA7B7ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB70147E89511DEBF64ECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FB70144E89511DEA8E3ECDF8D1506C3");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FB7014BE89511DEA4A1ECDF8D1506C3");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB7014CE89511DEB8A2ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB70151E89511DE986BECDF8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FB887E3E89511DEC191ECDF8D1506C3");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB887E4E89511DE8027ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB887E6E89511DE8E7CECDF8D1506C3");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FB887EAE89511DEC4A7ECDF8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB887EBE89511DE8DF8ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FB887EEE89511DE9F77ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FBA0E80E89511DEA64FECDF8D1506C3");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FBA0E81E89511DEB047ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FBA0E83E89511DEAFFAECDF8D1506C3");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD8FBB9520E89511DEC828ECDF8D1506C3");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CD8FC1AFA0E89511DEC4A6ECDF8D1506C3");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CD8FC1AFA3E89511DE8B18ECDF8D1506C3");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CD8FC4BCE0E89511DE8C30ECDF8D1506C3");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC4BCE4E89511DECE56ECDF8D1506C3");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC61C72E89511DEBDAEECDF8D1506C3");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC61C73E89511DE8779ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC61C75E89511DEC731ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC61C79E89511DEB4F5ECDF8D1506C3");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC61C7AE89511DE86AEECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC61C7CE89511DEA46AECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC7A310E89511DEC03FECDF8D1506C3");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A311E89511DEA33BECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A317E89511DE86E3ECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FC7A314E89511DEBEBDECDF8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC7A31BE89511DE82B6ECDF8D1506C3");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A31CE89511DEA87DECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A31FE89511DE8660ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC7A323E89511DEB4A5ECDF8D1506C3");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A324E89511DE82E2ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A327E89511DEC6DBECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC929B0E89511DEB2ACECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FC7A32BE89511DEBF4DECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A32CE89511DEB2E6ECDF8D1506C3");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A32DE89511DEB34BECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC7A330E89511DE80E1ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8FC929B4E89511DE906BECDF8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC929B5E89511DEC370ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC929B8E89511DE9E44ECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC929BEE89511DEA23FECDF8D1506C3");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC929BFE89511DEAD70ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FC929C1E89511DEA792ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FC929C5E89511DE83E8ECDF8D1506C3");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCAB050E89511DEA321ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCAB052E89511DEBDC6ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FCAB056E89511DEC365ECDF8D1506C3");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCAB057E89511DEB244ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCC36F4E89511DEA655ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FCC36F0E89511DE920DECDF8D1506C3");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FCC36F2E89511DEC1FBECDF8D1506C3");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8FCC36F8E89511DE856DECDF8D1506C3");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCC36F9E89511DE88E1ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCC36FBE89511DEB80CECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FCDBD90E89511DEBB51ECDF8D1506C3");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCDBD91E89511DE85C6ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCDBD99E89511DEA145ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FCDBD95E89511DEC66EECDF8D1506C3");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FCDBD97E89511DE8691ECDF8D1506C3");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD8FCDBD9EE89511DE96F1ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCDBD9FE89511DE98A7ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCDBDA2E89511DEAF29ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCF4432E89511DEAA3AECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FCDBDA6E89511DEBE72ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCF4430E89511DE9E08ECDF8D1506C3");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FCDBDA8E89511DEB000ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FCF4433E89511DE8C34ECDF8D1506C3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD8FCF4438E89511DEA6E4ECDF8D1506C3");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CD8FCF443BE89511DE8308ECDF8D1506C3");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CD8FCF443EE89511DE84CBECDF8D1506C3");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CD8FCF4441E89511DEB5A1ECDF8D1506C3");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CD8FD0CAD1E89511DE945CECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD0CAD2E89511DE8E1CECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD0CAD5E89511DEB3B2ECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD0CAD6E89511DEA62CECDF8D1506C3");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FD25172E89511DE94A3ECDF8D1506C3");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD25179E89511DEAACDECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FD25177E89511DE9005ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD2517AE89511DEBA3DECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD2517EE89511DE9AA7ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8FD2517CE89511DE8726ECDF8D1506C3");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD2517FE89511DE8FC6ECDF8D1506C3");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FD25183E89511DEC82AECDF8D1506C3");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD25185E89511DE91D1ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD3D816E89511DEA2CBECDF8D1506C3");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FD3D812E89511DEA03AECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD3D814E89511DE8442ECDF8D1506C3");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD3D817E89511DEBDEEECDF8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD55EB0E89511DE99F1ECDF8D1506C3");}(({_beforeSeqEl("E0DCF6CD8FD3D819E89511DE8718ECDF8D1506C3");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD55EB1E89511DE877AECDF8D1506C3");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FD55EBAE89511DEBF8FECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FD55EB8E89511DEA3B6ECDF8D1506C3");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD55EBCE89511DEBDAFECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FD55EBDE89511DEC812ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE00D11E89511DE97FFECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FDCFFD8E89511DEAC9BECDF8D1506C3");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FD55EC3E89511DEB1CDECDF8D1506C3");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD8FDCFFD6E89511DEB6A1ECDF8D1506C3");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE00D12E89511DE98A9ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE00D14E89511DE9F65ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE00D15E89511DEAB54ECDF8D1506C3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD8FE00D1AE89511DEB9C6ECDF8D1506C3");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CD8FE00D1DE89511DEC885ECDF8D1506C3");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CD8FE00D27E89511DEBC9EECDF8D1506C3");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FE00D24E89511DEACBFECDF8D1506C3");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE193B3E89511DE868FECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE193B4E89511DECFE3ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE193B6E89511DE9888ECDF8D1506C3");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE31A51E89511DEBA48ECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE31A55E89511DE9564ECDF8D1506C3");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A56E89511DEC2B7ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A58E89511DEC70CECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A59E89511DE9EC8ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE31A5DE89511DEB058ECDF8D1506C3");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A5EE89511DE8672ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A60E89511DEC843ECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A61E89511DE8250ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE31A66E89511DEB33BECDF8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE31A67E89511DEBDC2ECDF8D1506C3");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE4A0F1E89511DEB064ECDF8D1506C3");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FE31A69E89511DE9CEDECDF8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE4A0F9E89511DE88BAECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE62793E89511DE9AB9ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE62797E89511DEB18FECDF8D1506C3");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE62799E89511DE9268ECDF8D1506C3");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE6279DE89511DEC177ECDF8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE627A0E89511DEA2CDECDF8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE627A9E89511DE88B3ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FE627A7E89511DEAB9BECDF8D1506C3");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE627AAE89511DE83E7ECDF8D1506C3");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE627ACE89511DEC055ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE7AE30E89511DE8983ECDF8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE7AE32E89511DE9F3CECDF8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE7AE33E89511DECE9DECDF8D1506C3");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE7AE3BE89511DE8ED8ECDF8D1506C3");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FE7AE38E89511DE895BECDF8D1506C3");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE934D1E89511DEB8B2ECDF8D1506C3");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FE934D7E89511DEA49AECDF8D1506C3");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934D8E89511DEA183ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934D9E89511DE8FD2ECDF8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934DAE89511DEA0B4ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934DCE89511DEBF52ECDF8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934DDE89511DE9803ECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934DEE89511DE9783ECDF8D1506C3");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934DFE89511DE8DEAECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934E1E89511DEB3A3ECDF8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934EBE89511DEB491ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FE934E5E89511DEBFCEECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934E6E89511DE99C8ECDF8D1506C3");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934E7E89511DE9CE7ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934E9E89511DECB2FECDF8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FE934ECE89511DE85D6ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEABB72E89511DEB2A2ECDF8D1506C3");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB73E89511DE94CAECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB74E89511DEC20DECDF8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB75E89511DE8A19ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB7BE89511DE8268ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FEABB79E89511DECC5DECDF8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB7DE89511DE9824ECDF8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB7EE89511DEA185ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEABB82E89511DEC0DEECDF8D1506C3");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB83E89511DE8073ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB84E89511DEBC86ECDF8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB85E89511DECDA6ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB8BE89511DE9CCEECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FEABB89E89511DECF68ECDF8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEABB8DE89511DEA5CAECDF8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4210E89511DE886FECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4211E89511DEC810ECDF8D1506C3");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4212E89511DE83C5ECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4218E89511DEB7D4ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FEC4216E89511DEC321ECDF8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC421AE89511DEAD44ECDF8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEDC8B4E89511DE97FDECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FEC421EE89511DEC08CECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC421FE89511DEC164ECDF8D1506C3");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4220E89511DE9E8CECDF8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4222E89511DECBB6ECDF8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEDC8B2E89511DEC010ECDF8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD8FEC4226E89511DEBE4CECDF8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC4227E89511DEA600ECDF8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEC422CE89511DEB886ECDF8D1506C3");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD8FEC4229E89511DE9387ECDF8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEDC8B0E89511DECD05ECDF8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEDC8B5E89511DEC9E4ECDF8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEF4F53E89511DE97EEECDF8D1506C3");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEF4F54E89511DECCB4ECDF8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEF4F56E89511DEBE06ECDF8D1506C3");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEF4F5AE89511DE965DECDF8D1506C3");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEF4F5BE89511DE8052ECDF8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FEF4F5CE89511DEBB63ECDF8D1506C3");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEF4F60E89511DEC5A4ECDF8D1506C3");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEF4F64E89511DEADC6ECDF8D1506C3");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FEF4F6AE89511DE97BEECDF8D1506C3");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD8FF0D5F0E89511DE9167ECDF8D1506C3");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FF0D5F2E89511DEA3F8ECDF8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD8FF0D5F3E89511DE9C19ECDF8D1506C3");} RSQUARE {_afterSeqEl();})
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

        