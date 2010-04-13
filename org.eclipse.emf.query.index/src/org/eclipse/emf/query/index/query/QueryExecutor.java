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
 * Passed into a {@link QueryCommand}�by the IndexStore to actually execute a
 * query. This way we make sure a {@link Query} can only be executed within a
 * transaction.
 * 
 * @author koehnlein
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 */
public interface QueryExecutor {

	<T, DescriptorType, QueryType extends Query<T, DescriptorType>> QueryResult<T> execute(QueryType query);

}
