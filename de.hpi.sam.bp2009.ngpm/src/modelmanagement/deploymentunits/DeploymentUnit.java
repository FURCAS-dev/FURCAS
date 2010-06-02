/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.deploymentunits;

import modelmanagement.NamedElement;
import modelmanagement.PackageOwner;

import modelmanagement.processcomponents.ProcessComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelmanagement.deploymentunits.DeploymentUnit#getPcsInsideCompany <em>Pcs Inside Company</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelmanagement.deploymentunits.DeploymentunitsPackage#getDeploymentUnit()
 * @model
 * @generated
 */
public interface DeploymentUnit extends PackageOwner, NamedElement {
	/**
	 * Returns the value of the '<em><b>Pcs Inside Company</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pcs Inside Company</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pcs Inside Company</em>' containment reference.
	 * @see #setPcsInsideCompany(ProcessComponent)
	 * @see modelmanagement.deploymentunits.DeploymentunitsPackage#getDeploymentUnit_PcsInsideCompany()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ProcessComponent getPcsInsideCompany();

	/**
	 * Sets the value of the '{@link modelmanagement.deploymentunits.DeploymentUnit#getPcsInsideCompany <em>Pcs Inside Company</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pcs Inside Company</em>' containment reference.
	 * @see #getPcsInsideCompany()
	 * @generated
	 */
	void setPcsInsideCompany(ProcessComponent value);

} // DeploymentUnit
