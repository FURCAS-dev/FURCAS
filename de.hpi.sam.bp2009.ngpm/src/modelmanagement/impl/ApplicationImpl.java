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
	 * The cached value of the '{@link #getDeploymentUnits() <em>Deployment Units</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeploymentUnits()
	 * @generated
	 * @ordered
	 */
	protected DeploymentUnit deploymentUnits;

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
	public DeploymentUnit getDeploymentUnits() {
		return deploymentUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeploymentUnits(DeploymentUnit newDeploymentUnits, NotificationChain msgs) {
		DeploymentUnit oldDeploymentUnits = deploymentUnits;
		deploymentUnits = newDeploymentUnits;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS, oldDeploymentUnits, newDeploymentUnits);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeploymentUnits(DeploymentUnit newDeploymentUnits) {
		if (newDeploymentUnits != deploymentUnits) {
			NotificationChain msgs = null;
			if (deploymentUnits != null)
				msgs = ((InternalEObject)deploymentUnits).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS, null, msgs);
			if (newDeploymentUnits != null)
				msgs = ((InternalEObject)newDeploymentUnits).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS, null, msgs);
			msgs = basicSetDeploymentUnits(newDeploymentUnits, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelmanagementPackage.APPLICATION__DEPLOYMENT_UNITS, newDeploymentUnits, newDeploymentUnits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IntegrationScenario> getIntegrationScenarios() {
		if (integrationScenarios == null) {
			integrationScenarios = new EObjectContainmentEList<IntegrationScenario>(IntegrationScenario.class, this, ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS);
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
				return basicSetDeploymentUnits(null, msgs);
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
				setDeploymentUnits((DeploymentUnit)newValue);
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
				setDeploymentUnits((DeploymentUnit)null);
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
				return deploymentUnits != null;
			case ModelmanagementPackage.APPLICATION__INTEGRATION_SCENARIOS:
				return integrationScenarios != null && !integrationScenarios.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplicationImpl
