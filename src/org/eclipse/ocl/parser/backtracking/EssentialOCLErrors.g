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
-- * $Id: EssentialOCLErrors.g,v 1.3 2009/10/10 07:10:37 ewillink Exp $
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
	ERROR_IsMarkedPreCS ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_AT_PRE);
					$setResult(null);
		  $EndJava
		./

	ERROR_PathNameCS ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_PATH_NAME);
					CSTNode result = createPathNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText($getToken(1))));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
		
	ERROR_SimpleNameCS ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_SIMPLE_NAME);
					SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	associationClassCallExpCS ::= notReservedSimpleNameCS '[' argumentsCS ERROR_TOKEN
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
	propertyCallExpCS ::= dotArrowExpCS '.' notReservedSimpleNameCS '[' argumentsCS ERROR_TOKEN
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createFeatureCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							(EList)$getSym(5),
							null
						);
					setOffsets(result, source, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
	propertyCallExpCS ::= dotArrowExpCS '.' ERROR_SimpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(7);
					CallExpCS result = createFeatureCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							(EList)$getSym(5),
							isMarkedPreCS
						);
					if (isMarkedPreCS != null) {
						setOffsets(result, source, isMarkedPreCS);
					} else {
						setOffsets(result, source, getIToken($getToken(6)));
					}
					$setResult(result);
		  $EndJava
		./
		
	collectionTypeCS ::= collectionTypeIdentifierCS '(' typeCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_RPAREN);
					CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
					result.setTypeCS((TypeCS)dtParser.getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

	enumLiteralExpCS ::= pathNameCS '::' ERROR_SimpleNameCS
		/.$BeginJava
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					CSTNode result = createEnumLiteralExpCS(
							pathNameCS,
							simpleNameCS
						);
					setOffsets(result, pathNameCS, simpleNameCS);
					$setResult(result);
		  $EndJava
		./
		
	operationCallExpCS_B ::= dotArrowExpCS '->' ERROR_SimpleNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createArrowOperationCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)null,
							(EList)$getSym(5)
						);
					setOffsets(result, source, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./	
		
	operationCallExpCS_CE ::= dotArrowExpCS '.' ERROR_SimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createDotOperationCallExpCS(
							source,
							null,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./
	operationCallExpCS_CE ::= dotArrowExpCS '.' operationOrNotReservedSimpleNameCS ERROR_IsMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createDotOperationCallExpCS(
							source,
							null,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./
		
	operationCallExpCS_DF ::= notReservedSimpleNameCS ERROR_IsMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					CSTNode result = createDotOperationCallExpCS(
							null,
							null,
							(SimpleNameCS)$getSym(1),
							(IsMarkedPreCS)$getSym(2),
							(EList)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndJava
		./

	operationCallExpCS_G ::=  pathNameCS '::' ERROR_SimpleNameCS '(' argumentsCSopt ')'
		/.$BeginJava
					OperationCallExpCS result = createDotOperationCallExpCS(
							null,
							(PathNameCS)$getSym(1),
							(SimpleNameCS)$getSym(3),
							null,
							(EList)$getSym(5)
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./
		
	operationCallExpCS_IJ ::= dotArrowExpCS '.' qualifiedPathNameCS ERROR_IsMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					PathNameCS pathName = (PathNameCS)$getSym(3);
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createDotOperationCallExpCS(
							source,
							pathName,
							removeLastSimpleNameCS(pathName),
							(IsMarkedPreCS)$getSym(4),
							(EList)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./		
	operationCallExpCS_IJ ::= dotArrowExpCS '.' pathNameCS '::' ERROR_SimpleNameCS isMarkedPreCSopt '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					CallExpCS result = createDotOperationCallExpCS(
							source,
							(PathNameCS)$getSym(3),
							(SimpleNameCS)$getSym(5),
							(IsMarkedPreCS)$getSym(6),
							(EList)$getSym(8)
						);
					setOffsets(result, source, getIToken($getToken(9)));
					$setResult(result);
		  $EndJava
		./	

	ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS ERROR_TOKEN
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
	ifExpCS ::= if oclExpressionCS then oclExpressionCS ERROR_TOKEN
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
	ifExpCS ::= if oclExpressionCS ERROR_TOKEN
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
	ifExpCS ::= if ERROR_TOKEN endif
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
		
	oclMessageExpCS ::= dotArrowExpCS '^' simpleNameCS ERROR_TOKEN
		/.$NewCase./
	oclMessageExpCS ::= dotArrowExpCS '^^' simpleNameCS ERROR_TOKEN
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
	oclMessageExpCS ::= dotArrowExpCS '^' ERROR_SimpleNameCS
		/.$NewCase./
	oclMessageExpCS ::= dotArrowExpCS '^^' ERROR_SimpleNameCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					OCLExpressionCS target = (OCLExpressionCS)$getSym(1);
					MessageExpCS result = createMessageExpCS(
							target,
							getIToken($getToken(2)).getKind() == $sym_type.TK_CARET,
							simpleNameCS,
							new BasicEList<OCLMessageArgCS>()
						);
					setOffsets(result, target, simpleNameCS);
					$setResult(result);
		  $EndJava
		./

	oclExpCS ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_EXPR);
					CSTNode result = createInvalidLiteralExpCS(getTokenText($getToken(1)));
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	oclExpCS ::= '(' oclExpressionCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_RPAREN);
					CSTNode result = (CSTNode)$getSym(2);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndJava
		./

	operationCS1 ::= notReservedSimpleNameCS '(' variableListCSopt ')' ERROR_Colon
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
	operationCS1 ::= notReservedSimpleNameCS '(' variableListCSopt ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_RPAREN);
					CSTNode result = createOperationCS(
							getTokenText($getToken(1)),
							(EList)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
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
	operationCS2 ::= qualifiedPathNameCS '(' variableListCSopt ')' ERROR_Colon
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
	operationCS2 ::= qualifiedPathNameCS '(' variableListCSopt ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(6), OCLParserErrors.MISSING_RPAREN);
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					CSTNode result = createOperationCS(
							pathNameCS,
							removeLastSimpleNameCS(pathNameCS),
							(EList)$getSym(3),
							null
						);
					setOffsets(result, pathNameCS, getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	operationCS2 ::= qualifiedPathNameCS ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_LPAREN);
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					CSTNode result = createOperationCS(
							pathNameCS,
							removeLastSimpleNameCS(pathNameCS),
							new BasicEList(),
							null
						);
					setOffsets(result, pathNameCS, getIToken($getToken(2)));
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

	parametersCS ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_PARAMETERS);
					EList result = new BasicEList();
					$setResult(result);
		  $EndJava
		./
	parametersCS ::= parametersCS ',' ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_PARAMETER);
		  $EndJava
		./

	pathNameCS -> ERROR_PathNameCS
		
	simpleNameCSopt -> ERROR_SimpleNameCS

	tupleLiteralExpCS ::= Tuple ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(7), OCLParserErrors.MISSING_LBRACE);
					CSTNode result = createTupleLiteralExpCS((EList)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./

--	variableCS ::= notLiteralNorReservedSimpleNameCS ERROR_TOKEN
--		/.$BeginJava
--					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_VARIABLE_TYPE);
--					SimpleNameCS name = (SimpleNameCS)$getSym(1);
--					CSTNode result = createVariableCS(name.getValue());
--					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
--					$setResult(result);
--		  $EndJava
--		./

	variableListCS ::= ERROR_TOKEN
		/.$NewCase./
	variableListCS2 ::= ERROR_TOKEN
		/.$BeginJava
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_VARIABLES);
					EList result = new BasicEList();
					$setResult(result);
		  $EndJava
		./

$End
