/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyImpl#getPropertyArgs <em>Property Args</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.PropertyImpl#getPropertyReference <em>Property Reference</em>}</li>
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
     * The cached value of the '{@link #getPropertyReference() <em>Property Reference</em>}' containment reference.
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
            propertyArgs = new EObjectContainmentWithInverseEList.Resolving<PropertyArg>(PropertyArg.class, this, TCSPackage.PROPERTY__PROPERTY_ARGS, TCSPackage.PROPERTY_ARG__PROPERTY);
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
                InternalEObject newPropertyReference = (InternalEObject)propertyReference;
                NotificationChain msgs = oldPropertyReference.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.PROPERTY__PROPERTY_REFERENCE, null, null);
                if (newPropertyReference.eInternalContainer() == null) {
                    msgs = newPropertyReference.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.PROPERTY__PROPERTY_REFERENCE, null, msgs);
                }
                if (msgs != null) msgs.dispatch();
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
    public NotificationChain basicSetPropertyReference(PropertyReference newPropertyReference, NotificationChain msgs) {
        PropertyReference oldPropertyReference = propertyReference;
        propertyReference = newPropertyReference;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.PROPERTY__PROPERTY_REFERENCE, oldPropertyReference, newPropertyReference);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setPropertyReference(PropertyReference newPropertyReference) {
        if (newPropertyReference != propertyReference) {
            NotificationChain msgs = null;
            if (propertyReference != null)
                msgs = ((InternalEObject)propertyReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.PROPERTY__PROPERTY_REFERENCE, null, msgs);
            if (newPropertyReference != null)
                msgs = ((InternalEObject)newPropertyReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TCSPackage.PROPERTY__PROPERTY_REFERENCE, null, msgs);
            msgs = basicSetPropertyReference(newPropertyReference, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.PROPERTY__PROPERTY_REFERENCE, newPropertyReference, newPropertyReference));
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
            case TCSPackage.PROPERTY__PROPERTY_REFERENCE:
                return basicSetPropertyReference(null, msgs);
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
