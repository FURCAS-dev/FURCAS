/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLAnalyzer and OCLParser
 *             - Bugs 243976, 259818
 *   Zeligsoft - Bugs 243976, 255599, 251349
 *   Borland - Bugs 242880, 266320
 *
 * </copyright>
 *
 * $Id: AbstractOCLParser.java,v 1.7 2009/03/05 14:30:51 cdamus Exp $
 */
package org.eclipse.ocl.parser;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.ParseErrorCodes;
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
import org.eclipse.ocl.cst.OCLDocumentCS;
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
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.options.ProblemOption;

public abstract class AbstractOCLParser
		extends AbstractParser {
	
	public AbstractOCLParser(BasicEnvironment environment) {
		super(environment);
	}

	@SuppressWarnings("nls")
	public AbstractOCLParser(AbstractLexer lexStream) {
		super(lexStream);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(),
				OCLParserprs.EOFT_SYMBOL);
		} catch (NullExportedSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} catch (NullTerminalSymbolsException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} catch (UnimplementedTerminalsException e) {
			java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
			String error = "The Lexer will not scan the following token(s):";
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				error += "\t"
					+ OCLParsersym.orderedTerminalSymbols[id.intValue()];
			}
			throw new RuntimeException(error + "\n");
		} catch (UndefinedEofSymbolException e) {
			throw new RuntimeException(
				"The Lexer does not implement the Eof symbol "
					+ OCLParsersym.orderedTerminalSymbols[OCLParserprs.EOFT_SYMBOL]);
		}
	}
	
	protected PackageDeclarationCS createPackageDeclarationCS(
			PathNameCS pathNameCS, EList<ContextDeclCS> contextDecls) {
		PackageDeclarationCS result = CSTFactory.eINSTANCE
			.createPackageDeclarationCS();
		result.setPathNameCS(pathNameCS);
		if (contextDecls != null && !contextDecls.isEmpty()) {
			result.getContextDecls().addAll(contextDecls);
		}
		return result;
	}

	protected PropertyContextCS createPropertyContextCS(PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS, TypeCS typeCS,
			InitOrDerValueCS initOrDerValueCS) {
		PropertyContextCS result = CSTFactory.eINSTANCE
			.createPropertyContextCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setTypeCS(typeCS);
		result.setInitOrDerValueCS(initOrDerValueCS);
		return result;
	}

	protected DerValueCS createDerValueCS(InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected InitValueCS createInitValueCS(InitOrDerValueCS initOrDerValueCS,
			OCLExpressionCS oclExpressionCS) {
		InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
		result.setInitOrDerValueCS(initOrDerValueCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	/**
	 * @deprecated As of 1.3, the
	 *             {@link #createClassifierContextDeclCS(PathNameCS, EList)}
	 *             method should be used, instead.
	 */
	@Deprecated
	protected ClassifierContextDeclCS createClassifierContextDeclCS(
			PathNameCS pathNameCS, InvOrDefCS invOrDefCS) {
		ClassifierContextDeclCS result = CSTFactory.eINSTANCE
			.createClassifierContextDeclCS();
		result.setPathNameCS(pathNameCS);
		result.setInvOrDefCS(invOrDefCS);

		// fill in the owned constraints list
		for (InvOrDefCS next = invOrDefCS; next != null; next = next
			.getInvOrDefCS()) {
			result.getConstraints().add(0, next);
		}

		return result;
	}

	/**
	 * Creates a classifier context declaration.
	 * 
	 * @param pathNameCS
	 *            the concrete syntax of the classifier's qualified name
	 * @param constraints
	 *            the concrete syntax of the invariant and/or definition
	 *            constraints in the classifier context
	 * @return the classifier context declaration
	 * 
	 * @since 1.3
	 */
	protected ClassifierContextDeclCS createClassifierContextDeclCS(
			PathNameCS pathNameCS, EList<InvOrDefCS> constraints) {

		ClassifierContextDeclCS result = CSTFactory.eINSTANCE
			.createClassifierContextDeclCS();
		result.setPathNameCS(pathNameCS);
		result.getConstraints().addAll(constraints);

		// Create the reversed linked list for 1.2.0 API compatibility
		InvOrDefCS tail = null;
		for (InvOrDefCS next : constraints) {
			next.setInvOrDefCS(tail);
			tail = next;
		}
		result.setInvOrDefCS(tail);
		return result;
	}

	/**
	 * @deprecated As of 1.3, the
	 *             {@link #createInvCS(SimpleNameCS, OCLExpressionCS)} method
	 *             should be used, instead.
	 */
	@Deprecated
	protected InvCS createInvCS(InvOrDefCS invOrDefCS,
			SimpleNameCS simpleNameCS, OCLExpressionCS oclExpressionCS) {
		InvCS result = CSTFactory.eINSTANCE.createInvCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}

	/**
	 * Creates an invariant constraint.
	 * 
	 * @param simpleNameCS
	 *            the concrete syntax of the constraint name, or
	 *            <code>null</code> if none
	 * @param oclExpressionCS
	 *            the concrete syntax of the constraint expression
	 * 
	 * @return the concrete syntax of the invariant constraint
	 * 
	 * @since 1.3
	 */
	protected InvCS createInvCS(SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		InvCS result = CSTFactory.eINSTANCE.createInvCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	/**
	 * @deprecated As of 1.3, the
	 *             {@link #createDefCS(SimpleNameCS, OCLExpressionCS)} method
	 *             should be used, instead.
	 */
	@Deprecated
	protected DefCS createDefCS(InvOrDefCS invOrDefCS,
			SimpleNameCS simpleNameCS, DefExpressionCS defExpressionCS) {
		DefCS result = CSTFactory.eINSTANCE.createDefCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setDefExpressionCS(defExpressionCS);
		result.setInvOrDefCS(invOrDefCS);
		return result;
	}

	/**
	 * Creates a definition constraint.
	 * 
	 * @param simpleNameCS
	 *            the concrete syntax of the constraint name
	 * @param oclExpressionCS
	 *            the concrete syntax of the constraint expression
	 * 
	 * @return the concrete syntax of the definition constraint
	 * 
	 * @since 1.3
	 */
	protected DefCS createDefCS(SimpleNameCS simpleNameCS,
			DefExpressionCS defExpressionCS) {
		DefCS result = CSTFactory.eINSTANCE.createDefCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setDefExpressionCS(defExpressionCS);
		return result;
	}

	protected DefExpressionCS createDefExpressionCS(VariableCS variableCS,
			OperationCS operationCS, OCLExpressionCS oclExpressionCS) {
		DefExpressionCS result = CSTFactory.eINSTANCE.createDefExpressionCS();
		result.setVariableCS(variableCS);
		result.setOperationCS(operationCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationContextDeclCS createOperationContextDeclCS(
			OperationCS operationCS,
			EList<PrePostOrBodyDeclCS> prePostOrBodyDecls) {
		OperationContextDeclCS result = CSTFactory.eINSTANCE
			.createOperationContextDeclCS();
		result.setOperationCS(operationCS);
		result.getPrePostOrBodyDecls().addAll(prePostOrBodyDecls);
		return result;
	}

	protected PrePostOrBodyDeclCS createPrePostOrBodyDeclCS(
			PrePostOrBodyEnum kind, SimpleNameCS simpleNameCS,
			OCLExpressionCS oclExpressionCS) {
		PrePostOrBodyDeclCS result = CSTFactory.eINSTANCE
			.createPrePostOrBodyDeclCS();
		result.setKind(kind);
		result.setSimpleNameCS(simpleNameCS);
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected OperationCS createOperationCS(PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS, EList<VariableCS> list, TypeCS typeCS) {
		OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.getParameters().addAll(list);
		result.setTypeCS(typeCS);
		return result;
	}

	protected OperationCS createOperationCS(String simpleName,
			EList<VariableCS> list, TypeCS typeCS) {
		return createOperationCS(null, createSimpleNameCS(
			SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName), list, typeCS);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS, EList<OCLExpressionCS> arguments) {
		OperationCallExpCS result = CSTFactory.eINSTANCE
			.createOperationCallExpCS();
		result.setSource(oclExpressionCS);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	/**
	 * Queries whether the specified <tt>{@literal @pre}</tt> construct was
	 * actually present in the text. This method is safe with null inputs.
	 * 
	 * @param atPreCS
	 *            an "at pre" construct or <code>null</code>
	 * @return <code>true</code> if the <tt>atPreCS</tt> is present;
	 *         <code>false</code>, otherwise
	 * 
	 * @since 1.3
	 */
	protected boolean isAtPre(IsMarkedPreCS atPreCS) {
		return (atPreCS != null) && atPreCS.isPre();
	}

	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS,
			EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
			createIsMarkedPreCS(false), arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS,
			arguments);
	}

	protected OperationCallExpCS createOperationCallExpCS(
			SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
			StateExpCS stateExpCS) {
		OperationCallExpCS result = CSTFactory.eINSTANCE
			.createOperationCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().add(stateExpCS);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	protected StateExpCS createStateExpCS(PathNameCS pathName) {
		StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
		result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
		return result;
	}

	protected VariableExpCS createVariableExpCS(SimpleNameCS simpleNameCS,
			EList<OCLExpressionCS> arguments, IsMarkedPreCS isMarkedPreCS) {
		VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	protected SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, String value) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unquote(value));
		return result;
	}

	protected PrimitiveTypeCS createPrimitiveTypeCS(SimpleTypeEnum type,
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

	protected EnumLiteralExpCS createEnumLiteralExpCS(PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS) {
		EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		return result;
	}

	/**
	 * @deprecated Use {@link #createEnumLiteralExpCS(PathNameCS, SimpleNameCS)}
	 *             , instead.
	 */
	@Deprecated
	protected EnumLiteralExpCS createEnumLiteralExpCS(PathNameCS pathNameCS,
			String simpleName) {
		return createEnumLiteralExpCS(pathNameCS, createSimpleNameCS(
			SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName));
	}

	protected CollectionLiteralExpCS createCollectionLiteralExpCS(
			CollectionTypeIdentifierEnum type,
			EList<CollectionLiteralPartCS> collectionLiteralParts) {
		CollectionLiteralExpCS result = CSTFactory.eINSTANCE
			.createCollectionLiteralExpCS();
		result.setCollectionType(type);
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	protected CollectionLiteralPartCS createCollectionLiteralPartCS(
			OCLExpressionCS oclExpressionCS) {
		CollectionLiteralPartCS result = CSTFactory.eINSTANCE
			.createCollectionLiteralPartCS();
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	protected CollectionRangeCS createCollectionRangeCS(
			OCLExpressionCS oclExpressionCS, OCLExpressionCS lastOCLExpressionCS) {
		CollectionRangeCS result = CSTFactory.eINSTANCE
			.createCollectionRangeCS();
		result.setExpressionCS(oclExpressionCS);
		result.setLastExpressionCS(lastOCLExpressionCS);
		return result;
	}

	protected IntegerLiteralExpCS createRangeStart(String integerDotDot,
			boolean isNegative) {
		String intToken = integerDotDot
			.substring(0, integerDotDot.indexOf('.'));
		int intValue = Integer.parseInt(intToken);
		if (isNegative) {
			intValue = -intValue;
		}

		IntegerLiteralExpCS result = CSTFactory.eINSTANCE
			.createIntegerLiteralExpCS();
		result.setIntegerSymbol(new Integer(intValue));
		result.setSymbol(Integer.toString(intValue));

		return result;
	}

	protected TupleLiteralExpCS createTupleLiteralExpCS(
			EList<VariableCS> variables) {
		TupleLiteralExpCS result = CSTFactory.eINSTANCE
			.createTupleLiteralExpCS();
		result.getVariables().addAll(variables);
		return result;
	}

	protected IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE
			.createIntegerLiteralExpCS();
		result.setSymbol(string);
		result.setIntegerSymbol(Integer.valueOf(string));
		return result;
	}

	@SuppressWarnings("nls")
	protected UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS(
			String string) {
		UnlimitedNaturalLiteralExpCS result = CSTFactory.eINSTANCE
			.createUnlimitedNaturalLiteralExpCS();
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
		StringLiteralExpCS result = CSTFactory.eINSTANCE
			.createStringLiteralExpCS();
		result.setSymbol(string);
		result.setStringSymbol(string);
		return result;
	}

	protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
		BooleanLiteralExpCS result = CSTFactory.eINSTANCE
			.createBooleanLiteralExpCS();
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
		InvalidLiteralExpCS result = CSTFactory.eINSTANCE
			.createInvalidLiteralExpCS();
		result.setSymbol(string);
		return result;
	}

	protected IteratorExpCS createIteratorExpCS(SimpleNameCS simpleNameCS,
			VariableCS variable1, VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected IterateExpCS createIterateExpCS(SimpleNameCS simpleNameCS,
			VariableCS variable1, VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected VariableCS createVariableCS(String varName, TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unquote(varName));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	protected CollectionTypeCS createCollectionTypeCS(
			CollectionTypeIdentifierEnum collectionType, TypeCS typeCS) {
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
			SimpleNameCS simpleNameCS, EList<OCLExpressionCS> arguments,
			IsMarkedPreCS isMarkedPreCS) {
		FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	protected IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
		IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
		result.setPre(isMarkedPre);
		return result;
	}

	protected LetExpCS createLetExpCS(EList<VariableCS> variables,
			OCLExpressionCS oclExpressionCS) {
		LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
		result.getVariables().addAll(variables);
		result.setInExpression(oclExpressionCS);
		return result;
	}

	protected IfExpCS createIfExpCS(OCLExpressionCS condition,
			OCLExpressionCS thenExpression, OCLExpressionCS elseExpression) {
		IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
		result.setCondition(condition);
		result.setThenExpression(thenExpression);
		result.setElseExpression(elseExpression);
		return result;
	}

	protected MessageExpCS createMessageExpCS(boolean hasSent,
			SimpleNameCS simpleNameCS, EList<OCLMessageArgCS> oclMessageArgs) {
		MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
		result.setKind(hasSent
			? MessageExpKind.HAS_SENT_LITERAL
			: MessageExpKind.SENT_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(oclMessageArgs);
		return result;
	}

	protected OCLMessageArgCS createOCLMessageArgCS(TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
		result.setTypeCS(typeCS);
		result.setExpression(oclExpressionCS);
		return result;
	}

	/**
	 * Creates an OCL document CS from a chain of package context declarations.
	 * 
	 * @param packageDecl
	 *            a chain of package context declarations
	 * @return the document CS
	 * 
	 * @since 1.3
	 */
	protected OCLDocumentCS createOCLDocumentCS(PackageDeclarationCS packageDecl) {
		OCLDocumentCS result = CSTFactory.eINSTANCE.createOCLDocumentCS();

		for (PackageDeclarationCS decl = packageDecl; decl != null; decl = decl
			.getPackageDeclarationCS()) {

			result.getPackageDeclarations().add(0, decl);
		}

		return result;
	}
	
	/**
	 * <p>
	 * Escaping support based on the QVT specification (8.4.3).
	 * </p>
	 * <p>
	 * All the usual escape characters using backslash can be used including the '\n' new-line character.
	 *  The list of available escape characters are those defined for the Java language.
	 *  <p>
	 *  <p>
	 *  EscapeSequence:
	 *  </p>
	 *  <table border="0" align="left">
	 *  <tr><td><b><tt>\b</tt></b></td> <td><tt>\u0008</tt>: backspace <tt>BS</tt></td></tr>
	 *  <tr><td><b><tt>\t</tt></b></td> <td><tt>\u0009</tt>: horizontal tab <tt>HT</tt></td></tr>
	 *  <tr><td><b><tt>\n</tt></b></td> <td><tt>\u000a</tt>: line feed <tt>LF</tt></td></tr>
	 *  <tr><td><b><tt>\f</tt></b></td> <td><tt>\u000c</tt>: form feed <tt>FF</tt></td></tr> 
	 *  <tr><td><b><tt>\r</tt></b></td> <td><tt>\u000d</tt>: carriage return <tt>CR</tt></td></tr>
	 *  <tr><td><b><tt>\"</tt></b></td> <td><tt>\u0022</tt>: double quote <tt>"</tt></td></tr>
	 *  <tr><td><b><tt>\'</tt></b></td> <td><tt>\u0027</tt>: single quote <tt>'</tt></td></tr>
	 *  <tr><td><b><tt>\\</tt></b></td> <td><tt>\u005c</tt>: backslash <tt>\</tt></td></tr>
	 *  <tr><td rowspan="2" valign="top"><b>OctalEscape</b></td> <td><tt>\u0000</tt> to <tt>\u00ff</tt>: from octal value</td></tr>
	 *  <tr><td>\ ZeroToThree OctalDigit OctalDigit</td></tr>
	 *  <tr><td><b>OctalDigit<b></td> <td><tt>0 1 2 3 4 5 6 7</tt></td></tr>
	 *  <tr><td><b>ZeroToThree</b></td> <td><tt>0 1 2 3</tt></td></tr>
	 *  </table>
	 *  
	 * @param stringLiteral a string literal token with escape notation 
	 * @return the unescaped string
	 * 
	 * @since 1.3
	 */
	protected String unescape(IToken stringLiteral) {
		String rawString = stringLiteral.toString();
		int rawStringLength = rawString.length();
		if (rawStringLength <= 2) {
			return ""; //$NON-NLS-1$
		}
		StringBuilder unescapedStringBuilder = null;
		boolean isBackslashEscapeProcessingUsed = getEnvironment().isEnabled(
			ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		boolean isNonStdSQEscapingUsed = false;
		int n = rawStringLength - 1;
		for (int i = 1; i < n; i++) {
			char ch = rawString.charAt(i);
			if ((isBackslashEscapeProcessingUsed && (ch == '\\'))
				|| ((ch == '\'') && isNonStdSQSupported())) {
				if (unescapedStringBuilder == null) {
					unescapedStringBuilder = new StringBuilder(rawString
						.substring(1, i));
				}
				i++;
				if (i >= n) {
					reportError(
						ParseErrorCodes.INVALID_CODE,
						"", stringLiteral.getTokenIndex(), stringLiteral.getTokenIndex(), //$NON-NLS-1$
						OCLMessages.StringNotProperlyClosed_ERROR);
				}
				char nextCh = rawString.charAt(i);
				if (ch == '\\') {
					switch (nextCh) {
						case 'b' :
							unescapedStringBuilder.append('\b');
							break;
						case 't' :
							unescapedStringBuilder.append('\t');
							break;
						case 'n' :
							unescapedStringBuilder.append('\n');
							break;
						case 'f' :
							unescapedStringBuilder.append('\f');
							break;
						case 'r' :
							unescapedStringBuilder.append('\r');
							break;
						case '\"' :
							unescapedStringBuilder.append('\"');
							break;
						case '\'' :
							unescapedStringBuilder.append('\'');
							break;
						case '\\' :
							unescapedStringBuilder.append('\\');
							break;
						default :
							// octal escape check
							int unescapedChar = -1;
							if ((nextCh >= '\u0030') && (nextCh <= '\u0037')) { // octal
																				// digit
								unescapedChar = Character
									.getNumericValue(nextCh);
								if (i + 1 < n) {
									char tmpCh = rawString.charAt(i + 1);
									if ((tmpCh >= '\u0030')
										&& (tmpCh <= '\u0037')) { // octal digit
										unescapedChar = 8 * unescapedChar
											+ Character.getNumericValue(tmpCh);
										i++;
										if (i + 1 < n) {
											tmpCh = rawString.charAt(i + 1);
											if ((tmpCh >= '\u0030')
												&& (tmpCh <= '\u0037') // octal
																		// digit
												&& (nextCh <= '\u0033')) { // most-significant
																			// digit
																			// in
																			// range
																			// 0..2
												unescapedChar = 8
													* unescapedChar
													+ Character
														.getNumericValue(tmpCh);
												i++;
											}
										}
									}
								}
								unescapedStringBuilder
									.append((char) unescapedChar);
							}
							if (unescapedChar < 0) {
								reportError(
									ParseErrorCodes.INVALID_CODE,
									"", stringLiteral.getTokenIndex(), stringLiteral.getTokenIndex(), //$NON-NLS-1$
									OCLMessages.InvalidEscapeSequence_ERROR);
							}
							break;
					}
				} else { // non-std '' escaping
					unescapedStringBuilder.append('\'');
					isNonStdSQEscapingUsed = true;
					assert nextCh == '\'' : "Unexpected escape sequence in string literal: " + rawString; //$NON-NLS-1$
				}
			} else if (unescapedStringBuilder != null) {
				unescapedStringBuilder.append(ch);
			}
		}
		if (isNonStdSQEscapingUsed) {
			// check settings for using non-standard closure iterator
			ProblemHandler.Severity sev = getEnvironment().getValue(
				ProblemOption.STRING_SINGLE_QUOTE_ESCAPE);
			if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
				getEnvironment().problem(
					sev,
					ProblemHandler.Phase.PARSER,
					OCLMessages.bind(OCLMessages.NonStd_SQuote_Escape_,
						stringLiteral), "STRING_LITERAL", //$NON-NLS-1$
					stringLiteral);
			}
		}
		return (unescapedStringBuilder == null)
			? rawString.substring(1, n)
			: unescapedStringBuilder.toString();
	}

	/**
	 * To be overridden in parsers which prohibit non-std SQL-like single quote
	 * escaping (" <tt>''</tt> ").
	 * 
	 * @return true if such escaping is supported, false otherwise
	 * 
	 * @since 1.3
	 */
	protected boolean isNonStdSQSupported() {
		return true;
	}
}
