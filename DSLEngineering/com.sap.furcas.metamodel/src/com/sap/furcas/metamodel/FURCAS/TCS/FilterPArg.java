/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Filter PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getFilter <em>Filter</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getInvert <em>Invert</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFilterPArg()
 * @model
 * @generated
 */
public interface FilterPArg extends OclPArg {
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
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFilterPArg_Filter()
     * @model
     * @generated
     */
        String getFilter();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getFilter <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Filter</em>' attribute.
     * @see #getFilter()
     * @generated
     */
        void setFilter(String value);

        /**
     * Returns the value of the '<em><b>Invert</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Invert</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Invert</em>' attribute.
     * @see #setInvert(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFilterPArg_Invert()
     * @model
     * @generated
     */
        String getInvert();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg#getInvert <em>Invert</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Invert</em>' attribute.
     * @see #getInvert()
     * @generated
     */
        void setInvert(String value);

} // FilterPArg
