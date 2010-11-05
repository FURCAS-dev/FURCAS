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
-- * $Id: OCLParser.g,v 1.14 2010/01/25 11:31:46 asanchez Exp $
-- */
--
-- The Complete OCL Parser
--

%options escape=$
%options la=1
%options fp=OCLParser,prefix=TK_
%options noserialize
%options package=org.eclipse.ocl.parser
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
							getRhsTokenText(1)
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
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
					OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
					OperationCallExpCS result = createArrowOperationCallExpCS(
							source,
							(SimpleNameCS)getRhsSym(3),
							(IsMarkedPreCS)getRhsSym(4),
							(EList<OCLExpressionCS>)getRhsSym(6)
						);
					setOffsets(result, source, getRhsIToken(7));
					setResult(result);
		  $EndCode
		./	

	AssociationClassCallExpCS ::= -- [B.1],PropertyCallExpCS[B]
		simpleNameCS isMarkedPreCS
		/.$BeginCode
					SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
					IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(2);
					VariableExpCS result = createVariableExpCS(
							simpleNameCS,
							new BasicEList<OCLExpressionCS>(),
							isMarkedPreCS
						);
					setOffsets(result, simpleNameCS, isMarkedPreCS);
					setResult(result);
		  $EndCode
		./

	isMarkedPreCS ::= '@' pre
		/.$BeginCode
					IsMarkedPreCS result = createIsMarkedPreCS();
					setOffsets(result, getRhsIToken(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	isMarkedPreCSopt -> isMarkedPreCS

	OclMessageExpCS ::= primaryExpCS '^^' simpleNameCS '(' OclMessageArgumentsCSopt ')'
		/.$NewCase./
	OclMessageExpCS ::= primaryExpCS '^' simpleNameCS '(' OclMessageArgumentsCSopt ')'
		/.$BeginCode
					OCLExpressionCS target = (OCLExpressionCS)getRhsSym(1);
					MessageExpCS result = createMessageExpCS(
							target,
							getRhsIToken(2).getKind() == $sym_type.TK_CARET,
							(SimpleNameCS)getRhsSym(3),
							(EList<OCLMessageArgCS>)getRhsSym(5)
						);
					setOffsets(result, target, getRhsIToken(6));
					setResult(result);
		  $EndCode
		./

	OclMessageArgumentsCSopt ::= %empty
        /.$BeginCode
                    setResult(new BasicEList<OCLMessageArgCS>());
          $EndCode
        ./
	OclMessageArgumentsCSopt -> OclMessageArgumentsCS

	OclMessageArgumentsCS ::= OclMessageArgCS
		/.$BeginCode
					EList<OCLMessageArgCS> result = new BasicEList<OCLMessageArgCS>();
					result.add((OCLMessageArgCS)getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	OclMessageArgumentsCS ::= OclMessageArgumentsCS ',' OclMessageArgCS
		/.$BeginCode
					EList<OCLMessageArgCS> result = (EList<OCLMessageArgCS>)getRhsSym(1);
					result.add((OCLMessageArgCS)getRhsSym(3));
					setResult(result);
		  $EndCode
		./

	OclMessageArgCS ::= '?'
		/.$BeginCode
					OCLMessageArgCS result = createOCLMessageArgCS(
							null,
							null
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
	OclMessageArgCS ::= '?' ':' typeCS
		/.$BeginCode
					OCLMessageArgCS result = createOCLMessageArgCS(
							(TypeCS)getRhsSym(3),
							null
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	OclMessageArgCS ::= OclExpressionCS
		/.$BeginCode
					OCLMessageArgCS result = createOCLMessageArgCS(
							null,
							(OCLExpressionCS)getRhsSym(1)
						);
					setOffsets(result, (CSTNode)getRhsSym(1));
					setResult(result);
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
                    PackageDeclarationCS result = (PackageDeclarationCS)getRhsSym(2);
                    result.setPackageDeclarationCS((PackageDeclarationCS) getRhsSym(1));
                    setResult(result);
          $EndCode
        ./

    packageDeclarationCS -> packageDeclarationCS_A
    packageDeclarationCS -> packageDeclarationCS_B
    packageDeclarationCS_A ::= package pathNameCS contextDeclsCSopt endpackage
        /.$BeginCode
                    PackageDeclarationCS result = createPackageDeclarationCS(
                            (PathNameCS)getRhsSym(2),
                            (EList<ContextDeclCS>)getRhsSym(3)
                        );
                    setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                    setResult(result);
          $EndCode
        ./
    
    packageDeclarationCS_B ::= contextDeclsCS
        /.$BeginCode
                    EList<ContextDeclCS> contextDecls = (EList<ContextDeclCS>)getRhsSym(1);
                    PackageDeclarationCS result = createPackageDeclarationCS(null, contextDecls);
                    if (!contextDecls.isEmpty()) {
                        setOffsets(result, contextDecls.get(0), contextDecls.get(contextDecls.size()-1));
                    }
                    setResult(result);
          $EndCode
        ./

    contextDeclsCSopt ::= %empty
        /.$BeginCode
                    setResult(new BasicEList<ContextDeclCS>());
          $EndCode
        ./
    contextDeclsCSopt -> contextDeclsCS

    contextDeclsCS ::= contextDeclCS
        /.$BeginCode
                    EList<ContextDeclCS> result = new BasicEList<ContextDeclCS>();
                    result.add((ContextDeclCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    contextDeclsCS ::= contextDeclsCS contextDeclCS
        /.$BeginCode
                    EList<ContextDeclCS> result = (EList<ContextDeclCS>)getRhsSym(1);
                    result.add((ContextDeclCS)getRhsSym(2));
                    setResult(result);
          $EndCode
        ./

    contextDeclCS -> propertyContextDeclCS
    contextDeclCS -> classifierContextDeclCS
    contextDeclCS -> operationContextDeclCS

    propertyContextDeclCS ::= context pathNameCS '::' unreservedSimpleNameCS
        ':' typeCS initOrDerValuesCS
        /.$BeginCode
                    PathNameCS pathNameCS = (PathNameCS)getRhsSym(2);
                    SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(4);
                    EList<InitOrDerValueCS> list = (EList<InitOrDerValueCS>)getRhsSym(7);
                    PropertyContextCS result = createPropertyContextCS(
                            pathNameCS,
                            simpleNameCS,
                            (TypeCS)getRhsSym(6),
                            list
                        );
                    setOffsets(result, getRhsIToken(1), list.get(list.size()-1));
                    setResult(result);
          $EndCode
        ./

    initOrDerValuesCS ::= initOrDerValueCS
        /.$BeginCode
                    EList<InitOrDerValueCS> result = new BasicEList<InitOrDerValueCS>();
                    result.add((InitOrDerValueCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    initOrDerValuesCS ::= initOrDerValuesCS initOrDerValueCS
        /.$BeginCode
                    EList<InitOrDerValueCS> result = (EList<InitOrDerValueCS>)getRhsSym(1);
                    result.add((InitOrDerValueCS)getRhsSym(2));
                    setResult(result);
          $EndCode
        ./

    initOrDerValueCS ::= init ':' OclExpressionCS
        /.$BeginCode
                    InitValueCS result = createInitValueCS((OCLExpressionCS)getRhsSym(3));
                    setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./
    initOrDerValueCS ::= derive ':' OclExpressionCS
        /.$BeginCode
                    DerValueCS result = createDerValueCS((OCLExpressionCS)getRhsSym(3));
                    setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
                    setResult(result);
          $EndCode
        ./

	classifierContextDeclCS ::= context pathNameCS invOrDefsCS
		/.$BeginCode
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)getRhsSym(3);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							null,
							(PathNameCS)getRhsSym(2),
							list
						);
					setOffsets(result, getRhsIToken(1), list.get(list.size()-1));
					setResult(result);
		  $EndCode
		./
	classifierContextDeclCS ::= context simpleNameCS ':' pathNameCS invOrDefsCS
		/.$BeginCode
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)getRhsSym(5);
					ClassifierContextDeclCS result = createClassifierContextDeclCS(
							(SimpleNameCS)getRhsSym(2),
							(PathNameCS)getRhsSym(4),
							list
						);
					setOffsets(result, getRhsIToken(1), list.get(list.size()-1));
					setResult(result);
		  $EndCode
		./

    invOrDefsCS ::= invOrDefCS
        /.$BeginCode
                    EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
                    result.add((InvOrDefCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    invOrDefsCS ::= invOrDefsCS invOrDefCS
        /.$BeginCode
                    EList<InvOrDefCS> result = (EList<InvOrDefCS>)getRhsSym(1);
                    result.add((InvOrDefCS)getRhsSym(2));
                    setResult(result);
          $EndCode
        ./

	invOrDefCS ::= inv unreservedSimpleNameCSopt ':' OclExpressionCS
		/.$BeginCode
					InvCS result = createInvCS(
							(SimpleNameCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
					setResult(result);
		  $EndCode
		./	
    invOrDefCS ::= def unreservedSimpleNameCSopt ':' defExpressionCS
        /.$BeginCode
                    DefExpressionCS defExpressionCS = (DefExpressionCS)getRhsSym(4);
                    DefCS result = createDefCS(
                            false,
                            (SimpleNameCS)getRhsSym(2),
                            defExpressionCS
                        );
                    setOffsets(result, getRhsIToken(1), defExpressionCS);
                    setResult(result);
          $EndCode
        ./
    invOrDefCS ::= static def unreservedSimpleNameCSopt ':' defExpressionCS
        /.$BeginCode
                    DefExpressionCS defExpressionCS = (DefExpressionCS)getRhsSym(5);
                    DefCS result = createDefCS(
                            true,
                            (SimpleNameCS)getRhsSym(3),
                            defExpressionCS
                        );
                    setOffsets(result, getRhsIToken(1), defExpressionCS);
                    setResult(result);
          $EndCode
        ./

	defExpressionCS ::= typedUninitializedVariableCS '=' OclExpressionCS
		/.$BeginCode
					VariableCS variableCS = (VariableCS)getRhsSym(1);
					OCLExpressionCS expressionCS = (OCLExpressionCS)getRhsSym(3);
					DefExpressionCS result = createDefExpressionCS(
							variableCS,
							null,
							expressionCS
						);
					setOffsets(result, variableCS, expressionCS);
					setResult(result);
		  $EndCode
		./
	defExpressionCS ::= operationCS1 '=' OclExpressionCS
		/.$BeginCode
					DefExpressionCS result = createDefExpressionCS(
							null,
							(OperationCS)getRhsSym(1),
							(OCLExpressionCS)getRhsSym(3)
						);
					setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./

	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclsCS
		/.$BeginCode
					EList<PrePostOrBodyDeclCS> prePostOrBodyDecls = (EList<PrePostOrBodyDeclCS>)getRhsSym(3);
					OperationContextDeclCS result = createOperationContextDeclCS(
							(OperationCS)getRhsSym(2),
							prePostOrBodyDecls
						);
					setOffsets(result, getRhsIToken(1), prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
					setResult(result);
		  $EndCode
		./

    prePostOrBodyDeclsCS ::= prePostOrBodyDeclCS
        /.$BeginCode
                    EList<PrePostOrBodyDeclCS> result = new BasicEList<PrePostOrBodyDeclCS>();
                    result.add((PrePostOrBodyDeclCS)getRhsSym(1));
                    setResult(result);
          $EndCode
        ./
    prePostOrBodyDeclsCS ::= prePostOrBodyDeclsCS prePostOrBodyDeclCS
        /.$BeginCode
                    EList<PrePostOrBodyDeclCS> result = (EList<PrePostOrBodyDeclCS>)getRhsSym(1);
                    result.add((PrePostOrBodyDeclCS)getRhsSym(2));
                    setResult(result);
          $EndCode
        ./

    prePostOrBodyDeclCS ::= pre unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginCode
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.PRE_LITERAL,
                            (SimpleNameCS)getRhsSym(2),
                            (OCLExpressionCS)getRhsSym(4)
                        );
                    setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
                    setResult(result);
          $EndCode
        ./
    prePostOrBodyDeclCS ::= post unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginCode
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.POST_LITERAL,
                            (SimpleNameCS)getRhsSym(2),
                            (OCLExpressionCS)getRhsSym(4)
                        );
                    setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
                    setResult(result);
          $EndCode
        ./
    prePostOrBodyDeclCS ::= body unreservedSimpleNameCSopt ':' OclExpressionCS
        /.$BeginCode
                    PrePostOrBodyDeclCS result = createPrePostOrBodyDeclCS(
                            PrePostOrBodyEnum.BODY_LITERAL,
                            (SimpleNameCS)getRhsSym(2),
                            (OCLExpressionCS)getRhsSym(4)
                        );
                    setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
                    setResult(result);
          $EndCode
        ./

	operationCS1 ::= simpleNameCS '(' parametersCSopt ')' ':' typeCSopt
		/.$BeginCode
					OperationCS result = createOperationCS(
							getRhsIToken(1),
							(EList<VariableCS>)getRhsSym(3),
							(TypeCS)getRhsSym(6)
						);
					if (getRhsSym(6) != null) {
						setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
					} else {
						setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					}
					setResult(result);
		  $EndCode
		./
	operationCS2 ::= pathNameCS '::' unreservedSimpleNameCS '(' parametersCSopt ')'
	   ':' typeCSopt
		/.$BeginCode
					PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
					TypeCS typeCS = (TypeCS)getRhsSym(8);
					OperationCS result = createOperationCS(
							pathNameCS,
							simpleNameCS,
							(EList<VariableCS>)getRhsSym(5),
							typeCS
						);
					if (typeCS != null) {
						setOffsets(result, pathNameCS, typeCS);
					} else {
						setOffsets(result, pathNameCS, getRhsIToken(7));
					}
					setResult(result);
		  $EndCode
		./

    parametersCSopt ::= %empty
        /.$BeginCode
                    setResult(new BasicEList<VariableCS>());
          $EndCode
        ./
    parametersCSopt -> parametersCS
	
	parametersCS ::= VariableDeclarationCS 
		/.$BeginCode
					EList<VariableCS> result = new BasicEList<VariableCS>();
					result.add((VariableCS)getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	parametersCS ::= parametersCS ',' VariableDeclarationCS
		/.$BeginCode
					EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
					result.add((VariableCS)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
%End
