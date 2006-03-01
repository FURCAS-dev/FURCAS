/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.types.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.uml.Signal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.types.internal.impl.MessageTypeImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.types.internal.impl.MessageTypeImpl#getReferredSignal <em>Referred Signal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageTypeImpl extends EClassifierImpl implements MessageType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getReferredSignal() <em>Referred Signal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredSignal()
	 * @generated
	 * @ordered
	 */
	protected Signal referredSignal = null;

	/**
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation referredOperation = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.MESSAGE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getReferredSignal() {
		if (referredSignal != null && referredSignal.eIsProxy()) {
			InternalEObject oldReferredSignal = (InternalEObject)referredSignal;
			referredSignal = (Signal)eResolveProxy(oldReferredSignal);
			if (referredSignal != oldReferredSignal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
			}
		}
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal basicGetReferredSignal() {
		return referredSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredSignal(Signal newReferredSignal) {
		Signal oldReferredSignal = referredSignal;
		referredSignal = newReferredSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL, oldReferredSignal, referredSignal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				if (resolve) return getReferredSignal();
				return basicGetReferredSignal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((EOperation)newValue);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((Signal)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((EOperation)null);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((Signal)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				return referredOperation != null;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				return referredSignal != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getReferredOperation() {
		if (referredOperation != null && referredOperation.eIsProxy()) {
			InternalEObject oldReferredOperation = (InternalEObject)referredOperation;
			referredOperation = (EOperation)eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOperation(EOperation newReferredOperation) {
		EOperation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION, oldReferredOperation, referredOperation));
	}

} //MessageTypeImpl
