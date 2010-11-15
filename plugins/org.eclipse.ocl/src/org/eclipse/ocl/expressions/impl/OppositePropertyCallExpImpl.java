/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.expressions.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.operations.OppositePropertyCallExpOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * @since 3.1
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.OppositePropertyCallExpImpl#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OppositePropertyCallExpImpl<C, P>
		extends NavigationCallExpImpl<C, P>
		implements OppositePropertyCallExp<C, P> {

	/**
	 * The cached value of the '{@link #getReferredOppositeProperty() <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOppositeProperty()
	 * @generated
	 * @ordered
	 */
	protected P referredOppositeProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OppositePropertyCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public P getReferredOppositeProperty() {
		if (referredOppositeProperty != null
			&& ((EObject) referredOppositeProperty).eIsProxy()) {
			InternalEObject oldReferredOppositeProperty = (InternalEObject) referredOppositeProperty;
			referredOppositeProperty = (P) eResolveProxy(oldReferredOppositeProperty);
			if (referredOppositeProperty != oldReferredOppositeProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
						this,
						Notification.RESOLVE,
						ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY,
						oldReferredOppositeProperty, referredOppositeProperty));
			}
		}
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public P basicGetReferredOppositeProperty() {
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOppositeProperty(P newReferredOppositeProperty) {
		P oldReferredOppositeProperty = referredOppositeProperty;
		referredOppositeProperty = newReferredOppositeProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
				this,
				Notification.SET,
				ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY,
				oldReferredOppositeProperty, referredOppositeProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkPropertyType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return OppositePropertyCallExpOperations.checkPropertyType(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				if (resolve)
					return getReferredOppositeProperty();
				return basicGetReferredOppositeProperty();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				setReferredOppositeProperty((P) newValue);
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
			case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				setReferredOppositeProperty((P) null);
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
			case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				return referredOppositeProperty != null;
		}
		return super.eIsSet(featureID);
	}

} //OppositePropertyCallExpImpl
