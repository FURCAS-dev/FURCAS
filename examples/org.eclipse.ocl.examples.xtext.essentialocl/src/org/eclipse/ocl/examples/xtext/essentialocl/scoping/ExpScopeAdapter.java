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
 * $Id: ExpScopeAdapter.java,v 1.2 2010/05/24 08:55:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;

public abstract class ExpScopeAdapter<T extends ExpCS> extends EssentialOCLScopeAdapter<T>
{
	public ExpScopeAdapter(T csElement) {
		super(csElement);
	}

	protected ScopeAdapter getParentSourceScope() {
		return getParent().getSourceScope(getTarget().eContainingFeature());
	}

	@Override
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		return getParentSourceScope();
	}

	@Override
	public abstract ClassifierCS getSynthesizedType(TypeBindingsCS bindings);
}
