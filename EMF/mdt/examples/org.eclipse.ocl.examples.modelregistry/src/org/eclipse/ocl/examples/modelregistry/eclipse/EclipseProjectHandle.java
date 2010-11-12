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
 * $Id: EclipseProjectHandle.java,v 1.3 2010/04/08 06:23:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.eclipse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;

public class EclipseProjectHandle extends EclipseFileHandle implements ProjectHandle
{
	private Map<IResource,EclipseFileHandle> handles = new HashMap<IResource,EclipseFileHandle>();
	private List<String> registryNames;
	private URI uri = null;
	
	public EclipseProjectHandle(IProject project) {
		super(project);
		registryNames = new ArrayList<String>();
		registryNames.add(DEFAULT_MODEL_REGISTRY_PATH);
		registryNames.add(DEFAULT_MODEL_REGISTRY_PATH2);
		handles.put(project, this);
	}

	public EclipseFileHandle getFileHandle(String name) {
		IPath path = new Path(name);
		IContainer referenceResource = getProjectResource();
		if (path.isAbsolute()) {
			path = path.makeRelative();
			referenceResource = referenceResource.getParent();
		}
		IResource memberResource = referenceResource.findMember(path);
		if (memberResource != null)
			return getFileHandle(memberResource);
		IFile fileResource = referenceResource.getFile(path);
		if (fileResource != null)
			return getFileHandle(fileResource);
		return null;
//		return getHandle(memberResource);
//		if (memberResource == null)
//			return null;			// FIXME ?? put in a proxy to avoid deletion ??
//		return getHandle(memberResource);
	}

	public EclipseFileHandle getFileHandle(IResource resource) {
		if (resource == null)
			return null;
		EclipseFileHandle handle = handles.get(resource);
		if (handle == null) {
			// Using resource.getAdapter just introduces a needless Eclipse platform
			//  coupling without ensuring unique handles.
			handle = new EclipseFileHandle(this, resource);
			handles.put(resource, handle);
		}
		return handle;
	}
	
	public IProject getProjectResource() {
		return (IProject) getResource();
	}

	public IFile getRegistryResource() {
		return getProjectResource().getFile(new Path(getRegistryName()));
	}
	
	public URI getRegistryURI() {
		if (registryNames.isEmpty()) {
			return null;
		}
		URI registryURI = URI.createURI(registryNames.get(0), false);
		URI projectURI = getURI();
		URI resolvedURI = registryURI.resolve(projectURI);
		return resolvedURI;
	}
	
	public List<URI> getRegistryURIs() {
		List<URI> registryURIs = new ArrayList<URI>();
		for (String registryName : registryNames) {
			URI registryURI = URI.createURI(registryName, false);
			URI projectURI = getURI();
			URI resolvedURI = registryURI.resolve(projectURI);
			registryURIs.add(resolvedURI);
		}
		return registryURIs;
	}

	public String getRegistryName() {
		return registryNames.get(0);
	}

	public List<String> getRegistryNames() {
		return registryNames;
	}

//	public String getRoot() {
//		return rootPath;
//	}

	@Override public URI getURI() {
		if (uri  == null) {
			uri = URI.createPlatformResourceURI(resource.getFullPath().toString() + "/", true);
		}
		return uri;
	}
	
	public void refreshRegistry() {
		IFile registryResource = getRegistryResource();
		try {
			registryResource.refreshLocal(0, null);
		} catch (CoreException e) {
			ModelRegistryEnvironment.logError("Failed to refresh registry", e);
		}
	}

	public void setRegistryName(String name) {
		registryNames = Collections.singletonList(name);
	}

	public void setRegistryNames(List<String> names) {
		registryNames = new ArrayList<String>(names);
	}
}
