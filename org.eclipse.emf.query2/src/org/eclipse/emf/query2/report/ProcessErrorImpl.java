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

import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;


/**
 * This Class represents a {@link ProcessError}
 */
public class ProcessErrorImpl extends ProcessMessageImpl implements ProcessError {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a ProcessErrorImpl based on a Exception which can be related to
	 * position data in the input text.
	 * 
	 * @param actException
	 * @param startLine
	 * @param startColumn
	 * @param endLine
	 * @param endColumn
	 * @param startPosition
	 * @param endPosition
	 */
	public ProcessErrorImpl(LocalizedBaseRuntimeException actException, int startLine, int startColumn, int endLine, int endColumn,
			int startPosition, int endPosition) {

		super(actException, startLine, startColumn, endLine, endColumn, startPosition, endPosition);
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
	public ProcessErrorImpl(LocalizedBaseException actException, int startLine, int startColumn, int endLine, int endColumn,
			int startPosition, int endPosition) {

		super(actException, startLine, startColumn, endLine, endColumn, startPosition, endPosition);
	}

	protected ProcessErrorImpl(Exception actException, int startLine, int startColumn, int endLine, int endColumn, int startPosition,
			int endPosition) {

		super(actException, startLine, startColumn, endLine, endColumn, startPosition, endPosition);
	}

	/**
	 * Creates a ProcessErrorImpl based on a Exception which cannot be related
	 * to a position in the input text.
	 * 
	 * @param e
	 *            the Exception which caused the error
	 */
	public ProcessErrorImpl(LocalizedBaseRuntimeException e) {

		super(e);
	}

	/**
	 * @param e
	 */
	public ProcessErrorImpl(LocalizedBaseException e) {

		super(e);
	}

	/**
	 * Returns a textual representation of the ProcessError
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (getStartLine() < 0) {
			return ProcessMessages.PROCESS_ERROR.format(this.getMessage());
		}
		return ProcessMessages.PROCESS_ERROR_LOC.format(this.getStartLine(), this.getStartColumn(), this.getEndLine(), this.getEndColumn(),
				this.getMessage());
	}

	public String toString(Locale locale) {

		try {
			if (getStartLine() < 0) {
				String pattern = ProcessMessages.PROCESS_ERROR.getLocalizedMessage(locale);
				MessageFormat format = new MessageFormat(pattern, locale);
				return format.format(getMessage(locale));
			}

			String pattern = ProcessMessages.PROCESS_ERROR_LOC.getLocalizedMessage(locale);
			MessageFormat format = new MessageFormat(pattern, locale);
			return format.format(new Object[] { this.getStartLine(), this.getStartColumn(), this.getEndLine(), this.getEndColumn(),
					getMessage(locale) });
		} catch (RuntimeException e) {
			return toString();
		}

	}

	public Exception getRootCause() {

		return this.exception;
	}
}
