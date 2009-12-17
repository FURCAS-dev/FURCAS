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
   private static final String syntaxUUID = "E0DCF6CD6BE1CD30E8D211DE9139C00C8D1506C3";
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
  | 'separator' {ret = "separator";}
  | 'createAs' {ret = "createAs";}
  | 'syntax' {ret = "syntax";}
  | 'left' {ret = "left";}
  | 'abstract' {ret = "abstract";}
  | 'false' {ret = "false";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'start' {ret = "start";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'isDefined' {ret = "isDefined";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'value' {ret = "value";}
  | 'multiLine' {ret = "multiLine";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'operatored' {ret = "operatored";}
  | 'multi' {ret = "multi";}
  | 'function' {ret = "function";}
  | 'keywords' {ret = "keywords";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'template' {ret = "template";}
  | 'foreach' {ret = "foreach";}
  | 'operators' {ret = "operators";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'postfix' {ret = "postfix";}
  | 'never' {ret = "never";}
  | 'main' {ret = "main";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'startNL' {ret = "startNL";}
  | 'default' {ret = "default";}
  | 'endNL' {ret = "endNL";}
  | 'using' {ret = "using";}
  | 'word' {ret = "word";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'one' {ret = "one";}
  | 'importContext' {ret = "importContext";}
  | 'auto' {ret = "auto";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'true' {ret = "true";}
  | 'invert' {ret = "invert";}
  | 'octal' {ret = "octal";}
  | 'query' {ret = "query";}
  | 'when' {ret = "when";}
  | 'mode' {ret = "mode";}
  | 'serializer' {ret = "serializer";}
  | 'esc' {ret = "esc";}
  | 'part' {ret = "part";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'filter' {ret = "filter";}
  | 'createIn' {ret = "createIn";}
  | 'and' {ret = "and";}
  | 'leftNone' {ret = "leftNone";}
  | 'k' {ret = "k";}
  | 'all' {ret = "all";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'token' {ret = "token";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'partial' {ret = "partial";}
  | 'deep' {ret = "deep";}
  | 'hex' {ret = "hex";}
  | 'symbols' {ret = "symbols";}
  | 'as' {ret = "as";}
  | 'priority' {ret = "priority";}
  | 'end' {ret = "end";}
  | 'lookIn' {ret = "lookIn";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'nbNL' {ret = "nbNL";}
  | 'omitted' {ret = "omitted";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'refersTo' {ret = "refersTo";}
  | 'rightNone' {ret = "rightNone";}
  | 'prefix' {ret = "prefix";}
  | 'addToContext' {ret = "addToContext";}
  | 'lexer' {ret = "lexer";}
  | 'for' {ret = "for";}
  | 'always' {ret = "always";}
  | 'source' {ret = "source";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'context' {ret = "context";}
  | 'drop' {ret = "drop";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'right' {ret = "right";})
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
  ({_beforeSeqEl("E0DCF6CD67043A00E8D211DE9D67C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD66549910E8D211DEC23AC00C8D1506C3");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD66A29200E8D211DEA3A8C00C8D1506C3");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD66AA3321E8D211DEA5AFC00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD66FC98E1E8D211DEAE67C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD675B5AB1E8D211DEBAA3C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD675E67F2E8D211DE9E0BC00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CD67E37670E8D211DE9832C00C8D1506C3");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E37672E8D211DEB110C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E4FD17E8D211DEC044C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD67E4FD10E8D211DE8EF2C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E4FD11E8D211DEC625C00C8D1506C3");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E4FD12E8D211DEB622C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E4FD14E8D211DE9C02C00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E4FD15E8D211DEBEB3C00C8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E4FD18E8D211DEBAD0C00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6829A730E8D211DE84C9C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD67E4FD1AE8D211DE84DDC00C8D1506C3");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68007452E8D211DE87C3C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD67E683B0E8D211DE9FECC00C8D1506C3");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67E683B1E8D211DE87C3C00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD67EC9E30E8D211DEB030C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD67E683B3E8D211DE8440C00C8D1506C3");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68007450E8D211DEBF0CC00C8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6801FAF4E8D211DEB971C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68007456E8D211DE9EE4C00C8D1506C3");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68007457E8D211DEAA95C00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6801FAF1E8D211DE9005C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68007459E8D211DEB3C6C00C8D1506C3");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6801FAF2E8D211DEBA8EC00C8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6801FAF6E8D211DEA792C00C8D1506C3");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6801FAF8E8D211DEAD9DC00C8D1506C3");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD681A64F0E8D211DE85CBC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68038190E8D211DEAC4AC00C8D1506C3");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68038191E8D211DEC53BC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6812C3D0E8D211DEC999C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6818DE50E8D211DEC80AC00C8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD682FC1B0E8D211DEB42AC00C8D1506C3");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CD684CE6A0E8D211DEA403C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6835DC32E8D211DEA4F6C00C8D1506C3");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6835DC34E8D211DE8FF8C00C8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD684B6000E8D211DEA254C00C8D1506C3");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6835DC36E8D211DE83B2C00C8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD687C3400E8D211DE9DA8C00C8D1506C3");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD687C3402E8D211DEB61BC00C8D1506C3");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD687C3403E8D211DEAF2FC00C8D1506C3");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68824E80E8D211DEC79AC00C8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A40753E8D211DE8849C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68A40751E8D211DE8E3CC00C8D1506C3");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A40754E8D211DEC8C1C00C8D1506C3");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A40756E8D211DEC4B2C00C8D1506C3");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A4075CE8D211DEB243C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68A4075AE8D211DE989AC00C8D1506C3");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A58DF0E8D211DE90CBC00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A58DF1E8D211DEA7CBC00C8D1506C3");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A58DF2E8D211DE86BBC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A58DF5E8D211DEB674C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A71497E8D211DECEF5C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68A71490E8D211DEA9A6C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A71491E8D211DE8B32C00C8D1506C3");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A71492E8D211DE9CB0C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A71495E8D211DE88C2C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68A71498E8D211DEADC4C00C8D1506C3");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68B34990E8D211DEAB67C00C8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD68BAEAB0E8D211DE9055C00C8D1506C3");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68BAEAB1E8D211DEBDF5C00C8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68BC7155E8D211DE8845C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68BC7153E8D211DEC473C00C8D1506C3");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68D661F3E8D211DEC7E2C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68D4DB50E8D211DEC5B6C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68BC7159E8D211DEA4F9C00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68D354B0E8D211DECCA4C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68BC715EE8D211DEA58FC00C8D1506C3");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD68BC715BE8D211DEB584C00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68D354B1E8D211DE9558C00C8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD68D661F1E8D211DECFB7C00C8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68D661F6E8D211DEBED3C00C8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD68D96F31E8D211DEAAB9C00C8D1506C3");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68D96F32E8D211DEB92BC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68D96F34E8D211DE9815C00C8D1506C3");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD68DF89B0E8D211DEB03BC00C8D1506C3");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68DF89B1E8D211DEA711C00C8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F97A55E8D211DEC3A8C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68DF89B5E8D211DEA273C00C8D1506C3");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD68DF89BEE8D211DEA9CEC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68DF89BAE8D211DEC4EAC00C8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68DF89BCE8D211DE9707C00C8D1506C3");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E296F0E8D211DE8202C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E11051E8D211DEC93AC00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E11052E8D211DEC3DCC00C8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E11053E8D211DE8E3AC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E11056E8D211DECF4BC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E11057E8D211DEB435C00C8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E41D90E8D211DEAA0DC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E296F4E8D211DEA387C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E296F5E8D211DE8928C00C8D1506C3");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E296F6E8D211DEC6C2C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E296F9E8D211DECDD3C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E296FAE8D211DEB29EC00C8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E41D96E8D211DEBEEDC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E41D94E8D211DE9B0EC00C8D1506C3");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E41D9CE8D211DEA032C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E41D9AE8D211DEA056C00C8D1506C3");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E5A438E8D211DEA94CC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E5A435E8D211DE920FC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E5A433E8D211DEBB67C00C8D1506C3");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68E5A436E8D211DE8191C00C8D1506C3");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F4E674E8D211DE946AC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E72AD3E8D211DEC0DFC00C8D1506C3");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F4E672E8D211DEB4F6C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68E72AD7E8D211DE8564C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F35FD0E8D211DE923DC00C8D1506C3");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F4E670E8D211DE9534C00C8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F66D11E8D211DEC2E6C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68F4E678E8D211DE8484C00C8D1506C3");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F4E67FE8D211DE98F9C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68F4E67DE8D211DE89BBC00C8D1506C3");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F66D17E8D211DE9C02C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68F66D15E8D211DE988BC00C8D1506C3");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F66D1DE8D211DEB292C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68F66D1BE8D211DE9DD0C00C8D1506C3");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F97A53E8D211DEC972C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68F7F3B1E8D211DE9DB0C00C8D1506C3");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F97A51E8D211DE9D9FC00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68F7F3B2E8D211DECB8AC00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68F7F3B7E8D211DE808DC00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68F7F3B4E8D211DECFF5C00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68FB00FDE8D211DEAFEAC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD68FB00F9E8D211DEA741C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68FB00F1E8D211DEAAB4C00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68FB00F6E8D211DEA1D3C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD68FB00F3E8D211DEAC87C00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68FB00F7E8D211DEBA3FC00C8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD68FB00FBE8D211DE816BC00C8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD68FC8791E8D211DECD51C00C8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69011B70E8D211DE948FC00C8D1506C3");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69011B71E8D211DECC44C00C8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69011B72E8D211DEAA73C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69011B73E8D211DE81B2C00C8D1506C3");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69011B74E8D211DEBC9FC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A210E8D211DE8EF6C00C8D1506C3");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A211E8D211DEA640C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A212E8D211DEB469C00C8D1506C3");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A213E8D211DEAECDC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A215E8D211DE8C94C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A21FE8D211DEBDAAC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6902A219E8D211DE834FC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A21AE8D211DE88C4C00C8D1506C3");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A21BE8D211DE98B9C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6902A21DE8D211DEA82AC00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428B9E8D211DE831FC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD690428B3E8D211DEAD91C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428B4E8D211DE8F58C00C8D1506C3");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428B5E8D211DEAFB3C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428B7E8D211DEA296C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6905AF50E8D211DECBEEC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD690428BDE8D211DEBC69C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428BEE8D211DE9F90C00C8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428BFE8D211DECDBDC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690428C2E8D211DEA238C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6905AF5BE8D211DE9213C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6905AF54E8D211DEB6FDC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6905AF55E8D211DEC3A8C00C8D1506C3");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6905AF56E8D211DEAD78C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6905AF59E8D211DEC4ECC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6905AF5CE8D211DEB016C00C8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6908BC91E8D211DE8733C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6905AF60E8D211DE807AC00C8D1506C3");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD690735F9E8D211DE9601C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD690735F0E8D211DE8F02C00C8D1506C3");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD690735F7E8D211DEB2CAC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD690735F5E8D211DEA2C9C00C8D1506C3");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6908BCA1E8D211DE96DCC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6908BC9DE8D211DEB31CC00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD6908BC95E8D211DEAAAEC00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6908BC9AE8D211DE9FA8C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD6908BC97E8D211DEC93DC00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6908BC9BE8D211DEA8E3C00C8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6908BC9FE8D211DEB3BDC00C8D1506C3");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6908BCA4E8D211DEB583C00C8D1506C3");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69245AE0E8D211DEB626C00C8D1506C3");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69245AE2E8D211DEC10FC00C8D1506C3");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69245AE3E8D211DEBD41C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69245AE4E8D211DEBD5CC00C8D1506C3");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69245AE5E8D211DEC099C00C8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6925E188E8D211DE814EC00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD6925E180E8D211DE9D05C00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6925E185E8D211DE9D5EC00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD6925E182E8D211DE9F35C00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6925E186E8D211DEB775C00C8D1506C3");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6928EEC0E8D211DEBF0EC00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6928EEC5E8D211DE866FC00C8D1506C3");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6928EEC2E8D211DEA0EEC00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6928EEC6E8D211DECD63C00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD692BFC01E8D211DEB750C00C8D1506C3");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6973DA70E8D211DEC925C00C8D1506C3");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6996F2D0E8D211DE85D7C00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69CAD416E8D211DE81E7C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69C332F1E8D211DECFA6C00C8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD69CAD411E8D211DEB031C00C8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69CAD414E8D211DECE6DC00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD69CDE151E8D211DEAF70C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69D27532E8D211DEBD4EC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69CF67F3E8D211DE80A0C00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69CF67F8E8D211DEB461C00C8D1506C3");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD69CF67F5E8D211DEB474C00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69D27530E8D211DEC1C8C00C8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69D27535E8D211DE9C2EC00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69D70910E8D211DEAB8BC00C8D1506C3");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69D70912E8D211DE80D1C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69D70913E8D211DEA2ADC00C8D1506C3");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69D70916E8D211DEC220C00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69DBC400E8D211DE9C04C00C8D1506C3");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69DBC402E8D211DEAFF8C00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69DBC403E8D211DEC5F7C00C8D1506C3");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69DED140E8D211DEA51BC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69DBC407E8D211DECD4DC00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69DBC40CE8D211DEB5B1C00C8D1506C3");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD69DBC409E8D211DE81EFC00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69DBC40DE8D211DEB769C00C8D1506C3");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69DED143E8D211DE9012C00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69E1DE80E8D211DE8E5EC00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E1DE82E8D211DE8620C00C8D1506C3");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E1DE83E8D211DE8305C00C8D1506C3");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E1DE85E8D211DE8DDAC00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E36521E8D211DEBC90C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69E1DE89E8D211DE8153C00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E1DE8BE8D211DEB28BC00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E36522E8D211DE8B8DC00C8D1506C3");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E36525E8D211DEBC1CC00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69E4EBC0E8D211DE85D5C00C8D1506C3");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E4EBC5E8D211DE8B18C00C8D1506C3");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD69E4EBC2E8D211DEA809C00C8D1506C3");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E67260E8D211DE9F54C00C8D1506C3");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E67266E8D211DEC94FC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69E67264E8D211DEBAE0C00C8D1506C3");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E67269E8D211DE8647C00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69E97FA2E8D211DE903AC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69E7F903E8D211DEBCE1C00C8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E7F904E8D211DE9F66C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E7F907E8D211DE92AAC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E97FA0E8D211DEA120C00C8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69E97FA4E8D211DE887BC00C8D1506C3");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69EB0640E8D211DE85FBC00C8D1506C3");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69EB0643E8D211DE8AC9C00C8D1506C3");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69EB0646E8D211DEC0F8C00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69EE1380E8D211DEC163C00C8D1506C3");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69EE1385E8D211DEC63FC00C8D1506C3");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD69EE1382E8D211DEBE42C00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69EE1386E8D211DE8ACDC00C8D1506C3");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69EE1389E8D211DE8698C00C8D1506C3");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69F42E01E8D211DEC9B8C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F42E09E8D211DEC792C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69F42E05E8D211DE9E40C00C8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD69F42E07E8D211DE9EBBC00C8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F42E0BE8D211DE84ABC00C8D1506C3");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69F73B41E8D211DE94E6C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F73B49E8D211DEA958C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69F73B45E8D211DEC370C00C8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD69F73B47E8D211DEA074C00C8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F73B4AE8D211DEAD8AC00C8D1506C3");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F73B4BE8D211DEB3F6C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F73B4EE8D211DE9F40C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69F73B4FE8D211DECEDEC00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD69FA4881E8D211DE8CF9C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FA4889E8D211DE9994C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69FA4885E8D211DE991DC00C8D1506C3");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD69FA4887E8D211DEC701C00C8D1506C3");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FA488AE8D211DE8915C00C8D1506C3");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FA488BE8D211DEA8CFC00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FA488EE8D211DEA971C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FBCF23E8D211DECACEC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69FA4892E8D211DEC6FBC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FA4893E8D211DE8B93C00C8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FA4894E8D211DEBEDAC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FBCF21E8D211DE97BBC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A006300E8D211DEBABDC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD69FBCF27E8D211DEABE4C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD69FBCF2CE8D211DE94E0C00C8D1506C3");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD69FBCF29E8D211DE8545C00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A006301E8D211DEBD3EC00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A037049E8D211DEA8CDC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A037042E8D211DEA98FC00C8D1506C3");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037043E8D211DEC80EC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037046E8D211DECAC4C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037047E8D211DE906EC00C8D1506C3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037054E8D211DEBCE2C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A03704DE8D211DEA3FDC00C8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A03704EE8D211DE94C6C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037051E8D211DE92A8C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037052E8D211DE81D5C00C8D1506C3");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A037055E8D211DECCEAC00C8D1506C3");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A04F6E0E8D211DEBE47C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A04F6E5E8D211DECBD1C00C8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A080422E8D211DEC915C00C8D1506C3");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A080423E8D211DEBE91C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A080426E8D211DE9576C00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A0B1160E8D211DE8E36C00C8D1506C3");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A0B1161E8D211DEAFEEC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A38D828E8D211DE8D47C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A375181E8D211DE86DCC00C8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A375182E8D211DEA7F1C00C8D1506C3");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6A38D826E8D211DEA0F5C00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6A38D823E8D211DE8654C00C8D1506C3");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD6A3A5EC0E8D211DEBA8BC00C8D1506C3");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A3A5EC1E8D211DEA2C3C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A3A5EC7E8D211DECC80C00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6A3A5EC4E8D211DE8236C00C8D1506C3");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A3D6C00E8D211DEB6DCC00C8D1506C3");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A3D6C01E8D211DECA0FC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A3D6C06E8D211DEB6F0C00C8D1506C3");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A407940E8D211DEA286C00C8D1506C3");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A407941E8D211DE8484C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A407943E8D211DE90C1C00C8D1506C3");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A4226F0E8D211DEC3BBC00C8D1506C3");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A4226F1E8D211DE9722C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A4226F4E8D211DE96BDC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A43AD90E8D211DE87FAC00C8D1506C3");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A43AD91E8D211DEAB75C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A43AD93E8D211DEA190C00C8D1506C3");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD6A547670E8D211DECBF3C00C8D1506C3");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CD6A684C91E8D211DECCC1C00C8D1506C3");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CD6A684C94E8D211DEBA77C00C8D1506C3");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CD6A791570E8D211DEA7D4C00C8D1506C3");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A7A9C10E8D211DEC64BC00C8D1506C3");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A7C22B2E8D211DEC412C00C8D1506C3");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A7C22B3E8D211DEC795C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A7DA951E8D211DE872FC00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A7F2FF2E8D211DE8BD8C00C8D1506C3");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A7F2FF3E8D211DEB44FC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A7F2FF5E8D211DE93FAC00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A80B690E8D211DE9486C00C8D1506C3");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A80B691E8D211DE925CC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A83C3D0E8D211DEBF18C00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6A823D31E8D211DEC4D6C00C8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A854A70E8D211DECDB9C00C8D1506C3");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A854A71E8D211DEC5CDC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A854A74E8D211DEAE1BC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A86D110E8D211DE8912C00C8D1506C3");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A86D111E8D211DE9A60C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A86D114E8D211DE94DAC00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A8857B1E8D211DE8C6EC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A86D118E8D211DEA8F0C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A86D119E8D211DEC90CC00C8D1506C3");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A86D11AE8D211DEB1E2C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A86D11DE8D211DEC388C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD6A89DE50E8D211DE8DD4C00C8D1506C3");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A89DE51E8D211DE89A8C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A89DE54E8D211DEC7B2C00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A8CEB91E8D211DEAB65C00C8D1506C3");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A8CEB92E8D211DE8B08C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A8CEB94E8D211DEC923C00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A8FF8D0E8D211DE9D9DC00C8D1506C3");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A8FF8D1E8D211DEBC99C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A8FF8D3E8D211DE98B1C00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A917F70E8D211DEA8C5C00C8D1506C3");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A917F71E8D211DECC5BC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A930614E8D211DE8EF6C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A930610E8D211DE8E09C00C8D1506C3");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6A930612E8D211DEC86FC00C8D1506C3");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD6A961350E8D211DE95AFC00C8D1506C3");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A961351E8D211DE98B5C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A961353E8D211DEB68EC00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6A9799F0E8D211DEBA75C00C8D1506C3");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A9799F1E8D211DECD58C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A992093E8D211DEC3ECC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A9799F5E8D211DE91BBC00C8D1506C3");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6A992091E8D211DEC174C00C8D1506C3");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD6A9AA731E8D211DECB03C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A9AA732E8D211DECCEFC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A9AA735E8D211DEA6E1C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A9C2DD2E8D211DEAB1DC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6A9AA739E8D211DEAA58C00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A9C2DD0E8D211DEA65CC00C8D1506C3");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6A9AA73BE8D211DEB195C00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6A9C2DD3E8D211DEB3C7C00C8D1506C3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD6A9DB471E8D211DEAC9CC00C8D1506C3");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CD6A9DB474E8D211DE8A71C00C8D1506C3");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CD6A9DB477E8D211DEADA2C00C8D1506C3");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CD6A9F3B11E8D211DE9904C00C8D1506C3");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CD6AA0C1B1E8D211DECFC1C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA0C1B2E8D211DE9FE0C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA24852E8D211DEC718C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA3CEF0E8D211DEB2A2C00C8D1506C3");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AA3CEF4E8D211DE8501C00C8D1506C3");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA55594E8D211DEB45DC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AA55592E8D211DEC48FC00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA55595E8D211DEC4F7C00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA55599E8D211DE89C7C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD6AA55597E8D211DE9B9BC00C8D1506C3");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA5559AE8D211DEBA3BC00C8D1506C3");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AA889E0E8D211DE90F7C00C8D1506C3");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA889E2E8D211DE8FAFC00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA889ECE8D211DEA496C00C8D1506C3");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6AA889E8E8D211DE849BC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA889EAE8D211DEAD2AC00C8D1506C3");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA889EDE8D211DE99C5C00C8D1506C3");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA889F1E8D211DEB079C00C8D1506C3");}(({_beforeSeqEl("E0DCF6CD6AA889EFE8D211DECC1AC00C8D1506C3");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AA889F2E8D211DEA1B0C00C8D1506C3");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AAA1085E8D211DE9F5CC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AAA1083E8D211DEA94CC00C8D1506C3");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AAB9721E8D211DEA713C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AAB9722E8D211DE9646C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AC587C1E8D211DE9C8DC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6ABDE6A0E8D211DE86CFC00C8D1506C3");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AAB9728E8D211DEB8CFC00C8D1506C3");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD6AB952C6E8D211DEAD2BC00C8D1506C3");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AC587C2E8D211DE87FDC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AC587C4E8D211DE92D9C00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AC587C5E8D211DE9CD4C00C8D1506C3");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD6AC89501E8D211DE8F2FC00C8D1506C3");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CD6AC89504E8D211DEB5BBC00C8D1506C3");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CD6ACBA244E8D211DECDD7C00C8D1506C3");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6ACBA241E8D211DEC849C00C8D1506C3");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6ACEAF81E8D211DEA941C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6ACEAF82E8D211DEAF57C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6ACEAF84E8D211DEA9ABC00C8D1506C3");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AD1BCC1E8D211DEB162C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AD34360E8D211DEC56CC00C8D1506C3");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD34361E8D211DEB1E7C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD34363E8D211DEAF87C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD34364E8D211DE9FB0C00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AD4CA00E8D211DEB56FC00C8D1506C3");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD4CA01E8D211DE8A0AC00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD4CA03E8D211DEC713C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD4CA04E8D211DEC0B6C00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AD650A1E8D211DE92E8C00C8D1506C3");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD650A2E8D211DECBA0C00C8D1506C3");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AD650A7E8D211DE9BA5C00C8D1506C3");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6AD650A4E8D211DEADF5C00C8D1506C3");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AD95DE4E8D211DEA1A9C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6ADAE482E8D211DE8D6DC00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6ADC6B23E8D211DEB29EC00C8D1506C3");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6ADC6B25E8D211DEC940C00C8D1506C3");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6ADF7860E8D211DEB075C00C8D1506C3");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6ADF7863E8D211DE8ECBC00C8D1506C3");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AE0FF05E8D211DE9900C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AE0FF03E8D211DE819DC00C8D1506C3");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AE0FF06E8D211DEACB3C00C8D1506C3");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AE0FF08E8D211DEBA5CC00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AE0FF09E8D211DE9679C00C8D1506C3");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AE0FF0BE8D211DEA982C00C8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AE0FF0CE8D211DEB3C4C00C8D1506C3");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AE40C44E8D211DE915CC00C8D1506C3");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6AE40C41E8D211DEAC1BC00C8D1506C3");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AE71981E8D211DEC11EC00C8D1506C3");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AEA26C0E8D211DE819CC00C8D1506C3");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C1E8D211DEA285C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C2E8D211DEAA4BC00C8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C3E8D211DE95C9C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C5E8D211DEA2ABC00C8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C6E8D211DE985AC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C7E8D211DEC13DC00C8D1506C3");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26C8E8D211DE8EC3C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26CAE8D211DEA272C00C8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26D4E8D211DEB237C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AEA26CEE8D211DE8579C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26CFE8D211DECA40C00C8D1506C3");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26D0E8D211DEB9C8C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26D2E8D211DEB763C00C8D1506C3");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEA26D5E8D211DEB0D4C00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AED3400E8D211DE91A5C00C8D1506C3");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AED3401E8D211DE8647C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AED3402E8D211DE93F1C00C8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AED3403E8D211DE855AC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AED3409E8D211DEACD3C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AED3407E8D211DE9371C00C8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AED340BE8D211DE86E3C00C8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AED340CE8D211DE940CC00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AEEBAA2E8D211DEB8ABC00C8D1506C3");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEEBAA3E8D211DE99E0C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEEBAA4E8D211DE8E42C00C8D1506C3");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AEEBAA5E8D211DEB0C7C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF04143E8D211DEC347C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AF04141E8D211DEA93BC00C8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF04145E8D211DEBC9BC00C8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF04146E8D211DEB633C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF04147E8D211DE9C9DC00C8D1506C3");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF04148E8D211DEAEEEC00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF0414EE8D211DE8AA0C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AF0414CE8D211DEC8B4C00C8D1506C3");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF04150E8D211DE8D66C00C8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7F6E8D211DEB136C00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AF1C7E3E8D211DEC17FC00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7E4E8D211DEC649C00C8D1506C3");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7E5E8D211DEAA65C00C8D1506C3");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7E7E8D211DEBF36C00C8D1506C3");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7F4E8D211DE948FC00C8D1506C3");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD6AF1C7EBE8D211DE9667C00C8D1506C3");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7ECE8D211DEA637C00C8D1506C3");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7F1E8D211DE9F9BC00C8D1506C3");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD6AF1C7EEE8D211DE9DD8C00C8D1506C3");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF1C7F2E8D211DEB4A9C00C8D1506C3");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF34E80E8D211DE8C01C00C8D1506C3");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AF65BC1E8D211DE85D7C00C8D1506C3");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF65BC2E8D211DEC4F1C00C8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF65BC4E8D211DE9BCBC00C8D1506C3");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AF7E260E8D211DEBDCDC00C8D1506C3");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF7E261E8D211DE9A94C00C8D1506C3");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6AF7E262E8D211DECE13C00C8D1506C3");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AFAEFA0E8D211DEBAF8C00C8D1506C3");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AFC7640E8D211DEBC69C00C8D1506C3");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6AFF8382E8D211DE9C03C00C8D1506C3");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD6B010A20E8D211DEBEF4C00C8D1506C3");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6B010A22E8D211DEA889C00C8D1506C3");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD6B010A23E8D211DE8D45C00C8D1506C3");} RSQUARE {_afterSeqEl();})
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

        