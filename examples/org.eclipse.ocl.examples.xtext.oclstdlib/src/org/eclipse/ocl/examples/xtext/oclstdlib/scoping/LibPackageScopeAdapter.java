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
 * $Id: LibPackageScopeAdapter.java,v 1.1 2010/05/03 05:29:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS;

public class LibPackageScopeAdapter extends OCLstdlibScopeAdapter<LibPackageCS>
{
	public LibPackageScopeAdapter(LibPackageCS csElement) {
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
		filteredAccesses.addNamedElements(BaseCSTPackage.Literals.CLASSIFIER_CS, getTarget().getClassifiers());
/*		else if (ElementUtil.conformsTo(eStructuralFeature, OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CLASS_CS)) {
			for (ClassifierCS classifier : getTarget().getClassifiers()) {
				if (classifier instanceof OCLinEcoreClassCS) {
					descriptions = appendNamedElementDescription(descriptions, classifier);
				}
			}
		} */
	}
}
