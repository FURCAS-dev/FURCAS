/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

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
 * An implementation of the model object '<em><b>Operator List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorListImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.OperatorListImpl#getPriorities <em>Priorities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatorListImpl extends LocatedElementImpl implements OperatorList {
        /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
        protected static final String NAME_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
        protected String name = NAME_EDEFAULT;

        /**
     * The cached value of the '{@link #getPriorities() <em>Priorities</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getPriorities()
     * @generated
     * @ordered
     */
        protected EList<Priority> priorities;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected OperatorListImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.OPERATOR_LIST;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getName() {
        return name;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.OPERATOR_LIST__NAME, oldName, name));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<Priority> getPriorities() {
        if (priorities == null) {
            priorities = new EObjectContainmentWithInverseEList<Priority>(Priority.class, this, TCSPackage.OPERATOR_LIST__PRIORITIES, TCSPackage.PRIORITY__LIST);
        }
        return priorities;
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
            case TCSPackage.OPERATOR_LIST__PRIORITIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPriorities()).basicAdd(otherEnd, msgs);
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
            case TCSPackage.OPERATOR_LIST__PRIORITIES:
                return ((InternalEList<?>)getPriorities()).basicRemove(otherEnd, msgs);
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
            case TCSPackage.OPERATOR_LIST__NAME:
                return getName();
            case TCSPackage.OPERATOR_LIST__PRIORITIES:
                return getPriorities();
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
            case TCSPackage.OPERATOR_LIST__NAME:
                setName((String)newValue);
                return;
            case TCSPackage.OPERATOR_LIST__PRIORITIES:
                getPriorities().clear();
                getPriorities().addAll((Collection<? extends Priority>)newValue);
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
            case TCSPackage.OPERATOR_LIST__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TCSPackage.OPERATOR_LIST__PRIORITIES:
                getPriorities().clear();
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
            case TCSPackage.OPERATOR_LIST__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TCSPackage.OPERATOR_LIST__PRIORITIES:
                return priorities != null && !priorities.isEmpty();
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
        result.append(" (name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //OperatorListImpl
