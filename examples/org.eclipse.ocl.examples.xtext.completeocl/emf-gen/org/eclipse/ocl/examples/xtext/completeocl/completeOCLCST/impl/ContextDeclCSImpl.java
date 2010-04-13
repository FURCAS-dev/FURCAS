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
 * $Id: ContextDeclCSImpl.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ContextDeclCSImpl#getContextName <em>Context Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextDeclCSImpl extends MinimalEObjectImpl.Container implements ContextDeclCS {
	/**
	 * The cached value of the '{@link #getContextName() <em>Context Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS contextName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSTPackage.Literals.CONTEXT_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getContextName() {
		return contextName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextName(PathNameCS newContextName, NotificationChain msgs) {
		PathNameCS oldContextName = contextName;
		contextName = newContextName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME, oldContextName, newContextName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextName(PathNameCS newContextName) {
		if (newContextName != contextName) {
			NotificationChain msgs = null;
			if (contextName != null)
				msgs = ((InternalEObject)contextName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME, null, msgs);
			if (newContextName != null)
				msgs = ((InternalEObject)newContextName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME, null, msgs);
			msgs = basicSetContextName(newContextName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME, newContextName, newContextName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME:
				return basicSetContextName(null, msgs);
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
			case CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME:
				return getContextName();
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
			case CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME:
				setContextName((PathNameCS)newValue);
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
			case CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME:
				setContextName((PathNameCS)null);
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
			case CompleteOCLCSTPackage.CONTEXT_DECL_CS__CONTEXT_NAME:
				return contextName != null;
		}
		return super.eIsSet(featureID);
	}

} //ContextDeclCSImpl
