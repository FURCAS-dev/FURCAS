/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query By Identifier PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterByIdentifierPArg#getFilter <em>Filter</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterByIdentifierPArg#getCriterion <em>Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFilterByIdentifierPArg()
 * @model
 * @generated
 */
public interface FilterByIdentifierPArg extends PropertyArg {
    /**
     * Returns the value of the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filter</em>' attribute.
     * @see #setFilter(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFilterByIdentifierPArg_Filter()
     * @model
     * @generated
     */
    String getFilter();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterByIdentifierPArg#getFilter <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Filter</em>' attribute.
     * @see #getFilter()
     * @generated
     */
    void setFilter(String value);

    /**
     * Returns the value of the '<em><b>Criterion</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Criterion</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Criterion</em>' attribute.
     * @see #setCriterion(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFilterByIdentifierPArg_Criterion()
     * @model
     * @generated
     */
    String getCriterion();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterByIdentifierPArg#getCriterion <em>Criterion</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Criterion</em>' attribute.
     * @see #getCriterion()
     * @generated
     */
    void setCriterion(String value);

} // QueryByIdentifierPArg
