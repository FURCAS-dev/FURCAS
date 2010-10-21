/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumerationTemplateImpl#isAutomatic <em>Automatic</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.EnumerationTemplateImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationTemplateImpl extends TemplateImpl implements EnumerationTemplate {
        /**
     * The default value of the '{@link #isAutomatic() <em>Automatic</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isAutomatic()
     * @generated
     * @ordered
     */
        protected static final boolean AUTOMATIC_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isAutomatic() <em>Automatic</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isAutomatic()
     * @generated
     * @ordered
     */
        protected boolean automatic = AUTOMATIC_EDEFAULT;

        /**
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getMappings()
     * @generated
     * @ordered
     */
        protected EList<EnumLiteralMapping> mappings;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected EnumerationTemplateImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.ENUMERATION_TEMPLATE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isAutomatic() {
        return automatic;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setAutomatic(boolean newAutomatic) {
        boolean oldAutomatic = automatic;
        automatic = newAutomatic;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.ENUMERATION_TEMPLATE__AUTOMATIC, oldAutomatic, automatic));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<EnumLiteralMapping> getMappings() {
        if (mappings == null) {
            mappings = new EObjectContainmentEList<EnumLiteralMapping>(EnumLiteralMapping.class, this, TCSPackage.ENUMERATION_TEMPLATE__MAPPINGS);
        }
        return mappings;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.ENUMERATION_TEMPLATE__MAPPINGS:
                return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
            case TCSPackage.ENUMERATION_TEMPLATE__AUTOMATIC:
                return isAutomatic();
            case TCSPackage.ENUMERATION_TEMPLATE__MAPPINGS:
                return getMappings();
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
            case TCSPackage.ENUMERATION_TEMPLATE__AUTOMATIC:
                setAutomatic((Boolean)newValue);
                return;
            case TCSPackage.ENUMERATION_TEMPLATE__MAPPINGS:
                getMappings().clear();
                getMappings().addAll((Collection<? extends EnumLiteralMapping>)newValue);
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
            case TCSPackage.ENUMERATION_TEMPLATE__AUTOMATIC:
                setAutomatic(AUTOMATIC_EDEFAULT);
                return;
            case TCSPackage.ENUMERATION_TEMPLATE__MAPPINGS:
                getMappings().clear();
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
            case TCSPackage.ENUMERATION_TEMPLATE__AUTOMATIC:
                return automatic != AUTOMATIC_EDEFAULT;
            case TCSPackage.ENUMERATION_TEMPLATE__MAPPINGS:
                return mappings != null && !mappings.isEmpty();
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
        result.append(" (automatic: ");
        result.append(automatic);
        result.append(')');
        return result.toString();
    }

} //EnumerationTemplateImpl
