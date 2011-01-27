/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: MessageType.java,v 1.2 2011/01/24 20:42:34 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageType()
 * @model
 * @generated
 */
public interface MessageType
		extends Type {

	/**
	 * Returns the value of the '<em><b>Referred Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Signal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Signal</em>' reference.
	 * @see #setReferredSignal(Signal)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageType_ReferredSignal()
	 * @model ordered="false"
	 * @generated
	 */
	Signal getReferredSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredSignal <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Signal</em>' reference.
	 * @see #getReferredSignal()
	 * @generated
	 */
	void setReferredSignal(Signal value);

	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see #setReferredOperation(Operation)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageType_ReferredOperation()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageType#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Operation value);

} // MessageType
