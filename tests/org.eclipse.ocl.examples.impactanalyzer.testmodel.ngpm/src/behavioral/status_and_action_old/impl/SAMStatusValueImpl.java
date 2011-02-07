/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMStatusValueImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMStatusValue;
import behavioral.status_and_action_old.SAMStatusVariable;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAM Status Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusValueImpl#getSamStatusVariable <em>Sam Status Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMStatusValueImpl extends EObjectImpl implements SAMStatusValue {
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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMStatusValueImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_STATUS_VALUE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_VALUE__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusVariable getSamStatusVariable() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE) return null;
        return (SAMStatusVariable)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SAMStatusVariable basicGetSamStatusVariable() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE) return null;
        return (SAMStatusVariable)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamStatusVariable(SAMStatusVariable newSamStatusVariable, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSamStatusVariable, Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamStatusVariable(SAMStatusVariable newSamStatusVariable) {
        if (newSamStatusVariable != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE && newSamStatusVariable != null)) {
            if (EcoreUtil.isAncestor(this, newSamStatusVariable))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSamStatusVariable != null)
                msgs = ((InternalEObject)newSamStatusVariable).eInverseAdd(this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES, SAMStatusVariable.class, msgs);
            msgs = basicSetSamStatusVariable(newSamStatusVariable, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE, newSamStatusVariable, newSamStatusVariable));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSamStatusVariable((SAMStatusVariable)otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                return basicSetSamStatusVariable(null, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                return eInternalContainer().eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES, SAMStatusVariable.class, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__NAME:
                return getName();
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                if (resolve) return getSamStatusVariable();
                return basicGetSamStatusVariable();
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
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__NAME:
                setName((String)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                setSamStatusVariable((SAMStatusVariable)newValue);
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
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                setSamStatusVariable((SAMStatusVariable)null);
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
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE:
                return basicGetSamStatusVariable() != null;
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

} //SAMStatusValueImpl
