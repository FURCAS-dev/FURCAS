--/**
-- * <copyright>
-- *
-- * Copyright (c) 2005, 2007 IBM Corporation and others.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   IBM - Initial API and implementation
-- *   E.D. Willink - Elimination of some shift-reduce conflicts
-- *
-- * </copyright>
-- *
-- * $Id: OCLParser.g,v 1.2 2008/10/04 00:54:10 cdamus Exp $
-- */
--
-- The OCL Parser
--

%options escape=$
%options la=2
%options table=java
%options fp=OCLParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options package=org.eclipse.ocl.parser
--%options template=dtParserTemplateD.g
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

$Define
    $environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./
	$lex_stream_class /.OCLLexer./
$End

$Globals
	/.
	import org.eclipse.ocl.Environment;
	import org.eclipse.ocl.cst.DefExpressionCS;
	import org.eclipse.ocl.cst.InitOrDerValueCS;
	import org.eclipse.ocl.cst.InvOrDefCS;
	import org.eclipse.ocl.cst.OperationCS;
	import org.eclipse.ocl.cst.PackageDeclarationCS;
	import org.eclipse.ocl.cst.PrePostOrBodyEnum;
	./
$End

$KeyWords
	context
	package
	
	--
	-- the following are not used in the OCL concrete syntax, but
	-- are defined as reserved words in the Spec 7.4.9
	--
	attr
	oper
$End

$Rules
	-- opt = optional
	-- m = multiple
	
	goal -> packageDeclarationCS1
	goal -> packageDeclarationCSm
	goal -> invOrDefCS
	goal -> prePostOrBodyDeclCS
	goal -> initOrDerValueCS
	goal -> variableCS
	goal -> $empty	

	packageDeclarationCSm -> packageDeclarationCS
	packageDeclarationCSm ::= packageDeclarationCSm packageDeclarationCS
		/.$BeginJava
					PackageDeclarationCS result = (PackageDeclarationCS)$getSym(2);
					result.setPackageDeclarationCS((PackageDeclarationCS) $getSym(1));
					$setResult(result);
		  $EndJava
		./
	packageDeclarationCS ::= package pathNameCS contextDeclCSmopt endpackage
		/.$BeginJava
					CSTNode result = createPackageDeclarationCS(
							(PathNameCS)$getSym(2),
							(EList)$getSym(3)
						);
					setOffsets(result, getIToken($getToken(1)), getIToken($getToken(4)));
					$setResult(result);
		  $EndJava
		./
	
	packageDeclarationCS1 ::= contextDeclCSm
		/.$BeginJava
					EList contextDecls = (EList)$getSym(1);
					CSTNode result = createPackageDeclarationCS(null, contextDecls);
					if (!contextDecls.isEmpty()) {
						setOffsets(result, (CSTNode)contextDecls.get(0), (CSTNode)contextDecls.get(contextDecls.size()-1));
					}
					$setResult(result);
		  $EndJava
		./


	contextDeclCSmopt ::= $empty
		/.$EmptyListAction./
	contextDeclCSmopt -> contextDeclCSm

	contextDeclCSm ::= contextDeclCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	contextDeclCSm ::= contextDeclCSm contextDeclCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./

	contextDeclCS -> classifierContextDeclCS
	contextDeclCS -> operationContextDeclCS
	contextDeclCS -> propertyContextCS

	propertyContextCS ::= context pathNameCS '::' simpleNameCS ':' typeCS initOrDerValueCS
		/.$BeginJava
					CSTNode result = createPropertyContextCS(
							(PathNameCS)$getSym(2),
							(SimpleNameCS)$getSym(4),
							(TypeCS)$getSym(6),
							(InitOrDerValueCS)$getSym(7)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(7));
					$setResult(result);
		  $EndJava
		./

	initOrDerValueCS ::= initOrDerValueCSopt init ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createInitValueCS(
							(InitOrDerValueCS)$getSym(1),
							(OCLExpressionCS)$getSym(4)
						);
					if ($getSym(1) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(4));
					} else {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
					}
					$setResult(result);
		  $EndJava
		./

	initOrDerValueCS ::= initOrDerValueCSopt derive ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createDerValueCS(
							(InitOrDerValueCS)$getSym(1),
							(OCLExpressionCS)$getSym(4)
						);
					if ($getSym(1) != null) {
						setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(4));
					} else {
						setOffsets(result, getIToken($getToken(2)), (CSTNode)$getSym(4));
					}
					$setResult(result);
		  $EndJava
		./

	initOrDerValueCSopt ::= $empty
		/.$NullAction./
	initOrDerValueCSopt -> initOrDerValueCS

	classifierContextDeclCS ::= context pathNameCS invOrDefCSm
		/.$BeginJava
					EList<InvOrDefCS> list = (EList<InvOrDefCS>)$getSym(3);
					CSTNode result = createClassifierContextDeclCS(
							(PathNameCS)$getSym(2),
							list
						);
					setOffsets(result, getIToken($getToken(1)), list.get(list.size()-1));
					$setResult(result);
		  $EndJava
		./

	invOrDefCSm ::= invOrDefCS
		/.$BeginJava
					EList<InvOrDefCS> result = new BasicEList<InvOrDefCS>();
					result.add((InvOrDefCS)$getSym(1));
					$setResult(result);
		  $EndJava
		./
	invOrDefCSm ::= invOrDefCSm invOrDefCS
		/.$BeginJava
					EList<InvOrDefCS> result = (EList<InvOrDefCS>)$getSym(1);
					result.add((InvOrDefCS)$getSym(2));
					$setResult(result);
		  $EndJava
		./
	invOrDefCS ::= inv simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createInvCS(
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	
	invOrDefCS ::= def simpleNameCSopt ':' defExpressionCS
		/.$BeginJava
					CSTNode result = createDefCS(
							(SimpleNameCS)$getSym(2),
							(DefExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./

	defExpressionCS ::= IDENTIFIER ':' typeCS '=' oclExpressionCS
		/.$BeginJava
					VariableCS variableCS = createVariableCS(
								getTokenText($getToken(1)),
								(TypeCS)$getSym(3),
								null
							);
					setOffsets(variableCS, getIToken($getToken(1)), (CSTNode)$getSym(3));
					CSTNode result = createDefExpressionCS(
							variableCS,
							null,
							(OCLExpressionCS)$getSym(5)
						);
					setOffsets(result, variableCS, (CSTNode)$getSym(5));
					$setResult(result);
		  $EndJava
		./
	defExpressionCS ::= operationCS1 '=' oclExpressionCS
		/.$BeginJava
					CSTNode result = createDefExpressionCS(
							null,
							(OperationCS)$getSym(1),
							(OCLExpressionCS)$getSym(3)
						);
					setOffsets(result, (CSTNode)$getSym(1), (CSTNode)$getSym(3));
					$setResult(result);
		  $EndJava
		./

	operationContextDeclCS ::= context operationCS2 prePostOrBodyDeclCSm
		/.$BeginJava
					EList prePostOrBodyDecls = (EList)$getSym(3);
					CSTNode result = createOperationContextDeclCS(
							(OperationCS)$getSym(2),
							prePostOrBodyDecls
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)prePostOrBodyDecls.get(prePostOrBodyDecls.size()-1));
					$setResult(result);
		  $EndJava
		./

	prePostOrBodyDeclCSm ::= prePostOrBodyDeclCS
		/.$BeginJava
					EList result = new BasicEList();
					result.add($getSym(1));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCSm ::= prePostOrBodyDeclCSm prePostOrBodyDeclCS
		/.$BeginJava
					EList result = (EList)$getSym(1);
					result.add($getSym(2));
					$setResult(result);
		  $EndJava
		./

	prePostOrBodyDeclCS ::= pre simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.PRE_LITERAL,
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCS ::= post simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.POST_LITERAL,
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
	prePostOrBodyDeclCS ::= body simpleNameCSopt ':' oclExpressionCS
		/.$BeginJava
					CSTNode result = createPrePostOrBodyDeclCS(
							PrePostOrBodyEnum.BODY_LITERAL,
							(SimpleNameCS)$getSym(2),
							(OCLExpressionCS)$getSym(4)
						);
					setOffsets(result, getIToken($getToken(1)), (CSTNode)$getSym(4));
					$setResult(result);
		  $EndJava
		./
$End
