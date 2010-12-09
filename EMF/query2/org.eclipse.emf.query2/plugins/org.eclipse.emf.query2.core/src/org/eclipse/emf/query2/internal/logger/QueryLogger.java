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
package org.eclipse.emf.query2.internal.logger;

import java.text.MessageFormat;

import org.eclipse.emf.query2.exception.ExternalizedString;
import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;


/**
 * The MOIN Logging and Tracing API
 * <p>
 * Wraps the SAP Logging and Tracing API and provides one homogeneous interface
 * which covers the Category and Location functionality and automatically
 * redirect the messages to the associated log and/or trace files (Category
 * and/or Location).
 * <p>
 * To obtain a new MOIN Logger, application code should use the the getLogger()
 * factory method of the {@link LoggerFactory} class.
 * <p>
 * The MOIN Logger expects a Category that is predefined in the MoinCategoryEnum
 * class and is a sub-Category of the <tt>/Applications/Moin</tt> parent
 * Category.
 * <p>
 * The used Location name must be a logical-defined Location name that is
 * predefined in the MoinLocationEnum class and is a sub-Location of the
 * <tt>com.sap.moin</tt> parent Location.
 * <p>
 * The MOIN severities (see {@link LogSeverity}) are mapped to SAP Logging and
 * Tracing severities. Message parameter replacement is done using
 * {@link MessageFormat}
 * 
 * @author d029324
 */

public interface QueryLogger {


	/**
	 * Prints the message and a stack trace to the trace file
	 * <p>
	 * 
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void traceWithStack(LogSeverity severity, String message, Object... args);

	/**
	 * Prints the message and a stack trace to the trace file
	 * <p>
	 * 
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void traceWithStack(LogSeverity severity, ExternalizedString message, Object... args);

	/**
	 * Prints the message and the Exception to the trace file
	 * <p>
	 * 
	 * @param throwable
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void trace(Throwable throwable, LogSeverity severity, String message, Object... args);

	/**
	 * Prints the message and the Exception to the trace file
	 * <p>
	 * Allows reporting of the message context, see
	 * {@link #logAndTrace(Throwable, TraceContext, LogSeverity, LocalizedString, Object...)}
	 * 
	 * @param throwable
	 * @param context
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void trace(Throwable throwable, TraceContext context, LogSeverity severity, ExternalizedString message, Object... args);

	/**
	 * Prints the message and the Exception to the trace file
	 * <p>
	 * Allows reporting of the message context, see
	 * {@link #logAndTrace(Throwable, Object, LogSeverity, LocalizedString, Object...)}
	 * 
	 * @param throwable
	 * @param context
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void trace(Throwable throwable, Object context, LogSeverity severity, ExternalizedString message, Object... args);

	/**
	 * Prints the message and the Exception to the trace file
	 * 
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void trace(LogSeverity severity, String message, Object... args);

	/**
	 * Prints the message and the Exception to the trace file
	 * <p>
	 * 
	 * @param exception
	 * @param severity
	 *            MOIN severity
	 * @param message
	 *            message
	 * @param args
	 *            message parameters
	 */
	public void trace(Throwable exception, LogSeverity severity, ExternalizedString message, Object... args);

	/**
	 * Prints the message and the Exception to the trace file
	 * <p>
	 * 
	 * @param exception
	 *            the localized MOIN Exception
	 * @param severity
	 *            MOIN severity
	 */
	public void trace(LocalizedBaseException exception, LogSeverity severity);

	/**
	 * Prints the message and the Exception to the trace file
	 * <p>
	 * 
	 * @param exception
	 *            the localized MOIN Exception
	 * @param severity
	 *            MOIN severity
	 */
	public void trace(LocalizedBaseRuntimeException exception, LogSeverity severity);

	/**
	 * Prints the message to the trace file
	 * <p>
	 * 
	 * @param message
	 *            the localized MOIN Exception
	 * @param severity
	 *            MOIN severity
	 * @param args
	 *            message parameters
	 */
	public void trace(LogSeverity severity, ExternalizedString message, Object... args);


	/**
	 * The isTraced() method checks the current effective severity level of the
	 * particular Log Controller.
	 * <p>
	 * The isTraced() method returns true if the message with this particular
	 * severity (see MoinSeverity severity parameter) is traced; this means
	 * printed to the trace file. Otherwise the isTraced() method returns false.
	 * <p>
	 * This mehtod checks the Location severity and therefore should be used
	 * together with the trace(), entering() and exiting() methods.
	 * 
	 * @param severity
	 *            MOIN severity
	 * @return true if the used / checked severity allows the printing to the
	 *         trace file
	 */
	public boolean isTraced(LogSeverity severity);

}
