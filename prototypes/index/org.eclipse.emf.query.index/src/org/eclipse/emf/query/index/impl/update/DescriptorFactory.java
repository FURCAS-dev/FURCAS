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
package org.eclipse.emf.query.index.impl.update;

import java.util.Map;

import org.eclipse.emf.query.index.api.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.api.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.impl.EObjectDescriptorImpl;
import org.eclipse.emf.query.index.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.impl.ReferenceDescriptorImpl;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class DescriptorFactory {

	private final PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> resourceIndex;

	public DescriptorFactory(PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> rIndex) {
		this.resourceIndex = rIndex;
	}

	// FIXME create other descriptor instances if user data is null 

	public EObjectDescriptorImpl createEObjectDescriptor(String type, ResourceDescriptor resDesc, String fragment, String name,
			Map<String, String> userData) {
		assert resDesc instanceof PageableResourceDescriptorImpl;
		return new EObjectDescriptorImpl(type.intern(), (PageableResourceDescriptorImpl) resDesc, fragment, name, userData);
	}

	public ReferenceDescriptorImpl createReferenceDescriptor(EObjectDescriptor source, String type, String targetResource,
			String targetFragment) {
		assert source instanceof EObjectDescriptorImpl;
		return new ReferenceDescriptorImpl((EObjectDescriptorImpl) source, type.intern(), targetResource, targetFragment);
	}

	public PageableResourceDescriptorImpl createResourceDescriptor(String uri, long versionId, Map<String, String> userData) {
		return this.createInternalResourceDescriptor(uri, versionId, userData);
	}

	private PageableResourceDescriptorImpl createInternalResourceDescriptor(String uri, long versionId, Map<String, String> userData) {
		return new PageableResourceDescriptorImpl(uri, versionId, userData, this.resourceIndex, false);
	}

}
