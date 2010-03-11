/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.modelregistry.eclipse;

import org.eclipse.core.resources.IResource;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;

/**
 * ModelResourceResolver supports use of the ModelRegistry in an Eclipse application using
 * org.eclipse.core.resources.IResource as the handle on the physical model storage medium.
 */
public class ModelResourceResolver extends AbstractModelResolver
{
	public static EclipseFileHandle createFileHandle(IResource resource) {
		EclipseProjectHandle projectHandle = new EclipseProjectHandle(resource.getProject());
		return projectHandle.getFileHandle(resource);
	}
	
	public ModelResourceResolver(IResource resource) {
		super(createFileHandle(resource));
	}
}
