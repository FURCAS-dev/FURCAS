%Options slr
%Options fp=OclKeywordLexer,prefix=Char_
%options noserialize
%options package=com.sap.tc.moin.ocl.parser.gen
%options template=KeywordTemplateD.g
%options export_terminals=("OclParserSymbols.java", "TK_")

$Include
	KWLexerMap.g
$End

$Export
	self
	if
	then
	else
	endif
	and
	or
	xor
	not
	implies
	let
	in
	true
	false

	Set
	Bag
	Sequence
	Collection
	OrderedSet

	iterate
	forAll
	exists
	isUnique
	any
	one

	collect
	select
	reject
	collectNested
	sortedBy

	oclIsKindOf
	oclIsTypeOf
	oclAsType
	oclIsUndefined
	oclIsInvalid
	allInstances

	String
	Integer
	Real
	Float
	Double
	Boolean
	Tuple
	OclAny
	OclVoid
	OclInvalid
	
	null
	invalid
$End

$Terminals
	DollarSign
	a b c d e f g h i j k l m n o p q r s t u v w x y z
	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
$End

$Rules
	OclKeyWord ::=
		s e l f
		/.$BeginAction
			$setResult($_self);
		  $EndAction
		./
		
		| i f
		/.$BeginAction
			$setResult($_if);
		  $EndAction
		./
		
		| t h e n
		/.$BeginAction
			$setResult($_then);
		  $EndAction
		./
		
		| e l s e
		/.$BeginAction
			$setResult($_else);
		  $EndAction
		./
		
		| e n d i f
		/.$BeginAction
			$setResult($_endif);
		  $EndAction
		./
		
		| a n d
		/.$BeginAction
			$setResult($_and);
		  $EndAction
		./
		
		| o r
		/.$BeginAction
			$setResult($_or);
		  $EndAction
		./
		
		| x o r
		/.$BeginAction
			$setResult($_xor);
		  $EndAction
		./
		
		| n o t
		/.$BeginAction
			$setResult($_not);
		  $EndAction
		./
		
		| i m p l i e s
		/.$BeginAction
			$setResult($_implies);
		  $EndAction
		./
		
		| l e t
		/.$BeginAction
			$setResult($_let);
		  $EndAction
		./
		
		| i n
		/.$BeginAction
			$setResult($_in);
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
		
		| S e t
		/.$BeginAction
			$setResult($_Set);
		  $EndAction
		./
		
		| B a g
		/.$BeginAction
			$setResult($_Bag);
		  $EndAction
		./
		
		| S e q u e n c e
		/.$BeginAction
			$setResult($_Sequence);
		  $EndAction
		./
		
		| C o l l e c t i o n
		/.$BeginAction
			$setResult($_Collection);
		  $EndAction
		./

		| O r d e r e d S e t
		/.$BeginAction
			$setResult($_OrderedSet);
		  $EndAction
		./

		| i t e r a t e
		/.$BeginAction
			$setResult($_iterate);
		  $EndAction
		./
		
		| f o r A l l
		/.$BeginAction
			$setResult($_forAll);
		  $EndAction
		./
		
		| e x i s t s
		/.$BeginAction
			$setResult($_exists);
		  $EndAction
		./
		
		| i s U n i q u e
		/.$BeginAction
			$setResult($_isUnique);
		  $EndAction
		./
		
		| a n y
		/.$BeginAction
			$setResult($_any);
		  $EndAction
		./
		
		| o n e
		/.$BeginAction
			$setResult($_one);
		  $EndAction
		./

		| c o l l e c t
		/.$BeginAction
			$setResult($_collect);
		  $EndAction
		./
		
		| s e l e c t
		/.$BeginAction
			$setResult($_select);
		  $EndAction
		./
		
		| r e j e c t
		/.$BeginAction
			$setResult($_reject);
		  $EndAction
		./
		
		| c o l l e c t N e s t e d
		/.$BeginAction
			$setResult($_collectNested);
		  $EndAction
		./
		
		| s o r t e d B y
		/.$BeginAction
			$setResult($_sortedBy);
		  $EndAction
		./
		
		| o c l I s K i n d O f
		/.$BeginAction
			$setResult($_oclIsKindOf);
		  $EndAction
		./

		| o c l I s T y p e O f
		/.$BeginAction
			$setResult($_oclIsTypeOf);
		  $EndAction
		./
		
		| o c l A s T y p e
		/.$BeginAction
			$setResult($_oclAsType);
		  $EndAction
		./
		
		| o c l I s U n d e f i n e d
		/.$BeginAction
			$setResult($_oclIsUndefined);
		  $EndAction
		./
		
		| o c l I s I n v a l i d
		/.$BeginAction
			$setResult($_oclIsInvalid);
		  $EndAction
		./

		| a l l I n s t a n c e s
		/.$BeginAction
			$setResult($_allInstances);
		  $EndAction
		./

		| S t r i n g
		/.$BeginAction
			$setResult($_String);
		  $EndAction
		./

		| I n t e g e r
		/.$BeginAction
			$setResult($_Integer);
		  $EndAction
		./
		
		| R e a l
		/.$BeginAction
			$setResult($_Real);
		  $EndAction
		./
		
		| F l o a t
		/.$BeginAction
			$setResult($_Float);
		  $EndAction
		./
		
		| D o a b l e 
		/.$BeginAction
			$setResult($_Double);
		  $EndAction
		./
		
		| B o o l e a n
		/.$BeginAction
			$setResult($_Boolean);
		  $EndAction
		./

		| T u p l e
		/.$BeginAction
			$setResult($_Tuple);
		  $EndAction
		./

		| O c l A n y
		/.$BeginAction
			$setResult($_OclAny);
		  $EndAction
		./

		| O c l V o i d
		/.$BeginAction
			$setResult($_OclVoid);
		  $EndAction
		./

		| O c l I n v a l i d
		/.$BeginAction
			$setResult($_OclInvalid);
		  $EndAction
		./

		| n u l l
		/.$BeginAction
			$setResult($_null);
		  $EndAction
		./

		| i n v a l i d
		/.$BeginAction
			$setResult($_invalid);
		  $EndAction
		./
$End
