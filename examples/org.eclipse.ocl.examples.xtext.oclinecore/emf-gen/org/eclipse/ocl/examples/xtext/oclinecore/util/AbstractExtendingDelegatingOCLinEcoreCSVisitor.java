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
 * $Id: AbstractExtendingDelegatingOCLinEcoreCSVisitor.java,v 1.5 2011/02/11 20:59:20 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclinecore.util;

import org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractDelegatingEssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * An AbstractExtendingDelegatingOCLinEcoreCSVisitor delegates all visits.
 */
public abstract class AbstractExtendingDelegatingOCLinEcoreCSVisitor<R, C, D extends EssentialOCLCSVisitor<R, C>>
	extends AbstractDelegatingEssentialOCLCSVisitor<R, C, D>
	implements OCLinEcoreCSVisitor<R, C>
{
    protected AbstractExtendingDelegatingOCLinEcoreCSVisitor(D delegate, C context) {
        super(delegate, context);
    }

	@Override
	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
		return delegate.visiting(visitable);
	}

	public R visitOCLinEcoreConstraintCS(org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS object) {
		return delegate.visitExpConstraintCS(object);
	}
}
