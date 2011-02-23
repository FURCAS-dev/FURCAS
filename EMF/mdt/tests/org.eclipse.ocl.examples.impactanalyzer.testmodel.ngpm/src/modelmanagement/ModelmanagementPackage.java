/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelmanagementPackage.java,v 1.1 2011/02/07 17:16:09 auhl Exp $
 */
package modelmanagement;

import org.eclipse.emf.ecore.EAttribute;
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
 * Packaging, namespaces, visibility rules, dependency management, specifying facades / public parts, SCs, DCs, SCVs, ...
 * <!-- end-model-doc -->
 * @see modelmanagement.ModelmanagementFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ModelmanagementPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "modelmanagement";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/modelmanagement.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "modelmanagement";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ModelmanagementPackage eINSTANCE = modelmanagement.impl.ModelmanagementPackageImpl.init();

	/**
     * The meta object id for the '{@link modelmanagement.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.impl.NamedElementImpl
     * @see modelmanagement.impl.ModelmanagementPackageImpl#getNamedElement()
     * @generated
     */
	int NAMED_ELEMENT = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT__NAME = 0;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT__DESCRIPTION = 1;

	/**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_ELEMENT_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link modelmanagement.impl.PackageOwnerImpl <em>Package Owner</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.impl.PackageOwnerImpl
     * @see modelmanagement.impl.ModelmanagementPackageImpl#getPackageOwner()
     * @generated
     */
	int PACKAGE_OWNER = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_OWNER__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_OWNER__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_OWNER__OWNED_PACKAGES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Package Owner</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_OWNER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link modelmanagement.impl.PackageImpl <em>Package</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.impl.PackageImpl
     * @see modelmanagement.impl.ModelmanagementPackageImpl#getPackage()
     * @generated
     */
	int PACKAGE = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__NAME = PACKAGE_OWNER__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__DESCRIPTION = PACKAGE_OWNER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__OWNED_PACKAGES = PACKAGE_OWNER__OWNED_PACKAGES;

	/**
     * The feature id for the '<em><b>Associations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__ASSOCIATIONS = PACKAGE_OWNER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Classes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__CLASSES = PACKAGE_OWNER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Parameterized Classes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__PARAMETERIZED_CLASSES = PACKAGE_OWNER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__OWNER = PACKAGE_OWNER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Configurability</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__CONFIGURABILITY = PACKAGE_OWNER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE__BINDINGS = PACKAGE_OWNER_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Package</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PACKAGE_FEATURE_COUNT = PACKAGE_OWNER_FEATURE_COUNT + 6;

	/**
     * The meta object id for the '{@link modelmanagement.impl.ApplicationImpl <em>Application</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.impl.ApplicationImpl
     * @see modelmanagement.impl.ModelmanagementPackageImpl#getApplication()
     * @generated
     */
	int APPLICATION = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int APPLICATION__NAME = NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int APPLICATION__DESCRIPTION = NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Deployment Units</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int APPLICATION__DEPLOYMENT_UNITS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Integration Scenarios</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int APPLICATION__INTEGRATION_SCENARIOS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Application</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int APPLICATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link modelmanagement.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.impl.ModuleImpl
     * @see modelmanagement.impl.ModelmanagementPackageImpl#getModule()
     * @generated
     */
	int MODULE = 4;

	/**
     * The number of structural features of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MODULE_FEATURE_COUNT = 0;


	/**
     * Returns the meta object for class '{@link modelmanagement.Package <em>Package</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Package</em>'.
     * @see modelmanagement.Package
     * @generated
     */
	EClass getPackage();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Package#getAssociations <em>Associations</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Associations</em>'.
     * @see modelmanagement.Package#getAssociations()
     * @see #getPackage()
     * @generated
     */
	EReference getPackage_Associations();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Package#getClasses <em>Classes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Classes</em>'.
     * @see modelmanagement.Package#getClasses()
     * @see #getPackage()
     * @generated
     */
	EReference getPackage_Classes();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Package#getParameterizedClasses <em>Parameterized Classes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameterized Classes</em>'.
     * @see modelmanagement.Package#getParameterizedClasses()
     * @see #getPackage()
     * @generated
     */
	EReference getPackage_ParameterizedClasses();

	/**
     * Returns the meta object for the container reference '{@link modelmanagement.Package#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner</em>'.
     * @see modelmanagement.Package#getOwner()
     * @see #getPackage()
     * @generated
     */
	EReference getPackage_Owner();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Package#getConfigurability <em>Configurability</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Configurability</em>'.
     * @see modelmanagement.Package#getConfigurability()
     * @see #getPackage()
     * @generated
     */
	EReference getPackage_Configurability();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Package#getBindings <em>Bindings</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Bindings</em>'.
     * @see modelmanagement.Package#getBindings()
     * @see #getPackage()
     * @generated
     */
	EReference getPackage_Bindings();

	/**
     * Returns the meta object for class '{@link modelmanagement.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see modelmanagement.NamedElement
     * @generated
     */
	EClass getNamedElement();

	/**
     * Returns the meta object for the attribute '{@link modelmanagement.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see modelmanagement.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
	EAttribute getNamedElement_Name();

	/**
     * Returns the meta object for the containment reference '{@link modelmanagement.NamedElement#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Description</em>'.
     * @see modelmanagement.NamedElement#getDescription()
     * @see #getNamedElement()
     * @generated
     */
	EReference getNamedElement_Description();

	/**
     * Returns the meta object for class '{@link modelmanagement.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Application</em>'.
     * @see modelmanagement.Application
     * @generated
     */
	EClass getApplication();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Application#getDeploymentUnits <em>Deployment Units</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Deployment Units</em>'.
     * @see modelmanagement.Application#getDeploymentUnits()
     * @see #getApplication()
     * @generated
     */
	EReference getApplication_DeploymentUnits();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.Application#getIntegrationScenarios <em>Integration Scenarios</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Integration Scenarios</em>'.
     * @see modelmanagement.Application#getIntegrationScenarios()
     * @see #getApplication()
     * @generated
     */
	EReference getApplication_IntegrationScenarios();

	/**
     * Returns the meta object for class '{@link modelmanagement.PackageOwner <em>Package Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Package Owner</em>'.
     * @see modelmanagement.PackageOwner
     * @generated
     */
	EClass getPackageOwner();

	/**
     * Returns the meta object for the containment reference list '{@link modelmanagement.PackageOwner#getOwnedPackages <em>Owned Packages</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
     * @see modelmanagement.PackageOwner#getOwnedPackages()
     * @see #getPackageOwner()
     * @generated
     */
	EReference getPackageOwner_OwnedPackages();

	/**
     * Returns the meta object for class '{@link modelmanagement.Module <em>Module</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module</em>'.
     * @see modelmanagement.Module
     * @generated
     */
	EClass getModule();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ModelmanagementFactory getModelmanagementFactory();

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
         * The meta object literal for the '{@link modelmanagement.impl.PackageImpl <em>Package</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.impl.PackageImpl
         * @see modelmanagement.impl.ModelmanagementPackageImpl#getPackage()
         * @generated
         */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
         * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE__ASSOCIATIONS = eINSTANCE.getPackage_Associations();

		/**
         * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE__CLASSES = eINSTANCE.getPackage_Classes();

		/**
         * The meta object literal for the '<em><b>Parameterized Classes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE__PARAMETERIZED_CLASSES = eINSTANCE.getPackage_ParameterizedClasses();

		/**
         * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE__OWNER = eINSTANCE.getPackage_Owner();

		/**
         * The meta object literal for the '<em><b>Configurability</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE__CONFIGURABILITY = eINSTANCE.getPackage_Configurability();

		/**
         * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE__BINDINGS = eINSTANCE.getPackage_Bindings();

		/**
         * The meta object literal for the '{@link modelmanagement.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.impl.NamedElementImpl
         * @see modelmanagement.impl.ModelmanagementPackageImpl#getNamedElement()
         * @generated
         */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
         * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAMED_ELEMENT__DESCRIPTION = eINSTANCE.getNamedElement_Description();

		/**
         * The meta object literal for the '{@link modelmanagement.impl.ApplicationImpl <em>Application</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.impl.ApplicationImpl
         * @see modelmanagement.impl.ModelmanagementPackageImpl#getApplication()
         * @generated
         */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
         * The meta object literal for the '<em><b>Deployment Units</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference APPLICATION__DEPLOYMENT_UNITS = eINSTANCE.getApplication_DeploymentUnits();

		/**
         * The meta object literal for the '<em><b>Integration Scenarios</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference APPLICATION__INTEGRATION_SCENARIOS = eINSTANCE.getApplication_IntegrationScenarios();

		/**
         * The meta object literal for the '{@link modelmanagement.impl.PackageOwnerImpl <em>Package Owner</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.impl.PackageOwnerImpl
         * @see modelmanagement.impl.ModelmanagementPackageImpl#getPackageOwner()
         * @generated
         */
		EClass PACKAGE_OWNER = eINSTANCE.getPackageOwner();

		/**
         * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PACKAGE_OWNER__OWNED_PACKAGES = eINSTANCE.getPackageOwner_OwnedPackages();

		/**
         * The meta object literal for the '{@link modelmanagement.impl.ModuleImpl <em>Module</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.impl.ModuleImpl
         * @see modelmanagement.impl.ModelmanagementPackageImpl#getModule()
         * @generated
         */
		EClass MODULE = eINSTANCE.getModule();

	}

} //ModelmanagementPackage
