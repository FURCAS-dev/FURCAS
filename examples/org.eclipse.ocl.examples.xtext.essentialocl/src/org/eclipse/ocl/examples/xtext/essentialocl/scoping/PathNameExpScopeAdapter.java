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
 * $Id: PathNameExpScopeAdapter.java,v 1.6 2010/05/16 19:19:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.QualifiedRefScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS;

public class PathNameExpScopeAdapter extends QualifiedRefScopeAdapter<PathNameExpCS>
{
	public PathNameExpScopeAdapter(PathNameExpCS csElement) {
		super(csElement);
	}

	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		ScopeAdapter scopeAdapter = getScopeAdapter(getTarget().getElement());
		return scopeAdapter != null ? scopeAdapter.getSynthesizedType(bindings) : null;
	}
}
