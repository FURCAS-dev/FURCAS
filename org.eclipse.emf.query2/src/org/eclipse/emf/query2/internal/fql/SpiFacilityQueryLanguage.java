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
package org.eclipse.emf.query2.internal.fql;

import org.eclipse.emf.query2.internal.index.SpiFacilityQueryClientScope;
import org.eclipse.emf.query2.internal.index.SpiFacilityQueryServiceException;
import org.eclipse.emf.query2.internal.index.SpiMQLQueryService;

/**
 * The facility query language embodies the query algebra which a facility can
 * implement in order to support MQL queries
 * 
 * @author D045917
 */
public interface SpiFacilityQueryLanguage extends SpiMQLQueryService {

	/**
	 * Executes the provided FQL query for the given query client scope and
	 * returns a result set whose size is no larger than maxResultSetSize.
	 * Otherwise, a runtime exception is thrown. The actual partitionScope is
	 * specified as part of the queryClientScope.
	 * 
	 * @param queryClientScope
	 *            identifies the relevant {@link SpiClientSpec}s and partition
	 *            scope
	 * @param iqlQuery
	 *            the actual query, which will be executed
	 * @param maxResultSetSize
	 *            limits the maximum number of result set rows to avoid
	 *            out-of-memory exceptions. If the result is larger, an
	 *            {@link SpiFacilityQueryServiceException} is thrown
	 * @param numberOfRequestedRows
	 *            the max number of requested rows may be delimited
	 * @return the result set after executing the query
	 */
	public SpiFqlQueryResultSet execute(SpiFacilityQueryClientScope queryClientScope, SpiFqlQuery iqlQuery, int maxResultSetSize,
			int numberOfRequestedRows);

}
