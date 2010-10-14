/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet.impl;

import de.hpi.sam.petriNet.Element;
import de.hpi.sam.petriNet.PetriNet;
import de.hpi.sam.petriNet.PetriNetPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.impl.ElementImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementImpl extends EObjectImpl implements Element {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ElementImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return PetriNetPackage.Literals.ELEMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PetriNet getDiagram() {
        if (eContainerFeatureID() != PetriNetPackage.ELEMENT__DIAGRAM) return null;
        return (PetriNet)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDiagram(PetriNet newDiagram, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDiagram, PetriNetPackage.ELEMENT__DIAGRAM, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDiagram(PetriNet newDiagram) {
        if (newDiagram != eInternalContainer() || (eContainerFeatureID() != PetriNetPackage.ELEMENT__DIAGRAM && newDiagram != null)) {
            if (EcoreUtil.isAncestor(this, newDiagram))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDiagram != null)
                msgs = ((InternalEObject)newDiagram).eInverseAdd(this, PetriNetPackage.PETRI_NET__ELEMENTS, PetriNet.class, msgs);
            msgs = basicSetDiagram(newDiagram, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.ELEMENT__DIAGRAM, newDiagram, newDiagram));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case PetriNetPackage.ELEMENT__DIAGRAM:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDiagram((PetriNet)otherEnd, msgs);
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
            case PetriNetPackage.ELEMENT__DIAGRAM:
                return basicSetDiagram(null, msgs);
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
            case PetriNetPackage.ELEMENT__DIAGRAM:
                return eInternalContainer().eInverseRemove(this, PetriNetPackage.PETRI_NET__ELEMENTS, PetriNet.class, msgs);
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
            case PetriNetPackage.ELEMENT__DIAGRAM:
                return getDiagram();
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
            case PetriNetPackage.ELEMENT__DIAGRAM:
                setDiagram((PetriNet)newValue);
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
            case PetriNetPackage.ELEMENT__DIAGRAM:
                setDiagram((PetriNet)null);
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
            case PetriNetPackage.ELEMENT__DIAGRAM:
                return getDiagram() != null;
        }
        return super.eIsSet(featureID);
    }

} //ElementImpl
