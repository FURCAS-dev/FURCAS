lexer grammar Ocl;

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

T__39 : 'if' ;
T__40 : 'endif' ;
T__41 : 'then' ;
T__42 : 'forAll' ;
T__43 : 'self' ;
T__44 : 'else' ;
T__45 : 'Sequence' ;
T__46 : 'collect' ;
T__47 : 'Set' ;
T__48 : 'select' ;
T__49 : 'Collection' ;
T__50 : 'in' ;
T__51 : 'Bag' ;
T__52 : 'iterate' ;
T__53 : 'OrderedSet' ;
T__54 : 'let' ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1019
COMMENT
  :
     ((('//' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1025
MULTI_LINE_COMMENT
  :
     ((('/**' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1031
DDOT
  :
  '..'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1037
LBRACKET
  :
  '['
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1043
RBRACKET
  :
  ']'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1049
LCURL
  :
  '{'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1055
RCURL
  :
  '}'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1061
STAR
  :
  '*'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1067
LPAREN
  :
  '('
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1073
RPAREN
  :
  ')'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1079
COLON
  :
  ':'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1085
DCOLON
  :
  '::'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1091
COMMA
  :
  ','
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1097
SEMI
  :
  ';'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1103
DOT
  :
  '.'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1109
EQUALS
  :
  '='
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1115
GT
  :
  '>'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1121
GTRQULAS
  :
  '>='
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1127
LT
  :
  '<'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1133
LTEQUALS
  :
  '<='
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1139
ARROW
  :
  '->'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1145
BAR
  :
  '|'
  ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1151
APOSTROPHE
  :
  '\''
  ;



// testLiterals = false;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1161
NL
        :       (       '\r' '\n'
                |       '\n' '\r'     //Improbable
                |       '\r'
                |       '\n'
                )
        {newline();$channel=HIDDEN;}
        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1170
WS
        :       (       ' '
                |       '\t'
                ){$channel=HIDDEN;}
        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1176
fragment
DIGIT
        :       '0'..'9'
        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1181
fragment
ALPHA
        :       'a'..'z'
        |       'A'..'Z'
        |       '_'
        //For Unicode compatibility (from 0000 to 00ff)
        |       '\u00C0' .. '\u00D6'
        |       '\u00D8' .. '\u00F6'
        |       '\u00F8' .. '\u00FF'
        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1192
fragment
SNAME
        :       (ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1197
BOOL    :       'true' | 'false'        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1199
NAME
        :       (
                        (SNAME (~DCOLON|EOF))=>SNAME
                |       '\''!
                        (       
                        '\n' {newline();}
                        |       ~('\\'|'\''|'\n')
                        )*
                        '\''!
                )
        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1211
QNAME
        : SNAME DCOLON SNAME (DCOLON SNAME )*
        ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1215
protected
INT
 : (DIGIT)+
 ;

// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1220
fragment
FLOAT
        :       DIGIT+ '.' DIGIT*
        ;
  
// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1225
RANGE_OR_INT
    :   ( INT '..' ) => INT  { _type = INT; }
    |   ( INT '.' NAME ) => INT { _type = INT; }
    |   ( INT '.' ~('.' |       'a'..'z'
                                                |       'A'..'Z'
                                                |       '_'
                                                //For Unicode compatibility (from 0000 to 00ff)
                                                |       '\u00C0' .. '\u00D6'
                                                |       '\u00D8' .. '\u00F6'
                                                |       '\u00F8' .. '\u00FF') )  => FLOAT { _type = FLOAT; }
    |   INT                  { _type = INT; }
    ;


// $ANTLR src "/Users/thomas/dev/furcas-emf/DSLEngineering/com.sap.furcas.ocl.editor/generated/generated/Ocl.g" 1239
STRING
        :       '"'!
                (       
                //ESC   |               
                        '\n' {newline();}
                |       ~('\\'|'"'|'\n')
                )*
                '"'!
        ;

        