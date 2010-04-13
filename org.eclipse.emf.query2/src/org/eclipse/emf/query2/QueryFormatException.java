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
package org.eclipse.emf.query2;

import org.eclipse.emf.query2.report.ProcessReport;

/**
 * This exception may be thrown during the syntax and type checking of an MQL
 * query. It keeps a collection of type and usage errors in the formulation of
 * an MQL query.
 */
public class QueryFormatException extends QueryPreprocessorException {

	private static final long serialVersionUID = -4739285613393127920L;

	/**
	 * Instantiates a new MQL format exception.
	 * 
	 * @param _report
	 *            the _report
	 */
	public QueryFormatException(ProcessReport _report) {

		super(_report);
	}

}
