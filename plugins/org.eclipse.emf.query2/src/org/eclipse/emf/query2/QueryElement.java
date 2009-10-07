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

/**
 * This is top-class for all MQL abstract syntax elements. It maintains
 * optionally positional information. By default the positions are negative,
 * i.e. not set.
 */
public abstract class QueryElement {

	private int startPos = -1;

	private int endPos = -1;

	private int startColumn = -1;

	private int endColumn = -1;

	private int startLine = -1;

	private int endLine = -1;

	/**
	 * Sets the start position.
	 * 
	 * @param startPos
	 *            the new start position
	 */
	public void setStartPos(int startPos) {

		this.startPos = startPos;
	}

	/**
	 * Sets the end position.
	 * 
	 * @param endPos
	 *            the new end position
	 */
	public void setEndPos(int endPos) {

		this.endPos = endPos;
	}

	/**
	 * Sets the start column.
	 * 
	 * @param startColumn
	 *            the new start column
	 */
	public void setStartColumn(int startColumn) {

		this.startColumn = startColumn;
	}

	/**
	 * Sets the end column.
	 * 
	 * @param endColumn
	 *            the new end column
	 */
	public void setEndColumn(int endColumn) {

		this.endColumn = endColumn;
	}

	/**
	 * Sets the start line.
	 * 
	 * @param startLine
	 *            the new start line
	 */
	public void setStartLine(int startLine) {

		this.startLine = startLine;
	}

	/**
	 * Sets the end line.
	 * 
	 * @param endLine
	 *            the new end line
	 */
	public void setEndLine(int endLine) {

		this.endLine = endLine;
	}

	/**
	 * Gets the start position.
	 * 
	 * @return the start position
	 */
	public int getStartPos() {

		return this.startPos;
	}

	/**
	 * Gets the end position.
	 * 
	 * @return the end position
	 */
	public int getEndPos() {

		return this.endPos;
	}

	/**
	 * Gets the start column.
	 * 
	 * @return the start column
	 */
	public int getStartColumn() {

		return this.startColumn;
	}

	/**
	 * Gets the end column.
	 * 
	 * @return the end column
	 */
	public int getEndColumn() {

		return this.endColumn;
	}

	/**
	 * Gets the start line.
	 * 
	 * @return the start line
	 */
	public int getStartLine() {

		return this.startLine;
	}

	/**
	 * Gets the end line.
	 * 
	 * @return the end line
	 */
	public int getEndLine() {

		return this.endLine;
	}
}
