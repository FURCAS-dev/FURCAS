/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - refactored to separate from OCLAnalyzer and OCLParser
 *             - Bugs 243976, 295166, 259818
 *   Zeligsoft - Bugs 243976, 255599, 251349
 *   Borland - Bugs 242880, 266320
 *
 * </copyright>
 *
 * $Id: AbstractOCLParser.java,v 1.15 2010/02/09 21:04:08 ewillink Exp $
 */
package org.eclipse.ocl.parser;

import java.util.HashSet;
import java.util.Set;

import lpg.runtime.IToken;

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
import org.eclipse.ocl.cst.DotOrArrowEnum;
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
import org.eclipse.ocl.options.ProblemOption;

public abstract class AbstractOCLParser
		extends AbstractParser {

	public AbstractOCLParser(BasicEnvironment environment) {
		super(environment);
	}

	public AbstractOCLParser(AbstractLexer lexer) {
		super(lexer);
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

	/**
	 * @since 3.0
	 */
	protected PropertyContextCS createPropertyContextCS(PathNameCS pathNameCS,
			SimpleNameCS simpleNameCS, TypeCS typeCS,
			EList<InitOrDerValueCS> constraints) {
		PropertyContextCS result = CSTFactory.eINSTANCE
			.createPropertyContextCS();
		result.setPathNameCS(pathNameCS);
		result.setSimpleNameCS(simpleNameCS);
		result.setTypeCS(typeCS);
		result.getConstraints().addAll(constraints);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected DerValueCS createDerValueCS(OCLExpressionCS oclExpressionCS) {
		DerValueCS result = CSTFactory.eINSTANCE.createDerValueCS();
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected InitValueCS createInitValueCS(OCLExpressionCS oclExpressionCS) {
		InitValueCS result = CSTFactory.eINSTANCE.createInitValueCS();
		result.setExpressionCS(oclExpressionCS);
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
	 * @since 3.0
	 */
	protected ClassifierContextDeclCS createClassifierContextDeclCS(
			SimpleNameCS simpleNameCS, PathNameCS pathNameCS, EList<InvOrDefCS> constraints) {

		ClassifierContextDeclCS result = CSTFactory.eINSTANCE
			.createClassifierContextDeclCS();
		result.setSimpleNameCS(simpleNameCS);
		result.setPathNameCS(pathNameCS);
		result.getConstraints().addAll(constraints);
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
	 * Creates a definition constraint.
	 * 
	 * @param isStatic
	 *            true for a static constraint
	 * @param simpleNameCS
	 *            the concrete syntax of the constraint name
	 * @param oclExpressionCS
	 *            the concrete syntax of the constraint expression
	 * 
	 * @return the concrete syntax of the definition constraint
	 * 
	 * @since 3.0
	 */
	protected DefCS createDefCS(boolean isStatic, SimpleNameCS simpleNameCS,		
			DefExpressionCS defExpressionCS) {
		DefCS result = CSTFactory.eINSTANCE.createDefCS();
		result.setStatic(isStatic);
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

	/**
	 * @since 3.0
	 */
	protected OperationCS createOperationCS(IToken simpleName,
			EList<VariableCS> list, TypeCS typeCS) {
		return createOperationCS(null, createSimpleNameCS(
			SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName), list, typeCS);
	}

	/**
	 * @since 3.0
	 */
	private OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS, DotOrArrowEnum dotOrArrow, PathNameCS pathNameCS, SimpleNameCS simpleNameCS,
			IsMarkedPreCS isMarkedPreCS, EList<OCLExpressionCS> arguments) {
		OperationCallExpCS result = CSTFactory.eINSTANCE
			.createOperationCallExpCS();
		result.setSource(oclExpressionCS);
		result.setAccessor(oclExpressionCS != null ? dotOrArrow : DotOrArrowEnum.NONE_LITERAL);
		result.setPathNameCS((pathNameCS != null) && (pathNameCS.getSimpleNames().size() > 0) ? pathNameCS : null);
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
		return atPreCS != null;
	}

	/**
	 * @since 3.0
	 */
	protected OperationCallExpCS createOperationCallExpCS(
			OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS,
			EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, null, null, simpleNameCS,
			null, arguments);
	}

	/**
	 * @since 3.0
	 */
	protected OperationCallExpCS createArrowOperationCallExpCS(
			OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, DotOrArrowEnum.ARROW_LITERAL, null, simpleNameCS, isMarkedPreCS,
			arguments);
	}

	/**
	 * @since 3.0
	 */
	protected OperationCallExpCS createDotOperationCallExpCS(
			OCLExpressionCS oclExpressionCS, PathNameCS pathNameCS, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		OperationCallExpCS result = createOperationCallExpCS(oclExpressionCS, DotOrArrowEnum.DOT_LITERAL, pathNameCS, simpleNameCS,
			isMarkedPreCS, arguments);
		if (oclExpressionCS != null) {
			result.setIsAtomic(true);
		}
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

	/**
	 * @since 3.0
	 */
	protected SimpleNameCS createConceptualOperationNameCS(IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		String conceptualName = token.toString();
		result.setValue(conceptualName);
		ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
		BasicEnvironment benv = getEnvironment();
		if (benv != null) {
			sev = benv.getValue(ProblemOption.CONCEPTUAL_OPERATION_NAME);
			if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
				benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
					.bind(OCLMessages.Conceptual_Operation_Name_, conceptualName),
					"unquote", //$NON-NLS-1$
					token);
			}
		}
		return result;
	}

	/**
	 * @since 3.0
	 */
	@SuppressWarnings("deprecation")
	protected SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unDoubleQuote(token));
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected SimpleNameCS createQuotedSimpleNameCS(SimpleTypeEnum type, IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unSingleQuote(token));
		return result;
	}

	protected PrimitiveTypeCS createPrimitiveTypeCS(SimpleTypeEnum type,
			String value) {
		PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
		result.setType(type);
		result.setValue(value);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected PathNameCS createPathNameCS(SimpleNameCS name) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSimpleNames().add(name);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected PathNameCS extendPathNameCS(PathNameCS path, SimpleNameCS name) {
		path.getSimpleNames().add(name);
		return path;
	}

	protected PathNameCS createPathNameCS() {
		return CSTFactory.eINSTANCE.createPathNameCS();
	}

	/**
	 * @since 3.0
	 */
	protected PathNameCS createPathNamePrefixCS(PathNameCS pathNameCS) {
		EList<SimpleNameCS> simpleNames = pathNameCS.getSimpleNames();
		int size = simpleNames.size();
		PathNameCS prefixPathNameCS = CSTFactory.eINSTANCE.createPathNameCS();
		if (size > 1) {
			for (int i = 0; i < size-1; i++) {
				extendPathNameCS(prefixPathNameCS, simpleNames.get(i));
			}
			setOffsets(prefixPathNameCS, prefixPathNameCS.getSimpleNames().get(0), prefixPathNameCS.getSimpleNames().get(size-2));
		}
		return prefixPathNameCS;
	}
	/**
	 * @since 3.0
	 */
	protected SimpleNameCS getPathNameSuffixCS(PathNameCS pathNameCS) {
		EList<SimpleNameCS> simpleNames = pathNameCS.getSimpleNames();
		int size = simpleNames.size();
		return size > 0 ? simpleNames.get(size-1) : null;
	}

	/**
	 * @since 3.0
	 */
	protected CollectionLiteralExpCS createCollectionLiteralExpCS(
			CollectionTypeCS typeCS,
			EList<CollectionLiteralPartCS> collectionLiteralParts) {
		CollectionLiteralExpCS result = CSTFactory.eINSTANCE
			.createCollectionLiteralExpCS();
		result.setCollectionType(typeCS.getCollectionTypeIdentifier());
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

	/**
	 * @since 3.0
	 */
	protected StringLiteralExpCS createStringLiteralExpCS(IToken token) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE
			.createStringLiteralExpCS();
		String unquoted = unSingleQuote(token);
		result.setSymbol(unquoted);
		result.setStringSymbol(unquoted);
		result.setUnescapedStringSymbol(unquoted);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected SimpleNameCS extendQuotedSimpleNameCS(SimpleNameCS simpleName, IToken token) {       
        String oldString = simpleName.getValue();
        String newString = unSingleQuote(token);
    	String joinedString = oldString + newString;
    	simpleName.setValue(joinedString);
		return simpleName;
	}

	/**
	 * @since 3.0
	 */
	protected StringLiteralExpCS extendStringLiteralExpCS(StringLiteralExpCS string, IToken token) {       
        String oldString = string.getUnescapedStringSymbol();
        String newString = unSingleQuote(token);
    	String joinedString = oldString + newString;
		string.setSymbol(joinedString);
    	string.setStringSymbol(joinedString);
    	string.setUnescapedStringSymbol(joinedString);
		return string;
	}

	protected BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
		BooleanLiteralExpCS result = CSTFactory.eINSTANCE
			.createBooleanLiteralExpCS();
		result.setValue(string);
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		result.setSymbol(string);
		result.setBooleanSymbol(Boolean.valueOf(string));
		return result;
	}

	protected NullLiteralExpCS createNullLiteralExpCS(String string) {
		NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
		result.setValue(string);
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		return result;
	}

	protected InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
		InvalidLiteralExpCS result = CSTFactory.eINSTANCE
			.createInvalidLiteralExpCS();
		result.setValue(string);
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected IteratorExpCS createIteratorExpCS(
			OCLExpressionCS source, SimpleNameCS simpleNameCS,
			VariableCS variable1, VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
		result.setSource(source);
		result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected IterateExpCS createIterateExpCS(
			OCLExpressionCS source, SimpleNameCS simpleNameCS,
			VariableCS variable1, VariableCS variable2,
			OCLExpressionCS oclExpressionCS) {
		IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
		result.setSource(source);
		result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected VariableCS createVariableCS(SimpleNameCS varName, TypeCS typeCS,
			OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(varName.getValue());
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected CollectionTypeCS createCollectionTypeCS(
			CollectionTypeIdentifierEnum collectionType, String value) {
		CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
		result.setType(SimpleTypeEnum.IDENTIFIER_LITERAL);
		result.setValue(value);
		result.setCollectionTypeIdentifier(collectionType);
		return result;
	}

	protected TupleTypeCS createTupleTypeCS(EList<VariableCS> variables) {
		TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
		result.getVariables().addAll(variables);
		return result;
	}

	/**
	 * @since 3.0
	 */
	protected FeatureCallExpCS createFeatureCallExpCS(
			OCLExpressionCS source, PathNameCS pathNameCS, SimpleNameCS simpleNameCS, EList<OCLExpressionCS> arguments,
			IsMarkedPreCS isMarkedPreCS) {
		FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
		result.setSource(source);
		result.setAccessor(source != null ? DotOrArrowEnum.DOT_LITERAL : DotOrArrowEnum.NONE_LITERAL);
		result.setPathNameCS((pathNameCS != null) && (pathNameCS.getSimpleNames().size() > 0) ? pathNameCS : null);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	/**
	 * @since 3.0
	 */
	protected IsMarkedPreCS createIsMarkedPreCS() {
		IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
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

	/**
	 * @since 3.0
	 */
	protected MessageExpCS createMessageExpCS(OCLExpressionCS target, boolean hasSent,
			SimpleNameCS simpleNameCS, EList<OCLMessageArgCS> oclMessageArgs) {
		MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
		result.setTarget(target);
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
	 * @since 3.0
	 */
	protected Set<String> iteratorNames = null;

	/**
	 * @since 3.0
	 */
	@SuppressWarnings("nls")
	protected Set<String> createIteratorNames() {
		Set<String> iteratorNames = new HashSet<String>();
		iteratorNames.add("any");
		iteratorNames.add("collect");
		iteratorNames.add("collectNested");
		iteratorNames.add("exists");
		iteratorNames.add("forAll");
		iteratorNames.add("isUnique");
		iteratorNames.add("one");
		iteratorNames.add("reject");
		iteratorNames.add("select");
		iteratorNames.add("sortedBy");

		iteratorNames.add("closure");
		return iteratorNames;
	}
	
	/**
	 * @since 3.0
	 */
	protected boolean isIterator(String name) {
		if (iteratorNames == null) {
			iteratorNames = createIteratorNames();
		}
		return iteratorNames.contains(name);
	}
	
	/**
	 * <p>
	 * Escaping support based on the QVT specification (8.4.3).
	 * </p>
	 * @param stringLiteral a string literal token with escape notation 
	 * @return the unescaped string
	 * 
	 * @since 1.3
	 * 
	 * @deprecated Use decodeString.
	 */
	@Deprecated
	protected String unescape(IToken stringLiteral) {
		return decodeString(stringLiteral, stringLiteral.toString());
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
