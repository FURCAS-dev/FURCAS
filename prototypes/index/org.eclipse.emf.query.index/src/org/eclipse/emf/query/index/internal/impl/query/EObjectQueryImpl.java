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
package org.eclipse.emf.query.index.internal.impl.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.util.FilteredIterableMulti;
import org.eclipse.emf.query.index.query.EObjectQuery;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class EObjectQueryImpl<EODType> implements EObjectQuery<EODType>, QueryInternal<EODType, EObjectDescriptor> {

	private String type;
	private String fragment;
	private ResourceQueryImpl<ResourceDescriptor> resQuery;
	private Map<String, String> userData;
	private String name;

	/*
	 * Getter
	 */
	public String getType() {
		return type;
	}

	public String getFragment() {
		return fragment;
	}

	public String getName() {
		return name;
	}

	/*
	 * Constructor
	 */
	@Override
	public void fragment(String pattern) {
		this.fragment = pattern;
	}

	@Override
	public void name(String pattern) {
		this.name = pattern;
	}

	@Override
	public void nameContains(String nameSegment) {
		this.name = "*" + nameSegment + "*";
	}

	@Override
	public void nameEndsWith(String nameEnd) {
		this.name = "*" + nameEnd;
	}

	@Override
	public void nameStartsWith(String nameStart) {
		this.name = nameStart + "*";
	}

	@Override
	public ResourceQuery<ResourceDescriptor> resource() {
		if (resQuery == null) {
			this.resQuery = new ResourceQueryImpl<ResourceDescriptor>();
		}
		return resQuery;
	}

	@Override
	public void userData(String key, String pattern) {
		if (this.userData == null) {
			this.userData = new LinkedHashMap<String, String>();
		}
		this.userData.put(key, pattern);
	}

	@Override
	public QueryResult<EODType> execute(QueryExecutorInternal queryExecutor, final GlobalTables globalTables) {
		final Iterator<String> resourceScope = this.getResourceScope(globalTables).iterator();
		return this.createQueryResult(queryExecutor, new FilteredIterableMulti<EObjectDescriptor>() {

			@Override
			protected Iterator<? extends EObjectDescriptor> getNextIterator() {
				while (resourceScope.hasNext()) {
					Iterable<? extends EObjectDescriptor> posRet = null;
					PageableResourceDescriptorImpl resDesc = globalTables.resourceIndex.acquire(resourceScope.next());
					if (resDesc.isIndexed()) {
						posRet = resDesc.queryEObjectDescriptor(EObjectQueryImpl.this);
					}
					globalTables.resourceIndex.release(resDesc);
					if (posRet != null) {
						return posRet.iterator();
					}
				}
				return null;
			}

			@Override
			protected final boolean matches(EObjectDescriptor e) {
				return true;
			}

		});
	}

	public Iterable<String> getResourceScope(final GlobalTables globalTables) {
		Collection<String> ret = null;
		if (this.resQuery != null) {
			Iterable<ResourceDescriptor> executeListResult = resQuery.getResourceScope(globalTables);
			Collection<String> list = new ArrayList<String>();
			for (ResourceDescriptor r : executeListResult) {
				list.add(r.getURI());
			}
			if (ret == null) {
				ret = list;
			} else {
				ret.retainAll(list);
			}
		}
		if (type != null) {
			Collection<String> all = globalTables.elementTypeIndex.getAll(type);
			if (ret == null) {
				ret = all;
			} else {
				ret.retainAll(all);
			}
		}
		if (ret == null) {
			return globalTables.resourceIndex.getKeys();
		} else {
			return ret;
		}
	}

	public Map<String, String> getUserData() {
		return this.userData;
	}

	@Override
	public void eClassURI(String classURI) {
		this.type = classURI.intern();
	}

	@Override
	public QueryKind getQueryKind() {
		return QueryKind.EOBJECT;
	}

	@Override
	public QueryResult<EODType> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<EObjectDescriptor> result) {
		return new QueryResultImpl<EODType, EObjectDescriptor>(queryExecutor, result);
	}
}
