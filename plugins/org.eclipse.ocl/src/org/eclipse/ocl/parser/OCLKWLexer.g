--/**
-- * <copyright>
-- *
-- * Copyright (c) 2005, 2007 IBM Corporation and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   IBM - Initial API and implementation
-- *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
-- *
-- * </copyright>
-- *
-- * $Id: OCLKWLexer.g,v 1.2 2009/09/01 20:11:22 ewillink Exp $
-- */
--
-- The OCL KeyWord Lexer
--

%Options slr
%Options fp=OCLKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.ocl.parser
%options template=../lpg/KeywordTemplateD.g
%options export_terminals=("OCLParsersym.java", "TK_")
%options include_directory="../lpg"

$Define

	--
	-- Definition of macros used in the template
	--
	$action_class /.$file_prefix./
	$eof_char /.Char_EOF./
	$copyright_contributions /.*./

$End

$Notice
	/./**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
$copyright_contributions
 * </copyright>
 *
 * $Id: OCLKWLexer.g,v 1.2 2009/09/01 20:11:22 ewillink Exp $
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
	self
	inv
	pre
	post
	context
	package
	endpackage
	def
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

	--
	-- the following appear to have been omitted from the list of
	-- OCL reserved words in Section 7.4.9.  They will be treated 
	-- as unreserved for compliance
	--
	body
	derive
	init
	null
	invalid
--  return  -- don't need a keyword for LPG purposes
	
	--
	-- the following are not used in the OCL concrete syntax, but
	-- are defined as reserved words in the Spec 7.4.9
	--
	attr
	oper

	--
	-- the remainder of the LPG keywords are defined as such for the
	-- purpose of constructing the CST grammar.  They are not OCL
	-- reserved words
	--		
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

	closure

	oclIsKindOf
	oclIsTypeOf
	oclAsType
	oclIsNew
	oclIsUndefined
	oclIsInvalid
	oclIsInState
	allInstances

	String
	Integer
	UnlimitedNatural
	Real
	Boolean
	Tuple
	OclAny
	OclVoid
	OclInvalid
	OclMessage
$End

$Terminals
	DollarSign
	a b c d e f g h i j k l m n o p q r s t u v w x y z
	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
$End

$Eof
	EOF
$End

$Start
	KeyWord
$End

$Rules

-- The Goal for the parser is a single Keyword

	KeyWord ::=
		s e l f
		/.$BeginAction
			$setResult($_self);
		  $EndAction
		./

		| i n v
		/.$BeginAction
			$setResult($_inv);
		  $EndAction
		./

		| p r e
		/.$BeginAction
			$setResult($_pre);
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

		| c l o s u r e
		/.$BeginAction
			$setResult($_closure);
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
		
		| o c l I s N e w
		/.$BeginAction
			$setResult($_oclIsNew);
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
		
		| o c l I s I n S t a t e
		/.$BeginAction
			$setResult($_oclIsInState);
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
		
		| U n l i m i t e d N a t u r a l
		/.$BeginAction
			$setResult($_UnlimitedNatural);
		  $EndAction
		./
		
		| R e a l
		/.$BeginAction
			$setResult($_Real);
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

		| O c l M e s s a g e
		/.$BeginAction
			$setResult($_OclMessage);
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

		| a t t r
		/.$BeginAction
			$setResult($_attr);
		  $EndAction
		./

		| o p e r
		/.$BeginAction
			$setResult($_oper);
		  $EndAction
		./
$End
