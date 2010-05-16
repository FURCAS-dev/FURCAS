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
 * $Id: BoundClassifierScopeAdapter.java,v 1.1 2010/05/16 19:18:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;

public class BoundClassifierScopeAdapter extends AbstractScopeAdapter<BoundClassifierCS>
{
	public BoundClassifierScopeAdapter(BoundClassifierCS csElement) {
		super(csElement.getBinds().eContainer(), csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
//		System.out.println("Start computeLookup " + getSignature());
		BoundClassifierCS target = getTarget();
		BaseScopeView boundScopeView = new BaseScopeView(scopeView, target.getBindings());
		environmentView.addElementsOfScope(target.getBinds(), boundScopeView);
//		System.out.println("End computeLookup " + getSignature());
		return scopeView.getOuterScope();
	}
}
