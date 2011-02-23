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
 * $Id: ImplicitCollectFilter.java,v 1.1 2011/02/15 10:37:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public class ImplicitCollectFilter extends AbstractOperationFilter
{
	protected final Type iteratorType;

	/**
	 * Configure an OperationFilter for an implicit collect.
	 */
	public ImplicitCollectFilter(TypeManager typeManager, CollectionType sourceType, Type iteratorType) {
		super(typeManager, sourceType);
		this.iteratorType = iteratorType;
	}

	public boolean matches(EnvironmentView environmentView, EObject eObject) {
		if (!(eObject instanceof Iteration)) {
			return false;
		}
		Iteration candidateIteration = (Iteration)eObject;
		int iteratorCount = candidateIteration.getOwnedIterators().size();
		if (iteratorCount != 1) {
			return false;
		}
		int accumulatorCount = candidateIteration.getOwnedAccumulators().size();
		if (accumulatorCount != 0) {
			return false;
		}
		TemplateSignature templateSignature = candidateIteration.getClass_().getOwnedTemplateSignature();
		if (templateSignature == null) {
			return false;
		}
		List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
		if (templateParameters.size() != 1) {
			return false;
		}
		Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
		TemplateParameter iteratorParameter = templateParameters.get(0);
		bindings.put(iteratorParameter, iteratorType);
		installBindings(environmentView, eObject, bindings);
		return true;
	}
}