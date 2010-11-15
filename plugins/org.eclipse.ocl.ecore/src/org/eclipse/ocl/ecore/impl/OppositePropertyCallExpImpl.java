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
package org.eclipse.ocl.ecore.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.operations.OppositePropertyCallExpOperations;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.ocl.utilities.VisitorExtension;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * @since 3.1
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.OppositePropertyCallExpImpl#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OppositePropertyCallExpImpl
		extends NavigationCallExpImpl
		implements OppositePropertyCallExp {

	/**
	 * The cached value of the '{@link #getReferredOppositeProperty() <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOppositeProperty()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature referredOppositeProperty;

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
		return EcorePackage.Literals.OPPOSITE_PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getReferredOppositeProperty() {
		if (referredOppositeProperty != null
			&& ((EObject) referredOppositeProperty).eIsProxy()) {
			InternalEObject oldReferredOppositeProperty = (InternalEObject) referredOppositeProperty;
			referredOppositeProperty = (EStructuralFeature) eResolveProxy(oldReferredOppositeProperty);
			if (referredOppositeProperty != oldReferredOppositeProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
						this,
						Notification.RESOLVE,
						EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY,
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
	public EStructuralFeature basicGetReferredOppositeProperty() {
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOppositeProperty(
			EStructuralFeature newReferredOppositeProperty) {
		EStructuralFeature oldReferredOppositeProperty = referredOppositeProperty;
		referredOppositeProperty = newReferredOppositeProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
				this,
				Notification.SET,
				EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY,
				oldReferredOppositeProperty, referredOppositeProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean checkOppositePropertyType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return OppositePropertyCallExpOperations.checkOppositePropertyType(this, diagnostics,
			context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				setReferredOppositeProperty((EStructuralFeature) newValue);
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
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				setReferredOppositeProperty((EStructuralFeature) null);
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
			case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
				return referredOppositeProperty != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.expressions.OppositePropertyCallExp.class) {
			switch (derivedFeatureID) {
				case EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
					return ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == org.eclipse.ocl.expressions.OppositePropertyCallExp.class) {
			switch (baseFeatureID) {
				case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY :
					return EcorePackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if (v instanceof VisitorExtension<?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) {
			return ((VisitorExtension<T, EClassifier, ?, EStructuralFeature, ?, ?, ?, ?, ?, ?>) v)
				.visitOppositePropertyCallExp(this);
		} else {
			return null;
		}
	}
} //OppositePropertyCallExpImpl
