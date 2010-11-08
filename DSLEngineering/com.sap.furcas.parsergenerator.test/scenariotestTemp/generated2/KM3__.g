lexer grammar KM3;

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

T__42 : 'package' ;
T__43 : 'datatype' ;
T__44 : 'abstract' ;
T__45 : 'class' ;
T__46 : 'extends' ;
T__47 : 'reference' ;
T__48 : 'ordered' ;
T__49 : 'container' ;
T__50 : 'oppositeOf' ;
T__51 : 'unique' ;
T__52 : 'attribute' ;
T__53 : 'enumeration' ;
T__54 : 'literal' ;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 439
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 445
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 451
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 457
EXCL
  :
  '!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 463
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 469
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 475
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 481
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 487
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 493
SEMI
  :
  ';'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 499
COLON
  :
  ':'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 505
COLONS
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 511
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 517
SHARP
  :
  '#'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 523
QMARK
  :
  '?'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 529
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 535
RARROW
  :
  '->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 541
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 547
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 553
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 559
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 565
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 571
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 577
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 583
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 589
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 595
NE
  :
  '<>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 601
LARROW
  :
  '<-'
  ;



// testLiterals = false;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 610
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 619
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 625
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 630
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

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 641
fragment
SNAME



	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 649
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

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 666
INT
	:	(DIGIT)+

	;

	// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 671
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 673
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

// $ANTLR src "./scenariotestTemp/generated2/KM3.g" 711
STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
	;

	