/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TokenImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.TokenImpl#isOmitted <em>Omitted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TokenImpl extends NamedElementImpl implements Token {
        /**
         * The cached value of the '{@link #getPattern() <em>Pattern</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getPattern()
         * @generated
         * @ordered
         */
        protected OrPattern pattern;

        /**
         * The default value of the '{@link #isOmitted() <em>Omitted</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isOmitted()
         * @generated
         * @ordered
         */
        protected static final boolean OMITTED_EDEFAULT = false;

        /**
         * The cached value of the '{@link #isOmitted() <em>Omitted</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #isOmitted()
         * @generated
         * @ordered
         */
        protected boolean omitted = OMITTED_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected TokenImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.TOKEN;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public OrPattern getPattern() {
                return pattern;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetPattern(OrPattern newPattern, NotificationChain msgs) {
                OrPattern oldPattern = pattern;
                pattern = newPattern;
                if (eNotificationRequired()) {
                        ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.TOKEN__PATTERN, oldPattern, newPattern);
                        if (msgs == null) msgs = notification; else msgs.add(notification);
                }
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setPattern(OrPattern newPattern) {
                if (newPattern != pattern) {
                        NotificationChain msgs = null;
                        if (pattern != null)
                                msgs = ((InternalEObject)pattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.TOKEN__PATTERN, null, msgs);
                        if (newPattern != null)
                                msgs = ((InternalEObject)newPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.TOKEN__PATTERN, null, msgs);
                        msgs = basicSetPattern(newPattern, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TOKEN__PATTERN, newPattern, newPattern));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public boolean isOmitted() {
                return omitted;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setOmitted(boolean newOmitted) {
                boolean oldOmitted = omitted;
                omitted = newOmitted;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.TOKEN__OMITTED, oldOmitted, omitted));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TCSPackage.TOKEN__PATTERN:
                                return basicSetPattern(null, msgs);
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
                        case TCSPackage.TOKEN__PATTERN:
                                return getPattern();
                        case TCSPackage.TOKEN__OMITTED:
                                return isOmitted();
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
                        case TCSPackage.TOKEN__PATTERN:
                                setPattern((OrPattern)newValue);
                                return;
                        case TCSPackage.TOKEN__OMITTED:
                                setOmitted((Boolean)newValue);
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
                        case TCSPackage.TOKEN__PATTERN:
                                setPattern((OrPattern)null);
                                return;
                        case TCSPackage.TOKEN__OMITTED:
                                setOmitted(OMITTED_EDEFAULT);
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
                        case TCSPackage.TOKEN__PATTERN:
                                return pattern != null;
                        case TCSPackage.TOKEN__OMITTED:
                                return omitted != OMITTED_EDEFAULT;
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
                result.append(" (omitted: ");
                result.append(omitted);
                result.append(')');
                return result.toString();
        }

} //TokenImpl
