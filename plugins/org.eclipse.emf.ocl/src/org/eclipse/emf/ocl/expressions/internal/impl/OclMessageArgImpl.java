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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OclMessageArg;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Message Arg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclMessageArgImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.OclMessageArgImpl#getUnspecified <em>Unspecified</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclMessageArgImpl extends ENamedElementImpl implements OclMessageArg {
	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression expression = null;

	/**
	 * The cached value of the '{@link #getUnspecified() <em>Unspecified</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnspecified()
	 * @generated
	 * @ordered
	 */
	protected UnspecifiedValueExp unspecified = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclMessageArgImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getOclMessageArg();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getExpression() {
		if (expression != null && expression.eIsProxy()) {
			OclExpression oldExpression = expression;
			expression = (OclExpression)eResolveProxy((InternalEObject)expression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(OclExpression newExpression) {
		OclExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnspecifiedValueExp getUnspecified() {
		if (unspecified != null && unspecified.eIsProxy()) {
			UnspecifiedValueExp oldUnspecified = unspecified;
			unspecified = (UnspecifiedValueExp)eResolveProxy((InternalEObject)unspecified);
			if (unspecified != oldUnspecified) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, oldUnspecified, unspecified));
			}
		}
		return unspecified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnspecifiedValueExp basicGetUnspecified() {
		return unspecified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnspecified(UnspecifiedValueExp newUnspecified) {
		UnspecifiedValueExp oldUnspecified = unspecified;
		unspecified = newUnspecified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED, oldUnspecified, unspecified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.OCL_MESSAGE_ARG__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
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
				case ExpressionsPackage.OCL_MESSAGE_ARG__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
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
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.OCL_MESSAGE_ARG__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.OCL_MESSAGE_ARG__NAME:
				return getName();
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				if (resolve) return getUnspecified();
				return basicGetUnspecified();
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				setExpression((OclExpression)newValue);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				setUnspecified((UnspecifiedValueExp)newValue);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				setExpression((OclExpression)null);
				return;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				setUnspecified((UnspecifiedValueExp)null);
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
			case ExpressionsPackage.OCL_MESSAGE_ARG__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.OCL_MESSAGE_ARG__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.OCL_MESSAGE_ARG__EXPRESSION:
				return expression != null;
			case ExpressionsPackage.OCL_MESSAGE_ARG__UNSPECIFIED:
				return unspecified != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //OclMessageArgImpl
