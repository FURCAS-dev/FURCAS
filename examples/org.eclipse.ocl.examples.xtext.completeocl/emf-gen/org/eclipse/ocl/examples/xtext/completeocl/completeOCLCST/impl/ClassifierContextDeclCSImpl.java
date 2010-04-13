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
 * $Id: ClassifierContextDeclCSImpl.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl#getInvs <em>Invs</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.ClassifierContextDeclCSImpl#getDefs <em>Defs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclCSImpl extends ContextDeclCSImpl implements ClassifierContextDeclCS {
	/**
	 * The cached value of the '{@link #getSelfName() <em>Self Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS selfName;

	/**
	 * The cached value of the '{@link #getInvs() <em>Invs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvs()
	 * @generated
	 * @ordered
	 */
	protected EList<InvCS> invs;

	/**
	 * The cached value of the '{@link #getDefs() <em>Defs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefs()
	 * @generated
	 * @ordered
	 */
	protected EList<DefCS> defs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierContextDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSTPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSelfName() {
		return selfName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelfName(SimpleNameCS newSelfName, NotificationChain msgs) {
		SimpleNameCS oldSelfName = selfName;
		selfName = newSelfName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME, oldSelfName, newSelfName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfName(SimpleNameCS newSelfName) {
		if (newSelfName != selfName) {
			NotificationChain msgs = null;
			if (selfName != null)
				msgs = ((InternalEObject)selfName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME, null, msgs);
			if (newSelfName != null)
				msgs = ((InternalEObject)newSelfName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME, null, msgs);
			msgs = basicSetSelfName(newSelfName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME, newSelfName, newSelfName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InvCS> getInvs() {
		if (invs == null) {
			invs = new EObjectContainmentEList<InvCS>(InvCS.class, this, CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INVS);
		}
		return invs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefCS> getDefs() {
		if (defs == null) {
			defs = new EObjectContainmentEList<DefCS>(DefCS.class, this, CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFS);
		}
		return defs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				return basicSetSelfName(null, msgs);
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INVS:
				return ((InternalEList<?>)getInvs()).basicRemove(otherEnd, msgs);
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFS:
				return ((InternalEList<?>)getDefs()).basicRemove(otherEnd, msgs);
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
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				return getSelfName();
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INVS:
				return getInvs();
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFS:
				return getDefs();
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
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				setSelfName((SimpleNameCS)newValue);
				return;
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INVS:
				getInvs().clear();
				getInvs().addAll((Collection<? extends InvCS>)newValue);
				return;
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFS:
				getDefs().clear();
				getDefs().addAll((Collection<? extends DefCS>)newValue);
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
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				setSelfName((SimpleNameCS)null);
				return;
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INVS:
				getInvs().clear();
				return;
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFS:
				getDefs().clear();
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
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME:
				return selfName != null;
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INVS:
				return invs != null && !invs.isEmpty();
			case CompleteOCLCSTPackage.CLASSIFIER_CONTEXT_DECL_CS__DEFS:
				return defs != null && !defs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassifierContextDeclCSImpl
