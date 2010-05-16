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
 * $Id: TypedTypeRefScopeAdapter.java,v 1.3 2010/05/16 19:18:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class TypedTypeRefScopeAdapter extends AbstractScopeAdapter<TypedTypeRefCS>
{
	public TypedTypeRefScopeAdapter(TypedTypeRefCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == BaseCSTPackage.Literals.PARAMETERIZED_TYPE_REF_CS__TYPE_ARGUMENTS) {
			return scopeView.getUnqualifiedOuterScope(scopeView.getBindings());
		}
		else {
			TypeCS type = getTarget().getType();
			environmentView.addElementsOfScope(type, scopeView);
			return scopeView.getOuterScope();
		}
	}
}
