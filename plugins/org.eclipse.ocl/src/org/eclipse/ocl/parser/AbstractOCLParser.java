/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLAnalyzer and OCLParser
 *
 * </copyright>
 *
 * $Id: AbstractOCLParser.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
 */
package org.eclipse.ocl.parser;

import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.DerValueCS;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.InitValueCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.MessageExpKind;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.BasicEnvironment;


public abstract class AbstractOCLParser extends AbstractParser
{
	public AbstractOCLParser(BasicEnvironment environment) {
		super(environment);
	}

	@SuppressWarnings("nls")
	public AbstractOCLParser(AbstractLexer lexStream) {
		super(lexStream);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), OCLParserprs.EOFT_SYMBOL);
		}
		catch(NullExportedSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(NullTerminalSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		catch(UnimplementedTerminalsException e) {
			java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
			String error = "The Lexer will not scan the following token(s):";
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				error += "\t" + OCLParsersym.orderedTerminalSymbols[id.intValue()];			   
			}
			throw new RuntimeException(error + "\n");						
		}
		catch(UndefinedEofSymbolException e) {
			throw new RuntimeException("The Lexer does not implement the Eof symbol " +
				 OCLParsersym.orderedTerminalSymbols[OCLParserprs.EOFT_SYMBOL]);
		} 
	}

	protected PackageDeclarationCS createPackageDeclarationCS(
			PathNameCS pathNameCS,
			EList<ContextDeclCS> contextDecls) {
		PackageDeclarationCS result = CSTFactory.eINSTANCE.createPackageDeclarationCS();
		result.setPathNameCS(pathNameCS);
		if (contextDecls != null && !contextDecls.isEmpty()) {
            result.getContextDecls().addAll(contextDecls);
        }
		return result;
	}
	
	protected PropertyContextCS createPropertyContextCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS,
			TypeCS typeCS,
			InitOrDerValueCS initOrDerValueCS) {
		PropertyContextCS result = CSTFactory.eINSTANCE.createPropertyContextCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setTypeCS(typeCS);
		result.setInitOrDerValueCS(initOrDerValueCS);
		return result;
	}
	
	protected DerValueCS createDerValueCS(
			InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected InitValueCS createInitValueCS(
			InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}
	
	protected ClassifierContextDeclCS createClassifierContextDeclCS(
			PathNameCS pathNameCS,
			InvOrDefCS invOrDefCS) {
		ClassifierContextDeclCS result = CSTFactory.eINSTANCE.createClassifierContextDeclCS();
		result.setPathNameCS(pathNameCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected InvCS createInvCS(
			InvOrDefCS invOrDefCS,
			SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		InvCS result = CSTFactory.eINSTANCE.createInvCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected DefCS createDefCS(
			InvOrDefCS invOrDefCS,
			SimpleNameCS simpleNameCS,
			DefExpressionCS defExpressionCS) {
		DefCS result = CSTFactory.eINSTANCE.createDefCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setDefExpressionCS(defExpressionCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}
	
	protected DefExpressionCS createDefExpressionCS(
			VariableCS variableCS,
			OperationCS operationCS,
			OCLExpressionCS oclExpressionCS) {
		DefExpressionCS result = CSTFactory.eINSTANCE.createDefExpressionCS();
		result.setVariableCS(variableCS);
		result.setOperationCS(operationCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationContextDeclCS createOperationContextDeclCS(
			OperationCS operationCS,
			EList<PrePostOrBodyDeclCS> prePostOrBodyDecls) {
		OperationContextDeclCS result = CSTFactory.eINSTANCE.createOperationContextDeclCS();
		result.setOperationCS(operationCS);
		result.getPrePostOrBodyDecls().addAll(prePostOrBodyDecls);
		return result;
	}

	protected PrePostOrBodyDeclCS createPrePostOrBodyDeclCS(
			PrePostOrBodyEnum kind,
			SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		PrePostOrBodyDeclCS result = CSTFactory.eINSTANCE.createPrePostOrBodyDeclCS();
		result.setKind(kind);
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationCS createOperationCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS,
			EList<VariableCS> list,
			TypeCS typeCS) {
		OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.getParameters().addAll(list);
		result.setTypeCS(typeCS);
		return result;
	}

	protected OperationCS createOperationCS(
			String simpleName,
			EList<VariableCS> list,
			TypeCS typeCS) {
		return createOperationCS(
				null,
				createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName),
				list,
				typeCS);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS,
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSource(oclExpressionCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setIsMarkedPreCS(isMarkedPreCS);
		result.getArguments().addAll(arguments);
		return result;
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS,
			SimpleNameCS simpleNameCS,
			EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
				createIsMarkedPreCS(false), arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS, arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS,
			StateExpCS stateExpCS) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setIsMarkedPreCS(isMarkedPreCS);
		result.getArguments().add(stateExpCS);
		return result;
	}
	
	protected StateExpCS createStateExpCS(PathNameCS pathName) {
		StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
		result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
		return result;
	}

	protected VariableExpCS createVariableExpCS(
			SimpleNameCS simpleNameCS,
			EList<OCLExpressionCS> arguments,
			IsMarkedPreCS isMarkedPreCS) {
		VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	protected SimpleNameCS createSimpleNameCS(
			SimpleTypeEnum type,
			String value) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unquote(value));
		return result;
	}

	protected PrimitiveTypeCS createPrimitiveTypeCS(
			SimpleTypeEnum type,
			String value) {
		PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
		result.setType(type);
		result.setValue(value);
		return result;
	}

	protected PathNameCS createPathNameCS(String pathName) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSequenceOfNames().add(unquote(pathName));
		return result;
	}
	
	protected PathNameCS extendPathNameCS(PathNameCS path, String name) {
		path.getSequenceOfNames().add(unquote(name));
		return path;
	}

	protected PathNameCS createPathNameCS() {
		return CSTFactory.eINSTANCE.createPathNameCS();
	}

	protected EnumLiteralExpCS createEnumLiteralExpCS(
			PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS) {
		EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		return result;
	}

	protected EnumLiteralExpCS createEnumLiteralExpCS(
			PathNameCS pathNameCS,
			String simpleName) {
		return createEnumLiteralExpCS(pathNameCS,
			createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName));
	}

	protected CollectionLiteralExpCS createCollectionLiteralExpCS(
			CollectionTypeIdentifierEnum type,
			EList<CollectionLiteralPartCS> collectionLiteralParts) {
		CollectionLiteralExpCS result = CSTFactory.eINSTANCE.createCollectionLiteralExpCS();
		result.setCollectionType(type);
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	protected CollectionLiteralPartCS createCollectionLiteralPartCS(OCLExpressionCS oclExpressionCS) {
		CollectionLiteralPartCS result = CSTFactory.eINSTANCE.createCollectionLiteralPartCS();
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected CollectionRangeCS createCollectionRangeCS(
			OCLExpressionCS oclExpressionCS,
			OCLExpressionCS lastOCLExpressionCS) {
		CollectionRangeCS result = CSTFactory.eINSTANCE.createCollectionRangeCS();
		result.setExpressionCS(oclExpressionCS);
		result.setLastExpressionCS(lastOCLExpressionCS);
		return result;
	}

	protected IntegerLiteralExpCS createRangeStart(
			String integerDotDot,
			boolean isNegative) {
		String intToken = integerDotDot.substring(0, integerDotDot.indexOf('.'));
		int intValue = Integer.parseInt(intToken);
		if (isNegative) {
			intValue = -intValue;
		}
		
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
		result.setIntegerSymbol(new Integer(intValue));
		result.setSymbol(Integer.toString(intValue));
		
		return result;
	}

	protected TupleLiteralExpCS createTupleLiteralExpCS(EList<VariableCS> variables) {
		TupleLiteralExpCS result = CSTFactory.eINSTANCE.createTupleLiteralExpCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
		result.setSymbol(string);
		result.setIntegerSymbol(Integer.valueOf(string));
		return result;
	}

	@SuppressWarnings("nls")
	protected UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS(String string) {
		UnlimitedNaturalLiteralExpCS result = CSTFactory.eINSTANCE.createUnlimitedNaturalLiteralExpCS();
		result.setSymbol(string);
		if ("*".equals(string)) {
			result.setIntegerSymbol(-1);
		} else {
			result.setIntegerSymbol(Integer.valueOf(string));
		}
		return result;
	}

	protected RealLiteralExpCS createRealLiteralExpCS(String string) {
		RealLiteralExpCS result = CSTFactory.eINSTANCE.createRealLiteralExpCS();
		result.setSymbol(string);
		result.setRealSymbol(Double.valueOf(string));
		return result;
	}

	protected StringLiteralExpCS createStringLiteralExpCS(String string) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE.createStringLiteralExpCS();
		result.setSymbol(string);
		result.setStringSymbol(string);
		return result;
	}

	protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
		BooleanLiteralExpCS result = CSTFactory.eINSTANCE.createBooleanLiteralExpCS();
		result.setSymbol(string);
		result.setBooleanSymbol(Boolean.valueOf(string));
		return result;
	}

	protected NullLiteralExpCS createNullLiteralExpCS(String string) {
		NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
		InvalidLiteralExpCS result = CSTFactory.eINSTANCE.createInvalidLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected IteratorExpCS createIteratorExpCS(
			SimpleNameCS simpleNameCS,
			VariableCS variable1,
			VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected IterateExpCS createIterateExpCS(
			SimpleNameCS simpleNameCS,
			VariableCS variable1,
			VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected VariableCS createVariableCS(
			String varName,
			TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unquote(varName));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	protected CollectionTypeCS createCollectionTypeCS(
			CollectionTypeIdentifierEnum collectionType,
			TypeCS typeCS) {
		CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
		result.setCollectionTypeIdentifier(collectionType);
		result.setTypeCS(typeCS);
		return result;
	}

	protected TupleTypeCS createTupleTypeCS(EList<VariableCS> variables) {
		TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected FeatureCallExpCS createFeatureCallExpCS(
			SimpleNameCS simpleNameCS,
			EList<OCLExpressionCS> arguments,
			IsMarkedPreCS isMarkedPreCS) {
		FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	protected IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
		IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
		result.setPre(isMarkedPre);
		return result;
	}

	protected LetExpCS createLetExpCS(
			EList<VariableCS> variables,
			OCLExpressionCS oclExpressionCS) {
		LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
		result.getVariables().addAll(variables);
		result.setInExpression(oclExpressionCS);
		return result;
	}

	protected IfExpCS createIfExpCS(
			OCLExpressionCS condition,
			OCLExpressionCS thenExpression,
			OCLExpressionCS elseExpression) {
		IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
		result.setCondition(condition);
		result.setThenExpression(thenExpression);
		result.setElseExpression(elseExpression);
		return result;
	}

	protected MessageExpCS createMessageExpCS(
			boolean hasSent,
			SimpleNameCS simpleNameCS,
			EList<OCLMessageArgCS> oclMessageArgs) {
		MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
		result.setKind(hasSent ? MessageExpKind.HAS_SENT_LITERAL : MessageExpKind.SENT_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(oclMessageArgs);
		return result;
	}

	protected OCLMessageArgCS createOCLMessageArgCS(
			TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
		result.setTypeCS(typeCS);
		result.setExpression(oclExpressionCS);
		return result;
	}
}
