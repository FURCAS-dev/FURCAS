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
 * $Id: ReferenceCSScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.cs;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class ReferenceCSScopeAdapter extends BaseCSScopeAdapter<ReferenceCS, Property>
{
	public ReferenceCSScopeAdapter(TypeManager typeManager, ReferenceCS csElement) {
		super(typeManager, csElement, Property.class);
	}

	public void addAllReferences(EnvironmentView environmentView, org.eclipse.ocl.examples.pivot.Class csClass) {
		int oldSize = environmentView.getSize();
		environmentView.addNamedElements(csClass.getOwnedAttributes());
		int newSize = environmentView.getSize();
		if (newSize <= oldSize) {
			for (org.eclipse.ocl.examples.pivot.Class csTypeRef : csClass.getSuperClasses()) {
				if (csTypeRef instanceof ParameterizedTypeRefCS) {
					Type csType = ((ParameterizedTypeRefCS)csTypeRef).getPivot();
					if (csType instanceof org.eclipse.ocl.examples.pivot.Class) {
						addAllReferences(environmentView, (org.eclipse.ocl.examples.pivot.Class)csType);
					}
				}
			}
		}
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == BaseCSTPackage.Literals.REFERENCE_CS__OPPOSITE) {
			TypedRefCS typeRef = target.getOwnedType();
			if (typeRef instanceof ParameterizedTypeRefCS) {
				Type type = ((ParameterizedTypeRefCS)typeRef).getPivot();
				if (type instanceof org.eclipse.ocl.examples.pivot.Class) {
					addAllReferences(environmentView, (org.eclipse.ocl.examples.pivot.Class)type);
				}
			}
			return null;
		}
		else {
			return scopeView.getOuterScope();
		}
	}
}
