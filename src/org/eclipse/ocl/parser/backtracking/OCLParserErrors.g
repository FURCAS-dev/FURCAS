--/**
-- * <copyright>
-- *
-- * Copyright (c) 2008 Eclipse.org and others.
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
-- * $Id: OCLParserErrors.g,v 1.4 2009/10/15 19:41:25 ewillink Exp $
-- */
--
-- Additional ERROR_TOKEN rules for The OCL Parser
--

$Include
	OCLParser.g
$End

$Include
	EssentialOCLErrors.g
$End

$Rules

-----------------------------------------------------------------------
--	Calls
-----------------------------------------------------------------------	
	OclMessageExpCS ::= primaryExpCS '^' simpleNameCS ERROR_TOKEN
		/.$NewCase./
	OclMessageExpCS ::= primaryExpCS '^^' simpleNameCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_MESSAGE_ARGUMENTS);
					OCLExpressionCS target = (OCLExpressionCS)$getSym(1);
					MessageExpCS result = createMessageExpCS(
							target,
							getIToken($getToken(2)).getKind() == $sym_type.TK_CARET,
							(SimpleNameCS)$getSym(3),
							new BasicEList<OCLMessageArgCS>()
						);
					setOffsets(result, target, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

-----------------------------------------------------------------------
--	Contexts
-----------------------------------------------------------------------
	classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_INV_OR_DEF);
					CSTNode result = createClassifierContextDeclCS(
							null,
							(PathNameCS)$getSym(2),
							new BasicEList<InvOrDefCS>()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
		
	defExpressionCS ::= typedVariableCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_EQUALS);
					VariableCS variableCS = (VariableCS)$getSym(1);
					CSTNode result = createDefExpressionCS(
							variableCS,
							null,
							null
						);
					setOffsets(result, variableCS, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	defExpressionCS ::= notReservedSimpleNameCS ERROR_Colon
		/.$BeginJava
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					VariableCS variableCS = createVariableCS(name, null, null);
					setOffsets(variableCS, name, getIToken($getToken(2)));
					CSTNode result = createDefExpressionCS(
							variableCS,
							null,
							null
						);
					setOffsets(result, variableCS, getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
		
	invOrDefCS ::= inv simpleNameCS ERROR_Colon
		/.$BeginJava
					CSTNode result = createInvCS(
							(SimpleNameCS)$getSym(2),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./	
	invOrDefCS ::= def simpleNameCS ERROR_Colon
		/.$BeginJava
					CSTNode result = createDefCS(
							(SimpleNameCS)$getSym(2),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	operationCS1 ::= notReservedSimpleNameCS '(' parametersCSopt ')' ERROR_Colon
		/.$BeginJava
					CSTNode result = createOperationCS(
							getTokenText($getToken(1)),
							(EList)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	operationCS1 ::= notReservedSimpleNameCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_LPAREN);
					CSTNode result = createOperationCS(
							getTokenText($getToken(1)),
							new BasicEList(),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	operationCS1 ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_IDENTIFIER);
					CSTNode result = createOperationCS(
							getTokenText($getToken(1)),
							new BasicEList(),
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	operationCS2 ::= qualifiedPathNameCS '(' parametersCSopt ')' ERROR_Colon
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					CSTNode result = createOperationCS(
							pathNameCS,
							removeLastSimpleNameCS(pathNameCS),
							(EList)$getSym(3),
							null
						);
					setOffsets(result, pathNameCS, getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	operationCS2 ::= pathNameCS '::' ERROR_SimpleNameCS
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createOperationCS(
							pathNameCS,
							simpleNameCS,
							new BasicEList(),
							null
						);
					setOffsets(result, pathNameCS, simpleNameCS);
					$setResult(result);
		  $EndJava
		./
		
	prePostOrBodyDeclCS ::= pre simpleNameCS ERROR_Colon
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.PRE_LITERAL,
							(SimpleNameCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCS ::= post simpleNameCS ERROR_Colon
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.POST_LITERAL,
							(SimpleNameCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCS ::= body simpleNameCS ERROR_Colon
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.BODY_LITERAL,
							(SimpleNameCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
		
	initOrDerValueCS ::= init ERROR_Colon
		/.$BeginJava
					CSTNode result = createInitValueCS(null);
					setOffsets(result, getIToken($getToken(2)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	initOrDerValueCS ::= derive ERROR_Colon
		/.$BeginJava
					CSTNode result = createDerValueCS(null);
					setOffsets(result, getIToken($getToken(2)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	packageDeclarationCS ::= package pathNameCS contextDeclsCSopt ERROR_Empty endpackage
		/.$BeginJava
					CSTNode result = createPackageDeclarationCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	packageDeclarationCS ::= package pathNameCS contextDeclsCSopt ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_ENDPACKAGE);
					CSTNode result = createPackageDeclarationCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
$End
