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
 * $Id: PathNameExpScopeAdapter.java,v 1.5 2010/05/09 17:08:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS;

public class PathNameExpScopeAdapter extends AbstractScopeAdapter<PathNameExpCS>
{
	public PathNameExpScopeAdapter(PathNameExpCS csElement) {
		super(csElement);
	}

	@Override
	public boolean computeInheritedEnvironmentView(EnvironmentView environmentView, EStructuralFeature containmentFeature) {
		if (containmentFeature == null) {			
		}
		else {
			PathNameExpCS target = getTarget();
			AbstractScopeAdapter<?> scopeAdapter = AbstractScopeAdapter.getScopeAdapter(target.getNamespace());
			if (scopeAdapter != null) {
				scopeAdapter.getInclusiveInheritedContents(environmentView);
			}
		}
		return true;
	}

	@Override
	public TypeCS getType() {
		AbstractScopeAdapter<?> scopeAdapter = getScopeAdapter(getTarget().getElement());
		return scopeAdapter != null ? scopeAdapter.getType() : null;
	}
}
