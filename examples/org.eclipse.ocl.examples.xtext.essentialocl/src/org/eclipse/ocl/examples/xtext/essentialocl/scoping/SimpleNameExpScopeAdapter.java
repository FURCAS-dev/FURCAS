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
 * $Id: SimpleNameExpScopeAdapter.java,v 1.6 2010/05/29 15:31:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;

public class SimpleNameExpScopeAdapter extends ExpScopeAdapter<SimpleNameExpCS>
{
	public SimpleNameExpScopeAdapter(SimpleNameExpCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		ScopeAdapter nonNameParent = getParent();
//		EStructuralFeature eContainingFeature = getTarget().eContainingFeature();
		while (nonNameParent instanceof PathNameExpScopeAdapter) {
			nonNameParent = nonNameParent.getParent();
//			eContainingFeature = nonNameParent.getTarget().eContainingFeature();
		}
		if (nonNameParent instanceof ArrowOperationCallExpScopeAdapter) {
			environmentView.require(BaseCSTPackage.Literals.OPERATION_CS);
		}
		else if (nonNameParent instanceof DotOperationCallExpScopeAdapter) {
			environmentView.require(BaseCSTPackage.Literals.OPERATION_CS);
		}
		else if (nonNameParent instanceof ArrowExpScopeAdapter) {
			environmentView.require(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS);
		}
		else if (nonNameParent instanceof DotExpScopeAdapter) {
			environmentView.require(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS);
		}
		return super.computeLookup(environmentView, scopeView);
	}

	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		SimpleNameExpCS target = getTarget();
		NamedElementCS element = target.getElement();
		return getLibraryType(element, bindings);
	}
}
