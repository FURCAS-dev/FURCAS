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
package org.eclipse.emf.query2.internal.moinql.parser;

/**
 * Utility interface for nodes
 */
public interface CstNode {

	boolean equals(Object o);

	int hashCode();

	String toString();

	/**
	 * @return the start offset
	 */
	int getStartOffset();

	/**
	 * @return the line
	 */
	int getLine();

	/**
	 * @return the column
	 */
	int getColumn();

	/**
	 * @return the end offset
	 */
	int getEndOffset();

	/**
	 * @return the end line
	 */
	int getEndLine();

	/**
	 * @return the end column
	 */
	int getEndColumn();
}
