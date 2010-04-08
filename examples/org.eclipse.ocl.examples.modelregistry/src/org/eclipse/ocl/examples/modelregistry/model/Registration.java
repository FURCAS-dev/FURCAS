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
 * $Id: Registration.java,v 1.3 2010/04/08 06:23:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;

/**
 * A Registration maintains the binding between an accessor and the URI by which
 * the model may be loaded. Registrations are maintained in the hierarchy of
 * ProjectRegistry containing FileHandleRegistry containing AccessorRegistry containing Registration.
 */
public class Registration<A extends Accessor<A>> implements Comparable<Registration<?>>
{
	private final AccessorRegistry<A> parent;
	private final A accessor;
	private final URI uri;
	private final ModelSerialization modelSerialization;
	
	public Registration(AccessorRegistry<A> parent, A accessor, URI uri, ModelSerialization modelSerialization) {
		this.parent = parent;
		this.accessor = accessor;
		this.uri = uri;
		this.modelSerialization = modelSerialization;
	}

	public int compareTo(Registration<?> registration) {
		int comparison = getFileHandleRegistry().compareTo(registration.getFileHandleRegistry());
		if (comparison != 0)
			return comparison;
		return getAccessorName().compareTo(registration.getAccessorName());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Registration<?>))
			return false;
		if (!getAccessorName().equals(((Registration<?>)obj).getAccessorName()))
			return false;
		if (!getSerializationName().equals(((Registration<?>)obj).getSerializationName()))
			return false;
		if (!getURI().equals(((Registration<?>)obj).getURI()))
			return false;
		return true;
	}
	
	public A getAccessor() { return accessor; }
	public String getAccessorName() { return getAccessor().getName(); }
	public AccessorRegistry<A> getAccessorRegistry() { return parent; }
	public FileHandle getFileHandle() { return parent.getFileHandle(); }
	public FileHandleRegistry getFileHandleRegistry() { return parent.getFileHandleRegistry(); }
	public String getModelKindName() { return modelSerialization.getName(); }
	public Accessor.Namespace<A> getNamespace() { return accessor.getNamespace(); }
	public ModelSerialization getSerialization() { return modelSerialization; }
	public String getSerializationName() { return modelSerialization.getName(); }
	public URI getURI() { return uri; }
	public String getURIString() { return URI.decode(getURI().toString()); }

	@Override
	public int hashCode() {
		return uri.hashCode() + 55;
	}

	@Override public String toString() {
		return getAccessorName() + " -> " + getURIString();
	}

}
