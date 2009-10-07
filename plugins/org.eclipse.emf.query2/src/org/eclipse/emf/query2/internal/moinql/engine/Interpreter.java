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
package org.eclipse.emf.query2.internal.moinql.engine;

import org.eclipse.emf.query2.QueryExecutionException;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;

/**
 * This service interpretes the
 * {@link org.eclipse.emf.query2.internal.moinql.ast.InternalQuery}
 * structure. It uses the FQL services, including the memory FQL to calculate
 * parts of the query. Its query part results are further combined in-memory
 * according to the operations defined in the Internal Query.
 */
public interface Interpreter {

	/**
	 * The MQL execution interpreter. It assumes that the interal query has an
	 * executable structure. It returns a MQL result set. The number of
	 * requested rows limits the possible number of requested rows. The
	 * maxResultSetSize defines when the execution aborts with an
	 * MQLExecutionException.
	 */
	ResultSet execute(InternalQuery internalQuery, int maxResultSetSize, int numberOfRequestedRows) throws QueryExecutionException;

}
