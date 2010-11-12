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
 * $Id: PathNameCSImpl.java,v 1.7 2009/12/27 15:49:51 asanchez Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.PathNameCSImpl#getSimpleNames <em>Simple Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathNameCSImpl
		extends TypeCSImpl
		implements PathNameCS {

	/**
	 * The cached value of the '{@link #getSimpleNames() <em>Simple Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getSimpleNames()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleNameCS> simpleNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathNameCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.PATH_NAME_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleNameCS> getSimpleNames() {
		if (simpleNames == null) {
			simpleNames = new EObjectContainmentEList<SimpleNameCS>(
				SimpleNameCS.class, this, CSTPackage.PATH_NAME_CS__SIMPLE_NAMES);
		}
		return simpleNames;
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
			case CSTPackage.PATH_NAME_CS__SIMPLE_NAMES :
				return ((InternalEList<?>) getSimpleNames()).basicRemove(
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
			case CSTPackage.PATH_NAME_CS__SIMPLE_NAMES :
				return getSimpleNames();
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
			case CSTPackage.PATH_NAME_CS__SIMPLE_NAMES :
				getSimpleNames().clear();
				getSimpleNames().addAll(
					(Collection<? extends SimpleNameCS>) newValue);
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
			case CSTPackage.PATH_NAME_CS__SIMPLE_NAMES :
				getSimpleNames().clear();
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
			case CSTPackage.PATH_NAME_CS__SIMPLE_NAMES :
				return simpleNames != null && !simpleNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Set the associated AST object to newAst, and set the correspondiing
	 * AST objects of the child simpleNames to newAst and its containers.
	 */
	@Override
	public void setAst(Object newAst) {
		Object node = newAst;
		for (int i = simpleNames.size() - 1; i >= 0; --i) {
			simpleNames.get(i).setAst(node);
			node = node instanceof EObject
				? ((EObject) node).eContainer()
				: null;
		}
		super.setAst(newAst);
	}

} //PathNameCSImpl
