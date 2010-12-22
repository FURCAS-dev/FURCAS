/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case013.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case013.A13;
import org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A13</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.A13Impl#getConstrainedAttribute1 <em>Constrained Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.A13Impl#getConstrainedAttributeMany1 <em>Constrained Attribute Many1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A13Impl extends EObjectImpl implements A13 {
	/**
	 * The default value of the '{@link #getConstrainedAttribute1() <em>Constrained Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final int CONSTRAINED_ATTRIBUTE1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getConstrainedAttribute1() <em>Constrained Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedAttribute1()
	 * @generated
	 * @ordered
	 */
	protected int constrainedAttribute1 = CONSTRAINED_ATTRIBUTE1_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstrainedAttributeMany1() <em>Constrained Attribute Many1</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedAttributeMany1()
	 * @generated
	 * @ordered
	 */
	protected EList<A13> constrainedAttributeMany1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A13Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case013Package.Literals.A13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getConstrainedAttribute1() {
		return constrainedAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstrainedAttribute1(int newConstrainedAttribute1) {
		int oldConstrainedAttribute1 = constrainedAttribute1;
		constrainedAttribute1 = newConstrainedAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.A13__CONSTRAINED_ATTRIBUTE1, oldConstrainedAttribute1, constrainedAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A13> getConstrainedAttributeMany1() {
		if (constrainedAttributeMany1 == null) {
			constrainedAttributeMany1 = new EObjectContainmentEList.Resolving<A13>(A13.class, this, Case013Package.A13__CONSTRAINED_ATTRIBUTE_MANY1);
		}
		return constrainedAttributeMany1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE_MANY1:
				return ((InternalEList<?>)getConstrainedAttributeMany1()).basicRemove(otherEnd, msgs);
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
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE1:
				return getConstrainedAttribute1();
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE_MANY1:
				return getConstrainedAttributeMany1();
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
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE1:
				setConstrainedAttribute1((Integer)newValue);
				return;
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE_MANY1:
				getConstrainedAttributeMany1().clear();
				getConstrainedAttributeMany1().addAll((Collection<? extends A13>)newValue);
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
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE1:
				setConstrainedAttribute1(CONSTRAINED_ATTRIBUTE1_EDEFAULT);
				return;
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE_MANY1:
				getConstrainedAttributeMany1().clear();
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
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE1:
				return constrainedAttribute1 != CONSTRAINED_ATTRIBUTE1_EDEFAULT;
			case Case013Package.A13__CONSTRAINED_ATTRIBUTE_MANY1:
				return constrainedAttributeMany1 != null && !constrainedAttributeMany1.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (constrainedAttribute1: "); //$NON-NLS-1$
		result.append(constrainedAttribute1);
		result.append(')');
		return result.toString();
	}

} //A13Impl
