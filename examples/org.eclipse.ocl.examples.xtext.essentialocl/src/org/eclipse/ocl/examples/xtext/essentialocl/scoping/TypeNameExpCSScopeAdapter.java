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
 * $Id: TypeNameExpCSScopeAdapter.java,v 1.3 2011/05/06 09:05:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ModelElementCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS;

public class TypeNameExpCSScopeAdapter extends ModelElementCSScopeAdapter<TypeNameExpCS, Element>
{
	public TypeNameExpCSScopeAdapter(TypeManager typeManager, TypeNameExpCS csElement) {
		super(typeManager, csElement, Element.class);	// FIXME
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == EssentialOCLCSTPackage.Literals.TYPE_NAME_EXP_CS__ELEMENT) {
			List<Namespace> namespaces = target.getNamespace();
			int namespaceCount = namespaces.size();
			if (namespaceCount > 0) {
				Namespace eObject = namespaces.get(namespaceCount-1);
				if ((eObject == null) || eObject.eIsProxy()) {
					return null;
				}
				ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, eObject);
				if (scopeAdapter == null) {
					return null;
				}				
				return scopeAdapter.computeLookup(environmentView, scopeView);
			}
		}
		return scopeView.getOuterScope();
	}
}
