/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.assembly.impl;

import behavioral.status_and_action.assembly.AssemblyPackage;
import behavioral.status_and_action.assembly.Precondition;
import behavioral.status_and_action.assembly.Strategy;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precondition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link behavioral.status_and_action.assembly.impl.PreconditionImpl#getStrategy <em>Strategy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PreconditionImpl extends ConnectorImpl implements Precondition {
	/**
     * The cached value of the '{@link #getStrategy() <em>Strategy</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getStrategy()
     * @generated
     * @ordered
     */
	protected Strategy strategy;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PreconditionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return AssemblyPackage.Literals.PRECONDITION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Strategy getStrategy() {
        if (strategy != null && strategy.eIsProxy()) {
            InternalEObject oldStrategy = (InternalEObject)strategy;
            strategy = (Strategy)eResolveProxy(oldStrategy);
            if (strategy != oldStrategy) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, AssemblyPackage.PRECONDITION__STRATEGY, oldStrategy, strategy));
            }
        }
        return strategy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Strategy basicGetStrategy() {
        return strategy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setStrategy(Strategy newStrategy) {
        Strategy oldStrategy = strategy;
        strategy = newStrategy;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AssemblyPackage.PRECONDITION__STRATEGY, oldStrategy, strategy));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case AssemblyPackage.PRECONDITION__STRATEGY:
                if (resolve) return getStrategy();
                return basicGetStrategy();
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
            case AssemblyPackage.PRECONDITION__STRATEGY:
                setStrategy((Strategy)newValue);
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
            case AssemblyPackage.PRECONDITION__STRATEGY:
                setStrategy((Strategy)null);
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
            case AssemblyPackage.PRECONDITION__STRATEGY:
                return strategy != null;
        }
        return super.eIsSet(featureID);
    }

} //PreconditionImpl
