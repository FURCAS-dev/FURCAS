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
 * $Id: EnumerationScopeAdapter.java,v 1.5 2011/04/25 09:50:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class EnumerationScopeAdapter extends AbstractPivotScopeAdapter<org.eclipse.ocl.examples.pivot.Enumeration>
{
	public EnumerationScopeAdapter(TypeManager typeManager, org.eclipse.ocl.examples.pivot.Enumeration pivotElement) {
		super(typeManager, pivotElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		TypeManager typeManager = environmentView.getTypeManager();
		environmentView.addElements(target.getOwnedLiterals());
		environmentView.addElementsOfScope(typeManager.getEnumerationType(), scopeView);
		if (!environmentView.hasFinalResult()) {
			environmentView.addElementsOfScope(typeManager.getOclAnyType(), scopeView);
		}	// FIXME Use ClassScopeAdapter.addInheritedContents consistently
		return scopeView.getOuterScope();
	}
}
