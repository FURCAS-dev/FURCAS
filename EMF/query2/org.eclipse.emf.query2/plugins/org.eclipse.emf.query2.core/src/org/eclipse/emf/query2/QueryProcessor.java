/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2;

import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * The MQLProcessor is the basis for specifying and executing MQL queries. An
 * instance of an MQLProcessor is provided via a MOIN connection.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QueryProcessor {

	/**
	 * This operation executes the {@link Query}. It always first prepares
	 * the query by means of {@link #prepare(Query)} and returns an
	 * {@link ResultSet}. To avoid repeated preparation, use
	 * {@link #prepare(Query)} first and then
	 * {@link #execute(MQLPreparedQuery)}. Execution errors are throw as an
	 * {@link QueryExecutionException} and should not occur during normal
	 * operation. The {@link TypeScopeProvider} makes it possible to delimit the
	 * scope in which the query is executed. Tool builder can implement their
	 * own {@link TypeScopeProvider}.
	 * 
	 * @param query
	 *            the to-be-executed query in AST
	 * @param scopeProvider
	 *            the scope provider to reduce the global scope in which the
	 *            query is to be executed
	 * @return the MQL result set
	 * @throws QueryExecutionException
	 *             the MQL execution exception
	 * @throws QueryFormatException
	 *             the MQL format exception
	 */
	ResultSet execute(Query query, QueryContext scopeProvider) throws QueryExecutionException, QueryFormatException;

	
	/**
	 * Identical to {@link #execute(Query)}, but this method allows the query
	 * in concrete syntax format. The {@link TypeScopeProvider} makes it
	 * possible to delimit the scope in which the query is executed. Tool
	 * builder can implement their own {@link TypeScopeProvider}.
	 * 
	 * @param query
	 *            the to-be-executed query in CST
	 * @param scopeProvider
	 *            the scope provider to reduce the global scope in which the
	 *            query is to be executed
	 * @return the MQL result set
	 * @throws QueryExecutionException
	 *             the MQL execution exception
	 * @throws QueryFormatException
	 *             the MQL format exception
	 */
	ResultSet execute(String query, QueryContext scopeProvider) throws QueryExecutionException, QueryFormatException;

	/**
	 * This operation executes the {@link Query}. It always first prepares
	 * the query by means of {@link #prepare(Query)} and returns an
	 * {@link ResultSet}. To avoid repeated preparation, use
	 * {@link #prepare(Query)} first and then
	 * {@link #execute(MQLPreparedQuery)}. Execution errors are throw as an
	 * {@link QueryExecutionException} and should not occur during normal
	 * operation. The {@link TypeScopeProvider} makes it possible to delimit the
	 * scope in which the query is executed. Tool builder can implement their
	 * own {@link TypeScopeProvider}. Finally, the number of result rows can be
	 * constrained by a positive integer. A negative integer implies that no
	 * upper boundary is provided (note that an {@link QueryExecutionException}
	 * will be thrown if the number of results exceeds the maximum result set
	 * size as provided by {@link #setMaxResultSetSize(int)}.
	 * 
	 * @param query
	 *            the to-be-executed query in AST
	 * @param scopeProvider
	 *            the scope provider to reduce the global scope in which the
	 *            query is to be executed
	 * @param numberOfResults
	 *            limits the number of result rows. A negative number means no
	 *            limitation.
	 * @return the MQL result set
	 * @throws QueryExecutionException
	 *             the MQL execution exception
	 * @throws QueryFormatException
	 *             the MQL format exception
	 */
	ResultSet execute(Query query, QueryContext scopeProvider, int numberOfResults) throws QueryExecutionException, QueryFormatException;

	/**
	 * Identical to {@link #execute(Query)}, but this method allows the query
	 * in concrete syntax format. The {@link TypeScopeProvider} makes it
	 * possible to delimit the scope in which the query is executed. Tool
	 * builder can implement their own {@link TypeScopeProvider}. Finally, the
	 * number of result rows can be constrained by a positive integer. A
	 * negative integer implies that no upper boundary is provided (note that an
	 * {@link QueryExecutionException} will be thrown if the number of results
	 * exceeds the maximum result set size as provided by
	 * {@link #setMaxResultSetSize(int)}.
	 * 
	 * @param query
	 *            the to-be-executed query in CST
	 * @param scopeProvider
	 *            the scope provider to reduce the global scope in which the
	 *            query is to be executed
	 * @param numberOfResults
	 *            limits the number of result rows. A negative number means no
	 *            limitation.
	 * @return the MQL result set
	 * @throws QueryExecutionException
	 *             the MQL execution exception
	 * @throws QueryFormatException
	 *             the MQL format exception
	 */
	ResultSet execute(String query, QueryContext scopeProvider, int numberOfResults) throws QueryExecutionException, QueryFormatException;

	/**
	 * This provides a standard scope provider where the scope is defined by
	 * given set of URIs and the inclusion flag
	 * indicates whether the query should be calculated inside the provided
	 * scope or outside the provided scope.
	 * 
	 * @param scopeInclusive
	 *            indicates whether the scope should include the provided
	 *            resources
	 * @param resourceScope
	 *            the resources to be considered in the scope (may be null)
	 
	 * @return the query scope provider
	 */
	TypeScopeProvider getQueryScopeProvider(boolean scopeInclusive, Set<URI> resourceScope);

	/**
	 * This provides a standard scope provider where the scope is defined by
	 * given array of URIs and the inclusion
	 * flag indicates whether the query should be calculated inside the provided
	 * scope or outside the provided scope. 
	 * 
	 * @param scopeInclusive
	 *            indicates whether the scope should include the provided
	 *            resources
	 * @param resourceScope
	 *            the resources to be considered in the scope (may be null)
	 
	 * @return the query scope provider
	 */
	TypeScopeProvider getQueryScopeProvider(boolean scopeInclusive, URI[] resourceScope);

	/**
	 * This provides a standard scope provider where the scope is defined by
	 * given array of URIs  and the query will be executed
	 * inside the provided scope.
	 * 
	 * @param resourceScope
	 *            the resources to be considered in the scope (may be null)
	
	 * @return the inclusive query scope provider
	 */
	TypeScopeProvider getInclusiveQueryScopeProvider(URI[] resourceScope);

	/**
	 * This provides a standard scope provider where the scope is defined by
	 * the given set of URIs and the query will be executed
	 * inside the provided scope.
	 * 
	 * @param resourceScope
	 *            the resources to be considered in the scope (may be null)
	 
	 * @return the inclusive query scope provider
	 */
	TypeScopeProvider getInclusiveQueryScopeProvider(Set<URI> resourceScope);

	/**
	 * This provides a standard scope provider where the scope is defined by the
	 * given URIs and the query will be executed inside the provided
	 * scope.
	 * 
	 * @param resourceScope
	 *            the resources to be considered in the scope (may be null)
	 * @return the inclusive scope provider
	 */
	TypeScopeProvider getInclusivePartitionScopeProvider(URI... resourceScope);

	/**
	 * Returns the currently set maximum result set size after which the query
	 * engine will give up with an exception. Note that this threshold is also
	 * obeyed when constructing intermediate result sets (caused by mixing
	 * transient and persistent results). By default, the threshold is set to
	 * 10.000 rows.
	 * 
	 * @return the max result set size before a query execution will abort
	 */
	int getMaxResultSetSize();

	/**
	 * Allows to change the maximum result set size after which the query engine
	 * will give up with an exception. Note that this threshold is also obeyed
	 * when constructing intermediate result sets (caused by mixing transient
	 * and persistent results). By default, the threshold is set to 10.000 rows.
	 * 
	 * @param maxResultSetSize
	 *            the max result set size before which a query execution will
	 *            abort
	 */
	void setMaxResultSetSize(int maxResultSetSize);
	
	public void turnOnOptimizationDuringScheduling();
	
	public void turnOffOptimizationForPartitionsDuringScheduling();
	
	public void turnOffOptimizationForElementsDuringScheduling();

}
