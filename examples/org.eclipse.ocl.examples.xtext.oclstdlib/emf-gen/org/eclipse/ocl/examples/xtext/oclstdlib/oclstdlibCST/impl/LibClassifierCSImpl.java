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
 * $Id: LibClassifierCSImpl.java,v 1.2 2010/05/22 18:51:48 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ClassifierCSImpl;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassifierCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Classifier CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibClassifierCSImpl#getStructuralFeatures <em>Structural Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LibClassifierCSImpl extends ClassifierCSImpl implements LibClassifierCS {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibClassifierCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSTPackage.Literals.LIB_CLASSIFIER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedRefCS> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList.Unsettable<TypedRefCS>(TypedRefCS.class, this, OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__SUPER_TYPES);
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
			operations = new EObjectContainmentWithInverseEList<OperationCS>(OperationCS.class, this, OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS, BaseCSTPackage.OPERATION_CS__OWNER);
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
			structuralFeatures = new EObjectContainmentWithInverseEList<StructuralFeatureCS>(StructuralFeatureCS.class, this, OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES, BaseCSTPackage.STRUCTURAL_FEATURE_CS__OWNER);
		}
		return structuralFeatures;
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
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES:
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
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES:
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
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__SUPER_TYPES:
				return getSuperTypes();
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS:
				return getOperations();
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES:
				return getStructuralFeatures();
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
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends TypedRefCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends OperationCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
				getStructuralFeatures().addAll((Collection<? extends StructuralFeatureCS>)newValue);
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
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__SUPER_TYPES:
				unsetSuperTypes();
				return;
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS:
				getOperations().clear();
				return;
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES:
				getStructuralFeatures().clear();
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
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__SUPER_TYPES:
				return isSetSuperTypes();
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case OCLstdlibCSTPackage.LIB_CLASSIFIER_CS__STRUCTURAL_FEATURES:
				return structuralFeatures != null && !structuralFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LibClassifierCSImpl
