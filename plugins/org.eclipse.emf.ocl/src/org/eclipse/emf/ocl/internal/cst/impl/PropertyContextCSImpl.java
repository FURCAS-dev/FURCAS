/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PropertyContextCSImpl.java,v 1.1 2006/04/04 18:09:04 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.emf.ocl.internal.cst.PathNameCS;
import org.eclipse.emf.ocl.internal.cst.PropertyContextCS;
import org.eclipse.emf.ocl.internal.cst.SimpleNameCS;
import org.eclipse.emf.ocl.internal.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Context CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.PropertyContextCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.PropertyContextCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.PropertyContextCSImpl#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.PropertyContextCSImpl#getInitOrDerValueCS <em>Init Or Der Value CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyContextCSImpl extends ContextDeclCSImpl implements PropertyContextCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS = null;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS simpleNameCS = null;

	/**
	 * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeCS()
	 * @generated
	 * @ordered
	 */
	protected TypeCS typeCS = null;

	/**
	 * The cached value of the '{@link #getInitOrDerValueCS() <em>Init Or Der Value CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitOrDerValueCS()
	 * @generated
	 * @ordered
	 */
	protected InitOrDerValueCS initOrDerValueCS = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyContextCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CSTPackage.Literals.PROPERTY_CONTEXT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		if (pathNameCS != null && pathNameCS.eIsProxy()) {
			InternalEObject oldPathNameCS = (InternalEObject)pathNameCS;
			pathNameCS = (PathNameCS)eResolveProxy(oldPathNameCS);
			if (pathNameCS != oldPathNameCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
			}
		}
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS basicGetPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSimpleNameCS() {
		if (simpleNameCS != null && simpleNameCS.eIsProxy()) {
			InternalEObject oldSimpleNameCS = (InternalEObject)simpleNameCS;
			simpleNameCS = (SimpleNameCS)eResolveProxy(oldSimpleNameCS);
			if (simpleNameCS != oldSimpleNameCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
			}
		}
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS basicGetSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
		SimpleNameCS oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getTypeCS() {
		if (typeCS != null && typeCS.eIsProxy()) {
			InternalEObject oldTypeCS = (InternalEObject)typeCS;
			typeCS = (TypeCS)eResolveProxy(oldTypeCS);
			if (typeCS != oldTypeCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS, oldTypeCS, typeCS));
			}
		}
		return typeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS basicGetTypeCS() {
		return typeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeCS(TypeCS newTypeCS) {
		TypeCS oldTypeCS = typeCS;
		typeCS = newTypeCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS, oldTypeCS, typeCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitOrDerValueCS getInitOrDerValueCS() {
		if (initOrDerValueCS != null && initOrDerValueCS.eIsProxy()) {
			InternalEObject oldInitOrDerValueCS = (InternalEObject)initOrDerValueCS;
			initOrDerValueCS = (InitOrDerValueCS)eResolveProxy(oldInitOrDerValueCS);
			if (initOrDerValueCS != oldInitOrDerValueCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS, oldInitOrDerValueCS, initOrDerValueCS));
			}
		}
		return initOrDerValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitOrDerValueCS basicGetInitOrDerValueCS() {
		return initOrDerValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitOrDerValueCS(InitOrDerValueCS newInitOrDerValueCS) {
		InitOrDerValueCS oldInitOrDerValueCS = initOrDerValueCS;
		initOrDerValueCS = newInitOrDerValueCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS, oldInitOrDerValueCS, initOrDerValueCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS:
				if (resolve) return getPathNameCS();
				return basicGetPathNameCS();
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS:
				if (resolve) return getSimpleNameCS();
				return basicGetSimpleNameCS();
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS:
				if (resolve) return getTypeCS();
				return basicGetTypeCS();
			case CSTPackage.PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS:
				if (resolve) return getInitOrDerValueCS();
				return basicGetInitOrDerValueCS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)newValue);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS:
				setTypeCS((TypeCS)newValue);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS:
				setInitOrDerValueCS((InitOrDerValueCS)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS:
				setPathNameCS((PathNameCS)null);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS:
				setTypeCS((TypeCS)null);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS:
				setInitOrDerValueCS((InitOrDerValueCS)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS:
				return pathNameCS != null;
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS:
				return typeCS != null;
			case CSTPackage.PROPERTY_CONTEXT_CS__INIT_OR_DER_VALUE_CS:
				return initOrDerValueCS != null;
		}
		return super.eIsSet(featureID);
	}

} //AttrOrAssocContextCSImpl
