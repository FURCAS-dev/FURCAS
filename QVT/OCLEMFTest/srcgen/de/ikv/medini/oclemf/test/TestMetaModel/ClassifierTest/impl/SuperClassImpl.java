/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.ClassifierTestPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.SuperClass;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl.SuperClassImpl#getSuperName <em>Super Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperClassImpl extends AbstractSuperClassImpl implements SuperClass {
	/**
	 * The default value of the '{@link #getSuperName() <em>Super Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperName()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSuperName() <em>Super Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperName()
	 * @generated
	 * @ordered
	 */
	protected String superName = SUPER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ClassifierTestPackage.Literals.SUPER_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperName() {
		return superName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperName(String newSuperName) {
		String oldSuperName = superName;
		superName = newSuperName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassifierTestPackage.SUPER_CLASS__SUPER_NAME, oldSuperName, superName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassifierTestPackage.SUPER_CLASS__SUPER_NAME:
				return getSuperName();
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
			case ClassifierTestPackage.SUPER_CLASS__SUPER_NAME:
				setSuperName((String)newValue);
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
			case ClassifierTestPackage.SUPER_CLASS__SUPER_NAME:
				setSuperName(SUPER_NAME_EDEFAULT);
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
			case ClassifierTestPackage.SUPER_CLASS__SUPER_NAME:
				return SUPER_NAME_EDEFAULT == null ? superName != null : !SUPER_NAME_EDEFAULT.equals(superName);
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
		result.append(" (SuperName: ");
		result.append(superName);
		result.append(')');
		return result.toString();
	}

} //SuperClassImpl