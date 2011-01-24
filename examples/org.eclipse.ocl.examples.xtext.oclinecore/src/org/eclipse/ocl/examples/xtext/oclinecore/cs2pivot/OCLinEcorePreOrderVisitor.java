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
 * $Id: OCLinEcorePreOrderVisitor.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.util.AbstractExtendingDelegatingOCLinEcoreCSVisitor;

public class OCLinEcorePreOrderVisitor
	extends AbstractExtendingDelegatingOCLinEcoreCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{
	public OCLinEcorePreOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPreOrderVisitor(context), context);
	}
}