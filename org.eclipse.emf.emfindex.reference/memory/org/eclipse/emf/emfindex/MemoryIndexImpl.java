/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.emfindex.ecore.BufferedBinaryResourceFactory;
import org.eclipse.emf.emfindex.query.QueryCommand;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.UpdateCommand;
import org.eclipse.emf.emfindex.store.UpdateableIndex;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author koehnlein
 * 
 */
@Singleton
public class MemoryIndexImpl implements UpdateableIndex {

	private static final String INDEX_RESOURCE_URI_EXTENSION = "idx";

	private QueryExecutor queryExecutor;

	private IndexUpdater indexUpdater;

	private ResourceSet resourceSet;

	private CompositeIndexAdapter compositeAdapter;

	private ReadWriteLock lock;

	private List<URI> deletedResources; 
	
	public MemoryIndexImpl() {
		resourceSet = new ResourceSetImpl();
		deletedResources = new ArrayList<URI>();
		compositeAdapter = new CompositeIndexAdapter();
		resourceSet.eAdapters().add(compositeAdapter);
		lock = new ReentrantReadWriteLock();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(INDEX_RESOURCE_URI_EXTENSION,
				new BufferedBinaryResourceFactory());
	}

	public <T> T executeUpdateCommand(UpdateCommand<T> updateCommand) {
		try {
			lock.writeLock().lock();
			return updateCommand.execute(indexUpdater, queryExecutor);
		}
		finally {
			lock.writeLock().unlock();
		}
	}

	public <T> T executeQueryCommand(QueryCommand<T> queryCommand) {
		try {
			lock.readLock().lock();
			return queryCommand.execute(queryExecutor);
		}
		finally {
			lock.readLock().unlock();
		}
	}

	public void load() throws IOException {
		lock.writeLock().lock();
		try {
			compositeAdapter.setActive(false);
			resourceSet.getResources().clear();
			compositeAdapter.clear();
			compositeAdapter.setActive(true);
			File baseDirectory = EmfIndexPlugin.getBaseDirectory();
			final Pattern fileNamePattern = Pattern.compile("\\d*." + INDEX_RESOURCE_URI_EXTENSION);
			File[] indexFiles = baseDirectory.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return fileNamePattern.matcher(name).matches();
				}
			});
			for (File indexFile : indexFiles) {
				URI fileURI = URI.createFileURI(indexFile.getAbsolutePath());
				resourceSet.getResource(fileURI, true);
				indexFile.delete();
			}
		} catch (RuntimeException e) {
			resourceSet.getResources().clear();
			throw e;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void save() throws IOException {
		lock.readLock().lock();
		try {
			for (Resource resource : resourceSet.getResources()) {
				if (resource.isModified()) {
					resource.save(null);
				}
			}
			for(URI deletedReosurceURI : deletedResources) {
				resourceSet.getURIConverter().delete(deletedReosurceURI, null);
			}
			deletedResources.clear();
		}
		finally {
			lock.readLock().unlock();
		}
	}

	/*
	 * internal stuff. consider making it package private.
	 */


	public <T extends IndexAdapter> T indexAdapter(Class<T> adapterClass) {
		return compositeAdapter.indexAdapter(adapterClass);
	}

	/**
	 * Default scope of all containers.
	 */
	public Iterator<ContainerDescriptor> allContainerDescriptors() {
		return new ContainerDescriptorIterator(resourceSet.getResources());
	}

	/**
	 * Default scope of all resources.
	 */
	public Iterator<ResourceDescriptor> allResourceDescriptors() {
		return new ResourceDescriptorIterable(resourceSet.getResources());
	}

	/**
	 * Default scope of all EObjects.
	 */
	public Iterator<EObjectDescriptor> allEObjectDescriptors() {
		return new EObjectDescriptorIterator(resourceSet.getResources());
	}

	/**
	 * Default scope of all references.
	 */
	public Iterator<EReferenceDescriptor> allEReferenceDescriptors() {
		return new EReferenceDescriptorIterator(resourceSet.getResources());
	}

	/**
	 * Shortcut for queries to execute nested queries.
	 */
	public QueryExecutor getQueryExecutor() {
		return queryExecutor;
	}

	public Resource createResource() {
		URI uri = createURI();
		Resource newResource = resourceSet.createResource(uri);
		newResource.setModified(true);
		return newResource;
	}

	public void deleteResource(Resource resource) {
		resourceSet.getResources().remove(resource);
		deletedResources.add(resource.getURI());
	}

	private int resourceCount = 0;


	private URI createURI() {
		return EmfIndexPlugin.getBaseDirectoryURI().appendSegment(
				"" + resourceCount++ + "." + INDEX_RESOURCE_URI_EXTENSION);
	}

	@Inject
	public void setIndexUpdater(IndexUpdater indexUpdater) {
		this.indexUpdater = indexUpdater;
	}

	@Inject
	public void setQueryExecutor(QueryExecutor queryExecutor) {
		this.queryExecutor = queryExecutor;
	}
}
