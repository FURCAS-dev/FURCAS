/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessArea;
import configuration.businessconfiguration.BusinessPackage;
import configuration.businessconfiguration.BusinessconfigurationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.BusinessAreaImpl#getBusinessPackage <em>Business Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessAreaImpl extends ConfigurationElementImpl implements BusinessArea {
	/**
     * The cached value of the '{@link #getBusinessPackage() <em>Business Package</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBusinessPackage()
     * @generated
     * @ordered
     */
	protected EList<BusinessPackage> businessPackage;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusinessAreaImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.BUSINESS_AREA;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<BusinessPackage> getBusinessPackage() {
        if (businessPackage == null) {
            businessPackage = new EObjectContainmentEList.Resolving<BusinessPackage>(BusinessPackage.class, this, BusinessconfigurationPackage.BUSINESS_AREA__BUSINESS_PACKAGE);
        }
        return businessPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.BUSINESS_AREA__BUSINESS_PACKAGE:
                return ((InternalEList<?>)getBusinessPackage()).basicRemove(otherEnd, msgs);
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
            case BusinessconfigurationPackage.BUSINESS_AREA__BUSINESS_PACKAGE:
                return getBusinessPackage();
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
            case BusinessconfigurationPackage.BUSINESS_AREA__BUSINESS_PACKAGE:
                getBusinessPackage().clear();
                getBusinessPackage().addAll((Collection<? extends BusinessPackage>)newValue);
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
            case BusinessconfigurationPackage.BUSINESS_AREA__BUSINESS_PACKAGE:
                getBusinessPackage().clear();
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
            case BusinessconfigurationPackage.BUSINESS_AREA__BUSINESS_PACKAGE:
                return businessPackage != null && !businessPackage.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BusinessAreaImpl
