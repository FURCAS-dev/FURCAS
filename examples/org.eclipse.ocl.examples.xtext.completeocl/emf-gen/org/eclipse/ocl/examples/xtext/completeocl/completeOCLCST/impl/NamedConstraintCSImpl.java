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
 * $Id: NamedConstraintCSImpl.java,v 1.1 2010/04/13 06:38:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.NamedConstraintCS;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl.NamedConstraintCSImpl#getConstraintName <em>Constraint Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedConstraintCSImpl extends ConstraintCSImpl implements NamedConstraintCS {
	/**
	 * The cached value of the '{@link #getConstraintName() <em>Constraint Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintName()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS constraintName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedConstraintCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompleteOCLCSTPackage.Literals.NAMED_CONSTRAINT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getConstraintName() {
		return constraintName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintName(SimpleNameCS newConstraintName, NotificationChain msgs) {
		SimpleNameCS oldConstraintName = constraintName;
		constraintName = newConstraintName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME, oldConstraintName, newConstraintName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintName(SimpleNameCS newConstraintName) {
		if (newConstraintName != constraintName) {
			NotificationChain msgs = null;
			if (constraintName != null)
				msgs = ((InternalEObject)constraintName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME, null, msgs);
			if (newConstraintName != null)
				msgs = ((InternalEObject)newConstraintName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME, null, msgs);
			msgs = basicSetConstraintName(newConstraintName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME, newConstraintName, newConstraintName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME:
				return basicSetConstraintName(null, msgs);
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
			case CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME:
				return getConstraintName();
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
			case CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME:
				setConstraintName((SimpleNameCS)newValue);
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
			case CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME:
				setConstraintName((SimpleNameCS)null);
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
			case CompleteOCLCSTPackage.NAMED_CONSTRAINT_CS__CONSTRAINT_NAME:
				return constraintName != null;
		}
		return super.eIsSet(featureID);
	}

} //NamedConstraintCSImpl
