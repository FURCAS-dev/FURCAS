%options escape=$
%options single-productions
%options noserialize
%options template=LexerTemplateD.g

$Define

	$action_class /.$file_prefix./
	$prs_stream_class /.PrsStream./
	$eof_token /.$_EOF_TOKEN./

$End

$Globals
	/.
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.shared.util.parsers.AstException;
import com.sap.tc.moin.repository.shared.util.parsers.LPGMessages;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.shared.util.LocalizedProcessException;
	./
$End

$Include
	LexerBasicMap.g
$End

$Headers
/.
    // lexer/parser errors
    private LocalizedProcessException getErrorException(int index, String tokenText) {
        LocalizedProcessException result;
        switch (index) {
            case LEX_ERROR_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_LEX_ERROR_CODE, tokenText);
                break;
            case INVALID_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_INVALID_CODE, tokenText);
                break;
            case EOF_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_EOF_CODE);
                break;
            case INVALID_TOKEN_CODE:
                result = new LocalizedProcessException( LPGMessages.LPG_INVALID_TOKEN_CODE, tokenText);
                break;
            default:
                result = new LocalizedProcessException( LPGMessages.LPG_INVALID_ERRORCODE, index, tokenText); 
        }
        return result;
    }

    private ProcessReport report = null;

    @Override
    public void reportError(int i, String code) {
        throw new AstException(LPGMessages.LPG_LEXBUG_WRONG_REPORTERR);
    }

    @Override
    public void reportError(int left_loc, int right_loc) {
        // calculate the error code for lexing (only 3 possibilities)
        int errorCode = (right_loc >= getStreamLength() ? EOF_CODE : left_loc == right_loc ? LEX_ERROR_CODE
            : INVALID_TOKEN_CODE),
        // define the end location
        end_loc = (left_loc == right_loc ? right_loc : right_loc - 1);

        // define the error message text
        String tokenText = (errorCode == EOF_CODE ? "" : errorCode == INVALID_TOKEN_CODE ? //$NON-NLS-1$
            new String(getInputChars(), left_loc, right_loc - left_loc) : String.valueOf(getCharValue(left_loc)));

        // formulate error
        LocalizedProcessException exception = getErrorException(errorCode, tokenText);
        // add an error to the report
        this.report.reportError(new ProcessErrorImpl(exception,
            getLineNumberOfCharAt(left_loc), getColumnOfCharAt(left_loc), getLineNumberOfCharAt(end_loc),
            getColumnOfCharAt(end_loc), left_loc, end_loc));
    }

    @Override
    public void reportError(int errorCode, String locationInfo, String tokenText) {
        throw new AstException(LPGMessages.LPG_LEXBUG_WRONG_REPORTERR);
    }
    
    @Override
    public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
        throw new AstException(LPGMessages.LPG_LEXBUG_WRONG_REPORTERR);
    } 
./
$End

$Export

	IDENTIFIER
	STRING_LITERAL
	INTEGER_LITERAL
	REAL_LITERAL

	GREATER
	LESS
	EQUAL
	GREATER_EQUAL
	LESS_EQUAL
	NOT_EQUAL

	LPAREN
	RPAREN
	LBRACE
	RBRACE
	LBRACKET
	RBRACKET

	COMMA
	COLON
	COLONCOLON
	DOT
	EXCLAMATION
	
	SHARP
	
$End

$Terminals
	CtlCharNotWS

	LF   CR   HT   FF

	a b c d e f g h i j k l m n o p q r s t u v w x y z
	_

	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

	0 1 2 3 4 5 6 7 8 9

	AfterASCIINotAcute
	Space        ::= ' '
	LF           ::= NewLine
	CR           ::= Return
	HT           ::= HorizontalTab
	FF           ::= FormFeed
	DoubleQuote  ::= '"'
	SingleQuote  ::= "'"
	Percent      ::= '%'
	VerticalBar  ::= '|'
	Exclamation  ::= '!'
	AtSign       ::= '@'
	BackQuote    ::= '`'
	Acute        ::= '�'
	Tilde        ::= '~'
	Sharp        ::= '#'
	DollarSign   ::= '$'
	Ampersand    ::= '&'
	Caret        ::= '^'
	Colon        ::= ':'
	SemiColon    ::= ';'
	BackSlash    ::= '\'
	LeftBrace    ::= '{'
	RightBrace   ::= '}'
	LeftBracket  ::= '['
	RightBracket ::= ']'
	QuestionMark ::= '?'
	Comma        ::= ','
	Dot          ::= '.'
	LessThan     ::= '<'
	GreaterThan  ::= '>'
	Plus         ::= '+'
	Minus        ::= '-'
	Slash        ::= '/'
	Star         ::= '*'
	LeftParen    ::= '('
	RightParen   ::= ')'
	Equal        ::= '='

$End

$Start
	Token
$End

$Rules

	---------------------  Rules for Scanned Tokens --------------------------------
	-- The lexer creates an array list of tokens which is defined in the PrsStream class.
	-- A token has three attributes: a start offset, an end offset and a kind.
	-- 
	-- Only rules that produce complete tokens have actions to create token objects.
	-- When making a token, calls to the methods, $getToken(1) and $getRightSpan(), 
	-- provide the offsets (i.e. the span) of a rule's right hand side (rhs) and thus of the token.
	-- For a rule of the form A ::= A1 A2 ... An, the start offset of the rhs of A is given by
	-- $getToken(1) or by $getLeftSpan() and the end offset by $getRightSpan().
	--  
	-- Regarding rules for parsing in general, note that for a rhs symbol Ai, the 
	-- method $getToken(i) returns the location of the leftmost character derived from Ai.  
	-- The method $getLeftSpan(i) returns the same location unless Ai produces $empty in which case
	-- it returns the location of the last character derived before reducing Ai to $empty. 
	-- The method $getRightSpan(i) returns the location of the rightmost character derived from Ai 
	-- unless Ai produces $empty in which case it returns the location of the last character 
	-- derived before reducing Ai to $empty.
	--------------------------------------------------------------------------------
	Token ::= Identifier
		/.$BeginAction
					checkForKeyWord();
		  $EndAction
		./

    -- Strings

	Token ::= String 
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

    -- Integers
 
	Token ::= IntegerLiteral
		/.$BeginAction
					makeToken($_INTEGER_LITERAL);
		  $EndAction
		./

	-- Reals

	Token ::= RealLiteral
		/.$BeginAction
					makeToken($_REAL_LITERAL);
		  $EndAction
		./

	-- Single-line comments

	Token ::= SLC
		/.$BeginAction
					skipToken();
		  $EndAction
		./

	-- Multiple-line comments

    Token ::= '/' '*' Inside Stars '/'
        /.$BeginAction
                    skipToken();
          $EndAction
        ./

	-- white space

	Token ::= WS -- White Space is scanned but not added to output vector
		/.$BeginAction
					skipToken();
		  $EndAction
		./

	Token ::= '('
		/.$BeginAction
					makeToken($_LPAREN);
		  $EndAction
		./

	Token ::= ')'
		/.$BeginAction
					makeToken($_RPAREN);
		  $EndAction
		./

	Token ::= '>'
		/.$BeginAction
					makeToken($_GREATER);
		  $EndAction
		./
		
	Token ::= '<'
		/.$BeginAction
					makeToken($_LESS);
		  $EndAction
		./

	Token ::= '='
		/.$BeginAction
					makeToken($_EQUAL);
		  $EndAction
		./

	Token ::= '>' '='
		/.$BeginAction
					makeToken($_GREATER_EQUAL);
		  $EndAction
		./

	Token ::= '<' '='
		/.$BeginAction
					makeToken($_LESS_EQUAL);
		  $EndAction
		./

	Token ::= '<' '>'
		/.$BeginAction
					makeToken($_NOT_EQUAL);
		  $EndAction
		./

	Token ::= '['
		/.$BeginAction
					makeToken($_LBRACKET);
		  $EndAction
		./

	Token ::= ']'
		/.$BeginAction
					makeToken($_RBRACKET);
		  $EndAction
		./

	Token ::= '{'
		/.$BeginAction
					makeToken($_LBRACE);
		  $EndAction
		./

	Token ::= '}'
		/.$BeginAction
					makeToken($_RBRACE);
		  $EndAction
		./

	Token ::= ','
		/.$BeginAction
					makeToken($_COMMA);
		  $EndAction
		./

	Token ::= ':'
		/.$BeginAction
					makeToken($_COLON);
		  $EndAction
		./

	Token ::= ':' ':'
		/.$BeginAction
					makeToken($_COLONCOLON);
		  $EndAction
		./

	Token ::= '.'
		/.$BeginAction
					makeToken($_DOT);
		  $EndAction
		./
		
	Token ::= '!'
		/.$BeginAction
					makeToken($_EXCLAMATION);
		  $EndAction
		./

	Token ::= '#'
		/.$BeginAction
					makeToken($_SHARP);
		  $EndAction
		./

	-- Base literal definitions
    IntegerLiteral -> Integer
                   | '-' Integer
                   --| LetterXx HexDigits     				

	RealLiteral -> Real
	             | '-' Real

    Real -> Decimal
          | Decimal Exponent
          | Integer Exponent

    Inside ::= Inside Stars NotSlashOrStar
             | Inside '/'
             | Inside NotSlashOrStar
             | $empty

    Stars -> '*'
           | Stars '*'

    SLC -> '-' '-'
         | SLC NotEol

    Integer -> Digit
             | Integer Digit

    HexDigits -> HexDigit
               | HexDigits HexDigit

    Decimal -> Integer '.' Integer

    Exponent -> LetterEe Integer
              | LetterEe '-' Integer
              | LetterEe '+' Integer

    WSChar -> Space
            | LF
            | CR
            | HT
            | FF

    Letter -> LowerCaseLetter
            | UpperCaseLetter
            | _
            | AfterASCIINotAcute

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m |
                       n | o | p | q | r | s | t | u | v | w | x | y | z

    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M |
                       N | O | P | Q | R | S | T | U | V | W | X | Y | Z

    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    OctalDigit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7

    a..fA..F -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit
              | a..fA..F

    LetterEe -> 'E'
              | 'e'

    LetterXx -> 'X'
              | 'x'

    WS -> WSChar
        | WS WSChar

	Identifier -> Ident
	            | QuotedName
	            | Percent Ident

    Ident -> Letter
           | Ident Letter
           | Ident Digit

    SpecialNotStar -> '+' | '-' | '/' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                      '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                      '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | '$'

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | '$' 

    SpecialNotDQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | "'" | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | '$'

    SpecialNotSQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | '"' | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | '$'

    NotSlashOrStar -> Letter
                    | Digit
                    | SpecialNotSlash
                    | WSChar

    NotEol -> Letter
            | Digit
            | Space
            | '*'
            | SpecialNotStar
            | HT
            | FF
            | CtlCharNotWS

    NotDQ -> Letter
           | Digit
           | SpecialNotDQ
           | Space
           | DQEscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigit

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | SQEscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit
           | '\' OctalDigit

	SQEscapeSequence ::= '\' "'"
					 | EscapeSequence
					 
	DQEscapeSequence ::= '\' '"'
					 | EscapeSequence

    EscapeSequence ::= '\' 'b'
                     | '\' 't'
                     | '\' 'n'
                     | '\' 'f'
                     | '\' 'r'
                     | '\' '\'

	SLNotDQ -> NotDQ
	         | SLNotDQ NotDQ

	SLNotSQ -> NotSQ
	         | SLNotSQ NotSQ

	SLNotSQOpt -> $empty
	            | SLNotSQ

	QuotedName -> '"' SLNotDQ '"'
	
	String -> "'" SLNotSQOpt "'"

$End
