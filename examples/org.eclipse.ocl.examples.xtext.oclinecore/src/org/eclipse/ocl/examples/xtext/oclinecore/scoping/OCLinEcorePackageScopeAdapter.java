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
 * $Id: OCLinEcorePackageScopeAdapter.java,v 1.1 2010/05/03 05:44:34 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;
import org.eclipse.xtext.resource.IEObjectDescription;

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
		filteredAccesses.addNamedElements(BaseCSTPackage.Literals.PACKAGE_CS, getTarget().getSubpackages());
		filteredAccesses.addNamedElements(OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CLASSIFIER_CS, getTarget().getClassifiers());
		filteredAccesses.addNamedElements(OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CLASS_CS, getTarget().getClassifiers());
	}
}
