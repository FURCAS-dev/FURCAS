/**
 * <copyright>
 * </copyright>
 *
 * $Id: SAMActionImpl.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.SAMAction;
import behavioral.status_and_action_old.SAMSchemaAction;
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
 * An implementation of the model object '<em><b>SAM Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMActionImpl#isIsAgentAction <em>Is Agent Action</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMActionImpl#getBusinessObjectNode <em>Business Object Node</em>}</li>
 *   <li>{@link behavioral.status_and_action_old.impl.SAMActionImpl#getSamSchemaActions <em>Sam Schema Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAMActionImpl extends EObjectImpl implements SAMAction {
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
     * The default value of the '{@link #isIsAgentAction() <em>Is Agent Action</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsAgentAction()
     * @generated
     * @ordered
     */
	protected static final boolean IS_AGENT_ACTION_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsAgentAction() <em>Is Agent Action</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsAgentAction()
     * @generated
     * @ordered
     */
	protected boolean isAgentAction = IS_AGENT_ACTION_EDEFAULT;

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
	protected SAMActionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return Status_and_action_oldPackage.Literals.SAM_ACTION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_ACTION__NAME, oldName, name));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsAgentAction() {
        return isAgentAction;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsAgentAction(boolean newIsAgentAction) {
        boolean oldIsAgentAction = isAgentAction;
        isAgentAction = newIsAgentAction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_ACTION__IS_AGENT_ACTION, oldIsAgentAction, isAgentAction));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SapClass getBusinessObjectNode() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE) return null;
        return (SapClass)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SapClass basicGetBusinessObjectNode() {
        if (eContainerFeatureID() != Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE) return null;
        return (SapClass)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBusinessObjectNode(SapClass newBusinessObjectNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newBusinessObjectNode, Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBusinessObjectNode(SapClass newBusinessObjectNode) {
        if (newBusinessObjectNode != eInternalContainer() || (eContainerFeatureID() != Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE && newBusinessObjectNode != null)) {
            if (EcoreUtil.isAncestor(this, newBusinessObjectNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBusinessObjectNode != null)
                msgs = ((InternalEObject)newBusinessObjectNode).eInverseAdd(this, ClassesPackage.SAP_CLASS__SAM_ACTIONS, SapClass.class, msgs);
            msgs = basicSetBusinessObjectNode(newBusinessObjectNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE, newBusinessObjectNode, newBusinessObjectNode));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SAMSchemaAction> getSamSchemaActions() {
        if (samSchemaActions == null) {
            samSchemaActions = new EObjectWithInverseResolvingEList<SAMSchemaAction>(SAMSchemaAction.class, this, Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS, Status_and_action_oldPackage.SAM_SCHEMA_ACTION__SAM_ACTION);
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
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBusinessObjectNode((SapClass)otherEnd, msgs);
            case Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                return basicSetBusinessObjectNode(null, msgs);
            case Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                return eInternalContainer().eInverseRemove(this, ClassesPackage.SAP_CLASS__SAM_ACTIONS, SapClass.class, msgs);
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
            case Status_and_action_oldPackage.SAM_ACTION__NAME:
                return getName();
            case Status_and_action_oldPackage.SAM_ACTION__IS_AGENT_ACTION:
                return isIsAgentAction();
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                if (resolve) return getBusinessObjectNode();
                return basicGetBusinessObjectNode();
            case Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_ACTION__NAME:
                setName((String)newValue);
                return;
            case Status_and_action_oldPackage.SAM_ACTION__IS_AGENT_ACTION:
                setIsAgentAction((Boolean)newValue);
                return;
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                setBusinessObjectNode((SapClass)newValue);
                return;
            case Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_ACTION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_ACTION__IS_AGENT_ACTION:
                setIsAgentAction(IS_AGENT_ACTION_EDEFAULT);
                return;
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                setBusinessObjectNode((SapClass)null);
                return;
            case Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS:
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
            case Status_and_action_oldPackage.SAM_ACTION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case Status_and_action_oldPackage.SAM_ACTION__IS_AGENT_ACTION:
                return isAgentAction != IS_AGENT_ACTION_EDEFAULT;
            case Status_and_action_oldPackage.SAM_ACTION__BUSINESS_OBJECT_NODE:
                return basicGetBusinessObjectNode() != null;
            case Status_and_action_oldPackage.SAM_ACTION__SAM_SCHEMA_ACTIONS:
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
        result.append(" (name: ");
        result.append(name);
        result.append(", isAgentAction: ");
        result.append(isAgentAction);
        result.append(')');
        return result.toString();
    }

} //SAMActionImpl
