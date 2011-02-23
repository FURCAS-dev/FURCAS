/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionCallExpressionImpl.java,v 1.1 2011/02/07 17:20:40 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.FunctionCallExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.impl.FunctionCallExpressionImpl#getCalledBlock <em>Called Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionCallExpressionImpl extends SignatureCallExpressionImpl implements FunctionCallExpression {
	/**
     * The cached value of the '{@link #getCalledBlock() <em>Called Block</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCalledBlock()
     * @generated
     * @ordered
     */
	protected Expression calledBlock;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FunctionCallExpressionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.FUNCTION_CALL_EXPRESSION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Expression getCalledBlock() {
        if (calledBlock != null && calledBlock.eIsProxy()) {
            InternalEObject oldCalledBlock = (InternalEObject)calledBlock;
            calledBlock = (Expression)eResolveProxy(oldCalledBlock);
            if (calledBlock != oldCalledBlock) {
                InternalEObject newCalledBlock = (InternalEObject)calledBlock;
                NotificationChain msgs =  oldCalledBlock.eInverseRemove(this, ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION, Expression.class, null);
                if (newCalledBlock.eInternalContainer() == null) {
                    msgs =  newCalledBlock.eInverseAdd(this, ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION, Expression.class, msgs);
                }
                if (msgs != null) msgs.dispatch();
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK, oldCalledBlock, calledBlock));
            }
        }
        return calledBlock;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Expression basicGetCalledBlock() {
        return calledBlock;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCalledBlock(Expression newCalledBlock, NotificationChain msgs) {
        Expression oldCalledBlock = calledBlock;
        calledBlock = newCalledBlock;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK, oldCalledBlock, newCalledBlock);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCalledBlock(Expression newCalledBlock) {
        if (newCalledBlock != calledBlock) {
            NotificationChain msgs = null;
            if (calledBlock != null)
                msgs = ((InternalEObject)calledBlock).eInverseRemove(this, ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION, Expression.class, msgs);
            if (newCalledBlock != null)
                msgs = ((InternalEObject)newCalledBlock).eInverseAdd(this, ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION, Expression.class, msgs);
            msgs = basicSetCalledBlock(newCalledBlock, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK, newCalledBlock, newCalledBlock));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK:
                if (calledBlock != null)
                    msgs = ((InternalEObject)calledBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK, null, msgs);
                return basicSetCalledBlock((Expression)otherEnd, msgs);
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
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK:
                return basicSetCalledBlock(null, msgs);
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
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK:
                if (resolve) return getCalledBlock();
                return basicGetCalledBlock();
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
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK:
                setCalledBlock((Expression)newValue);
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
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK:
                setCalledBlock((Expression)null);
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
            case ExpressionsPackage.FUNCTION_CALL_EXPRESSION__CALLED_BLOCK:
                return calledBlock != null;
        }
        return super.eIsSet(featureID);
    }

} //FunctionCallExpressionImpl
