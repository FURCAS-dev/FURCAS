-- ******************************************************************************
-- Copyright (c) 2006, 2009 SAP AG and others.
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--     SAP AG - initial API and implementation
-- *******************************************************************************
%options escape=$
%options slr
%options fp=MqlLexerGen,prefix=Char_
%options single-productions
%options noserialize
%options package=org.eclipse.emf.query2.internal.moinql.parser.gen
%options template=LexerTemplateD.g
%options filter=MqlKeywordLexer.g
%options export_terminals=("MqlParserSymbols.java", "TK_")

$Import
	MoinLexerTemplate.g
$End

$Define
	$kw_lexer_class /.$MqlKeywordLexer./
$End

$Notice
	/./**
	   * This file is generated for MOIN-MQL with LPG. 
       */
	./
$End


$Headers
	/.
		/* MQL-specific constructor */
		public MqlLexerGen(char[] chars, String resourceName, ProcessReport _report, int tabLength) {
			this(chars, resourceName, tabLength);
			report = _report;
			kwLexer = new MqlKeywordLexer(getInputChars(), TK_IDENTIFIER);
		}
	    
	./
$End
