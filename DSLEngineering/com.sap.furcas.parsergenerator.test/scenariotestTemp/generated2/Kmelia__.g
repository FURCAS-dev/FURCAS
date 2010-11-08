lexer grammar Kmelia;

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

T__44 : 'COMPONENT' ;
T__45 : 'INTERFACE' ;
T__46 : 'provides' ;
T__47 : 'requires' ;
T__48 : 'SERVICES' ;
T__49 : 'END_SERVICES' ;
T__50 : 'required' ;
T__51 : 'provided' ;
T__52 : 'external' ;
T__53 : 'end' ;
T__54 : 'Behavior' ;
T__55 : 'Interface' ;
T__56 : 'init' ;
T__57 : 'final' ;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 467
COMMENT
  :
     ((('#' (~('\r'| '\n'))*)) | (('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/')))
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 473
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 479
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 485
EXCL
  :
  '!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 491
EXCLEXCL
  :
  '!!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 497
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 503
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 509
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 515
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 521
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 527
SEMI
  :
  ';'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 533
COLON
  :
  ':'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 539
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 545
QMARK
  :
  '?'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 551
COLONCOLON
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 557
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 563
MINUSMINUS
  :
  '--'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 569
RLARROW
  :
  '-->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 575
RARROW
  :
  '->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 581
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 587
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 593
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 599
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 605
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 611
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 617
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 623
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 629
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 635
NE
  :
  '<>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 641
LARROW
  :
  '<-'
  ;



// testLiterals = false;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 650
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 659
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 665
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 670
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

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 681
fragment
SNAME



	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 689
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

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 703
INT
	:	(DIGIT)+

	;

	// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 708
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 710
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

// $ANTLR src "./scenariotestTemp/generated2/Kmelia.g" 756
STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
			{setText(unescapeString(getText(), 1));}
	;

	