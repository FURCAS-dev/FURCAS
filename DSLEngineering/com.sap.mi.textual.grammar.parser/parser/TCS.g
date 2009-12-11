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
   private static final String syntaxUUID = "E0DCF6CD9301CB60E66411DEC46AE1868D1505E2";
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
  | 'instanceOf' {ret = "instanceOf";}
  | 'k' {ret = "k";}
  | 'template' {ret = "template";}
  | 'isDefined' {ret = "isDefined";}
  | 'one' {ret = "one";}
  | 'endNL' {ret = "endNL";}
  | 'disambiguate' {ret = "disambiguate";}
  | 'createIn' {ret = "createIn";}
  | 'orKeyword' {ret = "orKeyword";}
  | 'start' {ret = "start";}
  | 'syntax' {ret = "syntax";}
  | 'storeOpTo' {ret = "storeOpTo";}
  | 'nonPrimary' {ret = "nonPrimary";}
  | 'omitted' {ret = "omitted";}
  | 'main' {ret = "main";}
  | 'esc' {ret = "esc";}
  | 'auto' {ret = "auto";}
  | 'enumerationTemplate' {ret = "enumerationTemplate";}
  | 'indentIncr' {ret = "indentIncr";}
  | 'storeRightTo' {ret = "storeRightTo";}
  | 'source' {ret = "source";}
  | 'foreach' {ret = "foreach";}
  | 'rightSpace' {ret = "rightSpace";}
  | 'keywords' {ret = "keywords";}
  | 'priority' {ret = "priority";}
  | 'drop' {ret = "drop";}
  | 'addToContext' {ret = "addToContext";}
  | 'context' {ret = "context";}
  | 'disambiguateV3' {ret = "disambiguateV3";}
  | 'and' {ret = "and";}
  | 'rightNone' {ret = "rightNone";}
  | 'token' {ret = "token";}
  | 'prefix' {ret = "prefix";}
  | 'word' {ret = "word";}
  | 'as' {ret = "as";}
  | 'endOfLine' {ret = "endOfLine";}
  | 'right' {ret = "right";}
  | 'nbNL' {ret = "nbNL";}
  | 'postfix' {ret = "postfix";}
  | 'query' {ret = "query";}
  | 'value' {ret = "value";}
  | 'createAs' {ret = "createAs";}
  | 'importContext' {ret = "importContext";}
  | 'operators' {ret = "operators";}
  | 'multi' {ret = "multi";}
  | 'always' {ret = "always";}
  | 'referenceOnly' {ret = "referenceOnly";}
  | 'false' {ret = "false";}
  | 'serializer' {ret = "serializer";}
  | 'separator' {ret = "separator";}
  | 'for' {ret = "for";}
  | 'end' {ret = "end";}
  | 'lookIn' {ret = "lookIn";}
  | 'leftNone' {ret = "leftNone";}
  | 'all' {ret = "all";}
  | 'filter' {ret = "filter";}
  | 'function' {ret = "function";}
  | 'forcedUpper' {ret = "forcedUpper";}
  | 'default' {ret = "default";}
  | 'multiLine' {ret = "multiLine";}
  | 'when' {ret = "when";}
  | 'startNbNL' {ret = "startNbNL";}
  | 'invert' {ret = "invert";}
  | 'ifmissing' {ret = "ifmissing";}
  | 'mode' {ret = "mode";}
  | 'deep' {ret = "deep";}
  | 'octal' {ret = "octal";}
  | 'hex' {ret = "hex";}
  | 'operatorTemplate' {ret = "operatorTemplate";}
  | 'symbols' {ret = "symbols";}
  | 'abstract' {ret = "abstract";}
  | 'part' {ret = "part";}
  | 'partial' {ret = "partial";}
  | 'refersTo' {ret = "refersTo";}
  | 'using' {ret = "using";}
  | 'left' {ret = "left";}
  | 'operatored' {ret = "operatored";}
  | 'primitiveTemplate' {ret = "primitiveTemplate";}
  | 'startNL' {ret = "startNL";}
  | 'autoCreate' {ret = "autoCreate";}
  | 'never' {ret = "never";}
  | 'lexer' {ret = "lexer";}
  | 'true' {ret = "true";}
  | 'forcedLower' {ret = "forcedLower";}
  | 'leftSpace' {ret = "leftSpace";})
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


qualifiedNameSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=QNAME {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


qualifiedNameSymbolList returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=QNAME {ret = java.util.Arrays.asList(unescapeString( ast.getText()).split("::"));
})
{
ret2=ret;
}
  ;


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
  ({_beforeSeqEl("E0DCF6CD92486670E66411DEB6CBE1868D1505E2");}'syntax'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD924BE8E0E66411DEA8ACE1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD925AB5F0E66411DEB64CE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9257A8B0E66411DEC0E7E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9257A8B1E66411DE932FE1868D1505E2");}'k'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9257A8B2E66411DECCBFE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9257A8B4E66411DE92FFE1868D1505E2");}( temp=integerSymbol {setProperty(ret, "k", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9257CFC0E66411DEC953E1868D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD925CFFE0E66411DECB33E1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9268BFB0E66411DEAEAAE1868D1505E2");}(({_beforeSeqEl("E0DCF6CD925D26F1E66411DEBD39E1868D1505E2");}( temp=tcs_template {setProperty(ret, "templates", temp);} ( temp=tcs_template {setProperty(ret, "templates", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92611E90E66411DEB5E3E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD925D7511E66411DEA1B1E1868D1505E2");}'keywords'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD925D9C20E66411DEB90BE1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD925EFBB0E66411DEB12FE1868D1505E2");}(({_beforeSeqEl("E0DCF6CD925D9C22E66411DEB802E1868D1505E2");}( temp=tcs_keyword {setProperty(ret, "keywords", temp);} ( temp=tcs_keyword {setProperty(ret, "keywords", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9260D070E66411DE8BC2E1868D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92625710E66411DEAA56E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD926193C0E66411DE837EE1868D1505E2");}'symbols'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD926193C1E66411DE9BEEE1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9261E1E0E66411DEA331E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD9261BAD1E66411DEA47DE1868D1505E2");}( temp=tcs_symbol {setProperty(ret, "symbols", temp);} ( temp=tcs_symbol {setProperty(ret, "symbols", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD926208F0E66411DEBA10E1868D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9262A530E66411DE988DE1868D1505E2");}( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);} ( temp=tcs_operatorlist {setProperty(ret, "operatorLists", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92631A60E66411DEC7A2E1868D1505E2");}( temp=tcs_token {setProperty(ret, "tokens", temp);} ( temp=tcs_token {setProperty(ret, "tokens", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9266C3E0E66411DEABCAE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92636880E66411DE8D6AE1868D1505E2");}'lexer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92636881E66411DE82BAE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92658B60E66411DEC8C9E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "lexer", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD926675C0E66411DEA7D4E1868D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD926A1F40E66411DEAFC7E1868D1505E2");} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

reference[Object ret]
  :
  ({_beforeSeqEl("E0DCF6CD9276F080E66411DEAF2DE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92717240E66411DEAF9BE1868D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD926DEFD0E66411DE8C41E1868D1505E2");}( temp=qualifiedNameSymbol {setOclRef(ret, "metaReference", null, temp, "let e=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  					i; acc:Tuple(pos:Integer, ns:Set(Model::Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"            			  e.ns.contents->select(c | c.name=?.subString(e.pos, ?.size()))");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD927087E3E66411DECC5AE1868D1505E2");}( temp=identifier {setOclRef(ret, "metaReference", null, temp, "Classifier.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD9276A260E66411DE9C00E1868D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92731FF0E66411DE919BE1868D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92731FF3E66411DE9837E1868D1505E2");}( temp=qualifiedNameSymbolList {setProperty(ret, "names", temp);} ( temp=qualifiedNameSymbolList {setProperty(ret, "names", temp);})* )? {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92736E10E66411DECC94E1868D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92762D30E66411DEB46DE1868D1505E2");}( temp=identifier {setProperty(ret, "names", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD927AE820E66411DEC4A7E1868D1505E2");}'primitiveTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927B0F30E66411DE8CA4E1868D1505E2");}( temp=identifier {setProperty(ret, "templateName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927B0F31E66411DE8322E1868D1505E2");}'for'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927B8460E66411DEC992E1868D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927DA740E66411DEC172E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD927D8031E66411DEC1ACE1868D1505E2");}'default'{_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927DCE50E66411DEA4B7E1868D1505E2");}'using'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927DCE52E66411DEAC30E1868D1505E2");}( temp=identifier {setProperty(ret, "tokenName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927EDFC0E66411DE842BE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD927EB8B1E66411DEB9CAE1868D1505E2");}'orKeyword'{_afterSeqEl();}){setProperty(ret, "orKeyword", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "orKeyword", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F06D0E66411DE8CC6E1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F06D1E66411DEC2EAE1868D1505E2");}'value'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F06D2E66411DEB57AE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F2DE0E66411DECCD0E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927FF130E66411DE9441E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD927F7C00E66411DE8755E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F7C01E66411DEA84FE1868D1505E2");}'serializer'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F7C02E66411DEA822E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927F7C05E66411DE95CCE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "serializer", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD927FF131E66411DE987BE1868D1505E2");} SEMI {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92801842E66411DEBDBAE1868D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92819EE0E66411DEB1ECE1868D1505E2");}'enumerationTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92819EE1E66411DEB644E1868D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9281ED00E66411DECF98E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9281C5F1E66411DEBBDDE1868D1505E2");}'auto'{_afterSeqEl();}){setProperty(ret, "automatic", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "automatic", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9286CF00E66411DEB7B7E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928680E0E66411DEB30FE1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92823B20E66411DEA28FE1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928632C0E66411DEB1ECE1868D1505E2");}(({_beforeSeqEl("E0DCF6CD9284FA40E66411DEBF74E1868D1505E2");}( temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92823B22E66411DEB978E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_enumliteralmapping {setProperty(ret, "mappings", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928659D0E66411DE81F9E1868D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD9286A7F0E66411DEA742E1868D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9286F612E66411DE91DCE1868D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92879251E66411DEC815E1868D1505E2");}( temp=tcs_enumliteralval {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92879252E66411DE90EBE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92879254E66411DEB4FCE1868D1505E2");}( temp=tcs_literalref {setProperty(ret, "element", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD9288A3C0E66411DE9B3CE1868D1505E2");}'template'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9288A3C1E66411DE96AFE1868D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929267C0E66411DECBBCE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9288F1E0E66411DEA75DE1868D1505E2");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92896711E66411DECD65E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92894000E66411DECF29E1868D1505E2");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92894002E66411DEA2F9E1868D1505E2");}( temp=identifier {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928A2A60E66411DEBE48E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9289B531E66411DE8D09E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9289B532E66411DE8E16E1868D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9289B533E66411DEB629E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9289DC42E66411DE87ACE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928A0350E66411DEAA27E1868D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928AEDB0E66411DEC105E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928A7880E66411DEC6CBE1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928A7881E66411DE9972E1868D1505E2");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928A7882E66411DE8714E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928A7885E66411DE82D0E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928A9F90E66411DEB726E1868D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928B3BD2E66411DE8FC6E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928B3BD0E66411DEB4B5E1868D1505E2");}'multi'{_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928BB100E66411DEBF9DE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928B89F1E66411DEB659E1868D1505E2");}'main'{_afterSeqEl();}){setProperty(ret, "isMain", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMain", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928D1090E66411DEB346E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928C2632E66411DECEA0E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928C2630E66411DE96A3E1868D1505E2");}'deep'{_afterSeqEl();}){setProperty(ret, "isDeep", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isDeep", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928CE980E66411DE9267E1868D1505E2");}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928F0C61E66411DE96EEE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928D37A3E66411DEB4C1E1868D1505E2");}'operatored'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928EE550E66411DE96B1E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928D85C0E66411DE9744E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928E9730E66411DEB097E1868D1505E2");}( temp=identifier {setRef(ret, "operatorList", list("TCS","OperatorList"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928EBE40E66411DE8C61E1868D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isOperatored", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOperatored", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928FCFB1E66411DEBC5BE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928F5A81E66411DE8817E1868D1505E2");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD928FA8A1E66411DE86B9E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD928F8192E66411DE8EE2E1868D1505E2");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92901DD2E66411DE9090E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92901DD0E66411DEA58CE1868D1505E2");}'addToContext'{_afterSeqEl();}){setProperty(ret, "isAddToContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAddToContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92909300E66411DECA51E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92906BF1E66411DEBE3CE1868D1505E2");}'nonPrimary'{_afterSeqEl();}){setProperty(ret, "isNonPrimary", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isNonPrimary", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9291F290E66411DEA25AE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92915650E66411DEB507E1868D1505E2");}'prefix'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9291CB80E66411DEB718E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92915651E66411DEAC1EE1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92917D62E66411DEA191E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92915653E66411DE823DE1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "prefixSequence", temp);}){_afterSeqEl();})){_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92935221E66411DE8D73E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92932B10E66411DEB900E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD9292B5E0E66411DEA8DEE1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9292DCF1E66411DEA041E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD9292B5E2E66411DEBA14E1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "templateSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92930400E66411DE9C6FE1868D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92932B12E66411DEC354E1868D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92937932E66411DE9221E1868D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92941570E66411DECDBAE1868D1505E2");}'operatorTemplate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92941571E66411DEAD0AE1868D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92941572E66411DE9A0AE1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92941573E66411DEB8CEE1868D1505E2");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92941574E66411DEA6E0E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92943C82E66411DE9AE4E1868D1505E2");}( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);} ( temp=identifier {setRef(ret, "operators", list("TCS","Operator"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92946390E66411DE801FE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92946391E66411DEADECE1868D1505E2");}'source'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92946392E66411DEB935E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92946394E66411DEB3ECE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "storeLeftSideTo", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92957500E66411DE8DF4E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92948AA1E66411DE9F63E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92948AA2E66411DE831EE1868D1505E2");}'storeOpTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9294B1B0E66411DE80D8E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9294B1B2E66411DECC70E1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "storeOperatorTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92961140E66411DEB478E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9295C321E66411DEC22BE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9295C322E66411DE9C3AE1868D1505E2");}'storeRightTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9295C323E66411DEC005E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9295C325E66411DECCCAE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "storeRightSideTo", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92968670E66411DEA9C2E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92963851E66411DE8F4DE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92963852E66411DE8A14E1868D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92963853E66411DEC6B2E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92965F62E66411DEB598E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929722B0E66411DE84DDE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9296D491E66411DECD5EE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9296D492E66411DEC22FE1868D1505E2");}'disambiguateV3'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9296D493E66411DE8F16E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9296FBA0E66411DE8E8DE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguateV3", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929749C0E66411DEB721E1868D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92983420E66411DECDCEE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD929770D0E66411DEBDE8E1868D1505E2");}'referenceOnly'{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92980D10E66411DEB92CE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD929797E1E66411DEBFCDE1868D1505E2");}'context'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9297E600E66411DE84E6E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD9297BEF2E66411DEA3E6E1868D1505E2");}( temp=tcs_contexttags {setProperty(ret, "contextTags", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isContext", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContext", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}){setProperty(ret, "isReferenceOnly", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9299BAC2E66411DE9EA8E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD929993B0E66411DEA3B5E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92988240E66411DE9422E1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92996CA0E66411DE9B58E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92988242E66411DEA76EE1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "otSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92996CA1E66411DECA2BE1868D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD9299BAC0E66411DEB2C9E1868D1505E2");} SEMI {_afterSeqEl();}){_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD9299E1D2E66411DEAF4DE1868D1505E2");}( temp=textblockdefinition_textblockdefinition {setProperty(ret, "textBlockDefinition", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD929ACC30E66411DE9967E1868D1505E2");}'function'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929ACC32E66411DE989EE1868D1505E2");}( temp=identifier {setProperty(ret, "functionName", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929ACC33E66411DE80B4E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929AF340E66411DE9BF2E1868D1505E2");}reference[ret]{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929AF341E66411DEA48DE1868D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929B4160E66411DEA4EFE1868D1505E2");}(({_beforeSeqEl("E0DCF6CD929AF342E66411DEC270E1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929B1A51E66411DEC928E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD929AF344E66411DE8ECBE1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "functionSequence", temp);}){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929B1A52E66411DEBAEAE1868D1505E2");} SEMI {_afterSeqEl();})){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD929BB690E66411DEBA1EE1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929BDDA1E66411DE82C6E1868D1505E2");}( temp=identifier {setProperty(ret, "tags", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD929BB692E66411DE9CE0E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setProperty(ret, "tags", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD929C04B0E66411DEC99DE1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD929C52D0E66411DEAD5CE1868D1505E2");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92A30990E66411DE8BAFE1868D1505E2");}( temp=stringSymbol {setRef(ret, "referredLiteral", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AA83A0E66411DECD92E1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92AD69D1E66411DEA607E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92ACF4A3E66411DEB9C2E1868D1505E2");}( temp=identifierOrKeyword {setOclRef(ret, "strucfeature", "name", temp, "OCL:let c = #context.oclAsType(TCS::Template).metaReference in"+"		  				let result = c.lookupElementExtended(?) in"+"		  				if not (result.oclIsInvalid()) then"+"		  					if(result.oclIsTypeOf(Model::Attribute) or"+"		  							result.oclIsTypeOf(Model::Reference)"+"		  							or result.oclIsTypeOf(Model::StructureField)) then"+"		  						Bag{result}	"+"		  					else 		"+"		  						c.allSupertypes()->prepend(c)->collect("+"		  							st | st.oclAsType(Model::Classifier).typedElements->select("+"		  								te | "+"		  									if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  										te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  									else		"+"		  										false "+"		  									endif"+"		  								)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd())"+"		  						)"+"		  					endif "+"		  				else	"+"		  					c.allSupertypes()->prepend(c)->collect("+"		  						st | st.oclAsType(Model::Classifier).typedElements->select("+"		  							te | "+"		  								if te.oclIsTypeOf(Model::AssociationEnd) then"+"		  									te.oclAsType(Model::AssociationEnd).otherEnd().name = ? "+"		  								else"+"		  									false "+"		  								endif"+"		  							)"+"		  						)->collect(ae | ae.oclAsType(Model::AssociationEnd).otherEnd()"+"		  					) "+"		  				endif"+"		  					");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92AD42C0E66411DEC3F5E1868D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AD42C3E66411DE82BFE1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);})? {_afterSeqEl();}){_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD92ADB7F1E66411DE92BCE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AEC961E66411DE8403E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92AE0610E66411DECDDAE1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AE2D20E66411DECC2BE1868D1505E2");}( temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92AE0612E66411DEA098E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_propertyarg {setProperty(ret, "propertyArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AEA250E66411DE8854E1868D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AF1780E66411DE985AE1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92AF65A0E66411DE86E5E1868D1505E2");} LT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AF65A2E66411DEC75DE1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AF65A3E66411DEA9D6E1868D1505E2");} GT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92AF8CB1E66411DE95C5E1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92AFDAD0E66411DE9711E1868D1505E2");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B001E0E66411DE9225E1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "blockSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B001E1E66411DEA125E1868D1505E2");} RSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B09E20E66411DE9E1BE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B028F0E66411DE846CE1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B05001E66411DEABB0E1868D1505E2");}( temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92B028F2E66411DE9280E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_blockarg {setProperty(ret, "blockArgs", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B07710E66411DEBD30E1868D1505E2");} RCURLY {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B11350E66411DE9002E1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B18880E66411DE8C26E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B18882E66411DE9F86E1868D1505E2");}( temp=tcs_expression {setProperty(ret, "condition", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B18883E66411DE8C03E1868D1505E2");} QMARK {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B18885E66411DEBE6FE1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "thenSequence", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B1FDB0E66411DEB4D1E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B1AF93E66411DEB99DE1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B1D6A1E66411DEA156E1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "elseSequence", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B1FDB1E66411DECE9FE1868D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B224C0E66411DE81DAE1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B2C100E66411DEA351E1868D1505E2");} DLSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B2E813E66411DEC6BCE1868D1505E2");}( temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92B2E810E66411DEAC24E1868D1505E2");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_sequenceinalternative {setProperty(ret, "sequences", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B30F20E66411DE984AE1868D1505E2");} DRSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B33633E66411DE9DDAE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B33631E66411DE86C2E1868D1505E2");} STAR {_afterSeqEl();}){setProperty(ret, "isMulti", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isMulti", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B35D42E66411DEB791E1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B42090E66411DE9298E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B3D271E66411DE8C34E1868D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B3D272E66411DEB311E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B3D275E66411DEAF3DE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguate", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B3F980E66411DE822CE1868D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B42092E66411DEC2C5E1868D1505E2");}( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);} ( temp=tcs_sequenceelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B46EB0E66411DEB2D8E1868D1505E2");} DOLLAR {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B46EB3E66411DE89DDE1868D1505E2");}( temp=identifier {setRef(ret, "calledFunction", list("TCS","FunctionTemplate"), "functionName", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B495C2E66411DEC16AE1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B4E3E0E66411DE9FE6E1868D1505E2");} DLCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B50AF1E66411DEB58CE1868D1505E2");}( temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92B4E3E2E66411DE8CF6E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_injectoraction {setProperty(ret, "injectorActions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B53200E66411DEB1A6E1868D1505E2");} DRCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B53203E66411DEA266E1868D1505E2");}{setOclRef(ret, "parentTemplate", null, null, "OCL:#context", true);_exitInjectorAction();}{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B5F551E66411DEBE8BE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B64373E66411DECEC1E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B61C62E66411DE8326E1868D1505E2");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92B64371E66411DE980FE1868D1505E2");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B66A81E66411DE8EAFE1868D1505E2");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B6B8A1E66411DEAE7FE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B706C2E66411DE91DDE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B6DFB2E66411DEC305E1868D1505E2");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92B706C0E66411DEA405E1868D1505E2");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B72DD0E66411DE9B05E1868D1505E2");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B72DD1E66411DEAA43E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B72DD4E66411DE8A88E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B754E0E66411DECAE9E1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92B7A301E66411DEC0ECE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B7F122E66411DEC661E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B7CA12E66411DE8FD6E1868D1505E2");} LARROW {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92B7F120E66411DEB96BE1868D1505E2");} EQ {_afterSeqEl();}){setProperty(ret, "isDefault", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B81830E66411DE86B5E1868D1505E2");}'foreach'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B81831E66411DEB4D1E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B81834E66411DEC8E1E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B929A0E66411DE8A86E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B83F43E66411DE93EAE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B83F44E66411DEB028E1868D1505E2");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B8DB80E66411DEC3F4E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B90291E66411DEB233E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B99ED1E66411DEBC1FE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92B950B2E66411DEC596E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B977C2E66411DE8649E1868D1505E2");}( temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92B950B4E66411DE8295E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_predicatesemantic {setProperty(ret, "predicatesemantic", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92B9C5E0E66411DEA176E1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92BA8930E66411DE8827E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92BA3B11E66411DE8F80E1868D1505E2");}'when'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BA3B12E66411DE8FCFE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BA6220E66411DECEB5E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "when", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BA6221E66411DE9725E1868D1505E2");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BAFE60E66411DEA78BE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92BAB042E66411DEA694E1868D1505E2");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BAB043E66411DEC08CE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BAD750E66411DE8B69E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "mode", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BAD751E66411DEB867E1868D1505E2");} COMA {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BAFE61E66411DEC97AE1868D1505E2");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92BAFE62E66411DE83B7E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92C7A890E66411DE8188E1868D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92BB2574E66411DEB81DE1868D1505E2");}( temp=qualifiedNameSymbol {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"				let e=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  					i; acc:Tuple(pos:Integer, ns:Set(Model::Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"            			  e.ns.contents->select(c | c.name=?.subString(e.pos, ?.size()))->asSequence()->at(1) ="+"										t.oclAsType(TCS::ClassTemplate).metaReference"+"										and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"											->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"											->includes(self.foreachParent.propertyReference.strucfeature.type)"+"										and ("+"											if(not self.mode.oclIsUndefined()) then"+"												t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"											endif"+"										)									"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"										else"+"											false"+"										endif"+"									endif)"+"								");})? {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92BB7391E66411DE8C71E1868D1505E2");}( temp=identifierOrKeyword {setOclRef(ret, "as", null, temp, "OCL:self.foreachParent.injectorActionsBlockReference.parentTemplate.concreteSyntax.templates->select(t | "+"                                                                        if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"                                                                                t.oclAsType(TCS::ClassTemplate).metaReference = ?"+"                                                                                and(t.oclAsType(TCS::ClassTemplate).metaReference).allSupertypes()"+"                                                                                        ->prepend(t.oclAsType(TCS::ClassTemplate).metaReference)"+"                                                                                        ->includes(self.foreachParent.propertyReference.strucfeature.type)"+"                                                                                and ("+"                                                                                        if(not self.mode.oclIsUndefined()) then"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.mode"+"                                                                                        else"+"                                                                                                t.oclAsType(TCS::ClassTemplate).mode = self.foreachParent.mode"+"                                                                                        endif"+"                                                                                )                                                                       "+"                                                                        else"+"                                                                                if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"                                                                                        t.oclAsType(TCS::PrimitiveTemplate).templateName = ?"+"                                                                                else"+"                                                                                        false"+"                                                                                endif"+"                                                                        endif)"+"                                                                ");})? {_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92C81DC2E66411DECC6EE1868D1505E2");}'refersTo'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92C81DC3E66411DEC3F1E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92C844D2E66411DEA7C4E1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92C892F0E66411DE9D28E1868D1505E2");}'lookIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92C892F1E66411DE8757E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CC3C71E66411DEC622E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92CBC741E66411DEC321E1868D1505E2");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CBC742E66411DEBD97E1868D1505E2");}'all'{_afterSeqEl();}){setProperty(ret, "propertyName", new String("#all"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92CC1561E66411DEC8D8E1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92CBEE52E66411DE85DEE1868D1505E2");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();}){}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD92CCD8B0E66411DEC7D5E1868D1505E2");}'createIn'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CCD8B1E66411DE81F7E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CCFFC1E66411DE8091E1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92CCD8B4E66411DEA4F5E1868D1505E2");} POINT {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "propertyName", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92CD4DE1E66411DE86CAE1868D1505E2");}'as'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CD4DE2E66411DE8BFDE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CDC311E66411DEC317E1868D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92CD74F2E66411DEC2C8E1868D1505E2");}( temp=qualifiedNameSymbol {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"				let e=Sequence{1..?.size()}->select(j|?.subString(j, j+1) = '::')->iterate("+"  					i; acc:Tuple(pos:Integer, ns:Set(Model::Namespace), qn:String)=Tuple{pos=1, ns=null, qn=''} |"+"    				let namePart=?.subString(acc.pos, -1+i) in"+"      				Tuple{pos=i+2,"+"      				      ns=if acc.ns=null then"+"            			  	Namespace.allInstances()->select("+"              					ns2 | ns2.container->isEmpty() and ns2.name=namePart)"+"              			  else"+"              			  	acc.ns.contents->select(ns2 | ns2.name=namePart)->asSet()"+"              			  endif,"+"            			  qn=acc.qn.concat('::').concat(namePart)}) in"+"            			  e.ns.contents->select(c | c.name=?.subString(e.pos, ?.size()))->asSequence()->at(1) ="+"										t.oclAsType(TCS::ClassTemplate).metaReference"+"										and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"											->prepend(self.property.propertyReference.strucfeature.type)"+"											->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"										and ("+"											if (not self.property.propertyArgs->select("+"													arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"												) "+"											then"+"												t.oclAsType(TCS::ClassTemplate).mode = "+"													self.property.propertyArgs->select("+"														arg | arg.oclIsTypeOf(TCS::ModePArg))"+"															.oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"													.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"											endif"+"										)"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"										else"+"											false"+"										endif"+"									endif)"+"								");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92CD9C05E66411DEBF63E1868D1505E2");}( temp=identifierOrKeyword {setOclRef(ret, "template", null, temp, "OCL:self.property.parentTemplate.concreteSyntax.templates->select(t | "+"									if(t.oclIsTypeOf(TCS::ClassTemplate)) then "+"										t.oclAsType(TCS::ClassTemplate).metaReference.name = ? "+"										and(self.property.propertyReference.strucfeature.type.allSupertypes()"+"											->prepend(self.property.propertyReference.strucfeature.type)"+"											->includes(t.oclAsType(TCS::ClassTemplate).metaReference))"+"										and ("+"											if (not self.property.propertyArgs->select("+"													arg | arg.oclIsTypeOf(TCS::ModePArg))->isEmpty()"+"												) "+"											then"+"												t.oclAsType(TCS::ClassTemplate).mode = "+"													self.property.propertyArgs->select("+"														arg | arg.oclIsTypeOf(TCS::ModePArg))"+"															.oclAsType(TCS::ModePArg)->asSequence()->at(1)"+"													.mode"+"											else"+"												t.oclAsType(TCS::ClassTemplate).mode.oclIsUndefined()"+"											endif"+"										)"+"									else"+"										if(t.oclIsTypeOf(TCS::PrimitiveTemplate)) then"+"											t.oclAsType(TCS::PrimitiveTemplate).templateName = ? "+"										else"+"											false"+"										endif"+"									endif)"+"								");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92CE1132E66411DEAE39E1868D1505E2");}'separator'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CE1133E66411DE83CDE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CE3840E66411DEC21CE1868D1505E2");}( temp=tcs_sequence {setProperty(ret, "separatorSequence", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92CE5F50E66411DEBC03E1868D1505E2");}'disambiguate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CE5F51E66411DEAC9AE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CE5F54E66411DECD7BE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "disambiguation", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92CEAD70E66411DEB17CE1868D1505E2");}'autoCreate'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CEAD71E66411DE9164E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92CEAD73E66411DE8F02E1868D1505E2");}( temp=tcs_autocreatekind {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_autocreatekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD92D00D00E66411DEB4B1E1868D1505E2");}'always'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "always");}
 | ({_beforeSeqEl("E0DCF6CD92D452C1E66411DE99EFE1868D1505E2");}'ifmissing'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "ifmissing");}
 | ({_beforeSeqEl("E0DCF6CD92D479D0E66411DE8A2DE1868D1505E2");}'never'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","AutoCreateKind"), "never");})
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
  ({_beforeSeqEl("E0DCF6CD92D78710E66411DEB579E1868D1505E2");}'importContext'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92D7AE22E66411DEADE3E1868D1505E2");}'partial'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92D7FC40E66411DEB4EAE1868D1505E2");}'forcedLower'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D7FC41E66411DE83C6E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D7FC43E66411DE846EE1868D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92D82352E66411DE87E9E1868D1505E2");}'forcedUpper'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D82353E66411DE9719E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D84A61E66411DE827CE1868D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92D87171E66411DE9717E1868D1505E2");}'createAs'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D87172E66411DE835BE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D89883E66411DEB22CE1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92D89880E66411DEA6CBE1868D1505E2");} DLCOLON {_afterSeqEl();}){_exitSepSeq();} temp=identifierOrKeyword {setProperty(ret, "name", temp);})* ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92D8E6A0E66411DEB91CE1868D1505E2");}'query'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D8E6A1E66411DEA185E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D90DB1E66411DEC92BE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "query", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92D934C2E66411DEC418E1868D1505E2");}'filter'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D934C3E66411DE86AAE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D95BD2E66411DEC364E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "filter", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D9D100E66411DEA035E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92D982E1E66411DE8DDCE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D982E2E66411DE90D3E1868D1505E2");}'invert'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D982E3E66411DE9F17E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92D9A9F0E66411DEAB71E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "invert", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD92DA1F20E66411DEBBA6E1868D1505E2");}'mode'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DA1F21E66411DEBD56E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DA1F24E66411DECB1AE1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "mode", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92DA6D42E66411DE9718E1868D1505E2");}'nbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DA6D43E66411DE873CE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DA6D45E66411DEBA99E1868D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92DB57A1E66411DEAD2CE1868D1505E2");}'indentIncr'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DB7EB0E66411DE9314E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DB7EB2E66411DECFEBE1868D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92DBA5C1E66411DEB41AE1868D1505E2");}'startNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DBA5C2E66411DECFFEE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DBF3E0E66411DEC424E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92DBCCD1E66411DEAB21E1868D1505E2");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92DBCCD3E66411DEAF82E1868D1505E2");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD92DC4200E66411DEA962E1868D1505E2");}'startNbNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DC4201E66411DEC34DE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DC4203E66411DECFCEE1868D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92DC6912E66411DE821EE1868D1505E2");}'endNL'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DC9020E66411DEBCD4E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DCB732E66411DE9738E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92DC9024E66411DECB6AE1868D1505E2");}'true'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92DCB730E66411DECC15E1868D1505E2");}'false'{_afterSeqEl();}){setProperty(ret, "value", java.lang.Boolean.FALSE);}{_exitAlt();} )
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
  ({_beforeSeqEl("E0DCF6CD92DD0551E66411DEC0CEE1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DD0552E66411DEAC8CE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DD0555E66411DECD36E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DD7A81E66411DEABC3E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92DD2C63E66411DE960EE1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DD5373E66411DEBF3BE1868D1505E2");}( temp=tcs_spacekind {setProperty(ret, "spaces", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92DD5370E66411DE93C8E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_spacekind {setProperty(ret, "spaces", temp);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DDA190E66411DEBFE5E1868D1505E2");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_spacekind returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD92DDC8A3E66411DEA332E1868D1505E2");}'leftSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftSpace");}
 | ({_beforeSeqEl("E0DCF6CD92DDEFB1E66411DECADCE1868D1505E2");}'leftNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "leftNone");}
 | ({_beforeSeqEl("E0DCF6CD92DE16C1E66411DEAA22E1868D1505E2");}'rightSpace'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightSpace");}
 | ({_beforeSeqEl("E0DCF6CD92DE16C4E66411DE828EE1868D1505E2");}'rightNone'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","SpaceKind"), "rightNone");})
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
  ({_beforeSeqEl("E0DCF6CD92DEDA10E66411DEA35BE1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DF0120E66411DEA8C9E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DF0123E66411DE936FE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DF2830E66411DEC182E1868D1505E2");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92DF4F40E66411DEB92AE1868D1505E2");}'operators'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DF7654E66411DEAA9BE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92DF7652E66411DE8F72E1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DF9D60E66411DE9791E1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DFC470E66411DEAEA4E1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92DF9D62E66411DEA204E1868D1505E2");}( temp=tcs_priority {setProperty(ret, "priorities", temp);} ( temp=tcs_priority {setProperty(ret, "priorities", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92DFC471E66411DEA15FE1868D1505E2");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E01290E66411DECFCAE1868D1505E2");}'priority'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E01292E66411DEC94EE1868D1505E2");}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E060B0E66411DE94BDE1868D1505E2");} ({_enterAlt(0);} (){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"left"));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92E039A2E66411DE996BE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E039A4E66411DECC90E1868D1505E2");}( temp=tcs_associativity {setProperty(ret, "associativity", temp);}){_afterSeqEl();}){setProperty(ret, "associativity", createEnumLiteral(list("TCS","Associativity"),"right"));}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E060B1E66411DE9C43E1868D1505E2");} LCURLY {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E087C3E66411DECC0AE1868D1505E2");}(({_beforeSeqEl("E0DCF6CD92E087C1E66411DECF21E1868D1505E2");}( temp=tcs_operator {setProperty(ret, "operators", temp);} ( temp=tcs_operator {setProperty(ret, "operators", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E087C4E66411DE9CC9E1868D1505E2");} RCURLY {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E0FCF3E66411DEADD8E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E0FCF1E66411DEAB51E1868D1505E2");}'postfix'{_afterSeqEl();}){setProperty(ret, "isPostfix", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isPostfix", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E12401E66411DEC06AE1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E12402E66411DEBAC5E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E1C042E66411DEB6A5E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E1C040E66411DEAFB7E1868D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E14B12E66411DEA5C9E1868D1505E2");}( temp=identifier {setRef(ret, "literal", list("TCS","Literal"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92E17226E66411DE8F9CE1868D1505E2");}( temp=stringSymbol {setRef(ret, "literal", list("TCS","Literal"), "value", temp, "#all", "ifmissing", list("TCS","Keyword"), false, null);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E1E750E66411DEC088E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E1E752E66411DE9415E1868D1505E2");}( temp=integerSymbol {setProperty(ret, "arity", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E23570E66411DEB5D2E1868D1505E2");} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

tcs_associativity returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (({_beforeSeqEl("E0DCF6CD92E28391E66411DEACFCE1868D1505E2");}'left'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "left");}
 | ({_beforeSeqEl("E0DCF6CD92E28394E66411DE8197E1868D1505E2");}'right'{_afterSeqEl();}){ret = createEnumLiteral(list("TCS","Associativity"), "right");})
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
  ({_beforeSeqEl("E0DCF6CD92E2F8C0E66411DEBAE6E1868D1505E2");}( temp=tcs_atomexp {setProperty(ret, "expressions", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92E2D1B3E66411DE951AE1868D1505E2");}'and'{_afterSeqEl();}){_exitSepSeq();} temp=tcs_atomexp {setProperty(ret, "expressions", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E346E1E66411DE8DE9E1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E346E2E66411DE9A4EE1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E346E4E66411DECBBCE1868D1505E2");}( temp=tcs_value {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E39501E66411DEBAB4E1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E3BC10E66411DE8A4DE1868D1505E2");}'isDefined'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E3BC11E66411DEB2BAE1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E3BC13E66411DE840CE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E3BC14E66411DEC646E1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E40A30E66411DE8207E1868D1505E2");}'one'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E40A31E66411DEC913E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E40A33E66411DE850DE1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E40A34E66411DE91DDE1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E43143E66411DE9D47E1868D1505E2");}( temp=tcs_propertyreference {setProperty(ret, "propertyReference", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E45850E66411DEA167E1868D1505E2");}'instanceOf'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E4A671E66411DEBA69E1868D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E45853E66411DEB7D5E1868D1505E2");}( temp=qualifiedNameSymbolList {setProperty(ret, "supertype", temp);} ( temp=qualifiedNameSymbolList {setProperty(ret, "supertype", temp);})* ){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0DCF6CD92E47F64E66411DEBCD3E1868D1505E2");}( temp=identifier {setProperty(ret, "supertype", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E4F494E66411DEC06CE1868D1505E2");}( temp=stringSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E569C2E66411DE92C5E1868D1505E2");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E5B7E0E66411DEB11DE1868D1505E2");} MINUS {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E5B7E2E66411DEAED9E1868D1505E2");}( temp=integerSymbol {setProperty(ret, "symbol", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E5DEF0E66411DE89BAE1868D1505E2");} SHARP {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E5DEF3E66411DECA31E1868D1505E2");}( temp=identifierOrKeyword {setProperty(ret, "name", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E65420E66411DE9832E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E62D13E66411DE8DC5E1868D1505E2");}'omitted'{_afterSeqEl();}){setProperty(ret, "isOmitted", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOmitted", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E65421E66411DEBFACE1868D1505E2");}'token'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E65423E66411DEA4B2E1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E65424E66411DEA00EE1868D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E67B30E66411DEA74EE1868D1505E2");}( temp=tcs_orpattern {setProperty(ret, "pattern", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E67B31E66411DEAA52E1868D1505E2");} SEMI {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E6C951E66411DE9945E1868D1505E2");}( temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92E6A243E66411DEA64BE1868D1505E2");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=tcs_simplepattern {setProperty(ret, "simplePatterns", temp);})* )? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E71771E66411DEA536E1868D1505E2");}( temp=tcs_rule {setProperty(ret, "rule", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E73E82E66411DE8183E1868D1505E2");}'word'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E73E83E66411DE9F64E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E73E84E66411DE8738E1868D1505E2");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E76590E66411DEB668E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E76592E66411DEC371E1868D1505E2");}( temp=tcs_orpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E76593E66411DE9970E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E76594E66411DEC2E8E1868D1505E2");}'part'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E76595E66411DEA600E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E76597E66411DEA551E1868D1505E2");}( temp=tcs_orpattern {setProperty(ret, "part", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E7DAC0E66411DEA532E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E7B3B0E66411DEC7ADE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E7B3B1E66411DE873BE1868D1505E2");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E7B3B2E66411DE87E6E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E7B3B4E66411DE918BE1868D1505E2");}( temp=tcs_orpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E7DAC1E66411DEA335E1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E87700E66411DE876EE1868D1505E2");}'endOfLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E87701E66411DE9743E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E87702E66411DE8383E1868D1505E2");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E87703E66411DE8530E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E89E15E66411DE9764E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E89E13E66411DEC4BCE1868D1505E2");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E8C521E66411DEA28EE1868D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E8C522E66411DE9018E1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92E91340E66411DEADF1E1868D1505E2");}'multiLine'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E91341E66411DE9F55E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E91342E66411DEAD95E1868D1505E2");}'start'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E91343E66411DE83F4E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E93A53E66411DECDE6E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E93A51E66411DEA815E1868D1505E2");}'drop'{_afterSeqEl();}){setProperty(ret, "dropStart", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropStart", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E96161E66411DE98BDE1868D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "start", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E96162E66411DEBFA4E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E96163E66411DEBF53E1868D1505E2");}'end'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E96164E66411DE9746E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E98872E66411DECB4AE1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E98870E66411DEBFAFE1868D1505E2");}'drop'{_afterSeqEl();}){setProperty(ret, "dropEnd", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "dropEnd", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E98874E66411DECA63E1868D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "end", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EA4BC1E66411DEA106E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E9AF83E66411DEA725E1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E9AF84E66411DEBC20E1868D1505E2");}'esc'{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E9AF85E66411DE8606E1868D1505E2");} EQ {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E9D691E66411DE95EDE1868D1505E2");}( temp=tcs_stringpattern {setProperty(ret, "esc", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EA24B2E66411DEBC89E1868D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0DCF6CD92E9D695E66411DEC3EBE1868D1505E2");} COMA {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E9D696E66411DECBF3E1868D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92E9FDA4E66411DEB4D6E1868D1505E2");}( temp=tcs_mapping {setProperty(ret, "escMappings", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0DCF6CD92E9FDA1E66411DEBFA5E1868D1505E2");} COMA {_afterSeqEl();}){_exitSepSeq();} temp=tcs_mapping {setProperty(ret, "escMappings", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EA24B0E66411DE8F57E1868D1505E2");} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EA72D0E66411DEAD20E1868D1505E2");} RPAREN {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92EAE801E66411DE830AE1868D1505E2");}( temp=identifier {setProperty(ret, "key", temp);}){_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EAE802E66411DE8820E1868D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EAE804E66411DEB39EE1868D1505E2");}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92EB3620E66411DEA932E1868D1505E2");} POINT {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EB3621E66411DEC1A3E1868D1505E2");} RARROW {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EB3622E66411DE82AAE1868D1505E2");} POINT {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92EBAB50E66411DEB2A0E1868D1505E2");}'octal'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92EBD260E66411DE92F1E1868D1505E2");}'hex'{_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92EBF972E66411DEC2F6E1868D1505E2");}( temp=stringSymbol {setProperty(ret, "name", temp);})? {_afterSeqEl();})
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
  ({_beforeSeqEl("E0DCF6CD92EC2081E66411DE8BF9E1868D1505E2");} LSQUARE {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EC2083E66411DEB7F4E1868D1505E2");}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl("E0DCF6CD92EC4790E66411DE85BDE1868D1505E2");} RSQUARE {_afterSeqEl();})
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
	:	(~ORKEYWORD)=> (ALPHA) (ALPHA | DIGIT)* 
;

QNAME_OR_NAME :
	   ( ORKEYWORD COLON ) => ORKEYWORD { _type = ORKEYWORD; }
	   |    ( SNAME DLCOLON SNAME ) => QNAME { _type = QNAME; }
 	   |	(~ORKEYWORD COLON | SNAME COLON ~(COLON) ) => NAME { _type = NAME; }
 	   |    ( ~ORKEYWORD | SNAME ~COLON ) => NAME { _type = NAME; }
 	   |    ( '\'' SNAME) => NAME { _type = NAME; }
;

fragment 
ORKEYWORD :
	'orKeyword'
;

fragment
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

fragment
QNAME
        : SNAME DLCOLON SNAME (DLCOLON SNAME )*
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

	