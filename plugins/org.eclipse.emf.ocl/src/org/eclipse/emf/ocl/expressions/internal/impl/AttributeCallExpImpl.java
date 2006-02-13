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

package org.eclipse.emf.ocl.expressions.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.AttributeCallExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.Visitor;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.AttributeCallExpImpl#getReferredAttribute <em>Referred Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeCallExpImpl extends ModelPropertyCallExpImpl implements AttributeCallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getReferredAttribute() <em>Referred Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute referredAttribute = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.ATTRIBUTE_CALL_EXP;
	}

	public Object accept(Visitor v) {
		return v.visitAttributeCallExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferredAttribute() {
		if (referredAttribute != null && referredAttribute.eIsProxy()) {
			InternalEObject oldReferredAttribute = (InternalEObject)referredAttribute;
			referredAttribute = (EAttribute)eResolveProxy(oldReferredAttribute);
			if (referredAttribute != oldReferredAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE, oldReferredAttribute, referredAttribute));
			}
		}
		return referredAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetReferredAttribute() {
		return referredAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAttribute(EAttribute newReferredAttribute) {
		EAttribute oldReferredAttribute = referredAttribute;
		referredAttribute = newReferredAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE, oldReferredAttribute, referredAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				if (resolve) return getReferredAttribute();
				return basicGetReferredAttribute();
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
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				setReferredAttribute((EAttribute)newValue);
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
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				setReferredAttribute((EAttribute)null);
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
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				return referredAttribute != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeCallExpImpl
