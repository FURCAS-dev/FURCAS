/*
 * Created on 20.03.2006
 */
package com.sap.tc.moin.repository.mql;

import java.io.Writer;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;

/**
 * An MQL result set contains the results of executing an {@link MQLQuery}.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MQLResultSet {

    /**
     * Returns the size of the result set.
     * 
     * @return the size of the result set.
     */
    int getSize( );

    /**
     * Return true if the result set is empty
     * 
     * @return true if the result set is empty
     */
    boolean isEmpty( );

    /**
     * Obtain the {@link MRI} for the particular alias for the provided
     * position. If the result set does not include this information for the
     * alias, or the alias was not defined for the particular query, or the
     * position is out-of-bounds, the {@link MQLResultException} is thrown.
     * Result sets start at position 0.
     * 
     * @param position the row position
     * @param alias the alias of the requested element
     * @return the actual element as a MRI
     * @throws MQLResultException the MQL result exception
     */
    MRI getMri( int position, String alias ) throws MQLResultException;

    /**
     * Obtain the {@link RefObject} for the particular alias for the provided
     * position. If the result set does not include this information for the
     * alias, or the alias was not defined for the particular query, or the
     * position is out-of-bounds, the {@link MQLResultException} is thrown.
     * Result sets start at position 0.
     * 
     * @param position the row position
     * @param alias the alias of the requested element
     * @return the actual element as a RefObject
     * @throws MQLResultException the MQL result exception
     */
    RefObject getRefObject( int position, String alias ) throws MQLResultException;

    /**
     * Obtains all the {@link MRI}s for the particular alias in the result set.
     * If the result set does not include this information for the alias, or the
     * alias was not defined for the particular query, the
     * {@link MQLResultException} is thrown.
     * 
     * @param alias the alias the elements of interest
     * @return all elements for the alias in the form of a MRI
     * @throws MQLResultException the MQL result exception
     */
    MRI[] getMris( String alias ) throws MQLResultException;

    /**
     * Obtains all the {@link RefObject}s for the particular alias in the result
     * set. If the result set does not include this information for the alias,
     * or the alias was not defined for the particular query, the
     * {@link MQLResultException} is thrown.
     * 
     * @param alias the alias the elements of interest
     * @return all elements for the alias in the form of a RefObject
     * @throws MQLResultException the MQL result exception
     */
    RefObject[] getRefObjects( String alias ) throws MQLResultException;

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
     * out-of-bounds, the {@link MQLResultException} is thrown. Result sets
     * start at position 0.
     * 
     * @param position the row position
     * @param alias the alias of the type of the requested attribute
     * @param attrName the requested attribute name
     * @return the actual attribute value
     * @throws MQLResultException the MQL result exception
     */
    Object getAttribute( int position, String alias, String attrName ) throws MQLResultException;

    /**
     * Obtains all attributes that were defined in the query for the particular
     * alias on a give record position. If the result set does not include this
     * information for the alias, or the alias was not defined for the
     * particular query, or the position is out-of-bounds, the
     * {@link MQLResultException} is thrown. Note that if the query did not ask
     * for attributes for a valid alias, the empty array is returned. Result
     * sets start at position 0.
     * 
     * @param position the row position
     * @param alias the alias of the type of the requested attributes
     * @return the actual attribute values
     * @throws MQLResultException the MQL result exception
     */
    Object[] getAttributes( int position, String alias ) throws MQLResultException;

    /**
     * Removes a row of data at the provided position. Result sets start at
     * position 0. If the position is out-of-bounds, the
     * {@link MQLResultException} is thrown.
     * 
     * @param position the row position
     * @return the new size of the result set
     * @throws MQLResultException the MQL result exception
     */
    int removeRow( int position ) throws MQLResultException;

    /**
     * Returns the format of each column of the result set. This can be used for
     * reflectively inspecting the result set. Note that the length of this
     * array corresponds exactly to the number of selections made in the query.
     * 
     * @return the query column types
     */
    MQLColumnType[] getQueryColumnTypes( );

    /**
     * Streams a Comma-Separated Value list of the results to the provided
     * Writer. If a problem occurs, the {@link MQLResultException} is thrown.
     * 
     * @param writer the writer to which the CSV stream is sent
     * @throws MQLResultException the MQL result exception
     */
    void asCSV( Writer writer ) throws MQLResultException;

    /**
     * Produces a Comma-Separated Value list of the results in the return
     * string. If a problem occurs, the {@link MQLResultException} is thrown.
     * 
     * @return the result set pretty-printed as a CSV
     */
    String toString( );

}
