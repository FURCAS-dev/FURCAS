/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMDerivator;
import behavioral.status_and_action_old.SAMDerivatorKindEnum;
import behavioral.status_and_action_old.SAMSchemaDerivator;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

import data.classes.ClassesPackage;
import data.classes.SapClass;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAM Derivator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMDerivatorImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMDerivatorImpl#getBusinessObject <em>Business Object</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMDerivatorImpl#getSamSchemaDerivators <em>Sam Schema Derivators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMDerivatorImpl extends EObjectImpl implements SAMDerivator {
	/**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final SAMDerivatorKindEnum KIND_EDEFAULT = SAMDerivatorKindEnum.POPULATION;

	/**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected SAMDerivatorKindEnum kind = KIND_EDEFAULT;

	/**
     * The cached value of the '{@link #getSamSchemaDerivators() <em>Sam Schema Derivators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaDerivators()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaDerivator> samSchemaDerivators;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMDerivatorImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_DERIVATOR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMDerivatorKindEnum getKind() {
        return kind;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKind(SAMDerivatorKindEnum newKind) {
        SAMDerivatorKindEnum oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_DERIVATOR__KIND, oldKind, kind));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getBusinessObject() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetBusinessObject() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBusinessObject(SapClass newBusinessObject, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newBusinessObject, Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBusinessObject(SapClass newBusinessObject) {
        if (newBusinessObject != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT && newBusinessObject != null)) {
            if (EcoreUtil.isAncestor(this, newBusinessObject))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBusinessObject != null)
                msgs = ((InternalEObject)newBusinessObject).eInverseAdd(this, ClassesPackage.SAP_CLASS__SAM_DERIVATORS, SapClass.class, msgs);
            msgs = basicSetBusinessObject(newBusinessObject, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT, newBusinessObject, newBusinessObject));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaDerivator> getSamSchemaDerivators() {
        if (samSchemaDerivators == null) {
            samSchemaDerivators = new EObjectWithInverseResolvingEList<SAMSchemaDerivator>(SAMSchemaDerivator.class, this, Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR);
        }
        return samSchemaDerivators;
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBusinessObject((SapClass)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaDerivators()).basicAdd(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                return basicSetBusinessObject(null, msgs);
            case Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS:
                return ((InternalEList<?>)getSamSchemaDerivators()).basicRemove(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__SAM_DERIVATORS, SapClass.class, msgs);
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__KIND:
                return getKind();
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                if (resolve) return getBusinessObject();
                return basicGetBusinessObject();
            case Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS:
                return getSamSchemaDerivators();
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__KIND:
                setKind((SAMDerivatorKindEnum)newValue);
                return;
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                setBusinessObject((SapClass)newValue);
                return;
            case Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS:
                getSamSchemaDerivators().clear();
                getSamSchemaDerivators().addAll((Collection<? extends SAMSchemaDerivator>)newValue);
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                setBusinessObject((SapClass)null);
                return;
            case Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS:
                getSamSchemaDerivators().clear();
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
            case Status_and_action_oldPackage.SAM_DERIVATOR__KIND:
                return kind != KIND_EDEFAULT;
            case Status_and_action_oldPackage.SAM_DERIVATOR__BUSINESS_OBJECT:
                return basicGetBusinessObject() != null;
            case Status_and_action_oldPackage.SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS:
                return samSchemaDerivators != null && !samSchemaDerivators.isEmpty();
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
        result.append(" (kind: ");
        result.append(kind);
        result.append(')');
        return result.toString();
    }

} //SAMDerivatorImpl
