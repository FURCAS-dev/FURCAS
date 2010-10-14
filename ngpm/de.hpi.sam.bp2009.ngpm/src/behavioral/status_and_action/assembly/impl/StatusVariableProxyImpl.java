/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.assembly.impl;

import behavioral.status_and_action.assembly.AssemblyPackage;
import behavioral.status_and_action.assembly.StatusVariableProxy;

import behavioral.status_and_action.design.StatusVariable;

import behavioral.status_and_action.design.impl.AbstractStatusVariableImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Variable Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.impl.StatusVariableProxyImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatusVariableProxyImpl extends AbstractStatusVariableImpl implements StatusVariableProxy {
	/**
     * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariable()
     * @generated
     * @ordered
     */
	protected StatusVariable variable;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected StatusVariableProxyImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AssemblyPackage.Literals.STATUS_VARIABLE_PROXY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusVariable getVariable() {
        if (variable != null && variable.eIsProxy()) {
            InternalEObject oldVariable = (InternalEObject)variable;
            variable = (StatusVariable)eResolveProxy(oldVariable);
            if (variable != oldVariable) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.STATUS_VARIABLE_PROXY__VARIABLE, oldVariable, variable));
            }
        }
        return variable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusVariable basicGetVariable() {
        return variable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariable(StatusVariable newVariable) {
        StatusVariable oldVariable = variable;
        variable = newVariable;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.STATUS_VARIABLE_PROXY__VARIABLE, oldVariable, variable));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AssemblyPackage.STATUS_VARIABLE_PROXY__VARIABLE:
                if (resolve) return getVariable();
                return basicGetVariable();
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
            case AssemblyPackage.STATUS_VARIABLE_PROXY__VARIABLE:
                setVariable((StatusVariable)newValue);
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
            case AssemblyPackage.STATUS_VARIABLE_PROXY__VARIABLE:
                setVariable((StatusVariable)null);
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
            case AssemblyPackage.STATUS_VARIABLE_PROXY__VARIABLE:
                return variable != null;
        }
        return super.eIsSet(featureID);
    }

} //StatusVariableProxyImpl
