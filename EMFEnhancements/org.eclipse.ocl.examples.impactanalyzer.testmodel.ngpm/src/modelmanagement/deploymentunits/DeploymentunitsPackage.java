/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.deploymentunits;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Specifies constraints regarding the deployability of a solution. Which parts need to be codeployed, what can be distributed.
 * 
 * Align with PPMS "Deployment Package"
 * <!-- end-model-doc -->
 * @see modelmanagement.deploymentunits.DeploymentunitsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface DeploymentunitsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "deploymentunits";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///modelmanagement/deploymentunits.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "modelmanagement.deploymentunits";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	DeploymentunitsPackage eINSTANCE = modelmanagement.deploymentunits.impl.DeploymentunitsPackageImpl.init();

	/**
     * The meta object id for the '{@link modelmanagement.deploymentunits.impl.DeploymentUnitImpl <em>Deployment Unit</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.deploymentunits.impl.DeploymentUnitImpl
     * @see modelmanagement.deploymentunits.impl.DeploymentunitsPackageImpl#getDeploymentUnit()
     * @generated
     */
	int DEPLOYMENT_UNIT = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEPLOYMENT_UNIT__NAME = ModelmanagementPackage.PACKAGE_OWNER__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEPLOYMENT_UNIT__DESCRIPTION = ModelmanagementPackage.PACKAGE_OWNER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEPLOYMENT_UNIT__OWNED_PACKAGES = ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES;

	/**
     * The feature id for the '<em><b>Pcs Inside Company</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Deployment Unit</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DEPLOYMENT_UNIT_FEATURE_COUNT = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link modelmanagement.deploymentunits.DeploymentUnit <em>Deployment Unit</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Deployment Unit</em>'.
     * @see modelmanagement.deploymentunits.DeploymentUnit
     * @generated
     */
	EClass getDeploymentUnit();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.deploymentunits.DeploymentUnit#getPcsInsideCompany <em>Pcs Inside Company</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Pcs Inside Company</em>'.
     * @see modelmanagement.deploymentunits.DeploymentUnit#getPcsInsideCompany()
     * @see #getDeploymentUnit()
     * @generated
     */
	EReference getDeploymentUnit_PcsInsideCompany();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	DeploymentunitsFactory getDeploymentunitsFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link modelmanagement.deploymentunits.impl.DeploymentUnitImpl <em>Deployment Unit</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.deploymentunits.impl.DeploymentUnitImpl
         * @see modelmanagement.deploymentunits.impl.DeploymentunitsPackageImpl#getDeploymentUnit()
         * @generated
         */
		EClass DEPLOYMENT_UNIT = eINSTANCE.getDeploymentUnit();

		/**
         * The meta object literal for the '<em><b>Pcs Inside Company</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DEPLOYMENT_UNIT__PCS_INSIDE_COMPANY = eINSTANCE.getDeploymentUnit_PcsInsideCompany();

	}

} //DeploymentunitsPackage
