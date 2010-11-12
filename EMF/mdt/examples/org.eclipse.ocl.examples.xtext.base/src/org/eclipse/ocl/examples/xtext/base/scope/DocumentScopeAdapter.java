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
 * $Id: DocumentScopeAdapter.java,v 1.3 2010/05/29 15:30:45 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;

public interface DocumentScopeAdapter extends ScopeAdapter
{
	public static final TracingOption WORK = new TracingOption("org.eclipse.ocl.examples.xtext.base", "work");  //$NON-NLS-1$//$NON-NLS-2$

	void endModification();

	String getAlias(PackageCS csPackage);

	BoundDocumentCS getBoundDocument();

	long getModificationCount();
	
	DocumentCS getTarget();

	void startModification();
}
