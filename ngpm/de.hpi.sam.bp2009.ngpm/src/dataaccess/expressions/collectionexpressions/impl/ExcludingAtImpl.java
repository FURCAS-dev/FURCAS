/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.collectionexpressions.impl;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;
import dataaccess.expressions.collectionexpressions.ExcludingAt;
import dataaccess.expressions.collectionexpressions.WithPosition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Excluding At</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.ExcludingAtImpl#getAt <em>At</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExcludingAtImpl extends ExcludingImpl implements ExcludingAt {
	/**
     * The default value of the '{@link #getAt() <em>At</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAt()
     * @generated
     * @ordered
     */
	protected static final int AT_EDEFAULT = 0;

	/**
     * The cached value of the '{@link #getAt() <em>At</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAt()
     * @generated
     * @ordered
     */
	protected int at = AT_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ExcludingAtImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CollectionexpressionsPackage.Literals.EXCLUDING_AT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public int getAt() {
        return at;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAt(int newAt) {
        int oldAt = at;
        at = newAt;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.EXCLUDING_AT__AT, oldAt, at));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CollectionexpressionsPackage.EXCLUDING_AT__AT:
                return getAt();
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
            case CollectionexpressionsPackage.EXCLUDING_AT__AT:
                setAt((Integer)newValue);
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
            case CollectionexpressionsPackage.EXCLUDING_AT__AT:
                setAt(AT_EDEFAULT);
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
            case CollectionexpressionsPackage.EXCLUDING_AT__AT:
                return at != AT_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == WithPosition.class) {
            switch (derivedFeatureID) {
                case CollectionexpressionsPackage.EXCLUDING_AT__AT: return CollectionexpressionsPackage.WITH_POSITION__AT;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == WithPosition.class) {
            switch (baseFeatureID) {
                case CollectionexpressionsPackage.WITH_POSITION__AT: return CollectionexpressionsPackage.EXCLUDING_AT__AT;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (at: ");
        result.append(at);
        result.append(')');
        return result.toString();
    }

} //ExcludingAtImpl
