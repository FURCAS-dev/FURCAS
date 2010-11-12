/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: EclipseFileHandle.java,v 1.3 2010/04/08 06:23:49 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.eclipse;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;

public class EclipseFileHandle extends PlatformObject implements FileHandle
{
	protected final EclipseProjectHandle projectHandle;
	protected final IResource resource;
	private URI uri = null;
	
	protected EclipseFileHandle(IProject project) {
		this.projectHandle = (EclipseProjectHandle) this;
		this.resource = project;
	}
	
	public EclipseFileHandle(EclipseProjectHandle projectHandle, IResource resource) {
		this.projectHandle = projectHandle;
		this.resource = resource;
	}

	public boolean exists() {
		return resource.exists();
	}
	
	public String getAbsoluteName() {
		if (resource == null)
			return null;
		IPath path = resource.getRawLocation();
		if (path == null)
			path = resource.getFullPath();
		return String.valueOf(path);
	}

	public InputStream getContents() throws CoreException {
		return ((IFile)resource).getContents();
	}

	public String getName() {
		return resource.getName();
	}
	
	public EclipseFileHandle getParentFileHandle() {
		IResource parent = resource.getParent();
		return projectHandle.getFileHandle(parent);
	}
	
	public ProjectHandle getProjectHandle() {
		return projectHandle;
	}
	
	public String getProjectRelativeName() {
		return getProjectRelativePath().toString();
	}
	
	public IPath getProjectRelativePath() {
		return resource.getProjectRelativePath();
	}
	
	public IResource getResource() {
		return resource;
	}

	public URI getURI() {
		if (uri  == null) {
			uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		}
		return uri;
	}

	public IFile isFile() { return resource instanceof IFile ? (IFile)resource : null; }
	public IFolder isFolder() { return resource instanceof IFolder ? (IFolder)resource : null; }
	public IProject isProject() { return resource instanceof IProject ? (IProject)resource : null; }
	
	@Override public String toString() { return getAbsoluteName(); }
}
