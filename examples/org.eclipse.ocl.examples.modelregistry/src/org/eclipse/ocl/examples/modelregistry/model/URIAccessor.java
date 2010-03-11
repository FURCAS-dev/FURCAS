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
package org.eclipse.ocl.examples.modelregistry.model;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A URIAccesor defines a key to access model registry entries in a URI namespace.
 */
public final class URIAccessor extends AbstractAccessor<URIAccessor>
{
	public static final Namespace<URIAccessor> NAMESPACE = new AccessorNamespace<URIAccessor>("URI")
	{
		public URIAccessor newInstance(String name) throws URISyntaxException {
			return new URIAccessor(new URI(name));
		}
	};

	public static class Installer implements Accessor.Installer<URIAccessor>
	{
		public Namespace<URIAccessor> getNamespace() { return NAMESPACE; }
	}
	
	private final URI uri;
	
	public URIAccessor(URI uri) {
		super(NAMESPACE, uri.toString());
		this.uri = uri;
	}

	public URI getURI() { return uri; }
}
