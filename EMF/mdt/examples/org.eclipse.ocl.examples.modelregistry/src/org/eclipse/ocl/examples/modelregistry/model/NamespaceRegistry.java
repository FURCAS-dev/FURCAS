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
 * $Id: NamespaceRegistry.java,v 1.2 2010/04/08 06:23:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.examples.modelregistry.environment.ModelRegistryEnvironment;

/**
 * The map of namespace names to namespaces.
 */
public class NamespaceRegistry
{
	private final Map<String, Accessor.Namespace<?>> nameToNamespaceMap = new HashMap<String, Accessor.Namespace<?>>();

	public <A extends Accessor<A>> void addNamespace(Accessor.Namespace<A> namespace) {
		nameToNamespaceMap.put(namespace.getName(), namespace);
	}

	public <A extends Accessor<A>> A createAccessor(String namespaceName, String accessorName) {
		@SuppressWarnings("unchecked")
		Accessor.Namespace<A> namespace =  (Accessor.Namespace<A>) nameToNamespaceMap.get(namespaceName != null ? namespaceName : ModelNameAccessor.NAMESPACE);
		if (namespace == null)
			return null;
		return createAccessor(namespace, accessorName);
	}

	public <A extends Accessor<A>> A createAccessor(Accessor.Namespace<A> namespace, String accessorName) {
		try {
			return namespace.newInstance(accessorName);
		} catch (Exception e) {
			ModelRegistryEnvironment.logError("Unable to construct '" + namespace.getName() + "' instance", e);
			return null;
		}
	}

	public Accessor.Namespace<?> getNamespace(String namespaceName) {
		return nameToNamespaceMap.get(namespaceName);
	}

	public Collection<Accessor.Namespace<?>> getNamespaces() {
		return nameToNamespaceMap.values();
	}
}
