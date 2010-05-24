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
 * $Id: SubExpScopeAdapter.java,v 1.3 2010/05/24 08:55:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;


public abstract class SubExpScopeAdapter<T extends ExpCS> extends ExpScopeAdapter<T>
{
	public SubExpScopeAdapter(T csElement) {
		super(csElement);
	}
}
