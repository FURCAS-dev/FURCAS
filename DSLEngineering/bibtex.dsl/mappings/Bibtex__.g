lexer grammar Bibtex;

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

T__15 : 'Entries:' ;
T__16 : '{' ;
T__17 : '}' ;
T__18 : 'Authors:' ;
T__19 : '@article' ;
T__20 : ',' ;
T__21 : 'title' ;
T__22 : '=' ;
T__23 : 'author' ;
T__24 : 'and' ;

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 177
COMMENT
  :
     ((('--' (~('\r'| '\n'))*)))
  ;


// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 183
NL
    :   (   '\r' '\n'
        |   '\n' '\r'   //Improbable
        |   '\r'
        |   '\n'
        )
    {newline();$channel=HIDDEN;}
    ;

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 192
WS
    :   (   ' '
        |   '\t'
        )
        {$channel=HIDDEN;}    ;

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 198
fragment
DIGIT
    :   '0'..'9'
    ;

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 203
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

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 214
fragment
SNAME
    :   (ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 219
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

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 232
INT
    :   (DIGIT)+
    ;

    // $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 236
FLOAT   :   DIGIT+ (('.' DIGIT)=>'.' DIGIT+)?   ;   // cannot accept DIGIT '.' because it would conflict with Navigation

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 238
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

// $ANTLR src "/home/stephan/projekte/java/FURCAS-git/workspace/DSLEngineering/bibtex.dsl/mappings/Bibtex.g" 267
STRING
    :   '\''!
        (   ESC
        |   '\n' {newline();}
        |   ~('\\'|'\''|'\n')
        )*
        '\''!
       
    ;