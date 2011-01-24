/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TemplateSignatureCSImpl.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

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
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Signature CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateSignatureCSImpl#getOwningTemplateElement <em>Owning Template Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateSignatureCSImpl#getOwnedTemplateParameter <em>Owned Template Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateSignatureCSImpl extends MonikeredElementCSImpl implements TemplateSignatureCS {
	/**
	 * The cached value of the '{@link #getOwnedTemplateParameter() <em>Owned Template Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameterCS> ownedTemplateParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateSignatureCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.TEMPLATE_SIGNATURE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateableElementCS getOwningTemplateElement() {
		if (eContainerFeatureID() != BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT) return null;
		return (TemplateableElementCS)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateElement(TemplateableElementCS newOwningTemplateElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateElement, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningTemplateElement(TemplateableElementCS newOwningTemplateElement) {
		if (newOwningTemplateElement != eInternalContainer() || (eContainerFeatureID() != BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT && newOwningTemplateElement != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningTemplateElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateElement != null)
				msgs = ((InternalEObject)newOwningTemplateElement).eInverseAdd(this, BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE, TemplateableElementCS.class, msgs);
			msgs = basicSetOwningTemplateElement(newOwningTemplateElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT, newOwningTemplateElement, newOwningTemplateElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateParameterCS> getOwnedTemplateParameter() {
		if (ownedTemplateParameter == null)
		{
			ownedTemplateParameter = new EObjectContainmentWithInverseEList<TemplateParameterCS>(TemplateParameterCS.class, this, BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER, BaseCSTPackage.TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE);
		}
		return ownedTemplateParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateElement((TemplateableElementCS)otherEnd, msgs);
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTemplateParameter()).basicAdd(otherEnd, msgs);
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
		switch (featureID)
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				return basicSetOwningTemplateElement(null, msgs);
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER:
				return ((InternalEList<?>)getOwnedTemplateParameter()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID())
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, BaseCSTPackage.TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE, TemplateableElementCS.class, msgs);
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
		switch (featureID)
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				return getOwningTemplateElement();
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER:
				return getOwnedTemplateParameter();
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
		switch (featureID)
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				setOwningTemplateElement((TemplateableElementCS)newValue);
				return;
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER:
				getOwnedTemplateParameter().clear();
				getOwnedTemplateParameter().addAll((Collection<? extends TemplateParameterCS>)newValue);
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
		switch (featureID)
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				setOwningTemplateElement((TemplateableElementCS)null);
				return;
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER:
				getOwnedTemplateParameter().clear();
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
		switch (featureID)
		{
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT:
				return getOwningTemplateElement() != null;
			case BaseCSTPackage.TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER:
				return ownedTemplateParameter != null && !ownedTemplateParameter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitTemplateSignatureCS(this);
	}
} //TemplateSignatureCSImpl
