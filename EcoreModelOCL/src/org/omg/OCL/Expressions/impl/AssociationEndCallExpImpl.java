/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions.impl;

import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.omg.OCL.Expressions.AssociationEndCallExp;
import org.omg.OCL.Expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.impl.AssociationEndCallExpImpl#getReferredAssociationEnd <em>Referred Association End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndCallExpImpl extends NavigationCallExpImpl implements AssociationEndCallExp {
	/**
	 * The cached value of the '{@link #getReferredAssociationEnd() <em>Referred Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredAssociationEnd()
	 * @generated
	 * @ordered
	 */
	protected AssociationEnd referredAssociationEnd;

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
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.ASSOCIATION_END_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getReferredAssociationEnd() {
		if (referredAssociationEnd != null && referredAssociationEnd.eIsProxy()) {
			InternalEObject oldReferredAssociationEnd = (InternalEObject)referredAssociationEnd;
			referredAssociationEnd = (AssociationEnd)eResolveProxy(oldReferredAssociationEnd);
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
	public AssociationEnd basicGetReferredAssociationEnd() {
		return referredAssociationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredAssociationEnd(AssociationEnd newReferredAssociationEnd) {
		AssociationEnd oldReferredAssociationEnd = referredAssociationEnd;
		referredAssociationEnd = newReferredAssociationEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END, oldReferredAssociationEnd, referredAssociationEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				setReferredAssociationEnd((AssociationEnd)newValue);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				setReferredAssociationEnd((AssociationEnd)null);
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
			case ExpressionsPackage.ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END:
				return referredAssociationEnd != null;
		}
		return super.eIsSet(featureID);
	}

} //AssociationEndCallExpImpl
