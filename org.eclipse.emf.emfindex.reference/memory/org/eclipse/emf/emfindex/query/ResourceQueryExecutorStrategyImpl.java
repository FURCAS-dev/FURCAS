/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * A strategy for executing the base queries.
 * 
 * @author koehnlein
 */
public class ResourceQueryExecutorStrategyImpl extends
		AbstractBaseQueryExecutorStrategy<ResourceDescriptor, ResourceDescriptorQuery, MemoryIndexImpl> {

	public boolean canExecute(ResourceDescriptorQuery query, MemoryIndexImpl index) {
		return true;
	}

	public QueryResult<ResourceDescriptor> execute(final ResourceDescriptorQuery query, final MemoryIndexImpl index) {
		return new LazyQueryResultImpl<ResourceDescriptor>(new Iterable<ResourceDescriptor>() {
			public Iterator<ResourceDescriptor> iterator() {
				return getResult(query, index);
			}
		});
	}

	public Iterator<ResourceDescriptor> getResult(final ResourceDescriptorQuery query, final MemoryIndexImpl index) {
		Iterator<? extends ContainerDescriptor> containerDescriptors;
		if (query.getContainerQuery() != null) {
			containerDescriptors = index.getQueryExecutor().execute(query.getContainerQuery()).iterator();
		} else {
			containerDescriptors = index.allContainerDescriptors();
		}
		List<Iterator<ResourceDescriptor>> scope = new ArrayList<Iterator<ResourceDescriptor>>();
		if (!containerDescriptors.hasNext()) {
			scope.add(index.allResourceDescriptors());
		} else {
			do {
				scope.add(containerDescriptors.next().getResourceDescriptors().iterator());
			} while(containerDescriptors.hasNext());
		}
		return Iterators.filter(Iterators.concat(scope.iterator()), new Predicate<ResourceDescriptor>() {
			public boolean apply(ResourceDescriptor candidate) {
				return match(query, candidate);
			}
		});
	}

	@Override
	protected boolean internalMatch(ResourceDescriptorQuery query, ResourceDescriptor candidate) {
		return query.getIndexedVersionAfter() < candidate.getIndexedVersion()
		&& query.getIndexedVersionBefore() > candidate.getIndexedVersion()
		&& (query.getURI() == null || query.getURI().equals(candidate.getURI())) 
		&& (query.getURINotIn().isEmpty() || !query.getURINotIn().contains(candidate.getURI()));
	}
}
