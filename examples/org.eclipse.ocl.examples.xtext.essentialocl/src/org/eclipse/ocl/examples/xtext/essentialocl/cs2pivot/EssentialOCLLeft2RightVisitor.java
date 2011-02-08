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
 * $Id: EssentialOCLLeft2RightVisitor.java,v 1.4 2011/02/08 17:44:57 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.AssociativityKind;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
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
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil.PrecedenceComparator;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
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
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS;
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
import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLUtils;
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

	/**
	 * Establish the parent-{source,argument} relationships between all infix
	 * operators in accordance with the precedence and associativity configuration.
	 */
	protected void createInfixOperatorTree(InfixExpCS csInfix) {
		//
		//	Create the per-precedence list of operator indexes, and a
		//	highest precedence first list of all used infix precedences.
		//
		Map<Precedence, List<Integer>> precedenceToOperatorIndexes = createInfixPrecedenceToOperatorIndexesMap(csInfix);
		List<Precedence> sortedPrecedences = new ArrayList<Precedence>(precedenceToOperatorIndexes.keySet());
		Collections.sort(sortedPrecedences, PrecedenceComparator.INSTANCE);
		//
		//	Build the tree leaf-to root precedence at a time.
		//
		List<ExpCS> csExpressions = csInfix.getOwnedExpression();
		List<BinaryOperatorCS> csOperators = csInfix.getOwnedOperator();
		for (Precedence precedence : sortedPrecedences) {
			// null precedence arises when precedence or operation-to-precedence is wrong
			boolean isLeft = precedence == null || (precedence.getAssociativity() == AssociativityKind.LEFT);
			List<Integer> operatorIndexes = precedenceToOperatorIndexes.get(precedence);
			int operatorCount = operatorIndexes.size();
			int iFirst = isLeft ? 0 : operatorCount-1;
			int iIndex = isLeft ? 1 : -1;
			int iLast = isLeft ? operatorCount : -1;
			for (int i = iFirst; i != iLast; i += iIndex) {
				int operatorIndex = operatorIndexes.get(i);
				BinaryOperatorCS csOperator = csOperators.get(operatorIndex);
				//
				//	Establish parent-child relationship of operator source
				//
				ExpCS csSource = csExpressions.get(operatorIndex);
				while ((csSource.getParent() != null) && (csSource.getParent() != csOperator)) {
					csSource = csSource.getParent();
				}
				setSource(csOperator, csSource);
				//
				//	Establish parent-child relationship of operator argument
				//
				ExpCS csArgument = csExpressions.get(operatorIndex+1);
				while ((csArgument.getParent() != null) && (csArgument.getParent() != csOperator)) {
					csArgument = csArgument.getParent();
				}
				setArgument(csOperator, csArgument);
			}
		}
	}

	/**
	 * Return a map of operator indexes for each used precedence.
	 */
	protected Map<Precedence, List<Integer>> createInfixPrecedenceToOperatorIndexesMap(InfixExpCS csInfix) {
		List<BinaryOperatorCS> csOperators = csInfix.getOwnedOperator();
		int operatorCount = csOperators.size();
		Map<Precedence, List<Integer>> precedenceToOperatorIndex = new HashMap<Precedence, List<Integer>>();
		for (int operatorIndex = 0; operatorIndex < operatorCount; operatorIndex++) {
			BinaryOperatorCS csOperator = csOperators.get(operatorIndex);
			Precedence precedence = typeManager.getInfixPrecedence(csOperator.getName());
			List<Integer> indexesList = precedenceToOperatorIndex.get(precedence);
			if (indexesList == null) {
				indexesList = new ArrayList<Integer>();
				precedenceToOperatorIndex.put(precedence, indexesList);
			}
			indexesList.add(operatorIndex);
		}
		return precedenceToOperatorIndex;
	}

	private TemplateParameterSubstitution findFormalParameter(TemplateParameter formalTemplateParameter, Type actualType) {
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
	}

	private TemplateParameter getFormal(List<TemplateBinding> templateBindings, TemplateParameter templateParameter) {
		for (TemplateBinding templateBinding : templateBindings) {
			for (TemplateParameterSubstitution templateParameterSubstitution : templateBinding.getParameterSubstitutions()) {
				if (templateParameter == templateParameterSubstitution.getFormal()) {
					return templateParameterSubstitution.getActual().getOwningTemplateParameter();
				}
			}
		}
		return null;
	}

	protected VariableDeclaration getImplicitSource(ModelElementCS csExp, NamedElement namedElement) {
		EObject eContainer = csExp.eContainer();
		if (eContainer instanceof NavigatingExpCS) {
			EReference eContainmentFeature = csExp.eContainmentFeature();
			if ((eContainmentFeature == EssentialOCLCSTPackage.Literals.DECORATED_NAMED_EXP_CS__NAMED_EXP)
			 || (eContainmentFeature == EssentialOCLCSTPackage.Literals.NAVIGATING_EXP_CS__ARGUMENT)) {
				if (namedElement instanceof Feature) {
					Type namedElementType = PivotUtil.getFeaturingClass((Feature)namedElement);
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
		}
		else if (csExp instanceof ContextCS) {
			ContextCS csContext = (ContextCS) csExp;
			ExpressionInOcl pivotElement = PivotUtil.getPivot(ExpressionInOcl.class, csContext);
			return pivotElement.getContextVariable();
		}
		else if (csExp instanceof ConstraintCS) {
			ConstraintCS csContext = (ConstraintCS) csExp;
			Constraint constraint = PivotUtil.getPivot(Constraint.class, csContext);
			ExpressionInOcl pivotElement = (ExpressionInOcl) constraint.getSpecification();
			return pivotElement.getContextVariable();
		}
		if (eContainer instanceof ContextCS) {
			return getImplicitSource((ModelElementCS) eContainer, namedElement);
		}
		else if (eContainer instanceof ConstraintCS) {
			return getImplicitSource((ModelElementCS) eContainer, namedElement);
		}
		else if (eContainer instanceof ExpCS) {
			return getImplicitSource((ModelElementCS) eContainer, namedElement);
		}
		else if (eContainer instanceof NavigatingArgCS) {
			return getImplicitSource((ModelElementCS) eContainer, namedElement);
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

	protected void initializePrefixOperators(PrefixExpCS prefixExpCS, OperatorCS csParent) {
		prefixExpCS.setParent(null);		// FIXME asymmetric
		for (UnaryOperatorCS csUnaryOperator : prefixExpCS.getOwnedOperator()) {
			if (csParent instanceof UnaryOperatorCS) {
				setSource(csParent, csUnaryOperator);
			}
			else if (csParent instanceof BinaryOperatorCS) {
				if (csParent.getSource() == prefixExpCS) {
					setSource(csParent, csUnaryOperator);
				}
				else {
					setArgument((BinaryOperatorCS) csParent, csUnaryOperator);
				}
			}
			ExpCS csChild = prefixExpCS.getOwnedExpression();
			setSource(csUnaryOperator, csChild);
			csParent = csUnaryOperator;
		}
	}

	protected void interleavePrefixes(InfixExpCS csElement) {
		for (ExpCS csExp : csElement.getOwnedExpression()) {
			if (csExp instanceof PrefixExpCS) {
				PrefixExpCS prefixExpCS = (PrefixExpCS)csExp;
				OperatorCS csExpressionParent = prefixExpCS.getParent();
				initializePrefixOperators(prefixExpCS, csExpressionParent);			
				for (UnaryOperatorCS csUnaryOperator : prefixExpCS.getOwnedOperator()) {
					interleaveUnaryOperator(csUnaryOperator);
				}			
			}
		}
	}
	
	protected void interleaveUnaryOperator(UnaryOperatorCS csOperator) {
		while (true) {
			OperatorCS csParent = csOperator.getParent();
			if (!(csParent instanceof BinaryOperatorCS)) {
				break;
			}
			Precedence parentPrecedence = typeManager.getInfixPrecedence(csParent.getName());
			Precedence unaryPrecedence = typeManager.getPrefixPrecedence(csOperator.getName());
			if ((parentPrecedence != null) && (parentPrecedence.getOrder().compareTo(unaryPrecedence.getOrder()) >= 0)) {
				break;
			}
			OperatorCS csGrandParent = csParent.getParent();
			ExpCS csExp = csOperator.getSource();
			if (csOperator == csParent.getSource()) {
				setSource(csParent, null);			// Avoid a transient loop
				if (csGrandParent instanceof BinaryOperatorCS) {
					if (csGrandParent.getSource() == csParent) {
						setSource(csGrandParent, csOperator);
					}
					else {
						setArgument((BinaryOperatorCS) csGrandParent, csOperator);
					}
				}
//				else if (csGrandParent == null) {
//					setSource(null, csOperator);
//				}
				setSource(csOperator, csParent);
				setSource(csParent, csExp);
			}
			else if (csOperator == ((BinaryOperatorCS) csParent).getArgument()) {
				if (csGrandParent instanceof BinaryOperatorCS) {
					if (csGrandParent.getSource() == csParent) {
						setSource(csOperator, null);			// Avoid a transient loop
						setSource(csGrandParent, csExp);		
						setSource(csOperator, csGrandParent);
					}
				}
			}
			else {
				break;
			}
		}
	}

	/**
	 * Following the assignment of csElement's pivot, perform an ascent to resolve as
	 * many outstanding binary operator arguments as possible.
	 */
	protected void resolveBinaryOperationArguments(BinaryOperatorCS csOperator, ExpCS csElement) {
		if (csElement instanceof PrefixExpCS) {
			csElement = ((PrefixExpCS)csElement).getOwnedOperator().get(0);
		}
		for (OperatorCS csParent = csOperator;
				(csParent instanceof BinaryOperatorCS)
			 && (((BinaryOperatorCS)csParent).getArgument() == csElement);
				csElement = csElement.getParent(), csParent = csElement.getParent()) {
			OclExpression expression = PivotUtil.getPivot(OclExpression.class, csParent);
			if ((expression instanceof OperationCallExp) && (expression.getType() == null)) {		// FIXME Avoid the need to bypass NavigationOperator reresolution
				OperationCallExp operationCallExp = (OperationCallExp)expression;
				OclExpression arg = PivotUtil.getPivot(OclExpression.class, csElement);
				context.refreshList(operationCallExp.getArguments(), Collections.singletonList(arg));
				Operation operation = context.resolveOperationCall(csParent, operationCallExp);
				if (operation != null) {
					context.setType(operationCallExp, operation.getType());
				}
			}
		}
	}

	protected EnumLiteralExp resolveEnumLiteral(ExpCS csExp, EnumerationLiteral enumerationLiteral) {
		EnumLiteralExp expression = context.refreshExpression(EnumLiteralExp.class, PivotPackage.Literals.ENUM_LITERAL_EXP, csExp);
		context.setType(expression, enumerationLiteral.getEnumeration());
		expression.setReferredEnumLiteral(enumerationLiteral);
		return expression;
	}

	/**
	 * Build an expression tree top down, left to right.
	 */
	protected void resolveExpression(ExpCS csExp) {
		if (csExp instanceof NavigationOperatorCS) {
			NavigationOperatorCS csOperator = (NavigationOperatorCS)csExp;
			resolveExpression(csOperator.getSource());
			context.refreshExpTree(OclExpression.class, csOperator);
			// FIXME polymorphise wrt BinaryOperator
			resolveBinaryOperationArguments(csOperator, csOperator.getArgument());
		}
		else if (csExp instanceof BinaryOperatorCS) {
			BinaryOperatorCS csOperator = (BinaryOperatorCS)csExp;
			resolveExpression(csOperator.getSource());
			context.refreshExpTree(OclExpression.class, csOperator);
			ExpCS csArgument = csOperator.getArgument();
			resolveExpression(csArgument);
			resolveBinaryOperationArguments(csOperator, csArgument);
		}
		else if (csExp instanceof UnaryOperatorCS) {
			UnaryOperatorCS csOperator = (UnaryOperatorCS)csExp;
			resolveExpression(csOperator.getSource());
			context.refreshExpTree(OclExpression.class, csOperator);
		}
		else {
			context.refreshExpTree(OclExpression.class, csExp);
		}
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
				context.addBadExpressionError(csArgument, "Missing initializer for accumulator");
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
				context.addBadExpressionError(csNavigatingExp, "Iterate calls cannot have more than one accumulator");			
			}
			else {
				iterateExp.setResult(pivotAccumulators.get(0));
			}
		}
		else if (pivotAccumulators.size() > 0) {
			context.addBadExpressionError(csNavigatingExp, "Iteration calls cannot have an accumulator");			
		}
	}

	protected void resolveIterationBody(NavigatingExpCS csNavigatingExp, LoopExp expression) {
		List<OclExpression> pivotBodies = new ArrayList<OclExpression>();
		//
		//	Explicit body
		//
		for (NavigatingArgCS csArgument : csNavigatingExp.getArgument()) {
			if (csArgument.getRole() == NavigationRole.EXPRESSION) {
				if (csArgument.getInit() != null) {
					context.addBadExpressionError(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addBadExpressionError(csArgument, "Unexpected type for expression");
				}
				OclExpression exp = context.refreshExpTree(OclExpression.class, csArgument.getName());
				context.installPivotElement(csArgument, exp);
				pivotBodies.add(exp);
			}
		}
		if (pivotBodies.size() > 0) {
			if (pivotBodies.size() > 1) {
				context.addBadExpressionError(csNavigatingExp, "Iteration calls cannot have more than one body");			
			}
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
		expression.setReferredIteration(iteration);
		expression.setType(iteration.getType());
		context.reusePivotElement(csNavigatingExp, expression);		
		//
		resolveIterationAccumulators(csNavigatingExp, expression);
		resolveIterationIterators(csNavigatingExp, source, expression);
//		resolveLoopBody(csNavigatingExp, expression);
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
			OclExpression initExpression = context.refreshExpTree(OclExpression.class, csArgument.getInit());
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
				context.addWarning(csArgument, OCLMessages.WarningExtraIteratorIgnored, iteration.getName());
				continue;
			}
			if (csArgument.getInit() != null) {
				context.addBadExpressionError(csArgument, "Unexpected initializer for iterator");
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
	protected OclExpression resolveNavigationFeature(NamedExpCS csElement, OclExpression source, Feature feature, CallExp callExp) {
		CallExp navigationExp = callExp;
		Type actualSourceType = source.getType();
		Type requiredSourceType = PivotUtil.getFeaturingClass(feature);
		if (!(requiredSourceType instanceof CollectionType) && (actualSourceType instanceof CollectionType)) {
			Type elementType = ((CollectionType)actualSourceType).getElementType();
			String moniker = csElement.getMoniker() + "~collect";
			IteratorExp iteratorExp = context.refreshMonikeredElement(IteratorExp.class, PivotPackage.Literals.ITERATOR_EXP, moniker);
			iteratorExp.setImplicit(true);
			Iteration resolvedIteration = (Iteration) typeManager.resolveOperation(typeManager.getCollectionType(), "collect");
			iteratorExp.setReferredIteration(resolvedIteration);
			Variable iterator = context.refreshMonikeredElement(Variable.class, PivotPackage.Literals.VARIABLE, moniker + "|iterator~1_");
			iterator.setRepresentedParameter(resolvedIteration.getOwnedIterators().get(0));
			context.refreshName(iterator, "1_");
			iterator.setType(elementType);
			iterator.setImplicit(true);
			iteratorExp.getIterators().add(iterator);
			VariableExp variableExp = context.refreshMonikeredElement(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, moniker + "|source~1_");
			variableExp.setReferredVariable(iterator);
			variableExp.setType(elementType);
			callExp.setSource(variableExp);			
			iteratorExp.setBody(callExp);
			iteratorExp.setType(typeManager.getCollectionType(feature.isOrdered(), feature.isUnique(), elementType));
			navigationExp = iteratorExp;
		}
		navigationExp.setSource(source);
		OperatorCS csOperator = csElement.getParent();
		if ((csOperator != null) && (csOperator.getSource() != csElement)) {
			context.reusePivotElement(csOperator, navigationExp);
		}
		return navigationExp;
	}

	/**
	 * Resolve any implicit source and any associated implicit oclAsSet().
	 */
	protected OclExpression resolveNavigationSource(NamedExpCS csNameExp, Feature feature) {
		OperatorCS csOperator = csNameExp.getParent();
		OclExpression source = null;
		if (csOperator instanceof NavigationOperatorCS) {
			ExpCS csSource = csOperator.getSource();
			if (csSource != csNameExp) {
				source = PivotUtil.getPivot(OclExpression.class, csSource);
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
			sourceAccess.setType(implicitSource.getType());
			sourceAccess.setImplicit(true);
			source = sourceAccess;
		}
		Type actualSourceType = source.getType();
		Type requiredSourceType = PivotUtil.getFeaturingClass(feature);
		if ((requiredSourceType instanceof CollectionType) && !(actualSourceType instanceof CollectionType)) {
			OperationCallExp expression = context.refreshMonikeredElement(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csOperator);
			expression.setImplicit(true);
			expression.setSource(source);
			expression.setName("oclAsSet");
			context.resolveOperationCall(csOperator, expression);
			expression.setType(typeManager.getCollectionType("Set", actualSourceType));
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
			return context.addBadExpressionError(csNamedExp, OCLMessages.ErrorUnresolvedOperationName, csNamedExp);
		}
		else if (namedElement instanceof Operation) {
			Operation operation = (Operation)namedElement;
			OclExpression source = resolveNavigationSource(csNavigatingExp, operation);
			OclExpression expression;
			CallExp callExp;
			if (operation instanceof Iteration) {
				callExp = resolveIterationCall(csNavigatingExp, source, (Iteration)operation);
				expression = resolveNavigationFeature(csNavigatingExp, source, operation, callExp);
				resolveIterationBody(csNavigatingExp, (LoopExp)callExp);
			}
			else {
				OperationCallExp operationCallExp = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csNamedExp);
				operationCallExp.setReferredOperation(operation);
				context.reusePivotElement(csNavigatingExp, operationCallExp);		
				callExp = operationCallExp;
				expression = resolveNavigationFeature(csNavigatingExp, source, operation, callExp);
				resolveOperationArguments(csNavigatingExp, source, operation, operationCallExp);
				operationCallExp.setType(operation.getType());
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
				OclExpression arg = context.refreshExpTree(OclExpression.class, csArgument.getName());
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
		if (csArguments.size() > 0) {
			if (csArguments.get(0).getRole() != NavigationRole.EXPRESSION) {
				context.addBadExpressionError(csNavigatingExp, "Operation calls can only specify expressions");			
			}
			for (NavigatingArgCS csArgument : csArguments) {
				if (csArgument.getInit() != null) {
					context.addBadExpressionError(csArgument, "Unexpected initializer for expression");
				}
				if (csArgument.getOwnedType() != null) {
					context.addBadExpressionError(csArgument, "Unexpected type for expression");
				}
				OclExpression arg = PivotUtil.getPivot(OclExpression.class, csArgument);
				if (arg != null) {
					pivotArguments.add(arg);
				}
			}
		}
		if (csArguments.size() < operation.getOwnedParameters().size()) {
			context.addBadExpressionError(csNavigatingExp, "Operation call has too few parameters");			
		}
		else if (csArguments.size() > operation.getOwnedParameters().size()) {
			context.addBadExpressionError(csNavigatingExp, "Operation call has too many parameters");			
		}
		context.refreshList(expression.getArguments(), pivotArguments);
	}

	protected OclExpression resolvePropertyCallExp(NamedExpCS csNameExp, Property property) {
		OclExpression source = resolveNavigationSource(csNameExp, property);
		PropertyCallExp expression = context.refreshExpression(PropertyCallExp.class, PivotPackage.Literals.PROPERTY_CALL_EXP, csNameExp);
		expression.setReferredProperty(property);
		context.setType(expression, typeManager.getTypeWithMultiplicity(property));		// FIXME resolve template parameter		
		return resolveNavigationFeature(csNameExp, source, property, expression);
	}

	protected OclExpression resolvePropertyNavigation(NamedExpCS csNamedExp) {
		NamedElement namedElement = csNamedExp.getNamedElement();
		if (namedElement.eIsProxy()) {
			return context.addBadExpressionError(csNamedExp, OCLMessages.ErrorUnresolvedPropertyName, csNamedExp);
		}
		if (namedElement instanceof Property) {
			return resolvePropertyCallExp(csNamedExp, (Property)namedElement);
		}
		else {
			return context.addBadExpressionError(csNamedExp, "Property name expected");
		}
	}

	protected Type resolveSelfType(OclExpression expression) {
		if (expression instanceof TypeExp) {		// FIXME Is this fundamentally necessary
			return ((TypeExp)expression).getReferredType();
		}
		else {
			return expression.getType();
		}
	}

	protected TypeExp resolveTypeExp(ExpCS csExp, Type type) {
		TypeExp expression = context.refreshExpression(TypeExp.class, PivotPackage.Literals.TYPE_EXP, csExp);
		context.setType(expression, typeManager.getClassifierType());
		expression.setReferredType(type);
		return expression;
	}

	protected VariableExp resolveVariableExp(NameExpCS csNameExp, VariableDeclaration variableDeclaration) {
		VariableExp expression = context.refreshExpression(VariableExp.class, PivotPackage.Literals.VARIABLE_EXP, csNameExp);
		expression.setReferredVariable(variableDeclaration);
		context.setType(expression, variableDeclaration.getType());
		return expression;
	}

	private void setArgument(BinaryOperatorCS csParent, ExpCS csArgument) {
		csArgument.setParent(csParent);
		csParent.setArgument(csArgument);
		int i = 0;
		for (OperatorCS csOperator = csParent.getParent(); csOperator != null; csOperator = csOperator.getParent()) {
			if (csOperator == csParent) {
				logger.error("Operator loop established");
			}
			else if (i++ > 1000) {
				logger.error("Operator depth limit exceeded");
			}
		}
	}

	private void setSource(OperatorCS csParent, ExpCS csSource) {
		if (csSource != null) {
			csSource.setParent(csParent);
			int i = 0;
			for (OperatorCS csOperator = csParent.getParent(); csOperator != null; csOperator = csOperator.getParent()) {
				if (csOperator == csParent) {
					logger.error("Operator loop established");
				}
				else if (i++ > 1000) {
					logger.error("Operator depth limit exceeded");
				}
			}
			csParent.setSource(csSource);
		}
		else {
			csParent.getSource().setParent(null);
			csParent.setSource(csSource);
		}
	}

	private void updateBindings(Map<TemplateParameter, ParameterableElement> bindings, Type formalType, Type actualType) {		
		TemplateParameter formalTemplateParameter = formalType.getOwningTemplateParameter();
		if (formalTemplateParameter != null) {
			bindings.put(formalTemplateParameter, actualType);
		}
		else {
			List<TemplateBinding> templateBindings = formalType.getTemplateBindings();
			TemplateSignature formalTemplateSignature = PivotUtil.getUnspecializedTemplateableElement(formalType).getOwnedTemplateSignature();
			if (formalTemplateSignature != null) {
				for (TemplateParameter formalNestedTemplateParameter : formalTemplateSignature.getParameters()) {
					TemplateParameterSubstitution actualTemplateParameterSubstitution = findFormalParameter(formalNestedTemplateParameter, actualType);
					if (actualTemplateParameterSubstitution != null) {
						TemplateParameter formal = getFormal(templateBindings, actualTemplateParameterSubstitution.getFormal());
						if (formal == null) {	// FIXME Make this work at arbitrary depth
							formal = formalNestedTemplateParameter;
						}
						bindings.put(formal, actualTemplateParameterSubstitution.getActual());
					}
				}
			}
		}
	}
	  
	@Override
	public MonikeredElement visitBinaryOperatorCS(BinaryOperatorCS csBinaryOperator) {
		OperationCallExp expression = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csBinaryOperator);
		context.refreshName(expression, csBinaryOperator.getName());
		ExpCS csSource = csBinaryOperator.getSource();
		if (csSource != null) {
			OclExpression pivotChild = PivotUtil.getPivot(OclExpression.class, csSource);
			expression.setSource(pivotChild);
		}
		return expression;
	}

	@Override
	public MonikeredElement visitBooleanLiteralExpCS(BooleanLiteralExpCS csBooleanLiteralExp) {
		BooleanLiteralExp expression = context.refreshExpression(BooleanLiteralExp.class, PivotPackage.Literals.BOOLEAN_LITERAL_EXP, csBooleanLiteralExp);
		expression.setBooleanSymbol(Boolean.valueOf(csBooleanLiteralExp.getName()));
		expression.setType(typeManager.getBooleanType());
		return expression;
	}

	@Override
	public MonikeredElement visitCollectionLiteralExpCS(CollectionLiteralExpCS csCollectionLiteralExp) {
		Type commonType = null;
//		InvalidLiteralExp invalidValue = null;
		for (CollectionLiteralPartCS csPart : csCollectionLiteralExp.getOwnedParts()) {
			CollectionLiteralPart pivotPart = context.refreshExpTree(CollectionLiteralPart.class, csPart);
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
		if (type instanceof BagType) {
			expression.setKind(CollectionKind.BAG);
		}
		else if (type instanceof OrderedSetType) {
			expression.setKind(CollectionKind.ORDERED_SET);
		}
		else if (type instanceof SequenceType) {
			expression.setKind(CollectionKind.SEQUENCE);
		}
		else if (type instanceof SetType) {
			expression.setKind(CollectionKind.SET);
		}
		else {
			expression.setKind(CollectionKind.COLLECTION);
		}
		return expression;
	}

	@Override
	public MonikeredElement visitCollectionLiteralPartCS(CollectionLiteralPartCS csCollectionLiteralPart) {
		ExpCS csFirst = csCollectionLiteralPart.getExpressionCS();
		OclExpression pivotFirst = context.refreshExpTree(OclExpression.class, csFirst);
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
			OclExpression pivotLast = context.refreshExpTree(OclExpression.class, csLast);
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
		ExpressionInOcl pivotElement = context.refreshMonikeredElement(ExpressionInOcl.class,
			PivotPackage.Literals.EXPRESSION_IN_OCL, csContext);

		Variable contextVariable = pivotElement.getContextVariable();
		if (contextVariable == null) {
			contextVariable = PivotFactory.eINSTANCE.createVariable();
		}
		Resource resource = csContext.eResource();
		if (resource instanceof EvaluationContext) {	
			NamedElement specificationContext = ((EvaluationContext)resource).getSpecificationContext();
			if (specificationContext instanceof Type) {
				context.setType(contextVariable, (Type) specificationContext);
			}
			else if (specificationContext instanceof Feature) {
				Type contextType = PivotUtil.getFeaturingClass((Feature)specificationContext);
				context.setType(contextVariable, contextType);
				if (specificationContext instanceof Operation) {
					context.setType(contextVariable, contextType);
			        for (Parameter parameter : ((Operation)specificationContext).getOwnedParameters()) {
				        Variable param = PivotFactory.eINSTANCE.createVariable();
				        param.setName(parameter.getName());
				        param.setType(parameter.getType());
				        param.setRepresentedParameter(parameter);
				        pivotElement.getParameterVariables().add(param);
			        }					
				}
			}
		}
		context.refreshName(contextVariable, Environment.SELF_VARIABLE_NAME);
		pivotElement.setContextVariable(contextVariable);
		context.putPivotElement(contextVariable);
				
		context.installPivotElement(csContext, pivotElement);
		ExpCS csExpression = csContext.getOwnedExpression();
		OclExpression expression = context.refreshExpTree(OclExpression.class, csExpression);
		if (expression != null) {
			pivotElement.setBodyExpression(expression);
			context.setType(pivotElement, expression.getType());
		}
		return pivotElement;
	}

	@Override
	public MonikeredElement visitExpCS(ExpCS object) {
		return null;
	}

	@Override
	public MonikeredElement visitExpConstraintCS(ExpConstraintCS csExpConstraint) {
		ExpCS csExpression = csExpConstraint.getOwnedExpression();
		if (csExpression == null) {
			return null;
		}
		Constraint constraint = PivotUtil.getPivot(Constraint.class, csExpConstraint);
		OclExpression expression = context.refreshExpTree(OclExpression.class, csExpression);
		ExpressionInOcl specification = (ExpressionInOcl) constraint.getSpecification();
		specification.setBodyExpression(expression);
		return expression;
	}

	@Override
	public MonikeredElement visitIfExpCS(IfExpCS csIfExp) {
		IfExp expression = context.refreshExpression(IfExp.class, PivotPackage.Literals.IF_EXP, csIfExp);
		expression.setCondition(context.refreshExpTree(OclExpression.class, csIfExp.getCondition()));
		OclExpression thenExpression = context.refreshExpTree(OclExpression.class, csIfExp.getThenExpression());
		expression.setThenExpression(thenExpression);
		OclExpression elseExpression = context.refreshExpTree(OclExpression.class, csIfExp.getElseExpression());
		expression.setElseExpression(elseExpression);
		expression.setType(typeManager.getCommonType(thenExpression.getType(), elseExpression.getType()));
		return expression;
	}

	@Override
	public MonikeredElement visitIndexExpCS(IndexExpCS csIndexExp) {
		// Navigating completions are orchestrated by the SimpleNamedExpCS.
		return null;
	}

	@Override
	public MonikeredElement visitInfixExpCS(InfixExpCS csInfixExp) {
		// FIXME special case trivial expressions
		//
		//	Establish the Infix tree and the per leaf expression parent operator.
		//
		createInfixOperatorTree(csInfixExp);			// FIXME Move to PostOrder visit
		//
		//	Interleave the Prefix Operators.
		//
		interleavePrefixes(csInfixExp);					// FIXME Move to PostOrder visit
		//
		//	Find the root.
		//
		OperatorCS csRoot = csInfixExp.getOwnedOperator().get(0);
		for (OperatorCS csParent = csRoot.getParent(); csParent != null; csParent = csParent.getParent()) {
			csRoot = csParent;
		}
		//
		//	Build the corresponding AST.
		//
		resolveExpression(csRoot);		
		//
		//	Map the infix CS to the root of the AS tree.
		//
		OclExpression pivot = PivotUtil.getPivot(OclExpression.class, csRoot);
		context.reusePivotElement(csInfixExp, pivot);
		return pivot;
	}

	@Override
	public MonikeredElement visitInvalidLiteralExpCS(InvalidLiteralExpCS csInvalidLiteralExp) {
		InvalidLiteralExp expression = PivotUtil.getPivot(InvalidLiteralExp.class, csInvalidLiteralExp);
		if (expression == null) {
			expression = PivotFactory.eINSTANCE.createInvalidLiteralExp();
		}
		expression.setType(typeManager.getOclInvalidType());
		expression.setObject(csInvalidLiteralExp);
		expression.setExpression(null);
		expression.setReason("invalid literal");
		expression.setThrowable(null);
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
			OclExpression initExpression = context.refreshExpTree(OclExpression.class, csInitExpression);
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
			OclExpression in = context.refreshExpTree(OclExpression.class, csLetExp.getIn());
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
				return context.addBadExpressionError(csNameExp, OCLMessages.ErrorUnresolvedName, csNameExp);
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
		if (csNavigatingExp.getParent() instanceof NavigationOperatorCS) {
			return PivotUtil.getPivot(OclExpression.class, csNavigatingExp);
		}
		else {
			return resolveOperation(csNavigatingExp);
		}
	}

	@Override
	public OclExpression visitNavigationOperatorCS(NavigationOperatorCS csNavigationOperator) {
		OclExpression navigatingExp;
		ExpCS argument = csNavigationOperator.getArgument();
		if (argument instanceof NavigatingExpCS) {
			navigatingExp = resolveOperation((NavigatingExpCS) argument);
		}
		else {
			navigatingExp = resolvePropertyNavigation((NamedExpCS) argument);
		}
		context.reusePivotElement(csNavigationOperator, navigatingExp);
		return navigatingExp;
	}

	@Override
	public MonikeredElement visitNestedExpCS(NestedExpCS csNestedExp) {
		OclExpression pivot = context.refreshExpTree(OclExpression.class, csNestedExp.getSource());
		context.reusePivotElement(csNestedExp, pivot);
		return pivot;
	}

	@Override
	public MonikeredElement visitNullLiteralExpCS(NullLiteralExpCS csNullLiteralExp) {
		NullLiteralExp expression = context.refreshExpression(NullLiteralExp.class, PivotPackage.Literals.NULL_LITERAL_EXP, csNullLiteralExp);
		expression.setType(typeManager.getOclVoidType());
		return expression;
	}

	@Override
	public MonikeredElement visitNumberLiteralExpCS(NumberLiteralExpCS csNumberLiteralExp) {
		Number number = csNumberLiteralExp.getName();
		if (number instanceof BigDecimal) {
			RealLiteralExp expression = context.refreshExpression(RealLiteralExp.class, PivotPackage.Literals.REAL_LITERAL_EXP, csNumberLiteralExp);
			expression.setRealSymbol((BigDecimal) number);
			expression.setType(typeManager.getRealType());
			return expression;
		}
		BigInteger bigInteger = (BigInteger) number;
		if (bigInteger.signum() < 0) {
			IntegerLiteralExp expression = context.refreshExpression(IntegerLiteralExp.class, PivotPackage.Literals.INTEGER_LITERAL_EXP, csNumberLiteralExp);
			expression.setIntegerSymbol(bigInteger);
			expression.setType(typeManager.getIntegerType());
			return expression;
		}
		else {
			UnlimitedNaturalLiteralExp expression = context.refreshExpression(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csNumberLiteralExp);
			expression.setUnlimitedNaturalSymbol(bigInteger);
			expression.setType(typeManager.getUnlimitedNaturalType());
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
			initializePrefixOperators(csPrefixExp, null);
			resolveExpression(csRoot);		
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
		ScopeView scopeView = scopeAdapter.getOuterScopeView(null);
		scopeView.computeLookups(environmentView);
		VariableDeclaration variableDeclaration = (VariableDeclaration) environmentView.getContent();
		expression.setReferredVariable(variableDeclaration);
		context.setType(expression, variableDeclaration.getType());
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
		expression.setType(typeManager.getStringType());
		return expression;
	}

	@Override
	public MonikeredElement visitTupleLiteralExpCS(TupleLiteralExpCS csTupleLiteralExp) {
		TupleLiteralExp expression = context.refreshMonikeredElement(TupleLiteralExp.class, PivotPackage.Literals.TUPLE_LITERAL_EXP, csTupleLiteralExp);	
		for (TupleLiteralPartCS csPart : csTupleLiteralExp.getOwnedParts()) {
			@SuppressWarnings("unused")
			TupleLiteralPart pivotPart = context.refreshExpTree(TupleLiteralPart.class, csPart);
		}
		context.refreshPivotList(TupleLiteralPart.class, expression.getParts(), csTupleLiteralExp.getOwnedParts());
		String tupleTypeName = "Tuple"; //ownedCollectionType.getName();
		Type type = typeManager.getTupleType(tupleTypeName, expression.getParts(), null);
		context.setType(expression, type);
		return expression;
	}

	@Override
	public MonikeredElement visitTupleLiteralPartCS(TupleLiteralPartCS csTupleLiteralPart) {
		TupleLiteralPart pivotElement = context.refreshNamedElement(TupleLiteralPart.class, PivotPackage.Literals.TUPLE_LITERAL_PART, csTupleLiteralPart);	
		OclExpression initExpression = context.refreshExpTree(OclExpression.class, csTupleLiteralPart.getInitExpression());
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
	public MonikeredElement visitUnaryOperatorCS(UnaryOperatorCS csUnaryOperator) {
		OperationCallExp expression = context.refreshExpression(OperationCallExp.class, PivotPackage.Literals.OPERATION_CALL_EXP, csUnaryOperator);
		context.refreshName(expression, csUnaryOperator.getName());
		ExpCS csSource = csUnaryOperator.getSource();
		if (csSource != null) {
			OclExpression pivotChild = context.refreshExpTree(OclExpression.class, csSource);
			expression.setSource(pivotChild);
		}
		Operation operation = context.resolveOperationCall(csUnaryOperator, expression);
		if (operation != null) {
			context.setType(expression, operation.getType());
		}
		return expression;
	}

	@Override
	public MonikeredElement visitUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS csUnlimitedNaturalLiteralExp) {
		UnlimitedNaturalLiteralExp expression = context.refreshExpression(UnlimitedNaturalLiteralExp.class, PivotPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, csUnlimitedNaturalLiteralExp);
		expression.setName("*");
		expression.setType(typeManager.getUnlimitedNaturalType());
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
		variable.setType(type);
		return variable;
	}	
}