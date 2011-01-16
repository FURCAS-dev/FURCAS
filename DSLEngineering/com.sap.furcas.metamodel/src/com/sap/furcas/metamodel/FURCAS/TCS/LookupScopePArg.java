/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lookup Scope PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLookupScopePArg()
 * @model
 * @generated
 */
public interface LookupScopePArg extends PropertyArg {
    /**
     * Returns the value of the '<em><b>Query</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Query</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The query is meant to return all elements that shall be considered when references are resolved by name (see {@link ReferenceByPArg}). 
     * <!-- end-model-doc -->
     * @return the value of the '<em>Query</em>' attribute.
     * @see #setQuery(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLookupScopePArg_Query()
     * @model required="true"
     * @generated
     */
    String getQuery();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg#getQuery <em>Query</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Query</em>' attribute.
     * @see #getQuery()
     * @generated
     */
    void setQuery(String value);

} // LookupScopePArg
