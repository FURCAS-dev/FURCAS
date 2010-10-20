/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceElementImpl#getElementSequence <em>Element Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceElementImpl#getParentTemplate <em>Parent Template</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SequenceElementImpl extends LocatedElementImpl implements SequenceElement {
        /**
         * The cached value of the '{@link #getParentTemplate() <em>Parent Template</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #getParentTemplate()
         * @generated
         * @ordered
         */
        protected Template parentTemplate;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected SequenceElementImpl() {
                super();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        protected EClass eStaticClass() {
                return TCSPackage.Literals.SEQUENCE_ELEMENT;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Sequence getElementSequence() {
                if (eContainerFeatureID() != TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE) return null;
                return (Sequence)eContainer();
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public NotificationChain basicSetElementSequence(Sequence newElementSequence, NotificationChain msgs) {
                msgs = eBasicSetContainer((InternalEObject)newElementSequence, TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE, msgs);
                return msgs;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setElementSequence(Sequence newElementSequence) {
                if (newElementSequence != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE && newElementSequence != null)) {
                        if (EcoreUtil.isAncestor(this, newElementSequence))
                                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
                        NotificationChain msgs = null;
                        if (eInternalContainer() != null)
                                msgs = eBasicRemoveFromContainer(msgs);
                        if (newElementSequence != null)
                                msgs = ((InternalEObject)newElementSequence).eInverseAdd(this, TCSPackage.SEQUENCE__ELEMENTS, Sequence.class, msgs);
                        msgs = basicSetElementSequence(newElementSequence, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE, newElementSequence, newElementSequence));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Template getParentTemplate() {
                if (parentTemplate != null && parentTemplate.eIsProxy()) {
                        InternalEObject oldParentTemplate = (InternalEObject)parentTemplate;
                        parentTemplate = (Template)eResolveProxy(oldParentTemplate);
                        if (parentTemplate != oldParentTemplate) {
                                if (eNotificationRequired())
                                        eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.SEQUENCE_ELEMENT__PARENT_TEMPLATE, oldParentTemplate, parentTemplate));
                        }
                }
                return parentTemplate;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Template basicGetParentTemplate() {
                return parentTemplate;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public void setParentTemplate(Template newParentTemplate) {
                Template oldParentTemplate = parentTemplate;
                parentTemplate = newParentTemplate;
                if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE_ELEMENT__PARENT_TEMPLATE, oldParentTemplate, parentTemplate));
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                if (eInternalContainer() != null)
                                        msgs = eBasicRemoveFromContainer(msgs);
                                return basicSetElementSequence((Sequence)otherEnd, msgs);
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
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                return basicSetElementSequence(null, msgs);
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
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                return eInternalContainer().eInverseRemove(this, TCSPackage.SEQUENCE__ELEMENTS, Sequence.class, msgs);
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
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                return getElementSequence();
                        case TCSPackage.SEQUENCE_ELEMENT__PARENT_TEMPLATE:
                                if (resolve) return getParentTemplate();
                                return basicGetParentTemplate();
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
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                setElementSequence((Sequence)newValue);
                                return;
                        case TCSPackage.SEQUENCE_ELEMENT__PARENT_TEMPLATE:
                                setParentTemplate((Template)newValue);
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
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                setElementSequence((Sequence)null);
                                return;
                        case TCSPackage.SEQUENCE_ELEMENT__PARENT_TEMPLATE:
                                setParentTemplate((Template)null);
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
                        case TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE:
                                return getElementSequence() != null;
                        case TCSPackage.SEQUENCE_ELEMENT__PARENT_TEMPLATE:
                                return parentTemplate != null;
                }
                return super.eIsSet(featureID);
        }

} //SequenceElementImpl
