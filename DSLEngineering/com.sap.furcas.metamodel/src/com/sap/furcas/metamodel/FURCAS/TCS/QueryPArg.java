/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getQueryPArg()
 * @model
 * @generated
 */
public interface QueryPArg extends PropertyArg {

    /**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Query</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getQueryPArg_Query()
	 * @model required="true"
	 * @generated
	 */
    String getQuery();

    /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
    void setQuery(String value);
} // QueryPArg
