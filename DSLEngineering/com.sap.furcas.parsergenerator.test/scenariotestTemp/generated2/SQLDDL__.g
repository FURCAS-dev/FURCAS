lexer grammar SQLDDL;

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

T__42 : 'CREATE' ;
T__43 : 'TABLE' ;
T__44 : 'NOT' ;
T__45 : 'NULL' ;
T__46 : 'default' ;
T__47 : 'UNIQUE' ;
T__48 : 'KEY' ;
T__49 : 'PRIMARY' ;
T__50 : 'FOREIGN' ;
T__51 : 'REFERENCES' ;
T__52 : 'unsigned' ;

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 453
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 459
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 465
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 471
EXCL
  :
  '!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 477
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 483
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 489
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 495
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 501
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 507
SEMI
  :
  ';'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 513
COLON
  :
  ':'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 519
COLONS
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 525
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 531
SHARP
  :
  '#'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 537
QMARK
  :
  '?'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 543
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 549
RARROW
  :
  '->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 555
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 561
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 567
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 573
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 579
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 585
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 591
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 597
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 603
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 609
NE
  :
  '<>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 615
LARROW
  :
  '<-'
  ;



// testLiterals = false;
// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 623
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 632
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 638
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 643
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

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 654
fragment
SNAME



	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 662
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

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 676
INT
	:	(DIGIT)+

	;

	// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 681
FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 683
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

// $ANTLR src "./scenariotestTemp/generated2/SQLDDL.g" 729
STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
		{setText(unescapeString(getText(), 1));}
	;
	