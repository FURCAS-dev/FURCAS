/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMSchemaVariable;
import behavioral.status_and_action_old.SAMStatusValue;
import behavioral.status_and_action_old.SAMStatusVariable;
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAM Status Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl#isIsAgentVariable <em>Is Agent Variable</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl#getBusinessObjectNode <em>Business Object Node</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl#getSamStatusValues <em>Sam Status Values</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl#getSamSchemaVariables <em>Sam Schema Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMStatusVariableImpl extends EObjectImpl implements SAMStatusVariable {
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
     * The default value of the '{@link #isIsAgentVariable() <em>Is Agent Variable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsAgentVariable()
     * @generated
     * @ordered
     */
	protected static final boolean IS_AGENT_VARIABLE_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsAgentVariable() <em>Is Agent Variable</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsAgentVariable()
     * @generated
     * @ordered
     */
	protected boolean isAgentVariable = IS_AGENT_VARIABLE_EDEFAULT;

	/**
     * The cached value of the '{@link #getSamStatusValues() <em>Sam Status Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamStatusValues()
     * @generated
     * @ordered
     */
	protected EList<SAMStatusValue> samStatusValues;

	/**
     * The cached value of the '{@link #getSamSchemaVariables() <em>Sam Schema Variables</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaVariables()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaVariable> samSchemaVariables;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SAMStatusVariableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_STATUS_VARIABLE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsAgentVariable() {
        return isAgentVariable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsAgentVariable(boolean newIsAgentVariable) {
        boolean oldIsAgentVariable = isAgentVariable;
        isAgentVariable = newIsAgentVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE, oldIsAgentVariable, isAgentVariable));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getBusinessObjectNode() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetBusinessObjectNode() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBusinessObjectNode(SapClass newBusinessObjectNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newBusinessObjectNode, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBusinessObjectNode(SapClass newBusinessObjectNode) {
        if (newBusinessObjectNode != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE && newBusinessObjectNode != null)) {
            if (EcoreUtil.isAncestor(this, newBusinessObjectNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBusinessObjectNode != null)
                msgs = ((InternalEObject)newBusinessObjectNode).eInverseAdd(this, ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES, SapClass.class, msgs);
            msgs = basicSetBusinessObjectNode(newBusinessObjectNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE, newBusinessObjectNode, newBusinessObjectNode));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMStatusValue> getSamStatusValues() {
        if (samStatusValues == null) {
            samStatusValues = new EObjectContainmentWithInverseEList.Resolving<SAMStatusValue>(SAMStatusValue.class, this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES, Status_and_action_oldPackage.SAM_STATUS_VALUE__SAM_STATUS_VARIABLE);
        }
        return samStatusValues;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaVariable> getSamSchemaVariables() {
        if (samSchemaVariables == null) {
            samSchemaVariables = new EObjectWithInverseResolvingEList<SAMSchemaVariable>(SAMSchemaVariable.class, this, Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE);
        }
        return samSchemaVariables;
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBusinessObjectNode((SapClass)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamStatusValues()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaVariables()).basicAdd(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                return basicSetBusinessObjectNode(null, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES:
                return ((InternalEList<?>)getSamStatusValues()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES:
                return ((InternalEList<?>)getSamSchemaVariables()).basicRemove(otherEnd, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES, SapClass.class, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__NAME:
                return getName();
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE:
                return isIsAgentVariable();
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                if (resolve) return getBusinessObjectNode();
                return basicGetBusinessObjectNode();
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES:
                return getSamStatusValues();
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES:
                return getSamSchemaVariables();
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__NAME:
                setName((String)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE:
                setIsAgentVariable((Boolean)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                setBusinessObjectNode((SapClass)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES:
                getSamStatusValues().clear();
                getSamStatusValues().addAll((Collection<? extends SAMStatusValue>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES:
                getSamSchemaVariables().clear();
                getSamSchemaVariables().addAll((Collection<? extends SAMSchemaVariable>)newValue);
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE:
                setIsAgentVariable(IS_AGENT_VARIABLE_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                setBusinessObjectNode((SapClass)null);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES:
                getSamStatusValues().clear();
                return;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES:
                getSamSchemaVariables().clear();
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
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE:
                return isAgentVariable != IS_AGENT_VARIABLE_EDEFAULT;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE:
                return basicGetBusinessObjectNode() != null;
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_STATUS_VALUES:
                return samStatusValues != null && !samStatusValues.isEmpty();
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES:
                return samSchemaVariables != null && !samSchemaVariables.isEmpty();
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
        result.append(", isAgentVariable: ");
        result.append(isAgentVariable);
        result.append(')');
        return result.toString();
    }

} //SAMStatusVariableImpl
