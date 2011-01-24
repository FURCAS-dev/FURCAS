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
 * from: /org.eclipse.ocl.examples.xtext.oclinecore/model/OCLinEcoreCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractDelegatingOCLinEcoreCSVisitor.java,v 1.2 2011/01/24 21:43:56 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclinecore.util;

/**
 * An AbstractDelegatingOCLinEcoreCSVisitor delegates all visits.
 */
public abstract class AbstractDelegatingOCLinEcoreCSVisitor<R, C, D extends OCLinEcoreCSVisitor<R, C>>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLinEcoreCSVisitor<R, C>
{
    protected AbstractDelegatingOCLinEcoreCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitOCLinEcoreConstraintCS(org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS object) {
		return delegate.visitOCLinEcoreConstraintCS(object);
	}
}
