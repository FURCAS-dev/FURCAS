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
 * $Id: OCLinEcoreScopeVisitor.java,v 1.2 2011/01/24 21:43:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLScopeVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.util.AbstractExtendingDelegatingOCLinEcoreCSVisitor;

public class OCLinEcoreScopeVisitor
	extends AbstractExtendingDelegatingOCLinEcoreCSVisitor<ScopeCSAdapter, TypeManager, EssentialOCLScopeVisitor>
{
	public OCLinEcoreScopeVisitor(TypeManager context) {
		super(new EssentialOCLScopeVisitor(context), context);
	}
}