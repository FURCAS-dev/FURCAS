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

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.IndexUpdaterInternal;
import org.eclipse.emf.query.index.internal.ResourceDescriptorInternal;
import org.eclipse.emf.query.index.internal.impl.EObjectDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.ReferenceDescriptorImpl;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class IndexUpdaterImpl implements IndexUpdaterInternal {

	private final GlobalTables globalTables;
	private DescriptorFactory descriptorFactory;

	private Map<URI, ResourceDescriptorInternal> insertResourceCache;
	private Set<URI> deleteResourceCache;

	public IndexUpdaterImpl(GlobalTables _globalTables) {
		this.globalTables = _globalTables;
		this.descriptorFactory = new DescriptorFactory(_globalTables.resourceIndex);
		this.insertResourceCache = new LinkedHashMap<URI, ResourceDescriptorInternal>();
		this.deleteResourceCache = new LinkedHashSet<URI>(); // TODO lazy
		// initialization?
	}

	public void deleteResource(URI uri) {
		this.deleteResourceCache.add(uri); // FIXME remove from
		// insertResourceCache
	}

	public void insertEObject(URI resourceUri, String fragment, String typeUri, String name, Map<String, String> userData) {
		ResourceDescriptorInternal desc = this.insertResourceCache.get(resourceUri);
		if (desc != null) {
			EObjectDescriptorImpl eod = this.descriptorFactory.createEObjectDescriptor(typeUri, desc, fragment, name, userData);
			desc.addEObjectDescriptor(eod);
		} else {
			throw new UnsupportedOperationException("behavior to implement");
		}
	}

	public void insertEReference(URI sourceResourceUri, String sourceFragment, String typeUri, URI targetResourceUri, String targetFragment) {
		ResourceDescriptorInternal desc = this.insertResourceCache.get(sourceResourceUri);
		if (desc != null) {
			EObjectDescriptor eod = desc.getEObjectDescriptor(sourceFragment);
			if (eod != null) {
				ReferenceDescriptorImpl refDesc = this.descriptorFactory.createReferenceDescriptor(eod, typeUri, targetResourceUri, targetFragment);
				desc.addReferenceDescriptor(refDesc);
			} else {
				throw new UnsupportedOperationException("behavior to implmement");
			}
		} else {
			throw new UnsupportedOperationException("behavior to implement");
		}
	}

	public void insertResource(URI uri, long version, Map<String, String> userData) {
		ResourceDescriptorInternal resDesc = this.descriptorFactory.createResourceDescriptor(uri, version, userData);
		this.insertResourceCache.put(uri, resDesc);
	}

	public void commit() {
		for (URI delResource : this.deleteResourceCache) {
			this.removeResourceDescriptor(delResource);
		}

		for (Map.Entry<URI, ResourceDescriptorInternal> entry : this.insertResourceCache.entrySet()) {
			this.removeResourceDescriptor(entry.getKey());
			this.addResourceDescriptor(entry.getValue());
		}
	}

	public void rollback() {
		// TODO Auto-generated method stub

	}

	private void removeResourceDescriptor(URI resource) {
		PageableResourceDescriptorImpl resourceDescriptor = globalTables.resourceIndex.acquire(resource);

		if (resourceDescriptor != null) {
			if (resourceDescriptor.isIndexed()) {
				this.collectOutgoingLinks(resourceDescriptor);
				this.deregisterElementTypes(resourceDescriptor);

				if (resourceDescriptor.isReferenced()) {
					resourceDescriptor.markNotIndexed();
				} else {
					globalTables.resourceIndex.delete(resourceDescriptor);
					return;
				}
			}
			globalTables.resourceIndex.release(resourceDescriptor);
		}
	}

	private void collectOutgoingLinks(PageableResourceDescriptorImpl resDesc) {
		for (Iterator<ReferenceDescriptorImpl> it = resDesc.getReferences(); it.hasNext();) {
			ReferenceDescriptorImpl refDesc = it.next();
			PageableResourceDescriptorImpl targetResDesc = this.globalTables.resourceIndex.acquire(refDesc.getTargetResourceURI()); // does
			// not
			// need
			// equal
			// key
			// access,
			// may
			// be
			// changed
			// to
			// identical
			// key
			// access

			// FIXME think about handling this correctly
			if (targetResDesc != null) {
				targetResDesc.removeIncomingLink(refDesc, resDesc);
				if (!targetResDesc.isIndexed() && !targetResDesc.isReferenced()) {
					this.globalTables.resourceIndex.delete(targetResDesc);
				} else {
					this.globalTables.resourceIndex.release(targetResDesc);
				}
			}
		}
	}

	private void deregisterElementTypes(PageableResourceDescriptorImpl resDesc) {
		for (Iterator<String> it = resDesc.getEClassesOfContainedObjects(); it.hasNext();) {
			String type = it.next();
			this.globalTables.elementTypeIndex.remove(type, resDesc.getURI());
		}
	}

	private void addResourceDescriptor(ResourceDescriptor _resDesc) {
		assert _resDesc instanceof PageableResourceDescriptorImpl;
		PageableResourceDescriptorImpl resDesc = (PageableResourceDescriptorImpl) _resDesc;

		URI oldKey = resDesc.getURI();
		PageableResourceDescriptorImpl existingResDesc = globalTables.resourceIndex.acquire(oldKey);
		if (existingResDesc != null) {
			if (!existingResDesc.isIndexed()) {
				existingResDesc.makeIdentic(resDesc);
				// FIXME unnecessary remove -> identity copy in other direction,
				// adjust paging? user would have other object on hand than
				// indexed
				globalTables.resourceIndex.delete(existingResDesc);
			} else {
				throw new RuntimeException("Resource already in index: " + resDesc.getURI());
			}
		}

		globalTables.resourceIndex.putAndAcquire(resDesc);

		this.spreadOutgoingLinks(resDesc);
		this.registerElementTypes(resDesc);

		resDesc.compact();
		globalTables.resourceIndex.release(resDesc);
	}

	private void spreadOutgoingLinks(PageableResourceDescriptorImpl resDesc) {
		for (Iterator<ReferenceDescriptorImpl> it = resDesc.getReferences(); it.hasNext();) {
			ReferenceDescriptorImpl refDesc = it.next();
			URI targetResource = refDesc.getTargetResourceURI();
			PageableResourceDescriptorImpl targetResDesc = globalTables.resourceIndex.acquire(targetResource);
			if (targetResDesc == null) {
				targetResDesc = this.descriptorFactory.createResourceDescriptor(targetResource, ResourceDescriptorInternal.NOT_INDEXED, null);
				globalTables.resourceIndex.putAndAcquire(targetResDesc);
			} else if (targetResDesc.getURI() != targetResource) {
				refDesc.setTargetResource(targetResDesc.getURI());
			}
			targetResDesc.addIncomingLink(refDesc, resDesc);
			globalTables.resourceIndex.release(targetResDesc);
		}
	}

	private void registerElementTypes(PageableResourceDescriptorImpl resDesc) {
		for (Iterator<String> it = resDesc.getEClassesOfContainedObjects(); it.hasNext();) {
			String type = it.next();
			this.globalTables.elementTypeIndex.put(type, resDesc.getURI());
		}
	}
}
