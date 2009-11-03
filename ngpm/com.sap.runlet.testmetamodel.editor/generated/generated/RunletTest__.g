lexer grammar RunletTest;

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

T__49 : 'sub' ;
T__50 : 'runlettest' ;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 340
COMMENT
  :
     ((('//' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 346
MULTI_LINE_COMMENT
  :
     ((('/*' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/')))
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 352
LBRACKET
  :
  '['
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 358
RBRACKET
  :
  ']'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 364
LCURL
  :
  '{'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 370
RCURL
  :
  '}'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 376
LANGLE
  :
  '<'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 382
RANGLE
  :
  '>'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 388
LPAREN
  :
  '('
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 394
RPAREN
  :
  ')'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 400
EXCL
  :
  '!'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 406
EQUALS
  :
  '='
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 412
EQUALSEQUALS
  :
  '=='
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 418
ASSIGN
  :
  ':='
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 424
DOT
  :
  '.'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 430
DDOT
  :
  '..'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 436
ARROW
  :
  '->'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 442
PIPE
  :
  '|'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 448
COLON
  :
  ':'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 454
DCOLON
  :
  '::'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 460
SEMICOLON
  :
  ';'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 466
INCLUDING
  :
  'including'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 472
EXCLUDING
  :
  'excluding'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 478
INCLUDINGAT
  :
  'includingAt'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 484
EXCLUDINGAT
  :
  'excludingAt'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 490
ITERATE
  :
  'iterate'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 496
LCURL_LBRACK
  :
  '{['
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 502
LBRACK_LCURL
  :
  '[{'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 508
RCURL_RBRACK
  :
  '}]'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 514
RBRACK_RCURL
  :
  ']}'
  ;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 520
STAR
  :
  '*'
  ;



// testLiterals = false;


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 530
NL
	:	(	'\r' '\n'
		|	'\n' '\r'	//Improbable
		|	'\r'
		|	'\n'
		)
	{newline();$channel=HIDDEN;}
	;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 539
WS
	:	(	' '
		|	'\t'
		){$channel=HIDDEN;}
	;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 545
fragment
DIGIT
	:	'0'..'9'
	;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 550
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

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 561
fragment
SNAME
	:	(ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 566
BOOL	:	'true' | 'false'	;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 568
OBJECT	:	'o:'	;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 570
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

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 583
BINARY
	:	'0x'(DIGIT)+
	;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 587
protected
INT
 : (DIGIT)+
 ;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 592
fragment
FLOAT
	:	DIGIT+ '.' DIGIT*
	;
  
// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 597
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


// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 611
DATE	:	DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT ((' '|'T') DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT
            ((','|'.') (DIGIT)+)? ('Z' | (('+'|'-') DIGIT DIGIT DIGIT DIGIT)?) )? ;

// $ANTLR src "C:\data\cts\FURCAS\furcas_full\ngpm\com.sap.runlet.testmetamodel.editor\generated\generated\RunletTest.g" 614
STRING
	:	'"'!
		(	
		//ESC	|		
			'\n' {newline();}
		|	~('\\'|'"'|'\n')
		)*
		'"'!
	;

	