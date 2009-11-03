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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enumeration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.Enumeration#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends DataType {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' containment reference list. The list
	 * contents are of type {@link org.oslo.ocl20.semantics.bridge.EnumLiteral}. It is bidirectional
	 * and its opposite is '{@link org.oslo.ocl20.semantics.bridge.EnumLiteral#getEnumeration
	 * <em>Enumeration</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Literal</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getEnumeration_Literal()
	 * @see org.oslo.ocl20.semantics.bridge.EnumLiteral#getEnumeration
	 * @model type="org.oslo.ocl20.semantics.bridge.EnumLiteral" opposite="enumeration"
	 *        containment="true" required="true"
	 * @generated
	 */
	EList getLiteral();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	EnumLiteral lookupEnumLiteral(String name);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Enumeration
