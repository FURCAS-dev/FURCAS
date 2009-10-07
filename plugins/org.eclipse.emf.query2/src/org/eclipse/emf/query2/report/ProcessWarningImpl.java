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

import java.text.MessageFormat;
import java.util.Locale;

import org.eclipse.emf.query2.exception.BaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedString;


/**
 * Process warnings
 */
public class ProcessWarningImpl extends ProcessMessageImpl implements ProcessWarning {

	private static final long serialVersionUID = 1L;

	private StackTraceElement[] stackTrace;

	/**
	 * Creates a ProcessWarningImpl
	 * 
	 * @param actStack
	 * @param message
	 * @param args
	 */
	public ProcessWarningImpl(StackTraceElement[] actStack, LocalizedString message, Object... args) {

		super(message, args);
		this.stackTrace = actStack;
	}

	/**
	 * Creates a ProcessWarningImpl
	 * 
	 * @param actStack
	 * @param startLine
	 * @param startColumn
	 * @param endLine
	 * @param endColumn
	 * @param startPosition
	 * @param endPosition
	 * @param message
	 * @param args
	 */
	public ProcessWarningImpl(StackTraceElement[] actStack, int startLine, int startColumn, int endLine, int endColumn, int startPosition,
			int endPosition, LocalizedString message, Object... args) {

		super(startLine, startColumn, endLine, endColumn, startPosition, endPosition, message, args);
		this.stackTrace = actStack;
	}

	/**
	 * Creates a ProcessWarningImpl
	 * 
	 * @param actException
	 * @param startLine
	 * @param startColumn
	 * @param endLine
	 * @param endColumn
	 * @param startPosition
	 * @param endPosition
	 */
	public ProcessWarningImpl(LocalizedBaseException actException, int startLine, int startColumn, int endLine, int endColumn,
			int startPosition, int endPosition) {

		super(actException, startLine, startColumn, endLine, endColumn, startPosition, endPosition);
		this.stackTrace = actException.getStackTrace();
	}

	/**
	 * @param actException
	 * @param startLine
	 * @param startColumn
	 * @param endLine
	 * @param endColumn
	 * @param startPosition
	 * @param endPosition
	 */
	public ProcessWarningImpl(BaseRuntimeException actException, int startLine, int startColumn, int endLine, int endColumn,
			int startPosition, int endPosition) {

		super(actException, startLine, startColumn, endLine, endColumn, startPosition, endPosition);
		this.stackTrace = actException.getStackTrace();
	}

	/**
	 * Returns a textual representation of the ProcessWarning
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (getStartLine() < 0) {
			return ProcessMessages.PROCESS_WARNING.format(this.getMessage());
		}
		return ProcessMessages.PROCESS_WARNING_LOC.format(this.getStartLine(), this.getStartColumn(), this.getEndLine(), this
				.getEndColumn(), getMessage());

	}

	public String toString(Locale locale) {

		try {
			if (getStartLine() < 0) {
				String pattern = ProcessMessages.PROCESS_WARNING.getLocalizedMessage(locale);
				MessageFormat format = new MessageFormat(pattern, locale);
				return format.format(getMessage(locale));
			}

			String pattern = ProcessMessages.PROCESS_WARNING_LOC.getLocalizedMessage(locale);
			MessageFormat format = new MessageFormat(pattern, locale);
			return format.format(new Object[] { this.getStartLine(), this.getStartColumn(), this.getEndLine(), this.getEndColumn(),
					getMessage(locale) });
		} catch (RuntimeException e) {
			return toString();
		}
	}

	public StackTraceElement[] getStackTrace() {

		return this.stackTrace;
	}

}
