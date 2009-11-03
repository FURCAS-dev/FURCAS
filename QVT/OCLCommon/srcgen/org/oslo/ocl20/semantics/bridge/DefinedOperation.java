/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Defined Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.bridge.DefinedOperation#getClass_ <em>Class</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.bridge.DefinedOperation#getRaisedException <em>Raised
 * Exception</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedOperation()
 * @model
 * @generated
 */
public interface DefinedOperation extends Operation {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link org.oslo.ocl20.semantics.bridge.DefinedClass#getOwnedOperation
	 * <em>Owned Operation</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(DefinedClass)
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedOperation_Class()
	 * @see org.oslo.ocl20.semantics.bridge.DefinedClass#getOwnedOperation
	 * @model opposite="ownedOperation" required="true" transient="false"
	 * @generated
	 */
	DefinedClass getClass_();

	/**
	 * Sets the value of the '{@link org.oslo.ocl20.semantics.bridge.DefinedOperation#getClass_
	 * <em>Class</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(DefinedClass value);

	/**
	 * Returns the value of the '<em><b>Raised Exception</b></em>' reference list. The list contents
	 * are of type {@link org.oslo.ocl20.semantics.bridge.Classifier}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised Exception</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Raised Exception</em>' reference list.
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getDefinedOperation_RaisedException()
	 * @model type="org.oslo.ocl20.semantics.bridge.Classifier"
	 * @generated
	 */
	EList getRaisedException();

} // DefinedOperation
