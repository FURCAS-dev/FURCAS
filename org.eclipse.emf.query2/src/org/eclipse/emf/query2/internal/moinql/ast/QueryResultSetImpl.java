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
package org.eclipse.emf.query2.internal.moinql.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * Embodies a facility query result set.
 */
public final class QueryResultSetImpl implements SpiFqlQueryResultSet {

	private int[] numberOfAttributesPerSelection;

	private int rowSize = 0;

	private List<Object[]> resultSet;

	public QueryResultSetImpl(int[] numberOfAttributesPerSelection) {

		this.numberOfAttributesPerSelection = numberOfAttributesPerSelection;
		for (int i = 0; i < this.numberOfAttributesPerSelection.length; i++) {
			// reserve space for the MRI and the attributes
			this.rowSize += (this.numberOfAttributesPerSelection[i] + 1);
		}
		this.resultSet = new ArrayList<Object[]>();
	}

	public int addEmptyEntry() {

		this.resultSet.add(new Object[this.rowSize]);
		return this.resultSet.size() - 1;
	}

	public int addEntriesFromResultSet(SpiFqlQueryResultSet queryResultSet) {

		if (queryResultSet.getRowSize() != this.rowSize) {
			throw new BugException(BugMessages.RESULT_SET_OF_DIFFERENT_ROW_SIZES);
		}

		int originalResultSetSize = this.resultSet.size();
		for (int i = 0; i < queryResultSet.getSize(); i++) {
			this.resultSet.add(originalResultSetSize + i, queryResultSet.getEntireRow(i));
		}

		return this.resultSet.size();
	}

	public int addFixedAmountEntriesFromResult(SpiFqlQueryResultSet queryResultSet, int numberOfRowsToBeAdded) {

		if (queryResultSet.getRowSize() != this.rowSize) {
			throw new BugException(BugMessages.RESULT_SET_OF_DIFFERENT_ROW_SIZES);
		}

		int originalResultSetSize = this.resultSet.size();
		int toBeAddedNumberOfRows = (numberOfRowsToBeAdded <= queryResultSet.getSize() ? numberOfRowsToBeAdded : queryResultSet.getSize());
		for (int i = 0; i < toBeAddedNumberOfRows; i++) {
			this.resultSet.add(originalResultSetSize + i, queryResultSet.getEntireRow(i));
		}

		return this.resultSet.size();
	}

	public boolean removeEntry(int position) {

		try {
			this.resultSet.remove(position);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public int getSize() {

		return this.resultSet.size();
	}

	public int getMriPositionInResultRow(int numberOfSelection) {

		int position = 0;
		for (int i = 0; i < numberOfSelection; i++) {
			position += (this.numberOfAttributesPerSelection[i] + 1);
		}
		return position;
	}

	public int getAttributePositionInResultRow(int numberOfSelection, int numberOfAttributeInSelection) {

		return this.getMriPositionInResultRow(numberOfSelection) + numberOfAttributeInSelection + 1;
	}

	public void setMri(int resultPos, int numberOfSelection, URI mri) {

		Object[] horizontalObjectArray = this.resultSet.get(resultPos);
		horizontalObjectArray[this.getMriPositionInResultRow(numberOfSelection)] = mri;
	}

	public URI getMri(int resultPos, int numberOfSelection) {

		Object[] horizontalObjectArray = this.resultSet.get(resultPos);
		return (URI) horizontalObjectArray[this.getMriPositionInResultRow(numberOfSelection)];
	}

	public void setAttributeValue(int resultPos, int numberOfSelection, int numberOfAttributeInSelection, Object value) {

		if (numberOfAttributeInSelection < 0) {
			throw new BugException(BugMessages.NUMBER_OF_ATTRS_IN_SELECT_LIST_NEGATIVE, numberOfAttributeInSelection);
		}
		if (value instanceof URI) {
			throw new BugException(BugMessages.ATTR_VALUES_SHOULD_NOT_BE_MRIS, value);
		}
		Object[] horizontalObjectArray = this.resultSet.get(resultPos);

		// we need a conversion if we have RefEnums
		if (value instanceof Enumerator) {
			value = value.toString();
		}

		horizontalObjectArray[this.getAttributePositionInResultRow(numberOfSelection, numberOfAttributeInSelection)] = value;
	}

	public Object getAttributeValue(int resultPos, int numberOfSelection, int numberOfAttributeInSelection) {

		Object[] horizontalObjectArray = this.resultSet.get(resultPos);
		return horizontalObjectArray[this.getAttributePositionInResultRow(numberOfSelection, numberOfAttributeInSelection)];
	}

	public int getRowSize() {

		return this.rowSize;
	}

	public Object[] getEntireRow(int position) {

		return this.resultSet.get(position);
	}

	@Override
	@SuppressWarnings("nls")
	public String toString() {

		StringBuffer buf = new StringBuffer();
		int size = this.getSize();
		buf.append("("); //$NON-NLS-1$
		for (int row = 0; row < size; row++) {
			if (row != 0) {
				buf.append(","); //$NON-NLS-1$
			}
			buf.append("\n["); //$NON-NLS-1$
			for (int listNum = 0; listNum < this.numberOfAttributesPerSelection.length; listNum++) {
				if (listNum != 0) {
					buf.append(","); //$NON-NLS-1$
				}
				buf.append("{"); //$NON-NLS-1$
				buf.append(this.getMri(row, listNum));
				for (int attrNum = 0; attrNum < this.numberOfAttributesPerSelection[listNum]; attrNum++) {
					if (attrNum != 0) {
						buf.append(","); //$NON-NLS-1$
					}
					buf.append(","); //$NON-NLS-1$
					Object attrValue = this.getAttributeValue(row, listNum, attrNum);
					if (attrValue instanceof Object[]) {
						Object[] values = (Object[]) attrValue;
						buf.append("#"); //$NON-NLS-1$
						for (int i = 0; i < values.length; i++) {
							if (i != 0) {
								buf.append(","); //$NON-NLS-1$
							}
							buf.append(values[i]);
						}
						buf.append("#"); //$NON-NLS-1$
					} else {
						buf.append(attrValue);
					}
				}
				buf.append("}"); //$NON-NLS-1$
			}
			buf.append("]"); //$NON-NLS-1$
		}
		buf.append(")"); //$NON-NLS-1$
		return buf.toString();
	}

	/**
	 * Puts a lexicographic order on the result set
	 */
	public void lexicographicSort(int[][] positions) {

		Collections.sort(this.resultSet, new RowComparator(positions, this));
	}

	/**
	 * The lexicographic order criterion
	 */
	public static final class RowComparator implements Comparator<Object[]> {

		private int[] rowElementIndices;

		public RowComparator(int[][] _positions, SpiFqlQueryResultSet resultSet) {

			this.rowElementIndices = new int[resultSet.getRowSize()];
			for (int i = 0; i < _positions.length; i++) {
				if (_positions[i][1] == -1) {
					// alias only
					this.rowElementIndices[i] = resultSet.getMriPositionInResultRow(_positions[i][0]);
				} else {
					// attribute
					this.rowElementIndices[i] = resultSet.getAttributePositionInResultRow(_positions[i][0], _positions[i][1]);
				}
			}
		}

		public int compare(Object[] row1, Object[] row2) {

			// we assume that they are of equal length (invariant guaranteed
			// elsewhere -> sanity check too expensive)
			int pointComparison = 0;
			for (int i = 0; i < row1.length; i++) {
				Object obj1 = row1[this.rowElementIndices[i]];
				Object obj2 = row2[this.rowElementIndices[i]];
				String row1Element = (obj1 == null ? AuxServices.EMPTYSTR : obj1.toString());
				String row2Element = (obj2 == null ? AuxServices.EMPTYSTR : obj2.toString());
				pointComparison = row1Element.compareTo(row2Element);
				if (pointComparison != 0) {
					return pointComparison;
				}
			}

			// two rows are identical in this case
			return pointComparison;
		}

	}

}
