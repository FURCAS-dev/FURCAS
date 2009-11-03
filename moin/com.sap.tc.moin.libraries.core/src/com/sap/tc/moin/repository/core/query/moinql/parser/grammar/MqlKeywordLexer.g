%Options slr
%Options fp=MqlKeywordLexer,prefix=Char_
%options noserialize
%options package=com.sap.tc.moin.repository.core.query.moinql.parser.gen
%options template=KeywordTemplateD.g
%options export_terminals=("MqlParserSymbols.java", "TK_")

$Notice
	/.
	/**
	  * This file is generated for MOIN-MQL with LPG. 
      */
	./
$End

$Globals
	/../
$End

$Include
	KWLexerMap.g
$End

$Export
	select
	from
	type
	where
	as
	withoutsubtypes
	not
	in
	partitions
	containers
	elements
	for
	or
	and
	like
	true
	false
	null
$End

$Terminals
	DollarSign
	a b c d e f g h i j k l m n o p q r s t u v w x y z
	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
$End

$Start
	MqlKeyWord
$End

$Rules
	MqlKeyWord ::= 	
		s e l e c t
		/.$BeginAction
			$setResult($_select);
		  $EndAction
		./

		| t y p e
		/.$BeginAction
			$setResult($_type);
		  $EndAction
		./
		
		| n o t
		/.$BeginAction
			$setResult($_not);
		  $EndAction
		./
		
		| i n
		/.$BeginAction
			$setResult($_in);
		  $EndAction
		./
	
		| o r
		/.$BeginAction
			$setResult($_or);
		  $EndAction
		./
		
		| a n d
		/.$BeginAction
			$setResult($_and);
		  $EndAction
		./
		
		| n u l l
		/.$BeginAction
			$setResult($_null);
		  $EndAction
		./
		
		| t r u e
		/.$BeginAction
			$setResult($_true);
		  $EndAction
		./
		
		| f a l s e
		/.$BeginAction
			$setResult($_false);
		  $EndAction
		./
		
		| f r o m
		/.$BeginAction
			$setResult($_from);
		  $EndAction
		./

		| w h e r e
		/.$BeginAction
			$setResult($_where);
		  $EndAction
		./

		| a s
		/.$BeginAction
			$setResult($_as);
		  $EndAction
		./
		
		| w i t h o u t s u b t y p e s
		/.$BeginAction
			$setResult($_withoutsubtypes);
		  $EndAction
		./
	
		
		| p a r t i t i o n s
		/.$BeginAction
			$setResult($_partitions);
		  $EndAction
		./
		
		| c o n t a i n e r s
		/.$BeginAction
			$setResult($_containers);
		  $EndAction
		./
		
		| e l e m e n t s
		/.$BeginAction
			$setResult($_elements);
		  $EndAction
		./
		
		| f o r
		/.$BeginAction
			$setResult($_for);
		  $EndAction
		./
		
		| l i k e
		/.$BeginAction
			$setResult($_like);
		  $EndAction
		./

$End
