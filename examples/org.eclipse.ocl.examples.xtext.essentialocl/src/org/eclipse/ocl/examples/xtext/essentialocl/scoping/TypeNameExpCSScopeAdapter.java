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
 * $Id: TypeNameExpCSScopeAdapter.java,v 1.2 2011/01/24 21:31:46 ewillink Exp $
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
				ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, namespaces.get(namespaceCount-1));
				if (scopeAdapter != null) {
					return scopeAdapter.computeLookup(environmentView, scopeView);
				}				
				return null;
			}
		}
		return scopeView.getOuterScope();
	}
}
