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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.query.index.api.query.QueryResult;
import org.eclipse.emf.query.index.api.query.ResourceQuery;
import org.eclipse.emf.query.index.api.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.impl.GlobalTables;
import org.eclipse.emf.query.index.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class ResourceQueryImpl<T> implements ResourceQuery<T>, QueryInternal<T, ResourceDescriptor> {

	private static final long UNSET_DATE = Long.MIN_VALUE;
	private String uriPattern;
	private long indexingDate = UNSET_DATE;
	private Map<String, String> userData;

	public void uri(String pattern) {
		this.uriPattern = pattern;
	}

	@Override
	public void userData(String key, String pattern) {
		if (this.userData == null) {
			this.userData = new LinkedHashMap<String, String>();
		}
		this.userData.put(key, pattern);
	}

	@Override
	public QueryResult<T> execute(QueryExecutorInternal queryExecutor, GlobalTables globalTables) {
		return this.createQueryResult(queryExecutor, this.getResourceScope(globalTables));
	}

	// TODO return value should be String ?
	// FIXME return real iterator
	public Iterable<ResourceDescriptor> getResourceScope(final GlobalTables globalTables) {
		List<ResourceDescriptor> ret = null;
		PagingResourceDescriptorMap<String, PageableResourceDescriptorImpl> resourceMap = globalTables.resourceIndex;
		if (uriPattern == null || this.isPattern(uriPattern)) {
			for (String next : resourceMap.getKeys()) {
				if (QueryUtil.matchesGlobbing(next, uriPattern)) {
					PageableResourceDescriptorImpl match = resourceMap.acquire(next);
					if (this.matches(match)) {
						if (ret == null) {
							ret = new ArrayList<ResourceDescriptor>();
						}
						ret.add(match);
					}
					resourceMap.release(match);
				}
			}
		} else {
			PageableResourceDescriptorImpl match = resourceMap.acquire(uriPattern);
			if (match != null) {
				if (this.matches(match)) {
					ret = Collections.<ResourceDescriptor> singletonList(match);
				}
				resourceMap.release(match);
			}
		}
		if (ret == null) {
			return Collections.emptyList();
		} else {
			return ret;
		}
	}

	private boolean matches(PageableResourceDescriptorImpl possMatch) {
		if (indexingDate != UNSET_DATE && indexingDate != possMatch.getIndexedVersion()) {
			return false;
		}
		if (userData != null) {
			String matchValue;
			for (Map.Entry<String, String> entry : this.userData.entrySet()) {
				matchValue = possMatch.getUserData(entry.getKey());
				if (matchValue == null || !QueryUtil.matchesGlobbing(matchValue, entry.getValue())) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isPattern(String s) {
		return s.contains("*");
	}

	@Override
	public QueryKind getQueryKind() {
		return QueryKind.RESOURCE;
	}

	@Override
	public QueryResult<T> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<ResourceDescriptor> result) {
		return new QueryResultImpl<T, ResourceDescriptor>(queryExecutor, result);
	}

}
