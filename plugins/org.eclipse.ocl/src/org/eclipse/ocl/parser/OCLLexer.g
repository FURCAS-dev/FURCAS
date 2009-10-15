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
-- * $Id: OCLLexer.g,v 1.6 2009/10/15 19:43:12 ewillink Exp $
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
%options template=../lpg/LexerTemplateD.g
%options filter=OCLKWLexer.g
%options export_terminals=("OCLParsersym.java", "TK_")
%options include_directory="../lpg"

$Define

	--
	-- Definition of macros used in the template
	--
	$action_class /.$file_prefix./
	$eof_token /.$_EOF_TOKEN./
    $environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./
    $adapt_environment /.OCLUtil.getAdapter(environment, BasicEnvironment.class)./
    $environment_import /.org.eclipse.ocl.Environment./
 
	--
	-- Definition of macro used in the included file LexerBasicMap.g
	--
	$kw_lexer_class /.OCLKWLexer./
	$copyright_contributions /.*./

$End
$Include
	EssentialOCLLexer.g
$End

$Notice
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
 *   E.D.Willink - Bug 292112
 * </copyright>
 */
	./
$End

$Export
	ATPRE
	
	CARET
	CARETCARET
	QUESTIONMARK
$End

$Rules
	Token ::= '@' p r e
		/.$BeginAction
					makeToken($_ATPRE);
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
$End
