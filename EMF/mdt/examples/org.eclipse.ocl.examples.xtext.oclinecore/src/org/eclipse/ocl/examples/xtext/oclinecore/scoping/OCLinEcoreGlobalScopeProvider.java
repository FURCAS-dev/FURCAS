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
 * $Id: OCLinEcoreGlobalScopeProvider.java,v 1.3 2010/05/09 10:26:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

public class OCLinEcoreGlobalScopeProvider extends DefaultGlobalScopeProvider
{
	@Override
	protected List<IContainer> getVisibleContainers(EObject context) {
		// FIXME This is a workaround for Bug 308151 to stop an NPE on a dummy in-memory resource 
		Resource resource = context.eResource();
		URI uri = resource.getURI();
		boolean hasDevice = uri.hasDevice();
		int segmentCount = uri.segmentCount();
		if ((segmentCount <= 1) && !hasDevice) {
			return Collections.emptyList();
		}
		return super.getVisibleContainers(context);
	}
}
