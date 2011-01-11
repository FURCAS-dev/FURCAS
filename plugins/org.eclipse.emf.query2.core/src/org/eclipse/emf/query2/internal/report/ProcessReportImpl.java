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
package org.eclipse.emf.query2.internal.report;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.eclipse.emf.query2.internal.localization.MoinLocaleProvider;
import org.eclipse.emf.query2.report.ProcessError;
import org.eclipse.emf.query2.report.ProcessMessages;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessWarning;


/**
 * Generic process report implementation
 */
public class ProcessReportImpl implements ProcessReport, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * the list of errors
	 */
	protected final List<ProcessError> errors = new Vector<ProcessError>();

	/**
	 * the list of warnings
	 */
	protected final List<ProcessWarning> warnings = new Vector<ProcessWarning>();

	/**
	 * the status of the process. Initially the status is INITIAL but can change
	 * to FAILED or SUCCESSFUL_WITH_WARNINGS during the process.
	 */
	protected int processStatus = INITIAL;

	protected final int MAX_NUMBER_OF_ERRORS;

	protected boolean fatal = false;

	/**
	 * Default max number of errors is 7
	 */
	public ProcessReportImpl() {

		this.MAX_NUMBER_OF_ERRORS = 7;
	}

	/**
	 * @param maxNumberOfErrors
	 */
	public ProcessReportImpl(int maxNumberOfErrors) {

		this.MAX_NUMBER_OF_ERRORS = maxNumberOfErrors;
	}

	public int getProcessStatus() {

		if (this.fatal) {
			return FATAL;
		}
		return this.processStatus;

	}

	public void setProcessStatus(int _processStatus) {

		if (_processStatus > INITIAL && _processStatus < FATAL) {
			this.processStatus = _processStatus;
		}
	}

	public void failProcess() {

		if (!this.fatal) {
			this.processStatus = FAILED;
		}
	}

	public void reportError(ProcessError error) {

		this.processStatus = FAILED;
		if (!this.fatal) {
			this.errors.add(error);
			this.fatal = this.errors.size() >= this.MAX_NUMBER_OF_ERRORS;
		}
	}

	public void reportWarning(ProcessWarning warning) {

		if (!this.fatal) {
			if (this.processStatus == SUCCESSFUL || this.processStatus == INITIAL) {
				this.processStatus = SUCCESSFUL_WITH_WARNINGS;
			}
			this.warnings.add(warning);
		}
	}

	/**
	 * Adds a fatal error to the report and causes the process to fail. No
	 * additional errors are registered
	 */
	public void reportFatalError(ProcessError error) {

		if (!this.fatal) {
			this.errors.add(error);
			this.fatal = true;
		}
	}

	public List<ProcessError> getErrors() {

		return this.errors;
	}

	public List<ProcessWarning> getWarnings() {

		return this.warnings;
	}

	public void reportCompletion() {

		if (this.processStatus == ProcessReport.INITIAL) {
			this.processStatus = ProcessReport.SUCCESSFUL;
		}
	}

	public void printReport(OutputStream out) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8")); //$NON-NLS-1$
		bw.write(toString());
		bw.flush();
	}

	public void printLocalizedReport(OutputStream out) throws IOException {

		printReport(MoinLocaleProvider.getInstance().getCurrentLocale(), out);
	}

	public void printReport(Locale locale, OutputStream out) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "UTF-8")); //$NON-NLS-1$
		bw.write(toString(locale));
		bw.flush();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		for (Iterator<ProcessError> i = this.errors.iterator(); i.hasNext();) {
			s.append(i.next().toString());
			s.append('\n');
		}
		for (Iterator<ProcessWarning> i = this.warnings.iterator(); i.hasNext();) {
			s.append(i.next().toString());
			s.append('\n');
		}
		s.append(ProcessMessages.PROCESS_REPORT.format(this.errors.size(), this.warnings.size()));
		s.append('\n');

		return s.toString();
	}

	private String toString(Locale locale) {

		StringBuilder s = new StringBuilder();
		for (Iterator<ProcessError> i = this.errors.iterator(); i.hasNext();) {
			s.append(i.next().toString(locale));
			s.append('\n');
		}
		for (Iterator<ProcessWarning> i = this.warnings.iterator(); i.hasNext();) {
			s.append(i.next().toString(locale));
			s.append('\n');
		}
		String pattern = ProcessMessages.PROCESS_REPORT.getLocalizedMessage(locale);
		MessageFormat format = new MessageFormat(pattern, locale);
		s.append(format.format(new Object[] { this.errors.size(), this.warnings.size() }));
		s.append('\n');

		return s.toString();
	}

}
