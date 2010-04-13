/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;


/**
 * Wraps a set of queries and other operations to be executed within a read
 * transaction.
 * 
 * @author koehnlein
 */
public interface QueryCommand<T> {

	/**
	 * Within this method clients can execute Queries using the
	 * {@link QueryExecutor} handed in by the index store. A read transaction is
	 * opened before the method is entered and closed after it.
	 * 
	 * @param queryExecutor
	 * @param index
	 */
	T execute(QueryExecutor queryExecutor);
}
