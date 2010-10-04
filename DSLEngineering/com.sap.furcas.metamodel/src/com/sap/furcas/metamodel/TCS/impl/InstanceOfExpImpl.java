/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance Of Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.InstanceOfExpImpl#getSupertype <em>Supertype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceOfExpImpl extends AtomExpImpl implements InstanceOfExp {
        /**
         * The cached value of the '{@link #getSupertype() <em>Supertype</em>}' attribute list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getSupertype()
         * @generated
         * @ordered
         */
        protected EList<String> supertype;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected InstanceOfExpImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.INSTANCE_OF_EXP;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<String> getSupertype() {
                if (supertype == null) {
                        supertype = new EDataTypeUniqueEList<String>(String.class, this, TCSPackage.INSTANCE_OF_EXP__SUPERTYPE);
                }
                return supertype;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TCSPackage.INSTANCE_OF_EXP__SUPERTYPE:
                                return getSupertype();
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
                        case TCSPackage.INSTANCE_OF_EXP__SUPERTYPE:
                                getSupertype().clear();
                                getSupertype().addAll((Collection<? extends String>)newValue);
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
                        case TCSPackage.INSTANCE_OF_EXP__SUPERTYPE:
                                getSupertype().clear();
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
                        case TCSPackage.INSTANCE_OF_EXP__SUPERTYPE:
                                return supertype != null && !supertype.isEmpty();
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
                result.append(" (supertype: ");
                result.append(supertype);
                result.append(')');
                return result.toString();
        }

} //InstanceOfExpImpl
