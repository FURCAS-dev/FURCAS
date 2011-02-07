/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContextualElementImpl.java,v 1.1 2011/02/07 16:48:25 auhl Exp $
 */
package configuration.context_drivers.impl;

import configuration.context_drivers.ContexConfiguration;
import configuration.context_drivers.Context_driversPackage;
import configuration.context_drivers.ContextualElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contextual Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configuration.context_drivers.impl.ContextualElementImpl#getContextualElementConfiguration <em>Contextual Element Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextualElementImpl extends EObjectImpl implements ContextualElement {
	/**
     * The cached value of the '{@link #getContextualElementConfiguration() <em>Contextual Element Configuration</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getContextualElementConfiguration()
     * @generated
     * @ordered
     */
	protected EList<ContexConfiguration> contextualElementConfiguration;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ContextualElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Context_driversPackage.Literals.CONTEXTUAL_ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContexConfiguration> getContextualElementConfiguration() {
        if (contextualElementConfiguration == null) {
            contextualElementConfiguration = new EObjectContainmentWithInverseEList.Resolving<ContexConfiguration>(ContexConfiguration.class, this, Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION, Context_driversPackage.CONTEX_CONFIGURATION__CONFIGURED_ELEMENT);
        }
        return contextualElementConfiguration;
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
            case Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getContextualElementConfiguration()).basicAdd(otherEnd, msgs);
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
            case Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION:
                return ((InternalEList<?>)getContextualElementConfiguration()).basicRemove(otherEnd, msgs);
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
            case Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION:
                return getContextualElementConfiguration();
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
            case Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION:
                getContextualElementConfiguration().clear();
                getContextualElementConfiguration().addAll((Collection<? extends ContexConfiguration>)newValue);
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
            case Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION:
                getContextualElementConfiguration().clear();
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
            case Context_driversPackage.CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONFIGURATION:
                return contextualElementConfiguration != null && !contextualElementConfiguration.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ContextualElementImpl
