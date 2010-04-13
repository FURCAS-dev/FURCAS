/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractBaseDescriptorImpl.java,v 1.3 2009/10/02 12:20:10 jkohnlein Exp $
 */
package org.eclipse.emf.index.ecore.emfindex.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfindex.BaseDescriptor;
import org.eclipse.emf.index.ecore.emfindex.EmfindexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Base Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.index.ecore.emfindex.impl.AbstractBaseDescriptorImpl#getUserData <em>User Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractBaseDescriptorImpl extends Container implements BaseDescriptor {
	/**
	 * The cached value of the '{@link #getUserData() <em>User Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserData()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> userData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractBaseDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfindexPackage.Literals.ABSTRACT_BASE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getUserData() {
		if (userData == null) {
			userData = new EcoreEMap.Unsettable<String,String>(EmfindexPackage.Literals.USER_DATA_ENTRY, UserDataEntryImpl.class, this, EmfindexPackage.ABSTRACT_BASE_DESCRIPTOR__USER_DATA);
		}
		return userData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserData() {
		if (userData != null) ((InternalEList.Unsettable<?>)userData).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserData() {
		return userData != null && ((InternalEList.Unsettable<?>)userData).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserData(String key) {
		return (userData != null) ? userData.get(key) : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserData(String key, String value) {
		getUserData().put(key, value);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfindexPackage.ABSTRACT_BASE_DESCRIPTOR__USER_DATA:
				return ((InternalEList<?>)getUserData()).basicRemove(otherEnd, msgs);
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
			case EmfindexPackage.ABSTRACT_BASE_DESCRIPTOR__USER_DATA:
				if (coreType) return getUserData();
				else return getUserData().map();
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
			case EmfindexPackage.ABSTRACT_BASE_DESCRIPTOR__USER_DATA:
				((EStructuralFeature.Setting)getUserData()).set(newValue);
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
			case EmfindexPackage.ABSTRACT_BASE_DESCRIPTOR__USER_DATA:
				unsetUserData();
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
			case EmfindexPackage.ABSTRACT_BASE_DESCRIPTOR__USER_DATA:
				return isSetUserData();
		}
		return super.eIsSet(featureID);
	}

} //AbstractBaseDescriptorImpl
