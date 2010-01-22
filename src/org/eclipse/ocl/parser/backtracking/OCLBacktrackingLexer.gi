--/**
-- * <copyright>
-- *
-- * Copyright (c) 2008, 2009 Eclipse.org and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   IBM - Initial API and implementation
-- *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
-- *
-- * </copyright>
-- *
-- * $Id: OCLBacktrackingLexer.gi,v 1.3 2010/01/22 18:38:05 asanchez Exp $
-- */
--
-- The OCL Backtracking Lexer, which is nominally identical to the
-- normal Lexer, however the extra ERROR_TOKEN symbol makes it difficult
-- to share reliably.
--

%options escape=$
%options la=2
%options fp=OCLBacktrackingLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.ocl.parser.backtracking
%options template=../../lpg/LexerTemplateF.gi
%options filter=OCLBacktrackingKWLexer.gi
%options export_terminals=("OCLBacktrackingParsersym.java", "TK_")
%options include_directory="..;../../lpg"

%Import
	OCLLexer.gi
%End

%Define
	$kw_lexer_class /.OCLBacktrackingKWLexer./
%End
