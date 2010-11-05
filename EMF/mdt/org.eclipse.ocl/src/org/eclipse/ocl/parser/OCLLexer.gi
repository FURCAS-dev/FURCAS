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
-- * $Id: OCLLexer.gi,v 1.3 2010/01/22 18:37:51 asanchez Exp $
-- */
--
-- The Complete OCL Lexer
--

%options escape=$
%options la=2
%options fp=OCLLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.ocl.parser
%options template=../lpg/LexerTemplateF.gi
%options filter=OCLKWLexer.gi
%options export_terminals=("OCLParsersym.java", "TK_")
%options include_directory="../lpg"

%Import
	EssentialOCLLexer.gi
%End

%Define

	--
	-- Definition of macro used in the included file LexerBasicMap.g
	-- We redefine that one defined by EssentialOCLLexer
	--
	$kw_lexer_class /.OCLKWLexer./

%End

%Notice
	/./**
 * Complete OCL Lexer
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
 *   E.D.Willink - Bug 292112, 292594
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
 $copyright_contributions
 * </copyright>
 */
	./
%End

%Export
	AT
	CARET
	CARETCARET
	QUESTIONMARK
%End

%Rules
	Token ::= '@'
		/.$BeginAction
					makeToken($_AT);
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
%End
