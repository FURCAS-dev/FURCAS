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
		if (eContainerFeatureID() != TCSPackage.SEQUENCE__TEMPLATE_CONTAINER) return null;
		return (ClassTemplate)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetTemplateContainer(ClassTemplate newTemplateContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTemplateContainer, TCSPackage.SEQUENCE__TEMPLATE_CONTAINER, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setTemplateContainer(ClassTemplate newTemplateContainer) {
		if (newTemplateContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__TEMPLATE_CONTAINER && newTemplateContainer != null)) {
			if (EcoreUtil.isAncestor(this, newTemplateContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTemplateContainer != null)
				msgs = ((InternalEObject)newTemplateContainer).eInverseAdd(this, TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE, ClassTemplate.class, msgs);
			msgs = basicSetTemplateContainer(newTemplateContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__TEMPLATE_CONTAINER, newTemplateContainer, newTemplateContainer));
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public ClassTemplate getPrefixContainer() {
		if (eContainerFeatureID() != TCSPackage.SEQUENCE__PREFIX_CONTAINER) return null;
		return (ClassTemplate)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetPrefixContainer(ClassTemplate newPrefixContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPrefixContainer, TCSPackage.SEQUENCE__PREFIX_CONTAINER, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setPrefixContainer(ClassTemplate newPrefixContainer) {
		if (newPrefixContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__PREFIX_CONTAINER && newPrefixContainer != null)) {
			if (EcoreUtil.isAncestor(this, newPrefixContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPrefixContainer != null)
				msgs = ((InternalEObject)newPrefixContainer).eInverseAdd(this, TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE, ClassTemplate.class, msgs);
			msgs = basicSetPrefixContainer(newPrefixContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__PREFIX_CONTAINER, newPrefixContainer, newPrefixContainer));
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
		if (eContainerFeatureID() != TCSPackage.SEQUENCE__OT_CONTAINER) return null;
		return (OperatorTemplate)eContainer();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public NotificationChain basicSetOtContainer(OperatorTemplate newOtContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOtContainer, TCSPackage.SEQUENCE__OT_CONTAINER, msgs);
		return msgs;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public void setOtContainer(OperatorTemplate newOtContainer) {
		if (newOtContainer != eInternalContainer() || (eContainerFeatureID() != TCSPackage.SEQUENCE__OT_CONTAINER && newOtContainer != null)) {
			if (EcoreUtil.isAncestor(this, newOtContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOtContainer != null)
				msgs = ((InternalEObject)newOtContainer).eInverseAdd(this, TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE, OperatorTemplate.class, msgs);
			msgs = basicSetOtContainer(newOtContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.SEQUENCE__OT_CONTAINER, newOtContainer, newOtContainer));
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
			case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTemplateContainer((ClassTemplate)otherEnd, msgs);
			case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPrefixContainer((ClassTemplate)otherEnd, msgs);
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
			case TCSPackage.SEQUENCE__OT_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOtContainer((OperatorTemplate)otherEnd, msgs);
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
			case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
				return basicSetTemplateContainer(null, msgs);
			case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
				return basicSetPrefixContainer(null, msgs);
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
			case TCSPackage.SEQUENCE__OT_CONTAINER:
				return basicSetOtContainer(null, msgs);
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
			case TCSPackage.SEQUENCE__TEMPLATE_CONTAINER:
				return eInternalContainer().eInverseRemove(this, TCSPackage.CLASS_TEMPLATE__TEMPLATE_SEQUENCE, ClassTemplate.class, msgs);
			case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
				return eInternalContainer().eInverseRemove(this, TCSPackage.CLASS_TEMPLATE__PREFIX_SEQUENCE, ClassTemplate.class, msgs);
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
			case TCSPackage.SEQUENCE__OT_CONTAINER:
				return eInternalContainer().eInverseRemove(this, TCSPackage.OPERATOR_TEMPLATE__OT_SEQUENCE, OperatorTemplate.class, msgs);
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
				return getTemplateContainer();
			case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
				return getPrefixContainer();
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
				return getOtContainer();
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
				return getTemplateContainer() != null;
			case TCSPackage.SEQUENCE__PREFIX_CONTAINER:
				return getPrefixContainer() != null;
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
				return getOtContainer() != null;
		}
		return super.eIsSet(featureID);
	}

} //SequenceImpl
