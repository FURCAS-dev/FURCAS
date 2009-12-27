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
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
-- *
-- * </copyright>
-- *
-- * $Id: EssentialOCLErrors.gi,v 1.2 2009/12/27 15:49:49 asanchez Exp $
-- */
--
-- Additional ERROR_TOKEN rules for The EssentialOCL Backtracking Parser
--

%Rules
	ERROR_Colon ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_COLON);
		  $EndCode
		./
	ERROR_Empty ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(1), OCLParserErrors.EXTRA_TOKENS);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Names
-----------------------------------------------------------------------
		
	ERROR_SimpleNameCS ::= ERROR_TOKEN
		/.$BeginCode
					int token = $getToken(1);
					reportErrorTokenMessage(token, OCLParserErrors.MISSING_SIMPLE_NAME);
                    IToken iToken = getIToken(token);
					SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							iToken
						);
					setOffsets(result, iToken);
					$setResult(result);
		  $EndCode
		./

	simpleNameCS -> ERROR_SimpleNameCS
--	simpleNameCS -> reservedKeyword ERROR_SimpleNameCS

-----------------------------------------------------------------------
--	Types
-----------------------------------------------------------------------		
	collectionTypeCS ::= CollectionTypeIdentifierCS '(' typeCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_RPAREN);
					CollectionTypeCS result = (CollectionTypeCS)dtParser.getSym(1); 
					result.setTypeCS((TypeCS)dtParser.getSym(3));
					setOffsets(result, result, getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Declarations
-----------------------------------------------------------------------
--	VariableDeclarationCS ::= notLiteralNorReservedSimpleNameCS ERROR_TOKEN
--		/.$BeginCode
--					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_VARIABLE_TYPE);
--					SimpleNameCS name = (SimpleNameCS)$getSym(1);
--					VariableCS result = createVariableCS(name, null, null);
--					setOffsets(result, name, getIToken($getToken(2)));
--					$setResult(result);
--		  $EndCode
--		./

--	variableDeclarationListCS ::= ERROR_TOKEN
--		/.$BeginCode
--					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_VARIABLES);
--					EList result = new BasicEList();
--					$setResult(result);
--		  $EndCode
--		./

-----------------------------------------------------------------------
--	Literals
-----------------------------------------------------------------------
	TupleLiteralExpCS ::= Tuple ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(7), OCLParserErrors.MISSING_LBRACE);
					TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)$getSym(3));
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

	TupleLiteralPartsCS ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_VARIABLES);
					EList<VariableCS> result = new BasicEList<VariableCS>();
					$setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Calls
-----------------------------------------------------------------------		
	AssociationClassCallExpCS ::= simpleNameCS '[' argumentsCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_RBRACK);
					VariableExpCS result = createVariableExpCS(
							(SimpleNameCS)$getSym(1),
							(EList<OCLExpressionCS>)$getSym(3),
							null
						);
					setOffsets(result, (CSTNode)$getSym(1), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Expressions
-----------------------------------------------------------------------
	IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(7), OCLParserErrors.MISSING_ENDIF);
					IfExpCS result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							(OCLExpressionCS)$getSym(6)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./
	IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(5), OCLParserErrors.MISSING_ELSE_ENDIF);
					IfExpCS result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							(OCLExpressionCS)$getSym(4),
							createInvalidLiteralExpCS(getTokenText($getToken(5)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	IfExpCS ::= if OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
					IfExpCS result = createIfExpCS(
							(OCLExpressionCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3))),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	IfExpCS ::= if ERROR_TOKEN endif
		/.$BeginCode
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_THEN_ELSE);
					IfExpCS result = createIfExpCS(
							createInvalidLiteralExpCS(getTokenText($getToken(2))),
							createInvalidLiteralExpCS(getTokenText($getToken(2))),
							createInvalidLiteralExpCS(getTokenText($getToken(2)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./

	primaryExpCS ::= '(' OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_RPAREN);
					OCLExpressionCS result = (OCLExpressionCS)$getSym(2);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
%End
