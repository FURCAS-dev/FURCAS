/**
 * <copyright>
 * </copyright>
 *
 * $Id: EqualsImpl.java,v 1.1 2011/02/07 17:20:40 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.Equals;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equals</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.EqualsImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link dataaccess.expressions.impl.EqualsImpl#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EqualsImpl extends ExpressionImpl implements Equals {
	/**
     * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLeft()
     * @generated
     * @ordered
     */
	protected Expression left;

	/**
     * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRight()
     * @generated
     * @ordered
     */
	protected Expression right;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EqualsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.EQUALS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getLeft() {
        if (left != null && left.eIsProxy()) {
            InternalEObject oldLeft = (InternalEObject)left;
            left = (Expression)eResolveProxy(oldLeft);
            if (left != oldLeft) {
                InternalEObject newLeft = (InternalEObject)left;
                NotificationChain msgs =  oldLeft.eInverseRemove(this, ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS, Expression.class, null);
                if (newLeft.eInternalContainer() == null) {
                    msgs =  newLeft.eInverseAdd(this, ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.EQUALS__LEFT, oldLeft, left));
            }
        }
        return left;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetLeft() {
        return left;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs) {
        Expression oldLeft = left;
        left = newLeft;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EQUALS__LEFT, oldLeft, newLeft);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLeft(Expression newLeft) {
        if (newLeft != left) {
            NotificationChain msgs = null;
            if (left != null)
                msgs = ((InternalEObject)left).eInverseRemove(this, ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS, Expression.class, msgs);
            if (newLeft != null)
                msgs = ((InternalEObject)newLeft).eInverseAdd(this, ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS, Expression.class, msgs);
            msgs = basicSetLeft(newLeft, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EQUALS__LEFT, newLeft, newLeft));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getRight() {
        if (right != null && right.eIsProxy()) {
            InternalEObject oldRight = (InternalEObject)right;
            right = (Expression)eResolveProxy(oldRight);
            if (right != oldRight) {
                InternalEObject newRight = (InternalEObject)right;
                NotificationChain msgs =  oldRight.eInverseRemove(this, ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS, Expression.class, null);
                if (newRight.eInternalContainer() == null) {
                    msgs =  newRight.eInverseAdd(this, ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.EQUALS__RIGHT, oldRight, right));
            }
        }
        return right;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetRight() {
        return right;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRight(Expression newRight, NotificationChain msgs) {
        Expression oldRight = right;
        right = newRight;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EQUALS__RIGHT, oldRight, newRight);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRight(Expression newRight) {
        if (newRight != right) {
            NotificationChain msgs = null;
            if (right != null)
                msgs = ((InternalEObject)right).eInverseRemove(this, ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS, Expression.class, msgs);
            if (newRight != null)
                msgs = ((InternalEObject)newRight).eInverseAdd(this, ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS, Expression.class, msgs);
            msgs = basicSetRight(newRight, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EQUALS__RIGHT, newRight, newRight));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.EQUALS__LEFT:
                if (left != null)
                    msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.EQUALS__LEFT, null, msgs);
                return basicSetLeft((Expression)otherEnd, msgs);
            case ExpressionsPackage.EQUALS__RIGHT:
                if (right != null)
                    msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.EQUALS__RIGHT, null, msgs);
                return basicSetRight((Expression)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.EQUALS__LEFT:
                return basicSetLeft(null, msgs);
            case ExpressionsPackage.EQUALS__RIGHT:
                return basicSetRight(null, msgs);
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
            case ExpressionsPackage.EQUALS__LEFT:
                if (resolve) return getLeft();
                return basicGetLeft();
            case ExpressionsPackage.EQUALS__RIGHT:
                if (resolve) return getRight();
                return basicGetRight();
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
            case ExpressionsPackage.EQUALS__LEFT:
                setLeft((Expression)newValue);
                return;
            case ExpressionsPackage.EQUALS__RIGHT:
                setRight((Expression)newValue);
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
            case ExpressionsPackage.EQUALS__LEFT:
                setLeft((Expression)null);
                return;
            case ExpressionsPackage.EQUALS__RIGHT:
                setRight((Expression)null);
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
            case ExpressionsPackage.EQUALS__LEFT:
                return left != null;
            case ExpressionsPackage.EQUALS__RIGHT:
                return right != null;
        }
        return super.eIsSet(featureID);
    }

} //EqualsImpl
