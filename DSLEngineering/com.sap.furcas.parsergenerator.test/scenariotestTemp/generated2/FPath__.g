lexer grammar FPath;

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

T__42 : 'not' ;
T__43 : 'div' ;
T__44 : 'and' ;
T__45 : 'or' ;
T__46 : '$' ;
T__47 : 'component' ;
T__48 : 'internal-interface' ;
T__49 : 'interface' ;
T__50 : 'attribute' ;
T__51 : 'binding' ;
T__52 : 'child' ;
T__53 : 'parent' ;
T__54 : 'descendant' ;
T__55 : 'ancestor' ;
T__56 : 'sibling' ;
T__57 : 'descendant-or-self' ;
T__58 : 'ancestor-or-self' ;
T__59 : 'sibling-or-self' ;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 560
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 566
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 572
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 578
EXCL
  :
  '!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 584
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 590
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 596
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 602
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 608
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 614
SEMI
  :
  ';'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 620
COLON
  :
  ':'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 626
COLONCOLON
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 632
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 638
SHARP
  :
  '#'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 644
QMARK
  :
  '?'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 650
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 656
RARROW
  :
  '->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 662
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 668
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 674
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 680
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 686
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 692
EQEQ
  :
  '=='
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 698
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 704
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 710
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 716
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 722
NE
  :
  '<>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 728
LARROW
  :
  '<-'
  ;



// testLiterals = false;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 737
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 746
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 752
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 757
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

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 768
fragment
SNAME
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 773
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

	// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 786
FLOAT	:	DIGIT+ ('.' DIGIT*)?	;

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 788
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

// $ANTLR src "./scenariotestTemp/generated2/FPath.g" 818
STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
			{setText(unescapeString(getText(), 1));}
	;

	