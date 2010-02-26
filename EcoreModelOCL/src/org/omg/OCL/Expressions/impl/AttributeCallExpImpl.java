/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions.impl;

import com.sap.tc.moin.repository.mmi.Model.Attribute;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.OCL.Expressions.AttributeCallExp;
import org.omg.OCL.Expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.impl.AttributeCallExpImpl#getReferredAttribute <em>Referred Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeCallExpImpl extends ModelPropertyCallExpImpl implements AttributeCallExp {
	/**
	 * The cached value of the '{@link #getReferredAttribute() <em>Referred Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAttribute()
	 * @generated
	 * @ordered
	 */
	protected Attribute referredAttribute;

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
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.ATTRIBUTE_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getReferredAttribute() {
		if (referredAttribute != null && referredAttribute.eIsProxy()) {
			InternalEObject oldReferredAttribute = (InternalEObject)referredAttribute;
			referredAttribute = (Attribute)eResolveProxy(oldReferredAttribute);
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
	public Attribute basicGetReferredAttribute() {
		return referredAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAttribute(Attribute newReferredAttribute) {
		Attribute oldReferredAttribute = referredAttribute;
		referredAttribute = newReferredAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE, oldReferredAttribute, referredAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				setReferredAttribute((Attribute)newValue);
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
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				setReferredAttribute((Attribute)null);
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
			case ExpressionsPackage.ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE:
				return referredAttribute != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeCallExpImpl
