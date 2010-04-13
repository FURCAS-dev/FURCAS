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
package org.eclipse.emf.query2.report;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

/**
 * This class collects all error messages and warnings issued during a process.
 * The process is considered to be failed if there is is at least one error
 * message.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ProcessReport {

	/**
	 * returned by {@link #getProcessStatus()} if the process was successful
	 */
	public static final int SUCCESSFUL = 0;

	/**
	 * returned by {@link #getProcessStatus()}if the process was successful but
	 * warnings have been reported.
	 */
	public static final int SUCCESSFUL_WITH_WARNINGS = 1;

	/**
	 * returned by {@link #getProcessStatus()} if the process was not performed
	 * (yet)
	 */
	public static final int INITIAL = -1;

	/**
	 * returned by {@link #getProcessStatus()} if the process has failures, but
	 * can continue
	 */
	public static final int FAILED = 2;

	/**
	 * returned by {@link #getProcessStatus()} if the process is in a fatal
	 * position and should not continue
	 */
	public static final int FATAL = 3;

	/**
	 * Returns the status of the process.
	 * 
	 * @return either {@link #INITIAL}, {@link #SUCCESSFUL},
	 *         {@link #SUCCESSFUL_WITH_WARNINGS}, {@link #FAILED}, or
	 *         {@link #FATAL}
	 */
	public int getProcessStatus();

	/**
	 * Sets the status of the process, which is either {@link #INITIAL},
	 * {@link #SUCCESSFUL}, {@link #SUCCESSFUL_WITH_WARNINGS}, {@link #FAILED},
	 * or {@link #FATAL}
	 * 
	 * @param status
	 *            the status to be set
	 */
	public void setProcessStatus(int status);

	/**
	 * Fails the current process, independent of registered errors. FATAL
	 * remains FATAL though.
	 */
	public void failProcess();

	/**
	 * Adds an error to the report and causes the process to fail. If the
	 * maximum number of errors is reached, the status of the report becomes
	 * fatal. No additional errors are registered if the process fatally
	 * stopped.
	 * 
	 * @param error
	 *            to be reported
	 */
	public void reportError(ProcessError error);

	/**
	 * Adds a fatal error to the report and causes the process to fail. No
	 * additional errors are registered anymore.
	 * 
	 * @param error
	 *            a fatal error
	 */
	public void reportFatalError(ProcessError error);

	/**
	 * Adds a warning to the report.
	 * 
	 * @param warning
	 *            to be reported
	 */
	public void reportWarning(ProcessWarning warning);

	/**
	 * Called upon successsful completion
	 */
	public void reportCompletion();

	/**
	 * Returns the list of reported errors
	 * 
	 * @return a list of process errors
	 */
	public List<ProcessError> getErrors();

	/**
	 * Returns the list of reported warnings
	 * 
	 * @return a list of process warnings
	 */
	public List<ProcessWarning> getWarnings();

	/**
	 * Prints a formated report to <code>out</code>
	 * 
	 * @param out
	 *            the Stream to print the report to
	 * @throws IOException
	 *             if problems with the stream occur
	 */
	public void printReport(OutputStream out) throws IOException;

	/**
	 * Prints a formated, localized report to <code>out</code>.
	 * <p>
	 * The {@link Locale} is determined via {@link MoinLocaleProvider}
	 * 
	 * @param out
	 *            the Stream to print the report to
	 * @throws IOException
	 *             if problems with the stream occur
	 */
	public void printLocalizedReport(OutputStream out) throws IOException;

	/**
	 * Prints a formated report to <code>out</code>
	 * 
	 * @param locale
	 *            the requested {@link Locale}
	 * @param out
	 *            the Stream to print the report to
	 * @throws IOException
	 *             if problems with the stream occur
	 */
	public void printReport(Locale locale, OutputStream out) throws IOException;

}