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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getTemplateContainer <em>Template Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getPrefixContainer <em>Prefix Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getFunctionContainer <em>Function Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getBlockContainer <em>Block Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getThenContainer <em>Then Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getElseContainer <em>Else Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getSeparatorContainer <em>Separator Container</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.SequenceImpl#getOtContainer <em>Ot Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SequenceImpl extends LocatedElementImpl implements Sequence {
        /**
     * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getElements()
     * @generated
     * @ordered
     */
        protected EList<SequenceElement> elements;

        /**
     * The cached value of the '{@link #getTemplateContainer() <em>Template Container</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTemplateContainer()
     * @generated
     * @ordered
     */
    protected ClassTemplate templateContainer;
        /**
     * The cached value of the '{@link #getPrefixContainer() <em>Prefix Container</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefixContainer()
     * @generated
     * @ordered
     */
    protected ClassTemplate prefixContainer;
        /**
     * The cached value of the '{@link #getOtContainer() <em>Ot Container</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtContainer()
     * @generated
     * @ordered
     */
    protected OperatorTemplate otContainer;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected SequenceImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.SEQUENCE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<SequenceElement> getElements() {
        if (elements == null) {
            elements = new EObjectContainmentWithInverseEList<SequenceElement>(SequenceElement.class, this, TCSPackage.SEQUENCE__ELEMENTS, TCSPackage.SEQUENCE_ELEMENT__ELEMENT_SEQUENCE);
        }
        return elements;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ClassTemplate getTemplateContainer() {
        if (templateContainer != null && templateContainer.eIsProxy()) {
            InternalEObject oldTemplateContainer = (InternalEObject)templateContainer;
            templateContainer = (ClassTemplate)eResolveProxy(oldTemplateContainer);
            if (templateContainer != oldTemplateContainer) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.SEQUENCE__TEMPLATE_CONTAINER, oldTemplateContainer, templateContainer));
            }
        }
        return templateContainer;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassTemplate basicGetTemplateContainer() {
        return templateContainer;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setTemplateContainer(ClassTemplate newTemplateContainer) {
        ClassTemplate oldTemplateContainer = templateContainer;
        templateContainer = newTemplateContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__TEMPLATE_CONTAINER, oldTemplateContainer, templateContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ClassTemplate getPrefixContainer() {
        if (prefixContainer != null && prefixContainer.eIsProxy()) {
            InternalEObject oldPrefixContainer = (InternalEObject)prefixContainer;
            prefixContainer = (ClassTemplate)eResolveProxy(oldPrefixContainer);
            if (prefixContainer != oldPrefixContainer) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.SEQUENCE__PREFIX_CONTAINER, oldPrefixContainer, prefixContainer));
            }
        }
        return prefixContainer;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassTemplate basicGetPrefixContainer() {
        return prefixContainer;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setPrefixContainer(ClassTemplate newPrefixContainer) {
        ClassTemplate oldPrefixContainer = prefixContainer;
        prefixContainer = newPrefixContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__PREFIX_CONTAINER, oldPrefixContainer, prefixContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public FunctionTemplate getFunctionContainer() {
        if (eContainerFeatureID() != TCSPackage.SEQUENCE__FUNCTION_CONTAINER) return null;
        return (FunctionTemplate)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetFunctionContainer(FunctionTemplate newFunctionContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newFunctionContainer, TCSPackage.SEQUENCE__FUNCTION_CONTAINER, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setFunctionContainer(FunctionTemplate newFunctionContainer) {
        if (newFunctionContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__FUNCTION_CONTAINER && newFunctionContainer != null)) {
            if (EcoreUtil.isAncestor(this, newFunctionContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newFunctionContainer != null)
                msgs = ((InternalEObject)newFunctionContainer).eInverseAdd(this, TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE, FunctionTemplate.class, msgs);
            msgs = basicSetFunctionContainer(newFunctionContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__FUNCTION_CONTAINER, newFunctionContainer, newFunctionContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Block getBlockContainer() {
        if (eContainerFeatureID() != TCSPackage.SEQUENCE__BLOCK_CONTAINER) return null;
        return (Block)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetBlockContainer(Block newBlockContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newBlockContainer, TCSPackage.SEQUENCE__BLOCK_CONTAINER, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setBlockContainer(Block newBlockContainer) {
        if (newBlockContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__BLOCK_CONTAINER && newBlockContainer != null)) {
            if (EcoreUtil.isAncestor(this, newBlockContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newBlockContainer != null)
                msgs = ((InternalEObject)newBlockContainer).eInverseAdd(this, TCSPackage.BLOCK__BLOCK_SEQUENCE, Block.class, msgs);
            msgs = basicSetBlockContainer(newBlockContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__BLOCK_CONTAINER, newBlockContainer, newBlockContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ConditionalElement getThenContainer() {
        if (eContainerFeatureID() != TCSPackage.SEQUENCE__THEN_CONTAINER) return null;
        return (ConditionalElement)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetThenContainer(ConditionalElement newThenContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newThenContainer, TCSPackage.SEQUENCE__THEN_CONTAINER, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setThenContainer(ConditionalElement newThenContainer) {
        if (newThenContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__THEN_CONTAINER && newThenContainer != null)) {
            if (EcoreUtil.isAncestor(this, newThenContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newThenContainer != null)
                msgs = ((InternalEObject)newThenContainer).eInverseAdd(this, TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE, ConditionalElement.class, msgs);
            msgs = basicSetThenContainer(newThenContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__THEN_CONTAINER, newThenContainer, newThenContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public ConditionalElement getElseContainer() {
        if (eContainerFeatureID() != TCSPackage.SEQUENCE__ELSE_CONTAINER) return null;
        return (ConditionalElement)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetElseContainer(ConditionalElement newElseContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newElseContainer, TCSPackage.SEQUENCE__ELSE_CONTAINER, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setElseContainer(ConditionalElement newElseContainer) {
        if (newElseContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__ELSE_CONTAINER && newElseContainer != null)) {
            if (EcoreUtil.isAncestor(this, newElseContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newElseContainer != null)
                msgs = ((InternalEObject)newElseContainer).eInverseAdd(this, TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE, ConditionalElement.class, msgs);
            msgs = basicSetElseContainer(newElseContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__ELSE_CONTAINER, newElseContainer, newElseContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public SeparatorPArg getSeparatorContainer() {
        if (eContainerFeatureID() != TCSPackage.SEQUENCE__SEPARATOR_CONTAINER) return null;
        return (SeparatorPArg)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetSeparatorContainer(SeparatorPArg newSeparatorContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSeparatorContainer, TCSPackage.SEQUENCE__SEPARATOR_CONTAINER, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setSeparatorContainer(SeparatorPArg newSeparatorContainer) {
        if (newSeparatorContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__SEPARATOR_CONTAINER && newSeparatorContainer != null)) {
            if (EcoreUtil.isAncestor(this, newSeparatorContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSeparatorContainer != null)
                msgs = ((InternalEObject)newSeparatorContainer).eInverseAdd(this, TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE, SeparatorPArg.class, msgs);
            msgs = basicSetSeparatorContainer(newSeparatorContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__SEPARATOR_CONTAINER, newSeparatorContainer, newSeparatorContainer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public OperatorTemplate getOtContainer() {
        if (otContainer != null && otContainer.eIsProxy()) {
            InternalEObject oldOtContainer = (InternalEObject)otContainer;
            otContainer = (OperatorTemplate)eResolveProxy(oldOtContainer);
            if (otContainer != oldOtContainer) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TCSPackage.SEQUENCE__OT_CONTAINER, oldOtContainer, otContainer));
            }
        }
        return otContainer;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperatorTemplate basicGetOtContainer() {
        return otContainer;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setOtContainer(OperatorTemplate newOtContainer) {
        OperatorTemplate oldOtContainer = otContainer;
        otContainer = newOtContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__OT_CONTAINER, oldOtContainer, otContainer));
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
            case TCSPackage.SEQUENCE__ELEMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetFunctionContainer((FunctionTemplate)otherEnd, msgs);
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetBlockContainer((Block)otherEnd, msgs);
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetThenContainer((ConditionalElement)otherEnd, msgs);
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetElseContainer((ConditionalElement)otherEnd, msgs);
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSeparatorContainer((SeparatorPArg)otherEnd, msgs);
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
            case TCSPackage.SEQUENCE__ELEMENTS:
                return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                return basicSetFunctionContainer(null, msgs);
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                return basicSetBlockContainer(null, msgs);
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                return basicSetThenContainer(null, msgs);
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                return basicSetElseContainer(null, msgs);
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                return basicSetSeparatorContainer(null, msgs);
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
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                return eInternalContainer().eInverseRemove(this, TCSPackage.FUNCTION_TEMPLATE__FUNCTION_SEQUENCE, FunctionTemplate.class, msgs);
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                return eInternalContainer().eInverseRemove(this, TCSPackage.BLOCK__BLOCK_SEQUENCE, Block.class, msgs);
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                return eInternalContainer().eInverseRemove(this, TCSPackage.CONDITIONAL_ELEMENT__THEN_SEQUENCE, ConditionalElement.class, msgs);
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                return eInternalContainer().eInverseRemove(this, TCSPackage.CONDITIONAL_ELEMENT__ELSE_SEQUENCE, ConditionalElement.class, msgs);
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                return eInternalContainer().eInverseRemove(this, TCSPackage.SEPARATOR_PARG__SEPARATOR_SEQUENCE, SeparatorPArg.class, msgs);
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
            case TCSPackage.SEQUENCE__ELEMENTS:
                return getElements();
            case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
                if (resolve) return getTemplateContainer();
                return basicGetTemplateContainer();
            case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
                if (resolve) return getPrefixContainer();
                return basicGetPrefixContainer();
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                return getFunctionContainer();
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                return getBlockContainer();
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                return getThenContainer();
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                return getElseContainer();
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                return getSeparatorContainer();
            case TCSPackage.SEQUENCE__OT_CONTAINER:
                if (resolve) return getOtContainer();
                return basicGetOtContainer();
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
            case TCSPackage.SEQUENCE__ELEMENTS:
                getElements().clear();
                getElements().addAll((Collection<? extends SequenceElement>)newValue);
                return;
            case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
                setTemplateContainer((ClassTemplate)newValue);
                return;
            case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
                setPrefixContainer((ClassTemplate)newValue);
                return;
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                setFunctionContainer((FunctionTemplate)newValue);
                return;
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                setBlockContainer((Block)newValue);
                return;
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                setThenContainer((ConditionalElement)newValue);
                return;
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                setElseContainer((ConditionalElement)newValue);
                return;
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                setSeparatorContainer((SeparatorPArg)newValue);
                return;
            case TCSPackage.SEQUENCE__OT_CONTAINER:
                setOtContainer((OperatorTemplate)newValue);
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
            case TCSPackage.SEQUENCE__ELEMENTS:
                getElements().clear();
                return;
            case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
                setTemplateContainer((ClassTemplate)null);
                return;
            case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
                setPrefixContainer((ClassTemplate)null);
                return;
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                setFunctionContainer((FunctionTemplate)null);
                return;
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                setBlockContainer((Block)null);
                return;
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                setThenContainer((ConditionalElement)null);
                return;
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                setElseContainer((ConditionalElement)null);
                return;
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                setSeparatorContainer((SeparatorPArg)null);
                return;
            case TCSPackage.SEQUENCE__OT_CONTAINER:
                setOtContainer((OperatorTemplate)null);
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
            case TCSPackage.SEQUENCE__ELEMENTS:
                return elements != null && !elements.isEmpty();
            case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
                return templateContainer != null;
            case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
                return prefixContainer != null;
            case TCSPackage.SEQUENCE__FUNCTION_CONTAINER:
                return getFunctionContainer() != null;
            case TCSPackage.SEQUENCE__BLOCK_CONTAINER:
                return getBlockContainer() != null;
            case TCSPackage.SEQUENCE__THEN_CONTAINER:
                return getThenContainer() != null;
            case TCSPackage.SEQUENCE__ELSE_CONTAINER:
                return getElseContainer() != null;
            case TCSPackage.SEQUENCE__SEPARATOR_CONTAINER:
                return getSeparatorContainer() != null;
            case TCSPackage.SEQUENCE__OT_CONTAINER:
                return otContainer != null;
        }
        return super.eIsSet(featureID);
    }

} //SequenceImpl
