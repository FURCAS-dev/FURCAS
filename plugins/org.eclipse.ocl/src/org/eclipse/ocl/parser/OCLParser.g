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
-- * $Id: OCLParser.g,v 1.11 2009/12/27 15:49:46 asanchez Exp $
-- */
--
-- The Complete OCL Parser
--

%options escape=$
%options la=1
%options table=java
%options fp=OCLParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options package=org.eclipse.ocl.parser
%options import_terminals=OCLLexer.gi
%options ast_type=CSTNode
%options programming_language=java
%options action-block=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable
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
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
 * </copyright>
 */
	./
%End

%Define
    $environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./
	$lex_stream_class /.OCLLexer./
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

	unreservedSimpleNameCSopt ::= %empty
		/.$NullAction./
	unreservedSimpleNameCSopt -> unreservedSimpleNameCS	

-----------------------------------------------------------------------
--  Types
-----------------------------------------------------------------------
	primitiveTypeCS ::= OclMessage
		/.$BeginCode
					PrimitiveTypeCS result = createPrimitiveTypeCS(
							SimpleTypeEnum.OCL_MESSAGE_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./

	typeCSopt ::= %empty
		/.$NullAction./
	typeCSopt -> typeCS

-----------------------------------------------------------------------
--  Calls
-----------------------------------------------------------------------
	OperationCallExpCS ::= -- [B]
		primaryExpCS '->' simpleNameCS isMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					OperationCallExpCS result = createArrowOperationCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)$getSym(4),
							(EList<OCLExpressionCS>)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndCode
		./	

	AssociationClassCallExpCS ::= -- [B.1],PropertyCallExpCS[B]
		simpleNameCS isMarkedPreCS
		/.$BeginCode
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					VariableExpCS result = createVariableExpCS(
							simpleNameCS,
							new BasicEList<OCLExpressionCS>(),
							isMarkedPreCS
						);
					setOffsets(result, simpleNameCS, isMarkedPreCS);
					$setResult(result);
		  $EndCode
		./

	isMarkedPreCS ::= '@' pre
		/.$BeginCode
					IsMarkedPreCS result = createIsMarkedPreCS();
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndCode
		./
	isMarkedPreCSopt -> isMarkedPreCS

	OclMessageExpCS ::= primaryExpCS '^^' simpleNameCS '(' OclMessageArgumentsCSopt ')'
		/.$NewCase./
	OclMessageExpCS ::= primaryExpCS '^' simpleNameCS '(' OclMessageArgumentsCSopt ')'
		/.$BeginCode
					OCLExpressionCS target = (OCLExpressionCS)$getSym(1);
					MessageExpCS result = createMessageExpCS(
							target,
							getIToken($getToken(2)).getKind() == $sym_type.TK_CARET,
							(SimpleNameCS)$getSym(3),
							(EList<OCLMessageArgCS>)$getSym(5)
						);
					setOffsets(result, target, getIToken($getToken(6)));
					$setResult(result);
		  $EndCode
		./

	OclMessageArgumentsCSopt ::= %empty
        /.$BeginCode
                    $setResult(new BasicEList<OCLMessageArgCS>());
          $EndCode
        ./
	OclMessageArgumentsCSopt -> OclMessageArgumentsCS

	OclMessageArgumentsCS ::= OclMessageArgCS
		/.$BeginCode
					EList<OCLMessageArgCS> result = new BasicEList<OCLMessageArgCS>();
					result.add((OCLMessageArgCS)$getSym(1));
					$setResult(result);
		  $EndCode
		./
	OclMessageArgumentsCS ::= OclMessageArgumentsCS ',' OclMessageArgCS
		/.$BeginCode
					EList<OCLMessageArgCS> result = (EList<OCLMessageArgCS>)$getSym(1);
					result.add((OCLMessageArgCS)$getSym(3));
					$setResult(result);
		  $EndCode
		./

	OclMessageArgCS ::= '?'
		/.$BeginCode
					OCLMessageArgCS result = createOCLMessageArgCS(
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndCode
		./
	OclMessageArgCS ::= '?' ':' typeCS
		/.$BeginCode
					OCLMessageArgCS result = createOCLMessageArgCS(
							(TypeCS)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./
	OclMessageArgCS ::= OclExpressionCS
		/.$BeginCode
					OCLMessageArgCS result = createOCLMessageArgCS(
							null,
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndCode
		./

-----------------------------------------------------------------------
--  Expressions
-----------------------------------------------------------------------
	primaryNotNameCS -> OclMessageExpCS

-----------------------------------------------------------------------
--  Contexts
-----------------------------------------------------------------------
    packageDeclarationsCS -> packageDeclarationCS
    packageDeclarationsCS ::= packageDeclarationsCS packageDeclarationCS_A
        /.$BeginCode
                    PackageDeclarationCS result = (PackageDeclarationCS)$getSym(2);
                    result.setPackageDeclarationCS((PackageDeclarationCS) $getSym(1));
                    $setResult(result);
          $EndCode
        ./

    packageDeclarationCS -> packageDeclarationCS_A
    packageDeclarationCS -> packageDeclarationCS_B
    packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt endpackage
        /.$BeginCode
                    PackageDeclarationCS result = createPackageDeclarationCS(
                            (PathNameCS)$getSym(2),
                            (EList<ContextDeclCS>)$getSym(3)
                        );
                    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
                    $setResult(result);
          $EndCode
        ./
    
    packageDeclarationCS_B ::= contextDeclsCS
        /.$BeginCode
                    EList<ContextDeclCS> contextDecls = (EList<ContextDeclCS>)$getSym(1);
                    PackageDeclarationCS result = createPackageDeclarationCS(null, contextDecls);
                    if (!contextDecls.isEmpty()) {
                        setOffsets(result, contextDecls.get(0), contextDecls.get(contextDecls.size()-1));
                    }
                    $setResult(result);
          $EndCode
        ./

    contextDeclsCSopt ::= %empty
        /.$BeginCode
                    $setResult(new BasicEList<ContextDeclCS>());
          $EndCode
        ./
    contextDeclsCSopt -> contextDeclsCS

    contextDeclsCS ::= contextDeclCS
        /.$BeginCode
                    EList<ContextDeclCS> result = new BasicEList<ContextDeclCS>();
                    result.add((ContextDeclCS)$getSym(1));
                    $setResult(result);
          $EndCode
        ./
    contextDeclsCS ::= contextDeclsCS contextDeclCS
        /.$BeginCode
                    EList<ContextDeclCS> result = (EList<ContextDeclCS>)$getSym(1);
                    result.add((ContextDeclCS)$getSym(2));
                    $setResult(result);
          $EndCode
        ./

    contextDeclCS -> propertyContextDeclCS
    contextDeclCS -> classifierContextDeclCS
    contextDeclCS -> operationContextDeclCS

    propertyContextDeclCS ::= context pathNameCS '::' unreservedSimpleNameCS
        ':' typeCS initOrDerValuesCS
        /.$BeginCode
                    PathNameCS pathNameCS = (PathNameCS)$getSym(2);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(4);
                    EList<InitOrDerValueCS> list = (EList<InitOrDerValueCS>)$getSym(7);
                    PropertyContextCS result = createPropertyContextCS(
                            pathNameCS,
                            simpleNameCS,
                            (TypeCS)$getSym(6),
                            list
                        );
                    setOffsets(result, getIToken($getToken(1)), list.get(list.size()-1));
                    $setResult(result);
          $EndCode
        ./

    initOrDerValuesCS ::= initOrDerValueCS
        /.$BeginCode
                    EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
                    result.add((InitOrDerValueCS)$getSym(1));
                    $setResult(result);
          $EndCode
        ./
    initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS
        /.$BeginCode
                    EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)$getSym(1);
                    result.add((InitOrDerValueCS)$getSym(2));
                    $setResult(result);
          $EndCode
        ./

    initOrDerValueCS ::= init ':' OclExpressionCS
        /.$BeginCode
                    InitValueCS result = createInitValueCS((OCLExpressionCS)$getSym(3));
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
                    $setResult(result);
          $EndCode
        ./
    initOrDerValueCS ::= derive ':' OclExpressionCS
        /.$BeginCode
                    DerValueCS result = createDerValueCS((OCLExpressionCS)$getSym(3));
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
                    $setResult(result);
          $EndCode
        ./

	classifierContextDeclCS ::= context pathNameCS invOrDefsCS
		/.$BeginCode
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)$getSym(3);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							null,
							(PathNameCS)$getSym(2),
							list
						);
					setOffsets(result, getIToken($getToken(1)), list.get(list.size()-1));
					$setResult(result);
		  $EndCode
		./
	classifierContextDeclCS ::= context simpleNameCS ':' pathNameCS invOrDefsCS
		/.$BeginCode
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)$getSym(5);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							(SimpleNameCS)$getSym(2),
							(PathNameCS)$getSym(4),
							list
						);
					setOffsets(result, getIToken($getToken(1)), list.get(list.size()-1));
					$setResult(result);
		  $EndCode
		./

    invOrDefsCS ::= invOrDefCS
        /.$BeginCode
                    EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
                    result.add((InvOrDefCS)$getSym(1));
                    $setResult(result);
          $EndCode
        ./
    invOrDefsCS ::= invOrDefsCS invOrDefCS
        /.$BeginCode
                    EList<InvOrDefCS> result = (EList<InvOrDefCS>)$getSym(1);
                    result.add((InvOrDefCS)$getSym(2));
                    $setResult(result);
          $EndCode
        ./

	invOrDefCS ::= inv unreservedSimpleNameCSopt ':' OclExpressionCS
		/.$BeginCode
					InvCS result = createInvCS(
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndCode
		./	
    invOrDefCS ::= def unreservedSimpleNameCSopt ':' defExpressionCS
        /.$BeginCode
                    DefExpressionCS defExpressionCS = (DefExpressionCS)$getSym(4);
                    DefCS result = createDefCS(
                            false,
                            (SimpleNameCS)$getSym(2),
                            defExpressionCS
                        );
                    setOffsets(result, getIToken($getToken(1)), defExpressionCS);
                    $setResult(result);
          $EndCode
        ./
    invOrDefCS ::= static def unreservedSimpleNameCSopt ':' defExpressionCS
        /.$BeginCode
                    DefExpressionCS defExpressionCS = (DefExpressionCS)$getSym(5);
                    DefCS result = createDefCS(
                            true,
                            (SimpleNameCS)$getSym(3),
                            defExpressionCS
                        );
                    setOffsets(result, getIToken($getToken(1)), defExpressionCS);
                    $setResult(result);
          $EndCode
        ./

	defExpressionCS ::= typedUninitializedVariableCS '=' OclExpressionCS
		/.$BeginCode
					VariableCS variableCS = (VariableCS)$getSym(1);
					OCLExpressionCS expressionCS = (OCLExpressionCS)$getSym(3);
					DefExpressionCS result = createDefExpressionCS(
							variableCS,
							null,
							expressionCS
						);
					setOffsets(result, variableCS, expressionCS);
					$setResult(result);
		  $EndCode
		./
	defExpressionCS ::= operationCS1 '=' OclExpressionCS
		/.$BeginCode
					DefExpressionCS result = createDefExpressionCS(
							null,
							(OperationCS)$getSym(1),
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndCode
		./

	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS
		/.$BeginCode
					EList<PrePostOrBodyDeclCS> prePostOrBodyDecls = (EList<PrePostOrBodyDeclCS>)$getSym(3);
					OperationContextDeclCS result = createOperationContextDeclCS(
							(OperationCS)$getSym(2),
							prePostOrBodyDecls
						);
					setOffsets(result, getIToken($getToken(1)), prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
					$setResult(result);
		  $EndCode
		./

    prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
        /.$BeginCode
                    EList<PrePostOrBodyDeclCS> result = new BasicEList<PrePostOrBodyDeclCS>();
                    result.add((PrePostOrBodyDeclCS)$getSym(1));
                    $setResult(result);
          $EndCode
        ./
    prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS
        /.$BeginCode
                    EList<PrePostOrBodyDeclCS> result = (EList<PrePostOrBodyDeclCS>)$getSym(1);
                    result.add((PrePostOrBodyDeclCS)$getSym(2));
                    $setResult(result);
          $EndCode
        ./

    prePostOrBodyDeclCS ::= pre unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginCode
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.PRE_LITERAL,
                            (SimpleNameCS)$getSym(2),
                            (OCLExpressionCS)$getSym(4)
                        );
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
                    $setResult(result);
          $EndCode
        ./
    prePostOrBodyDeclCS ::= post unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginCode
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.POST_LITERAL,
                            (SimpleNameCS)$getSym(2),
                            (OCLExpressionCS)$getSym(4)
                        );
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
                    $setResult(result);
          $EndCode
        ./
    prePostOrBodyDeclCS ::= body unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginCode
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.BODY_LITERAL,
                            (SimpleNameCS)$getSym(2),
                            (OCLExpressionCS)$getSym(4)
                        );
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
                    $setResult(result);
          $EndCode
        ./

	operationCS1 ::= simpleNameCS '(' parametersCSopt ')' ':' typeCSopt
		/.$BeginCode
					OperationCS result = createOperationCS(
							getIToken($getToken(1)),
							(EList<VariableCS>)$getSym(3),
							(TypeCS)$getSym(6)
						);
					if ($getSym(6) != null) {
						setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(6));
					} else {
						setOffsets(result, getIToken($getToken(1)), getIToken($getToken(5)));
					}
					$setResult(result);
		  $EndCode
		./
	operationCS2 ::= pathNameCS '::' unreservedSimpleNameCS '(' parametersCSopt ')'
	   ':' typeCSopt
		/.$BeginCode
					PathNameCS pathNameCS = (PathNameCS)$getSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(3);
					TypeCS typeCS = (TypeCS)$getSym(8);
					OperationCS result = createOperationCS(
							pathNameCS,
							simpleNameCS,
							(EList<VariableCS>)$getSym(5),
							typeCS
						);
					if (typeCS != null) {
						setOffsets(result, pathNameCS, typeCS);
					} else {
						setOffsets(result, pathNameCS, getIToken($getToken(7)));
					}
					$setResult(result);
		  $EndCode
		./

    parametersCSopt ::= %empty
        /.$BeginCode
                    $setResult(new BasicEList<VariableCS>());
          $EndCode
        ./
    parametersCSopt -> parametersCS
	
	parametersCS ::= VariableDeclarationCS 
		/.$BeginCode
					EList<VariableCS> result = new BasicEList<VariableCS>();
					result.add((VariableCS)$getSym(1));
					$setResult(result);
		  $EndCode
		./
	parametersCS ::= parametersCS ',' VariableDeclarationCS
		/.$BeginCode
					EList<VariableCS> result = (EList<VariableCS>)$getSym(1);
					result.add((VariableCS)$getSym(3));
					$setResult(result);
		  $EndCode
		./
%End
