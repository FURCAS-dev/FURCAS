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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.AssociationEndCallExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.AssociationEndCallExpImpl#getReferredAssociationEnd <em>Referred Association End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndCallExpImpl extends NavigationCallExpImpl implements AssociationEndCallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getReferredAssociationEnd() <em>Referred Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAssociationEnd()
	 * @generated
	 * @ordered
	 */
	protected EReference referredAssociationEnd = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationEndCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.ASSOCIATION_END_CALL_EXP;
	}

	/**
	 * Accept a visitor
	 * @param v the visitor to accept
	 */
	public Object accept(Visitor v) {
		return v.visitAssociationEndCallExp(this);
	}
		

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferredAssociationEnd() {
		if (referredAssociationEnd != null && referredAssociationEnd.eIsProxy()) {
			InternalEObject oldReferredAssociationEnd = (InternalEObject)referredAssociationEnd;
			referredAssociationEnd = (EReference)eResolveProxy(oldReferredAssociationEnd);
			if (referredAssociationEnd != oldReferredAssociationEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END, oldReferredAssociationEnd, referredAssociationEnd));
			}
		}
		return referredAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReferredAssociationEnd() {
		return referredAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAssociationEnd(EReference newReferredAssociationEnd) {
		EReference oldReferredAssociationEnd = referredAssociationEnd;
		referredAssociationEnd = newReferredAssociationEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END, oldReferredAssociationEnd, referredAssociationEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				if (resolve) return getReferredAssociationEnd();
				return basicGetReferredAssociationEnd();
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				setReferredAssociationEnd((EReference)newValue);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				setReferredAssociationEnd((EReference)null);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				return referredAssociationEnd != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	public String toString() {
		return ToStringVisitorImpl.toString(this);
	}

} //AssociationEndCallExpImpl
