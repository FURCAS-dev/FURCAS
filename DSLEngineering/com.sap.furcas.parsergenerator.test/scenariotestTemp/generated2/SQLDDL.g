grammar SQLDDL;
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
   private static final String syntaxUUID = "SQLDDL";
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
  ((ret=sqlddl_database) EOF) 
  {
ret2=ret;
}
  ;


sqlddl_database returns[Object ret2] @init{List<String> metaType=list("SQLDDL","Database");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=sqlddl_table {setProperty(ret, "tables", temp);} ( temp=sqlddl_table {setProperty(ret, "tables", temp);})* )? {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_table returns[Object ret2] @init{List<String> metaType=list("SQLDDL","Table");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'CREATE'{_afterSeqEl();}{_beforeSeqEl();}'TABLE'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}(({_beforeSeqEl();}( temp=sqlddl_tableelement {setProperty(ret, "elements", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=sqlddl_tableelement {setProperty(ret, "elements", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=sqlddl_parameter {setProperty(ret, "parameters", temp);} ( temp=sqlddl_parameter {setProperty(ret, "parameters", temp);})* )? {_afterSeqEl();}{_beforeSeqEl();} SEMI {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_tableelement returns[Object ret2]
  :
  (ret=sqlddl_column
  | ret=sqlddl_key)
  {
ret2=ret;
 }
  ;


sqlddl_column returns[Object ret2] @init{List<String> metaType=list("SQLDDL","Column");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, true) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();}( temp=sqlddl_type {setProperty(ret, "type", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} (){setProperty(ret, "canBeNull", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} ({_beforeSeqEl();}'NOT'{_afterSeqEl();}{_beforeSeqEl();}'NULL'{_afterSeqEl();}){setProperty(ret, "canBeNull", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'default'{_afterSeqEl();}{_beforeSeqEl();}( temp=stringSymbol {setProperty(ret, "default", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_key returns[Object ret2]
  :
  (ret=sqlddl_simplekey
  | ret=sqlddl_primarykey
  | ret=sqlddl_foreignkey)
  {
ret2=ret;
 }
  ;


sqlddl_simplekey returns[Object ret2] @init{List<String> metaType=list("SQLDDL","SimpleKey");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'UNIQUE'{_afterSeqEl();}){setProperty(ret, "isUnique", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isUnique", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'KEY'{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);})* ){_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_primarykey returns[Object ret2] @init{List<String> metaType=list("SQLDDL","PrimaryKey");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'PRIMARY'{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'UNIQUE'{_afterSeqEl();}){setProperty(ret, "isUnique", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isUnique", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'KEY'{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);})* ){_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_foreignkey returns[Object ret2] @init{List<String> metaType=list("SQLDDL","ForeignKey");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'FOREIGN'{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'UNIQUE'{_afterSeqEl();}){setProperty(ret, "isUnique", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isUnique", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();}'KEY'{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "columns", list("SQLDDL","Column"), "name", temp, null, "never", null, false, null);})* ){_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();}{_beforeSeqEl();}'REFERENCES'{_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "referencedTable", list("SQLDDL","Table"), "name", temp, null, "never", null, false, null);}){_afterSeqEl();}{_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=identifier {setRef(ret, "referencedColumns", list("SQLDDL","Column"), "name", temp, "referencedTable", "never", null, false, null);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=identifier {setRef(ret, "referencedColumns", list("SQLDDL","Column"), "name", temp, "referencedTable", "never", null, false, null);})* ){_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_type returns[Object ret2] @init{List<String> metaType=list("SQLDDL","Type");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} LPAREN {_afterSeqEl();}{_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "length", temp);} ({_enterSepSeq();}({_beforeSeqEl();} COMA {_afterSeqEl();}){_exitSepSeq();} temp=integerSymbol {setProperty(ret, "length", temp);})?)? {_afterSeqEl();}{_beforeSeqEl();} RPAREN {_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();}'unsigned'{_afterSeqEl();}){setProperty(ret, "isUnsigned", java.lang.Boolean.TRUE);}{_exitAlt();}  | {_enterAlt(1);} {setProperty(ret, "isUnsigned", java.lang.Boolean.FALSE);}{_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_parameter returns[Object ret2] @init{List<String> metaType=list("SQLDDL","Parameter");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl();} ({_enterAlt(0);} ({_beforeSeqEl();} EQ {_afterSeqEl();}{_beforeSeqEl();}( temp=sqlddl_value {setProperty(ret, "value", temp);}){_afterSeqEl();}){_exitAlt();}  | {_enterAlt(1);} {_exitAlt();} )
{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_value returns[Object ret2]
  :
  (ret=sqlddl_integerval
  | ret=sqlddl_nullval
  | ret=sqlddl_stringval)
  {
ret2=ret;
 }
  ;


sqlddl_integerval returns[Object ret2] @init{List<String> metaType=list("SQLDDL","IntegerVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=integerSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_nullval returns[Object ret2] @init{List<String> metaType=list("SQLDDL","NullVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}'NULL'{_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

sqlddl_stringval returns[Object ret2] @init{List<String> metaType=list("SQLDDL","StringVal");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl();}( temp=stringSymbol {setProperty(ret, "value", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

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
			{setText(unescapeString(getText(), 1));}
		)
	;

INT
	:	(DIGIT)+

	;

	FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

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
	