/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement;

import integration.processintegration.IntegrationScenario;

import modelmanagement.deploymentunits.DeploymentUnit;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An application, such as "Business ByDesign"
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelmanagement.Application#getDeploymentUnits <em>Deployment Units</em>}</li>
 *   <li>{@link modelmanagement.Application#getIntegrationScenarios <em>Integration Scenarios</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelmanagement.ModelmanagementPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Deployment Units</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment Units</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment Units</em>' containment reference.
	 * @see #setDeploymentUnits(DeploymentUnit)
	 * @see modelmanagement.ModelmanagementPackage#getApplication_DeploymentUnits()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	DeploymentUnit getDeploymentUnits();

	/**
	 * Sets the value of the '{@link modelmanagement.Application#getDeploymentUnits <em>Deployment Units</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment Units</em>' containment reference.
	 * @see #getDeploymentUnits()
	 * @generated
	 */
	void setDeploymentUnits(DeploymentUnit value);

	/**
	 * Returns the value of the '<em><b>Integration Scenarios</b></em>' containment reference list.
	 * The list contents are of type {@link integration.processintegration.IntegrationScenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integration Scenarios</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integration Scenarios</em>' containment reference list.
	 * @see modelmanagement.ModelmanagementPackage#getApplication_IntegrationScenarios()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntegrationScenario> getIntegrationScenarios();

} // Application
