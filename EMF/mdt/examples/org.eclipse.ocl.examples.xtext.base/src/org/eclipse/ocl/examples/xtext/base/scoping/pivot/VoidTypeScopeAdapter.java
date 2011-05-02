/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: VoidTypeScopeAdapter.java,v 1.1 2011/04/25 19:39:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class VoidTypeScopeAdapter extends ClassScopeAdapter
{
	public VoidTypeScopeAdapter(TypeManager typeManager, org.eclipse.ocl.examples.pivot.Class pivotElement) {
		super(typeManager, pivotElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		super.computeLookup(environmentView, scopeView);
		if (!environmentView.hasFinalResult()) {
			TypeManager typeManager = environmentView.getTypeManager();
			for (String packageMoniker : typeManager.getAllPackages()) {
				org.eclipse.ocl.examples.pivot.Package primaryPackage = typeManager.getPrimaryPackage(packageMoniker);
				if (primaryPackage != typeManager.getOrphanPackage()) {
					for (Type aType : typeManager.getLocalClasses(primaryPackage)) {
						org.eclipse.ocl.examples.pivot.Class primaryClass = typeManager.getPrimaryClass(aType);
						environmentView.addNamedElements(typeManager.getLocalOperations(primaryClass, Boolean.FALSE));
						environmentView.addNamedElements(typeManager.getLocalProperties(primaryClass, Boolean.FALSE));
					}
				}
			}
		}
		return scopeView.getOuterScope();
	}
}
