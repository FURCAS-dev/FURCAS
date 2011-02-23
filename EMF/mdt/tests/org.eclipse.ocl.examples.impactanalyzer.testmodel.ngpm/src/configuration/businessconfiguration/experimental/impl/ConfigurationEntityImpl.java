/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigurationEntityImpl.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package configuration.businessconfiguration.experimental.impl;

import configuration.businessconfiguration.ValueSet;

import configuration.businessconfiguration.experimental.ConfigurationEntity;
import configuration.businessconfiguration.experimental.ExperimentalPackage;

import data.classes.AssociationEnd;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.experimental.impl.ConfigurationEntityImpl#getPickList <em>Pick List</em>}</li>
 *   <li>{@link configuration.businessconfiguration.experimental.impl.ConfigurationEntityImpl#getConfigurableItem <em>Configurable Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationEntityImpl extends NamedElementImpl implements ConfigurationEntity {
	/**
     * The cached value of the '{@link #getPickList() <em>Pick List</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPickList()
     * @generated
     * @ordered
     */
	protected ValueSet pickList;

	/**
     * The cached value of the '{@link #getConfigurableItem() <em>Configurable Item</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConfigurableItem()
     * @generated
     * @ordered
     */
	protected AssociationEnd configurableItem;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConfigurationEntityImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentalPackage.Literals.CONFIGURATION_ENTITY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueSet getPickList() {
        if (pickList != null && pickList.eIsProxy()) {
            InternalEObject oldPickList = (InternalEObject)pickList;
            pickList = (ValueSet)eResolveProxy(oldPickList);
            if (pickList != oldPickList) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentalPackage.CONFIGURATION_ENTITY__PICK_LIST, oldPickList, pickList));
            }
        }
        return pickList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ValueSet basicGetPickList() {
        return pickList;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPickList(ValueSet newPickList) {
        ValueSet oldPickList = pickList;
        pickList = newPickList;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentalPackage.CONFIGURATION_ENTITY__PICK_LIST, oldPickList, pickList));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getConfigurableItem() {
        if (configurableItem != null && configurableItem.eIsProxy()) {
            InternalEObject oldConfigurableItem = (InternalEObject)configurableItem;
            configurableItem = (AssociationEnd)eResolveProxy(oldConfigurableItem);
            if (configurableItem != oldConfigurableItem) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentalPackage.CONFIGURATION_ENTITY__CONFIGURABLE_ITEM, oldConfigurableItem, configurableItem));
            }
        }
        return configurableItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd basicGetConfigurableItem() {
        return configurableItem;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setConfigurableItem(AssociationEnd newConfigurableItem) {
        AssociationEnd oldConfigurableItem = configurableItem;
        configurableItem = newConfigurableItem;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentalPackage.CONFIGURATION_ENTITY__CONFIGURABLE_ITEM, oldConfigurableItem, configurableItem));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentalPackage.CONFIGURATION_ENTITY__PICK_LIST:
                if (resolve) return getPickList();
                return basicGetPickList();
            case ExperimentalPackage.CONFIGURATION_ENTITY__CONFIGURABLE_ITEM:
                if (resolve) return getConfigurableItem();
                return basicGetConfigurableItem();
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
            case ExperimentalPackage.CONFIGURATION_ENTITY__PICK_LIST:
                setPickList((ValueSet)newValue);
                return;
            case ExperimentalPackage.CONFIGURATION_ENTITY__CONFIGURABLE_ITEM:
                setConfigurableItem((AssociationEnd)newValue);
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
            case ExperimentalPackage.CONFIGURATION_ENTITY__PICK_LIST:
                setPickList((ValueSet)null);
                return;
            case ExperimentalPackage.CONFIGURATION_ENTITY__CONFIGURABLE_ITEM:
                setConfigurableItem((AssociationEnd)null);
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
            case ExperimentalPackage.CONFIGURATION_ENTITY__PICK_LIST:
                return pickList != null;
            case ExperimentalPackage.CONFIGURATION_ENTITY__CONFIGURABLE_ITEM:
                return configurableItem != null;
        }
        return super.eIsSet(featureID);
    }

} //ConfigurationEntityImpl
