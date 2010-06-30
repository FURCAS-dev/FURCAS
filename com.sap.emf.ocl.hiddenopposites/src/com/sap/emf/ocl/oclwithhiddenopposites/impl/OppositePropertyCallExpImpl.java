/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.impl;

import com.sap.emf.ocl.oclwithhiddenopposites.OclwithhiddenoppositesPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.OppositePropertyCallExp;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.ecore.impl.NavigationCallExpImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.oclwithhiddenopposites.impl.OppositePropertyCallExpImpl#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OppositePropertyCallExpImpl extends NavigationCallExpImpl implements OppositePropertyCallExp {
	/**
	 * The cached value of the '{@link #getReferredOppositeProperty() <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOppositeProperty()
	 * @generated
	 * @ordered
	 */
	protected EReference referredOppositeProperty;

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
		return OclwithhiddenoppositesPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferredOppositeProperty() {
		if (referredOppositeProperty != null && referredOppositeProperty.eIsProxy()) {
			InternalEObject oldReferredOppositeProperty = (InternalEObject)referredOppositeProperty;
			referredOppositeProperty = (EReference)eResolveProxy(oldReferredOppositeProperty);
			if (referredOppositeProperty != oldReferredOppositeProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY, oldReferredOppositeProperty, referredOppositeProperty));
			}
		}
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReferredOppositeProperty() {
		return referredOppositeProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredOppositeProperty(EReference newReferredOppositeProperty) {
		EReference oldReferredOppositeProperty = referredOppositeProperty;
		referredOppositeProperty = newReferredOppositeProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY, oldReferredOppositeProperty, referredOppositeProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
				if (resolve) return getReferredOppositeProperty();
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
			case OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
				setReferredOppositeProperty((EReference)newValue);
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
			case OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
				setReferredOppositeProperty((EReference)null);
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
			case OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY:
				return referredOppositeProperty != null;
		}
		return super.eIsSet(featureID);
	}

} //OppositePropertyCallExpImpl
