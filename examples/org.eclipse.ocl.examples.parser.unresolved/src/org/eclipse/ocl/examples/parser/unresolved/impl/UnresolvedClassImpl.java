/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UnresolvedClassImpl.java,v 1.1 2010/03/11 11:54:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unresolved.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedClassifier;
import org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl#getUnresolvedAttribute <em>Unresolved Attribute</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl#getUnresolvedReference <em>Unresolved Reference</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.parser.unresolved.impl.UnresolvedClassImpl#getUnresolvedProperty <em>Unresolved Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnresolvedClassImpl extends EObjectImpl implements UnresolvedClass {
	/**
	 * The default value of the '{@link #getUnresolvedAttribute() <em>Unresolved Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String UNRESOLVED_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnresolvedAttribute() <em>Unresolved Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedAttribute()
	 * @generated
	 * @ordered
	 */
	protected String unresolvedAttribute = UNRESOLVED_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUnresolvedReference() <em>Unresolved Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedReference()
	 * @generated
	 * @ordered
	 */
	protected UnresolvedClass unresolvedReference;

	/**
	 * The cached value of the '{@link #getUnresolvedProperty() <em>Unresolved Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnresolvedProperty()
	 * @generated
	 * @ordered
	 */
	protected UnresolvedClassifier unresolvedProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnresolvedClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UnresolvedPackage.Literals.UNRESOLVED_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnresolvedAttribute() {
		return unresolvedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnresolvedAttribute(String newUnresolvedAttribute) {
		String oldUnresolvedAttribute = unresolvedAttribute;
		unresolvedAttribute = newUnresolvedAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE, oldUnresolvedAttribute, unresolvedAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedClass getUnresolvedReference() {
		if (unresolvedReference != null && unresolvedReference.eIsProxy()) {
			InternalEObject oldUnresolvedReference = (InternalEObject)unresolvedReference;
			unresolvedReference = (UnresolvedClass)eResolveProxy(oldUnresolvedReference);
			if (unresolvedReference != oldUnresolvedReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_REFERENCE, oldUnresolvedReference, unresolvedReference));
			}
		}
		return unresolvedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedClass basicGetUnresolvedReference() {
		return unresolvedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnresolvedReference(UnresolvedClass newUnresolvedReference) {
		UnresolvedClass oldUnresolvedReference = unresolvedReference;
		unresolvedReference = newUnresolvedReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_REFERENCE, oldUnresolvedReference, unresolvedReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedClassifier getUnresolvedProperty() {
		if (unresolvedProperty != null && unresolvedProperty.eIsProxy()) {
			InternalEObject oldUnresolvedProperty = (InternalEObject)unresolvedProperty;
			unresolvedProperty = (UnresolvedClassifier)eResolveProxy(oldUnresolvedProperty);
			if (unresolvedProperty != oldUnresolvedProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_PROPERTY, oldUnresolvedProperty, unresolvedProperty));
			}
		}
		return unresolvedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnresolvedClassifier basicGetUnresolvedProperty() {
		return unresolvedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnresolvedProperty(UnresolvedClassifier newUnresolvedProperty) {
		UnresolvedClassifier oldUnresolvedProperty = unresolvedProperty;
		unresolvedProperty = newUnresolvedProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_PROPERTY, oldUnresolvedProperty, unresolvedProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unresolvedOperation() {
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
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE:
				return getUnresolvedAttribute();
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_REFERENCE:
				if (resolve) return getUnresolvedReference();
				return basicGetUnresolvedReference();
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_PROPERTY:
				if (resolve) return getUnresolvedProperty();
				return basicGetUnresolvedProperty();
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
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE:
				setUnresolvedAttribute((String)newValue);
				return;
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_REFERENCE:
				setUnresolvedReference((UnresolvedClass)newValue);
				return;
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_PROPERTY:
				setUnresolvedProperty((UnresolvedClassifier)newValue);
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
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE:
				setUnresolvedAttribute(UNRESOLVED_ATTRIBUTE_EDEFAULT);
				return;
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_REFERENCE:
				setUnresolvedReference((UnresolvedClass)null);
				return;
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_PROPERTY:
				setUnresolvedProperty((UnresolvedClassifier)null);
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
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_ATTRIBUTE:
				return UNRESOLVED_ATTRIBUTE_EDEFAULT == null ? unresolvedAttribute != null : !UNRESOLVED_ATTRIBUTE_EDEFAULT.equals(unresolvedAttribute);
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_REFERENCE:
				return unresolvedReference != null;
			case UnresolvedPackage.UNRESOLVED_CLASS__UNRESOLVED_PROPERTY:
				return unresolvedProperty != null;
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
		result.append(" (unresolvedAttribute: ");
		result.append(unresolvedAttribute);
		result.append(')');
		return result.toString();
	}

} //UnresolvedClassImpl
