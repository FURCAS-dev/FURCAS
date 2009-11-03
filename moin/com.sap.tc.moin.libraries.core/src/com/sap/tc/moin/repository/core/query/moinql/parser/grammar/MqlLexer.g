%options escape=$
%options slr
%options fp=MqlLexerGen,prefix=Char_
%options single-productions
%options noserialize
%options package=com.sap.tc.moin.repository.core.query.moinql.parser.gen
%options template=LexerTemplateD.g
%options filter=MqlKeywordLexer.g
%options export_terminals=("MqlParserSymbols.java", "TK_")

$Import
	MoinLexerTemplate.g
$End

$Define
	$kw_lexer_class /.$MqlKeywordLexer./
$End

$Notice
	/./**
	   * This file is generated for MOIN-MQL with LPG. 
       */
	./
$End


$Headers
	/.
		/* MQL-specific constructor */
		public MqlLexerGen(char[] chars, String resourceName, ProcessReport _report, int tabLength) {
			this(chars, resourceName, tabLength);
			report = _report;
			kwLexer = new MqlKeywordLexer(getInputChars(), TK_IDENTIFIER);
		}
	    
	./
$End
