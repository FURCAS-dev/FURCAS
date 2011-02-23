package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

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
 * $Id: OperationContextFilter.java,v 1.1 2011/02/08 17:53:05 ewillink Exp $
 */
public class OperationContextFilter implements EnvironmentView.Filter
{
	private final OperationContextDeclCS csOperationContext;
	
	public OperationContextFilter(OperationContextDeclCS csOperationContext) {
		this.csOperationContext = csOperationContext;
	}

	public int compareMatches(EObject match1, Map<TemplateParameter, ParameterableElement> bindings1, EObject match2, Map<TemplateParameter, ParameterableElement> bindings2) {
		return 0;
	}

	public boolean matches(EnvironmentView environmentView, EObject eObject) {
		if (!(eObject instanceof Operation)) {
			return false;
		}
		List<VariableCS> contextParameters = csOperationContext.getParameters();
		Operation candidateOperation = (Operation) eObject;
		List<Parameter> candidateParameters = candidateOperation.getOwnedParameters();
		int iMax = contextParameters.size();
		if (iMax != candidateParameters.size()) {
			return false;
		}
		for (int i = 0; i < iMax; i++) {
			VariableCS contextParameter = contextParameters.get(i);
			Parameter candidateParameter = candidateParameters.get(i);
			Type candidateType = candidateParameter.getType();
			// FIXME Check more than just argument counts
		}
		return true;
	}
}