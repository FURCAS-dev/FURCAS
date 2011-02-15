/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: NamespaceRefCSImpl.java,v 1.1 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.pivot.Namespace;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespace Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamespaceRefCSImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamespaceRefCSImpl#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamespaceRefCSImpl extends ElementCSImpl implements NamespaceRefCS
{
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected Namespace ref;

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
	protected NamespaceRefCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return BaseCSTPackage.Literals.NAMESPACE_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace getRef()
	{
		if (ref != null && ((EObject)ref).eIsProxy())
		{
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (Namespace)eResolveProxy(oldRef);
			if (ref != oldRef)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.NAMESPACE_REF_CS__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Namespace basicGetRef()
	{
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(Namespace newRef)
	{
		Namespace oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.NAMESPACE_REF_CS__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateBindingCS getOwnedTemplateBinding()
	{
		return ownedTemplateBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTemplateBinding(TemplateBindingCS newOwnedTemplateBinding, NotificationChain msgs)
	{
		TemplateBindingCS oldOwnedTemplateBinding = ownedTemplateBinding;
		ownedTemplateBinding = newOwnedTemplateBinding;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING, oldOwnedTemplateBinding, newOwnedTemplateBinding);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedTemplateBinding(TemplateBindingCS newOwnedTemplateBinding)
	{
		if (newOwnedTemplateBinding != ownedTemplateBinding)
		{
			NotificationChain msgs = null;
			if (ownedTemplateBinding != null)
				msgs = ((InternalEObject)ownedTemplateBinding).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING, null, msgs);
			if (newOwnedTemplateBinding != null)
				msgs = ((InternalEObject)newOwnedTemplateBinding).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING, null, msgs);
			msgs = basicSetOwnedTemplateBinding(newOwnedTemplateBinding, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING, newOwnedTemplateBinding, newOwnedTemplateBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case BaseCSTPackage.NAMESPACE_REF_CS__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING:
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSTPackage.NAMESPACE_REF_CS__REF:
				setRef((Namespace)newValue);
				return;
			case BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING:
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case BaseCSTPackage.NAMESPACE_REF_CS__REF:
				setRef((Namespace)null);
				return;
			case BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING:
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case BaseCSTPackage.NAMESPACE_REF_CS__REF:
				return ref != null;
			case BaseCSTPackage.NAMESPACE_REF_CS__OWNED_TEMPLATE_BINDING:
				return ownedTemplateBinding != null;
		}
		return super.eIsSet(featureID);
	}

} //NamespaceRefCSImpl
