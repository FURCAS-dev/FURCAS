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
-- * $Id: OCLParser.g,v 1.2 2011/01/24 21:31:48 ewillink Exp $
-- */
--
-- The Complete OCL Parser
--

%options escape=$
%options la=1
%options fp=OCLParser,prefix=TK_
%options noserialize
%options package=org.eclipse.ocl.examples.xtext.essentialocl.parser
%options import_terminals=OCLLexer.gi
%options ast_type=CSTNode
%options template=dtParserTemplateF.gi
%options include_directory=".;../lpg"

%Start
	goal
%End

%Import
	EssentialOCL.gi
%End

%Notice
	/./**
 * Complete OCL Grammar
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
 *   E.D.Willink - Bug 259818, 285633, 292112
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
 *        - 242153: LPG v 2.0.17 adoption.
 *        - 299396: Introducing new LPG templates
 *        - 300534: Removing the use of deprecated macros.
 * </copyright>
 */
	./
%End

%Define
    $environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./
	$super_lexer_class /.OCLLexer./
%End

%Globals
	/.
	import org.eclipse.ocl.Environment;
	import org.eclipse.ocl.cst.ClassifierContextDeclCS;
	import org.eclipse.ocl.cst.ContextDeclCS;
	import org.eclipse.ocl.cst.DefCS;
	import org.eclipse.ocl.cst.DefExpressionCS;
	import org.eclipse.ocl.cst.DerValueCS;
	import org.eclipse.ocl.cst.InitValueCS;
	import org.eclipse.ocl.cst.InitOrDerValueCS;
	import org.eclipse.ocl.cst.InvCS;
	import org.eclipse.ocl.cst.InvOrDefCS;
	import org.eclipse.ocl.cst.MessageExpCS;
	import org.eclipse.ocl.cst.OCLMessageArgCS;
	import org.eclipse.ocl.cst.OperationCS;
	import org.eclipse.ocl.cst.OperationContextDeclCS;
	import org.eclipse.ocl.cst.PackageDeclarationCS;
	import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
	import org.eclipse.ocl.cst.PrePostOrBodyEnum;
	import org.eclipse.ocl.cst.PropertyContextCS;
	./
%End

%KeyWords
-- Reserved keywords
	body context def derive endpackage init inv package post pre static

-- Restricted keywords
	OclMessage
%End

%Terminals
	AT           ::= '@'
	CARET        ::= '^'
	CARETCARET   ::= '^^'
	QUESTIONMARK ::= '?'
%End

%Rules
	goal -> packageDeclarationsCS
	goal -> invOrDefCS
	goal -> prePostOrBodyDeclCS
	goal -> initOrDerValueCS
	goal -> VariableDeclarationCS
	goal -> %empty	
-----------------------------------------------------------------------
--  Names
-----------------------------------------------------------------------
	reservedKeyword -> body
	reservedKeyword -> context
	reservedKeyword -> def
	reservedKeyword -> derive
	reservedKeyword -> endpackage
	reservedKeyword -> init
	reservedKeyword -> inv
	reservedKeyword -> package
	reservedKeyword -> post
	reservedKeyword -> pre
	reservedKeyword -> static

	InfixOperator -> '^'
	InfixOperator -> '^^'

	unreservedSimpleNameCSopt ::= %empty
	unreservedSimpleNameCSopt -> unreservedSimpleNameCS	

-----------------------------------------------------------------------
--  Types
-----------------------------------------------------------------------
	PrimitiveTypeIdentifier ::= OclMessage

	TypeExpCSopt ::= %empty
	TypeExpCSopt -> TypeExpCS

-----------------------------------------------------------------------
--  Calls
-----------------------------------------------------------------------
	NavigatingExpCSbase ::= IndexExpCS '@' 'pre'

	TypedExpressionCS ::= '?'
	TypedExpressionCS ::= '?' ':' TypeExpCS
	
	UntypedExpressionCS ::= '?'
	UntypedExpressionCS ::= '?' ':' TypeExpCS

-----------------------------------------------------------------------
--  Contexts
-----------------------------------------------------------------------
    packageDeclarationsCS -> packageDeclarationCS
    packageDeclarationsCS ::= packageDeclarationsCS packageDeclarationCS_A

    packageDeclarationCS -> packageDeclarationCS_A
    packageDeclarationCS -> packageDeclarationCS_B
    packageDeclarationCS_A ::= package NameExpCS contextDeclsCSopt endpackage
    
    packageDeclarationCS_B ::= contextDeclsCS

    contextDeclsCSopt ::= %empty
    contextDeclsCSopt -> contextDeclsCS

    contextDeclsCS ::= contextDeclCS
    contextDeclsCS ::= contextDeclsCS contextDeclCS

    contextDeclCS -> propertyContextDeclCS
    contextDeclCS -> classifierContextDeclCS
    contextDeclCS -> operationContextDeclCS

    propertyContextDeclCS ::= context NameExpCS '::' unreservedSimpleNameCS
        ':' TypeExpCS initOrDerValuesCS

    initOrDerValuesCS ::= initOrDerValueCS
    initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS

    initOrDerValueCS ::= init ':' OclExpressionCS
    initOrDerValueCS ::= derive ':' OclExpressionCS

	classifierContextDeclCS ::= context NameExpCS invOrDefsCS
	classifierContextDeclCS ::= context SimpleName ':' NameExpCS invOrDefsCS

    invOrDefsCS ::= invOrDefCS
    invOrDefsCS ::= invOrDefsCS invOrDefCS

	invOrDefCS ::= inv unreservedSimpleNameCSopt ':' OclExpressionCS
    invOrDefCS ::= def unreservedSimpleNameCSopt ':' defExpressionCS
    invOrDefCS ::= static def unreservedSimpleNameCSopt ':' defExpressionCS

	defExpressionCS ::= SimpleName ':' TypeExpCS '=' OclExpressionCS
	defExpressionCS ::= operationCS1 '=' OclExpressionCS

	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS

    prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
    prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS

    prePostOrBodyDeclCS ::= pre unreservedSimpleNameCSopt ':' OclExpressionCS
    prePostOrBodyDeclCS ::= post unreservedSimpleNameCSopt ':' OclExpressionCS
    prePostOrBodyDeclCS ::= body unreservedSimpleNameCSopt ':' OclExpressionCS

	operationCS1 ::= SimpleName '(' parametersCSopt ')' ':' TypeExpCSopt
	operationCS2 ::= NameExpCS '::' unreservedSimpleNameCS '(' parametersCSopt ')' ':' TypeExpCSopt

    parametersCSopt ::= %empty
    parametersCSopt -> parametersCS
	
	parametersCS ::= VariableDeclarationCS 
	parametersCS ::= parametersCS ',' VariableDeclarationCS
%End
