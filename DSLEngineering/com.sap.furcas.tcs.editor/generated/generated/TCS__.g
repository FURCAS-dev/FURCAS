lexer grammar TCS;

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

T__49 : 'default' ;
T__50 : 'source' ;
T__51 : 'lookupScope' ;
T__52 : 'nonPrimary' ;
T__53 : 'always' ;
T__54 : 'symbols' ;
T__55 : 'referenceOnly' ;
T__56 : 'abstract' ;
T__57 : 'all' ;
T__58 : 'indentIncr' ;
T__59 : 'right' ;
T__60 : 'function' ;
T__61 : 'value' ;
T__62 : 'octal' ;
T__63 : 'using' ;
T__64 : 'operatored' ;
T__65 : 'endNL' ;
T__66 : 'referenceBy' ;
T__67 : 'never' ;
T__68 : 'disambiguateV3' ;
T__69 : 'auto' ;
T__70 : 'endOfLine' ;
T__71 : 'lookIn' ;
T__72 : 'prefix' ;
T__73 : 'rightSpace' ;
T__74 : 'drop' ;
T__75 : 'postfix' ;
T__76 : 'forcedUpper' ;
T__77 : 'leftSpace' ;
T__78 : 'disambiguate' ;
T__79 : 'rightNone' ;
T__80 : 'template' ;
T__81 : 'end' ;
T__82 : 'separator' ;
T__83 : 'deep' ;
T__84 : 'partial' ;
T__85 : 'part' ;
T__86 : 'autoCreate' ;
T__87 : 'as' ;
T__88 : 'hex' ;
T__89 : 'omitted' ;
T__90 : 'esc' ;
T__91 : 'createAs' ;
T__92 : 'forcedLower' ;
T__93 : 'startNL' ;
T__94 : 'enumerationTemplate' ;
T__95 : 'main' ;
T__96 : 'and' ;
T__97 : 'storeRightTo' ;
T__98 : 'nbNL' ;
T__99 : 'serializer' ;
T__100 : 'orKeyword' ;
T__101 : 'priority' ;
T__102 : 'token' ;
T__103 : 'refersTo' ;
T__104 : 'leftNone' ;
T__105 : 'keywords' ;
T__106 : 'lexer' ;
T__107 : 'word' ;
T__108 : 'left' ;
T__109 : 'true' ;
T__110 : 'false' ;
T__111 : 'ifmissing' ;
T__112 : 'foreach' ;
T__113 : 'importContext' ;
T__114 : 'mode' ;
T__115 : 'startNbNL' ;
T__116 : 'one' ;
T__117 : 'context' ;
T__118 : 'storeOpTo' ;
T__119 : 'multi' ;
T__120 : 'operators' ;
T__121 : 'addToContext' ;
T__122 : 'createIn' ;
T__123 : 'k' ;
T__124 : 'when' ;
T__125 : 'isDefined' ;
T__126 : 'start' ;
T__127 : 'for' ;
T__128 : 'operatorTemplate' ;
T__129 : 'primitiveTemplate' ;
T__130 : 'syntax' ;
T__131 : 'semDisambiguate' ;
T__132 : 'instanceOf' ;
T__133 : 'multiLine' ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1942
COMMENT
  :
     ((('--' (~('\r'| '\n'))*))){$channel=HIDDEN;}
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1948
MULTI_LINE_COMMENT
  :
     ((('/**' (options {greedy = false;} : ('\n'| ~ '\n'))* '*/'))){$channel=HIDDEN;}
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1954
LSQUARE
  :
  '['
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1960
RSQUARE
  :
  ']'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1966
DLSQUARE
  :
  '[['
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1972
DRSQUARE
  :
  ']]'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1978
EXCL
  :
  '!'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1984
COMA
  :
  ','
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1990
LPAREN
  :
  '('
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 1996
RPAREN
  :
  ')'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2002
LCURLY
  :
  '{'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2008
RCURLY
  :
  '}'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2014
DLCURLY
  :
  '{{'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2020
DRCURLY
  :
  '}}'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2026
SEMI
  :
  ';'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2032
COLON
  :
  ':'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2038
DLCOLON
  :
  '::'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2044
PIPE
  :
  '|'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2050
SHARP
  :
  '#'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2056
QMARK
  :
  '?'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2062
DOLLAR
  :
  '$'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2068
AROBAS
  :
  '@'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2074
POINT
  :
  '.'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2080
RARROW
  :
  '->'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2086
MINUS
  :
  '-'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2092
STAR
  :
  '*'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2098
SLASH
  :
  '/'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2104
PLUS
  :
  '+'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2110
EQ
  :
  '='
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2116
GT
  :
  '>'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2122
LT
  :
  '<'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2128
GE
  :
  '>='
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2134
LE
  :
  '<='
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2140
NE
  :
  '<>'
  ;


// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2146
LARROW
  :
  '<-'
  ;



// testLiterals = false;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2155
NL
        :       (       '\r' '\n'
                |       '\n' '\r'     //Improbable
                |       '\r'
                |       '\n'
                )
        {newline();$channel=HIDDEN;}
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2164
WS
        :       (       ' '
                |       '\t'
                ){$channel=HIDDEN;}
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2170
fragment
DIGIT
        :       '0'..'9'
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2175
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
        



// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2189
fragment
SNAME
        :       
//      (~ORKEYWORD)=> 
        (ALPHA) (ALPHA | DIGIT)* 
;

//QNAME_OR_NAME :
//         ( ORKEYWORD COLON ) => ORKEYWORD { _type = ORKEYWORD; }
//         |    ( SNAME DLCOLON SNAME ) => QNAME { _type = QNAME; }
//         |    (~ORKEYWORD COLON | SNAME COLON ~(COLON) ) => NAME { _type = NAME; }
//         |    ( ~ORKEYWORD | SNAME ~COLON ) => NAME { _type = NAME; }
//         |    ( '\'' SNAME) => NAME { _type = NAME; }
//;

//fragment 
//ORKEYWORD :
//      'orKeyword'
//;

//fragment
// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2210
NAME
        :       (   
                        SNAME
                |       '\''!  // exclamation marks means to exclude the char from the token (in theory)
                        (       ESC
                        |       '\n' {newline();}
                        |       ~('\\'|'\''|'\n') // means any other character
                        )*
                        '\''!
                )
        ;

//fragment
//QNAME
//        : SNAME DLCOLON SNAME (DLCOLON SNAME )*
//        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2227
INT
        :       (DIGIT)+
        ;

        // $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2231
FLOAT   :       DIGIT+ '.' DIGIT*       ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2233
fragment
ESC
        :       '\\'!
                (       'n' 
                |       'r' 
                |       't' 
                |       'b' 
                |       'f' 
                |       '"' 
                |       '\'' 
                |       '\\' 
                |       (
                                ('0'..'3')
                                (
                                :       ('0'..'7')
                                        (
                                        :       '0'..'7'
                                        )?
                                )?
                        |       ('4'..'7')
                                (
                                :       ('0'..'7')
                                )?
                        )
                                {
                                }
                )
        ;

// $ANTLR src "C:\dev\workspaces\runtime-workspace\com.sap.furcas.tcs.editor\generated\generated\TCS.g" 2262
STRING
        :       '"'!
                (       ESC
                |       '\n' {newline();}
                |       ~('\\'|'\"'|'\n')  // means any other character
                )*
                '"'!
        ;

        