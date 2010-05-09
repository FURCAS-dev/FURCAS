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
 * $Id: LibClassScopeAdapter.java,v 1.3 2010/05/09 17:08:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

public class LibClassScopeAdapter extends OCLstdlibScopeAdapter<LibClassCS>
{
	public LibClassScopeAdapter(LibClassCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == OCLstdlibCSTPackage.Literals.LIB_CLASS_CS__CONFORMS_TO) {
			environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, getTarget().getTypeParameters());
		}
		else {
			LibClassCS target = getTarget();
			environmentView.addNamedElements(OCLstdlibCSTPackage.Literals.LIB_ITERATION_CS, target.getIterations());
			environmentView.addNamedElements(BaseCSTPackage.Literals.OPERATION_CS, target.getOperations());
			environmentView.addNamedElements(BaseCSTPackage.Literals.STRUCTURAL_FEATURE_CS, target.getStructuralFeatures());
			environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters());
			for (TypedRefCS csSuperType : target.getConformsTo()) {
				environmentView.addElementsOfScope(csSuperType);
			}
		}
		return true;
	}
}
