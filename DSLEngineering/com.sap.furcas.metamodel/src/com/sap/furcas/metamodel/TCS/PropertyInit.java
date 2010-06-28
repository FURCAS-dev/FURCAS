/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.PropertyInit#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPropertyInit()
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
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPropertyInit_PropertyReference()
	 * @model
	 * @generated
	 */
	PropertyReference getPropertyReference();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.PropertyInit#getPropertyReference <em>Property Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Reference</em>' reference.
	 * @see #getPropertyReference()
	 * @generated
	 */
	void setPropertyReference(PropertyReference value);

} // PropertyInit
