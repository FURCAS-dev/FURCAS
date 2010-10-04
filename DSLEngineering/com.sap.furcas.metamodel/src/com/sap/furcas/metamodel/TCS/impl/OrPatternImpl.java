/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.OrPattern;
import com.sap.furcas.metamodel.TCS.SimplePattern;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Or Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.OrPatternImpl#getSimplePatterns <em>Simple Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OrPatternImpl extends LocatedElementImpl implements OrPattern {
        /**
         * The cached value of the '{@link #getSimplePatterns() <em>Simple Patterns</em>}' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getSimplePatterns()
         * @generated
         * @ordered
         */
        protected EList<SimplePattern> simplePatterns;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected OrPatternImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.OR_PATTERN;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<SimplePattern> getSimplePatterns() {
                if (simplePatterns == null) {
                        simplePatterns = new EObjectContainmentEList<SimplePattern>(SimplePattern.class, this, TCSPackage.OR_PATTERN__SIMPLE_PATTERNS);
                }
                return simplePatterns;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TCSPackage.OR_PATTERN__SIMPLE_PATTERNS:
                                return ((InternalEList<?>)getSimplePatterns()).basicRemove(otherEnd, msgs);
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
                        case TCSPackage.OR_PATTERN__SIMPLE_PATTERNS:
                                return getSimplePatterns();
                }
                return super.eGet(featureID, resolve, coreType);
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("unchecked")
        @Override
        public void eSet(int featureID, Object newValue) {
                switch (featureID) {
                        case TCSPackage.OR_PATTERN__SIMPLE_PATTERNS:
                                getSimplePatterns().clear();
                                getSimplePatterns().addAll((Collection<? extends SimplePattern>)newValue);
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
                        case TCSPackage.OR_PATTERN__SIMPLE_PATTERNS:
                                getSimplePatterns().clear();
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
                        case TCSPackage.OR_PATTERN__SIMPLE_PATTERNS:
                                return simplePatterns != null && !simplePatterns.isEmpty();
                }
                return super.eIsSet(featureID);
        }

} //OrPatternImpl
