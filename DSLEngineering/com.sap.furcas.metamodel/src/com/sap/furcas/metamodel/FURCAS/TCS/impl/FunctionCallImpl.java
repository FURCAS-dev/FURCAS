/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.FunctionCallImpl#getCalledFunction <em>Called Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionCallImpl extends SequenceElementImpl implements FunctionCall {
        /**
     * The cached value of the '{@link #getCalledFunction() <em>Called Function</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getCalledFunction()
     * @generated
     * @ordered
     */
        protected FunctionTemplate calledFunction;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected FunctionCallImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.FUNCTION_CALL;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public FunctionTemplate getCalledFunction() {
        if (calledFunction != null && calledFunction.eIsProxy()) {
            InternalEObject oldCalledFunction = (InternalEObject)calledFunction;
            calledFunction = (FunctionTemplate)eResolveProxy(oldCalledFunction);
            if (calledFunction != oldCalledFunction) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.FUNCTION_CALL__CALLED_FUNCTION, oldCalledFunction, calledFunction));
            }
        }
        return calledFunction;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public FunctionTemplate basicGetCalledFunction() {
        return calledFunction;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setCalledFunction(FunctionTemplate newCalledFunction) {
        FunctionTemplate oldCalledFunction = calledFunction;
        calledFunction = newCalledFunction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.FUNCTION_CALL__CALLED_FUNCTION, oldCalledFunction, calledFunction));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TCSPackage.FUNCTION_CALL__CALLED_FUNCTION:
                if (resolve) return getCalledFunction();
                return basicGetCalledFunction();
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
            case TCSPackage.FUNCTION_CALL__CALLED_FUNCTION:
                setCalledFunction((FunctionTemplate)newValue);
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
            case TCSPackage.FUNCTION_CALL__CALLED_FUNCTION:
                setCalledFunction((FunctionTemplate)null);
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
            case TCSPackage.FUNCTION_CALL__CALLED_FUNCTION:
                return calledFunction != null;
        }
        return super.eIsSet(featureID);
    }

} //FunctionCallImpl
