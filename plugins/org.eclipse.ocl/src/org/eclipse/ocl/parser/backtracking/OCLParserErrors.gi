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
-- *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
-- *
-- * </copyright>
-- *
-- * $Id: OCLParserErrors.gi,v 1.2 2009/12/27 15:49:47 asanchez Exp $
-- */
--
-- Additional ERROR_TOKEN rules for The OCL Parser
--

%Import
	OCLParser.g
%End

%Import
	EssentialOCLErrors.gi
%End

%Rules

-----------------------------------------------------------------------
--	Calls
-----------------------------------------------------------------------	
	OclMessageExpCS ::= primaryExpCS '^^' simpleNameCS ERROR_TOKEN
		/.$NewCase./
	OclMessageExpCS ::= primaryExpCS '^' simpleNameCS ERROR_TOKEN
		/.$BeginCode
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
		  $EndCode
		./

-----------------------------------------------------------------------
--	Contexts
-----------------------------------------------------------------------
	classifierContextDeclCS ::= context pathNameCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(3), OCLParserErrors.MISSING_INV_OR_DEF);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							null,
							(PathNameCS)$getSym(2),
							new BasicEList<InvOrDefCS>()
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
		
	defExpressionCS ::= typedUninitializedVariableCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_EQUALS);
					VariableCS variableCS = (VariableCS)$getSym(1);
					DefExpressionCS result = createDefExpressionCS(
							variableCS,
							null,
							null
						);
					setOffsets(result, variableCS, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	defExpressionCS ::= simpleNameCS ERROR_Colon
		/.$BeginCode
					SimpleNameCS name = (SimpleNameCS)$getSym(1);
					VariableCS variableCS = createVariableCS(name, null, null);
					setOffsets(variableCS, name, getIToken($getToken(2)));
					DefExpressionCS result = createDefExpressionCS(
							variableCS,
							null,
							null
						);
					setOffsets(result, variableCS, getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
		
	invOrDefCS ::= inv unreservedSimpleNameCS ERROR_Colon
		/.$BeginCode
					InvCS result = createInvCS(
							(SimpleNameCS)$getSym(2),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./	
    invOrDefCS ::= def unreservedSimpleNameCS ERROR_Colon
        /.$BeginCode
                    DefCS result = createDefCS(
                            false,
                            (SimpleNameCS)$getSym(2),
                            null
                        );
                    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
                    $setResult(result);
          $EndCode
        ./
    invOrDefCS ::= static def unreservedSimpleNameCS ERROR_Colon
        /.$BeginCode
                    DefCS result = createDefCS(
                            true,
                            (SimpleNameCS)$getSym(3),
                            null
                        );
                    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
                    $setResult(result);
          $EndCode
        ./

	operationCS1 ::= simpleNameCS '(' parametersCSopt ')' ERROR_Colon
		/.$BeginCode
					OperationCS result = createOperationCS(
							getIToken($getToken(1)),
							new BasicEList<VariableCS>(),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	operationCS1 ::= simpleNameCS ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(2), OCLParserErrors.MISSING_LPAREN);
					OperationCS result = createOperationCS(
							getIToken($getToken(1)),
							new BasicEList<VariableCS>(),
							null
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	operationCS1 ::= ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(1), OCLParserErrors.MISSING_IDENTIFIER);
					OperationCS result = createOperationCS(
							getIToken($getToken(1)),
							new BasicEList<VariableCS>(),
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	operationCS2 ::= pathNameCS '::' unreservedSimpleNameCS '(' parametersCSopt ')' ERROR_Colon
		/.$BeginCode
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					OperationCS result = createOperationCS(
							pathNameCS,
							simpleNameCS,
							(EList<VariableCS>)$getSym(5),
							null
						);
					setOffsets(result, pathNameCS, getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./
	operationCS2 ::= pathNameCS '::' ERROR_SimpleNameCS
		/.$BeginCode
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					OperationCS result = createOperationCS(
							pathNameCS,
							simpleNameCS,
							new BasicEList<VariableCS>(),
							null
						);
					setOffsets(result, pathNameCS, simpleNameCS);
					$setResult(result);
		  $EndCode
		./
		
	prePostOrBodyDeclCS ::= pre unreservedSimpleNameCS ERROR_Colon
		/.$BeginCode
					PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.PRE_LITERAL,
							(SimpleNameCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	prePostOrBodyDeclCS ::= post unreservedSimpleNameCS ERROR_Colon
		/.$BeginCode
					PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.POST_LITERAL,
							(SimpleNameCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	prePostOrBodyDeclCS ::= body unreservedSimpleNameCS ERROR_Colon
		/.$BeginCode
					PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.BODY_LITERAL,
							(SimpleNameCS)$getSym(2),
							createInvalidLiteralExpCS(getTokenText($getToken(3)))
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
		
	initOrDerValueCS ::= init ERROR_Colon
		/.$BeginCode
					InitValueCS result = createInitValueCS(null);
					setOffsets(result, getIToken($getToken(2)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./
	initOrDerValueCS ::= derive ERROR_Colon
		/.$BeginCode
					DerValueCS result = createDerValueCS(null);
					setOffsets(result, getIToken($getToken(2)), getIToken($getToken(3)));
					$setResult(result);
		  $EndCode
		./

	packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt ERROR_Empty endpackage
		/.$BeginCode
					PackageDeclarationCS result = createPackageDeclarationCS(
							(PathNameCS)$getSym(2),
							(EList<ContextDeclCS>)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					$setResult(result);
		  $EndCode
		./
	packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt ERROR_TOKEN
		/.$BeginCode
					reportErrorTokenMessage($getToken(4), OCLParserErrors.MISSING_ENDPACKAGE);
					PackageDeclarationCS result = createPackageDeclarationCS(
							(PathNameCS)$getSym(2),
							(EList<ContextDeclCS>)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndCode
		./
%End
