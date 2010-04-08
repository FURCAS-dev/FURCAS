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
 * $Id: AccessorRegistry.java,v 1.2 2010/04/08 06:23:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;

/**
 * An AccessorRegistry forms part of the in memory org.eclipse.ocl.modelregistry
 * model read from and updated in the project .settings folder.
 * 
 * The ProjectRegistry contains a FileHandleRegistry for each file handle for which models are
 * registered. The FileHandleRegistry in turn contains an AccessorRegistry for each Accessor class
 * and the AccessorRegistry contains the model Registrations.
 */
public class AccessorRegistry<A extends Accessor<A>> implements Comparable<AccessorRegistry<A>>
{
	private final FileHandleRegistry parent;
	private final Accessor.Namespace<A> namespace;
	private final Map<String, Registration<A>> registrations = new HashMap<String, Registration<A>>();
	
	public AccessorRegistry(FileHandleRegistry parent, Accessor.Namespace<A> namespace) {
		this.parent = parent;
		this.namespace = namespace;
	}

/*	public void add(Registration<?> registration) {
		A validAccessor = (A) registration.getAccessor();
		if (validAccessor == null)
			ModelRegistryEnvironment.logError("BUG -- Inconsistent accessor classes : " + registration.getAccessor().getClass() + ", " + namespace, null);
		else if (registrations.get(validAccessor) != null)
			ModelRegistryEnvironment.logError("BUG -- Conflicting accessor : " + registration, null);
		else
			registrations.put(validAccessor.getName(), ClassUtils.asClassUnchecked(registration, (Registration<A>)null));	
	} */

	public Registration<A> add(String accessorName, URI uri, ModelSerialization modelSerialisation) {
		NamespaceRegistry namespaceRegistry = ModelRegistryEnvironment.getInstance().getNamespaceRegistry();
		A accessor = namespaceRegistry.createAccessor(namespace, accessorName);
		return add(accessor, uri, modelSerialisation);
	}

	public Registration<A> add(A accessor, URI uri, ModelSerialization modelSerialisation) {
		Registration<A> registration = new Registration<A>(this, accessor, uri, modelSerialisation);
		registrations.put(accessor.getName(), registration);
		return registration;
	}

	public Registration<A> add(Registration<A> registration) {
		return registrations.put(registration.getAccessorName(), registration);
	}

	public void clear() {
		registrations.clear();		
	}

	public int compareTo(AccessorRegistry<A> accessorRegistry) {
		return getNamespace().getName().compareTo(accessorRegistry.getNamespace().getName());
	}

	public Registration<A> createRegistration(String accessorName, String resourceURI, ModelSerialization modelSerialisation) {
		NamespaceRegistry namespaceRegistry = ModelRegistryEnvironment.getInstance().getNamespaceRegistry();
		A accessor = namespaceRegistry.createAccessor(getNamespace(), accessorName);
		URI uri = URI.createURI(resourceURI);
		return new Registration<A>(this, accessor, uri, modelSerialisation);
	}

	public Registration<A> get(A accessor) {
		return registrations.get(accessor.getName());
	}

	public FileHandle getFileHandle() { return parent.getFileHandle(); }
	public FileHandleRegistry getFileHandleRegistry() { return parent; }
	public Accessor.Namespace<A> getNamespace() { return namespace; }	
	public ProjectRegistry getProjectRegistry() { return parent.getProjectRegistry(); }
	public Collection<String> getRegistrationKeys() { return registrations.keySet(); }
	public Collection<Registration<A>> getRegistrations() { return registrations.values(); }

	public Registration<A> remove(Registration<A> registration) {
		return registrations.remove(registration.getAccessorName());
	}
	
	@Override
	public String toString() {
		return String.valueOf(parent) + "[" + namespace.getName() + "]";
	}
}
