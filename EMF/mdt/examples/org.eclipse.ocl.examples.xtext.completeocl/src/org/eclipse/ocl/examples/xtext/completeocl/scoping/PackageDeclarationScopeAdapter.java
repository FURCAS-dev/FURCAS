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
 * $Id: PackageDeclarationScopeAdapter.java,v 1.4 2010/05/16 19:26:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.scoping;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;

public class PackageDeclarationScopeAdapter extends EssentialOCLScopeAdapter<PackageDeclarationCS>
{
	public PackageDeclarationScopeAdapter(PackageDeclarationCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == CompleteOCLCSTPackage.Literals.PACKAGE_DECLARATION_CS__PACKAGE) {
			return scopeView.getOuterScope();
		}
		if ((containmentFeature == null)
		 || (containmentFeature == CompleteOCLCSTPackage.Literals.PACKAGE_DECLARATION_CS__CONTEXTS)) {
			PackageRefCS csPackageRef = getTarget().getPackage();
			while (csPackageRef instanceof QualifiedPackageRefCS) {
				csPackageRef = ((QualifiedPackageRefCS)csPackageRef).getElement();
			}
			if (csPackageRef instanceof SimplePackageRefCS) {
				SimplePackageRefCS csSimplePackageRef = (SimplePackageRefCS)csPackageRef;
				environmentView.addElementsOfScope(csSimplePackageRef.getPackage(), scopeView);
			}
		}
		else {
			return scopeView.getOuterScope();
		}
		return scopeView.getOuterScope();
	}
}
