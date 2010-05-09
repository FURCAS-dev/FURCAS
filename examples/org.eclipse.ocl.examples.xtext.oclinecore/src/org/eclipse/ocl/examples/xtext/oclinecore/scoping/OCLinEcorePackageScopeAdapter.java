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
 * $Id: OCLinEcorePackageScopeAdapter.java,v 1.4 2010/05/09 14:28:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;

public class OCLinEcorePackageScopeAdapter extends EssentialOCLScopeAdapter<OCLinEcorePackageCS>
{
	public OCLinEcorePackageScopeAdapter(OCLinEcorePackageCS csElement) {
		super(csElement);
	}

	@Override
	public AbstractScopeAdapter<?> getScopeAdapter(String scopeName, boolean isNested) {
		PackageCS csPackage = ElementUtil.getNamedElementCS(getTarget().getSubpackages(), scopeName);
		if (csPackage != null) {
			return getScopeAdapter(csPackage);
		}
		ClassifierCS csClassifier = ElementUtil.getNamedElementCS(getTarget().getClassifiers(), scopeName);
		if (csClassifier != null) {
			return getScopeAdapter(csClassifier);
		}
		return super.getScopeAdapter(scopeName, isNested);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {			
		}
		else {
			OCLinEcorePackageCS target = getTarget();
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.PACKAGE_CS, target.getSubpackages());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.CLASSIFIER_CS, target.getClassifiers());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.CLASS_CS, target.getClassifiers());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.NAMESPACE_CS, target.getClassifiers());		// FIXME needed for Enums
		}
	}
}
