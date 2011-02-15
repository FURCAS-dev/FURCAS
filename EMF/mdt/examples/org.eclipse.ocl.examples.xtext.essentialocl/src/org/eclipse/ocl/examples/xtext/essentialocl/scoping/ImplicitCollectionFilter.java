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
 * $Id: ImplicitCollectionFilter.java,v 1.1 2011/02/15 10:37:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public class ImplicitCollectionFilter extends AbstractOperationFilter
{
	public ImplicitCollectionFilter(TypeManager typeManager, Type sourceType) {
		super(typeManager, sourceType);
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
		super.installBindings(environmentView, eObject, bindings);
	}

	public boolean matches(EnvironmentView environmentView, EObject eObject) {
		if (eObject instanceof Iteration) {		
			return false;
		}
		else if (eObject instanceof Operation) {
			Operation candidateOperation = (Operation)eObject;
			List<Parameter> candidateParameters = candidateOperation.getOwnedParameters();
			if (candidateParameters.size() != 0) {
				return false;
			}
			Map<TemplateParameter, ParameterableElement> bindings = PivotUtil.getAllTemplateParameterSubstitutions(null, sourceType);
			TemplateSignature templateSignature = candidateOperation.getOwnedTemplateSignature();
			if (templateSignature != null) {
				for (TemplateParameter templateParameter : templateSignature.getOwnedParameters()) {
					if (bindings == null) {
						bindings = new HashMap<TemplateParameter, ParameterableElement>();
					}
					bindings.put(templateParameter, null);
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