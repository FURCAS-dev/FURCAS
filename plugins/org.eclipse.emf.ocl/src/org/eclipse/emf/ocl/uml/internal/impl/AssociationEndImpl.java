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

import org.eclipse.emf.ocl.uml.AssociationEnd;
import org.eclipse.emf.ocl.uml.Qualifier;
import org.eclipse.emf.ocl.uml.UmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EReferenceImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.AssociationEndImpl#getQualifiers <em>Qualifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndImpl extends EReferenceImpl implements AssociationEnd {
	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList qualifiers = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.eINSTANCE.getAssociationEnd();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EObjectContainmentWithInverseEList(Qualifier.class, this, UmlPackage.ASSOCIATION_END__QUALIFIERS, UmlPackage.QUALIFIER__ASSOCIATION_END);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int structuralFeatureID, Class baseClass, NotificationChain msgs) {
		if (structuralFeatureID >= 0) {
			switch (eDerivedStructuralFeatureID(structuralFeatureID, baseClass)) {
				case UmlPackage.ASSOCIATION_END__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS, msgs);
				case UmlPackage.ASSOCIATION_END__QUALIFIERS:
					return ((InternalEList)getQualifiers()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, structuralFeatureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, structuralFeatureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int structualFeatureID, Class baseClass, NotificationChain msgs) {
		if (structualFeatureID >= 0) {
			switch (eDerivedStructuralFeatureID(structualFeatureID, baseClass)) {
				case UmlPackage.ASSOCIATION_END__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS:
					return eBasicSetContainer(null, UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS, msgs);
				case UmlPackage.ASSOCIATION_END__QUALIFIERS:
					return ((InternalEList)getQualifiers()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, structualFeatureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, structualFeatureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS:
					return eContainer.eInverseRemove(this, EcorePackage.ECLASS__ESTRUCTURAL_FEATURES, EClass.class, msgs);
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
			case UmlPackage.ASSOCIATION_END__EANNOTATIONS:
				return getEAnnotations();
			case UmlPackage.ASSOCIATION_END__NAME:
				return getName();
			case UmlPackage.ASSOCIATION_END__ORDERED:
				return isOrdered() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__UNIQUE:
				return isUnique() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__LOWER_BOUND:
				return new Integer(getLowerBound());
			case UmlPackage.ASSOCIATION_END__UPPER_BOUND:
				return new Integer(getUpperBound());
			case UmlPackage.ASSOCIATION_END__MANY:
				return isMany() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__REQUIRED:
				return isRequired() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__ETYPE:
				if (resolve) return getEType();
				return basicGetEType();
			case UmlPackage.ASSOCIATION_END__CHANGEABLE:
				return isChangeable() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__VOLATILE:
				return isVolatile() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__TRANSIENT:
				return isTransient() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__DEFAULT_VALUE_LITERAL:
				return getDefaultValueLiteral();
			case UmlPackage.ASSOCIATION_END__DEFAULT_VALUE:
				return getDefaultValue();
			case UmlPackage.ASSOCIATION_END__UNSETTABLE:
				return isUnsettable() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__DERIVED:
				return isDerived() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS:
				return getEContainingClass();
			case UmlPackage.ASSOCIATION_END__CONTAINMENT:
				return isContainment() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__CONTAINER:
				return isContainer() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__RESOLVE_PROXIES:
				return isResolveProxies() ? Boolean.TRUE : Boolean.FALSE;
			case UmlPackage.ASSOCIATION_END__EOPPOSITE:
				if (resolve) return getEOpposite();
				return basicGetEOpposite();
			case UmlPackage.ASSOCIATION_END__EREFERENCE_TYPE:
				if (resolve) return getEReferenceType();
				return basicGetEReferenceType();
			case UmlPackage.ASSOCIATION_END__QUALIFIERS:
				return getQualifiers();
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
			case UmlPackage.ASSOCIATION_END__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UmlPackage.ASSOCIATION_END__NAME:
				setName((String)newValue);
				return;
			case UmlPackage.ASSOCIATION_END__ORDERED:
				setOrdered(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__UNIQUE:
				setUnique(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__LOWER_BOUND:
				setLowerBound(((Integer)newValue).intValue());
				return;
			case UmlPackage.ASSOCIATION_END__UPPER_BOUND:
				setUpperBound(((Integer)newValue).intValue());
				return;
			case UmlPackage.ASSOCIATION_END__ETYPE:
				setEType((EClassifier)newValue);
				return;
			case UmlPackage.ASSOCIATION_END__CHANGEABLE:
				setChangeable(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__VOLATILE:
				setVolatile(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__TRANSIENT:
				setTransient(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__DEFAULT_VALUE_LITERAL:
				setDefaultValueLiteral((String)newValue);
				return;
			case UmlPackage.ASSOCIATION_END__UNSETTABLE:
				setUnsettable(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__DERIVED:
				setDerived(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__CONTAINMENT:
				setContainment(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__RESOLVE_PROXIES:
				setResolveProxies(((Boolean)newValue).booleanValue());
				return;
			case UmlPackage.ASSOCIATION_END__EOPPOSITE:
				setEOpposite((EReference)newValue);
				return;
			case UmlPackage.ASSOCIATION_END__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection)newValue);
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
			case UmlPackage.ASSOCIATION_END__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UmlPackage.ASSOCIATION_END__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__ORDERED:
				setOrdered(ORDERED_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__ETYPE:
				setEType((EClassifier)null);
				return;
			case UmlPackage.ASSOCIATION_END__CHANGEABLE:
				setChangeable(CHANGEABLE_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__VOLATILE:
				setVolatile(VOLATILE_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__TRANSIENT:
				setTransient(TRANSIENT_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__DEFAULT_VALUE_LITERAL:
				setDefaultValueLiteral(DEFAULT_VALUE_LITERAL_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__UNSETTABLE:
				setUnsettable(UNSETTABLE_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__DERIVED:
				setDerived(DERIVED_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__CONTAINMENT:
				setContainment(CONTAINMENT_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__RESOLVE_PROXIES:
				setResolveProxies(RESOLVE_PROXIES_EDEFAULT);
				return;
			case UmlPackage.ASSOCIATION_END__EOPPOSITE:
				setEOpposite((EReference)null);
				return;
			case UmlPackage.ASSOCIATION_END__QUALIFIERS:
				getQualifiers().clear();
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
			case UmlPackage.ASSOCIATION_END__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UmlPackage.ASSOCIATION_END__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlPackage.ASSOCIATION_END__ORDERED:
				return ((eFlags & ORDERED_EFLAG) != 0) != ORDERED_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__UNIQUE:
				return ((eFlags & UNIQUE_EFLAG) != 0) != UNIQUE_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__MANY:
				return isMany() != MANY_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__ETYPE:
				return eType != null;
			case UmlPackage.ASSOCIATION_END__CHANGEABLE:
				return ((eFlags & CHANGEABLE_EFLAG) != 0) != CHANGEABLE_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__VOLATILE:
				return ((eFlags & VOLATILE_EFLAG) != 0) != VOLATILE_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__TRANSIENT:
				return ((eFlags & TRANSIENT_EFLAG) != 0) != TRANSIENT_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__DEFAULT_VALUE_LITERAL:
				return DEFAULT_VALUE_LITERAL_EDEFAULT == null ? defaultValueLiteral != null : !DEFAULT_VALUE_LITERAL_EDEFAULT.equals(defaultValueLiteral);
			case UmlPackage.ASSOCIATION_END__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case UmlPackage.ASSOCIATION_END__UNSETTABLE:
				return ((eFlags & UNSETTABLE_EFLAG) != 0) != UNSETTABLE_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__DERIVED:
				return ((eFlags & DERIVED_EFLAG) != 0) != DERIVED_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__ECONTAINING_CLASS:
				return getEContainingClass() != null;
			case UmlPackage.ASSOCIATION_END__CONTAINMENT:
				return ((eFlags & CONTAINMENT_EFLAG) != 0) != CONTAINMENT_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__CONTAINER:
				return isContainer() != CONTAINER_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__RESOLVE_PROXIES:
				return ((eFlags & RESOLVE_PROXIES_EFLAG) != 0) != RESOLVE_PROXIES_EDEFAULT;
			case UmlPackage.ASSOCIATION_END__EOPPOSITE:
				return eOpposite != null;
			case UmlPackage.ASSOCIATION_END__EREFERENCE_TYPE:
				return basicGetEReferenceType() != null;
			case UmlPackage.ASSOCIATION_END__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //AssociationEndImpl
