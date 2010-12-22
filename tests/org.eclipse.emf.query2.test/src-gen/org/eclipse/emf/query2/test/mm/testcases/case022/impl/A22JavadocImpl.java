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
package org.eclipse.emf.query2.test.mm.testcases.case022.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc;
import org.eclipse.emf.query2.test.mm.testcases.case022.Case022Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A22 Javadoc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.A22JavadocImpl#getAttributeJavadoc <em>Attribute Javadoc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A22JavadocImpl extends EObjectImpl implements A22Javadoc {
	/**
	 * The default value of the '{@link #getAttributeJavadoc() <em>Attribute Javadoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeJavadoc()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_JAVADOC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeJavadoc() <em>Attribute Javadoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeJavadoc()
	 * @generated
	 * @ordered
	 */
	protected String attributeJavadoc = ATTRIBUTE_JAVADOC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A22JavadocImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case022Package.Literals.A22_JAVADOC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeJavadoc() {
		return attributeJavadoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeJavadoc(String newAttributeJavadoc) {
		String oldAttributeJavadoc = attributeJavadoc;
		attributeJavadoc = newAttributeJavadoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case022Package.A22_JAVADOC__ATTRIBUTE_JAVADOC, oldAttributeJavadoc, attributeJavadoc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void operationJavadoc() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case022Package.A22_JAVADOC__ATTRIBUTE_JAVADOC:
				return getAttributeJavadoc();
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
			case Case022Package.A22_JAVADOC__ATTRIBUTE_JAVADOC:
				setAttributeJavadoc((String)newValue);
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
			case Case022Package.A22_JAVADOC__ATTRIBUTE_JAVADOC:
				setAttributeJavadoc(ATTRIBUTE_JAVADOC_EDEFAULT);
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
			case Case022Package.A22_JAVADOC__ATTRIBUTE_JAVADOC:
				return ATTRIBUTE_JAVADOC_EDEFAULT == null ? attributeJavadoc != null : !ATTRIBUTE_JAVADOC_EDEFAULT.equals(attributeJavadoc);
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
		result.append(" (attributeJavadoc: "); //$NON-NLS-1$
		result.append(attributeJavadoc);
		result.append(')');
		return result.toString();
	}

} //A22JavadocImpl
