/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessintegrationPackage.java,v 1.1 2011/02/07 16:57:59 auhl Exp $
 */
package integration.processintegration;

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
 * @see integration.processintegration.ProcessintegrationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ProcessintegrationPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "processintegration";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/integration/processintegration.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "integration.processintegration";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ProcessintegrationPackage eINSTANCE = integration.processintegration.impl.ProcessintegrationPackageImpl.init();

	/**
     * The meta object id for the '{@link integration.processintegration.impl.IntegrationScenarioImpl <em>Integration Scenario</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.processintegration.impl.IntegrationScenarioImpl
     * @see integration.processintegration.impl.ProcessintegrationPackageImpl#getIntegrationScenario()
     * @generated
     */
	int INTEGRATION_SCENARIO = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGRATION_SCENARIO__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGRATION_SCENARIO__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Interactions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGRATION_SCENARIO__INTERACTIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Integration Scenario</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INTEGRATION_SCENARIO_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link integration.processintegration.impl.ProcessComponentInteractionImpl <em>Process Component Interaction</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see integration.processintegration.impl.ProcessComponentInteractionImpl
     * @see integration.processintegration.impl.ProcessintegrationPackageImpl#getProcessComponentInteraction()
     * @generated
     */
	int PROCESS_COMPONENT_INTERACTION = 1;

	/**
     * The feature id for the '<em><b>Initiator Process Component</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT = 0;

	/**
     * The feature id for the '<em><b>Process Component</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT = 1;

	/**
     * The feature id for the '<em><b>Uses</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INTERACTION__USES = 2;

	/**
     * The feature id for the '<em><b>Method Calls</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INTERACTION__METHOD_CALLS = 3;

	/**
     * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS = 4;

	/**
     * The number of structural features of the '<em>Process Component Interaction</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PROCESS_COMPONENT_INTERACTION_FEATURE_COUNT = 5;


	/**
     * Returns the meta object for class '{@link integration.processintegration.IntegrationScenario <em>Integration Scenario</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Integration Scenario</em>'.
     * @see integration.processintegration.IntegrationScenario
     * @generated
     */
	EClass getIntegrationScenario();

	/**
     * Returns the meta object for the containment reference list '{@link integration.processintegration.IntegrationScenario#getInteractions <em>Interactions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Interactions</em>'.
     * @see integration.processintegration.IntegrationScenario#getInteractions()
     * @see #getIntegrationScenario()
     * @generated
     */
	EReference getIntegrationScenario_Interactions();

	/**
     * Returns the meta object for class '{@link integration.processintegration.ProcessComponentInteraction <em>Process Component Interaction</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Process Component Interaction</em>'.
     * @see integration.processintegration.ProcessComponentInteraction
     * @generated
     */
	EClass getProcessComponentInteraction();

	/**
     * Returns the meta object for the reference '{@link integration.processintegration.ProcessComponentInteraction#getInitiatorProcessComponent <em>Initiator Process Component</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Initiator Process Component</em>'.
     * @see integration.processintegration.ProcessComponentInteraction#getInitiatorProcessComponent()
     * @see #getProcessComponentInteraction()
     * @generated
     */
	EReference getProcessComponentInteraction_InitiatorProcessComponent();

	/**
     * Returns the meta object for the reference '{@link integration.processintegration.ProcessComponentInteraction#getProcessComponent <em>Process Component</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Process Component</em>'.
     * @see integration.processintegration.ProcessComponentInteraction#getProcessComponent()
     * @see #getProcessComponentInteraction()
     * @generated
     */
	EReference getProcessComponentInteraction_ProcessComponent();

	/**
     * Returns the meta object for the container reference '{@link integration.processintegration.ProcessComponentInteraction#getUses <em>Uses</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Uses</em>'.
     * @see integration.processintegration.ProcessComponentInteraction#getUses()
     * @see #getProcessComponentInteraction()
     * @generated
     */
	EReference getProcessComponentInteraction_Uses();

	/**
     * Returns the meta object for the reference list '{@link integration.processintegration.ProcessComponentInteraction#getMethodCalls <em>Method Calls</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Method Calls</em>'.
     * @see integration.processintegration.ProcessComponentInteraction#getMethodCalls()
     * @see #getProcessComponentInteraction()
     * @generated
     */
	EReference getProcessComponentInteraction_MethodCalls();

	/**
     * Returns the meta object for the reference list '{@link integration.processintegration.ProcessComponentInteraction#getSubscriptions <em>Subscriptions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Subscriptions</em>'.
     * @see integration.processintegration.ProcessComponentInteraction#getSubscriptions()
     * @see #getProcessComponentInteraction()
     * @generated
     */
	EReference getProcessComponentInteraction_Subscriptions();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ProcessintegrationFactory getProcessintegrationFactory();

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
         * The meta object literal for the '{@link integration.processintegration.impl.IntegrationScenarioImpl <em>Integration Scenario</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.processintegration.impl.IntegrationScenarioImpl
         * @see integration.processintegration.impl.ProcessintegrationPackageImpl#getIntegrationScenario()
         * @generated
         */
		EClass INTEGRATION_SCENARIO = eINSTANCE.getIntegrationScenario();

		/**
         * The meta object literal for the '<em><b>Interactions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INTEGRATION_SCENARIO__INTERACTIONS = eINSTANCE.getIntegrationScenario_Interactions();

		/**
         * The meta object literal for the '{@link integration.processintegration.impl.ProcessComponentInteractionImpl <em>Process Component Interaction</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see integration.processintegration.impl.ProcessComponentInteractionImpl
         * @see integration.processintegration.impl.ProcessintegrationPackageImpl#getProcessComponentInteraction()
         * @generated
         */
		EClass PROCESS_COMPONENT_INTERACTION = eINSTANCE.getProcessComponentInteraction();

		/**
         * The meta object literal for the '<em><b>Initiator Process Component</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT_INTERACTION__INITIATOR_PROCESS_COMPONENT = eINSTANCE.getProcessComponentInteraction_InitiatorProcessComponent();

		/**
         * The meta object literal for the '<em><b>Process Component</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT_INTERACTION__PROCESS_COMPONENT = eINSTANCE.getProcessComponentInteraction_ProcessComponent();

		/**
         * The meta object literal for the '<em><b>Uses</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT_INTERACTION__USES = eINSTANCE.getProcessComponentInteraction_Uses();

		/**
         * The meta object literal for the '<em><b>Method Calls</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT_INTERACTION__METHOD_CALLS = eINSTANCE.getProcessComponentInteraction_MethodCalls();

		/**
         * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PROCESS_COMPONENT_INTERACTION__SUBSCRIPTIONS = eINSTANCE.getProcessComponentInteraction_Subscriptions();

	}

} //ProcessintegrationPackage
