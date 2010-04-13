/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.emfindex.query.spi.QueryExecutorStrategy;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorWithStrategies;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class DefaultQueryExecutorStrategyInitializer {
	
	@Inject
	public DefaultQueryExecutorStrategyInitializer(QueryExecutorWithStrategies queryExecutor) {
		queryExecutor.addQueryExecutorStrategy(new EObjectQueryExecutorStrategyImpl(), QueryExecutorStrategy.DEFAULT_PRIORITY);
		queryExecutor.addQueryExecutorStrategy(new EReferenceQueryExecutorStrategyImpl(), QueryExecutorStrategy.DEFAULT_PRIORITY);
		queryExecutor.addQueryExecutorStrategy(new ResourceQueryExecutorStrategyImpl(), QueryExecutorStrategy.DEFAULT_PRIORITY);
		queryExecutor.addQueryExecutorStrategy(new ContainerQueryExecutorStrategyImpl(), QueryExecutorStrategy.DEFAULT_PRIORITY);
	}
}
