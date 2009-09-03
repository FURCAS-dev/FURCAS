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
package org.eclipse.emf.query.index.impl.query;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.query.index.api.query.EObjectQuery;
import org.eclipse.emf.query.index.api.query.EReferenceQuery;
import org.eclipse.emf.query.index.api.query.QueryResult;
import org.eclipse.emf.query.index.api.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.api.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.impl.GlobalTables;
import org.eclipse.emf.query.index.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.util.FilteredIterableMulti;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class EReferenceQueryImpl<RDType> implements EReferenceQuery<RDType>, QueryInternal<RDType, EReferenceDescriptor> {

	private EObjectQueryImpl<EObjectDescriptor> srcEObjectQuery;
	private String type;
	private EObjectQueryImpl<EObjectDescriptor> tgtEObjectQuery;

	private Set<String> srcResScope;
	private Set<String> tgtResScope;
	private Direction direction;

	public enum Direction {
		FORWARD, BACKWARD;
	}

	@Override
	public QueryResult<RDType> execute(QueryExecutorInternal queryExecutor, GlobalTables globalTables) {
		final Iterator<String> resourceScope = this.getResourceScope(globalTables).iterator();
		final PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> resourceMap = globalTables.resourceIndex;
		return this.createQueryResult(queryExecutor, new FilteredIterableMulti<EReferenceDescriptor>() {

			@Override
			protected Iterator<? extends EReferenceDescriptor> getNextIterator() {
				while (resourceScope.hasNext()) {
					Iterable<? extends EReferenceDescriptor> posRet = null;
					PageableResourceDescriptorImpl resDesc = resourceMap.acquire(resourceScope.next());
					if (resDesc.isIndexed()) {
						posRet = resDesc.queryEReferenceDescriptor(EReferenceQueryImpl.this);
					}
					resourceMap.release(resDesc);
					if (posRet != null) {
						return posRet.iterator();
					}
				}
				return null;
			}

			@Override
			protected boolean matches(EReferenceDescriptor e) {
				return true;
			}

		});

	}

	public Iterable<String> getResourceScope(GlobalTables globalTables) {
		String tgtFragment = null;
		String srcFragment = null;

		if (srcEObjectQuery != null) {
			if (srcResScope == null) {
				this.srcResScope = new LinkedHashSet<String>();
			}
			for (String next : srcEObjectQuery.getResourceScope(globalTables)) {
				srcResScope.add(next);
			}
			srcFragment = srcEObjectQuery.getFragment();
		}
		if (tgtEObjectQuery != null) {
			if (tgtResScope == null) {
				this.tgtResScope = new LinkedHashSet<String>();
			}
			for (String next : tgtEObjectQuery.getResourceScope(globalTables)) {
				tgtResScope.add(next);
			}
			tgtFragment = tgtEObjectQuery.getFragment();
		}

		if ((srcResScope == null || srcResScope.size() == 0) && (tgtResScope == null || tgtResScope.size() == 0)) {
			if (tgtFragment == null || srcFragment != null) {
				this.direction = Direction.FORWARD;
			} else {
				this.direction = Direction.BACKWARD;
			}
			return globalTables.resourceIndex.getKeys();
		} else {
			if (size(srcResScope) >= size(tgtResScope)) {
				this.direction = Direction.FORWARD;
				return srcResScope;
			} else {
				this.direction = Direction.BACKWARD;
				return tgtResScope;
			}
		}
	}

	private int size(Set<?> set) {
		return set == null ? -1 : set.size();
	}

	public Direction getDirection() {
		return this.direction;
	}

	public EObjectQueryImpl<EObjectDescriptor> getSrcObjectQuery() {
		return this.srcEObjectQuery;
	}

	public EObjectQueryImpl<EObjectDescriptor> getTgtObjectQuery() {
		return this.tgtEObjectQuery;
	}

	public String getType() {
		return this.type;
	}

	public Set<String> getTargetScope() {
		return this.tgtResScope;
	}

	public Set<String> getSourceScope() {
		return this.srcResScope;
	}

	/*
	 * Query interface (non-Javadoc)
	 */

	@Override
	public void eReferenceURI(String referenceURI) {
		this.type = referenceURI.intern();
	}

	@Override
	public EObjectQuery<EObjectDescriptor> sourceEObject() {
		if (this.srcEObjectQuery == null) {
			this.srcEObjectQuery = new EObjectQueryImpl<EObjectDescriptor>();
		}
		return this.srcEObjectQuery;
	}

	@Override
	public EObjectQuery<EObjectDescriptor> targetEObject() {
		if (this.tgtEObjectQuery == null) {
			this.tgtEObjectQuery = new EObjectQueryImpl<EObjectDescriptor>();
		}
		return this.tgtEObjectQuery;
	}

	@Override
	public QueryKind getQueryKind() {
		return QueryKind.LINK;
	}

	@Override
	public QueryResult<RDType> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<EReferenceDescriptor> result) {
		return new QueryResultImpl<RDType, EReferenceDescriptor>(queryExecutor, result);
	}
}
