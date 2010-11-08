grammar Kmelia;
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
   private static final String syntaxUUID = "Kmelia";
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


main returns[Object ret2]
  :
  ((ret=kmelia_component) EOF) 
  {
ret2=ret;
}
  ;


kmelia_component returns[Object ret2] @init{List<String> metaType=list("Kmelia","Component");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'COMPONENT'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}'INTERFACE'{_afterSeqEl();}{_beforeSeqEl();}'provides'{_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();} LCURLY {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "provides", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "provides", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl();} RCURLY {_afterSeqEl();}{_beforeSeqEl();}'requires'{_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();} LCURLY {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "requires", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "requires", list("Kmelia","Service"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}{_beforeSeqEl();} RCURLY {_afterSeqEl();}{_beforeSeqEl();}'SERVICES'{_afterSeqEl();}{_beforeSeqEl();}( temp=kmelia_service {setProperty(ret, "services", temp);} ( temp=kmelia_service {setProperty(ret, "services", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();}'END_SERVICES'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_service returns[Object ret2]
  :
  (ret=kmelia_externalservice
  | ret=kmelia_internalservice)
  {
ret2=ret;
 }
  ;


kmelia_externalservice returns[Object ret2] @init{List<String> metaType=list("Kmelia","ExternalService");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'required'{_afterSeqEl();}){setProperty(ret, "isRequired", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}'provided'{_afterSeqEl();}){setProperty(ret, "isRequired", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'external'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_internalservice returns[Object ret2] @init{List<String> metaType=list("Kmelia","InternalService");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'required'{_afterSeqEl();}){setProperty(ret, "isRequired", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}'provided'{_afterSeqEl();}){setProperty(ret, "isRequired", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=kmelia_parameter {setProperty(ret, "parameters", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=kmelia_parameter {setProperty(ret, "parameters", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "returnType", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}( temp=kmelia_body {setProperty(ret, "body", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'end'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_parameter returns[Object ret2] @init{List<String> metaType=list("Kmelia","Parameter");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "type", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_body returns[Object ret2] @init{List<String> metaType=list("Kmelia","Body");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=kmelia_interface {setProperty(ret, "interface", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'Behavior'{_afterSeqEl();}{_beforeSeqEl();}( temp=kmelia_behavior {setProperty(ret, "behavior", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_interface returns[Object ret2] @init{List<String> metaType=list("Kmelia","Interface");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'Interface'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_behavior returns[Object ret2] @init{List<String> metaType=list("Kmelia","Behavior");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'init'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "initialState", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");}){_afterSeqEl();}{_beforeSeqEl();}'final'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "finalStates", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "finalStates", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");})* ){_afterSeqEl();}{_beforeSeqEl();} LCURLY {_afterSeqEl();}{_beforeSeqEl();}( temp=kmelia_transition {setProperty(ret, "transitions", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=kmelia_transition {setProperty(ret, "transitions", temp);})* ){_afterSeqEl();}{_beforeSeqEl();} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_state returns[Object ret2] @init{List<String> metaType=list("Kmelia","State");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_transition returns[Object ret2] @init{List<String> metaType=list("Kmelia","Transition");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setRef(ret, "source", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");}){_afterSeqEl();}{_beforeSeqEl();} MINUSMINUS {_afterSeqEl();}{_beforeSeqEl();}( temp=kmelia_action {setProperty(ret, "actions", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=kmelia_action {setProperty(ret, "actions", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RLARROW {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "target", list("Kmelia","State"), "name", temp, null, "ifmissing", null, false, "#context.states");}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_action returns[Object ret2]
  :
  (ret=kmelia_functioncall
  | ret=kmelia_communication)
  {
ret2=ret;
 }
  ;


kmelia_functioncall returns[Object ret2] @init{List<String> metaType=list("Kmelia","FunctionCall");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=kmelia_expression {setProperty(ret, "arguments", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=kmelia_expression {setProperty(ret, "arguments", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_communication returns[Object ret2]
  :
  (ret=kmelia_servicecall)
  {
ret2=ret;
 }
  ;


kmelia_servicecall returns[Object ret2] @init{List<String> metaType=list("Kmelia","ServiceCall");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "channel", temp);}){_afterSeqEl();}{_beforeSeqEl();} EXCLEXCL {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

kmelia_expression returns[Object ret2]
  :
  (ret=kmelia_stringexp)
  {
ret2=ret;
 }
  ;


kmelia_stringexp returns[Object ret2] @init{List<String> metaType=list("Kmelia","StringExp");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('#' (~('\r'| '\n'))*)) | (('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/')))
  ;


LSQUARE
  :
  '['
  ;


RSQUARE
  :
  ']'
  ;


EXCL
  :
  '!'
  ;


EXCLEXCL
  :
  '!!'
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


SEMI
  :
  ';'
  ;


COLON
  :
  ':'
  ;


PIPE
  :
  '|'
  ;


QMARK
  :
  '?'
  ;


COLONCOLON
  :
  '::'
  ;


POINT
  :
  '.'
  ;


MINUSMINUS
  :
  '--'
  ;


RLARROW
  :
  '-->'
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
	{newline();}
	;

WS
	:	(	' '
		|	'\t'
		)
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

		|	'"'!
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\"'|'\n')
			)*
			'"'!
			{setText(unescapeString(getText(), 1));}
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
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
			{setText(unescapeString(getText(), 1));}
	;

	