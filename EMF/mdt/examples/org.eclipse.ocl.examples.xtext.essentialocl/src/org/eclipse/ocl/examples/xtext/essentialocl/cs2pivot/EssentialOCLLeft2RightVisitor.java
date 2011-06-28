/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLLeft2RightVisitor.java,v 1.23 2011/05/23 05:51:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.evaluation.CallableImplementation;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseLeft2RightVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpSpecificationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.BinaryOperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.ImplicitCollectFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.ImplicitCollectionFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.UnaryOperationFilter;
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLUtils;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

public class EssentialOCLLeft2RightVisitor
	extends AbstractExtendingDelegatingEssentialOCLCSVisitor<MonikeredElement, CS2PivotConversion, BaseLeft2RightVisitor>
{
	private static final Logger logger = Logger.getLogger(EssentialOCLLeft2RightVisitor.class);

	protected final TypeManager typeManager;
	
	public EssentialOCLLeft2RightVisitor(CS2PivotConversion context) {
		super(new BaseLeft2RightVisitor(context), context);
		this.typeManager = context.getTypeManager();
	}

	protected OclExpression checkImplementation(NamedExpCS csNavigatingExp,
			Feature feature, CallExp callExp, OclExpression expression) {
		CallableImplementation implementation;
		try {
			implementation = typeManager.getImplementation(feature);
		} catch (Exception e) {
			return context.addBadExpressionError(csNavigatingExp, "Failed to load '" + feature.getImplementationClass() + "': " + e);
		}
		if (implementation != null) {
			Diagnostic diagnostic = implementation.validate(typeManager, callExp);
			if (diagnostic != null) {
				context.addDiagnostic(csNavigatingExp, diagnostic);
			}
		}
		return expression;
	}

/*	private TemplateParameterSubstitution findFormalParameter(TemplateParameter formalTemplateParameter, Type actualType) {
		for (TemplateBinding actualTemplateBinding : actualType.getTemplateBindings()) {
			for (TemplateParameterSubstitution actualTemplateParameterSubstitution : actualTemplateBinding.getParameterSubstitutions()) {
				TemplateParameter actualFormal = actualTemplateParameterSubstitution.getFormal();
				if (actualFormal == formalTemplateParameter) {
					return actualTemplateParameterSubstitution;
				}
			}
		}
		if (actualType instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : ((org.eclipse.ocl.examples.pivot.Class)actualType).getSuperClasses()) {
				TemplateParameterSubstitution actualTemplateParameterSubstitution = findFormalParameter(formalTemplateParameter, superClass);
				if (actualTemplateParameterSubstitution != null) {
					return actualTemplateParameterSubstitution;
				}
			}
		}
		return null;
	} */

	protected Operation getBadOperation() {
		InvalidType invalidType = typeManager.getOclInvalidType();
		Operation badOperation = PivotUtil.getNamedElement(invalidType.getOwnedOperations(), "oclBadOperation");
		return badOperation;
	}

	protected Property getBadProperty() {
		InvalidType invalidType = typeManager.getOclInvalidType();
		Property badProperty = PivotUtil.getNamedElement(invalidType.getOwnedAttributes(), "oclBadProperty");
		return badProperty;
	}

/*	private TemplateParameter getFormal(List<TemplateBinding> templateBindings, TemplateParameter templateParameter) {
		for (TemplateBinding templateBinding : templateBindings) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
				if (templateParameter == templateParameterSubstitution.getFormal()) {
					return templateParameterSubstitution.getActual().getOwningTemplateParameter();
				}
			}
		}
		return null;
	} */

	protected VariableDeclaration getImplicitSource(ModelElementCS csExp, Feature feature) {
		EObject eContainer = csExp.eContainer();
		if (eContainer instanceof NavigatingExpCS) {
			EReference eContainmentFeature = csExp.eContainmentFeature();
			if ((eContainmentFeature == EssentialOCLCSTPackage.Literals.DECORATED_NAMED_EXP_CS__NAMED_EXP)
			 || (eContainmentFeature == EssentialOCLCSTPackage.Literals.NAVIGATING_EXP_CS__ARGUMENT)) {
				Type namedElementType = PivotUtil.getFeaturingClass(feature);
				NavigatingExpCS csNavigatingExp = (NavigatingExpCS) eContainer;
				CallExp iteratorExp = PivotUtil.getPivot(CallExp.class, csNavigatingExp);
				if (iteratorExp instanceof LoopExp) {
					for (Variable iterator : ((LoopExp)iteratorExp).getIterators()) {
						Type type = iterator.getType();
						if (typeManager.conformsTo(type, namedElementType)) {
							return iterator;
						}
					}
					if (iteratorExp instanceof IterateExp) {
						Variable iterator = ((IterateExp)iteratorExp).getResult();
						Type type = iterator.getType();
						if (typeManager.conformsTo(type, namedElementType)) {
							return iterator;
						}
					}
				}
			}
		}
		else if (csExp instanceof ContextCS) {
			ContextCS csContext = (ContextCS) csExp;
			ExpressionInOcl pivotElement = PivotUtil.getPivot(ExpressionInOcl.class, csContext);
			return pivotElement.getContextVariable();
		}
		else if (csExp instanceof ExpSpecificationCS) {
			ExpressionInOcl pivotElement = PivotUtil.getPivot(ExpressionInOcl.class, csExp);
			return pivotElement.getContextVariable();
		}
		if (eContainer instanceof ContextCS) {
			return getImplicitSource((ModelElementCS) eContainer, feature);
		}
		else if (eContainer instanceof ExpSpecificationCS) {
			return getImplicitSource((ModelElementCS) eContainer, feature);
		}
		else if (eContainer instanceof ExpCS) {
			return getImplicitSource((ModelElementCS) eContainer, feature);
		}
		else if (eContainer instanceof NavigatingArgCS) {
			return getImplicitSource((ModelElementCS) eContainer, feature);
		}
		return null;
	}

	protected Type getSourceElementType(NavigatingExpCS csNavigatingExp, OclExpression source) {
		Type sourceType = source.getType();
		boolean isCollectionNavigation = PivotConstants.COLLECTION_NAVIGATION_OPERATOR.equals(csNavigatingExp.getParent().getName());
		if (!isCollectionNavigation) {
			return sourceType;
		}
		if (sourceType instanceof CollectionType) {
			return ((CollectionType)sourceType).getElementType();
		}
		else {
			return sourceType;
		}
	}

	protected EnumLiteralExp resolveEnumLiteral(ExpCS csExp, EnumerationLiteral enumerationLiteral) {
		EnumLiteralExp expression = context.refreshExpression(EnumLiteralExp.class, PivotPackage.Literals.ENUM_LITERAL_EXP, csExp);
		context.setType(expression, typeManager.getClassifierType(enumerationLiteral.getEnumeration()));
		expression.setReferredEnumLiteral(enumerationLiteral);
		return expression;
	}

	protected void resolveIterationAccumulators(NavigatingExpCS csNavigatingExp, LoopExp expression) {
		Iteration iteration = expression.getReferredIteration();
		List<Variable> pivotAccumulators = new ArrayList<Variable>();
		//
		//	Explicit accumulator
		//
		for (int argIndex = 0; argIndex < csNavigatingExp.getArgument().size(); argIndex++) {
			NavigatingArgCS csArgument = csNavigatingExp.getArgument().get(argIndex);
			if (csArgument.getRole() != NavigationRole.ACCUMULATOR) {
				continue;
			}
			if (csArgument.getInit() == null) {
				context.addDiagnostic(csArgument, "Missing initializer for accumulator");
			}
//			if (csArgument.getOwnedType() != null) {
//				context.addError(csArgument, "Unexpected type for parameter");
//			}
			ExpCS csName = csArgument.getName();
			Variable acc = PivotUtil.getPivot(Variable.class, csName);
			acc.setRepresentedParameter(iteration.getOwnedAccumulators().get(pivotAccumulators.size()));
			pivotAccumulators.add(acc);
		}
		//
		//	Implicit Accumulator
		//
		if (expression instanceof IterateExp) {
			IterateExp iterateExp = (IterateExp)expression;
			if (pivotAccumulators.size() > 1) {
				context.addDiagnostic(csNavigatingExp, "Iterate calls cannot have more than one accumulator");			
			}
			else {
				iterateExp.setResult(pivotAccumulators.get(0));
			}
		}
		else if (pivotAccumulators.size() > 0) {
			context.addDiagnostic(csNavigatingExp, "Iteration calls cannot have an accumulator");			
		}
	}

	protected void resolveIterationBody(NavigatingExpCS csNavigatingExp, LoopExp expression) {
		List<OclExpression> pivotBodies = new ArrayList<OclExpression>();
		for (NavigatingArgCS csArgument : csNavigatingExp.getArgument()) {
			if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				if (csArgument.getInit() != null) {
					context.addDiagnostic(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addDiagnostic(csArgument, "Unexpected type for expression");
				}
				OclExpression exp = context.visitLeft2Right(OclExpression.class, csArgument.getName());
				context.installPivotElement(csArgument, exp);
				pivotBodies.add(exp);
			}
		}
		if (pivotBodies.size() != 1) {
			expression.setBody(context.addBadExpressionError(csNavigatingExp, "Iteration calls must have exactly one body"));
		}
		else {
			expression.setBody(pivotBodies.get(0));
		}
	}

	protected LoopExp resolveIterationCall(NavigatingExpCS csNavigatingExp, OclExpression source, Iteration iteration) {
		NamedExpCS csNamedExp = csNavigatingExp.getNamedExp();
		LoopExp expression;
		if (iteration.getOwnedAccumulators().size() > 0) {
			expression = context.refreshExpression(IterateExp.class, PivotPackage.Literals.ITERATE_EXP, csNamedExp);
		}
		else {
			expression = context.refreshExpression(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, csNamedExp);
		}
		context.setReferredIteration(expression, iteration);
		context.reusePivotElement(csNavigatingExp, expression);		
		//
		resolveIterationAccumulators(csNavigatingExp, expression);
		resolveIterationIterators(csNavigatingExp, source, expression);
//		resolveLoopBody(csNavigatingExp, expression);
		resolveOperationReturnType(expression);
		return expression;
	}

	protected void resolveIterationExplicitAccumulators(NavigatingExpCS csNavigatingExp) {
		//
		//	Explicit accumulator
		//
		for (int argIndex = 0; argIndex < csNavigatingExp.getArgument().size(); argIndex++) {
			NavigatingArgCS csArgument = csNavigatingExp.getArgument().get(argIndex);
			if (csArgument.getRole() != NavigationRole.ACCUMULATOR) {
				continue;
			}
			ExpCS csName = csArgument.getName();
			ICompositeNode node = NodeModelUtils.getNode(csName);
			ILeafNode leafNode = ElementUtil.getLeafNode(node);
			String varName = leafNode.getText();
			Variable acc = context.refreshMonikeredElement(Variable.class, PivotPackage.Literals.VARIABLE, csName);
			((NameExpCS)csName).setElement(acc);	// Resolve the reference that is actually a definition
			context.installPivotElement(csName, acc);
			context.reusePivotElement(csArgument, acc);
			context.refreshName(acc, varName);
			OclExpression initExpression = context.visitLeft2Right(OclExpression.class, csArgument.getInit());
			acc.setInitExpression(initExpression);
			TypedRefCS csAccType = csArgument.getOwnedType();
			Type accType;
			if (csAccType != null) {
				accType = PivotUtil.getPivot(Type.class, csAccType);
			}
			else {
				accType = initExpression.getType();
			}
			context.setType(acc, accType);
		}
	}

	protected void resolveIterationIterators(NavigatingExpCS csNavigatingExp,
			OclExpression source, LoopExp expression) {
		NamedExpCS csNamedExp = csNavigatingExp.getNamedExp();
		Iteration iteration = expression.getReferredIteration();
		List<Variable> pivotIterators = new ArrayList<Variable>();
		//
		//	Explicit iterators
		//
		int iterationIteratorsSize = iteration.getOwnedIterators().size();
		for (int argIndex = 0; argIndex < csNavigatingExp.getArgument().size(); argIndex++) {
			NavigatingArgCS csArgument = csNavigatingExp.getArgument().get(argIndex);
			if (csArgument.getRole() != NavigationRole.ITERATOR) {
				continue;
			}
			if (iterationIteratorsSize <= argIndex) {
				context.addWarning(csArgument, OCLMessages.RedundantIterator_WARNING_, iteration.getName());
				continue;
			}
			if (csArgument.getInit() != null) {
				context.addDiagnostic(csArgument, "Unexpected initializer for iterator");
			}
//			if (csArgument.getOwnedType() == null) {
//				context.addError(csArgument, "Missing type for iterator");
//			}
			ExpCS csName = csArgument.getName();
			ICompositeNode node = NodeModelUtils.getNode(csName);
			ILeafNode leafNode = ElementUtil.getLeafNode(node);
			String varName = leafNode.getText();
			Variable iterator = context.refreshMonikeredElement(Variable.class, PivotPackage.Literals.VARIABLE, csName);
			((NameExpCS)csName).setElement(iterator);	// Resolve the reference that is actually a definition
			context.installPivotElement(csName, iterator);
			context.reusePivotElement(csArgument, iterator);
			context.refreshName(iterator, varName);
			iterator.setRepresentedParameter(iteration.getOwnedIterators().get(pivotIterators.size()));
			TypedRefCS csType = csArgument.getOwnedType();
			Type varType = csType != null ? PivotUtil.getPivot(Type.class, csType) : null;
			if (varType == null) {
				varType = getSourceElementType(csNavigatingExp, source);
			}
			context.setType(iterator, varType);
			pivotIterators.add(iterator);
		}
		//
		//	Implicit Iterators
		//
		while (pivotIterators.size() < iterationIteratorsSize) {
			String varName = Integer.toString(pivotIterators.size()+1) + "_";
			String moniker = csNamedExp.getMoniker() + PivotConstants.MONIKER_SCOPE_SEPARATOR
				+ PivotPackage.Literals.LOOP_EXP__ITERATOR.getName() + PivotConstants.MONIKER_OPERATOR_SEPARATOR + varName;
			Variable iterator = context.refreshMonikeredElement(Variable.class, PivotPackage.Literals.VARIABLE, moniker);
			context.usePivotElement(csNavigatingExp, iterator);
			context.refreshName(iterator, varName);
			Type varType = getSourceElementType(csNavigatingExp, source);
			context.setType(iterator, varType);
			iterator.setImplicit(true);
			iterator.setRepresentedParameter(iteration.getOwnedIterators().get(pivotIterators.size()));
			pivotIterators.add(iterator);
		}
		context.refreshList(expression.getIterators(), pivotIterators);
	}

	/**
	 * Resolve any implicit collect().
	 */
	protected CallExp resolveNavigationFeature(NamedExpCS csElement, OclExpression source, Feature feature, CallExp callExp) {
		CallExp navigationExp = callExp;
		Type actualSourceType = source.getType();
		Type requiredSourceType = PivotUtil.getFeaturingClass(feature);
		boolean isDotNavigation = false;
		if (csElement.getParent() instanceof NavigationOperatorCS) {
			isDotNavigation = PivotConstants.OBJECT_NAVIGATION_OPERATOR.equals(((NavigationOperatorCS)csElement.getParent()).getName());
		}
		if (isDotNavigation && (actualSourceType instanceof CollectionType) && !(requiredSourceType instanceof CollectionType)) {
			Type elementType = ((CollectionType)actualSourceType).getElementType();
			String csMoniker = csElement.getMoniker();
			int lastIndex = csMoniker.lastIndexOf(PivotConstants.MONIKER_OPERATOR_SEPARATOR);
			String baseMoniker = csMoniker.substring(0, lastIndex+1);
			String moniker = baseMoniker + "collect";
			IteratorExp iteratorExp = context.refreshMonikeredElement(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, moniker);
			iteratorExp.setImplicit(true);
			EnvironmentView environmentView = new EnvironmentView(typeManager, PivotPackage.Literals.LOOP_EXP__REFERRED_ITERATION, "collect");
			environmentView.addFilter(new ImplicitCollectFilter(typeManager, (CollectionType) actualSourceType, elementType));
			environmentView.computeLookups(actualSourceType);
			Iteration resolvedIteration = (Iteration)environmentView.getContent();
			context.setReferredIteration(iteratorExp, resolvedIteration);
			Variable iterator = context.refreshMonikeredElement(Variable.class, PivotPackage.Literals.VARIABLE, baseMoniker + "1_");
			Parameter resolvedIterator = resolvedIteration.getOwnedIterators().get(0);
			iterator.setRepresentedParameter(resolvedIterator);
			context.refreshName(iterator, "1_");
			context.setType(iterator, elementType);
			iterator.setImplicit(true);
			iteratorExp.getIterators().add(iterator);
			String iteratorRefMoniker = csMoniker + PivotConstants.MONIKER_SCOPE_SEPARATOR + "source" + PivotConstants.MONIKER_OPERATOR_SEPARATOR + "1_";
			VariableExp variableExp = context.refreshMonikeredElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, iteratorRefMoniker);
			variableExp.setReferredVariable(iterator);
			variableExp.setImplicit(true);
			context.setType(variableExp, elementType);
			callExp.setSource(variableExp);			
			iteratorExp.setBody(callExp);
			Type bodyType = callExp.getType();
			while (bodyType instanceof CollectionType) {
				bodyType = ((CollectionType)bodyType).getElementType();
			}
			if (bodyType != null) {
				iteratorExp.setType(typeManager.getCollectionType(feature.isOrdered(), feature.isUnique(), bodyType));
			}
			navigationExp = iteratorExp;
		}
		navigationExp.setSource(source);
		return navigationExp;
	}

	/**
	 * Resolve any implicit source and any associated implicit oclAsSet().
	 */
	protected OclExpression resolveNavigationSource(NamedExpCS csNameExp, Feature feature) {
		boolean isCollectionNavigation = false;
		OperatorCS csOperator = csNameExp.getParent();
		OclExpression source = null;
		if (csOperator instanceof NavigationOperatorCS) {
			ExpCS csSource = csOperator.getSource();
			if (csSource != csNameExp) {
				source = PivotUtil.getPivot(OclExpression.class, csSource);
				isCollectionNavigation = csOperator.getName().equals(PivotConstants.COLLECTION_NAVIGATION_OPERATOR);
			}
		}
		if (source == null) {
			MonikeredElementCS csPivoted = EssentialOCLUtils.getPivotedCS(csOperator != null ? csOperator : csNameExp);
			ElementCS csChild = EssentialOCLUtils.getPivotingChildCS(csPivoted);
			MonikeredElementCS csParent = EssentialOCLUtils.getPivotingParentCS(csChild);
			MonikeredElementCS csPivotedParent = EssentialOCLUtils.getPivotedCS(csParent);
			VariableDeclaration implicitSource = getImplicitSource(csPivotedParent, feature);
			VariableExp sourceAccess = PivotFactory.eINSTANCE.createVariableExp();
			sourceAccess.setReferredVariable(implicitSource);
			context.setType(sourceAccess, implicitSource.getType());
			sourceAccess.setImplicit(true);
			source = sourceAccess;
		}
		Type actualSourceType = source.getType();
		if (isCollectionNavigation && !(actualSourceType instanceof CollectionType)) {
			OperationCallExp expression = context.refreshMonikeredElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
			expression.setImplicit(true);
			expression.setSource(source);
			expression.setName("oclAsSet");
			resolveOperationCall(expression, csOperator, new ImplicitCollectionFilter(typeManager, actualSourceType));
			source = expression;
		}
		return source;
	}

	protected OclExpression resolveOperation(NavigatingExpCS csNavigatingExp) {
		NamedExpCS csNamedExp = csNavigatingExp.getNamedExp();
		//
		//	Need to resolve types for operation arguments in order to disambiguate
		//	operation names. No need to resolve iteration arguments since for those
		//	we only need to count iterators.
		//
		resolveOperationArgumentTypes(csNavigatingExp);
		resolveIterationExplicitAccumulators(csNavigatingExp);
		//
		//	Resolve the static operation/iteration by name and known operation argument types.
		//
		NamedElement namedElement = csNamedExp.getNamedElement();
		if (namedElement.eIsProxy()) {
//			return context.addBadProxyError(EssentialOCLCSTPackage.Literals.NAME_EXP_CS__ELEMENT, csNamedExp);
			namedElement = getBadOperation();
		}
		if ((namedElement == null) || namedElement.eIsProxy()) {
			OperationCallExp operationCallExp = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNamedExp);
			context.setReferredOperation(operationCallExp, null);
			context.reusePivotElement(csNavigatingExp, operationCallExp);		
			context.setType(operationCallExp, typeManager.getOclInvalidType());
			return operationCallExp;
		}
		else if (namedElement instanceof Operation) {
			Operation operation = (Operation)namedElement;
			OclExpression source = resolveNavigationSource(csNavigatingExp, operation);
			CallExp expression;
			CallExp callExp;
			if (operation instanceof Iteration) {
				Iteration iteration = (Iteration)operation;
				callExp = resolveIterationCall(csNavigatingExp, source, iteration);
				expression = resolveNavigationFeature(csNavigatingExp, source, operation, callExp);
				resolveIterationBody(csNavigatingExp, (LoopExp)callExp);
			}
			else {
				OperationCallExp operationCallExp = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNamedExp);
				context.setReferredOperation(operationCallExp, operation);
				context.reusePivotElement(csNavigatingExp, operationCallExp);		
				callExp = operationCallExp;
				expression = resolveNavigationFeature(csNavigatingExp, source, operation, callExp);
				resolveOperationArguments(csNavigatingExp, source, operation, operationCallExp);
			}
			resolveOperationReturnType(callExp);
			if (expression != callExp) {
				resolveOperationReturnType(expression);
			}
			return checkImplementation(csNavigatingExp, operation, callExp, expression);
		}
		else {
			return context.addBadExpressionError(csNamedExp, "Operation name expected");
		}
	}

	/**
	 * Determine the type of each operation argument so that the appropriate operation overload can be selected.
	 * Iterator bodies are left unresolved.
	 */
	protected void resolveOperationArgumentTypes(NavigatingExpCS csNavigatingExp) {
		for (NavigatingArgCS csArgument : csNavigatingExp.getArgument()) {
			if (csArgument.getRole() == NavigationRole.ITERATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
				break;
			}
			else if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				OclExpression arg = context.visitLeft2Right(OclExpression.class, csArgument.getName());
				if (arg != null) {
					context.installPivotElement(csArgument, arg);
				}
			}
		}
	}

	/**
	 * Complete the installation of each operation argument in its operation call.
	 */
	protected void resolveOperationArguments(NavigatingExpCS csNavigatingExp,
			OclExpression source, Operation operation, OperationCallExp expression) {
		List<OclExpression> pivotArguments = new ArrayList<OclExpression>();
		List<NavigatingArgCS> csArguments = csNavigatingExp.getArgument();
		List<Parameter> ownedParameters = operation.getOwnedParameters();
		int parametersCount = ownedParameters.size();
		int csArgumentCount = csArguments.size();
		if (csArgumentCount > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addDiagnostic(csNavigatingExp, "Operation calls can only specify expressions");			
			}
			for (int argIndex = 0; argIndex < csArgumentCount; argIndex++) {
				NavigatingArgCS csArgument = csArguments.get(argIndex);
				if (csArgument.getInit() != null) {
					context.addDiagnostic(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addDiagnostic(csArgument, "Unexpected type for expression");
				}
				OclExpression arg = PivotUtil.getPivot(OclExpression.class, csArgument);
				if (arg != null) {
					pivotArguments.add(arg);
				}
			}
		}
		if ((csArgumentCount != parametersCount) && (operation != getBadOperation())) {
			String boundMessage = NLS.bind(OCLMessages.MismatchedArgumentCount_ERROR_, csArgumentCount, parametersCount);
			context.addDiagnostic(csNavigatingExp, boundMessage);			
		}
		context.refreshList(expression.getArguments(), pivotArguments);
	}

	protected void resolveOperationCall(OperationCallExp expression, OperatorCS csOperator, EnvironmentView.Filter filter) {
		EnvironmentView environmentView = new EnvironmentView(typeManager, PivotPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION, expression.getName());
		environmentView.addFilter(filter);
		Type sourceType = expression.getSource().getType();
		int size = 0;
		if (sourceType != null) {
			size = environmentView.computeLookups(sourceType);
		}
		if (size == 1) {
			Operation operation = (Operation)environmentView.getContent();
			context.setReferredOperation(expression, operation);
			resolveOperationReturnType(expression);
		}
		else {
			StringBuffer s = new StringBuffer();
			for (OclExpression argument : expression.getArguments()) {
				Type argumentType = argument.getType();
				if (s.length() > 0) {
					s.append(",");
				}
				if (argumentType != null) {
					s.append(argumentType.toString());
				}
			}
			String boundMessage;
			if (s.length() > 0) {
				boundMessage = NLS.bind(OCLMessages.UnresolvedOperationCall_ERROR_, new Object[]{csOperator, sourceType, s.toString()});
			}
			else {
				boundMessage = NLS.bind(OCLMessages.UnresolvedOperation_ERROR_, new Object[]{csOperator, sourceType});
			}
//			context.addBadExpressionError(csOperator, boundMessage);
			context.addDiagnostic(csOperator, boundMessage);
			Operation badOperation = getBadOperation();
			context.setReferredOperation(expression, badOperation);
			context.setType(expression, typeManager.getOclInvalidType());
		}
	}

	protected void resolveOperationReturnType(CallExp callExp) {
		Operation operation = null;
		if (callExp instanceof OperationCallExp) {
			operation = ((OperationCallExp)callExp).getReferredOperation();
		}
		else if (callExp instanceof LoopExp) {
			operation = ((LoopExp)callExp).getReferredIteration();
		}
		if (operation == null) {
			return;
		}
		Map<TemplateParameter, ParameterableElement> templateBindings = new HashMap<TemplateParameter, ParameterableElement>();
		Type sourceType = null;
		OclExpression source = callExp.getSource();
		if (source != null) {
			sourceType = source.getType();
		}
		if (sourceType != null) {
			if (operation.isStatic() && (sourceType instanceof ClassifierType)) {
				sourceType = ((ClassifierType)sourceType).getInstanceType();
			}
			templateBindings.put(null, sourceType);		// Use the null key to pass OclSelf without creating an object
		}
		PivotUtil.getAllTemplateParameterSubstitutions(templateBindings, sourceType);
//		PivotUtil.getAllTemplateParameterSubstitutions(templateBindings, operation);
		TemplateSignature templateSignature = operation.getOwnedTemplateSignature();
		if (templateSignature != null) {
			for (TemplateParameter templateParameter : templateSignature.getOwnedParameters()) {
				templateBindings.put(templateParameter, null);
			}
		}
		@SuppressWarnings("unused")		// Should never happen; just for debugging
		boolean isConformant = true;
		if (callExp instanceof OperationCallExp) {
			List<Parameter> parameters = operation.getOwnedParameters();
			List<OclExpression> arguments = ((OperationCallExp)callExp).getArguments();
			int iMax = Math.min(parameters.size(), arguments.size());
			for (int i = 0; i < iMax; i++) {
				Parameter parameter = parameters.get(i);
				OclExpression argument = arguments.get(i);
				if ((parameter != null) && (argument != null)) {
					Type parameterType = PivotUtil.getBehavioralType(typeManager.getTypeWithMultiplicity(parameter));
					Type argumentType = PivotUtil.getBehavioralType(argument.getType());
					if (!typeManager.conformsTo(argumentType, parameterType, templateBindings)) {
						isConformant = false;
					}
				}
			}
		}
		else if (callExp instanceof LoopExp) {
			if (callExp instanceof IterateExp) {
				List<Parameter> accumulators = ((Iteration)operation).getOwnedAccumulators();
				if (accumulators.size() >= 1) {
					Parameter accumulator = accumulators.get(0);
					Variable result = ((IterateExp)callExp).getResult();
					if ((accumulator != null) && (result != null)) {
						Type accumulatorType = PivotUtil.getBehavioralType(accumulator.getType());
						Type resultType = PivotUtil.getBehavioralType(result.getType());
						if (!typeManager.conformsTo(resultType, accumulatorType, templateBindings)) {
							isConformant = false;
						}
					}
				}
			}
			List<Parameter> parameters = ((Iteration)operation).getOwnedParameters();
			if (parameters.size() >= 1) {
				Parameter parameter = parameters.get(0);
				OclExpression body = ((LoopExp)callExp).getBody();
				if ((parameter != null) && (body != null)) {
					Type parameterType = parameter.getType();
					if (parameterType instanceof LambdaType) {		// Should always be a LambdaType
						parameterType = ((LambdaType)parameterType).getResultType();
					}
					Type bodyType = PivotUtil.getBehavioralType(body.getType());
					if (!typeManager.conformsTo(bodyType, parameterType, templateBindings)) {
						isConformant = false;
					}
				}
			}
		}
		Type returnType = typeManager.getSpecializedType(typeManager.getTypeWithMultiplicity(operation), templateBindings);
		context.setType(callExp, returnType);
	}

	protected OclExpression resolvePropertyCallExp(NamedExpCS csNameExp, Property property) {
		OclExpression source = resolveNavigationSource(csNameExp, property);
		PropertyCallExp expression = context.refreshExpression(PropertyCallExp.class, PivotPackage.Literals.PROPERTY_CALL_EXP, csNameExp);
		expression.setReferredProperty(property);
		context.setTypeWithMultiplicity(expression, property);		// FIXME resolve template parameter		
		OclExpression navigationExpression = resolveNavigationFeature(csNameExp, source, property, expression);
		return navigationExpression;
	}

	protected OclExpression resolvePropertyNavigation(NamedExpCS csNamedExp) {
		NamedElement namedElement = csNamedExp.getNamedElement();
		if (namedElement.eIsProxy()) {
//			String boundMessage = NLS.bind(OCLMessages.UnresolvedProperty_ERROR_, csNamedExp, PivotConstants.UNKNOWN_TYPE_TEXT);
//			return context.addBadExpressionError(csNamedExp, boundMessage);
			namedElement = getBadProperty();
		}
		if ((namedElement == null) || namedElement.eIsProxy()) {
			PropertyCallExp expression = context.refreshExpression(PropertyCallExp.class, PivotPackage.Literals.PROPERTY_CALL_EXP, csNamedExp);
			expression.setReferredProperty(null);
//			context.reusePivotElement(csNavigatingExp, operationCallExp);		
			context.setType(expression, typeManager.getOclInvalidType());
			return expression;
		}
		else if (namedElement instanceof Property) {
			return resolvePropertyCallExp(csNamedExp, (Property)namedElement);
		}
		else {
			return context.addBadExpressionError(csNamedExp, "Property name expected");
		}
	}

	protected TypeExp resolveTypeExp(ExpCS csExp, Type type) {
		TypeExp expression = context.refreshExpression(TypeExp.class, PivotPackage.Literals.TYPE_EXP, csExp);
		context.setType(expression, typeManager.getClassifierType(type));
		expression.setReferredType(type);
		return expression;
	}

	protected VariableExp resolveVariableExp(NameExpCS csNameExp, VariableDeclaration variableDeclaration) {
		VariableExp expression = context.refreshExpression(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csNameExp);
		expression.setReferredVariable(variableDeclaration);
		context.setType(expression, variableDeclaration.getType());
		return expression;
	}
	  
	@Override
	public MonikeredElement visitBinaryOperatorCS(BinaryOperatorCS csOperator) {
		OclExpression source = context.visitLeft2Right(OclExpression.class, csOperator.getSource());
		OperationCallExp expression = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
		context.refreshName(expression, csOperator.getName());
		expression.setSource(source);
		OclExpression argument = context.visitLeft2Right(OclExpression.class, csOperator.getArgument());
		context.refreshList(expression.getArguments(), Collections.singletonList(argument));
		resolveOperationCall(expression, csOperator, new BinaryOperationFilter(typeManager, source.getType(), argument.getType()));
		return expression;
	}

	@Override
	public MonikeredElement visitBooleanLiteralExpCS(BooleanLiteralExpCS csBooleanLiteralExp) {
		BooleanLiteralExp expression = context.refreshExpression(BooleanLiteralExp.class, PivotPackage.Literals.BOOLEAN_LITERAL_EXP, csBooleanLiteralExp);
		expression.setBooleanSymbol(Boolean.valueOf(csBooleanLiteralExp.getName()));
		context.setType(expression, typeManager.getBooleanType());
		return expression;
	}

	@Override
	public MonikeredElement visitCollectionLiteralExpCS(CollectionLiteralExpCS csCollectionLiteralExp) {
		Type commonType = null;
//		InvalidLiteralExp invalidValue = null;
		for (CollectionLiteralPartCS csPart : csCollectionLiteralExp.getOwnedParts()) {
			CollectionLiteralPart pivotPart = context.visitLeft2Right(CollectionLiteralPart.class, csPart);
			Type type = pivotPart.getType();
//			if (type instanceof InvalidType) {	// FIXME Use propagated reason via InvalidType
//				if (invalidValue == null) {
//					invalidValue = typeManager.createInvalidValue(csPart, null, "Invalid Collection content", null);
//				}
//			}
//			else
			if (commonType == null) {
				commonType = type;
			}
			else {
				commonType = typeManager.getCommonType(commonType, type);
			}
		}
//		if (invalidValue != null) {
//			context.installPivotElement(csCollectionLiteralExp, invalidValue);
//			return invalidValue;
//		}
		CollectionLiteralExp expression = context.refreshExpression(CollectionLiteralExp.class, PivotPackage.Literals.COLLECTION_LITERAL_EXP, csCollectionLiteralExp);
		context.refreshPivotList(CollectionLiteralPart.class, expression.getParts(), csCollectionLiteralExp.getOwnedParts());
		CollectionTypeCS ownedCollectionType = csCollectionLiteralExp.getOwnedType();
		String collectionTypeName = ownedCollectionType.getName();
		TypedRefCS ownedElementType = ownedCollectionType.getOwnedType();
		if (ownedElementType != null) {
			commonType = (Type) ownedElementType.getPivot();
		}
		if (commonType == null) {
			commonType = typeManager.createUnspecifiedType();
		}
		Type type = typeManager.getLibraryType(collectionTypeName, Collections.singletonList(commonType));
		context.setType(expression, type);
		expression.setKind(PivotUtil.getCollectionKind((CollectionType) type));
		return expression;
	}

	@Override
	public MonikeredElement visitCollectionLiteralPartCS(CollectionLiteralPartCS csCollectionLiteralPart) {
		ExpCS csFirst = csCollectionLiteralPart.getExpressionCS();
		OclExpression pivotFirst = context.visitLeft2Right(OclExpression.class, csFirst);
		ExpCS csLast = csCollectionLiteralPart.getLastExpressionCS();
		if (csLast == null) {
			CollectionItem expression = context.refreshMonikeredElement(CollectionItem.class, PivotPackage.Literals.COLLECTION_ITEM, csCollectionLiteralPart);	
			context.installPivotElement(csCollectionLiteralPart, expression);
			expression.setItem(pivotFirst);
		}
		else {
			CollectionRange expression = context.refreshMonikeredElement(CollectionRange.class, PivotPackage.Literals.COLLECTION_RANGE, csCollectionLiteralPart);
			context.installPivotElement(csCollectionLiteralPart, expression);
			expression.setFirst(pivotFirst);
			OclExpression pivotLast = context.visitLeft2Right(OclExpression.class, csLast);
			expression.setLast(pivotLast);
		}
		Type type = pivotFirst.getType();
		if (csLast != null) {
			OclExpression pivotLast = PivotUtil.getPivot(OclExpression.class, csLast);
			Type secondType = pivotLast.getType();
			type = typeManager.getCommonType(type, secondType);
		}
		CollectionLiteralPart expression = PivotUtil.getPivot(CollectionLiteralPart.class, csCollectionLiteralPart);
		context.setType(expression, type);
		return expression;
	}

	@Override
	public MonikeredElement visitCollectionTypeCS(CollectionTypeCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitContextCS(ContextCS csContext) {
		NamedElement specificationContext = null;
		Resource resource = csContext.eResource();
		if (resource instanceof EvaluationContext) {	
			specificationContext = ((EvaluationContext)resource).getSpecificationContext();
		}
		ExpressionInOcl pivotElement;
		if (specificationContext instanceof ExpressionInOcl) {
			pivotElement = (ExpressionInOcl) specificationContext;			
			context.installPivotElement(csContext, pivotElement);
			ExpCS csExpression = csContext.getOwnedExpression();
			OclExpression expression = context.visitLeft2Right(OclExpression.class, csExpression);
			if (expression != null) {
				if (pivotElement.getBodyExpression() == null) {
					pivotElement.setBodyExpression(expression);
					context.setType(pivotElement, expression.getType());
				}
				else {
					pivotElement.setMessageExpression(expression);
				}
//				context.setType(pivotElement, expression.getType());
			}
		}
		else {
			pivotElement = context.refreshMonikeredElement(ExpressionInOcl.class,
				PivotPackage.Literals.EXPRESSION_IN_OCL, csContext);
			Variable contextVariable = pivotElement.getContextVariable();
			if (contextVariable == null) {
				contextVariable = PivotFactory.eINSTANCE.createVariable();
			}
			Type contextType;
			if (specificationContext instanceof Type) {
				contextType = (Type) specificationContext;
			}
			else if (specificationContext instanceof Feature) {
				contextType = PivotUtil.getFeaturingClass((Feature)specificationContext);
				if (specificationContext instanceof Operation) {
					context.setType(contextVariable, contextType);
			        for (Parameter parameter : ((Operation)specificationContext).getOwnedParameters()) {
				        Variable param = PivotFactory.eINSTANCE.createVariable();
				        param.setName(parameter.getName());
						context.setTypeWithMultiplicity(param, parameter);
				        param.setRepresentedParameter(parameter);
				        pivotElement.getParameterVariables().add(param);
			        }					
				}
			}
			else {
				contextType = typeManager.getOclInvalidType();
			}
			context.setType(contextVariable, contextType);

			context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
			pivotElement.setContextVariable(contextVariable);
			context.putPivotElement(contextVariable);
			
			context.installPivotElement(csContext, pivotElement);
			ExpCS csExpression = csContext.getOwnedExpression();
			OclExpression expression = context.visitLeft2Right(OclExpression.class, csExpression);
			if (expression != null) {
				pivotElement.setBodyExpression(expression);
				context.setType(pivotElement, expression.getType());
			}
		}
		return pivotElement;
	}

	@Override
	public MonikeredElement visitExpCS(ExpCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitExpSpecificationCS(ExpSpecificationCS object) {
		ExpressionInOcl pivotElement = context.refreshMonikeredElement(ExpressionInOcl.class, PivotPackage.Literals.EXPRESSION_IN_OCL, object);
		pivotElement.getLanguages().add(PivotConstants.OCL_LANGUAGE);
		pivotElement.getBodies().add(object.getExprString());
		pivotElement.getMessages().add(null);
		OclExpression expression = context.visitLeft2Right(OclExpression.class, object.getOwnedExpression());
		pivotElement.setBodyExpression(expression);
		return pivotElement;
	}

	@Override
	public MonikeredElement visitIfExpCS(IfExpCS csIfExp) {
		IfExp expression = context.refreshExpression(IfExp.class, PivotPackage.Literals.IF_EXP, csIfExp);
		expression.setCondition(context.visitLeft2Right(OclExpression.class, csIfExp.getCondition()));
		OclExpression thenExpression = context.visitLeft2Right(OclExpression.class, csIfExp.getThenExpression());
		expression.setThenExpression(thenExpression);
		OclExpression elseExpression = context.visitLeft2Right(OclExpression.class, csIfExp.getElseExpression());
		expression.setElseExpression(elseExpression);
		context.setType(expression, typeManager.getCommonType(thenExpression.getType(), elseExpression.getType()));
		return expression;
	}

	@Override
	public MonikeredElement visitIndexExpCS(IndexExpCS csIndexExp) {
		// Navigating completions are orchestrated by the SimpleNamedExpCS.
		return null;
	}

	@Override
	public MonikeredElement visitInfixExpCS(InfixExpCS csInfixExp) {
		//
		//	Find the root.
		//
		OperatorCS csRoot = csInfixExp.getOwnedOperator().get(0);
		for (OperatorCS csParent = csRoot.getParent(); csParent != null; csParent = csParent.getParent()) {
			csRoot = csParent;
		}
		//
		//	Build the corresponding AST and reuse as the Infix node.
		//
		OclExpression pivot = context.visitLeft2Right(OclExpression.class, csRoot);		
		context.reusePivotElement(csInfixExp, pivot);
		return pivot;
	}

	@Override
	public MonikeredElement visitInvalidLiteralExpCS(InvalidLiteralExpCS csInvalidLiteralExp) {
		InvalidLiteralExp expression = PivotUtil.getPivot(InvalidLiteralExp.class, csInvalidLiteralExp);
		if (expression == null) {
			expression = typeManager.createInvalidExpression();
		}
//		expression.setType(typeManager.getOclInvalidType());
		context.installPivotElement(csInvalidLiteralExp, expression);
		return expression;
	}

	@Override
	public MonikeredElement visitLetExpCS(LetExpCS csLetExp) {
		// Each CS Let Variable becomes a Pivot LetExpression and Variable
		// The CS Let therefore just re-uses the Pivot of the first CS Let Variable
		String letMoniker = csLetExp.getMoniker();	// FIXME ?? simplify with auxiliary tree created in PostOrder visit
		LetExp firstLetExp = null;
		LetExp lastLetExp = null;
		for (LetVariableCS csLetVariable : csLetExp.getVariable()) {
			LetExp letExp = context.refreshMonikeredElement(LetExp.class,
				PivotPackage.Literals.LET_EXP, letMoniker);
			Variable variable = context.refreshNamedElement(Variable.class,
				PivotPackage.Literals.VARIABLE, csLetVariable);
			letExp.setVariable(variable);		
			ExpCS csInitExpression = csLetVariable.getInitExpression();
			OclExpression initExpression = context.visitLeft2Right(OclExpression.class, csInitExpression);
			variable.setInitExpression(initExpression);
			Type initType = initExpression != null ? initExpression.getType() : null;
			TypedRefCS csVariableType = csLetVariable.getOwnedType();
			Type variableType = csVariableType != null ? PivotUtil.getPivot(Type.class, csVariableType) : null;
			if (variableType == null) {
				variableType = initType;
			}
			context.setType(variable, variableType);
			
			if (lastLetExp != null) {
				lastLetExp.setIn(letExp);
				context.usePivotElement(csLetExp, letExp);
			}
			else {
				firstLetExp = letExp;
				context.installPivotElement(csLetExp, firstLetExp);
			}
			lastLetExp = letExp;
			letMoniker = letMoniker + PivotConstants.MONIKER_SCOPE_SEPARATOR + "in" + PivotConstants.MONIKER_OPERATOR_SEPARATOR + PivotConstants.MONIKER_LET_EXP;
		}
		if (lastLetExp != null) {
			OclExpression in = context.visitLeft2Right(OclExpression.class, csLetExp.getIn());
			lastLetExp.setIn(in);
			Type type = in.getType();
			for (OclExpression letExp = firstLetExp; (letExp != in) && (letExp != null); letExp = ((LetExp)letExp).getIn()) {
				context.setType(letExp, type);
			}
		}
		return firstLetExp;
	}

	@Override
	public MonikeredElement visitLetVariableCS(LetVariableCS csLetVariable) {
		return null;	// Handled by parent
	}

	@Override
	public MonikeredElement visitNameExpCS(NameExpCS csNameExp) {
		EObject eContainer = csNameExp.eContainer();
		if (eContainer instanceof NavigatingExpCS) {
			EObject eContainerContainer = eContainer.eContainer();
			if (eContainerContainer instanceof NamedExpCS) {
				logger.warn("Unsupported '" + eContainerContainer.eClass().getName() + "' for () navigation");
			}
			return null;
		}
//		else if (eContainer instanceof IndexExpCS) {
//			EObject eContainerContainer = eContainer.eContainer();
//			if (eContainerContainer instanceof NamedExpCS) {
//				logger.warn("Unsupported '" + eContainerContainer.eClass().getName() + "' for [] navigation");
//			}
//			return new IndexExpCSCompletion(context, (IndexExpCS) eContainer);
//		}
		else {
			NamedElement element = csNameExp.getElement();
			if (element.eIsProxy()) {
				Element pivot = csNameExp.getPivot();
				if (pivot instanceof InvalidLiteralExp) {
					return (InvalidLiteralExp)pivot;
				}
				InvalidLiteralExp invalidLiteralExp = typeManager.createInvalidExpression();
				context.reusePivotElement(csNameExp, invalidLiteralExp);
				return invalidLiteralExp;
//				return context.addBadProxyError(EssentialOCLCSTPackage.Literals.NAME_EXP_CS__ELEMENT, csNameExp);
			}
			else if (element instanceof VariableDeclaration) {
				return resolveVariableExp(csNameExp, (VariableDeclaration)element);
			}
			else if (element instanceof Property) {
				return resolvePropertyCallExp(csNameExp, (Property) element);
			}
			else if (element instanceof Operation) {
				return context.addBadExpressionError(csNameExp, "No parameters for operation " + element.getName());
			}
			else if (element instanceof Type) {
				return resolveTypeExp(csNameExp, (Type) element);
			}
			else if (element instanceof EnumerationLiteral) {
				return resolveEnumLiteral(csNameExp, (EnumerationLiteral) element);
			}
			else {
				return context.addBadExpressionError(csNameExp, "Unsupported NameExpCS " + element.eClass().getName());		// FIXME
			}
		}
	}

	@Override
	public MonikeredElement visitNavigatingArgCS(NavigatingArgCS csNavigatingArg) {
		OclExpression pivot = PivotUtil.getPivot(OclExpression.class, csNavigatingArg.getName());
		context.installPivotElement(csNavigatingArg, pivot);
		return pivot;
	}

	@Override
	public MonikeredElement visitNavigatingExpCS(NavigatingExpCS csNavigatingExp) {
		OperatorCS csParent = csNavigatingExp.getParent();
		if ((csParent instanceof NavigationOperatorCS)
		 && (csNavigatingExp != csParent.getSource())) {
			return PivotUtil.getPivot(OclExpression.class, csNavigatingExp);
		}
		else {
			return resolveOperation(csNavigatingExp);
		}
	}

	@Override
	public OclExpression visitNavigationOperatorCS(NavigationOperatorCS csOperator) {
		@SuppressWarnings("unused")
		OclExpression sourceExp = context.visitLeft2Right(OclExpression.class, csOperator.getSource());
		OclExpression navigatingExp = null;
		ExpCS argument = csOperator.getArgument();
		if (argument instanceof NavigatingExpCS) {
			navigatingExp = resolveOperation((NavigatingExpCS) argument);
		}
		else if (argument instanceof NamedExpCS) {
			navigatingExp = resolvePropertyNavigation((NamedExpCS) argument);
		}
		context.reusePivotElement(csOperator, navigatingExp);
//		assert sourceExp.eContainer() != null; -- need to insert into invalidLiteralExp for bad navigation
		return navigatingExp;
	}

	@Override
	public MonikeredElement visitNestedExpCS(NestedExpCS csNestedExp) {
		OclExpression pivot = context.visitLeft2Right(OclExpression.class, csNestedExp.getSource());
		context.reusePivotElement(csNestedExp, pivot);
		return pivot;
	}

	@Override
	public MonikeredElement visitNullLiteralExpCS(NullLiteralExpCS csNullLiteralExp) {
		NullLiteralExp expression = context.refreshExpression(NullLiteralExp.class, PivotPackage.Literals.NULL_LITERAL_EXP, csNullLiteralExp);
		context.setType(expression, typeManager.getOclVoidType());
		return expression;
	}

	@Override
	public MonikeredElement visitNumberLiteralExpCS(NumberLiteralExpCS csNumberLiteralExp) {
		Number number = csNumberLiteralExp.getName();
		if (number instanceof BigDecimal) {
			RealLiteralExp expression = context.refreshExpression(RealLiteralExp.class, PivotPackage.Literals.REAL_LITERAL_EXP, csNumberLiteralExp);
			expression.setRealSymbol((BigDecimal) number);
			context.setType(expression, typeManager.getRealType());
			return expression;
		}
		BigInteger bigInteger = (BigInteger) number;
		if (bigInteger.signum() < 0) {
			IntegerLiteralExp expression = context.refreshExpression(IntegerLiteralExp.class, PivotPackage.Literals.INTEGER_LITERAL_EXP, csNumberLiteralExp);
			expression.setIntegerSymbol(bigInteger);
			context.setType(expression, typeManager.getIntegerType());
			return expression;
		}
		else {
			UnlimitedNaturalLiteralExp expression = context.refreshExpression(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csNumberLiteralExp);
			expression.setUnlimitedNaturalSymbol(bigInteger);
			context.setType(expression, typeManager.getUnlimitedNaturalType());
			return expression;
		}
	}

	@Override
	public MonikeredElement visitOperatorCS(OperatorCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitPrefixExpCS(PrefixExpCS csPrefixExp) {
		UnaryOperatorCS csRoot = csPrefixExp.getOwnedOperator().get(0);
		if (csPrefixExp.eContainer() instanceof InfixExpCS) {
			// PrefixExpCS embedded in InfixExpCS is resolved as part of the Infix tree;		
		}
		else {
//			initializePrefixOperators(csPrefixExp, null);
			context.visitLeft2Right(OclExpression.class, csRoot);		
		}
		OclExpression pivotElement = PivotUtil.getPivot(OclExpression.class, csRoot);
		context.reusePivotElement(csPrefixExp, pivotElement);
		return pivotElement;
	}

	@Override
	public MonikeredElement visitSelfExpCS(SelfExpCS csSelfExp) {	// FIXME Just use VariableExpCS
		VariableExp expression = context.refreshExpression(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csSelfExp);
		ScopeCSAdapter scopeAdapter = ElementUtil.getScopeCSAdapter(csSelfExp);
		EnvironmentView environmentView = new EnvironmentView(typeManager, PivotPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, Environment.SELF_VARIABLE_NAME);
		ScopeView scopeView = scopeAdapter.getOuterScopeView(typeManager, null);
		environmentView.computeLookups(scopeView);
		VariableDeclaration variableDeclaration = (VariableDeclaration) environmentView.getContent();
		expression.setReferredVariable(variableDeclaration);
		context.setType(expression, variableDeclaration != null ? variableDeclaration.getType() : typeManager.getOclVoidType());
		return expression;
	}

	@Override
	public MonikeredElement visitStringLiteralExpCS(StringLiteralExpCS csStringLiteralExp) {
		StringLiteralExp expression = context.refreshExpression(StringLiteralExp.class, PivotPackage.Literals.STRING_LITERAL_EXP, csStringLiteralExp);
		List<String> names = csStringLiteralExp.getName();
		if (names.size() == 0) {
			expression.setStringSymbol("");
		}
		else if (names.size() == 1) {
			expression.setStringSymbol(names.get(0));
		}
		else {
			StringBuffer s = new StringBuffer();
			for (String name : names) {
				s.append(name);
			}
			expression.setStringSymbol(s.toString());
		}
		context.setType(expression, typeManager.getStringType());
		return expression;
	}

	@Override
	public MonikeredElement visitTupleLiteralExpCS(TupleLiteralExpCS csTupleLiteralExp) {
		TupleLiteralExp expression = context.refreshExpression(TupleLiteralExp.class, PivotPackage.Literals.TUPLE_LITERAL_EXP, csTupleLiteralExp);	
		for (TupleLiteralPartCS csPart : csTupleLiteralExp.getOwnedParts()) {
			@SuppressWarnings("unused")
			TupleLiteralPart pivotPart = context.visitLeft2Right(TupleLiteralPart.class, csPart);
		}
		context.refreshPivotList(TupleLiteralPart.class, expression.getParts(), csTupleLiteralExp.getOwnedParts());
		String tupleTypeName = "Tuple"; //ownedCollectionType.getName();
		Type type = typeManager.getTupleType(tupleTypeName, expression.getParts(), null, null);
		context.setType(expression, type);
		return expression;
	}

	@Override
	public MonikeredElement visitTupleLiteralPartCS(TupleLiteralPartCS csTupleLiteralPart) {
		TupleLiteralPart pivotElement = context.refreshNamedElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csTupleLiteralPart);	
		OclExpression initExpression = context.visitLeft2Right(OclExpression.class, csTupleLiteralPart.getInitExpression());
		pivotElement.setInitExpression(initExpression);
		TypedRefCS csType = csTupleLiteralPart.getOwnedType();
		Type type = csType != null ? PivotUtil.getPivot(Type.class, csType) : initExpression.getType();
		context.setType(pivotElement, type);
		return pivotElement;
	}

	@Override
	public MonikeredElement visitTypeLiteralExpCS(TypeLiteralExpCS csTypeLiteralExp) {
		TypedRefCS csType = csTypeLiteralExp.getOwnedType();
//		context.visitInOrder(csType, null);
		Type type = PivotUtil.getPivot(Type.class, csType);
		return resolveTypeExp(csTypeLiteralExp, type);
	}

	@Override
	public MonikeredElement visitUnaryOperatorCS(UnaryOperatorCS csOperator) {
		OclExpression source = context.visitLeft2Right(OclExpression.class, csOperator.getSource());
		OperationCallExp expression = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
		context.refreshName(expression, csOperator.getName());
		expression.setSource(source);
		resolveOperationCall(expression, csOperator, new UnaryOperationFilter(typeManager, source.getType()));
		return expression;
	}

	@Override
	public MonikeredElement visitUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS csUnlimitedNaturalLiteralExp) {
		UnlimitedNaturalLiteralExp expression = context.refreshExpression(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csUnlimitedNaturalLiteralExp);
		expression.setName("*");
		context.setType(expression, typeManager.getUnlimitedNaturalType());
		expression.setUnlimitedNaturalSymbol(BigInteger.valueOf(-1));
		return expression;
	}

	@Override
	public MonikeredElement visitVariableCS(VariableCS csVariable) {
		Variable variable = context.refreshNamedElement(Variable.class,
			PivotPackage.Literals.VARIABLE, csVariable);
		OclExpression initExpression = PivotUtil.getPivot(OclExpression.class, csVariable.getInitExpression());
		TypedRefCS csType = csVariable.getOwnedType();
		Type type;
		if (csType != null) {
			type = PivotUtil.getPivot(Type.class, csType);
		}
		else {
			type = initExpression.getType();
			// FIXME deduction is more complex that this
		}
		variable.setInitExpression(initExpression);
		context.setType(variable, type);
		return variable;
	}	
}