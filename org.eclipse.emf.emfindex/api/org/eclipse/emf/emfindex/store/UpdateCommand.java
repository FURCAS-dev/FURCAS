/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.store;

import org.eclipse.emf.emfindex.query.QueryExecutor;

/**
 * Wraps a set of update operations and queries to be executed within a write
 * transaction.
 * 
 * @author koehnlein
 */
public interface UpdateCommand<T> {

	/**
	 * Within this method clients can execute updates and queries using the
	 * {@link QueryExecutor} handed in by the index store. A write transaction is
	 * opened before the method is entered and closed after it.
	 * 
	 * @param queryExecutor
	 * @param indexStore
	 */
	T execute(IndexUpdater indexUpdater, QueryExecutor queryExecutor);
}
