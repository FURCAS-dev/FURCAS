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

T__35 : 'in' ;
T__36 : 'Collection' ;
T__37 : 'endif' ;
T__38 : 'OrderedSet' ;
T__39 : 'collect' ;
T__40 : 'self' ;
T__41 : 'Bag' ;
T__42 : 'Set' ;
T__43 : 'iterate' ;
T__44 : 'if' ;
T__45 : 'let' ;
T__46 : 'then' ;
T__47 : 'forAll' ;
T__48 : 'Sequence' ;
T__49 : 'else' ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 964
COMMENT
  :
     ((('//' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 970
MULTI_LINE_COMMENT
  :
     ((('/**' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 976
DDOT
  :
  '..'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 982
LBRACKET
  :
  '['
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 988
RBRACKET
  :
  ']'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 994
LCURL
  :
  '{'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1000
RCURL
  :
  '}'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1006
STAR
  :
  '*'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1012
LPAREN
  :
  '('
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1018
RPAREN
  :
  ')'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1024
COLON
  :
  ':'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1030
DCOLON
  :
  '::'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1036
COMMA
  :
  ','
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1042
SEMI
  :
  ';'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1048
DOT
  :
  '.'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1054
EQUALS
  :
  '='
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1060
ARROW
  :
  '->'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1066
BAR
  :
  '|'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1072
APOSTROPHE
  :
  '\''
  ;



// testLiterals = false;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1082
NL
        :       (       '\r' '\n'
                |       '\n' '\r'     //Improbable
                |       '\r'
                |       '\n'
                )
        {newline();$channel=HIDDEN;}
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1091
WS
        :       (       ' '
                |       '\t'
                ){$channel=HIDDEN;}
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1097
fragment
DIGIT
        :       '0'..'9'
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1102
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

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1113
fragment
SNAME
        :       (ALPHA) (ALPHA | DIGIT)*
;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1118
BOOL    :       'true' | 'false'        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1120
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

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1132
QNAME
        : SNAME DCOLON SNAME (DCOLON SNAME )*
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1136
protected
INT
 : (DIGIT)+
 ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1141
fragment
FLOAT
        :       DIGIT+ '.' DIGIT*
        ;
  
// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1146
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


// $ANTLR src "C:\dev\workspaces\runtime-workspace\OCL.dsl\generated\generated\Ocl.g" 1160
STRING
        :       '"'!
                (       
                //ESC   |               
                        '\n' {newline();}
                |       ~('\\'|'"'|'\n')
                )*
                '"'!
        ;

        