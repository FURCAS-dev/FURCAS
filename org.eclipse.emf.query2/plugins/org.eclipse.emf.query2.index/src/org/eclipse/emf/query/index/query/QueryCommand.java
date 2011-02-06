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
 * Wraps a set of queries and other operations to be executed within a read
 * transaction which guarantees consistent execution.
 * 
 * @author koehnlein
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 */
public interface QueryCommand {

	/**
	 * Within this method clients can execute Queries using the
	 * {@link QueryExecutor} handed in by the index store. A read transaction is
	 * opened before the method is entered and closed after it.
	 * <p>
	 * Queries can only be executed in scope of a QueryCommand which guarantees
	 * consistent query results. Inside the command, a QueryExecutor is
	 * available that takes all kinds of query types for execution and returns a
	 * QueryResult, which is basically an iterator. At the time you retrieve the
	 * iterator from the executor the execution has not been started and only
	 * starts by iterating over the QueryResult. This lazy querying element by
	 * element allows performant exists-any checks or first-X queries. Since
	 * there is no ordering the query does not support range queries.
	 * </p>
	 * <p>
	 * The QueryExecutor, on the one hand, is just a facade to hide the
	 * implementation of the query execution from the user, and on the other
	 * hand it encapsulates the validity check for a Query-Result in an
	 * iteration step. A QueryResult is valid as long as the QueryCommand
	 * associated to the QueryExecutor is running.
	 * </p>
	 * 
	 * @param queryExecutor
	 */
	void execute(QueryExecutor queryExecutor);
}
