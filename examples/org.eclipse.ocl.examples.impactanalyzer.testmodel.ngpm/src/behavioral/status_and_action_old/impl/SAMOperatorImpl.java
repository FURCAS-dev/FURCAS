/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMOperatorImpl.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMOperator;
import behavioral.status_and_action_old.SAMOperatorKindEnum;
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
 * An implementation of the model object '<em><b>SAM Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMOperatorImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMOperatorImpl#getSamStatusSchema <em>Sam Status Schema</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMOperatorImpl#getSamSchemaValues <em>Sam Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMOperatorImpl#getSamSourceOperators <em>Sam Source Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMOperatorImpl#getSamTargetOperators <em>Sam Target Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMOperatorImpl#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMOperatorImpl extends EObjectImpl implements SAMOperator {
	/**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final SAMOperatorKindEnum KIND_EDEFAULT = SAMOperatorKindEnum.OR;

	/**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected SAMOperatorKindEnum kind = KIND_EDEFAULT;

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
     * The cached value of the '{@link #getSamSourceOperators() <em>Sam Source Operators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSourceOperators()
     * @generated
     * @ordered
     */
	protected EList<SAMOperator> samSourceOperators;

	/**
     * The cached value of the '{@link #getSamTargetOperators() <em>Sam Target Operators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamTargetOperators()
     * @generated
     * @ordered
     */
	protected EList<SAMOperator> samTargetOperators;

	/**
     * The cached value of the '{@link #getSamSchemaActions() <em>Sam Schema Actions</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaActions()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaAction> samSchemaActions;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMOperatorImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_OPERATOR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMOperatorKindEnum getKind() {
        return kind;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKind(SAMOperatorKindEnum newKind) {
        SAMOperatorKindEnum oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_OPERATOR__KIND, oldKind, kind));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusSchema getSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SAMStatusSchema basicGetSamStatusSchema() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA) return null;
        return (SAMStatusSchema)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamStatusSchema(SAMStatusSchema newSamStatusSchema, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSamStatusSchema, Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamStatusSchema(SAMStatusSchema newSamStatusSchema) {
        if (newSamStatusSchema != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA && newSamStatusSchema != null)) {
            if (EcoreUtil.isAncestor(this, newSamStatusSchema))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSamStatusSchema != null)
                msgs = ((InternalEObject)newSamStatusSchema).eInverseAdd(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS, SAMStatusSchema.class, msgs);
            msgs = basicSetSamStatusSchema(newSamStatusSchema, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA, newSamStatusSchema, newSamStatusSchema));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaValue> getSamSchemaValues() {
        if (samSchemaValues == null) {
            samSchemaValues = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaValue>(SAMSchemaValue.class, this, Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS);
        }
        return samSchemaValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMOperator> getSamSourceOperators() {
        if (samSourceOperators == null) {
            samSourceOperators = new EObjectWithInverseResolvingEList.ManyInverse<SAMOperator>(SAMOperator.class, this, Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS, Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS);
        }
        return samSourceOperators;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMOperator> getSamTargetOperators() {
        if (samTargetOperators == null) {
            samTargetOperators = new EObjectWithInverseResolvingEList.ManyInverse<SAMOperator>(SAMOperator.class, this, Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS, Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS);
        }
        return samTargetOperators;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaAction> getSamSchemaActions() {
        if (samSchemaActions == null) {
            samSchemaActions = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaAction>(SAMSchemaAction.class, this, Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS);
        }
        return samSchemaActions;
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
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSamStatusSchema((SAMStatusSchema)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSourceOperators()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamTargetOperators()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaActions()).basicAdd(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                return basicSetSamStatusSchema(null, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES:
                return ((InternalEList<?>)getSamSchemaValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS:
                return ((InternalEList<?>)getSamSourceOperators()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS:
                return ((InternalEList<?>)getSamTargetOperators()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS:
                return ((InternalEList<?>)getSamSchemaActions()).basicRemove(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                return eInternalContainer().eInverseRemove(this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS, SAMStatusSchema.class, msgs);
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
            case Status_and_action_oldPackage.SAM_OPERATOR__KIND:
                return getKind();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                if (resolve) return getSamStatusSchema();
                return basicGetSamStatusSchema();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES:
                return getSamSchemaValues();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS:
                return getSamSourceOperators();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS:
                return getSamTargetOperators();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS:
                return getSamSchemaActions();
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
            case Status_and_action_oldPackage.SAM_OPERATOR__KIND:
                setKind((SAMOperatorKindEnum)newValue);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)newValue);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES:
                getSamSchemaValues().clear();
                getSamSchemaValues().addAll((Collection<? extends SAMSchemaValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS:
                getSamSourceOperators().clear();
                getSamSourceOperators().addAll((Collection<? extends SAMOperator>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS:
                getSamTargetOperators().clear();
                getSamTargetOperators().addAll((Collection<? extends SAMOperator>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS:
                getSamSchemaActions().clear();
                getSamSchemaActions().addAll((Collection<? extends SAMSchemaAction>)newValue);
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
            case Status_and_action_oldPackage.SAM_OPERATOR__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                setSamStatusSchema((SAMStatusSchema)null);
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES:
                getSamSchemaValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS:
                getSamSourceOperators().clear();
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS:
                getSamTargetOperators().clear();
                return;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS:
                getSamSchemaActions().clear();
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
            case Status_and_action_oldPackage.SAM_OPERATOR__KIND:
                return kind != KIND_EDEFAULT;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA:
                return basicGetSamStatusSchema() != null;
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES:
                return samSchemaValues != null && !samSchemaValues.isEmpty();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SOURCE_OPERATORS:
                return samSourceOperators != null && !samSourceOperators.isEmpty();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_TARGET_OPERATORS:
                return samTargetOperators != null && !samTargetOperators.isEmpty();
            case Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_ACTIONS:
                return samSchemaActions != null && !samSchemaActions.isEmpty();
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

} //SAMOperatorImpl
