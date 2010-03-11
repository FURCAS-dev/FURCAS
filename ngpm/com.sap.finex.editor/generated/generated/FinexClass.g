grammar FinexClass;
options {superClass=ObservableInjectingParser;}

@lexer::header {
package generated;
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
package generated;
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
   private static final String syntaxUUID = "E0677A9A9881FC9B2B8311DFB37BC07B8D1505E2";
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


firstLowercaseIdentifier returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FIRST_LOWERCASE_NAME {ret = unescapeString( ast.getText());
})
{
ret2=ret;
}
  ;


firstUppercaseIdentifier returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FIRST_UPPERCASE_NAME {ret = unescapeString( ast.getText());
})
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


longSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=INT {ret = Long.valueOf( ast.getText());
})
{
ret2=ret;
}
  ;


integerAsStringSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=INT {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


floatAsStringSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=FLOAT {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


booleanSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=BOOL {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


binarySymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=BINARY {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


dateSymbol returns[Object ret2] @init{java.lang.Object ret=null;}
  :
  (ast=DATE {ret =  ast.getText();
})
{
ret2=ret;
}
  ;


main returns[Object ret2]
  :
  ((ret=structure_finexclass) EOF) 
  {
ret2=ret;
}
  ;


structure_finexclass returns[Object ret2] @init{List<String> metaType=list("structure","FinexClass");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A97F721B32B8311DFA415C07B8D1505E2");}classdeclaration[ret]{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_type_field returns[Object ret2]
  :
  (ret=structure_finexclass_field)
  {
ret2=ret;
 }
  ;


structure_finexclass_field returns[Object ret2] @init{List<String> metaType=list("structure","FinexClass");
onEnterTemplateRule(metaType,"field");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A97F8A8502B8311DF94B8C07B8D1505E2");}classdeclaration[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A97F8A8532B8311DF904FC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:#context(field).oclAsType(structure::Field).association.clazz", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

classdeclaration[Object ret]
  :
  ({_beforeSeqEl("E0677A9A97F8A85C2B8311DFA935C07B8D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97F8A85A2B8311DF8B5CC07B8D1505E2");}'value'{_afterSeqEl();}){setProperty(ret, "valueType", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "valueType", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2EF42B8311DF9CE7C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97F8A85F2B8311DFA3EEC07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FA2EF22B8311DFC559C07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2EF52B8311DFC9D7C07B8D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2F092B8311DFC965C07B8D1505E2");}(({_beforeSeqEl("E0677A9A97FA2F072B8311DF8575C07B8D1505E2");}((structure_association) => {_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FA2EF82B8311DF95B1C07B8D1505E2");}( temp=structure_association {setProperty(ret, "associations", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2EF92B8311DF9CADC07B8D1505E2");} SEMICOLON {_afterSeqEl();}){_exitAlt();} 
  |(behavior_functions_function) => {_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FA2EFD2B8311DF9214C07B8D1505E2");}( temp=behavior_functions_function {setProperty(ret, "functions", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2EFE2B8311DFB098C07B8D1505E2");} SEMICOLON {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl("E0677A9A97FA2F002B8311DF9C13C07B8D1505E2");} LBRACKET {_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2F032B8311DFB44AC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "invariants", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2F042B8311DF91DDC07B8D1505E2");} RBRACKET {_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2F052B8311DFAB81C07B8D1505E2");} SEMICOLON {_afterSeqEl();}){_exitAlt();} )*{_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2F0A2B8311DFBE65C07B8D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0677A9A97FA2F132B8311DFA34DC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FA2F0D2B8311DFAC6BC07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FA2F112B8311DF8A63C07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
{
  }

  ;


structure_type returns[Object ret2]
  :
  (ret=structure_finexclass)
  {
ret2=ret;
 }
  ;


structure_association returns[Object ret2] @init{List<String> metaType=list("structure","Association");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A97FBB5962B8311DFAB78C07B8D1505E2");}( temp=structure_field {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FD3C3B2B8311DF8395C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FBB5972B8311DF880DC07B8D1505E2");}'opposite'{_afterSeqEl();}{_beforeSeqEl("E0677A9A97FD3C332B8311DFA512C07B8D1505E2");}( temp=structure_field_opposite {setProperty(ret, "ends", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FD3C392B8311DFB113C07B8D1505E2");}( temp=structure_field_nondeclaredOpposite {setProperty(ret, "ends", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FD3C3E2B8311DFCA67C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:if self.ends->last().name.size() > 0 then"+"		                        self.ends->first().name.concat(' opposite ').concat(self.ends->last().name)"+"		                      else"+"		                        self.ends->first().name"+"		                      endif", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_field returns[Object ret2] @init{List<String> metaType=list("structure","Field");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"field"}) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A97FEC2D82B8311DF92DCC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FD3C432B8311DF9C6BC07B8D1505E2");} DOT {_afterSeqEl();}{_beforeSeqEl("E0677A9A97FEC2D12B8311DFCD1EC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FEC2D32B8311DFB117C07B8D1505E2");} DDOT {_afterSeqEl();}{_beforeSeqEl("E0677A9A97FEC2D62B8311DFB581C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "singleMultiplicity", false);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9800498F2B8311DFB226C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FEC2E72B8311DFC1F5C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FEC2DB2B8311DF97D3C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FEC2DE2B8311DFA77BC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FEC2E22B8311DFB14FC07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FEC2E52B8311DFCB84C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "mandatory", true);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FEC2F42B8311DF83E2C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A97FEC2EC2B8311DFAC62C07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A97FEC2F22B8311DF9343C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A97FEC2F52B8311DF9BC2C07B8D1505E2");}askey[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A980049792B8311DFC852C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980049702B8311DFB231C07B8D1505E2");}'DEFAULT'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980049722B8311DFB364C07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "defaultValue", temp);})? {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980049742B8311DF9951C07B8D1505E2");} ASSIGN {_afterSeqEl();}{_beforeSeqEl("E0677A9A980049762B8311DFBC3AC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "determination", temp);})? {_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} (){_exitAlt();} ){_afterSeqEl();}){_exitAlt();} 
  |(structure_type_field) => {_enterAlt(1);} ({_beforeSeqEl("E0677A9A9800497D2B8311DFB7F8C07B8D1505E2");}( temp=structure_type_field {setProperty(ret, "type", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A980049802B8311DFCA36C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.type.name", true);_exitInjectorAction();}{_afterSeqEl();}{_beforeSeqEl("E0677A9A980049812B8311DF873CC07B8D1505E2");}askey[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9800498D2B8311DFA361C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980049822B8311DFB47CC07B8D1505E2");}'DEFAULT'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980049852B8311DF886CC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "defaultValue", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980049872B8311DFCD48C07B8D1505E2");} ASSIGN {_afterSeqEl();}{_beforeSeqEl("E0677A9A9800498A2B8311DFC6CFC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "determination", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} (){_exitAlt();} ){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A980049922B8311DF9016C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_field_opposite returns[Object ret2] @init{List<String> metaType=list("structure","Field");
onEnterTemplateRule(metaType,"opposite");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9801D0122B8311DF8301C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9801D01B2B8311DFC9EAC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_field_nondeclaredOpposite returns[Object ret2] @init{List<String> metaType=list("structure","Field");
onEnterTemplateRule(metaType,"nondeclaredOpposite");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A980356BA2B8311DFC90AC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "name", "");_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", false);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.association.clazz", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

askey[Object ret]
  :
  ({_beforeSeqEl("E0677A9A9807EA942B8311DFC6D4C07B8D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0677A9A9807EA912B8311DFB7D1C07B8D1505E2");}'AS'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9807EA922B8311DF850DC07B8D1505E2");}'KEY'{_afterSeqEl();}){setProperty(ret, "key", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "key", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


behavior_functions_function returns[Object ret2] @init{List<String> metaType=list("behavior","functions","Function");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9809713B2B8311DFAAEFC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980971302B8311DFC9AFC07B8D1505E2");}'function'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980971312B8311DF9073C07B8D1505E2");}functionheader[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A980971332B8311DF9AEBC07B8D1505E2");}( temp=behavior_functions_signatureimplementation {setProperty(ret, "implementation", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980971352B8311DF993FC07B8D1505E2");}'manipulator'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980971362B8311DF95F3C07B8D1505E2");}functionheader[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A980971392B8311DFBDF8C07B8D1505E2");}( temp=behavior_functions_signatureimplementation_manipulator {setProperty(ret, "implementation", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

functionheader[Object ret]
  :
  ({_beforeSeqEl("E0677A9A980AF7D82B8311DFB44EC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980971412B8311DFBFC1C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980AF7D22B8311DF8E41C07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl("E0677A9A980AF7D62B8311DF830FC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "name", "");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A980AF7D92B8311DFA22CC07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A980C7E732B8311DFC2B1C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980AF7DA2B8311DF920FC07B8D1505E2");}'IN'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980AF7E12B8311DFB4A2C07B8D1505E2");}( temp=behavior_functions_parameter_IN {setProperty(ret, "parameters", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A980AF7DD2B8311DF8F09C07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=behavior_functions_parameter_IN {setProperty(ret, "parameters", temp);})* ){_afterSeqEl();}{_beforeSeqEl("E0677A9A980AF7ED2B8311DF8B11C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980AF7E22B8311DF896EC07B8D1505E2");}','{_afterSeqEl();}{_beforeSeqEl("E0677A9A980AF7E32B8311DFA1B9C07B8D1505E2");}'OUT'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980AF7EA2B8311DFB12DC07B8D1505E2");}( temp=behavior_functions_parameter_OUT {setProperty(ret, "parameters", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A980AF7E62B8311DFBC85C07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=behavior_functions_parameter_OUT {setProperty(ret, "parameters", temp);})* ){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} (){_exitAlt();} ){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980AF7EF2B8311DF9E9EC07B8D1505E2");}'OUT'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980C7E712B8311DF9D68C07B8D1505E2");}( temp=behavior_functions_parameter_OUT {setProperty(ret, "parameters", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A980AF7F22B8311DFC8F7C07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=behavior_functions_parameter_OUT {setProperty(ret, "parameters", temp);})* ){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A980C7E742B8311DF8C1EC07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A980C7E752B8311DF9F75C07B8D1505E2");} COLON {_afterSeqEl();})
{
  }

  ;


parameter[Object ret]
  :
  ({_beforeSeqEl("E0677A9A980E05182B8311DF81BAC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980E05122B8311DF9699C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980E05162B8311DFB03FC07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A980E05252B8311DFA08BC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980E051D2B8311DF94BFC07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A980E05232B8311DFC0A7C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "type", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A980F8BB72B8311DFCCC5C07B8D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0677A9A980F8BB32B8311DF9FE7C07B8D1505E2");}'DEFAULT'{_afterSeqEl();}{_beforeSeqEl("E0677A9A980F8BB52B8311DF867CC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "defaultValue", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


behavior_functions_parameter_IN returns[Object ret2] @init{List<String> metaType=list("behavior","functions","Parameter");
onEnterTemplateRule(metaType,"IN");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A981112502B8311DFA553C07B8D1505E2");}parameter[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A981112532B8311DF9B2CC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "direction", behavior.functions.DirectionEnum.IN);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_functions_parameter_OUT returns[Object ret2] @init{List<String> metaType=list("behavior","functions","Parameter");
onEnterTemplateRule(metaType,"OUT");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A981298F02B8311DFC3E9C07B8D1505E2");}parameter[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A981298F32B8311DFB84BC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "direction", behavior.functions.DirectionEnum.OUT);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_functions_signatureimplementation returns[Object ret2]
  :
  (ret=behavior_actions_block)
  {
ret2=ret;
 }
  ;


behavior_actions_block returns[Object ret2] @init{List<String> metaType=list("behavior","actions","Block");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9815A6302B8311DF98D9C07B8D1505E2");} LCURL {_afterSeqEl();}{_beforeSeqEl("E0677A9A9815A6342B8311DFA266C07B8D1505E2");}(({_beforeSeqEl("E0677A9A9815A6322B8311DF9B7DC07B8D1505E2");}( temp=behavior_actions_statement {setProperty(ret, "statements", temp);} ( temp=behavior_actions_statement {setProperty(ret, "statements", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0677A9A9815A6352B8311DFC60BC07B8D1505E2");} RCURL {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_functions_signatureimplementation_manipulator returns[Object ret2]
  :
  (ret=behavior_actions_manipulator_manipulator)
  {
ret2=ret;
 }
  ;


behavior_actions_manipulator_manipulator returns[Object ret2] @init{List<String> metaType=list("behavior","actions","Manipulator");
onEnterTemplateRule(metaType,"manipulator");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A98172CD02B8311DF8698C07B8D1505E2");} LCURL {_afterSeqEl();}{_beforeSeqEl("E0677A9A98172CD82B8311DFC844C07B8D1505E2");}(({_beforeSeqEl("E0677A9A98172CD62B8311DF8122C07B8D1505E2");}( temp=behavior_actions_assignment_manipulator {setProperty(ret, "assignments", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A98172CD32B8311DFAAFDC07B8D1505E2");} PIPE {_afterSeqEl();}){_exitSepSeq();} temp=behavior_actions_assignment_manipulator {setProperty(ret, "assignments", temp);})* ){_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E0677A9A98172CD92B8311DF882FC07B8D1505E2");} RCURL {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_actions_statement returns[Object ret2]
  :
  (ret=behavior_actions_statementwithargument
  | ret=behavior_actions_expressionstatement)
  {
ret2=ret;
 }
  ;


behavior_actions_statementwithargument returns[Object ret2]
  :
  ((DOT (FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME) EQUALS)=>(ret=behavior_actions_assignment))
  {
ret2=ret;
 }
  ;


behavior_actions_assignment returns[Object ret2] @init{List<String> metaType=list("behavior","actions","Assignment");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A981D47502B8311DF92ECC07B8D1505E2");}assignment[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A981D47512B8311DFBB5EC07B8D1505E2");} SEMICOLON {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_actions_assignment_manipulator returns[Object ret2] @init{List<String> metaType=list("behavior","actions","Assignment");
onEnterTemplateRule(metaType,"manipulator");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A981D47552B8311DF830EC07B8D1505E2");}assignment[ret]{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

assignment[Object ret]
  :
  ({_beforeSeqEl("E0677A9A981D47592B8311DF9BB7C07B8D1505E2");} DOT {_afterSeqEl();}{_beforeSeqEl("E0677A9A981ECDF62B8311DF9745C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A981D475E2B8311DF8A25C07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "assignTo", null, temp, "OCL:self.getOwningClass().getNavigableFields()->select(f | f.name = ?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A981ECDF42B8311DF93ACC07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "assignTo", null, temp, "OCL:self.getOwningClass().getNavigableFields()->select(f | f.name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A981ECDF72B8311DFAC27C07B8D1505E2");} EQUALS {_afterSeqEl();}{_beforeSeqEl("E0677A9A981ECDF92B8311DFA2A8C07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "argument", temp);})? {_afterSeqEl();})
{
  }

  ;


behavior_actions_expressionstatement returns[Object ret2] @init{List<String> metaType=list("behavior","actions","ExpressionStatement");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A982054912B8311DF8ADCC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "expression", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A982054922B8311DF8948C07B8D1505E2");} SEMICOLON {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

primary_behavior_expressions_expression returns[Object ret2]
  :
  (ret=behavior_expressions_namedvalueexpression
  | ret=behavior_expressions_oql_oqlquery
  | ret=behavior_expressions_objectcreationexpression
  | ret=behavior_expressions_literals_literal
  | ret=behavior_expressions_firstpathexpression
  | ret=behavior_expressions_this
  | ret=behavior_expressions_literals_multiobjectliteral
  | ret=behavior_expressions_all
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=behavior_expressions_expression{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


expressions_priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ((('-')=>({_enterOpSeq("-", 1, false);}{_beforeSeqEl();}'-'{opName = "-";}{_afterSeqEl();}((ret=behavior_expressions_unaryminus[opName, null, firstToken]right=primary_behavior_expressions_expression {setProperty(ret, "operand", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('not')=>({_enterOpSeq("not", 1, false);}{_beforeSeqEl();}'not'{opName = "not";}{_afterSeqEl();}((ret=behavior_expressions_not[opName, null, firstToken]right=primary_behavior_expressions_expression {setProperty(ret, "operand", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))
|
 ( ret=primary_behavior_expressions_expression((DOT)=>({_enterOpSeq(".", 2, false);}{_beforeSeqEl();}DOT {opName = ".";}{_afterSeqEl();}((ret=behavior_expressions_booleanaggregate[opName, ret, firstToken])
| (ret=behavior_expressions_count[opName, ret, firstToken])
| (ret=behavior_expressions_single[opName, ret, firstToken])
| (ret=behavior_expressions_tuple[opName, ret, firstToken])
| (ret=behavior_expressions_numericaggregate[opName, ret, firstToken])
| (ret=behavior_expressions_pathexpression[opName, ret, firstToken])){_exitOpSeq();})
| (LBRACKET)=>({_enterOpSeq("[", 2, false);}{_beforeSeqEl();}LBRACKET {opName = "[";}{_afterSeqEl();}((ret=behavior_expressions_filterexpression[opName, ret, firstToken])){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

expressions_priority_1 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=expressions_priority_0(('*')=>({_enterOpSeq("*", 2, false);}{_beforeSeqEl();}'*'{opName = "*";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_0 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('/')=>({_enterOpSeq("/", 2, false);}{_beforeSeqEl();}'/'{opName = "/";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_0 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('AND')=>({_enterOpSeq("AND", 2, false);}{_beforeSeqEl();}'AND'{opName = "AND";}{_afterSeqEl();}((ret=behavior_expressions_binarybooleanoperator[opName, ret, firstToken]right=expressions_priority_0 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

expressions_priority_2 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=expressions_priority_1(('OR')=>({_enterOpSeq("OR", 2, false);}{_beforeSeqEl();}'OR'{opName = "OR";}{_afterSeqEl();}((ret=behavior_expressions_binarybooleanoperator[opName, ret, firstToken]right=expressions_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('+')=>({_enterOpSeq("+", 2, false);}{_beforeSeqEl();}'+'{opName = "+";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('-')=>({_enterOpSeq("-", 2, false);}{_beforeSeqEl();}'-'{opName = "-";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_1 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

expressions_priority_3 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=expressions_priority_2((RANGLE)=>({_enterOpSeq(">", 2, false);}{_beforeSeqEl();}RANGLE {opName = ">";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (LANGLE)=>({_enterOpSeq("<", 2, false);}{_beforeSeqEl();}LANGLE {opName = "<";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('>=')=>({_enterOpSeq(">=", 2, false);}{_beforeSeqEl();}'>='{opName = ">=";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('<=')=>({_enterOpSeq("<=", 2, false);}{_beforeSeqEl();}'<='{opName = "<=";}{_afterSeqEl();}((ret=behavior_expressions_binarynumericoperator[opName, ret, firstToken]right=expressions_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| (EQUALSEQUALS)=>({_enterOpSeq("==", 2, false);}{_beforeSeqEl();}EQUALSEQUALS {opName = "==";}{_afterSeqEl();}((ret=behavior_expressions_equals[opName, ret, firstToken]right=expressions_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();})
| ('!=')=>({_enterOpSeq("!=", 2, false);}{_beforeSeqEl();}'!='{opName = "!=";}{_afterSeqEl();}((ret=behavior_expressions_unequals[opName, ret, firstToken]right=expressions_priority_2 {setProperty(ret, "right", right);
this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))*))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

behavior_expressions_expression returns[Object ret2]
  :
  ret=expressions_priority_3
  {
ret2=ret;
 }
  ;


alias[Object ret]
  :
  ({_beforeSeqEl("E0677A9A9824E8772B8311DF9EB9C07B8D1505E2");} ({_enterAlt(0);} ({_beforeSeqEl("E0677A9A9824E8732B8311DF9D5EC07B8D1505E2");}'AS'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9824E8752B8311DFC71BC07B8D1505E2");}( temp=behavior_expressions_alias {setProperty(ret, "alias", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


behavior_expressions_alias returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Alias");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9824E8822B8311DF9F4EC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A9824E87C2B8311DFA1D8C07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A9824E8802B8311DF87B3C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A98266F122B8311DF99C9C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:aliasFor.type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_all returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","All");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A98266F162B8311DFB369C07B8D1505E2");}'all'{_afterSeqEl();}{_beforeSeqEl("E0677A9A98266F1B2B8311DF80B4C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "clazz", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}{_beforeSeqEl("E0677A9A98266F1E2B8311DFC6F2C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.clazz", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_binarybooleanoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","BinaryBooleanOperator");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A98297C532B8311DFAD9BC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A98297C562B8311DF96CCC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();}{_afterSeqEl();}){
setProperty(ret,"operator" , opName);
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_not[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Not");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A982B02F12B8311DFC206C07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A982B02F42B8311DFB69FC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_booleanaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","BooleanAggregate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A982E10402B8311DFB784C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A982E10312B8311DF8E88C07B8D1505E2");}'and'{_afterSeqEl();}{_beforeSeqEl("E0677A9A982E10342B8311DFB9EBC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "and");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A982E10362B8311DF989EC07B8D1505E2");}'or'{_afterSeqEl();}{_beforeSeqEl("E0677A9A982E10392B8311DFBD18C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "or");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl("E0677A9A982E103B2B8311DF8F59C07B8D1505E2");}'xor'{_afterSeqEl();}{_beforeSeqEl("E0677A9A982E103E2B8311DFA1F1C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "xor");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A982E10412B8311DFB348C07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A982E10422B8311DFC945C07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A982E10432B8311DFC931C07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A982F96D02B8311DFCE38C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_equals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Equals");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A9832A4122B8311DF9AF2C07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9832A4152B8311DF81D6C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_unequals[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Unequals");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A98342AB22B8311DFB9FEC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A98342AB52B8311DFAB6AC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_binarynumericoperator[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","BinaryNumericOperator");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A9835B1532B8311DF94FCC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A983737F02B8311DFA9C1C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:if self.operator = '+' or"+"		                         self.operator = '-' or"+"		                         self.operator = '*' or"+"		                         self.operator = '/' then"+"		                            self.numericPostType(self.operator, self.left.type, self.right.type)"+"		                      else"+"		                        structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')->asSequence()->first()"+"		                      endif", true);_exitInjectorAction();}{_afterSeqEl();}){
setProperty(ret,"operator" , opName);
setProperty(ret,"left" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_unaryminus[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","UnaryMinus");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A9838BE922B8311DF890AC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9838BE952B8311DF9A9BC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();}{_afterSeqEl();}){
setProperty(ret,"operator" , opName);
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_count[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Count");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A983A45312B8311DF989FC07B8D1505E2");}'count'{_afterSeqEl();}{_beforeSeqEl("E0677A9A983A45342B8311DFC95BC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();}{_afterSeqEl();}{_beforeSeqEl("E0677A9A983A45352B8311DFC2E5C07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A983A45362B8311DFC675C07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A983A45372B8311DFCFE4C07B8D1505E2");}alias[ret]{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_single[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Single");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A983BCBD12B8311DF92CDC07B8D1505E2");}'single'{_afterSeqEl();}{_beforeSeqEl("E0677A9A983BCBD42B8311DFBDA2C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();}{_afterSeqEl();}{_beforeSeqEl("E0677A9A983BCBD52B8311DFB393C07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A983BCBD62B8311DFB663C07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A983BCBD72B8311DFAC27C07B8D1505E2");}alias[ret]{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_tuple[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Tuple");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A983D52712B8311DFBD33C07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A983D52742B8311DFB79BC07B8D1505E2");}( temp=structure_type_tuple {setProperty(ret, "type", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A983ED9102B8311DFBE87C07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A983ED9112B8311DF8434C07B8D1505E2");}alias[ret]{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

structure_type_tuple returns[Object ret2]
  :
  (ret=structure_finexclass_tuple)
  {
ret2=ret;
 }
  ;


structure_finexclass_tuple returns[Object ret2] @init{List<String> metaType=list("structure","FinexClass");
onEnterTemplateRule(metaType,"tuple");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A983ED91D2B8311DF8FEEC07B8D1505E2");}( temp=structure_association_tuple {setProperty(ret, "associations", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A983ED9192B8311DFCAECC07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=structure_association_tuple {setProperty(ret, "associations", temp);})* ){_afterSeqEl();}{_beforeSeqEl("E0677A9A983ED9242B8311DFC501C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement->select(te|te.oclIsKindOf(\"Tuple\")).oclAsType(\"Tuple\").operand.getAllVisibleAliases()->iterate("+"			 			a; acc='TupleType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_association_tuple returns[Object ret2] @init{List<String> metaType=list("structure","Association");
onEnterTemplateRule(metaType,"tuple");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A98405FB62B8311DF822DC07B8D1505E2");}( temp=structure_field_tuple {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A98405FBB2B8311DF9FBFC07B8D1505E2");}( temp=structure_field_nondeclaredOpposite {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A98405FBE2B8311DFAEFCC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'Tuple_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_field_tuple returns[Object ret2] @init{List<String> metaType=list("structure","Field");
onEnterTemplateRule(metaType,"tuple");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9841E65E2B8311DF8B4FC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A9841E6522B8311DF9428C07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9841E6552B8311DF96D5C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "mandatory", true);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A9841E6592B8311DFCD56C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9841E65C2B8311DFC252C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9841E65F2B8311DF8C84C07B8D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0677A9A9841E6622B8311DFA6F9C07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "defaultValue", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9841E6692B8311DF9C01C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_numericaggregate[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","NumericAggregate");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A9844F3A52B8311DFB7F6C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A9844F3912B8311DF9104C07B8D1505E2");}'sum'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3942B8311DFC8B4C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "sum");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A9844F3962B8311DF823AC07B8D1505E2");}'avg'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3992B8311DFC8B2C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "avg");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(2);} ({_beforeSeqEl("E0677A9A9844F39B2B8311DF9962C07B8D1505E2");}'min'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F39E2B8311DFB269C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "min");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(3);} ({_beforeSeqEl("E0677A9A9844F3A02B8311DFAC5DC07B8D1505E2");}'max'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3A32B8311DF8D34C07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "operator", "max");_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3A62B8311DF9A2EC07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3A72B8311DF9B28C07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3A82B8311DFCFFCC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9844F3AB2B8311DF8666C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:operand.type", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_objectcreationexpression returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","ObjectCreationExpression");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A98467A302B8311DFB935C07B8D1505E2");}'create'{_afterSeqEl();}{_beforeSeqEl("E0677A9A98467A352B8311DFBF67C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "classToInstantiate", null, temp, "OCL:structure::FinexClass.allInstances()->select(c | c.name = ?)");}){_afterSeqEl();}{_beforeSeqEl("E0677A9A984800D22B8311DFB080C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:classToInstantiate", true);_exitInjectorAction();}{_afterSeqEl();}{_beforeSeqEl("E0677A9A984800D32B8311DFA5DBC07B8D1505E2");} LPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A984800D82B8311DFC821C07B8D1505E2");}( temp=behavior_expressions_fieldinitializer {setProperty(ret, "fieldInitializers", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A984800D52B8311DFC1A1C07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=behavior_expressions_fieldinitializer {setProperty(ret, "fieldInitializers", temp);})* )? {_afterSeqEl();}{_beforeSeqEl("E0677A9A984800D92B8311DFC465C07B8D1505E2");} RPAREN {_afterSeqEl();}{_beforeSeqEl("E0677A9A984800DA2B8311DFA1EBC07B8D1505E2");}alias[ret]{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_fieldinitializer returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","FieldInitializer");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A984987702B8311DF8965C07B8D1505E2");} DOT {_afterSeqEl();}{_beforeSeqEl("E0677A9A9849877D2B8311DF81B0C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A984987752B8311DF890AC07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "fieldToInitialize", null, temp, "OCL:self.creationExpression.classToInstantiate.getNavigableFields()->select(f | f.name = ?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A9849877B2B8311DF949CC07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "fieldToInitialize", null, temp, "OCL:self.creationExpression.classToInstantiate.getNavigableFields()->select(f | f.name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9849877E2B8311DF874FC07B8D1505E2");} COLON {_afterSeqEl();}{_beforeSeqEl("E0677A9A984987802B8311DFA66EC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "initExpression", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_this returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","This");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A984B0E102B8311DF9C96C07B8D1505E2");}'this'{_afterSeqEl();}{_beforeSeqEl("E0677A9A984B0E112B8311DF9F17C07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A984B0E142B8311DFC252C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.getEnclosingType()", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_namedvalueexpression returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","NamedValueExpression");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A984B0E242B8311DFCFADC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A984B0E1C2B8311DF82BDC07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "namedValue", null, temp, "OCL:self.getAllVisibleAliases()->select(a | a.name = ?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A984B0E222B8311DFA3A5C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "namedValue", null, temp, "OCL:self.getAllVisibleAliases()->select(a | a.name = ?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A984C94B12B8311DFBD9AC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:namedValue.type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_expression_pathExpression returns[Object ret2]
  :
  (ret=behavior_expressions_implicitcontext_pathExpression)
  {
ret2=ret;
 }
  ;


behavior_expressions_implicitcontext_pathExpression returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","ImplicitContext");
onEnterTemplateRule(metaType,"pathExpression");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A984FA1F22B8311DFA49BC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.getImplicitContextType()", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_oql_oqlquery returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","oql","OqlQuery");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A984FA1FF2B8311DF9908C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A984FA1F62B8311DFB030C07B8D1505E2");}'select'{_afterSeqEl();}{_beforeSeqEl("E0677A9A984FA1F92B8311DFC4D2C07B8D1505E2");}( temp=structure_type_oqlQuery {setProperty(ret, "type", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A984FA1FD2B8311DF9A8AC07B8D1505E2");}( temp=structure_type_oqlQueryWithImplicitSelect {setProperty(ret, "type", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A984FA2002B8311DFA9E6C07B8D1505E2");}'from'{_afterSeqEl();}{_beforeSeqEl("E0677A9A985128902B8311DFA686C07B8D1505E2");}( temp=behavior_expressions_oql_fromclause {setProperty(ret, "fromClauses", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A984FA2022B8311DFC1B5C07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=behavior_expressions_oql_fromclause {setProperty(ret, "fromClauses", temp);})* ){_afterSeqEl();}{_beforeSeqEl("E0677A9A985128912B8311DF81AAC07B8D1505E2");}'where'{_afterSeqEl();}{_beforeSeqEl("E0677A9A985128942B8311DFAA0CC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "condition", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_oql_fromclause returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","oql","FromClause");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A985128992B8311DFCA0AC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "fromExpression", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9851289A2B8311DF87DDC07B8D1505E2");}'as'{_afterSeqEl();}{_beforeSeqEl("E0677A9A9851289D2B8311DFB2ADC07B8D1505E2");}( temp=behavior_expressions_alias_fromClause {setProperty(ret, "alias", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_alias_fromClause returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","Alias");
onEnterTemplateRule(metaType,"fromClause");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9852AF312B8311DFA8D2C07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A985128A32B8311DFAF2FC07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A985128A72B8311DFC9BFC07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9852AF342B8311DF8C36C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.fromClause.fromExpression.type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_type_oqlQuery returns[Object ret2]
  :
  (ret=structure_finexclass_oqlQuery)
  {
ret2=ret;
 }
  ;


structure_finexclass_oqlQuery returns[Object ret2] @init{List<String> metaType=list("structure","FinexClass");
onEnterTemplateRule(metaType,"oqlQuery");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9852AF402B8311DFCC12C07B8D1505E2");}( temp=structure_association_oqlQuery {setProperty(ret, "associations", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A9852AF3C2B8311DF940CC07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=structure_association_oqlQuery {setProperty(ret, "associations", temp);})* ){_afterSeqEl();}{_beforeSeqEl("E0677A9A985435D42B8311DFACD3C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement->select(te|te.oclIsKindOf(OqlQuery)).oclAsType(OqlQuery).fromClauses.alias->iterate("+"			 			a; acc='QueryType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_association_oqlQuery returns[Object ret2] @init{List<String> metaType=list("structure","Association");
onEnterTemplateRule(metaType,"oqlQuery");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9855BC742B8311DF9E86C07B8D1505E2");}( temp=structure_field_oqlQuery {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9855BC792B8311DFABC4C07B8D1505E2");}( temp=structure_field_nondeclaredOpposite {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9855BC7C2B8311DFAA1CC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'Query_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_field_oqlQuery returns[Object ret2] @init{List<String> metaType=list("structure","Field");
onEnterTemplateRule(metaType,"oqlQuery");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9858C9B22B8311DF8E6EC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A985743142B8311DF8FBEC07B8D1505E2");}( temp=firstUppercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A985743172B8311DFC1EFC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "mandatory", true);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A9857431B2B8311DF9500C07B8D1505E2");}( temp=firstLowercaseIdentifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9858C9B02B8311DFCA0BC07B8D1505E2");}{_enterInjectorAction();setProperty(ret, "mandatory", false);_exitInjectorAction();}{_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9858C9B62B8311DFA797C07B8D1505E2");}( temp=behavior_expressions_expression_oqlQuery {setProperty(ret, "defaultValue", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9858C9BD2B8311DFBA07C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_expression_oqlQuery returns[Object ret2]
  :
  (ret=behavior_expressions_namedvalueexpression_oqlQuery)
  {
ret2=ret;
 }
  ;


behavior_expressions_namedvalueexpression_oqlQuery returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","NamedValueExpression");
onEnterTemplateRule(metaType,"oqlQuery");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A985A50562B8311DF805BC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "namedValue", null, null, "OCL:self.defaultOf.oclAsType(Field).association.clazz.typedElement."+"						          oclAsType(OqlQuery).fromClauses.alias->select(a|"+"								                                a.name=self.defaultOf.oclAsType(Field).name)", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:namedValue.type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_type_oqlQueryWithImplicitSelect returns[Object ret2]
  :
  (ret=structure_finexclass_oqlQueryWithImplicitSelect)
  {
ret2=ret;
 }
  ;


structure_finexclass_oqlQueryWithImplicitSelect returns[Object ret2] @init{List<String> metaType=list("structure","FinexClass");
onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A985BD6FB2B8311DFA3E5C07B8D1505E2");}{_enterInjectorAction();
{
List<PredicateSemantic> list = new ArrayList<PredicateSemantic>();
RuleNameFinder finder = new RuleNameFinder();
list.add(new PredicateSemantic(null, "structure_association_oqlQueryWithImplicitSelect"));
setPredicateRef(ret,"associations","oqlQueryWithImplicitSelect","OCL:self.typedElement->select(te|te.oclIsKindOf(OqlQuery)).oclAsType(OqlQuery).fromClauses",list,finder,true);
}
_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:self.typedElement->select(te|te.oclIsKindOf(OqlQuery)).oclAsType(OqlQuery).fromClauses.alias->iterate("+"			 			a; acc='QueryType_for' | acc.concat('_').concat(a.name))", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "valueType", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "owner", null, null, "OCL:self.typedElement->select(te | te.oclIsKindOf(Expression))."+"			                   oclAsType(Expression).getEnclosingType()", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_association_oqlQueryWithImplicitSelect returns[Object ret2] @init{List<String> metaType=list("structure","Association");
onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A985D5D972B8311DF979FC07B8D1505E2");}( temp=structure_field_oqlQueryWithImplicitSelect {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A985D5D9C2B8311DFCC25C07B8D1505E2");}( temp=structure_field_nondeclaredOpposite {setProperty(ret, "ends", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A985D5D9F2B8311DFC23CC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:'Query_to_'.concat(self.ends->first().name)", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

structure_field_oqlQueryWithImplicitSelect returns[Object ret2] @init{List<String> metaType=list("structure","Field");
onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A985EE4332B8311DFA613C07B8D1505E2");}( temp=behavior_expressions_expression_oqlQueryWithImplicitSelect {setProperty(ret, "defaultValue", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A985EE43C2B8311DFB0E1C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.defaultValue.type", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "navigable", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "singleMultiplicity", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "name", null, null, "OCL:#context.oclAsType(FromClause).alias.name", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_expression_oqlQueryWithImplicitSelect returns[Object ret2]
  :
  (ret=behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect)
  {
ret2=ret;
 }
  ;


behavior_expressions_namedvalueexpression_oqlQueryWithImplicitSelect returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","NamedValueExpression");
onEnterTemplateRule(metaType,"oqlQueryWithImplicitSelect");
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9861F1742B8311DFC9C1C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "namedValue", null, null, "OCL:#context.oclAsType(FromClause).alias", true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.namedValue.type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_firstpathexpression returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","FirstPathExpression");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A986378132B8311DFAF5DC07B8D1505E2");} DOT {_afterSeqEl();}{_beforeSeqEl("E0677A9A986378162B8311DFC906C07B8D1505E2");}( temp=behavior_expressions_expression_pathExpression {setProperty(ret, "operand", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A986378232B8311DF98EBC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A9863781B2B8311DFC804C07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A986378212B8311DFC7A4C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A986378242B8311DFB96EC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A986378272B8311DF9894C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.field.type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_pathexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","PathExpression");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A9866855D2B8311DFA8ADC07B8D1505E2");}({_enterAlt(0);} ({_beforeSeqEl("E0677A9A986685552B8311DF958BC07B8D1505E2");}( temp=firstLowercaseIdentifier {setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");}){_afterSeqEl();}){_exitAlt();} 
  |{_enterAlt(1);} ({_beforeSeqEl("E0677A9A9866855B2B8311DFB279C07B8D1505E2");}( temp=firstUppercaseIdentifier {setOclRef(ret, "field", null, temp, "OCL:self.operand.type.oclAsType(structure::FinexClass).getNavigableFields()->select(f|f.name=?)");}){_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();}{_beforeSeqEl("E0677A9A9866855E2B8311DFB4DBC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A986685612B8311DFC85BC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.field.type", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_filterexpression[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","FilterExpression");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl("E0677A9A98680BF22B8311DFA6F7C07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "condition", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A98680BF32B8311DF8C7BC07B8D1505E2");} RBRACKET {_afterSeqEl();}{_beforeSeqEl("E0677A9A98680BF42B8311DFA06BC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A98680BF72B8311DFC2A0C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.operand.type", true);_exitInjectorAction();}{_afterSeqEl();}){
// discarding operator name instead of storing it here
setProperty(ret,"operand" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_literal returns[Object ret2]
  :
  (ret=behavior_expressions_literals_booleanliteral
  | ret=behavior_expressions_literals_stringliteral
  | ret=behavior_expressions_literals_decimalliteral
  | ret=behavior_expressions_literals_integerliteral
  | ret=behavior_expressions_literals_dateliteral
  | ret=behavior_expressions_literals_binaryliteral)
  {
ret2=ret;
 }
  ;


behavior_expressions_literals_booleanliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","BooleanLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A986E26722B8311DFB79EC07B8D1505E2");}( temp=booleanSymbol {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A986E26732B8311DFB00CC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A986E26762B8311DFB8E1C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Boolean')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_stringliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","StringLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A986FAD122B8311DFCE80C07B8D1505E2");}( temp=stringSymbol {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A986FAD132B8311DFA0FAC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A987133B02B8311DFAB8DC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'String')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_decimalliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","DecimalLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9872BA522B8311DFA7A3C07B8D1505E2");}( temp=floatAsStringSymbol {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9872BA532B8311DF85DCC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9872BA562B8311DFB7D0C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Decimal')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_integerliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","IntegerLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9875C7922B8311DF929FC07B8D1505E2");}( temp=integerAsStringSymbol {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9875C7932B8311DFC80BC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9875C7962B8311DFABA9C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Integer')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_dateliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","DateLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A9878D4D22B8311DFA835C07B8D1505E2");}( temp=dateSymbol {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A9878D4D32B8311DF8000C07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A9878D4D62B8311DFBAF4C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Date')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_binaryliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","BinaryLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A987D68B22B8311DFAE4DC07B8D1505E2");}( temp=binarySymbol {setProperty(ret, "literal", temp);}){_afterSeqEl();}{_beforeSeqEl("E0677A9A987D68B32B8311DFC58FC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A987D68B62B8311DF9751C07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:structure::FinexClass.allInstances()->select(c | c.name = 'Binary')", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

behavior_expressions_literals_multiobjectliteral returns[Object ret2] @init{List<String> metaType=list("behavior","expressions","literals","MultiObjectLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E0677A9A987EEF502B8311DF8F6BC07B8D1505E2");} LBRACKET {_afterSeqEl();}{_beforeSeqEl("E0677A9A987EEF552B8311DFBAFEC07B8D1505E2");}( temp=behavior_expressions_expression {setProperty(ret, "elements", temp);} ({_enterSepSeq();}({_beforeSeqEl("E0677A9A987EEF522B8311DFB170C07B8D1505E2");}','{_afterSeqEl();}){_exitSepSeq();} temp=behavior_expressions_expression {setProperty(ret, "elements", temp);})* ){_afterSeqEl();}{_beforeSeqEl("E0677A9A988075F02B8311DF95E6C07B8D1505E2");} RBRACKET {_afterSeqEl();}{_beforeSeqEl("E0677A9A988075F12B8311DFB26BC07B8D1505E2");}alias[ret]{_afterSeqEl();}{_beforeSeqEl("E0677A9A988075F42B8311DFAB7AC07B8D1505E2");}{_enterInjectorAction();setOclRef(ret, "type", null, null, "OCL:self.elements->asSequence()->first().type", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('//' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


MULTI_LINE_COMMENT
  :
     ((('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


LBRACKET
  :
  '['
  ;


RBRACKET
  :
  ']'
  ;


LCURL
  :
  '{'
  ;


RCURL
  :
  '}'
  ;


LANGLE
  :
  '<'
  ;


RANGLE
  :
  '>'
  ;


LPAREN
  :
  '('
  ;


RPAREN
  :
  ')'
  ;


EQUALS
  :
  '='
  ;


EQUALSEQUALS
  :
  '=='
  ;


ASSIGN
  :
  ':='
  ;


DOT
  :
  '.'
  ;


DDOT
  :
  '..'
  ;


PIPE
  :
  '|'
  ;


COLON
  :
  ':'
  ;


SEMICOLON
  :
  ';'
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
	:	LOWERCASE_ALPHA | UPPERCASE_ALPHA
	;

fragment
LOWERCASE_ALPHA
	:	'a'..'z'
	|	'_'
	// lowercase accented characters
	|	'\u00DE' .. '\u00F6'
	|	'\u00F8' .. '\u00FF'
	;

fragment
UPPERCASE_ALPHA
	:	'A'..'Z'
	// uppercase accented characters
	|	'\u00C0' .. '\u00D6'
	|	'\u00D8' .. '\u00DD'
	;

fragment
FIRST_LOWERCASE_SNAME
	:	(LOWERCASE_ALPHA) (ALPHA | DIGIT)*
;

fragment
FIRST_UPPERCASE_SNAME
	:	(UPPERCASE_ALPHA) (ALPHA | DIGIT)*
;

BOOL	:	'true' | 'false'	;

OBJECT	:	'o:'	;

FIRST_UPPERCASE_NAME
	:	FIRST_UPPERCASE_SNAME
	;

FIRST_LOWERCASE_NAME
	:	FIRST_LOWERCASE_SNAME
	;

BINARY
	:	'0x'((DIGIT | 'a'..'f' | 'A'..'F') (DIGIT | 'a'..'f' | 'A'..'F'))+
	;

protected
INT
 : (DIGIT)+
 ;

fragment
FLOAT
	:	DIGIT+ '.' DIGIT*
	;
  
RANGE_OR_INT
    :   ( INT '..' ) => INT  { _type = INT; }
    |	( INT '.' (FIRST_LOWERCASE_NAME | FIRST_UPPERCASE_NAME) ) => INT { _type = INT; }
    |   ( INT '.' ~('.'	|	'a'..'z'
					   	|	'A'..'Z'
					   	|	'_'
						//For Unicode compatibility (from 0000 to 00ff)
						|	'\u00C0' .. '\u00D6'
						|	'\u00D8' .. '\u00F6'
						|	'\u00F8' .. '\u00FF') )  => FLOAT { _type = FLOAT; }
    |   INT                  { _type = INT; }
    ;


DATE	:	DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ((' '|'T') DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT
            (
              ( (',' | '.') DIGIT ) => ((',' | '.') (DIGIT)+)
              |
            )
            ('Z' | (('+'|'-') DIGIT DIGIT DIGIT DIGIT)?) )? ;

STRING
	:	'"'!
		(	
		//ESC	|		
			'\n' {newline();}
		|	~('\\'|'"'|'\n')
		)*
		'"'!
	;

	