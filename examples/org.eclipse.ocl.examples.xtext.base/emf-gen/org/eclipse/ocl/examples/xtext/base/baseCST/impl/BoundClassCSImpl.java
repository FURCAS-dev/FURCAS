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
 * $Id: BoundClassCSImpl.java,v 1.1 2010/05/24 08:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Class CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.BoundClassCSImpl#getBinds <em>Binds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundClassCSImpl extends ClassifierCSImpl implements BoundClassCS {
	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedRefCS> superTypes;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCS> operations;

	/**
	 * The cached value of the '{@link #getStructuralFeatures() <em>Structural Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructuralFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureCS> structuralFeatures;

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
	protected ClassifierCS binds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundClassCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.BOUND_CLASS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList.Unsettable<TypedRefCS>(TypedRefCS.class, this, BaseCSTPackage.BOUND_CLASS_CS__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuperTypes() {
		if (superTypes != null) ((InternalEList.Unsettable<?>)superTypes).unset();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuperTypes() {
		return superTypes != null && ((InternalEList.Unsettable<?>)superTypes).isSet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationCS> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<OperationCS>(OperationCS.class, this, BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS, BaseCSTPackage.OPERATION_CS__OWNER);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeatureCS> getStructuralFeatures() {
		if (structuralFeatures == null) {
			structuralFeatures = new EObjectContainmentWithInverseEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES, BaseCSTPackage.STRUCTURAL_FEATURE_CS__OWNER);
		}
		return structuralFeatures;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.BOUND_CLASS_CS__BINDINGS, oldBindings, bindings));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierCS getBinds() {
		if (binds != null && binds.eIsProxy()) {
			InternalEObject oldBinds = (InternalEObject)binds;
			binds = (ClassifierCS)eResolveProxy(oldBinds);
			if (binds != oldBinds) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.BOUND_CLASS_CS__BINDS, oldBinds, binds));
			}
		}
		return binds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierCS basicGetBinds() {
		return binds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBinds(ClassifierCS newBinds) {
		ClassifierCS oldBinds = binds;
		binds = newBinds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.BOUND_CLASS_CS__BINDS, oldBinds, binds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
			case BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStructuralFeatures()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.BOUND_CLASS_CS__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES:
				return ((InternalEList<?>)getStructuralFeatures()).basicRemove(otherEnd, msgs);
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
			case BaseCSTPackage.BOUND_CLASS_CS__SUPER_TYPES:
				return getSuperTypes();
			case BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS:
				return getOperations();
			case BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES:
				return getStructuralFeatures();
			case BaseCSTPackage.BOUND_CLASS_CS__BINDINGS:
				return getBindings();
			case BaseCSTPackage.BOUND_CLASS_CS__BINDS:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BaseCSTPackage.BOUND_CLASS_CS__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				getStructuralFeatures().addAll((Collection<? extends StructuralFeatureCS>)newValue);
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__BINDINGS:
				setBindings((TypeBindingsCS)newValue);
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__BINDS:
				setBinds((ClassifierCS)newValue);
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
			case BaseCSTPackage.BOUND_CLASS_CS__SUPER_TYPES:
				unsetSuperTypes();
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS:
				getOperations().clear();
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__BINDINGS:
				setBindings((TypeBindingsCS)null);
				return;
			case BaseCSTPackage.BOUND_CLASS_CS__BINDS:
				setBinds((ClassifierCS)null);
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
			case BaseCSTPackage.BOUND_CLASS_CS__SUPER_TYPES:
				return isSetSuperTypes();
			case BaseCSTPackage.BOUND_CLASS_CS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case BaseCSTPackage.BOUND_CLASS_CS__STRUCTURAL_FEATURES:
				return structuralFeatures != null && !structuralFeatures.isEmpty();
			case BaseCSTPackage.BOUND_CLASS_CS__BINDINGS:
				return bindings != null;
			case BaseCSTPackage.BOUND_CLASS_CS__BINDS:
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
		if (baseClass == NamespaceCS.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == BoundElementCS.class) {
			switch (derivedFeatureID) {
				case BaseCSTPackage.BOUND_CLASS_CS__BINDINGS: return BaseCSTPackage.BOUND_ELEMENT_CS__BINDINGS;
				case BaseCSTPackage.BOUND_CLASS_CS__BINDS: return BaseCSTPackage.BOUND_ELEMENT_CS__BINDS;
				default: return -1;
			}
		}
		if (baseClass == BoundClassifierCS.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == NamespaceCS.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == BoundElementCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.BOUND_ELEMENT_CS__BINDINGS: return BaseCSTPackage.BOUND_CLASS_CS__BINDINGS;
				case BaseCSTPackage.BOUND_ELEMENT_CS__BINDS: return BaseCSTPackage.BOUND_CLASS_CS__BINDS;
				default: return -1;
			}
		}
		if (baseClass == BoundClassifierCS.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BoundClassCSImpl
