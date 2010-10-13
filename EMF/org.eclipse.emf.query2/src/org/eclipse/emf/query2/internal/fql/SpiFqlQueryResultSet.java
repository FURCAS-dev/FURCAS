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

import org.eclipse.emf.common.util.URI;

/**
 * Executing an FQL query always results in a FacilityQueryResultSet. MQL result
 * sets always encapsulate facility query result sets. Even MQL's mixer
 * constructs these kind of result sets (to avoid copying result sets).
 * Therefore, the SPI also includes constructive operations. Once a result set
 * is returned by FQL, the facility should not make assumptions of the format of
 * the result set as it might be destructed as it gets processed by MQL.
 * 
 * @author D045917
 */
public interface SpiFqlQueryResultSet {

	/*
	 * Constructive operations
	 */

	/**
	 * Adds one empty row entry at the end of the result set. Returns the new
	 * position of the entry in the result set
	 */
	int addEmptyEntry();

	/**
	 * Removes the row entry at the provided rowPosition (positions start at 0).
	 * Returns true if successful, otherwise false.
	 */
	boolean removeEntry(int rowPosition);

	/**
	 * Copies the references of all row entries of the input queryResultSet into
	 * the current result set by adding them at the end of the result set.
	 */
	int addEntriesFromResultSet(SpiFqlQueryResultSet queryResultSet);

	/**
	 * Copies the references of a limited number row entries of the input
	 * queryResultSet into the current result set by adding them at the end of
	 * the result set. If the queryResultSet has less rows than indicated by the
	 * numberOfRowsToBeAdded, only as many will be added as are available in the
	 * queryResultSet.
	 */
	int addFixedAmountEntriesFromResult(SpiFqlQueryResultSet queryResultSet, int numberOfRowsToBeAdded);

	/**
	 * Sets the element (mri) for the selection position at the row position
	 */
	void setMri(int position, int selectionPosition, URI mri);

	/**
	 * Sets a primitive typed value (Object) for the selection position and
	 * attribute-in-selection position at the row position.
	 */
	void setAttributeValue(int position, int selectionPosition, int attributeInSelectionPosition, Object value);

	/**
	 * Puts a lexicographic order on the result set. The sorting order is
	 * defined by the 2-dimensional sortPositionList. Its first dimension
	 * encodes the column in the order of the requested output. The second
	 * dimension is only 2 long and its first position indicates the selection
	 * list inside the query result set. The second position is -1 if the column
	 * does not contain an attribute, otherwise the attribute position within
	 * the selection list
	 */
	void lexicographicSort(int[][] sortPositionList);

	/*
	 * retrieval operations
	 */

	/**
	 * The current size of the result set
	 */
	int getSize();

	/**
	 * Returns the MRI at row position and for selectionPosition. Throws a
	 * runtime exception if any of the provided positions is out of bounds. If
	 * the entry exists, but has not been set, null will be returned.
	 */
	URI getMri(int position, int selectionPosition);

	/**
	 * Returns the value at row position and for selectionPosition and
	 * attribtueInSelectionPosition. Throws a runtime exception if any of the
	 * provided positions is out of bounds. If the entry exists, but no value
	 * has not been set, null will be returned. For multi-valued attributes, an
	 * Object[] array will be returned.
	 */
	Object getAttributeValue(int position, int selectionPosition, int attributeInSelectionPosition);

	/**
	 * Gets a MRI entry position in the horizontal result row.
	 * 
	 * @param numberOfSelection
	 *            number of the selection starting with 0
	 * @return position in the result row
	 */
	int getMriPositionInResultRow(int numberOfSelection);

	/**
	 * Gets an attribute entry position in the horizontal result row.
	 * 
	 * @param numberOfSelection
	 *            number of the selection starting with 0
	 * @param numberOfAttributeInSelection
	 *            number of the attribute in the selection starting with 0
	 * @return position in the result row
	 */
	int getAttributePositionInResultRow(int numberOfSelection, int numberOfAttributeInSelection);

	/**
	 * Returns the size of a row in the result table
	 */
	int getRowSize();

	/**
	 * Returns an entire row at the position.
	 * 
	 * @return an Object array whose size conforms to the row size
	 */
	Object[] getEntireRow(int position);

}
