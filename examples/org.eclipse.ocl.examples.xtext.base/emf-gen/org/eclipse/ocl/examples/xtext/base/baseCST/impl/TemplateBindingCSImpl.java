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
 * $Id: TemplateBindingCSImpl.java,v 1.3 2011/02/15 10:36:55 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateBindingCSImpl#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TemplateBindingCSImpl#getOwnedParameterSubstitution <em>Owned Parameter Substitution</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateBindingCSImpl extends ModelElementCSImpl implements TemplateBindingCS {
	/**
	 * The cached value of the '{@link #getOwnedParameterSubstitution() <em>Owned Parameter Substitution</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameterSubstitution()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateParameterSubstitutionCS> ownedParameterSubstitution;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.TEMPLATE_BINDING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedTypeRefCS getOwningTemplateBindableElement() {
		if (eContainerFeatureID() != BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT) return null;
		return (TypedTypeRefCS)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTemplateBindableElement(TypedTypeRefCS newOwningTemplateBindableElement, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newOwningTemplateBindableElement, BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningTemplateBindableElement(TypedTypeRefCS newOwningTemplateBindableElement)
	{
		if (newOwningTemplateBindableElement != eInternalContainer() || (eContainerFeatureID() != BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT && newOwningTemplateBindableElement != null))
		{
			if (EcoreUtil.isAncestor(this, newOwningTemplateBindableElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTemplateBindableElement != null)
				msgs = ((InternalEObject)newOwningTemplateBindableElement).eInverseAdd(this, BaseCSTPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, TypedTypeRefCS.class, msgs);
			msgs = basicSetOwningTemplateBindableElement(newOwningTemplateBindableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT, newOwningTemplateBindableElement, newOwningTemplateBindableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateParameterSubstitutionCS> getOwnedParameterSubstitution() {
		if (ownedParameterSubstitution == null)
		{
			ownedParameterSubstitution = new EObjectContainmentWithInverseEList<TemplateParameterSubstitutionCS>(TemplateParameterSubstitutionCS.class, this, BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION, BaseCSTPackage.TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING);
		}
		return ownedParameterSubstitution;
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTemplateBindableElement((TypedTypeRefCS)otherEnd, msgs);
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedParameterSubstitution()).basicAdd(otherEnd, msgs);
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				return basicSetOwningTemplateBindableElement(null, msgs);
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION:
				return ((InternalEList<?>)getOwnedParameterSubstitution()).basicRemove(otherEnd, msgs);
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, BaseCSTPackage.TYPED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, TypedTypeRefCS.class, msgs);
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				return getOwningTemplateBindableElement();
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION:
				return getOwnedParameterSubstitution();
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				setOwningTemplateBindableElement((TypedTypeRefCS)newValue);
				return;
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION:
				getOwnedParameterSubstitution().clear();
				getOwnedParameterSubstitution().addAll((Collection<? extends TemplateParameterSubstitutionCS>)newValue);
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				setOwningTemplateBindableElement((TypedTypeRefCS)null);
				return;
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION:
				getOwnedParameterSubstitution().clear();
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
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT:
				return getOwningTemplateBindableElement() != null;
			case BaseCSTPackage.TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION:
				return ownedParameterSubstitution != null && !ownedParameterSubstitution.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitTemplateBindingCS(this);
	}
} //TemplateBindingCSImpl
