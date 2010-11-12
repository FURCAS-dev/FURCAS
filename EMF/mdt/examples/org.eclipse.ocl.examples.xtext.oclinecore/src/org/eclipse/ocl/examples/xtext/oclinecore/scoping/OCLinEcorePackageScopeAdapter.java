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
 * $Id: OCLinEcorePackageScopeAdapter.java,v 1.6 2010/05/16 19:22:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;

public class OCLinEcorePackageScopeAdapter extends EssentialOCLScopeAdapter<OCLinEcorePackageCS>
{
	public OCLinEcorePackageScopeAdapter(OCLinEcorePackageCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		OCLinEcorePackageCS target = getTarget();
		TypeBindingsCS bindings = scopeView.getBindings();
		environmentView.addNamedElements(BaseCSTPackage.Literals.PACKAGE_CS, target.getSubpackages(), bindings);
		environmentView.addNamedElements(BaseCSTPackage.Literals.CLASSIFIER_CS, target.getClassifiers(), bindings);
		environmentView.addNamedElements(BaseCSTPackage.Literals.CLASS_CS, target.getClassifiers(), bindings);
		environmentView.addNamedElements(BaseCSTPackage.Literals.NAMESPACE_CS, target.getClassifiers(), bindings);		// FIXME needed for Enums
		return scopeView.getOuterScope();
	}
}
