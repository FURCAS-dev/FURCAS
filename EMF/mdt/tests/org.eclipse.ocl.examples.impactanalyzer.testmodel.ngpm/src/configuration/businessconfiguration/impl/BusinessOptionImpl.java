/**
 * <copyright>
 * </copyright>
 *
 * $Id: BusinessOptionImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessOption;
import configuration.businessconfiguration.BusinessconfigurationPackage;
import configuration.businessconfiguration.ValueSet;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.BusinessOptionImpl#getValueSet <em>Value Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessOptionImpl extends ConfigurationElementImpl implements BusinessOption {
	/**
     * The cached value of the '{@link #getValueSet() <em>Value Set</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValueSet()
     * @generated
     * @ordered
     */
	protected EList<ValueSet> valueSet;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected BusinessOptionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.BUSINESS_OPTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ValueSet> getValueSet() {
        if (valueSet == null) {
            valueSet = new EObjectWithInverseResolvingEList<ValueSet>(ValueSet.class, this, BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET, BusinessconfigurationPackage.VALUE_SET__CONFIGURATION_BUSINESS_OPTION);
        }
        return valueSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getValueSet()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET:
                return ((InternalEList<?>)getValueSet()).basicRemove(otherEnd, msgs);
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
            case BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET:
                return getValueSet();
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
            case BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET:
                getValueSet().clear();
                getValueSet().addAll((Collection<? extends ValueSet>)newValue);
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
            case BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET:
                getValueSet().clear();
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
            case BusinessconfigurationPackage.BUSINESS_OPTION__VALUE_SET:
                return valueSet != null && !valueSet.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //BusinessOptionImpl
