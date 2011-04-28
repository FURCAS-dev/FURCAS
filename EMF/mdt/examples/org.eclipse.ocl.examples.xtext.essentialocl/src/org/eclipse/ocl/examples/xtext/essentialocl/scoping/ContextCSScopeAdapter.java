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
 * $Id: ContextCSScopeAdapter.java,v 1.9 2011/04/20 19:02:15 ewillink Exp $
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
		if ((pivot != null) && (pivot.getContextVariable().getType() != null)) {
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
				if (!environmentView.hasFinalResult()) {
					Type type = contextVariable.getType();
					environmentView.addElementsOfScope(type, scopeView);
					if (!environmentView.hasFinalResult()) {
						environmentView.addElementsOfScope(type.getPackage(), scopeView);
					}
				}
			}
		}
		else {
			Resource resource = target.eResource();
			if (resource instanceof EvaluationContext) {
				NamedElement specificationContext = ((EvaluationContext)resource).getSpecificationContext();
				if (specificationContext != null) {
					ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, specificationContext);
					if (scopeAdapter != null) {		// FIXME just redirect; it will do OclAny at its root
						ScopeView ruleScopeView = scopeAdapter.getInnerScopeView(typeManager, PivotPackage.Literals.NAMED_ELEMENT__OWNED_RULE);
						environmentView.computeLookups(ruleScopeView);
					}	
				}
			}
		}
		if (!environmentView.hasFinalResult()) {
			environmentView.addElementsOfScope(typeManager.getOclAnyType().getPackage(), scopeView);
		}
		return super.computeLookup(environmentView, scopeView);
	}
}
