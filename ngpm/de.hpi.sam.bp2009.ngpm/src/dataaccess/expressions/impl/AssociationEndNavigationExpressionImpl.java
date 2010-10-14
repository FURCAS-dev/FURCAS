/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

import data.classes.AssociationEnd;

import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.ExpressionsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Navigation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.AssociationEndNavigationExpressionImpl#getToEnd <em>To End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndNavigationExpressionImpl extends ObjectBasedExpressionImpl implements AssociationEndNavigationExpression {
	/**
     * The cached value of the '{@link #getToEnd() <em>To End</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getToEnd()
     * @generated
     * @ordered
     */
	protected AssociationEnd toEnd;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected AssociationEndNavigationExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.ASSOCIATION_END_NAVIGATION_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd getToEnd() {
        if (toEnd != null && toEnd.eIsProxy()) {
            InternalEObject oldToEnd = (InternalEObject)toEnd;
            toEnd = (AssociationEnd)eResolveProxy(oldToEnd);
            if (toEnd != oldToEnd) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END, oldToEnd, toEnd));
            }
        }
        return toEnd;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssociationEnd basicGetToEnd() {
        return toEnd;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setToEnd(AssociationEnd newToEnd) {
        AssociationEnd oldToEnd = toEnd;
        toEnd = newToEnd;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END, oldToEnd, toEnd));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END:
                if (resolve) return getToEnd();
                return basicGetToEnd();
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
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END:
                setToEnd((AssociationEnd)newValue);
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
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END:
                setToEnd((AssociationEnd)null);
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
            case ExpressionsPackage.ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END:
                return toEnd != null;
        }
        return super.eIsSet(featureID);
    }

} //AssociationEndNavigationExpressionImpl
