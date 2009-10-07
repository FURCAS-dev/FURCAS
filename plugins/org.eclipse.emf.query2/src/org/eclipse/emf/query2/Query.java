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
/*
 * Created on 10.02.2006
 */
package org.eclipse.emf.query2;

import java.util.Arrays;
import java.util.List;

/**
 * The MQLQuery class represents a completely specified MQL query. It forms the
 * basis for preparation and/or execution.
 */
final public class Query extends QueryElement {

	/*
	 * A select clause contains one or more select entries
	 */
	private SelectEntry[] selectEntries;

	/*
	 * A from clause contains one or more from entries
	 */
	private FromEntry[] fromEntries;

	/*
	 * Optionally, we have a set of where entries
	 */
	private WhereEntry[] whereEntries;

	/**
	 * Constructs an MQL query with a select-clause and a from-clause.
	 * 
	 * @param _selectEntries
	 *            the select entries of the select-clause.
	 * @param _fromEntries
	 *            the from entries of the from-clause.
	 */
	public Query(SelectEntry[] _selectEntries, FromEntry[] _fromEntries) {

		this(_selectEntries, _fromEntries, new WhereEntry[0]);
	}

	/**
	 * Constructs an MQL query with a select-clause and a from-clause.
	 * 
	 * @param _selectEntries
	 *            the select entries of the select-clause.
	 * @param _fromEntries
	 *            the from entries of the from-clause.
	 */
	public Query(List<SelectEntry> _selectEntries, List<FromEntry> _fromEntries) {

		this(_selectEntries.toArray(new SelectEntry[_selectEntries.size()]), _fromEntries.toArray(new FromEntry[_fromEntries.size()]),
				new WhereEntry[0]);
	}

	/**
	 * Constructs an MQL query with a select-clause, a from-clause, and a set of
	 * where-entries (each where-entry is connected by a logical AND).
	 * 
	 * @param _selectEntries
	 *            the select entries of the select-clause.
	 * @param _fromEntries
	 *            the from entries of the from-clause.
	 * @param _whereEntries
	 *            the different where entries
	 */
	public Query(SelectEntry[] _selectEntries, FromEntry[] _fromEntries, WhereEntry[] _whereEntries) {

		this.selectEntries = _selectEntries;
		this.fromEntries = _fromEntries;
		this.whereEntries = _whereEntries;
	}

	/**
	 * Constructs an MQL query with a select-clause, a from-clause, and a set of
	 * where-entries (each where-entry is connected by a logical AND).
	 * 
	 * @param _selectEntries
	 *            the select entries of the select-clause.
	 * @param _fromEntries
	 *            the from entries of the from-clause.
	 * @param _whereEntries
	 *            the different where entries
	 */
	public Query(List<SelectEntry> _selectEntries, List<FromEntry> _fromEntries, List<WhereEntry> _whereEntries) {

		this.selectEntries = _selectEntries.toArray(new SelectEntry[_selectEntries.size()]);
		this.fromEntries = _fromEntries.toArray(new FromEntry[_fromEntries.size()]);
		this.whereEntries = _whereEntries.toArray(new WhereEntry[_whereEntries.size()]);
	}

	/**
	 * Returns the from-entries.
	 * 
	 * @return the from entries
	 */
	public FromEntry[] getFromEntries() {

		return this.fromEntries;
	}

	/**
	 * Returns the select-entries.
	 * 
	 * @return the select entries
	 */
	public SelectEntry[] getSelectEntries() {

		return this.selectEntries;
	}

	/**
	 * Returns the where-entries.
	 * 
	 * @return the where entries
	 */
	public WhereEntry[] getWhereEntries() {

		return this.whereEntries;
	}

	protected void toString(StringBuilder sb, int indent) {

		char[] whiteSpace = new char[indent];
		Arrays.fill(whiteSpace, ' ');
		sb.append(whiteSpace);

		// SELECT
		sb.append("select "); //$NON-NLS-1$
		if (this.selectEntries != null && this.selectEntries.length > 0) {
			this.selectEntries[0].toString(sb, indent + 7);
			for (int i = 1; i < this.selectEntries.length; i++) {
				sb.append(",\n"); //$NON-NLS-1$
				char[] whiteSpaceN = new char[indent + 7];
				Arrays.fill(whiteSpaceN, ' ');
				sb.append(whiteSpaceN);
				this.selectEntries[i].toString(sb, indent + 7);
			}
		}
		sb.append("\n"); //$NON-NLS-1$
		sb.append(whiteSpace);

		//FROM
		sb.append("from "); //$NON-NLS-1$
		if (this.fromEntries != null && this.fromEntries.length > 0) {
			this.fromEntries[0].toString(sb, indent + 5);
			for (int i = 1; i < this.fromEntries.length; i++) {
				sb.append(",\n"); //$NON-NLS-1$
				char[] whiteSpaceN = new char[indent + 5];
				Arrays.fill(whiteSpaceN, ' ');
				sb.append(whiteSpaceN);
				this.fromEntries[i].toString(sb, indent + 5);
			}
		}
		sb.append("\n"); //$NON-NLS-1$
		sb.append(whiteSpace);

		//WHERE
		if (this.whereEntries != null && this.whereEntries.length > 0) {
			sb.append("where "); //$NON-NLS-1$
			this.whereEntries[0].toString(sb, indent + 6);
			for (int i = 1; i < this.whereEntries.length; i++) {
				sb.append("\n"); //$NON-NLS-1$
				sb.append(whiteSpace);
				sb.append("where "); //$NON-NLS-1$
				this.whereEntries[i].toString(sb, indent + 6);
			}
		}
		sb.append("\n"); //$NON-NLS-1$
		sb.append(whiteSpace);

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		this.toString(sb, 0);
		return sb.toString();
	}

}
