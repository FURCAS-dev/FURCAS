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
 * $Id: AbstractExtendingDelegatingOCLstdlibCSVisitor.java,v 1.4 2011/02/11 20:59:23 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.util;

import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingOCLstdlibCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingOCLstdlibCSVisitor<R, C, D extends EssentialOCLCSVisitor<R, C>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLstdlibCSVisitor<R, C>
{
    protected AbstractExtendingDelegatingOCLstdlibCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitLibAccumulatorCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibAccumulatorCS object) {
		return delegate.visitParameterCS(object);
	}

	public R visitLibClassCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS object) {
		return delegate.visitClassCS(object);
	}

	public R visitLibConstraintCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS object) {
		return delegate.visitExpConstraintCS(object);
	}

	public R visitLibIterationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS object) {
		return delegate.visitOperationCS(object);
	}

	public R visitLibIteratorCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIteratorCS object) {
		return delegate.visitParameterCS(object);
	}

	public R visitLibOperationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS object) {
		return delegate.visitOperationCS(object);
	}

	public R visitLibPropertyCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS object) {
		return delegate.visitAttributeCS(object);
	}

	public R visitLibRootPackageCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS object) {
		return delegate.visitRootPackageCS(object);
	}

	public R visitPrecedenceCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS object) {
		return delegate.visitNamedElementCS(object);
	}
}
