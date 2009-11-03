grammar RunletTest;
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
import com.sap.mi.textual.grammar.IModelElementProxy;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import org.antlr.runtime.Token;
}


@members {
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
  | 'sub' {ret = "sub";}
  | 'runlettest' {ret = "runlettest";})
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
  ((ret=runlettest_runlettest) EOF) 
  {
ret2=ret;
}
  ;


runlettest_runlettest returns[Object ret2] @init{List<String> metaType=list("runlettest","RunletTest");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, true, false, new String[]{"root"}) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E064D8BE8ADBF2018BC211DEA79400016CE99C52");}'runlettest'{_afterSeqEl();}{_beforeSeqEl("E064D8BE8ADBF2038BC211DE822700016CE99C52");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();}{_beforeSeqEl("E064D8BE8ADBF2048BC211DEC31E00016CE99C52");} LCURL {_afterSeqEl();}{_beforeSeqEl("E064D8BE8ADBF20B8BC211DEC53000016CE99C52");}(({_beforeSeqEl("E064D8BE8ADBF2098BC211DE9D7900016CE99C52");}( temp=runlettest_subcomponent {setProperty(ret, "sub", temp);} ({_enterSepSeq();}({_beforeSeqEl("E064D8BE8ADBF2068BC211DEB9C000016CE99C52");} SEMICOLON {_afterSeqEl();}){_exitSepSeq();} temp=runlettest_subcomponent {setProperty(ret, "sub", temp);})* )? {_afterSeqEl();})){_afterSeqEl();}{_beforeSeqEl("E064D8BE8ADBF20C8BC211DE857F00016CE99C52");} RCURL {_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, true);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

runlettest_subcomponent returns[Object ret2] @init{List<String> metaType=list("runlettest","Subcomponent");
onEnterTemplateRule(metaType);
IModelElementProxy ret=(getBacktrackingLevel()==0) ? createModelElementProxy(metaType, false, false) : null;
org.antlr.runtime.Token firstToken=input.LT(1);
}
  :
  ({_beforeSeqEl("E064D8BE8AEB34408BC211DEC56A00016CE99C52");}'sub'{_afterSeqEl();}{_beforeSeqEl("E064D8BE8AEB34428BC211DE99BA00016CE99C52");}( temp=identifier {setProperty(ret, "name", temp);}){_afterSeqEl();})
  {
ret2 = commitCreation(ret, firstToken, false);

 }
  ;
catch [Exception e] {handleExceptionInTemplateRule(e, firstToken, ret);} finally {onExitTemplateRule(metaType);}

COMMENT
  :
     ((('//' (~('\r'| '\n'))*)))
  ;


MULTI_LINE_COMMENT
  :
     ((('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/')))
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


EXCL
  :
  '!'
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


ARROW
  :
  '->'
  ;


PIPE
  :
  '|'
  ;


COLON
  :
  ':'
  ;


DCOLON
  :
  '::'
  ;


SEMICOLON
  :
  ';'
  ;


INCLUDING
  :
  'including'
  ;


EXCLUDING
  :
  'excluding'
  ;


INCLUDINGAT
  :
  'includingAt'
  ;


EXCLUDINGAT
  :
  'excludingAt'
  ;


ITERATE
  :
  'iterate'
  ;


LCURL_LBRACK
  :
  '{['
  ;


LBRACK_LCURL
  :
  '[{'
  ;


RCURL_RBRACK
  :
  '}]'
  ;


RBRACK_RCURL
  :
  ']}'
  ;


STAR
  :
  '*'
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

BOOL	:	'true' | 'false'	;

OBJECT	:	'o:'	;

NAME
	:	(
			SNAME
		|	'\''!
			(	
		//	ESC	|
			'\n' {newline();}
			|	~('\\'|'\''|'\n')
			)*
			'\''!
		)
	;

BINARY
	:	'0x'(DIGIT)+
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
    |	( INT '.' NAME ) => INT { _type = INT; }
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
            ((','|'.') (DIGIT)+)? ('Z' | (('+'|'-') DIGIT DIGIT DIGIT DIGIT)?) )? ;

STRING
	:	'"'!
		(	
		//ESC	|		
			'\n' {newline();}
		|	~('\\'|'"'|'\n')
		)*
		'"'!
	;

	