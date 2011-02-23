/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: OperationFilter.java,v 1.3 2011/02/15 10:37:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;

public class OperationFilter extends AbstractOperationFilter
{
//	private final ExpCS csNavigatingExp;
	private final List<NavigatingArgCS> csArguments;
	private final int iterators;
	private final int accumulators;
	private final int expressions;
	
	public OperationFilter(TypeManager typeManager, Type sourceType, NavigatingExpCS csNavigatingExp) {
		super(typeManager, sourceType);
//		this.csNavigatingExp = csNavigatingExp;
		int accumulators = 0;
		int iterators = 0;
		int expressions = 0;
		this.csArguments = csNavigatingExp.getArgument();
		for (NavigatingArgCS csNavigatingArg : csArguments) {
			if (csNavigatingArg.getRole() == NavigationRole.ITERATOR) {
				iterators++;
			}
			else if (csNavigatingArg.getRole() == NavigationRole.ACCUMULATOR) {
				accumulators++;
			}
			else if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				expressions++;
			}
		}
		this.iterators = iterators;
		this.accumulators = accumulators;
		this.expressions = expressions;
	}

	protected OclExpression getExpressionArgument(int index) {
		int expIndex = 0;
		for (NavigatingArgCS csNavigatingArg : csArguments) {
			if (csNavigatingArg.getRole() == NavigationRole.EXPRESSION) {
				if (expIndex == index) {
					return PivotUtil.getPivot(OclExpression.class, csNavigatingArg);
				}
				expIndex++;
			}
		}
		return null;
	}
	
	@Override
	protected void installBindings(EnvironmentView environmentView, EObject eObject,
			Map<TemplateParameter, ParameterableElement> bindings) {
		for (TemplateParameter templateParameter : bindings.keySet()) {
			ParameterableElement parameteredElement = templateParameter.getParameteredElement();
			if (parameteredElement instanceof NamedElement) {
				if (PivotConstants.OCL_SELF_NAME.equals(((NamedElement)parameteredElement).getName())) {
					if (bindings.get(templateParameter) == null) {
						bindings.put(templateParameter, sourceType);
						break;
					}
				}
			}
		}
		List<Parameter> parameters = ((Operation)eObject).getOwnedParameters();
		int iMax = parameters.size();
		if (iMax > 0) {
			for (int i = 0; i < iMax; i++) {
				Parameter parameter = parameters.get(i);
				OclExpression argument = getExpressionArgument(i);
				if (argument != null) {
					Type parameterType = parameter.getType();
					if (parameterType instanceof LambdaType) {
						PivotUtil.getAllTemplateParameterSubstitutions(bindings, argument.getType(), (LambdaType) parameterType);
					}
				}
			}
		}
		super.installBindings(environmentView, eObject, bindings);
	}

	public boolean matches(EnvironmentView environmentView, EObject eObject) {
		if (eObject instanceof Iteration) {
			Iteration candidateIteration = (Iteration)eObject;
			int iteratorCount = candidateIteration.getOwnedIterators().size();
			if ((0 < iterators) && (iteratorCount != iterators)) {
				return false;
			}
			int accumulatorCount = candidateIteration.getOwnedAccumulators().size();
			if (accumulatorCount != accumulators) {
				return false;
			}
			Type sourceType = this.sourceType;
			if (!(sourceType instanceof CollectionType) && (candidateIteration.getClass_() instanceof CollectionType)) {
				sourceType = typeManager.getCollectionType("Set", sourceType);		// Implicit oclAsSet()
			}			
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
			TemplateSignature templateSignature = candidateIteration.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
				int accIndex = 0;
				for (NavigatingArgCS csArgument : csArguments) {
					if (csArgument.getRole() == NavigationRole.ACCUMULATOR) {
						if (accIndex < templateParameters.size()) {
							Variable argument = PivotUtil.getPivot(Variable.class, csArgument);
							Type argumentType = argument.getType();
							TemplateParameter accParameter = templateParameters.get(accIndex);
							bindings.put(accParameter, argumentType);
						}
						accIndex++;
					}
				}
			}
			if (bindings != null) {
				installBindings(environmentView, eObject, bindings);
			}
			return true;
		}
		else if (eObject instanceof Operation) {
			if (iterators > 0) {
				return false;
			}
			if (accumulators > 0) {
				return false;
			}
			Operation candidateOperation = (Operation)eObject;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameters();
			if (expressions != candidateParameters.size()) {
				return false;
			}
			Type sourceType = this.sourceType;
			if (!(sourceType instanceof CollectionType) && (candidateOperation.getClass_() instanceof CollectionType)) {
				sourceType = typeManager.getCollectionType("Set", sourceType);		// Implicit oclAsSet()
			}			
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
//			PivotUtil.getAllTemplateParameterSubstitutions(bindings, candidateOperation);
			TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
			if (templateSignature != null) {
				for (TemplateParameter templateParameter : templateSignature.getOwnedParameters()) {
					if (bindings == null) {
						bindings = new HashMap<TemplateParameter, ParameterableElement>();
					}
					bindings.put(templateParameter, null);
				}
			}
			for (int i = 0; i < expressions; i++) {
				Parameter candidateParameter = candidateParameters.get(i);
				NavigatingArgCS csExpression = csArguments.get(i);
				OclExpression expression = PivotUtil.getPivot(OclExpression.class, csExpression);
				Type candidateType = candidateParameter.getType();
				Type expressionType = expression.getType();
				if (!typeManager.conformsTo(expressionType, candidateType, bindings)) {
					return false;
				}
			}
			if (bindings != null) {
				installBindings(environmentView, eObject, bindings);
			}
			return true;
		}
		else {
			return false;
		}
	}
}