--/**
-- * <copyright>
-- *
-- * Copyright (c) 2005, 2009 IBM Corporation and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   See (or edit) Notice Declaration below
-- *   
-- * </copyright>
-- *
-- * $Id: OCLLexer.g,v 1.4 2009/10/02 20:55:33 ewillink Exp $
-- */
--
-- The OCL Lexer
--

%options escape=$
%options la=2
%options fp=OCLLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.ocl.parser
%options template=../lpg/LexerTemplateD.g
%options filter=OCLKWLexer.g
%options export_terminals=("OCLParsersym.java", "TK_")
%options include_directory="../lpg"

$Define

	--
	-- Definition of macros used in the template
	--
	$action_class /.$file_prefix./
	$eof_token /.$_EOF_TOKEN./
    $environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./
    $adapt_environment /.OCLUtil.getAdapter(environment, BasicEnvironment.class)./
    $environment_import /.org.eclipse.ocl.Environment./
 
	--
	-- Definition of macro used in the included file LexerBasicMap.g
	--
	$kw_lexer_class /.OCLKWLexer./
	$copyright_contributions /.*./

$End

$Notice
	/./**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
 *   Borland - Bug 242880
 $copyright_contributions
 * </copyright>
 *
 * $Id: OCLLexer.g,v 1.4 2009/10/02 20:55:33 ewillink Exp $
 */
	./
$End

$Include
	LexerBasicMap.g
$End

$Globals
    /.import $environment_import;
    import org.eclipse.ocl.lpg.BasicEnvironment;
    import org.eclipse.ocl.util.OCLUtil;
    ./
$End

$Export

	IDENTIFIER
	STRING_LITERAL
	INTEGER_LITERAL
	REAL_LITERAL
	NUMERIC_OPERATION
	INTEGER_RANGE_START
	
	PLUS
	MINUS
	MULTIPLY
	DIVIDE

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

	ARROW
	BAR
	COMMA
	COLON
	COLONCOLON
	SEMICOLON
	DOT
	DOTDOT
	ATPRE
	
	CARET
	CARETCARET
	QUESTIONMARK
	
	SINGLE_LINE_COMMENT
	MULTI_LINE_COMMENT

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
	Acute        ::= '´'
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

	-- an empty String literal looks just like an escaped single-quote
	Token ::= EscapedSQ
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

	Token ::= SingleQuote SLNotSQ SingleQuote
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

	Token ::= Acute SLNotSQOpt Acute
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

	Token ::= BackQuote SLNotSQOpt Acute
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

	Token ::= IntegerLiteral
		/.$BeginAction
					makeToken($_INTEGER_LITERAL);
		  $EndAction
		./

	Token ::= RealLiteral
		/.$BeginAction
					makeToken($_REAL_LITERAL);
		  $EndAction
		./

	Token ::= NumericOperation
		/.$BeginAction
					makeToken($_NUMERIC_OPERATION);
		  $EndAction
		./

	Token ::= IntegerRangeStart
		/.$BeginAction
					makeToken($_INTEGER_RANGE_START);
		  $EndAction
		./

	Token ::= SLC
		/.$BeginAction
					makeComment($_SINGLE_LINE_COMMENT);
		  $EndAction
		./

    Token ::= '/' '*' Inside Stars '/'
        /.$BeginAction
                    makeComment($_MULTI_LINE_COMMENT);
          $EndAction
        ./

	Token ::= WS -- White Space is scanned but not added to output vector
		/.$BeginAction
					skipToken();
		  $EndAction
		./

	Token ::= '+'
		/.$BeginAction
					makeToken($_PLUS);
		  $EndAction
		./

	Token ::= '-'
		/.$BeginAction
					makeToken($_MINUS);
		  $EndAction
		./

	Token ::= '*'
		/.$BeginAction
					makeToken($_MULTIPLY);
		  $EndAction
		./

	Token ::= '/'
		/.$BeginAction
					makeToken($_DIVIDE);
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

	Token ::= '-' '>'
		/.$BeginAction
					makeToken($_ARROW);
		  $EndAction
		./

	Token ::= '|'
		/.$BeginAction
					makeToken($_BAR);
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

	Token ::= ';'
		/.$BeginAction
					makeToken($_SEMICOLON);
		  $EndAction
		./

	Token ::= '.'
		/.$BeginAction
					makeToken($_DOT);
		  $EndAction
		./

	Token ::= '.' '.'
		/.$BeginAction
					makeToken($_DOTDOT);
		  $EndAction
		./

	Token ::= '@' p r e
		/.$BeginAction
					makeToken($_ATPRE);
		  $EndAction
		./


	Token ::= '^'
		/.$BeginAction
					makeToken($_CARET);
		  $EndAction
		./

	Token ::= '^' '^'
		/.$BeginAction
					makeToken($_CARETCARET);
		  $EndAction
		./
		
	Token ::= '?'
		/.$BeginAction
					makeToken($_QUESTIONMARK);
		  $EndAction
		./


    IntegerLiteral -> Integer
    --                | '0' LetterXx HexDigits

    RealLiteral -> Decimal
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

    OctalDigits3 -> OctalDigit
                  | OctalDigit OctalDigit
                  | OctalDigit OctalDigit OctalDigit

    LetterEe -> 'E'
              | 'e'

    LetterXx -> 'X'
              | 'x'

    WS -> WSChar
        | WS WSChar

    Identifier -> Letter
                | Identifier Letter
                | Identifier Digit
                | Identifier DollarSign
                | QuotedName

    SpecialNotStar -> '+' | '-' | '/' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                      '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                      '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    SpecialNotSQNotDQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                         '%' | '&' | '^' | ':' | ';' | '|' | '{' | '}' |
                         '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    
    SpecialNotDQ -> SpecialNotSQNotDQ | "'"
    SpecialNotSQ -> SpecialNotSQNotDQ | '"'

    EscapedSymbols -> NotSQNotDQ | '"' | "'" | '\'
    BackslashEscapedSymbol -> '\' EscapedSymbols

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

    NotSQNotDQ -> Letter
           | Digit
           | SpecialNotSQNotDQ
           | Space

    NotDQ -> Letter
           | Digit
           | SpecialNotDQ
           | Space
           | EscapedDQ
           --| '\' u HexDigit HexDigit HexDigit HexDigit
           --| '\' OctalDigit

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | EscapedSQ
           | BackslashEscapedSymbol
           --| '\' u HexDigit HexDigit HexDigit HexDigit
           --| '\' OctalDigit

	EscapedSQ -> SingleQuote SingleQuote

	-- maintain this for compatibility with the "...\"..." escapes in an
	-- escape mechanism (double-quotes) that isn't compliant, anyway
	EscapedDQ -> '\' DoubleQuote

	SLNotDQ -> NotDQ
	         | SLNotDQ NotDQ

	SLNotSQ -> NotSQ
	         | SLNotSQ NotSQ

	SLNotSQOpt -> $empty
	            | SLNotSQ

	QuotedName -> '"' SLNotDQ '"'

	NumericOperation -> Integer '.' Identifier
	NumericOperation -> Integer '.' '+'
	NumericOperation -> Integer '.' '-'
	NumericOperation -> Integer '.' '*'
	NumericOperation -> Integer '.' '/'
	NumericOperation -> Integer '.' '<'
	NumericOperation -> Integer '.' '<' '='
	NumericOperation -> Integer '.' '>' '='
	NumericOperation -> Integer '.' '>'

	IntegerRangeStart -> Integer '.' '.'

$End
