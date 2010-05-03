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
 * $Id: SelfExpScopeAdapter.java,v 1.1 2010/05/03 05:38:07 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class SelfExpScopeAdapter extends EssentialOCLScopeAdapter<SelfExpCS>
{
	public SelfExpScopeAdapter(SelfExpCS csElement) {
		super(csElement);
	}

	@Override
	public TypeCS getType() {
		EStructuralFeature eContainingFeature = getTarget().eContainingFeature();
		IScope scope = getExclusiveScopeAccessor(null);
		IEObjectDescription selfDescription = scope.getContentByName("self");
		if (selfDescription == null) {
			return null;
		}
		EObject selfObject = selfDescription.getEObjectOrProxy();
		AbstractScopeAdapter<?> selfScopeAdapter = getScopeAdapter(selfObject);
		if (selfScopeAdapter == null) {
			return null;
		}
		TypeCS type = selfScopeAdapter.getType();
		if (type == null) {
			return null;
		}
		return getLibType(type);
	}
}
