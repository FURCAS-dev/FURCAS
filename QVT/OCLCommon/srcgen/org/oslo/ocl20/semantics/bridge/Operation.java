/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Operation#getOwnedParameter <em>Owned Parameter</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Operation#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list. The
	 * list contents are of type {@link org.oslo.ocl20.semantics.bridge.Parameter}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.bridge.Parameter#getOperation <em>Operation</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getOperation_OwnedParameter()
	 * @see org.oslo.ocl20.semantics.bridge.Parameter#getOperation
	 * @model type="org.oslo.ocl20.semantics.bridge.Parameter" opposite="operation"
	 *        containment="true"
	 * @generated
	 */
	EList getOwnedParameter();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Return Type</em>' reference.
	 * @see #setReturnType(Classifier)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getOperation_ReturnType()
	 * @model required="true"
	 * @generated
	 */
	Classifier getReturnType();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.Operation#getReturnType
	 * <em>Return Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Return Type</em>' reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(Classifier value);

} // Operation
