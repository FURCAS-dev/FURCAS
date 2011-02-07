/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeploymentUnit.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package modelmanagement.deploymentunits;

import modelmanagement.NamedElement;
import modelmanagement.PackageOwner;

import modelmanagement.processcomponents.ProcessComponent;
import org.eclipse.emf.common.util.EList;

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
     * Returns the value of the '<em><b>Pcs Inside Company</b></em>' containment reference list.
     * The list contents are of type {@link modelmanagement.processcomponents.ProcessComponent}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pcs Inside Company</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pcs Inside Company</em>' containment reference list.
     * @see modelmanagement.deploymentunits.DeploymentunitsPackage#getDeploymentUnit_PcsInsideCompany()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
	EList<ProcessComponent> getPcsInsideCompany();

} // DeploymentUnit
