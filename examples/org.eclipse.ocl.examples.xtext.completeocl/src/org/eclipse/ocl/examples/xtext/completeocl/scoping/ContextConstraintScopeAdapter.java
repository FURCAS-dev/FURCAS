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
 * $Id: ContextConstraintScopeAdapter.java,v 1.1 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLCSScopeAdapter;

public class ContextConstraintScopeAdapter extends EssentialOCLCSScopeAdapter<ContextConstraintCS, Constraint>
{	// FIXME Share with ConstraintCSScopeAdapter
	public ContextConstraintScopeAdapter(TypeManager typeManager, ContextConstraintCS csElement) {
		super(typeManager, csElement, Constraint.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		Constraint constraint = getPivot();
		if (constraint != null) {
			ValueSpecification specification = constraint.getSpecification();
			if (specification instanceof ExpressionInOcl) {
				ExpressionInOcl expressionInOcl = (ExpressionInOcl) specification;
				Variable resultVariable = expressionInOcl.getResultVariable();
				if (resultVariable != null) {
					environmentView.addNamedElement(resultVariable);
				}
				for (Variable parameterVariable : expressionInOcl.getParameterVariables()) {
					environmentView.addNamedElement(parameterVariable);
				}
				Variable contextVariable = expressionInOcl.getContextVariable();
				if (contextVariable != null) {
					environmentView.addNamedElement(contextVariable);
					if (!environmentView.hasFinalResult()) {
						Type type = contextVariable.getType();
						environmentView.addElementsOfScope(typeManager, type, scopeView);
						if (!environmentView.hasFinalResult()) {
							environmentView.addElementsOfScope(typeManager, type.getPackage(), scopeView);
						}
					}
				}
			}
		}
		return scopeView.getOuterScope();
	}
}
