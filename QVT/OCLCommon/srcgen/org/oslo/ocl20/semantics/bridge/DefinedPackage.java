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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Defined Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.DefinedPackage#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedPackage()
 * @model
 * @generated
 */
public interface DefinedPackage extends Namespace {
	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference list. The list
	 * contents are of type {@link org.oslo.ocl20.semantics.bridge.DefinedClass}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedClass#getPackage <em>Package</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owned Type</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedPackage_OwnedType()
	 * @see org.oslo.ocl20.semantics.bridge.DefinedClass#getPackage
	 * @model type="org.oslo.ocl20.semantics.bridge.DefinedClass" opposite="package"
	 *        containment="true"
	 * @generated
	 */
	EList getOwnedType();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // DefinedPackage
