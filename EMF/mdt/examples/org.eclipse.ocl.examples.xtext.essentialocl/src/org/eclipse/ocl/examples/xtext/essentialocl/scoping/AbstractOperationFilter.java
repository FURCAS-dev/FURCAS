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
 * $Id: AbstractOperationFilter.java,v 1.1 2011/02/15 10:37:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public abstract class AbstractOperationFilter implements EnvironmentView.Filter
{
	protected final TypeManager typeManager;
	protected final Type sourceType;
	
	public AbstractOperationFilter(TypeManager typeManager, Type sourceType) {
		this.typeManager = typeManager;
		this.sourceType = PivotUtil.getBehavioralType(sourceType);
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

	protected void installBindings(EnvironmentView environmentView, EObject eObject,
			Map<TemplateParameter, ParameterableElement> bindings) {
		environmentView.setBindings(eObject, bindings);
	}
}