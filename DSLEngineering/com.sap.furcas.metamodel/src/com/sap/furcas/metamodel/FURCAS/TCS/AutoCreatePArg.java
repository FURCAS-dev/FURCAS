/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Auto Create PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAutoCreatePArg()
 * @model
 * @generated
 */
public interface AutoCreatePArg extends PropertyArg {
        /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * The literals are from the enumeration {@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Value</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind
     * @see #setValue(AutoCreateKind)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAutoCreatePArg_Value()
     * @model required="true"
     * @generated
     */
        AutoCreateKind getValue();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind
     * @see #getValue()
     * @generated
     */
        void setValue(AutoCreateKind value);

} // AutoCreatePArg
