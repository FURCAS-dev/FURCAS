/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.petriNet.Arc;
import de.hpi.sam.petriNet.Node;
import de.hpi.sam.petriNet.PetriNetPackage;

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
     * The cached value of the '{@link #getOutgoingArcs() <em>Outgoing Arcs</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOutgoingArcs()
     * @generated
     * @ordered
     */
	protected Arc outgoingArcs;

	/**
     * The cached value of the '{@link #getIncomingArcs() <em>Incoming Arcs</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIncomingArcs()
     * @generated
     * @ordered
     */
	protected Arc incomingArcs;

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
	public Arc getOutgoingArcs() {
        if (outgoingArcs != null && outgoingArcs.eIsProxy()) {
            InternalEObject oldOutgoingArcs = (InternalEObject)outgoingArcs;
            outgoingArcs = (Arc)eResolveProxy(oldOutgoingArcs);
            if (outgoingArcs != oldOutgoingArcs) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PetriNetPackage.NODE__OUTGOING_ARCS, oldOutgoingArcs, outgoingArcs));
            }
        }
        return outgoingArcs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Arc basicGetOutgoingArcs() {
        return outgoingArcs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetOutgoingArcs(Arc newOutgoingArcs, NotificationChain msgs) {
        Arc oldOutgoingArcs = outgoingArcs;
        outgoingArcs = newOutgoingArcs;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PetriNetPackage.NODE__OUTGOING_ARCS, oldOutgoingArcs, newOutgoingArcs);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOutgoingArcs(Arc newOutgoingArcs) {
        if (newOutgoingArcs != outgoingArcs) {
            NotificationChain msgs = null;
            if (outgoingArcs != null)
                msgs = ((InternalEObject)outgoingArcs).eInverseRemove(this, PetriNetPackage.ARC__SOURCE, Arc.class, msgs);
            if (newOutgoingArcs != null)
                msgs = ((InternalEObject)newOutgoingArcs).eInverseAdd(this, PetriNetPackage.ARC__SOURCE, Arc.class, msgs);
            msgs = basicSetOutgoingArcs(newOutgoingArcs, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.NODE__OUTGOING_ARCS, newOutgoingArcs, newOutgoingArcs));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Arc getIncomingArcs() {
        if (incomingArcs != null && incomingArcs.eIsProxy()) {
            InternalEObject oldIncomingArcs = (InternalEObject)incomingArcs;
            incomingArcs = (Arc)eResolveProxy(oldIncomingArcs);
            if (incomingArcs != oldIncomingArcs) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PetriNetPackage.NODE__INCOMING_ARCS, oldIncomingArcs, incomingArcs));
            }
        }
        return incomingArcs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Arc basicGetIncomingArcs() {
        return incomingArcs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetIncomingArcs(Arc newIncomingArcs, NotificationChain msgs) {
        Arc oldIncomingArcs = incomingArcs;
        incomingArcs = newIncomingArcs;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PetriNetPackage.NODE__INCOMING_ARCS, oldIncomingArcs, newIncomingArcs);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIncomingArcs(Arc newIncomingArcs) {
        if (newIncomingArcs != incomingArcs) {
            NotificationChain msgs = null;
            if (incomingArcs != null)
                msgs = ((InternalEObject)incomingArcs).eInverseRemove(this, PetriNetPackage.ARC__TARGET, Arc.class, msgs);
            if (newIncomingArcs != null)
                msgs = ((InternalEObject)newIncomingArcs).eInverseAdd(this, PetriNetPackage.ARC__TARGET, Arc.class, msgs);
            msgs = basicSetIncomingArcs(newIncomingArcs, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.NODE__INCOMING_ARCS, newIncomingArcs, newIncomingArcs));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PetriNetPackage.NODE__OUTGOING_ARCS:
                if (outgoingArcs != null)
                    msgs = ((InternalEObject)outgoingArcs).eInverseRemove(this, PetriNetPackage.ARC__SOURCE, Arc.class, msgs);
                return basicSetOutgoingArcs((Arc)otherEnd, msgs);
            case PetriNetPackage.NODE__INCOMING_ARCS:
                if (incomingArcs != null)
                    msgs = ((InternalEObject)incomingArcs).eInverseRemove(this, PetriNetPackage.ARC__TARGET, Arc.class, msgs);
                return basicSetIncomingArcs((Arc)otherEnd, msgs);
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
                return basicSetOutgoingArcs(null, msgs);
            case PetriNetPackage.NODE__INCOMING_ARCS:
                return basicSetIncomingArcs(null, msgs);
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
                if (resolve) return getOutgoingArcs();
                return basicGetOutgoingArcs();
            case PetriNetPackage.NODE__INCOMING_ARCS:
                if (resolve) return getIncomingArcs();
                return basicGetIncomingArcs();
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
            case PetriNetPackage.NODE__OUTGOING_ARCS:
                setOutgoingArcs((Arc)newValue);
                return;
            case PetriNetPackage.NODE__INCOMING_ARCS:
                setIncomingArcs((Arc)newValue);
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
                setOutgoingArcs((Arc)null);
                return;
            case PetriNetPackage.NODE__INCOMING_ARCS:
                setIncomingArcs((Arc)null);
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
                return outgoingArcs != null;
            case PetriNetPackage.NODE__INCOMING_ARCS:
                return incomingArcs != null;
        }
        return super.eIsSet(featureID);
    }

} //NodeImpl
