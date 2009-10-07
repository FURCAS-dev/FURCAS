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
/*
 * Created on 02.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.report.ProcessReport;

/**
 * An MQLPreparedQuery stands for a pre-processed
 * {@link org.eclipse.emf.query2.Query}. It has elaborated all static query
 * information such as type-relevant operations. This is particularly useful if
 * a query has to be executed multiple times.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface PreparedQuery {

	/**
	 * Produces a pretty-printed string of the prepared query.
	 * 
	 * @return a pretty-printed string of the prepared query.
	 */
	String toString();

	/**
	 * Provides the report made during the preparation phase of the query. Note
	 * that if there were errors, an {@link QueryFormatException} has been thrown,
	 * which also provides a means to obtain a {@link ProcessReport}.
	 * 
	 * @return the preparation report
	 */
	ProcessReport getPreparationReport();

	/**
	 * Some syntactic and type-correct queries may have statically determinable
	 * empty solution sets. This predicate allows the client to verify this
	 * before actually executing the query.
	 * 
	 * @return true, if the query is the empty query
	 */
	boolean isEmpty();
}
