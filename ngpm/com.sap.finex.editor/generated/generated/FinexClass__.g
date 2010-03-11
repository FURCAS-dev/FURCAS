lexer grammar FinexClass;

@members {  public com.sap.mi.textual.grammar.IModelInjector ei = null;
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
import com.sap.mi.textual.grammar.antlr3.ITokenFactory;
import com.sap.mi.textual.grammar.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

T__40 : 'value' ;
T__41 : 'opposite' ;
T__42 : 'DEFAULT' ;
T__43 : 'AS' ;
T__44 : 'KEY' ;
T__45 : 'function' ;
T__46 : 'manipulator' ;
T__47 : 'IN' ;
T__48 : ',' ;
T__49 : 'OUT' ;
T__50 : '-' ;
T__51 : 'not' ;
T__52 : '*' ;
T__53 : '/' ;
T__54 : 'AND' ;
T__55 : 'OR' ;
T__56 : '+' ;
T__57 : '>=' ;
T__58 : '<=' ;
T__59 : '!=' ;
T__60 : 'all' ;
T__61 : 'and' ;
T__62 : 'or' ;
T__63 : 'xor' ;
T__64 : 'count' ;
T__65 : 'single' ;
T__66 : 'sum' ;
T__67 : 'avg' ;
T__68 : 'min' ;
T__69 : 'max' ;
T__70 : 'create' ;
T__71 : 'this' ;
T__72 : 'select' ;
T__73 : 'from' ;
T__74 : 'where' ;
T__75 : 'as' ;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1461
COMMENT
  :
     ((('//' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1467
MULTI_LINE_COMMENT
  :
     ((('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1473
LBRACKET
  :
  '['
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1479
RBRACKET
  :
  ']'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1485
LCURL
  :
  '{'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1491
RCURL
  :
  '}'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1497
LANGLE
  :
  '<'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1503
RANGLE
  :
  '>'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1509
LPAREN
  :
  '('
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1515
RPAREN
  :
  ')'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1521
EQUALS
  :
  '='
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1527
EQUALSEQUALS
  :
  '=='
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1533
ASSIGN
  :
  ':='
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1539
DOT
  :
  '.'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1545
DDOT
  :
  '..'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1551
PIPE
  :
  '|'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1557
COLON
  :
  ':'
  ;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1563
SEMICOLON
  :
  ';'
  ;



// testLiterals = false;


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1573
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();$channel=HIDDEN;}
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1582
WS
	:	(	' '
		|	'\t'
		){$channel=HIDDEN;}
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1588
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1593
fragment
ALPHA
	:	LOWERCASE_ALPHA | UPPERCASE_ALPHA
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1598
fragment
LOWERCASE_ALPHA
	:	'a'..'z'
	|	'_'
	// lowercase accented characters
	|	'\u00DE' .. '\u00F6'
	|	'\u00F8' .. '\u00FF'
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1607
fragment
UPPERCASE_ALPHA
	:	'A'..'Z'
	// uppercase accented characters
	|	'\u00C0' .. '\u00D6'
	|	'\u00D8' .. '\u00DD'
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1615
fragment
FIRST_LOWERCASE_SNAME
	:	(LOWERCASE_ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1620
fragment
FIRST_UPPERCASE_SNAME
	:	(UPPERCASE_ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1625
BOOL	:	'true' | 'false'	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1627
OBJECT	:	'o:'	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1629
FIRST_UPPERCASE_NAME
	:	FIRST_UPPERCASE_SNAME
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1633
FIRST_LOWERCASE_NAME
	:	FIRST_LOWERCASE_SNAME
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1637
BINARY
	:	'0x'((DIGIT | 'a'..'f' | 'A'..'F') (DIGIT | 'a'..'f' | 'A'..'F'))+
	;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1641
protected
INT
 : (DIGIT)+
 ;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1646
fragment
FLOAT
	:	DIGIT+ '.' DIGIT*
	;
  
// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1651
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


// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1665
DATE	:	DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ((' '|'T') DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT
            (
              ( (',' | '.') DIGIT ) => ((',' | '.') (DIGIT)+)
              |
            )
            ('Z' | (('+'|'-') DIGIT DIGIT DIGIT DIGIT)?) )? ;

// $ANTLR src "C:\_fzi\projects\CTS\git\ngpm\com.sap.finex.editor\generated\generated\FinexClass.g" 1672
STRING
	:	'"'!
		(	
		//ESC	|		
			'\n' {newline();}
		|	~('\\'|'"'|'\n')
		)*
		'"'!
	;

	