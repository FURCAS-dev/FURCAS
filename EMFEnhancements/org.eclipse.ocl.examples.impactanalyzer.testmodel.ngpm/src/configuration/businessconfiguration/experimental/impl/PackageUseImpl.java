/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.experimental.impl;

import configuration.businessconfiguration.experimental.ConfigurationSetting;
import configuration.businessconfiguration.experimental.ExperimentalPackage;
import configuration.businessconfiguration.experimental.PackageUse;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.experimental.impl.PackageUseImpl#getPackage_ <em>Package </em>}</li>
 *   <li>{@link configuration.businessconfiguration.experimental.impl.PackageUseImpl#getSetting <em>Setting</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageUseImpl extends EObjectImpl implements PackageUse {
	/**
     * The cached value of the '{@link #getPackage_() <em>Package </em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPackage_()
     * @generated
     * @ordered
     */
	protected modelmanagement.Package package_;

	/**
     * The cached value of the '{@link #getSetting() <em>Setting</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSetting()
     * @generated
     * @ordered
     */
	protected EList<ConfigurationSetting> setting;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PackageUseImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentalPackage.Literals.PACKAGE_USE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public modelmanagement.Package getPackage_() {
        if (package_ != null && package_.eIsProxy()) {
            InternalEObject oldPackage_ = (InternalEObject)package_;
            package_ = (modelmanagement.Package)eResolveProxy(oldPackage_);
            if (package_ != oldPackage_) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentalPackage.PACKAGE_USE__PACKAGE_, oldPackage_, package_));
            }
        }
        return package_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public modelmanagement.Package basicGetPackage_() {
        return package_;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPackage_(modelmanagement.Package newPackage_) {
        modelmanagement.Package oldPackage_ = package_;
        package_ = newPackage_;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentalPackage.PACKAGE_USE__PACKAGE_, oldPackage_, package_));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ConfigurationSetting> getSetting() {
        if (setting == null) {
            setting = new EObjectResolvingEList<ConfigurationSetting>(ConfigurationSetting.class, this, ExperimentalPackage.PACKAGE_USE__SETTING);
        }
        return setting;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExperimentalPackage.PACKAGE_USE__PACKAGE_:
                if (resolve) return getPackage_();
                return basicGetPackage_();
            case ExperimentalPackage.PACKAGE_USE__SETTING:
                return getSetting();
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
            case ExperimentalPackage.PACKAGE_USE__PACKAGE_:
                setPackage_((modelmanagement.Package)newValue);
                return;
            case ExperimentalPackage.PACKAGE_USE__SETTING:
                getSetting().clear();
                getSetting().addAll((Collection<? extends ConfigurationSetting>)newValue);
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
            case ExperimentalPackage.PACKAGE_USE__PACKAGE_:
                setPackage_((modelmanagement.Package)null);
                return;
            case ExperimentalPackage.PACKAGE_USE__SETTING:
                getSetting().clear();
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
            case ExperimentalPackage.PACKAGE_USE__PACKAGE_:
                return package_ != null;
            case ExperimentalPackage.PACKAGE_USE__SETTING:
                return setting != null && !setting.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //PackageUseImpl
