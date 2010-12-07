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

import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Expression;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl#getThenSequence <em>Then Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConditionalElementImpl#getElseSequence <em>Else Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalElementImpl extends SequenceElementImpl implements ConditionalElement {
        /**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
        protected Expression condition;

        /**
     * The cached value of the '{@link #getThenSequence() <em>Then Sequence</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getThenSequence()
     * @generated
     * @ordered
     */
        protected Sequence thenSequence;

        /**
     * The cached value of the '{@link #getElseSequence() <em>Else Sequence</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getElseSequence()
     * @generated
     * @ordered
     */
        protected Sequence elseSequence;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected ConditionalElementImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.CONDITIONAL_ELEMENT;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Expression getCondition() {
        return condition;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
        Expression oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CONDITIONAL_ELEMENT__CONDITION, oldCondition, newCondition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setCondition(Expression newCondition) {
        if (newCondition != condition) {
            NotificationChain msgs = null;
            if (condition != null)
                msgs = ((InternalEObject)condition).eInverseRemove(this, TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT, Expression.class, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject)newCondition).eInverseAdd(this, TCSPackage.EXPRESSION__CONDITIONAL_ELEMENT, Expression.class, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONDITIONAL_ELEMENT__CONDITION, newCondition, newCondition));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Sequence getThenSequence() {
        return thenSequence;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetThenSequence(Sequence newThenSequence, NotificationChain msgs) {
        Sequence oldThenSequence = thenSequence;
        thenSequence = newThenSequence;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE, oldThenSequence, newThenSequence);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setThenSequence(Sequence newThenSequence) {
        if (newThenSequence != thenSequence) {
            NotificationChain msgs = null;
            if (thenSequence != null)
                msgs = ((InternalEObject)thenSequence).eInverseRemove(this, TCSPackage.SEQUENCE__THEN_CONTAINER, Sequence.class, msgs);
            if (newThenSequence != null)
                msgs = ((InternalEObject)newThenSequence).eInverseAdd(this, TCSPackage.SEQUENCE__THEN_CONTAINER, Sequence.class, msgs);
            msgs = basicSetThenSequence(newThenSequence, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE, newThenSequence, newThenSequence));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Sequence getElseSequence() {
        return elseSequence;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetElseSequence(Sequence newElseSequence, NotificationChain msgs) {
        Sequence oldElseSequence = elseSequence;
        elseSequence = newElseSequence;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE, oldElseSequence, newElseSequence);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setElseSequence(Sequence newElseSequence) {
        if (newElseSequence != elseSequence) {
            NotificationChain msgs = null;
            if (elseSequence != null)
                msgs = ((InternalEObject)elseSequence).eInverseRemove(this, TCSPackage.SEQUENCE__ELSE_CONTAINER, Sequence.class, msgs);
            if (newElseSequence != null)
                msgs = ((InternalEObject)newElseSequence).eInverseAdd(this, TCSPackage.SEQUENCE__ELSE_CONTAINER, Sequence.class, msgs);
            msgs = basicSetElseSequence(newElseSequence, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE, newElseSequence, newElseSequence));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
                if (condition != null)
                    msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONDITIONAL_ELEMENT__CONDITION, null, msgs);
                return basicSetCondition((Expression)otherEnd, msgs);
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
                if (thenSequence != null)
                    msgs = ((InternalEObject)thenSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE, null, msgs);
                return basicSetThenSequence((Sequence)otherEnd, msgs);
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
                if (elseSequence != null)
                    msgs = ((InternalEObject)elseSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE, null, msgs);
                return basicSetElseSequence((Sequence)otherEnd, msgs);
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
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
                return basicSetCondition(null, msgs);
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
                return basicSetThenSequence(null, msgs);
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
                return basicSetElseSequence(null, msgs);
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
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
                return getCondition();
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
                return getThenSequence();
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
                return getElseSequence();
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
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
                setCondition((Expression)newValue);
                return;
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
                setThenSequence((Sequence)newValue);
                return;
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
                setElseSequence((Sequence)newValue);
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
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
                setCondition((Expression)null);
                return;
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
                setThenSequence((Sequence)null);
                return;
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
                setElseSequence((Sequence)null);
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
            case TCSPackage.CONDITIONAL_ELEMENT__CONDITION:
                return condition != null;
            case TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE:
                return thenSequence != null;
            case TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE:
                return elseSequence != null;
        }
        return super.eIsSet(featureID);
    }

} //ConditionalElementImpl
