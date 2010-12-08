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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreach Predicate Property Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForeachPredicatePropertyInitImpl#getPredicateSemantic <em>Predicate Semantic</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ForeachPredicatePropertyInitImpl#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeachPredicatePropertyInitImpl extends PropertyInitImpl implements ForeachPredicatePropertyInit {
        /**
     * The cached value of the '{@link #getPredicateSemantic() <em>Predicate Semantic</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getPredicateSemantic()
     * @generated
     * @ordered
     */
        protected EList<PredicateSemantic> predicateSemantic;

        /**
     * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getMode()
     * @generated
     * @ordered
     */
        protected static final String MODE_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getMode()
     * @generated
     * @ordered
     */
        protected String mode = MODE_EDEFAULT;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected ForeachPredicatePropertyInitImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.FOREACH_PREDICATE_PROPERTY_INIT;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<PredicateSemantic> getPredicateSemantic() {
        if (predicateSemantic == null) {
            predicateSemantic = new EObjectContainmentEList<PredicateSemantic>(PredicateSemantic.class, this, TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC);
        }
        return predicateSemantic;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getMode() {
        return mode;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setMode(String newMode) {
        String oldMode = mode;
        mode = newMode;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__MODE, oldMode, mode));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
                return ((InternalEList<?>)getPredicateSemantic()).basicRemove(otherEnd, msgs);
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
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
                return getPredicateSemantic();
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__MODE:
                return getMode();
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
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
                getPredicateSemantic().clear();
                getPredicateSemantic().addAll((Collection<? extends PredicateSemantic>)newValue);
                return;
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__MODE:
                setMode((String)newValue);
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
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
                getPredicateSemantic().clear();
                return;
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__MODE:
                setMode(MODE_EDEFAULT);
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
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC:
                return predicateSemantic != null && !predicateSemantic.isEmpty();
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT__MODE:
                return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
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
        result.append(" (mode: ");
        result.append(mode);
        result.append(')');
        return result.toString();
    }

} //ForeachPredicatePropertyInitImpl
