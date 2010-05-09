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
 * $Id: ClassScopeAdapter.java,v 1.3 2010/05/09 10:26:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

public class ClassScopeAdapter extends EssentialOCLScopeAdapter<OCLinEcoreClassCS>
{
	public ClassScopeAdapter(OCLinEcoreClassCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == BaseCSTPackage.Literals.CLASS_CS__SUPER_TYPES) {
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, getTarget().getTypeParameters());
		}
		else if (containmentFeature == OCLstdlibCSTPackage.Literals.LIB_CLASS_CS__CONFORMS_TO) {
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, getTarget().getTypeParameters());
		}
		else {
			OCLinEcoreClassCS target = getTarget();
			filteredAccesses.addNamedElements(OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_OPERATION_CS, target.getOperations());
			filteredAccesses.addNamedElements(OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_STRUCTURAL_FEATURE_CS, target.getStructuralFeatures());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters());
			addInheritedContents(filteredAccesses, target); // FIXME Use getConformsTo
		}
	}

	public void addInheritedContents(FilteredAccesses filteredAccesses, OCLinEcoreClassCS target) {
		EList<TypedRefCS> superTypes = target.getSuperTypes();
		if (superTypes.size() > 0) {
			for (TypedRefCS csSuperType : superTypes) {
				filteredAccesses.addElementsOfScope(csSuperType);
			}
		}
		else {
			ClassCS libType = getLibType("Classifier");
			addLibContents(filteredAccesses, libType);
		}
	}

	public void addLibContents(FilteredAccesses filteredAccesses, ElementCS libType) {
		if (libType == null) {
			return;
		}
		filteredAccesses.addElementsOfScope(libType);
		if (libType instanceof LibClassCS) {
			for (TypedRefCS csSuperType : ((LibClassCS) libType).getConformsTo()) {
				addLibContents(filteredAccesses, csSuperType);
			}
		}
	}

	@Override
	public TypeCS getType() {
		return getTarget();
	}
}
