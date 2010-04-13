/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorStrategy;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorWithStrategies;

/**
 * @author koehnlein - Initial contribution and API
 */
public class AllReferencesToResourceQueryExecutorStrategy implements
		QueryExecutorStrategy<EReferenceDescriptor, AllReferencesToResourceQuery, MemoryIndexImpl> {

	private ReferencesToResourceCache targetResourceCache;

	public void init(QueryExecutorWithStrategies queryExecutor) {
		Index index = queryExecutor.getIndex();
		if (index instanceof MemoryIndexImpl) {
			targetResourceCache = ((MemoryIndexImpl) index).indexAdapter(ReferencesToResourceCache.class);
		}
	}
	
	public boolean canExecute(AllReferencesToResourceQuery query, MemoryIndexImpl index) {
		return true;
	}

	public QueryResult<EReferenceDescriptor> execute(AllReferencesToResourceQuery query, MemoryIndexImpl index) {
		return new LazyQueryResultImpl<EReferenceDescriptor>(targetResourceCache.getReferencesTargetingResource(query
				.getTargetResourceURIEquals()));
	}

}
