/**
 * <copyright>
 * </copyright>
 *
 * $Id: TernaryImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.Ternary;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ternary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.TernaryImpl#getFalseExpr <em>False Expr</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.TernaryImpl#getTrueExpr <em>True Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TernaryImpl extends ConditionalExpressionImpl implements Ternary {
	/**
     * The cached value of the '{@link #getFalseExpr() <em>False Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFalseExpr()
     * @generated
     * @ordered
     */
	protected Expression falseExpr;

	/**
     * The cached value of the '{@link #getTrueExpr() <em>True Expr</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTrueExpr()
     * @generated
     * @ordered
     */
	protected Expression trueExpr;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TernaryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.TERNARY;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getFalseExpr() {
        if (falseExpr != null && falseExpr.eIsProxy()) {
            InternalEObject oldFalseExpr = (InternalEObject)falseExpr;
            falseExpr = (Expression)eResolveProxy(oldFalseExpr);
            if (falseExpr != oldFalseExpr) {
                InternalEObject newFalseExpr = (InternalEObject)falseExpr;
                NotificationChain msgs = oldFalseExpr.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__FALSE_EXPR, null, null);
                if (newFalseExpr.eInternalContainer() == null) {
                    msgs = newFalseExpr.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__FALSE_EXPR, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.TERNARY__FALSE_EXPR, oldFalseExpr, falseExpr));
            }
        }
        return falseExpr;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetFalseExpr() {
        return falseExpr;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetFalseExpr(Expression newFalseExpr, NotificationChain msgs) {
        Expression oldFalseExpr = falseExpr;
        falseExpr = newFalseExpr;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TERNARY__FALSE_EXPR, oldFalseExpr, newFalseExpr);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFalseExpr(Expression newFalseExpr) {
        if (newFalseExpr != falseExpr) {
            NotificationChain msgs = null;
            if (falseExpr != null)
                msgs = ((InternalEObject)falseExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__FALSE_EXPR, null, msgs);
            if (newFalseExpr != null)
                msgs = ((InternalEObject)newFalseExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__FALSE_EXPR, null, msgs);
            msgs = basicSetFalseExpr(newFalseExpr, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TERNARY__FALSE_EXPR, newFalseExpr, newFalseExpr));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getTrueExpr() {
        if (trueExpr != null && trueExpr.eIsProxy()) {
            InternalEObject oldTrueExpr = (InternalEObject)trueExpr;
            trueExpr = (Expression)eResolveProxy(oldTrueExpr);
            if (trueExpr != oldTrueExpr) {
                InternalEObject newTrueExpr = (InternalEObject)trueExpr;
                NotificationChain msgs = oldTrueExpr.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__TRUE_EXPR, null, null);
                if (newTrueExpr.eInternalContainer() == null) {
                    msgs = newTrueExpr.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__TRUE_EXPR, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.TERNARY__TRUE_EXPR, oldTrueExpr, trueExpr));
            }
        }
        return trueExpr;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetTrueExpr() {
        return trueExpr;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTrueExpr(Expression newTrueExpr, NotificationChain msgs) {
        Expression oldTrueExpr = trueExpr;
        trueExpr = newTrueExpr;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TERNARY__TRUE_EXPR, oldTrueExpr, newTrueExpr);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTrueExpr(Expression newTrueExpr) {
        if (newTrueExpr != trueExpr) {
            NotificationChain msgs = null;
            if (trueExpr != null)
                msgs = ((InternalEObject)trueExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__TRUE_EXPR, null, msgs);
            if (newTrueExpr != null)
                msgs = ((InternalEObject)newTrueExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TERNARY__TRUE_EXPR, null, msgs);
            msgs = basicSetTrueExpr(newTrueExpr, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TERNARY__TRUE_EXPR, newTrueExpr, newTrueExpr));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.TERNARY__FALSE_EXPR:
                return basicSetFalseExpr(null, msgs);
            case ExpressionsPackage.TERNARY__TRUE_EXPR:
                return basicSetTrueExpr(null, msgs);
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
            case ExpressionsPackage.TERNARY__FALSE_EXPR:
                if (resolve) return getFalseExpr();
                return basicGetFalseExpr();
            case ExpressionsPackage.TERNARY__TRUE_EXPR:
                if (resolve) return getTrueExpr();
                return basicGetTrueExpr();
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
            case ExpressionsPackage.TERNARY__FALSE_EXPR:
                setFalseExpr((Expression)newValue);
                return;
            case ExpressionsPackage.TERNARY__TRUE_EXPR:
                setTrueExpr((Expression)newValue);
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
            case ExpressionsPackage.TERNARY__FALSE_EXPR:
                setFalseExpr((Expression)null);
                return;
            case ExpressionsPackage.TERNARY__TRUE_EXPR:
                setTrueExpr((Expression)null);
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
            case ExpressionsPackage.TERNARY__FALSE_EXPR:
                return falseExpr != null;
            case ExpressionsPackage.TERNARY__TRUE_EXPR:
                return trueExpr != null;
        }
        return super.eIsSet(featureID);
    }

} //TernaryImpl
