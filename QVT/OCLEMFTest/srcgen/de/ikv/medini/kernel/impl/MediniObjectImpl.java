/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.kernel.impl;

import de.ikv.medini.kernel.KernelPackage;
import de.ikv.medini.kernel.MediniObject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Medini Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.kernel.impl.MediniObjectImpl#getMediniIdentifier <em>Medini Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MediniObjectImpl extends EObjectImpl implements MediniObject {
	/**
	 * The default value of the '{@link #getMediniIdentifier() <em>Medini Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediniIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String MEDINI_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMediniIdentifier() <em>Medini Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMediniIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String mediniIdentifier = MEDINI_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MediniObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return KernelPackage.Literals.MEDINI_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMediniIdentifier() {
		return mediniIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediniIdentifier(String newMediniIdentifier) {
		String oldMediniIdentifier = mediniIdentifier;
		mediniIdentifier = newMediniIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER, oldMediniIdentifier, mediniIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER:
				return getMediniIdentifier();
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
			case KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER:
				setMediniIdentifier((String)newValue);
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
			case KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER:
				setMediniIdentifier(MEDINI_IDENTIFIER_EDEFAULT);
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
			case KernelPackage.MEDINI_OBJECT__MEDINI_IDENTIFIER:
				return MEDINI_IDENTIFIER_EDEFAULT == null ? mediniIdentifier != null : !MEDINI_IDENTIFIER_EDEFAULT.equals(mediniIdentifier);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mediniIdentifier: ");
		result.append(mediniIdentifier);
		result.append(')');
		return result.toString();
	}

} //MediniObjectImpl