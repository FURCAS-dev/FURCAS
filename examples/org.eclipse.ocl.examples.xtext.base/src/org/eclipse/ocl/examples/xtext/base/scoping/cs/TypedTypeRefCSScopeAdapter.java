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
 * $Id: TypedTypeRefCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class TypedTypeRefCSScopeAdapter extends ModelElementCSScopeAdapter<TypedTypeRefCS, Type>
{
	public TypedTypeRefCSScopeAdapter(TypeManager typeManager, TypedTypeRefCS csElement) {
		super(typeManager, csElement, Type.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
//		toString();
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == BaseCSTPackage.Literals.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING) {
			return scopeView.getUnqualifiedOuterScope();
		}
		else if (containmentFeature == BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE) {
			return scopeView.getOuterScope();
		}
		else {
			Type type = target.getType();
			environmentView.addElementsOfScope(typeManager, type, scopeView);
			return scopeView.getOuterScope();
		}
	}
}
