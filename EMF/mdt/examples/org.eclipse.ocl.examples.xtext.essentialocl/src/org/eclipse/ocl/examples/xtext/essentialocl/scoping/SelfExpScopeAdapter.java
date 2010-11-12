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
 * $Id: SelfExpScopeAdapter.java,v 1.4 2010/05/21 20:12:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class SelfExpScopeAdapter extends ExpScopeAdapter<SelfExpCS>
{
	public SelfExpScopeAdapter(SelfExpCS csElement) {
		super(csElement);
	}

	@Override
	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		IScope scope = getOuterScopeView(null, bindings);
		IEObjectDescription selfDescription = scope.getContentByName("self");
		if (selfDescription == null) {
			return null;
		}
		EObject selfObject = selfDescription.getEObjectOrProxy();
		ScopeAdapter selfScopeAdapter = getScopeAdapter(selfObject);
		if (selfScopeAdapter == null) {
			return null;
		}
		TypeCS type = selfScopeAdapter.getSynthesizedType(bindings);
		if (type == null) {
			return null;
		}
		return getLibraryType(type, bindings);
	}
}
