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
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.xtext.oclstdlib/model/OCLstdlibCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractDelegatingOCLstdlibCSVisitor.java,v 1.9 2011/05/05 17:53:38 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.util;

/**
 * An AbstractDelegatingOCLstdlibCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLstdlibCSVisitor<R, C, D extends OCLstdlibCSVisitor<R, C>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLstdlibCSVisitor<R, C>
{
    protected AbstractDelegatingOCLstdlibCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitLibClassCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS object) {
		return delegate.visitLibClassCS(object);
	}

	public R visitLibConstraintCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS object) {
		return delegate.visitLibConstraintCS(object);
	}

	public R visitLibIterationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS object) {
		return delegate.visitLibIterationCS(object);
	}

	public R visitLibOperationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS object) {
		return delegate.visitLibOperationCS(object);
	}

	public R visitLibPropertyCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS object) {
		return delegate.visitLibPropertyCS(object);
	}

	public R visitLibRootPackageCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS object) {
		return delegate.visitLibRootPackageCS(object);
	}

	public R visitMetaTypeName(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName object) {
		return delegate.visitMetaTypeName(object);
	}

	public R visitPrecedenceCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS object) {
		return delegate.visitPrecedenceCS(object);
	}
}
