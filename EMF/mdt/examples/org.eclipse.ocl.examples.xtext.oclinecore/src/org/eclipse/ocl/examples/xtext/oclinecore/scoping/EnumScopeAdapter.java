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
 * $Id: EnumScopeAdapter.java,v 1.4 2010/08/17 06:51:08 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;

public class EnumScopeAdapter extends OCLinEcoreScopeAdapter<EnumCS>
{
	public EnumScopeAdapter(EnumCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		TypeBindingsCS bindings = scopeView.getBindings();
		EnumCS target = getTarget();
		environmentView.addNamedElements(BaseCSTPackage.Literals.ENUM_LITERAL_CS, target.getLiterals(), bindings);
		environmentView.addNamedElements(BaseCSTPackage.Literals.TYPE_PARAMETER_CS, target.getTypeParameters(), bindings);
		addLibContents(environmentView, getLibraryOclAnyType(), scopeView);
		return scopeView.getOuterScope();
	}
}
