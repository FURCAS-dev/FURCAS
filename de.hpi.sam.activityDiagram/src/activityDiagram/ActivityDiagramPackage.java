/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;

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
 * @see activityDiagram.ActivityDiagramFactory
 * @model kind="package"
 * @generated
 */
public interface ActivityDiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "activityDiagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://activityDiagram/0.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "activityDiagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityDiagramPackage eINSTANCE = activityDiagram.impl.ActivityDiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link activityDiagram.impl.activityDiagramContainerImpl <em>activity Diagram Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.activityDiagramContainerImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getactivityDiagramContainer()
	 * @generated
	 */
	int ACTIVITY_DIAGRAM_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Activities</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES = 1;

	/**
	 * The number of structural features of the '<em>activity Diagram Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_DIAGRAM_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.ElementImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.ActivityImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 2;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ACTIONS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__CONTAINER = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Flows</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__FLOWS = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.ActionImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ACTIVITY = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__INCOMING = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OUTGOING = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.ControlFlowImpl <em>Control Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.ControlFlowImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getControlFlow()
	 * @generated
	 */
	int CONTROL_FLOW = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW__SOURCE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW__TARGET = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW__CONDITION = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW__ACTIVITY = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Control Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.SendSignalImpl <em>Send Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.SendSignalImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getSendSignal()
	 * @generated
	 */
	int SEND_SIGNAL = 5;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL__INCOMING = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL__NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Send Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_SIGNAL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.ReceiveSignalImpl <em>Receive Signal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.ReceiveSignalImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getReceiveSignal()
	 * @generated
	 */
	int RECEIVE_SIGNAL = 6;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL__OUTGOING = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL__NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Receive Signal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_SIGNAL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.NodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 9;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.ForkNodeImpl <em>Fork Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.ForkNodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getForkNode()
	 * @generated
	 */
	int FORK_NODE = 7;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__INCOMING = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE__OUTGOINGS = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fork Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.MergeNodeImpl <em>Merge Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.MergeNodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getMergeNode()
	 * @generated
	 */
	int MERGE_NODE = 8;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_NODE__OUTGOING = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_NODE__INCOMINGS = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Merge Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.DecisionNodeImpl <em>Decision Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.DecisionNodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getDecisionNode()
	 * @generated
	 */
	int DECISION_NODE = 10;

	/**
	 * The feature id for the '<em><b>Outgoings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_NODE__OUTGOINGS = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_NODE__INCOMING = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Decision Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.JoinNodeImpl <em>Join Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.JoinNodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getJoinNode()
	 * @generated
	 */
	int JOIN_NODE = 11;

	/**
	 * The feature id for the '<em><b>Incomings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__INCOMINGS = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE__OUTGOING = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Join Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.StartNodeImpl <em>Start Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.StartNodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getStartNode()
	 * @generated
	 */
	int START_NODE = 12;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_NODE__OUTGOING = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Start Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.EndNodeImpl <em>End Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.EndNodeImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getEndNode()
	 * @generated
	 */
	int END_NODE = 15;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE__INCOMING = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>End Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.EndNodeFlowImpl <em>End Node Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.EndNodeFlowImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getEndNodeFlow()
	 * @generated
	 */
	int END_NODE_FLOW = 13;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE_FLOW__INCOMING = END_NODE__INCOMING;

	/**
	 * The number of structural features of the '<em>End Node Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE_FLOW_FEATURE_COUNT = END_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link activityDiagram.impl.EndNodeActivityImpl <em>End Node Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see activityDiagram.impl.EndNodeActivityImpl
	 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getEndNodeActivity()
	 * @generated
	 */
	int END_NODE_ACTIVITY = 14;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE_ACTIVITY__INCOMING = END_NODE__INCOMING;

	/**
	 * The number of structural features of the '<em>End Node Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_NODE_ACTIVITY_FEATURE_COUNT = END_NODE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link activityDiagram.activityDiagramContainer <em>activity Diagram Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>activity Diagram Container</em>'.
	 * @see activityDiagram.activityDiagramContainer
	 * @generated
	 */
	EClass getactivityDiagramContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link activityDiagram.activityDiagramContainer#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see activityDiagram.activityDiagramContainer#getElements()
	 * @see #getactivityDiagramContainer()
	 * @generated
	 */
	EReference getactivityDiagramContainer_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link activityDiagram.activityDiagramContainer#getActivities <em>Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Activities</em>'.
	 * @see activityDiagram.activityDiagramContainer#getActivities()
	 * @see #getactivityDiagramContainer()
	 * @generated
	 */
	EReference getactivityDiagramContainer_Activities();

	/**
	 * Returns the meta object for class '{@link activityDiagram.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see activityDiagram.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link activityDiagram.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see activityDiagram.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the containment reference '{@link activityDiagram.Activity#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Actions</em>'.
	 * @see activityDiagram.Activity#getActions()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Actions();

	/**
	 * Returns the meta object for the attribute '{@link activityDiagram.Activity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see activityDiagram.Activity#getName()
	 * @see #getActivity()
	 * @generated
	 */
	EAttribute getActivity_Name();

	/**
	 * Returns the meta object for the container reference '{@link activityDiagram.Activity#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see activityDiagram.Activity#getContainer()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Container();

	/**
	 * Returns the meta object for the containment reference '{@link activityDiagram.Activity#getFlows <em>Flows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flows</em>'.
	 * @see activityDiagram.Activity#getFlows()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Flows();

	/**
	 * Returns the meta object for class '{@link activityDiagram.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see activityDiagram.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the container reference '{@link activityDiagram.Action#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Activity</em>'.
	 * @see activityDiagram.Action#getActivity()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Activity();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.Action#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see activityDiagram.Action#getIncoming()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Incoming();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.Action#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see activityDiagram.Action#getOutgoing()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Outgoing();

	/**
	 * Returns the meta object for the attribute '{@link activityDiagram.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see activityDiagram.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for class '{@link activityDiagram.ControlFlow <em>Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Flow</em>'.
	 * @see activityDiagram.ControlFlow
	 * @generated
	 */
	EClass getControlFlow();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.ControlFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see activityDiagram.ControlFlow#getSource()
	 * @see #getControlFlow()
	 * @generated
	 */
	EReference getControlFlow_Source();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.ControlFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see activityDiagram.ControlFlow#getTarget()
	 * @see #getControlFlow()
	 * @generated
	 */
	EReference getControlFlow_Target();

	/**
	 * Returns the meta object for the attribute '{@link activityDiagram.ControlFlow#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see activityDiagram.ControlFlow#getCondition()
	 * @see #getControlFlow()
	 * @generated
	 */
	EAttribute getControlFlow_Condition();

	/**
	 * Returns the meta object for the container reference '{@link activityDiagram.ControlFlow#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Activity</em>'.
	 * @see activityDiagram.ControlFlow#getActivity()
	 * @see #getControlFlow()
	 * @generated
	 */
	EReference getControlFlow_Activity();

	/**
	 * Returns the meta object for class '{@link activityDiagram.SendSignal <em>Send Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Signal</em>'.
	 * @see activityDiagram.SendSignal
	 * @generated
	 */
	EClass getSendSignal();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.SendSignal#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see activityDiagram.SendSignal#getIncoming()
	 * @see #getSendSignal()
	 * @generated
	 */
	EReference getSendSignal_Incoming();

	/**
	 * Returns the meta object for the attribute '{@link activityDiagram.SendSignal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see activityDiagram.SendSignal#getName()
	 * @see #getSendSignal()
	 * @generated
	 */
	EAttribute getSendSignal_Name();

	/**
	 * Returns the meta object for class '{@link activityDiagram.ReceiveSignal <em>Receive Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Signal</em>'.
	 * @see activityDiagram.ReceiveSignal
	 * @generated
	 */
	EClass getReceiveSignal();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.ReceiveSignal#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see activityDiagram.ReceiveSignal#getOutgoing()
	 * @see #getReceiveSignal()
	 * @generated
	 */
	EReference getReceiveSignal_Outgoing();

	/**
	 * Returns the meta object for the attribute '{@link activityDiagram.ReceiveSignal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see activityDiagram.ReceiveSignal#getName()
	 * @see #getReceiveSignal()
	 * @generated
	 */
	EAttribute getReceiveSignal_Name();

	/**
	 * Returns the meta object for class '{@link activityDiagram.ForkNode <em>Fork Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork Node</em>'.
	 * @see activityDiagram.ForkNode
	 * @generated
	 */
	EClass getForkNode();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.ForkNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see activityDiagram.ForkNode#getIncoming()
	 * @see #getForkNode()
	 * @generated
	 */
	EReference getForkNode_Incoming();

	/**
	 * Returns the meta object for the reference list '{@link activityDiagram.ForkNode#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see activityDiagram.ForkNode#getOutgoings()
	 * @see #getForkNode()
	 * @generated
	 */
	EReference getForkNode_Outgoings();

	/**
	 * Returns the meta object for class '{@link activityDiagram.MergeNode <em>Merge Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merge Node</em>'.
	 * @see activityDiagram.MergeNode
	 * @generated
	 */
	EClass getMergeNode();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.MergeNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see activityDiagram.MergeNode#getOutgoing()
	 * @see #getMergeNode()
	 * @generated
	 */
	EReference getMergeNode_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link activityDiagram.MergeNode#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see activityDiagram.MergeNode#getIncomings()
	 * @see #getMergeNode()
	 * @generated
	 */
	EReference getMergeNode_Incomings();

	/**
	 * Returns the meta object for class '{@link activityDiagram.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see activityDiagram.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for class '{@link activityDiagram.DecisionNode <em>Decision Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision Node</em>'.
	 * @see activityDiagram.DecisionNode
	 * @generated
	 */
	EClass getDecisionNode();

	/**
	 * Returns the meta object for the reference list '{@link activityDiagram.DecisionNode#getOutgoings <em>Outgoings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoings</em>'.
	 * @see activityDiagram.DecisionNode#getOutgoings()
	 * @see #getDecisionNode()
	 * @generated
	 */
	EReference getDecisionNode_Outgoings();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.DecisionNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see activityDiagram.DecisionNode#getIncoming()
	 * @see #getDecisionNode()
	 * @generated
	 */
	EReference getDecisionNode_Incoming();

	/**
	 * Returns the meta object for class '{@link activityDiagram.JoinNode <em>Join Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join Node</em>'.
	 * @see activityDiagram.JoinNode
	 * @generated
	 */
	EClass getJoinNode();

	/**
	 * Returns the meta object for the reference list '{@link activityDiagram.JoinNode#getIncomings <em>Incomings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incomings</em>'.
	 * @see activityDiagram.JoinNode#getIncomings()
	 * @see #getJoinNode()
	 * @generated
	 */
	EReference getJoinNode_Incomings();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.JoinNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see activityDiagram.JoinNode#getOutgoing()
	 * @see #getJoinNode()
	 * @generated
	 */
	EReference getJoinNode_Outgoing();

	/**
	 * Returns the meta object for class '{@link activityDiagram.StartNode <em>Start Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Node</em>'.
	 * @see activityDiagram.StartNode
	 * @generated
	 */
	EClass getStartNode();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.StartNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outgoing</em>'.
	 * @see activityDiagram.StartNode#getOutgoing()
	 * @see #getStartNode()
	 * @generated
	 */
	EReference getStartNode_Outgoing();

	/**
	 * Returns the meta object for class '{@link activityDiagram.EndNodeFlow <em>End Node Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Node Flow</em>'.
	 * @see activityDiagram.EndNodeFlow
	 * @generated
	 */
	EClass getEndNodeFlow();

	/**
	 * Returns the meta object for class '{@link activityDiagram.EndNodeActivity <em>End Node Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Node Activity</em>'.
	 * @see activityDiagram.EndNodeActivity
	 * @generated
	 */
	EClass getEndNodeActivity();

	/**
	 * Returns the meta object for class '{@link activityDiagram.EndNode <em>End Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Node</em>'.
	 * @see activityDiagram.EndNode
	 * @generated
	 */
	EClass getEndNode();

	/**
	 * Returns the meta object for the reference '{@link activityDiagram.EndNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming</em>'.
	 * @see activityDiagram.EndNode#getIncoming()
	 * @see #getEndNode()
	 * @generated
	 */
	EReference getEndNode_Incoming();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivityDiagramFactory getActivityDiagramFactory();

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
		 * The meta object literal for the '{@link activityDiagram.impl.activityDiagramContainerImpl <em>activity Diagram Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.activityDiagramContainerImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getactivityDiagramContainer()
		 * @generated
		 */
		EClass ACTIVITY_DIAGRAM_CONTAINER = eINSTANCE.getactivityDiagramContainer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_DIAGRAM_CONTAINER__ELEMENTS = eINSTANCE.getactivityDiagramContainer_Elements();

		/**
		 * The meta object literal for the '<em><b>Activities</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES = eINSTANCE.getactivityDiagramContainer_Activities();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.ElementImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.ActivityImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__ACTIONS = eINSTANCE.getActivity_Actions();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY__NAME = eINSTANCE.getActivity_Name();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__CONTAINER = eINSTANCE.getActivity_Container();

		/**
		 * The meta object literal for the '<em><b>Flows</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__FLOWS = eINSTANCE.getActivity_Flows();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.ActionImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__ACTIVITY = eINSTANCE.getAction_Activity();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__INCOMING = eINSTANCE.getAction_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OUTGOING = eINSTANCE.getAction_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.ControlFlowImpl <em>Control Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.ControlFlowImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getControlFlow()
		 * @generated
		 */
		EClass CONTROL_FLOW = eINSTANCE.getControlFlow();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW__SOURCE = eINSTANCE.getControlFlow_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW__TARGET = eINSTANCE.getControlFlow_Target();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_FLOW__CONDITION = eINSTANCE.getControlFlow_Condition();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW__ACTIVITY = eINSTANCE.getControlFlow_Activity();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.SendSignalImpl <em>Send Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.SendSignalImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getSendSignal()
		 * @generated
		 */
		EClass SEND_SIGNAL = eINSTANCE.getSendSignal();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_SIGNAL__INCOMING = eINSTANCE.getSendSignal_Incoming();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEND_SIGNAL__NAME = eINSTANCE.getSendSignal_Name();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.ReceiveSignalImpl <em>Receive Signal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.ReceiveSignalImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getReceiveSignal()
		 * @generated
		 */
		EClass RECEIVE_SIGNAL = eINSTANCE.getReceiveSignal();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_SIGNAL__OUTGOING = eINSTANCE.getReceiveSignal_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECEIVE_SIGNAL__NAME = eINSTANCE.getReceiveSignal_Name();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.ForkNodeImpl <em>Fork Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.ForkNodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getForkNode()
		 * @generated
		 */
		EClass FORK_NODE = eINSTANCE.getForkNode();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK_NODE__INCOMING = eINSTANCE.getForkNode_Incoming();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK_NODE__OUTGOINGS = eINSTANCE.getForkNode_Outgoings();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.MergeNodeImpl <em>Merge Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.MergeNodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getMergeNode()
		 * @generated
		 */
		EClass MERGE_NODE = eINSTANCE.getMergeNode();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE_NODE__OUTGOING = eINSTANCE.getMergeNode_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGE_NODE__INCOMINGS = eINSTANCE.getMergeNode_Incomings();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.NodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.DecisionNodeImpl <em>Decision Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.DecisionNodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getDecisionNode()
		 * @generated
		 */
		EClass DECISION_NODE = eINSTANCE.getDecisionNode();

		/**
		 * The meta object literal for the '<em><b>Outgoings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION_NODE__OUTGOINGS = eINSTANCE.getDecisionNode_Outgoings();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECISION_NODE__INCOMING = eINSTANCE.getDecisionNode_Incoming();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.JoinNodeImpl <em>Join Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.JoinNodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getJoinNode()
		 * @generated
		 */
		EClass JOIN_NODE = eINSTANCE.getJoinNode();

		/**
		 * The meta object literal for the '<em><b>Incomings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN_NODE__INCOMINGS = eINSTANCE.getJoinNode_Incomings();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN_NODE__OUTGOING = eINSTANCE.getJoinNode_Outgoing();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.StartNodeImpl <em>Start Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.StartNodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getStartNode()
		 * @generated
		 */
		EClass START_NODE = eINSTANCE.getStartNode();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference START_NODE__OUTGOING = eINSTANCE.getStartNode_Outgoing();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.EndNodeFlowImpl <em>End Node Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.EndNodeFlowImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getEndNodeFlow()
		 * @generated
		 */
		EClass END_NODE_FLOW = eINSTANCE.getEndNodeFlow();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.EndNodeActivityImpl <em>End Node Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.EndNodeActivityImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getEndNodeActivity()
		 * @generated
		 */
		EClass END_NODE_ACTIVITY = eINSTANCE.getEndNodeActivity();

		/**
		 * The meta object literal for the '{@link activityDiagram.impl.EndNodeImpl <em>End Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see activityDiagram.impl.EndNodeImpl
		 * @see activityDiagram.impl.ActivityDiagramPackageImpl#getEndNode()
		 * @generated
		 */
		EClass END_NODE = eINSTANCE.getEndNode();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_NODE__INCOMING = eINSTANCE.getEndNode_Incoming();

	}

} //ActivityDiagramPackage
