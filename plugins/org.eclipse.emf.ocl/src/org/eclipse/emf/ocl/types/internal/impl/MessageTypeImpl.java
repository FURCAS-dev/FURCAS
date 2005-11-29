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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.TypesPackage;

import org.eclipse.emf.ocl.uml.Signal;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Message Type</b></em>'.
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
		return TypesPackage.eINSTANCE.getMessageType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signal getReferredSignal() {
		if (referredSignal != null && referredSignal.eIsProxy()) {
			Signal oldReferredSignal = referredSignal;
			referredSignal = (Signal)eResolveProxy((InternalEObject)referredSignal);
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
	public EOperation getReferredOperation() {
		if (referredOperation != null && referredOperation.eIsProxy()) {
			EOperation oldReferredOperation = referredOperation;
			referredOperation = (EOperation)eResolveProxy((InternalEObject)referredOperation);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.MESSAGE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.MESSAGE_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.MESSAGE_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.MESSAGE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.MESSAGE_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.MESSAGE_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case TypesPackage.MESSAGE_TYPE__EPACKAGE:
					return eContainer.eInverseRemove(this, EcorePackage.EPACKAGE__ECLASSIFIERS, EPackage.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.MESSAGE_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.MESSAGE_TYPE__NAME:
				return getName();
			case TypesPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.MESSAGE_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.MESSAGE_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.MESSAGE_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				if (resolve) return getReferredSignal();
				return basicGetReferredSignal();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.MESSAGE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.MESSAGE_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((EOperation)newValue);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((Signal)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.MESSAGE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.MESSAGE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				setReferredOperation((EOperation)null);
				return;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				setReferredSignal((Signal)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.MESSAGE_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.MESSAGE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.MESSAGE_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.MESSAGE_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.MESSAGE_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.MESSAGE_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.MESSAGE_TYPE__REFERRED_OPERATION:
				return referredOperation != null;
			case TypesPackage.MESSAGE_TYPE__REFERRED_SIGNAL:
				return referredSignal != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //MessageTypeImpl
