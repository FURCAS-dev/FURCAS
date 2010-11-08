grammar KM3;
options {superClass=ObservableInjectingParser;k = 4;}

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
   private static final String syntaxUUID = "KM3";
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
  ((ret=km3_metamodel) EOF) 
  {
ret2=ret;
}
  ;


km3_metamodel returns[Object ret2] @init{List<String> metaType=list("KM3","Metamodel");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}(({_beforeSeqEl();}( temp=km3_package {setProperty(ret, "contents", temp);} ( temp=km3_package {setProperty(ret, "contents", temp);})* )? {_afterSeqEl();})){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_modelelement returns[Object ret2]
  :
  (ret=km3_packageelement
  | ret=km3_structuralfeature
  | ret=km3_enumliteral)
  {
ret2=ret;
 }
  ;


km3_packageelement returns[Object ret2]
  :
  (ret=km3_classifier
  | ret=km3_package)
  {
ret2=ret;
 }
  ;


km3_classifier returns[Object ret2]
  :
  (ret=km3_datatype
  | ret=km3_class)
  {
addToCurrentContext(ret);
ret2=ret;
 }
  ;


km3_package returns[Object ret2] @init{List<String> metaType=list("KM3","Package");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'package'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}{_afterSeqEl();}{_beforeSeqEl();} LCURLY {_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=km3_packageelement {setProperty(ret, "contents", temp);} ( temp=km3_packageelement {setProperty(ret, "contents", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_datatype_abstractContents returns[Object ret2] @init{List<String> metaType=list("KM3","DataType");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'datatype'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_datatype returns[Object ret2]
  :
  (ret=km3_enumeration
  | ret=km3_datatype_abstractContents)
  {
ret2=ret;
 }
  ;


km3_class returns[Object ret2] @init{List<String> metaType=list("KM3","Class");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'abstract'{_afterSeqEl();}){setProperty(ret, "isAbstract", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isAbstract", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'class'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'extends'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "supertypes", list("KM3","Class"), "name", temp, null, "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}{_beforeSeqEl();}{_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "supertypes", list("KM3","Class"), "name", temp, null, "never", null, false, null);})* )? {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} LCURLY {_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=km3_structuralfeature {setProperty(ret, "structuralFeatures", temp);} ( temp=km3_structuralfeature {setProperty(ret, "structuralFeatures", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_structuralfeature returns[Object ret2]
  :
  (ret=km3_reference
  | ret=km3_attribute)
  {
ret2=ret;
 }
  ;


km3_reference returns[Object ret2] @init{List<String> metaType=list("KM3","Reference");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'reference'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}multiplicity[ret]{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'ordered'{_afterSeqEl();}){setProperty(ret, "isOrdered", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOrdered", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'container'{_afterSeqEl();}){setProperty(ret, "isContainer", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isContainer", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "type", list("KM3","Classifier"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'oppositeOf'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "opposite", list("KM3","Reference"), "name", temp, "type", "never", null, false, null);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_attribute returns[Object ret2] @init{List<String> metaType=list("KM3","Attribute");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'unique'{_afterSeqEl();}){setProperty(ret, "isUnique", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isUnique", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'attribute'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}multiplicity[ret]{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'ordered'{_afterSeqEl();}){setProperty(ret, "isOrdered", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isOrdered", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} COLON {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "type", list("KM3","Classifier"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl();} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_enumeration returns[Object ret2] @init{List<String> metaType=list("KM3","Enumeration");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'enumeration'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LCURLY {_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=km3_enumliteral {setProperty(ret, "literals", temp);} ( temp=km3_enumliteral {setProperty(ret, "literals", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();} RCURLY {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

km3_enumliteral returns[Object ret2] @init{List<String> metaType=list("KM3","EnumLiteral");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'literal'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

multiplicity[Object ret]
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} (){setProperty(ret, "lower", new Integer(1));setProperty(ret, "upper", new Integer(1));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();} STAR {_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){setProperty(ret, "lower", new Integer(0));setProperty(ret, "upper", new Integer(-1));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "lower", temp);}){_afterSeqEl();}{_beforeSeqEl();} MINUS {_afterSeqEl();}{_beforeSeqEl();} STAR {_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){setProperty(ret, "upper", new Integer(-1));}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();} LSQUARE {_afterSeqEl();}{_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "lower", temp);}){_afterSeqEl();}{_beforeSeqEl();} MINUS {_afterSeqEl();}{_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "upper", temp);}){_afterSeqEl();}{_beforeSeqEl();} RSQUARE {_afterSeqEl();}){}{_exitAlt();} )
{_afterSeqEl();}){}{_exitAlt();} )
{_afterSeqEl();}){}{_exitAlt();} )
{_afterSeqEl();})
{
  }

  ;


COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
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


COLONS
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
	;

	