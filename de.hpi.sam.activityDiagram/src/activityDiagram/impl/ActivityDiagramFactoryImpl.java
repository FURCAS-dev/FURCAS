/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram.impl;

import activityDiagram.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityDiagramFactoryImpl extends EFactoryImpl implements ActivityDiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityDiagramFactory init() {
		try {
			ActivityDiagramFactory theActivityDiagramFactory = (ActivityDiagramFactory)EPackage.Registry.INSTANCE.getEFactory("http://activityDiagram/0.1"); 
			if (theActivityDiagramFactory != null) {
				return theActivityDiagramFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActivityDiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityDiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER: return createactivityDiagramContainer();
			case ActivityDiagramPackage.ACTIVITY: return createActivity();
			case ActivityDiagramPackage.ACTION: return createAction();
			case ActivityDiagramPackage.CONTROL_FLOW: return createControlFlow();
			case ActivityDiagramPackage.SEND_SIGNAL: return createSendSignal();
			case ActivityDiagramPackage.RECEIVE_SIGNAL: return createReceiveSignal();
			case ActivityDiagramPackage.FORK_NODE: return createForkNode();
			case ActivityDiagramPackage.MERGE_NODE: return createMergeNode();
			case ActivityDiagramPackage.DECISION_NODE: return createDecisionNode();
			case ActivityDiagramPackage.JOIN_NODE: return createJoinNode();
			case ActivityDiagramPackage.START_NODE: return createStartNode();
			case ActivityDiagramPackage.END_NODE_FLOW: return createEndNodeFlow();
			case ActivityDiagramPackage.END_NODE_ACTIVITY: return createEndNodeActivity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public activityDiagramContainer createactivityDiagramContainer() {
		activityDiagramContainerImpl activityDiagramContainer = new activityDiagramContainerImpl();
		return activityDiagramContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow createControlFlow() {
		ControlFlowImpl controlFlow = new ControlFlowImpl();
		return controlFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SendSignal createSendSignal() {
		SendSignalImpl sendSignal = new SendSignalImpl();
		return sendSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceiveSignal createReceiveSignal() {
		ReceiveSignalImpl receiveSignal = new ReceiveSignalImpl();
		return receiveSignal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkNode createForkNode() {
		ForkNodeImpl forkNode = new ForkNodeImpl();
		return forkNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeNode createMergeNode() {
		MergeNodeImpl mergeNode = new MergeNodeImpl();
		return mergeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DecisionNode createDecisionNode() {
		DecisionNodeImpl decisionNode = new DecisionNodeImpl();
		return decisionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinNode createJoinNode() {
		JoinNodeImpl joinNode = new JoinNodeImpl();
		return joinNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartNode createStartNode() {
		StartNodeImpl startNode = new StartNodeImpl();
		return startNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndNodeFlow createEndNodeFlow() {
		EndNodeFlowImpl endNodeFlow = new EndNodeFlowImpl();
		return endNodeFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndNodeActivity createEndNodeActivity() {
		EndNodeActivityImpl endNodeActivity = new EndNodeActivityImpl();
		return endNodeActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityDiagramPackage getActivityDiagramPackage() {
		return (ActivityDiagramPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActivityDiagramPackage getPackage() {
		return ActivityDiagramPackage.eINSTANCE;
	}

} //ActivityDiagramFactoryImpl
