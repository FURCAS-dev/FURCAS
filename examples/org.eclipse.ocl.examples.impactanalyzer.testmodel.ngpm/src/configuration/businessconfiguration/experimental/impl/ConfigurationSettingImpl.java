/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigurationSettingImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package configuration.businessconfiguration.experimental.impl;

import configuration.businessconfiguration.experimental.ConfigurationEntity;
import configuration.businessconfiguration.experimental.ConfigurationSetting;
import configuration.businessconfiguration.experimental.ExperimentalPackage;

import dataaccess.expressions.Expression;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Setting</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.experimental.impl.ConfigurationSettingImpl#getEntity <em>Entity</em>}</li>
 *   <li>{@link configuration.businessconfiguration.experimental.impl.ConfigurationSettingImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationSettingImpl extends EObjectImpl implements ConfigurationSetting {
	/**
     * The cached value of the '{@link #getEntity() <em>Entity</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEntity()
     * @generated
     * @ordered
     */
	protected ConfigurationEntity entity;

	/**
     * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected Expression value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConfigurationSettingImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentalPackage.Literals.CONFIGURATION_SETTING;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConfigurationEntity getEntity() {
        if (entity != null && entity.eIsProxy()) {
            InternalEObject oldEntity = (InternalEObject)entity;
            entity = (ConfigurationEntity)eResolveProxy(oldEntity);
            if (entity != oldEntity) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentalPackage.CONFIGURATION_SETTING__ENTITY, oldEntity, entity));
            }
        }
        return entity;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ConfigurationEntity basicGetEntity() {
        return entity;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEntity(ConfigurationEntity newEntity) {
        ConfigurationEntity oldEntity = entity;
        entity = newEntity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentalPackage.CONFIGURATION_SETTING__ENTITY, oldEntity, entity));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getValue() {
        if (value != null && value.eIsProxy()) {
            InternalEObject oldValue = (InternalEObject)value;
            value = (Expression)eResolveProxy(oldValue);
            if (value != oldValue) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentalPackage.CONFIGURATION_SETTING__VALUE, oldValue, value));
            }
        }
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression basicGetValue() {
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(Expression newValue) {
        Expression oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentalPackage.CONFIGURATION_SETTING__VALUE, oldValue, value));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentalPackage.CONFIGURATION_SETTING__ENTITY:
                if (resolve) return getEntity();
                return basicGetEntity();
            case ExperimentalPackage.CONFIGURATION_SETTING__VALUE:
                if (resolve) return getValue();
                return basicGetValue();
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
            case ExperimentalPackage.CONFIGURATION_SETTING__ENTITY:
                setEntity((ConfigurationEntity)newValue);
                return;
            case ExperimentalPackage.CONFIGURATION_SETTING__VALUE:
                setValue((Expression)newValue);
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
            case ExperimentalPackage.CONFIGURATION_SETTING__ENTITY:
                setEntity((ConfigurationEntity)null);
                return;
            case ExperimentalPackage.CONFIGURATION_SETTING__VALUE:
                setValue((Expression)null);
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
            case ExperimentalPackage.CONFIGURATION_SETTING__ENTITY:
                return entity != null;
            case ExperimentalPackage.CONFIGURATION_SETTING__VALUE:
                return value != null;
        }
        return super.eIsSet(featureID);
    }

} //ConfigurationSettingImpl
