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
 * $Id: ClassScopeAdapter.java,v 1.7 2010/08/17 06:51:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

public class ClassScopeAdapter extends OCLinEcoreScopeAdapter<OCLinEcoreClassCS>
{
	public ClassScopeAdapter(OCLinEcoreClassCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		TypeBindingsCS bindings = scopeView.getBindings();
		OCLinEcoreClassCS target = getTarget();
		if ((containmentFeature == BaseCSTPackage.Literals.CLASS_CS__SUPER_TYPES)
		 || (containmentFeature == OCLstdlibCSTPackage.Literals.LIB_CLASS_CS__CONFORMS_TO)) {
			environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
			return scopeView.getOuterScope();
		}
		else {
			environmentView.addNamedElements(OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_OPERATION_CS, target.getOperations(), bindings);
			environmentView.addNamedElements(OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_STRUCTURAL_FEATURE_CS, target.getStructuralFeatures(), bindings);
			environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
			addInheritedContents(environmentView, target, scopeView); // FIXME Use getConformsTo
			return scopeView.getOuterScope();
		}
	}

	public void addInheritedContents(EnvironmentView environmentView, OCLinEcoreClassCS target, ScopeView scopeView) {
		EList<TypedRefCS> superTypes = target.getSuperTypes();
		if (superTypes.size() > 0) {
			for (TypedRefCS csSuperType : superTypes) {
				environmentView.addElementsOfScope(csSuperType, scopeView);
			}
		}
		else {
			ClassifierCS libType = getLibraryClassifierType();
			addLibContents(environmentView, libType, scopeView);
		}
	}
	
	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		return getLibraryType(getTarget(), bindings);
	}
}
