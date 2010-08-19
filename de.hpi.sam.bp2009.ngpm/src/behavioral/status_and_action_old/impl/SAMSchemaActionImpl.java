/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMAction;
import behavioral.status_and_action_old.SAMOperator;
import behavioral.status_and_action_old.SAMSchemaAction;
import behavioral.status_and_action_old.SAMSchemaValue;
import behavioral.status_and_action_old.SAMStatusSchema;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

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
 * An implementation of the model object '<em><b>SAM Schema Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl#getSamAction <em>Sam Action</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl#getSamSchemaValues <em>Sam Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl#getSamSchemaOperators <em>Sam Schema Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMSchemaActionImpl extends EObjectImpl implements SAMSchemaAction {
	/**
     * The cached value of the '{@link #getSamAction() <em>Sam Action</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamAction()
     * @generated
     * @ordered
     */
	protected SAMAction samAction;

	/**
     * The cached value of the '{@link #getSamTargetSchemaValues() <em>Sam Target Schema Values</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamTargetSchemaValues()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaValue> samTargetSchemaValues;

	/**
     * The cached value of the '{@link #getSamSchemaValues() <em>Sam Schema Values</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaValues()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaValue> samSchemaValues;

	/**
     * The cached value of the '{@link #getSamSchemaOperators() <em>Sam Schema Operators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaOperators()
     * @generated
     * @ordered
     */
	protected EList<SAMOperator> samSchemaOperators;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMSchemaActionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_SCHEMA_ACTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusSchema getSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SAMStatusSchema basicGetSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamStatusSchema(SAMStatusSchema newSamStatusSchema, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSamStatusSchema, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamStatusSchema(SAMStatusSchema newSamStatusSchema) {
        if (newSamStatusSchema != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA && newSamStatusSchema != null)) {
            if (EcoreUtil.isAncestor(this, newSamStatusSchema))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSamStatusSchema != null)
                msgs = ((InternalEObject)newSamStatusSchema).eInverseAdd(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS, SAMStatusSchema.class, msgs);
            msgs = basicSetSamStatusSchema(newSamStatusSchema, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA, newSamStatusSchema, newSamStatusSchema));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMAction getSamAction() {
        if (samAction != null && samAction.eIsProxy()) {
            InternalEObject oldSamAction = (InternalEObject)samAction;
            samAction = (SAMAction)eResolveProxy(oldSamAction);
            if (samAction != oldSamAction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION, oldSamAction, samAction));
            }
        }
        return samAction;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMAction basicGetSamAction() {
        return samAction;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamAction(SAMAction newSamAction, NotificationChain msgs) {
        SAMAction oldSamAction = samAction;
        samAction = newSamAction;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION, oldSamAction, newSamAction);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamAction(SAMAction newSamAction) {
        if (newSamAction != samAction) {
            NotificationChain msgs = null;
            if (samAction != null)
                msgs = ((InternalEObject)samAction).eInverseRemove(this, Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS, SAMAction.class, msgs);
            if (newSamAction != null)
                msgs = ((InternalEObject)newSamAction).eInverseAdd(this, Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS, SAMAction.class, msgs);
            msgs = basicSetSamAction(newSamAction, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION, newSamAction, newSamAction));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaValue> getSamTargetSchemaValues() {
        if (samTargetSchemaValues == null) {
            samTargetSchemaValues = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaValue>(SAMSchemaValue.class, this, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS);
        }
        return samTargetSchemaValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaValue> getSamSchemaValues() {
        if (samSchemaValues == null) {
            samSchemaValues = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaValue>(SAMSchemaValue.class, this, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS);
        }
        return samSchemaValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMOperator> getSamSchemaOperators() {
        if (samSchemaOperators == null) {
            samSchemaOperators = new EObjectWithInverseResolvingEList.ManyInverse<SAMOperator>(SAMOperator.class, this, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS, Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS);
        }
        return samSchemaOperators;
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSamStatusSchema((SAMStatusSchema)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION:
                if (samAction != null)
                    msgs = ((InternalEObject)samAction).eInverseRemove(this, Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS, SAMAction.class, msgs);
                return basicSetSamAction((SAMAction)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamTargetSchemaValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaOperators()).basicAdd(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                return basicSetSamStatusSchema(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION:
                return basicSetSamAction(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES:
                return ((InternalEList<?>)getSamTargetSchemaValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES:
                return ((InternalEList<?>)getSamSchemaValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS:
                return ((InternalEList<?>)getSamSchemaOperators()).basicRemove(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                return eInternalContainer().eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS, SAMStatusSchema.class, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                if (resolve) return getSamStatusSchema();
                return basicGetSamStatusSchema();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION:
                if (resolve) return getSamAction();
                return basicGetSamAction();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES:
                return getSamTargetSchemaValues();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES:
                return getSamSchemaValues();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS:
                return getSamSchemaOperators();
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION:
                setSamAction((SAMAction)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES:
                getSamTargetSchemaValues().clear();
                getSamTargetSchemaValues().addAll((Collection<? extends SAMSchemaValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES:
                getSamSchemaValues().clear();
                getSamSchemaValues().addAll((Collection<? extends SAMSchemaValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS:
                getSamSchemaOperators().clear();
                getSamSchemaOperators().addAll((Collection<? extends SAMOperator>)newValue);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION:
                setSamAction((SAMAction)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES:
                getSamTargetSchemaValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES:
                getSamSchemaValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS:
                getSamSchemaOperators().clear();
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
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA:
                return basicGetSamStatusSchema() != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION:
                return samAction != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES:
                return samTargetSchemaValues != null && !samTargetSchemaValues.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES:
                return samSchemaValues != null && !samSchemaValues.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS:
                return samSchemaOperators != null && !samSchemaOperators.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SAMSchemaActionImpl
