/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query.spi;

import org.eclipse.emf.emfindex.query.Query;
import org.eclipse.emf.emfindex.query.QueryResult;

/**
 * Hook for the execution of sophisticated, domain-specific and/or highly optimized queries.  
 * @author koehnlein
 */
public interface QueryExecutorStrategy<DescriptorType, QueryType extends Query<DescriptorType>, IndexType> {

	static final int DEFAULT_PRIORITY = 0;
	
	void init(QueryExecutorWithStrategies queryExecutor);
	
	boolean canExecute(QueryType query, IndexType index);
	
	QueryResult<DescriptorType> execute(QueryType query, IndexType index);

}

