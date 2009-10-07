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

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;


/**
 * Implementation of a {@link ProcessMessage}
 */
public abstract class ProcessMessageImpl implements ProcessMessage, Serializable {

	private static final long serialVersionUID = 1L;

	private final static String ASSERT_NUMPARS = "Number of message parameters doesn't match number of arguments"; //$NON-NLS-1$

	private final static String ASSERT_NOEX = "Exceptions can not be used as message parameter"; //$NON-NLS-1$

	private String message;

	private transient LocalizedString pattern;

	private transient Object[] messageArgs;

	protected Exception exception;

	private int startLine = -1;

	private int startColumn = -1;

	private int endLine = -1;

	private int endColumn = -1;

	private int startPosition = -1;

	private int endPosition = -1;

	ProcessMessageImpl(Exception actException) {

		this.message = actException.getMessage();
		this.exception = actException;
	}

	ProcessMessageImpl(LocalizedString actMessage, Object... args) {

		this.message = actMessage.format(args);

		assert (parameterCountOk(actMessage, args)) : ASSERT_NUMPARS;
		assert (parameterNoExceptions(args)) : ASSERT_NOEX;

		this.pattern = actMessage;
		this.messageArgs = args;
	}

	ProcessMessageImpl(Exception actException, int actStartLine, int actStartColumn, int actEndLine, int actEndColumn, int actStartPos,
			int actEndPos) {

		this(actException);

		if (actException instanceof LocalizedBaseException || actException instanceof LocalizedBaseRuntimeException) {
			this.startLine = actStartLine;
			this.startColumn = actStartColumn;
			this.endLine = actEndLine;
			this.endColumn = actEndColumn;
			this.startPosition = actStartPos;
			this.endPosition = actEndPos;
		} else {
			throw new IllegalArgumentException();
		}

	}

	ProcessMessageImpl(int actStartLine, int actStartColumn, int actEndLine, int actEndColumn, int actStartPosition, int actEndPosition,
			LocalizedString actMessage, Object... args) {

		this(actMessage, args);

		this.startLine = actStartLine;
		this.startColumn = actStartColumn;
		this.endLine = actEndLine;
		this.endColumn = actEndColumn;
		this.startPosition = actStartPosition;
		this.endPosition = actEndPosition;
	}

	public int getEndColumn() {

		return this.endColumn;
	}

	public void setEndColumn(int actEndCol) {

		this.endColumn = actEndCol;
	}

	public int getEndLine() {

		return this.endLine;
	}

	public void setEndLine(int actEndLine) {

		this.endLine = actEndLine;
	}

	public int getEndPosition() {

		return this.endPosition;
	}

	public void setEndPosition(int actEndPos) {

		this.endPosition = actEndPos;
	}

	public int getStartColumn() {

		return this.startColumn;
	}

	public void setStartColumn(int actStartCol) {

		this.startColumn = actStartCol;
	}

	public int getStartLine() {

		return this.startLine;
	}

	public void setStartLine(int actStartLine) {

		this.startLine = actStartLine;
	}

	public int getStartPosition() {

		return this.startPosition;
	}

	public void setStartPosition(int actStartPos) {

		this.startPosition = actStartPos;
	}

	public String getMessage() {

		return this.message;
	}

	public String getMessage(Locale locale) {

		if (this.pattern != null) {
			String rawMessage = this.pattern.getLocalizedMessage(locale);
			if (this.messageArgs != null && this.messageArgs.length > 0) {
				MessageFormat format = new MessageFormat(rawMessage, locale);
				return format.format(this.messageArgs);
			}
			return rawMessage;
		}

		if (this.exception != null) {
			// can only be a localized one
			return this.exception.getLocalizedMessage();
		}
		return this.message;
	}

	private boolean parameterCountOk(LocalizedString actMessage, Object... args) {

		String actPattern = actMessage.format();
		int count = 0;
		int lastIndex = 0;
		int lastLeftIndex = 0;

		int index = actPattern.indexOf('{', lastLeftIndex);
		int arglength = 0;
		if (args != null) {
			arglength = args.length;
		}

		Set<Integer> intSet = new HashSet<Integer>();
		// there might be {} that are not intended for parameter replacement (do not have an Integer in between)

		while (index >= 0) {
			int rightIndex = actPattern.indexOf('}', index);
			String inbetween;
			try {
				inbetween = actPattern.substring(index + 1, rightIndex);
				Integer parIndex = new Integer(inbetween);
				if (intSet.add(parIndex)) {
					count++;
				}
			} catch (Exception e) {
				// $JL-EXC$ we just want to check the inbetween
			}
			lastLeftIndex = index + 1;
			index = actPattern.indexOf('{', lastLeftIndex);
		}

		return count == arglength;
	}

	private boolean parameterNoExceptions(Object... args) {

		for (Object arg : args) {
			if (arg instanceof Throwable) {
				return false;
			}
		}
		return true;
	}

}
