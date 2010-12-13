/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessPackage;
import configuration.businessconfiguration.BusinessTopic;
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
 * An implementation of the model object '<em><b>Business Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.BusinessPackageImpl#getBusinessTopic <em>Business Topic</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessPackageImpl extends ConfigurationElementImpl implements BusinessPackage {
	/**
     * The cached value of the '{@link #getBusinessTopic() <em>Business Topic</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBusinessTopic()
     * @generated
     * @ordered
     */
	protected EList<BusinessTopic> businessTopic;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusinessPackageImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.BUSINESS_PACKAGE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<BusinessTopic> getBusinessTopic() {
        if (businessTopic == null) {
            businessTopic = new EObjectContainmentEList.Resolving<BusinessTopic>(BusinessTopic.class, this, BusinessconfigurationPackage.BUSINESS_PACKAGE__BUSINESS_TOPIC);
        }
        return businessTopic;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.BUSINESS_PACKAGE__BUSINESS_TOPIC:
                return ((InternalEList<?>)getBusinessTopic()).basicRemove(otherEnd, msgs);
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
            case BusinessconfigurationPackage.BUSINESS_PACKAGE__BUSINESS_TOPIC:
                return getBusinessTopic();
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
            case BusinessconfigurationPackage.BUSINESS_PACKAGE__BUSINESS_TOPIC:
                getBusinessTopic().clear();
                getBusinessTopic().addAll((Collection<? extends BusinessTopic>)newValue);
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
            case BusinessconfigurationPackage.BUSINESS_PACKAGE__BUSINESS_TOPIC:
                getBusinessTopic().clear();
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
            case BusinessconfigurationPackage.BUSINESS_PACKAGE__BUSINESS_TOPIC:
                return businessTopic != null && !businessTopic.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BusinessPackageImpl
