/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
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
 * An implementation of the model object '<em><b>Alternative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AlternativeImpl#getSequences <em>Sequences</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.AlternativeImpl#isIsMulti <em>Is Multi</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlternativeImpl extends SequenceElementImpl implements Alternative {
        /**
     * The cached value of the '{@link #getSequences() <em>Sequences</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getSequences()
     * @generated
     * @ordered
     */
        protected EList<SequenceInAlternative> sequences;

        /**
     * The default value of the '{@link #isIsMulti() <em>Is Multi</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsMulti()
     * @generated
     * @ordered
     */
        protected static final boolean IS_MULTI_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isIsMulti() <em>Is Multi</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isIsMulti()
     * @generated
     * @ordered
     */
        protected boolean isMulti = IS_MULTI_EDEFAULT;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected AlternativeImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.ALTERNATIVE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<SequenceInAlternative> getSequences() {
        if (sequences == null) {
            sequences = new EObjectContainmentWithInverseEList<SequenceInAlternative>(SequenceInAlternative.class, this, TCSPackage.ALTERNATIVE__SEQUENCES, TCSPackage.SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER);
        }
        return sequences;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isIsMulti() {
        return isMulti;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setIsMulti(boolean newIsMulti) {
        boolean oldIsMulti = isMulti;
        isMulti = newIsMulti;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.ALTERNATIVE__IS_MULTI, oldIsMulti, isMulti));
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
            case TCSPackage.ALTERNATIVE__SEQUENCES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getSequences()).basicAdd(otherEnd, msgs);
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
            case TCSPackage.ALTERNATIVE__SEQUENCES:
                return ((InternalEList<?>)getSequences()).basicRemove(otherEnd, msgs);
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
            case TCSPackage.ALTERNATIVE__SEQUENCES:
                return getSequences();
            case TCSPackage.ALTERNATIVE__IS_MULTI:
                return isIsMulti();
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
            case TCSPackage.ALTERNATIVE__SEQUENCES:
                getSequences().clear();
                getSequences().addAll((Collection<? extends SequenceInAlternative>)newValue);
                return;
            case TCSPackage.ALTERNATIVE__IS_MULTI:
                setIsMulti((Boolean)newValue);
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
            case TCSPackage.ALTERNATIVE__SEQUENCES:
                getSequences().clear();
                return;
            case TCSPackage.ALTERNATIVE__IS_MULTI:
                setIsMulti(IS_MULTI_EDEFAULT);
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
            case TCSPackage.ALTERNATIVE__SEQUENCES:
                return sequences != null && !sequences.isEmpty();
            case TCSPackage.ALTERNATIVE__IS_MULTI:
                return isMulti != IS_MULTI_EDEFAULT;
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
        result.append(" (isMulti: ");
        result.append(isMulti);
        result.append(')');
        return result.toString();
    }

} //AlternativeImpl
