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
 * $Id: LibOperationScopeAdapter.java,v 1.5 2010/05/16 19:20:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class LibOperationScopeAdapter extends OCLstdlibScopeAdapter<OperationCS>
{
	public LibOperationScopeAdapter(OperationCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		TypeBindingsCS bindings = scopeView.getBindings();
		OperationCS target = getTarget();
		if (containmentFeature == BaseCSTPackage.Literals.OPERATION_CS__PARAMETERS) {
		}
		else {
			environmentView.addNamedElements(BaseCSTPackage.Literals.PARAMETER_CS, target.getParameters(), bindings);
		}
		environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
		return scopeView.getOuterScope();
	}
}
