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
 * $Id: LibClassScopeAdapter.java,v 1.1 2010/05/03 05:29:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.ElementUtil;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class LibClassScopeAdapter extends OCLstdlibScopeAdapter<LibClassCS>
{
	public LibClassScopeAdapter(LibClassCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == OCLstdlibCSTPackage.Literals.LIB_CLASS_CS__CONFORMS_TO) {
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, getTarget().getTypeParameters());
		}
		else {
			LibClassCS target = getTarget();
			filteredAccesses.addNamedElements(OCLstdlibCSTPackage.Literals.LIB_ITERATION_CS, target.getIterations());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.OPERATION_CS, target.getOperations());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS, target.getStructuralFeatures());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters());
			for (TypedRefCS csSuperType : target.getConformsTo()) {
				filteredAccesses.addElementsOfScope(csSuperType);
			}
		}
	}
}
