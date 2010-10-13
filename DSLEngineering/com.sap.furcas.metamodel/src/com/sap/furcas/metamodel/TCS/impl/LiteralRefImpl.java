/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.Literal;
import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.LiteralRefImpl#getReferredLiteral <em>Referred Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralRefImpl extends SequenceElementImpl implements LiteralRef {
        /**
         * The cached value of the '{@link #getReferredLiteral() <em>Referred Literal</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getReferredLiteral()
         * @generated
         * @ordered
         */
        protected Literal referredLiteral;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected LiteralRefImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.LITERAL_REF;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Literal getReferredLiteral() {
                if (referredLiteral != null && referredLiteral.eIsProxy()) {
                        InternalEObject oldReferredLiteral = (InternalEObject)referredLiteral;
                        referredLiteral = (Literal)eResolveProxy(oldReferredLiteral);
                        if (referredLiteral != oldReferredLiteral) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.LITERAL_REF__REFERRED_LITERAL, oldReferredLiteral, referredLiteral));
                        }
                }
                return referredLiteral;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Literal basicGetReferredLiteral() {
                return referredLiteral;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetReferredLiteral(Literal newReferredLiteral, NotificationChain msgs) {
                Literal oldReferredLiteral = referredLiteral;
                referredLiteral = newReferredLiteral;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.LITERAL_REF__REFERRED_LITERAL, oldReferredLiteral, newReferredLiteral);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setReferredLiteral(Literal newReferredLiteral) {
                if (newReferredLiteral != referredLiteral) {
                        NotificationChain msgs = null;
                        if (referredLiteral != null)
                                msgs = ((InternalEObject)referredLiteral).eInverseRemove(this, TCSPackage.LITERAL__LITERAL_REFS, Literal.class, msgs);
                        if (newReferredLiteral != null)
                                msgs = ((InternalEObject)newReferredLiteral).eInverseAdd(this, TCSPackage.LITERAL__LITERAL_REFS, Literal.class, msgs);
                        msgs = basicSetReferredLiteral(newReferredLiteral, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.LITERAL_REF__REFERRED_LITERAL, newReferredLiteral, newReferredLiteral));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TCSPackage.LITERAL_REF__REFERRED_LITERAL:
                                if (referredLiteral != null)
                                        msgs = ((InternalEObject)referredLiteral).eInverseRemove(this, TCSPackage.LITERAL__LITERAL_REFS, Literal.class, msgs);
                                return basicSetReferredLiteral((Literal)otherEnd, msgs);
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
                        case TCSPackage.LITERAL_REF__REFERRED_LITERAL:
                                return basicSetReferredLiteral(null, msgs);
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
                        case TCSPackage.LITERAL_REF__REFERRED_LITERAL:
                                if (resolve) return getReferredLiteral();
                                return basicGetReferredLiteral();
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
                        case TCSPackage.LITERAL_REF__REFERRED_LITERAL:
                                setReferredLiteral((Literal)newValue);
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
                        case TCSPackage.LITERAL_REF__REFERRED_LITERAL:
                                setReferredLiteral((Literal)null);
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
                        case TCSPackage.LITERAL_REF__REFERRED_LITERAL:
                                return referredLiteral != null;
                }
                return super.eIsSet(featureID);
        }

} //LiteralRefImpl
