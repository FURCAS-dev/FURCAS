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
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
-- *        - 242153: LPG v 2.0.17 adoption.
-- *        - 299396: Introducing new LPG templates.
-- *        - 300534: Removing the use of deprecated macros.
-- *
-- * </copyright>
-- *
-- * $Id: EssentialOCLErrors.gi,v 1.5 2010/01/25 11:31:46 asanchez Exp $
-- */
--
-- Additional ERROR_TOKEN rules for The EssentialOCL Backtracking Parser
--

%Headers
	/.
	// Some methods for backwards compatibility
	
	/**
	 * Report error message for given error_token.
	 * 
	 * @param error_token
	 *            the error taken index
	 * @param msg
	 *            the message to report
	 * 
	 * @since 1.3
	 */
	protected final void reportErrorTokenMessage(int error_token, String msg) {
		getIPrsStream().reportErrorTokenMessage(error_token, msg); 
	}
	./
%End

%Rules
	ERROR_Colon ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_COLON);
		  $EndCode
		./
	ERROR_Empty ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.EXTRA_TOKENS);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Names
-----------------------------------------------------------------------
		
	ERROR_SimpleNameCS ::= ERROR_TOKEN
		/.$BeginCode					
					reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_SIMPLE_NAME);
                    IToken iToken = getRhsIToken(1);
					SimpleNameCS result = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							iToken
						);
					setOffsets(result, iToken);
					setResult(result);
		  $EndCode
		./

	simpleNameCS -> ERROR_SimpleNameCS
--	simpleNameCS -> reservedKeyword ERROR_SimpleNameCS

-----------------------------------------------------------------------
--	Types
-----------------------------------------------------------------------		
	collectionTypeCS ::= CollectionTypeIdentifierCS '(' typeCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RPAREN);
					CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1); 
					result.setTypeCS((TypeCS)getRhsSym(3));
					setOffsets(result, result, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Declarations
-----------------------------------------------------------------------
--	VariableDeclarationCS ::= notLiteralNorReservedSimpleNameCS ERROR_TOKEN
--		/.$BeginCode
--					reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_VARIABLE_TYPE);
--					SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
--					VariableCS result = createVariableCS(name, null, null);
--					setOffsets(result, name, getRhsIToken(2));
--					setResult(result);
--		  $EndCode
--		./

--	variableDeclarationListCS ::= ERROR_TOKEN
--		/.$BeginCode
--					reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_VARIABLES);
--					EList result = new BasicEList();
--					setResult(result);
--		  $EndCode
--		./

-----------------------------------------------------------------------
--	Literals
-----------------------------------------------------------------------
	TupleLiteralExpCS ::= Tuple ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(2), OCLParserErrors.MISSING_LBRACE);
					TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./

	TupleLiteralPartsCS ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(1), OCLParserErrors.MISSING_VARIABLES);
					EList<VariableCS> result = new BasicEList<VariableCS>();
					setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Calls
-----------------------------------------------------------------------		
	AssociationClassCallExpCS ::= simpleNameCS '[' argumentsCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(4), OCLParserErrors.MISSING_RBRACK);
					VariableExpCS result = createVariableExpCS(
							(SimpleNameCS)getRhsSym(1),
							(EList<OCLExpressionCS>)getRhsSym(3),
							null
						);
					setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--	Expressions
-----------------------------------------------------------------------
	IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(7), OCLParserErrors.MISSING_ENDIF);
					IfExpCS result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4),
							(OCLExpressionCS)getRhsSym(6)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(7));
					setResult(result);
		  $EndCode
		./
	IfExpCS ::= if OclExpressionCS then OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(5), OCLParserErrors.MISSING_ELSE_ENDIF);
					IfExpCS result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4),
							createInvalidLiteralExpCS(getRhsTokenText(5))
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					setResult(result);
		  $EndCode
		./
	IfExpCS ::= if OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_THEN_ELSE_ENDIF);
					IfExpCS result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							createInvalidLiteralExpCS(getRhsTokenText(3)),
							createInvalidLiteralExpCS(getRhsTokenText(3))
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	IfExpCS ::= if ERROR_TOKEN endif
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_THEN_ELSE);
					IfExpCS result = createIfExpCS(
							createInvalidLiteralExpCS(getRhsTokenText(2)),
							createInvalidLiteralExpCS(getRhsTokenText(2)),
							createInvalidLiteralExpCS(getRhsTokenText(2))
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./

	primaryExpCS ::= '(' OclExpressionCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage(getRhsTokenIndex(3), OCLParserErrors.MISSING_RPAREN);
					OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
%End
