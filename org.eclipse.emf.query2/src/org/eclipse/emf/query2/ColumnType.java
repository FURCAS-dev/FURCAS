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
 * This record defines the form of one column in a result set.
 */
final public class ColumnType {

	/**
	 * the name of the alias as it was used during execution
	 */
	public String newRuntimeAlias;

	/**
	 * the name of the alias involved
	 */
	public String alias;

	/**
	 * this value is null if the column actually has the URI of the alias,
	 * otherwise this String value indicates the attribute of the column
	 */
	public String attribute = null;

	/**
	 * if the column is actually an attribute, it is possibly multi-valued. This
	 * value is only relevant if attribute !=null
	 */
	public boolean multiValued = false;

	/**
	 * if the column is multi-valued, this attribute indicates if the values are
	 * ordered
	 */
	public boolean isOrdered = false;

	/**
	 * if the column is multi-valued, this attribute indicates if the values are
	 * unique
	 */
	public boolean isUnique = false;

	/**
	 * indicates the type name of the values in the column. If we have model
	 * elements, it contains the fully qualified type name of the alias,
	 * otherwise the (Java) primitive type of the attribute, or, if it is
	 * multi-valued, the Java primitive type of the elements in the returned
	 * collection
	 */
	public String typeName;
}
