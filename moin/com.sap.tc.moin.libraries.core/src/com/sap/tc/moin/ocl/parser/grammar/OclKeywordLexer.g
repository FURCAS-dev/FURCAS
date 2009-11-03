%Options slr
%Options fp=OclKeywordLexer,prefix=Char_
%options noserialize
%options package=com.sap.tc.moin.ocl.parser.gen
%options template=KeywordTemplateD.g
%options export_terminals=("OclParserSymbols.java", "TK_")

$Import
	OclKeywordLexerBase.g
$End

$Notice
	/.
	/**
	  * This file is generated for MOIN-OCL with LPG. 
      */
	./
$End

$Export
	inv
	pre
	exp
	post
	body
	context
	package
	endpackage
	def
	derive
	init
--	oclIsNew
$End

$Start
	OclKeyWord
$End

$Rules
	OclKeyWord ::=
	     i n v
		/.$BeginAction
			$setResult($_inv);
		  $EndAction
		./

		| p r e
		/.$BeginAction
			$setResult($_pre);
		  $EndAction
		./
		
		| e x p
		/.$BeginAction
			$setResult($_exp);
		  $EndAction
		./

		| p o s t
		/.$BeginAction
			$setResult($_post);
		  $EndAction
		./
		
		| b o d y
		/.$BeginAction
			$setResult($_body);
		  $EndAction
		./
		
		| c o n t e x t
		/.$BeginAction
			$setResult($_context);
		  $EndAction
		./
		
		| p a c k a g e
		/.$BeginAction
			$setResult($_package);
		  $EndAction
		./
		
		| e n d p a c k a g e
		/.$BeginAction
			$setResult($_endpackage);
		  $EndAction
		./
		
		| d e f
		/.$BeginAction
			$setResult($_def);
		  $EndAction
		./
		
		| d e r i v e
		/.$BeginAction
			$setResult($_derive);
		  $EndAction
		./
		
		| i n i t
		/.$BeginAction
			$setResult($_init);
		  $EndAction
		./
	
--		| o c l I s N e w
--		/.$BeginAction
--			$setResult($_oclIsNew);
--		  $EndAction
--		./
$End
