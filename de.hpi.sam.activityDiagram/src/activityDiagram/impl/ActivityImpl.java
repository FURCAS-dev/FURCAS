/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram.impl;

import activityDiagram.Action;
import activityDiagram.Activity;
import activityDiagram.ActivityDiagramPackage;
import activityDiagram.ControlFlow;
import activityDiagram.activityDiagramContainer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link activityDiagram.impl.ActivityImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link activityDiagram.impl.ActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link activityDiagram.impl.ActivityImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link activityDiagram.impl.ActivityImpl#getFlows <em>Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends ElementImpl implements Activity {
	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected Action actions;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlows()
	 * @generated
	 * @ordered
	 */
	protected ControlFlow flows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityDiagramPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getActions() {
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetActions(Action newActions, NotificationChain msgs) {
		Action oldActions = actions;
		actions = newActions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY__ACTIONS, oldActions, newActions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActions(Action newActions) {
		if (newActions != actions) {
			NotificationChain msgs = null;
			if (actions != null)
				msgs = ((InternalEObject)actions).eInverseRemove(this, ActivityDiagramPackage.ACTION__ACTIVITY, Action.class, msgs);
			if (newActions != null)
				msgs = ((InternalEObject)newActions).eInverseAdd(this, ActivityDiagramPackage.ACTION__ACTIVITY, Action.class, msgs);
			msgs = basicSetActions(newActions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY__ACTIONS, newActions, newActions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public activityDiagramContainer getContainer() {
		if (eContainerFeatureID() != ActivityDiagramPackage.ACTIVITY__CONTAINER) return null;
		return (activityDiagramContainer)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(activityDiagramContainer newContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer, ActivityDiagramPackage.ACTIVITY__CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(activityDiagramContainer newContainer) {
		if (newContainer != eInternalContainer() || (eContainerFeatureID() != ActivityDiagramPackage.ACTIVITY__CONTAINER && newContainer != null)) {
			if (EcoreUtil.isAncestor(this, newContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES, activityDiagramContainer.class, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow getFlows() {
		return flows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFlows(ControlFlow newFlows, NotificationChain msgs) {
		ControlFlow oldFlows = flows;
		flows = newFlows;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY__FLOWS, oldFlows, newFlows);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlows(ControlFlow newFlows) {
		if (newFlows != flows) {
			NotificationChain msgs = null;
			if (flows != null)
				msgs = ((InternalEObject)flows).eInverseRemove(this, ActivityDiagramPackage.CONTROL_FLOW__ACTIVITY, ControlFlow.class, msgs);
			if (newFlows != null)
				msgs = ((InternalEObject)newFlows).eInverseAdd(this, ActivityDiagramPackage.CONTROL_FLOW__ACTIVITY, ControlFlow.class, msgs);
			msgs = basicSetFlows(newFlows, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.ACTIVITY__FLOWS, newFlows, newFlows));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY__ACTIONS:
				if (actions != null)
					msgs = ((InternalEObject)actions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActivityDiagramPackage.ACTIVITY__ACTIONS, null, msgs);
				return basicSetActions((Action)otherEnd, msgs);
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer((activityDiagramContainer)otherEnd, msgs);
			case ActivityDiagramPackage.ACTIVITY__FLOWS:
				if (flows != null)
					msgs = ((InternalEObject)flows).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActivityDiagramPackage.ACTIVITY__FLOWS, null, msgs);
				return basicSetFlows((ControlFlow)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY__ACTIONS:
				return basicSetActions(null, msgs);
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				return basicSetContainer(null, msgs);
			case ActivityDiagramPackage.ACTIVITY__FLOWS:
				return basicSetFlows(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				return eInternalContainer().eInverseRemove(this, ActivityDiagramPackage.ACTIVITY_DIAGRAM_CONTAINER__ACTIVITIES, activityDiagramContainer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY__ACTIONS:
				return getActions();
			case ActivityDiagramPackage.ACTIVITY__NAME:
				return getName();
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				return getContainer();
			case ActivityDiagramPackage.ACTIVITY__FLOWS:
				return getFlows();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY__ACTIONS:
				setActions((Action)newValue);
				return;
			case ActivityDiagramPackage.ACTIVITY__NAME:
				setName((String)newValue);
				return;
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				setContainer((activityDiagramContainer)newValue);
				return;
			case ActivityDiagramPackage.ACTIVITY__FLOWS:
				setFlows((ControlFlow)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY__ACTIONS:
				setActions((Action)null);
				return;
			case ActivityDiagramPackage.ACTIVITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				setContainer((activityDiagramContainer)null);
				return;
			case ActivityDiagramPackage.ACTIVITY__FLOWS:
				setFlows((ControlFlow)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActivityDiagramPackage.ACTIVITY__ACTIONS:
				return actions != null;
			case ActivityDiagramPackage.ACTIVITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ActivityDiagramPackage.ACTIVITY__CONTAINER:
				return getContainer() != null;
			case ActivityDiagramPackage.ACTIVITY__FLOWS:
				return flows != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ActivityImpl
