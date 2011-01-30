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
 * $Id: ContextCSScopeAdapter.java,v 1.3 2011/01/30 11:20:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationContext;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractRootCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;

public class ContextCSScopeAdapter extends AbstractRootCSScopeAdapter<ContextCS, ExpressionInOcl>
{
	public ContextCSScopeAdapter(TypeManager typeManager, ContextCS csElement) {
		super(typeManager, csElement, ExpressionInOcl.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		ExpressionInOcl pivot = getPivot();
		if (pivot != null) {
			Variable resultVariable = pivot.getResultVariable();
			if (resultVariable != null) {
				environmentView.addNamedElement(resultVariable);
			}
			for (Variable parameterVariable : pivot.getParameterVariables()) {
				environmentView.addNamedElement(parameterVariable);
			}
			Variable contextVariable = pivot.getContextVariable();
			if (contextVariable != null) {
				environmentView.addNamedElement(contextVariable);
				if ((environmentView.getSize() == 0) || (environmentView.getName() == null)) {
					Type type = contextVariable.getType();
					environmentView.addElementsOfScope(typeManager, type, scopeView);
					if ((environmentView.getSize() == 0) || (environmentView.getName() == null)) {
						environmentView.addElementsOfScope(typeManager, type.getPackage(), scopeView);
					}
				}
			}
		}
		else {
			Resource resource = target.eResource();
			if (resource instanceof EvaluationContext) {
				NamedElement specificationContext = ((EvaluationContext)resource).getSpecificationContext();
				ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, specificationContext);
				if (scopeAdapter != null) {
					scopeAdapter.computeLookup(environmentView, PivotPackage.Literals.NAMED_ELEMENT__OWNED_RULE);
				}				
			}
		}
		if ((environmentView.getSize() == 0) || (environmentView.getName() == null)) {
			environmentView.addElementsOfScope(typeManager, typeManager.getOclAnyType().getPackage(), scopeView);
		}
		return super.computeLookup(environmentView, scopeView);
	}
}
