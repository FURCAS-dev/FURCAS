/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: PackageScopeAdapter.java,v 1.4 2011/04/20 19:02:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class PackageScopeAdapter extends AbstractPivotScopeAdapter<org.eclipse.ocl.examples.pivot.Package>
{
	public PackageScopeAdapter(TypeManager typeManager, org.eclipse.ocl.examples.pivot.Package pivotElement) {
		super(typeManager, pivotElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		TypeManager typeManager = environmentView.getTypeManager();
		environmentView.addNamedElements(typeManager.getLocalPackages(target));
		environmentView.addNamedElements(typeManager.getLocalClasses(target));
		environmentView.addNamedElements(target.getOwnedPrecedences());
		return scopeView.getOuterScope();
	}
}
