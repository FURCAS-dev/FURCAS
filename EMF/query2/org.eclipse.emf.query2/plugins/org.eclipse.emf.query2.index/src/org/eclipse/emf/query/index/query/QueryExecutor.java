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
package org.eclipse.emf.query.index.query;

/**
 * Passed into a {@link QueryCommand} by the IndexStore to actually execute a
 * query. This way we make sure a {@link Query} can only be executed within a
 * transaction.
 * <p>
 * The QueryExecutor, on the one hand, is just a facade to hide the
 * implementation of the query execution from the user, and on the other hand it
 * encapsulates the validity check for a QueryResult in an iteration step.
 * </p>
 * 
 * @author koehnlein
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 */
public interface QueryExecutor {

	/**
	 * It takes all kinds of query types for execution and returns a
	 * QueryResult, which is basically an iterator. At the time you retrieve the
	 * iterator from the executor the execution has not been started and only
	 * starts by iterating over the QueryResult. This lazy querying element by
	 * element allows performant exists-any checks or first-X queries. Since
	 * there is no ordering the query does not support range queries.
	 * <p>
	 * The execution of queries of all types has two phases. In the first phase,
	 * we determine the scope (i.e. resources/pages) that might contribute to
	 * the result set. Therefore, we evaluate for example the URI (pattern) of
	 * ResourceQueries and the type information of EObjectQueries and gather the
	 * scope by use of the global indices. To determine the scope in case of
	 * nested queries, the outer query asks the inner query/queries for their
	 * resource scope and filters this result by use of their own additional
	 * information. </p>
	 * <p>
	 * In the second phase we iterate over each page in the scope
	 * and perform the acutal query. As mentioned ealier, the acutal execution
	 * is done lazily. With the invocation of the execute method a set of nested
	 * iterators gets built-up starting with the iterator iterating over the
	 * scope. This scope iterator is responsible for the invisible concatenation
	 * of iterators that iterate over the content in different pages (which are
	 * equivalent to ResourceDescriptors). During the iteration over the content
	 * of one page in the scope, only this page should be locked so that it does
	 * not get paged-out. This is also ensured in the scope iterator. Each
	 * iterator in the queue can perform filter operations to omit elements from
	 * the result.
	 * </p>
	 * 
	 * @param <T>
	 * @param <DescriptorType>
	 * @param <QueryType>
	 * @param query
	 * @return
	 */
	<T, DescriptorType, QueryType extends Query<T, DescriptorType>> QueryResult<T> execute(
			QueryType query);

}
