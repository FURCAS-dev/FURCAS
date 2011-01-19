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
 * Created on 20.03.2006
 */
package org.eclipse.emf.query2.internal.moinql.controller;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.ColumnType;
import org.eclipse.emf.query2.EmfHelper;
import org.eclipse.emf.query2.QueryResultException;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.internal.fql.SpiFqlQueryResultSet;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.SelectEntry;


/**
 * An MQL Result Set wraps the {@link SpiFqlQueryResultSet} structure. It does
 * some book-keeping to map user-defined aliases and attribute references to the
 * correct position in the wrapped result set.
 */
public class ResultSetImpl implements ResultSet {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(ResultSetImpl.class);

	// we keep the result set as a BasicQueryResultSet
	private final SpiFqlQueryResultSet resultSet;

	// the size of the result set
	private int resultSetSize;

	// we keep a connection to resolve MRIs if asked for
	//    private final CoreConnection conn;

	// keeps the format of each column in the result set
	private final ColumnType[] columnTypes;

	// this maps the alias String to the number of select list
	private final Map<String, Integer> aliasToPosition;

	// this list contains maps of attribute names to their positions in the
	// select list of a particular alias.
	// The position of the alias in a record is the index in this list of maps
	private final List<Map<String, Integer>> attrsToPosition;

	private EmfHelper emfHelper;

	/**
	 * @param _aliasResultStructures
	 *            the structure of the query which is responsible for this
	 *            result set
	 * @param _resultSet
	 *            the encapsulated BasicQuery result set
	 * @param _aliasToPosition
	 *            the map from alias strings to Integer positions
	 * @param _attrToPosition
	 *            the array of maps from attribute names to Integer positions.
	 *            For each alias position, we have a map in this array at the
	 *            position of the alias position
	 */
	public ResultSetImpl(EmfHelper _emfHelper, List<SelectEntry> selectEntries, SpiFqlQueryResultSet _resultSet,
			Map<String, Integer> _aliasToPosition, List<Map<String, Integer>> _attrsToPosition) {

		//        this.conn = (CoreConnection) _conn;
		this.emfHelper = _emfHelper;
		this.resultSet = _resultSet;
		this.aliasToPosition = _aliasToPosition;
		this.attrsToPosition = _attrsToPosition;
		this.resultSetSize = (_resultSet == null ? 0 : _resultSet.getSize());

		// construct the column types
		this.columnTypes = new ColumnType[selectEntries.size()];

		int j = 0;
		for (Iterator<SelectEntry> iter = selectEntries.iterator(); iter.hasNext(); j++) {
			this.columnTypes[j] = iter.next().getColumnType();
		}

		// because original aliases might have disappeared during query processing, 
		// we add them here and give them the same value as the "new" alias
		this.addOriginalAliases();

		// put a lexicographical sort on the result set
		this.lexicographicSort();
	}

	/**
	 * this method makes sure that all originally used aliases are also given a
	 * position
	 */
	private void addOriginalAliases() {

		if (this.aliasToPosition != null) {
			// only for the non-empty set
			for (int i = 0; i < this.columnTypes.length; i++) {
				this.aliasToPosition.put(this.columnTypes[i].alias, this.aliasToPosition.get(this.columnTypes[i].newRuntimeAlias));
			}
		}
	}

	public ResultSetImpl(EmfHelper _emfHelper, List<SelectEntry> selectEntries) {

		this(_emfHelper, selectEntries, null, null, null);
	}

	public int getSize() {

		return this.resultSetSize;
	}

	public boolean isEmpty() {

		return this.resultSetSize == 0;
	}

	public URI getUri(int position, String alias) throws QueryResultException {

		// check for index out of bounds
		if (position >= 0 && position < this.resultSetSize) {
			return this.resultSet.getMri(position, this.getAliasPosition(alias));
		}
		throw new QueryResultException(ApiMessages.QUERY_RESULT_OUT_OF_BOUNDS);
	}

	public int removeRow(int position) throws QueryResultException {

		// check for index out of bounds
		if (position >= 0 && position < this.resultSetSize) {
			if (this.resultSet.removeEntry(position)) {
				return (--this.resultSetSize);
			}
		}
		throw new QueryResultException(ApiMessages.QUERY_RESULT_OUT_OF_BOUNDS);
	}
	/**
	 * Returns an array of URIs for the given alias
	 */
	public URI[] getUris(String alias) throws QueryResultException {

		URI[] resultMRI = new URI[this.resultSetSize];

		// for empty sets, since there is no getAliasPosition for such result sets
		if (resultMRI.length == 0) {
			return resultMRI;
		}

		// build the result set
		int aliasPosition = this.getAliasPosition(alias);
		for (int i = 0; i < resultMRI.length; i++) {
			resultMRI[i] = this.resultSet.getMri(i, aliasPosition);
		}

		return resultMRI;
	}
	/**
	 * Returns the attribute by the given name from the given alias
	 */
	public Object getAttribute(int position, String alias, String attrName) throws QueryResultException {

		// check for index out of bounds
		if (position >= 0 && position < this.resultSetSize) {
			// obtain the number of the selection list
			int aliasPos = this.getAliasPosition(alias);

			// obtain the attributeName mapper for this alias
			Map<String, Integer> aliasAttrNames = this.attrsToPosition.get(aliasPos);

			Integer attrPos = aliasAttrNames.get(attrName);

			if (attrPos != null) {
				return this.getAttributeValueForPosition(position, aliasPos, attrPos);
			}
			// the attribute name was not defined for the particular alias of the result set
			throw new QueryResultException(ApiMessages.ATTRIBUTE_NOT_SELECTED, attrName, alias);
		}
		// index out of bounds
		throw new QueryResultException(ApiMessages.QUERY_RESULT_OUT_OF_BOUNDS);
	}
	/**
	 * Returns the attributes from the given alias
	 */
	public Object[] getAttributes(int position, String alias) throws QueryResultException {

		// check for index out of bounds
		if (position >= 0 && position < this.resultSetSize) {
			// obtain the position of the alias
			int aliasPos = this.getAliasPosition(alias);

			// obtain the number of attributes for that alias
			int numberOfAttrs = this.attrsToPosition.get(aliasPos).values().size();

			// construct the result set
			Object[] result = new Object[numberOfAttrs];

			// iterate over the to-be-constructed result
			for (int attrPos = 0; attrPos < result.length; attrPos++) {
				result[attrPos] = this.getAttributeValueForPosition(position, aliasPos, attrPos);
			}

			return result;
		}

		throw new QueryResultException(ApiMessages.QUERY_RESULT_OUT_OF_BOUNDS);
	}

	private int getAliasPosition(String alias) throws QueryResultException {

		// observe that the pre-condition is a non-empty result set
		Integer aliasPosition = this.aliasToPosition.get(alias);

		if (aliasPosition != null) {
			return aliasPosition;
		}
		// the alias was not defined for the particular result set
		throw new QueryResultException(ApiMessages.UNDEFINED_ALIAS, alias);
	}

	private Object getAttributeValueForPosition(int position, int aliasPos, int attrPos) throws QueryResultException {

		// check for index out of bounds
		if (position >= 0 && position < this.resultSetSize) {
			return this.resultSet.getAttributeValue(position, aliasPos, attrPos);
		}
		throw new QueryResultException(ApiMessages.QUERY_RESULT_OUT_OF_BOUNDS);
	}

	public ColumnType[] getQueryColumnTypes() {

		return this.columnTypes;
	}

	@Override
	public String toString() {

		StringWriter sw = new StringWriter();
		this.asCSV(sw);

		return sw.toString();
	}

	public void asCSV(Writer writer) throws QueryResultException {

		// separation character for CSV
		char sep_char = ';';

		// separation character for multi-valued attributes
		char mv_sep_char = ',';

		// obtain header data
		ColumnType[] headerData = this.getQueryColumnTypes();

		try {

			// create table header
			for (int k = 0; k < headerData.length; k++) {
				writer.append(headerData[k].alias);
				// writer.append(aliasesHeaderList.get(k));
				if (headerData[k].attribute != null) {
					writer.append("."); //$NON-NLS-1$
					writer.append(headerData[k].attribute);
					if (headerData[k].multiValued) {
						writer.append("[multi]"); //$NON-NLS-1$
					}
				}
				writer.append(" : "); //$NON-NLS-1$
				writer.append(headerData[k].typeName);

				// CSV lines do not have a final separation character
				if (k < (headerData.length - 1)) {
					writer.append(sep_char);
				}
			}
			writer.append("\n"); //$NON-NLS-1$

			// create table data

			for (int l = 0; l < this.resultSetSize; l++) {

				for (int k = 0; k < headerData.length; k++) {
					// if no attribute is specified, return MRI of the
					// ModelElement
					if (headerData[k].attribute == null) {
						writer.append(this.getUri(l, headerData[k].alias).toString());
					} else {
						// for multivalued attributes, put all values in one
						// field
						if (headerData[k].multiValued) {
							Object[] mvAttr = (Object[]) (this.getAttribute(l, headerData[k].alias, headerData[k].attribute));
							if (mvAttr == null) {
								writer.append("null"); //$NON-NLS-1$
							} else {
								for (int i = 0; i < mvAttr.length; i++) {
									writer.append(mvAttr[i].toString());
									if (i < mvAttr.length - 1) {
										writer.append(mv_sep_char);
									}
								}
							}

						} else {
							Object value = this.getAttribute(l, headerData[k].alias, headerData[k].attribute);
							if (value == null) {
								writer.append("null"); //$NON-NLS-1$
							} else {
								writer.append(value.toString());
							}
						}
					}
					if (k < headerData.length - 1) {
						writer.append(sep_char);
					}
				}
				writer.append("\n"); //$NON-NLS-1$
			}

		} catch (IOException e) {
			throw new QueryResultException(e, ApiMessages.IO_DURING_CSV_SERIALIZATION);
		}
	}

	/**
	 * Puts a lexicographic ordering on the result set
	 */
	private void lexicographicSort() {

		// only if not null!
		if (this.resultSet != null && this.resultSet.getSize() > 1) {

			long timeStamp = System.nanoTime();

			// based on the query columns, make a sort-list
			int[][] positions = new int[this.columnTypes.length][2];
			for (int i = 0; i < this.columnTypes.length; i++) {
				ColumnType columnType = this.columnTypes[i];
				// for aliases, we only need the alias position
				positions[i][0] = this.aliasToPosition.get(columnType.alias);
				if (columnType.attribute != null) {
					// for attributes, we also get the attribute position
					positions[i][1] = this.attrsToPosition.get(positions[i][0]).get(columnType.attribute);
				} else {
					positions[i][1] = -1;
				}
			}

			// do the actual sorting
			this.resultSet.lexicographicSort(positions);

			if (logger.isTraced(LogSeverity.DEBUG)) {
				long queryTime = (System.nanoTime() - timeStamp) / 1000000;
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_PUTTING_FIX_ORDER_ON_RESULT_SET, queryTime);
			}
		}
	}
}
