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
 * $Id: LibBoundClassScopeAdapter.java,v 1.1 2010/05/16 19:20:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibBoundClassCS;

public class LibBoundClassScopeAdapter extends OCLstdlibScopeAdapter<LibBoundClassCS>
{
	public LibBoundClassScopeAdapter(LibBoundClassCS csElement) {
		super(csElement.getBinds(), csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		ScopeAdapter scopeAdapter = getScopeAdapter(getTarget().getBinds());
		ScopeView boundScopeView = new BaseScopeView(scopeView, getTarget().getBindings());
		ScopeView outerScope = scopeAdapter.computeLookup(environmentView, boundScopeView);
		return outerScope;				// FIXME cache specializations
	}
}
