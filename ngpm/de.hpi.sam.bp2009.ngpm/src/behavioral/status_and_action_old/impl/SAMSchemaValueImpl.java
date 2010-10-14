/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMOperator;
import behavioral.status_and_action_old.SAMSchemaAction;
import behavioral.status_and_action_old.SAMSchemaValue;
import behavioral.status_and_action_old.SAMSchemaVariable;
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
 * An implementation of the model object '<em><b>SAM Schema Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#isIsInhibiting <em>Is Inhibiting</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#getSamSchemaVariable <em>Sam Schema Variable</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#getSamSourceSchemaActions <em>Sam Source Schema Actions</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#getSamSourceSchemaValues <em>Sam Source Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#getSamOperators <em>Sam Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMSchemaValueImpl extends EObjectImpl implements SAMSchemaValue {
	/**
     * The default value of the '{@link #isIsInitial() <em>Is Initial</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsInitial()
     * @generated
     * @ordered
     */
	protected static final boolean IS_INITIAL_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsInitial() <em>Is Initial</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsInitial()
     * @generated
     * @ordered
     */
	protected boolean isInitial = IS_INITIAL_EDEFAULT;

	/**
     * The default value of the '{@link #isIsInhibiting() <em>Is Inhibiting</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsInhibiting()
     * @generated
     * @ordered
     */
	protected static final boolean IS_INHIBITING_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsInhibiting() <em>Is Inhibiting</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsInhibiting()
     * @generated
     * @ordered
     */
	protected boolean isInhibiting = IS_INHIBITING_EDEFAULT;

	/**
     * The cached value of the '{@link #getSamSourceSchemaActions() <em>Sam Source Schema Actions</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSourceSchemaActions()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaAction> samSourceSchemaActions;

	/**
     * The cached value of the '{@link #getSamSourceSchemaValues() <em>Sam Source Schema Values</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSourceSchemaValues()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaValue> samSourceSchemaValues;

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
     * The cached value of the '{@link #getSamOperators() <em>Sam Operators</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamOperators()
     * @generated
     * @ordered
     */
	protected EList<SAMOperator> samOperators;

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
	protected SAMSchemaValueImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_SCHEMA_VALUE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsInitial() {
        return isInitial;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsInitial(boolean newIsInitial) {
        boolean oldIsInitial = isInitial;
        isInitial = newIsInitial;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INITIAL, oldIsInitial, isInitial));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsInhibiting() {
        return isInhibiting;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsInhibiting(boolean newIsInhibiting) {
        boolean oldIsInhibiting = isInhibiting;
        isInhibiting = newIsInhibiting;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INHIBITING, oldIsInhibiting, isInhibiting));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMSchemaVariable getSamSchemaVariable() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE) return null;
        return (SAMSchemaVariable)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SAMSchemaVariable basicGetSamSchemaVariable() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE) return null;
        return (SAMSchemaVariable)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSamSchemaVariable(SAMSchemaVariable newSamSchemaVariable, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSamSchemaVariable, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSamSchemaVariable(SAMSchemaVariable newSamSchemaVariable) {
        if (newSamSchemaVariable != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE && newSamSchemaVariable != null)) {
            if (EcoreUtil.isAncestor(this, newSamSchemaVariable))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSamSchemaVariable != null)
                msgs = ((InternalEObject)newSamSchemaVariable).eInverseAdd(this, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES, SAMSchemaVariable.class, msgs);
            msgs = basicSetSamSchemaVariable(newSamSchemaVariable, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE, newSamSchemaVariable, newSamSchemaVariable));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaAction> getSamSourceSchemaActions() {
        if (samSourceSchemaActions == null) {
            samSourceSchemaActions = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaAction>(SAMSchemaAction.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES);
        }
        return samSourceSchemaActions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaValue> getSamSourceSchemaValues() {
        if (samSourceSchemaValues == null) {
            samSourceSchemaValues = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaValue>(SAMSchemaValue.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES);
        }
        return samSourceSchemaValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaValue> getSamTargetSchemaValues() {
        if (samTargetSchemaValues == null) {
            samTargetSchemaValues = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaValue>(SAMSchemaValue.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES);
        }
        return samTargetSchemaValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMOperator> getSamOperators() {
        if (samOperators == null) {
            samOperators = new EObjectWithInverseResolvingEList.ManyInverse<SAMOperator>(SAMOperator.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS, Status_and_action_oldPackage.SAM_OPERATOR__SAM_SCHEMA_VALUES);
        }
        return samOperators;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaAction> getSamSchemaActions() {
        if (samSchemaActions == null) {
            samSchemaActions = new EObjectWithInverseResolvingEList.ManyInverse<SAMSchemaAction>(SAMSchemaAction.class, this, Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSamSchemaVariable((SAMSchemaVariable)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSourceSchemaActions()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSourceSchemaValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamTargetSchemaValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamOperators()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                return basicSetSamSchemaVariable(null, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS:
                return ((InternalEList<?>)getSamSourceSchemaActions()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES:
                return ((InternalEList<?>)getSamSourceSchemaValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES:
                return ((InternalEList<?>)getSamTargetSchemaValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS:
                return ((InternalEList<?>)getSamOperators()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                return eInternalContainer().eInverseRemove(this, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES, SAMSchemaVariable.class, msgs);
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INITIAL:
                return isIsInitial();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INHIBITING:
                return isIsInhibiting();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                if (resolve) return getSamSchemaVariable();
                return basicGetSamSchemaVariable();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS:
                return getSamSourceSchemaActions();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES:
                return getSamSourceSchemaValues();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES:
                return getSamTargetSchemaValues();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS:
                return getSamOperators();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INITIAL:
                setIsInitial((Boolean)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INHIBITING:
                setIsInhibiting((Boolean)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                setSamSchemaVariable((SAMSchemaVariable)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS:
                getSamSourceSchemaActions().clear();
                getSamSourceSchemaActions().addAll((Collection<? extends SAMSchemaAction>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES:
                getSamSourceSchemaValues().clear();
                getSamSourceSchemaValues().addAll((Collection<? extends SAMSchemaValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES:
                getSamTargetSchemaValues().clear();
                getSamTargetSchemaValues().addAll((Collection<? extends SAMSchemaValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS:
                getSamOperators().clear();
                getSamOperators().addAll((Collection<? extends SAMOperator>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INITIAL:
                setIsInitial(IS_INITIAL_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INHIBITING:
                setIsInhibiting(IS_INHIBITING_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                setSamSchemaVariable((SAMSchemaVariable)null);
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS:
                getSamSourceSchemaActions().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES:
                getSamSourceSchemaValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES:
                getSamTargetSchemaValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS:
                getSamOperators().clear();
                return;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INITIAL:
                return isInitial != IS_INITIAL_EDEFAULT;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__IS_INHIBITING:
                return isInhibiting != IS_INHIBITING_EDEFAULT;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE:
                return basicGetSamSchemaVariable() != null;
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS:
                return samSourceSchemaActions != null && !samSourceSchemaActions.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES:
                return samSourceSchemaValues != null && !samSourceSchemaValues.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES:
                return samTargetSchemaValues != null && !samTargetSchemaValues.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_OPERATORS:
                return samOperators != null && !samOperators.isEmpty();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS:
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
        result.append(" (isInitial: ");
        result.append(isInitial);
        result.append(", isInhibiting: ");
        result.append(isInhibiting);
        result.append(')');
        return result.toString();
    }

} //SAMSchemaValueImpl
