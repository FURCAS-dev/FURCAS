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
 * $Id: PackageDeclarationScopeAdapter.java,v 1.7 2011/03/01 08:47:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLCSScopeAdapter;

public class PackageDeclarationScopeAdapter extends EssentialOCLCSScopeAdapter<PackageDeclarationCS, org.eclipse.ocl.examples.pivot.Package>
{
	public PackageDeclarationScopeAdapter(TypeManager typeManager, PackageDeclarationCS csElement) {
		super(typeManager, csElement, org.eclipse.ocl.examples.pivot.Package.class);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSTPackage.Literals.PACKAGE_DECLARATION_CS__PACKAGE) {
			return getNamespaceScope(environmentView, scopeView, target.getNamespace());
		}
		else if (containmentFeature == CompleteOCLCSTPackage.Literals.PACKAGE_DECLARATION_CS__NAMESPACE) {
			return getNextNamespaceScope(environmentView, scopeView, target.getNamespace());
		}
		else if (containmentFeature == CompleteOCLCSTPackage.Literals.PACKAGE_DECLARATION_CS__CONTEXTS) {
//			return getNextNamespaceScope(environmentView, scopeView, target.getNamespace());
			org.eclipse.ocl.examples.pivot.Package pkg = target.getPackage();
			environmentView.addNamedElements(typeManager.getLocalPackages(pkg));
			environmentView.addNamedElements(typeManager.getLocalTypes(pkg));
//			environmentView.addNamedElements(pkge.getOwnedPrecedences());
		}
		return scopeView.getOuterScope();
	}
}
