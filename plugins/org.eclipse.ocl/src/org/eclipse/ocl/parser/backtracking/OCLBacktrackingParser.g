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
-- *   E.D. Willink - Initial API and implementation
-- *
-- * </copyright>
-- *
-- * $Id: OCLBacktrackingParser.g,v 1.4 2010/01/04 23:22:46 asanchez Exp $
-- */
--
-- The OCL Backtracking Parser
--
-- This alternate top level grammar demonstrates how to reconfigure the
-- default deterministic parser to give backtracking behaviour. The backtracking
-- parser is at least ten times slower, but is able to repair multiple syntax
-- errors making it useful for interactive usage such as within an editor.
--

%options escape=$
%options la=1
%options table=java
%options fp=OCLBacktrackingParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options backtrack
%options noserialize
%options package=org.eclipse.ocl.parser.backtracking
%options import_terminals=OCLBacktrackingLexer.gi
%options ast_type=CSTNode
%options programming_language=java
%options action-block=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable
%options include_directory=".;..;../../lpg"

%Import
	OCLParserErrors.gi
%End

%Globals
	/.
		import org.eclipse.ocl.parser.AbstractOCLParser;
	./
%End

%Define
	$lex_stream_class /.OCLBacktrackingLexer./
	$prs_parser_class /.BacktrackingParser./
	$prs_parser_exception /.NotBacktrackParseTableException./
	$prs_parser_throw /.throw new RuntimeException("****Error: Regenerate $prs_type.java with -BACKTRACK option")./
	$prs_fuzzy_parse_call/.fuzzyParse./
	$prs_parse_args /.error_repair_count./
%End
