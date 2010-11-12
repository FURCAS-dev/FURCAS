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
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
-- *
-- * </copyright>
-- *
-- * $Id: OCLBacktrackingParser.g,v 1.5 2010/01/22 18:38:09 asanchez Exp $
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
%options fp=OCLBacktrackingParser,prefix=TK_
%options backtrack
%options noserialize
%options package=org.eclipse.ocl.parser.backtracking
%options import_terminals=OCLBacktrackingLexer.gi
%options ast_type=CSTNode
%options ParseTable=lpg.runtime.ParseTable
%options template=btParserTemplateF.gi
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
	$super_lexer_class /.OCLBacktrackingLexer./
%End
