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
package org.eclipse.emf.query2.internal.fql;

/**
 * The facility query language has queries with a form described by this type
 * 
 * @author D045917
 */
public interface SpiFqlQuery {

	/**
	 * An FQL query has at least 1 or more selections. The order of these
	 * selections determines the format of the FQL result set. This method
	 * cannot return null.
	 */
	SpiFqlSelection[] getQuerySelections();

	/**
	 * An FQL query has at least 1 or more query type entries. Each type entry
	 * contributes to the Cartesian Product on which constraints can be put and
	 * selection can be made from. This method cannot return null.
	 */
	SpiFqlQueryEntry[] getQueryEntries();

	/**
	 * An FQL query has optionally (join) constraints over the Cartesian product
	 * of Query Entries (note that local constraints are managed by the query
	 * type entries themselves). This method cannot return null.
	 */
	SpiFqlJoinConstraint[] getJoinConstraints();

	/*
	 * For debugging purposes
	 */

	/**
	 * The unique alias name of this query
	 */
	String getUniqueAliasName();

	/**
	 * A canonical string representation of the entire query
	 */
	String toString();

}
