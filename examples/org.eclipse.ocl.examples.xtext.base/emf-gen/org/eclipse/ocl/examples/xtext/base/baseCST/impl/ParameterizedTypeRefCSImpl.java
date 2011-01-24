/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: ParameterizedTypeRefCSImpl.java,v 1.3 2011/01/24 20:59:32 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.ParameterizedTypeRefCSImpl#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterizedTypeRefCSImpl extends TypedRefCSImpl implements ParameterizedTypeRefCS {
	/**
	 * The cached value of the '{@link #getOwnedTemplateBinding() <em>Owned Template Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTemplateBinding()
	 * @generated
	 * @ordered
	 */
	protected TemplateBindingCS ownedTemplateBinding;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedTypeRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.PARAMETERIZED_TYPE_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCS getOwnedTemplateBinding() {
		return ownedTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateBinding(TemplateBindingCS newOwnedTemplateBinding, NotificationChain msgs) {
		TemplateBindingCS oldOwnedTemplateBinding = ownedTemplateBinding;
		ownedTemplateBinding = newOwnedTemplateBinding;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, oldOwnedTemplateBinding, newOwnedTemplateBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateBinding(TemplateBindingCS newOwnedTemplateBinding) {
		if (newOwnedTemplateBinding != ownedTemplateBinding)
		{
			NotificationChain msgs = null;
			if (ownedTemplateBinding != null)
				msgs = ((InternalEObject)ownedTemplateBinding).eInverseRemove(this, BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT, TemplateBindingCS.class, msgs);
			if (newOwnedTemplateBinding != null)
				msgs = ((InternalEObject)newOwnedTemplateBinding).eInverseAdd(this, BaseCSTPackage.TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT, TemplateBindingCS.class, msgs);
			msgs = basicSetOwnedTemplateBinding(newOwnedTemplateBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, newOwnedTemplateBinding, newOwnedTemplateBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Type getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				if (ownedTemplateBinding != null)
					msgs = ((InternalEObject)ownedTemplateBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING, null, msgs);
				return basicSetOwnedTemplateBinding((TemplateBindingCS)otherEnd, msgs);
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
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				return basicSetOwnedTemplateBinding(null, msgs);
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
		switch (featureID)
		{
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				return getOwnedTemplateBinding();
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
		switch (featureID)
		{
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				setOwnedTemplateBinding((TemplateBindingCS)newValue);
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
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				setOwnedTemplateBinding((TemplateBindingCS)null);
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
			case BaseCSTPackage.PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING:
				return ownedTemplateBinding != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitParameterizedTypeRefCS(this);
	}
	
	@Override
	public Type getPivot() {
		return (Type) pivot;
	}
} //ParameterizedTypeRefCSImpl
