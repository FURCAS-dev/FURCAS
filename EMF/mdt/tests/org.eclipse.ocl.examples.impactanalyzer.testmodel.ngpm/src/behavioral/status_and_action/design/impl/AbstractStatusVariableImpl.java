/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractStatusVariableImpl.java,v 1.1 2011/02/07 17:17:57 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.AbstractStatusValue;
import behavioral.status_and_action.design.AbstractStatusVariable;
import behavioral.status_and_action.design.DesignPackage;

import java.util.Collection;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Status Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractStatusVariableImpl#isIsAgent <em>Is Agent</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractStatusVariableImpl#isIsStateGuarded <em>Is State Guarded</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractStatusVariableImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractStatusVariableImpl extends NamedElementImpl implements AbstractStatusVariable {
	/**
     * The default value of the '{@link #isIsAgent() <em>Is Agent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsAgent()
     * @generated
     * @ordered
     */
	protected static final boolean IS_AGENT_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsAgent() <em>Is Agent</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsAgent()
     * @generated
     * @ordered
     */
	protected boolean isAgent = IS_AGENT_EDEFAULT;

	/**
     * The default value of the '{@link #isIsStateGuarded() <em>Is State Guarded</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsStateGuarded()
     * @generated
     * @ordered
     */
	protected static final boolean IS_STATE_GUARDED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsStateGuarded() <em>Is State Guarded</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsStateGuarded()
     * @generated
     * @ordered
     */
	protected boolean isStateGuarded = IS_STATE_GUARDED_EDEFAULT;

	/**
     * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
	protected EList<AbstractStatusValue> values;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AbstractStatusVariableImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.ABSTRACT_STATUS_VARIABLE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsAgent() {
        return isAgent;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsAgent(boolean newIsAgent) {
        boolean oldIsAgent = isAgent;
        isAgent = newIsAgent;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_AGENT, oldIsAgent, isAgent));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsStateGuarded() {
        return isStateGuarded;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsStateGuarded(boolean newIsStateGuarded) {
        boolean oldIsStateGuarded = isStateGuarded;
        isStateGuarded = newIsStateGuarded;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED, oldIsStateGuarded, isStateGuarded));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<AbstractStatusValue> getValues() {
        if (values == null) {
            values = new EObjectContainmentEList.Resolving<AbstractStatusValue>(AbstractStatusValue.class, this, DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES);
        }
        return values;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES:
                return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_AGENT:
                return isIsAgent();
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED:
                return isIsStateGuarded();
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES:
                return getValues();
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
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_AGENT:
                setIsAgent((Boolean)newValue);
                return;
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED:
                setIsStateGuarded((Boolean)newValue);
                return;
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES:
                getValues().clear();
                getValues().addAll((Collection<? extends AbstractStatusValue>)newValue);
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
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_AGENT:
                setIsAgent(IS_AGENT_EDEFAULT);
                return;
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED:
                setIsStateGuarded(IS_STATE_GUARDED_EDEFAULT);
                return;
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES:
                getValues().clear();
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
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_AGENT:
                return isAgent != IS_AGENT_EDEFAULT;
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED:
                return isStateGuarded != IS_STATE_GUARDED_EDEFAULT;
            case DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES:
                return values != null && !values.isEmpty();
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
        result.append(" (isAgent: ");
        result.append(isAgent);
        result.append(", isStateGuarded: ");
        result.append(isStateGuarded);
        result.append(')');
        return result.toString();
    }

} //AbstractStatusVariableImpl
