/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: OperationCallExpCSImpl.java,v 1.5 2009/10/10 07:09:24 ewillink Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.OperationCallExpCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.OperationCallExpCSImpl#getIsAtomic <em>Is Atomic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCallExpCSImpl
		extends FeatureCallExpCSImpl
		implements OperationCallExpCS {

	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS;

	/**
	 * The default value of the '{@link #getIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_ATOMIC_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getIsAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getIsAtomic()
	 * @generated
	 * @ordered
	 */
	protected Boolean isAtomic = IS_ATOMIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCallExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.OPERATION_CALL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS,
			NotificationChain msgs) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS, oldPathNameCS,
				newPathNameCS);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		if (newPathNameCS != pathNameCS) {
			NotificationChain msgs = null;
			if (pathNameCS != null)
				msgs = ((InternalEObject) pathNameCS).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS, null,
					msgs);
			if (newPathNameCS != null)
				msgs = ((InternalEObject) newPathNameCS).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS, null,
					msgs);
			msgs = basicSetPathNameCS(newPathNameCS, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS, newPathNameCS,
				newPathNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsAtomic() {
		return isAtomic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAtomic(Boolean newIsAtomic) {
		Boolean oldIsAtomic = isAtomic;
		isAtomic = newIsAtomic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC, oldIsAtomic,
				isAtomic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS :
				return basicSetPathNameCS(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS :
				return getPathNameCS();
			case CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC :
				return getIsAtomic();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS :
				setPathNameCS((PathNameCS) newValue);
				return;
			case CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC :
				setIsAtomic((Boolean) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS :
				setPathNameCS((PathNameCS) null);
				return;
			case CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC :
				setIsAtomic(IS_ATOMIC_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CSTPackage.OPERATION_CALL_EXP_CS__PATH_NAME_CS :
				return pathNameCS != null;
			case CSTPackage.OPERATION_CALL_EXP_CS__IS_ATOMIC :
				return IS_ATOMIC_EDEFAULT == null
					? isAtomic != null
					: !IS_ATOMIC_EDEFAULT.equals(isAtomic);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isAtomic: "); //$NON-NLS-1$
		result.append(isAtomic);
		result.append(')');
		return result.toString();
	}

} //OperationCallExpCSImpl
