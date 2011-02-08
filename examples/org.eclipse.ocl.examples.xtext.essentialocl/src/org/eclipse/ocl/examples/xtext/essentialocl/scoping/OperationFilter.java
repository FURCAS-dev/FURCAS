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
 * $Id: OperationFilter.java,v 1.1 2011/02/08 17:44:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;

class OperationFilter implements EnvironmentView.Filter
{
	protected final TypeManager typeManager;
	private final NavigatingExpCS csNavigatingExp;
	private final int iterators;
	private final int accumulators;
	private final int expressions;
	
	public OperationFilter(TypeManager typeManager, NavigatingExpCS csNavigatingExp) {
		this.typeManager = typeManager;
		this.csNavigatingExp = csNavigatingExp;
		int accumulators = 0;
		int iterators = 0;
		int expressions = 0;
		for (NavigatingArgCS csNavigatingArg : csNavigatingExp.getArgument()) {
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

	public int compareMatches(EObject match1, Map<TemplateParameter, ParameterableElement> bindings1,
			EObject match2, Map<TemplateParameter, ParameterableElement> bindings2) {
		int comparison = typeManager.compareOperationMatches((Operation)match1, bindings1,
			(Operation)match2, bindings2);
		if (comparison == 0) {
			typeManager.compareOperationMatches((Operation)match1, bindings1,
				(Operation)match2, bindings2);	// FIXME Debugging
		}
		return comparison;
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
			ExpCS csSource = csNavigatingExp.getParent().getSource();
			OclExpression source = PivotUtil.getPivot(OclExpression.class, csSource);
			Type sourceType = source.getType();
			if (!(sourceType instanceof CollectionType) && (candidateIteration.getClass_() instanceof CollectionType)) {
				sourceType = typeManager.getCollectionType("Set", sourceType);		// Implicit oclAsSet()
			}			
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
			TemplateSignature templateSignature = candidateIteration.getOwnedTemplateSignature();
			if (templateSignature != null) {
				List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
				int accIndex = 0;
				for (NavigatingArgCS csArgument : csNavigatingExp.getArgument()) {
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
//				for (TemplateParameter templateParameter : templateParameters) {
//					if (bindings == null) {
//						bindings = new HashMap<TemplateParameter, ParameterableElement>();
//					}
//					bindings.put(templateParameter, null);
//				}
			}
			if (bindings != null) {
//				Map<TemplateParameter, ParameterableElement> resolvedBindings = new HashMap<TemplateParameter, ParameterableElement>();
//				for (TemplateParameter templateParameter : templateSignature.getOwnedParameters()) {
//					resolvedBindings.put(templateParameter, bindings.get(templateParameter));
//				}
				environmentView.setBindings(eObject, bindings);
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
//			if (expressions > 0) {
				ExpCS csSource = csNavigatingExp.getParent().getSource();
				OclExpression source = PivotUtil.getPivot(OclExpression.class, csSource);
				Type sourceType = source.getType();
				if (!(sourceType instanceof CollectionType) && (candidateOperation.getClass_() instanceof CollectionType)) {
					sourceType = typeManager.getCollectionType("Set", sourceType);		// Implicit oclAsSet()
				}			
				Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
//				PivotUtil.getAllTemplateParameterSubstitutions(bindings, candidateOperation);
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
					NavigatingArgCS csExpression = csNavigatingExp.getArgument().get(i);
					OclExpression expression = PivotUtil.getPivot(OclExpression.class, csExpression);
					Type candidateType = candidateParameter.getType();
					Type expressionType = expression.getType();
					if (!typeManager.conformsTo(expressionType, candidateType, bindings)) {
						return false;
					}
				}
				if (bindings != null) {
//					Map<TemplateParameter, ParameterableElement> resolvedBindings = new HashMap<TemplateParameter, ParameterableElement>();
//					for (TemplateParameter templateParameter : templateSignature.getOwnedParameters()) {
//						resolvedBindings.put(templateParameter, bindings.get(templateParameter));
//					}
					environmentView.setBindings(eObject, bindings);
				}
//			}
			return true;
		}
		else {
			return false;
		}
	}
}