/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.util.Iterator;

import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.MemoryIndexImpl;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * A strategy for executing the base queries.
 * 
 * @author Sven Efftinge
 */
public class ContainerQueryExecutorStrategyImpl extends
		AbstractBaseQueryExecutorStrategy<ContainerDescriptor, ContainerDescriptorQuery, MemoryIndexImpl> {

	public boolean canExecute(ContainerDescriptorQuery query, MemoryIndexImpl index) {
		return true;
	}

	public QueryResult<ContainerDescriptor> execute(final ContainerDescriptorQuery query, final MemoryIndexImpl index) {
		return new LazyQueryResultImpl<ContainerDescriptor>(new Iterable<ContainerDescriptor>() {
			public Iterator<ContainerDescriptor> iterator() {
				return getResult(query, index);
			}
		});
	}

	public Iterator<ContainerDescriptor> getResult(final ContainerDescriptorQuery query, final MemoryIndexImpl index) {
		return Iterators.filter(index.allContainerDescriptors(), new Predicate<ContainerDescriptor>() {
			public boolean apply(ContainerDescriptor candidate) {
				return match(query, candidate);
			}
		});
	}

	@Override
	protected boolean internalMatch(ContainerDescriptorQuery query, ContainerDescriptor candidate) {
		return query.getName()==null || query.getName().equals(candidate.getName());
	}
}
