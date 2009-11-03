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
   private static final String syntaxUUID = "E0DCF6CDE579EF41C3A411DEB0A500216A684158";
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
  | 'octal' {ret = "octal";}
  | 'start' {ret = "start";}
  | 'all' {ret = "all";}
  | 'one' {ret = "one";}
  | 'left' {ret = "left";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'refersTo' {ret = "refersTo";}
  | 'never' {ret = "never";}
  | 'deep' {ret = "deep";}
  | 'separator' {ret = "separator";}
  | 'default' {ret = "default";}
  | 'multi' {ret = "multi";}
  | 'template' {ret = "template";}
  | 'operators' {ret = "operators";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'createAs' {ret = "createAs";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'startNL' {ret = "startNL";}
  | 'importContext' {ret = "importContext";}
  | 'addToContext' {ret = "addToContext";}
  | 'value' {ret = "value";}
  | 'rightNone' {ret = "rightNone";}
  | 'serializer' {ret = "serializer";}
  | 'multiLine' {ret = "multiLine";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'token' {ret = "token";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'word' {ret = "word";}
  | 'false' {ret = "false";}
  | 'mode' {ret = "mode";}
  | 'function' {ret = "function";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'end' {ret = "end";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'endNL' {ret = "endNL";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'part' {ret = "part";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'source' {ret = "source";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'lexer' {ret = "lexer";}
  | 'abstract' {ret = "abstract";}
  | 'when' {ret = "when";}
  | 'k' {ret = "k";}
  | 'isDefined' {ret = "isDefined";}
  | 'lookIn' {ret = "lookIn";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'omitted' {ret = "omitted";}
  | 'drop' {ret = "drop";}
  | 'priority' {ret = "priority";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'esc' {ret = "esc";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'operatored' {ret = "operatored";}
  | 'instanceOf' {ret = "instanceOf";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'invert' {ret = "invert";}
  | 'foreach' {ret = "foreach";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'auto' {ret = "auto";}
  | 'and' {ret = "and";}
  | 'leftNone' {ret = "leftNone";}
  | 'nbNL' {ret = "nbNL";}
  | 'leftSpace' {ret = "leftSpace";}
  | 'partial' {ret = "partial";}
  | 'syntax' {ret = "syntax";}
  | 'hex' {ret = "hex";}
  | 'right' {ret = "right";}
  | 'context' {ret = "context";}
  | 'as' {ret = "as";}
  | 'prefix' {ret = "prefix";}
  | 'createIn' {ret = "createIn";}
  | 'main' {ret = "main";}
  | 'always' {ret = "always";}
  | 'query' {ret = "query";}
  | 'using' {ret = "using";}
  | 'for' {ret = "for";}
  | 'postfix' {ret = "postfix";}
  | 'symbols' {ret = "symbols";}
  | 'true' {ret = "true";}
  | 'filter' {ret = "filter";}
  | 'keywords' {ret = "keywords";})
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
  ({_beforeSeqEl("E0DCF6CDE4A86E73C3A411DEC1FF00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE49C8791C3A411DEAA2500216A684158");}( temp=model_namespace {setProperty(ret, "container", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4A14280C3A411DE92BF00216A684158");} DLCOLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4A14282C3A411DEC12A00216A684158");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4A86E71C3A411DE8F9700216A684158");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDE4B45551C3A411DE8E8300216A684158");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4B45557C3A411DEA11800216A684158");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){
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
  ({_beforeSeqEl("E0DCF6CDE4BB8140C3A411DE825400216A684158");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB8142C3A411DE89E600216A684158");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB814DC3A411DEBA0100216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4BB8146C3A411DEAF7F00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB8147C3A411DEA9AA00216A684158");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB8148C3A411DE91AA00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB814AC3A411DEC9B400216A684158");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB814BC3A411DEBCCC00216A684158");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB814EC3A411DEBA7400216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C4F721C3A411DE945100216A684158");}(({_beforeSeqEl("E0DCF6CDE4BB8150C3A411DEC77700216A684158");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C30C3A411DEB65500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4BB8154C3A411DEB23600216A684158");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BB8155C3A411DE948100216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BDCB30C3A411DEB57500216A684158");}(({_beforeSeqEl("E0DCF6CDE4BB8157C3A411DE87CC00216A684158");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4BDCB31C3A411DEBA9000216A684158");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C3CC3A411DE990F00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4C03C34C3A411DECF3400216A684158");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C35C3A411DEBF5A00216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C39C3A411DE9DD300216A684158");}(({_beforeSeqEl("E0DCF6CDE4C03C37C3A411DE9DD300216A684158");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C3AC3A411DEA39900216A684158");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C3EC3A411DE9FFC00216A684158");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C40C3A411DE8A9B00216A684158");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C28623C3A411DEB24900216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4C03C44C3A411DE85EE00216A684158");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C03C45C3A411DEAE9900216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C28620C3A411DEC7A200216A684158");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C28621C3A411DEB9B100216A684158");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C76820C3A411DEA46C00216A684158");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CDE4C9B213C3A411DEA58100216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4C76828C3A411DEA98400216A684158");}( temp=model_classifier {setProperty(ret, "metaReference", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4C7682AC3A411DEA90400216A684158");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4C9B211C3A411DEAAE600216A684158");}( temp=identifier {setProperty(ret, "names", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE4C7682CC3A411DEAB4E00216A684158");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


tcs_template returns[Object ret2]
  :
  (ret=tcs_primitivetemplate
  | ret=tcs_enumerationtemplate
  | ret=tcs_classtemplate
  | ret=tcs_operatortemplate
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
  ({_beforeSeqEl("E0DCF6CDE4D0DE00C3A411DEACB000216A684158");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D0DE02C3A411DE8ECB00216A684158");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D0DE03C3A411DEBE0600216A684158");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D0DE04C3A411DEC85800216A684158");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F03C3A411DEA00800216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4D34F01C3A411DE882D00216A684158");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F04C3A411DEA6AA00216A684158");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F06C3A411DE843E00216A684158");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F0CC3A411DEADE900216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4D34F0AC3A411DEA21000216A684158");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F0DC3A411DEA25B00216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F0EC3A411DEC6D200216A684158");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F0FC3A411DE851D00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F12C3A411DECE3F00216A684158");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F1DC3A411DE8DDE00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4D34F16C3A411DE94A400216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F17C3A411DEA17600216A684158");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F18C3A411DEC82200216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F1BC3A411DE8DA800216A684158");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D34F1EC3A411DE913200216A684158");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D598F1C3A411DEAD8E00216A684158");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4D809F0C3A411DEA01400216A684158");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D809F1C3A411DEC4C400216A684158");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4D809F7C3A411DEC94B00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4D809F5C3A411DEBC8500216A684158");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DA53E8C3A411DEA68500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4DA53E4C3A411DE860700216A684158");}(({_beforeSeqEl("E0DCF6CDE4D809FBC3A411DEB2A800216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DA53E1C3A411DEAD9C00216A684158");}(({_beforeSeqEl("E0DCF6CDE4D80A00C3A411DEBABE00216A684158");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE4D809FDC3A411DEC40000216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DA53E2C3A411DEA2DB00216A684158");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4DA53E6C3A411DEB59E00216A684158");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DA53EBC3A411DEBB8700216A684158");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4DCC4E1C3A411DE864500216A684158");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DCC4E2C3A411DECD9500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DCC4E4C3A411DE9B1700216A684158");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4DCC4E8C3A411DEC3E100216A684158");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35E0C3A411DE944000216A684158");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E63AD9C3A411DEBA9F00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4DF35E4C3A411DE8A7000216A684158");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4DF35EDC3A411DE9C0A00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4DF35E9C3A411DEAF3500216A684158");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35EBC3A411DE940200216A684158");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35F9C3A411DE85CD00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4DF35F1C3A411DE9B7700216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35F2C3A411DECCD900216A684158");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35F3C3A411DEC0E200216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35F6C3A411DE9F6400216A684158");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35F7C3A411DECDA100216A684158");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF3605C3A411DEB69C00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4DF35FDC3A411DE990D00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35FEC3A411DE961F00216A684158");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF35FFC3A411DEA51500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF3602C3A411DEB95400216A684158");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4DF3603C3A411DE927E00216A684158");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E17FD2C3A411DE85B800216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E17FD0C3A411DE870100216A684158");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E17FD8C3A411DEBF4000216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E17FD6C3A411DE8CF700216A684158");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E17FE4C3A411DE8C0100216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E17FE1C3A411DE9A8D00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E17FDFC3A411DE863500216A684158");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E17FE2C3A411DE99B800216A684158");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E3F0D6C3A411DECE2700216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E17FE8C3A411DE916C00216A684158");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E3F0D4C3A411DEB5E500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E17FECC3A411DE9E6900216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E3F0D1C3A411DE83F900216A684158");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E3F0D2C3A411DE8E9600216A684158");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E3F0E3C3A411DE94B100216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E3F0DAC3A411DEC85800216A684158");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E3F0E1C3A411DE925300216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E3F0DFC3A411DEADB800216A684158");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E63AC3C3A411DEC0F900216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E63AC1C3A411DEB19B00216A684158");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E63AC9C3A411DEB6CF00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E63AC7C3A411DEC4F400216A684158");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E63AD7C3A411DEAB4C00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E63ACDC3A411DE8BAC00216A684158");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E63AD5C3A411DE8BC700216A684158");}(({_beforeSeqEl("E0DCF6CDE4E63ACEC3A411DEA01D00216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E63AD3C3A411DEBDDC00216A684158");}(({_beforeSeqEl("E0DCF6CDE4E63AD0C3A411DEC84400216A684158");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E8ABCAC3A411DEBEA300216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4E8ABC6C3A411DEAEC600216A684158");}(({_beforeSeqEl("E0DCF6CDE4E63ADDC3A411DECC9D00216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E8ABC3C3A411DE9F3A00216A684158");}(({_beforeSeqEl("E0DCF6CDE4E8ABC0C3A411DEA74B00216A684158");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E8ABC4C3A411DEC62C00216A684158");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4E8ABC8C3A411DE8A9E00216A684158");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4E8ABCDC3A411DEA8B900216A684158");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4EB1CC0C3A411DE882400216A684158");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC1C3A411DEB29300216A684158");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC2C3A411DEC4E600216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC3C3A411DE8FAF00216A684158");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC4C3A411DEA15500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC7C3A411DEA0E600216A684158");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC8C3A411DE865F00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CC9C3A411DEBA8A00216A684158");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CCAC3A411DE8A4200216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EB1CCCC3A411DEBCAC00216A684158");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66B7C3A411DEAED500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4ED66B1C3A411DEC29B00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66B2C3A411DE807400216A684158");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66B3C3A411DE86F600216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66B5C3A411DEC0FC00216A684158");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66C1C3A411DE838600216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4ED66BBC3A411DEB89C00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66BCC3A411DE9FD600216A684158");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66BDC3A411DE910900216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66BFC3A411DEB19400216A684158");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66CCC3A411DEBFC000216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4ED66C5C3A411DE80F200216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66C6C3A411DE9A8700216A684158");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66C7C3A411DEC10400216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66CAC3A411DE8F6500216A684158");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7B0C3A411DEBA4C00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4ED66D0C3A411DEA3EF00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66D1C3A411DE878F00216A684158");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66D2C3A411DE8DCB00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4ED66D5C3A411DEAED800216A684158");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7B1C3A411DE849F00216A684158");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7C5C3A411DEA63000216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4EFD7B5C3A411DE9A8100216A684158");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4EFD7C3C3A411DEA52600216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4EFD7BAC3A411DE96F000216A684158");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7C1C3A411DE88DB00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4EFD7BFC3A411DEADE000216A684158");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7D5C3A411DEC08400216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE4EFD7D1C3A411DEAAC000216A684158");}(({_beforeSeqEl("E0DCF6CDE4EFD7C9C3A411DE923900216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7CEC3A411DE89C100216A684158");}(({_beforeSeqEl("E0DCF6CDE4EFD7CBC3A411DE961C00216A684158");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7CFC3A411DEBB1200216A684158");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE4EFD7D3C3A411DEC3B500216A684158");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4EFD7D8C3A411DEB8CF00216A684158");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4F221A2C3A411DE853600216A684158");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221A4C3A411DECF1700216A684158");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221A5C3A411DE823100216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221A6C3A411DECC5D00216A684158");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221A7C3A411DE9E7A00216A684158");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221B0C3A411DEC24200216A684158");}(({_beforeSeqEl("E0DCF6CDE4F221A8C3A411DE8D5900216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221ADC3A411DE999800216A684158");}(({_beforeSeqEl("E0DCF6CDE4F221AAC3A411DE887500216A684158");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F221AEC3A411DEA73400216A684158");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4F492A2C3A411DEC2F400216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F492A7C3A411DECC7D00216A684158");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE4F492A4C3A411DEB29300216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE4F492A8C3A411DE9E5400216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4F703A1C3A411DE95F700216A684158");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE4FE0881C3A411DEB61300216A684158");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5007980C3A411DE857000216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE505347EC3A411DEC80200216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5053477C3A411DE824700216A684158");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"		  				let result = c.lookupElementExtended(?) in"+"		  				if not (result.oclIsInvalid()) then"+"		  					if(result.oclIsTypeOf(Model::Attribute) or"+"		  							result.oclIsTypeOf(Model::Reference)"+"		  							or result.oclIsTypeOf(Model::StructureField)) then"+"		  						Bag{result}	"+"		  					else 		"+"		  						c.allSupertypes()->prepend(c)->collect("+"		  							st | st.oclAsType(Model::Classifier).typedElements->select("+"		  								te | "+"		  									if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  										te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  									else		"+"		  										false "+"		  									endif"+"		  								)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"		  						)"+"		  					endif "+"		  				else	"+"		  					c.allSupertypes()->prepend(c)->collect("+"		  						st | st.oclAsType(Model::Classifier).typedElements->select("+"		  							te | "+"		  								if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  									te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  								else"+"		  									false "+"		  								endif"+"		  							)"+"		  						)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"		  					) "+"		  				endif"+"		  					");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE5053479C3A411DE9AEF00216A684158");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE505347CC3A411DE9A3500216A684158");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDE507A571C3A411DEBE7B00216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE507A57DC3A411DECCC500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE507A575C3A411DE97FB00216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE507A57AC3A411DE979B00216A684158");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE507A577C3A411DEC94400216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE507A57BC3A411DE997D00216A684158");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE507A580C3A411DE95C200216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE509EF60C3A411DEAE1600216A684158");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF62C3A411DEC73E00216A684158");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF63C3A411DEBB6A00216A684158");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF66C3A411DE95E500216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE509EF6AC3A411DEC9A000216A684158");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF6CC3A411DEBC9300216A684158");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF6DC3A411DEAE7500216A684158");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF79C3A411DE885200216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE509EF71C3A411DEC24D00216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF76C3A411DEA3FD00216A684158");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE509EF73C3A411DEBAE100216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF77C3A411DE947E00216A684158");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE509EF7CC3A411DE96A800216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE50C6060C3A411DE84FC00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C6062C3A411DEBAF500216A684158");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C6063C3A411DEC5B500216A684158");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C6065C3A411DEC88100216A684158");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C606DC3A411DE965B00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE50C6069C3A411DE9F4800216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C606BC3A411DEA04C00216A684158");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C606EC3A411DE99F600216A684158");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C6071C3A411DEA5F800216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE50C6075C3A411DEBA3700216A684158");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50C607AC3A411DEBF3300216A684158");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE50C6077C3A411DE9B3700216A684158");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED160C3A411DEB2AA00216A684158");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED166C3A411DE852100216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE50ED164C3A411DEB9BE00216A684158");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED169C3A411DE9F0900216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE50ED177C3A411DEC13800216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE50ED170C3A411DE87C600216A684158");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED171C3A411DE826A00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED174C3A411DE984D00216A684158");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED175C3A411DECD8600216A684158");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE50ED179C3A411DEA6BB00216A684158");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5111B50C3A411DEC9A200216A684158");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5111B53C3A411DEAA0F00216A684158");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5111B56C3A411DE8A0500216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5111B5AC3A411DEC1FD00216A684158");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5111B5FC3A411DEA62200216A684158");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE5111B5CC3A411DEA0B600216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5111B60C3A411DEAE6E00216A684158");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5111B63C3A411DEA7D800216A684158");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5138C55C3A411DEBD8400216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5138C5DC3A411DEC27B00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5138C59C3A411DEC91800216A684158");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE5138C5BC3A411DECF3C00216A684158");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE515D641C3A411DEB07E00216A684158");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE515D646C3A411DEA5F300216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE515D64EC3A411DECDC000216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE515D64AC3A411DE920600216A684158");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE515D64CC3A411DE99AB00216A684158");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE515D64FC3A411DE99D600216A684158");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE515D650C3A411DEACFF00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE515D653C3A411DE927100216A684158");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE515D654C3A411DE8F9F00216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5184741C3A411DEC05800216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184749C3A411DEAFC500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5184745C3A411DEA35500216A684158");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE5184747C3A411DECEDF00216A684158");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE518474AC3A411DEB99F00216A684158");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE518474BC3A411DECAA100216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE518474EC3A411DEB67700216A684158");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184759C3A411DE9C4F00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5184752C3A411DECDEB00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184753C3A411DEBF2400216A684158");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184754C3A411DE996400216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184757C3A411DECD7600216A684158");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184764C3A411DEB09D00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE518475DC3A411DE963600216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184762C3A411DEB56D00216A684158");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE518475FC3A411DECB0800216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5184765C3A411DE915400216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE51AB84AC3A411DE8A6B00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE51AB843C3A411DEC59A00216A684158");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB844C3A411DE994500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB847C3A411DE9DD000216A684158");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB848C3A411DE8F8800216A684158");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB855C3A411DEB92C00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE51AB84EC3A411DEBD5A00216A684158");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB84FC3A411DEA50100216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB852C3A411DEA11C00216A684158");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB853C3A411DECF2300216A684158");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB856C3A411DE84F000216A684158");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51AB857C3A411DEA15C00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51D0230C3A411DECA4500216A684158");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ?"+"										and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"											->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"											->includes(self.foreachParent.propertyReference.strucfeature.type)"+"										and ("+"											if(not self.mode.oclIsUndefined()) then"+"												t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"											endif"+"										)									"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"										else"+"											false"+"										endif"+"									endif)"+"								");})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE51F7330C3A411DEA52A00216A684158");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51F7331C3A411DE9DF100216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51F7334C3A411DE89F900216A684158");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE51F7338C3A411DEC54A00216A684158");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE51F7339C3A411DE830000216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5242E2BC3A411DEAC2B00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5242E21C3A411DEB43300216A684158");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5242E22C3A411DECC5600216A684158");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE5242E29C3A411DE957F00216A684158");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE5242E26C3A411DEB6B900216A684158");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDE5242E2FC3A411DE8F2600216A684158");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5242E30C3A411DE9EC800216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5242E36C3A411DEA73300216A684158");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE5242E33C3A411DEB4D100216A684158");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5269F20C3A411DEA35F00216A684158");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5269F21C3A411DEAAED00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5269F26C3A411DE849F00216A684158");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"										and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"											->prepend(self.property.propertyReference.strucfeature.type)"+"											->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"										and ("+"											if (not self.property.propertyArgs->select("+"													arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"												) "+"											then"+"												t.oclAsType(TCS::ClassTemplate).mode = "+"													self.property.propertyArgs->select("+"														arg | arg.oclIsTypeOf(TCS::ModePArg))"+"															.oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"													.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"											endif"+"										)"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"										else"+"											false"+"										endif"+"									endif)"+"								");}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5269F2AC3A411DE8BDD00216A684158");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5269F2BC3A411DE81AF00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5269F2DC3A411DEA31300216A684158");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE528E910C3A411DE948400216A684158");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE528E911C3A411DE9EA300216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE528E914C3A411DE99E900216A684158");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE528E918C3A411DECEA700216A684158");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE528E919C3A411DEC3F300216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE528E91BC3A411DE88F800216A684158");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDE52B5A11C3A411DE93B700216A684158");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CDE5301501C3A411DECBFB00216A684158");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CDE5301504C3A411DECE8B00216A684158");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CDE5328600C3A411DEA77300216A684158");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE534CFF0C3A411DE9FD100216A684158");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE534CFF4C3A411DEA4F800216A684158");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE534CFF5C3A411DEA85500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE534CFF7C3A411DEAE6200216A684158");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE534CFFBC3A411DE918400216A684158");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE534CFFCC3A411DECCCD00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE534CFFEC3A411DEAB4B00216A684158");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE53740F0C3A411DEA1AC00216A684158");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53740F1C3A411DE908600216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53740F7C3A411DE875700216A684158");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE53740F4C3A411DE87C400216A684158");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE53740FBC3A411DEA01100216A684158");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53740FCC3A411DEA83000216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53740FFC3A411DE809200216A684158");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5398AE0C3A411DEC07300216A684158");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AE1C3A411DE988800216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AE4C3A411DEC03800216A684158");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AEFC3A411DECF8B00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5398AE8C3A411DEB48F00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AE9C3A411DEB9A400216A684158");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AEAC3A411DE86C500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AEDC3A411DEC9AC00216A684158");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDE5398AF3C3A411DE9C1800216A684158");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AF4C3A411DEB01E00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5398AF7C3A411DEC27E00216A684158");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE53BFBE2C3A411DEB75A00216A684158");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53BFBE3C3A411DEC9DD00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53BFBE5C3A411DE9E0F00216A684158");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE53BFBE9C3A411DE802500216A684158");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53BFBEAC3A411DEA33400216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53BFBECC3A411DEAD3100216A684158");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE53E6CE0C3A411DEB95A00216A684158");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53E6CE1C3A411DE8EC500216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53E6CE9C3A411DEB5DD00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE53E6CE5C3A411DEAE4D00216A684158");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE53E6CE7C3A411DE80A300216A684158");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDE53E6CEDC3A411DEB1BF00216A684158");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53E6CEEC3A411DE8AC000216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE53E6CF0C3A411DEB85F00216A684158");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE540B6D0C3A411DE966500216A684158");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6D1C3A411DE939F00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6D9C3A411DE820300216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE540B6D5C3A411DEA35400216A684158");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE540B6D7C3A411DEBFB000216A684158");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CDE540B6DEC3A411DEBECC00216A684158");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6DFC3A411DEB70000216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6E2C3A411DEC59E00216A684158");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6EDC3A411DE9A4D00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE540B6E6C3A411DEA8CD00216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6EBC3A411DEB8E000216A684158");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE540B6E8C3A411DEAE1C00216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE540B6EEC3A411DEAA3400216A684158");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDE54327D1C3A411DE98BA00216A684158");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CDE54327D4C3A411DE956400216A684158");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CDE54327D7C3A411DECE1500216A684158");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CDE54327DAC3A411DEC1F000216A684158");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CDE54327DFC3A411DE929C00216A684158");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54327E0C3A411DEB59900216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54327E3C3A411DEBD3300216A684158");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54327E4C3A411DEA4AF00216A684158");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE54571C0C3A411DE96BC00216A684158");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54571C7C3A411DEC35C00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE54571C5C3A411DE828700216A684158");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54571C8C3A411DEC80200216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54571CCC3A411DE89F900216A684158");}(({_beforeSeqEl("E0DCF6CDE54571CAC3A411DEA77800216A684158");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54571CDC3A411DEC34C00216A684158");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE54571D1C3A411DE9A3E00216A684158");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2C0C3A411DEC71400216A684158");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2CAC3A411DECBC000216A684158");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE547E2C6C3A411DEB68A00216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2C8C3A411DE8B9700216A684158");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2CBC3A411DEB9A900216A684158");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2CFC3A411DE805900216A684158");}(({_beforeSeqEl("E0DCF6CDE547E2CDC3A411DEB46800216A684158");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2D0C3A411DE840100216A684158");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE547E2D9C3A411DE88B500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE547E2D7C3A411DE891500216A684158");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2DBC3A411DEBA9B00216A684158");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE547E2DCC3A411DEA73900216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54C9DB1C3A411DEA0BF00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE54A53C9C3A411DE83C600216A684158");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE547E2E2C3A411DEA31E00216A684158");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CDE54A53C7C3A411DEA88300216A684158");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54C9DB2C3A411DEBD6400216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54C9DB4C3A411DECA1B00216A684158");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE54C9DB5C3A411DECCF300216A684158");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CDE54C9DBAC3A411DE86F400216A684158");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CDE54C9DBDC3A411DEC85200216A684158");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CDE54F0EB6C3A411DE9CC000216A684158");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE54F0EB3C3A411DE891E00216A684158");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55158A3C3A411DEA69700216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55158A4C3A411DECC1700216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55158A6C3A411DEBED400216A684158");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55158ABC3A411DE863400216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE553C9A0C3A411DECCA700216A684158");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9A1C3A411DE918F00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9A3C3A411DEBFD600216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9A4C3A411DE874900216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE553C9A8C3A411DE92D700216A684158");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9A9C3A411DE920F00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9ABC3A411DE813800216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9ACC3A411DE9EEA00216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE553C9B1C3A411DE9B7B00216A684158");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9B2C3A411DEA1B700216A684158");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE553C9B7C3A411DE868D00216A684158");}( temp=identifier {setProperty(ret, "supertype", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE553C9B4C3A411DE883D00216A684158");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5563AA4C3A411DEA25700216A684158");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5588491C3A411DEBE3E00216A684158");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5588495C3A411DEB21600216A684158");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5588497C3A411DE8C3C00216A684158");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE558849BC3A411DEA01C00216A684158");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE558849EC3A411DEBC6800216A684158");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55AF595C3A411DEA50A00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE55AF593C3A411DE9CDA00216A684158");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55AF596C3A411DEB3B500216A684158");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55AF598C3A411DEA4F400216A684158");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55AF599C3A411DE939000216A684158");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55AF59BC3A411DECE6D00216A684158");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55AF59CC3A411DEAB0200216A684158");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55AF5A4C3A411DE84D700216A684158");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE55AF5A1C3A411DEB07500216A684158");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55D3F83C3A411DEAF0900216A684158");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55D3F89C3A411DEA46600216A684158");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F8AC3A411DE860300216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F8BC3A411DEBA7C00216A684158");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F8CC3A411DEC52F00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F8EC3A411DEBF6600216A684158");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F8FC3A411DEBCC700216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F90C3A411DE9CDB00216A684158");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F91C3A411DE961A00216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55D3F93C3A411DE92EF00216A684158");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB085C3A411DEAC9500216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE55D3F97C3A411DE84C400216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB080C3A411DEAD0500216A684158");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB081C3A411DE9CB200216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB083C3A411DEBD2E00216A684158");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB086C3A411DE9F4F00216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE55FB08AC3A411DE912E00216A684158");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB08BC3A411DE841200216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB08CC3A411DE9F0200216A684158");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB08DC3A411DE958000216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB093C3A411DEA42600216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE55FB091C3A411DEA19300216A684158");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB095C3A411DE87C900216A684158");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE55FB096C3A411DEA6D400216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5622180C3A411DEB3DA00216A684158");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5622181C3A411DEA31B00216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5622182C3A411DE950700216A684158");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5622183C3A411DEA3B100216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5622189C3A411DECB1100216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5622187C3A411DEC2E100216A684158");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562218BC3A411DEBF3E00216A684158");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562218CC3A411DEA96900216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562218DC3A411DE9C0B00216A684158");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562218EC3A411DEAA4900216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5622194C3A411DEB6EA00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE5622192C3A411DEBDA400216A684158");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5622196C3A411DE9F4300216A684158");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE56221ADC3A411DE9A4F00216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE562219AC3A411DEC7B400216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562219BC3A411DEB4DF00216A684158");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562219CC3A411DE935700216A684158");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE562219EC3A411DEC33200216A684158");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE56221ABC3A411DEC0F000216A684158");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CDE56221A2C3A411DEB1D300216A684158");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE56221A3C3A411DEB2F100216A684158");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE56221A8C3A411DECDF200216A684158");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CDE56221A5C3A411DEAFB100216A684158");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE56221A9C3A411DEC1B300216A684158");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE56221AEC3A411DEBDA700216A684158");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5646B73C3A411DE905200216A684158");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5646B74C3A411DEB4AC00216A684158");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5646B76C3A411DE8C6900216A684158");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5646B7AC3A411DECA1500216A684158");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5646B7BC3A411DEBA6400216A684158");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5646B7CC3A411DEB6F400216A684158");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE566DC70C3A411DEABA700216A684158");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE566DC74C3A411DEB44000216A684158");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE566DC7AC3A411DEAB1100216A684158");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CDE5692660C3A411DEB13600216A684158");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5692662C3A411DE817200216A684158");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CDE5692663C3A411DEBA6500216A684158");} RSQUARE {_afterSeqEl();})
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

	