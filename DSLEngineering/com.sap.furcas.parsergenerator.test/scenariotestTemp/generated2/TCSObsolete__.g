lexer grammar TCSObsolete;

@members {  public com.sap.furcas.runtime.parser.IModelInjector ei = null;
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
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

T__48 : 'leftSpace' ;
T__49 : 'always' ;
T__50 : 'true' ;
T__51 : 'for' ;
T__52 : 'end' ;
T__53 : 'storeOpTo' ;
T__54 : 'disambiguate' ;
T__55 : 'rightNone' ;
T__56 : 'context' ;
T__57 : 'ifmissing' ;
T__58 : 'primitiveTemplate' ;
T__59 : 'refersToKey' ;
T__60 : 'leftNone' ;
T__61 : 'postfix' ;
T__62 : 'part' ;
T__63 : 'startNL' ;
T__64 : 'indentIncr' ;
T__65 : 'esc' ;
T__66 : 'mode' ;
T__67 : 'lookIn' ;
T__68 : 'multiLine' ;
T__69 : 'false' ;
T__70 : 'words' ;
T__71 : 'abstract' ;
T__72 : 'default' ;
T__73 : 'importContext' ;
T__74 : 'never' ;
T__75 : 'as' ;
T__76 : 'operatorTemplate' ;
T__77 : 'serializer' ;
T__78 : 'enumerationTemplate' ;
T__79 : 'word' ;
T__80 : 'template' ;
T__81 : 'function' ;
T__82 : 'createAs' ;
T__83 : 'keywords' ;
T__84 : 'main' ;
T__85 : 'separator' ;
T__86 : 'orKeyword' ;
T__87 : 'lexer' ;
T__88 : 'token' ;
T__89 : 'startNbNL' ;
T__90 : 'endOfLine' ;
T__91 : 'all' ;
T__92 : 'disambiguateV3' ;
T__93 : 'and' ;
T__94 : 'value' ;
T__95 : 'left' ;
T__96 : 'operators' ;
T__97 : 'prefix' ;
T__98 : 'storeRightTo' ;
T__99 : 'nbNL' ;
T__100 : 'rightSpace' ;
T__101 : 'k' ;
T__102 : 'one' ;
T__103 : 'isDefined' ;
T__104 : 'hex' ;
T__105 : 'right' ;
T__106 : 'nonPrimary' ;
T__107 : 'using' ;
T__108 : 'refersTo' ;
T__109 : 'endNL' ;
T__110 : 'priority' ;
T__111 : 'autoCreate' ;
T__112 : 'source' ;
T__113 : 'drop' ;
T__114 : 'start' ;
T__115 : 'createIn' ;
T__116 : 'forcedLower' ;
T__117 : 'deep' ;
T__118 : 'octal' ;
T__119 : 'operatored' ;
T__120 : 'symbols' ;
T__121 : 'multi' ;
T__122 : 'syntax' ;
T__123 : 'auto' ;
T__124 : 'addToContext' ;

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1388
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1394
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1400
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1406
DLSQUARE
  :
  '[['
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1412
DRSQUARE
  :
  ']]'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1418
EXCL
  :
  '!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1424
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1430
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1436
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1442
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1448
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1454
DLCURLY
  :
  '{{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1460
DRCURLY
  :
  '}}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1466
SEMI
  :
  ';'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1472
COLON
  :
  ':'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1478
DLCOLON
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1484
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1490
SHARP
  :
  '#'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1496
QMARK
  :
  '?'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1502
DOLLAR
  :
  '$'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1508
AROBAS
  :
  '@'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1514
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1520
RARROW
  :
  '->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1526
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1532
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1538
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1544
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1550
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1556
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1562
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1568
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1574
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1580
NE
  :
  '<>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1586
LARROW
  :
  '<-'
  ;



// testLiterals = false;

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1595
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1604
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1610
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1615
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
	



// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1629
fragment
SNAME
	:	(ALPHA) (ALPHA | DIGIT)* 
;


// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1635
NAME
	:	(   
		SNAME
		|	'\''!
			(	ESC
			|	'\n' {newline();}
			|	~('\\'|'\''|'\n')
			)*
			'\''!
		{setText(unescapeString(getText(), 1));}
		)
	;
	

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1649
INT
	:	(DIGIT)+
	;

	// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1653
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1655
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

// $ANTLR src "./scenariotestTemp/generated2/TCSObsolete.g" 1684
STRING
	:	'"'!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\"'|'\n')
		)*
		'"'!
		{setText(unescapeString(getText(), 1));}

	;

	