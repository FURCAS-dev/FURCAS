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
 * $Id: OperationScopeAdapter.java,v 1.3 2010/05/16 19:22:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;

public class OperationScopeAdapter extends EssentialOCLScopeAdapter<OCLinEcoreOperationCS>
{
	public OperationScopeAdapter(OCLinEcoreOperationCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		TypeBindingsCS bindings = scopeView.getBindings();
		OCLinEcoreOperationCS target = getTarget();
		if (containmentFeature == BaseCSTPackage.Literals.OPERATION_CS__PARAMETERS) {
		}
		else {
			environmentView.addNamedElements(BaseCSTPackage.Literals.PARAMETER_CS, target.getParameters(), bindings);
		}
		environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
		return scopeView.getOuterScope();
	}
}
