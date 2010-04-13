/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.ResourceDescriptor;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * A strategy for executing the base queries.
 * 
 * @author koehnlein
 */
public class EObjectQueryExecutorStrategyImpl extends
		AbstractBaseQueryExecutorStrategy<EObjectDescriptor, EObjectDescriptorQuery, MemoryIndexImpl> {

	public boolean canExecute(EObjectDescriptorQuery query, MemoryIndexImpl index) {
		return true;
	}

	public QueryResult<EObjectDescriptor> execute(final EObjectDescriptorQuery query, final MemoryIndexImpl index) {
		return new LazyQueryResultImpl<EObjectDescriptor>(new Iterable<EObjectDescriptor>() {
			public Iterator<EObjectDescriptor> iterator() {
				return getResult(query, index);
			}
		});
	}

	public Iterator<EObjectDescriptor> getResult(final EObjectDescriptorQuery query, final MemoryIndexImpl index) {
		if (query.getResourceQuery() != null) {
			Iterator<? extends ResourceDescriptor> resourceDescriptors = index.getQueryExecutor().execute(
					query.getResourceQuery()).iterator();
			return Iterators.concat(Iterators.transform(resourceDescriptors,
					new Function<ResourceDescriptor, Iterator<EObjectDescriptor>>() {
						public Iterator<EObjectDescriptor> apply(ResourceDescriptor scope) {
							return Iterators.filter(scope.getEObjectDescriptors().iterator(),
									new Predicate<EObjectDescriptor>() {
										public boolean apply(EObjectDescriptor candidate) {
											return match(query, candidate);
										}
									});
						}
					}));
		} else {
			return Iterators.filter(index.allEObjectDescriptors(), new Predicate<EObjectDescriptor>() {
				public boolean apply(EObjectDescriptor candidate) {
					return match(query, candidate);
				}
			});
		}
	}

	@Override
	protected boolean internalMatch(EObjectDescriptorQuery query, EObjectDescriptor candidate) {
		final EClass isInstanceOf = query.getIsInstanceOf();
		if (isInstanceOf != null && !isInstanceOf.isSuperTypeOf(candidate.getEClass()))
			return false;

		final String fragment = query.getFragment();
		if (fragment != null && !fragment.equals(candidate.getFragment()))
			return false;

		final String name = query.getName();
		final String nameContains = query.getNameContains();
		final String nameStartsWith = query.getNameStartsWith();
		final String nameEndsWith = query.getNameEndsWith();
		if (name == null && nameContains == null && nameStartsWith == null && nameEndsWith == null)
			return true;

		final String candidateName = candidate.getName();
		return candidateName != null
				&& ((name == null || candidateName.equals(name))
						&& (nameContains == null || candidateName.contains(nameContains))
						&& (nameStartsWith == null || candidateName.startsWith(nameStartsWith)) && (nameEndsWith == null || candidateName
						.endsWith(nameEndsWith)));
	}
}
