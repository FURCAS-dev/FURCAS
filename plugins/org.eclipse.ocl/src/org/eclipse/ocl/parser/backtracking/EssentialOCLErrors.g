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
-- *   E.D.Willink - Initial API and implementation
-- *
-- * </copyright>
-- *
-- * $Id: EssentialOCLErrors.g,v 1.4 2009/10/15 19:41:25 ewillink Exp $
-- */
--
-- Additional ERROR_TOKEN rules for The EssentialOCL Backtracking Parser
--

$Rules
	ERROR_Colon ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_COLON);
		  $EndJava
		./
	ERROR_Empty ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.EXTRA_TOKENS);
		  $EndJava
		./

-----------------------------------------------------------------------
--	Names
-----------------------------------------------------------------------
		
	ERROR_SimpleNameCS ::= ERROR_TOKEN
		/.$BeginJava
					int token = $getToken(1);
					String tokenText = getTokenText(token);
					reportErrorTokenMessage(token, OCLParserErrors.MISSING_SIMPLE_NAME);
					SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							tokenText
						);
					setOffsets(result, getIToken(token));
					$setResult(result);
		  $EndJava
		./

	simpleIdentifierCS -> ERROR_SimpleNameCS
--	simpleIdentifierCS -> reservedKeyword ERROR_SimpleNameCS

-----------------------------------------------------------------------
--	Types
-----------------------------------------------------------------------		
	collectionTypeCS ::= CollectionTypeIdentifierCS '(' typeCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_RPAREN);
					CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
					result.setTypeCS((TypeCS)dtParser.getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

-----------------------------------------------------------------------
--	Declarations
-----------------------------------------------------------------------
--	VariableDeclarationCS ::= notLiteralNorReservedSimpleNameCS ERROR_TOKEN
--		/.$BeginJava
--					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_VARIABLE_TYPE);
--					SimpleNameCS name = (SimpleNameCS)$getSym(1);
--					CSTNode result = createVariableCS(name, null, null);
--					setOffsets(result, name, getIToken($getToken(2)));
--					$setResult(result);
--		  $EndJava
--		./

--	variableDeclarationListCS ::= ERROR_TOKEN
--		/.$BeginJava
--					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_VARIABLES);
--					EList result = new BasicEList();
--					$setResult(result);
--		  $EndJava
--		./

-----------------------------------------------------------------------
--	Literals
-----------------------------------------------------------------------
	TupleLiteralExpCS ::= Tuple ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(7), OCLParserErrors.MISSING_LBRACE);
					CSTNode result = createTupleLiteralExpCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	TupleLiteralPartsCS ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_VARIABLES);
					EList result = new BasicEList();
					$setResult(result);
		  $EndJava
		./

-----------------------------------------------------------------------
--	Calls
-----------------------------------------------------------------------		
	AssociationClassCallExpCS ::= notReservedSimpleNameCS '[' argumentsCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_RBRACK);
					CSTNode result = createVariableExpCS(
							(SimpleNameCS)$getSym(1),
							(EList)$getSym(3),
							null
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	PropertyCallExpCS ::= primaryExpCS '.' pathNameCS '[' argumentsCS ERROR_TOKEN
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					PathNameCS pathNameCS = (PathNameCS)$getSym(3);
					SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
					CallExpCS result = createFeatureCallExpCS(
							source,
							pathNameCS,
							simpleNameCS,
							(EList)$getSym(5),
							null
						);
					setOffsets(result, source, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./

-----------------------------------------------------------------------
--	Expressions
-----------------------------------------------------------------------
	IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(7), OCLParserErrors.MISSING_ENDIF);
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./
	IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(5), OCLParserErrors.MISSING_ELSE_ENDIF);
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							createInvalidLiteralExpCS(getTokenText($getToken(5)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./
	IfExpCS ::= if OclExpressionCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3))),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
	IfExpCS ::= if ERROR_TOKEN endif
		/.$BeginJava
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_THEN_ELSE);
					CSTNode result = createIfExpCS(
							createInvalidLiteralExpCS(getTokenText($getToken(2))),
							createInvalidLiteralExpCS(getTokenText($getToken(2))),
							createInvalidLiteralExpCS(getTokenText($getToken(2)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	primaryExpCS ::= '(' OclExpressionCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_RPAREN);
					CSTNode result = (CSTNode)$getSym(2);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./
$End
