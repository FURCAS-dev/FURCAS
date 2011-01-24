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
 * $Id: ConstraintCSScopeAdapter.java,v 1.2 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ConstraintCSScopeAdapter extends BaseCSScopeAdapter<ConstraintCS, Constraint>
{
	public ConstraintCSScopeAdapter(TypeManager typeManager, ConstraintCS csElement) {
		super(typeManager, csElement, Constraint.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		Constraint pivot = getPivot();
		if (pivot != null) {
			ValueSpecification specification = pivot.getSpecification();
			if (specification instanceof ExpressionInOcl) {
				Variable contextVariable = ((ExpressionInOcl)specification).getContextVariable();
				if (contextVariable != null) {
					environmentView.addNamedElement(contextVariable);
					Type type = contextVariable.getType();
					environmentView.addElementsOfScope(typeManager, type, scopeView);
				}
				Variable resultVariable = ((ExpressionInOcl)specification).getResultVariable();
				if (resultVariable != null) {
					environmentView.addNamedElement(resultVariable);
				}
			}
		}
		return scopeView.getOuterScope();
	}

	@Override
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		EObject eContainer = target.eContainer();
		if (eContainer instanceof FeatureCS) {
			eContainer = eContainer.eContainer();
		}
		return getScopeAdapter((ModelElementCS)eContainer);
	}
}
