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

import java.util.Locale;

/**
 * This class represents a message issued during a process. It holds a
 * description of the problem and optionally has position data on the problem.
 * <p>
 * There are two ways to provide the location information, either by specifying
 * column/line pairs for start and end position or using absolute offsets.
 * Depending on the specific use case, coordinates may be omitted, which is
 * encoded as -1.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ProcessMessage {

	/**
	 * @return Returns the column of the start
	 */
	public int getStartColumn();

	/**
	 * Sets start column.
	 * 
	 * @param startColumn
	 *            start column to be set.
	 */
	public void setStartColumn(int startColumn);

	/**
	 * @return Returns the line of the start
	 */
	public int getStartLine();

	/**
	 * Sets start line.
	 * 
	 * @param startLine
	 *            start line to be set.
	 */
	public void setStartLine(int startLine);

	/**
	 * @return Returns the column of the end
	 */
	public int getEndColumn();

	/**
	 * Sets end column.
	 * 
	 * @param endColumn
	 *            end column to be set.
	 */
	public void setEndColumn(int endColumn);

	/**
	 * @return Returns the line of the end
	 */
	public int getEndLine();

	/**
	 * Sets end line.
	 * 
	 * @param endLine
	 *            end line to be set.
	 */
	public void setEndLine(int endLine);

	/**
	 * @return Returns the position of the start
	 */
	public int getStartPosition();

	/**
	 * Sets start position.
	 * 
	 * @param startPosition
	 *            start position to be set.
	 */
	public void setStartPosition(int startPosition);

	/**
	 * @return returns the position of the end
	 */
	public int getEndPosition();

	/**
	 * Sets end position.
	 * 
	 * @param endPosition
	 *            end position to be set.
	 */
	public void setEndPosition(int endPosition);

	/**
	 * Returns a textual description of the message for {@link Locale#ENGLISH}.
	 * 
	 * @return the message
	 */
	public String getMessage();

	/**
	 * Returns a localized textual description of the message.
	 * 
	 * @param locale
	 * @return the message
	 */
	public String getMessage(Locale locale);

	/**
	 * @param locale
	 * @return the localized String if possible, else the non localized String
	 */
	public String toString(Locale locale);

}