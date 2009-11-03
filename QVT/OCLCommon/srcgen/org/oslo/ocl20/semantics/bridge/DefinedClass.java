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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Defined Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.DefinedClass#getOwnedOperation <em>Owned Operation
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.DefinedClass#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedClass()
 * @model
 * @generated
 */
public interface DefinedClass extends Classifier {
	/**
	 * Returns the value of the '<em><b>Owned Operation</b></em>' containment reference list. The
	 * list contents are of type {@link org.oslo.ocl20.semantics.bridge.DefinedOperation}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedOperation#getClass_ <em>Class</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owned Operation</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedClass_OwnedOperation()
	 * @see org.oslo.ocl20.semantics.bridge.DefinedOperation#getClass_
	 * @model type="org.oslo.ocl20.semantics.bridge.DefinedOperation" opposite="class"
	 *        containment="true"
	 * @generated
	 */
	EList getOwnedOperation();

	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link org.oslo.ocl20.semantics.bridge.DefinedPackage#getOwnedType
	 * <em>Owned Type</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(DefinedPackage)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedClass_Package()
	 * @see org.oslo.ocl20.semantics.bridge.DefinedPackage#getOwnedType
	 * @model opposite="ownedType" required="true" transient="false"
	 * @generated
	 */
	DefinedPackage getPackage();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.DefinedClass#getPackage
	 * <em>Package</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(DefinedPackage value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // DefinedClass
