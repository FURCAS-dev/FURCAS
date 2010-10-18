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
package org.eclipse.emf.query2.test.mm.testcases.case004.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case004.B4;
import org.eclipse.emf.query2.test.mm.testcases.case004.C4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4Impl#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4Impl#getComplex <em>Complex</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class C4Impl extends EObjectImpl implements C4 {
	/**
	 * The default value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected String primitive = PRIMITIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComplex() <em>Complex</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplex()
	 * @generated
	 * @ordered
	 */
	protected B4 complex;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected C4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.C4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive(String newPrimitive) {
		String oldPrimitive = primitive;
		primitive = newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.C4__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 getComplex() {
		if (complex != null && complex.eIsProxy()) {
			InternalEObject oldComplex = (InternalEObject)complex;
			complex = (B4)eResolveProxy(oldComplex);
			if (complex != oldComplex) {
				InternalEObject newComplex = (InternalEObject)complex;
				NotificationChain msgs = oldComplex.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.C4__COMPLEX, null, null);
				if (newComplex.eInternalContainer() == null) {
					msgs = newComplex.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.C4__COMPLEX, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.C4__COMPLEX, oldComplex, complex));
			}
		}
		return complex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 basicGetComplex() {
		return complex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplex(B4 newComplex, NotificationChain msgs) {
		B4 oldComplex = complex;
		complex = newComplex;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.C4__COMPLEX, oldComplex, newComplex);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplex(B4 newComplex) {
		if (newComplex != complex) {
			NotificationChain msgs = null;
			if (complex != null)
				msgs = ((InternalEObject)complex).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.C4__COMPLEX, null, msgs);
			if (newComplex != null)
				msgs = ((InternalEObject)newComplex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.C4__COMPLEX, null, msgs);
			msgs = basicSetComplex(newComplex, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.C4__COMPLEX, newComplex, newComplex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case004Package.C4__COMPLEX:
				return basicSetComplex(null, msgs);
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
			case Case004Package.C4__PRIMITIVE:
				return getPrimitive();
			case Case004Package.C4__COMPLEX:
				if (resolve) return getComplex();
				return basicGetComplex();
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
			case Case004Package.C4__PRIMITIVE:
				setPrimitive((String)newValue);
				return;
			case Case004Package.C4__COMPLEX:
				setComplex((B4)newValue);
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
			case Case004Package.C4__PRIMITIVE:
				setPrimitive(PRIMITIVE_EDEFAULT);
				return;
			case Case004Package.C4__COMPLEX:
				setComplex((B4)null);
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
			case Case004Package.C4__PRIMITIVE:
				return PRIMITIVE_EDEFAULT == null ? primitive != null : !PRIMITIVE_EDEFAULT.equals(primitive);
			case Case004Package.C4__COMPLEX:
				return complex != null;
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
		result.append(" (primitive: ");
		result.append(primitive);
		result.append(')');
		return result.toString();
	}

} //C4Impl
