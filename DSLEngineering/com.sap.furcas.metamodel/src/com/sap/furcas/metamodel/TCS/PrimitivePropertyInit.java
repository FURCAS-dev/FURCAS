/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Property Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.PrimitivePropertyInit#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPrimitivePropertyInit()
 * @model
 * @generated
 */
public interface PrimitivePropertyInit extends PropertyInit {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Value)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPrimitivePropertyInit_Value()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Value getValue();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.PrimitivePropertyInit#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Value value);

} // PrimitivePropertyInit
