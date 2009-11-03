%options escape=$
%options la=1
%options fp=OclLexerGen,prefix=Char_
%options single-productions
%options noserialize
%options package=com.sap.tc.moin.ocl.parser.gen
%options template=LexerTemplateD.g
%options filter=OclKeywordLexer.g
%options export_terminals=("OclParserSymbols.java", "TK_")

$Import
	MoinLexerTemplate.g
	$DropSymbols
	EXCLAMATION
$End

$Export
	PLUS
	MINUS
	MULTIPLY
	DIVIDE

	ARROW
	DOTDOT
	BAR
	
	INTEGER_RANGE_START
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

	Token ::= '-' '>'
		/.$BeginAction
					makeToken($_ARROW);
		  $EndAction
		./

	Token ::= '.' '.'
		/.$BeginAction
					makeToken($_DOTDOT);
		  $EndAction
		./
		
	Token ::= Integer '.' '.'
		/.$BeginAction
					makeToken($_INTEGER_RANGE_START);
		  $EndAction
		./
	Token ::= '|'
		/.$BeginAction
					makeToken($_BAR);
		  $EndAction
		./

$End
