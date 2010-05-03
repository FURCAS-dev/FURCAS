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
 * $Id: QualifiedStructuralFeatureRefScopeAdapter.java,v 1.1 2010/05/03 05:24:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;

public class QualifiedStructuralFeatureRefScopeAdapter extends AbstractScopeAdapter<QualifiedStructuralFeatureRefCS>
{
	public QualifiedStructuralFeatureRefScopeAdapter(QualifiedStructuralFeatureRefCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {			
		}
		else if (filteredAccesses == BaseCSTPackage.Literals.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__FEATURE) {
		}
		else {
			QualifiedStructuralFeatureRefCS target = getTarget();
			AbstractScopeAdapter<?> scopeAdapter = AbstractScopeAdapter.getScopeAdapter(target.getNamespace());
			if (scopeAdapter != null) {
				scopeAdapter.createContents(filteredAccesses, null);
			}
		}
	}
}
