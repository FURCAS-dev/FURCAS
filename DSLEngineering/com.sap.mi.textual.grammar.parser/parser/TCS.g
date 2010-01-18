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
   private static final String syntaxUUID = "E0DCF6CDDAF2B170EEF511DE8D81F4438D1505E2";
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
  | 'right' {ret = "right";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'omitted' {ret = "omitted";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'end' {ret = "end";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'template' {ret = "template";}
  | 'query' {ret = "query";}
  | 'priority' {ret = "priority";}
  | 'part' {ret = "part";}
  | 'start' {ret = "start";}
  | 'false' {ret = "false";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'for' {ret = "for";}
  | 'function' {ret = "function";}
  | 'value' {ret = "value";}
  | 'never' {ret = "never";}
  | 'using' {ret = "using";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'octal' {ret = "octal";}
  | 'foreach' {ret = "foreach";}
  | 'context' {ret = "context";}
  | 'operators' {ret = "operators";}
  | 'k' {ret = "k";}
  | 'one' {ret = "one";}
  | 'esc' {ret = "esc";}
  | 'refersTo' {ret = "refersTo";}
  | 'token' {ret = "token";}
  | 'and' {ret = "and";}
  | 'nbNL' {ret = "nbNL";}
  | 'mode' {ret = "mode";}
  | 'true' {ret = "true";}
  | 'partial' {ret = "partial";}
  | 'endNL' {ret = "endNL";}
  | 'drop' {ret = "drop";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'deep' {ret = "deep";}
  | 'left' {ret = "left";}
  | 'postfix' {ret = "postfix";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'default' {ret = "default";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'abstract' {ret = "abstract";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'createAs' {ret = "createAs";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'auto' {ret = "auto";}
  | 'keywords' {ret = "keywords";}
  | 'invert' {ret = "invert";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'when' {ret = "when";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'importContext' {ret = "importContext";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'prefix' {ret = "prefix";}
  | 'isDefined' {ret = "isDefined";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'main' {ret = "main";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'lexer' {ret = "lexer";}
  | 'rightNone' {ret = "rightNone";}
  | 'createIn' {ret = "createIn";}
  | 'word' {ret = "word";}
  | 'syntax' {ret = "syntax";}
  | 'multiLine' {ret = "multiLine";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'multi' {ret = "multi";}
  | 'hex' {ret = "hex";}
  | 'lookIn' {ret = "lookIn";}
  | 'serializer' {ret = "serializer";}
  | 'always' {ret = "always";}
  | 'addToContext' {ret = "addToContext";}
  | 'separator' {ret = "separator";}
  | 'leftNone' {ret = "leftNone";}
  | 'startNL' {ret = "startNL";}
  | 'as' {ret = "as";}
  | 'symbols' {ret = "symbols";}
  | 'all' {ret = "all";}
  | 'source' {ret = "source";}
  | 'filter' {ret = "filter";}
  | 'operatored' {ret = "operatored";})
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
  ({_beforeSeqEl("E0DCF6CDD9BF3A80EEF511DE8BE9F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9B1A5F0EEF511DE90E9F4438D1505E2");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9B687F0EEF511DEC1FDF4438D1505E2");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9B77250EEF511DEA3CEF4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDD9BE0201EEF511DEC463F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDD9CD1D31EEF511DEBFEAF4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDD9CEF1F1EEF511DEC125F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CDD9D69310EEF511DEC9CDF4438D1505E2");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D6BA20EEF511DE8A12F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D7F2A0EEF511DE8F46F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9D70840EEF511DE9C12F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D70841EEF511DEA257F4438D1505E2");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D70842EEF511DE83ABF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D70844EEF511DE9E55F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D72F50EEF511DEC4CCF4438D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D819B0EEF511DE9E56F4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9E40090EEF511DEC655F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDD9D840C1EEF511DEC72AF4438D1505E2");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DC1150EEF511DEAEF5F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9D88EE0EEF511DEB6B9F4438D1505E2");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D88EE1EEF511DEBB39F4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9D95230EEF511DEA4E5F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDD9D88EE3EEF511DEBA0BF4438D1505E2");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DB7510EEF511DEA33CF4438D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DCFBB0EEF511DEAD46F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9DC5F71EEF511DEB184F4438D1505E2");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DC5F72EEF511DECDEDF4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DCAD90EEF511DEBC0CF4438D1505E2");}(({_beforeSeqEl("E0DCF6CDD9DC8680EEF511DE9A16F4438D1505E2");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DCAD91EEF511DEB9CFF4438D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DD97F0EEF511DEA3F8F4438D1505E2");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DDE611EEF511DEB588F4438D1505E2");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9E1DDB0EEF511DE9782F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9DE8250EEF511DE94E6F4438D1505E2");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9DEA960EEF511DECC49F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9E03000EEF511DEACD6F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9E11A60EEF511DE807EF4438D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9E4C3E0EEF511DEA7DAF4438D1505E2");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CDD9EBC8C0EEF511DEB650F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9E6BFB2EEF511DEC1D9F4438D1505E2");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDD9E75BF0EEF511DECC71F4438D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9EB7AA0EEF511DEA529F4438D1505E2");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDD9E75BF2EEF511DEC315F4438D1505E2");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDD9F31BC0EEF511DEBFB5F4438D1505E2");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F31BC2EEF511DE8B62F4438D1505E2");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F342D0EEF511DEB1EAF4438D1505E2");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F3DF10EEF511DE8057F4438D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F65012EEF511DE8563F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9F65010EEF511DEAA4AF4438D1505E2");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F69E30EEF511DE8945F4438D1505E2");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F69E32EEF511DEACA6F4438D1505E2");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F6EC50EEF511DE9732F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9F6C541EEF511DE87DAF4438D1505E2");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F71360EEF511DECF62F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F71361EEF511DEC7C9F4438D1505E2");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F71362EEF511DEB64AF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F71365EEF511DE94A7F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F7AFA0EEF511DECF13F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9F76180EEF511DEC21BF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F76181EEF511DEAC44F4438D1505E2");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F76182EEF511DEC859F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F78890EEF511DEB1D2F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F7D6B0EEF511DE84DBF4438D1505E2");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9F93640EEF511DEB8F7F4438D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDD9FB8030EEF511DE8AEEF4438D1505E2");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9FB8031EEF511DEBEA6F4438D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9FBF560EEF511DE87CBF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9FBCE51EEF511DEC308F4438D1505E2");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9FF02A2EEF511DE9D58F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDD9FEDB90EEF511DE879CF4438D1505E2");}(({_beforeSeqEl("E0DCF6CDD9FCDFC0EEF511DEAD54F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9FE8D70EEF511DE8408F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDD9FD2DE0EEF511DEA7F9F4438D1505E2");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDD9FD06D0EEF511DEABD6F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9FEB480EEF511DECA23F4438D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDD9FF02A0EEF511DE9AFAF4438D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDD9FF50C0EEF511DE8392F4438D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA014C91EEF511DECC4CF4438D1505E2");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0173A0EEF511DEC551F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0173A2EEF511DEC0BDF4438D1505E2");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA034860EEF511DEB5F4F4438D1505E2");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA034861EEF511DEC1ACF4438D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0F0830EEF511DEC6FCF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA036F71EEF511DEA8DFF4438D1505E2");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA0655A0EEF511DE8896F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA062E90EEF511DEC261F4438D1505E2");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA062E92EEF511DE9F7DF4438D1505E2");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA078E20EEF511DE9C9EF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA06A3C0EEF511DE9B26F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA06A3C1EEF511DEC205F4438D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA06A3C2EEF511DEADB9F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA06A3C5EEF511DE9792F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA06CAD0EEF511DE806CF4438D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA085170EEF511DEBB4BF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA07DC41EEF511DEAE6FF4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA07DC42EEF511DE98CCF4438D1505E2");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA080350EEF511DEC6F2F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA080353EEF511DEB818F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA080354EEF511DECC0BF4438D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA08C6A0EEF511DE846FF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA089F90EEF511DEB649F4438D1505E2");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA08EDB3EEF511DEC2E6F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA08EDB1EEF511DEC5BAF4438D1505E2");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA09B100EEF511DE8A93F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0962E2EEF511DE8B44F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0962E0EEF511DEBD8EF4438D1505E2");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0989F0EEF511DEB11BF4438D1505E2");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0C4910EEF511DECF60F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA09D811EEF511DE9883F4438D1505E2");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0C2200EEF511DE9044F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA09FF21EEF511DEC05DF4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0BACD0EEF511DE9C4FF4438D1505E2");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0BFAF0EEF511DEA10EF4438D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0D0C60EEF511DE8FD2F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0C9730EEF511DEBFD5F4438D1505E2");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0CBE43EEF511DE959CF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0CBE41EEF511DEB5B1F4438D1505E2");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0D3373EEF511DEBF1BF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0D3371EEF511DEAE47F4438D1505E2");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0D8192EEF511DE95DFF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0D8190EEF511DEB5BFF4438D1505E2");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0E9301EEF511DEC2BCF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0DCFB0EEF511DEB716F4438D1505E2");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0E44E0EEF511DEAEE8F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA0DCFB1EEF511DE9C6FF4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0DF6C2EEF511DE955EF4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA0DCFB3EEF511DEA5A6F4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0FF290EEF511DEB194F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA0FCB80EEF511DE83D8F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA0F5651EEF511DEB3B5F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0F7D62EEF511DEAB52F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA0F5653EEF511DEA644F4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA0FA470EEF511DEC8B3F4438D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA0FCB82EEF511DE81B4F4438D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1019A2EEF511DECB37F4438D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA145F60EEF511DEAC34F4438D1505E2");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA145F61EEF511DEAB35F4438D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA145F62EEF511DEAC85F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA148670EEF511DE933BF4438D1505E2");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA148671EEF511DEAAEEF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA14AD80EEF511DEAB36F4438D1505E2");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA14D490EEF511DECF96F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA14D491EEF511DEC015F4438D1505E2");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA14FBA0EEF511DE976BF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA14FBA2EEF511DE9FDCF4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1570D0EEF511DEA307F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA1522B1EEF511DEBE0FF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1549C0EEF511DEBE7EF4438D1505E2");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1549C1EEF511DECA27F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1549C3EEF511DEC185F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA160D10EEF511DE99BAF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA15BEF1EEF511DECECDF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA15BEF2EEF511DEA648F4438D1505E2");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA15BEF3EEF511DE8CA3F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA15BEF5EEF511DEA82CF4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA171E80EEF511DEAE16F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA16D061EEF511DEB4DEF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA16D062EEF511DE9275F4438D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA16D063EEF511DE84A6F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA16F771EEF511DE9F77F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA17BAC0EEF511DEA91DF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA176CA0EEF511DEC489F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA176CA1EEF511DEC63AF4438D1505E2");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA176CA2EEF511DEC1BFF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA176CA5EEF511DE9DFCF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA17BAC1EEF511DE89A8F4438D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA18A521EEF511DEB29BF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA17E1D1EEF511DE9AEFF4438D1505E2");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA187E11EEF511DECAEAF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA1808E2EEF511DECDEEF4438D1505E2");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA185701EEF511DEC965F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA182FF2EEF511DE9457F4438D1505E2");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA198F82EEF511DEB9B4F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA196870EEF511DEA4F4F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA18F341EEF511DEA3ADF4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA191A52EEF511DECA75F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA18F343EEF511DE9079F4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA194160EEF511DEBCF0F4438D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA198F80EEF511DE8C6EF4438D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA19B692EEF511DE8875F4438D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA1C0080EEF511DEA8EBF4438D1505E2");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C0082EEF511DEB919F4438D1505E2");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C2790EEF511DE9796F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C2791EEF511DE818FF4438D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C4EA0EEF511DEB528F4438D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C9CC0EEF511DEC8F8F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA1C4EA1EEF511DEB5C2F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C75B1EEF511DE9B4FF4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA1C4EA3EEF511DECC2BF4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1C75B2EEF511DE91A0F4438D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA1E7180EEF511DEC0ADF4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1E9891EEF511DEA2E2F4438D1505E2");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA1E7182EEF511DECF15F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA1E9892EEF511DEA400F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA20BB71EEF511DEC347F4438D1505E2");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA2C5430EEF511DE81C0F4438D1505E2");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA304BD0EEF511DE8EBDF4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA3A8500EEF511DEC570F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA37C5E1EEF511DEA28AF4438D1505E2");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"                                                let result = c.lookupElementExtended(?) in"+"                                                if not (result.oclIsInvalid()) then"+"                                                        if(result.oclIsTypeOf(Model::Attribute) or"+"                                                                        result.oclIsTypeOf(Model::Reference)"+"                                                                        or result.oclIsTypeOf(Model::StructureField)) then"+"                                                                Bag{result}     "+"                                                        else            "+"                                                                c.allSupertypes()->prepend(c)->collect("+"                                                                        st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                                te | "+"                                                                                        if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                                te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                        else            "+"                                                                                                false "+"                                                                                        endif"+"                                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"                                                                )"+"                                                        endif "+"                                                else    "+"                                                        c.allSupertypes()->prepend(c)->collect("+"                                                                st | st.oclAsType(Model::Classifier).typedElements->select("+"                                                                        te | "+"                                                                                if te.oclIsTypeOf(Model::AssociationEnd) then"+"                                                                                        te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"                                                                                else"+"                                                                                        false "+"                                                                                endif"+"                                                                        )"+"                                                                )->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"                                                        ) "+"                                                endif"+"                                                        ");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA3A36E1EEF511DE9ADEF4438D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3A5DF1EEF511DEB5B4F4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDDA3BBD81EEF511DEAFE0F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3C59C0EEF511DEA60FF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA3C0BA0EEF511DEC5A0F4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3C32B0EEF511DE948CF4438D1505E2");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA3C0BA2EEF511DE8F21F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3C32B1EEF511DE9FE4F4438D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3CA7E0EEF511DEA160F4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA3E2E80EEF511DE873EF4438D1505E2");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3E2E82EEF511DECD42F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3E2E83EEF511DEBD4DF4438D1505E2");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3E5592EEF511DECF20F4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA3FDC30EEF511DEC27AF4438D1505E2");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA3FDC32EEF511DE904AF4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA400340EEF511DEA4A4F4438D1505E2");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA409F80EEF511DEC748F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA402A50EEF511DEBFD4F4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA405160EEF511DECE3CF4438D1505E2");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA402A52EEF511DECC56F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA405161EEF511DECD8CF4438D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA40EDA0EEF511DEB00EF4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA42E970EEF511DEC470F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA42E972EEF511DEA6C5F4438D1505E2");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA431080EEF511DEB3F1F4438D1505E2");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA431082EEF511DEA532F4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA435EA0EEF511DEA081F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA433791EEF511DEC0C5F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA433793EEF511DEC4F6F4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA435EA1EEF511DE8FFAF4438D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA4385B1EEF511DE82D5F4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA44BE30EEF511DEBF29F4438D1505E2");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA44E541EEF511DE9B53F4438D1505E2");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA44BE32EEF511DEBEEBF4438D1505E2");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA453360EEF511DE83E9F4438D1505E2");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA455A73EEF511DECA0BF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA455A71EEF511DECDF6F4438D1505E2");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA458182EEF511DEAC63F4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA472F32EEF511DEC7A6F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA470820EEF511DEAF92F4438D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA470821EEF511DEBB09F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA470824EEF511DE87D7F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA472F30EEF511DEC139F4438D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA475641EEF511DEB2B5F4438D1505E2");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA48DCE0EEF511DEC285F4438D1505E2");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA48DCE3EEF511DE89D1F4438D1505E2");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA492B02EEF511DE9FFCF4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA4AB1A0EEF511DE82B3F4438D1505E2");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA4AD8B3EEF511DE8978F4438D1505E2");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA4AD8B0EEF511DEB2F0F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA4AFFC0EEF511DE90EEF4438D1505E2");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA4B26D0EEF511DE8E1EF4438D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA4EA941EEF511DEB054F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA4FE1C0EEF511DE9C1EF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA4F1E70EEF511DE88AEF4438D1505E2");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA4F1E72EEF511DEB246F4438D1505E2");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5008D0EEF511DE8AACF4438D1505E2");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA516861EEF511DEAE98F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA51DD90EEF511DEB165F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA518F73EEF511DEC3F4F4438D1505E2");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA51B681EEF511DEB617F4438D1505E2");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA51DD91EEF511DE8E61F4438D1505E2");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA51DD92EEF511DEAD00F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5204A2EEF511DE8ABFF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA522BB0EEF511DECD29F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA542781EEF511DE89FDF4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA549CB2EEF511DE8D9BF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA544E91EEF511DE9483F4438D1505E2");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA549CB0EEF511DEB55DF4438D1505E2");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA54C3C0EEF511DE9190F4438D1505E2");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA54C3C1EEF511DEA420F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA54C3C4EEF511DEA181F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA556000EEF511DEA77AF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA5511E2EEF511DEBCC5F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5511E3EEF511DEA018F4438D1505E2");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5511E4EEF511DEC4B8F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5538F2EEF511DE81DFF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA593090EEF511DEA315F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA558712EEF511DE9A80F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA55D531EEF511DECB5CF4438D1505E2");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA55AE21EEF511DEAFE8F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5957A0EEF511DEA504F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA5AB731EEF511DEBEDEF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA5A9020EEF511DEB960F4438D1505E2");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5A9021EEF511DEC351F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5A9024EEF511DE85F2F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5A9025EEF511DEACBCF4438D1505E2");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5B2C60EEF511DE8F7BF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA5ADE43EEF511DE8A6EF4438D1505E2");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5ADE44EEF511DEC3D5F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5B0551EEF511DEC2FDF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5B0552EEF511DE9034F4438D1505E2");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5BC8A0EEF511DE95F3F4438D1505E2");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5BC8A1EEF511DEAD55F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5BEFB1EEF511DE935CF4438D1505E2");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA5F4B10EEF511DEC6A7F4438D1505E2");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5F7220EEF511DEBC63F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA5F7223EEF511DEA030F4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA608390EEF511DEB5D2F4438D1505E2");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA608391EEF511DEB21DF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA658CA0EEF511DEB99CF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA651770EEF511DEB8BAF4438D1505E2");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA651771EEF511DE9082F4438D1505E2");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA656591EEF511DE8A2DF4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA653E82EEF511DE83DDF4438D1505E2");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDDA676160EEF511DE9084F4438D1505E2");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA676161EEF511DEA45CF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA678871EEF511DECA93F4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA676164EEF511DEC0E4F4438D1505E2");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA68E800EEF511DE83B9F4438D1505E2");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA68E801EEF511DE8728F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA690F14EEF511DE8E96F4438D1505E2");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"                                                                                and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"                                                                                        ->prepend(self.property.propertyReference.strucfeature.type)"+"                                                                                        ->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"                                                                                and ("+"                                                                                        if (not self.property.propertyArgs->select("+"                                                                                                        arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"                                                                                                ) "+"                                                                                        then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = "+"                                                                                                        self.property.propertyArgs->select("+"                                                                                                                arg | arg.oclIsTypeOf(TCS::ModePArg))"+"                                                                                                                        .oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"                                                                                                        .mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"                                                                                        endif"+"                                                                                )"+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA6A2080EEF511DECA1BF4438D1505E2");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA6A2081EEF511DE877BF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA6A2083EEF511DEA059F4438D1505E2");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA6C1C50EEF511DECC70F4438D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA6C1C51EEF511DEA221F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA6C1C54EEF511DEB7CBF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA6D06B0EEF511DEA1D6F4438D1505E2");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA6D06B1EEF511DECD95F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA6D06B3EEF511DEC836F4438D1505E2");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDDA708920EEF511DEA263F4438D1505E2");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CDDA754411EEF511DE9AC5F4438D1505E2");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CDDA754414EEF511DEB21AF4438D1505E2");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CDDA79B0E0EEF511DECFE9F4438D1505E2");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA7B5E90EEF511DEB694F4438D1505E2");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA7D0C40EEF511DE8CECF4438D1505E2");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA7D0C41EEF511DEC1FFF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA7D0C43EEF511DEBAC7F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA7EE100EEF511DECE9FF4438D1505E2");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA7EE101EEF511DEA281F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA7EE103EEF511DEBB52F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA8067A0EEF511DEBE86F4438D1505E2");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8067A1EEF511DEA4D6F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA808EB2EEF511DEC9ADF4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA8067A4EEF511DECF5EF4438D1505E2");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA81A020EEF511DECB5CF4438D1505E2");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA81A021EEF511DEBB76F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA81A024EEF511DEC842F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA834DD0EEF511DE93EBF4438D1505E2");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA834DD1EEF511DEC963F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA834DD4EEF511DE9152F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA83C300EEF511DEBFFEF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA8374E3EEF511DECDFEF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8374E4EEF511DEAB3FF4438D1505E2");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA839BF0EEF511DE9BD1F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA839BF3EEF511DEBD7EF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDDA8570B0EEF511DE82FCF4438D1505E2");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8570B1EEF511DEB9E1F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8570B4EEF511DE89E4F4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA87E1B0EEF511DE8576F4438D1505E2");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA87E1B1EEF511DEC312F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA87E1B3EEF511DEBAE1F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA88F320EEF511DEAEA6F4438D1505E2");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA88F321EEF511DECEF1F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA88F323EEF511DE953EF4438D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA8AA0D0EEF511DEBCF3F4438D1505E2");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8AA0D1EEF511DECC03F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8AEEF0EEF511DE9470F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA8AC7E1EEF511DEBED1F4438D1505E2");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA8AC7E3EEF511DE961EF4438D1505E2");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDDA8C9CA0EEF511DECF16F4438D1505E2");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8CC3B0EEF511DEB9F3F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8CC3B2EEF511DE8FBFF4438D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA8DAE10EEF511DEA693F4438D1505E2");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8DAE11EEF511DEB755F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA8DFC31EEF511DEB7C9F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA8DD521EEF511DEB39DF4438D1505E2");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA8DD523EEF511DEAABDF4438D1505E2");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDDA901F11EEF511DECD7CF4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA901F12EEF511DEA45CF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA904622EEF511DEC5BDF4438D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA90BB51EEF511DE8D62F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA909440EEF511DEA1E3F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA909445EEF511DEB86FF4438D1505E2");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDA909442EEF511DEA950F4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA90E260EEF511DE8E03F4438D1505E2");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDDA93A180EEF511DEA930F4438D1505E2");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CDDA93A183EEF511DE9691F4438D1505E2");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CDDA93C891EEF511DEACF8F4438D1505E2");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CDDA948BE1EEF511DEBA6CF4438D1505E2");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CDDA961281EEF511DE8524F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA963990EEF511DEA9AEF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9687B1EEF511DE9431F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA96FCE0EEF511DE90AAF4438D1505E2");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA985C70EEF511DE9E25F4438D1505E2");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA988381EEF511DE9A7FF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA985C75EEF511DE933BF4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA988382EEF511DECC33F4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA98AA93EEF511DE804FF4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA98AA91EEF511DE9E73F4438D1505E2");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA98AA94EEF511DECCAFF4438D1505E2");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA9AF480EEF511DEA3CDF4438D1505E2");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9B1B91EEF511DEA3D7F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9B69B0EEF511DEC8A4F4438D1505E2");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDA9B42A2EEF511DEB657F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9B42A4EEF511DE815DF4438D1505E2");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9B69B1EEF511DEAB92F4438D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9B90C2EEF511DE9CA1F4438D1505E2");}(({_beforeSeqEl("E0DCF6CDDA9B90C0EEF511DE83F8F4438D1505E2");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9B90C3EEF511DECB2EF4438D1505E2");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDA9D3E70EEF511DEBF7EF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA9D1763EEF511DE9602F4438D1505E2");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9D3E72EEF511DE9625F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDA9D3E73EEF511DEBFD7F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAA2E3C1EEF511DE9746F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDAA10F00EEF511DEA3C9F4438D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDA9D6584EEF511DE8004F4438D1505E2");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDDAA04BB0EEF511DEA1F1F4438D1505E2");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAA30AD0EEF511DEBD33F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAA30AD2EEF511DEA331F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAA30AD3EEF511DEC851F4438D1505E2");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDDAA46A61EEF511DE82FEF4438D1505E2");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CDDAA49171EEF511DECB72F4438D1505E2");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CDDAA70270EEF511DEA029F4438D1505E2");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDAA6DB61EEF511DEC248F4438D1505E2");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAA94C60EEF511DE9B03F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAA94C61EEF511DEA631F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAA94C63EEF511DEA4AFF4438D1505E2");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAAB2121EEF511DEA846F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAAC0B80EEF511DEA484F4438D1505E2");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAAC0B81EEF511DEBECBF4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAAC0B83EEF511DE8B79F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAAC3290EEF511DEC9C0F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAAE7C80EEF511DE8E15F4438D1505E2");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAAE7C81EEF511DE8B0DF4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAAE7C83EEF511DEA051F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAAEA390EEF511DE89B3F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAB55A51EEF511DE9173F4438D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAB55A52EEF511DECFDEF4438D1505E2");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAB61DA0EEF511DEC088F4438D1505E2");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDAB58160EEF511DEAC5FF4438D1505E2");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAB86792EEF511DEA621F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAB9A011EEF511DECA27F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDABAD890EEF511DE80FDF4438D1505E2");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABAD892EEF511DEBAC1F4438D1505E2");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDABBEA00EEF511DEC417F4438D1505E2");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABC1112EEF511DE80B5F4438D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDABD97B3EEF511DE8FD0F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDABD97B1EEF511DEC184F4438D1505E2");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABDBEC0EEF511DE8ECDF4438D1505E2");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABDBEC2EEF511DE9213F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABDE5D0EEF511DE8533F4438D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABDE5D2EEF511DEAB80F4438D1505E2");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDABDE5D3EEF511DE9AFDF4438D1505E2");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDABF6C70EEF511DEC62CF4438D1505E2");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDABF4561EEF511DE9A3FF4438D1505E2");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAC18F51EEF511DEB7D0F4438D1505E2");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAC5AE00EEF511DEB6EBF4438D1505E2");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5AE01EEF511DE9CE3F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5AE02EEF511DEC326F4438D1505E2");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5AE03EEF511DECA15F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5AE05EEF511DEC140F4438D1505E2");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5D510EEF511DE8ACCF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5D511EEF511DE83C9F4438D1505E2");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5D512EEF511DEA9F2F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5D514EEF511DE831AF4438D1505E2");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC62330EEF511DEAFF9F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDAC5FC21EEF511DE9DB1F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5FC22EEF511DEA5B7F4438D1505E2");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5FC23EEF511DECA49F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC5FC25EEF511DEC88BF4438D1505E2");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC62331EEF511DEBC5BF4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAC7F7F0EEF511DEC741F4438D1505E2");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC7F7F1EEF511DEB2A6F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC7F7F2EEF511DE9ABEF4438D1505E2");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC7F7F3EEF511DEB564F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC81F04EEF511DE89D3F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDAC81F02EEF511DE84ADF4438D1505E2");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC86D20EEF511DEC19CF4438D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAC86D21EEF511DEC994F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDACA1AD0EEF511DEB28CF4438D1505E2");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACA41E0EEF511DE9D9DF4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACA41E1EEF511DEBF70F4438D1505E2");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACA41E2EEF511DECCF8F4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACB0530EEF511DEA9C0F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDACA9000EEF511DE8C91F4438D1505E2");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACB5350EEF511DEA990F4438D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACB5351EEF511DEC2E0F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACB5352EEF511DE9619F4438D1505E2");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACB5353EEF511DEBE4CF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACB7A62EEF511DEC248F4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDACB7A60EEF511DEA9E1F4438D1505E2");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACBA171EEF511DEB89EF4438D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACC64C0EEF511DEA0ACF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDACBA175EEF511DE9F0CF4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACBC880EEF511DEBA4FF4438D1505E2");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACBC881EEF511DEC72DF4438D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACBC883EEF511DE911FF4438D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACC3DB0EEF511DE802AF4438D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDDACBC887EEF511DE9198F4438D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACBEF90EEF511DE84A9F4438D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACC16A0EEF511DEC96CF4438D1505E2");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDDACBEF92EEF511DE9CAFF4438D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACC16A1EEF511DEA50BF4438D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACC64C1EEF511DE8E84F4438D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDACEFCD1EEF511DECB74F4438D1505E2");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACF23E0EEF511DEB90EF4438D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDACF23E2EEF511DE8A33F4438D1505E2");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAD0AA80EEF511DEB1D3F4438D1505E2");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAD0AA81EEF511DE9626F4438D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAD0AA82EEF511DECE37F4438D1505E2");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAD2CD60EEF511DE9DF1F4438D1505E2");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAD3DED0EEF511DEC6F4F4438D1505E2");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAD56572EEF511DEBD92F4438D1505E2");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDDAD872B0EEF511DE8E88F4438D1505E2");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAD872B2EEF511DECC45F4438D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDDAD899C0EEF511DEB67FF4438D1505E2");} RSQUARE {_afterSeqEl();})
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

        