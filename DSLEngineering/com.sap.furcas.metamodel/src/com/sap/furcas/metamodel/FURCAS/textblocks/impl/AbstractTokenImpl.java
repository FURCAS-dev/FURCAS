/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.impl;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Token</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.AbstractTokenImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.AbstractTokenImpl#getLookahead <em>Lookahead</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.AbstractTokenImpl#getLookback <em>Lookback</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.AbstractTokenImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractTokenImpl extends DocumentNodeImpl implements AbstractToken {
        /**
         * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getValue()
         * @generated
         * @ordered
         */
        protected static final String VALUE_EDEFAULT = null;

        /**
         * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getValue()
         * @generated
         * @ordered
         */
        protected String value = VALUE_EDEFAULT;

        /**
         * The default value of the '{@link #getLookahead() <em>Lookahead</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLookahead()
         * @generated
         * @ordered
         */
        protected static final int LOOKAHEAD_EDEFAULT = 0;

        /**
         * The cached value of the '{@link #getLookahead() <em>Lookahead</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLookahead()
         * @generated
         * @ordered
         */
        protected int lookahead = LOOKAHEAD_EDEFAULT;

        /**
         * The default value of the '{@link #getLookback() <em>Lookback</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLookback()
         * @generated
         * @ordered
         */
        protected static final int LOOKBACK_EDEFAULT = 0;

        /**
         * The cached value of the '{@link #getLookback() <em>Lookback</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getLookback()
         * @generated
         * @ordered
         */
        protected int lookback = LOOKBACK_EDEFAULT;

        /**
         * The default value of the '{@link #getState() <em>State</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getState()
         * @generated
         * @ordered
         */
        protected static final int STATE_EDEFAULT = 0;

        /**
         * The cached value of the '{@link #getState() <em>State</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getState()
         * @generated
         * @ordered
         */
        protected int state = STATE_EDEFAULT;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected AbstractTokenImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TextblocksPackage.Literals.ABSTRACT_TOKEN;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public String getValue() {
                return value;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setValue(String newValue) {
                String oldValue = value;
                value = newValue;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.ABSTRACT_TOKEN__VALUE, oldValue, value));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public int getLookahead() {
                return lookahead;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setLookahead(int newLookahead) {
                int oldLookahead = lookahead;
                lookahead = newLookahead;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.ABSTRACT_TOKEN__LOOKAHEAD, oldLookahead, lookahead));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public int getLookback() {
                return lookback;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setLookback(int newLookback) {
                int oldLookback = lookback;
                lookback = newLookback;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.ABSTRACT_TOKEN__LOOKBACK, oldLookback, lookback));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public int getState() {
                return state;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setState(int newState) {
                int oldState = state;
                state = newState;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.ABSTRACT_TOKEN__STATE, oldState, state));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TextblocksPackage.ABSTRACT_TOKEN__VALUE:
                                return getValue();
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKAHEAD:
                                return getLookahead();
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKBACK:
                                return getLookback();
                        case TextblocksPackage.ABSTRACT_TOKEN__STATE:
                                return getState();
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
                        case TextblocksPackage.ABSTRACT_TOKEN__VALUE:
                                setValue((String)newValue);
                                return;
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKAHEAD:
                                setLookahead((Integer)newValue);
                                return;
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKBACK:
                                setLookback((Integer)newValue);
                                return;
                        case TextblocksPackage.ABSTRACT_TOKEN__STATE:
                                setState((Integer)newValue);
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
                        case TextblocksPackage.ABSTRACT_TOKEN__VALUE:
                                setValue(VALUE_EDEFAULT);
                                return;
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKAHEAD:
                                setLookahead(LOOKAHEAD_EDEFAULT);
                                return;
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKBACK:
                                setLookback(LOOKBACK_EDEFAULT);
                                return;
                        case TextblocksPackage.ABSTRACT_TOKEN__STATE:
                                setState(STATE_EDEFAULT);
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
                        case TextblocksPackage.ABSTRACT_TOKEN__VALUE:
                                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKAHEAD:
                                return lookahead != LOOKAHEAD_EDEFAULT;
                        case TextblocksPackage.ABSTRACT_TOKEN__LOOKBACK:
                                return lookback != LOOKBACK_EDEFAULT;
                        case TextblocksPackage.ABSTRACT_TOKEN__STATE:
                                return state != STATE_EDEFAULT;
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
                result.append(" (value: ");
                result.append(value);
                result.append(", lookahead: ");
                result.append(lookahead);
                result.append(", lookback: ");
                result.append(lookback);
                result.append(", state: ");
                result.append(state);
                result.append(')');
                return result.toString();
        }

} //AbstractTokenImpl
