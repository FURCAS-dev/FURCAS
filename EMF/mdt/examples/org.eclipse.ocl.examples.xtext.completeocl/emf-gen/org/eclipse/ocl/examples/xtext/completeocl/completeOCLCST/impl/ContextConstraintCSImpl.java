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
 * $Id: ContextConstraintCSImpl.java,v 1.1 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.CompleteOCLCSVisitor;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpConstraintCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextConstraintCSImpl#getContextDecl <em>Context Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ContextConstraintCSImpl extends ExpConstraintCSImpl implements ContextConstraintCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextConstraintCSImpl()
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
		return CompleteOCLCSTPackage.Literals.CONTEXT_CONSTRAINT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextDeclCS getContextDecl()
	{
		if (eContainerFeatureID() != CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL) return null;
		return (ContextDeclCS)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextDecl(ContextDeclCS newContextDecl, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newContextDecl, CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextDecl(ContextDeclCS newContextDecl)
	{
		if (newContextDecl != eInternalContainer() || (eContainerFeatureID() != CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL && newContextDecl != null))
		{
			if (EcoreUtil.isAncestor(this, newContextDecl))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContextDecl != null)
				msgs = ((InternalEObject)newContextDecl).eInverseAdd(this, CompleteOCLCSTPackage.CONTEXT_DECL_CS__RULES, ContextDeclCS.class, msgs);
			msgs = basicSetContextDecl(newContextDecl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL, newContextDecl, newContextDecl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContextDecl((ContextDeclCS)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				return basicSetContextDecl(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				return eInternalContainer().eInverseRemove(this, CompleteOCLCSTPackage.CONTEXT_DECL_CS__RULES, ContextDeclCS.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				return getContextDecl();
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
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				setContextDecl((ContextDeclCS)newValue);
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
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				setContextDecl((ContextDeclCS)null);
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
			case CompleteOCLCSTPackage.CONTEXT_CONSTRAINT_CS__CONTEXT_DECL:
				return getContextDecl() != null;
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(CompleteOCLCSVisitor.class).visitContextConstraintCS(this);
	}
} //ContextConstraintCSImpl
