/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import org.eclipse.emf.emfindex.Index;

/**
 * Passed into a {@link QueryCommand} by the IndexStore to actually execute a
 * query. This way we make sure a {@link Query} can only be executed within a
 * transaction.
 * 
 * @author koehnlein
 */
public interface QueryExecutor {

	Index getIndex();
	
	<DescriptorType, QueryType extends Query<DescriptorType>, IndexType> QueryResult<DescriptorType> execute(QueryType query);

}
