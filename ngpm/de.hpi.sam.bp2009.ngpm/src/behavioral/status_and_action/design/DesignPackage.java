/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.design;

import modelmanagement.ModelmanagementPackage;

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
 * @see behavioral.status_and_action.design.DesignFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface DesignPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "design";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///behavioral/status_and_action/design.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.status_and_action.design";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	DesignPackage eINSTANCE = behavioral.status_and_action.design.impl.DesignPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.BusinessObjectImpl <em>Business Object</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.BusinessObjectImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getBusinessObject()
     * @generated
     */
	int BUSINESS_OBJECT = 0;

	/**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT__NODES = 0;

	/**
     * The number of structural features of the '<em>Business Object</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.BusinessObjectNodeImpl <em>Business Object Node</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.BusinessObjectNodeImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getBusinessObjectNode()
     * @generated
     */
	int BUSINESS_OBJECT_NODE = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT_NODE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT_NODE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT_NODE__VARIABLES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Actions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT_NODE__ACTIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Business Object Node</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BUSINESS_OBJECT_NODE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.AbstractStatusVariableImpl <em>Abstract Status Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.AbstractStatusVariableImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAbstractStatusVariable()
     * @generated
     */
	int ABSTRACT_STATUS_VARIABLE = 5;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VARIABLE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VARIABLE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VARIABLE__IS_AGENT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VARIABLE__VALUES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Abstract Status Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VARIABLE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.StatusVariableImpl <em>Status Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.StatusVariableImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getStatusVariable()
     * @generated
     */
	int STATUS_VARIABLE = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE__NAME = ABSTRACT_STATUS_VARIABLE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE__DESCRIPTION = ABSTRACT_STATUS_VARIABLE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE__IS_AGENT = ABSTRACT_STATUS_VARIABLE__IS_AGENT;

	/**
     * The feature id for the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE__IS_STATE_GUARDED = ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED;

	/**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE__VALUES = ABSTRACT_STATUS_VARIABLE__VALUES;

	/**
     * The number of structural features of the '<em>Status Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_FEATURE_COUNT = ABSTRACT_STATUS_VARIABLE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.AbstractStatusValueImpl <em>Abstract Status Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.AbstractStatusValueImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAbstractStatusValue()
     * @generated
     */
	int ABSTRACT_STATUS_VALUE = 6;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VALUE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VALUE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Initial</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VALUE__IS_INITIAL = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Is Inhibiting</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VALUE__IS_INHIBITING = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Abstract Status Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_STATUS_VALUE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.StatusValueImpl <em>Status Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.StatusValueImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getStatusValue()
     * @generated
     */
	int STATUS_VALUE = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE__NAME = ABSTRACT_STATUS_VALUE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE__DESCRIPTION = ABSTRACT_STATUS_VALUE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Initial</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE__IS_INITIAL = ABSTRACT_STATUS_VALUE__IS_INITIAL;

	/**
     * The feature id for the '<em><b>Is Inhibiting</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE__IS_INHIBITING = ABSTRACT_STATUS_VALUE__IS_INHIBITING;

	/**
     * The feature id for the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE__IS_STATE_GUARDED = ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED;

	/**
     * The number of structural features of the '<em>Status Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_FEATURE_COUNT = ABSTRACT_STATUS_VALUE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.AbstractActionImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAbstractAction()
     * @generated
     */
	int ABSTRACT_ACTION = 7;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_ACTION__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_ACTION__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_ACTION__IS_AGENT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Is Precondition Fixed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_ACTION__IS_PRECONDITION_FIXED = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Abstract Action</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ABSTRACT_ACTION_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.design.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.design.impl.ActionImpl
     * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAction()
     * @generated
     */
	int ACTION = 4;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION__NAME = ABSTRACT_ACTION__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION__DESCRIPTION = ABSTRACT_ACTION__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION__IS_AGENT = ABSTRACT_ACTION__IS_AGENT;

	/**
     * The feature id for the '<em><b>Is Precondition Fixed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION__IS_PRECONDITION_FIXED = ABSTRACT_ACTION__IS_PRECONDITION_FIXED;

	/**
     * The number of structural features of the '<em>Action</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;


	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.BusinessObject <em>Business Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Business Object</em>'.
     * @see behavioral.status_and_action.design.BusinessObject
     * @generated
     */
	EClass getBusinessObject();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action.design.BusinessObject#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nodes</em>'.
     * @see behavioral.status_and_action.design.BusinessObject#getNodes()
     * @see #getBusinessObject()
     * @generated
     */
	EReference getBusinessObject_Nodes();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.BusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Business Object Node</em>'.
     * @see behavioral.status_and_action.design.BusinessObjectNode
     * @generated
     */
	EClass getBusinessObjectNode();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action.design.BusinessObjectNode#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see behavioral.status_and_action.design.BusinessObjectNode#getVariables()
     * @see #getBusinessObjectNode()
     * @generated
     */
	EReference getBusinessObjectNode_Variables();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action.design.BusinessObjectNode#getActions <em>Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Actions</em>'.
     * @see behavioral.status_and_action.design.BusinessObjectNode#getActions()
     * @see #getBusinessObjectNode()
     * @generated
     */
	EReference getBusinessObjectNode_Actions();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.StatusVariable <em>Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status Variable</em>'.
     * @see behavioral.status_and_action.design.StatusVariable
     * @generated
     */
	EClass getStatusVariable();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.StatusValue <em>Status Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status Value</em>'.
     * @see behavioral.status_and_action.design.StatusValue
     * @generated
     */
	EClass getStatusValue();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.Action <em>Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Action</em>'.
     * @see behavioral.status_and_action.design.Action
     * @generated
     */
	EClass getAction();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.AbstractStatusVariable <em>Abstract Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Status Variable</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusVariable
     * @generated
     */
	EClass getAbstractStatusVariable();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractStatusVariable#isIsAgent <em>Is Agent</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Agent</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusVariable#isIsAgent()
     * @see #getAbstractStatusVariable()
     * @generated
     */
	EAttribute getAbstractStatusVariable_IsAgent();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractStatusVariable#isIsStateGuarded <em>Is State Guarded</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is State Guarded</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusVariable#isIsStateGuarded()
     * @see #getAbstractStatusVariable()
     * @generated
     */
	EAttribute getAbstractStatusVariable_IsStateGuarded();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action.design.AbstractStatusVariable#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Values</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusVariable#getValues()
     * @see #getAbstractStatusVariable()
     * @generated
     */
	EReference getAbstractStatusVariable_Values();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.AbstractStatusValue <em>Abstract Status Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Status Value</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusValue
     * @generated
     */
	EClass getAbstractStatusValue();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractStatusValue#isIsInitial <em>Is Initial</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Initial</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusValue#isIsInitial()
     * @see #getAbstractStatusValue()
     * @generated
     */
	EAttribute getAbstractStatusValue_IsInitial();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractStatusValue#isIsInhibiting <em>Is Inhibiting</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Inhibiting</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusValue#isIsInhibiting()
     * @see #getAbstractStatusValue()
     * @generated
     */
	EAttribute getAbstractStatusValue_IsInhibiting();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractStatusValue#isIsStateGuarded <em>Is State Guarded</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is State Guarded</em>'.
     * @see behavioral.status_and_action.design.AbstractStatusValue#isIsStateGuarded()
     * @see #getAbstractStatusValue()
     * @generated
     */
	EAttribute getAbstractStatusValue_IsStateGuarded();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.design.AbstractAction <em>Abstract Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Action</em>'.
     * @see behavioral.status_and_action.design.AbstractAction
     * @generated
     */
	EClass getAbstractAction();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractAction#isIsAgent <em>Is Agent</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Agent</em>'.
     * @see behavioral.status_and_action.design.AbstractAction#isIsAgent()
     * @see #getAbstractAction()
     * @generated
     */
	EAttribute getAbstractAction_IsAgent();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action.design.AbstractAction#isIsPreconditionFixed <em>Is Precondition Fixed</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Precondition Fixed</em>'.
     * @see behavioral.status_and_action.design.AbstractAction#isIsPreconditionFixed()
     * @see #getAbstractAction()
     * @generated
     */
	EAttribute getAbstractAction_IsPreconditionFixed();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	DesignFactory getDesignFactory();

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
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.BusinessObjectImpl <em>Business Object</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.BusinessObjectImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getBusinessObject()
         * @generated
         */
		EClass BUSINESS_OBJECT = eINSTANCE.getBusinessObject();

		/**
         * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_OBJECT__NODES = eINSTANCE.getBusinessObject_Nodes();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.BusinessObjectNodeImpl <em>Business Object Node</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.BusinessObjectNodeImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getBusinessObjectNode()
         * @generated
         */
		EClass BUSINESS_OBJECT_NODE = eINSTANCE.getBusinessObjectNode();

		/**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_OBJECT_NODE__VARIABLES = eINSTANCE.getBusinessObjectNode_Variables();

		/**
         * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BUSINESS_OBJECT_NODE__ACTIONS = eINSTANCE.getBusinessObjectNode_Actions();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.StatusVariableImpl <em>Status Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.StatusVariableImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getStatusVariable()
         * @generated
         */
		EClass STATUS_VARIABLE = eINSTANCE.getStatusVariable();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.StatusValueImpl <em>Status Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.StatusValueImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getStatusValue()
         * @generated
         */
		EClass STATUS_VALUE = eINSTANCE.getStatusValue();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.ActionImpl <em>Action</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.ActionImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAction()
         * @generated
         */
		EClass ACTION = eINSTANCE.getAction();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.AbstractStatusVariableImpl <em>Abstract Status Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.AbstractStatusVariableImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAbstractStatusVariable()
         * @generated
         */
		EClass ABSTRACT_STATUS_VARIABLE = eINSTANCE.getAbstractStatusVariable();

		/**
         * The meta object literal for the '<em><b>Is Agent</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_STATUS_VARIABLE__IS_AGENT = eINSTANCE.getAbstractStatusVariable_IsAgent();

		/**
         * The meta object literal for the '<em><b>Is State Guarded</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED = eINSTANCE.getAbstractStatusVariable_IsStateGuarded();

		/**
         * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ABSTRACT_STATUS_VARIABLE__VALUES = eINSTANCE.getAbstractStatusVariable_Values();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.AbstractStatusValueImpl <em>Abstract Status Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.AbstractStatusValueImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAbstractStatusValue()
         * @generated
         */
		EClass ABSTRACT_STATUS_VALUE = eINSTANCE.getAbstractStatusValue();

		/**
         * The meta object literal for the '<em><b>Is Initial</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_STATUS_VALUE__IS_INITIAL = eINSTANCE.getAbstractStatusValue_IsInitial();

		/**
         * The meta object literal for the '<em><b>Is Inhibiting</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_STATUS_VALUE__IS_INHIBITING = eINSTANCE.getAbstractStatusValue_IsInhibiting();

		/**
         * The meta object literal for the '<em><b>Is State Guarded</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED = eINSTANCE.getAbstractStatusValue_IsStateGuarded();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.design.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.design.impl.AbstractActionImpl
         * @see behavioral.status_and_action.design.impl.DesignPackageImpl#getAbstractAction()
         * @generated
         */
		EClass ABSTRACT_ACTION = eINSTANCE.getAbstractAction();

		/**
         * The meta object literal for the '<em><b>Is Agent</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_ACTION__IS_AGENT = eINSTANCE.getAbstractAction_IsAgent();

		/**
         * The meta object literal for the '<em><b>Is Precondition Fixed</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ABSTRACT_ACTION__IS_PRECONDITION_FIXED = eINSTANCE.getAbstractAction_IsPreconditionFixed();

	}

} //DesignPackage
