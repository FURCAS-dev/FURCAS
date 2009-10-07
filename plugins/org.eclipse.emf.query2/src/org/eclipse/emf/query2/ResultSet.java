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
package org.eclipse.emf.query2;

import java.io.Writer;

import org.eclipse.emf.common.util.URI;

/**
 * An MQL result set contains the results of executing an {@link Query}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ResultSet {

	/**
	 * Returns the size of the result set.
	 * 
	 * @return the size of the result set.
	 */
	int getSize();

	/**
	 * Return true if the result set is empty
	 * 
	 * @return true if the result set is empty
	 */
	boolean isEmpty();

	/**
	 * Obtain the {@link MRI} for the particular alias for the provided
	 * position. If the result set does not include this information for the
	 * alias, or the alias was not defined for the particular query, or the
	 * position is out-of-bounds, the {@link QueryResultException} is thrown.
	 * Result sets start at position 0.
	 * 
	 * @param position
	 *            the row position
	 * @param alias
	 *            the alias of the requested element
	 * @return the actual element as a MRI
	 * @throws QueryResultException
	 *             the MQL result exception
	 */
	URI getUri(int position, String alias) throws QueryResultException;

	//	/**
	//	 * Obtain the {@link RefObject} for the particular alias for the provided
	//	 * position. If the result set does not include this information for the
	//	 * alias, or the alias was not defined for the particular query, or the
	//	 * position is out-of-bounds, the {@link MQLResultException} is thrown.
	//	 * Result sets start at position 0.
	//	 * 
	//	 * @param position
	//	 *            the row position
	//	 * @param alias
	//	 *            the alias of the requested element
	//	 * @return the actual element as a RefObject
	//	 * @throws MQLResultException
	//	 *             the MQL result exception
	//	 */
	//	EObject getRefObject(int position, String alias) throws MQLResultException;

	/**
	 * Obtains all the {@link MRI}s for the particular alias in the result set.
	 * If the result set does not include this information for the alias, or the
	 * alias was not defined for the particular query, the
	 * {@link QueryResultException} is thrown.
	 * 
	 * @param alias
	 *            the alias the elements of interest
	 * @return all elements for the alias in the form of a MRI
	 * @throws QueryResultException
	 *             the MQL result exception
	 */
	URI[] getUris(String alias) throws QueryResultException;

	//	/**
	//	 * Obtains all the {@link RefObject}s for the particular alias in the result
	//	 * set. If the result set does not include this information for the alias,
	//	 * or the alias was not defined for the particular query, the
	//	 * {@link MQLResultException} is thrown.
	//	 * 
	//	 * @param alias
	//	 *            the alias the elements of interest
	//	 * @return all elements for the alias in the form of a RefObject
	//	 * @throws MQLResultException
	//	 *             the MQL result exception
	//	 */
	//	EObject[] getRefObjects(String alias) throws MQLResultException;

	/**
	 * Obtain the attribute value for the provided alias, attribute name, and
	 * record position. If the attribute value is single valued, the result type
	 * has to be of type {@link Boolean} {@link Integer}, {@link Long},
	 * {@link Float}, {@link Double}, or {@link String}. If the multiplicity's
	 * lower-end is 0, the result may also be null. If the attribute value is
	 * multi-valued, the result type is of type Object[], where each Object in
	 * the array may again be {@link Boolean} {@link Integer}, {@link Long},
	 * {@link Float}, {@link Double}, or {@link String}. If the result set does
	 * not include this information for the alias, or the alias and/or attribute
	 * was not defined for the particular query, or the position is
	 * out-of-bounds, the {@link QueryResultException} is thrown. Result sets
	 * start at position 0.
	 * 
	 * @param position
	 *            the row position
	 * @param alias
	 *            the alias of the type of the requested attribute
	 * @param attrName
	 *            the requested attribute name
	 * @return the actual attribute value
	 * @throws QueryResultException
	 *             the MQL result exception
	 */
	Object getAttribute(int position, String alias, String attrName) throws QueryResultException;

	/**
	 * Obtains all attributes that were defined in the query for the particular
	 * alias on a give record position. If the result set does not include this
	 * information for the alias, or the alias was not defined for the
	 * particular query, or the position is out-of-bounds, the
	 * {@link QueryResultException} is thrown. Note that if the query did not ask
	 * for attributes for a valid alias, the empty array is returned. Result
	 * sets start at position 0.
	 * 
	 * @param position
	 *            the row position
	 * @param alias
	 *            the alias of the type of the requested attributes
	 * @return the actual attribute values
	 * @throws QueryResultException
	 *             the MQL result exception
	 */
	Object[] getAttributes(int position, String alias) throws QueryResultException;

	/**
	 * Removes a row of data at the provided position. Result sets start at
	 * position 0. If the position is out-of-bounds, the
	 * {@link QueryResultException} is thrown.
	 * 
	 * @param position
	 *            the row position
	 * @return the new size of the result set
	 * @throws QueryResultException
	 *             the MQL result exception
	 */
	int removeRow(int position) throws QueryResultException;

	/**
	 * Returns the format of each column of the result set. This can be used for
	 * reflectively inspecting the result set. Note that the length of this
	 * array corresponds exactly to the number of selections made in the query.
	 * 
	 * @return the query column types
	 */
	ColumnType[] getQueryColumnTypes();

	/**
	 * Streams a Comma-Separated Value list of the results to the provided
	 * Writer. If a problem occurs, the {@link QueryResultException} is thrown.
	 * 
	 * @param writer
	 *            the writer to which the CSV stream is sent
	 * @throws QueryResultException
	 *             the MQL result exception
	 */
	void asCSV(Writer writer) throws QueryResultException;

	/**
	 * Produces a Comma-Separated Value list of the results in the return
	 * string. If a problem occurs, the {@link QueryResultException} is thrown.
	 * 
	 * @return the result set pretty-printed as a CSV
	 */
	String toString();

}
