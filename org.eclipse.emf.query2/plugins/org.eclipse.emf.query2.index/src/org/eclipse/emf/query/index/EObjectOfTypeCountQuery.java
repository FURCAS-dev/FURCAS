package org.eclipse.emf.query.index;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.query.QueryResultImpl;
import org.eclipse.emf.query.index.internal.impl.query.ResourceQueryImpl;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

public class EObjectOfTypeCountQuery implements QueryInternal<Integer, Integer> {

	private String type;
	private ResourceQueryImpl<ResourceDescriptor> resQuery;

	public void eClassUri(URI value) {
		this.type = value.toString().intern();
	}

	public ResourceQuery<ResourceDescriptor> resource() {
		if (resQuery == null) {
			this.resQuery = new ResourceQueryImpl<ResourceDescriptor>();
		}
		return resQuery;
	}

	@Override
	public QueryResult<Integer> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<? extends Integer> result) {
		return new QueryResultImpl<Integer, Integer>(queryExecutor, result);
	}

	@Override
	public QueryResult<Integer> execute(QueryExecutorInternal queryExecutor, final GlobalTables globalTables) {
		final Iterator<URI> resourceScope = this.getResourceScope(globalTables).iterator();
		int size = 0;
		while (resourceScope.hasNext()) {
			PageableResourceDescriptorImpl resDesc = globalTables.resourceIndex.acquire(resourceScope.next());
			if (resDesc.isIndexed()) {
				size += queryEObjectDescriptorCount(resDesc);
			}
			globalTables.resourceIndex.release(resDesc);
		}
		return this.createQueryResult(queryExecutor, Collections.singletonList(size));
	}

	protected int queryEObjectDescriptorCount(PageableResourceDescriptorImpl resDesc) {
		return resDesc.typeTable.getAllWithEqualKey(type).size();
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

}
