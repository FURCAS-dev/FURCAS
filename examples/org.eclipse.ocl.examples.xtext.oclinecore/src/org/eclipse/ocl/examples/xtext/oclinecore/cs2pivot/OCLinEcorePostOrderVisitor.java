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
 * $Id: OCLinEcorePostOrderVisitor.java,v 1.4 2011/03/01 08:46:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.util.AbstractExtendingDelegatingOCLinEcoreCSVisitor;

public class OCLinEcorePostOrderVisitor
	extends AbstractExtendingDelegatingOCLinEcoreCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{
	public OCLinEcorePostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}
}