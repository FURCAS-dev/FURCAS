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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Petri Net</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.impl.PetriNetImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link de.hpi.sam.petriNet.impl.PetriNetImpl#getDiagramName <em>Diagram Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PetriNetImpl extends EObjectImpl implements PetriNet {
	/**
     * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElements()
     * @generated
     * @ordered
     */
	protected EList<Element> elements;

	/**
     * The default value of the '{@link #getDiagramName() <em>Diagram Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDiagramName()
     * @generated
     * @ordered
     */
	protected static final String DIAGRAM_NAME_EDEFAULT = "Petri Net 1.0";
	/**
     * The cached value of the '{@link #getDiagramName() <em>Diagram Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDiagramName()
     * @generated
     * @ordered
     */
	protected String diagramName = DIAGRAM_NAME_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PetriNetImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return PetriNetPackage.Literals.PETRI_NET;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Element> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentWithInverseEList<Element>(Element.class, this, PetriNetPackage.PETRI_NET__ELEMENTS, PetriNetPackage.ELEMENT__DIAGRAM);
        }
        return elements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getDiagramName() {
        return diagramName;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDiagramName(String newDiagramName) {
        String oldDiagramName = diagramName;
        diagramName = newDiagramName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PetriNetPackage.PETRI_NET__DIAGRAM_NAME, oldDiagramName, diagramName));
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
            case PetriNetPackage.PETRI_NET__ELEMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
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
            case PetriNetPackage.PETRI_NET__ELEMENTS:
                return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
            case PetriNetPackage.PETRI_NET__ELEMENTS:
                return getElements();
            case PetriNetPackage.PETRI_NET__DIAGRAM_NAME:
                return getDiagramName();
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
            case PetriNetPackage.PETRI_NET__ELEMENTS:
                getElements().clear();
                getElements().addAll((Collection<? extends Element>)newValue);
                return;
            case PetriNetPackage.PETRI_NET__DIAGRAM_NAME:
                setDiagramName((String)newValue);
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
            case PetriNetPackage.PETRI_NET__ELEMENTS:
                getElements().clear();
                return;
            case PetriNetPackage.PETRI_NET__DIAGRAM_NAME:
                setDiagramName(DIAGRAM_NAME_EDEFAULT);
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
            case PetriNetPackage.PETRI_NET__ELEMENTS:
                return elements != null && !elements.isEmpty();
            case PetriNetPackage.PETRI_NET__DIAGRAM_NAME:
                return DIAGRAM_NAME_EDEFAULT == null ? diagramName != null : !DIAGRAM_NAME_EDEFAULT.equals(diagramName);
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
        result.append(" (diagramName: ");
        result.append(diagramName);
        result.append(')');
        return result.toString();
    }

} //PetriNetImpl
