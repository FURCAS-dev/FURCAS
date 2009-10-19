/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.impl;

import de.hpi.sam.petriNet.Arc;
import de.hpi.sam.petriNet.Node;
import de.hpi.sam.petriNet.PetriNetPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.impl.NodeImpl#getOutgoingArcs <em>Outgoing Arcs</em>}</li>
 *   <li>{@link de.hpi.sam.petriNet.impl.NodeImpl#getIncomingArcs <em>Incoming Arcs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NodeImpl extends ElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getOutgoingArcs() <em>Outgoing Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> outgoingArcs;

	/**
	 * The cached value of the '{@link #getIncomingArcs() <em>Incoming Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> incomingArcs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PetriNetPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arc> getOutgoingArcs() {
		if (outgoingArcs == null) {
			outgoingArcs = new EObjectWithInverseResolvingEList<Arc>(Arc.class, this, PetriNetPackage.NODE__OUTGOING_ARCS, PetriNetPackage.ARC__SOURCE);
		}
		return outgoingArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arc> getIncomingArcs() {
		if (incomingArcs == null) {
			incomingArcs = new EObjectWithInverseResolvingEList<Arc>(Arc.class, this, PetriNetPackage.NODE__INCOMING_ARCS, PetriNetPackage.ARC__TARGET);
		}
		return incomingArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PetriNetPackage.NODE__OUTGOING_ARCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingArcs()).basicAdd(otherEnd, msgs);
			case PetriNetPackage.NODE__INCOMING_ARCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingArcs()).basicAdd(otherEnd, msgs);
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
			case PetriNetPackage.NODE__OUTGOING_ARCS:
				return ((InternalEList<?>)getOutgoingArcs()).basicRemove(otherEnd, msgs);
			case PetriNetPackage.NODE__INCOMING_ARCS:
				return ((InternalEList<?>)getIncomingArcs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetriNetPackage.NODE__OUTGOING_ARCS:
				return getOutgoingArcs();
			case PetriNetPackage.NODE__INCOMING_ARCS:
				return getIncomingArcs();
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
			case PetriNetPackage.NODE__OUTGOING_ARCS:
				getOutgoingArcs().clear();
				getOutgoingArcs().addAll((Collection<? extends Arc>)newValue);
				return;
			case PetriNetPackage.NODE__INCOMING_ARCS:
				getIncomingArcs().clear();
				getIncomingArcs().addAll((Collection<? extends Arc>)newValue);
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
			case PetriNetPackage.NODE__OUTGOING_ARCS:
				getOutgoingArcs().clear();
				return;
			case PetriNetPackage.NODE__INCOMING_ARCS:
				getIncomingArcs().clear();
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
			case PetriNetPackage.NODE__OUTGOING_ARCS:
				return outgoingArcs != null && !outgoingArcs.isEmpty();
			case PetriNetPackage.NODE__INCOMING_ARCS:
				return incomingArcs != null && !incomingArcs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
