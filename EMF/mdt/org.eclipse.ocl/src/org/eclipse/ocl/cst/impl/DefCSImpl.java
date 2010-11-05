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
 * $Id: DefCSImpl.java,v 1.4 2009/09/04 08:27:07 ewillink Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.DefCS;
import org.eclipse.ocl.cst.DefExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.DefCSImpl#getDefExpressionCS <em>Def Expression CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.DefCSImpl#isStatic <em>Static</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefCSImpl
		extends InvOrDefCSImpl
		implements DefCS {

	/**
	 * The cached value of the '{@link #getDefExpressionCS() <em>Def Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected DefExpressionCS defExpressionCS;

	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final int STATIC_EFLAG = 1 << 8;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.DEF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefExpressionCS getDefExpressionCS() {
		return defExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefExpressionCS(
			DefExpressionCS newDefExpressionCS, NotificationChain msgs) {
		DefExpressionCS oldDefExpressionCS = defExpressionCS;
		defExpressionCS = newDefExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, CSTPackage.DEF_CS__DEF_EXPRESSION_CS,
				oldDefExpressionCS, newDefExpressionCS);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefExpressionCS(DefExpressionCS newDefExpressionCS) {
		if (newDefExpressionCS != defExpressionCS) {
			NotificationChain msgs = null;
			if (defExpressionCS != null)
				msgs = ((InternalEObject) defExpressionCS).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.DEF_CS__DEF_EXPRESSION_CS, null, msgs);
			if (newDefExpressionCS != null)
				msgs = ((InternalEObject) newDefExpressionCS).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.DEF_CS__DEF_EXPRESSION_CS, null, msgs);
			msgs = basicSetDefExpressionCS(newDefExpressionCS, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.DEF_CS__DEF_EXPRESSION_CS, newDefExpressionCS,
				newDefExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return (eFlags & STATIC_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(boolean newStatic) {
		boolean oldStatic = (eFlags & STATIC_EFLAG) != 0;
		if (newStatic)
			eFlags |= STATIC_EFLAG;
		else
			eFlags &= ~STATIC_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.DEF_CS__STATIC, oldStatic, newStatic));
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
			case CSTPackage.DEF_CS__DEF_EXPRESSION_CS :
				return basicSetDefExpressionCS(null, msgs);
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
			case CSTPackage.DEF_CS__DEF_EXPRESSION_CS :
				return getDefExpressionCS();
			case CSTPackage.DEF_CS__STATIC :
				return isStatic();
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
			case CSTPackage.DEF_CS__DEF_EXPRESSION_CS :
				setDefExpressionCS((DefExpressionCS) newValue);
				return;
			case CSTPackage.DEF_CS__STATIC :
				setStatic((Boolean) newValue);
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
			case CSTPackage.DEF_CS__DEF_EXPRESSION_CS :
				setDefExpressionCS((DefExpressionCS) null);
				return;
			case CSTPackage.DEF_CS__STATIC :
				setStatic(STATIC_EDEFAULT);
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
			case CSTPackage.DEF_CS__DEF_EXPRESSION_CS :
				return defExpressionCS != null;
			case CSTPackage.DEF_CS__STATIC :
				return ((eFlags & STATIC_EFLAG) != 0) != STATIC_EDEFAULT;
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
		result.append(" (static: "); //$NON-NLS-1$
		result.append((eFlags & STATIC_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} //DefCSImpl
