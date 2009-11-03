/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.oslo.ocl20.semantics.SemanticsVisitable;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.ModelElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends SemanticsVisitable, Element {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getModelElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.ModelElement#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.Object"
	 * @generated
	 */
	Object getDelegate();

} // ModelElement
