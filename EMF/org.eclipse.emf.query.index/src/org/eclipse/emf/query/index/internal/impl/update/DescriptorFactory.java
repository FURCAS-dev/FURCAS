/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.impl.update;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.impl.EObjectDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.impl.ReferenceDescriptorImpl;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class DescriptorFactory {

	private final PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceIndex;

	public DescriptorFactory(PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> rIndex) {
		this.resourceIndex = rIndex;
	}

	// FIXME create other descriptor instances if user data is null

	public EObjectDescriptorImpl createEObjectDescriptor(String type, ResourceDescriptor resDesc, String fragment, String name,
			Map<String, String> userData) {
		assert resDesc instanceof PageableResourceDescriptorImpl;
		return new EObjectDescriptorImpl(type.intern(), (PageableResourceDescriptorImpl) resDesc, fragment, name, userData);
		// TODO "intern()" is less expensive in indexer + caching
	}

	public ReferenceDescriptorImpl createReferenceDescriptor(EObjectDescriptor source, String type, URI targetResource,
			String targetFragment) {
		assert source instanceof EObjectDescriptorImpl;
		return new ReferenceDescriptorImpl((EObjectDescriptorImpl) source, type.intern(), targetResource, targetFragment);
	}

	public PageableResourceDescriptorImpl createResourceDescriptor(URI uri, long versionId, Map<String, String> userData) {
		return new PageableResourceDescriptorImpl(uri, versionId, userData, this.resourceIndex, false);
	}

}
