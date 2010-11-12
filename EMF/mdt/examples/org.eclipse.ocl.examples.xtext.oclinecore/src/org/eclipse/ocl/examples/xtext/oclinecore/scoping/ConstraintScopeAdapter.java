/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: ConstraintScopeAdapter.java,v 1.2 2010/10/30 20:20:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;

public class ConstraintScopeAdapter extends EssentialOCLScopeAdapter<ConstraintCS>
{
	public ConstraintScopeAdapter(ConstraintCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EObject classifierContext = getTarget().eContainer();
		while ((classifierContext != null) && !(classifierContext instanceof ClassCS)) {
			classifierContext = classifierContext.eContainer();
		}
		if (classifierContext != null) {
			environmentView.addElementsOfScope(classifierContext, scopeView);
			environmentView.addElement("self", classifierContext, scopeView.getBindings());
		}
		return scopeView.getOuterScope();
	}

	@Override
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		ConstraintCS target = getTarget();
		EObject eContainer = target.eContainer();
		if (eContainer instanceof FeatureCS) {
			eContainer = eContainer.eContainer();
		}
		return getScopeAdapter(eContainer);
	}
}
