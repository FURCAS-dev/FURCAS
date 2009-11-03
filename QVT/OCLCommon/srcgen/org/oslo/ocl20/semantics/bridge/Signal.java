/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Signal</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Signal#getParameterNames <em>Parameter Names</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Signal#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getSignal()
 * @model
 * @generated
 */
public interface Signal extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Parameter Names</b></em>' attribute list. The list contents
	 * are of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Names</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parameter Names</em>' attribute list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getSignal_ParameterNames()
	 * @model
	 * @generated
	 */
	EList getParameterNames();

	/**
	 * Returns the value of the '<em><b>Parameter Types</b></em>' reference list. The list contents
	 * are of type {@link org.oslo.ocl20.semantics.bridge.Classifier}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Types</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parameter Types</em>' reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getSignal_ParameterTypes()
	 * @model type="org.oslo.ocl20.semantics.bridge.Classifier"
	 * @generated
	 */
	EList getParameterTypes();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Signal
