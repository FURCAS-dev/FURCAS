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
 * $Id: BinaryOperationFilter.java,v 1.2 2011/03/12 18:45:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public class BinaryOperationFilter extends AbstractOperationFilter
{
	protected final Type argumentType;
	
	public BinaryOperationFilter(TypeManager typeManager, Type sourceType, Type argumentType) {
		super(typeManager, sourceType);
		this.argumentType = PivotUtil.getBehavioralType(argumentType);
	}

	public boolean matches(EnvironmentView environmentView, EObject eObject) {
		if (eObject instanceof Iteration) {		
			return false;
		}
		else if (eObject instanceof Operation) {
			Operation candidateOperation = (Operation)eObject;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameters();
			if (candidateParameters.size() != 1) {
				return false;
			}
			Parameter candidateParameter = candidateParameters.get(0);
			Type candidateType = candidateParameter.getType();
			if (!typeManager.conformsTo(argumentType, candidateType, null)) {
				return false;
			}
			Map<TemplateParameter, ParameterableElement> bindings = getOperationBindings(candidateOperation);
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