/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>As PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAsPArg()
 * @model
 * @generated
 */
public interface AsPArg extends PropertyArg {
        /**
	 * Returns the value of the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Template</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(Template)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAsPArg_Template()
	 * @model
	 * @generated
	 */
        Template getTemplate();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getTemplate <em>Template</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' reference.
	 * @see #getTemplate()
	 * @generated
	 */
        void setTemplate(Template value);

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
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAsPArg_Value()
	 * @model
	 * @generated
	 */
        String getValue();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.AsPArg#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
        void setValue(String value);

} // AsPArg
