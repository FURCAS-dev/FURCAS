%options escape=$
%options slr
%options fp=OclLexerGen,prefix=Char_
%options single-productions
%options noserialize
%options package=com.sap.tc.moin.ocl.parser.gen
%options template=LexerTemplateD.g
%options filter=OclKeywordLexer.g
%options export_terminals=("OclParserSymbols.java", "TK_")

$Import
	OclLexerBase.g
$End

$Export
	ATPRE
	SEMICOLON
$End

$Define
	$kw_lexer_class /.$OclKeywordLexer./
$End

$Notice
	/./**
	   * This file is generated for MOIN-OCL with LPG. 
       */
	./
$End

$Headers
	/.		
		/* OCL-specific constructor */
		public OclLexerGen(char[] chars, String resourceName, ProcessReport _report, int tabLength) {
			this(chars, resourceName, tabLength);
			report = _report;
			kwLexer = new OclKeywordLexer(getInputChars(), TK_IDENTIFIER);
		}
	    
	./
$End

$Rules
	Token ::= ';'
		/.$BeginAction
					makeToken($_SEMICOLON);
		  $EndAction
		./
		| '@' p r e
		/.$BeginAction
					makeToken($_ATPRE);
		  $EndAction
		./
$End