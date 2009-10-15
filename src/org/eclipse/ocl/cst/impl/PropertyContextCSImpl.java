/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: PropertyContextCSImpl.java,v 1.5 2009/10/15 19:38:06 ewillink Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PropertyContextCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Context CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.PropertyContextCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PropertyContextCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PropertyContextCSImpl#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PropertyContextCSImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyContextCSImpl
		extends ContextDeclCSImpl
		implements PropertyContextCS {

	/**
	 * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathNameCS()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS pathNameCS;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS simpleNameCS;

	/**
	 * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeCS()
	 * @generated
	 * @ordered
	 */
	protected TypeCS typeCS;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<InitOrDerValueCS> constraints;

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
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.PROPERTY_CONTEXT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getPathNameCS() {
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS,
			NotificationChain msgs) {
		PathNameCS oldPathNameCS = pathNameCS;
		pathNameCS = newPathNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS,
				oldPathNameCS, newPathNameCS);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathNameCS(PathNameCS newPathNameCS) {
		if (newPathNameCS != pathNameCS) {
			NotificationChain msgs = null;
			if (pathNameCS != null)
				msgs = ((InternalEObject) pathNameCS).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS, null,
					msgs);
			if (newPathNameCS != null)
				msgs = ((InternalEObject) newPathNameCS).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS, null,
					msgs);
			msgs = basicSetPathNameCS(newPathNameCS, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS, newPathNameCS,
				newPathNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleNameCS(SimpleNameCS newSimpleNameCS,
			NotificationChain msgs) {
		SimpleNameCS oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS,
				oldSimpleNameCS, newSimpleNameCS);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
		if (newSimpleNameCS != simpleNameCS) {
			NotificationChain msgs = null;
			if (simpleNameCS != null)
				msgs = ((InternalEObject) simpleNameCS).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS, null,
					msgs);
			if (newSimpleNameCS != null)
				msgs = ((InternalEObject) newSimpleNameCS).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS, null,
					msgs);
			msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS,
				newSimpleNameCS, newSimpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeCS getTypeCS() {
		return typeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeCS(TypeCS newTypeCS,
			NotificationChain msgs) {
		TypeCS oldTypeCS = typeCS;
		typeCS = newTypeCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS,
				oldTypeCS, newTypeCS);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeCS(TypeCS newTypeCS) {
		if (newTypeCS != typeCS) {
			NotificationChain msgs = null;
			if (typeCS != null)
				msgs = ((InternalEObject) typeCS).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS, null, msgs);
			if (newTypeCS != null)
				msgs = ((InternalEObject) newTypeCS).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS, null, msgs);
			msgs = basicSetTypeCS(newTypeCS, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS, newTypeCS, newTypeCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InitOrDerValueCS> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<InitOrDerValueCS>(
				InitOrDerValueCS.class, this,
				CSTPackage.PROPERTY_CONTEXT_CS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS :
				return basicSetPathNameCS(null, msgs);
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS :
				return basicSetSimpleNameCS(null, msgs);
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS :
				return basicSetTypeCS(null, msgs);
			case CSTPackage.PROPERTY_CONTEXT_CS__CONSTRAINTS :
				return ((InternalEList<?>) getConstraints()).basicRemove(
					otherEnd, msgs);
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
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS :
				return getPathNameCS();
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS :
				return getSimpleNameCS();
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS :
				return getTypeCS();
			case CSTPackage.PROPERTY_CONTEXT_CS__CONSTRAINTS :
				return getConstraints();
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
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS :
				setPathNameCS((PathNameCS) newValue);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS :
				setSimpleNameCS((SimpleNameCS) newValue);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS :
				setTypeCS((TypeCS) newValue);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__CONSTRAINTS :
				getConstraints().clear();
				getConstraints().addAll(
					(Collection<? extends InitOrDerValueCS>) newValue);
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
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS :
				setPathNameCS((PathNameCS) null);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS :
				setSimpleNameCS((SimpleNameCS) null);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS :
				setTypeCS((TypeCS) null);
				return;
			case CSTPackage.PROPERTY_CONTEXT_CS__CONSTRAINTS :
				getConstraints().clear();
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
			case CSTPackage.PROPERTY_CONTEXT_CS__PATH_NAME_CS :
				return pathNameCS != null;
			case CSTPackage.PROPERTY_CONTEXT_CS__SIMPLE_NAME_CS :
				return simpleNameCS != null;
			case CSTPackage.PROPERTY_CONTEXT_CS__TYPE_CS :
				return typeCS != null;
			case CSTPackage.PROPERTY_CONTEXT_CS__CONSTRAINTS :
				return constraints != null && !constraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyContextCSImpl
