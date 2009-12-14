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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.util.FilteredIterable;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

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
		Iterable<PageableResourceDescriptorImpl> scope = this.getResourceScope(globalTables);
		FilteredIterable<PageableResourceDescriptorImpl> iterable = new FilteredIterable<PageableResourceDescriptorImpl>(scope) {

			@Override
			protected boolean matches(PageableResourceDescriptorImpl e) {
				return e.isIndexed();
			}
		};
		return this.createQueryResult(queryExecutor, iterable);
	}

	// TODO return value should be String ?
	// FIXME return real iterator
	public Iterable<PageableResourceDescriptorImpl> getResourceScope(final GlobalTables globalTables) {
		List<PageableResourceDescriptorImpl> ret = null;
		PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceMap = globalTables.resourceIndex;
		if (uriPattern == null || this.isPattern(uriPattern)) {
			for (URI next : resourceMap.getKeys()) {
				if (QueryUtil.matchesGlobbing(next.toString(), uriPattern)) {
					PageableResourceDescriptorImpl match = resourceMap.getUnderlyingMap().get(next);
					if (this.matches(match)) {
						if (ret == null) {
							ret = new ArrayList<PageableResourceDescriptorImpl>();
						}
						ret.add(match);
					}
				}
			}
		} else {
			PageableResourceDescriptorImpl match = resourceMap.getUnderlyingMap().getEqual(URI.createURI(uriPattern));
			if (match != null) {
				if (this.matches(match)) {
					ret = Collections.<PageableResourceDescriptorImpl> singletonList(match);
				}
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
	public QueryResult<T> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<? extends ResourceDescriptor> result) {
		return new QueryResultImpl<T, ResourceDescriptor>(queryExecutor, result);
	}

}
