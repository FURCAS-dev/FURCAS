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
 * $Id: LibClassScopeAdapter.java,v 1.6 2010/05/29 15:31:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

public class LibClassScopeAdapter extends OCLstdlibScopeAdapter<LibClassCS>
{
	public LibClassScopeAdapter(LibClassCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		TypeBindingsCS bindings = scopeView.getBindings();
		LibClassCS target = getTarget();
		if (containmentFeature == OCLstdlibCSTPackage.Literals.LIB_CLASS_CS__CONFORMS_TO) {
			environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
			return scopeView.getOuterScope();
		}
		else {
			environmentView.addNamedElements(BaseCSTPackage.Literals.OPERATION_CS, target.getOperations(), bindings);
			environmentView.addNamedElements(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS, target.getStructuralFeatures(), bindings);
			environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
			if ((environmentView.getSize() == 0) && (environmentView.getRequiredType() != BaseCSTPackage.Literals.TYPE_CS)) { // Avoid creating bindings for nested type parameters
				for (TypedRefCS csSuperType : target.getConformsTo()) {
					TypeCS csType = getLibraryType(csSuperType, bindings);
					ScopeView nestedScopeView = scopeView;
					if (csType instanceof BoundClassifierCS) {
						nestedScopeView = new BaseScopeView(scopeView, ((BoundClassifierCS)csType).getBindings());
					}
					environmentView.addElementsOfScope(csType, nestedScopeView);
				}
			}
			return scopeView.getOuterScope();
		}
	}
	
	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		return getLibraryType(getTarget(), bindings);
	}
}
