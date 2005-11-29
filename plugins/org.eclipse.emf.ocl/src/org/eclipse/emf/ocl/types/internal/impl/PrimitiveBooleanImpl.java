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
 * $Id$
 */

package org.eclipse.emf.ocl.types.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Boolean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveBooleanImpl extends PrimitiveTypeImpl implements PrimitiveBoolean {
	
	
	

	private static EList operations = new BasicEList();
	/*
	 * Operations defined on Real
	 */
	protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i = 0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}
		operations.add(createBinaryOperation(OCL_BOOLEAN, "and", OCL_BOOLEAN)); //$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_BOOLEAN, "not"));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_BOOLEAN, "or", OCL_BOOLEAN));	//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_BOOLEAN, "implies", OCL_BOOLEAN));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_BOOLEAN, "xor", OCL_BOOLEAN));//$NON-NLS-1$
		return operations;
	}
	
	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected PrimitiveBooleanImpl() {
		super();
		this.setInstanceClass(Boolean.class);
		this.setClassifierID(TypesPackage.PRIMITIVE_BOOLEAN);
	}

	protected PrimitiveBooleanImpl(String name) {
		this();
		setName("Boolean");//$NON-NLS-1$
		this.setClassifierID(TypesPackage.PRIMITIVE_BOOLEAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getPrimitiveBoolean();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.PRIMITIVE_BOOLEAN__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.PRIMITIVE_BOOLEAN__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE:
					return eContainer.eInverseRemove(this, EcorePackage.EPACKAGE__ECLASSIFIERS, EPackage.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.PRIMITIVE_BOOLEAN__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.PRIMITIVE_BOOLEAN__NAME:
				return getName();
			case TypesPackage.PRIMITIVE_BOOLEAN__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.PRIMITIVE_BOOLEAN__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.PRIMITIVE_BOOLEAN__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE:
				return getEPackage();
			case TypesPackage.PRIMITIVE_BOOLEAN__SERIALIZABLE:
				return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.PRIMITIVE_BOOLEAN__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.PRIMITIVE_BOOLEAN__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.PRIMITIVE_BOOLEAN__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.PRIMITIVE_BOOLEAN__SERIALIZABLE:
				setSerializable(((Boolean)newValue).booleanValue());
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.PRIMITIVE_BOOLEAN__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.PRIMITIVE_BOOLEAN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.PRIMITIVE_BOOLEAN__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.PRIMITIVE_BOOLEAN__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.PRIMITIVE_BOOLEAN__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.PRIMITIVE_BOOLEAN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.PRIMITIVE_BOOLEAN__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.PRIMITIVE_BOOLEAN__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.PRIMITIVE_BOOLEAN__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.PRIMITIVE_BOOLEAN__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.PRIMITIVE_BOOLEAN__SERIALIZABLE:
				return ((eFlags & SERIALIZABLE_EFLAG) != 0) != SERIALIZABLE_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

} //PrimitiveBooleanImpl
