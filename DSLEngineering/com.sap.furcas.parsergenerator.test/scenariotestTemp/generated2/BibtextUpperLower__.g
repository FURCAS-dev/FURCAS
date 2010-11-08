lexer grammar BibtextUpperLower;

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

T__18 : 'article' ;
T__19 : 'author' ;
T__20 : '=' ;
T__21 : '.' ;
T__22 : 'year' ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 301
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 307
COMA
  :
  ','
  ;


// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 313
LCURLY
  :
  '{'
  ;


// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 319
RCURLY
  :
  '}'
  ;


// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 325
NL
    :   (   '\r' '\n'
        |   '\n' '\r'   //Improbable
        |   '\r'
        |   '\n'
        )
    {newline();$channel=HIDDEN;}
    ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 334
WS
    :   (   ' '
        |   '\t'
        )
        {$channel=HIDDEN;}    ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 340
fragment
DIGIT
    :   '0'..'9'
    ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 345
fragment
ALPHA
    :   'a'..'z'
    |   'A'..'Z'
    |   '_'
    //For Unicode compatibility (from 0000 to 00ff)
    |   '\u00C0' .. '\u00D6'
    |   '\u00D8' .. '\u00F6'
    |   '\u00F8' .. '\u00FF'
    ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 356
fragment
SNAME
    :   (ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 361
NAME
    :   (
            SNAME
        |   '"'!
            (   ESC
            |   '\n' {newline();}
            |   ~('\\'|'\"'|'\n')
            )*
            '"'!
            
        )
    ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 374
INT
    :   (DIGIT)+
    ;

    // $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 378
FLOAT   :   DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?   ;   // cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 380
fragment
ESC
    :   '\\'!
        (   'n' 
        |   'r' 
        |   't' 
        |   'b' 
        |   'f' 
        |   '"' 
        |   '\'' 
        |   '\\' 
        |   (
                ('0'..'3')
                (
                :   ('0'..'7')
                    (
                    :   '0'..'7'
                    )?
                )?
            |   ('4'..'7')
                (
                :   ('0'..'7')
                )?
            )
                {
                }
        )
    ;

// $ANTLR src "./scenariotestTemp/generated2/BibtextUpperLower.g" 409
STRING
    :   '\''!
        (   ESC
        |   '\n' {newline();}
        |   ~('\\'|'\''|'\n')
        )*
        '\''!
       
    ;