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
 * $Id: LibOperationScopeAdapter.java,v 1.2 2010/05/04 06:43:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.scope.FilteredAccesses;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;

public class LibOperationScopeAdapter extends OCLstdlibScopeAdapter<OperationCS>
{
	public LibOperationScopeAdapter(OperationCS csElement) {
		super(csElement);
	}

	@Override
	public void createContents(FilteredAccesses filteredAccesses, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {
		}
		else if (containmentFeature == BaseCSTPackage.Literals.OPERATION_CS__PARAMETERS) {
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, getTarget().getTypeParameters());
		}
		else {
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.PARAMETER_CS, getTarget().getParameters());
			filteredAccesses.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, getTarget().getTypeParameters());
		}
	}
}
