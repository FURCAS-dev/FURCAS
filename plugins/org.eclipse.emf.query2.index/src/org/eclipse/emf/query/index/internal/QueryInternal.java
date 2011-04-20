package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.query.Query;
import org.eclipse.emf.query.index.query.QueryResult;


/**
 * Represents the Query used to query the {@link Index}
 * 
 */
public interface QueryInternal<T, DescriptorType> extends Query<T, DescriptorType> {

	QueryResult<T> execute(QueryExecutorInternal queryExecutor, GlobalTables globalTables);

	QueryResult<T> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<? extends DescriptorType> result);

}
