/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.spi;

import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.query.Query;
import org.eclipse.emf.emfindex.query.QueryExecutor;

/**
 * Internally dispatches to its QueryExecutionStrategies to allow for query
 * customization and/or optimization.
 * 
 * @author koehnlein
 */
public interface QueryExecutorWithStrategies extends QueryExecutor {

	void addQueryExecutorStrategy(QueryExecutorStrategy<?, ? extends Query<?>, ? extends Index> queryExecutorStrategy,
			int priority);

	void removeQueryExecutorStrategy(QueryExecutorStrategy<?, ? extends Query<?>, ? extends Index> queryExecutorStrategy,
			int priority);

}
