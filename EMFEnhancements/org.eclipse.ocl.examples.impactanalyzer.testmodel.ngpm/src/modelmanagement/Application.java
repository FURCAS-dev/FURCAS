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
     * Returns the value of the '<em><b>Deployment Units</b></em>' containment reference list.
     * The list contents are of type {@link modelmanagement.deploymentunits.DeploymentUnit}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deployment Units</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Deployment Units</em>' containment reference list.
     * @see modelmanagement.ModelmanagementPackage#getApplication_DeploymentUnits()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
	EList<DeploymentUnit> getDeploymentUnits();

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
     * @model containment="true" resolveProxies="true"
     * @generated
     */
	EList<IntegrationScenario> getIntegrationScenarios();

} // Application
