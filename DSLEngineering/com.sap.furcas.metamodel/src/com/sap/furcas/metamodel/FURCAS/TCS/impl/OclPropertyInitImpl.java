/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Property Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OclPropertyInitImpl#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclPropertyInitImpl extends PropertyInitImpl implements OclPropertyInit {
        /**
         * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getOclExpression()
         * @generated
         * @ordered
         */
        protected OCLExpression oclExpression;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected OclPropertyInitImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.OCL_PROPERTY_INIT;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public OCLExpression getOclExpression() {
                if (oclExpression != null && oclExpression.eIsProxy()) {
                        InternalEObject oldOclExpression = (InternalEObject)oclExpression;
                        oclExpression = (OCLExpression)eResolveProxy(oldOclExpression);
                        if (oclExpression != oldOclExpression) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.OCL_PROPERTY_INIT__OCL_EXPRESSION, oldOclExpression, oclExpression));
                        }
                }
                return oclExpression;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public OCLExpression basicGetOclExpression() {
                return oclExpression;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setOclExpression(OCLExpression newOclExpression) {
                OCLExpression oldOclExpression = oclExpression;
                oclExpression = newOclExpression;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OCL_PROPERTY_INIT__OCL_EXPRESSION, oldOclExpression, oclExpression));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TCSPackage.OCL_PROPERTY_INIT__OCL_EXPRESSION:
                                if (resolve) return getOclExpression();
                                return basicGetOclExpression();
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
                        case TCSPackage.OCL_PROPERTY_INIT__OCL_EXPRESSION:
                                setOclExpression((OCLExpression)newValue);
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
                        case TCSPackage.OCL_PROPERTY_INIT__OCL_EXPRESSION:
                                setOclExpression((OCLExpression)null);
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
                        case TCSPackage.OCL_PROPERTY_INIT__OCL_EXPRESSION:
                                return oclExpression != null;
                }
                return super.eIsSet(featureID);
        }

} //OclPropertyInitImpl
