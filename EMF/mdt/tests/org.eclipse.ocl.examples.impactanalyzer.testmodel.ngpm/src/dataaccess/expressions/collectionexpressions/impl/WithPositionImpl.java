/**
 * <copyright>
 * </copyright>
 *
 * $Id: WithPositionImpl.java,v 1.1 2011/02/07 17:16:11 auhl Exp $
 */
package dataaccess.expressions.collectionexpressions.impl;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;
import dataaccess.expressions.collectionexpressions.WithPosition;

import dataaccess.expressions.impl.ExpressionWithArgumentImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>With Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.collectionexpressions.impl.WithPositionImpl#getAt <em>At</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WithPositionImpl extends ExpressionWithArgumentImpl implements WithPosition {
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
	protected WithPositionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CollectionexpressionsPackage.Literals.WITH_POSITION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, CollectionexpressionsPackage.WITH_POSITION__AT, oldAt, at));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CollectionexpressionsPackage.WITH_POSITION__AT:
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
            case CollectionexpressionsPackage.WITH_POSITION__AT:
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
            case CollectionexpressionsPackage.WITH_POSITION__AT:
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
            case CollectionexpressionsPackage.WITH_POSITION__AT:
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
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (at: ");
        result.append(at);
        result.append(')');
        return result.toString();
    }

} //WithPositionImpl
