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
 * $Id: MessageExp.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getArguments <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp()
 * @model
 * @generated
 */
public interface MessageExp
		extends OclExpression {

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_Target()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getTarget()
	 * @generated
	 */
	OclExpression createTarget(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getTarget()
	 * @generated
	 */
	OclExpression createTarget();

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_Argument()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<OclExpression> getArguments();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and appends it to the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getArguments()
	 * @generated
	 */
	OclExpression createArgument(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and appends it to the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getArguments()
	 * @generated
	 */
	OclExpression createArgument();

	/**
	 * Returns the value of the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Operation</em>' containment reference.
	 * @see #setCalledOperation(CallOperationAction)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_CalledOperation()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	CallOperationAction getCalledOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getCalledOperation <em>Called Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Operation</em>' containment reference.
	 * @see #getCalledOperation()
	 * @generated
	 */
	void setCalledOperation(CallOperationAction value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.CallOperationAction} and sets the '<em><b>Called Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.CallOperationAction}.
	 * @see #getCalledOperation()
	 * @generated
	 */
	CallOperationAction createCalledOperation();

	/**
	 * Returns the value of the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sent Signal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sent Signal</em>' containment reference.
	 * @see #setSentSignal(SendSignalAction)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getMessageExp_SentSignal()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	SendSignalAction getSentSignal();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.MessageExp#getSentSignal <em>Sent Signal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sent Signal</em>' containment reference.
	 * @see #getSentSignal()
	 * @generated
	 */
	void setSentSignal(SendSignalAction value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.SendSignalAction} and sets the '<em><b>Sent Signal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.SendSignalAction}.
	 * @see #getSentSignal()
	 * @generated
	 */
	SendSignalAction createSentSignal();
} // MessageExp
