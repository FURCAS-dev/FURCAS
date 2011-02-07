/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessTopicImpl.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessOption;
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
 * An implementation of the model object '<em><b>Business Topic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.BusinessTopicImpl#getBusinessOption <em>Business Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessTopicImpl extends ConfigurationElementImpl implements BusinessTopic {
	/**
     * The cached value of the '{@link #getBusinessOption() <em>Business Option</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBusinessOption()
     * @generated
     * @ordered
     */
	protected EList<BusinessOption> businessOption;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusinessTopicImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.BUSINESS_TOPIC;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<BusinessOption> getBusinessOption() {
        if (businessOption == null) {
            businessOption = new EObjectContainmentEList.Resolving<BusinessOption>(BusinessOption.class, this, BusinessconfigurationPackage.BUSINESS_TOPIC__BUSINESS_OPTION);
        }
        return businessOption;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.BUSINESS_TOPIC__BUSINESS_OPTION:
                return ((InternalEList<?>)getBusinessOption()).basicRemove(otherEnd, msgs);
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
            case BusinessconfigurationPackage.BUSINESS_TOPIC__BUSINESS_OPTION:
                return getBusinessOption();
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
            case BusinessconfigurationPackage.BUSINESS_TOPIC__BUSINESS_OPTION:
                getBusinessOption().clear();
                getBusinessOption().addAll((Collection<? extends BusinessOption>)newValue);
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
            case BusinessconfigurationPackage.BUSINESS_TOPIC__BUSINESS_OPTION:
                getBusinessOption().clear();
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
            case BusinessconfigurationPackage.BUSINESS_TOPIC__BUSINESS_OPTION:
                return businessOption != null && !businessOption.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BusinessTopicImpl
