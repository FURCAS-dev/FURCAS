/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.URI2ResourceCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

/**
 * A strategy for executing the base queries.
 * 
 * @author koehnlein
 */
public class EReferenceQueryExecutorStrategyImpl extends
		AbstractBaseQueryExecutorStrategy<EReferenceDescriptor, EReferenceDescriptorQuery, MemoryIndexImpl> {
	
	public EReferenceQueryExecutorStrategyImpl() {
		
	}
	
	
	public boolean canExecute(EReferenceDescriptorQuery query, MemoryIndexImpl index) {
		return true;
	}

	public QueryResult<EReferenceDescriptor> execute(final EReferenceDescriptorQuery query, final MemoryIndexImpl index) {
		return new LazyQueryResultImpl<EReferenceDescriptor>(new Iterable<EReferenceDescriptor>() {
			public Iterator<EReferenceDescriptor> iterator() {
				return getResult(query, index);
			}
		});
	}

	public Iterator<EReferenceDescriptor> getResult(final EReferenceDescriptorQuery query, final MemoryIndexImpl index) {
		final Iterator<EReferenceDescriptor> sourceScope = getSourceResourceScope(query.getSourceResourceQuery(), index);
		final URI2ResourceCache uri2ResourceCache = index.indexAdapter(URI2ResourceCache.class);
		if (query.getTargetResourceQuery() != null) {
			// TODO: this performs horribly, as we build a cross product. change api to access matcher of targetResourceQuery instead
			final Iterable<ResourceDescriptor> targetResourceQueryResult = index.getQueryExecutor().execute(query.getTargetResourceQuery());
			return Iterators.filter(sourceScope, new Predicate<EReferenceDescriptor>() {
				public boolean apply(EReferenceDescriptor candidate) {
					final URI candidateTargetResourceURI = candidate.getTargetFragmentURI().trimFragment();
					ResourceDescriptor findResourceDescriptor = uri2ResourceCache
							.findResourceDescriptor(candidateTargetResourceURI);
					return Iterables.contains(targetResourceQueryResult, findResourceDescriptor)
							&& match(query, candidate);
				}
			});
		} else {
			return Iterators.filter(sourceScope, new Predicate<EReferenceDescriptor>() {
				public boolean apply(EReferenceDescriptor candidate) {
					return match(query, candidate);
				}
			});
		}
	}

	@SuppressWarnings("cast")
	private Iterator<EReferenceDescriptor> getSourceResourceScope(final Query<ResourceDescriptor> sourceResourceQuery,
			final MemoryIndexImpl index) {
		if (sourceResourceQuery != null) {
			Iterator<? extends ResourceDescriptor> resourceDescriptors = (Iterator<? extends ResourceDescriptor>) index
					.getQueryExecutor().execute(sourceResourceQuery).iterator();
			Iterator<EReferenceDescriptor> scope = null;
			while (resourceDescriptors.hasNext()) {
				ResourceDescriptor resourceDescriptor = resourceDescriptors.next();
				Iterator<EReferenceDescriptor> eReferencesInResource = resourceDescriptor.getEReferenceDescriptors().iterator();
				scope = (scope == null) ? eReferencesInResource : Iterators.concat(scope, eReferencesInResource);
			}
			if (scope == null) {
				return Iterators.<EReferenceDescriptor> emptyIterator();
			}
			return scope;
		} else {
			return index.allEReferenceDescriptors();
		}
	}

	@Override
	protected boolean internalMatch(EReferenceDescriptorQuery query, EReferenceDescriptor candidate) {
		boolean result = query.getTargetResourceURIEquals()==null || query.getTargetResourceURIEquals().equals(candidate.getTargetResourceURI());
		return result && (query.getEReferenceEquals() == null || query.getEReferenceEquals().equals(candidate.getEReference()))
				&& (query.getSourceFragmentEquals() == null || query.getSourceFragmentEquals().equals(
						candidate.getSourceFragment()))
				&& (query.getTargetFragmentEquals() == null || query.getTargetFragmentEquals().equals(
						candidate.getTargetFragment()));
	}
}
