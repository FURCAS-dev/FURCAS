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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;
import org.eclipse.emf.query2.report.ProcessReport;


/**
 * A preprocessor exception is thrown when something goes wrong unexpectedly
 * during pre-processing that is not a format or type error. Observe that syntax
 * and type errors are usage errors which are thrown as
 * {@link QueryFormatException}s, which is a specialization of this exception.
 */
abstract public class QueryPreprocessorException extends LocalizedBaseRuntimeException {

	private ProcessReport report;

	private static final long serialVersionUID = 8861140627280716070L;

	private static class ProcessReportWrapper implements LocalizedString {

		private final ProcessReport myReport;

		public ProcessReportWrapper(ProcessReport report) {

			this.myReport = report;
		}

		public String getLocalizedMessage(Locale locale) {

			try {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				this.myReport.printReport(locale, os);
				return os.toString("UTF-8"); //$NON-NLS-1$
			} catch (UnsupportedEncodingException e) {
				return this.myReport.toString();
			} catch (IOException e) {
				return this.myReport.toString();
			}
		}

		public String format(Object... args) {

			return this.myReport.toString();
		}

	}

	/**
	 * Instantiates a new MQL preprocessor exception.
	 * 
	 * @param report
	 *            the report
	 */
	public QueryPreprocessorException(ProcessReport report) {

		super(new ProcessReportWrapper(report));
		this.report = report;
	}

	/**
	 * Obtain a report enlisting the errors and warnings during query parsing
	 * and preparation.
	 * 
	 * @return a report enlisting the errors and warnings during query parsing
	 *         and preparation.
	 */
	public ProcessReport getPreparationReport() {

		return this.report;
	}

}
