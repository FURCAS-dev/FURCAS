/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigurationElementImpl.java,v 1.1 2011/02/07 17:16:10 auhl Exp $
 */
package configuration.businessconfiguration.impl;

import configuration.businessconfiguration.BusinessconfigurationPackage;
import configuration.businessconfiguration.ConfigurationElement;
import configuration.businessconfiguration.ScopingContext;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.businessconfiguration.impl.ConfigurationElementImpl#getApplicableInContext <em>Applicable In Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationElementImpl extends EObjectImpl implements ConfigurationElement {
	/**
     * The cached value of the '{@link #getApplicableInContext() <em>Applicable In Context</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getApplicableInContext()
     * @generated
     * @ordered
     */
	protected EList<ScopingContext> applicableInContext;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ConfigurationElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BusinessconfigurationPackage.Literals.CONFIGURATION_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ScopingContext> getApplicableInContext() {
        if (applicableInContext == null) {
            applicableInContext = new EObjectResolvingEList<ScopingContext>(ScopingContext.class, this, BusinessconfigurationPackage.CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT);
        }
        return applicableInContext;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case BusinessconfigurationPackage.CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT:
                return getApplicableInContext();
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
            case BusinessconfigurationPackage.CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT:
                getApplicableInContext().clear();
                getApplicableInContext().addAll((Collection<? extends ScopingContext>)newValue);
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
            case BusinessconfigurationPackage.CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT:
                getApplicableInContext().clear();
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
            case BusinessconfigurationPackage.CONFIGURATION_ELEMENT__APPLICABLE_IN_CONTEXT:
                return applicableInContext != null && !applicableInContext.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ConfigurationElementImpl
