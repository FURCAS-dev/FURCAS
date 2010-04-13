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
package org.eclipse.emf.query2.internal.moinql.preprocessor;

import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;
import org.eclipse.emf.query2.report.ProcessReport;

/**
 * The type checker is responsible for translating the client api data structure
 * into the
 * {@link org.eclipse.emf.query2.internal.moinql.ast.InternalQuery}
 * structure. In doing so, the preprocessor resolves all relevant type
 * information and checks if the provided query has an interpretable format.
 */
public interface TypeChecker {

	/**
	 * Converts the user-defined query by doing type and format checkings
	 */
	InternalQuery convert(Query selectClause, ProcessReport processReport) throws QueryFormatException;

}
