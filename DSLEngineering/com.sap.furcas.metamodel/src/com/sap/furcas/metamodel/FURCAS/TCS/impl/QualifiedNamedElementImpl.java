/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QualifiedNamedElementImpl#getNames <em>Names</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.QualifiedNamedElementImpl#getMetaReference <em>Meta Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedNamedElementImpl extends LocatedElementImpl implements QualifiedNamedElement {
        /**
         * The cached value of the '{@link #getNames() <em>Names</em>}' attribute list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getNames()
         * @generated
         * @ordered
         */
        protected EList<String> names;

        /**
         * The cached value of the '{@link #getMetaReference() <em>Meta Reference</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getMetaReference()
         * @generated
         * @ordered
         */
        protected EClass metaReference;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected QualifiedNamedElementImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.QUALIFIED_NAMED_ELEMENT;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<String> getNames() {
                if (names == null) {
                        names = new EDataTypeUniqueEList<String>(String.class, this, TCSPackage.QUALIFIED_NAMED_ELEMENT__NAMES);
                }
                return names;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass getMetaReference() {
                if (metaReference != null && metaReference.eIsProxy()) {
                        InternalEObject oldMetaReference = (InternalEObject)metaReference;
                        metaReference = (EClass)eResolveProxy(oldMetaReference);
                        if (metaReference != oldMetaReference) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.QUALIFIED_NAMED_ELEMENT__META_REFERENCE, oldMetaReference, metaReference));
                        }
                }
                return metaReference;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EClass basicGetMetaReference() {
                return metaReference;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setMetaReference(EClass newMetaReference) {
                EClass oldMetaReference = metaReference;
                metaReference = newMetaReference;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.QUALIFIED_NAMED_ELEMENT__META_REFERENCE, oldMetaReference, metaReference));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__NAMES:
                                return getNames();
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__META_REFERENCE:
                                if (resolve) return getMetaReference();
                                return basicGetMetaReference();
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
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__NAMES:
                                getNames().clear();
                                getNames().addAll((Collection<? extends String>)newValue);
                                return;
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__META_REFERENCE:
                                setMetaReference((EClass)newValue);
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
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__NAMES:
                                getNames().clear();
                                return;
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__META_REFERENCE:
                                setMetaReference((EClass)null);
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
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__NAMES:
                                return names != null && !names.isEmpty();
                        case TCSPackage.QUALIFIED_NAMED_ELEMENT__META_REFERENCE:
                                return metaReference != null;
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
                result.append(" (names: ");
                result.append(names);
                result.append(')');
                return result.toString();
        }

} //QualifiedNamedElementImpl
