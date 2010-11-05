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
-- * $Id: OCLKWLexer.gi,v 1.3 2010/01/22 18:37:44 asanchez Exp $
-- */
--
-- The Complete OCL KeyWord Lexer
--

%options slr
%options fp=OCLKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.ocl.parser
%options template=../lpg/KeywordTemplateF.gi
%options export_terminals=("OCLParsersym.java", "TK_")
%options include_directory="../lpg"

%Import
	EssentialOCLKWLexer.gi
%End

%Notice
	/./**
 * Complete OCL Keyword Lexer
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
 *   E.D.Willink - Bug 292112
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
$copyright_contributions
 * </copyright>
 */
	./
%End

%Export
	inv
	pre
	post
	context
	package
	endpackage
	def
	body
	derive
	init
	--
	-- the following were introduced in the OCL 2.1 RTF 09-05-02. 
	--
	static
	
	OclMessage
%End

%Rules

-- The Goal for the parser is a single Keyword

	KeyWord ::=
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

		| O c l M e s s a g e
		/.$BeginAction
			$setResult($_OclMessage);
		  $EndAction
		./

		| s t a t i c
		/.$BeginAction
			$setResult($_static);
		  $EndAction
		./
%End
