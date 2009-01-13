--/**
-- * <copyright>
-- *
-- * Copyright (c) 2008, 2009 IBM Corporation and others.
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
-- * $Id: OCLBacktrackingKWLexer.g,v 1.1 2009/01/13 20:31:30 cdamus Exp $
-- */
--
-- The OCL Backtracking KeyWord Lexer, which is nominally identical to the
-- normal KeyWord Lexer, however the extra ERROR_TOKEN symbol makes it difficult
-- to share reliably.
--

%Options slr
%Options fp=OCLBacktrackingKWLexer,prefix=Char_
%options noserialize
%options package=org.eclipse.ocl.parser.backtracking
%options template=../../lpg/KeywordTemplateD.g
%options export_terminals=("OCLBacktrackingParsersym.java", "TK_")
%options include_directory="..;../../lpg"

$Include
	OCLKWLexer.g
$End
