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
 * $Id: LibPackageScopeAdapter.java,v 1.4 2010/05/16 19:20:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.scoping;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPackageCS;

public class LibPackageScopeAdapter extends OCLstdlibScopeAdapter<LibPackageCS>
{
	public LibPackageScopeAdapter(LibPackageCS csElement) {
		super(csElement);
	}

	@Override
	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		TypeBindingsCS bindings = scopeView.getBindings();
		LibPackageCS target = getTarget();
		environmentView.addNamedElements(BaseCSTPackage.Literals.PACKAGE_CS, target.getSubpackages(), bindings);
		environmentView.addNamedElements(BaseCSTPackage.Literals.CLASSIFIER_CS, target.getClassifiers(), bindings);
		return scopeView.getOuterScope();
	}
}
