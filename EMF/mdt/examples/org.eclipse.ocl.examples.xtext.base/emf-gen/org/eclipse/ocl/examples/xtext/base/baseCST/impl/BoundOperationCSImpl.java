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
 * $Id: BoundOperationCSImpl.java,v 1.3 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundOperationCSImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundOperationCSImpl#getBinds <em>Binds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundOperationCSImpl extends OperationCSImpl implements BoundOperationCS {
	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected TypeBindingsCS bindings;
	/**
	 * The cached value of the '{@link #getBinds() <em>Binds</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBinds()
	 * @generated
	 * @ordered
	 */
	protected OperationCS binds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.BOUND_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeBindingsCS getBindings() {
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBindings(TypeBindingsCS newBindings) {
		TypeBindingsCS oldBindings = bindings;
		bindings = newBindings;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS, oldBindings, bindings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS getBinds() {
		if (binds != null && binds.eIsProxy()) {
			InternalEObject oldBinds = (InternalEObject)binds;
			binds = (OperationCS)eResolveProxy(oldBinds);
			if (binds != oldBinds) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.BOUND_OPERATION_CS__BINDS, oldBinds, binds));
			}
		}
		return binds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS basicGetBinds() {
		return binds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinds(OperationCS newBinds) {
		OperationCS oldBinds = binds;
		binds = newBinds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.BOUND_OPERATION_CS__BINDS, oldBinds, binds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS:
				return getBindings();
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDS:
				if (resolve) return getBinds();
				return basicGetBinds();
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
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS:
				setBindings((TypeBindingsCS)newValue);
				return;
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDS:
				setBinds((OperationCS)newValue);
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
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS:
				setBindings((TypeBindingsCS)null);
				return;
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDS:
				setBinds((OperationCS)null);
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
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS:
				return bindings != null;
			case BaseCSTPackage.BOUND_OPERATION_CS__BINDS:
				return binds != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BoundElementCS.class) {
			switch (derivedFeatureID) {
				case BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS: return BaseCSTPackage.BOUND_ELEMENT_CS__BINDINGS;
				case BaseCSTPackage.BOUND_OPERATION_CS__BINDS: return BaseCSTPackage.BOUND_ELEMENT_CS__BINDS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BoundElementCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.BOUND_ELEMENT_CS__BINDINGS: return BaseCSTPackage.BOUND_OPERATION_CS__BINDINGS;
				case BaseCSTPackage.BOUND_ELEMENT_CS__BINDS: return BaseCSTPackage.BOUND_OPERATION_CS__BINDS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		if (typeBindings == null) {
			signature.appendTypeBindings(getBindings());
			signature.appendElement(getBinds(), null);
		}
		else {
			signature.appendElement(getBinds(), getBindings());
		}
	}
} //BoundOperationCSImpl
