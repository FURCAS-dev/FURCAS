/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram.impl;

import activityDiagram.ActivityDiagramPackage;
import activityDiagram.ControlFlow;
import activityDiagram.MergeNode;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merge Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link activityDiagram.impl.MergeNodeImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link activityDiagram.impl.MergeNodeImpl#getIncomings <em>Incomings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MergeNodeImpl extends NodeImpl implements MergeNode {
	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected ControlFlow outgoing;

	/**
	 * The cached value of the '{@link #getIncomings() <em>Incomings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomings()
	 * @generated
	 * @ordered
	 */
	protected EList<ControlFlow> incomings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MergeNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityDiagramPackage.Literals.MERGE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow getOutgoing() {
		if (outgoing != null && outgoing.eIsProxy()) {
			InternalEObject oldOutgoing = (InternalEObject)outgoing;
			outgoing = (ControlFlow)eResolveProxy(oldOutgoing);
			if (outgoing != oldOutgoing) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityDiagramPackage.MERGE_NODE__OUTGOING, oldOutgoing, outgoing));
			}
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlow basicGetOutgoing() {
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutgoing(ControlFlow newOutgoing) {
		ControlFlow oldOutgoing = outgoing;
		outgoing = newOutgoing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityDiagramPackage.MERGE_NODE__OUTGOING, oldOutgoing, outgoing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ControlFlow> getIncomings() {
		if (incomings == null) {
			incomings = new EObjectResolvingEList<ControlFlow>(ControlFlow.class, this, ActivityDiagramPackage.MERGE_NODE__INCOMINGS);
		}
		return incomings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityDiagramPackage.MERGE_NODE__OUTGOING:
				if (resolve) return getOutgoing();
				return basicGetOutgoing();
			case ActivityDiagramPackage.MERGE_NODE__INCOMINGS:
				return getIncomings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActivityDiagramPackage.MERGE_NODE__OUTGOING:
				setOutgoing((ControlFlow)newValue);
				return;
			case ActivityDiagramPackage.MERGE_NODE__INCOMINGS:
				getIncomings().clear();
				getIncomings().addAll((Collection<? extends ControlFlow>)newValue);
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
			case ActivityDiagramPackage.MERGE_NODE__OUTGOING:
				setOutgoing((ControlFlow)null);
				return;
			case ActivityDiagramPackage.MERGE_NODE__INCOMINGS:
				getIncomings().clear();
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
			case ActivityDiagramPackage.MERGE_NODE__OUTGOING:
				return outgoing != null;
			case ActivityDiagramPackage.MERGE_NODE__INCOMINGS:
				return incomings != null && !incomings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MergeNodeImpl
