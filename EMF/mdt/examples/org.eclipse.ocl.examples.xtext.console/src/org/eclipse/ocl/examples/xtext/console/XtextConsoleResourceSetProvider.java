/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XtextConsoleResourceSetProvider.java,v 1.1 2011/03/11 15:26:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.console;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;


public class XtextConsoleResourceSetProvider extends XtextResourceSetProvider
{
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private XtextResourceSet nullProjectResourceSet = null;

	@Override
	public ResourceSet get(IProject project) {			// FIXME Workaround for Bug 339640
		if (project != null) {
			return super.get(project);
		}
		else {
			if (nullProjectResourceSet == null) {
				nullProjectResourceSet = resourceSetProvider.get();
			}
			return nullProjectResourceSet;
		}
	}
}
