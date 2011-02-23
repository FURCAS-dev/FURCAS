/**
 * <copyright>
 * </copyright>
 *
 * $Id: SeverityInStateImpl.java,v 1.1 2011/02/07 17:18:46 auhl Exp $
 */
package data.constraints.impl;

import data.constraints.ConstraintsPackage;
import data.constraints.ObjectState;
import data.constraints.Severity;
import data.constraints.SeverityInState;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Severity In State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link data.constraints.impl.SeverityInStateImpl#getState <em>State</em>}</li>
 *   <li>{@link data.constraints.impl.SeverityInStateImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SeverityInStateImpl extends EObjectImpl implements SeverityInState {
	/**
     * The default value of the '{@link #getState() <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getState()
     * @generated
     * @ordered
     */
	protected static final ObjectState STATE_EDEFAULT = ObjectState.INITIAL;

	/**
     * The cached value of the '{@link #getState() <em>State</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getState()
     * @generated
     * @ordered
     */
	protected ObjectState state = STATE_EDEFAULT;

	/**
     * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSeverity()
     * @generated
     * @ordered
     */
	protected static final Severity SEVERITY_EDEFAULT = Severity.WARNING;

	/**
     * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSeverity()
     * @generated
     * @ordered
     */
	protected Severity severity = SEVERITY_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SeverityInStateImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ConstraintsPackage.Literals.SEVERITY_IN_STATE;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObjectState getState() {
        return state;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setState(ObjectState newState) {
        ObjectState oldState = state;
        state = newState == null ? STATE_EDEFAULT : newState;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.SEVERITY_IN_STATE__STATE, oldState, state));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Severity getSeverity() {
        return severity;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSeverity(Severity newSeverity) {
        Severity oldSeverity = severity;
        severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ConstraintsPackage.SEVERITY_IN_STATE__SEVERITY, oldSeverity, severity));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ConstraintsPackage.SEVERITY_IN_STATE__STATE:
                return getState();
            case ConstraintsPackage.SEVERITY_IN_STATE__SEVERITY:
                return getSeverity();
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
            case ConstraintsPackage.SEVERITY_IN_STATE__STATE:
                setState((ObjectState)newValue);
                return;
            case ConstraintsPackage.SEVERITY_IN_STATE__SEVERITY:
                setSeverity((Severity)newValue);
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
            case ConstraintsPackage.SEVERITY_IN_STATE__STATE:
                setState(STATE_EDEFAULT);
                return;
            case ConstraintsPackage.SEVERITY_IN_STATE__SEVERITY:
                setSeverity(SEVERITY_EDEFAULT);
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
            case ConstraintsPackage.SEVERITY_IN_STATE__STATE:
                return state != STATE_EDEFAULT;
            case ConstraintsPackage.SEVERITY_IN_STATE__SEVERITY:
                return severity != SEVERITY_EDEFAULT;
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
        result.append(" (state: ");
        result.append(state);
        result.append(", severity: ");
        result.append(severity);
        result.append(')');
        return result.toString();
    }

} //SeverityInStateImpl
