grammar People;
options {superClass=ObservableInjectingParser;backtrack = true;}

@lexer::header {
package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

@lexer::members {  public com.sap.furcas.runtime.parser.IModelInjector ei = null;
public ITokenFactory<? extends ANTLR3LocationToken> tokenFactory;
  /*************** Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
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
  /*************** End of Code generated in class com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter  ********/
}

@header {
package generated2;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.impl.PredicateSemantic;
import com.sap.furcas.parsergenerator.emf.lookup.RuleNameFinder;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
   private static final String syntaxUUID = "People";
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


main returns[Object ret2]
  :
  ((ret=people_world) EOF) 
  {
ret2=ret;
}
  ;


people_world returns[Object ret2] @init{List<String> metaType=list("People","World");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}({_enterAlt(0);} ({_beforeSeqEl();} WORLD {_afterSeqEl();}{_beforeSeqEl();}'{'{_afterSeqEl();}{_beforeSeqEl();}( temp=people_nation {setProperty(ret, "nations", temp);} ({_enterSepSeq();}({_beforeSeqEl();}','{_afterSeqEl();}){_exitSepSeq();} temp=people_nation {setProperty(ret, "nations", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}'}'{_afterSeqEl();}){_exitAlt();} 
  |(~WORLD) => {_enterAlt(1);} ({_beforeSeqEl();}'heaven'{_afterSeqEl();}{_beforeSeqEl();}'{'{_afterSeqEl();}{_beforeSeqEl();}( temp=people_nation {setProperty(ret, "nations", temp);} ({_enterSepSeq();}({_beforeSeqEl();}','{_afterSeqEl();}){_exitSepSeq();} temp=people_nation {setProperty(ret, "nations", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}'}'{_afterSeqEl();}{_beforeSeqEl();}'defs:'{_afterSeqEl();}{_beforeSeqEl();}( temp=people_persondefinition {setProperty(ret, "definitions", temp);} ( temp=people_persondefinition {setProperty(ret, "definitions", temp);})* )? {_afterSeqEl();}){_exitAlt();} ){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

people_nation returns[Object ret2] @init{List<String> metaType=list("People","Nation");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"nationTag"}) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl();}'['{_afterSeqEl();}{_beforeSeqEl();}( temp=people_city {setProperty(ret, "cities", temp);} ({_enterSepSeq();}({_beforeSeqEl();}','{_afterSeqEl();}){_exitSepSeq();} temp=people_city {setProperty(ret, "cities", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}']'{_afterSeqEl();}{_beforeSeqEl();}'capital:'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "capital", list("People","City"), "name", temp, "cities", "never", null, false, null);})? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

people_city returns[Object ret2] @init{List<String> metaType=list("People","City");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);})? {_afterSeqEl();}{_beforeSeqEl();}'('{_afterSeqEl();}{_beforeSeqEl();}( temp=people_person {setProperty(ret, "persons", temp);} ({_enterSepSeq();}({_beforeSeqEl();}','{_afterSeqEl();}){_exitSepSeq();} temp=people_person {setProperty(ret, "persons", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}')'{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'representative:'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setOclRef(ret, "representative", "name", temp, "OCL:#context(nationTag).capital.persons->select(p | p.name = ?)");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

people_person returns[Object ret2] @init{List<String> metaType=list("People","Person");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}'@'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "currentlyIn", list("People","City"), "name", temp, "#context(nationTag).cities", "never", null, false, null);})? {_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'('{_afterSeqEl();}{_beforeSeqEl();}'mother:'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "parents", list("People","Person"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl();}')'{_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'spouse:'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setOclRef(ret, "spouse", null, temp, "OCL:Person.allInstances()->select(p|p.name=?)");}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}{_enterInjectorAction();setProperty(ret, "male", true);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "age", 42);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "height", 1.83);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "codeName", "Viper");_exitInjectorAction();_enterInjectorAction();setRef(ret, "embassy", list("People","City"), null, null, "currentlyIn.nation.capital", null, null, false, null, true);_exitInjectorAction();_enterInjectorAction();setOclRef(ret, "embassy2", null, null, "OCL:currentlyIn.nation.capital", true);_exitInjectorAction();}{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

primary_people_persondefinition returns[Object ret2]
  :
  (ret=people_concretepersondefinition
  | ({_enterOpdBrackSeq();}{_beforeSeqEl();}LPAREN {_afterSeqEl();}{_beforeSeqEl();}ret=people_persondefinition{_afterSeqEl();}{_beforeSeqEl();} RPAREN{_afterSeqEl();}){_exitOpdBrackSeq();})
  {
  ret2=ret;
}
  ;


persondefinitions_priority_0 returns[Object ret2] @init{java.lang.String opName=null; org.antlr.runtime.Token firstToken=input.LT(1);}
  :
   ( ( ret=primary_people_persondefinition
)(
(((STAR)())=>({_enterOpSeq("*", 1, true);}{_beforeSeqEl();}STAR {opName = "*";}{_afterSeqEl();}((ret=people_nestedpersondefinition_People_NestedPersonDefinition_starOp[opName, ret, firstToken]{this.setLocationAndComment(ret, firstToken);
})){_exitOpSeq();}))
|
))
{
this.setLocationAndComment(ret, firstToken);
ret2=ret;
 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);}

people_persondefinition returns[Object ret2]
  :
  ret=persondefinitions_priority_0
  {
ret2=ret;
 }
  ;


people_concretepersondefinition returns[Object ret2] @init{List<String> metaType=list("People","ConcretePersonDefinition");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setRef(ret, "person", list("People","Person"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

people_nestedpersondefinition_People_NestedPersonDefinition_starOp[java.lang.String opName, Object left, org.antlr.runtime.Token firstToken] returns[Object ret2] @init{List<String> metaType=list("People","NestedPersonDefinition");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;

}
  :
  ({_beforeSeqEl();}{_enterInjectorAction();setProperty(ret, "lowerMultiplicity", 0);_exitInjectorAction();_enterInjectorAction();setProperty(ret, "upperMultiplicity", -1);_exitInjectorAction();}{_afterSeqEl();}){
setProperty(ret,"op" , opName);
setProperty(ret,"nestedDefinition" , left);
ret2 = createOrResolve(ret, firstToken);
onRuleElementCreationCommited(ret2);

}
  ;
 finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


WORLD
  :
  'world'
  ;


STAR
  :
  '*'
  ;


NL
    :   (   '\r' '\n'
        |   '\n' '\r'   //Improbable
        |   '\r'
        |   '\n'
        )
    {newline();$channel=HIDDEN;}
    ;

WS
    :   (   ' '
        |   '\t'
        )
        {$channel=HIDDEN;}    ;

fragment
DIGIT
    :   '0'..'9'
    ;

fragment
ALPHA
    :   'a'..'z'
    |   'A'..'Z'
    |   '_'
    //For Unicode compatibility (from 0000 to 00ff)
    |   '\u00C0' .. '\u00D6'
    |   '\u00D8' .. '\u00F6'
    |   '\u00F8' .. '\u00FF'
    ;

fragment
SNAME
    :   (ALPHA) (ALPHA | DIGIT)*
;

NAME
    :   (
            SNAME
        |   '"'!
            (   ESC
            |   '\n' {newline();}
            |   ~('\\'|'\"'|'\n')
            )*
            '"'!
            
        )
    ;

INT
    :   (DIGIT)+
    ;

    FLOAT   :   DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?   ;   // cannot accept DIGIT '.' because it would conflict with Navigation

fragment
ESC
    :   '\\'!
        (   'n' 
        |   'r' 
        |   't' 
        |   'b' 
        |   'f' 
        |   '"' 
        |   '\'' 
        |   '\\' 
        |   (
                ('0'..'3')
                (
                :   ('0'..'7')
                    (
                    :   '0'..'7'
                    )?
                )?
            |   ('4'..'7')
                (
                :   ('0'..'7')
                )?
            )
                {
                }
        )
    ;

STRING
    :   '\''!
        (   ESC
        |   '\n' {newline();}
        |   ~('\\'|'\''|'\n')
        )*
        '\''!
       
    ;