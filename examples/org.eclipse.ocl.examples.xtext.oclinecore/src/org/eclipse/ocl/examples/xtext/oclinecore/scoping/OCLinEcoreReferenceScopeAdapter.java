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
 * $Id: OCLinEcoreReferenceScopeAdapter.java,v 1.1 2010/05/09 14:28:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;

public class OCLinEcoreReferenceScopeAdapter extends EssentialOCLScopeAdapter<OCLinEcoreReferenceCS>
{
	public OCLinEcoreReferenceScopeAdapter(OCLinEcoreReferenceCS csElement) {
		super(csElement);
	}

	public void addAllReferences(FilteredAccesses filteredAccesses, ClassCS csClass) {
		int oldSize = filteredAccesses.getSize();
		filteredAccesses.addNamedElements(BaseCSTPackage.Literals.REFERENCE_CS, csClass.getStructuralFeatures());
		int newSize = filteredAccesses.getSize();
		if (newSize <= oldSize) {
			for (TypedRefCS csTypeRef : csClass.getSuperTypes()) {
				if (csTypeRef instanceof TypedTypeRefCS) {
					TypeCS csType = ((TypedTypeRefCS)csTypeRef).getType();
					if (csType instanceof ClassCS) {
						addAllReferences(filteredAccesses, (ClassCS)csType);
					}
				}
			}
		}
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == BaseCSTPackage.Literals.REFERENCE_CS__OPPOSITE) {
			OCLinEcoreReferenceCS target = getTarget();
			TypedRefCS typeRef = target.getType();
			if (typeRef instanceof TypedTypeRefCS) {
				TypeCS type = ((TypedTypeRefCS)typeRef).getType();
				if (type instanceof ClassCS) {
					addAllReferences(filteredAccesses, (ClassCS)type);
				}
			}
		}
	}
}
