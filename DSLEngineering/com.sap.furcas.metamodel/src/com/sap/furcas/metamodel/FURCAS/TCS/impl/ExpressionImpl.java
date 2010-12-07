/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Expression;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ExpressionImpl#getConditionalElement <em>Conditional Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ExpressionImpl extends LocatedElementImpl implements Expression {
        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected ExpressionImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.EXPRESSION;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ConditionalElement getConditionalElement() {
        if (eContainerFeatureID() != TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT) return null;
        return (ConditionalElement)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetConditionalElement(ConditionalElement newConditionalElement, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newConditionalElement, TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setConditionalElement(ConditionalElement newConditionalElement) {
        if (newConditionalElement != eInternalContainer() || (eContainerFeatureID() != TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT && newConditionalElement != null)) {
            if (EcoreUtil.isAncestor(this, newConditionalElement))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newConditionalElement != null)
                msgs = ((InternalEObject)newConditionalElement).eInverseAdd(this, TCSPackage.CONDITIONAL_ELEMENT__CONDITION, ConditionalElement.class, msgs);
            msgs = basicSetConditionalElement(newConditionalElement, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT, newConditionalElement, newConditionalElement));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetConditionalElement((ConditionalElement)otherEnd, msgs);
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
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                return basicSetConditionalElement(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                return eInternalContainer().eInverseRemove(this, TCSPackage.CONDITIONAL_ELEMENT__CONDITION, ConditionalElement.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                return getConditionalElement();
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
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                setConditionalElement((ConditionalElement)newValue);
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
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                setConditionalElement((ConditionalElement)null);
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
            case TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT:
                return getConditionalElement() != null;
        }
        return super.eIsSet(featureID);
    }

} //ExpressionImpl
