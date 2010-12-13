/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package modelmanagement.processcomponents;

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
 * The process components as defined by AP are an important structuring means into which BOs can be grouped.
 * <!-- end-model-doc -->
 * @see modelmanagement.processcomponents.ProcesscomponentsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ProcesscomponentsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "processcomponents";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///modelmanagement/processcomponents.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "modelmanagement.processcomponents";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ProcesscomponentsPackage eINSTANCE = modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl.init();

	/**
     * The meta object id for the '{@link modelmanagement.processcomponents.impl.ProcessComponentImpl <em>Process Component</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.processcomponents.impl.ProcessComponentImpl
     * @see modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl#getProcessComponent()
     * @generated
     */
	int PROCESS_COMPONENT = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__NAME = ModelmanagementPackage.PACKAGE_OWNER__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__DESCRIPTION = ModelmanagementPackage.PACKAGE_OWNER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__OWNED_PACKAGES = ModelmanagementPackage.PACKAGE_OWNER__OWNED_PACKAGES;

	/**
     * The feature id for the '<em><b>Provided Interfaces</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__PROVIDED_INTERFACES = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Event Producers</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__EVENT_PRODUCERS = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Initiated Interactions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__INITIATED_INTERACTIONS = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Interactions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT__INTERACTIONS = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Process Component</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_FEATURE_COUNT = ModelmanagementPackage.PACKAGE_OWNER_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link modelmanagement.processcomponents.impl.ProcessComponentInsideCompanyImpl <em>Process Component Inside Company</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.processcomponents.impl.ProcessComponentInsideCompanyImpl
     * @see modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl#getProcessComponentInsideCompany()
     * @generated
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__NAME = PROCESS_COMPONENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__OWNED_PACKAGES = PROCESS_COMPONENT__OWNED_PACKAGES;

	/**
     * The feature id for the '<em><b>Provided Interfaces</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__PROVIDED_INTERFACES = PROCESS_COMPONENT__PROVIDED_INTERFACES;

	/**
     * The feature id for the '<em><b>Event Producers</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__EVENT_PRODUCERS = PROCESS_COMPONENT__EVENT_PRODUCERS;

	/**
     * The feature id for the '<em><b>Initiated Interactions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__INITIATED_INTERACTIONS = PROCESS_COMPONENT__INITIATED_INTERACTIONS;

	/**
     * The feature id for the '<em><b>Interactions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY__INTERACTIONS = PROCESS_COMPONENT__INTERACTIONS;

	/**
     * The number of structural features of the '<em>Process Component Inside Company</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INSIDE_COMPANY_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link modelmanagement.processcomponents.impl.ProcessComponentOutsideCompanyImpl <em>Process Component Outside Company</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see modelmanagement.processcomponents.impl.ProcessComponentOutsideCompanyImpl
     * @see modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl#getProcessComponentOutsideCompany()
     * @generated
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__NAME = PROCESS_COMPONENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__DESCRIPTION = PROCESS_COMPONENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__OWNED_PACKAGES = PROCESS_COMPONENT__OWNED_PACKAGES;

	/**
     * The feature id for the '<em><b>Provided Interfaces</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__PROVIDED_INTERFACES = PROCESS_COMPONENT__PROVIDED_INTERFACES;

	/**
     * The feature id for the '<em><b>Event Producers</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__EVENT_PRODUCERS = PROCESS_COMPONENT__EVENT_PRODUCERS;

	/**
     * The feature id for the '<em><b>Initiated Interactions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__INITIATED_INTERACTIONS = PROCESS_COMPONENT__INITIATED_INTERACTIONS;

	/**
     * The feature id for the '<em><b>Interactions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY__INTERACTIONS = PROCESS_COMPONENT__INTERACTIONS;

	/**
     * The number of structural features of the '<em>Process Component Outside Company</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_OUTSIDE_COMPANY_FEATURE_COUNT = PROCESS_COMPONENT_FEATURE_COUNT + 0;


	/**
     * Returns the meta object for class '{@link modelmanagement.processcomponents.ProcessComponent <em>Process Component</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Process Component</em>'.
     * @see modelmanagement.processcomponents.ProcessComponent
     * @generated
     */
	EClass getProcessComponent();

	/**
     * Returns the meta object for the reference list '{@link modelmanagement.processcomponents.ProcessComponent#getProvidedInterfaces <em>Provided Interfaces</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Provided Interfaces</em>'.
     * @see modelmanagement.processcomponents.ProcessComponent#getProvidedInterfaces()
     * @see #getProcessComponent()
     * @generated
     */
	EReference getProcessComponent_ProvidedInterfaces();

	/**
     * Returns the meta object for the reference list '{@link modelmanagement.processcomponents.ProcessComponent#getEventProducers <em>Event Producers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Event Producers</em>'.
     * @see modelmanagement.processcomponents.ProcessComponent#getEventProducers()
     * @see #getProcessComponent()
     * @generated
     */
	EReference getProcessComponent_EventProducers();

	/**
     * Returns the meta object for the reference list '{@link modelmanagement.processcomponents.ProcessComponent#getInteractions <em>Interactions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Interactions</em>'.
     * @see modelmanagement.processcomponents.ProcessComponent#getInteractions()
     * @see #getProcessComponent()
     * @generated
     */
	EReference getProcessComponent_Interactions();

	/**
     * Returns the meta object for the reference list '{@link modelmanagement.processcomponents.ProcessComponent#getInitiatedInteractions <em>Initiated Interactions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Initiated Interactions</em>'.
     * @see modelmanagement.processcomponents.ProcessComponent#getInitiatedInteractions()
     * @see #getProcessComponent()
     * @generated
     */
	EReference getProcessComponent_InitiatedInteractions();

	/**
     * Returns the meta object for class '{@link modelmanagement.processcomponents.ProcessComponentInsideCompany <em>Process Component Inside Company</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Process Component Inside Company</em>'.
     * @see modelmanagement.processcomponents.ProcessComponentInsideCompany
     * @generated
     */
	EClass getProcessComponentInsideCompany();

	/**
     * Returns the meta object for class '{@link modelmanagement.processcomponents.ProcessComponentOutsideCompany <em>Process Component Outside Company</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Process Component Outside Company</em>'.
     * @see modelmanagement.processcomponents.ProcessComponentOutsideCompany
     * @generated
     */
	EClass getProcessComponentOutsideCompany();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ProcesscomponentsFactory getProcesscomponentsFactory();

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
         * The meta object literal for the '{@link modelmanagement.processcomponents.impl.ProcessComponentImpl <em>Process Component</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.processcomponents.impl.ProcessComponentImpl
         * @see modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl#getProcessComponent()
         * @generated
         */
		EClass PROCESS_COMPONENT = eINSTANCE.getProcessComponent();

		/**
         * The meta object literal for the '<em><b>Provided Interfaces</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT__PROVIDED_INTERFACES = eINSTANCE.getProcessComponent_ProvidedInterfaces();

		/**
         * The meta object literal for the '<em><b>Event Producers</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT__EVENT_PRODUCERS = eINSTANCE.getProcessComponent_EventProducers();

		/**
         * The meta object literal for the '<em><b>Interactions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT__INTERACTIONS = eINSTANCE.getProcessComponent_Interactions();

		/**
         * The meta object literal for the '<em><b>Initiated Interactions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT__INITIATED_INTERACTIONS = eINSTANCE.getProcessComponent_InitiatedInteractions();

		/**
         * The meta object literal for the '{@link modelmanagement.processcomponents.impl.ProcessComponentInsideCompanyImpl <em>Process Component Inside Company</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.processcomponents.impl.ProcessComponentInsideCompanyImpl
         * @see modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl#getProcessComponentInsideCompany()
         * @generated
         */
		EClass PROCESS_COMPONENT_INSIDE_COMPANY = eINSTANCE.getProcessComponentInsideCompany();

		/**
         * The meta object literal for the '{@link modelmanagement.processcomponents.impl.ProcessComponentOutsideCompanyImpl <em>Process Component Outside Company</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see modelmanagement.processcomponents.impl.ProcessComponentOutsideCompanyImpl
         * @see modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl#getProcessComponentOutsideCompany()
         * @generated
         */
		EClass PROCESS_COMPONENT_OUTSIDE_COMPANY = eINSTANCE.getProcessComponentOutsideCompany();

	}

} //ProcesscomponentsPackage
