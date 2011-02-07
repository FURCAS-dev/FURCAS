/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractActionImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.AbstractAction;
import behavioral.status_and_action.design.DesignPackage;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractActionImpl#isIsAgent <em>Is Agent</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractActionImpl#isIsPreconditionFixed <em>Is Precondition Fixed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractActionImpl extends NamedElementImpl implements AbstractAction {
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
     * The default value of the '{@link #isIsPreconditionFixed() <em>Is Precondition Fixed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsPreconditionFixed()
     * @generated
     * @ordered
     */
	protected static final boolean IS_PRECONDITION_FIXED_EDEFAULT = false;

	/**
     * The cached value of the '{@link #isIsPreconditionFixed() <em>Is Precondition Fixed</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isIsPreconditionFixed()
     * @generated
     * @ordered
     */
	protected boolean isPreconditionFixed = IS_PRECONDITION_FIXED_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AbstractActionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.ABSTRACT_ACTION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_ACTION__IS_AGENT, oldIsAgent, isAgent));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isIsPreconditionFixed() {
        return isPreconditionFixed;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsPreconditionFixed(boolean newIsPreconditionFixed) {
        boolean oldIsPreconditionFixed = isPreconditionFixed;
        isPreconditionFixed = newIsPreconditionFixed;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_ACTION__IS_PRECONDITION_FIXED, oldIsPreconditionFixed, isPreconditionFixed));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DesignPackage.ABSTRACT_ACTION__IS_AGENT:
                return isIsAgent();
            case DesignPackage.ABSTRACT_ACTION__IS_PRECONDITION_FIXED:
                return isIsPreconditionFixed();
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
            case DesignPackage.ABSTRACT_ACTION__IS_AGENT:
                setIsAgent((Boolean)newValue);
                return;
            case DesignPackage.ABSTRACT_ACTION__IS_PRECONDITION_FIXED:
                setIsPreconditionFixed((Boolean)newValue);
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
            case DesignPackage.ABSTRACT_ACTION__IS_AGENT:
                setIsAgent(IS_AGENT_EDEFAULT);
                return;
            case DesignPackage.ABSTRACT_ACTION__IS_PRECONDITION_FIXED:
                setIsPreconditionFixed(IS_PRECONDITION_FIXED_EDEFAULT);
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
            case DesignPackage.ABSTRACT_ACTION__IS_AGENT:
                return isAgent != IS_AGENT_EDEFAULT;
            case DesignPackage.ABSTRACT_ACTION__IS_PRECONDITION_FIXED:
                return isPreconditionFixed != IS_PRECONDITION_FIXED_EDEFAULT;
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
        result.append(", isPreconditionFixed: ");
        result.append(isPreconditionFixed);
        result.append(')');
        return result.toString();
    }

} //AbstractActionImpl
