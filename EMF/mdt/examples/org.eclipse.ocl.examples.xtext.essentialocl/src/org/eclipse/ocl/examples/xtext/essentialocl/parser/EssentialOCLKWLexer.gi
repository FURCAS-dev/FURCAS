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
-- * $Id: EssentialOCLKWLexer.gi,v 1.2 2011/01/24 21:31:47 ewillink Exp $
-- */
--
-- The Essential OCL KeyWord Lexer
--

%options slr
%options fp=EssentialOCLKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.ocl.examples.xtext.essentialocl.parser
%options template=../lpg/KeywordTemplateF.gi
%options export_terminals=("EssentialOCLParsersym.java", "TK_")
%options include_directory="../lpg"

%Import
	KWLexerMapF.gi
%End

%Define

	--
	-- Definition of macros used in the template
	--
	$action_class /.$file_prefix./
	$eof_char /.Char_EOF./
	$copyright_contributions /.*./

%End

%Notice
	/./**
 * Essential OCL Keyword Lexer
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
 *   E.D.Willink - Bug 285633, 292112
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396) 
$copyright_contributions
 * </copyright>
 *
 *
 */
	./
%End

%Globals
	/../
%End

%Export
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

	null
	invalid

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

	String
	Integer
	UnlimitedNatural
	Real
	Boolean
	Tuple
	OclAny
	OclVoid
	OclInvalid
%End

%Start
	KeyWord
%End

%Rules

-- The Goal for the parser is a single Keyword

	KeyWord ::=
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
%End
