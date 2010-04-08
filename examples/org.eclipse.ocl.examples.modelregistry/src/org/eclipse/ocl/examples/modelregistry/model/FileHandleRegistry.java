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
 * $Id: FileHandleRegistry.java,v 1.2 2010/04/08 06:23:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;

/**
 * A FileHandleRegistry forms part of the in memory oorg.eclipse.ocl.modelregistry
 * model read from and updated in the project .settings folder.
 * 
 * The ProjectRegistry contains a FileHandleRegistry for each file handle for which models are
 * registered. The FileHandleRegistry in turn contains an AccessorRegistry for each Accessor class
 * and the AccessorRegistry contains the model Registrations.
 */
public class FileHandleRegistry implements Comparable<FileHandleRegistry>
{
	private static class AccessorClassToAccessorRegistryMap {
		private HashMap<Accessor.Namespace<?>, AccessorRegistry<? extends Accessor<?>>> map = new HashMap<Accessor.Namespace<?>, AccessorRegistry<? extends Accessor<?>>>();
		@SuppressWarnings("unchecked")
		public <A extends Accessor<A>> AccessorRegistry<A> get(Accessor.Namespace<A> key) {
			return (AccessorRegistry<A>) map.get(key);
		}
		@SuppressWarnings("unchecked")
		public <A extends Accessor<A>> AccessorRegistry<A> put(Accessor.Namespace<A> key, AccessorRegistry<A> value) {
			return (AccessorRegistry<A>) map.put(key, value);
		}
		public Collection<Accessor.Namespace<?>> keySet() {
			return map.keySet();
		}
		public Collection<AccessorRegistry<? extends Accessor<?>>> values() {
			return map.values();
		}
	}
	private final ProjectRegistry parent;
	private final FileHandle fileHandle;
	private final AccessorClassToAccessorRegistryMap map = new AccessorClassToAccessorRegistryMap();
	
	public FileHandleRegistry(ProjectRegistry parent, FileHandle fileHandle) {
		this.parent = parent;
		this.fileHandle = fileHandle;
	}

	public <A extends Accessor<A>> void add(A accessor, URI ecoreURI, ModelSerialization modelSerialisation) {
		AccessorRegistry<A> registry = getOrCreate(accessor.getNamespace());
		registry.add(accessor, ecoreURI, modelSerialisation);		
	}

	public <A extends Accessor<A>> Registration<A> add(Registration<A> registration) {
		Accessor.Namespace<A> namespace = registration.getNamespace();
		AccessorRegistry<A> registry = getOrCreate(namespace);
		return registry.add(registration);
	}

	public int compareTo(FileHandleRegistry fileHandleRegistry) {
		String name1 = getFileHandle().getProjectRelativeName();
		if (name1 == null)
			return -1;
		String name2 = fileHandleRegistry.getFileHandle().getProjectRelativeName();
		if (name2 == null)
			return 1;
		IPath path1 = new Path(name1);
		IPath path2 = new Path(name2);
		int segmentCount1 = path1.segmentCount();
		int segmentCount2 = path2.segmentCount();
		int segmentCount = Math.min(segmentCount1, segmentCount2);
		for (int i = 0; i < segmentCount; i++) {
			int comparison = path1.segment(i).compareTo(path2.segment(i));
			if (comparison != 0)
				return comparison;
		}
		return segmentCount1 - segmentCount2;
	}

	public <A extends Accessor<A>> AccessorRegistry<A> get(Accessor.Namespace<A> namespace) {
		return map.get(namespace);
	}

	public AccessorRegistry<?> getOrCreate(String namespaceName) {
		Accessor.Namespace<?> namespace = ModelRegistryEnvironment.getInstance().getNamespaceRegistry().getNamespace(namespaceName);
		return getOrCreate(namespace);
	}

	public <A extends Accessor<A>> AccessorRegistry<A> getOrCreate(Accessor.Namespace<A> namespace) {
		AccessorRegistry<A> accessorRegistry = map.get(namespace);
		if (accessorRegistry == null) {
			accessorRegistry = new AccessorRegistry<A>(this, namespace);
			map.put(namespace, accessorRegistry);
		}			
		return accessorRegistry;
	}
	
	public Collection<Accessor.Namespace<?>> getAccessorKeys() { return map.keySet(); }

	/**
	 * Return the depth of the file handle with respect to the project handle. Returns 0 for the
	 * project, 1 for direct project members, etc.
	 * 
	 * @return the depth with respect to the project.
	 */
	public int getDepth() {
		int depth = 0;
		for (FileHandle ancestorHandle = fileHandle.getParentFileHandle(); ancestorHandle != null; ancestorHandle = ancestorHandle.getParentFileHandle())
			depth++;
		return depth;
	}

	public FileHandle getFileHandle() { return fileHandle; }
	public ProjectRegistry getProjectRegistry() { return parent; }

	public <A extends Accessor<A>> Registration<A> getRegistration(A accessor) {
		AccessorRegistry<A> accessorRegistry = get(accessor.getNamespace());
		return accessorRegistry != null ? accessorRegistry.get(accessor) : null;
	}
	
	public Collection<AccessorRegistry<? extends Accessor<?>>> getRegistries() { return map.values(); }

	public <A extends Accessor<A>> URI getURI(A accessor) {
		Registration<?> registration = getRegistration(accessor);
		return registration != null ? registration.getURI() : null;
	}

	public <A extends Accessor<A>> Registration<A> remove(Registration<A> registration) {
		Accessor.Namespace<A> namespace = registration.getNamespace();
		AccessorRegistry<A> registry = getOrCreate(namespace);
		return registry.remove(registration);
	}
	
	@Override public String toString() {
		return getFileHandle().getAbsoluteName();
	}
}
