/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMSchemaVariableImpl.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMSchemaDerivator;
import behavioral.status_and_action_old.SAMSchemaValue;
import behavioral.status_and_action_old.SAMSchemaVariable;
import behavioral.status_and_action_old.SAMStatusSchema;
import behavioral.status_and_action_old.SAMStatusVariable;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAM Schema Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl#isHasStateGuard <em>Has State Guard</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl#getSamSchemaValues <em>Sam Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl#getSamSchemaValue <em>Sam Schema Value</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl#getSamTargetSchemaDerivators <em>Sam Target Schema Derivators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl#getSamSourceSchemaDerivators <em>Sam Source Schema Derivators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMSchemaVariableImpl extends EObjectImpl implements SAMSchemaVariable {
	/**
     * The default value of the '{@link #isHasStateGuard() <em>Has State Guard</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isHasStateGuard()
     * @generated
     * @ordered
     */
	protected static final boolean HAS_STATE_GUARD_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isHasStateGuard() <em>Has State Guard</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isHasStateGuard()
     * @generated
     * @ordered
     */
	protected boolean hasStateGuard = HAS_STATE_GUARD_EDEFAULT;

	/**
     * The cached value of the '{@link #getSamSchemaValues() <em>Sam Schema Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaValues()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaValue> samSchemaValues;

	/**
     * The cached value of the '{@link #getSamSchemaValue() <em>Sam Schema Value</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaValue()
     * @generated
     * @ordered
     */
	protected SAMStatusVariable samSchemaValue;

	/**
     * The cached value of the '{@link #getSamTargetSchemaDerivators() <em>Sam Target Schema Derivators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamTargetSchemaDerivators()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaDerivator> samTargetSchemaDerivators;

	/**
     * The cached value of the '{@link #getSamSourceSchemaDerivators() <em>Sam Source Schema Derivators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSourceSchemaDerivators()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaDerivator> samSourceSchemaDerivators;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMSchemaVariableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_SCHEMA_VARIABLE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isHasStateGuard() {
        return hasStateGuard;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setHasStateGuard(boolean newHasStateGuard) {
        boolean oldHasStateGuard = hasStateGuard;
        hasStateGuard = newHasStateGuard;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD, oldHasStateGuard, hasStateGuard));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusSchema getSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SAMStatusSchema basicGetSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamStatusSchema(SAMStatusSchema newSamStatusSchema, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSamStatusSchema, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamStatusSchema(SAMStatusSchema newSamStatusSchema) {
        if (newSamStatusSchema != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA && newSamStatusSchema != null)) {
            if (EcoreUtil.isAncestor(this, newSamStatusSchema))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSamStatusSchema != null)
                msgs = ((InternalEObject)newSamStatusSchema).eInverseAdd(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES, SAMStatusSchema.class, msgs);
            msgs = basicSetSamStatusSchema(newSamStatusSchema, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA, newSamStatusSchema, newSamStatusSchema));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaValue> getSamSchemaValues() {
        if (samSchemaValues == null) {
            samSchemaValues = new EObjectContainmentWithInverseEList.Resolving<SAMSchemaValue>(SAMSchemaValue.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE);
        }
        return samSchemaValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusVariable getSamSchemaValue() {
        if (samSchemaValue != null && samSchemaValue.eIsProxy()) {
            InternalEObject oldSamSchemaValue = (InternalEObject)samSchemaValue;
            samSchemaValue = (SAMStatusVariable)eResolveProxy(oldSamSchemaValue);
            if (samSchemaValue != oldSamSchemaValue) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE, oldSamSchemaValue, samSchemaValue));
            }
        }
        return samSchemaValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusVariable basicGetSamSchemaValue() {
        return samSchemaValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamSchemaValue(SAMStatusVariable newSamSchemaValue, NotificationChain msgs) {
        SAMStatusVariable oldSamSchemaValue = samSchemaValue;
        samSchemaValue = newSamSchemaValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE, oldSamSchemaValue, newSamSchemaValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamSchemaValue(SAMStatusVariable newSamSchemaValue) {
        if (newSamSchemaValue != samSchemaValue) {
            NotificationChain msgs = null;
            if (samSchemaValue != null)
                msgs = ((InternalEObject)samSchemaValue).eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES, SAMStatusVariable.class, msgs);
            if (newSamSchemaValue != null)
                msgs = ((InternalEObject)newSamSchemaValue).eInverseAdd(this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES, SAMStatusVariable.class, msgs);
            msgs = basicSetSamSchemaValue(newSamSchemaValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE, newSamSchemaValue, newSamSchemaValue));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaDerivator> getSamTargetSchemaDerivators() {
        if (samTargetSchemaDerivators == null) {
            samTargetSchemaDerivators = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaDerivator>(SAMSchemaDerivator.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES);
        }
        return samTargetSchemaDerivators;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaDerivator> getSamSourceSchemaDerivators() {
        if (samSourceSchemaDerivators == null) {
            samSourceSchemaDerivators = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaDerivator>(SAMSchemaDerivator.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE);
        }
        return samSourceSchemaDerivators;
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSamStatusSchema((SAMStatusSchema)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE:
                if (samSchemaValue != null)
                    msgs = ((InternalEObject)samSchemaValue).eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES, SAMStatusVariable.class, msgs);
                return basicSetSamSchemaValue((SAMStatusVariable)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamTargetSchemaDerivators()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSourceSchemaDerivators()).basicAdd(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                return basicSetSamStatusSchema(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES:
                return ((InternalEList<?>)getSamSchemaValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE:
                return basicSetSamSchemaValue(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS:
                return ((InternalEList<?>)getSamTargetSchemaDerivators()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS:
                return ((InternalEList<?>)getSamSourceSchemaDerivators()).basicRemove(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                return eInternalContainer().eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES, SAMStatusSchema.class, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD:
                return isHasStateGuard();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                if (resolve) return getSamStatusSchema();
                return basicGetSamStatusSchema();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES:
                return getSamSchemaValues();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE:
                if (resolve) return getSamSchemaValue();
                return basicGetSamSchemaValue();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS:
                return getSamTargetSchemaDerivators();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS:
                return getSamSourceSchemaDerivators();
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD:
                setHasStateGuard((Boolean)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES:
                getSamSchemaValues().clear();
                getSamSchemaValues().addAll((Collection<? extends SAMSchemaValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE:
                setSamSchemaValue((SAMStatusVariable)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS:
                getSamTargetSchemaDerivators().clear();
                getSamTargetSchemaDerivators().addAll((Collection<? extends SAMSchemaDerivator>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS:
                getSamSourceSchemaDerivators().clear();
                getSamSourceSchemaDerivators().addAll((Collection<? extends SAMSchemaDerivator>)newValue);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD:
                setHasStateGuard(HAS_STATE_GUARD_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES:
                getSamSchemaValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE:
                setSamSchemaValue((SAMStatusVariable)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS:
                getSamTargetSchemaDerivators().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS:
                getSamSourceSchemaDerivators().clear();
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD:
                return hasStateGuard != HAS_STATE_GUARD_EDEFAULT;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA:
                return basicGetSamStatusSchema() != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES:
                return samSchemaValues != null && !samSchemaValues.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE:
                return samSchemaValue != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS:
                return samTargetSchemaDerivators != null && !samTargetSchemaDerivators.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS:
                return samSourceSchemaDerivators != null && !samSourceSchemaDerivators.isEmpty();
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
        result.append(" (hasStateGuard: ");
        result.append(hasStateGuard);
        result.append(')');
        return result.toString();
    }

} //SAMSchemaVariableImpl
