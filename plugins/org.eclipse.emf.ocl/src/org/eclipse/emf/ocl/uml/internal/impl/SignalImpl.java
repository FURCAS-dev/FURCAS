/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.uml.internal.impl;

import org.eclipse.emf.ocl.uml.Signal;
import org.eclipse.emf.ocl.uml.UmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EClassImpl;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SignalImpl extends EClassImpl implements Signal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SignalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.eINSTANCE.getSignal();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UmlPackage.SIGNAL__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UmlPackage.SIGNAL__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UmlPackage.SIGNAL__EPACKAGE, msgs);
				case UmlPackage.SIGNAL__EOPERATIONS:
					return ((InternalEList)getEOperations()).basicAdd(otherEnd, msgs);
				case UmlPackage.SIGNAL__ESTRUCTURAL_FEATURES:
					return ((InternalEList)getEStructuralFeatures()).basicAdd(otherEnd, msgs);
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
				case UmlPackage.SIGNAL__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UmlPackage.SIGNAL__EPACKAGE:
					return eBasicSetContainer(null, UmlPackage.SIGNAL__EPACKAGE, msgs);
				case UmlPackage.SIGNAL__EOPERATIONS:
					return ((InternalEList)getEOperations()).basicRemove(otherEnd, msgs);
				case UmlPackage.SIGNAL__ESTRUCTURAL_FEATURES:
					return ((InternalEList)getEStructuralFeatures()).basicRemove(otherEnd, msgs);
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
				case UmlPackage.SIGNAL__EPACKAGE:
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
			case UmlPackage.SIGNAL__EANNOTATIONS:
				return getEAnnotations();
			case UmlPackage.SIGNAL__NAME:
				return getName();
			case UmlPackage.SIGNAL__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case UmlPackage.SIGNAL__INSTANCE_CLASS:
				return getInstanceClass();
			case UmlPackage.SIGNAL__DEFAULT_VALUE:
				return getDefaultValue();
			case UmlPackage.SIGNAL__EPACKAGE:
				return getEPackage();
			case UmlPackage.SIGNAL__ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.SIGNAL__INTERFACE:
				return isInterface() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.SIGNAL__ESUPER_TYPES:
				return getESuperTypes();
			case UmlPackage.SIGNAL__EOPERATIONS:
				return getEOperations();
			case UmlPackage.SIGNAL__EALL_ATTRIBUTES:
				return getEAllAttributes();
			case UmlPackage.SIGNAL__EALL_REFERENCES:
				return getEAllReferences();
			case UmlPackage.SIGNAL__EREFERENCES:
				return getEReferences();
			case UmlPackage.SIGNAL__EATTRIBUTES:
				return getEAttributes();
			case UmlPackage.SIGNAL__EALL_CONTAINMENTS:
				return getEAllContainments();
			case UmlPackage.SIGNAL__EALL_OPERATIONS:
				return getEAllOperations();
			case UmlPackage.SIGNAL__EALL_STRUCTURAL_FEATURES:
				return getEAllStructuralFeatures();
			case UmlPackage.SIGNAL__EALL_SUPER_TYPES:
				return getEAllSuperTypes();
			case UmlPackage.SIGNAL__EID_ATTRIBUTE:
				return getEIDAttribute();
			case UmlPackage.SIGNAL__ESTRUCTURAL_FEATURES:
				return getEStructuralFeatures();
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
			case UmlPackage.SIGNAL__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UmlPackage.SIGNAL__NAME:
				setName((String)newValue);
				return;
			case UmlPackage.SIGNAL__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case UmlPackage.SIGNAL__ABSTRACT:
				setAbstract(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.SIGNAL__INTERFACE:
				setInterface(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.SIGNAL__ESUPER_TYPES:
				getESuperTypes().clear();
				getESuperTypes().addAll((Collection)newValue);
				return;
			case UmlPackage.SIGNAL__EOPERATIONS:
				getEOperations().clear();
				getEOperations().addAll((Collection)newValue);
				return;
			case UmlPackage.SIGNAL__ESTRUCTURAL_FEATURES:
				getEStructuralFeatures().clear();
				getEStructuralFeatures().addAll((Collection)newValue);
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
			case UmlPackage.SIGNAL__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UmlPackage.SIGNAL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlPackage.SIGNAL__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case UmlPackage.SIGNAL__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case UmlPackage.SIGNAL__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case UmlPackage.SIGNAL__ESUPER_TYPES:
				getESuperTypes().clear();
				return;
			case UmlPackage.SIGNAL__EOPERATIONS:
				getEOperations().clear();
				return;
			case UmlPackage.SIGNAL__ESTRUCTURAL_FEATURES:
				getEStructuralFeatures().clear();
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
			case UmlPackage.SIGNAL__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UmlPackage.SIGNAL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlPackage.SIGNAL__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case UmlPackage.SIGNAL__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case UmlPackage.SIGNAL__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case UmlPackage.SIGNAL__EPACKAGE:
				return getEPackage() != null;
			case UmlPackage.SIGNAL__ABSTRACT:
				return ((eFlags & ABSTRACT_EFLAG) != 0) != ABSTRACT_EDEFAULT;
			case UmlPackage.SIGNAL__INTERFACE:
				return ((eFlags & INTERFACE_EFLAG) != 0) != INTERFACE_EDEFAULT;
			case UmlPackage.SIGNAL__ESUPER_TYPES:
				return eSuperTypes != null && !eSuperTypes.isEmpty();
			case UmlPackage.SIGNAL__EOPERATIONS:
				return eOperations != null && !eOperations.isEmpty();
			case UmlPackage.SIGNAL__EALL_ATTRIBUTES:
				return !getEAllAttributes().isEmpty();
			case UmlPackage.SIGNAL__EALL_REFERENCES:
				return !getEAllReferences().isEmpty();
			case UmlPackage.SIGNAL__EREFERENCES:
				return !getEReferences().isEmpty();
			case UmlPackage.SIGNAL__EATTRIBUTES:
				return !getEAttributes().isEmpty();
			case UmlPackage.SIGNAL__EALL_CONTAINMENTS:
				return !getEAllContainments().isEmpty();
			case UmlPackage.SIGNAL__EALL_OPERATIONS:
				return !getEAllOperations().isEmpty();
			case UmlPackage.SIGNAL__EALL_STRUCTURAL_FEATURES:
				return !getEAllStructuralFeatures().isEmpty();
			case UmlPackage.SIGNAL__EALL_SUPER_TYPES:
				return !getEAllSuperTypes().isEmpty();
			case UmlPackage.SIGNAL__EID_ATTRIBUTE:
				return getEIDAttribute() != null;
			case UmlPackage.SIGNAL__ESTRUCTURAL_FEATURES:
				return eStructuralFeatures != null && !eStructuralFeatures.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //SignalImpl
