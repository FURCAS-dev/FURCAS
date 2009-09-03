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
package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.api.query.Query;
import org.eclipse.emf.query.index.api.query.QueryResult;
import org.eclipse.emf.query.index.impl.GlobalTables;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public interface QueryInternal<T, DescriptorType> extends Query<T, DescriptorType> {

	static enum QueryKind {
		LINK, EOBJECT, RESOURCE
	}

	QueryKind getQueryKind();

	QueryResult<T> execute(QueryExecutorInternal queryExecutor, GlobalTables globalTables);

	QueryResult<T> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<DescriptorType> result);

}
