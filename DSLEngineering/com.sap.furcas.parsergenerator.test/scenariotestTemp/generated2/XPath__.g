lexer grammar XPath;

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

T__36 : 'div' ;
T__37 : 'mod' ;
T__38 : 'and' ;
T__39 : 'or' ;
T__40 : ',' ;
T__41 : 'node' ;
T__42 : 'text' ;
T__43 : 'ancestor' ;
T__44 : 'ancestor-or-self' ;
T__45 : 'attribute' ;
T__46 : 'child' ;
T__47 : 'descendant' ;
T__48 : 'descendant-or-self' ;
T__49 : 'following' ;
T__50 : 'following-sibling' ;
T__51 : 'namespace' ;
T__52 : 'parent' ;
T__53 : 'preceding' ;
T__54 : 'preceding-sibling' ;
T__55 : 'self' ;

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 817
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 823
DOLLAR
  :
  '$'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 829
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 835
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 841
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 847
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 853
COLONS
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 859
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 865
POINTPOINT
  :
  '..'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 871
AROBAS
  :
  '@'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 877
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 883
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 889
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 895
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 901
SLASHSLASH
  :
  '//'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 907
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 913
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 919
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 925
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 931
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 937
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 943
EXCLEQ
  :
  '!='
  ;



// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 950
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 959
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 965
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 970
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

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 981
fragment
SNAME
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 986
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

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 999
INT
	:	(DIGIT)+
	;

	// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 1003
FLOAT	:	DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?	;	// cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 1005
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

// $ANTLR src "./scenariotestTemp/generated2/XPath.g" 1034
STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
		{setText(unescapeString(getText(), 1));}
	;
	