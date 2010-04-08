/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: ModelRegistrationImpl.java,v 1.2 2010/04/08 06:24:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.examples.modelregistry.ModelRegistration;
import org.eclipse.ocl.examples.modelregistry.ModelRegistryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Registration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl#getSerialization <em>Serialization</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.modelregistry.impl.ModelRegistrationImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelRegistrationImpl extends EObjectImpl implements ModelRegistration {
	/**
	 * The default value of the '{@link #getAccessor() <em>Accessor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessor()
	 * @generated
	 * @ordered
	 */
	protected static final String ACCESSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccessor() <em>Accessor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessor()
	 * @generated
	 * @ordered
	 */
	protected String accessor = ACCESSOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSerialization() <em>Serialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialization()
	 * @generated
	 * @ordered
	 */
	protected static final String SERIALIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSerialization() <em>Serialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialization()
	 * @generated
	 * @ordered
	 */
	protected String serialization = SERIALIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelRegistrationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelRegistryPackage.Literals.MODEL_REGISTRATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAccessor() {
		return accessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAccessor(String newAccessor) {
		String oldAccessor = accessor;
		accessor = newAccessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelRegistryPackage.MODEL_REGISTRATION__ACCESSOR, oldAccessor, accessor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelRegistryPackage.MODEL_REGISTRATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSerialization() {
		return serialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerialization(String newSerialization) {
		String oldSerialization = serialization;
		serialization = newSerialization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelRegistryPackage.MODEL_REGISTRATION__SERIALIZATION, oldSerialization, serialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelRegistryPackage.MODEL_REGISTRATION__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelRegistryPackage.MODEL_REGISTRATION__ACCESSOR:
				return getAccessor();
			case ModelRegistryPackage.MODEL_REGISTRATION__KIND:
				return getKind();
			case ModelRegistryPackage.MODEL_REGISTRATION__SERIALIZATION:
				return getSerialization();
			case ModelRegistryPackage.MODEL_REGISTRATION__URI:
				return getUri();
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
			case ModelRegistryPackage.MODEL_REGISTRATION__ACCESSOR:
				setAccessor((String)newValue);
				return;
			case ModelRegistryPackage.MODEL_REGISTRATION__KIND:
				setKind((String)newValue);
				return;
			case ModelRegistryPackage.MODEL_REGISTRATION__SERIALIZATION:
				setSerialization((String)newValue);
				return;
			case ModelRegistryPackage.MODEL_REGISTRATION__URI:
				setUri((String)newValue);
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
			case ModelRegistryPackage.MODEL_REGISTRATION__ACCESSOR:
				setAccessor(ACCESSOR_EDEFAULT);
				return;
			case ModelRegistryPackage.MODEL_REGISTRATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ModelRegistryPackage.MODEL_REGISTRATION__SERIALIZATION:
				setSerialization(SERIALIZATION_EDEFAULT);
				return;
			case ModelRegistryPackage.MODEL_REGISTRATION__URI:
				setUri(URI_EDEFAULT);
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
			case ModelRegistryPackage.MODEL_REGISTRATION__ACCESSOR:
				return ACCESSOR_EDEFAULT == null ? accessor != null : !ACCESSOR_EDEFAULT.equals(accessor);
			case ModelRegistryPackage.MODEL_REGISTRATION__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case ModelRegistryPackage.MODEL_REGISTRATION__SERIALIZATION:
				return SERIALIZATION_EDEFAULT == null ? serialization != null : !SERIALIZATION_EDEFAULT.equals(serialization);
			case ModelRegistryPackage.MODEL_REGISTRATION__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
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
		result.append(" (accessor: ");
		result.append(accessor);
		result.append(", kind: ");
		result.append(kind);
		result.append(", serialization: ");
		result.append(serialization);
		result.append(", uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //ModelRegistrationImpl
