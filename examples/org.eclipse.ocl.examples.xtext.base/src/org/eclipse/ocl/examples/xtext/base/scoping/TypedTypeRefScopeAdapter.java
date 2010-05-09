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
 * $Id: TypedTypeRefScopeAdapter.java,v 1.2 2010/05/09 17:08:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;

public class TypedTypeRefScopeAdapter extends AbstractScopeAdapter<TypedTypeRefCS>
{
	public TypedTypeRefScopeAdapter(TypedTypeRefCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {		
		}
/*		else if (containmentFeature == BaseCSTPackage.Literals.TYPED_TYPE_REF_CS__TYPE_ARGUMENTS) {
			AbstractScopeAdapter<?> parent = getParent();
			for ( ; parent instanceof QualifiedTypeRefScopeAdapter; parent = parent.getParent())
				;
			return parent.computeInheritedEnvironmentView(environmentView, containmentFeature);
		} */
		else {
			TypeCS type = getTarget().getType();
			return environmentView.addElementsOfScope(type);
		}
		return true;
	}
}
