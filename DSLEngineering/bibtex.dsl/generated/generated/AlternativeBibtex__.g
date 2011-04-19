lexer grammar AlternativeBibtex;

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
     * Removing starting/ending delimiters.
     * @deprecated
     */
    public String unescapeString(String s, int delimLength) {
        // get rid of the starting and ending delimiters (e.g., '\'', '"')
       if (s.charAt(0) == '\'' && s.charAt(s.length()-delimLength) == '\'' || s.charAt(0) == '\"' && s.charAt(s.length()-delimLength) == '\"') {
                s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
       } else if (s.length() >= 4 && s.charAt(0) == '\\' && s.charAt(s.length()-delimLength) == '\"' && s.charAt(1) == '\"' && s.charAt(s.length()-delimLength-1) == '\\') {
             //also handle strings that are surrounded with an escaped string symbol \"value\"
             delimLength += 1;
             s = s.substring(delimLength, s.length()-(delimLength * 2 - 1));
        }
        return s;
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
package generated;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.antlr3.DefaultANTLR3LocationTokenFactory;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;}

T__15 : 'DB:' ;
T__16 : '{' ;
T__17 : '}' ;
T__18 : ':' ;

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 185
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 191
NL
    :   (   '\r' '\n'
        |   '\n' '\r'   //Improbable
        |   '\r'
        |   '\n'
        )
    {newline();$channel=HIDDEN;}
    ;

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 200
WS
    :   (   ' '
        |   '\t'
        )
        {$channel=HIDDEN;}    ;

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 206
fragment
DIGIT
    :   '0'..'9'
    ;

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 211
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

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 222
fragment
SNAME
    :   (ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 227
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

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 240
INT
    :   (DIGIT)+
    ;

    // $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 244
FLOAT   :   DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?   ;   // cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 246
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

// $ANTLR src "C:\Users\d043530\git\DSLEngineering\bibtex.dsl\generated\generated\AlternativeBibtex.g" 275
STRING
    :   '\''!
        (   ESC
        |   '\n' {newline();}
        |   ~('\\'|'\''|'\n')
        )*
        '\''!
       
    ;