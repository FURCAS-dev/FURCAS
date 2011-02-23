/**
 * <copyright>
 * </copyright>
 *
 * $Id: IntegrationScenarioImpl.java,v 1.1 2011/02/07 17:21:38 auhl Exp $
 */
package integration.processintegration.impl;

import integration.processintegration.IntegrationScenario;
import integration.processintegration.ProcessComponentInteraction;
import integration.processintegration.ProcessintegrationPackage;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integration Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link integration.processintegration.impl.IntegrationScenarioImpl#getInteractions <em>Interactions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegrationScenarioImpl extends NamedElementImpl implements IntegrationScenario {
	/**
     * The cached value of the '{@link #getInteractions() <em>Interactions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInteractions()
     * @generated
     * @ordered
     */
	protected EList<ProcessComponentInteraction> interactions;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected IntegrationScenarioImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ProcessintegrationPackage.Literals.INTEGRATION_SCENARIO;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ProcessComponentInteraction> getInteractions() {
        if (interactions == null) {
            interactions = new EObjectContainmentWithInverseEList.Resolving<ProcessComponentInteraction>(ProcessComponentInteraction.class, this, ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS, ProcessintegrationPackage.PROCESS_COMPONENT_INTERACTION__USES);
        }
        return interactions;
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInteractions()).basicAdd(otherEnd, msgs);
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS:
                return ((InternalEList<?>)getInteractions()).basicRemove(otherEnd, msgs);
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS:
                return getInteractions();
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS:
                getInteractions().clear();
                getInteractions().addAll((Collection<? extends ProcessComponentInteraction>)newValue);
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS:
                getInteractions().clear();
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
            case ProcessintegrationPackage.INTEGRATION_SCENARIO__INTERACTIONS:
                return interactions != null && !interactions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //IntegrationScenarioImpl
