/**
 * <copyright>
 * </copyright>
 *
 * $Id: WithArgumentImpl.java,v 1.1 2011/02/07 16:53:51 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.WithArgument;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>With Argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.WithArgumentImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WithArgumentImpl extends EObjectImpl implements WithArgument {
	/**
     * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArgument()
     * @generated
     * @ordered
     */
	protected Expression argument;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected WithArgumentImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.WITH_ARGUMENT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getArgument() {
        if (argument != null && argument.eIsProxy()) {
            InternalEObject oldArgument = (InternalEObject)argument;
            argument = (Expression)eResolveProxy(oldArgument);
            if (argument != oldArgument) {
                InternalEObject newArgument = (InternalEObject)argument;
                NotificationChain msgs =  oldArgument.eInverseRemove(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, null);
                if (newArgument.eInternalContainer() == null) {
                    msgs =  newArgument.eInverseAdd(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.WITH_ARGUMENT__ARGUMENT, oldArgument, argument));
            }
        }
        return argument;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetArgument() {
        return argument;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetArgument(Expression newArgument, NotificationChain msgs) {
        Expression oldArgument = argument;
        argument = newArgument;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WITH_ARGUMENT__ARGUMENT, oldArgument, newArgument);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setArgument(Expression newArgument) {
        if (newArgument != argument) {
            NotificationChain msgs = null;
            if (argument != null)
                msgs = ((InternalEObject)argument).eInverseRemove(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, msgs);
            if (newArgument != null)
                msgs = ((InternalEObject)newArgument).eInverseAdd(this, ExpressionsPackage.EXPRESSION__ARGUMENT_OF, Expression.class, msgs);
            msgs = basicSetArgument(newArgument, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.WITH_ARGUMENT__ARGUMENT, newArgument, newArgument));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT:
                if (argument != null)
                    msgs = ((InternalEObject)argument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.WITH_ARGUMENT__ARGUMENT, null, msgs);
                return basicSetArgument((Expression)otherEnd, msgs);
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
            case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT:
                return basicSetArgument(null, msgs);
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
            case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT:
                if (resolve) return getArgument();
                return basicGetArgument();
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
            case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT:
                setArgument((Expression)newValue);
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
            case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT:
                setArgument((Expression)null);
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
            case ExpressionsPackage.WITH_ARGUMENT__ARGUMENT:
                return argument != null;
        }
        return super.eIsSet(featureID);
    }

} //WithArgumentImpl
