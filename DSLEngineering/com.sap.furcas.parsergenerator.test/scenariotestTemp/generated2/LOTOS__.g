lexer grammar LOTOS;

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

T__48 : 'is' ;
T__49 : 'false' ;
T__50 : 'true' ;
T__51 : 'choice' ;
T__52 : 'sorts' ;
T__53 : 'library' ;
T__54 : 'endtype' ;
T__55 : 'process' ;
T__56 : 'hide' ;
T__57 : 'where' ;
T__58 : 'of' ;
T__59 : 'endproc' ;
T__60 : 'in' ;
T__61 : 'ofsort' ;
T__62 : 'forall' ;
T__63 : 'or' ;
T__64 : 'let' ;
T__65 : 'and' ;
T__66 : 'endlib' ;
T__67 : 'opns' ;
T__68 : 'neq' ;
T__69 : 'exit' ;
T__70 : 'endspec' ;
T__71 : 'eqns' ;
T__72 : 'behaviour' ;
T__73 : 'specification' ;
T__74 : 'type' ;
T__75 : 'eq' ;
T__76 : 'noexit' ;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1005
COMMENT
  :
     ((('(*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*)')))
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1011
LSQUARERSQUARE
  :
  '[]'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1017
LSQUARE
  :
  '['
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1023
RSQUARE
  :
  ']'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1029
EXCL
  :
  '!'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1035
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1041
LPAREN
  :
  '('
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1047
RPAREN
  :
  ')'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1053
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1059
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1065
SEMI
  :
  ';'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1071
COLON
  :
  ':'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1077
PIPE
  :
  '|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1083
SHARP
  :
  '#'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1089
QMARK
  :
  '?'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1095
COLONCOLON
  :
  '::'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1101
PIPE3
  :
  '|||'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1107
PIPELSQUARE
  :
  '|['
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1113
RSQUAREPIPE
  :
  ']|'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1119
COLONEQ
  :
  ':='
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1125
IMPLIES
  :
  '=>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1131
POINT
  :
  '.'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1137
RARROW
  :
  '->'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1143
MINUS
  :
  '-'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1149
STAR
  :
  '*'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1155
SLASH
  :
  '/'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1161
PLUS
  :
  '+'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1167
EQ
  :
  '='
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1173
GT
  :
  '>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1179
LT
  :
  '<'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1185
GE
  :
  '>='
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1191
LE
  :
  '<='
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1197
NE
  :
  '<>'
  ;


// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1203
LARROW
  :
  '<-'
  ;



// testLiterals = false;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1212
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();}
	;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1221
WS
	:	(	' '
		|	'\t'
		)
	;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1227
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1232
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

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1243
fragment
SNAME



	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1251
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

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1265
INT
	:	(DIGIT)+

	;

	// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1270
FLOAT	:	DIGIT+ '.' DIGIT*	;

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1272
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

// $ANTLR src "./scenariotestTemp/generated2/LOTOS.g" 1318
STRING
	:	'\''!
		(	ESC
		|	'\n' {newline();}
		|	~('\\'|'\''|'\n')
		)*
		'\''!
			{setText(unescapeString(getText(), 1));}
	;

	