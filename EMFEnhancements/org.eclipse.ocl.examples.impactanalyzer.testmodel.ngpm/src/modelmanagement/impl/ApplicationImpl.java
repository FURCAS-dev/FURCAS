/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.impl;

import integration.processintegration.IntegrationScenario;

import java.util.Collection;

import modelmanagement.Application;
import modelmanagement.ModelmanagementPackage;

import modelmanagement.deploymentunits.DeploymentUnit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelmanagement.impl.ApplicationImpl#getDeploymentUnits <em>Deployment Units</em>}</li>
 *   <li>{@link modelmanagement.impl.ApplicationImpl#getIntegrationScenarios <em>Integration Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationImpl extends NamedElementImpl implements Application {
	/**
     * The cached value of the '{@link #getDeploymentUnits() <em>Deployment Units</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDeploymentUnits()
     * @generated
     * @ordered
     */
	protected EList<DeploymentUnit> deploymentUnits;

	/**
     * The cached value of the '{@link #getIntegrationScenarios() <em>Integration Scenarios</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIntegrationScenarios()
     * @generated
     * @ordered
     */
	protected EList<IntegrationScenario> integrationScenarios;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ApplicationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ModelmanagementPackage.Literals.APPLICATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<DeploymentUnit> getDeploymentUnits() {
        if (deploymentUnits == null) {
            deploymentUnits = new EObjectContainmentEList.Resolving<DeploymentUnit>(DeploymentUnit.class, this, ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS);
        }
        return deploymentUnits;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<IntegrationScenario> getIntegrationScenarios() {
        if (integrationScenarios == null) {
            integrationScenarios = new EObjectContainmentEList.Resolving<IntegrationScenario>(IntegrationScenario.class, this, ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS);
        }
        return integrationScenarios;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS:
                return ((InternalEList<?>)getDeploymentUnits()).basicRemove(otherEnd, msgs);
            case ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS:
                return ((InternalEList<?>)getIntegrationScenarios()).basicRemove(otherEnd, msgs);
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
            case ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS:
                return getDeploymentUnits();
            case ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS:
                return getIntegrationScenarios();
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
            case ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS:
                getDeploymentUnits().clear();
                getDeploymentUnits().addAll((Collection<? extends DeploymentUnit>)newValue);
                return;
            case ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS:
                getIntegrationScenarios().clear();
                getIntegrationScenarios().addAll((Collection<? extends IntegrationScenario>)newValue);
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
            case ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS:
                getDeploymentUnits().clear();
                return;
            case ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS:
                getIntegrationScenarios().clear();
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
            case ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS:
                return deploymentUnits != null && !deploymentUnits.isEmpty();
            case ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS:
                return integrationScenarios != null && !integrationScenarios.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ApplicationImpl
