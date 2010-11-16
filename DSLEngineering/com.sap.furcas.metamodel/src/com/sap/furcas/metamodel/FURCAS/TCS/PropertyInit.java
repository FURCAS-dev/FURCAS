/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getPropertyReference <em>Property Reference</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#isDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyInit()
 * @model abstract="true"
 * @generated
 */
public interface PropertyInit extends InjectorAction {
        /**
     * Returns the value of the '<em><b>Property Reference</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property Reference</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Property Reference</em>' reference.
     * @see #setPropertyReference(PropertyReference)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyInit_PropertyReference()
     * @model
     * @generated
     */
        PropertyReference getPropertyReference();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getPropertyReference <em>Property Reference</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property Reference</em>' reference.
     * @see #getPropertyReference()
     * @generated
     */
        void setPropertyReference(PropertyReference value);

        /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Value</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyInit_Value()
     * @model
     * @generated
     */
        String getValue();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
        void setValue(String value);

        /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyInit_Default()
     * @model
     * @generated
     */
    boolean isDefault();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit#isDefault <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default</em>' attribute.
     * @see #isDefault()
     * @generated
     */
    void setDefault(boolean value);

} // PropertyInit
