/**
 * <copyright>
 * </copyright>
 *
 * $Id: FunctionFromMethodExprImpl.java,v 1.1 2011/02/07 17:20:40 auhl Exp $
 */
package dataaccess.expressions.fp.impl;

import data.classes.MethodSignature;

import dataaccess.expressions.fp.FpPackage;
import dataaccess.expressions.fp.FunctionFromMethodExpr;

import dataaccess.expressions.impl.ObjectBasedExpressionImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function From Method Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dataaccess.expressions.fp.impl.FunctionFromMethodExprImpl#getMethod <em>Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionFromMethodExprImpl extends ObjectBasedExpressionImpl implements FunctionFromMethodExpr {
	/**
     * The cached value of the '{@link #getMethod() <em>Method</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMethod()
     * @generated
     * @ordered
     */
	protected MethodSignature method;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FunctionFromMethodExprImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return FpPackage.Literals.FUNCTION_FROM_METHOD_EXPR;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature getMethod() {
        if (method != null && method.eIsProxy()) {
            InternalEObject oldMethod = (InternalEObject)method;
            method = (MethodSignature)eResolveProxy(oldMethod);
            if (method != oldMethod) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, FpPackage.FUNCTION_FROM_METHOD_EXPR__METHOD, oldMethod, method));
            }
        }
        return method;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MethodSignature basicGetMethod() {
        return method;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMethod(MethodSignature newMethod) {
        MethodSignature oldMethod = method;
        method = newMethod;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, FpPackage.FUNCTION_FROM_METHOD_EXPR__METHOD, oldMethod, method));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FpPackage.FUNCTION_FROM_METHOD_EXPR__METHOD:
                if (resolve) return getMethod();
                return basicGetMethod();
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
            case FpPackage.FUNCTION_FROM_METHOD_EXPR__METHOD:
                setMethod((MethodSignature)newValue);
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
            case FpPackage.FUNCTION_FROM_METHOD_EXPR__METHOD:
                setMethod((MethodSignature)null);
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
            case FpPackage.FUNCTION_FROM_METHOD_EXPR__METHOD:
                return method != null;
        }
        return super.eIsSet(featureID);
    }

} //FunctionFromMethodExprImpl
