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
-- * $Id: OCLParser.g,v 1.10 2009/12/18 06:26:04 ewillink Exp $
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
%options import_terminals=OCLLexer.g
%options ast_type=CSTNode
%options programming_language=java
%options action=("*.java", "/.", "./")
%options ParseTable=lpg.lpgjavaruntime.ParseTable
%options include_directory=".;../lpg"

$Start
	goal
$End

$Include
	EssentialOCL.g
$End

$Notice
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
 * </copyright>
 */
	./
$End

$Define
    $environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./
	$lex_stream_class /.OCLLexer./
$End

$Globals
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
$End

$KeyWords
-- Reserved keywords
	body context def derive endpackage init inv package post pre static

-- Restricted keywords
	OclMessage
$End

$Terminals
	AT           ::= '@'
	CARET        ::= '^'
	CARETCARET   ::= '^^'
	QUESTIONMARK ::= '?'
$End

$Rules
	goal -> packageDeclarationsCS
	goal -> invOrDefCS
	goal -> prePostOrBodyDeclCS
	goal -> initOrDerValueCS
	goal -> VariableDeclarationCS
	goal -> $empty	
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

	unreservedSimpleNameCSopt ::= $empty
		/.$NullAction./
	unreservedSimpleNameCSopt -> unreservedSimpleNameCS	

-----------------------------------------------------------------------
--  Types
-----------------------------------------------------------------------
	primitiveTypeCS ::= OclMessage
		/.$BeginJava
					PrimitiveTypeCS result = createPrimitiveTypeCS(
							SimpleTypeEnum.OCL_MESSAGE_LITERAL,
							getTokenText($getToken(1))
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./

	typeCSopt ::= $empty
		/.$NullAction./
	typeCSopt -> typeCS

-----------------------------------------------------------------------
--  Calls
-----------------------------------------------------------------------
	OperationCallExpCS ::= -- [B]
		primaryExpCS '->' simpleNameCS isMarkedPreCS '(' argumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS source = (OCLExpressionCS)$getSym(1);
					OperationCallExpCS result = createArrowOperationCallExpCS(
							source,
							(SimpleNameCS)$getSym(3),
							(IsMarkedPreCS)$getSym(4),
							(EList<OCLExpressionCS>)$getSym(6)
						);
					setOffsets(result, source, getIToken($getToken(7)));
					$setResult(result);
		  $EndJava
		./	

	AssociationClassCallExpCS ::= -- [B.1],PropertyCallExpCS[B]
		simpleNameCS isMarkedPreCS
		/.$BeginJava
					SimpleNameCS simpleNameCS = (SimpleNameCS)$getSym(1);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)$getSym(2);
					VariableExpCS result = createVariableExpCS(
							simpleNameCS,
							new BasicEList<OCLExpressionCS>(),
							isMarkedPreCS
						);
					setOffsets(result, simpleNameCS, isMarkedPreCS);
					$setResult(result);
		  $EndJava
		./

	isMarkedPreCS ::= '@' pre
		/.$BeginJava
					IsMarkedPreCS result = createIsMarkedPreCS();
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(2)));
					$setResult(result);
		  $EndJava
		./
	isMarkedPreCSopt -> isMarkedPreCS

	OclMessageExpCS ::= primaryExpCS '^^' simpleNameCS '(' OclMessageArgumentsCSopt ')'
		/.$NewCase./
	OclMessageExpCS ::= primaryExpCS '^' simpleNameCS '(' OclMessageArgumentsCSopt ')'
		/.$BeginJava
					OCLExpressionCS target = (OCLExpressionCS)$getSym(1);
					MessageExpCS result = createMessageExpCS(
							target,
							getIToken($getToken(2)).getKind() == $sym_type.TK_CARET,
							(SimpleNameCS)$getSym(3),
							(EList<OCLMessageArgCS>)$getSym(5)
						);
					setOffsets(result, target, getIToken($getToken(6)));
					$setResult(result);
		  $EndJava
		./

	OclMessageArgumentsCSopt ::= $empty
        /.$BeginJava
                    $setResult(new BasicEList<OCLMessageArgCS>());
          $EndJava
        ./
	OclMessageArgumentsCSopt -> OclMessageArgumentsCS

	OclMessageArgumentsCS ::= OclMessageArgCS
		/.$BeginJava
					EList<OCLMessageArgCS> result = new BasicEList<OCLMessageArgCS>();
					result.add((OCLMessageArgCS)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	OclMessageArgumentsCS ::= OclMessageArgumentsCS ',' OclMessageArgCS
		/.$BeginJava
					EList<OCLMessageArgCS> result = (EList<OCLMessageArgCS>)$getSym(1);
					result.add((OCLMessageArgCS)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	OclMessageArgCS ::= '?'
		/.$BeginJava
					OCLMessageArgCS result = createOCLMessageArgCS(
							null,
							null
						);
					setOffsets(result, getIToken($getToken(1)));
					$setResult(result);
		  $EndJava
		./
	OclMessageArgCS ::= '?' ':' typeCS
		/.$BeginJava
					OCLMessageArgCS result = createOCLMessageArgCS(
							(TypeCS)$getSym(3),
							null
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./
	OclMessageArgCS ::= OclExpressionCS
		/.$BeginJava
					OCLMessageArgCS result = createOCLMessageArgCS(
							null,
							(OCLExpressionCS)$getSym(1)
						);
					setOffsets(result, (CSTNode)$getSym(1));
					$setResult(result);
		  $EndJava
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
        /.$BeginJava
                    PackageDeclarationCS result = (PackageDeclarationCS)$getSym(2);
                    result.setPackageDeclarationCS((PackageDeclarationCS) $getSym(1));
                    $setResult(result);
          $EndJava
        ./

    packageDeclarationCS -> packageDeclarationCS_A
    packageDeclarationCS -> packageDeclarationCS_B
    packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt endpackage
        /.$BeginJava
                    PackageDeclarationCS result = createPackageDeclarationCS(
                            (PathNameCS)$getSym(2),
                            (EList<ContextDeclCS>)$getSym(3)
                        );
                    setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
                    $setResult(result);
          $EndJava
        ./
    
    packageDeclarationCS_B ::= contextDeclsCS
        /.$BeginJava
                    EList<ContextDeclCS> contextDecls = (EList<ContextDeclCS>)$getSym(1);
                    PackageDeclarationCS result = createPackageDeclarationCS(null, contextDecls);
                    if (!contextDecls.isEmpty()) {
                        setOffsets(result, contextDecls.get(0), contextDecls.get(contextDecls.size()-1));
                    }
                    $setResult(result);
          $EndJava
        ./

    contextDeclsCSopt ::= $empty
        /.$BeginJava
                    $setResult(new BasicEList<ContextDeclCS>());
          $EndJava
        ./
    contextDeclsCSopt -> contextDeclsCS

    contextDeclsCS ::= contextDeclCS
        /.$BeginJava
                    EList<ContextDeclCS> result = new BasicEList<ContextDeclCS>();
                    result.add((ContextDeclCS)$getSym(1));
                    $setResult(result);
          $EndJava
        ./
    contextDeclsCS ::= contextDeclsCS contextDeclCS
        /.$BeginJava
                    EList<ContextDeclCS> result = (EList<ContextDeclCS>)$getSym(1);
                    result.add((ContextDeclCS)$getSym(2));
                    $setResult(result);
          $EndJava
        ./

    contextDeclCS -> propertyContextDeclCS
    contextDeclCS -> classifierContextDeclCS
    contextDeclCS -> operationContextDeclCS

    propertyContextDeclCS ::= context pathNameCS '::' unreservedSimpleNameCS
        ':' typeCS initOrDerValuesCS
        /.$BeginJava
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
          $EndJava
        ./

    initOrDerValuesCS ::= initOrDerValueCS
        /.$BeginJava
                    EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
                    result.add((InitOrDerValueCS)$getSym(1));
                    $setResult(result);
          $EndJava
        ./
    initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS
        /.$BeginJava
                    EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)$getSym(1);
                    result.add((InitOrDerValueCS)$getSym(2));
                    $setResult(result);
          $EndJava
        ./

    initOrDerValueCS ::= init ':' OclExpressionCS
        /.$BeginJava
                    InitValueCS result = createInitValueCS((OCLExpressionCS)$getSym(3));
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
                    $setResult(result);
          $EndJava
        ./
    initOrDerValueCS ::= derive ':' OclExpressionCS
        /.$BeginJava
                    DerValueCS result = createDerValueCS((OCLExpressionCS)$getSym(3));
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(3));
                    $setResult(result);
          $EndJava
        ./

	classifierContextDeclCS ::= context pathNameCS invOrDefsCS
		/.$BeginJava
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)$getSym(3);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							null,
							(PathNameCS)$getSym(2),
							list
						);
					setOffsets(result, getIToken($getToken(1)), list.get(list.size()-1));
					$setResult(result);
		  $EndJava
		./
	classifierContextDeclCS ::= context simpleNameCS ':' pathNameCS invOrDefsCS
		/.$BeginJava
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)$getSym(5);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							(SimpleNameCS)$getSym(2),
							(PathNameCS)$getSym(4),
							list
						);
					setOffsets(result, getIToken($getToken(1)), list.get(list.size()-1));
					$setResult(result);
		  $EndJava
		./

    invOrDefsCS ::= invOrDefCS
        /.$BeginJava
                    EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
                    result.add((InvOrDefCS)$getSym(1));
                    $setResult(result);
          $EndJava
        ./
    invOrDefsCS ::= invOrDefsCS invOrDefCS
        /.$BeginJava
                    EList<InvOrDefCS> result = (EList<InvOrDefCS>)$getSym(1);
                    result.add((InvOrDefCS)$getSym(2));
                    $setResult(result);
          $EndJava
        ./

	invOrDefCS ::= inv unreservedSimpleNameCSopt ':' OclExpressionCS
		/.$BeginJava
					InvCS result = createInvCS(
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./	
    invOrDefCS ::= def unreservedSimpleNameCSopt ':' defExpressionCS
        /.$BeginJava
                    DefExpressionCS defExpressionCS = (DefExpressionCS)$getSym(4);
                    DefCS result = createDefCS(
                            false,
                            (SimpleNameCS)$getSym(2),
                            defExpressionCS
                        );
                    setOffsets(result, getIToken($getToken(1)), defExpressionCS);
                    $setResult(result);
          $EndJava
        ./
    invOrDefCS ::= static def unreservedSimpleNameCSopt ':' defExpressionCS
        /.$BeginJava
                    DefExpressionCS defExpressionCS = (DefExpressionCS)$getSym(5);
                    DefCS result = createDefCS(
                            true,
                            (SimpleNameCS)$getSym(3),
                            defExpressionCS
                        );
                    setOffsets(result, getIToken($getToken(1)), defExpressionCS);
                    $setResult(result);
          $EndJava
        ./

	defExpressionCS ::= typedUninitializedVariableCS '=' OclExpressionCS
		/.$BeginJava
					VariableCS variableCS = (VariableCS)$getSym(1);
					OCLExpressionCS expressionCS = (OCLExpressionCS)$getSym(3);
					DefExpressionCS result = createDefExpressionCS(
							variableCS,
							null,
							expressionCS
						);
					setOffsets(result, variableCS, expressionCS);
					$setResult(result);
		  $EndJava
		./
	defExpressionCS ::= operationCS1 '=' OclExpressionCS
		/.$BeginJava
					DefExpressionCS result = createDefExpressionCS(
							null,
							(OperationCS)$getSym(1),
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS
		/.$BeginJava
					EList<PrePostOrBodyDeclCS> prePostOrBodyDecls = (EList<PrePostOrBodyDeclCS>)$getSym(3);
					OperationContextDeclCS result = createOperationContextDeclCS(
							(OperationCS)$getSym(2),
							prePostOrBodyDecls
						);
					setOffsets(result, getIToken($getToken(1)), prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
					$setResult(result);
		  $EndJava
		./

    prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
        /.$BeginJava
                    EList<PrePostOrBodyDeclCS> result = new BasicEList<PrePostOrBodyDeclCS>();
                    result.add((PrePostOrBodyDeclCS)$getSym(1));
                    $setResult(result);
          $EndJava
        ./
    prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS
        /.$BeginJava
                    EList<PrePostOrBodyDeclCS> result = (EList<PrePostOrBodyDeclCS>)$getSym(1);
                    result.add((PrePostOrBodyDeclCS)$getSym(2));
                    $setResult(result);
          $EndJava
        ./

    prePostOrBodyDeclCS ::= pre unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginJava
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.PRE_LITERAL,
                            (SimpleNameCS)$getSym(2),
                            (OCLExpressionCS)$getSym(4)
                        );
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
                    $setResult(result);
          $EndJava
        ./
    prePostOrBodyDeclCS ::= post unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginJava
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.POST_LITERAL,
                            (SimpleNameCS)$getSym(2),
                            (OCLExpressionCS)$getSym(4)
                        );
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
                    $setResult(result);
          $EndJava
        ./
    prePostOrBodyDeclCS ::= body unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginJava
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.BODY_LITERAL,
                            (SimpleNameCS)$getSym(2),
                            (OCLExpressionCS)$getSym(4)
                        );
                    setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
                    $setResult(result);
          $EndJava
        ./

	operationCS1 ::= simpleNameCS '(' parametersCSopt ')' ':' typeCSopt
		/.$BeginJava
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
		  $EndJava
		./
	operationCS2 ::= pathNameCS '::' unreservedSimpleNameCS '(' parametersCSopt ')'
	   ':' typeCSopt
		/.$BeginJava
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
		  $EndJava
		./

    parametersCSopt ::= $empty
        /.$BeginJava
                    $setResult(new BasicEList<VariableCS>());
          $EndJava
        ./
    parametersCSopt -> parametersCS
	
	parametersCS ::= VariableDeclarationCS 
		/.$BeginJava
					EList<VariableCS> result = new BasicEList<VariableCS>();
					result.add((VariableCS)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	parametersCS ::= parametersCS ',' VariableDeclarationCS
		/.$BeginJava
					EList<VariableCS> result = (EList<VariableCS>)$getSym(1);
					result.add((VariableCS)$getSym(3));
					$setResult(result);
		  $EndJava
		./
$End
