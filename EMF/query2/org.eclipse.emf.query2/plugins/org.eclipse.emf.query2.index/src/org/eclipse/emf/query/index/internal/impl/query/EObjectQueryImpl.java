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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.internal.impl.EObjectDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.util.FilteredIterable;
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

	public void fragment(String pattern) {
		this.fragment = pattern;
	}

	public void name(String pattern) {
		this.name = pattern;
	}

	public void nameContains(String nameSegment) {
		this.name = "*" + nameSegment + "*";
	}

	public void nameEndsWith(String nameEnd) {
		this.name = "*" + nameEnd;
	}

	public void nameStartsWith(String nameStart) {
		this.name = nameStart + "*";
	}

	public ResourceQuery<ResourceDescriptor> resource() {
		if (resQuery == null) {
			this.resQuery = new ResourceQueryImpl<ResourceDescriptor>();
		}
		return resQuery;
	}

	public void userData(String key, String pattern) {
		if (this.userData == null) {
			this.userData = new LinkedHashMap<String, String>();
		}
		this.userData.put(key, pattern);
	}

	public QueryResult<EODType> execute(QueryExecutorInternal queryExecutor, final GlobalTables globalTables) {
		final Iterator<URI> resourceScope = this.getResourceScope(globalTables).iterator();
		return this.createQueryResult(queryExecutor, new FilteredIterableMulti<EObjectDescriptor>() {

			protected Iterator<? extends EObjectDescriptor> getNextIterator() {
				while (resourceScope.hasNext()) {
					Iterable<? extends EObjectDescriptor> posRet = null;
					PageableResourceDescriptorImpl resDesc = globalTables.resourceIndex.acquire(resourceScope.next());
					if (resDesc.isIndexed()) {
						posRet = queryEObjectDescriptor(resDesc);
					}
					globalTables.resourceIndex.release(resDesc);
					if (posRet != null) {
						return posRet.iterator();
					}
				}
				return null;
			}

			protected final boolean matches(EObjectDescriptor e) {
				return true;
			}

		});
	}

	public Iterable<URI> getResourceScope(final GlobalTables globalTables) {
		Collection<URI> ret = null;
		if (this.resQuery != null) {
			Iterable<PageableResourceDescriptorImpl> executeListResult = resQuery.getResourceScope(globalTables);
			Collection<URI> list = new ArrayList<URI>();
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
			Collection<URI> all = globalTables.elementTypeIndex.getAll(type);
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

	public void eClassURI(URI classURI) {
		this.type = classURI.toString().intern();
	}

	public QueryResult<EODType> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<? extends EObjectDescriptor> result) {
		return new QueryResultImpl<EODType, EObjectDescriptor>(queryExecutor, result);
	}

	public Iterable<? extends EObjectDescriptor> queryEObjectDescriptor(PageableResourceDescriptorImpl resDesc) {
		final String frag = getFragment();
		final String type = getType();
		final String name = getName();
		final Map<String, String> uData = getUserData();

		if (frag != null) {
			if (frag.indexOf('*') == -1) { // concrete fragment
				EObjectDescriptorImpl obj = resDesc.eObjectTable.getEqual(frag);
				if (obj == null) {
					return Collections.emptyList();
				} else {
					return new FilteredIterable<EObjectDescriptorImpl>(Collections.singletonList(obj)) {

						protected boolean matches(EObjectDescriptorImpl e) {
							if (type == null)
								return matchesUserData(e, uData) && QueryUtil.matchesGlobbing(e.getName(), name);
							else
								return e.getEClassURI() == type && QueryUtil.matchesGlobbing(e.getName(), name) && matchesUserData(e, uData);
						}

					};
				}
			} else { // fragment patters
				Iterable<EObjectDescriptorImpl> base = null;
				if (type != null) {
					base = resDesc.typeTable.getAllWithEqualKey(type);
				} else {
					base = resDesc.eObjectTable;
				}
				if (base == null) {
					return Collections.emptyList();
				} else {
					return new FilteredIterable<EObjectDescriptorImpl>(base) {

						protected boolean matches(EObjectDescriptorImpl e) {
							return QueryUtil.matchesGlobbing(e.getFragment(), frag) && QueryUtil.matchesGlobbing(e.getName(), name) && matchesUserData(e, uData);
						}

					};
				}
			}
		} else {
			Iterable<EObjectDescriptorImpl> base;
			if (type != null) {
				base = resDesc.typeTable.getAllWithEqualKey(type);
			} else {
				base = resDesc.eObjectTable;
			}
			return uData == null ? base : new FilteredIterable<EObjectDescriptorImpl>(base) {

				protected boolean matches(EObjectDescriptorImpl e) {
					return matchesUserData(e, uData) && QueryUtil.matchesGlobbing(e.getName(), name);
				}

			};
		}
	}

	private boolean matchesUserData(EObjectDescriptorImpl e, Map<String, String> uData) {
		if (uData != null) {
			for (Map.Entry<String, String> entry : uData.entrySet()) {
				String userDataValue = e.getUserData(entry.getKey());
				if (userDataValue == null || !QueryUtil.matchesGlobbing(userDataValue, entry.getValue())) {
					return false;
				}
			}
		}
		return true;
	}

}
