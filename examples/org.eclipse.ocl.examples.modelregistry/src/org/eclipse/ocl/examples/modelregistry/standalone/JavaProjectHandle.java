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
 * $Id: JavaProjectHandle.java,v 1.2 2010/04/08 06:24:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.standalone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.ProjectHandle;

public class JavaProjectHandle extends JavaFileHandle implements ProjectHandle
{
	private Map<String,JavaFileHandle> handles = new HashMap<String,JavaFileHandle>();
	private List<String> registryNames;
	private String rootPath = null;
	
	public JavaProjectHandle(String projectFile, String registryPath) throws IOException {
		this(new File(projectFile), registryPath);
		handles.put(getFile().toString(), this);
	}
	
	public JavaProjectHandle(File projectFile, String registryPath) throws IOException {
		super(projectFile);
		setRegistryName(registryPath); 
		handles.put(getFile().toString(), this);
	}

	public JavaFileHandle getFileHandle(String name) throws IOException {
		File referenceFile = getFile();
		if (name.startsWith("/")) {
			name = name.substring(1);
			if (rootPath == null)
				referenceFile = new File(referenceFile.getParent());
			else
				referenceFile = new File(rootPath);
		}
		File memberFile = new File(referenceFile, name);
		return getFileHandle(memberFile);
	}

	public JavaFileHandle getFileHandle(File file) throws IOException {
		if (file == null)
			return null;
		String canonicalFileName = createCanonicalFileName(file);
		JavaFileHandle handle = handles.get(canonicalFileName);
		if (handle == null) {
			handle = new JavaFileHandle(this, file);
			handles.put(handle.getFile().toString(), handle);
		}
		return handle;
	}
	
	@Override public JavaFileHandle getParentFileHandle() {
		return null;
	}

	public File getRegistryFile() {
		return new File(file, getRegistryName());
	}

	public String getRegistryName() {
		return registryNames.isEmpty() ? null : registryNames.get(0);
	}

	public List<String> getRegistryNames() {
		return registryNames;
	}
	
	public URI getRegistryURI() {
		if (registryNames.isEmpty()) {
			return null;
		}
		URI registryURI = URI.createURI(registryNames.get(0));
		URI projectURI = getURI();
		URI resolvedURI = registryURI.resolve(projectURI);
		return resolvedURI;
	}
	
	public List<URI> getRegistryURIs() {
		List<URI> registryURIs = new ArrayList<URI>();
		for (String registryName : registryNames) {
			URI registryURI = URI.createURI(registryName);
			URI projectURI = getURI();
			URI resolvedURI = registryURI.resolve(projectURI);
			registryURIs.add(resolvedURI);
		}
		return registryURIs;
	}

	public String getRoot() {
		return rootPath;
	}

	@Override public URI getURI() {
		return URI.createFileURI(getFile().toString() + "/");
	}
	
	public void refreshRegistry() {}

	public void setRegistryName(String name) {
		registryNames = Collections.singletonList(name != null ? name : DEFAULT_MODEL_REGISTRY_PATH);
	}

	public void setRegistryNames(List<String> names) {
		registryNames = new ArrayList<String>(names);
	}

	public void setRoot(String rootPath) {
		this.rootPath = rootPath;		
	}
}
