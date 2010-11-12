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
 * $Id: OCLinEcoreReferenceScopeAdapter.java,v 1.4 2010/08/17 07:52:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;

public class OCLinEcoreReferenceScopeAdapter extends EssentialOCLScopeAdapter<OCLinEcoreReferenceCS>
{
	public OCLinEcoreReferenceScopeAdapter(OCLinEcoreReferenceCS csElement) {
		super(csElement);
	}

	public void addAllReferences(EnvironmentView environmentView, ClassCS csClass, TypeBindingsCS bindings) {
		int oldSize = environmentView.getSize();
		environmentView.addNamedElements(BaseCSTPackage.Literals.REFERENCE_CS, csClass.getStructuralFeatures(), bindings);
		int newSize = environmentView.getSize();
		if (newSize <= oldSize) {
			for (TypedRefCS csTypeRef : csClass.getSuperTypes()) {
				if (csTypeRef instanceof ParameterizedTypeRefCS) {
					TypeCS csType = ((ParameterizedTypeRefCS)csTypeRef).getType();
					if (csType instanceof ClassCS) {
						addAllReferences(environmentView, (ClassCS)csType, bindings);
					}
				}
			}
		}
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == BaseCSTPackage.Literals.REFERENCE_CS__OPPOSITE) {
			OCLinEcoreReferenceCS target = getTarget();
			TypedRefCS typeRef = target.getType();
			if (typeRef instanceof ParameterizedTypeRefCS) {
				TypeCS type = ((ParameterizedTypeRefCS)typeRef).getType();
				if (type instanceof ClassCS) {
					addAllReferences(environmentView, (ClassCS)type, scopeView.getBindings());
				}
			}
			return null;
		}
		else {
			return scopeView.getOuterScope();
		}
	}
}
