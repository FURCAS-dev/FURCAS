/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.metamodel.TCS.PropertyArg;
import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.furcas.metamodel.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.PropertyImpl#getPropertyArgs <em>Property Args</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.impl.PropertyImpl#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends SequenceElementImpl implements Property {
        /**
         * The cached value of the '{@link #getPropertyArgs() <em>Property Args</em>}' containment reference list.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getPropertyArgs()
         * @generated
         * @ordered
         */
        protected EList<PropertyArg> propertyArgs;

        /**
         * The cached value of the '{@link #getPropertyReference() <em>Property Reference</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getPropertyReference()
         * @generated
         * @ordered
         */
        protected PropertyReference propertyReference;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected PropertyImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.PROPERTY;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public EList<PropertyArg> getPropertyArgs() {
                if (propertyArgs == null) {
                        propertyArgs = new EObjectContainmentWithInverseEList<PropertyArg>(PropertyArg.class, this, TCSPackage.PROPERTY__PROPERTY_ARGS, TCSPackage.PROPERTY_ARG__PROPERTY);
                }
                return propertyArgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public PropertyReference getPropertyReference() {
                if (propertyReference != null && propertyReference.eIsProxy()) {
                        InternalEObject oldPropertyReference = (InternalEObject)propertyReference;
                        propertyReference = (PropertyReference)eResolveProxy(oldPropertyReference);
                        if (propertyReference != oldPropertyReference) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.PROPERTY__PROPERTY_REFERENCE, oldPropertyReference, propertyReference));
                        }
                }
                return propertyReference;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public PropertyReference basicGetPropertyReference() {
                return propertyReference;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setPropertyReference(PropertyReference newPropertyReference) {
                PropertyReference oldPropertyReference = propertyReference;
                propertyReference = newPropertyReference;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PROPERTY__PROPERTY_REFERENCE, oldPropertyReference, propertyReference));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @SuppressWarnings("unchecked")
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TCSPackage.PROPERTY__PROPERTY_ARGS:
                                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPropertyArgs()).basicAdd(otherEnd, msgs);
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
                        case TCSPackage.PROPERTY__PROPERTY_ARGS:
                                return ((InternalEList<?>)getPropertyArgs()).basicRemove(otherEnd, msgs);
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
                        case TCSPackage.PROPERTY__PROPERTY_ARGS:
                                return getPropertyArgs();
                        case TCSPackage.PROPERTY__PROPERTY_REFERENCE:
                                if (resolve) return getPropertyReference();
                                return basicGetPropertyReference();
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
                        case TCSPackage.PROPERTY__PROPERTY_ARGS:
                                getPropertyArgs().clear();
                                getPropertyArgs().addAll((Collection<? extends PropertyArg>)newValue);
                                return;
                        case TCSPackage.PROPERTY__PROPERTY_REFERENCE:
                                setPropertyReference((PropertyReference)newValue);
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
                        case TCSPackage.PROPERTY__PROPERTY_ARGS:
                                getPropertyArgs().clear();
                                return;
                        case TCSPackage.PROPERTY__PROPERTY_REFERENCE:
                                setPropertyReference((PropertyReference)null);
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
                        case TCSPackage.PROPERTY__PROPERTY_ARGS:
                                return propertyArgs != null && !propertyArgs.isEmpty();
                        case TCSPackage.PROPERTY__PROPERTY_REFERENCE:
                                return propertyReference != null;
                }
                return super.eIsSet(featureID);
        }

} //PropertyImpl
