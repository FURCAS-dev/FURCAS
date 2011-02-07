/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractStatusValueImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.AbstractStatusValue;
import behavioral.status_and_action.design.DesignPackage;

import modelmanagement.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Status Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractStatusValueImpl#isIsInitial <em>Is Initial</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractStatusValueImpl#isIsInhibiting <em>Is Inhibiting</em>}</li>
 *   <li>{@link behavioral.status_and_action.design.impl.AbstractStatusValueImpl#isIsStateGuarded <em>Is State Guarded</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractStatusValueImpl extends NamedElementImpl implements AbstractStatusValue {
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
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AbstractStatusValueImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return DesignPackage.Literals.ABSTRACT_STATUS_VALUE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_STATUS_VALUE__IS_INITIAL, oldIsInitial, isInitial));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_STATUS_VALUE__IS_INHIBITING, oldIsInhibiting, isInhibiting));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED, oldIsStateGuarded, isStateGuarded));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INITIAL:
                return isIsInitial();
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INHIBITING:
                return isIsInhibiting();
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED:
                return isIsStateGuarded();
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
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INITIAL:
                setIsInitial((Boolean)newValue);
                return;
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INHIBITING:
                setIsInhibiting((Boolean)newValue);
                return;
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED:
                setIsStateGuarded((Boolean)newValue);
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
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INITIAL:
                setIsInitial(IS_INITIAL_EDEFAULT);
                return;
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INHIBITING:
                setIsInhibiting(IS_INHIBITING_EDEFAULT);
                return;
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED:
                setIsStateGuarded(IS_STATE_GUARDED_EDEFAULT);
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
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INITIAL:
                return isInitial != IS_INITIAL_EDEFAULT;
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_INHIBITING:
                return isInhibiting != IS_INHIBITING_EDEFAULT;
            case DesignPackage.ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED:
                return isStateGuarded != IS_STATE_GUARDED_EDEFAULT;
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
        result.append(", isStateGuarded: ");
        result.append(isStateGuarded);
        result.append(')');
        return result.toString();
    }

} //AbstractStatusValueImpl
