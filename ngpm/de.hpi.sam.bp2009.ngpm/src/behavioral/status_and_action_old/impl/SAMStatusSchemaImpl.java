/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMOperator;
import behavioral.status_and_action_old.SAMSchemaAction;
import behavioral.status_and_action_old.SAMSchemaDerivator;
import behavioral.status_and_action_old.SAMSchemaVariable;
import behavioral.status_and_action_old.SAMStatusSchema;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAM Status Schema</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl#getBusinessObjectNode <em>Business Object Node</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl#getSamOperators <em>Sam Operators</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl#getSamSchemaVariables <em>Sam Schema Variables</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl#getSamSchemaDerivators <em>Sam Schema Derivators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMStatusSchemaImpl extends EObjectImpl implements SAMStatusSchema {
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
     * The cached value of the '{@link #getSamOperators() <em>Sam Operators</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamOperators()
     * @generated
     * @ordered
     */
	protected EList<SAMOperator> samOperators;

	/**
     * The cached value of the '{@link #getSamSchemaVariables() <em>Sam Schema Variables</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaVariables()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaVariable> samSchemaVariables;

	/**
     * The cached value of the '{@link #getSamSchemaActions() <em>Sam Schema Actions</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSamSchemaActions()
     * @generated
     * @ordered
     */
	protected EList<SAMSchemaAction> samSchemaActions;

	/**
     * The cached value of the '{@link #getSamSchemaDerivators() <em>Sam Schema Derivators</em>}' containment reference list.
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
	protected SAMStatusSchemaImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_STATUS_SCHEMA;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getBusinessObjectNode() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetBusinessObjectNode() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBusinessObjectNode(SapClass newBusinessObjectNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newBusinessObjectNode, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBusinessObjectNode(SapClass newBusinessObjectNode) {
        if (newBusinessObjectNode != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE && newBusinessObjectNode != null)) {
            if (EcoreUtil.isAncestor(this, newBusinessObjectNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBusinessObjectNode != null)
                msgs = ((InternalEObject)newBusinessObjectNode).eInverseAdd(this, ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA, SapClass.class, msgs);
            msgs = basicSetBusinessObjectNode(newBusinessObjectNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE, newBusinessObjectNode, newBusinessObjectNode));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMOperator> getSamOperators() {
        if (samOperators == null) {
            samOperators = new EObjectContainmentWithInverseEList.Resolving<SAMOperator>(SAMOperator.class, this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS, Status_and_action_oldPackage.SAM_OPERATOR__SAM_STATUS_SCHEMA);
        }
        return samOperators;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaVariable> getSamSchemaVariables() {
        if (samSchemaVariables == null) {
            samSchemaVariables = new EObjectContainmentWithInverseEList.Resolving<SAMSchemaVariable>(SAMSchemaVariable.class, this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES, Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA);
        }
        return samSchemaVariables;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaAction> getSamSchemaActions() {
        if (samSchemaActions == null) {
            samSchemaActions = new EObjectContainmentWithInverseEList.Resolving<SAMSchemaAction>(SAMSchemaAction.class, this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA);
        }
        return samSchemaActions;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaDerivator> getSamSchemaDerivators() {
        if (samSchemaDerivators == null) {
            samSchemaDerivators = new EObjectContainmentWithInverseEList.Resolving<SAMSchemaDerivator>(SAMSchemaDerivator.class, this, Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS, Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA);
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBusinessObjectNode((SapClass)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamOperators()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaVariables()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSamSchemaActions()).basicAdd(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS:
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                return basicSetBusinessObjectNode(null, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS:
                return ((InternalEList<?>)getSamOperators()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES:
                return ((InternalEList<?>)getSamSchemaVariables()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS:
                return ((InternalEList<?>)getSamSchemaActions()).basicRemove(otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS:
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA, SapClass.class, msgs);
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__NAME:
                return getName();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                if (resolve) return getBusinessObjectNode();
                return basicGetBusinessObjectNode();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS:
                return getSamOperators();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES:
                return getSamSchemaVariables();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS:
                return getSamSchemaActions();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS:
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__NAME:
                setName((String)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                setBusinessObjectNode((SapClass)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS:
                getSamOperators().clear();
                getSamOperators().addAll((Collection<? extends SAMOperator>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES:
                getSamSchemaVariables().clear();
                getSamSchemaVariables().addAll((Collection<? extends SAMSchemaVariable>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS:
                getSamSchemaActions().clear();
                getSamSchemaActions().addAll((Collection<? extends SAMSchemaAction>)newValue);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS:
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                setBusinessObjectNode((SapClass)null);
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS:
                getSamOperators().clear();
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES:
                getSamSchemaVariables().clear();
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS:
                getSamSchemaActions().clear();
                return;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS:
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
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE:
                return basicGetBusinessObjectNode() != null;
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_OPERATORS:
                return samOperators != null && !samOperators.isEmpty();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES:
                return samSchemaVariables != null && !samSchemaVariables.isEmpty();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS:
                return samSchemaActions != null && !samSchemaActions.isEmpty();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS:
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //SAMStatusSchemaImpl
