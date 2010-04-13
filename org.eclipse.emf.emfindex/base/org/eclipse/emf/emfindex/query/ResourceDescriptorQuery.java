/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;

/**
 * @author koehnlein
 */
public class ResourceDescriptorQuery extends AbstractBaseDescriptorQuery<ResourceDescriptor> {

	private long indexedVersionBefore = Long.MAX_VALUE;
	private long indexedVersionAfter = Long.MIN_VALUE;

	private URI uri;

	private Query<ContainerDescriptor> containerQuery;
	
	private final Set<URI> notIn = new HashSet<URI>();
	
	public Set<URI> getURINotIn() {
		return notIn;
	}

	/**
	 * @return the indexedVersionBefore
	 */
	public long getIndexedVersionBefore() {
		return indexedVersionBefore;
	}

	/**
	 * @param indexedVersionBefore
	 *            the indexedVersionBefore to set
	 */
	public void setIndexedVersionBefore(long indexedVersionBefore) {
		this.indexedVersionBefore = indexedVersionBefore;
	}

	/**
	 * @param indexedVersionEquals
	 *            the indexedVersionEquals to set
	 */
	public void setIndexedVersionEquals(long indexedVersionEquals) {
		this.indexedVersionBefore = indexedVersionEquals + 1;
		this.indexedVersionAfter = indexedVersionEquals - 1;
	}

	/**
	 * @return the indexedVersionAfter
	 */
	public long getIndexedVersionAfter() {
		return indexedVersionAfter;
	}

	/**
	 * @param indexedVersionAfter
	 *            the indexedVersionAfter to set
	 */
	public void setIndexedVersionAfter(long indexedVersionAfter) {
		this.indexedVersionAfter = indexedVersionAfter;
	}

	/**
	 * @return the uri
	 */
	public URI getURI() {
		return uri;
	}

	/**
	 * @param uri
	 *            the uri to set
	 */
	public void setURI(URI uri) {
		this.uri = uri;
	}

	/**
	 * @return the containerQuery
	 */
	public Query<ContainerDescriptor> getContainerQuery() {
		return containerQuery;
	}

	/**
	 * @param containerQuery
	 *            the containerQuery to set
	 */
	public void setContainerQuery(Query<ContainerDescriptor> containerQuery) {
		this.containerQuery = containerQuery;
	}

}
