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
 * $Id: PropertyContextDeclCSImpl.java,v 1.5 2010/05/24 08:58:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl#getInit <em>Init</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.PropertyContextDeclCSImpl#getDer <em>Der</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyContextDeclCSImpl extends FeatureContextDeclCSImpl implements PropertyContextDeclCS {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected StructuralFeatureRefCS property;

	/**
	 * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInit()
	 * @generated
	 * @ordered
	 */
	protected InitCS init;

	/**
	 * The cached value of the '{@link #getDer() <em>Der</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDer()
	 * @generated
	 * @ordered
	 */
	protected DerCS der;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSTPackage.Literals.PROPERTY_CONTEXT_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureRefCS getProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(StructuralFeatureRefCS newProperty, NotificationChain msgs) {
		StructuralFeatureRefCS oldProperty = property;
		property = newProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY, oldProperty, newProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(StructuralFeatureRefCS newProperty) {
		if (newProperty != property) {
			NotificationChain msgs = null;
			if (property != null)
				msgs = ((InternalEObject)property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY, null, msgs);
			if (newProperty != null)
				msgs = ((InternalEObject)newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY, null, msgs);
			msgs = basicSetProperty(newProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY, newProperty, newProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitCS getInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInit(InitCS newInit, NotificationChain msgs) {
		InitCS oldInit = init;
		init = newInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT, oldInit, newInit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInit(InitCS newInit) {
		if (newInit != init) {
			NotificationChain msgs = null;
			if (init != null)
				msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT, null, msgs);
			if (newInit != null)
				msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT, null, msgs);
			msgs = basicSetInit(newInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT, newInit, newInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerCS getDer() {
		return der;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDer(DerCS newDer, NotificationChain msgs) {
		DerCS oldDer = der;
		der = newDer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER, oldDer, newDer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDer(DerCS newDer) {
		if (newDer != der) {
			NotificationChain msgs = null;
			if (der != null)
				msgs = ((InternalEObject)der).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER, null, msgs);
			if (newDer != null)
				msgs = ((InternalEObject)newDer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER, null, msgs);
			msgs = basicSetDer(newDer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER, newDer, newDer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				return basicSetProperty(null, msgs);
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT:
				return basicSetInit(null, msgs);
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER:
				return basicSetDer(null, msgs);
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
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				return getProperty();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT:
				return getInit();
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER:
				return getDer();
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
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				setProperty((StructuralFeatureRefCS)newValue);
				return;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT:
				setInit((InitCS)newValue);
				return;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER:
				setDer((DerCS)newValue);
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
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				setProperty((StructuralFeatureRefCS)null);
				return;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT:
				setInit((InitCS)null);
				return;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER:
				setDer((DerCS)null);
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
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__PROPERTY:
				return property != null;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__INIT:
				return init != null;
			case CompleteOCLCSTPackage.PROPERTY_CONTEXT_DECL_CS__DER:
				return der != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.appendElement(getProperty(), typeBindings);
	}
} //PropertyContextDeclCSImpl
