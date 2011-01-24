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
 * $Id: OCLstdlibScopeVisitor.java,v 1.2 2011/01/24 22:28:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.ConstraintCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.EmptyCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.cs.RootPackageCSScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLScopeVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.LibOperationScopeAdapter;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;

public class OCLstdlibScopeVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<ScopeCSAdapter, TypeManager, EssentialOCLScopeVisitor>
{
	public OCLstdlibScopeVisitor(TypeManager context) {
		super(new EssentialOCLScopeVisitor(context), context);
	}
	
	@Override
	public ScopeCSAdapter visitLibConstraintCS(LibConstraintCS csObject) {
		return new ConstraintCSScopeAdapter(context, csObject);
	}

	@Override
	public ScopeCSAdapter visitLibIterationCS(LibIterationCS csObject) {
		return new LibOperationScopeAdapter(context, csObject);
	}

	@Override
	public ScopeCSAdapter visitLibOperationCS(LibOperationCS csObject) {
		return new LibOperationScopeAdapter(context, csObject);
	}

	@Override
	public ScopeCSAdapter visitLibPropertyCS(LibPropertyCS csObject) {
		return new EmptyCSScopeAdapter(context, csObject);
	}

	@Override
	public ScopeCSAdapter visitLibRootPackageCS(LibRootPackageCS csObject) {
		return new RootPackageCSScopeAdapter(context, csObject);
	}

	@Override
	public ScopeCSAdapter visitParameterCS(ParameterCS csObject) {
		return new EmptyCSScopeAdapter(context, csObject);
	}
}